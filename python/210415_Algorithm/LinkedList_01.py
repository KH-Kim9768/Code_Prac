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
    

## 전역 변수 선언 부분 ##

head, current, pre = None, None, None
dataArray = [["지민", "010-1111-1111"], ["정국", "010-2222-2222"], ["뷔", "010-3333-3333"], ["슈가", "010-4444-4444"], ["진", "010-5555-5555"]]

## 메인 코드 부분 ##
if __name__ == "__main__" :

    while True:
        mode = int(input("모드를 선택하세요 (0. 종료, 1. 입력, 2. 수정, 3. 삭제, 4. 탐색) : "))

        # 종료
        if mode == 0:
            break;

        # 입력모드
        elif mode == 1:
            #
            namedata = input("추가할 노드의 이름을 입력하세요 : ")
            phonedata = input("추가할 노드의 핸드폰번호를 입력하세요 : ")

            nodedata = [namedata, phonedata]    # 입력받은 데이터를 리스트 형태로 만듬

            makeSimpleLinkedList(nodedata)
        


'''
	for data in dataArray :
		makeSimpleLinkedList(data)

	printNodes(head)
'''