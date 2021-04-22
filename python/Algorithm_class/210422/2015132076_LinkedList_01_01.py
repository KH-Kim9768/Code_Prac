'''

210415 알고리즘 과제

0. 입력/수정/탐색/삭제/종료 기능을 출력하고  사용자가 기능 선택하기
1.  입력 : 이름, 전화번호 입력받아 연결리스트에 이름순으로 저장되게 삽입
2.  수정 : 이름으로 찾아서 전화번호 수정
3.  삭제 : 이름으로 찾아서 해당 자료 삭제
4.  탐색 :  특정이름의 전화번호 찾아 출력하기

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
def editNode(name):
    global head

    temp_node = searchNode(name)

    if temp_node == None:
        return
    
    change_number = input(name + "의 변경할 연락처를 입력하세요 : ")
    temp_node.data[1] = change_number

    print(temp_node.data, "수정 완료")


# 삭제모드
def deleteNode(name):
    global head, current, pre

    temp_node = searchNode(name)    # searchNode()로 name node 탐색

    if head.data[0] == name:
        current = head
        head = head.link
        del(current)
        print(name, " 삭제완료")
        return

    elif temp_node != None:
        pre.link = current.link
        del(current)
        print(name, " 삭제완료")
        return

    
# 탐색 모드
def searchNode(name):
    global head, current, pre

    current = head
    
    if current == None:
        print("연결리스트가 비어 있습니다.")
        return None
            
    while current != None:    # not null
        if name == current.data[0]:
            break
        
        else :
            if current.link == None:  # 노드의 link가 비어있으면 다음 노드가 없는것 이므로 해당 연락처가 없는 것
                print("해당 연락처를 찾을 수 없습니다.")
                return None

            pre = current
            current = current.link
    
    return current


    

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
            printNodes(head)
        
        # 수정모드
        elif mode == "2":
            inputname = input("수정할 연락처 이름을 입력하세요 : ")
            editNode(inputname)
            printNodes(head)

        # 삭제모드
        elif mode == "3":
            inputname = input("삭제할 연락처 이름을 입력하세요 : ")
            deleteNode(inputname)
            printNodes(head)

        # 탐색모드
        elif mode == "4":
            inputname = input("탐색할 연락처 이름을 입력하세요 : ")
            if searchNode(inputname) != None:
                print(searchNode(inputname))
            
            
            
        # 전체 출력모드
        elif mode == "5":
            printNodes(head)
        
        else :
            print("잘못된 입력입니다.")
            
