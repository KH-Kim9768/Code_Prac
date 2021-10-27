def show(message):
    print(message)



for i in range(2, 10):
    for j in range(1, 10):
        message = "{} * {} = {}".format(i, j, i*j)
        show(message)
    print()