package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum GimbalAxisCalibrationRequired {
  /**
   * Whether or not this axis requires calibration is unknown at this time
   */
  @MavlinkEnumEntry(0)
  GIMBAL_AXIS_CALIBRATION_REQUIRED_UNKNOWN,

  /**
   * This axis requires calibration
   */
  @MavlinkEnumEntry(1)
  GIMBAL_AXIS_CALIBRATION_REQUIRED_TRUE,

  /**
   * This axis does not require calibration
   */
  @MavlinkEnumEntry(2)
  GIMBAL_AXIS_CALIBRATION_REQUIRED_FALSE
}
