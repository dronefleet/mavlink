package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Enumeration of estimator types 
 */
@MavlinkEnum
public enum MavEstimatorType {
    /**
     * Unknown type of the estimator. 
     */
    @MavlinkEntryInfo(0)
    MAV_ESTIMATOR_TYPE_UNKNOWN,

    /**
     * This is a naive estimator without any real covariance feedback. 
     */
    @MavlinkEntryInfo(1)
    MAV_ESTIMATOR_TYPE_NAIVE,

    /**
     * Computer vision based estimate. Might be up to scale. 
     */
    @MavlinkEntryInfo(2)
    MAV_ESTIMATOR_TYPE_VISION,

    /**
     * Visual-inertial estimate. 
     */
    @MavlinkEntryInfo(3)
    MAV_ESTIMATOR_TYPE_VIO,

    /**
     * Plain GPS estimate. 
     */
    @MavlinkEntryInfo(4)
    MAV_ESTIMATOR_TYPE_GPS,

    /**
     * Estimator integrating GPS and inertial sensing. 
     */
    @MavlinkEntryInfo(5)
    MAV_ESTIMATOR_TYPE_GPS_INS,

    /**
     * Estimate from external motion capturing system. 
     */
    @MavlinkEntryInfo(6)
    MAV_ESTIMATOR_TYPE_MOCAP,

    /**
     * Estimator based on lidar sensor input. 
     */
    @MavlinkEntryInfo(7)
    MAV_ESTIMATOR_TYPE_LIDAR,

    /**
     * Estimator on autopilot. 
     */
    @MavlinkEntryInfo(8)
    MAV_ESTIMATOR_TYPE_AUTOPILOT
}
