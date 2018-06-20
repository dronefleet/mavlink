package io.dronefleet.mavlink.autoquad;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Available operating modes/statuses for AutoQuad flight controller. Bitmask up to 32 bits. 
 * Low side bits for base modes, high side for additional active 
 * features/modifiers/constraints. 
 */
@MavlinkEnum
public enum AutoquadNavStatus {
  /**
   * System is initializing
   */
  @MavlinkEntryInfo(0)
  AQ_NAV_STATUS_INIT,

  /**
   * System is *armed* and standing by, with no throttle input and no autonomous mode
   */
  @MavlinkEntryInfo(1)
  AQ_NAV_STATUS_STANDBY,

  /**
   * Flying (throttle input detected), assumed under manual control unless other mode bits are set
   */
  @MavlinkEntryInfo(2)
  AQ_NAV_STATUS_MANUAL,

  /**
   * Altitude hold engaged
   */
  @MavlinkEntryInfo(4)
  AQ_NAV_STATUS_ALTHOLD,

  /**
   * Position hold engaged
   */
  @MavlinkEntryInfo(8)
  AQ_NAV_STATUS_POSHOLD,

  /**
   * Externally-guided (eg. GCS) navigation mode
   */
  @MavlinkEntryInfo(16)
  AQ_NAV_STATUS_GUIDED,

  /**
   * Autonomous mission execution mode
   */
  @MavlinkEntryInfo(32)
  AQ_NAV_STATUS_MISSION,

  /**
   * Ready but *not armed*
   */
  @MavlinkEntryInfo(256)
  AQ_NAV_STATUS_READY,

  /**
   * Calibration mode active
   */
  @MavlinkEntryInfo(512)
  AQ_NAV_STATUS_CALIBRATING,

  /**
   * No valid control input (eg. no radio link)
   */
  @MavlinkEntryInfo(4096)
  AQ_NAV_STATUS_NO_RC,

  /**
   * Battery is low (stage 1 warning)
   */
  @MavlinkEntryInfo(8192)
  AQ_NAV_STATUS_FUEL_LOW,

  /**
   * Battery is depleted (stage 2 warning)
   */
  @MavlinkEntryInfo(16384)
  AQ_NAV_STATUS_FUEL_CRITICAL,

  /**
   * Dynamic Velocity Hold is active (PH with proportional manual direction override)
   */
  @MavlinkEntryInfo(16777216)
  AQ_NAV_STATUS_DVH,

  /**
   * ynamic Altitude Override is active (AH with proportional manual adjustment)
   */
  @MavlinkEntryInfo(33554432)
  AQ_NAV_STATUS_DAO,

  /**
   * Craft is at ceiling altitude
   */
  @MavlinkEntryInfo(67108864)
  AQ_NAV_STATUS_CEILING_REACHED,

  /**
   * Ceiling altitude is set
   */
  @MavlinkEntryInfo(134217728)
  AQ_NAV_STATUS_CEILING,

  /**
   * Heading-Free dynamic mode active
   */
  @MavlinkEntryInfo(268435456)
  AQ_NAV_STATUS_HF_DYNAMIC,

  /**
   * Heading-Free locked mode active
   */
  @MavlinkEntryInfo(536870912)
  AQ_NAV_STATUS_HF_LOCKED,

  /**
   * Automatic Return to Home is active
   */
  @MavlinkEntryInfo(1073741824)
  AQ_NAV_STATUS_RTH,

  /**
   * System is in failsafe recovery mode
   */
  @MavlinkEntryInfo(-2147483648)
  AQ_NAV_STATUS_FAILSAFE
}
