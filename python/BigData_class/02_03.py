'''

2021 - 09 - 13
Big Data Class

Python Practice

'''

number = 1
sum = 0

while number <= 100 :
    sum += number

    if sum >= 1000:
        break

    number += 1

print("합계 : %d, 숫자 : %d" %(sum, number))
