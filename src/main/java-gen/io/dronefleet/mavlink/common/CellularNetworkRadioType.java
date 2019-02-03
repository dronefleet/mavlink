package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Cellular network radio type 
 */
@MavlinkEnum
public enum CellularNetworkRadioType {
    /**
     *  
     */
    @MavlinkEntryInfo(0)
    CELLULAR_NETWORK_RADIO_TYPE_NONE,

    /**
     *  
     */
    @MavlinkEntryInfo(1)
    CELLULAR_NETWORK_RADIO_TYPE_GSM,

    /**
     *  
     */
    @MavlinkEntryInfo(2)
    CELLULAR_NETWORK_RADIO_TYPE_CDMA,

    /**
     *  
     */
    @MavlinkEntryInfo(3)
    CELLULAR_NETWORK_RADIO_TYPE_WCDMA,

    /**
     *  
     */
    @MavlinkEntryInfo(4)
    CELLULAR_NETWORK_RADIO_TYPE_LTE
}
