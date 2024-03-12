# 연결 요소란 : 노드 끼리 연결되어 있는 묶음의 개수
import sys
from collections import defaultdict

sys.setrecursionlimit(10**7)

n, m = map(int, input().split())

graph = [[] for _ in range(n+1)]

for _ in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

def dfs(v):
    # 해당 정점에 방문하면 무조건 방문 기록 작성
    visited[v] = True
    for i in graph[v]:
        if not visited[i]:
            dfs(i)

# 연결 요소 개수 세기
count = 0
visited = [False for _ in range(n+1)]
for i in range(1, n+1):
    if not visited[i]:
        count += 1 # dfs가 돌고나면 하나의 연결 요소를 찾은 것이므로 cnt + 1
        dfs(i)

print(count)