package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Flags for gimbal device (lower level) operation. 
 */
@MavlinkEnum
public enum GimbalDeviceFlags {
    /**
     * Set to retracted safe position (no stabilization), takes presedence over all other flags. 
     */
    @MavlinkEntryInfo(1)
    GIMBAL_DEVICE_FLAGS_RETRACT,

    /**
     * Set to neutral/default position, taking precedence over all other flags except RETRACT. 
     * Neutral is commonly forward-facing and horizontal (roll=pitch=yaw=0) but may be any 
     * orientation. 
     */
    @MavlinkEntryInfo(2)
    GIMBAL_DEVICE_FLAGS_NEUTRAL,

    /**
     * Lock roll angle to absolute angle relative to horizon (not relative to vehicle). This is 
     * generally the default with a stabilizing gimbal. 
     */
    @MavlinkEntryInfo(4)
    GIMBAL_DEVICE_FLAGS_ROLL_LOCK,

    /**
     * Lock pitch angle to absolute angle relative to horizon (not relative to vehicle). This is 
     * generally the default with a stabilizing gimbal. 
     */
    @MavlinkEntryInfo(8)
    GIMBAL_DEVICE_FLAGS_PITCH_LOCK,

    /**
     * Lock yaw angle to absolute angle relative to North (not relative to vehicle). If this flag is 
     * set, the yaw angle and z component of angular velocity are relative to North (earth frame, 
     * x-axis pointing North), else they are relative to the vehicle heading (vehicle frame, earth 
     * frame rotated so that the x-axis is pointing forward). 
     */
    @MavlinkEntryInfo(16)
    GIMBAL_DEVICE_FLAGS_YAW_LOCK,

    /**
     * Yaw angle and z component of angular velocity are relative to the vehicle heading (vehicle 
     * frame, earth frame rotated such that the x-axis is pointing forward). 
     */
    @MavlinkEntryInfo(32)
    GIMBAL_DEVICE_FLAGS_YAW_IN_VEHICLE_FRAME,

    /**
     * Yaw angle and z component of angular velocity are relative to North (earth frame, x-axis is 
     * pointing North). 
     */
    @MavlinkEntryInfo(64)
    GIMBAL_DEVICE_FLAGS_YAW_IN_EARTH_FRAME,

    /**
     * Gimbal device can accept yaw angle inputs relative to North (earth frame). This flag is only for 
     * reporting (attempts to set this flag are ignored). 
     */
    @MavlinkEntryInfo(128)
    GIMBAL_DEVICE_FLAGS_ACCEPTS_YAW_IN_EARTH_FRAME,

    /**
     * The gimbal orientation is set exclusively by the RC signals feed to the gimbal's radio control 
     * inputs. MAVLink messages for setting the gimbal orientation ({@link io.dronefleet.mavlink.common.GimbalDeviceSetAttitude GIMBAL_DEVICE_SET_ATTITUDE}) 
     * are ignored. 
     */
    @MavlinkEntryInfo(256)
    GIMBAL_DEVICE_FLAGS_RC_EXCLUSIVE,

    /**
     * The gimbal orientation is determined by combining/mixing the RC signals feed to the gimbal's 
     * radio control inputs and the MAVLink messages for setting the gimbal orientation 
     * ({@link io.dronefleet.mavlink.common.GimbalDeviceSetAttitude GIMBAL_DEVICE_SET_ATTITUDE}). How these two controls are combined or mixed is not defined by 
     * the protocol but is up to the implementation. 
     */
    @MavlinkEntryInfo(512)
    GIMBAL_DEVICE_FLAGS_RC_MIXED
}
