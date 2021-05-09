'''
참고사이트
https://alnova2.tistory.com/1227

'''

# import smbus
# import wiringpi

# PCA9685 기본파일 작성 p149
# pca9685.h
MODE1 = 0x00
PRE_SCALE = 0xFE
LED0_ON_L = 0x06
LED0_OFF_L = 0x08

AI = 0x20
SLEEP = 0x10
RESTART = 0x80

class pca9685_t():
    def __init__(self):
        self.i2c_addr = None
        self.i2c_port = None

# pca9685.cpp , p150
def setupAI(pca9685):
    I2C_PORT = pca9685.i2c_port
    mode1 = 0
    prescale = 0

    mode1 = wiringpi.wiringPiI2CReadReg8(I2C_PORT, MODE1) & 0xFF
    wiringpi.wiringPiI2CWriteReg8(I2C_PORT, MODE1, mode1|AI)

def setFreq(pca9685, frequency):
    I2C_PORT = pca9685.i2c_port
    mode1 = 0
    prescale = 0

    mode1 = wiringpi.wiringPiI2CReadReg8(I2C_PORT, MODE1) & 0xFF
    wiringpi.wiringPiI2CWriteReg8(I2C_PORT, MODE1, mode1|SLEEP)

    prescale = (int)(25000000.0/(4096*frequency))
    
    wiringpi.wiringPiI2CWriteReg8(I2C_PORT, PRE_SCALE, prescale)
    
    mode1 = wiringpi.wiringPiI2CReadReg8(I2C_PORT, MODE1) & 0xFF
    wiringpi.wiringPiI2CWriteReg8(I2C_PORT, MODE1, mode1 & ~SLEEP)
    
    wiringpi.delay(1)

    mode1 = wiringpi.wiringPiI2CReadReg8(I2C_PORT, MODE1) & 0xFF
    wiringpi.wiringPiI2CWriteReg8(I2C_PORT, MODE1, mode1|RESTART)

def setDuty(pca9685, pin, duty_cycle):
    I2C_PORT = pca9685.i2c_port
    chan = pin*4
    duty_off = duty_cycle & 0x1FFF

    wiringpi.wiringPiI2CWriteReg16(I2C_PORT, LED0_OFF_L + chan, duty_off)



# pca9685_motor.cpp, p154
pca9685 = pca9685_t()
pca9685.i2c_addr = 0x40
pin[4] = {0, 2, 1, 3}


if __name__ == "__main__":
    wiringpi.wiringPiSetup()

    i2c_port = wiringpi.wiringPiI2CSetup(pca9685.i2c_addr)
    if i2c_port < 0:
        print("i2c_port open error")
    
    pca9685.i2c_port = i2c_port

    setupAI(pca9685)
    setFreq(pca9685, 1000)
    
    while True:

        inputdata = int(input("숫자입력 : "))
        throttle = (int)(inputdata*4095/250)
        
        setDuty(pca9685, pin[0], throttle)
        setDuty(pca9685, pin[1], throttle)
        setDuty(pca9685, pin[2], throttle)
        setDuty(pca9685, pin[3], throttle)


