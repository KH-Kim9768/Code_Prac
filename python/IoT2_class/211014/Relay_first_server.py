

from socket import *


Host = "127.0.0.1"
Port = 30002

messages = ["Hello from Server1", "Good Bye from Server1"]

# 서버 코드
server_socket = socket(socket.AF_INET, socket.SOCK_STREAM)

# 주소를 다시 사용하겠다( 비정상 종료 시 기존 포트 사용 불가능 현상 수정 코드 )
server_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)


server_socket.bind((Host, Port))
server_socket.listen(0)

client, addr = server_socket.accept()
print("{}, {}".format(client, addr))

for message in messages:
    client.send(message)


client.close()
server_socket.close()
