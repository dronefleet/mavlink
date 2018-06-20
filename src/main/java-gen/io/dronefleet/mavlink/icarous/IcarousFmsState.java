package io.dronefleet.mavlink.icarous;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum IcarousFmsState {
  /**
   * null
   */
  @MavlinkEntryInfo(0)
  ICAROUS_FMS_STATE_IDLE,

  /**
   * null
   */
  @MavlinkEntryInfo(1)
  ICAROUS_FMS_STATE_TAKEOFF,

  /**
   * null
   */
  @MavlinkEntryInfo(2)
  ICAROUS_FMS_STATE_CLIMB,

  /**
   * null
   */
  @MavlinkEntryInfo(3)
  ICAROUS_FMS_STATE_CRUISE,

  /**
   * null
   */
  @MavlinkEntryInfo(4)
  ICAROUS_FMS_STATE_APPROACH,

  /**
   * null
   */
  @MavlinkEntryInfo(5)
  ICAROUS_FMS_STATE_LAND
}
