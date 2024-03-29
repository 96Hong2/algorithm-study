'''
가장 적은 종류의 비행기를 타고 모든 국가들을 여행
- 한 국가에서 다른 국가로 이동할 때 다른 국가를 거쳐 가도 된다.(방문했던 곳도 ㅇㅋ)

연결 그래프를 유지하기 위한 간선의 최소 개수는 (노드의 수 -1 )이다.
이를 신장 트리라 한다.
즉, 비행기의 종류 = 간선수
    여행갈 나라의 수 = 노드의 수
=> 간선의 최소 수 = 노드의 수 - 1

'''

# 테스트 케이스의 수
t = int(input())

for _ in range(t):
    # 국가의 수 : n, 비행기의 종류 : m
    n, m = map(int, input().split())

    # a와 b의 왕복 비행기 종류
    # 주어지는 비행 스케줄은 항상 연결 그래프를 이룸
    for _ in range(m):
        a, b = map(int, input().split())

    # 모든 국가를 여행하기 위해 타야하는 비행기 종류의 최소 개수
    print(n - 1)