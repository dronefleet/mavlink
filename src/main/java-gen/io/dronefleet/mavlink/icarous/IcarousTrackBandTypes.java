package io.dronefleet.mavlink.icarous;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum IcarousTrackBandTypes {
  /**
   * null
   */
  @MavlinkEnumEntry(0)
  ICAROUS_TRACK_BAND_TYPE_NONE,

  /**
   * null
   */
  @MavlinkEnumEntry(1)
  ICAROUS_TRACK_BAND_TYPE_NEAR,

  /**
   * null
   */
  @MavlinkEnumEntry(2)
  ICAROUS_TRACK_BAND_TYPE_RECOVERY
}
