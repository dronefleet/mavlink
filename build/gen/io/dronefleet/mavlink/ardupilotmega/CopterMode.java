package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * A mapping of copter flight modes for custom_mode field of heartbeat 
 */
@MavlinkEnum
public enum CopterMode {
  /**
   * null
   */
  @MavlinkEnumEntry(0)
  COPTER_MODE_STABILIZE,

  /**
   * null
   */
  @MavlinkEnumEntry(1)
  COPTER_MODE_ACRO,

  /**
   * null
   */
  @MavlinkEnumEntry(2)
  COPTER_MODE_ALT_HOLD,

  /**
   * null
   */
  @MavlinkEnumEntry(3)
  COPTER_MODE_AUTO,

  /**
   * null
   */
  @MavlinkEnumEntry(4)
  COPTER_MODE_GUIDED,

  /**
   * null
   */
  @MavlinkEnumEntry(5)
  COPTER_MODE_LOITER,

  /**
   * null
   */
  @MavlinkEnumEntry(6)
  COPTER_MODE_RTL,

  /**
   * null
   */
  @MavlinkEnumEntry(7)
  COPTER_MODE_CIRCLE,

  /**
   * null
   */
  @MavlinkEnumEntry(9)
  COPTER_MODE_LAND,

  /**
   * null
   */
  @MavlinkEnumEntry(11)
  COPTER_MODE_DRIFT,

  /**
   * null
   */
  @MavlinkEnumEntry(13)
  COPTER_MODE_SPORT,

  /**
   * null
   */
  @MavlinkEnumEntry(14)
  COPTER_MODE_FLIP,

  /**
   * null
   */
  @MavlinkEnumEntry(15)
  COPTER_MODE_AUTOTUNE,

  /**
   * null
   */
  @MavlinkEnumEntry(16)
  COPTER_MODE_POSHOLD,

  /**
   * null
   */
  @MavlinkEnumEntry(17)
  COPTER_MODE_BRAKE,

  /**
   * null
   */
  @MavlinkEnumEntry(18)
  COPTER_MODE_THROW,

  /**
   * null
   */
  @MavlinkEnumEntry(19)
  COPTER_MODE_AVOID_ADSB,

  /**
   * null
   */
  @MavlinkEnumEntry(20)
  COPTER_MODE_GUIDED_NOGPS,

  /**
   * null
   */
  @MavlinkEnumEntry(21)
  COPTER_MODE_SMART_RTL
}
