#include <stdio.h>
#include <errno.h>
#include <string.h>
#include <wiringPi.h>
#include <wiringPiI2C.h>
#include <iostream>

#include "pca9685.h"

pca9685_t pca9685 = {.i2c_addr = 0x40, };
const int pin[4] = {0, 2, 1, 3};

int main(void){
    
    wiringPiSetup();

    int i2c_port;
    if((i2c_port = wiringPiI2CSetup(pca9685.i2c_addr)) < 0){
        fprintf(stderr, "Unable to open pca9685 device : %s\n", strerror(errno));
        return 1;
    }
    
    pca9685.i2c_port = i2c_port;

    setupAI(pca9685);
    setFreq(pca9685, 1000);

    while(1){
        int data;
        std::cin >> data;
        int throttle = (int)(data*4095.0/250);
        setDuty(pca9685, pin[0], throttle); 
        setDuty(pca9685, pin[1], throttle); 
        setDuty(pca9685, pin[2], throttle); 
        setDuty(pca9685, pin[3], throttle);

        
    }
}