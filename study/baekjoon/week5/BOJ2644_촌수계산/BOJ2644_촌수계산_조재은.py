n = int(input())                        # 전체 사람의 수
a, b = map(int, input().split())        # 촌수를 계산해야 하는 서로 다른 사람의 번호
m = int(input())                        # 부모 자식들 간의 관계의 개수

family = [[] for i in range(n+1)]       # n+1 을 하는 이유는 사람의 번호가 1부터 시작하기 때문


for _ in range(m):
    x, y = map(int, input().split()) # 부모 자식간의 관계를 나타내는 두 번호, x:부모/y:자식
    # 양방향
    # x 사람의 리스트에섯 y를 추가하고, y 사람의 리스트에는 x를 추가하는 방식
    # 예를 들어 (2, 7) 쌍이 입력되면, family[2] 에 '7'이 추가되고, family[7] 에 '2'가 추가됨
    family[x].append(y)
    family[y].append(x)

# family 출력값:  [[], [2, 3], [1, 7, 8, 9], [1], [5, 6], [4], [4], [2], [2], [2]]
visited = [False for _ in range(n+1)]
result = []

def dfs(v, count):
    count += 1              # 현재 노드로 이동하는 데 필요한 경로 길이 업데이트
    visited[v] = True       # 노드 방문 표시

    if v == b:              # 현재 노드 v 가 목표 노드 b와 같다면, result에 count 추가.
        result.append(count)

    for i in family[v]:     # 현재 노드 'v'와 연결된 모든 인접 노드 'i'에 대해 반복
                            # 만약 인접 노드 u가 아직 방문되지 않았다면 재귀 함수 소출
        if not visited[i]:
            dfs(i, count)

dfs(a,0)

if len(result) == 0:
    print(-1)
else:
    print(result[0] - 1) # -1 하는 이유는 시작노드도 경로에 포함되기 때문에, 실제 거리는 하나 줄어듬