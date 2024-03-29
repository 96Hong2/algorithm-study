import heapq

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

if n == 1:
    print(arr[0][0])
else:
    heap = []
    for sub_list in arr:
        for element in sub_list:
            if len(heap) < n:
                heapq.heappush(heap, element)
            else:
                heapq.heappushpop(heap, element)

    print(heap[0])