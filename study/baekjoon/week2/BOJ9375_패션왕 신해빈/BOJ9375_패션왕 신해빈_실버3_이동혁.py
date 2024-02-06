n = int(input())

for _ in range(n):
    m = int(input())
    cloth_dict = dict()
    sum = 1

    for _ in range(m):
        item, type = input().split()
        if type in cloth_dict:
            cloth_dict[type] += 1
        else:
            cloth_dict[type] = 1

    for key, value in cloth_dict.items():
        sum *= (value + 1)

    print(sum-1)