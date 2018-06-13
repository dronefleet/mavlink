package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum LimitModule {
  /**
   * pre-initialization
   */
  @MavlinkEnumEntry(1)
  LIMIT_GPSLOCK,

  /**
   * disabled
   */
  @MavlinkEnumEntry(2)
  LIMIT_GEOFENCE,

  /**
   * checking limits
   */
  @MavlinkEnumEntry(4)
  LIMIT_ALTITUDE
}
