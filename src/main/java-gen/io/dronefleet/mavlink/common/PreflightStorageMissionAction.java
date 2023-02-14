package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Actions for reading and writing plan information (mission, rally points, geofence) between 
 * persistent and volatile storage when using MAV_CMD_PREFLIGHT_STORAGE. (Commonly missions 
 * are loaded from persistent storage (flash/EEPROM) into volatile storage (RAM) on startup and 
 * written back when they are changed.) 
 */
@MavlinkEnum
public enum PreflightStorageMissionAction {
    /**
     * Read current mission data from persistent storage 
     */
    @MavlinkEntryInfo(0)
    MISSION_READ_PERSISTENT,

    /**
     * Write current mission data to persistent storage 
     */
    @MavlinkEntryInfo(1)
    MISSION_WRITE_PERSISTENT,

    /**
     * Erase all mission data stored on the vehicle (both persistent and volatile storage) 
     */
    @MavlinkEntryInfo(2)
    MISSION_RESET_DEFAULT
}
