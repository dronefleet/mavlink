package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum GoproFrameRate {
    /**
     * 12 FPS 
     */
    @MavlinkEntryInfo(0)
    GOPRO_FRAME_RATE_12,

    /**
     * 15 FPS 
     */
    @MavlinkEntryInfo(1)
    GOPRO_FRAME_RATE_15,

    /**
     * 24 FPS 
     */
    @MavlinkEntryInfo(2)
    GOPRO_FRAME_RATE_24,

    /**
     * 25 FPS 
     */
    @MavlinkEntryInfo(3)
    GOPRO_FRAME_RATE_25,

    /**
     * 30 FPS 
     */
    @MavlinkEntryInfo(4)
    GOPRO_FRAME_RATE_30,

    /**
     * 48 FPS 
     */
    @MavlinkEntryInfo(5)
    GOPRO_FRAME_RATE_48,

    /**
     * 50 FPS 
     */
    @MavlinkEntryInfo(6)
    GOPRO_FRAME_RATE_50,

    /**
     * 60 FPS 
     */
    @MavlinkEntryInfo(7)
    GOPRO_FRAME_RATE_60,

    /**
     * 80 FPS 
     */
    @MavlinkEntryInfo(8)
    GOPRO_FRAME_RATE_80,

    /**
     * 90 FPS 
     */
    @MavlinkEntryInfo(9)
    GOPRO_FRAME_RATE_90,

    /**
     * 100 FPS 
     */
    @MavlinkEntryInfo(10)
    GOPRO_FRAME_RATE_100,

    /**
     * 120 FPS 
     */
    @MavlinkEntryInfo(11)
    GOPRO_FRAME_RATE_120,

    /**
     * 240 FPS 
     */
    @MavlinkEntryInfo(12)
    GOPRO_FRAME_RATE_240,

    /**
     * 12.5 FPS 
     */
    @MavlinkEntryInfo(13)
    GOPRO_FRAME_RATE_12_5
}
