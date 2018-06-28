package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum GoproProtuneColour {
    /**
     * Auto 
     */
    @MavlinkEntryInfo(0)
    GOPRO_PROTUNE_COLOUR_STANDARD,

    /**
     * Neutral 
     */
    @MavlinkEntryInfo(1)
    GOPRO_PROTUNE_COLOUR_NEUTRAL
}
