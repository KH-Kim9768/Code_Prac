import numpy as np

# Array는 한 종류의 데이터만 가능
# list는 여러 종류의 데이터 가능

ar1 = np.array([1,2, 3, 4, 5])
print(ar1)
type(ar1)

ar2 = np.array([[10, 20, 30], [40, 50, 60]]) # 2차원 배열
print(ar2)

ar3 = np.arange(1, 11, 2)
print(ar3)

ar4 = np.array([1, 2, 3, 4, 5, 6]).reshape((3,2))
print(ar4)
ar5 = ar4.reshape((2,3))
print(ar5)

ar5_0 = np.zeros((2,3))
print(ar5_0)

ar6 = ar2[0:2, 0:2] # 배열 슬라이싱
print(ar6)

ar7 = ar2[0, :] # 첫 행 출력
print(ar7)
ar7 = ar2[1, :] # 두번째 행 출력
print(ar7)

ar8 = ar1 + 10
print(ar8)
ar8 = ar1 - ar8
print(ar8)

print(ar1 * 2)
print(ar1 / 2)

ar9 = np.dot(ar2, ar4) # 행렬 곱
print(ar9)