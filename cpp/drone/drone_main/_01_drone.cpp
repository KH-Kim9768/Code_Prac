#include "_00_drone.h"

// 변수 선언
i2c_t i2c;
mpu6050_t mpu6050 = {
    .i2c_addr = 0x68,
    .PWR_MGMT_1 = 0x6b,
    .GYRO_XOUT_H = 0x43,
};//1

gyro_raw_t gyro_raw;
gyro_offset_t gyro_offset;
gyro_adj_t gyro_adj;
gyro_rate_t gyro_rate;
dt_t dt;
gyro_angle_t gyro_angle;

target_angle_t target_angle = { 
    .pitch = 0.0, .roll = 0.0, .yaw = 0.0, };//7 // p289 각도 보정 안내

balancing_force_t balancing_force;
throttle_t throttle = { .value = 0.0 };//8 --> 9
motor_speed_t motor_speed;
hm10_t hm10;
pca9685_t pca9685;
motor_t motor = {
    .a = 0,
    .b = 2,
    .c = 1, 
    .d = 3,
};//10



// 전체 문맥 구성
int main(){
    wiringPiSetup();
    init(i2c);
    init(i2c, mpu6050);
    get(mpu6050, gyro_offset);
    init(dt);
    init(hm10);
    init(i2c, pca9685);

    while(true){
        read(mpu6050, gyro_raw);
        calc(gyro_adj, gyro_raw, gyro_offset);
        calc(gyro_rate, gyro_adj);
        calc(dt);
        calc(gyro_angle, gyro_rate, dt);
        calc(balancing_force, target_angle, gyro_angle);
        add(balancing_force, gyro_rate);
        add(balancing_force, target_angle, gyro_angle, dt);
        distribute(motor_speed, throttle, balancing_force);
        check(hm10, throttle, target_angle);
        update(pca9685, motor, motor_speed);

        // static int cnt;//1
        // cnt++;//1
        // if(cnt%1000 != 0) continue;//1

        // print(gyro_raw);//1
        // print(gyro_offset);//2
        // print(gyro_adj);//3
        // print(gyro_rate);//4
        // print(dt);//5
        // print(gyro_angle);
        // print(balancing_force);
        // print(motor_speed);
        // println();
    }
}


