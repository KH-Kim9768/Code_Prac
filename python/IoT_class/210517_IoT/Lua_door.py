from flask import Flask  # 서버 구현을 위한 Flask 객체 import
from flask_restx import Api, Resource  # Api 구현을 위한 Api 객체 import
import RPi.GPIO as GPIO
import time
import threading

LED = 26
SW = 21

GPIO.setmode(GPIO.BCM)
GPIO.setup(LED, GPIO.OUT)
GPIO.setup(SW, GPIO.IN, pull_up_down=GPIO.PUD_DOWN)

stat = 4
opening = 0
onoff = False

def led_state():
    global onoff
    state = False
    while True:
        if onoff != state:
            GPIO.output(LED, onoff)
            state = onoff
            print("LED : %s" % (str(state)))

def get_door():
    global stat
    stat_arr = ["Close", "Opening", "Open", "Closing"]

    return stat_arr[stat % 4]
    
def set_door():
    global onoff
    global stat

    long = 0
    while True:
        if stat < 4:
            stat += 1
            print("stat : %d" % (stat))
            if stat == 1:
                long = 5
                for i in range(0, long * 5):
                    onoff = not onoff
                    time.sleep(0.2)
            elif stat == 2:
                long = 3
                for i in range(0, long * 5):
                    onoff = True
                    time.sleep(0.2)
            elif stat == 3:
                long = 5
                for i in range(0, long * 5):
                    onoff = not onoff
                    time.sleep(0.2)
            else:
                long = 0


app = Flask(__name__)  # Flask 객체 선언, 파라미터로 어플리케이션 패키지의 이름을 넣어줌.
api = Api(app)  # Flask 객체에 Api 객체 등록

def button():
    global stat
    stat = 0

GPIO.add_event_detect(SW, GPIO.RISING, callback=button)

@api.route('/door')
class Door(Resource):
    def put(self):
        global stat
        stat = 0
        return {"Response": "강제 오픈"}

    def get(self):
        return {"Response": get_door()}

if __name__ == "__main__":
    th = threading.Thread(target=led_state, args=())
    th2 = threading.Thread(target=set_door, args=())
    th.start()
    th2.start()
    app.run(debug=True, host='0.0.0.0', port=80)