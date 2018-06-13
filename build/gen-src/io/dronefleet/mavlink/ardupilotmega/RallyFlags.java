package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Flags in RALLY_POINT message 
 */
@MavlinkEnum
public enum RallyFlags {
  /**
   * Flag set when requiring favorable winds for landing.
   */
  @MavlinkEnumEntry(1)
  FAVORABLE_WIND,

  /**
   * Flag set when plane is to immediately descend to break altitude and land without GCS intervention. Flag not set when plane is to loiter at Rally point until commanded to land.
   */
  @MavlinkEnumEntry(2)
  LAND_IMMEDIATELY
}
