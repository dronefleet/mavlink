package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Special ACK block numbers control activation of dataflash log streaming 
 */
@MavlinkEnum
public enum MavRemoteLogDataBlockCommands {
  /**
   * UAV to stop sending DataFlash blocks
   */
  @MavlinkEntryInfo(2147483645)
  MAV_REMOTE_LOG_DATA_BLOCK_STOP,

  /**
   * UAV to start sending DataFlash blocks
   */
  @MavlinkEntryInfo(2147483646)
  MAV_REMOTE_LOG_DATA_BLOCK_START
}
