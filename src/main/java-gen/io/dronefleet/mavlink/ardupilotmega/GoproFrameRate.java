package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum GoproFrameRate {
    /**
     * 12 FPS<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    GOPRO_FRAME_RATE_12,

    /**
     * 15 FPS<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    GOPRO_FRAME_RATE_15,

    /**
     * 24 FPS<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    GOPRO_FRAME_RATE_24,

    /**
     * 25 FPS<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    GOPRO_FRAME_RATE_25,

    /**
     * 30 FPS<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    GOPRO_FRAME_RATE_30,

    /**
     * 48 FPS<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(5)
    GOPRO_FRAME_RATE_48,

    /**
     * 50 FPS<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(6)
    GOPRO_FRAME_RATE_50,

    /**
     * 60 FPS<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(7)
    GOPRO_FRAME_RATE_60,

    /**
     * 80 FPS<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(8)
    GOPRO_FRAME_RATE_80,

    /**
     * 90 FPS<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(9)
    GOPRO_FRAME_RATE_90,

    /**
     * 100 FPS<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(10)
    GOPRO_FRAME_RATE_100,

    /**
     * 120 FPS<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(11)
    GOPRO_FRAME_RATE_120,

    /**
     * 240 FPS<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(12)
    GOPRO_FRAME_RATE_240,

    /**
     * 12.5 FPS<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(13)
    GOPRO_FRAME_RATE_12_5
}
