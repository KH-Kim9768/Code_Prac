from socket import *
from os.path import exists
import os
import sys

# 참고사이트 : https://foxtrotin.tistory.com/278

serverSocket = socket(AF_INET, SOCK_STREAM)
serverSocket.bind(('', 9002))
serverSocket.listen(1)

connectionSocket, addr = serverSocket.accept()

print(str(addr), '에서 접속했습니다.')


while True:
       
    data = connectionSocket.recv(1024)
    
    
    try:
        filename = data
        print("받는파일명 : ", filename)
    except Exception as ex:
        print(ex)
        print("파일명 받는 과정 오류")
        continue
    
    
    nowdir = os.getcwd()
    
    # 데이터 받음
    data = connectionSocket.recv(1024)
    data_transferred = 0
    with open(nowdir+"\\"+filename.decode('utf-8'), 'wb') as f:
        try:
            while data:
                f.write(data)
                data_transferred += len(data)
                data = connectionSocket.recv(1024)
        except Exception as ex:
            print(ex)
            print("파일 받는 과정 오류")

    print("파일 %s 받기 완료. 전송량 %d" %(filename, data_transferred))


