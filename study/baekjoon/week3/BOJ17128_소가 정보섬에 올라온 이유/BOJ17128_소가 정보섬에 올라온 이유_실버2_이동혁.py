n, q = map(int, input().split())
quality_sum_list = [1 for _ in range(n)]

qualities = map(int, input().split())
i = 0
for quality in qualities:
    quality_sum_list[i % n] *= quality
    quality_sum_list[(i - 1) % n] *= quality
    quality_sum_list[(i - 2) % n] *= quality
    quality_sum_list[(i - 3) % n] *= quality
    i += 1

quality_sum = sum(quality_sum_list)

jokes = map(int, input().split())
for joke in jokes:
    quality_sum_list[(joke - 1) % n] = -quality_sum_list[(joke - 1) % n]
    quality_sum_list[(joke - 2) % n] = -quality_sum_list[(joke - 2) % n]
    quality_sum_list[(joke - 3) % n] = -quality_sum_list[(joke - 3) % n]
    quality_sum_list[(joke - 4) % n] = -quality_sum_list[(joke - 4) % n]
    quality_sum += 2*(quality_sum_list[(joke - 1) % n] + quality_sum_list[(joke - 2) % n] + quality_sum_list[(joke - 3) % n] + quality_sum_list[(joke - 4) % n])
    print(quality_sum)