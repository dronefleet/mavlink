package io.dronefleet.mavlink.autoquad;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Track current version of these definitions (can be used by checking value of 
 * AUTOQUAD_MAVLINK_DEFS_VERSION_ENUM_END). Append a new entry for each published change. 
 */
@MavlinkEnum
public enum AutoquadMavlinkDefsVersion {
  /**
   * null
   */
  @MavlinkEntryInfo(1)
  AQ_MAVLINK_DEFS_VERSION_1
}
