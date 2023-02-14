package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum MavOdidUaType {
    /**
     * No UA (Unmanned Aircraft) type defined. 
     */
    @MavlinkEntryInfo(0)
    MAV_ODID_UA_TYPE_NONE,

    /**
     * Aeroplane/Airplane. Fixed wing. 
     */
    @MavlinkEntryInfo(1)
    MAV_ODID_UA_TYPE_AEROPLANE,

    /**
     * Helicopter or multirotor. 
     */
    @MavlinkEntryInfo(2)
    MAV_ODID_UA_TYPE_HELICOPTER_OR_MULTIROTOR,

    /**
     * Gyroplane. 
     */
    @MavlinkEntryInfo(3)
    MAV_ODID_UA_TYPE_GYROPLANE,

    /**
     * VTOL (Vertical Take-Off and Landing). Fixed wing aircraft that can take off vertically. 
     */
    @MavlinkEntryInfo(4)
    MAV_ODID_UA_TYPE_HYBRID_LIFT,

    /**
     * Ornithopter. 
     */
    @MavlinkEntryInfo(5)
    MAV_ODID_UA_TYPE_ORNITHOPTER,

    /**
     * Glider. 
     */
    @MavlinkEntryInfo(6)
    MAV_ODID_UA_TYPE_GLIDER,

    /**
     * Kite. 
     */
    @MavlinkEntryInfo(7)
    MAV_ODID_UA_TYPE_KITE,

    /**
     * Free Balloon. 
     */
    @MavlinkEntryInfo(8)
    MAV_ODID_UA_TYPE_FREE_BALLOON,

    /**
     * Captive Balloon. 
     */
    @MavlinkEntryInfo(9)
    MAV_ODID_UA_TYPE_CAPTIVE_BALLOON,

    /**
     * Airship. E.g. a blimp. 
     */
    @MavlinkEntryInfo(10)
    MAV_ODID_UA_TYPE_AIRSHIP,

    /**
     * Free Fall/Parachute (unpowered). 
     */
    @MavlinkEntryInfo(11)
    MAV_ODID_UA_TYPE_FREE_FALL_PARACHUTE,

    /**
     * Rocket. 
     */
    @MavlinkEntryInfo(12)
    MAV_ODID_UA_TYPE_ROCKET,

    /**
     * Tethered powered aircraft. 
     */
    @MavlinkEntryInfo(13)
    MAV_ODID_UA_TYPE_TETHERED_POWERED_AIRCRAFT,

    /**
     * Ground Obstacle. 
     */
    @MavlinkEntryInfo(14)
    MAV_ODID_UA_TYPE_GROUND_OBSTACLE,

    /**
     * Other type of aircraft not listed earlier. 
     */
    @MavlinkEntryInfo(15)
    MAV_ODID_UA_TYPE_OTHER
}
