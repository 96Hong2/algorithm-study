car_number = list(input())

total = 1

for idx, element in enumerate(car_number):
    if idx == 0:
        if element == 'c':
            total = (total * 26) % 1000000009
        if element == 'd':
            total = (total * 10) % 1000000009
    
    elif element == car_number[idx-1]:
        if element == 'c':
            total = (total * 25) % 1000000009
        if element == 'd':
            total = (total * 9) % 1000000009
    
    else:
        if element == 'c':
            total = (total * 26) % 1000000009
        if element == 'd':
            total = (total * 10) % 1000000009

print(total)