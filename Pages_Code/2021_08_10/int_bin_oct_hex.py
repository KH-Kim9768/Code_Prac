number = 82

binary = bin(number)
octal = oct(number)
hexa = hex(number)

print("%s, %s, %s" % (binary, octal, hexa))
print(str(number))

binary = int('0b0111011', 2)
octal = int('0o21562', 8)
hexa = int('0xFA21BC', 16)

print("%d, %d, %d" % (binary, octal, hexa))

binary = format(number, '#b')
octal = format(number, '#o')
hexa = format(number, '#x')

print("%s, %s, %s" % (binary, octal, hexa))