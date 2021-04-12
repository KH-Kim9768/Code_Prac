import time
import threading
from queue import Queue

'''

Queue를 이용한 쓰레드간 데이터 통신
참고 사이트
https://jvvp.tistory.com/1155

'''

def sender(q):
    data = [123, 321, 222, 241, 232]
    while data:
        d = data.pop(0)
        q.put(d)
        print(f'sender : {d}')
        time.sleep(1)
    
    q.put(None)
    print('sender done')

def receiver(q):
    while True:
        data = q.get()
        if data is None:
            break
        print(f'receiver : {data}')

    print('receiver done')


if __name__ == '__main__':
    q = Queue()
    t1 = threading.Thread(target=sender, args=(q,))
    t2 = threading.Thread(target=receiver, args=(q,))
    t1.start()
    t2.start()
    