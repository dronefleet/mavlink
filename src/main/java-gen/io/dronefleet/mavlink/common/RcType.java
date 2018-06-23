package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * RC type 
 */
@MavlinkEnum
public enum RcType {
    /**
     * Spektrum DSM2<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    RC_TYPE_SPEKTRUM_DSM2,

    /**
     * Spektrum DSMX<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    RC_TYPE_SPEKTRUM_DSMX
}
