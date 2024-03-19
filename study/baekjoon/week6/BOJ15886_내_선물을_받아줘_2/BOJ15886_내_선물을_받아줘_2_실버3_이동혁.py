n = int(input())
pattern = list(input())

graph = {}
for i in range(1, n+1):
    graph[i] = []

for i in range(n):
    if pattern[i] == 'E':
        graph[i+1].append(i+2)
        graph[i+2].append(i+1)
    if pattern[i] == 'W':
        graph[i+1].append(i)
        graph[i].append(i+1)

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
visited = list()

for i in range(1, n+1):
    if i in visited:
        continue
    visited.extend(dfs(graph, i))
    sum += 1

print(sum)