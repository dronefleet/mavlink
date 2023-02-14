package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum HeadingType {
    /**
     *  
     */
    @MavlinkEntryInfo(0)
    HEADING_TYPE_COURSE_OVER_GROUND,

    /**
     *  
     */
    @MavlinkEntryInfo(1)
    HEADING_TYPE_HEADING
}
