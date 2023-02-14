package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 *  
 */
@MavlinkEnum
public enum MavlinkDataStreamType {
    /**
     *  
     */
    @MavlinkEntryInfo(0)
    MAVLINK_DATA_STREAM_IMG_JPEG,

    /**
     *  
     */
    @MavlinkEntryInfo(1)
    MAVLINK_DATA_STREAM_IMG_BMP,

    /**
     *  
     */
    @MavlinkEntryInfo(2)
    MAVLINK_DATA_STREAM_IMG_RAW8U,

    /**
     *  
     */
    @MavlinkEntryInfo(3)
    MAVLINK_DATA_STREAM_IMG_RAW32U,

    /**
     *  
     */
    @MavlinkEntryInfo(4)
    MAVLINK_DATA_STREAM_IMG_PGM,

    /**
     *  
     */
    @MavlinkEntryInfo(5)
    MAVLINK_DATA_STREAM_IMG_PNG
}
