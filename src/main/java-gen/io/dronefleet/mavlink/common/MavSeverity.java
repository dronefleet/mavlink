package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Indicates the severity level, generally used for status messages to indicate their relative 
 * urgency. Based on RFC-5424 using expanded definitions at: 
 * http://www.kiwisyslog.com/kb/info:-syslog-message-levels/. 
 */
@MavlinkEnum
public enum MavSeverity {
  /**
   * System is unusable. This is a "panic" condition.
   */
  @MavlinkEnumEntry(0)
  MAV_SEVERITY_EMERGENCY,

  /**
   * Action should be taken immediately. Indicates error in non-critical systems.
   */
  @MavlinkEnumEntry(1)
  MAV_SEVERITY_ALERT,

  /**
   * Action must be taken immediately. Indicates failure in a primary system.
   */
  @MavlinkEnumEntry(2)
  MAV_SEVERITY_CRITICAL,

  /**
   * Indicates an error in secondary/redundant systems.
   */
  @MavlinkEnumEntry(3)
  MAV_SEVERITY_ERROR,

  /**
   * Indicates about a possible future error if this is not resolved within a given timeframe. Example would be a low battery warning.
   */
  @MavlinkEnumEntry(4)
  MAV_SEVERITY_WARNING,

  /**
   * An unusual event has occured, though not an error condition. This should be investigated for the root cause.
   */
  @MavlinkEnumEntry(5)
  MAV_SEVERITY_NOTICE,

  /**
   * Normal operational messages. Useful for logging. No action is required for these messages.
   */
  @MavlinkEnumEntry(6)
  MAV_SEVERITY_INFO,

  /**
   * Useful non-operational messages that can assist in debugging. These should not occur during normal operation.
   */
  @MavlinkEnumEntry(7)
  MAV_SEVERITY_DEBUG
}
