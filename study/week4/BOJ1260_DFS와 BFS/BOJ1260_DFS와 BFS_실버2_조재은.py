from collections import deque

# n : 정점의 개수, m : 간선의 개수, v : 탐색 시작 번호
n, m, v = map(int, input().split())

# 초기값을 false로 만들어  그래프 선언
graph = [[False] * (n+1) for _ in range(n+1)]

# 연결된 정점을 입력
for i in range(m):
    x, y = map(int, input().split())
    graph[x][y] = 1
    graph[y][x] = 1

# dfs와 bfs 그래프의 방문 여부를 담을 리스트
visited1 = [False] * (n+1)
visited2 = [False] * (n+1)

# dfs 알고리즘
def dfs(v):
    # 방문 처리
    visited1[v] = True
    # 방문 후, 정점 출력
    print(v, end=" ")
    # 방문 기록이 업고, 인덱스에 값이 있다면 (= 연결되어 있다면)
    for i in range(1, n+1):
        if not visited1[i] and graph[v][i] == 1:
            # 방문한다. ** 재귀함수 사용
            # 호출될 때마다 visited는 1이 되고, 재귀되어 v에 i가 들어간다.
            dfs(i)

# bfs 알고리즘
def bfs(v):
    # 방문할 곳을 순서대로 넣을 큐
    q = deque([v])
    # 방문 처리
    visited2[v] = True
    # 큐 안에 데이터가 없을 때 까지 실행
    while q:
        # 큐 맨 앞에 있는 값을 꺼내서 출력
        v = q.popleft()
        print(v, end=" ")
        for i in range(1, n+1):
            # 방문기록이 없고, 인덱스 값이 있다면(= 연결되어 있다면)
            if not visited2[i] and graph[v][i] == 1:
                # 큐에 추카한다.
                q.append(i)
                visited2[i] = True
dfs(v)
print()
bfs(v)