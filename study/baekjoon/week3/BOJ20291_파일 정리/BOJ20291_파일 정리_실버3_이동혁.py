from collections import Counter

n = int(input())
extension_lst = []

for _ in range(n):
    name, extension = map(str, input().split('.'))
    extension_lst.append(extension)

extension_counter = Counter(extension_lst)

for ext in sorted(extension_counter):
    print(ext, extension_counter[ext])