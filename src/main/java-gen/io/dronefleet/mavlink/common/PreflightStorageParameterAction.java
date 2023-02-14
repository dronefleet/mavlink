package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Actions for reading/writing parameters between persistent and volatile storage when using 
 * MAV_CMD_PREFLIGHT_STORAGE. (Commonly parameters are loaded from persistent storage 
 * (flash/EEPROM) into volatile storage (RAM) on startup and written back when they are 
 * changed.) 
 */
@MavlinkEnum
public enum PreflightStorageParameterAction {
    /**
     * Read all parameters from persistent storage. Replaces values in volatile storage. 
     */
    @MavlinkEntryInfo(0)
    PARAM_READ_PERSISTENT,

    /**
     * Write all parameter values to persistent storage (flash/EEPROM) 
     */
    @MavlinkEntryInfo(1)
    PARAM_WRITE_PERSISTENT,

    /**
     * Reset all user configurable parameters to their default value (including airframe 
     * selection, sensor calibration data, safety settings, and so on). Does not reset values that 
     * contain operation counters and vehicle computed statistics. 
     */
    @MavlinkEntryInfo(2)
    PARAM_RESET_CONFIG_DEFAULT,

    /**
     * Reset only sensor calibration parameters to factory defaults (or firmware default if not 
     * available) 
     */
    @MavlinkEntryInfo(3)
    PARAM_RESET_SENSOR_DEFAULT,

    /**
     * Reset all parameters, including operation counters, to default values 
     */
    @MavlinkEntryInfo(4)
    PARAM_RESET_ALL_DEFAULT
}
