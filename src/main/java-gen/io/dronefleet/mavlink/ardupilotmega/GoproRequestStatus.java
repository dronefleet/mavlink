package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * null
 */
@MavlinkEnum
public enum GoproRequestStatus {
  /**
   * The write message with ID indicated succeeded
   */
  @MavlinkEnumEntry(0)
  GOPRO_REQUEST_SUCCESS,

  /**
   * The write message with ID indicated failed
   */
  @MavlinkEnumEntry(1)
  GOPRO_REQUEST_FAILED
}
