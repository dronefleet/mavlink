package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Gimbal manager high level capability flags (bitmap). The first 16 bits are identical to the 
 * {@link io.dronefleet.mavlink.common.GimbalDeviceCapFlags GIMBAL_DEVICE_CAP_FLAGS}. However, the gimbal manager does not need to copy the flags from the 
 * gimbal but can also enhance the capabilities and thus add flags. 
 */
@MavlinkEnum
public enum GimbalManagerCapFlags {
    /**
     * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_RETRACT. 
     */
    @MavlinkEntryInfo(1)
    GIMBAL_MANAGER_CAP_FLAGS_HAS_RETRACT,

    /**
     * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_NEUTRAL. 
     */
    @MavlinkEntryInfo(2)
    GIMBAL_MANAGER_CAP_FLAGS_HAS_NEUTRAL,

    /**
     * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_AXIS. 
     */
    @MavlinkEntryInfo(4)
    GIMBAL_MANAGER_CAP_FLAGS_HAS_ROLL_AXIS,

    /**
     * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_FOLLOW. 
     */
    @MavlinkEntryInfo(8)
    GIMBAL_MANAGER_CAP_FLAGS_HAS_ROLL_FOLLOW,

    /**
     * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_ROLL_LOCK. 
     */
    @MavlinkEntryInfo(16)
    GIMBAL_MANAGER_CAP_FLAGS_HAS_ROLL_LOCK,

    /**
     * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_AXIS. 
     */
    @MavlinkEntryInfo(32)
    GIMBAL_MANAGER_CAP_FLAGS_HAS_PITCH_AXIS,

    /**
     * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_FOLLOW. 
     */
    @MavlinkEntryInfo(64)
    GIMBAL_MANAGER_CAP_FLAGS_HAS_PITCH_FOLLOW,

    /**
     * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_PITCH_LOCK. 
     */
    @MavlinkEntryInfo(128)
    GIMBAL_MANAGER_CAP_FLAGS_HAS_PITCH_LOCK,

    /**
     * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_AXIS. 
     */
    @MavlinkEntryInfo(256)
    GIMBAL_MANAGER_CAP_FLAGS_HAS_YAW_AXIS,

    /**
     * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_FOLLOW. 
     */
    @MavlinkEntryInfo(512)
    GIMBAL_MANAGER_CAP_FLAGS_HAS_YAW_FOLLOW,

    /**
     * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_YAW_LOCK. 
     */
    @MavlinkEntryInfo(1024)
    GIMBAL_MANAGER_CAP_FLAGS_HAS_YAW_LOCK,

    /**
     * Based on GIMBAL_DEVICE_CAP_FLAGS_SUPPORTS_INFINITE_YAW. 
     */
    @MavlinkEntryInfo(2048)
    GIMBAL_MANAGER_CAP_FLAGS_SUPPORTS_INFINITE_YAW,

    /**
     * Based on GIMBAL_DEVICE_CAP_FLAGS_SUPPORTS_YAW_IN_EARTH_FRAME. 
     */
    @MavlinkEntryInfo(4096)
    GIMBAL_MANAGER_CAP_FLAGS_SUPPORTS_YAW_IN_EARTH_FRAME,

    /**
     * Based on GIMBAL_DEVICE_CAP_FLAGS_HAS_RC_INPUTS. 
     */
    @MavlinkEntryInfo(8192)
    GIMBAL_MANAGER_CAP_FLAGS_HAS_RC_INPUTS,

    /**
     * Gimbal manager supports to point to a local position. 
     */
    @MavlinkEntryInfo(65536)
    GIMBAL_MANAGER_CAP_FLAGS_CAN_POINT_LOCATION_LOCAL,

    /**
     * Gimbal manager supports to point to a global latitude, longitude, altitude position. 
     */
    @MavlinkEntryInfo(131072)
    GIMBAL_MANAGER_CAP_FLAGS_CAN_POINT_LOCATION_GLOBAL
}
