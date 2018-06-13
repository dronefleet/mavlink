package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum FenceBreach {
  /**
   * No last fence breach
   */
  @MavlinkEnumEntry(0)
  FENCE_BREACH_NONE,

  /**
   * Breached minimum altitude
   */
  @MavlinkEnumEntry(1)
  FENCE_BREACH_MINALT,

  /**
   * Breached maximum altitude
   */
  @MavlinkEnumEntry(2)
  FENCE_BREACH_MAXALT,

  /**
   * Breached fence boundary
   */
  @MavlinkEnumEntry(3)
  FENCE_BREACH_BOUNDARY
}
