# n: 행의 수, m: 열의 수
n, m = map(int, input().split())

dp = [list(map(int, input().split())) for _ in range(n)]

for i in range(1,n):
    for j in range(m):
        dp[i][j] += dp[i-1][j] # 열의 누적 합계

'''
입력값
9 14 29 7
1 31 6 13
21 26 40 16
8 38 11 23
출력값
[[9, 14, 29, 7], 
[10, 45, 35, 20], 
[31, 71, 75, 36], 
[39, 109, 86, 59]]
'''

k = int(input())

for _ in range(k):
    x1, y1, x2, y2= map(int, input().split())
    ans = sum(dp[x2-1][y1-1:y2])
    '''
    입렵값
    1 1 3 2
    1 1 1 4
    출력값
    [31, 71] 
    [9, 14, 29, 7] 
    [39, 109, 86, 59]
    입력값 
    2 2 3 4 일 경우
    '''
    if x1 > 1:
        ans -= sum(dp[x1 - 2][y1-1:y2])
    print(ans)