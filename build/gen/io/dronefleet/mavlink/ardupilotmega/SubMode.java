package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * A mapping of sub flight modes for custom_mode field of heartbeat 
 */
@MavlinkEnum
public enum SubMode {
  /**
   * null
   */
  @MavlinkEnumEntry(0)
  SUB_MODE_STABILIZE,

  /**
   * null
   */
  @MavlinkEnumEntry(1)
  SUB_MODE_ACRO,

  /**
   * null
   */
  @MavlinkEnumEntry(2)
  SUB_MODE_ALT_HOLD,

  /**
   * null
   */
  @MavlinkEnumEntry(3)
  SUB_MODE_AUTO,

  /**
   * null
   */
  @MavlinkEnumEntry(4)
  SUB_MODE_GUIDED,

  /**
   * null
   */
  @MavlinkEnumEntry(7)
  SUB_MODE_CIRCLE,

  /**
   * null
   */
  @MavlinkEnumEntry(9)
  SUB_MODE_SURFACE,

  /**
   * null
   */
  @MavlinkEnumEntry(16)
  SUB_MODE_POSHOLD,

  /**
   * null
   */
  @MavlinkEnumEntry(19)
  SUB_MODE_MANUAL
}
