# -*- coding: utf-8 -*-
import sys
import json
import re
import  os
import xml.etree.ElementTree as ET
import subprocess
import os
from tqdm import tqdm
current_dir = os.path.dirname(__file__) #./PipLine/Deal
Experiment_PATH = os.path.dirname(current_dir) # ./InitialPharse_Experiment


Promt2Testing_PATH = os.path.abspath(os.path.join(current_dir, os.pardir, os.pardir, os.pardir, os.pardir))
PipLine_PATH = os.path.join(Promt2Testing_PATH, "chatGPT_experiment_for_javaProject",'PipLine')




# used to deal compile and test information
class CompileInfo:
    def __init__(self, Log_PATH, model_name, gen_test_PATH):
        RepairProcess_PATH = os.path.join(Experiment_PATH, "Iterate", model_name,'RepairProcess')
        self.Log_PATH = Log_PATH
        # self.TestMethodExample = TestMethodExample
        log_fileName = os.path.basename(self.Log_PATH).replace(".java", "_compile.text")
        self.gen_test_PATH = gen_test_PATH
        self.Compile_PATH = os.path.join(RepairProcess_PATH, log_fileName)  # 处理过后的编译信息

        # key words used to locate information in Compile_INFO_List
        self.ERROR_LINE_START_TOKEN = "[ERROR]"
        self.INFO_LINE_START_TOKEN = "[INFO]"
        self.GENERATED_PATH_LINE_START_TOKEN = "[GENERATED PATH]"
        self.ORIGINAL_TEST_PATH_LINE_START_TOKEN = "original test path:"
        self.SPILT_CHAR =  "####################"
        # self.Test_Impor_INFO = Test_Impor_INFO

    # 输入：./PipLine/LogInfo/
    # 输出： ./INFO_compile.txt
    def Compile_INFO(self):
        with open(self.Log_PATH, 'r', encoding='utf-8') as f:
            file_cont = f.read()
        file_cont_list = file_cont.split("########## Test INFO ##########")
        if "[ERROR] COMPILATION ERROR :" not in file_cont_list[0]:
            pass
        else:
            lines = []
            # 用于标记是否需要继续添加行
            add_to_list = False
            # 用于查找数字的正则表达式
            regex = re.compile(r'\d+')

            # 正确的报告了编译错误。现在需要对这些编译错误进行处理
            with open(self.Log_PATH, 'r', encoding='utf-8') as file:
                # 逐行读取文件内容
                for line in file:
                    if "original test path: " in line:
                        original_PATH = line
                    if '[ERROR] COMPILATION ERROR :' in line:
                        # 标记需要添加行
                        lines.append(line)
                        add_to_list = True

                    # [INFO] 4 errors
                    elif '[INFO]' in line and regex.search(line) and " error" in line:
                        # 不再往下读取，退出循环
                        lines.append(line)
                        break

                    # 判断是否需要继续添加行
                    elif add_to_list:
                        # 添加到列表中
                        lines.append(line)
            no_blank_s = [l for l in lines if l != ""]
            generated_PATH = "[GENERATED PATH] " + os.path.basename(self.Log_PATH)
            write_cont = original_PATH + generated_PATH + "\n" + "".join(no_blank_s) + "####################\n\n"
            with open(self.Compile_PATH, 'a', encoding='utf-8') as f:
                f.write(write_cont)

    def divFileIntoBlocks(self):
        with open(self.Compile_PATH, 'r', encoding='utf-8') as f:
            file_cont = f.read()
        split_block = file_cont.split("####################\n\n")[-2]  # 取最后一个报错信息
        errorInfoBlock = [b for b in split_block.split("\n") if b!='']

        return errorInfoBlock

    def CompileInfo_Deal(self, errorInfoBlock):
        ERROR_list = []

        # "Error_INFO":报错的信息行, "Error_Line":从报错信息行中抽取出来的行号, "ERROR_Type":从报错信息行中抽取出来的报错信息,"Location":报错处于哪个位置,"TEST_PATH":测试用例的原本路径, Gene_PATH:生成测试用例的路径
        errorInfo_dict = {}

        TEST_PATH = ""
        Gene_PATH = ""
        singleErrorInfo = []
        PATH = "Prompt2Testing"
        added_line = []
        for line_i in range(len(errorInfoBlock)):
            if line_i in added_line: continue
            if PATH in errorInfoBlock[line_i] and "[GENERATED PATH]" not in errorInfoBlock[line_i] and 'original test path:' not in errorInfoBlock[line_i]:   # 包含路径和报错信息的那行
                # 依次向下遍历拿到信息
                while line_i < len(errorInfoBlock)-1:
                    singleErrorInfo.append(errorInfoBlock[line_i].replace("D:",""))
                    added_line.append(line_i)
                    line_i = line_i + 1
                    if line_i>=len(errorInfoBlock)-1 or PATH in errorInfoBlock[line_i]:
                        errorInfo_dict = self.changeSingleErrorInfoToDict(singleErrorInfo)
                        if os.path.basename(TEST_PATH) in errorInfo_dict["Error_INFO"]:
                            errorInfo_dict["Gene_PATH"] = Gene_PATH
                            errorInfo_dict["TEST_PATH"] = TEST_PATH
                            ERROR_list.append(errorInfo_dict)
                            singleErrorInfo = [] # 置空，为下一次遍历做准备
                        break
            elif errorInfoBlock[line_i].startswith('[GENERATED PATH]'):
                Gene_PATH = errorInfoBlock[line_i].split("PATH]")[1].strip()

            elif errorInfoBlock[line_i].startswith('original test path:'):
                TEST_PATH = errorInfoBlock[line_i].split("path:")[1].strip()

            else:continue
        return ERROR_list


    # 对ERROR_List 进行二次处理
    def Call_errorDeal(self):
        #先将LogINFO中的信息转换到 RepairPrcess/xxx_comple.txt文本中
        self.Compile_INFO()

        # "Error_INFO":str, "Error_Line":str, "ERROR_Type":str,"Location":str,"TEST_PATH":str, Gene_PATH:str
        errorInfoBlock = self.divFileIntoBlocks()
        # i = 0
        # for errorInfoBlock in tqdm(errorInfoBlocks):
        #     print("i: ", i)
        Error_list = self.CompileInfo_Deal(errorInfoBlock)
        Out_list = []
        for error in Error_list:
            Out_dict = {"ERROR_MESSAGE": str, "Class_Name": str, "ERROR_LINE": str}

            # 情况1、cannot find symbol method。Error_message: Cannot find symbol method [METHOD_NAME] in [Class Name]. 注意 class name 记得做筛选
            # class name 用于在项目中检索得这个class的详细信息
            if "Error_Symbol" in error and "Location" in error and "method " in error["Error_Symbol"]:
                className = error['Location'].split(" ")[-1].split(".")[-1]
                simpleName = className.split(".")[-1]
                if simpleName == os.path.basename(error['TEST_PATH']): Out_dict['Class_Name'] = ""
                else: Out_dict['Class_Name'] = simpleName

                Method_name = error['Error_Symbol'].replace("method","").strip()
                Out_dict["ERROR_MESSAGE"] = "cannot find symbol method " + "\""+Method_name +"\""+ " in " + simpleName
                Out_dict['ERROR_LINE'] = error['ERROR_LINE']

            # 情况2、$$ in class $$ cannot be applied to given type。 Error_message: [Method/constructor] in class [Class Name] cannot be given applied to given types
            # Error_message 直接为Error_Type. 要通过in class $$ 当中的信息将class name 抽取出来用于检索
            elif "cannot be applied to given type" in error['Error_INFO']:
                pattern = r"\b(\w+)\b.*?\b(class)\b\s+(\w+(\.\w+)*)"
                match = re.search(pattern, error['Error_Type'])
                Method_name, className = match.group(1), match.group(3)
                Out_dict['ERROR_MESSAGE'] = error['Error_Type']
                Out_dict['ERROR_LINE'] = error['ERROR_LINE']

                simpleName = className.split(".")[-1]
                if simpleName == os.path.basename(error['TEST_PATH']): Out_dict['Class_Name'] = ""
                else: Out_dict['Class_Name'] = simpleName

            elif "no suitable method found for" in error['Error_INFO'] and "others" in error:
                match2 = re.search(r'\w+(?=\()', error['Error_INFO'])
                if match2:
                    method_name = match2.group()  # 得到error['Error_INFO'] 那行所涉及到的 method name
                    # 然后利用这个method name 去得到对应的class name
                    for other in error['others']:
                        split_tag = "."+method_name+"("
                        split_name = other.split(split_tag)
                        if len(split_name)>1:
                            Out_dict['ERROR_MESSAGE'] = error['Error_Type']
                            Out_dict['ERROR_LINE'] = error['ERROR_LINE']

                            simpleName = split_name[0].split(".")[-1]
                            if simpleName == os.path.basename(error['TEST_PATH']):
                                Out_dict['Class_Name'] = ""
                            else:
                                Out_dict['Class_Name'] = simpleName

            # 情况3、$$ has private access in $$. Error_Message 直接为Error_Type。
            # 通过 in $$ 中的信息，将class name 抽取出来用于检索。
            elif "has private access in" in error['Error_INFO']:
                className = error['Error_INFO'].split("has private access in")[-1].strip()
                Out_dict['ERROR_MESSAGE'] = error['Error_Type']
                Out_dict['ERROR_LINE'] = error['ERROR_LINE']
                simpleName = className.split(".")[-1]
                if simpleName == os.path.basename(error['TEST_PATH']):
                    Out_dict['Class_Name'] = ""
                else:
                    Out_dict['Class_Name'] = simpleName

            # 情况4、method does not override or implement [重写了某个类中不存在的方法]、
            # Error_message 直接为Error_Type. 但是要通过”行号“ 将对应的类检索出来。
            # 这个需要调用java程序完成
            elif "does not override or implement" in error['Error_INFO']:

                # windows指令使用 .;  Linux系统使用 .:
                JarPath = os.path.join(Promt2Testing_PATH, 'Java_Analyzer', 'src', 'main', 'jarPackage',
                                       'javaparser-core-3.24.7.jar')
                classpath = '.:' + JarPath
                arg1 = self.gen_test_PATH  #由chatGPT生成的 java file
                arg2 = error['ERROR_LINE']  # 错误的行号

                ExcuteJava = os.path.join(Promt2Testing_PATH, 'Java_Analyzer','src','main','java')
                os.chdir(ExcuteJava)
                result = subprocess.run(["java", '-cp', classpath, 'ExtractClassFromOverride', arg1, arg2], stdout=subprocess.PIPE, check=True)
                os.chdir(current_dir)

                Out_dict["ERROR_MESSAGE"] = error['Error_Type']
                Out_dict['ERROR_LINE'] = error['ERROR_LINE']

                simpleName = result.stdout.strip().decode('ascii')
                if simpleName == os.path.basename(error['TEST_PATH']):
                    Out_dict['Class_Name'] = ""
                else:
                    Out_dict['Class_Name'] = simpleName

            # 情况5、Cannot find symbol class/variable。Error_message: cannot find symbol [Class/Variable] [Class_Name/Variable_Name]
            elif "Error_Symbol" in error and "class " in error["Error_Symbol"]:
                className = error['Error_Symbol'].replace("class","").strip()
                Out_dict["ERROR_MESSAGE"] = "cannot find symbol class " + "\""+className+"\""
                Out_dict['ERROR_LINE'] = error['ERROR_LINE']
                Out_dict['Class_Name'] = ""

            elif "Error_Symbol" in error and "variable " in error["Error_Symbol"]:
                VariableName = error['Error_Symbol'].replace("variable","").strip()
                Out_dict["ERROR_MESSAGE"] = "cannot find symbol variable " + "\""+VariableName+"\""
                Out_dict['ERROR_LINE'] = error['ERROR_LINE']
                className = ""
                if "Location" in error: className = error['Location'].split(" ")[-1].split(".")[-1]
                if className == os.path.basename(error['TEST_PATH']):
                    Out_dict['Class_Name'] = ""
                else: Out_dict['Class_Name'] = className

            # 情况6、其它情况直接将error_type 作为 Error_message 返回。
            else:
                Out_dict['ERROR_MESSAGE'] = error['Error_Type']
                Out_dict['ERROR_LINE'] = error['ERROR_LINE']
                Out_dict['Class_Name'] = ""

            Out_list.append(Out_dict)

        return Out_list

    def changeSingleErrorInfoToDict(self, singleErrorInfo):
        # "Error_INFO":str, "Error_Line":str, "Error_Type":str, "Location":str, "Error_symbol":str
        singleErrorInfoDict = {}
        PATH = "Prompt2Testing"
        for errorInfoLine in singleErrorInfo:
            errorInfoLine = errorInfoLine.replace("D:",'')
            if PATH in errorInfoLine:
                errorInfoLine = errorInfoLine.replace(self.ERROR_LINE_START_TOKEN, "", 1).strip()
                singleErrorInfoDict['Error_INFO'] = errorInfoLine
            if ":" in errorInfoLine:
                # checked that if the line contains more than one colon, the first part must start with 'x.java'
                # except one BUILD FAILURE
                # if len(errorInfoLine.split(":")) > 2:
                #     print(errorInfoLine)
                leftToken = errorInfoLine.split(":")[0]
                rightInfo = errorInfoLine.split(":")[1].strip()
                if "symbol" in leftToken:
                    leftToken = "Error_Symbol"
                elif "location" in leftToken:
                    leftToken = "Location"
                if not leftToken.endswith('.java') and not len(leftToken) > 20:
                    if leftToken in singleErrorInfoDict:
                        if type(singleErrorInfoDict[leftToken]) == list:
                            singleErrorInfoDict[leftToken].append(rightInfo)
                        else:
                            singleErrorInfoDict[leftToken] = [
                                singleErrorInfoDict[leftToken], rightInfo]
                    else:
                        singleErrorInfoDict[leftToken] = rightInfo
            else:
                if not "others" in singleErrorInfoDict:
                    singleErrorInfoDict["others"] = []
                singleErrorInfoDict["others"].append(errorInfoLine)

            # spilt the line with space and colon
            spiltResult = re.split('[\s:]', errorInfoLine)
            for i in spiltResult:
                if i.endswith(".java"):
                    # singleErrorInfoDict["file_path"] = i
                    singleErrorInfoDict["file_name"] = i.split("/")[-1]

            # if the line contains the form like '[1,2]' then it is the wrong location
            # also the error type is the rest of the line
            # wrong location info only exists once in an error info block(as far as I know, if not, please modify the code)
            pattern = r"\[[0-9]+,[0-9]+\]"
            match = re.search(pattern, errorInfoLine)
            if match==None:
                pattern = r"\[(\d+)\]"
                match = re.search(pattern, errorInfoLine)
            if match:
                Error_raw_colum = match.group()
                singleErrorInfoDict["ERROR_LINE"] = Error_raw_colum.split(",")[0].replace("[","").replace("]","")  # obtain the accurate the code line
                errorTypeInfo = errorInfoLine.split(Error_raw_colum)[-1].strip()
                if errorTypeInfo.split(" ")[0] == "error:":
                    errorTypeInfo = errorTypeInfo.replace("error:", "", 1).strip()
                singleErrorInfoDict["Error_Type"] = errorTypeInfo
        return singleErrorInfoDict

