package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * WORK IN PROGRESS! DO NOT DEPLOY! Enumeration of possible waypoint/trajectory 
 * representation 
 */
@MavlinkEnum
public enum MavTrajectoryRepresentation {
  /**
   * Array of waypoints with the following order
   * param[1]: X-coordinate of waypoint [m], set to NaN if not being used
   * param[2]: Y-coordinate of waypoint [m], set to NaN if not being used
   * param[3]: Z-coordinate of waypoint [m], set to NaN if not being used
   * param[4]: X-velocity of waypoint [m/s], set to NaN if not being used
   * param[5]: Y-velocity of waypoint [m/s], set to NaN if not being used
   * param[6]: Z-velocity of waypoint [m/s], set to NaN if not being used
   * param[7]: X-acceleration of waypoint [m/s/s], set to NaN if not being used
   * param[8]: Y-acceleration of waypoint [m/s/s], set to NaN if not being used
   * param[9]: Z-acceleration of waypoint [m/s/s], set to NaN if not being used
   * param[10]: Yaw [rad], set to NaN for unchanged
   * param[11]: Yaw-rate [rad/s], set to NaN for unchanged
   */
  @MavlinkEnumEntry(0)
  MAV_TRAJECTORY_REPRESENTATION_WAYPOINTS,

  /**
   * WORK IN PROGRESS! DO NOT DEPLOY! Array of bezier points with the following order
   * param[1]: X-coordinate of starting bezier point [m], set to NaN if not being used
   * param[2]: Y-coordinate of starting bezier point [m], set to NaN if not being used
   * param[3]: Z-coordinate of starting bezier point [m], set to NaN if not being used
   * param[4]: Bezier time horizon [s], set to NaN if velocity/acceleration should not be incorporated
   * param[5]: Yaw [rad], set to NaN for unchanged
   */
  @MavlinkEnumEntry(1)
  MAV_TRAJECTORY_REPRESENTATION_BEZIER
}
