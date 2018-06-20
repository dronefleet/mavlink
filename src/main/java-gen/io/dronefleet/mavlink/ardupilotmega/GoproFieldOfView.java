package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum GoproFieldOfView {
  /**
   * 0x00: Wide
   */
  @MavlinkEntryInfo(0)
  GOPRO_FIELD_OF_VIEW_WIDE,

  /**
   * 0x01: Medium
   */
  @MavlinkEntryInfo(1)
  GOPRO_FIELD_OF_VIEW_MEDIUM,

  /**
   * 0x02: Narrow
   */
  @MavlinkEntryInfo(2)
  GOPRO_FIELD_OF_VIEW_NARROW
}
