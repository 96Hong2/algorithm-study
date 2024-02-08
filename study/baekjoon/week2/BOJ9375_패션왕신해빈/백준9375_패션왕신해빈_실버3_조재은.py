from collections import Counter
t = int(input())

# 테스트케이스 개수만큼 반복
for i in range(t):
    n = int(input())
    wear = []
    # 의상 개수만큼 반복
    for j in range(n):
        a, b = input().split()
        wear.append(b)

    wear_Counter = Counter(wear)
    cnt = 1 # 각 종류마다 항목의 개수

    for key in wear_Counter:
        # +1하는 이유는 알몸도 옷이라고 생각해 추가
        cnt *= wear_Counter[key] + 1
        
    # -1하는 이유 모든 종류의 옷을 착용하지 않았을 경우를 제외
    print("result", cnt-1)
