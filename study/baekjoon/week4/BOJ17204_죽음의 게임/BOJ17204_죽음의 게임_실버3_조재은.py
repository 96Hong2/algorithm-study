'''
게임하는 n명의 사람들
 - 게임을 시작하는 영기는 0번
 - 그 오른쪽 사람은 1번, 그 오른쪽은 2번, n-1 번의 오른쪽 사람은 다시 0번
 - 모든 사람들은 각각 테이블에 둘러 앉은 사람들 중 한명을 지목하고 나서 0번은 임의의 양의 정수 m을 외친다
 - 0번은 "1"이라 말하고, "1"이라고 말한 사람이 "2"라고 말하고 같은 방식으로 m까지 말하며 마지막으로 m이라고 말한 사람이 지목한 사람은 벌주를 마ㅣㄴ다
 - 보성이가 벌주를 마시기 위해 영기가 불러야 하는 가장 작은 양의 정수(m)는?
 - 지목을 받아야하지만 받지 않는 경우는 "-1" 출력

'''

# n : 게임에 참여하는 사람의 수, k : 보성이의 번호
n, k = map(int, input().split())
numlist = []

# i번째 사람이 지목하는 사람의 번호 a
for _ in range(n):
    a = int(input())
    numlist.append(a)

# m: 가장 작은 양의 정수
m = 0
newnum = 0
for _ in range(k):
    if newnum != k:                 # newnum이 보성이의 번호가 아니라면
        newnum = numlist[newnum]    # 지목된 번호를 newnum에 넣어준다
        m += 1
    else:                           # 보성이의 번호라면
        print(m)                    # count 한 값 출력
        break
# 지목받아야 하는 사람이 어떤 경우에도 지목받지 못하는 경우
# break문을 만나지 못했기 때문에 for else로 빠지게 된다.
else:
    print(-1)