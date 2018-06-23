package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Enumeration of estimator types 
 */
@MavlinkEnum
public enum MavEstimatorType {
    /**
     * This is a naive estimator without any real covariance feedback.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    MAV_ESTIMATOR_TYPE_NAIVE,

    /**
     * Computer vision based estimate. Might be up to scale.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    MAV_ESTIMATOR_TYPE_VISION,

    /**
     * Visual-inertial estimate.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    MAV_ESTIMATOR_TYPE_VIO,

    /**
     * Plain GPS estimate.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    MAV_ESTIMATOR_TYPE_GPS,

    /**
     * Estimator integrating GPS and inertial sensing.<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(5)
    MAV_ESTIMATOR_TYPE_GPS_INS
}
