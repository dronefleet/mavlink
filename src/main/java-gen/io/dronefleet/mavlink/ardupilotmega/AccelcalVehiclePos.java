package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum AccelcalVehiclePos {
    /**
     *  
     */
    @MavlinkEntryInfo(1)
    ACCELCAL_VEHICLE_POS_LEVEL,

    /**
     *  
     */
    @MavlinkEntryInfo(2)
    ACCELCAL_VEHICLE_POS_LEFT,

    /**
     *  
     */
    @MavlinkEntryInfo(3)
    ACCELCAL_VEHICLE_POS_RIGHT,

    /**
     *  
     */
    @MavlinkEntryInfo(4)
    ACCELCAL_VEHICLE_POS_NOSEDOWN,

    /**
     *  
     */
    @MavlinkEntryInfo(5)
    ACCELCAL_VEHICLE_POS_NOSEUP,

    /**
     *  
     */
    @MavlinkEntryInfo(6)
    ACCELCAL_VEHICLE_POS_BACK,

    /**
     *  
     */
    @MavlinkEntryInfo(16777215)
    ACCELCAL_VEHICLE_POS_SUCCESS,

    /**
     *  
     */
    @MavlinkEntryInfo(16777216)
    ACCELCAL_VEHICLE_POS_FAILED
}
