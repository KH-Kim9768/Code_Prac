# ID : 6045
# 정수 3개 입력받아 합과 평균 출력하기

num1, num2, num3 = map(int,input().split())
sum = num1 + num2 + num3
avr = sum/3
print(sum, '%.2f' % avr)