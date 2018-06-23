package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum GoproProtuneSharpness {
    /**
     * Low Sharpness<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    GOPRO_PROTUNE_SHARPNESS_LOW,

    /**
     * Medium Sharpness<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    GOPRO_PROTUNE_SHARPNESS_MEDIUM,

    /**
     * High Sharpness<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    GOPRO_PROTUNE_SHARPNESS_HIGH
}
