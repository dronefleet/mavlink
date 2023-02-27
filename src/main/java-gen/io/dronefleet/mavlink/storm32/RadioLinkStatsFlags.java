package io.dronefleet.mavlink.storm32;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * {@link io.dronefleet.mavlink.storm32.RadioLinkStats RADIO_LINK_STATS} flags (bitmask). 
 */
@MavlinkEnum
public enum RadioLinkStatsFlags {
    /**
     * Rssi are in negative dBm. Values 0..254 corresponds to 0..-254 dBm. 
     */
    @MavlinkEntryInfo(1)
    RADIO_LINK_STATS_FLAGS_RSSI_DBM
}
