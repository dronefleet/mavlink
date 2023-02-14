package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Defines how throttle value is represented in MAV_CMD_DO_MOTOR_TEST. 
 */
@MavlinkEnum
public enum MotorTestThrottleType {
    /**
     * Throttle as a percentage (0 ~ 100) 
     */
    @MavlinkEntryInfo(0)
    MOTOR_TEST_THROTTLE_PERCENT,

    /**
     * Throttle as an absolute PWM value (normally in range of 1000~2000). 
     */
    @MavlinkEntryInfo(1)
    MOTOR_TEST_THROTTLE_PWM,

    /**
     * Throttle pass-through from pilot's transmitter. 
     */
    @MavlinkEntryInfo(2)
    MOTOR_TEST_THROTTLE_PILOT,

    /**
     * Per-motor compass calibration test. 
     */
    @MavlinkEntryInfo(3)
    MOTOR_TEST_COMPASS_CAL
}
