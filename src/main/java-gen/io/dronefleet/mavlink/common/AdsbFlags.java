package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * These flags indicate status such as data validity of each data source. Set = data valid 
 */
@MavlinkEnum
public enum AdsbFlags {
  /**
   * null
   */
  @MavlinkEnumEntry(1)
  ADSB_FLAGS_VALID_COORDS,

  /**
   * null
   */
  @MavlinkEnumEntry(2)
  ADSB_FLAGS_VALID_ALTITUDE,

  /**
   * null
   */
  @MavlinkEnumEntry(4)
  ADSB_FLAGS_VALID_HEADING,

  /**
   * null
   */
  @MavlinkEnumEntry(8)
  ADSB_FLAGS_VALID_VELOCITY,

  /**
   * null
   */
  @MavlinkEnumEntry(16)
  ADSB_FLAGS_VALID_CALLSIGN,

  /**
   * null
   */
  @MavlinkEnumEntry(32)
  ADSB_FLAGS_VALID_SQUAWK,

  /**
   * null
   */
  @MavlinkEnumEntry(64)
  ADSB_FLAGS_SIMULATED
}
