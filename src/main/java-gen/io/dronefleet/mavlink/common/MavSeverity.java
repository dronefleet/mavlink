package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

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
  @MavlinkEntryInfo(0)
  MAV_SEVERITY_EMERGENCY,

  /**
   * Action should be taken immediately. Indicates error in non-critical systems.
   */
  @MavlinkEntryInfo(1)
  MAV_SEVERITY_ALERT,

  /**
   * Action must be taken immediately. Indicates failure in a primary system.
   */
  @MavlinkEntryInfo(2)
  MAV_SEVERITY_CRITICAL,

  /**
   * Indicates an error in secondary/redundant systems.
   */
  @MavlinkEntryInfo(3)
  MAV_SEVERITY_ERROR,

  /**
   * Indicates about a possible future error if this is not resolved within a given timeframe. Example would be a low battery warning.
   */
  @MavlinkEntryInfo(4)
  MAV_SEVERITY_WARNING,

  /**
   * An unusual event has occured, though not an error condition. This should be investigated for the root cause.
   */
  @MavlinkEntryInfo(5)
  MAV_SEVERITY_NOTICE,

  /**
   * Normal operational messages. Useful for logging. No action is required for these messages.
   */
  @MavlinkEntryInfo(6)
  MAV_SEVERITY_INFO,

  /**
   * Useful non-operational messages that can assist in debugging. These should not occur during normal operation.
   */
  @MavlinkEntryInfo(7)
  MAV_SEVERITY_DEBUG
}
