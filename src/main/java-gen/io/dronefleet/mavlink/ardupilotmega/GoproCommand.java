package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum GoproCommand {
    /**
     * (Get/Set)<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    GOPRO_COMMAND_POWER,

    /**
     * (Get/Set)<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    GOPRO_COMMAND_CAPTURE_MODE,

    /**
     * (___/Set)<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    GOPRO_COMMAND_SHUTTER,

    /**
     * (Get/___)<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    GOPRO_COMMAND_BATTERY,

    /**
     * (Get/___)<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    GOPRO_COMMAND_MODEL,

    /**
     * (Get/Set)<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(5)
    GOPRO_COMMAND_VIDEO_SETTINGS,

    /**
     * (Get/Set)<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(6)
    GOPRO_COMMAND_LOW_LIGHT,

    /**
     * (Get/Set)<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(7)
    GOPRO_COMMAND_PHOTO_RESOLUTION,

    /**
     * (Get/Set)<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(8)
    GOPRO_COMMAND_PHOTO_BURST_RATE,

    /**
     * (Get/Set)<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(9)
    GOPRO_COMMAND_PROTUNE,

    /**
     * (Get/Set) Hero 3+ Only<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(10)
    GOPRO_COMMAND_PROTUNE_WHITE_BALANCE,

    /**
     * (Get/Set) Hero 3+ Only<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(11)
    GOPRO_COMMAND_PROTUNE_COLOUR,

    /**
     * (Get/Set) Hero 3+ Only<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(12)
    GOPRO_COMMAND_PROTUNE_GAIN,

    /**
     * (Get/Set) Hero 3+ Only<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(13)
    GOPRO_COMMAND_PROTUNE_SHARPNESS,

    /**
     * (Get/Set) Hero 3+ Only<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(14)
    GOPRO_COMMAND_PROTUNE_EXPOSURE,

    /**
     * (Get/Set)<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(15)
    GOPRO_COMMAND_TIME,

    /**
     * (Get/Set)<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(16)
    GOPRO_COMMAND_CHARGING
}
