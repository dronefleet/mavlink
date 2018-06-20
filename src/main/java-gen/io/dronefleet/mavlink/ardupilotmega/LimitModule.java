package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum LimitModule {
  /**
   * pre-initialization
   */
  @MavlinkEntryInfo(1)
  LIMIT_GPSLOCK,

  /**
   * disabled
   */
  @MavlinkEntryInfo(2)
  LIMIT_GEOFENCE,

  /**
   * checking limits
   */
  @MavlinkEntryInfo(4)
  LIMIT_ALTITUDE
}
