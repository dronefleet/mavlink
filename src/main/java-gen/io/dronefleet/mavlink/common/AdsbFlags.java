package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * These flags indicate status such as data validity of each data source. Set = data valid 
 */
@MavlinkEnum
public enum AdsbFlags {
  /**
   * null
   */
  @MavlinkEntryInfo(1)
  ADSB_FLAGS_VALID_COORDS,

  /**
   * null
   */
  @MavlinkEntryInfo(2)
  ADSB_FLAGS_VALID_ALTITUDE,

  /**
   * null
   */
  @MavlinkEntryInfo(4)
  ADSB_FLAGS_VALID_HEADING,

  /**
   * null
   */
  @MavlinkEntryInfo(8)
  ADSB_FLAGS_VALID_VELOCITY,

  /**
   * null
   */
  @MavlinkEntryInfo(16)
  ADSB_FLAGS_VALID_CALLSIGN,

  /**
   * null
   */
  @MavlinkEntryInfo(32)
  ADSB_FLAGS_VALID_SQUAWK,

  /**
   * null
   */
  @MavlinkEntryInfo(64)
  ADSB_FLAGS_SIMULATED
}
