package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum GoproHeartbeatFlags {
  /**
   * GoPro is currently recording
   */
  @MavlinkEnumEntry(1)
  GOPRO_FLAG_RECORDING
}
