#include <stdio.h>
#include <errno.h>
#include <string.h>
#include <wiringPi.h>
#include <wiringSerial.h>
#include <wiringPiI2C.h>

#include "pca9685.h"
#include "mpu6050_regs.h"

#include "_00_drone.h"

// 5. 함수 정의
void init(i2c_t& i2c) {
	
	i2c.port = open("/dev/i2c-1", O_RDWR);
	if(i2c.port < 0) {
		fprintf (stderr, 
			"Unable to open i2c-1 device: %s\n", 
			strerror (errno));
		exit(-1);
	}
}//1
void init(
	i2c_t& i2c, 
	mpu6050_t& mpu6050) {
		
	mpu6050.i2c_port = i2c.port;
 	
	ioctl(mpu6050.i2c_port, I2C_SLAVE, mpu6050.i2c_addr);
	
	wiringPiI2CWriteReg8(mpu6050.i2c_port, mpu6050.PWR_MGMT_1, 0);		
}//1
void read(
	mpu6050_t& mpu6050, 
	gyro_raw_t& gyro_raw) {
		
	const int I2C_PORT = mpu6050.i2c_port;
	const int GYRO_XH = mpu6050.GYRO_XOUT_H;
		
	ioctl(I2C_PORT, I2C_SLAVE, mpu6050.i2c_addr);
	
	gyro_raw.x=(wiringPiI2CReadReg8(I2C_PORT, GYRO_XH+0 )&0xFF)<<8;
	gyro_raw.x|=wiringPiI2CReadReg8(I2C_PORT, GYRO_XH+1 )&0xFF;
	gyro_raw.y=(wiringPiI2CReadReg8(I2C_PORT, GYRO_XH+2 )&0xFF)<<8;
	gyro_raw.y|=wiringPiI2CReadReg8(I2C_PORT, GYRO_XH+3 )&0xFF;
	gyro_raw.z=(wiringPiI2CReadReg8(I2C_PORT, GYRO_XH+4 )&0xFF)<<8;
	gyro_raw.z|=wiringPiI2CReadReg8(I2C_PORT, GYRO_XH+5 )&0xFF;		
}//1
#define NSAMPLES 1000//2
void get(
	mpu6050_t& mpu6050, 
	gyro_offset_t& gyro_offset) {
		
	gyro_raw_t gyro_raw;
	int32_t sumGyX = 0, sumGyY = 0, sumGyZ = 0;
	
	for(int i=0;i<NSAMPLES;i++) {
		read(mpu6050, gyro_raw);
		
		sumGyX += gyro_raw.x;  
		sumGyY += gyro_raw.y;  
		sumGyZ += gyro_raw.z;
		
		delay(1);
	}
	
	gyro_offset.x = (double)sumGyX/NSAMPLES;  
	gyro_offset.y = (double)sumGyY/NSAMPLES;  
	gyro_offset.z = (double)sumGyZ/NSAMPLES;
}//2
void calc(
	gyro_adj_t& gyro_adj, 
	gyro_raw_t& gyro_raw, 
	gyro_offset_t& gyro_offset) {
	
	gyro_adj.x = gyro_raw.x - gyro_offset.x;
	gyro_adj.y = gyro_raw.y - gyro_offset.y;
	gyro_adj.z = gyro_raw.z - gyro_offset.z;	
}//3
void calc(
	gyro_rate_t& gyro_rate, 
	gyro_adj_t& gyro_adj) {

	gyro_rate.roll  = gyro_adj.y/131.0;
	gyro_rate.pitch = gyro_adj.x/131.0;
	gyro_rate.yaw   = gyro_adj.z/131.0;
}//4
void init(dt_t& dt)  {
	
	dt.t_prev = micros();
}//5
void calc(dt_t& dt)  {
	
  dt.t_now = micros();
  dt.t_period = (dt.t_now - dt.t_prev)/1000000.0;
  dt.t_prev = dt.t_now;
}//5 
void calc(gyro_angle_t& gyro_angle, gyro_rate_t& gyro_rate, dt_t& dt)  {	

	gyro_angle.roll  += gyro_rate.roll  * dt.t_period;
	gyro_angle.pitch += gyro_rate.pitch * dt.t_period;
	gyro_angle.yaw   += gyro_rate.yaw   * dt.t_period;
    
    extern throttle_t throttle;//9
    if(throttle.value==0) {
        gyro_angle.pitch = 0;
        gyro_angle.roll = 0;
        gyro_angle.yaw = 0;
    }//9
}//6


