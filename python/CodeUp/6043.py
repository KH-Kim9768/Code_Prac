# ID : 6043
# 실수 2개 입력받아 나눈 결과 계산하기

num1, num2 = map(float, input().split())
res = num1 / num2
print("{:.3f}".format(res))
# print('%.3f' % res)