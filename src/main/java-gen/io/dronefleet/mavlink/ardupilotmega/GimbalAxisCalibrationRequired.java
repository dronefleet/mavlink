package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum GimbalAxisCalibrationRequired {
    /**
     * Whether or not this axis requires calibration is unknown at this time<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    GIMBAL_AXIS_CALIBRATION_REQUIRED_UNKNOWN,

    /**
     * This axis requires calibration<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    GIMBAL_AXIS_CALIBRATION_REQUIRED_TRUE,

    /**
     * This axis does not require calibration<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    GIMBAL_AXIS_CALIBRATION_REQUIRED_FALSE
}
