package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum GoproFieldOfView {
  /**
   * 0x00: Wide
   */
  @MavlinkEnumEntry(0)
  GOPRO_FIELD_OF_VIEW_WIDE,

  /**
   * 0x01: Medium
   */
  @MavlinkEnumEntry(1)
  GOPRO_FIELD_OF_VIEW_MEDIUM,

  /**
   * 0x02: Narrow
   */
  @MavlinkEnumEntry(2)
  GOPRO_FIELD_OF_VIEW_NARROW
}
