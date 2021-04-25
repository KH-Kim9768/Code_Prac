from flask import Flask                 # 서버 구현을 위한 Flask 객체 import
from flask_restx import Api, Resource   # Api 구현을 위한 Api 객체 import
import RPi.GPIO as GPIO
import time

'''

RESTful 기반 이용한 웹 API 구현
구현 목표 (최종 목표 과제 완료)
저번주까지 구현한 결과에서, 다음의 웹 서비스를 구현한다.

1. int GetLedState()
    - API : /led
    - 반환값 { "Response" : 0 or 1 or 2 or 3 }

2. int SetLedState(int state)
    - API : /led/3

3. void Reset()
    - API : /reset

'''

cnt = 0
cnt_state = cnt % 4

# GPIO Setup
GPIO.setmode(GPIO.BCM)

LED1 = 17
LED2 = 27
SW1 = 6
SW2 = 13

# LED setup
GPIO.setup(LED1, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(LED2, GPIO.OUT, initial=GPIO.LOW)

#SWITCH setup
GPIO.setup(SW1, GPIO.IN, pull_up_down = GPIO.PUD_UP)
GPIO.setup(SW2, GPIO.IN, pull_up_down = GPIO.PUD_UP)


app = Flask(__name__)   # Flask 객체 선언, 파라미터로 어플리케이션 패키지의 이름을 넣어줌
api = Api(app)          # Flask 객체에 Api 객체 등록


'''
@api.route('/hello')  # 데코레이터 이용, '/hello' 경로에 클래스 등록
class HelloWorld(Resource):
    def get(self):  # GET 요청시 리턴 값에 해당 하는 dict를 JSON 형태로 반환
        return {"hello": "world!"}
'''

@api.route('/led')
class GetLedState(Resource):
    def get(self):
        global cnt_state

        return {"Response" : cnt_state}

@api.route('/led/<int:state>')  # /led/3 -> 복수개의 LED에서 ID가 3인 LED의 상태를 질의
class SetLedSTate(Resource):
    def put(self, state):   # 원래는 값을 변경하는 것이기 때문에 RESTful - 'PUT'으로 해야함
        global cnt_state
        global cnt

        cnt = state
        cnt_state = cnt % 4

        setLED(LED1, LED2, cnt_state)

        return {"Response" : cnt_state}

@api.route('/reset')
class Reset(Resource):
    def get(self):
        global cnt
        
        cnt = 0
        cnt_state = cnt % 4
        setLED(LED1, LED2, cnt_state)
        
        return {"Response" : "OK"}


# LED 설정
def setLED(bcm1, bcm2, count):

    led1 = (count & 0b10) >> 1
    led2 = count & 0b01

    GPIO.output(bcm1, led1 if GPIO.HIGH else GPIO.LOW)
    GPIO.output(bcm2, led2 if GPIO.HIGH else GPIO.LOW)

    print(f'{led1}, {led2}')

def SWLED(sw):
    global SW1
    global cnt
    global cnt_state

    try:
        if sw == SW1:
            print("스위치1 입력(카운트 증가)")
            cnt += 1
            cnt_state = cnt % 4
            setLED(LED1, LED2, cnt_state)
            
        
        elif sw == SW2:
            print("스위치2 입력(카운트 초기화)")
            cnt = 0
            cnt_state = cnt % 4
            setLED(LED1, LED2, cnt_state)
            
            
    except KeyboardInterrupt:
        pass

GPIO.add_event_detect(SW1, GPIO.FALLING, callback = SWLED, bouncetime = 1000)
GPIO.add_event_detect(SW2, GPIO.FALLING, callback = SWLED, bouncetime = 1000)

if __name__ == "__main__":
    app.run(debug=True, host='0.0.0.0', port=30000)

GPIO.cleanup()
