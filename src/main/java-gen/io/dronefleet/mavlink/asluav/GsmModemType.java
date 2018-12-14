package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum GsmModemType {
    /**
     * not specified 
     */
    @MavlinkEntryInfo(0)
    GSM_MODEM_TYPE_UNKNOWN,

    /**
     * HUAWEI LTE USB Stick E3372 
     */
    @MavlinkEntryInfo(1)
    GSM_MODEM_TYPE_HUAWEI_E3372
}
