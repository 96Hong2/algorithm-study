import  math

# n: 비밀번호의 자릿수, m: 비밀번호에 대해 기억하는 정보의 수
n, m = map(int, input().split())

# x: 비번 입력하는 데 걸리는 시간, y: 비번 3번 연속 실패 입력 시 비번 입력할 수 없는 시간
x, y = map(int, input().split())

pwCnt = 0
cnt = 0

for _ in range(m):
    # m개 줄에 걸쳐 비밀번호에 대한 정보를 뜻하는 a, b
    a, b = map(int, input().split())
    if a != 0:   # a가 0이 아니면, a번째 자리의 값이 b라는 것을 의미
        pwCnt += 1
    else:       # a가 0이면 비번 중 한 자리의 값이 b라는 것을 의미
        cnt += 1

n -= pwCnt
result = 1
if cnt > 0:
    result *= math.comb(n,cnt) * math.factorial(cnt)
n -= cnt
if n > 0:
    result *= math.perm(9-(pwCnt+cnt), n)
print(result * x + ((result -1) // 3) * y)