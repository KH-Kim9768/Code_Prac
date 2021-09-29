# for i in range(0, 3):
#     print("안녕하세요")


# i = 1
# result = 0
# while i <= 10 :
#     result += i
#     i += 1
# print(result)

# for i in range(100):
#     print("for 문을 %d 번 반복" % i)
#     break



'''
누적합이 1000이상이 되는 시점을 알아보는 반복문 작성
'''
# hap = 0
# for i in range(1, 101):
#     if i % 3 == 0:
#         continue
#     hap += i
    
# print("누적합 : %d" % hap)

'''
다이아 모양 출력하기
n = 9
별표 유니코드 = \u2605
'''
'''
max = 9
star = '\u2605'

count_blank = max // 2
count_star = 1

total_count = 0

# 증감 
increase = 2

while total_count < max:

    for i in range(count_blank):
        print(' ', end = ' ')
    
    for i in range(count_star):
        print('\u2605', end = ' ')
    
    print()
    count_star += increase
    count_blank -= increase // 2

    if count_blank == 0:
        increase = -2

    total_count += 1
    
'''
'''
i = 0
while i < 9 :
    if i < 5:
        k = 0
        while k < 4 - i:
            print('  ', end='')
            k += 1
        k = 0
        while k < i*2 + 1:
            print('\u2605', end=' ')
            k += 1
    else:
        k = 0
        while k < i-4:
            print('  ', end='')
            k += 1
        k = 0
        while k < (9-i)*2 - 1:
            print('\u2605', end=' ')
            k += 1
    
    print()
    i += 1
'''
