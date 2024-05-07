import subprocess
import time

# 设置重试间隔秒数
retry_interval = 5

# 设置重试次数的上限
max_retries = 50

def run_command():
    try:
        # 尝试运行你的Python脚本
        completed_process = subprocess.run(
            ['python', 'scripts/jacoco.py'],
            check=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
        return completed_process
    except subprocess.CalledProcessError as e:
        # 打印错误信息
        print(f"Command failed with return code {e.returncode}")
        print(f"stdout: {e.stdout.decode()}")
        print(f"stderr: {e.stderr.decode()}")
        return None

for i in range(max_retries):
    print(f"Attempt {i+1} of {max_retries}")
    result = run_command()
    if result is not None and result.returncode == 0:
        print("Command succeeded")
        break
    else:
        print(f"Command failed, retrying in {retry_interval} seconds...")
        time.sleep(retry_interval)
else:
    print("Command failed after maximum retries")
