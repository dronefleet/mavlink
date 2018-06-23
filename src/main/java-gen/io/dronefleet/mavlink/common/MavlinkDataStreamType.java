package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum MavlinkDataStreamType {
    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    MAVLINK_DATA_STREAM_IMG_JPEG,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    MAVLINK_DATA_STREAM_IMG_BMP,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    MAVLINK_DATA_STREAM_IMG_RAW8U,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    MAVLINK_DATA_STREAM_IMG_RAW32U,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(5)
    MAVLINK_DATA_STREAM_IMG_PGM,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(6)
    MAVLINK_DATA_STREAM_IMG_PNG
}
