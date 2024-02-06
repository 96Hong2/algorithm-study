n, k = map(int, input().split())
josephus_list = []

from collections import deque

queue_in = deque(range(1, n+1))
queue_out = deque()

while len(queue_in) > 0:
    for _ in range(k-1):
        queue_in.append(queue_in.popleft())
    queue_out.append(queue_in.popleft())

print('<', end = '')
print(*queue_out, sep = ', ', end = '')
print('>')