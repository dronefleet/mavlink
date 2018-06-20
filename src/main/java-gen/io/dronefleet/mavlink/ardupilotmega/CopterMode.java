package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * A mapping of copter flight modes for custom_mode field of heartbeat 
 */
@MavlinkEnum
public enum CopterMode {
  /**
   * null
   */
  @MavlinkEntryInfo(0)
  COPTER_MODE_STABILIZE,

  /**
   * null
   */
  @MavlinkEntryInfo(1)
  COPTER_MODE_ACRO,

  /**
   * null
   */
  @MavlinkEntryInfo(2)
  COPTER_MODE_ALT_HOLD,

  /**
   * null
   */
  @MavlinkEntryInfo(3)
  COPTER_MODE_AUTO,

  /**
   * null
   */
  @MavlinkEntryInfo(4)
  COPTER_MODE_GUIDED,

  /**
   * null
   */
  @MavlinkEntryInfo(5)
  COPTER_MODE_LOITER,

  /**
   * null
   */
  @MavlinkEntryInfo(6)
  COPTER_MODE_RTL,

  /**
   * null
   */
  @MavlinkEntryInfo(7)
  COPTER_MODE_CIRCLE,

  /**
   * null
   */
  @MavlinkEntryInfo(9)
  COPTER_MODE_LAND,

  /**
   * null
   */
  @MavlinkEntryInfo(11)
  COPTER_MODE_DRIFT,

  /**
   * null
   */
  @MavlinkEntryInfo(13)
  COPTER_MODE_SPORT,

  /**
   * null
   */
  @MavlinkEntryInfo(14)
  COPTER_MODE_FLIP,

  /**
   * null
   */
  @MavlinkEntryInfo(15)
  COPTER_MODE_AUTOTUNE,

  /**
   * null
   */
  @MavlinkEntryInfo(16)
  COPTER_MODE_POSHOLD,

  /**
   * null
   */
  @MavlinkEntryInfo(17)
  COPTER_MODE_BRAKE,

  /**
   * null
   */
  @MavlinkEntryInfo(18)
  COPTER_MODE_THROW,

  /**
   * null
   */
  @MavlinkEntryInfo(19)
  COPTER_MODE_AVOID_ADSB,

  /**
   * null
   */
  @MavlinkEntryInfo(20)
  COPTER_MODE_GUIDED_NOGPS,

  /**
   * null
   */
  @MavlinkEntryInfo(21)
  COPTER_MODE_SMART_RTL
}
