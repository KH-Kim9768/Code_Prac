import numpy as np

a = np.array([[3,2,-2,0,1], [2,-3,4,5,2,], [1,1,-2,-3,2]])
print(a)
print(a[2,1], a[-1,3], a[0, -2]) # -1은 뒤에서 첫번째
print(a[2])
print(a[-2])
print(a[:, 3])
print(a[1, 1:3]) # 1:3 => 1, 2 (3 미만)
print(a[:, 1:])  # 모든 행의 1번 인덱스 부터 끝까지
print(a[:, :3])
print(a[1,3], a[1][3])


a = np.array([1,2,3,4,5])
b = np.array([0, -1, 2, 6, 1])

print(3*a)
print(a**2)
print(a+b)
print(a-b)
print(a+b)
# print(a/b) # 나누기 조심
print(b<0)

a = np.array([[3,2,-2,0,1], [2,-3,4,5,2,], [0,1,-2,-3,2]])
print(a.sum())
print(a.sum(axis=0)) # 0축 == 아마 x축
print(a.sum(axis=1)) # 1축 == y축 느낌

print(a.max(axis=0))
print(a.max(axis=1))
print(a.cumsum(axis=0))

positive = a>0
print(positive)

b = a[positive]
print(b)
print(b.sum())

a = np.array([1,2,3])
b = np.array([4,5,6])
c = np.array([[7,8,9], [1,4,7]])
x = np.vstack([a,b])
print(x)

a = np.array([1,2,3,4,5])
b = np.array([0, -1, 2, 6, 1])
c = np.array([np.pi/2, np.pi, np.pi*2])
print(c)
print(np.add(a, b))

print(np.log10(a))
print(np.sin(c))
print(np.left_shift(a, 1))
print(np.left_shift(a, 2))

print(np.greater(a, b))
print(np.maximum(a,b))
print(c.round(2))

a = np.array([[1,2,3,4], [0,1,2,3], [-1,0,1,2]])
b = np.array([[1,1,2,2]])
print(a+b)

a = np.array([[4,2], [2,7], [-2, 1]])
c = np.array([[1,-2, 3], [5, 0, 2]])
res = np.matmul(a,c)
print(res)

