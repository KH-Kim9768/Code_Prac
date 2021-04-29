#ifndef __DRONE_H__
#define __DRONE_H__

#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>
#include <errno.h>
#include <string.h>
#include <stdlib.h>
#include <sys/ioctl.h>
#include <stdint.h>

#include <wiringPi.h>
#include <wiringPiI2C.h>
#include <wiringSerial.h>


#include "pca9685.h"

#define I2C_SLAVE 0x0703;


// 변수 형 정의
typedef struct{ int port; } i2c_t; //1
typedef struct{ uint8_t i2c_addr, PWR_MGMT_1, GYRO_XOUT_H, i2c_port; } mpu6050_t;//1
typedef struct{ int16_t x, y, z; } gyro_raw_t;//1
typedef struct{ int16_t x, y, z; } gyro_offset_t;//2
typedef struct{ int16_t x, y, z; } gyro_adj_t;//3
typedef struct{ double roll, pitch, yaw; } gyro_rate_t;//4
typedef struct{ unsigned long t_prev, t_now; double t_period; } dt_t;//5
typedef struct{ double roll, pitch, yaw; } gyro_angle_t;//6
typedef struct{ double roll, pitch, yaw; } target_angle_t;
typedef struct{ double roll, pitch, yaw; } balancing_force_t;
typedef struct{ double value; } throttle_t;
typedef struct{ double a, b, c, d; } motor_speed_t;
typedef struct{ int dummy; } hm10_t;
//typedef struct{ int dummy; } pca9685_t;
typedef struct{ int a, b, c, d; } motor_t;//10


// 함수 원형 선언
void init(i2c_t&);
void init(i2c_t&, mpu6050_t&);
void read(mpu6050_t&, gyro_raw_t&);
void get(mpu6050_t&, gyro_offset_t&);
void calc(gyro_adj_t&, gyro_raw_t&, gyro_offset_t&)
void calc(gyro_rate_t&, gyro_adj_t&);
void init(dt_t&);
void calc(dt_t&);
void calc(gyro_angle_t&, gyro_rate_t&, dt_t&);
void calc(balancing_force_t&, target_angle_t&, gyro_angle_t&);
void distribute(motor_speed_t&, throttle_t&, balancing_force_t&);
void init(hm10_t&);
void check(hm10_t&, throttle_t&, target_angle_t&);
void init(i2c_t&, pca9685_t&);
void update(pca9685_t&, motor_t&, motor_speed_t&);
void add(balancing_force_t&, gyro_rate_t&);
void add(balancing_force_t&, target_angle_t&, gyro_angle_t&, dt_t&);

void print(gyro_raw_t&);
void println(void);
void print(gyro_offset_t&);
void print(gyro_adj_t&);
void print(gyro_rate_t&);
void print(dt_t&);
void print(gyro_angle_t&);
void print(balancing_force_t&);
void print(motor_speed_t&);

#endif   // __DRONE_H__