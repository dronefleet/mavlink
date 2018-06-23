package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * null
 */
@MavlinkEnum
public enum AccelcalVehiclePos {
    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(1)
    ACCELCAL_VEHICLE_POS_LEVEL,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(2)
    ACCELCAL_VEHICLE_POS_LEFT,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(3)
    ACCELCAL_VEHICLE_POS_RIGHT,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(4)
    ACCELCAL_VEHICLE_POS_NOSEDOWN,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(5)
    ACCELCAL_VEHICLE_POS_NOSEUP,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(6)
    ACCELCAL_VEHICLE_POS_BACK,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(16777215)
    ACCELCAL_VEHICLE_POS_SUCCESS,

    /**
     * null<dl>
     *
     * </dl>
     */
    @MavlinkEntryInfo(16777216)
    ACCELCAL_VEHICLE_POS_FAILED
}
