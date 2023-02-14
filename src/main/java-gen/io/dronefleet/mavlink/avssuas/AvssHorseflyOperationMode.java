package io.dronefleet.mavlink.avssuas;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum AvssHorseflyOperationMode {
    /**
     * In manual control mode 
     */
    @MavlinkEntryInfo(0)
    MODE_HORSEFLY_MANUAL_CTRL,

    /**
     * In auto takeoff mode 
     */
    @MavlinkEntryInfo(1)
    MODE_HORSEFLY_AUTO_TAKEOFF,

    /**
     * In auto landing mode 
     */
    @MavlinkEntryInfo(2)
    MODE_HORSEFLY_AUTO_LANDING,

    /**
     * In go home mode 
     */
    @MavlinkEntryInfo(3)
    MODE_HORSEFLY_NAVI_GO_HOME,

    /**
     * In drop mode 
     */
    @MavlinkEntryInfo(4)
    MODE_HORSEFLY_DROP
}
