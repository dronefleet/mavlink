package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Bitmask of options for the MAV_CMD_DO_REPOSITION 
 */
@MavlinkEnum
public enum MavDoRepositionFlags {
  /**
   * The aircraft should immediately transition into guided. This should not be set for follow me applications
   */
  @MavlinkEnumEntry(1)
  MAV_DO_REPOSITION_FLAGS_CHANGE_MODE
}
