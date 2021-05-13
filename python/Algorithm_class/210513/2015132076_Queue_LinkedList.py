'''

2015132076 김광희
'''
# 노드 클래스
class Node:
    def __init__(self):
        self.data = None
        self.link = None
    
# 큐 클래스
class Queue:
    def __init__(self): # 큐 생성자 
        self.front = None
        self.rear = None

    def enQueue(self, inputData):   # rear 다음 노드에 새 노드를 삽입
        newNode = Node()
        newNode.data = inputData

        # if self.front == None:
        if self.rear == None:   # rear가 None이면 Queue가 비어있다 (= front == None)
            self.front = newNode
            self.rear = newNode
        
        else:   # rear가 가리키는 노드 다음으로 새 Node 연결
            self.rear.link = newNode
            self.rear = newNode
        
        print("enQueue 완료")
    
    def deQueue(self):  # front가 가리키는 첫 노드를 삭제
        
        if self.front == None:  # 큐가 비어있다.
            # print("비어있는 Queue")
            return
    
        else:   # front Node를 반환하고 frontNode의 다음 노드를 front로 설정
            deleteNode = self.front
            self.front = self.front.link
            if self.front == None:
                self.rear = None

            print(deleteNode.data, " deQueue 완료")
            del(deleteNode)
    
    def printQueue(self):   # 큐 전체 출력
        
        if self.front == None:
            print("비어있는 Queue")
            return
        
        else:
            current = self.front
            while current != None:
                print(current.data, end = ' ')
                current = current.link
            print()
## 메인
if __name__ == '__main__':
    queue = Queue()

    print("Queue 프로그램입니다.")
    while True:
        mode = input("모드를 선택하세요 (0. 종료, 1. enQueue, 2. deQueue, 3. Queue 출력) : ")
        
        # 종료
        if mode == "0":
            print("프로그램을 종료합니다")
            break

        # Queue enQueue()
        elif mode == "1":
            inputData = input("데이터 입력 : ")
            queue.enQueue(inputData)
            queue.printQueue()
        
        # Queue deQueue()
        elif mode == "2":
            queue.deQueue()
            queue.printQueue()
        
        # Queue 출력
        elif mode == "3":
            queue.printQueue()

        else:
            print("잘못된 입력입니다")