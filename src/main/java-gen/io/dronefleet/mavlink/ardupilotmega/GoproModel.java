package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum GoproModel {
    /**
     * Unknown gopro model 
     */
    @MavlinkEntryInfo(0)
    GOPRO_MODEL_UNKNOWN,

    /**
     * Hero 3+ Silver (HeroBus not supported by GoPro) 
     */
    @MavlinkEntryInfo(1)
    GOPRO_MODEL_HERO_3_PLUS_SILVER,

    /**
     * Hero 3+ Black 
     */
    @MavlinkEntryInfo(2)
    GOPRO_MODEL_HERO_3_PLUS_BLACK,

    /**
     * Hero 4 Silver 
     */
    @MavlinkEntryInfo(3)
    GOPRO_MODEL_HERO_4_SILVER,

    /**
     * Hero 4 Black 
     */
    @MavlinkEntryInfo(4)
    GOPRO_MODEL_HERO_4_BLACK
}
