#include "_00_drone.h"

// 5. 함수 정의
void print(gyro_raw_t& gyro_raw) {
	
	printf("#RAW(X,Y,Z): ");
	printf("%6d,", gyro_raw.x);
	printf("%6d,", gyro_raw.y);
	printf("%6d", gyro_raw.z);        
}//1
void println(void) {

	printf("\n");
}//1
void print(gyro_offset_t& gyro_offset) {
	
	printf("#OFF(X,Y,Z):");
	printf("%6d,", gyro_offset.x);
	printf("%6d,", gyro_offset.y);
	printf("%6d", gyro_offset.z);
}//2
void print(gyro_adj_t& gyro_adj) {
	
	printf("#ADJ(X,Y,Z):");
	printf("%6d,", gyro_adj.x);
	printf("%6d,", gyro_adj.y);
	printf("%6d", gyro_adj.z);
}//3
void print(gyro_rate_t& gyro_rate) {
	
	printf("#RATE(P,R,Y):");        
	printf("%6.1f,", gyro_rate.pitch);
	printf("%6.1f,", gyro_rate.roll);
	printf("%6.1f", gyro_rate.yaw);
}//4
void print(dt_t& dt) {
	
	printf("#DT:%6.6f", dt.t_period);
}//5
void print(gyro_angle_t& gyro_angle) {
	
	printf("#ANGLE(P,R,Y):");           
	printf("%6.1f,", gyro_angle.pitch);
	printf("%6.1f,", gyro_angle.roll);
	printf("%6.1f", gyro_angle.yaw);
}//6
void print(balancing_force_t& balancing_force) {
	
	printf("#FORCE(P,R,Y):");         
	printf("%6.1f,", balancing_force.pitch);
	printf("%6.1f,", balancing_force.roll);
	printf("%6.1f", balancing_force.yaw);
}//7
void print(motor_speed_t& motor_speed) {

	printf("#SPEED(A,B,C,D):");
	printf("%6.1f,", motor_speed.a);
	printf("%6.1f,", motor_speed.b);
	printf("%6.1f,", motor_speed.c);
	printf("%6.1f", motor_speed.d);
}//8
