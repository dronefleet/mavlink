package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;
import java.lang.Deprecated;

/**
 *  
 */
@MavlinkEnum
public enum MavFrame {
    /**
     * Global (WGS84) coordinate frame + MSL altitude. First value / x: latitude, second value / y: 
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
     * Global (WGS84) coordinate frame + altitude relative to the home position. First value / x: 
     * latitude, second value / y: longitude, third value / z: positive altitude with 0 being at the 
     * altitude of the home location. 
     */
    @MavlinkEntryInfo(3)
    MAV_FRAME_GLOBAL_RELATIVE_ALT,

    /**
     * Local coordinate frame, Z-up (x: east, y: north, z: up). 
     */
    @MavlinkEntryInfo(4)
    MAV_FRAME_LOCAL_ENU,

    /**
     * Global (WGS84) coordinate frame (scaled) + MSL altitude. First value / x: latitude in 
     * degrees*1.0e-7, second value / y: longitude in degrees*1.0e-7, third value / z: positive 
     * altitude over mean sea level (MSL). 
     */
    @MavlinkEntryInfo(5)
    MAV_FRAME_GLOBAL_INT,

    /**
     * Global (WGS84) coordinate frame (scaled) + altitude relative to the home position. First 
     * value / x: latitude in degrees*10e-7, second value / y: longitude in degrees*10e-7, third 
     * value / z: positive altitude with 0 being at the altitude of the home location. 
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
     * @deprecated Since 2019-08, replaced by MAV_FRAME_BODY_FRD. 
     */
    @MavlinkEntryInfo(8)
    @Deprecated
    MAV_FRAME_BODY_NED,

    /**
     * Offset in body NED frame. This makes sense if adding setpoints to the current flight path, to 
     * avoid an obstacle - e.g. useful to command 2 m/s^2 acceleration to the east. 
     * @deprecated Since 2019-08, replaced by MAV_FRAME_BODY_FRD. 
     */
    @MavlinkEntryInfo(9)
    @Deprecated
    MAV_FRAME_BODY_OFFSET_NED,

    /**
     * Global (WGS84) coordinate frame with AGL altitude (at the waypoint coordinate). First value / 
     * x: latitude in degrees, second value / y: longitude in degrees, third value / z: positive 
     * altitude in meters with 0 being at ground level in terrain model. 
     */
    @MavlinkEntryInfo(10)
    MAV_FRAME_GLOBAL_TERRAIN_ALT,

    /**
     * Global (WGS84) coordinate frame (scaled) with AGL altitude (at the waypoint coordinate). 
     * First value / x: latitude in degrees*10e-7, second value / y: longitude in degrees*10e-7, 
     * third value / z: positive altitude in meters with 0 being at ground level in terrain model. 
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
     * @deprecated Since 2019-08, replaced by MAV_FRAME_LOCAL_FRD. 
     */
    @MavlinkEntryInfo(14)
    @Deprecated
    MAV_FRAME_MOCAP_NED,

    /**
     * Odometry local coordinate frame of data given by a motion capture system, Z-up (x: east, y: 
     * north, z: up). 
     * @deprecated Since 2019-08, replaced by MAV_FRAME_LOCAL_FLU. 
     */
    @MavlinkEntryInfo(15)
    @Deprecated
    MAV_FRAME_MOCAP_ENU,

    /**
     * Odometry local coordinate frame of data given by a vision estimation system, Z-down (x: north, 
     * y: east, z: down). 
     * @deprecated Since 2019-08, replaced by MAV_FRAME_LOCAL_FRD. 
     */
    @MavlinkEntryInfo(16)
    @Deprecated
    MAV_FRAME_VISION_NED,

    /**
     * Odometry local coordinate frame of data given by a vision estimation system, Z-up (x: east, y: 
     * north, z: up). 
     * @deprecated Since 2019-08, replaced by MAV_FRAME_LOCAL_FLU. 
     */
    @MavlinkEntryInfo(17)
    @Deprecated
    MAV_FRAME_VISION_ENU,

    /**
     * Odometry local coordinate frame of data given by an estimator running onboard the vehicle, 
     * Z-down (x: north, y: east, z: down). 
     * @deprecated Since 2019-08, replaced by MAV_FRAME_LOCAL_FRD. 
     */
    @MavlinkEntryInfo(18)
    @Deprecated
    MAV_FRAME_ESTIM_NED,

    /**
     * Odometry local coordinate frame of data given by an estimator running onboard the vehicle, 
     * Z-up (x: east, y: noth, z: up). 
     * @deprecated Since 2019-08, replaced by MAV_FRAME_LOCAL_FLU. 
     */
    @MavlinkEntryInfo(19)
    @Deprecated
    MAV_FRAME_ESTIM_ENU,

    /**
     * Forward, Right, Down coordinate frame. This is a local frame with Z-down and arbitrary F/R 
     * alignment (i.e. not aligned with NED/earth frame). 
     */
    @MavlinkEntryInfo(20)
    MAV_FRAME_LOCAL_FRD,

    /**
     * Forward, Left, Up coordinate frame. This is a local frame with Z-up and arbitrary F/L alignment 
     * (i.e. not aligned with ENU/earth frame). 
     */
    @MavlinkEntryInfo(21)
    MAV_FRAME_LOCAL_FLU
}
