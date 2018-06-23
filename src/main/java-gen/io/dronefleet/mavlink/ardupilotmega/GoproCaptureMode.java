package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum GoproCaptureMode {
    /**
     * Video mode<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    GOPRO_CAPTURE_MODE_VIDEO,

    /**
     * Photo mode<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    GOPRO_CAPTURE_MODE_PHOTO,

    /**
     * Burst mode, hero 3+ only<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    GOPRO_CAPTURE_MODE_BURST,

    /**
     * Time lapse mode, hero 3+ only<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    GOPRO_CAPTURE_MODE_TIME_LAPSE,

    /**
     * Multi shot mode, hero 4 only<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    GOPRO_CAPTURE_MODE_MULTI_SHOT,

    /**
     * Playback mode, hero 4 only, silver only except when LCD or HDMI is connected to black<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(5)
    GOPRO_CAPTURE_MODE_PLAYBACK,

    /**
     * Playback mode, hero 4 only<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(6)
    GOPRO_CAPTURE_MODE_SETUP,

    /**
     * Mode not yet known<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(255)
    GOPRO_CAPTURE_MODE_UNKNOWN
}
