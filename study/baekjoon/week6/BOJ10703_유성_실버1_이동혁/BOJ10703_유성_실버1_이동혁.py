r, s = map(int, input().split())

arr = [list(input()) for _ in range(r)]

meteor_index = {}
earth_index = {}
for i in range(r):
    for j in range(s):
        if arr[i][j] == 'X':
            if j not in meteor_index:
                meteor_index[j] = [i]
            else:
                meteor_index[j].append(i)
        if arr[i][j] == '#':
            if j not in earth_index:
                earth_index[j] = [i]
            else:
                earth_index[j].append(i)


min_fall_length = r
for i in range(s):
    if i not in meteor_index:
        continue
    min_fall_length = min(min_fall_length, min(earth_index[i]) - max(meteor_index[i]) - 1)

for i in range(r):
    for j in range(s):
        if arr[i][j] == 'X':
            arr[i][j] = '.'

for i in meteor_index:
    for j in meteor_index[i]:
        arr[j+min_fall_length][i] = 'X'

for lst in arr:
    for element in lst:
        print(element, end = "")
    print()