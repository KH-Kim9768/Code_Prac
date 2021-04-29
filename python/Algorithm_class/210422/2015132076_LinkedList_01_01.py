'''

210415 알고리즘 과제

0. 입력/수정/탐색/삭제/종료 기능을 출력하고  사용자가 기능 선택하기
1.  입력 : 이름, 전화번호 입력받아 연결리스트에 이름순으로 저장되게 삽입
2.  수정 : 이름으로 찾아서 전화번호 수정
3.  삭제 : 이름으로 찾아서 해당 자료 삭제
4.  탐색 :  특정이름의 전화번호 찾아 출력하기
5.  전체출력 : 연결리스트 전체 출력

자료의 저장은 예제를 응용해서 이름순으로 저장되는 단순 연결리스트로 해야 함


210422 추가

전화번호부 입력/수정/삭제/검색/종료 기능을 가진 프로그램작성


- 입력/수정/삭제작업후 전체 전화번호부 내용 출력하기


- 입력한 전화번호자료는 이름순으로 저장함


- 수정/삭제/검색작업시 없는 이름은 에러 메시지 출력


- 수정/삭제 작업 완료시 완료 메시지 출력


- 코딩때 함수명은  작업내용에 맞게,  변수명은 갖는 자료에 맞게 적절하게 네이밍하기

2015132076 김광희

'''

## 클래스와 함수 선언 부분 ##
class Node() :
    def __init__ (self) :
        self.data = None
        self.link = None

# 전체 출력
def printNodes(start) :
    current = start
    if current == None :
        print("연결리스트가 비어 있습니다.")
        return
    print(current.data, end = ' ')
    while current.link != None:
        current = current.link
        print(current.data, end = ' ')
    print()

# 입력모드
def makeSimpleLinkedList(namePhone, head_node) :
    node = Node()
    node.data = namePhone
	
    if head_node == None :  # 첫 번째 노드일 때
	    head_node = node
	    return head_node

    if head_node.data[0] > namePhone[0] :	# 첫 번째 노드보다 작을 때
	    node.link = head_node
	    head_node = node
	    return head_node

	# 중간 노드로 삽입하는 경우
    current = head_node
    while current.link != None :
        pre = current
        current = current.link
        if current.data[0] > namePhone[0]:
            pre.link = node
            node.link = current
            return head_node

	# 삽입하는 노드가 가장 큰 경우
    current.link = node
    return head_node


# 수정모드
def editNode(name, head):
    temp_node = searchNode(name, head)

    if temp_node == None:
        return head
    
    change_number = input(name + "의 변경할 연락처를 입력하세요 : ")
    temp_node.data[1] = change_number

    print(temp_node.data, "수정 완료")
    return head


# 삭제모드
def deleteNode(name, head):
    if searchNode(name, head, True) == None:    # 탐색결과 없으면 return (종료)
        return head
    pre_node, current_node = searchNode(name, head, True)    # searchNode()로 name node 탐색

    if head.data[0] == name:
        delete_node = head
        head = head.link
        del(delete_node)
        print(name, " 삭제완료")
        

    elif current_node != None:
        pre_node.link = current_node.link
        del(current_node)
        print(name, " 삭제완료")
    
    return head


# 탐색 모드, 삭제모드 일 때 delete_mode 매개변수 True 전달
def searchNode(name, head, delete_mode = False):
    current_node = head
    pre_node = None
    
    if current_node == None:    # 연결리스트가 비어있음
        return None
            
    while current_node != None:    # not null
        if name == current_node.data[0]:
            break
        
        else :
            if current_node.link == None:  # 노드의 link가 비어있으면 다음 노드가 없는것 이므로 해당 연락처가 없는 것
                print("해당 연락처를 찾을 수 없습니다.")
                return None

            pre_node = current_node
            current_node = current_node.link

    if delete_mode: # 삭제모드에서 호출 시 pre_node도 return함
        return pre_node, current_node

    elif not delete_mode:   # 삭제모드가 아닌 곳에서 호출 시 current_node 만 return
        return current_node



## 메인 코드 부분 ##
if __name__ == "__main__" :
    head = None

    while True:
        mode = input("모드를 선택하세요 (0. 종료, 1. 입력, 2. 수정, 3. 삭제, 4. 탐색, 5. 전체 출력) : ")

        # 종료
        if mode == "0":
            break;

        # 입력모드
        elif mode == "1":
            #
            namedata = input("추가할 노드의 이름을 입력하세요 : ")
            phonedata = input("추가할 노드의 핸드폰번호를 입력하세요 : ")

            nodedata = [namedata, phonedata]    # 입력받은 데이터를 리스트 형태로 만듬

            head = makeSimpleLinkedList(nodedata, head)
            printNodes(head)
        
        # 수정모드
        elif mode == "2":
            inputname = input("수정할 연락처 이름을 입력하세요 : ")
            head = editNode(inputname, head)
            printNodes(head)

        # 삭제모드
        elif mode == "3":
            inputname = input("삭제할 연락처 이름을 입력하세요 : ")
            head = deleteNode(inputname, head)
            printNodes(head)

        # 탐색모드
        elif mode == "4":
            inputname = input("탐색할 연락처 이름을 입력하세요 : ")
            result_node = searchNode(inputname, head)
            if result_node != None:
                print(result_node.data)
            
        # 전체 출력모드
        elif mode == "5":
            printNodes(head)
        
        else :
            print("잘못된 입력입니다.")
            
