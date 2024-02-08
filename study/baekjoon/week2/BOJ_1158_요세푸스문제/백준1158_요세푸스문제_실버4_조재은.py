from collections import deque

# 입력 갑 읽기
# 1번 부터 n번까지의 n명의 사람이 원을 이루면서 앉아있고, 양의 정수 k를 입력받는다.
n, k = map(int, input().split())
# n명의 사람을 넣어준다.
q = deque([i+1 for i in range(n)])

r = []

while(q):                           # q가 비어있지 않는 동안 반복
    for _ in range(k-1):            # k-1번 만큼 반복
        q.append(q.popleft())       # p 첫 번째 숫자를 pop한 값을 append 한다.
    r.append(str(q.popleft()))      # 이 작업을 반복하면 k-1번째로 있는 숫자를 맨 앞으로 옮기는 효과를 냅니다.
                                    # 제거할 숫자를 pop하여 결과 리스트인 r에 추가한다.

# <3, 6, 2, 7, 5, 1, 4> 형태로 나오고 싶으면 문자열을 직접 구성하여 출력해야한다.
print("<", ", ".join(r), ">", sep="")