import json
import shutil
import logging
import warnings
import subprocess
import csv
import re
import os
import time
import tqdm
from bs4 import BeautifulSoup


original_cwd = os.getcwd()
warnings.filterwarnings('ignore', category=UserWarning, module='bs4')
repos_dir = 'repos'
repo_names = os.listdir(repos_dir)
# repo_names = ['Zappos_zappos-json']
logging.basicConfig(level=logging.INFO, filename='logs/jacoco.log', filemode='w',
                    format='%(name)s - %(levelname)s - %(message)s')

def load_jsonl(fpath):
    with open(fpath, 'r') as file:
        lines = file.readlines()
        return [json.loads(line) for line in lines]
        

def add_extend_to_code_block(code, tab_num=1):
    lines_with_tabs = [' ' * 4 * tab_num + line for line in code.split('\n')]
    return '\n'.join(lines_with_tabs)

def write_file(fpath, context):
    with open(fpath, 'w') as f:
        f.write(context)

def mvn_clean_test(path):
    os.chdir(path)
    max_retries = 5
    attempt = 0
    
    while attempt < max_retries:
        try:
            # 尝试运行 mvn clean test 命令
            completed_process = subprocess.run(['mvn', 'clean', 'test', '-e'], check=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
            
            # 如果成功，则记录标准输出并退出循环
            logging.error(completed_process.stdout.decode())
            break
        except subprocess.CalledProcessError as e:
            # 如果失败，则记录错误信息并增加尝试次数
            # logging.error(f"Attempt {attempt + 1} of {max_retries} failed.")
            # logging.error(e.stderr.decode())
            attempt += 1
            
            # 等待一段时间后重试
            time.sleep(5)  # 等待5秒
    
    # 恢复原始工作目录
    os.chdir(original_cwd)

    if attempt == max_retries:
        # logging.info("Max retries reached. Skipping this project.")
        return False
    return True

def jacoco_str2int(s):
    s = s.replace(',', '')
    return int(s.strip())

def extract_jacoco_coverage_info(repo_dir):
    # 从jacoco-report的html文件中提取覆盖率数据
    report_fpath = os.path.join(repo_dir, 'target/jacoco-report/index.html')
    with open(report_fpath, 'r') as file:
        html_content = file.read()
    soup = BeautifulSoup(html_content, 'lxml')
    table = soup.find('table', class_='coverage')
    foot_row = table.find('tfoot').find_all('tr')
    branches = foot_row[0].find_all('td')[3].text.strip().split('of')
    missed_branches, total_branches = jacoco_str2int(branches[0]), jacoco_str2int(branches[1])
    missed_lines = jacoco_str2int(foot_row[0].find_all('td')[7].text.strip())
    total_lines = jacoco_str2int(foot_row[0].find_all('td')[8].text.strip())
    return missed_branches, total_branches, missed_lines, total_lines

def save_result(file_path, results):
    with open(file_path, mode='w', newline='', encoding='utf-8') as file:
        writer = csv.writer(file)
        # 写入多行数据
        writer.writerows(results)

def read_csv(fpath):
    with open(fpath, mode='r', encoding='utf-8') as file:
        csv_reader = csv.reader(file)
        return [data for data in csv_reader]


def run_single():
    output_dir = 'coverage_result/single'
    for repo_name in repo_names:
        if '.' in repo_name: continue

        # TODO:测试
        # if repo_name != 'sachin-handiekar_jInstagram': continue
        single_method_result = [
        ['repo', 'focal_method', 'test_method', 'missed_branches', 'total_branches', 'missed_lines', 'total_lines', 'branch_coverage', 'line_coverage']
        ]
        output_path = os.path.join(output_dir, f'{repo_name}_single.csv')

        if not os.path.exists(output_path):
            save_result(output_path, single_method_result)
        single_method_result = read_csv(output_path)
        # 重新运行时，以往的数据不再重复执行
        history_sets = {f"""{data[1]}-{data[2]}""" for data in single_method_result}

        # 错误数据也不再重新计算
        errors = read_csv('error.csv')
        for error in errors:
            err_mn = error[1].strip().strip('\'')
            history_sets.add(f'{error[0].strip()}-{err_mn}')


        repo_json_path = os.path.join('json', repo_name + '.json')
        repo_result_json_path = os.path.join('json', repo_name + '_final_result.json')


        repo_datas = json.load(open(repo_json_path, 'r'))
        result_datas = json.load(open(repo_result_json_path, 'r'))

        for result_data in tqdm.tqdm(result_datas):
            if result_data['Test_result'] != 1: continue
            # e.g. signRequest(Token accessToken, OAuthRequest request)
            method_statement = result_data['generated_path'].split('#')[1].split('.java')[0]

            focal_method_data = None

            # 根据method_statement找到focal method，并取出对应的所有数据
            for data in repo_datas:
                if 'Method_statement' not in data['Under_test_method'].keys():
                    continue
                if data['Under_test_method']['Method_statement'] == method_statement:
                    focal_method_data = data
                    break
            
            all_test_2_focal_list = focal_method_data['Test_method']['AllTest2Focal'].strip('[]').split(', ')
            # focal_method e.g. match###2
            focal_method_with_pn = focal_method_data['Under_test_method']['Method_name'] + '###' + focal_method_data['Under_test_method']['Parameter_num']
            # 存放该focal method的所有test method
            # {test1, test3, ...}
            test_methods_set = set()
            # 找到所有test method
            for all_test_2_focal in all_test_2_focal_list:
                # all_test_2_focal e.g. DictionaryMatcher_ESTest.java###test0+++put###2
                if focal_method_with_pn in all_test_2_focal:
                    # add test0
                    test_methods_set.add(all_test_2_focal.split('###')[1].split('+++')[0])

            # 清除maven仓库中的测试文件夹
            repo_test_dir = os.path.join(repos_dir, repo_name, 'src/test')
            if os.path.exists(repo_test_dir):
                shutil.rmtree(repo_test_dir)

            # 准备scaffolding_code
            scaffolding_code = focal_method_data['Test_method']['scaffoldingCode']
            test_java_fpath = focal_method_data['Test_method']['TestInfo'].split(repo_name + '/')[1].split('###')[0]

            # 测试方法所在.java文件路径
            test_java_fpath = os.path.join(repos_dir, repo_name, test_java_fpath)
            # scaffolding文件路径
            scaffolding_java_fpath = test_java_fpath.replace('.java', '_scaffolding.java')
            
            # 确定scaffolding文件名与类名相同
            assert os.path.splitext(os.path.basename(scaffolding_java_fpath))[0] in scaffolding_code
            
            os.makedirs(os.path.dirname(scaffolding_java_fpath), exist_ok=True)
            write_file(scaffolding_java_fpath, scaffolding_code)

            test_methods = focal_method_data['Test_method']['AllTestMethod'].split('#####')
            test_code_shell = focal_method_data['Test_method']['TestCodeShell']

            for i, test_method in enumerate(test_methods):
                focal_method = focal_method_data['Under_test_method']['project_path'].split('Four_project/')[1]

                match = re.search(r'public void\s+(\w+)\(\)\s+throws Throwable', test_method)
                # test0
                method_name = match.group(1)
                # 测试方法并不测试到现focal method，则跳过
                if method_name not in test_methods_set: continue

                # 已计算过的不再重复执行
                if f'{focal_method}-{method_name}' in history_sets:
                    continue
                
                test_method_code = test_code_shell.replace('//TOFILLL', add_extend_to_code_block(test_method)) \
                                                .replace('separateClassLoader = true', 'separateClassLoader = false')

                # 得到测试文件
                write_file(test_java_fpath, test_method_code)

                # 执行测试指令
                if not mvn_clean_test(os.path.join(repos_dir, repo_name)):
                    with open('error.csv', 'a+') as f:
                        f.write(f"{focal_method}, '{method_name}'\n")
                    continue

                # 收集jacoco结果
                results = extract_jacoco_coverage_info(os.path.join(repos_dir, repo_name))
                
                single_method_result.append([repo_name, focal_method, method_name,
                                            results[0], results[1], results[2], results[3],
                                            (results[1] - results[0]) / results[1],
                                            (results[3] - results[2]) / results[3]])
                
                save_result(output_path, single_method_result)



def run_combine():
    output_dir = 'coverage_result/combine'

    for repo_name in repo_names:
        total = 0
        if '.' in repo_name: continue

        multi_method_result = [
        ['repo', 'focal_method', 'method_num', 'missed_branches', 'total_branches', 'missed_lines', 'total_lines', 'branch_coverage', 'line_coverage']
        ]
        output_path = os.path.join(output_dir, f'{repo_name}_combine.csv')

        if not os.path.exists(output_path):
            save_result(output_path, multi_method_result)
        multi_method_result = read_csv(output_path)
        # 重新运行时，以往的数据不再重复执行
        history_sets = {data[1] for data in multi_method_result}


        errors = read_csv('error.csv')
        for error in errors:
            err_mn = error[1].strip().strip('\'')
            history_sets.add(f'{error[0].strip()}-{err_mn}')


        repo_json_path = os.path.join('json', repo_name + '.json')
        repo_result_json_path = os.path.join('json', repo_name + '_final_result.json')


        repo_datas = json.load(open(repo_json_path, 'r'))
        result_datas = json.load(open(repo_result_json_path, 'r'))

        for result_data in tqdm.tqdm(result_datas):
            if result_data['Test_result'] != 1: continue
            # e.g. signRequest(Token accessToken, OAuthRequest request)
            method_statement = result_data['generated_path'].split('#')[1].split('.java')[0]

            focal_method_data = None

            # 根据method_statement找到focal method，并取出对应的所有数据
            for data in repo_datas:
                if 'Method_statement' not in data['Under_test_method'].keys():
                    continue
                if data['Under_test_method']['Method_statement'] == method_statement:
                    focal_method_data = data
                    break
            
            all_test_2_focal_list = focal_method_data['Test_method']['AllTest2Focal'].strip('[]').split(', ')
            # focal_method e.g. match###2
            focal_method_with_pn = focal_method_data['Under_test_method']['Method_name'] + '###' + focal_method_data['Under_test_method']['Parameter_num']
            # 存放该focal method的所有test method
            # {test1, test3, ...}
            test_methods_set = set()
            # 找到所有test method
            for all_test_2_focal in all_test_2_focal_list:
                # all_test_2_focal e.g. DictionaryMatcher_ESTest.java###test0+++put###2
                if focal_method_with_pn in all_test_2_focal:
                    # add test0
                    test_methods_set.add(all_test_2_focal.split('###')[1].split('+++')[0])

            # # 清除maven仓库中的测试文件夹
            # repo_test_dir = os.path.join(repos_dir, repo_name, 'src/test')
            # if os.path.exists(repo_test_dir):
            #     shutil.rmtree(repo_test_dir)

            # # 准备scaffolding_code
            # scaffolding_code = focal_method_data['Test_method']['scaffoldingCode']
            # test_java_fpath = focal_method_data['Test_method']['TestInfo'].split(repo_name + '/')[1].split('###')[0]

            # # 测试方法所在.java文件路径
            # test_java_fpath = os.path.join(repos_dir, repo_name, test_java_fpath)
            # # scaffolding文件路径
            # scaffolding_java_fpath = test_java_fpath.replace('.java', '_scaffolding.java')
            
            # # 确定scaffolding文件名与类名相同
            # assert os.path.splitext(os.path.basename(scaffolding_java_fpath))[0] in scaffolding_code
            
            # os.makedirs(os.path.dirname(scaffolding_java_fpath), exist_ok=True)
            # write_file(scaffolding_java_fpath, scaffolding_code)

            test_methods = focal_method_data['Test_method']['AllTestMethod'].split('#####')
            test_code_shell = focal_method_data['Test_method']['TestCodeShell']

            class_body = ''
            test_method_num = 0
            for i, test_method in enumerate(test_methods):
                focal_method = focal_method_data['Under_test_method']['project_path'].split('Four_project/')[1]

                match = re.search(r'public void\s+(\w+)\(\)\s+throws Throwable', test_method)
                # test0
                method_name = match.group(1)
                if method_name not in test_methods_set: continue

                if focal_method in history_sets:
                    continue
                
                class_body += ('\n\n' + add_extend_to_code_block(test_method))
                test_method_num += 1

            total += test_method_num
            # test_method_code = test_code_shell.replace('//TOFILLL', class_body) \
            #                                 .replace('separateClassLoader = true', 'separateClassLoader = false')
                

            # # 得到测试文件
            # write_file(test_java_fpath, test_method_code)

            # # 执行测试指令
            # if not mvn_clean_test(os.path.join(repos_dir, repo_name)):
            #     # with open('error.csv', 'a+') as f:
            #     #     f.write(f"{focal_method}, '{method_name}'\n")
            #     continue

            # # 收集jacoco结果
            # results = extract_jacoco_coverage_info(os.path.join(repos_dir, repo_name))
            
            multi_method_result.append([repo_name, focal_method, test_method_num])
                                        # results[0], results[1], results[2], results[3],
                                        # (results[1] - results[0]) / results[1],
                                        # (results[3] - results[2]) / results[3]])
            
            
            save_result(output_path, multi_method_result)
    print(f'{repo_name}: {total}')

def mvn_and_print():
    for repo_name in repo_names:

        if repo_name.startswith('.'):
            continue

        # 执行测试指令
        # mvn_clean_test(os.path.join(repos_dir, repo_name))

        # 收集jacoco结果
        results = extract_jacoco_coverage_info(os.path.join(repos_dir, repo_name))
        print(f'{repo_name}: \
              \n\tmissed branches: {results[0]} \
              \n\tmissed lines: {results[2]} \
              \n\tbranch coverage: {(results[1] - results[0]) / results[1]}\
              \n\tline coverage: {(results[3] - results[2]) / results[3]}')


def generate_test_folder():
    csv_dir = 'coverage_result/single'
    # final_result_dir = 'final_result'
    final_result_dir = 'repos'
    for repo_name in repo_names:

        if repo_name.startswith('.'):
            continue
        os.makedirs(os.path.join(final_result_dir, repo_name), exist_ok=True)
        best_dict = {}
        if '.' in repo_name: continue
        datas = read_csv(os.path.join(csv_dir, f'{repo_name}_single.csv'))

        repo_test_dir = os.path.join(final_result_dir, repo_name, 'src/test')
        if os.path.exists(repo_test_dir):
            shutil.rmtree(repo_test_dir)

        for i, data in enumerate(datas):
            # 标题不要
            if i == 0: continue

            if data[1] not in best_dict.keys():
                best_dict[data[1]] = {
                    "method_name": data[2],
                    "coverage": data[8]
                }
            elif data[8] > best_dict[data[1]]['coverage']:
                best_dict[data[1]] = {
                    "method_name": data[2],
                    "coverage": data[8]
                }
        test_infos = json.load(open(os.path.join('json', f'{repo_name}.json'), 'r'))
        
        
        for focal_method, meta in best_dict.items():
            for info in test_infos:
                if len(info['Under_test_method']) != 0 and info['Under_test_method']['project_path'].split('Four_project/')[1] == focal_method:
                    test_methods = info['Test_method']['AllTestMethod'].split('#####')
                    for test_method in test_methods:
                        match = re.search(r'public void\s+(\w+)\(\)\s+throws Throwable', test_method)
                        # test0
                        method_name = match.group(1)
                        if method_name == meta['method_name']:
                            meta["method_body"] = test_method
                            break
                    break
        
        classify_dict = {}
        for focal_method, meta in best_dict.items():
            java_filename = focal_method.split('###')[0]
            if java_filename not in classify_dict.keys():
                classify_dict[java_filename] = {
                    "code": meta['method_body'],
                    "method_names": {meta['method_name']},
                    "focal_method": focal_method
                }                    
            elif meta['method_name'] not in classify_dict[java_filename]['method_names']:
                classify_dict[java_filename]['code'] += ('\n\n' + meta['method_body'])
                classify_dict[java_filename]['method_names'].add(meta['method_name'])
        

        for _, value in classify_dict.items():
            for info in test_infos:
                if len(info['Under_test_method']) != 0 and info['Under_test_method']['project_path'].split('Four_project/')[1] != value['focal_method']:
                    continue
                # 准备scaffolding_code
                scaffolding_code = info['Test_method']['scaffoldingCode']
                test_java_fpath = info['Test_method']['TestInfo'].split(repo_name + '/')[1].split('###')[0]

                # 测试方法所在.java文件路径
                test_java_fpath = os.path.join(final_result_dir, repo_name, test_java_fpath)
                # scaffolding文件路径
                scaffolding_java_fpath = test_java_fpath.replace('.java', '_scaffolding.java')
                
                # 确定scaffolding文件名与类名相同
                assert os.path.splitext(os.path.basename(scaffolding_java_fpath))[0] in scaffolding_code
                
                os.makedirs(os.path.dirname(scaffolding_java_fpath), exist_ok=True)
                write_file(scaffolding_java_fpath, scaffolding_code)
                test_code_shell = info['Test_method']['TestCodeShell']
                test_method_code = test_code_shell.replace('//TOFILLL', add_extend_to_code_block(value['code'])) \
                                            .replace('separateClassLoader = true', 'separateClassLoader = false')

                os.makedirs(os.path.dirname(test_java_fpath), exist_ok=True)
                write_file(test_java_fpath, test_method_code)
        
        # 执行测试指令
        mvn_clean_test(os.path.join(repos_dir, repo_name))

        # 收集jacoco结果
        results = extract_jacoco_coverage_info(os.path.join(repos_dir, repo_name))
        print(f'{repo_name}: \
              \n\tmissed branches: {results[0]} \
              \n\tmissed lines: {results[2]} \
              \n\tbranch coverage: {(results[1] - results[0]) / results[1]}\
              \n\tline coverage: {(results[3] - results[2]) / results[3]}')



def move_and_test(dir = 'ProjectResult/ChatTester'):
    '''
    将已经完成的test文件夹移动至相应的repo下

    move与test分两个for写为了防止test报错而让move出错

    '''
    # move
    # for repo_name in repo_names:
    #     if '.' in repo_name: continue
    #     repo_test_dir = os.path.join(repos_dir, repo_name, 'src/test')
    #     if os.path.exists(repo_test_dir):
    #         shutil.rmtree(repo_test_dir)
    #
    #     shutil.copytree(os.path.join(dir, repo_name, 'src/test'), repo_test_dir)

    # test
    for repo_name in repo_names:
        if '.' in repo_name: continue
        mvn_clean_test(os.path.join(repos_dir, repo_name))
        results = extract_jacoco_coverage_info(os.path.join(repos_dir, repo_name))
        print(f'{repo_name}: \
                \n\tmissed branches: {results[0]} \
                \n\tmissed lines: {results[2]} \
                \n\tbranch coverage: {(results[1] - results[0]) / results[1]}\
                \n\tline coverage: {(results[3] - results[2]) / results[3]}')

def move_test_dir_back(dir = 'ProjectResult/ChatTester'):
    '''
    将repos中的test移回ProjectResult中去
    '''
    for repo_name in repo_names:
        if '.' in repo_name: continue
        # src
        repo_test_dir = os.path.join(repos_dir, repo_name, 'src/test')
        dst_dir = os.path.join(dir, repo_name, 'src/test')


        if os.path.exists(dst_dir):
            shutil.rmtree(dst_dir)
        
        shutil.copytree(repo_test_dir, dst_dir)
        # mvn_clean_test(os.path.join(repos_dir, repo_name))

    
def merge_athenatest_output_2_test_dir():
    athenatest_dir = 'json/athenatest_all'
    final_result_dir = 'ProjectResult/AthenaTest_all'
    for repo_name in repo_names:
        if '.' in repo_name: continue
        test_infos = json.load(open(os.path.join('json', f'{repo_name}.json'), 'r'))
        datas = load_jsonl(os.path.join(athenatest_dir, f'{repo_name}_output.jsonl'))
        classify_dict = {}
        for data in datas:
            # data -> ['model_output': , 'focal_method': ,]
            if data['test_result'] != 1: continue
            focal_method = data['focal_method'][0]
            test_method = data['model_output']

            test_method = ';\n'.join(test_method.split('; '))
            test_method = '{ \n'.join(test_method.split('{ '))
            test_method = '@Test \n'.join(test_method.split('@Test '))


            java_filename = focal_method.split('###')[0]
            if java_filename not in classify_dict.keys():
                classify_dict[java_filename] = {
                    "code": test_method,
                    "focal_method": focal_method
                }                    
            else:
                classify_dict[java_filename]['code'] += ('\n\n' + test_method)
        
        for java_filename, value in classify_dict.items():
            for info in test_infos:
                if len(info['Under_test_method']) != 0 and info['Under_test_method']['project_path'].split('###')[0] != java_filename:
                    continue
                # 准备scaffolding_code
                scaffolding_code = info['Test_method']['scaffoldingCode']
                test_java_fpath = info['Test_method']['TestInfo'].split(repo_name + '/')[1].split('###')[0]

                # 测试方法所在.java文件路径
                test_java_fpath = os.path.join(final_result_dir, repo_name, test_java_fpath)
                # scaffolding文件路径
                scaffolding_java_fpath = test_java_fpath.replace('.java', '_scaffolding.java')
                
                # 确定scaffolding文件名与类名相同
                assert os.path.splitext(os.path.basename(scaffolding_java_fpath))[0] in scaffolding_code
                
                os.makedirs(os.path.dirname(scaffolding_java_fpath), exist_ok=True)
                write_file(scaffolding_java_fpath, scaffolding_code)
                test_code_shell = info['Test_method']['TestCodeShell']
                test_method_code = test_code_shell.replace('//TOFILLL', add_extend_to_code_block(value['code'])) \
                                            .replace('separateClassLoader = true', 'separateClassLoader = false')

                os.makedirs(os.path.dirname(test_java_fpath), exist_ok=True)
                write_file(test_java_fpath, test_method_code)

def move_jacoco_report(report_dir):
    for repo_name in repo_names:
        if '.' in repo_name: continue

        os.makedirs(os.path.join(repos_dir, repo_name), exist_ok=True)
        target_dir = os.path.join(repos_dir, repo_name, 'target')
        dst_dir = os.path.join(report_dir, repo_name, 'target')
        # 如果存在则删除
        if os.path.exists(dst_dir):
            shutil.rmtree(dst_dir)
        
        shutil.copytree(target_dir, dst_dir)



if __name__ == '__main__':
    # run_combine()
    # generate_test_folder()


    move_and_test('ProjectResult/Evosuite_first')


    # 人工纠正好一些错误之后，放回ProjectResult中
    # move_test_dir_back('ProjectResult/AthenaTest_all')


    # mvn_and_print()
    # merge_athenatest_output_2_test_dir()
    # move_jacoco_report('jacoco_report/ChatGPT')


    
