package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Flags in EKF_STATUS message. 
 */
@MavlinkEnum
public enum EkfStatusFlags {
    /**
     * Set if EKF's attitude estimate is good. 
     */
    @MavlinkEntryInfo(1)
    EKF_ATTITUDE,

    /**
     * Set if EKF's horizontal velocity estimate is good. 
     */
    @MavlinkEntryInfo(2)
    EKF_VELOCITY_HORIZ,

    /**
     * Set if EKF's vertical velocity estimate is good. 
     */
    @MavlinkEntryInfo(4)
    EKF_VELOCITY_VERT,

    /**
     * Set if EKF's horizontal position (relative) estimate is good. 
     */
    @MavlinkEntryInfo(8)
    EKF_POS_HORIZ_REL,

    /**
     * Set if EKF's horizontal position (absolute) estimate is good. 
     */
    @MavlinkEntryInfo(16)
    EKF_POS_HORIZ_ABS,

    /**
     * Set if EKF's vertical position (absolute) estimate is good. 
     */
    @MavlinkEntryInfo(32)
    EKF_POS_VERT_ABS,

    /**
     * Set if EKF's vertical position (above ground) estimate is good. 
     */
    @MavlinkEntryInfo(64)
    EKF_POS_VERT_AGL,

    /**
     * EKF is in constant position mode and does not know it's absolute or relative position. 
     */
    @MavlinkEntryInfo(128)
    EKF_CONST_POS_MODE,

    /**
     * Set if EKF's predicted horizontal position (relative) estimate is good. 
     */
    @MavlinkEntryInfo(256)
    EKF_PRED_POS_HORIZ_REL,

    /**
     * Set if EKF's predicted horizontal position (absolute) estimate is good. 
     */
    @MavlinkEntryInfo(512)
    EKF_PRED_POS_HORIZ_ABS,

    /**
     * Set if EKF has never been healthy. 
     */
    @MavlinkEntryInfo(1024)
    EKF_UNINITIALIZED
}
