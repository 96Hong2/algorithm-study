MOD = 10 ** 9 + 9

plate_format = input() # 차량 번호판 형식 입력 받기

# 첫 번째 문자 처리
if plate_format[0] == 'c':
    count = 26    # 문자, a ~ z까지, 경우의 수 26가지
else:
    count = 10     # 숫자, 0~9번까지, 경우의 수 10가지

for i in range(1, len(plate_format)):
    if plate_format[i] == plate_format[i-1]: # 이전 문자와 같은 경우
        if plate_format[i] == 'c':
            count = (count * 25) % MOD  # c 다음에 c
        else:
            count = (count * 9) % MOD   # c 다음에 d
    else:                                   # 이전 문자와 다른 경우 ('c'와 'd' 사이의 전환)
        if plate_format[i] == 'c':
            count = (count * 26) % MOD # d 다음에 c
        else:
            count = (count * 10) % MOD # c 다음에 d

print(count)