package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum LimitsState {
  /**
   * pre-initialization
   */
  @MavlinkEntryInfo(0)
  LIMITS_INIT,

  /**
   * disabled
   */
  @MavlinkEntryInfo(1)
  LIMITS_DISABLED,

  /**
   * checking limits
   */
  @MavlinkEntryInfo(2)
  LIMITS_ENABLED,

  /**
   * a limit has been breached
   */
  @MavlinkEntryInfo(3)
  LIMITS_TRIGGERED,

  /**
   * taking action eg. RTL
   */
  @MavlinkEntryInfo(4)
  LIMITS_RECOVERING,

  /**
   * we're no longer in breach of a limit
   */
  @MavlinkEntryInfo(5)
  LIMITS_RECOVERED
}
