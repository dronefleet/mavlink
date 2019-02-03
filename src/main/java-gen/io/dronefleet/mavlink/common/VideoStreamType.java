package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkEntryInfo;
import io.dronefleet.mavlink.annotations.MavlinkEnum;

/**
 * Video stream types 
 */
@MavlinkEnum
public enum VideoStreamType {
    /**
     * Stream is RTSP 
     */
    @MavlinkEntryInfo(0)
    VIDEO_STREAM_TYPE_RTSP,

    /**
     * Stream is RTP UDP (URI gives the port number) 
     */
    @MavlinkEntryInfo(1)
    VIDEO_STREAM_TYPE_RTPUDP,

    /**
     * Stream is MPEG on TCP 
     */
    @MavlinkEntryInfo(2)
    VIDEO_STREAM_TYPE_TCP_MPEG,

    /**
     * Stream is h.264 on MPEG TS (URI gives the port number) 
     */
    @MavlinkEntryInfo(3)
    VIDEO_STREAM_TYPE_MPEG_TS_H264
}
