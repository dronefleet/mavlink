package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum MagCalStatus {
    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(0)
    MAG_CAL_NOT_STARTED,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    MAG_CAL_WAITING_TO_START,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    MAG_CAL_RUNNING_STEP_ONE,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    MAG_CAL_RUNNING_STEP_TWO,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    MAG_CAL_SUCCESS,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(5)
    MAG_CAL_FAILED
}
