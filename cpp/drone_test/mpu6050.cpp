#include <stdio.h>
#include <wiringPi.h>
#include <wiringPiI2C.h>

#include "mpu6050_regs.h"

int main(void){
    int fd;
    const int mpu6050_addr = 0x68;
    short GyX, GyY, GyZ;

    wiringPiSetup();

    fd = wiringPiI2CSetup(mpu6050_addr);
    if(fd<0) return -1;

    wiringPiI2CWriteReg8(fd, PWR_MGMT_1, 0);

    while(1){
        GyX = (wiringPiI2CReadReg8(fd, GYRO_XOUT_H) & 0xFF) << 8;
        GyX |= wiringPiI2CReadReg8(fd, GYRO_XOUT_L) & 0xFF;
        GyY = (wiringPiI2CReadReg8(fd, GYRO_YOUT_H) & 0xFF) << 8;
        GyY |= wiringPiI2CReadReg8(fd, GYRO_YOUT_L) & 0xFF;
        GyZ = (wiringPiI2CReadReg8(fd, GYRO_ZOUT_H) & 0xFF) << 8;
        GyZ |= wiringPiI2CReadReg8(fd, GYRO_ZOUT_L) & 0xFF;

        printf("GyX = %6d | GyY = %6d | GyZ = %6d \n", GyX, GyY, GyZ);
    }
}