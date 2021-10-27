'''

클라이언트
 - 서버에 접속
 - 접속이 되면 "수신 시작"
 - 수신된 데이터를 파일로 순차적으로 저장
 - 접속이 끊기면 프로그램 종료
 - 다운로드 된 파일 확인 ( 이미지 열기 )

'''

import socket

# 서버 접속
HOST = "slogs.dev"
PORT = 30000

client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

client_socket.connect((HOST, PORT))
print("서버 접속 성공!")

'''
# 테스트 텍스트 보내기
send_message = input("보낼 텍스트 입력 : ")
client_socket.send(send_message.encode('utf-8'))
client_socket.close()
'''


# 이미지 받아오는 코드 
# 서버로부터 데이터 수신
recv_data = client_socket.recv(1024)

# 서버에서 데이터를 받지 못한다면
if not recv_data:
    print("파일이 없음")

else:
    with open("recvImg.jpg", 'wb') as f:
        try:
            while recv_data:
                f.write(recv_data)
                recv_data = client_socket.recv(1024)

        except Exception as ex:
            print("오류 발생 %s" % ex)

print("파일 수신 완료")

client_socket.close()
print("Good Bye!")