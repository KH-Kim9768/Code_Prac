class Node() :
    def __init__ (self) :
        self.data = None
        self.link = None

def pop(top):
    if top == None:
        print("빈스택입니다")
        return top

    delete_node = top
    top = top.link
    print("%s pop합니다\n" %delete_node.data)
    del(delete_node)
    return top

def push(top, new_data):

    node = Node()
    node.data = new_data

    if top == None:
        top = node
        return top

    node.link = top
    top = node
    return top

def printStack(top):
    if top == None:
        print("빈스택입니다")
        return

    current = top
    while current != None:
        print(current.data, end = ' ')
        current = current.link
    print()

if __name__=="__main__":

    top = None
    print("연결리스트를 이용한 스택구현 프로그램입니다.\n")
    while True:
        print("\n1:push\t 2:pop\t 3:스택출력\t 4:종료")
        ch = input("기능선택 -->")
        if ch == '1':
            add_data=(input("입력할 자료:"))
            top = push(top,add_data)
            printStack(top)
        elif ch == '2':
            top = pop(top)
            printStack(top)
        elif ch == '3':
            printStack(top)
        elif ch == '4':
            print("종료합니다\n")
            break