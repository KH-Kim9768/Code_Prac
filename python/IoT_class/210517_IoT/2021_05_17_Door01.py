from flask import Flask
from flask_restx import Api, Resource
import RPi.GPIO as GPIO
import time
import threading



GPIO.setmode(GPIO.BCM)

LED1 = 17
SW1 = 27
timer_state = 0

GPIO.setup(LED1, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(SW1, GPIO.IN, pull_up_down = GPIO.PUD_UP)

app = Flask(__name__)
api = Api(app)

state = 'close'
stateList = ['open', 'opening', 'closing', 'close']
cnt = 0
setTimer = True

@api.route('/door')
class door(Resource):
    def get(self):
        global state

        return {"Current State" : state}

    def put(self):
        putThread = threading.Thread(target=openAndCloseDoor)
        putThread.start()
        return "Door open"



def timer(t):
    global timer_state


    timer_state = 0
    time.sleep(5)
    
    timer_state = 1
    time.sleep(3)

    timer_state = 2
    time.sleep(5)

    timer_state = 3
    time.sleep(0.2)

    timer_state = 4
    
        
def openAndCloseDoor():
    global state
    global LED1
    global timer_state
    LEDSTATE = False
    
    try:
        timer_state = 0
        timeThread = threading.Thread(target=timer, args=(5,))
        timeThread.start()
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
            elif timer_state == 4:
                break

            if timer_state == 0 or timer_state == 2:
                GPIO.output(LED1, LEDSTATE if GPIO.HIGH else GPIO.LOW)
                LEDSTATE = not LEDSTATE
                time.sleep(0.2)
            
    except KeyboardInterrupt:
        pass


def interruptswitch(sw):
    openCloseThread = threading.Thread(target=openAndCloseDoor)
    openCloseThread.start()
    

GPIO.add_event_detect(SW1, GPIO.FALLING, callback = interruptswitch, bouncetime = 1000)


if __name__ == "__main__":
    app.run(debug=True, host='0.0.0.0', port=30000)

GPIO.cleanup()
        