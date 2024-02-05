import sys

T = int(sys.stdin.readline().strip())

# 테스트케이스 개수만큼 반복
for _ in range(T):
    wears = {}
    n = int(sys.stdin.readline().strip())
    # 의상 개수만큼 반복
    for _ in range(n):
        name, type = sys.stdin.readline().strip().split()
        if type in wears:
            # 종류가 이미 있으면 해당 종류에 의상 이름만 추가
            wears[type].append(name)
        else:
            # 종류가 사전형에 없으면 추가
            wears[type] = [name]

    cnt = 1

    # 조합식을 세워 계산
    # +1하는 이유는 알몸도 옷이라고 생각해 추가
    for x in wears:
        cnt *= (len(wears[x]) + 1)

    # -1하는 이유 모든 종류의 옷을 착용하지 않았을 경우를 제외
    print(cnt - 1)