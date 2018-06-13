package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum GoproHeartbeatStatus {
  /**
   * No GoPro connected
   */
  @MavlinkEnumEntry(0)
  GOPRO_HEARTBEAT_STATUS_DISCONNECTED,

  /**
   * The detected GoPro is not HeroBus compatible
   */
  @MavlinkEnumEntry(1)
  GOPRO_HEARTBEAT_STATUS_INCOMPATIBLE,

  /**
   * A HeroBus compatible GoPro is connected
   */
  @MavlinkEnumEntry(2)
  GOPRO_HEARTBEAT_STATUS_CONNECTED,

  /**
   * An unrecoverable error was encountered with the connected GoPro, it may require a power cycle
   */
  @MavlinkEnumEntry(3)
  GOPRO_HEARTBEAT_STATUS_ERROR
}
