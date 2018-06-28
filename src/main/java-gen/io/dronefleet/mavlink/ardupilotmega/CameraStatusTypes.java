package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum CameraStatusTypes {
    /**
     * Camera heartbeat, announce camera component ID at 1hz 
     */
    @MavlinkEntryInfo(0)
    CAMERA_STATUS_TYPE_HEARTBEAT,

    /**
     * Camera image triggered 
     */
    @MavlinkEntryInfo(1)
    CAMERA_STATUS_TYPE_TRIGGER,

    /**
     * Camera connection lost 
     */
    @MavlinkEntryInfo(2)
    CAMERA_STATUS_TYPE_DISCONNECT,

    /**
     * Camera unknown error 
     */
    @MavlinkEntryInfo(3)
    CAMERA_STATUS_TYPE_ERROR,

    /**
     * Camera battery low. Parameter p1 shows reported voltage 
     */
    @MavlinkEntryInfo(4)
    CAMERA_STATUS_TYPE_LOWBATT,

    /**
     * Camera storage low. Parameter p1 shows reported shots remaining 
     */
    @MavlinkEntryInfo(5)
    CAMERA_STATUS_TYPE_LOWSTORE,

    /**
     * Camera storage low. Parameter p1 shows reported video minutes remaining 
     */
    @MavlinkEntryInfo(6)
    CAMERA_STATUS_TYPE_LOWSTOREV
}
