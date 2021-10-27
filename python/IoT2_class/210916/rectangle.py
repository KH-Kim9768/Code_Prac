'''

N을 입력해서 가로N * 세로N인 "#"으로 이루어진 상자를 출력하라

'''

def draw_rectangle(num, blank = False):
    for i in range(num):
        for j in range(num):
            condition = i == 0 or i == num -1 or j == 0 or j == num-1
            if (condition if blank else True):
                print("#" , end = "")
            else:
                print(" ", end = "")
            
        print()


def draw_x_rectangle(num, reverse = False):
    for i in range(num):
        for j in range(num):
            condition = i == 0 or i == num -1 or j == 0 or j == num-1 or i == j or j == num-1 - i
            if (not condition if reverse else condition):
                print("#" , end = "")
            else:
                print(" ", end = "")
        print()


# main start
if __name__ == "__main__":
    num = int(input("숫자 입력 : "))
    draw_rectangle(num)
    print()
    draw_rectangle(num, True)
    print()
    draw_x_rectangle(num)
    print()
    draw_x_rectangle(num, True)