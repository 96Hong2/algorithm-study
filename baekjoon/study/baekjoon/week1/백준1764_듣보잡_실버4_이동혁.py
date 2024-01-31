n, m = map(int, input().split())

n_list, m_list = list(), list()

for _ in range(n): n_list.append(input())

for _ in range(m): m_list.append(input())

intersection = list(set(n_list) & set(m_list))
intersection.sort()

print(len(intersection))
print(*intersection, sep='\n')