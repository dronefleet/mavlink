package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * The type of parameter for the OSD parameter editor. 
 */
@MavlinkEnum
public enum OsdParamConfigType {
    /**
     *  
     */
    @MavlinkEntryInfo(0)
    OSD_PARAM_NONE,

    /**
     *  
     */
    @MavlinkEntryInfo(1)
    OSD_PARAM_SERIAL_PROTOCOL,

    /**
     *  
     */
    @MavlinkEntryInfo(2)
    OSD_PARAM_SERVO_FUNCTION,

    /**
     *  
     */
    @MavlinkEntryInfo(3)
    OSD_PARAM_AUX_FUNCTION,

    /**
     *  
     */
    @MavlinkEntryInfo(4)
    OSD_PARAM_FLIGHT_MODE,

    /**
     *  
     */
    @MavlinkEntryInfo(5)
    OSD_PARAM_FAILSAFE_ACTION,

    /**
     *  
     */
    @MavlinkEntryInfo(6)
    OSD_PARAM_FAILSAFE_ACTION_1,

    /**
     *  
     */
    @MavlinkEntryInfo(7)
    OSD_PARAM_FAILSAFE_ACTION_2,

    /**
     *  
     */
    @MavlinkEntryInfo(8)
    OSD_PARAM_NUM_TYPES
}
