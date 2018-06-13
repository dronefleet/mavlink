package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Flags in EKF_STATUS message 
 */
@MavlinkEnum
public enum EkfStatusFlags {
  /**
   * set if EKF's attitude estimate is good
   */
  @MavlinkEnumEntry(1)
  EKF_ATTITUDE,

  /**
   * set if EKF's horizontal velocity estimate is good
   */
  @MavlinkEnumEntry(2)
  EKF_VELOCITY_HORIZ,

  /**
   * set if EKF's vertical velocity estimate is good
   */
  @MavlinkEnumEntry(4)
  EKF_VELOCITY_VERT,

  /**
   * set if EKF's horizontal position (relative) estimate is good
   */
  @MavlinkEnumEntry(8)
  EKF_POS_HORIZ_REL,

  /**
   * set if EKF's horizontal position (absolute) estimate is good
   */
  @MavlinkEnumEntry(16)
  EKF_POS_HORIZ_ABS,

  /**
   * set if EKF's vertical position (absolute) estimate is good
   */
  @MavlinkEnumEntry(32)
  EKF_POS_VERT_ABS,

  /**
   * set if EKF's vertical position (above ground) estimate is good
   */
  @MavlinkEnumEntry(64)
  EKF_POS_VERT_AGL,

  /**
   * EKF is in constant position mode and does not know it's absolute or relative position
   */
  @MavlinkEnumEntry(128)
  EKF_CONST_POS_MODE,

  /**
   * set if EKF's predicted horizontal position (relative) estimate is good
   */
  @MavlinkEnumEntry(256)
  EKF_PRED_POS_HORIZ_REL,

  /**
   * set if EKF's predicted horizontal position (absolute) estimate is good
   */
  @MavlinkEnumEntry(512)
  EKF_PRED_POS_HORIZ_ABS
}
