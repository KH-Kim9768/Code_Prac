'''

210415 알고리즘 과제

0. 입력/수정/탐색/삭제/종료 기능을 출력하고  사용자가 기능 선택하기
1.  입력 : 이름, 전화번호 입력받아 연결리스트에 이름순으로 저장되게 삽입
2.  수정 : 이름으로 찾아서 전화번호 수정
3.  삭제 : 이름으로 찾아서 해당 자료 삭제
4.  탐색 :  특정이름의 전화번호 찾아 출력하기

자료의 저장은 예제를 응용해서 이름순으로 저장되는 단순 연결리스트로 해야 함

2015132076 김광희

'''

## 클래스와 함수 선언 부분 ##
class Node() :
    def __init__ (self) :
        self.data = None
        self.link = None

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

def makeSimpleLinkedList(namePhone) :
	global  head, current, pre
	#printNodes(head)

	node = Node()
	node.data = namePhone
	
	if head == None :			# 첫 번째 노드일 때
		head = node
		return

	if head.data[0] > namePhone[0] :	# 첫 번째 노드보다 작을 때
		node.link = head
		head = node
		return

	# 중간 노드로 삽입하는 경우
	current = head
	while current.link != None :
		pre = current
		current = current.link
		if current.data[0] > namePhone[0]:
			pre.link = node
			node.link = current
			return

	# 삽입하는 노드가 가장 큰 경우
	current.link = node


# 수정모드
def editnode(name):
    global head

    temp_node = Node()  # 빈 노드 생성
    temp_node = head

    if temp_node == None:
        print("연결리스트가 비어 있습니다.")
        return

    while temp_node != None:    # not null
        if name == temp_node.data[0]:
            break;
        
        else :
            if temp_node.link == None:  # 노드의 link가 비어있으면 다음 노드가 없는것 이므로 해당 연락처가 없는 것
                print("해당 연락처를 찾을 수 없습니다.(수정모드)")
                return

            temp_node = temp_node.link
    
    change_number = input(name + "의 변경할 연락처를 입력하세요 : ")
    temp_node.data[1] = change_number

    print(temp_node.data)


# 삭제모드
def deletenode(name):
    global head, current, pre

    if head == None:
        print("연결리스트가 비어 있습니다.")
        return

    elif head.data[0] == name:  # head가 삭제 할 사람이면 head.link(다음 노드) 를 head로 만듬
        current = head
        head = head.link
        del(current)
        print("삭제 완료")
        return

    else :
        current = head
        while current != None: # not null
            pre = current
            current = current.link

            if current.data[0] == name: # current.data가 삭제할 이름이면 pre.link를 다음 노드(current.link)로 바꿈
                pre.link = current.link
                del(current)
                print("삭제 완료")
                break
                
            elif current.link == None:
                print("해당 연락처를 찾을 수 없습니다.(삭제모드)")
                return
    

# 탐색 모드
def searchnode(name):
    global head, current, pre

    temp_node = Node()
    temp_node = head
    
    if temp_node == None:
        print("연결리스트가 비어 있습니다.")
        return
            
    while temp_node != None:    # not null
        if name == temp_node.data[0]:
            break;
        
        else :
            if temp_node.link == None:  # 노드의 link가 비어있으면 다음 노드가 없는것 이므로 해당 연락처가 없는 것
                print("해당 연락처를 찾을 수 없습니다.(탐색모드)")
                return

            temp_node = temp_node.link
    
    print(temp_node.data)


    

## 전역 변수 선언 부분 ##

head, current, pre = None, None, None


## 메인 코드 부분 ##
if __name__ == "__main__" :

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

            makeSimpleLinkedList(nodedata)
        
        # 수정모드
        elif mode == "2":
            inputname = input("수정할 연락처 이름을 입력하세요 : ")
            editnode(inputname)

        # 삭제모드
        elif mode == "3":
            inputname = input("삭제할 연락처 이름을 입력하세요 : ")
            deletenode(inputname)

        # 탐색모드
        elif mode == "4":
            inputname = input("탐색할 연락처 이름을 입력하세요 : ")
            searchnode(inputname)
            
        # 전체 출력모드
        elif mode == "5":
            printNodes(head)
        
        else :
            print("잘못된 입력입니다.")
            
