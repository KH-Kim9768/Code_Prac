#include "_00_drone.h"
#include <iostream>
using namespace std;

// 5. 함수 정의
void init(
	i2c_t& i2c, 
	pca9685_t& pca9685) {
			
	pca9685.i2c_port = i2c.port;	
	ioctl(pca9685.i2c_port, I2C_SLAVE, pca9685.i2c_addr);

	setupAI(pca9685);	
	setFreq(pca9685, 1000);
}//10
void update(
	pca9685_t& pca9685, 
	motor_t& motor, 
	motor_speed_t& motor_speed) {

	double motor_speed_all = (motor_speed.a + motor_speed.b + motor_speed.c + motor_speed.d)/4;
	
	int duty_cycle_a = (int)(motor_speed.a*4095.0/250)*1.2;
	int duty_cycle_b = (int)(motor_speed.b*4095.0/250)*1.15*1.2;
	int duty_cycle_c = (int)(motor_speed.c*4095.0/250);
	int duty_cycle_d = (int)(motor_speed.d*4095.0/250);

	cout << "a : " << motor_speed.a << ", b : " << motor_speed.b << ", c : " << motor_speed.c << ", d : " << motor_speed.d << ", ALL : " << motor_speed_all << endl;
		
	ioctl(pca9685.i2c_port, I2C_SLAVE, pca9685.i2c_addr);
		
	setDuty(pca9685, motor.a, duty_cycle_a);
	setDuty(pca9685, motor.b, duty_cycle_b);
	setDuty(pca9685, motor.c, duty_cycle_c);
	setDuty(pca9685, motor.d, duty_cycle_d);
}//10	

