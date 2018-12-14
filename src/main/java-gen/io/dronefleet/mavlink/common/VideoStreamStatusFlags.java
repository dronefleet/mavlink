package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Stream status flags (Bitmap) 
 */
@MavlinkEnum
public enum VideoStreamStatusFlags {
    /**
     * Stream is active (running) 
     */
    @MavlinkEntryInfo(1)
    VIDEO_STREAM_STATUS_FLAGS_RUNNING,

    /**
     * Stream is thermal imaging 
     */
    @MavlinkEntryInfo(2)
    VIDEO_STREAM_STATUS_FLAGS_THERMAL
}
