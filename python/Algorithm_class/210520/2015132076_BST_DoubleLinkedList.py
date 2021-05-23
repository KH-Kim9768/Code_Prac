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
     # data 매개변수 입력시 data에 입력, 입력 안할 시 None
    def __init__(self, data = None):
        self.llink = None
        self.data = data
        self.rlink = None

# 이진탐색트리 클래스
class BinarySearchTree:
    # 생성자
    def __init__(self):
        self.root = None
    
    # 기능 1 : 노드 입력
    def insertNode(self, data):
        newNode = Node(data) # 받아온 데이터 newNode 생성
        
        if self.root == None:   # root가 없으면(트리가 비어있으면) root = newNode
            self.root = newNode
            print("입력 완료")
            return

        currentNode = self.root
        while currentNode != None:  # node 입력 루프
            if currentNode.data > newNode.data: # input data가 currentNode.data보다 작은 경우
                if currentNode.llink == None:   # currentNode의 llink가 비어있으면 newNode 지정
                    currentNode.llink = newNode
                    break
                else:
                    currentNode = currentNode.llink # 삽입하려는 data가 더 작기 떄문에 llink 쪽으로 가야함
            
            elif currentNode.data < newNode.data:   # input data가 currentNode.data보다 큰 경우
                if currentNode.rlink == None:       # currentNode의 rlink가 비어있으면 newNode 지정
                    currentNode.rlink = newNode
                    break
                else:
                    currentNode = currentNode.rlink # 삽입하려는 data가 더 크기 때문에 rlink 쪽으로 가야함
            
            elif currentNode.data == data:  # 중복 허용 불가
                print("중복된 값을 입력하면 안됩니다.")
                return
        
        print("입력 완료")


    # 기능 2 : 특정 값 탐색
    def searchNode(self, node, data):
        if self.root == None:   # root가 없으면 None 리턴
            return None
        
        if node == None:        # node가 None면 값이 없음.
            return None

        if node.data == data:   # 값이 같으면 node를 리턴
            return node
        
        elif node.data > data:  # node.data > data 면 node.llink로 탐색
            return self.searchNode(node.llink, data)
        
        elif node.data < data:  # node,data< data 면 node.rlink로 탐색
            return self.searchNode(node.rlink, data)
        
        else : 
            return None

        

    # 기능 3 : 전체 노드를 pre-order로 순회하기
    def traversal_preorder(self, node):

        if self.root == None:
            print("비어있는 트리입니다.")
            return
        

        if node == None: # node가 None이면 return
            return

        print(node.data)
        self.traversal_preorder(node.llink) # pre-order llink 먼저 순회
        self.traversal_preorder(node.rlink) # llink 출력 후 해당 노드의 rlink 출력



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
                result_node = BST.searchNode(BST.root, input_data)

                if result_node != None:    # node 를 리턴 받으면 print
                    print(result_node.data)
                else :
                    print("찾는 값이 없습니다.")

            except Exception as e:
                print(e)
                print("잘못된 데이터를 입력했습니다. 모드 선택으로 돌아갑니다.")
                continue
        
        # preorder 순회
        elif mode == "3":
            BST.traversal_preorder(BST.root)
        
        else :
            print("잘못된 입력입니다. 모드 선택으로 돌아갑니다.")
            
