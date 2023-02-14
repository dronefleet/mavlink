package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Flags for {@link io.dronefleet.mavlink.common.CurrentEventSequence CURRENT_EVENT_SEQUENCE}. 
 */
@MavlinkEnum
public enum MavEventCurrentSequenceFlags {
    /**
     * A sequence reset has happened (e.g. vehicle reboot). 
     */
    @MavlinkEntryInfo(1)
    MAV_EVENT_CURRENT_SEQUENCE_FLAGS_RESET
}
