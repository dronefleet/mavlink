package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum GimbalAxis {
  /**
   * Gimbal yaw axis
   */
  @MavlinkEnumEntry(0)
  GIMBAL_AXIS_YAW,

  /**
   * Gimbal pitch axis
   */
  @MavlinkEnumEntry(1)
  GIMBAL_AXIS_PITCH,

  /**
   * Gimbal roll axis
   */
  @MavlinkEnumEntry(2)
  GIMBAL_AXIS_ROLL
}
