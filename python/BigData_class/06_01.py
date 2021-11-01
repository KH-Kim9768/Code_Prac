

a = [5, 2, 3, 8, 2]
b = (5, 2, 3, 8, 2)
c = {1:"bokok", 5:"notebook", 3:"pencil", -3:"eraser", "as":120, 12.2:50}
d = set([5, 2, 3, 8, 2])

print(type(a), type(b), type(c), type(d))
print(a,b,c,d, sep = '\n')

# b[2] = -3 # tuple이라 변경 불가능

a = [5, 2, 3, ['pencil', 4, -2, 2], "book"]

print(a[2], a[3], a[4])
print(a[3][2], a[4][1]) # numpy array의 a[3,2] 형식은 안됨
print(a[1:4], a[:-1], a[2:], sep = '\n') # a[:-1] == a[:4]
print(a[3][1:], a[4][:3])

print(c[-3], c[5], c["as"], c[12.2])
# print(c[2]) # KeyError: 2 => 2라는 key가 없기 때문에 Error 발생


x = [1, 2, "pen"]
y = [-2, 1]

print(3*x) # *는 반복 연산자
print(y + x) # +는 연결 연산자


z = [1, 2, 3, 4]
z.append(-7)
print(z)

z.insert(1, -7)
print(z)

z.remove(-7)
print(z)

v = z.pop(2)
print(v, z)

print(z.pop())
print(z)


# 리스트 내포 - list comprehension
x2 = [i*i for i in range(10)]
'''
위 내용은 아래와 같다
x2 = []
for i in range(10):
    x2.append(i*i)
'''
print(x2)

x3 = [[i,j*2] for i in [10, 2, 3, 1] for j in [2, 4]]
print(x3)

x4 = [[i, j*2] for i in[10, 2, 3, 1] for j in [2, 4] if i != j] # i == j 가 되는 i=2, j=2 가 빠짐
print(x4)


