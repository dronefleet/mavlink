package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum MavCmdDoAuxFunctionSwitchLevel {
    /**
     * Switch Low. 
     */
    @MavlinkEntryInfo(0)
    MAV_CMD_DO_AUX_FUNCTION_SWITCH_LEVEL_LOW,

    /**
     * Switch Middle. 
     */
    @MavlinkEntryInfo(1)
    MAV_CMD_DO_AUX_FUNCTION_SWITCH_LEVEL_MIDDLE,

    /**
     * Switch High. 
     */
    @MavlinkEntryInfo(2)
    MAV_CMD_DO_AUX_FUNCTION_SWITCH_LEVEL_HIGH
}
