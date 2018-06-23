package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum MotorTestThrottleType {
    /**
     * throttle as a percentage from 0 ~ 100<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    MOTOR_TEST_THROTTLE_PERCENT,

    /**
     * throttle as an absolute PWM value (normally in range of 1000~2000)<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    MOTOR_TEST_THROTTLE_PWM,

    /**
     * throttle pass-through from pilot's transmitter<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    MOTOR_TEST_THROTTLE_PILOT,

    /**
     * per-motor compass calibration test<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    MOTOR_TEST_COMPASS_CAL
}
