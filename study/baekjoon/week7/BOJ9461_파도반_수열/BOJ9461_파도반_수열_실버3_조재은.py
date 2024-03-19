P = [0 for i in range(101)] # 1 <= N <= 100

P[1] = 1
P[2] = 1
P[3] = 1

# P[N] = P[N-3] + P[N-2] 규칙 성립
for i in range(4, 100+1):
    P[i] = P[i-3] + P[i-2]

t = int(input())
for _ in range(t):
    n = int(input())
    print(P[n])