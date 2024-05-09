# -*- coding: utf-8 -*-
import sys
import json
import re
import os
import xml.etree.ElementTree as ET
import subprocess
import os
import glob
from tqdm import tqdm
# import Compile_Test_INFO

current_dir = os.path.dirname(__file__)  # ./Deal
ChatTester_PATH = os.path.abspath(os.path.join(current_dir, os.pardir, os.pardir))

Involved_repo_PATH = os.path.join(ChatTester_PATH, "Repos")



# 用于得到包含错误信息，及class 信息的prompt
class CompilePrompt:
    def __init__(self, Error_INFO_dict, Gen_Java_File, Class_Java_Path, re_generate_Tag, Method_intention, Focal_Method, repo_name, findClassInfo):
        self.Error_INFO_dict = Error_INFO_dict
        self.Gen_Java_File = Gen_Java_File
        self.Class_Java_Path = Class_Java_Path
        self.repo_name = repo_name

        self.re_generate_Tag = re_generate_Tag
        self.Method_intention = Method_intention
        self.Focal_Method = Focal_Method
        self.findClassInfo = findClassInfo


    # 对 compile信息处理
    # Input: {"ERROR_MESSAGE": str, "Class_Name": str, "ERROR_LINE": str}
    def Compile_deal(self):
        ERROR_MESSAGE = self.Error_INFO_dict['ERROR_MESSAGE']
        Class_Name = self.Error_INFO_dict['Class_Name'].replace("_ESTest","")
        ERROR_LINE = self.Error_INFO_dict['ERROR_LINE']

        import_line = 0  # 获得最后一个import的行号
        # 得到了包含Buggy 的信息
        i = 0
        BuggyCode = []
        with open(self.Gen_Java_File, 'r', encoding='utf-8') as f:
            for line in f.readlines():
                i = i + 1
                if "import " in line: import_line = i
                if ERROR_LINE.isdigit() and int(ERROR_LINE) == i:  # 定位到报错行
                    numbe_of_cr = line.count(' ')-2
                    BugInfo = f"<Buggy Line>: {ERROR_MESSAGE}" + '\n'
                    BuggyCode.append("\n")
                    BuggyCode.append(' '*numbe_of_cr+BugInfo)
                    BuggyCode.append(line)
                    BuggyCode.append("\n")

                elif "// original test path:" not in line and "Test Method" not in line and 'Fixed Test Method' not in line:
                    BuggyCode.append(line)


        BuggyMethod = commentDelete(self.return_code(BuggyCode))

        if len(Class_Name) > 0:
            Class_Name_java = Class_Name + ".java"

            # 使用glob模块搜索指定目录下所有文件名为'kk'的文件
            Class_Java_Path = glob.glob(os.path.join(Involved_repo_PATH, self.repo_name, '**/', Class_Name_java),
                                        recursive=True)
            PublicINFO = ""
            if len(Class_Java_Path)>0: # 可能找不到
                # windows指令使用 .;  Linux系统使用 .:
                JarPath = os.path.join(ChatTester_PATH, 'Java_Analyzer','src','main','jarPackage','javaparser-core-3.24.7.jar')
                classpath = '.:' + JarPath
                arg1 = Class_Java_Path[0]  # 项目里面原本的java文件
                arg2 = Class_Name
                ExcuteJava = os.path.join(ChatTester_PATH, 'Java_Analyzer','src','main','java')
                os.chdir(ExcuteJava)
                result = subprocess.run(["java", '-cp', classpath, 'PublicInfo_collection', arg1, arg2],
                                        stdout=subprocess.PIPE, check=True)
                os.chdir(current_dir)

                PublicINFOs = result.stdout.strip().decode('ascii')
                PublicINFO = commentDelete(PublicINFOs)
                if PublicINFO not in self.findClassInfo:
                    self.findClassInfo = self.findClassInfo + "\n" + f"# {Class_Name} class\n" + PublicINFO

            CompileError_fix_Prompt = self.findClassInfo + "\n\n" + "# Test Method\n" + BuggyMethod + "\n\n" +\
                f"# Instruction\nThe test method has a bug error (marked <Buggy Line>). " \
                f"\nPlease fix the buggy line based on the given \"{Class_Name}\" class information (it is crucial) and return the complete and compilable test method after fix. \n" \
                f"Note that the contents in  \"{Class_Name}\" class  cannot be modified.\nThe generated code should be enclosed within ``` ```."


        elif self.re_generate_Tag or "<Buggy Line>:" not in BuggyMethod:
            CompileError_fix_Prompt = (self.findClassInfo + "\n\n" +
                                       "# Focal Method\n" + self.Focal_Method + "\n\n" +
                                       "# Method Intention\n" + self.Method_intention + "\n\n" +
                                       f"# Instruction\nPlease generate a complete and compilable test method for the `Focal Method` based on the `Method Intention` and Class Information. \nThe generated test method coverage for the focal method is as comprehensive as possible, and the generated code should be enclosed within ``` ```.")

        else:
            CompileError_fix_Prompt = (self.findClassInfo + "\n\n" +
                                     "# Test Method\n" + BuggyMethod + "\n\n" +
                                      f"# Instruction\nThe test method has a bug error (marked <Buggy Line>). \n Please repair the buggy code " \
                                      f"line and return the complete and compilable test method after repair. \nThe generated code should be enclosed within ``` ```.")



        return CompileError_fix_Prompt, self.findClassInfo

    def return_code(self, JavaCode_list):
        codeBlock = []
        left_brack_list = []
        right_brack_list = []
        Start_Tag = False
        for current_line_number, line in enumerate(JavaCode_list, start=1):
            if ("@Test" in line or " void " in line) and Start_Tag == False:
                Start_Tag = True
                if "@Test" not in line:  # 生成的代码当中可能没有 @Test 这个关键字
                    line_str = "@Test\n" + line
                    codeBlock.append(line_str)
                else:
                    codeBlock.append(line)

                left_brack_count = line.count("{")
                left_brack_list.extend(["{"] * left_brack_count)
                right_brack_count = line.count("}")
                right_brack_list.extend(["}"] * right_brack_count)
                continue
            if Start_Tag:
                codeBlock.append(line)

                left_brack_count = line.count("{")
                left_brack_list.extend(["{"] * left_brack_count)
                right_brack_count = line.count("}")
                right_brack_list.extend(["}"] * right_brack_count)
                if len(left_brack_list) == len(right_brack_list):
                    break
        codeBlock_str = "\n".join(codeBlock)

        return codeBlock_str


