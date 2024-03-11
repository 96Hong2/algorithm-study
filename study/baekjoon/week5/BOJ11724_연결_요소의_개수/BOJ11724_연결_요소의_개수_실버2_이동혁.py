n, m = map(int, input().split())

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

sum = 0
visited = set()
for i in range(1, n+1):
    if i in visited:
        continue
    visited.update(set(dfs(graph, i)))
    sum += 1

print(sum)