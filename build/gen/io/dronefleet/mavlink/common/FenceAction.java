package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum FenceAction {
  /**
   * Disable fenced mode
   */
  @MavlinkEnumEntry(0)
  FENCE_ACTION_NONE,

  /**
   * Switched to guided mode to return point (fence point 0)
   */
  @MavlinkEnumEntry(1)
  FENCE_ACTION_GUIDED,

  /**
   * Report fence breach, but don't take action
   */
  @MavlinkEnumEntry(2)
  FENCE_ACTION_REPORT,

  /**
   * Switched to guided mode to return point (fence point 0) with manual throttle control
   */
  @MavlinkEnumEntry(3)
  FENCE_ACTION_GUIDED_THR_PASS,

  /**
   * Switch to RTL (return to launch) mode and head for the return point.
   */
  @MavlinkEnumEntry(4)
  FENCE_ACTION_RTL
}
