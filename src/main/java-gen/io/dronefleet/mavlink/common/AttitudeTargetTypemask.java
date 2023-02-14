package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Bitmap to indicate which dimensions should be ignored by the vehicle: a value of 0b00000000 
 * indicates that none of the setpoint dimensions should be ignored. 
 */
@MavlinkEnum
public enum AttitudeTargetTypemask {
    /**
     * Ignore body roll rate 
     */
    @MavlinkEntryInfo(1)
    ATTITUDE_TARGET_TYPEMASK_BODY_ROLL_RATE_IGNORE,

    /**
     * Ignore body pitch rate 
     */
    @MavlinkEntryInfo(2)
    ATTITUDE_TARGET_TYPEMASK_BODY_PITCH_RATE_IGNORE,

    /**
     * Ignore body yaw rate 
     */
    @MavlinkEntryInfo(4)
    ATTITUDE_TARGET_TYPEMASK_BODY_YAW_RATE_IGNORE,

    /**
     * Use 3D body thrust setpoint instead of throttle 
     */
    @MavlinkEntryInfo(32)
    ATTITUDE_TARGET_TYPEMASK_THRUST_BODY_SET,

    /**
     * Ignore throttle 
     */
    @MavlinkEntryInfo(64)
    ATTITUDE_TARGET_TYPEMASK_THROTTLE_IGNORE,

    /**
     * Ignore attitude 
     */
    @MavlinkEntryInfo(128)
    ATTITUDE_TARGET_TYPEMASK_ATTITUDE_IGNORE
}
