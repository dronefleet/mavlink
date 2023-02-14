package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Gimbal device (low level) capability flags (bitmap). 
 */
@MavlinkEnum
public enum GimbalDeviceCapFlags {
    /**
     * Gimbal device supports a retracted position. 
     */
    @MavlinkEntryInfo(1)
    GIMBAL_DEVICE_CAP_FLAGS_HAS_RETRACT,

    /**
     * Gimbal device supports a horizontal, forward looking position, stabilized. 
     */
    @MavlinkEntryInfo(2)
    GIMBAL_DEVICE_CAP_FLAGS_HAS_NEUTRAL,

    /**
     * Gimbal device supports rotating around roll axis. 
     */
    @MavlinkEntryInfo(4)
    GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_AXIS,

    /**
     * Gimbal device supports to follow a roll angle relative to the vehicle. 
     */
    @MavlinkEntryInfo(8)
    GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_FOLLOW,

    /**
     * Gimbal device supports locking to a roll angle (generally that's the default with roll 
     * stabilized). 
     */
    @MavlinkEntryInfo(16)
    GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_LOCK,

    /**
     * Gimbal device supports rotating around pitch axis. 
     */
    @MavlinkEntryInfo(32)
    GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_AXIS,

    /**
     * Gimbal device supports to follow a pitch angle relative to the vehicle. 
     */
    @MavlinkEntryInfo(64)
    GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_FOLLOW,

    /**
     * Gimbal device supports locking to a pitch angle (generally that's the default with pitch 
     * stabilized). 
     */
    @MavlinkEntryInfo(128)
    GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_LOCK,

    /**
     * Gimbal device supports rotating around yaw axis. 
     */
    @MavlinkEntryInfo(256)
    GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_AXIS,

    /**
     * Gimbal device supports to follow a yaw angle relative to the vehicle (generally that's the 
     * default). 
     */
    @MavlinkEntryInfo(512)
    GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_FOLLOW,

    /**
     * Gimbal device supports locking to an absolute heading, i.e., yaw angle relative to North 
     * (earth frame, often this is an option available). 
     */
    @MavlinkEntryInfo(1024)
    GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_LOCK,

    /**
     * Gimbal device supports yawing/panning infinetely (e.g. using slip disk). 
     */
    @MavlinkEntryInfo(2048)
    GIMBAL_DEVICE_CAP_FLAGS_SUPPORTS_INFINITE_YAW,

    /**
     * Gimbal device supports yaw angles and angular velocities relative to North (earth frame). 
     * This usually requires support by an autopilot via {@link io.dronefleet.mavlink.common.AutopilotStateForGimbalDevice AUTOPILOT_STATE_FOR_GIMBAL_DEVICE}. 
     * Support can go on and off during runtime, which is reported by the flag 
     * GIMBAL_DEVICE_FLAGS_CAN_ACCEPT_YAW_IN_EARTH_FRAME. 
     */
    @MavlinkEntryInfo(4096)
    GIMBAL_DEVICE_CAP_FLAGS_SUPPORTS_YAW_IN_EARTH_FRAME,

    /**
     * Gimbal device supports radio control inputs as an alternative input for controlling the 
     * gimbal orientation. 
     */
    @MavlinkEntryInfo(8192)
    GIMBAL_DEVICE_CAP_FLAGS_HAS_RC_INPUTS
}
