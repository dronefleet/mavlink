package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * RC type 
 */
@MavlinkEnum
public enum RcType {
    /**
     * Spektrum DSM2 
     */
    @MavlinkEntryInfo(0)
    RC_TYPE_SPEKTRUM_DSM2,

    /**
     * Spektrum DSMX 
     */
    @MavlinkEntryInfo(1)
    RC_TYPE_SPEKTRUM_DSMX
}
