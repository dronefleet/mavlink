package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Possible remote log data block statuses 
 */
@MavlinkEnum
public enum MavRemoteLogDataBlockStatuses {
  /**
   * This block has NOT been received
   */
  @MavlinkEntryInfo(0)
  MAV_REMOTE_LOG_DATA_BLOCK_NACK,

  /**
   * This block has been received
   */
  @MavlinkEntryInfo(1)
  MAV_REMOTE_LOG_DATA_BLOCK_ACK
}