int gyroI2C(void){
    int fd;
    const int mpu6050_addr = 0x68;
    short GyX, GyY, GyZ;

    wiringPiSetup();

    fd = wiringPiI2CSetup(mpu6050_addr);
    if(fd<0) return -1;

    wiringPiI2CWriteReg8(fd, PWR_MGMT_1, 0);

    GyX = (wiringPiI2CReadReg8(fd, GYRO_XOUT_H) & 0xFF) << 8;
    GyX |= wiringPiI2CReadReg8(fd, GYRO_XOUT_L) & 0xFF;
    GyY = (wiringPiI2CReadReg8(fd, GYRO_YOUT_H) & 0xFF) << 8;
    GyY |= wiringPiI2CReadReg8(fd, GYRO_YOUT_L) & 0xFF;
    GyZ = (wiringPiI2CReadReg8(fd, GYRO_ZOUT_H) & 0xFF) << 8;
    GyZ |= wiringPiI2CReadReg8(fd, GYRO_ZOUT_L) & 0xFF;

    printf("GyX = %6d | GyY = %6d | GyZ = %6d \n", GyX, GyY, GyZ);




    return 0;
}

void setupAI(pca9685_t& pca9685){
    const int I2C_PORT = pca9685.i2c_port;
    int mode1;

    mode1 = wiringPiI2CReadReg8(I2C_PORT, MODE1)&0xFF;
    wiringPiI2CWriteReg8(I2C_PORT, MODE1, mode1|AI);

}

void setFreq (pca9685_t& pca9685, int frequency){
    const int I2C_PORT = pca9685.i2c_port;
    int mode1;
    int prescale;

    mode1 = wiringPiI2CReadReg8(I2C_PORT, MODE1)&0xFF;
    wiringPiI2CWriteReg8(I2C_PORT, MODE1, mode1 | SLEEP);

    prescale = (int)(25000000.0f/(4096*frequency));
    wiringPiI2CWriteReg8(I2C_PORT, PRE_SCALE, prescale);
    
    mode1 = wiringPiI2CReadReg8(I2C_PORT, MODE1) & 0xFF;
    wiringPiI2CWriteReg8(I2C_PORT, MODE1, mode1&~SLEEP);

    delay(1);

    mode1 = wiringPiI2CReadReg8(I2C_PORT, MODE1) & 0xFF;
    wiringPiI2CWriteReg8(I2C_PORT, MODE1, mode1|RESTART);
}

void setDuty(pca9685_t& pca9685, const int pin, const int duty_cycle){
    const int I2C_PORT = pca9685.i2c_port;
    const int chan = pin*4;
    const int duty_off = duty_cycle&0x1FFF;

    wiringPiI2CWriteReg16(I2C_PORT, LED0_OFF_L+chan, duty_off);
}

pca9685_t pca9685 = {.i2c_addr = 0x40, };
const int pin[4] = {0, 2, 1, 3,};

int main(){

    int gyx = 0

    wiringPiSetup();

    int serial_port;
    if((serial_port = serialOpen("/dev/ttyS0", 115200)) < 0){
        fprintf(stderr, "Unable to open serial device: %s\n", strerror(errno));
        return 1;
    }

    int i2c_port;
    if((i2c_port = wiringPiI2CSetup(pca9685.i2c_addr)) < 0){
        fprintf(stderr, "Unable to open pca9685 device: %s\n", strerror(errno));
        return 1;
    }

    pca9685.i2c_port = i2c_port;

    setupAI(pca9685);
    setFreq(pca9685, 1000);

    while(1){
        static int cnt_msg;

        //if(serialDataAvail(serial_port)){
        //    char dat = serialGetchar(serial_port);
        //    if(dat == '$') cnt_msg = 0;
        //    else cnt_msg++;

        //    if(cnt_msg == 8){

                int throttle = 0;
                scanf("%d", &throttle);
                gyroI2C();
                calc();

                setDuty(pca9685, pin[0], throttle);
                setDuty(pca9685, pin[1], throttle);
                setDuty(pca9685, pin[2], throttle);
                setDuty(pca9685, pin[3], throttle);
        //    }
        //}
    }
}