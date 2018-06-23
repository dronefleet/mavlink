package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * ADSB classification for the type of vehicle emitting the transponder signal 
 */
@MavlinkEnum
public enum AdsbEmitterType {
    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    ADSB_EMITTER_TYPE_NO_INFO,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    ADSB_EMITTER_TYPE_LIGHT,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    ADSB_EMITTER_TYPE_SMALL,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    ADSB_EMITTER_TYPE_LARGE,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    ADSB_EMITTER_TYPE_HIGH_VORTEX_LARGE,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(5)
    ADSB_EMITTER_TYPE_HEAVY,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(6)
    ADSB_EMITTER_TYPE_HIGHLY_MANUV,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(7)
    ADSB_EMITTER_TYPE_ROTOCRAFT,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(8)
    ADSB_EMITTER_TYPE_UNASSIGNED,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(9)
    ADSB_EMITTER_TYPE_GLIDER,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(10)
    ADSB_EMITTER_TYPE_LIGHTER_AIR,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(11)
    ADSB_EMITTER_TYPE_PARACHUTE,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(12)
    ADSB_EMITTER_TYPE_ULTRA_LIGHT,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(13)
    ADSB_EMITTER_TYPE_UNASSIGNED2,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(14)
    ADSB_EMITTER_TYPE_UAV,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(15)
    ADSB_EMITTER_TYPE_SPACE,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(16)
    ADSB_EMITTER_TYPE_UNASSGINED3,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(17)
    ADSB_EMITTER_TYPE_EMERGENCY_SURFACE,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(18)
    ADSB_EMITTER_TYPE_SERVICE_SURFACE,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(19)
    ADSB_EMITTER_TYPE_POINT_OBSTACLE
}
