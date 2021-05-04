#ifndef __PCA9685_H__
#define __PCA9685_H__

#define MODE1	0x00
#define PRE_SCALE	0xFE
#define LED0_ON_L	0x06
#define LED0_OFF_L	0x08

#define AI	0x20
#define SLEEP	0x10
#define RESTART	0x80

typedef struct { int i2c_addr, i2c_port; } pca9685_t;

void setupAI(pca9685_t&);
void setFreq(pca9685_t&, const int);
void setDuty(pca9685_t&, const int, const int);
						
#endif//__PCA9685_H__