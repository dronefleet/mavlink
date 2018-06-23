package io.dronefleet.mavlink.uavionix;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Status for ADS-B transponder dynamic input 
 */
@MavlinkEnum
public enum UavionixAdsbOutDynamicGpsFix {
    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    UAVIONIX_ADSB_OUT_DYNAMIC_GPS_FIX_NONE_0,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    UAVIONIX_ADSB_OUT_DYNAMIC_GPS_FIX_NONE_1,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    UAVIONIX_ADSB_OUT_DYNAMIC_GPS_FIX_2D,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    UAVIONIX_ADSB_OUT_DYNAMIC_GPS_FIX_3D,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    UAVIONIX_ADSB_OUT_DYNAMIC_GPS_FIX_DGPS,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(5)
    UAVIONIX_ADSB_OUT_DYNAMIC_GPS_FIX_RTK
}
