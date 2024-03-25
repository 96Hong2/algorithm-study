t = int(input())
for _ in range(t):
    n = int(input())
    p_list = [0, 1, 1, 1, 2, 2, 3, 4, 5, 7, 9]
    for i in range(11, n+1):
        p_list.append(p_list[i-1] + p_list[i-5])
    print(p_list[n])