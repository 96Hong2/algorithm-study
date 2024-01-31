import numpy as np
from collections import Counter

# N개의 수 입력값 (홀수)
n = int(input())

li = []
for _ in range(n):
    li.append(int(input()))


# 1. 산술평균 : n개의 수들의 합을 n으로 나눈 값, 소수점 이하 첫째 자리에서 반올림한 값을 출력
a1 = round(sum(li) / n)

print(a1)

# 2. 중앙값 : n개의 수들을 증가하는 순서로 나열했을 경우 그중앙에 위차하는 값
li.sort()
a2 = li[n//2] # 또는 numpy 사용, a2 = np.median(li)

print(a2)

# 3. 최반값 : n개의 수들 중 가장 많이 나타나는 값, 여러 개 있을 때에는 최빈값 중 두번째로 작은 값을 출력

 # Counter 라이브러리는 최빈값이 객체 형태로 저장됩니다.
 # {값:빈도 수}로 저장되며, 정렬을 해두었기에 빈도 수가 같은 값이어도 작은 수 부터 정리됩니다.
cnt = Counter(li).most_common(2)

if len(cnt) > 1:
    if cnt[0][1] == cnt[1][1]:  # 0번 인덱스와 1번 인덱스의 빈도수 값이 같다면
        print(cnt[1][0])        # 그 다음 수를 출력
    else:
        print(cnt[0][0])        # 아니면 0번 인덱스 출력
else:                           # 애초에 입력값이 하나면 그냥 출력
    print(cnt[0][0])

# 4. 범위 : n개의 수들 중 최댓값과 최솟값의 차이
a4 = max(li) - min(li)

print(a4)