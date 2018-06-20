package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum FenceBreach {
  /**
   * No last fence breach
   */
  @MavlinkEntryInfo(0)
  FENCE_BREACH_NONE,

  /**
   * Breached minimum altitude
   */
  @MavlinkEntryInfo(1)
  FENCE_BREACH_MINALT,

  /**
   * Breached maximum altitude
   */
  @MavlinkEntryInfo(2)
  FENCE_BREACH_MAXALT,

  /**
   * Breached fence boundary
   */
  @MavlinkEntryInfo(3)
  FENCE_BREACH_BOUNDARY
}
