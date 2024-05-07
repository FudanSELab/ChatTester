
import os
import shutil
class FunctionToool:
    def __init__(self):
        pass
    def boolean(self, file_path):
        if not os.path.exists(file_path):
            print('Creat floder....')
            os.makedirs(file_path)
        else:
            shutil.rmtree(file_path)
            os.makedirs(file_path)