class TestINFO:
    def __init__(self, XML_PATH, loginfo_file):
        self.XML_PATH = XML_PATH
        self.loginfo_file = loginfo_file

    def TetsINFO_deal(self):

        xml_file_path = self.XML_PATH
        # print("DEAL: ", os.path.basename(xml_file_path))


        # 读取xml文件
        tree = ET.parse(xml_file_path)
        root = tree.getroot()

        TEST_INFO_list = []
        # 遍历testcase元素
        for testcase in root.iter('testcase'):
            TEST_INFO_dict = {"FILE_NAME":os.path.basename(xml_file_path), "ERROR_MESSAGE":str, "ERROR_LINE":str}
            # 获取classname和name属性的值
            classname = testcase.get('classname')
            if classname == None: classname = os.path.basename(self.loginfo_file).split("_")[0]
            name = testcase.get('name')
            message = ""
            error_type = ""
            ERROR_LINE = ""

            # 获取failure元素
            error = testcase.find('error')
            failure = testcase.find('failure')
            rerunFailure = testcase.find("rerunFailure")
            tag_INFO = None
            if error is not None:
                tag_INFO = error
            elif failure is not None:
                tag_INFO = failure
            elif rerunFailure is not None:
                tag_INFO = rerunFailure

            if tag_INFO is not None:
                # 获取message和type属性的值
                message = tag_INFO.get('message')
                error_type = tag_INFO.get('type')

                # 查找包含classname内容的字符串
                stack_trace = tag_INFO.text
                if stack_trace is not None:
                    split_stack = stack_trace.split("\n")
                    error_line_info = [stack for stack in split_stack if classname in stack]
                    if len(error_line_info)<0: continue
                    ERROR_LINE = error_line_info[0].split(".java:")[-1].replace(")","")  # 准确的报错行号

            # 对于assert的报错信息，只给报错类型， i.e., java.lang.AssertionError, 不给报错的 expected...
            if ".Assert" in error_type:
                ERROR_MESSAGE = error_type
            else:
                ERROR_MESSAGE = error_type + " " + str(message)


            TEST_INFO_dict['ERROR_LINE'] = ERROR_LINE
            TEST_INFO_dict['ERROR_MESSAGE'] = ERROR_MESSAGE

            if len(ERROR_LINE) == 0: continue
            TEST_INFO_list.append(TEST_INFO_dict)

            # write_cont = "[FILE NAME]: " + os.path.basename(xml_file_path) + "\n" + \
            #              "[CLASS NAME]: " + classname + "\n" + \
            #              "[METHOD NAME]: " + name + "\n" + \
            #              "[ERROR MESSAGE]: " + str(message) + "\n" + \
            #              "[ERROR TYPE]: " + error_type + "\n" + \
            #              "[ERROR LINE]: " + " ".join(error_line).strip()

        return TEST_INFO_list

if __name__ == "__main__":
    
    # PATH = "D:\Python\Test_Completion\Promt2Testing\chatGPT_experiment\PipLine\LogINFO\TokenTest_testGenerate.java"
    # PP = CompileInfo(PATH, None)
    # errorInfoWrapperList = PP.Call_errorDeal()
    pass