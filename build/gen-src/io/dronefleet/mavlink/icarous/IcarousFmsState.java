package io.dronefleet.mavlink.icarous;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum IcarousFmsState {
  /**
   * null
   */
  @MavlinkEnumEntry(0)
  ICAROUS_FMS_STATE_IDLE,

  /**
   * null
   */
  @MavlinkEnumEntry(1)
  ICAROUS_FMS_STATE_TAKEOFF,

  /**
   * null
   */
  @MavlinkEnumEntry(2)
  ICAROUS_FMS_STATE_CLIMB,

  /**
   * null
   */
  @MavlinkEnumEntry(3)
  ICAROUS_FMS_STATE_CRUISE,

  /**
   * null
   */
  @MavlinkEnumEntry(4)
  ICAROUS_FMS_STATE_APPROACH,

  /**
   * null
   */
  @MavlinkEnumEntry(5)
  ICAROUS_FMS_STATE_LAND
}
