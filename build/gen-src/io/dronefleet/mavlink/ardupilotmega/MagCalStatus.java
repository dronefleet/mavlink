package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum MagCalStatus {
  /**
   * null
   */
  @MavlinkEnumEntry(0)
  MAG_CAL_NOT_STARTED,

  /**
   * null
   */
  @MavlinkEnumEntry(1)
  MAG_CAL_WAITING_TO_START,

  /**
   * null
   */
  @MavlinkEnumEntry(2)
  MAG_CAL_RUNNING_STEP_ONE,

  /**
   * null
   */
  @MavlinkEnumEntry(3)
  MAG_CAL_RUNNING_STEP_TWO,

  /**
   * null
   */
  @MavlinkEnumEntry(4)
  MAG_CAL_SUCCESS,

  /**
   * null
   */
  @MavlinkEnumEntry(5)
  MAG_CAL_FAILED
}
