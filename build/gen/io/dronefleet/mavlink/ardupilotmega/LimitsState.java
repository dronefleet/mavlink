package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum LimitsState {
  /**
   * pre-initialization
   */
  @MavlinkEnumEntry(0)
  LIMITS_INIT,

  /**
   * disabled
   */
  @MavlinkEnumEntry(1)
  LIMITS_DISABLED,

  /**
   * checking limits
   */
  @MavlinkEnumEntry(2)
  LIMITS_ENABLED,

  /**
   * a limit has been breached
   */
  @MavlinkEnumEntry(3)
  LIMITS_TRIGGERED,

  /**
   * taking action eg. RTL
   */
  @MavlinkEnumEntry(4)
  LIMITS_RECOVERING,

  /**
   * we're no longer in breach of a limit
   */
  @MavlinkEnumEntry(5)
  LIMITS_RECOVERED
}
