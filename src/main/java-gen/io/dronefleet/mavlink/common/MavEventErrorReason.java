package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Reason for an event error response. 
 */
@MavlinkEnum
public enum MavEventErrorReason {
    /**
     * The requested event is not available (anymore). 
     */
    @MavlinkEntryInfo(0)
    MAV_EVENT_ERROR_REASON_UNAVAILABLE
}
