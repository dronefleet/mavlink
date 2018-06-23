package io.dronefleet.mavlink.uavionix;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Definitions for aircraft size 
 */
@MavlinkEnum
public enum UavionixAdsbOutCfgAircraftSize {
    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_NO_DATA,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L15M_W23M,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L25M_W28P5M,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L25_34M,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L35_33M,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(5)
    UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L35_38M,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(6)
    UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L45_39P5M,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(7)
    UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L45_45M,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(8)
    UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L55_45M,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(9)
    UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L55_52M,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(10)
    UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L65_59P5M,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(11)
    UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L65_67M,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(12)
    UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L75_W72P5M,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(13)
    UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L75_W80M,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(14)
    UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L85_W80M,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(15)
    UAVIONIX_ADSB_OUT_CFG_AIRCRAFT_SIZE_L85_W90M
}
