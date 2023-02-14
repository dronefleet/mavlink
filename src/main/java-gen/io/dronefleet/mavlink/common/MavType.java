package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * MAVLINK component type reported in {@link io.dronefleet.mavlink.common.Heartbeat HEARTBEAT} message. Flight controllers must report the 
 * type of the vehicle on which they are mounted (e.g. MAV_TYPE_OCTOROTOR). All other components 
 * must report a value appropriate for their type (e.g. a camera must use MAV_TYPE_CAMERA). 
 */
@MavlinkEnum
public enum MavType {
    /**
     * Generic micro air vehicle 
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
     * Two-rotor Tailsitter VTOL that additionally uses control surfaces in vertical operation. 
     * Note, value previously named MAV_TYPE_VTOL_DUOROTOR. 
     */
    @MavlinkEntryInfo(19)
    MAV_TYPE_VTOL_TAILSITTER_DUOROTOR,

    /**
     * Quad-rotor Tailsitter VTOL using a V-shaped quad config in vertical operation. Note: value 
     * previously named MAV_TYPE_VTOL_QUADROTOR. 
     */
    @MavlinkEntryInfo(20)
    MAV_TYPE_VTOL_TAILSITTER_QUADROTOR,

    /**
     * Tiltrotor VTOL. Fuselage and wings stay (nominally) horizontal in all flight phases. It able 
     * to tilt (some) rotors to provide thrust in cruise flight. 
     */
    @MavlinkEntryInfo(21)
    MAV_TYPE_VTOL_TILTROTOR,

    /**
     * VTOL with separate fixed rotors for hover and cruise flight. Fuselage and wings stay 
     * (nominally) horizontal in all flight phases. 
     */
    @MavlinkEntryInfo(22)
    MAV_TYPE_VTOL_FIXEDROTOR,

    /**
     * Tailsitter VTOL. Fuselage and wings orientation changes depending on flight phase: vertical 
     * for hover, horizontal for cruise. Use more specific VTOL MAV_TYPE_VTOL_DUOROTOR or 
     * MAV_TYPE_VTOL_QUADROTOR if appropriate. 
     */
    @MavlinkEntryInfo(23)
    MAV_TYPE_VTOL_TAILSITTER,

    /**
     * Tiltwing VTOL. Fuselage stays horizontal in all flight phases. The whole wing, along with any 
     * attached engine, can tilt between vertical and horizontal mode. 
     */
    @MavlinkEntryInfo(24)
    MAV_TYPE_VTOL_TILTWING,

    /**
     * VTOL reserved 5 
     */
    @MavlinkEntryInfo(25)
    MAV_TYPE_VTOL_RESERVED5,

    /**
     * Gimbal 
     */
    @MavlinkEntryInfo(26)
    MAV_TYPE_GIMBAL,

    /**
     * ADSB system 
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
     * FLARM collision avoidance system 
     */
    @MavlinkEntryInfo(32)
    MAV_TYPE_FLARM,

    /**
     * Servo 
     */
    @MavlinkEntryInfo(33)
    MAV_TYPE_SERVO,

    /**
     * Open Drone ID. See https://mavlink.io/en/services/opendroneid.html. 
     */
    @MavlinkEntryInfo(34)
    MAV_TYPE_ODID,

    /**
     * Decarotor 
     */
    @MavlinkEntryInfo(35)
    MAV_TYPE_DECAROTOR,

    /**
     * Battery 
     */
    @MavlinkEntryInfo(36)
    MAV_TYPE_BATTERY,

    /**
     * Parachute 
     */
    @MavlinkEntryInfo(37)
    MAV_TYPE_PARACHUTE,

    /**
     * Log 
     */
    @MavlinkEntryInfo(38)
    MAV_TYPE_LOG,

    /**
     * OSD 
     */
    @MavlinkEntryInfo(39)
    MAV_TYPE_OSD,

    /**
     * IMU 
     */
    @MavlinkEntryInfo(40)
    MAV_TYPE_IMU,

    /**
     * GPS 
     */
    @MavlinkEntryInfo(41)
    MAV_TYPE_GPS,

    /**
     * Winch 
     */
    @MavlinkEntryInfo(42)
    MAV_TYPE_WINCH
}
