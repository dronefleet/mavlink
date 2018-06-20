package io.dronefleet.mavlink.icarous;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum IcarousTrackBandTypes {
  /**
   * null
   */
  @MavlinkEntryInfo(0)
  ICAROUS_TRACK_BAND_TYPE_NONE,

  /**
   * null
   */
  @MavlinkEntryInfo(1)
  ICAROUS_TRACK_BAND_TYPE_NEAR,

  /**
   * null
   */
  @MavlinkEntryInfo(2)
  ICAROUS_TRACK_BAND_TYPE_RECOVERY
}
