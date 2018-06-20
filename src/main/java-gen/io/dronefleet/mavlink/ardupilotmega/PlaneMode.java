package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * A mapping of plane flight modes for custom_mode field of heartbeat 
 */
@MavlinkEnum
public enum PlaneMode {
  /**
   * null
   */
  @MavlinkEntryInfo(0)
  PLANE_MODE_MANUAL,

  /**
   * null
   */
  @MavlinkEntryInfo(1)
  PLANE_MODE_CIRCLE,

  /**
   * null
   */
  @MavlinkEntryInfo(2)
  PLANE_MODE_STABILIZE,

  /**
   * null
   */
  @MavlinkEntryInfo(3)
  PLANE_MODE_TRAINING,

  /**
   * null
   */
  @MavlinkEntryInfo(4)
  PLANE_MODE_ACRO,

  /**
   * null
   */
  @MavlinkEntryInfo(5)
  PLANE_MODE_FLY_BY_WIRE_A,

  /**
   * null
   */
  @MavlinkEntryInfo(6)
  PLANE_MODE_FLY_BY_WIRE_B,

  /**
   * null
   */
  @MavlinkEntryInfo(7)
  PLANE_MODE_CRUISE,

  /**
   * null
   */
  @MavlinkEntryInfo(8)
  PLANE_MODE_AUTOTUNE,

  /**
   * null
   */
  @MavlinkEntryInfo(10)
  PLANE_MODE_AUTO,

  /**
   * null
   */
  @MavlinkEntryInfo(11)
  PLANE_MODE_RTL,

  /**
   * null
   */
  @MavlinkEntryInfo(12)
  PLANE_MODE_LOITER,

  /**
   * null
   */
  @MavlinkEntryInfo(14)
  PLANE_MODE_AVOID_ADSB,

  /**
   * null
   */
  @MavlinkEntryInfo(15)
  PLANE_MODE_GUIDED,

  /**
   * null
   */
  @MavlinkEntryInfo(16)
  PLANE_MODE_INITIALIZING,

  /**
   * null
   */
  @MavlinkEntryInfo(17)
  PLANE_MODE_QSTABILIZE,

  /**
   * null
   */
  @MavlinkEntryInfo(18)
  PLANE_MODE_QHOVER,

  /**
   * null
   */
  @MavlinkEntryInfo(19)
  PLANE_MODE_QLOITER,

  /**
   * null
   */
  @MavlinkEntryInfo(20)
  PLANE_MODE_QLAND,

  /**
   * null
   */
  @MavlinkEntryInfo(21)
  PLANE_MODE_QRTL
}
