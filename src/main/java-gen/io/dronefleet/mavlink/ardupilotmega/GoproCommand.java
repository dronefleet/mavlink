package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum GoproCommand {
    /**
     * (Get/Set). 
     */
    @MavlinkEntryInfo(0)
    GOPRO_COMMAND_POWER,

    /**
     * (Get/Set). 
     */
    @MavlinkEntryInfo(1)
    GOPRO_COMMAND_CAPTURE_MODE,

    /**
     * (___/Set). 
     */
    @MavlinkEntryInfo(2)
    GOPRO_COMMAND_SHUTTER,

    /**
     * (Get/___). 
     */
    @MavlinkEntryInfo(3)
    GOPRO_COMMAND_BATTERY,

    /**
     * (Get/___). 
     */
    @MavlinkEntryInfo(4)
    GOPRO_COMMAND_MODEL,

    /**
     * (Get/Set). 
     */
    @MavlinkEntryInfo(5)
    GOPRO_COMMAND_VIDEO_SETTINGS,

    /**
     * (Get/Set). 
     */
    @MavlinkEntryInfo(6)
    GOPRO_COMMAND_LOW_LIGHT,

    /**
     * (Get/Set). 
     */
    @MavlinkEntryInfo(7)
    GOPRO_COMMAND_PHOTO_RESOLUTION,

    /**
     * (Get/Set). 
     */
    @MavlinkEntryInfo(8)
    GOPRO_COMMAND_PHOTO_BURST_RATE,

    /**
     * (Get/Set). 
     */
    @MavlinkEntryInfo(9)
    GOPRO_COMMAND_PROTUNE,

    /**
     * (Get/Set) Hero 3+ Only. 
     */
    @MavlinkEntryInfo(10)
    GOPRO_COMMAND_PROTUNE_WHITE_BALANCE,

    /**
     * (Get/Set) Hero 3+ Only. 
     */
    @MavlinkEntryInfo(11)
    GOPRO_COMMAND_PROTUNE_COLOUR,

    /**
     * (Get/Set) Hero 3+ Only. 
     */
    @MavlinkEntryInfo(12)
    GOPRO_COMMAND_PROTUNE_GAIN,

    /**
     * (Get/Set) Hero 3+ Only. 
     */
    @MavlinkEntryInfo(13)
    GOPRO_COMMAND_PROTUNE_SHARPNESS,

    /**
     * (Get/Set) Hero 3+ Only. 
     */
    @MavlinkEntryInfo(14)
    GOPRO_COMMAND_PROTUNE_EXPOSURE,

    /**
     * (Get/Set). 
     */
    @MavlinkEntryInfo(15)
    GOPRO_COMMAND_TIME,

    /**
     * (Get/Set). 
     */
    @MavlinkEntryInfo(16)
    GOPRO_COMMAND_CHARGING
}
