package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum GoproResolution {
    /**
     * 848 x 480 (480p). 
     */
    @MavlinkEntryInfo(0)
    GOPRO_RESOLUTION_480p,

    /**
     * 1280 x 720 (720p). 
     */
    @MavlinkEntryInfo(1)
    GOPRO_RESOLUTION_720p,

    /**
     * 1280 x 960 (960p). 
     */
    @MavlinkEntryInfo(2)
    GOPRO_RESOLUTION_960p,

    /**
     * 1920 x 1080 (1080p). 
     */
    @MavlinkEntryInfo(3)
    GOPRO_RESOLUTION_1080p,

    /**
     * 1920 x 1440 (1440p). 
     */
    @MavlinkEntryInfo(4)
    GOPRO_RESOLUTION_1440p,

    /**
     * 2704 x 1440 (2.7k-17:9). 
     */
    @MavlinkEntryInfo(5)
    GOPRO_RESOLUTION_2_7k_17_9,

    /**
     * 2704 x 1524 (2.7k-16:9). 
     */
    @MavlinkEntryInfo(6)
    GOPRO_RESOLUTION_2_7k_16_9,

    /**
     * 2704 x 2028 (2.7k-4:3). 
     */
    @MavlinkEntryInfo(7)
    GOPRO_RESOLUTION_2_7k_4_3,

    /**
     * 3840 x 2160 (4k-16:9). 
     */
    @MavlinkEntryInfo(8)
    GOPRO_RESOLUTION_4k_16_9,

    /**
     * 4096 x 2160 (4k-17:9). 
     */
    @MavlinkEntryInfo(9)
    GOPRO_RESOLUTION_4k_17_9,

    /**
     * 1280 x 720 (720p-SuperView). 
     */
    @MavlinkEntryInfo(10)
    GOPRO_RESOLUTION_720p_SUPERVIEW,

    /**
     * 1920 x 1080 (1080p-SuperView). 
     */
    @MavlinkEntryInfo(11)
    GOPRO_RESOLUTION_1080p_SUPERVIEW,

    /**
     * 2704 x 1520 (2.7k-SuperView). 
     */
    @MavlinkEntryInfo(12)
    GOPRO_RESOLUTION_2_7k_SUPERVIEW,

    /**
     * 3840 x 2160 (4k-SuperView). 
     */
    @MavlinkEntryInfo(13)
    GOPRO_RESOLUTION_4k_SUPERVIEW
}
