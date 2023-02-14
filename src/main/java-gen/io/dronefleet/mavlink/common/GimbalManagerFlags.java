package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Flags for high level gimbal manager operation The first 16 bits are identical to the 
 * {@link io.dronefleet.mavlink.common.GimbalDeviceFlags GIMBAL_DEVICE_FLAGS}. 
 */
@MavlinkEnum
public enum GimbalManagerFlags {
    /**
     * Based on GIMBAL_DEVICE_FLAGS_RETRACT. 
     */
    @MavlinkEntryInfo(1)
    GIMBAL_MANAGER_FLAGS_RETRACT,

    /**
     * Based on GIMBAL_DEVICE_FLAGS_NEUTRAL. 
     */
    @MavlinkEntryInfo(2)
    GIMBAL_MANAGER_FLAGS_NEUTRAL,

    /**
     * Based on GIMBAL_DEVICE_FLAGS_ROLL_LOCK. 
     */
    @MavlinkEntryInfo(4)
    GIMBAL_MANAGER_FLAGS_ROLL_LOCK,

    /**
     * Based on GIMBAL_DEVICE_FLAGS_PITCH_LOCK. 
     */
    @MavlinkEntryInfo(8)
    GIMBAL_MANAGER_FLAGS_PITCH_LOCK,

    /**
     * Based on GIMBAL_DEVICE_FLAGS_YAW_LOCK. 
     */
    @MavlinkEntryInfo(16)
    GIMBAL_MANAGER_FLAGS_YAW_LOCK,

    /**
     * Based on GIMBAL_DEVICE_FLAGS_YAW_IN_VEHICLE_FRAME. 
     */
    @MavlinkEntryInfo(32)
    GIMBAL_MANAGER_FLAGS_YAW_IN_VEHICLE_FRAME,

    /**
     * Based on GIMBAL_DEVICE_FLAGS_YAW_IN_EARTH_FRAME. 
     */
    @MavlinkEntryInfo(64)
    GIMBAL_MANAGER_FLAGS_YAW_IN_EARTH_FRAME,

    /**
     * Based on GIMBAL_DEVICE_FLAGS_ACCEPTS_YAW_IN_EARTH_FRAME. 
     */
    @MavlinkEntryInfo(128)
    GIMBAL_MANAGER_FLAGS_ACCEPTS_YAW_IN_EARTH_FRAME,

    /**
     * Based on GIMBAL_DEVICE_FLAGS_RC_EXCLUSIVE. 
     */
    @MavlinkEntryInfo(256)
    GIMBAL_MANAGER_FLAGS_RC_EXCLUSIVE,

    /**
     * Based on GIMBAL_DEVICE_FLAGS_RC_MIXED. 
     */
    @MavlinkEntryInfo(512)
    GIMBAL_MANAGER_FLAGS_RC_MIXED
}
