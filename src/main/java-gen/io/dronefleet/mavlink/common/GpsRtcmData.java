package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * RTCM message for injecting into the onboard GPS (used for DGPS) 
 */
@MavlinkMessageInfo(
        id = 233,
        crc = 35,
        description = "RTCM message for injecting into the onboard GPS (used for DGPS)"
)
public final class GpsRtcmData {
    private final int flags;

    private final int len;

    private final byte[] data;

    private GpsRtcmData(int flags, int len, byte[] data) {
        this.flags = flags;
        this.len = len;
        this.data = data;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * LSB: 1 means message is fragmented, next 2 bits are the fragment ID, the remaining 5 bits are used 
     * for the sequence ID. Messages are only to be flushed to the GPS when the entire message has been 
     * reconstructed on the autopilot. The fragment ID specifies which order the fragments should be 
     * assembled into a buffer, while the sequence ID is used to detect a mismatch between different 
     * buffers. The buffer is considered fully reconstructed when either all 4 fragments are 
     * present, or all the fragments before the first fragment with a non full payload is received. 
     * This management is used to ensure that normal GPS operation doesn't corrupt RTCM data, and to 
     * recover from a unreliable transport delivery order. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "LSB: 1 means message is fragmented, next 2 bits are the fragment ID, the remaining 5 bits are used for the sequence ID. Messages are only to be flushed to the GPS when the entire message has been reconstructed on the autopilot. The fragment ID specifies which order the fragments should be assembled into a buffer, while the sequence ID is used to detect a mismatch between different buffers. The buffer is considered fully reconstructed when either all 4 fragments are present, or all the fragments before the first fragment with a non full payload is received. This management is used to ensure that normal GPS operation doesn't corrupt RTCM data, and to recover from a unreliable transport delivery order."
    )
    public final int flags() {
        return this.flags;
    }

    /**
     * data length 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "data length"
    )
    public final int len() {
        return this.len;
    }

    /**
     * RTCM message (may be fragmented) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            arraySize = 180,
            description = "RTCM message (may be fragmented)"
    )
    public final byte[] data() {
        return this.data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        GpsRtcmData other = (GpsRtcmData)o;
        if (!Objects.deepEquals(flags, other.flags)) return false;
        if (!Objects.deepEquals(len, other.len)) return false;
        if (!Objects.deepEquals(data, other.data)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(flags);
        result = 31 * result + Objects.hashCode(len);
        result = 31 * result + Objects.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        return "GpsRtcmData{flags=" + flags
                 + ", len=" + len
                 + ", data=" + data + "}";
    }

    public static final class Builder {
        private int flags;

        private int len;

        private byte[] data;

        /**
         * LSB: 1 means message is fragmented, next 2 bits are the fragment ID, the remaining 5 bits are used 
         * for the sequence ID. Messages are only to be flushed to the GPS when the entire message has been 
         * reconstructed on the autopilot. The fragment ID specifies which order the fragments should be 
         * assembled into a buffer, while the sequence ID is used to detect a mismatch between different 
         * buffers. The buffer is considered fully reconstructed when either all 4 fragments are 
         * present, or all the fragments before the first fragment with a non full payload is received. 
         * This management is used to ensure that normal GPS operation doesn't corrupt RTCM data, and to 
         * recover from a unreliable transport delivery order. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "LSB: 1 means message is fragmented, next 2 bits are the fragment ID, the remaining 5 bits are used for the sequence ID. Messages are only to be flushed to the GPS when the entire message has been reconstructed on the autopilot. The fragment ID specifies which order the fragments should be assembled into a buffer, while the sequence ID is used to detect a mismatch between different buffers. The buffer is considered fully reconstructed when either all 4 fragments are present, or all the fragments before the first fragment with a non full payload is received. This management is used to ensure that normal GPS operation doesn't corrupt RTCM data, and to recover from a unreliable transport delivery order."
        )
        public final Builder flags(int flags) {
            this.flags = flags;
            return this;
        }

        /**
         * data length 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "data length"
        )
        public final Builder len(int len) {
            this.len = len;
            return this;
        }

        /**
         * RTCM message (may be fragmented) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                arraySize = 180,
                description = "RTCM message (may be fragmented)"
        )
        public final Builder data(byte[] data) {
            this.data = data;
            return this;
        }

        public final GpsRtcmData build() {
            return new GpsRtcmData(flags, len, data);
        }
    }
}
