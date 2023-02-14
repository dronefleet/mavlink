package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Flags in {@link io.dronefleet.mavlink.common.EstimatorStatus ESTIMATOR_STATUS} message 
 */
@MavlinkEnum
public enum EstimatorStatusFlags {
    /**
     * True if the attitude estimate is good 
     */
    @MavlinkEntryInfo(1)
    ESTIMATOR_ATTITUDE,

    /**
     * True if the horizontal velocity estimate is good 
     */
    @MavlinkEntryInfo(2)
    ESTIMATOR_VELOCITY_HORIZ,

    /**
     * True if the vertical velocity estimate is good 
     */
    @MavlinkEntryInfo(4)
    ESTIMATOR_VELOCITY_VERT,

    /**
     * True if the horizontal position (relative) estimate is good 
     */
    @MavlinkEntryInfo(8)
    ESTIMATOR_POS_HORIZ_REL,

    /**
     * True if the horizontal position (absolute) estimate is good 
     */
    @MavlinkEntryInfo(16)
    ESTIMATOR_POS_HORIZ_ABS,

    /**
     * True if the vertical position (absolute) estimate is good 
     */
    @MavlinkEntryInfo(32)
    ESTIMATOR_POS_VERT_ABS,

    /**
     * True if the vertical position (above ground) estimate is good 
     */
    @MavlinkEntryInfo(64)
    ESTIMATOR_POS_VERT_AGL,

    /**
     * True if the EKF is in a constant position mode and is not using external measurements (eg GPS or 
     * optical flow) 
     */
    @MavlinkEntryInfo(128)
    ESTIMATOR_CONST_POS_MODE,

    /**
     * True if the EKF has sufficient data to enter a mode that will provide a (relative) position 
     * estimate 
     */
    @MavlinkEntryInfo(256)
    ESTIMATOR_PRED_POS_HORIZ_REL,

    /**
     * True if the EKF has sufficient data to enter a mode that will provide a (absolute) position 
     * estimate 
     */
    @MavlinkEntryInfo(512)
    ESTIMATOR_PRED_POS_HORIZ_ABS,

    /**
     * True if the EKF has detected a GPS glitch 
     */
    @MavlinkEntryInfo(1024)
    ESTIMATOR_GPS_GLITCH,

    /**
     * True if the EKF has detected bad accelerometer data 
     */
    @MavlinkEntryInfo(2048)
    ESTIMATOR_ACCEL_ERROR
}
