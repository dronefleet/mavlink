package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Flags to indicate the status of camera storage. 
 */
@MavlinkEnum
public enum StorageStatus {
    /**
     * Storage is missing (no microSD card loaded for example.) 
     */
    @MavlinkEntryInfo(0)
    STORAGE_STATUS_EMPTY,

    /**
     * Storage present but unformatted. 
     */
    @MavlinkEntryInfo(1)
    STORAGE_STATUS_UNFORMATTED,

    /**
     * Storage present and ready. 
     */
    @MavlinkEntryInfo(2)
    STORAGE_STATUS_READY,

    /**
     * Camera does not supply storage status information. Capacity information in 
     * {@link io.dronefleet.mavlink.common.StorageInformation STORAGE_INFORMATION} fields will be ignored. 
     */
    @MavlinkEntryInfo(3)
    STORAGE_STATUS_NOT_SUPPORTED
}
