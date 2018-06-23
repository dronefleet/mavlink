package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum MavType {
    /**
     * Generic micro air vehicle.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    MAV_TYPE_GENERIC,

    /**
     * Fixed wing aircraft.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    MAV_TYPE_FIXED_WING,

    /**
     * Quadrotor<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    MAV_TYPE_QUADROTOR,

    /**
     * Coaxial helicopter<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    MAV_TYPE_COAXIAL,

    /**
     * Normal helicopter with tail rotor.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    MAV_TYPE_HELICOPTER,

    /**
     * Ground installation<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(5)
    MAV_TYPE_ANTENNA_TRACKER,

    /**
     * Operator control unit / ground control station<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(6)
    MAV_TYPE_GCS,

    /**
     * Airship, controlled<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(7)
    MAV_TYPE_AIRSHIP,

    /**
     * Free balloon, uncontrolled<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(8)
    MAV_TYPE_FREE_BALLOON,

    /**
     * Rocket<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(9)
    MAV_TYPE_ROCKET,

    /**
     * Ground rover<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(10)
    MAV_TYPE_GROUND_ROVER,

    /**
     * Surface vessel, boat, ship<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(11)
    MAV_TYPE_SURFACE_BOAT,

    /**
     * Submarine<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(12)
    MAV_TYPE_SUBMARINE,

    /**
     * Hexarotor<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(13)
    MAV_TYPE_HEXAROTOR,

    /**
     * Octorotor<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(14)
    MAV_TYPE_OCTOROTOR,

    /**
     * Tricopter<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(15)
    MAV_TYPE_TRICOPTER,

    /**
     * Flapping wing<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(16)
    MAV_TYPE_FLAPPING_WING,

    /**
     * Kite<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(17)
    MAV_TYPE_KITE,

    /**
     * Onboard companion controller<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(18)
    MAV_TYPE_ONBOARD_CONTROLLER,

    /**
     * Two-rotor VTOL using control surfaces in vertical operation in addition. Tailsitter.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(19)
    MAV_TYPE_VTOL_DUOROTOR,

    /**
     * Quad-rotor VTOL using a V-shaped quad config in vertical operation. Tailsitter.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(20)
    MAV_TYPE_VTOL_QUADROTOR,

    /**
     * Tiltrotor VTOL<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(21)
    MAV_TYPE_VTOL_TILTROTOR,

    /**
     * VTOL reserved 2<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(22)
    MAV_TYPE_VTOL_RESERVED2,

    /**
     * VTOL reserved 3<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(23)
    MAV_TYPE_VTOL_RESERVED3,

    /**
     * VTOL reserved 4<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(24)
    MAV_TYPE_VTOL_RESERVED4,

    /**
     * VTOL reserved 5<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(25)
    MAV_TYPE_VTOL_RESERVED5,

    /**
     * Onboard gimbal<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(26)
    MAV_TYPE_GIMBAL,

    /**
     * Onboard ADSB peripheral<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(27)
    MAV_TYPE_ADSB,

    /**
     * Steerable, nonrigid airfoil<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(28)
    MAV_TYPE_PARAFOIL,

    /**
     * Dodecarotor<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(29)
    MAV_TYPE_DODECAROTOR,

    /**
     * Camera<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(30)
    MAV_TYPE_CAMERA,

    /**
     * Charging station<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(31)
    MAV_TYPE_CHARGING_STATION,

    /**
     * Onboard FLARM collision avoidance system<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(32)
    MAV_TYPE_FLARM
}
