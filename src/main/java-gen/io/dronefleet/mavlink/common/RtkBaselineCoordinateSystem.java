package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * RTK GPS baseline coordinate system, used for RTK corrections 
 */
@MavlinkEnum
public enum RtkBaselineCoordinateSystem {
  /**
   * Earth-centered, Earth-fixed
   */
  @MavlinkEnumEntry(0)
  RTK_BASELINE_COORDINATE_SYSTEM_ECEF,

  /**
   * North, East, Down
   */
  @MavlinkEnumEntry(1)
  RTK_BASELINE_COORDINATE_SYSTEM_NED
}
