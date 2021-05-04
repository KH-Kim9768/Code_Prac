#include "_00_drone.h"

// 5. 함수 정의
void calc(
	balancing_force_t& balancing_force, 
	target_angle_t& target_angle, 
	gyro_angle_t& gyro_angle) {
  
  double angle_error_roll  = target_angle.roll  - gyro_angle.roll;
  double angle_error_pitch = target_angle.pitch - gyro_angle.pitch;
  double angle_error_yaw   = target_angle.yaw   - gyro_angle.yaw;

  balancing_force.roll   = 1 * angle_error_roll ;
  balancing_force.pitch  = 1 * angle_error_pitch;
  balancing_force.yaw    = 1 * angle_error_yaw;
}//7
void distribute(
	motor_speed_t& motor_speed, 
	throttle_t& throttle, 
	balancing_force_t& balancing_force) {		
	
	motor_speed.a = throttle.value 
		+ balancing_force.yaw 
		+ balancing_force.roll 
		+ balancing_force.pitch;
	motor_speed.b = throttle.value 
		- balancing_force.yaw 
		- balancing_force.roll 
		+ balancing_force.pitch;
	motor_speed.c = throttle.value 
		+ balancing_force.yaw 
		- balancing_force.roll 
		- balancing_force.pitch;
	motor_speed.d = throttle.value 
		- balancing_force.yaw 
		+ balancing_force.roll 
		- balancing_force.pitch;

	if(motor_speed.a < 0)  motor_speed.a = 0;
	if(motor_speed.a > 250)  motor_speed.a = 250;
	if(motor_speed.b < 0)  motor_speed.b = 0; 
	if(motor_speed.b > 250)  motor_speed.b = 250;
	if(motor_speed.c < 0)  motor_speed.c = 0; 
	if(motor_speed.c > 250)  motor_speed.c = 250;
	if(motor_speed.d < 0)  motor_speed.d = 0; 
	if(motor_speed.d > 250)  motor_speed.d = 250;
	
	if(throttle.value==0) {
		motor_speed.a = 0;
		motor_speed.b = 0;
		motor_speed.c = 0;
		motor_speed.d = 0;
	}//9
}//8	
void add(
	balancing_force_t& balancing_force, 
	gyro_rate_t& gyro_rate) {	

	balancing_force.roll  += 1 * (-gyro_rate.roll);
	balancing_force.pitch += 1 * (-gyro_rate.pitch);
	balancing_force.yaw   += 1 * (-gyro_rate.yaw);
}//11
void add(
	balancing_force_t& balancing_force, 
	target_angle_t& target_angle, 
	gyro_angle_t& gyro_angle, 
	dt_t& dt) {
	
	static double res_force_pitch;
    static double res_force_roll;
    static double res_force_yaw;
    
    double angle_error_pitch = target_angle.pitch - gyro_angle.pitch;
    double angle_error_roll  = target_angle.roll  - gyro_angle.roll;
    double angle_error_yaw   = target_angle.yaw   - gyro_angle.yaw;
        
    res_force_pitch += 1 * angle_error_pitch*dt.t_period;
    res_force_roll  += 1 * angle_error_roll*dt.t_period;
    res_force_yaw   += 0 * angle_error_yaw*dt.t_period;
    
    extern throttle_t throttle;//13
    if(throttle.value==0) {
        res_force_pitch = 0;
        res_force_roll = 0;
        res_force_yaw = 0;
    }//13
    
    balancing_force.roll += res_force_roll;
    balancing_force.pitch += res_force_pitch;
    balancing_force.yaw += res_force_yaw;
	
}//12	

