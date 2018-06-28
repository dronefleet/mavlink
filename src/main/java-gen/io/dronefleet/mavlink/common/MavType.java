package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum MavType {
    /**
     * Generic micro air vehicle. 
     */
    @MavlinkEntryInfo(0)
    MAV_TYPE_GENERIC,

    /**
     * Fixed wing aircraft. 
     */
    @MavlinkEntryInfo(1)
    MAV_TYPE_FIXED_WING,

    /**
     * Quadrotor 
     */
    @MavlinkEntryInfo(2)
    MAV_TYPE_QUADROTOR,

    /**
     * Coaxial helicopter 
     */
    @MavlinkEntryInfo(3)
    MAV_TYPE_COAXIAL,

    /**
     * Normal helicopter with tail rotor. 
     */
    @MavlinkEntryInfo(4)
    MAV_TYPE_HELICOPTER,

    /**
     * Ground installation 
     */
    @MavlinkEntryInfo(5)
    MAV_TYPE_ANTENNA_TRACKER,

    /**
     * Operator control unit / ground control station 
     */
    @MavlinkEntryInfo(6)
    MAV_TYPE_GCS,

    /**
     * Airship, controlled 
     */
    @MavlinkEntryInfo(7)
    MAV_TYPE_AIRSHIP,

    /**
     * Free balloon, uncontrolled 
     */
    @MavlinkEntryInfo(8)
    MAV_TYPE_FREE_BALLOON,

    /**
     * Rocket 
     */
    @MavlinkEntryInfo(9)
    MAV_TYPE_ROCKET,

    /**
     * Ground rover 
     */
    @MavlinkEntryInfo(10)
    MAV_TYPE_GROUND_ROVER,

    /**
     * Surface vessel, boat, ship 
     */
    @MavlinkEntryInfo(11)
    MAV_TYPE_SURFACE_BOAT,

    /**
     * Submarine 
     */
    @MavlinkEntryInfo(12)
    MAV_TYPE_SUBMARINE,

    /**
     * Hexarotor 
     */
    @MavlinkEntryInfo(13)
    MAV_TYPE_HEXAROTOR,

    /**
     * Octorotor 
     */
    @MavlinkEntryInfo(14)
    MAV_TYPE_OCTOROTOR,

    /**
     * Tricopter 
     */
    @MavlinkEntryInfo(15)
    MAV_TYPE_TRICOPTER,

    /**
     * Flapping wing 
     */
    @MavlinkEntryInfo(16)
    MAV_TYPE_FLAPPING_WING,

    /**
     * Kite 
     */
    @MavlinkEntryInfo(17)
    MAV_TYPE_KITE,

    /**
     * Onboard companion controller 
     */
    @MavlinkEntryInfo(18)
    MAV_TYPE_ONBOARD_CONTROLLER,

    /**
     * Two-rotor VTOL using control surfaces in vertical operation in addition. Tailsitter. 
     */
    @MavlinkEntryInfo(19)
    MAV_TYPE_VTOL_DUOROTOR,

    /**
     * Quad-rotor VTOL using a V-shaped quad config in vertical operation. Tailsitter. 
     */
    @MavlinkEntryInfo(20)
    MAV_TYPE_VTOL_QUADROTOR,

    /**
     * Tiltrotor VTOL 
     */
    @MavlinkEntryInfo(21)
    MAV_TYPE_VTOL_TILTROTOR,

    /**
     * VTOL reserved 2 
     */
    @MavlinkEntryInfo(22)
    MAV_TYPE_VTOL_RESERVED2,

    /**
     * VTOL reserved 3 
     */
    @MavlinkEntryInfo(23)
    MAV_TYPE_VTOL_RESERVED3,

    /**
     * VTOL reserved 4 
     */
    @MavlinkEntryInfo(24)
    MAV_TYPE_VTOL_RESERVED4,

    /**
     * VTOL reserved 5 
     */
    @MavlinkEntryInfo(25)
    MAV_TYPE_VTOL_RESERVED5,

    /**
     * Onboard gimbal 
     */
    @MavlinkEntryInfo(26)
    MAV_TYPE_GIMBAL,

    /**
     * Onboard ADSB peripheral 
     */
    @MavlinkEntryInfo(27)
    MAV_TYPE_ADSB,

    /**
     * Steerable, nonrigid airfoil 
     */
    @MavlinkEntryInfo(28)
    MAV_TYPE_PARAFOIL,

    /**
     * Dodecarotor 
     */
    @MavlinkEntryInfo(29)
    MAV_TYPE_DODECAROTOR,

    /**
     * Camera 
     */
    @MavlinkEntryInfo(30)
    MAV_TYPE_CAMERA,

    /**
     * Charging station 
     */
    @MavlinkEntryInfo(31)
    MAV_TYPE_CHARGING_STATION,

    /**
     * Onboard FLARM collision avoidance system 
     */
    @MavlinkEntryInfo(32)
    MAV_TYPE_FLARM
}
