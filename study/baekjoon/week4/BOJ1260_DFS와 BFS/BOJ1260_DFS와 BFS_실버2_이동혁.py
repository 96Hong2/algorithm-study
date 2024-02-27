n, m, v = map(int, input().split())

graph = {}
for i in range(1, n+1):
    graph[i] = []
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(graph, start):
    visited = []
    stack = [start]

    while stack:
        node = stack.pop()
        if node not in visited:
            visited.append(node)
            stack.extend(sorted(graph[node], reverse=True))

    return visited

def bfs(graph, start):
    visited = []
    queue = [start]

    while queue:
        node = queue.pop(0)
        if node not in visited:
            visited.append(node)
            queue.extend(sorted(graph[node]))

    return visited

print(*dfs(graph, v))
print(*bfs(graph, v))