package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum PidTuningAxis {
  /**
   * null
   */
  @MavlinkEnumEntry(1)
  PID_TUNING_ROLL,

  /**
   * null
   */
  @MavlinkEnumEntry(2)
  PID_TUNING_PITCH,

  /**
   * null
   */
  @MavlinkEnumEntry(3)
  PID_TUNING_YAW,

  /**
   * null
   */
  @MavlinkEnumEntry(4)
  PID_TUNING_ACCZ,

  /**
   * null
   */
  @MavlinkEnumEntry(5)
  PID_TUNING_STEER,

  /**
   * null
   */
  @MavlinkEnumEntry(6)
  PID_TUNING_LANDING
}
