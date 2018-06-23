package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum GoproPhotoResolution {
    /**
     * 5MP Medium<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    GOPRO_PHOTO_RESOLUTION_5MP_MEDIUM,

    /**
     * 7MP Medium<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    GOPRO_PHOTO_RESOLUTION_7MP_MEDIUM,

    /**
     * 7MP Wide<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    GOPRO_PHOTO_RESOLUTION_7MP_WIDE,

    /**
     * 10MP Wide<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    GOPRO_PHOTO_RESOLUTION_10MP_WIDE,

    /**
     * 12MP Wide<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    GOPRO_PHOTO_RESOLUTION_12MP_WIDE
}
