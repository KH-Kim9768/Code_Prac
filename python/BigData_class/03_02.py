
import numpy as np

print(np.random.rand(2,5))
print(np.__version__)

a = np.array([1,2,3])

# 객체의 차원
print(a.ndim)

# 리스트 배열 차이 -> 다른 데이터형을 리스트[ , , ] 형태로 모아놓은것
# 튜플 -> ( , , ) 형태, 튜플은 데이터 변형이 불가하다 (읽기전용)
# 딕셔너리 -> { k:v, k:v, k:v } 

# 객체의 형태
print(a.shape)

# 객체의 내부자료형
print(a.dtype)

# a의 내부자료형이 차지하는 메모리 바이트 단위 int32 -> 4바이트
print(a.itemsize)

# 객체의 크기(항목의 수)
print(a.size)

b = np.array([[1,2], [10,20]])
print(b)
print(b.shape)
print(b.ndim)
print(b.size)
print(b.itemsize)
print(b.dtype)