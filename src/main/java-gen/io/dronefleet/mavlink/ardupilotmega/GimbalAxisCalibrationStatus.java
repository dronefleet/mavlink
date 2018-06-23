package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum GimbalAxisCalibrationStatus {
    /**
     * Axis calibration is in progress<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    GIMBAL_AXIS_CALIBRATION_STATUS_IN_PROGRESS,

    /**
     * Axis calibration succeeded<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    GIMBAL_AXIS_CALIBRATION_STATUS_SUCCEEDED,

    /**
     * Axis calibration failed<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    GIMBAL_AXIS_CALIBRATION_STATUS_FAILED
}
