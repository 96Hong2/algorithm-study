import math

n, m = map(int, input().split())
x, y = map(int, input().split())

known = 0
semi_known = 0
for _ in range(m):
    a, b = map(int, input().split())
    if a != 0:
        known += 1
    else:
        semi_known += 1

nums = math.comb((9 - known - semi_known), (n - known - semi_known)) * math.factorial(n-known)
input_time = x * nums
delay_time = y * (nums // 3) if nums % 3 != 0 else y * ((nums // 3) - 1)
print(input_time + delay_time)