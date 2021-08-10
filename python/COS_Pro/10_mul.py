'''
표준 입력으로 자연수 n을 입력받아, 10의 배수 n개를 크기가 작은 것부터 순서대로 출력해주세요
'''

n = int(input())

for i in range(1, n+1):
    print(i*10)

i = 1
while i < n+1:
    print(i*10)
    # print("%d" % (i*10))
    i += 1