#!/usr/bin/env python

import os
import re
from urllib import parse
from collections import defaultdict

HEADER = """# 
# 백준 & 프로그래머스 & SWEA 문제 풀이 목록

프로그래머스의 경우, 푼 문제 목록에 대한 마이그레이션이 필요합니다.

"""

def get_linked_problems(readme_path="README.md"):
    """README.md를 파싱하여 이미 링크된 문제들의 ID를 집합(set)으로 반환합니다."""
    linked_set = set()
    try:
        with open(readme_path, 'r', encoding='utf-8') as f:
            for line in f:
                # | 문제번호 | [링크](...) | 형식의 라인에서 '문제번호'를 추출합니다.
                match = re.search(r"\|\s*([^|]+?)\s*\|\[링크\]", line)
                if match:
                    problem_id = match.group(1).strip()
                    if problem_id not in ["문제번호", "-----"]:
                        linked_set.add(problem_id)
    except FileNotFoundError:
        pass  # 파일이 없으면 빈 집합을 반환합니다.
    return linked_set

def main():
    # 1. README.md에서 이미 링크된 문제 목록 가져오기
    linked_problems = get_linked_problems()
    print(f"✅ Found {len(linked_problems)} problems linked in README.md.")

    # 2. 파일 시스템을 탐색하여 현재 모든 문제 목록 가져오기
    all_problems = []
    found_problems_set = set()

    for root, dirs, files in os.walk("."):
        dirs.sort()
        if root == '.':
            for dir_to_skip in ('.git', '.github'):
                if dir_to_skip in dirs:
                    dirs.remove(dir_to_skip)
            continue

        category = os.path.basename(root)
        directory = os.path.basename(os.path.dirname(root))

        # 문제 폴더 구조(예: '백준/1000')에 맞는 경우만 처리
        if directory in ["백준", "프로그래머스", "SWEA"] and files:
            if category not in found_problems_set:
                # 첫 번째 파일을 대표 링크로 사용
                file_path = os.path.join(root, files[0])
                all_problems.append({"id": category, "platform": directory, "path": file_path})
                found_problems_set.add(category)

    print(f"✅ Found {len(found_problems_set)} problem folders in the file system.")

    # 3. 새로운 문제가 있는지 비교
    if not found_problems_set.issubset(linked_problems):
        print("🚀 New problems detected! Regenerating README.md...")

        # README 내용 새로 생성
        new_content = HEADER
        
        # 플랫폼별로 문제 그룹화
        problems_by_platform = defaultdict(list)
        for prob in all_problems:
            problems_by_platform[prob['platform']].append(prob)
        
        # 플랫폼 정렬 (백준, 프로그래머스, SWEA 순서 우선)
        PLATFORM_ORDER = {"백준": 0, "프로그래머스": 1, "SWEA": 2}
        sorted_platforms = sorted(
            problems_by_platform.keys(), 
            key=lambda p: PLATFORM_ORDER.get(p, 99)
        )
        
        for platform in sorted_platforms:
            new_content += f"## 📚 {platform}\n"
            new_content += "| 문제번호 | 링크 |\n"
            new_content += "| ----- | ----- |\n"
            
            # 문제 ID를 기준으로 정렬 (숫자 > 문자 순)
            sorted_problems = sorted(
                problems_by_platform[platform], 
                key=lambda x: (0, int(x['id'])) if x['id'].isdigit() else (1, x['id'])
            )
            
            for prob in sorted_problems:
                # Windows 경로(\)를 URL 친화적인 /로 변경
                file_path = prob['path'].replace("\\", "/")
                new_content += "|{}|[링크]({})|\n".format(prob['id'], parse.quote(file_path))
            new_content += "\n" # 플랫폼 간 간격 추가
        
        # 4. 변경된 내용으로 README.md 파일 쓰기
        with open("README.md", "w", encoding="utf-8") as fd:
            fd.write(new_content)
        print("✨ README.md has been successfully updated.")

    else:
        print("👍 No new problems found. README.md is already up-to-date.")

if __name__ == "__main__":
    main()