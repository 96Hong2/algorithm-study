from collections import deque

def bfs(graph, start, end):
    queue = deque([(start, 0)])  # (현재 노드, 현재까지의 간선 수)
    visited = set([start])

    while queue:
        current, distance = queue.popleft()
        if current == end:
            return distance

        for neighbor in graph[current]:
            if neighbor not in visited:
                visited.add(neighbor)
                queue.append((neighbor, distance + 1))

    return -1  # 경로가 존재하지 않는 경우

n, k = map(int, input().split())
graph = [[] for _ in range(n)]

for i in range(n):
    graph[i].append(int(input()))

# BFS 실행하여 최소 간선의 개수 찾기
min_edges = bfs(graph, 0, k)
print(min_edges)
