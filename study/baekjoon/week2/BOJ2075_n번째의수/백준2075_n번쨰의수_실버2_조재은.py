import heapq

n = int(input())

heap = []

for _ in range(n):
    numbers = map(int, input().split())
    for number in numbers:
        if len(heap) < n :                            # 리스트를 최소 힙처럼 다룰 수 있도록 하기 때문에, 빈 리스트를 heapq의 함수를 호출할 때마다 리스트에 인자를 넘겨야 한다.
            heapq.heappush(heap, number)        # number를 heap에 추가
            print(heap)
        else:
            if heap[0] < number:
                heapq.heappop(heap)                   # heappop 함수는 가장 작은 원소를 pop
                heapq.heappush(heap, number)
                print(heap)

print(heap[0])