package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum GimbalAxisCalibrationStatus {
  /**
   * Axis calibration is in progress
   */
  @MavlinkEnumEntry(0)
  GIMBAL_AXIS_CALIBRATION_STATUS_IN_PROGRESS,

  /**
   * Axis calibration succeeded
   */
  @MavlinkEnumEntry(1)
  GIMBAL_AXIS_CALIBRATION_STATUS_SUCCEEDED,

  /**
   * Axis calibration failed
   */
  @MavlinkEnumEntry(2)
  GIMBAL_AXIS_CALIBRATION_STATUS_FAILED
}
