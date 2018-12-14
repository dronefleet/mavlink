package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum GoproCaptureMode {
    /**
     * Video mode. 
     */
    @MavlinkEntryInfo(0)
    GOPRO_CAPTURE_MODE_VIDEO,

    /**
     * Photo mode. 
     */
    @MavlinkEntryInfo(1)
    GOPRO_CAPTURE_MODE_PHOTO,

    /**
     * Burst mode, Hero 3+ only. 
     */
    @MavlinkEntryInfo(2)
    GOPRO_CAPTURE_MODE_BURST,

    /**
     * Time lapse mode, Hero 3+ only. 
     */
    @MavlinkEntryInfo(3)
    GOPRO_CAPTURE_MODE_TIME_LAPSE,

    /**
     * Multi shot mode, Hero 4 only. 
     */
    @MavlinkEntryInfo(4)
    GOPRO_CAPTURE_MODE_MULTI_SHOT,

    /**
     * Playback mode, Hero 4 only, silver only except when LCD or HDMI is connected to black. 
     */
    @MavlinkEntryInfo(5)
    GOPRO_CAPTURE_MODE_PLAYBACK,

    /**
     * Playback mode, Hero 4 only. 
     */
    @MavlinkEntryInfo(6)
    GOPRO_CAPTURE_MODE_SETUP,

    /**
     * Mode not yet known. 
     */
    @MavlinkEntryInfo(255)
    GOPRO_CAPTURE_MODE_UNKNOWN
}
