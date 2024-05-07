import json
import os
import glob
import shutil
current_dir = os.path.dirname(os.path.abspath(__file__))
chatTesterDir = os.path.dirname(current_dir)

# 如果文件夹存在先清空文件夹，再创一个。
def boolean(file_path):
    if not os.path.exists(file_path):
        print('Creat floder....')
        os.makedirs(file_path)

# 根据 chatTester_result 从 evosuite 生成的test method 当中得到一个用于计算coverage
def evosuite_first(project_name):
    ResultPath = os.path.join(chatTesterDir, 'RepoData')
    path = os.path.join(ResultPath, project_name+".json")

    with open(path, 'r', encoding='utf-8') as f:
        file_cont = json.load(f)
    # project_name = os.path.basename(path).replace(".json","")

    for cont in file_cont:
        if len(cont['Under_test_method']) == 0: continue
        # if cont['Test_method']['TestInfo'] not in ChatTester_result: continue

        UnderTest = cont['Under_test_method']
        Method_name = UnderTest['Method_name']
        Parameter_num = UnderTest['Parameter_num']
        sub_file_Name = "#" + Method_name + "_" + Parameter_num + ".java"


        Test_method = cont['Test_method']
        TestPath = Test_method['TestInfo'].split("###")[0].split(project_name+'/')[1]

        # 文件路径
        TestDir = os.path.dirname(TestPath)
        TestFileName = os.path.basename(TestPath).replace(".java",sub_file_Name)
        ori_class_name = os.path.basename(TestPath).replace(".java","")

        # 写入文件中的代码
        Est_code = Test_method['TestCodeShell'].replace(ori_class_name, TestFileName.replace(".java",""), 1).replace("//TOFILLL",Test_method['TestMethodBody'])
        full_TestDir = os.path.join(current_dir, "ProjectResult","Evosuite_first",project_name,TestDir)
        boolean(full_TestDir)
        EST_full_file_path = os.path.join(full_TestDir, TestFileName)
        with open(EST_full_file_path, 'w', encoding='utf-8') as f:
            f.write(Est_code)

        # 将 scaffoldingCode 也写入当前的文件
        scaffoldFileName = os.path.basename(TestPath).replace("_ESTest.java","_ESTest_scaffolding.java")
        sca_full_file_path = os.path.join(full_TestDir, scaffoldFileName)
        with open(sca_full_file_path, 'w', encoding='utf-8') as f:
            f.write(Test_method['scaffoldingCode'])

def chatTester(project_name, resultDIR="IterateResultDeal"):
    repo_get_path = os.path.join(chatTesterDir, 'Repos')
    IteratePath = os.path.join(chatTesterDir, 'ExperimentCode', resultDIR)


    Evosuite_testPath = os.path.join(repo_get_path, project_name+"_evosuite-tests")
    final_path = os.path.join(IteratePath, project_name, 'final_result.json')

    # project_name = os.path.basename(Evosuite_testPath).replace("_evosuite-tests","")
    with open(final_path,'r', encoding='utf-8') as f:
        final_cont = json.load(f)

    ChatTester_result = []

    for cont in final_cont:
        Test_result = cont["Test_result"]
        if Test_result != 1: continue

        ChatTester_result.append(cont['original_path'])

        generated_path = cont['generated_path']
        with open(generated_path, 'r', encoding='utf-8') as f:
            gen_cont = f.read()
        Method_name = os.path.basename(generated_path).split("#")[1].split("(")[0]
        Parameter_num = len(os.path.basename(generated_path).split("#")[1].split(","))
        sub_file_Name = "#" + Method_name + "_" + str(Parameter_num) + ".java"

        original_path = cont['original_path']
        TestPath = original_path.split("###")[0].split(project_name+'/')[1]
        TestDir = os.path.dirname(TestPath)
        TestFileName = os.path.basename(TestPath).replace(".java",sub_file_Name)
        ori_class_name = os.path.basename(TestPath).replace(".java","")

        # 写入文件中的代码
        Est_code = gen_cont.replace(" "+ori_class_name, " "+TestFileName.replace(".java",""), 1)
        full_TestDir = os.path.join(current_dir,"ProjectResult", "ChatTester", project_name, TestDir)
        boolean(full_TestDir)
        EST_full_file_path = os.path.join(full_TestDir, TestFileName)
        with open(EST_full_file_path, 'w', encoding='utf-8') as f:
            f.write(Est_code)

        # 将 scaffoldingCode 也写入当前的文件
        scaffoldFileName = os.path.basename(TestPath).replace("_ESTest.java","_ESTest_scaffolding.java")
        scaffoldfile_path = next((path for path in glob.glob(os.path.join(Evosuite_testPath, '**', scaffoldFileName), recursive=True)), None)
        shutil.copy(scaffoldfile_path,full_TestDir)

    return ChatTester_result



def chatGPT(project_name):
    repo_get_path = os.path.join(chatTesterDir, 'Repos')
    IteratePath = os.path.join(chatTesterDir, 'ExperimentCode', "No_intention")


    Evosuite_testPath = os.path.join(repo_get_path, project_name+"_evosuite-tests")
    final_path = os.path.join(IteratePath, project_name, 'result_1.json')

    # project_name = os.path.basename(Evosuite_testPath).replace("_evosuite-tests","")
    with open(final_path,'r', encoding='utf-8') as f:
        final_cont = json.load(f)

    ChatTester_result = []

    for cont in final_cont:
        Test_result = cont["Test"]
        if Test_result != 1: continue

        ChatTester_result.append(cont['original_path'])

        generated_path = cont['generated_path']
        with open(generated_path, 'r', encoding='utf-8') as f:
            gen_cont = f.read()
        Method_name = os.path.basename(generated_path).split("#")[1].split("(")[0]
        Parameter_num = len(os.path.basename(generated_path).split("#")[1].split(","))
        sub_file_Name = "#" + Method_name + "_" + str(Parameter_num) + ".java"

        original_path = cont['original_path']
        TestPath = original_path.split("###")[0].split(project_name+'/')[1]
        TestDir = os.path.dirname(TestPath)
        TestFileName = os.path.basename(TestPath).replace(".java",sub_file_Name)
        ori_class_name = os.path.basename(TestPath).replace(".java","")

        # 写入文件中的代码
        Est_code = gen_cont.replace(" "+ori_class_name, " "+TestFileName.replace(".java",""), 1)
        full_TestDir = os.path.join(current_dir,"ProjectResult", "ChatGPT",project_name,TestDir)
        boolean(full_TestDir)
        EST_full_file_path = os.path.join(full_TestDir, TestFileName)
        with open(EST_full_file_path, 'w', encoding='utf-8') as f:
            f.write(Est_code)

        # 将 scaffoldingCode 也写入当前的文件
        scaffoldFileName = os.path.basename(TestPath).replace("_ESTest.java","_ESTest_scaffolding.java")
        scaffoldfile_path = next((path for path in glob.glob(os.path.join(Evosuite_testPath, '**', scaffoldFileName), recursive=True)), None)
        shutil.copy(scaffoldfile_path,full_TestDir)

    # return ChatTester_result
if __name__ == "__main__":
    projects_name = ['sachin-handiekar_jInstagram', 'tabulapdf_tabula-java',
                     'Zappos_zappos-json']

    for project_name in projects_name:
        # evosuite("")
        # chatGPT(project_name)  # 将 no_intention 的结果处理一下

        ChatTester_result = chatTester(project_name)

        # evosuite_same_union(ChatTester_result, project_name)
        # evosuite_first(project_name)

