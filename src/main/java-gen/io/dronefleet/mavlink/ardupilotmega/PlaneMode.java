package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * A mapping of plane flight modes for custom_mode field of heartbeat 
 */
@MavlinkEnum
public enum PlaneMode {
  /**
   * null
   */
  @MavlinkEnumEntry(0)
  PLANE_MODE_MANUAL,

  /**
   * null
   */
  @MavlinkEnumEntry(1)
  PLANE_MODE_CIRCLE,

  /**
   * null
   */
  @MavlinkEnumEntry(2)
  PLANE_MODE_STABILIZE,

  /**
   * null
   */
  @MavlinkEnumEntry(3)
  PLANE_MODE_TRAINING,

  /**
   * null
   */
  @MavlinkEnumEntry(4)
  PLANE_MODE_ACRO,

  /**
   * null
   */
  @MavlinkEnumEntry(5)
  PLANE_MODE_FLY_BY_WIRE_A,

  /**
   * null
   */
  @MavlinkEnumEntry(6)
  PLANE_MODE_FLY_BY_WIRE_B,

  /**
   * null
   */
  @MavlinkEnumEntry(7)
  PLANE_MODE_CRUISE,

  /**
   * null
   */
  @MavlinkEnumEntry(8)
  PLANE_MODE_AUTOTUNE,

  /**
   * null
   */
  @MavlinkEnumEntry(10)
  PLANE_MODE_AUTO,

  /**
   * null
   */
  @MavlinkEnumEntry(11)
  PLANE_MODE_RTL,

  /**
   * null
   */
  @MavlinkEnumEntry(12)
  PLANE_MODE_LOITER,

  /**
   * null
   */
  @MavlinkEnumEntry(14)
  PLANE_MODE_AVOID_ADSB,

  /**
   * null
   */
  @MavlinkEnumEntry(15)
  PLANE_MODE_GUIDED,

  /**
   * null
   */
  @MavlinkEnumEntry(16)
  PLANE_MODE_INITIALIZING,

  /**
   * null
   */
  @MavlinkEnumEntry(17)
  PLANE_MODE_QSTABILIZE,

  /**
   * null
   */
  @MavlinkEnumEntry(18)
  PLANE_MODE_QHOVER,

  /**
   * null
   */
  @MavlinkEnumEntry(19)
  PLANE_MODE_QLOITER,

  /**
   * null
   */
  @MavlinkEnumEntry(20)
  PLANE_MODE_QLAND,

  /**
   * null
   */
  @MavlinkEnumEntry(21)
  PLANE_MODE_QRTL
}
