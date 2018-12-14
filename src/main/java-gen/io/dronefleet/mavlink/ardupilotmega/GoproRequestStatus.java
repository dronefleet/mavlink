package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum GoproRequestStatus {
    /**
     * The write message with ID indicated succeeded. 
     */
    @MavlinkEntryInfo(0)
    GOPRO_REQUEST_SUCCESS,

    /**
     * The write message with ID indicated failed. 
     */
    @MavlinkEntryInfo(1)
    GOPRO_REQUEST_FAILED
}
