package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum FenceAction {
  /**
   * Disable fenced mode
   */
  @MavlinkEntryInfo(0)
  FENCE_ACTION_NONE,

  /**
   * Switched to guided mode to return point (fence point 0)
   */
  @MavlinkEntryInfo(1)
  FENCE_ACTION_GUIDED,

  /**
   * Report fence breach, but don't take action
   */
  @MavlinkEntryInfo(2)
  FENCE_ACTION_REPORT,

  /**
   * Switched to guided mode to return point (fence point 0) with manual throttle control
   */
  @MavlinkEntryInfo(3)
  FENCE_ACTION_GUIDED_THR_PASS,

  /**
   * Switch to RTL (return to launch) mode and head for the return point.
   */
  @MavlinkEntryInfo(4)
  FENCE_ACTION_RTL
}
