from flask import Flask
from flask_restx import Api, Resource
import RPi.GPIO as GPIO
import time
import threading



GPIO.setmode(GPIO.BCM)

lock = threading.Lock()
LED1 = 17
SW1 = 27
timer_state = 3 # 0 : opening / 1 : open / 2 : closing / 3 : close 
timer_list = []
state = 'close'
stateList = ['open', 'opening', 'closing', 'close']


GPIO.setup(LED1, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(SW1, GPIO.IN, pull_up_down = GPIO.PUD_UP)

app = Flask(__name__)
api = Api(app)



@api.route('/door')
class door(Resource):
    def get(self):
        global state
        global timer_state
        return {"Current State" : state,
        "timer_state" : timer_state}

    def put(self):
        for thread in timer_list:
            thread.setFlag_False()
            thread.join()

        timer_list.clear()

        timer_thread = Timer_Thread()
        timer_thread.start()
        timer_list.append(timer_thread)

        return "Force open Door"


class Timer_Thread(threading.Thread):
    def __init__(self):
        super().__init__()
        self.flag = True
    
    def run(self):
        global timer_state
        lock.acquire()

        if self.flag:
            timer_state = 0
            time.sleep(5)

        if self.flag:
            timer_state = 1
            time.sleep(3)

        if self.flag:
            timer_state = 2
            time.sleep(5)

        if self.flag:
            timer_state = 3
            timer_list.clear()

        lock.release()
    def setFlag_False(self):
        self.flag = False
        print(threading.current_thread(), " setFlag False")
        
        
        
def openAndCloseDoor():
    global state
    global LED1
    global timer_state
    LEDSTATE = False
    
    try:
        while True:
            if timer_state == 0:
                state = 'opening'
            elif timer_state == 1:
                state = 'open'
                GPIO.output(LED1, GPIO.HIGH)
            elif timer_state == 2:
                state = 'closing'
            elif timer_state == 3:
                state = 'close'
                GPIO.output(LED1, GPIO.LOW)

            if timer_state == 0 or timer_state == 2:
                GPIO.output(LED1, LEDSTATE if GPIO.HIGH else GPIO.LOW)
                LEDSTATE = not LEDSTATE
                time.sleep(0.2)
            
    except KeyboardInterrupt:
        pass



def interruptswitch(sw):
    print("SW EVENT DETECTED!")
    timer_thread = Timer_Thread()
    timer_thread.start()
    timer_list.append(timer_thread)

GPIO.add_event_detect(SW1, GPIO.FALLING, callback = interruptswitch, bouncetime = 1000)
openAndCloseDoor_thread = threading.Thread(target = openAndCloseDoor)
openAndCloseDoor_thread.start()

if __name__ == "__main__":
    app.run(debug=True, host='0.0.0.0', port=30000)

GPIO.cleanup()