class TestPrompt():
    def __init__(self, Error_INFO_dict, Gen_Java_File, Method_intention, Focal_Method, Focal_Method_name):
        self.Error_INFO_dict = Error_INFO_dict
        self.Gen_Java_File = Gen_Java_File
        self.Method_intention = Method_intention
        self.Focal_Method = Focal_Method
        self.Focal_Method_name = Focal_Method_name

    # 对 compile信息处理
    # Input: {"ERROR_MESSAGE": str, "Class_Name": str, "ERROR_LINE": str}
    def Test_deal(self):
        ERROR_MESSAGE = self.Error_INFO_dict['ERROR_MESSAGE']
        # Class_Name = self.Error_INFO_dict['Class_Name']
        ERROR_LINE = self.Error_INFO_dict['ERROR_LINE']
        i = 0
        Buggy_line = ""
        allCode = []
        with open(self.Gen_Java_File,'r', encoding='utf-8') as f:
            for line in f.readlines():
                i = i + 1
                if ERROR_LINE.isdigit() and int(ERROR_LINE) == i:
                    numbe_of_cr = line.count(' ')-2
                    # BugInfo = f"<Error Line>: {ERROR_MESSAGE}" + '\n'
                    BugInfo = "[Generate an assertion statement here]" + '\n'
                    # allCode.append("\n")
                    allCode.append(' '*numbe_of_cr+BugInfo)
                    # allCode.append(line)
                    # allCode.append("\n")
                    break

                elif "// original test path:" not in line and "Test Method" not in line and 'Fixed Test Method' not in line:
                    allCode.append(line)

        dealedCode1 = commentDelete("\n".join(allCode))
        dealedCode = self.return_code(dealedCode1.split("\n"))

        # if "assert" in ERROR_MESSAGE.lower():
        TestError_fix_Prompt = ("# Focal method (Cannot be modified)\n" + self.Focal_Method + "\n\n" +
                                "# Method Intention\n" + self.Method_intention + "\n\n" +
                                "# Test Method\n" + dealedCode + "\n\n" +
                                f"# Instruction\nThe test method throw an error \" {ERROR_MESSAGE} \" in \" {Buggy_line} \". " + "\n" +
                                f"Please analyze the code logic and method intention of the Focal method, then generate a correct assertion statement in the test method. Return the complete and compilable test method for the Focal method.\nThe generated code should be enclosed within ``` ```.")

        if "[Generate an assertion statement here]" not in dealedCode:
            TestError_fix_Prompt = ("# Focal Method\n" + self.Focal_Method + "\n\n" +
                                       "# Method Intention\n" + self.Method_intention + "\n\n" +
                                       f"# Instruction\nPlease generate a complete and compilable test method for the `Focal Method` based on the `Method Intention`. \nThe generated test method coverage for the focal method is as comprehensive as possible, and the generated code should be enclosed within ``` ```")

        return TestError_fix_Prompt

    def return_code(self, JavaCode_list):
        codeBlock = []
        left_brack_list = []
        right_brack_list = []
        Start_Tag = False
        for current_line_number, line in enumerate(JavaCode_list, start=1):
            if ("@Test" in line or " void " in line) and Start_Tag == False:
                Start_Tag = True
                if "@Test" not in line:  # 生成的代码当中可能没有 @Test 这个关键字
                    line_str = "@Test\n" + line
                    codeBlock.append(line_str)
                else:
                    codeBlock.append(line)

                left_brack_count = line.count("{")
                left_brack_list.extend(["{"] * left_brack_count)
                right_brack_count = line.count("}")
                right_brack_list.extend(["}"] * right_brack_count)
                continue
            if Start_Tag:
                codeBlock.append(line)

                left_brack_count = line.count("{")
                left_brack_list.extend(["{"] * left_brack_count)
                right_brack_count = line.count("}")
                right_brack_list.extend(["}"] * right_brack_count)
                if len(left_brack_list) == len(right_brack_list):
                    break
        codeBlock_str = "\n".join(codeBlock)

        return codeBlock_str

