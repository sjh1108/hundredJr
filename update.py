#!/usr/bin/env python

import os
from urllib import parse

HEADER = """# 
# 백준 & 프로그래머스 & SWEA 문제 풀이 목록

프로그래머스의 경우, 푼 문제 목록에 대한 마이그레이션이 필요합니다.

"""

def main():
    content = HEADER
    directories = []
    solveds = []

    for root, dirs, files in os.walk("."):
        dirs.sort()
        files.sort()
        if root == '.':
            for dir in ('.git', '.github'):
                try:
                    dirs.remove(dir)
                except ValueError:
                    pass
            continue

        category = os.path.basename(root)
        directory = os.path.basename(os.path.dirname(root))
        
        # 특정 폴더는 건너뜀
        if category == 'images' or directory == '.':
            continue
            
        # 메인 디렉토리 섹션 헤더 추가
        if directory not in directories:
            if directory in ["백준", "프로그래머스", "SWEA"]:
                content += "## 📚 {}\n".format(directory)
            else:
                content += "### 🚀 {}\n".format(directory)
                content += "| 문제번호 | 링크 |\n"
                content += "| ----- | ----- |\n"
            directories.append(directory)

        # 각 문제 폴더의 README.md만 링크한다.
        if category in solveds:
            continue

        readme_name = None
        for file in files:
            if file.lower() == "readme.md":
                readme_name = file
                break

        # README.md가 없는 폴더는 출력하지 않는다.
        if readme_name is None:
            continue

        file_path = os.path.join(root, readme_name).replace("\\", "/")
        content += "|{}|[링크]({})|\n".format(category, parse.quote(file_path))
        solveds.append(category)

    with open("README.md", "w") as fd:
        fd.write(content)
        
if __name__ == "__main__":
    main()
