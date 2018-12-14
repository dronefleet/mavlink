package io.dronefleet.mavlink.ualberta;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Navigation filter mode 
 */
@MavlinkEnum
public enum UalbertaNavMode {
    /**
     *  
     */
    @MavlinkEntryInfo(1)
    NAV_AHRS_INIT,

    /**
     * AHRS mode 
     */
    @MavlinkEntryInfo(2)
    NAV_AHRS,

    /**
     * INS/GPS initialization mode 
     */
    @MavlinkEntryInfo(3)
    NAV_INS_GPS_INIT,

    /**
     * INS/GPS mode 
     */
    @MavlinkEntryInfo(4)
    NAV_INS_GPS
}
