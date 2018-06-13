package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEnum;
import io.dronefleet.mavlink.annotations.MavlinkEnumEntry;

/**
 * Enumeration of estimator types 
 */
@MavlinkEnum
public enum MavEstimatorType {
  /**
   * This is a naive estimator without any real covariance feedback.
   */
  @MavlinkEnumEntry(1)
  MAV_ESTIMATOR_TYPE_NAIVE,

  /**
   * Computer vision based estimate. Might be up to scale.
   */
  @MavlinkEnumEntry(2)
  MAV_ESTIMATOR_TYPE_VISION,

  /**
   * Visual-inertial estimate.
   */
  @MavlinkEnumEntry(3)
  MAV_ESTIMATOR_TYPE_VIO,

  /**
   * Plain GPS estimate.
   */
  @MavlinkEnumEntry(4)
  MAV_ESTIMATOR_TYPE_GPS,

  /**
   * Estimator integrating GPS and inertial sensing.
   */
  @MavlinkEnumEntry(5)
  MAV_ESTIMATOR_TYPE_GPS_INS
}
