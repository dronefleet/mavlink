package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Actuator output function. Values greater or equal to 1000 are autopilot-specific. 
 */
@MavlinkEnum
public enum ActuatorOutputFunction {
    /**
     * No function (disabled). 
     */
    @MavlinkEntryInfo(0)
    ACTUATOR_OUTPUT_FUNCTION_NONE,

    /**
     * Motor 1 
     */
    @MavlinkEntryInfo(1)
    ACTUATOR_OUTPUT_FUNCTION_MOTOR1,

    /**
     * Motor 2 
     */
    @MavlinkEntryInfo(2)
    ACTUATOR_OUTPUT_FUNCTION_MOTOR2,

    /**
     * Motor 3 
     */
    @MavlinkEntryInfo(3)
    ACTUATOR_OUTPUT_FUNCTION_MOTOR3,

    /**
     * Motor 4 
     */
    @MavlinkEntryInfo(4)
    ACTUATOR_OUTPUT_FUNCTION_MOTOR4,

    /**
     * Motor 5 
     */
    @MavlinkEntryInfo(5)
    ACTUATOR_OUTPUT_FUNCTION_MOTOR5,

    /**
     * Motor 6 
     */
    @MavlinkEntryInfo(6)
    ACTUATOR_OUTPUT_FUNCTION_MOTOR6,

    /**
     * Motor 7 
     */
    @MavlinkEntryInfo(7)
    ACTUATOR_OUTPUT_FUNCTION_MOTOR7,

    /**
     * Motor 8 
     */
    @MavlinkEntryInfo(8)
    ACTUATOR_OUTPUT_FUNCTION_MOTOR8,

    /**
     * Motor 9 
     */
    @MavlinkEntryInfo(9)
    ACTUATOR_OUTPUT_FUNCTION_MOTOR9,

    /**
     * Motor 10 
     */
    @MavlinkEntryInfo(10)
    ACTUATOR_OUTPUT_FUNCTION_MOTOR10,

    /**
     * Motor 11 
     */
    @MavlinkEntryInfo(11)
    ACTUATOR_OUTPUT_FUNCTION_MOTOR11,

    /**
     * Motor 12 
     */
    @MavlinkEntryInfo(12)
    ACTUATOR_OUTPUT_FUNCTION_MOTOR12,

    /**
     * Motor 13 
     */
    @MavlinkEntryInfo(13)
    ACTUATOR_OUTPUT_FUNCTION_MOTOR13,

    /**
     * Motor 14 
     */
    @MavlinkEntryInfo(14)
    ACTUATOR_OUTPUT_FUNCTION_MOTOR14,

    /**
     * Motor 15 
     */
    @MavlinkEntryInfo(15)
    ACTUATOR_OUTPUT_FUNCTION_MOTOR15,

    /**
     * Motor 16 
     */
    @MavlinkEntryInfo(16)
    ACTUATOR_OUTPUT_FUNCTION_MOTOR16,

    /**
     * Servo 1 
     */
    @MavlinkEntryInfo(33)
    ACTUATOR_OUTPUT_FUNCTION_SERVO1,

    /**
     * Servo 2 
     */
    @MavlinkEntryInfo(34)
    ACTUATOR_OUTPUT_FUNCTION_SERVO2,

    /**
     * Servo 3 
     */
    @MavlinkEntryInfo(35)
    ACTUATOR_OUTPUT_FUNCTION_SERVO3,

    /**
     * Servo 4 
     */
    @MavlinkEntryInfo(36)
    ACTUATOR_OUTPUT_FUNCTION_SERVO4,

    /**
     * Servo 5 
     */
    @MavlinkEntryInfo(37)
    ACTUATOR_OUTPUT_FUNCTION_SERVO5,

    /**
     * Servo 6 
     */
    @MavlinkEntryInfo(38)
    ACTUATOR_OUTPUT_FUNCTION_SERVO6,

    /**
     * Servo 7 
     */
    @MavlinkEntryInfo(39)
    ACTUATOR_OUTPUT_FUNCTION_SERVO7,

    /**
     * Servo 8 
     */
    @MavlinkEntryInfo(40)
    ACTUATOR_OUTPUT_FUNCTION_SERVO8,

    /**
     * Servo 9 
     */
    @MavlinkEntryInfo(41)
    ACTUATOR_OUTPUT_FUNCTION_SERVO9,

    /**
     * Servo 10 
     */
    @MavlinkEntryInfo(42)
    ACTUATOR_OUTPUT_FUNCTION_SERVO10,

    /**
     * Servo 11 
     */
    @MavlinkEntryInfo(43)
    ACTUATOR_OUTPUT_FUNCTION_SERVO11,

    /**
     * Servo 12 
     */
    @MavlinkEntryInfo(44)
    ACTUATOR_OUTPUT_FUNCTION_SERVO12,

    /**
     * Servo 13 
     */
    @MavlinkEntryInfo(45)
    ACTUATOR_OUTPUT_FUNCTION_SERVO13,

    /**
     * Servo 14 
     */
    @MavlinkEntryInfo(46)
    ACTUATOR_OUTPUT_FUNCTION_SERVO14,

    /**
     * Servo 15 
     */
    @MavlinkEntryInfo(47)
    ACTUATOR_OUTPUT_FUNCTION_SERVO15,

    /**
     * Servo 16 
     */
    @MavlinkEntryInfo(48)
    ACTUATOR_OUTPUT_FUNCTION_SERVO16
}
