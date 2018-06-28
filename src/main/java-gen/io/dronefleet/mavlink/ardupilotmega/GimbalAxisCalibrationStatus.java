package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum GimbalAxisCalibrationStatus {
    /**
     * Axis calibration is in progress 
     */
    @MavlinkEntryInfo(0)
    GIMBAL_AXIS_CALIBRATION_STATUS_IN_PROGRESS,

    /**
     * Axis calibration succeeded 
     */
    @MavlinkEntryInfo(1)
    GIMBAL_AXIS_CALIBRATION_STATUS_SUCCEEDED,

    /**
     * Axis calibration failed 
     */
    @MavlinkEntryInfo(2)
    GIMBAL_AXIS_CALIBRATION_STATUS_FAILED
}
