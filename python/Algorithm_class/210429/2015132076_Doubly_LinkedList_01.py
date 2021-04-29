'''
이중 연결 리스트
실무에선 순차 리스보다 연결 리스트를 더 많이 쓴다
단순 연결 리스트 보단 이중 연결 리스트를 더 많이 쓴다

0. 입력/수정/탐색/삭제/종료 기능을 출력하고  사용자가 기능 선택하기
1.  입력 : 이름, 전화번호 입력받아 연결리스트에 이름순으로 저장되게 삽입
2.  수정 : 이름으로 찾아서 전화번호 수정
3.  삭제 : 이름으로 찾아서 해당 자료 삭제
4.  탐색 :  특정이름의 전화번호 찾아 출력하기
5.  전체출력 : 연결리스트 전체 출력


2015132076 김광희

'''

class Node():
    def __init__(self):
        self.llink = None
        self.data = None
        self.rlink = None

# 전체 출력
def printNodes(start) :
    current = start
    if current == None :
        print("연결리스트가 비어 있습니다.")
        return
    print(current.data, end = ' ')
    while current.rlink != None:
        current = current.rlink
        print(current.data, end = ' ')
    print()

# 입력 모드
def insertNode(head, insertData):

    newNode = Node()
    newNode.data = insertData

    if head == None:
        head = newNode
        return head

    if head.data[0] > newNode.data[0] :	# 첫 번째 노드보다 작을 때
        newNode.rlink = head
        head.llink = newNode
        head = newNode
        return head

    # 중간 노드로 삽입하는 경우
    current = head
    while current.rlink != None :
        current = current.rlink
        if current.data[0] > newNode.data[0]:
            current.llink.rlink = newNode   # pre.link = newNode
            newNode.rlink = current         # newNode.link = current
            current.llink = newNode         
            return head

    # 삽입하는 노드가 가장 큰 경우
    current.rlink = newNode
    newNode.llink = current
    return head

# 수정 모드
def editNode(head, data_Name):
    edit_Node = searchNode(head, data_Name)

    if edit_Node == None:
        print("수정모드 취소")
        return head

    edit_Phone = input("수정할 연락처를 입력하세요(수정) : ")

    edit_Node.data[1] = edit_Phone

    print(edit_Node.data, " 수정 완료")
    return head

# 삭제 모드
def deleteNode(head, data_Name):
    delete_Node = searchNode(head, data_Name)

    if delete_Node == None:
        print("삭제모드 취소")
        return head
    
    if delete_Node == head:
        head.rlink.llink = None
        delete_HeadNode = head
        head = head.rlink
        del(delete_HeadNode)
        print(data_Name, " 삭제 완료")
        return head

    delete_Node.llink.rlink = delete_Node.rlink # pre.link = current.link
    if delete_Node.rlink != None:
        delete_Node.rlink.llink = delete_Node.llink

    del(delete_Node)
    print(data_Name, " 삭제 완료")
    return head

# 탐색 모드
def searchNode(head, data_Name):
    current = head
    
    if current == None:
        print("이중 연결리스트가 존재하지 않습니다.(탐색)")
        return head

    while current != None:
        if current.data[0] == data_Name:
            return current
        
        elif current.rlink == None:
            print("해당 연락처가 존재 하지 않습니다(탐색)")
            return None
        
        else:
            current = current.rlink

## main()
if __name__ == "__main__":
    head = None

    while True:
        mode = input("모드를 선택하세요 (0. 종료, 1. 입력, 2. 수정, 3. 삭제, 4. 탐색, 5. 전체 출력) : ")
        
        # 종료
        if mode == '0':
            print("종료합니다")
            break
        
        # 입력
        elif mode == '1':
            insert_Data_List = []
            insert_Data_List.append(input("추가할 이름을 입력하세요 : "))
            insert_Data_List.append(input("추가할 전화번호를 입력하세요 : "))
            head = insertNode(head, insert_Data_List)
            printNodes(head)
        
        # 수정
        elif mode == '2':
            data_Name = input("수정할 연락처 이름을 입력하세요 : ")
            head = editNode(head, data_Name)
            printNodes(head)
        
        # 삭제
        elif mode == '3':
            data_Name = input("삭제할 연락처 이름을 입력하세요 : ")
            head = deleteNode(head, data_Name)
            printNodes(head)

        # 탐색
        elif mode == '4':
            data_Name = input("탐색할 연락처 이름을 입력하세요 : ")
            result_node = searchNode(head, data_Name)
            if result_node != None:
                print(result_node.data)
            
        # 전체 출력
        elif mode == '5':
            printNodes(head)
        
        else :
            print("잘못된 입력입니다.")
            