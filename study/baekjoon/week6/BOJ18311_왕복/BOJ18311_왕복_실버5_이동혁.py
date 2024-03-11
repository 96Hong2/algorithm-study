n, k = map(int, input().split())

course = list(map(int, input().split()))

if k == sum(course):
    print(n)
if k <= sum(course):
    i = 0
    while True:
        if k < course[i]:
            break
        else:
            k -= course[i]
            i += 1
    print(i+1)
if k > sum(course):
    course_reversed = list(reversed(course))
    k -= sum(course_reversed)

    i = 0
    while True:
        if k < course_reversed[i]:
            break
        else:
            k -= course_reversed[i]
            i += 1
    print(n-i)