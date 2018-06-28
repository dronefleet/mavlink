package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum GoproProtuneSharpness {
    /**
     * Low Sharpness 
     */
    @MavlinkEntryInfo(0)
    GOPRO_PROTUNE_SHARPNESS_LOW,

    /**
     * Medium Sharpness 
     */
    @MavlinkEntryInfo(1)
    GOPRO_PROTUNE_SHARPNESS_MEDIUM,

    /**
     * High Sharpness 
     */
    @MavlinkEntryInfo(2)
    GOPRO_PROTUNE_SHARPNESS_HIGH
}
