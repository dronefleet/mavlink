package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Flags for the global position report. 
 */
@MavlinkEnum
public enum UtmDataAvailFlags {
    /**
     * The field time contains valid data. 
     */
    @MavlinkEntryInfo(1)
    UTM_DATA_AVAIL_FLAGS_TIME_VALID,

    /**
     * The field uas_id contains valid data. 
     */
    @MavlinkEntryInfo(2)
    UTM_DATA_AVAIL_FLAGS_UAS_ID_AVAILABLE,

    /**
     * The fields lat, lon and h_acc contain valid data. 
     */
    @MavlinkEntryInfo(4)
    UTM_DATA_AVAIL_FLAGS_POSITION_AVAILABLE,

    /**
     * The fields alt and v_acc contain valid data. 
     */
    @MavlinkEntryInfo(8)
    UTM_DATA_AVAIL_FLAGS_ALTITUDE_AVAILABLE,

    /**
     * The field relative_alt contains valid data. 
     */
    @MavlinkEntryInfo(16)
    UTM_DATA_AVAIL_FLAGS_RELATIVE_ALTITUDE_AVAILABLE,

    /**
     * The fields vx and vy contain valid data. 
     */
    @MavlinkEntryInfo(32)
    UTM_DATA_AVAIL_FLAGS_HORIZONTAL_VELO_AVAILABLE,

    /**
     * The field vz contains valid data. 
     */
    @MavlinkEntryInfo(64)
    UTM_DATA_AVAIL_FLAGS_VERTICAL_VELO_AVAILABLE,

    /**
     * The fields next_lat, next_lon and next_alt contain valid data. 
     */
    @MavlinkEntryInfo(128)
    UTM_DATA_AVAIL_FLAGS_NEXT_WAYPOINT_AVAILABLE
}
