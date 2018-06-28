package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum MotorTestThrottleType {
    /**
     * throttle as a percentage from 0 ~ 100 
     */
    @MavlinkEntryInfo(0)
    MOTOR_TEST_THROTTLE_PERCENT,

    /**
     * throttle as an absolute PWM value (normally in range of 1000~2000) 
     */
    @MavlinkEntryInfo(1)
    MOTOR_TEST_THROTTLE_PWM,

    /**
     * throttle pass-through from pilot's transmitter 
     */
    @MavlinkEntryInfo(2)
    MOTOR_TEST_THROTTLE_PILOT,

    /**
     * per-motor compass calibration test 
     */
    @MavlinkEntryInfo(3)
    MOTOR_TEST_COMPASS_CAL
}
