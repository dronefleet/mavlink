package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Type of GPS fix 
 */
@MavlinkEnum
public enum GpsFixType {
    /**
     * No GPS connected<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    GPS_FIX_TYPE_NO_GPS,

    /**
     * No position information, GPS is connected<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    GPS_FIX_TYPE_NO_FIX,

    /**
     * 2D position<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    GPS_FIX_TYPE_2D_FIX,

    /**
     * 3D position<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    GPS_FIX_TYPE_3D_FIX,

    /**
     * DGPS/SBAS aided 3D position<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    GPS_FIX_TYPE_DGPS,

    /**
     * RTK float, 3D position<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(5)
    GPS_FIX_TYPE_RTK_FLOAT,

    /**
     * RTK Fixed, 3D position<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(6)
    GPS_FIX_TYPE_RTK_FIXED,

    /**
     * Static fixed, typically used for base stations<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(7)
    GPS_FIX_TYPE_STATIC,

    /**
     * PPP, 3D position.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(8)
    GPS_FIX_TYPE_PPP
}
