package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Gimbal device (low level) error flags (bitmap, 0 means no error) 
 */
@MavlinkEnum
public enum GimbalDeviceErrorFlags {
    /**
     * Gimbal device is limited by hardware roll limit. 
     */
    @MavlinkEntryInfo(1)
    GIMBAL_DEVICE_ERROR_FLAGS_AT_ROLL_LIMIT,

    /**
     * Gimbal device is limited by hardware pitch limit. 
     */
    @MavlinkEntryInfo(2)
    GIMBAL_DEVICE_ERROR_FLAGS_AT_PITCH_LIMIT,

    /**
     * Gimbal device is limited by hardware yaw limit. 
     */
    @MavlinkEntryInfo(4)
    GIMBAL_DEVICE_ERROR_FLAGS_AT_YAW_LIMIT,

    /**
     * There is an error with the gimbal encoders. 
     */
    @MavlinkEntryInfo(8)
    GIMBAL_DEVICE_ERROR_FLAGS_ENCODER_ERROR,

    /**
     * There is an error with the gimbal power source. 
     */
    @MavlinkEntryInfo(16)
    GIMBAL_DEVICE_ERROR_FLAGS_POWER_ERROR,

    /**
     * There is an error with the gimbal motors. 
     */
    @MavlinkEntryInfo(32)
    GIMBAL_DEVICE_ERROR_FLAGS_MOTOR_ERROR,

    /**
     * There is an error with the gimbal's software. 
     */
    @MavlinkEntryInfo(64)
    GIMBAL_DEVICE_ERROR_FLAGS_SOFTWARE_ERROR,

    /**
     * There is an error with the gimbal's communication. 
     */
    @MavlinkEntryInfo(128)
    GIMBAL_DEVICE_ERROR_FLAGS_COMMS_ERROR,

    /**
     * Gimbal device is currently calibrating. 
     */
    @MavlinkEntryInfo(256)
    GIMBAL_DEVICE_ERROR_FLAGS_CALIBRATION_RUNNING,

    /**
     * Gimbal device is not assigned to a gimbal manager. 
     */
    @MavlinkEntryInfo(512)
    GIMBAL_DEVICE_ERROR_FLAGS_NO_MANAGER
}
