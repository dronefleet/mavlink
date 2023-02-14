package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Battery mode. Note, the normal operation mode (i.e. when flying) should be reported as 
 * MAV_BATTERY_MODE_UNKNOWN to allow message trimming in normal flight. 
 */
@MavlinkEnum
public enum MavBatteryMode {
    /**
     * Battery mode not supported/unknown battery mode/normal operation. 
     */
    @MavlinkEntryInfo(0)
    MAV_BATTERY_MODE_UNKNOWN,

    /**
     * Battery is auto discharging (towards storage level). 
     */
    @MavlinkEntryInfo(1)
    MAV_BATTERY_MODE_AUTO_DISCHARGING,

    /**
     * Battery in hot-swap mode (current limited to prevent spikes that might damage sensitive 
     * electrical circuits). 
     */
    @MavlinkEntryInfo(2)
    MAV_BATTERY_MODE_HOT_SWAP
}
