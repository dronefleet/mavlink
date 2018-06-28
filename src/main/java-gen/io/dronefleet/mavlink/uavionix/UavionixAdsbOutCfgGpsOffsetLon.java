package io.dronefleet.mavlink.uavionix;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * GPS longitudinal offset encoding 
 */
@MavlinkEnum
public enum UavionixAdsbOutCfgGpsOffsetLon {
    /**
     *  
     */
    @MavlinkEntryInfo(0)
    UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LON_NO_DATA,

    /**
     *  
     */
    @MavlinkEntryInfo(1)
    UAVIONIX_ADSB_OUT_CFG_GPS_OFFSET_LON_APPLIED_BY_SENSOR
}
