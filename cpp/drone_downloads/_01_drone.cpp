#include "_00_drone.h"

i2c_t i2c;//1
mpu6050_t mpu6050 = {
  .i2c_addr = 0x68,
  .PWR_MGMT_1 = 0x6b,
  .GYRO_XOUT_H = 0x43,
};//1
gyro_raw_t gyro_raw;//1
gyro_offset_t gyro_offset;//2
gyro_adj_t gyro_adj;//3
gyro_rate_t gyro_rate;//4
dt_t dt;//5
gyro_angle_t gyro_angle;//6
target_angle_t target_angle = {.roll = 10.0, .pitch = 50.0, .yaw = 0.0 };//7
balancing_force_t balancing_force;//7
throttle_t throttle = { .value = 0, };//8
motor_speed_t motor_speed;//8
hm10_t hm10;//9
motor_t motor = { .a = 0, .b = 2, .c = 1, .d = 3, };//10
pca9685_t pca9685 = { .i2c_addr = 0x40, };//10

int main() {
	
	wiringPiSetup();//1	
	init(i2c);//1	
	init(i2c, mpu6050);//1	
	get(mpu6050, gyro_offset);//2	
	init(dt);//5
	init(hm10);//9
	init(i2c, pca9685);//10
	
	while(true) {
		
		read(mpu6050, gyro_raw);//1		
		calc(gyro_adj, gyro_raw, gyro_offset);//3		
		calc(gyro_rate, gyro_adj);//4
		calc(dt);//5
		calc(gyro_angle, gyro_rate, dt);//6		
		calc(balancing_force, target_angle, gyro_angle);//7
        add(balancing_force, gyro_rate);//11
        add(balancing_force, target_angle, gyro_angle, dt);//12		
		distribute(motor_speed, throttle, balancing_force);//8		
		check(hm10, throttle, target_angle);//9		
		update(pca9685, motor, motor_speed);//10

		static int cnt_loop;//1
		cnt_loop++;//1
		if(cnt_loop%100 != 0) continue;//1

		// print(gyro_raw);//1
		// print(gyro_offset);//2
		// print(gyro_adj);//3
		print(gyro_rate);//4
		println();//1
		print(dt);//5
		println();
		print(gyro_angle);//6
		println();//1
		// print(balancing_force);//7
		print(motor_speed);//8			 
		println();//1
	}
}
