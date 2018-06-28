package io.dronefleet.mavlink.icarous;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum IcarousTrackBandTypes {
    /**
     *  
     */
    @MavlinkEntryInfo(0)
    ICAROUS_TRACK_BAND_TYPE_NONE,

    /**
     *  
     */
    @MavlinkEntryInfo(1)
    ICAROUS_TRACK_BAND_TYPE_NEAR,

    /**
     *  
     */
    @MavlinkEntryInfo(2)
    ICAROUS_TRACK_BAND_TYPE_RECOVERY
}
