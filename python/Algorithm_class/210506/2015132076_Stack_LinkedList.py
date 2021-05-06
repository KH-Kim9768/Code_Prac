'''

단순 연결리스트를 이용한 스택 구현

2015132076 김광희

'''

# 단순 연결 리스트 노드 클래스
class Node():
    def __init__(self):
        self.data = None
        self.link = None

# 스택 클래스
class Stack():
    def __init__(self):
        self.top = None
    
    # 스택 push()
    def push(self, inputData):
        
        newNode = Node()
        newNode.data = inputData    # 입력받은 데이터를 새 노드.data에 저장

        # 스택이 비어있을 경우
        if self.top == None:
            self.top = newNode      # 스택이 비어있을 경우 새 노드가 top이 됨

        # 스택이 비어있지 않을 경우
        else :
            newNode.link = self.top # 새로운 노드의 link는 이전의 top을 연결
            self.top = newNode      # 새로운 top = newNode

    # 스택 pop()
    def pop(self):
        if self.top == None:
            print("비어있는 스택입니다")
            return
        
        popNode = self.top          # 맨 위 Node 꺼내옴
        self.top = self.top.link    # top.link를 top에 저장
        
        print(popNode.data, " 가 POP 되었음")
        del(popNode)
        
    # 스택 print
    def printStack(self):
        if self.top == None:
            print("비어있는 스택입니다")
            return

        current = self.top
        while current != None:
            print(current.data, end = ' ')
            current = current.link
        print()

# 메인
if __name__ == '__main__':
    st = Stack()

    print("스택 프로그램입니다")
    while True:
        mode = input("모드를 선택하세요 (0. 종료, 1. PUSH, 2. POP, 3. 스택출력) : ")
        
        # 종료
        if mode == "0":
            print("프로그램을 종료합니다")
            break

        # 스택 push()
        elif mode == "1":
            inputData = input("데이터 입력 : ")
            st.push(inputData)
            st.printStack()
        
        # 스택 pop()
        elif mode == "2":
            st.pop()
            st.printStack()
        
        # 스택 출력
        elif mode == "3":
            st.printStack()

        else:
            print("잘못된 입력입니다")