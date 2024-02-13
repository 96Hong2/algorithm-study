import os
from collections import Counter
# 파일 개수 n 입력받기
n = int(input())
file_names = []
# 파일 이름 입력받기
for _ in range(n):
    file_names.append(input())
results = []
# 파일 이름에서 확장자 추출 (점 제거)
for file_name in file_names:
    result = os.path.splitext(file_name)[1][1:]  # 확장자 앞의 점 제거
    results.append(result)
# 확장자별 카운트
file_counter = Counter(results)
# 확장자와 카운트 출력 (점 제거된 확장자)
for ext, count in sorted(file_counter.items()):  # 사전 순으로 정렬
    print(f"{ext} {count}")