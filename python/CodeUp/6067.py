# ID : 6067
# 정수 1개 입력받아 분류하기

num1 = int(input())

if num1 < 0:
    if num1 % 2 == 0:
        print('A')
    
    else:
        print('B')

elif num1 > 0:
    if num1 % 2 == 0:
        print('C')
    
    else:
        print('D')