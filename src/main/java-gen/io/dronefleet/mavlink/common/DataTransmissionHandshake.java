package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * null
 */
@MavlinkMessageInfo(
        id = 130,
        crc = 29
)
public final class DataTransmissionHandshake {
    /**
     * total data size in bytes (set on ACK only) 
     */
    private final long size;

    /**
     * Width of a matrix or image 
     */
    private final int width;

    /**
     * Height of a matrix or image 
     */
    private final int height;

    /**
     * number of packets beeing sent (set on ACK only) 
     */
    private final int packets;

    /**
     * type of requested/acknowledged data (as defined in ENUM DATA_TYPES in 
     * mavlink/include/mavlink_types.h) 
     */
    private final int type;

    /**
     * payload size per packet (normally 253 byte, see DATA field size in message ENCAPSULATED_DATA) 
     * (set on ACK only) 
     */
    private final int payload;

    /**
     * JPEG quality out of [1,100] 
     */
    private final int jpgQuality;

    private DataTransmissionHandshake(long size, int width, int height, int packets, int type,
            int payload, int jpgQuality) {
        this.size = size;
        this.width = width;
        this.height = height;
        this.packets = packets;
        this.type = type;
        this.payload = payload;
        this.jpgQuality = jpgQuality;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "DataTransmissionHandshake{type=" + type
                 + ", size=" + size
                 + ", width=" + width
                 + ", height=" + height
                 + ", packets=" + packets
                 + ", payload=" + payload
                 + ", jpgQuality=" + jpgQuality + "}";
    }

    /**
     * total data size in bytes (set on ACK only) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final long size() {
        return size;
    }

    /**
     * Width of a matrix or image 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2
    )
    public final int width() {
        return width;
    }

    /**
     * Height of a matrix or image 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2
    )
    public final int height() {
        return height;
    }

    /**
     * number of packets beeing sent (set on ACK only) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2
    )
    public final int packets() {
        return packets;
    }

    /**
     * type of requested/acknowledged data (as defined in ENUM DATA_TYPES in 
     * mavlink/include/mavlink_types.h) 
     */
    @MavlinkFieldInfo(
            position = 0,
            unitSize = 1
    )
    public final int type() {
        return type;
    }

    /**
     * payload size per packet (normally 253 byte, see DATA field size in message ENCAPSULATED_DATA) 
     * (set on ACK only) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final int payload() {
        return payload;
    }

    /**
     * JPEG quality out of [1,100] 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1
    )
    public final int jpgQuality() {
        return jpgQuality;
    }

    public static class Builder {
        private long size;

        private int width;

        private int height;

        private int packets;

        private int type;

        private int payload;

        private int jpgQuality;

        private Builder() {
        }

        /**
         * total data size in bytes (set on ACK only) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
        )
        public final Builder size(long size) {
            this.size = size;
            return this;
        }

        /**
         * Width of a matrix or image 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2
        )
        public final Builder width(int width) {
            this.width = width;
            return this;
        }

        /**
         * Height of a matrix or image 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2
        )
        public final Builder height(int height) {
            this.height = height;
            return this;
        }

        /**
         * number of packets beeing sent (set on ACK only) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2
        )
        public final Builder packets(int packets) {
            this.packets = packets;
            return this;
        }

        /**
         * type of requested/acknowledged data (as defined in ENUM DATA_TYPES in 
         * mavlink/include/mavlink_types.h) 
         */
        @MavlinkFieldInfo(
                position = 0,
                unitSize = 1
        )
        public final Builder type(int type) {
            this.type = type;
            return this;
        }

        /**
         * payload size per packet (normally 253 byte, see DATA field size in message ENCAPSULATED_DATA) 
         * (set on ACK only) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1
        )
        public final Builder payload(int payload) {
            this.payload = payload;
            return this;
        }

        /**
         * JPEG quality out of [1,100] 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1
        )
        public final Builder jpgQuality(int jpgQuality) {
            this.jpgQuality = jpgQuality;
            return this;
        }

        public final DataTransmissionHandshake build() {
            return new DataTransmissionHandshake(size, width, height, packets, type, payload, jpgQuality);
        }
    }
}
