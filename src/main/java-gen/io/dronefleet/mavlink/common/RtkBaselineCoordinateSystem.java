package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * RTK GPS baseline coordinate system, used for RTK corrections 
 */
@MavlinkEnum
public enum RtkBaselineCoordinateSystem {
    /**
     * Earth-centered, Earth-fixed 
     */
    @MavlinkEntryInfo(0)
    RTK_BASELINE_COORDINATE_SYSTEM_ECEF,

    /**
     * RTK basestation centered, north, east, down 
     */
    @MavlinkEntryInfo(1)
    RTK_BASELINE_COORDINATE_SYSTEM_NED
}
