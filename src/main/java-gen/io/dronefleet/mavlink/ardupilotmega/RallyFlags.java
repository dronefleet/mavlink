package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Flags in RALLY_POINT message 
 */
@MavlinkEnum
public enum RallyFlags {
  /**
   * Flag set when requiring favorable winds for landing.
   */
  @MavlinkEntryInfo(1)
  FAVORABLE_WIND,

  /**
   * Flag set when plane is to immediately descend to break altitude and land without GCS intervention. Flag not set when plane is to loiter at Rally point until commanded to land.
   */
  @MavlinkEntryInfo(2)
  LAND_IMMEDIATELY
}
