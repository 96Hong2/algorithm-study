import  math

# n: 비밀번호의 자릿수, m: 비밀번호에 대해 기억하는 정보의 수
n, m = map(int, input().split())

# x: 비번 입력하는 데 걸리는 시간, y: 비번 3번 연속 실패 입력 시 비번 입력할 수 없는 시간
x, y = map(int, input().split())

pwCnt = 0      # 비밀번호의 특정 자리가 확정된 숫자의 개수입니다.
cnt = 0        # 비밀번호에 포함되어야 하지만 자리가 확정되지 않은 숫자의 개수

for _ in range(m):
    # m개 줄에 걸쳐 비밀번호에 대한 정보를 뜻하는 a, b
    a, b = map(int, input().split())
    if a != 0:   # a가 0이 아니면, a번째 자리의 값이 b라는 것을 의미
        pwCnt += 1
    else:       # a가 0이면 비번 중 한 자리의 값이 b라는 것을 의미
        cnt += 1

n -= pwCnt # 확정된 자리의 숫자를 제외한 남은 자리수를 업데이트
result = 1
if cnt > 0:
    # n개의 자리 중에서 cnt개의 특정 숫자를 포함하는 조합의 수를 계산
    # cnt개의 특정 숫자를 나열하는 순열의 수를 계산합니다.
    result *= math.comb(n,cnt) * math.factorial(cnt)
    
n -= cnt # 자리는 확정되지 않았지만 포함되어야 하는 숫자를 배치한 후의 남은 자리수를 업데이트
if n > 0:
    # 남은 자리수에 대해, 사용할 수 있는 숫자로 만들 수 있는 순열의 수를 계산합니다. 
    # 여기서 9 - (pwCnt + cnt)는 아직 사용되지 않은 숫자의 개수 (0 ~9번까지에서 -1)
    result *= math.perm(9-(pwCnt+cnt), n)
    
# 계산된 비밀번호 조합의 수에 따라 비밀번호를 입력하는 데 걸리는 
# 총 시간(result * x)과, 3회 연속 실패 후 대기하는 시간을 포함한 총 시간을 계산하고 출력
print(result * x + ((result -1) // 3) * y)
