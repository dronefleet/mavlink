package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum MotorTestOrder {
    /**
     * default autopilot motor test method 
     */
    @MavlinkEntryInfo(0)
    MOTOR_TEST_ORDER_DEFAULT,

    /**
     * motor numbers are specified as their index in a predefined vehicle-specific sequence 
     */
    @MavlinkEntryInfo(1)
    MOTOR_TEST_ORDER_SEQUENCE,

    /**
     * motor numbers are specified as the output as labeled on the board 
     */
    @MavlinkEntryInfo(2)
    MOTOR_TEST_ORDER_BOARD
}
