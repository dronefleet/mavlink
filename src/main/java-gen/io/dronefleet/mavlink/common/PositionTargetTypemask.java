package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Bitmap to indicate which dimensions should be ignored by the vehicle: a value of 
 * 0b0000000000000000 or 0b0000001000000000 indicates that none of the setpoint dimensions 
 * should be ignored. If bit 9 is set the floats afx afy afz should be interpreted as force instead of 
 * acceleration. 
 */
@MavlinkEnum
public enum PositionTargetTypemask {
    /**
     * Ignore position x 
     */
    @MavlinkEntryInfo(1)
    POSITION_TARGET_TYPEMASK_X_IGNORE,

    /**
     * Ignore position y 
     */
    @MavlinkEntryInfo(2)
    POSITION_TARGET_TYPEMASK_Y_IGNORE,

    /**
     * Ignore position z 
     */
    @MavlinkEntryInfo(4)
    POSITION_TARGET_TYPEMASK_Z_IGNORE,

    /**
     * Ignore velocity x 
     */
    @MavlinkEntryInfo(8)
    POSITION_TARGET_TYPEMASK_VX_IGNORE,

    /**
     * Ignore velocity y 
     */
    @MavlinkEntryInfo(16)
    POSITION_TARGET_TYPEMASK_VY_IGNORE,

    /**
     * Ignore velocity z 
     */
    @MavlinkEntryInfo(32)
    POSITION_TARGET_TYPEMASK_VZ_IGNORE,

    /**
     * Ignore acceleration x 
     */
    @MavlinkEntryInfo(64)
    POSITION_TARGET_TYPEMASK_AX_IGNORE,

    /**
     * Ignore acceleration y 
     */
    @MavlinkEntryInfo(128)
    POSITION_TARGET_TYPEMASK_AY_IGNORE,

    /**
     * Ignore acceleration z 
     */
    @MavlinkEntryInfo(256)
    POSITION_TARGET_TYPEMASK_AZ_IGNORE,

    /**
     * Use force instead of acceleration 
     */
    @MavlinkEntryInfo(512)
    POSITION_TARGET_TYPEMASK_FORCE_SET,

    /**
     * Ignore yaw 
     */
    @MavlinkEntryInfo(1024)
    POSITION_TARGET_TYPEMASK_YAW_IGNORE,

    /**
     * Ignore yaw rate 
     */
    @MavlinkEntryInfo(2048)
    POSITION_TARGET_TYPEMASK_YAW_RATE_IGNORE
}
