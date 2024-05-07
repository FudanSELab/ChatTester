import os
import re

METHOD_STRING = 'public void test'

# test_dir = 'ProjectResult/Evosuite_first'
test_dir = '/Users/zhi/Documents/PH.D/Project/Testing/ChatTESTER/CodePackage/Prompt2Testing/Coverage/repos/'

# Define the pattern to match test method names such as test00, test01, etc.
pattern = re.compile(r'(?<=public void )test\d(?=\(\) throws Throwable {)')
# pattern = re.compile(r'(?<=public void )test\d\d(?=\(\) throws Throwable {)')

# Function to rename the methods
def rename_methods(src):
    # Initialize the count for renaming
    count = 0
    
    # Function to replace the matched object with a new method name
    def replacer(match):
        nonlocal count
        # Format the new method name with the current count
        new_name = f'test{count:01d}'
        # new_name = f'test{count:02d}'
        # Increment the count for the next replacement
        count += 1
        return new_name
    
    # Replace all occurrences of the pattern with the new method names
    return pattern.sub(replacer, src)


for foldername, subfolders, filenames in os.walk(test_dir):
    for filename in filenames:
        if not filename.endswith('_ESTest.java'):
            continue
        file_path = os.path.join(foldername, filename)

        with open(file_path, 'r', encoding="utf-8", errors="ignore") as f:
            src = f.read()
        print(file_path)
        src = src.replace('separateClassLoader = true', 'separateClassLoader = false')
        
        src = rename_methods(src)


        # method_cnt = 0
        # last_find_idx = 0

        
        # while src[last_find_idx:].find(METHOD_STRING) != -1:
        #     find_idx = src[last_find_idx:].find(METHOD_STRING)
        #     src = src[:find_idx] + src[find_idx:].replace(METHOD_STRING + src[find_idx + len(METHOD_STRING):find_idx + len(METHOD_STRING) + 2], METHOD_STRING + str(method_cnt).zfill(2))
        #     method_cnt += 1
        #     last_find_idx = find_idx + len(METHOD_STRING)

        # print(src)

        with open(file_path, 'w') as f:
            f.write(src)
        
        
        
        
        

            
        
    
        
        
        

