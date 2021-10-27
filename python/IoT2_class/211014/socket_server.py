'''
소켓프로그래밍

TCP : 연결/연결보장/ 보내는 데이터가 데이터그램을 넘어가도 됨(내부적으로 처리됨)
보내는 대로(순서 등) 받음

UDP : 비연결/연결보장x 데이터그램으로 보내야함
받는 순서 다를 수 있음

'''

import socket

# 서버 코드
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# 주소를 다시 사용하겠다( 비정상 종료 시 기존 포트 사용 불가능 현상 수정 코드 )
s.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)

# 127.0.0.1 = localhost, 내부에서는 접근되나 외부에서는 접근 안됨 -> 테스트를 위한 용도, 또는 내부 서비스 활용 용도
# 0.0.0.0 = 외부에서 접근 가능한 IP
# 방화벽에서 포트는 개방되어 있어야 함

s.bind(('127.0.0.1', 30000))
s.listen(0)
c, addr = s.accept()
print("{}, {}".format(c, addr))

data = c.recv(1024)
print("받은 데이터 : {}".format(data.decode()))

c.close()
s.close()