'''
이진탐색트리를 파이썬으로 구현하기

기능 1: 노드 입력
기능 2: 특정값 탐색
기능 3: 전체 노드를 pre-order로 순회하기
프로그램 처음과 각 단락마다 주석달기

2015132076 김광희
'''

# Node 클래스
class Node:
    def __init__(self, data = None): # data 매개변수 입력시 data에 입력, 입력 안할 시 None
        self.llink = None
        self.data = data
        self.rlink = None

# 
class BinarySearchTree:
    def __init__(self):
        self.root = None
    
    # 기능 1 : 노드 입력
    def insertNode(self, data):
        newNode = Node(data) # 받아온 데이터 newNode 생성
        
        if self.root == None:   # root가 없으면(트리가 비어있으면) root = newNode
            root = newNode
    
    # 기능 2 : 특정 값 탐색
    def searchNode(self, data):
        
        if self.root == None:   # root가 없으면 None 리턴
            return None

    # 기능 3 : 전체 노드를 pre-order로 순회하기
    def printTree(self):
        print()


# main()
if __name__ == "__main__":
    BST = BinarySearchTree()

    while True:
        mode = input("모드를 선택하세요 (0 : 종료, 1 : 노드 입력, 2: 특정 값 탐색, 3 : 전체 노드 순회)")

        # 종료
        if mode == "0":
            print("종료합니다")
            break
        
        # 입력
        elif mode == "1":
            try:
                input_data = int(input("데이터(숫자)를 입력하세요(입력모드) : "))
                BST.insertNode(input_data)

            except Exception as e:
                print(e)
                print("잘못된 데이터를 입력했습니다. 모드 선택으로 돌아갑니다.")
                continue
        
        # 탐색
        elif mode == "2":
            try:
                input_data = int(input("데이터(숫자)를 입력하세요(탐색모드) : "))
                BST.searchNode(input_data)

            except Exception as e:
                print(e)
                print("잘못된 데이터를 입력했습니다. 모드 선택으로 돌아갑니다.")
                continue

        elif mode == "3":
            BST.printTree()
        
        else :
            print("잘못된 입력입니다. 모드 선택으로 돌아갑니다.")
            
