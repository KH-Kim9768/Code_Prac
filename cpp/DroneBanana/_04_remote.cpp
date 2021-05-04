#include "_00_drone.h"

// 5. 함수 정의
void init(hm10_t& hm10) {
	
	hm10.serial_port = serialOpen ("/dev/ttyS0", 115200);

	if (hm10.serial_port < 0) {
		fprintf (stderr, 
			"Unable to open serial device: %s\n", 
			strerror (errno));
		exit(-1);
	}
}//9
void check(
	hm10_t& hm10, 
	throttle_t& throttle, 
	target_angle_t& target_angle) {
		
	static int cntMsg;
	
	if(serialDataAvail (hm10.serial_port)) {
		while(serialDataAvail (hm10.serial_port)) {
			char msp_data = serialGetchar (hm10.serial_port); 
			if(msp_data == '$') cntMsg = 0;
			else cntMsg++;    

			if(cntMsg == 8) throttle.value = msp_data;
			else if(cntMsg == 7) 
				target_angle.yaw = -(msp_data-125);//12
			else if(cntMsg == 6) 
				target_angle.pitch = -(msp_data-125);//12
			else if(cntMsg == 5) 
				target_angle.roll = (msp_data-125);//12

			#define ANGLE_MAX   30
			if(target_angle.roll < -ANGLE_MAX) 
				target_angle.roll = -ANGLE_MAX;
			else if(target_angle.roll > ANGLE_MAX) 
				target_angle.roll = ANGLE_MAX;
			if(target_angle.pitch < -ANGLE_MAX) 
				target_angle.pitch = -ANGLE_MAX;
			else if(target_angle.pitch > ANGLE_MAX) 
				target_angle.pitch = ANGLE_MAX;             
			if(target_angle.yaw < -ANGLE_MAX) 
				target_angle.yaw = -ANGLE_MAX;
			else if(target_angle.yaw > ANGLE_MAX) 
				target_angle.yaw = ANGLE_MAX;
		}
	}
}//9		
