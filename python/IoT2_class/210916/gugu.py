def show(num):
    for i in range(1, 10):
        if num % 2 == 1:
            print(" %d X %d = %d" % ( num, i, num*i ))
        else:
            print("%d X %d = %d" % ( num, i, num*i ))
    print()


if __name__ == "__main__":
    for i in range(2, 10):
        show(i)
        