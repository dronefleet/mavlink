package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum GimbalAxisCalibrationRequired {
    /**
     * Whether or not this axis requires calibration is unknown at this time. 
     */
    @MavlinkEntryInfo(0)
    GIMBAL_AXIS_CALIBRATION_REQUIRED_UNKNOWN,

    /**
     * This axis requires calibration. 
     */
    @MavlinkEntryInfo(1)
    GIMBAL_AXIS_CALIBRATION_REQUIRED_TRUE,

    /**
     * This axis does not require calibration. 
     */
    @MavlinkEntryInfo(2)
    GIMBAL_AXIS_CALIBRATION_REQUIRED_FALSE
}