def remove_comments_java(java_code):
    """
    Removes all comments from the given Java/C++ code, while preserving the content
    within string literals.
    """
    # Pattern to match string literals (both single and double-quoted) or comments
    pattern = r'(".*?"|\'.*?\'|//.*?$|/\*.*?\*/)'

    def replace_func(match):
        # If the matched text is a comment (either single or double slash), remove it (replace with empty string)
        # Otherwise, it's a string literal, so we keep it
        if match.group(0).startswith(("//", "/*")):
            return ""  # Remove comments
        else:
            return match.group(0)  # Keep string literals

    # Using the sub function with a replacement function
    cleaned_code = re.sub(pattern, replace_func, java_code, flags=re.DOTALL | re.MULTILINE)
    return cleaned_code

def commentDelete(code):

    codeWithoutComment = remove_comments_java(code)  # 去除注释

    # 将字符中多余的空行去除
    code = '\n'.join(filter(lambda x: x.strip(), codeWithoutComment.split('\n')))

    # 然后在 <Buggy Line> 的前一行和后两行，分别加上一个换行符
    out_code = []
    code_list = code.split("\n")
    add_line = []
    for i in range(len(code_list)):
        if i in add_line: continue

        if "<Buggy Line>" in code_list[i]:
            out_code.append("\n")
            out_code.append(code_list[i]+'\n')  # bug info
            out_code.append(code_list[i+1]+'\n') # bug code
            out_code.append("\n")
            add_line.append(i+1)

        else:
            out_code.append(code_list[i]+'\n')

    returnCode = "".join(out_code)

    return returnCode

if __name__ == "__main__":
    pass
