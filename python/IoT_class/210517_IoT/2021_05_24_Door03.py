from flask import Flask
from flask_restx import Api, Resource
import RPi.GPIO as GPIO
import time
import threading



GPIO.setmode(GPIO.BCM)

LED1 = 17
SW1 = 27
timer_state = None # 0 : opening / 1 : open / 2 : closing / 3 : close
print("set state None") 
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
        global timer_list
        
        for thread in timer_list:
            thread.setFlag_False()

        for thread in timer_list:
            thread.join()

        for thread in timer_list:
            del[thread]

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
            print("(timer)set state 3")
            timer_list.clear()

    def setFlag_False(self):
        self.flag = False
        print(threading.current_thread(), " setFlag False")
        
        
        
def openAndCloseDoor():
    global state
    global LED1
    global timer_state
    LEDSTATE = False
    cnt = 0

    try:
        while True:
            if timer_state == 0:
                state = 'opening'
                for i in range(0, 25):
                    GPIO.output(LED1, LEDSTATE if GPIO.HIGH else GPIO.LOW)
                    LEDSTATE = not LEDSTATE
                    time.sleep(0.2)
            if timer_state == 1:
                state = 'open'
                GPIO.output(LED1, GPIO.HIGH)
            if timer_state == 2:
                state = 'closing'
                for i in range(0, 25):
                    GPIO.output(LED1, LEDSTATE if GPIO.HIGH else GPIO.LOW)
                    LEDSTATE = not LEDSTATE
                    time.sleep(0.2)
            if timer_state == 3:
                state = 'close'
                GPIO.output(LED1, GPIO.LOW)
            
            
            
            cnt += 1
            if (cnt % 100000) == 0:
                print(threading.current_thread, "timer_state : ", timer_state)

            # if timer_state == 0 or timer_state == 2:
            #     GPIO.output(LED1, LEDSTATE if GPIO.HIGH else GPIO.LOW)
            #     LEDSTATE = not LEDSTATE
            #     time.sleep(0.2)
            
    except KeyboardInterrupt:
        GPIO.cleanup()
        pass



def interruptswitch(sw):
    print("SW EVENT DETECTED!")
    for i in timer_list:
        i.join()
    
    timer_thread = Timer_Thread()
    timer_thread.start()
    print(timer_thread, "Start!")
    timer_list.append(timer_thread)



if __name__ == "__main__":
    timer_state = 3
    GPIO.add_event_detect(SW1, GPIO.FALLING, callback = interruptswitch, bouncetime = 1000)
    openAndCloseDoor_thread = threading.Thread(target = openAndCloseDoor)
    openAndCloseDoor_thread.start()
    app.run(debug=False, host='0.0.0.0', port=30000)

GPIO.cleanup()
