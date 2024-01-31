n = int(input())

# 산술 평균을 구하기 위한 sum
sum = 0

# 중앙값을 구하기 위한 리스트
num_list = []
min_num2, max_num2 = 4001, -4001

# 최빈값을 구하기 위한 딕셔너리
num_dict = {}

# 범위를 구하기 위한 최소, 최대
min_num, max_num = 4001, -4001

for i in range(n):
    num = int(input())

    # 산술 평균을 구하기 위한 sum
    sum += num

    # 중앙값을 구하기 위한 리스트
    num_list.append(num)

    # 최빈값을 구하기 위한 딕셔너리
    if num in num_dict:
        num_dict[num] += 1
    else:
        num_dict[num] = 1

    # 범위를 구하기 위한 최소, 최대
    if num < min_num:
        min_num = num
    if num > max_num:
        max_num = num

# 산술평균 출력
print(int(round(sum/n,0)))

# 중앙값 출력
# 리스트의 중앙값 인덱스 구하기
mid = int((len(num_list)-1)/2)
# 정렬
num_list.sort()
print(num_list[mid])

# 최빈값 출력
# 딕셔너리의 value 중 가장 큰 값을 구하기
mode = max(num_dict.values())
# 딕셔너리의 value 중 가장 큰 값의 키 값 구하기
num_dict_list = [key for key, value in num_dict.items() if value == mode]
if len(num_dict_list) > 1:
    num_dict_list.sort()
    print(num_dict_list[1])
else:
    print(num_dict_list[0])

# 범위 출력
print(max_num - min_num)