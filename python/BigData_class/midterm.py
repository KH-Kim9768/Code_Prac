import numpy as np

a = np.array([12, 8, 20, 17, 15]) # a를 1차원 배열로 선언
a.sort()
print(a)    # => [ 8 12 15 17 20]
print(a.shape)  # => (5,) // tuple형으로 return


b = np.array([[12,3,4.0], [1,4,5]]) # 2차원 배열
print(b.ndim) # 차원 => 2
print(b.shape) # b데이터의 형태 => (2,3)
print(b.dtype) # 요소의 데이터 형을 알려줌 => float64


c = np.array([[[1, 3, 0, 1], [1, 1, 4, 2], [3, 3, 4, 1]], [[2, 1, 2, 1], [1, 0, 1, 0], [1, 5, 6,2]]]) # 3차원 배열
print(c.shape) # c데이터의 형태 => (2,3,4)


d = np.zeros([2,3]) # 2행 3열의 배열을 0으로 채워넣어라
print(d)
print(d.dtype)  # d데이터의 형태 => float64


e = np.random.random([2,5]) # 0~1까지 랜덤 숫자로 2행 5열 배열 생성
print(e)


f = np.arange(1, 20, 2.5) # 1부터 20미만 까지 2.5만큼 증가하는 배열 생성
print(f) # [ 1.   3.5  6.   8.5 11.  13.5 16.  18.5]


c = a.copy() # copy() 하지 않으면 같은 객체를 참조함
c[1] = 30
print(a, c) # a가 참조하는 객체를 복사함 => [ 8 12 15 17 20] [ 8 30 15 17 20]


a = np.array([1, 2, 3, 4, 5, 6])
b = a.reshape([2,3]) # 1차원 구조 -> 2차원 구조 => [[1, 2, 3], [4, 5, 6]]
print(a, b)
a[4] = 10 # a, b 둘 다 값이 바뀜 => 참조를 복사했기 때문에 동일한 객체 참조함
print(a, b) # 


a = np.array([[3,2,-2,0,1], [2,-3,4,5,2], [1,1,-2,-3,2]])
print(a.shape) # => (3,5)
print(a[2,1], a[-1,3], a[0, -2]) # -1은 뒤에서 첫번째 => 1, -3, 0
print(a[2]) # => [1, 1, -2, -3, 2]
print(a[-2]) # => [2, -3, 4, 5, 2]
print(a[:, 3]) # => [0, 5, -3]
print(a[:, :3]) # => [3, 2, -2], [2, -3, 4], [1, 1, -2]
print(a[1,3], a[1][3]) # => 5 5


a = np.array([1, 2, 3, 4, 5])
b = np.array([0, -1, 2, 6, 1])
print(3*a) # => [3, 6, 9, 12, 15]
print(a**2) # => [1, 4, 9, 16, 25]
print(a + b) # => [1, 1, 5, 10, 6]
print(a - b) # => [1, 3, 1, -2, 4]
print(a * b) # => [0, -2, 6, 24, 5]
print(b < 0) # => [False, True, False, False, False]


a = np.array([[3,2,-2,0,1], [2,-3,4,5,2], [0,1,-2,-3,2]])
print(a.sum()) # => 12
print(a.sum(axis = 0)) # => [5, 0, 0, 2, 5]
print(a.sum(axis = 1)) # => [4, 10, -2]
print(a.cumsum(axis = 0)) # 누적합 => [3, 2, -2, 0, 1], [5, -1, 2, 5, 3], [5, 0, 0, 2, 5]
print(a.max(axis = 0)) # => [3, 2, 4, 5, 2]
print(a.max(axis = 1)) # => [3, 5, 2]

positive = a > 0
print(positive)
'''
=>
[[ True  True False False  True]
 [ True False  True  True  True]
 [False  True False False  True]]
'''

b = a[positive]
print(b) # => [3, 2, 1, 2, 4, 5, 2, 1, 2]
print(b.sum()) # => 22


a = np.array([1,2,3])
b = np.array([4,5,6])
c = np.array([[7,8,9], [1,4,7]])
x = np.vstack([a,b]) # 세로로 이어 붙이기
print(x) # => [[1, 2, 3], [4, 5, 6]]

a = np.array([1,2,3,4,5])
b = np.array([0, -1, 2, 6, 1])
c = np.array([np.pi/2, np.pi, np.pi*2]) # pi 관련
print(c) # => [1.57079633 3.14159265 6.28318531]
print(np.add(a, b)) # => [1, 1, 5, 10, 6]
print(np.log10(a)) # => [0., 0.30103, 0.47712125, 0.60205999, 0.69897]
print(np.sin(c)) # => [1.0000000e+00, 1.2246468e-16, -2.4492936e-16]
print(np.left_shift(a, 1)) # 왼쪽 Shift == *2 => [2, 4, 6, 8, 10]
print(np.greater(a, b)) # 큰 지 비교=> [True, True, True, False, True]
print(np.maximum(a, b)) # => [1, 2, 3, 6, 5]
print(c.round(2)) # 소수점 2자리 반올림 => [1.57, 3.14, 6.28]


a = np.array([[1,2,3,4], [0,1,2,3], [-1,0,1,2]])
b = np.array([[1,1,2,2]])
print(a+b) # => [[2, 3, 5, 6], [1, 2, 4, 5], [0, 1, 3, 4]]


a = np.array([[4,2], [2,7], [-2, 1]])
c = np.array([[1,-2, 3], [5, 0, 2]])
res = np.matmul(a,c) # 행렬의 곱셈 ex) res[0,0] = a[0,0]*b[0,0] + a[0,1]*b[0,1]...
print(res) # => [[14, -8, 16], [37, -4, 20], [3, 4, -4]]


# 랜덤 숫자 발생 프로그램
import random as r

numbers = []

for i in range(10):
    numbers.append(r.randrange(0, 10))

print("생성된 리스트", numbers)
for i in range(10):
    if i not in numbers:
        print("숫자", i, "이 없네요.")


# 별 출력 프로그램
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
