package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * The error type for the OSD parameter editor. 
 */
@MavlinkEnum
public enum OsdParamConfigError {
    /**
     *  
     */
    @MavlinkEntryInfo(0)
    OSD_PARAM_SUCCESS,

    /**
     *  
     */
    @MavlinkEntryInfo(1)
    OSD_PARAM_INVALID_SCREEN,

    /**
     *  
     */
    @MavlinkEntryInfo(2)
    OSD_PARAM_INVALID_PARAMETER_INDEX,

    /**
     *  
     */
    @MavlinkEntryInfo(3)
    OSD_PARAM_INVALID_PARAMETER
}
