package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum GpsInputIgnoreFlags {
    /**
     * ignore altitude field<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    GPS_INPUT_IGNORE_FLAG_ALT,

    /**
     * ignore hdop field<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    GPS_INPUT_IGNORE_FLAG_HDOP,

    /**
     * ignore vdop field<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    GPS_INPUT_IGNORE_FLAG_VDOP,

    /**
     * ignore horizontal velocity field (vn and ve)<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(8)
    GPS_INPUT_IGNORE_FLAG_VEL_HORIZ,

    /**
     * ignore vertical velocity field (vd)<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(16)
    GPS_INPUT_IGNORE_FLAG_VEL_VERT,

    /**
     * ignore speed accuracy field<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(32)
    GPS_INPUT_IGNORE_FLAG_SPEED_ACCURACY,

    /**
     * ignore horizontal accuracy field<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(64)
    GPS_INPUT_IGNORE_FLAG_HORIZONTAL_ACCURACY,

    /**
     * ignore vertical accuracy field<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(128)
    GPS_INPUT_IGNORE_FLAG_VERTICAL_ACCURACY
}
