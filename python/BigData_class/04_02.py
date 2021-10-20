import numpy as np

a = np.array([12, 8, 20, 17, 15]) # a를 1차원 배열로 선언
print(a)

a.sort() # a를 오름차순으로 정렬
print(a)

print(a.shape) # tuple형의 5개의 요소의  데이터

b = np.array([[12,3,4.0], [1,4,5]]) # 2차원 배열
print(b)

print(b.ndim) # 차원
print(b.shape) # b데이터의 형태
print(b.dtype) # 요소의 데이터 형을 알려줌

c = np.array([[[1, 3, 0, 1], [1, 1, 4, 2], [3, 3, 4, 1]], [[2, 1, 2, 1], [1, 0, 1, 0], [1, 5, 6,2]]]) # 3차원 배열
print(c)
print(c.shape)

d = np.zeros([2,3]) # 2행 3열의 배열을 0으로 채워넣어라
print(d)
print(d.dtype)

e = np.random.random([2,5]) # 0~1까지 랜덤 숫자로 2행 5열 배열 생성
print(e)

f = np.arange(1, 20, 2.5) # 1부터 20미만 까지 2.5만큼 증가하는 배열 생성
print(f)

x = 10
y = x
y = 12
print(x, y) # 변수의 값만 복사함

a = np.array([10, 20, 30, 40])
b = a
b[0] = -10
print(a) # b가 a의 참조를 복사했기 때문에 a, b가 참조하는 객체는 동일한 객체이다

c = a.copy()
c[1] = 30
print(a, c) # a가 참조하는 객체를 복사함

a = np.array([1, 2, 3, 4, 5, 6])
b = a.reshape([2,3]) # 1차원 구조 -> 2차원 구조
print(a, b)
a[4] = 10 # 참조를 복사했기 때문에 동일한 객체 참조함
print(a, b)