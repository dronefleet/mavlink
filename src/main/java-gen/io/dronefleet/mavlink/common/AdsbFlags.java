package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * These flags indicate status such as data validity of each data source. Set = data valid 
 */
@MavlinkEnum
public enum AdsbFlags {
    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    ADSB_FLAGS_VALID_COORDS,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    ADSB_FLAGS_VALID_ALTITUDE,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    ADSB_FLAGS_VALID_HEADING,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(8)
    ADSB_FLAGS_VALID_VELOCITY,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(16)
    ADSB_FLAGS_VALID_CALLSIGN,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(32)
    ADSB_FLAGS_VALID_SQUAWK,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(64)
    ADSB_FLAGS_SIMULATED
}
