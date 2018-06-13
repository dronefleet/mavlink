package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Possible remote log data block statuses 
 */
@MavlinkEnum
public enum MavRemoteLogDataBlockStatuses {
  /**
   * This block has NOT been received
   */
  @MavlinkEnumEntry(0)
  MAV_REMOTE_LOG_DATA_BLOCK_NACK,

  /**
   * This block has been received
   */
  @MavlinkEnumEntry(1)
  MAV_REMOTE_LOG_DATA_BLOCK_ACK
}
