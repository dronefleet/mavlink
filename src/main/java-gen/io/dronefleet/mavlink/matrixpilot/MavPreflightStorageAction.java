package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Action required when performing CMD_PREFLIGHT_STORAGE 
 */
@MavlinkEnum
public enum MavPreflightStorageAction {
    /**
     * Read all parameters from storage 
     */
    @MavlinkEntryInfo(0)
    MAV_PFS_CMD_READ_ALL,

    /**
     * Write all parameters to storage 
     */
    @MavlinkEntryInfo(1)
    MAV_PFS_CMD_WRITE_ALL,

    /**
     * Clear all parameters in storage 
     */
    @MavlinkEntryInfo(2)
    MAV_PFS_CMD_CLEAR_ALL,

    /**
     * Read specific parameters from storage 
     */
    @MavlinkEntryInfo(3)
    MAV_PFS_CMD_READ_SPECIFIC,

    /**
     * Write specific parameters to storage 
     */
    @MavlinkEntryInfo(4)
    MAV_PFS_CMD_WRITE_SPECIFIC,

    /**
     * Clear specific parameters in storage 
     */
    @MavlinkEntryInfo(5)
    MAV_PFS_CMD_CLEAR_SPECIFIC,

    /**
     * do nothing 
     */
    @MavlinkEntryInfo(6)
    MAV_PFS_CMD_DO_NOTHING
}
