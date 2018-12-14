package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum GoproHeartbeatStatus {
    /**
     * No GoPro connected. 
     */
    @MavlinkEntryInfo(0)
    GOPRO_HEARTBEAT_STATUS_DISCONNECTED,

    /**
     * The detected GoPro is not HeroBus compatible. 
     */
    @MavlinkEntryInfo(1)
    GOPRO_HEARTBEAT_STATUS_INCOMPATIBLE,

    /**
     * A HeroBus compatible GoPro is connected. 
     */
    @MavlinkEntryInfo(2)
    GOPRO_HEARTBEAT_STATUS_CONNECTED,

    /**
     * An unrecoverable error was encountered with the connected GoPro, it may require a power cycle. 
     */
    @MavlinkEntryInfo(3)
    GOPRO_HEARTBEAT_STATUS_ERROR
}
