import numpy as np

a = np.array([12, 8, 20, 17, 15])
print(a)

a.sort()
print(a)

print(a.shape) # tuple형의 5개의 요소의  데이터

b = np.array([[12,3,4.0], [1,4,5]])
print(b)

print(b.ndim) # 차원
print(b.shape)
print(b.dtype) # 요소의 데이터 형을 알려줌

c = np.array([[[1, 3, 0, 1], [1, 1, 4, 2], [3, 3, 4, 1]], [[2, 1, 2, 1], [1, 0, 1, 0], [1, 5, 6,2]]]) # 3차원 배열
print(c)
print(c.shape)

d = np.zeros([2,3])
print(d)
print(d.dtype)

e = np.random.random([2,5])
print(e)

f = np.arange(1, 20, 2.5)
print(f)

x = 10
y = x
y = 12
print(x, y)

a = np.array([10, 20, 30, 40])
b = a
b[0] = -10
print(a)

c = a.copy()
c[1] = 30
print(a, c)

a = np.array([1, 2, 3, 4, 5, 6])
b = a.reshape([2,3]) # 1차원 구조 -> 2차원 구조
print(a, b)
a[4] = 10
print(a, b)