from flask import Flask
from flask_restx import Api, Resource
import RPi.GPIO as GPIO
import time
import threading



GPIO.setmode(GPIO.BCM)

LED1 = 17
SW1 = 27

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
        global LED1
        openAndCloseDoor()


def timerSet(t):
    global setTimer
    time.sleep(5)
    setTimer = False
    

def blink(bcm1):
    global setTimer
    global stateList
    global cnt

    setTimer = True
    LEDSTATE = True

    
    timerThread = threading.Thread(target=timerSet, args=(5,))
    timerThread.start()
    while setTimer:
        GPIO.output(bcm1, LEDSTATE if GPIO.HIGH else GPIO.LOW)
        LEDSTATE = not LEDSTATE
        time.sleep(0.2)
        
def openAndCloseDoor():
    global state
    global LED1
    try:
        blink(LED1)
        state = 'opening'
        time.sleep(5)

        state = 'open'
        GPIO.output(LED1, GPIO.HIGH)
        time.sleep(3)
        
        blink(LED1)
        state = 'closing'
        time.sleep(5)

        state = 'close'
        GPIO.output(LED1, GPIO.LOW)

    except KeyboardInterrupt:
        pass

def interruptswitch(sw):
    openCloseThread = threading.Thread(target=openAndCloseDoor)
    openCloseThread.start()
    

GPIO.add_event_detect(SW1, GPIO.FALLING, callback = interruptswitch, bouncetime = 1000)


if __name__ == "__main__":
    app.run(debug=True, host='0.0.0.0', port=30000)

GPIO.cleanup()
        