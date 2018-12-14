package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum GsmLinkType {
    /**
     * no service 
     */
    @MavlinkEntryInfo(0)
    GSM_LINK_TYPE_NONE,

    /**
     * link type unknown 
     */
    @MavlinkEntryInfo(1)
    GSM_LINK_TYPE_UNKNOWN,

    /**
     * 2G (GSM/GRPS/EDGE) link 
     */
    @MavlinkEntryInfo(2)
    GSM_LINK_TYPE_2G,

    /**
     * 3G link (WCDMA/HSDPA/HSPA) 
     */
    @MavlinkEntryInfo(3)
    GSM_LINK_TYPE_3G,

    /**
     * 4G link (LTE) 
     */
    @MavlinkEntryInfo(4)
    GSM_LINK_TYPE_4G
}
