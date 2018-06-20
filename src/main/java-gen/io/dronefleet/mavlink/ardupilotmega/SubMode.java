package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * A mapping of sub flight modes for custom_mode field of heartbeat 
 */
@MavlinkEnum
public enum SubMode {
  /**
   * null
   */
  @MavlinkEntryInfo(0)
  SUB_MODE_STABILIZE,

  /**
   * null
   */
  @MavlinkEntryInfo(1)
  SUB_MODE_ACRO,

  /**
   * null
   */
  @MavlinkEntryInfo(2)
  SUB_MODE_ALT_HOLD,

  /**
   * null
   */
  @MavlinkEntryInfo(3)
  SUB_MODE_AUTO,

  /**
   * null
   */
  @MavlinkEntryInfo(4)
  SUB_MODE_GUIDED,

  /**
   * null
   */
  @MavlinkEntryInfo(7)
  SUB_MODE_CIRCLE,

  /**
   * null
   */
  @MavlinkEntryInfo(9)
  SUB_MODE_SURFACE,

  /**
   * null
   */
  @MavlinkEntryInfo(16)
  SUB_MODE_POSHOLD,

  /**
   * null
   */
  @MavlinkEntryInfo(19)
  SUB_MODE_MANUAL
}
