package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum MavFrame {
    /**
     * Global coordinate frame, WGS84 coordinate system. First value / x: latitude, second value / y: 
     * longitude, third value / z: positive altitude over mean sea level (MSL). 
     */
    @MavlinkEntryInfo(0)
    MAV_FRAME_GLOBAL,

    /**
     * Local coordinate frame, Z-down (x: north, y: east, z: down). 
     */
    @MavlinkEntryInfo(1)
    MAV_FRAME_LOCAL_NED,

    /**
     * NOT a coordinate frame, indicates a mission command. 
     */
    @MavlinkEntryInfo(2)
    MAV_FRAME_MISSION,

    /**
     * Global coordinate frame, WGS84 coordinate system, relative altitude over ground with 
     * respect to the home position. First value / x: latitude, second value / y: longitude, third 
     * value / z: positive altitude with 0 being at the altitude of the home location. 
     */
    @MavlinkEntryInfo(3)
    MAV_FRAME_GLOBAL_RELATIVE_ALT,

    /**
     * Local coordinate frame, Z-up (x: east, y: north, z: up). 
     */
    @MavlinkEntryInfo(4)
    MAV_FRAME_LOCAL_ENU,

    /**
     * Global coordinate frame, WGS84 coordinate system. First value / x: latitude in 
     * degrees*1.0e-7, second value / y: longitude in degrees*1.0e-7, third value / z: positive 
     * altitude over mean sea level (MSL). 
     */
    @MavlinkEntryInfo(5)
    MAV_FRAME_GLOBAL_INT,

    /**
     * Global coordinate frame, WGS84 coordinate system, relative altitude over ground with 
     * respect to the home position. First value / x: latitude in degrees*10e-7, second value / y: 
     * longitude in degrees*10e-7, third value / z: positive altitude with 0 being at the altitude of 
     * the home location. 
     */
    @MavlinkEntryInfo(6)
    MAV_FRAME_GLOBAL_RELATIVE_ALT_INT,

    /**
     * Offset to the current local frame. Anything expressed in this frame should be added to the 
     * current local frame position. 
     */
    @MavlinkEntryInfo(7)
    MAV_FRAME_LOCAL_OFFSET_NED,

    /**
     * Setpoint in body NED frame. This makes sense if all position control is externalized - e.g. 
     * useful to command 2 m/s^2 acceleration to the right. 
     */
    @MavlinkEntryInfo(8)
    MAV_FRAME_BODY_NED,

    /**
     * Offset in body NED frame. This makes sense if adding setpoints to the current flight path, to 
     * avoid an obstacle - e.g. useful to command 2 m/s^2 acceleration to the east. 
     */
    @MavlinkEntryInfo(9)
    MAV_FRAME_BODY_OFFSET_NED,

    /**
     * Global coordinate frame with above terrain level altitude. WGS84 coordinate system, 
     * relative altitude over terrain with respect to the waypoint coordinate. First value / x: 
     * latitude in degrees, second value / y: longitude in degrees, third value / z: positive altitude 
     * in meters with 0 being at ground level in terrain model. 
     */
    @MavlinkEntryInfo(10)
    MAV_FRAME_GLOBAL_TERRAIN_ALT,

    /**
     * Global coordinate frame with above terrain level altitude. WGS84 coordinate system, 
     * relative altitude over terrain with respect to the waypoint coordinate. First value / x: 
     * latitude in degrees*10e-7, second value / y: longitude in degrees*10e-7, third value / z: 
     * positive altitude in meters with 0 being at ground level in terrain model. 
     */
    @MavlinkEntryInfo(11)
    MAV_FRAME_GLOBAL_TERRAIN_ALT_INT,

    /**
     * Body fixed frame of reference, Z-down (x: forward, y: right, z: down). 
     */
    @MavlinkEntryInfo(12)
    MAV_FRAME_BODY_FRD,

    /**
     * Body fixed frame of reference, Z-up (x: forward, y: left, z: up). 
     */
    @MavlinkEntryInfo(13)
    MAV_FRAME_BODY_FLU,

    /**
     * Odometry local coordinate frame of data given by a motion capture system, Z-down (x: north, y: 
     * east, z: down). 
     */
    @MavlinkEntryInfo(14)
    MAV_FRAME_MOCAP_NED,

    /**
     * Odometry local coordinate frame of data given by a motion capture system, Z-up (x: east, y: 
     * north, z: up). 
     */
    @MavlinkEntryInfo(15)
    MAV_FRAME_MOCAP_ENU,

    /**
     * Odometry local coordinate frame of data given by a vision estimation system, Z-down (x: north, 
     * y: east, z: down). 
     */
    @MavlinkEntryInfo(16)
    MAV_FRAME_VISION_NED,

    /**
     * Odometry local coordinate frame of data given by a vision estimation system, Z-up (x: east, y: 
     * north, z: up). 
     */
    @MavlinkEntryInfo(17)
    MAV_FRAME_VISION_ENU,

    /**
     * Odometry local coordinate frame of data given by an estimator running onboard the vehicle, 
     * Z-down (x: north, y: east, z: down). 
     */
    @MavlinkEntryInfo(18)
    MAV_FRAME_ESTIM_NED,

    /**
     * Odometry local coordinate frame of data given by an estimator running onboard the vehicle, 
     * Z-up (x: east, y: noth, z: up). 
     */
    @MavlinkEntryInfo(19)
    MAV_FRAME_ESTIM_ENU
}
