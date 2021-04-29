#include <wiringPi.h> //delay
#include <wiringPiI2C.h>

#include "pca9685.h"

void setupAI(pca9685_t& pca9685) {
	
	const int I2C_PORT = pca9685.i2c_port;
	int mode1;

	mode1 = wiringPiI2CReadReg8(I2C_PORT, MODE1)&0xFF;
	wiringPiI2CWriteReg8(I2C_PORT, MODE1, mode1|AI);
}

void setFreq(pca9685_t& pca9685, int frequency) {
	
	const int I2C_PORT = pca9685.i2c_port;
	int mode1;
	int prescale;

	mode1 = wiringPiI2CReadReg8(I2C_PORT, MODE1)&0xFF;
	wiringPiI2CWriteReg8(I2C_PORT, MODE1, mode1|SLEEP);

	prescale = (int)(25000000.0f/(4096*frequency));
	wiringPiI2CWriteReg8(I2C_PORT, PRE_SCALE, prescale);

	mode1 = wiringPiI2CReadReg8(I2C_PORT, MODE1)&0xFF;
	wiringPiI2CWriteReg8(I2C_PORT, MODE1, mode1&~SLEEP);

	delay(1);

	mode1 = wiringPiI2CReadReg8(I2C_PORT, MODE1)&0xFF;
	wiringPiI2CWriteReg8(I2C_PORT, MODE1, mode1|RESTART);
}

void setDuty(
	pca9685_t& pca9685, 
	const int pin, 
	const int duty_cycle) {
	
	const int I2C_PORT = pca9685.i2c_port;
	const int chan = pin*4;
	const int duty_off = duty_cycle&0x1FFF;
	
	wiringPiI2CWriteReg16(I2C_PORT, LED0_OFF_L+chan, duty_off);
}	