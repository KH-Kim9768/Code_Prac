'''

2021 - 09 - 13
Big Data Class

Python Practice

'''

'''
sum = 0
for i in range(1, 11):
    sum += i
print(sum)
'''
'''
dan = int(input("단을 입력하세요 : "))

for i in range(10):
    print("%d X %d = %d" % (dan, i, dan * i))
'''

for i in range(1, 10):
    for j in range(2, 10):
        print("%d X %d = %d" % (j, i, i*j), end='\t')
    print()
