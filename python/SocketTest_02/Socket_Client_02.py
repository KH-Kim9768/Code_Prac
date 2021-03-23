from socket import *
from os.path import exists
import os
import sys
from picamera import PiCamera
import time

# 함수 - 사진 캡처
"""
def cap_img(filename):
    camera.capture(filename)
    
"""

# 변수 선언
data_transferred = 0

# 서버와 연결
clientSocket = socket(AF_INET, SOCK_STREAM)
clientSocket.connect(('127.0.0.1', 9002))

print("연결에 성공했습니다.")

'''# 카메라 생성
with picamera.PiCamera() as camera:
    # 카메라 해상도 설정
    camera.resolution = (1024, 768)
'''

camera = PiCamera()
camera.resolution = (1024, 768)

select_mode = 0

# 메인 루프
while True:

    # 모드 선택
    try:
        select_mode = int(input("모드를 선택하세요(0. 종료  1. 사진 찍고 전송) : "))
    except Exception as ex:
        print(ex + "\n")
        print("모드 선택 과정에서 오류 발생함!")
        continue


    # 0 : 프로그램 종료
    if select_mode == 0:
        break


    # 1 : 사진 찍고 서버에 전송
    elif select_mode == 1:
        # 파일명 입력받음
        filename = input("파일명을 입력하세요(확장자 제외) : ")
        filename = filename + '.jpg'

        
        # 파일명 전송
        try:
            clientSocket.sendall(filename.encode('utf-8'))
        except Exception as ex:
            print(ex)
            print("파일명 전송과정 오류")
            continue
        

        #사진 찍음
        #cap_img(filename)
        camera.capture(filename)
        time.sleep(6)

        if not exists(filename):
            print("no file, 사진 파일 없음")
            sys.exit()

        #사진찍음
        #os.system('raspistill -o ' + filename)

        with open(filename, 'rb') as f:
            try:
                data = f.read(1024)
                while data:
                    data_transferred += clientSocket.send(data)
                    data = f.read(1024)

            except Exception as ex:
                print(ex)
                print("파일 전송 단계 오류")
        
        print("전송완료 %s, 전송량 %d" %(filename, data_transferred))

        
