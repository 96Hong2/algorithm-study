n, q = map(int, input().split())
cow_quality_lst = list(map(int, input().split()))
joke_lst = list(map(int, input().split()))

cow_quality_sum_lst = []
for idx, _ in enumerate(cow_quality_lst):
    cow_quality_sum_lst.append(cow_quality_lst[idx % n] * cow_quality_lst[(idx + 1) % n] * cow_quality_lst[(idx + 2) % n] * cow_quality_lst[(idx + 3) % n])

print(cow_quality_sum_lst)
for cow_num in joke_lst:
    cow_quality_sum_lst[(cow_num-1) % n] = -cow_quality_sum_lst[(cow_num-1) & n]
    cow_quality_sum_lst[(cow_num-2) % n] = -cow_quality_sum_lst[(cow_num-2) % n]
    cow_quality_sum_lst[(cow_num-3) % n] = -cow_quality_sum_lst[(cow_num-3) % n]
    cow_quality_sum_lst[(cow_num-4) % n] = -cow_quality_sum_lst[(cow_num-4) % n]
    print(cow_quality_sum_lst, sum(cow_quality_sum_lst))