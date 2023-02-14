package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Flags to indicate usage for a particular storage (see {@link io.dronefleet.mavlink.common.StorageInformation STORAGE_INFORMATION}.storage_usage 
 * and MAV_CMD_SET_STORAGE_USAGE). 
 */
@MavlinkEnum
public enum StorageUsageFlag {
    /**
     * Always set to 1 (indicates {@link io.dronefleet.mavlink.common.StorageInformation STORAGE_INFORMATION}.storage_usage is supported). 
     */
    @MavlinkEntryInfo(1)
    STORAGE_USAGE_FLAG_SET,

    /**
     * Storage for saving photos. 
     */
    @MavlinkEntryInfo(2)
    STORAGE_USAGE_FLAG_PHOTO,

    /**
     * Storage for saving videos. 
     */
    @MavlinkEntryInfo(4)
    STORAGE_USAGE_FLAG_VIDEO,

    /**
     * Storage for saving logs. 
     */
    @MavlinkEntryInfo(8)
    STORAGE_USAGE_FLAG_LOGS
}
