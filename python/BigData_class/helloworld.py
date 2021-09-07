a = 100
b = 50
result = 150

print(a, "+", b, "=", a+b)
print(a, "-", b, "=", a-b)
print(a, "*", b, "=", a*b)
print(a, "/", b, "=", a/b)
print(type(a))


s1, s2, s3 = "100", "100.123", "9999"
s1 = int(s1) + 1
s2 = float(s2) + 1
s3 = int(s3) + 1

print("%d, %f, %d" % (s1, s2, s3))

a = 100
a = str(a) + "1"
print(a)

print(10/3)
print(10//3)

a, b = 100, 200

print(a is not b)