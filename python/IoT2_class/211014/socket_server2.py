# UDP 실습
# UDP는 연결이 없음

from socket import *

serverPort = 30000

# SOCK_STREAM 은  연결이 되어있지만 SOCK_DGAM
serverSocket = socket(AF_INET, SOCK_DGRAM)
serverSocket.bind("slogs.dev", 30000)
print("서버에서 수신할 준비가 완료되었습니다")

try:
    while True:
        m, a = serverSocket.recvfrom(8192)
        print("%s" % m.decode())

except Exception as e:
    print("오류 발생 >> %s" % e)

except KeyboardInterrupt:
    serverSocket.close()

serverSocket.close()

print("서버 종료")