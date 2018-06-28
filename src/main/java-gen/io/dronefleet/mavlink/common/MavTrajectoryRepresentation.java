package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * WORK IN PROGRESS! DO NOT DEPLOY! Enumeration of possible waypoint/trajectory 
 * representation 
 */
@MavlinkEnum
public enum MavTrajectoryRepresentation {
    /**
     * Array of waypoints with the following order 
     * <dl>
     * <dt>param1</dt><dd>X-coordinate of waypoint [m], set to NaN if not being used 
     * </dd>
     * <dt>param2</dt><dd>Y-coordinate of waypoint [m], set to NaN if not being used 
     * </dd>
     * <dt>param3</dt><dd>Z-coordinate of waypoint [m], set to NaN if not being used 
     * </dd>
     * <dt>param4</dt><dd>X-velocity of waypoint [m/s], set to NaN if not being used 
     * </dd>
     * <dt>param5</dt><dd>Y-velocity of waypoint [m/s], set to NaN if not being used 
     * </dd>
     * <dt>param6</dt><dd>Z-velocity of waypoint [m/s], set to NaN if not being used 
     * </dd>
     * <dt>param7</dt><dd>X-acceleration of waypoint [m/s/s], set to NaN if not being used 
     * </dd>
     * <dt>param8</dt><dd>Y-acceleration of waypoint [m/s/s], set to NaN if not being used 
     * </dd>
     * <dt>param9</dt><dd>Z-acceleration of waypoint [m/s/s], set to NaN if not being used 
     * </dd>
     * <dt>param10</dt><dd>Yaw [rad], set to NaN for unchanged 
     * </dd>
     * <dt>param11</dt><dd>Yaw-rate [rad/s], set to NaN for unchanged 
     * </dd>
     * </dl>
     */
    @MavlinkEntryInfo(0)
    MAV_TRAJECTORY_REPRESENTATION_WAYPOINTS,

    /**
     * WORK IN PROGRESS! DO NOT DEPLOY! Array of bezier points with the following order 
     * <dl>
     * <dt>param1</dt><dd>X-coordinate of starting bezier point [m], set to NaN if not being used 
     * </dd>
     * <dt>param2</dt><dd>Y-coordinate of starting bezier point [m], set to NaN if not being used 
     * </dd>
     * <dt>param3</dt><dd>Z-coordinate of starting bezier point [m], set to NaN if not being used 
     * </dd>
     * <dt>param4</dt><dd>Bezier time horizon [s], set to NaN if velocity/acceleration should not be incorporated 
     * </dd>
     * <dt>param5</dt><dd>Yaw [rad], set to NaN for unchanged 
     * </dd>
     * </dl>
     */
    @MavlinkEntryInfo(1)
    MAV_TRAJECTORY_REPRESENTATION_BEZIER
}
