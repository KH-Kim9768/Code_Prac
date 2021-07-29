# ID : 6065
# 정수 3개 입력받아 짝수만 출력하기

num1, num2, num3 = map(int, input().split())

if num1 % 2 == 0:
    print(num1)

if num2 % 2 == 0:
    print(num2)

if num3 % 2 == 0:
    print(num3)