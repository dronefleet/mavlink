package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum MagCalStatus {
  /**
   * null
   */
  @MavlinkEntryInfo(0)
  MAG_CAL_NOT_STARTED,

  /**
   * null
   */
  @MavlinkEntryInfo(1)
  MAG_CAL_WAITING_TO_START,

  /**
   * null
   */
  @MavlinkEntryInfo(2)
  MAG_CAL_RUNNING_STEP_ONE,

  /**
   * null
   */
  @MavlinkEntryInfo(3)
  MAG_CAL_RUNNING_STEP_TWO,

  /**
   * null
   */
  @MavlinkEntryInfo(4)
  MAG_CAL_SUCCESS,

  /**
   * null
   */
  @MavlinkEntryInfo(5)
  MAG_CAL_FAILED
}
