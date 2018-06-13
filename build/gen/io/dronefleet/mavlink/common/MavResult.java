package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * result from a mavlink command 
 */
@MavlinkEnum
public enum MavResult {
  /**
   * Command ACCEPTED and EXECUTED
   */
  @MavlinkEnumEntry(0)
  MAV_RESULT_ACCEPTED,

  /**
   * Command TEMPORARY REJECTED/DENIED
   */
  @MavlinkEnumEntry(1)
  MAV_RESULT_TEMPORARILY_REJECTED,

  /**
   * Command PERMANENTLY DENIED
   */
  @MavlinkEnumEntry(2)
  MAV_RESULT_DENIED,

  /**
   * Command UNKNOWN/UNSUPPORTED
   */
  @MavlinkEnumEntry(3)
  MAV_RESULT_UNSUPPORTED,

  /**
   * Command executed, but failed
   */
  @MavlinkEnumEntry(4)
  MAV_RESULT_FAILED,

  /**
   * WIP: Command being executed
   */
  @MavlinkEnumEntry(5)
  MAV_RESULT_IN_PROGRESS
}
