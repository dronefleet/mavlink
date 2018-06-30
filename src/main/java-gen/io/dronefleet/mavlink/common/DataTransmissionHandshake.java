package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.util.Objects;

/**
 *  
 */
@MavlinkMessageInfo(
        id = 130,
        crc = 29
)
public final class DataTransmissionHandshake {
    private final int type;

    private final long size;

    private final int width;

    private final int height;

    private final int packets;

    private final int payload;

    private final int jpgQuality;

    private DataTransmissionHandshake(int type, long size, int width, int height, int packets,
            int payload, int jpgQuality) {
        this.type = type;
        this.size = size;
        this.width = width;
        this.height = height;
        this.packets = packets;
        this.payload = payload;
        this.jpgQuality = jpgQuality;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
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
        return this.type;
    }

    /**
     * total data size in bytes (set on ACK only) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final long size() {
        return this.size;
    }

    /**
     * Width of a matrix or image 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2
    )
    public final int width() {
        return this.width;
    }

    /**
     * Height of a matrix or image 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2
    )
    public final int height() {
        return this.height;
    }

    /**
     * number of packets beeing sent (set on ACK only) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2
    )
    public final int packets() {
        return this.packets;
    }

    /**
     * payload size per packet (normally 253 byte, see DATA field size in message {@link io.dronefleet.mavlink.common.EncapsulatedData ENCAPSULATED_DATA}) 
     * (set on ACK only) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final int payload() {
        return this.payload;
    }

    /**
     * JPEG quality out of [1,100] 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1
    )
    public final int jpgQuality() {
        return this.jpgQuality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        DataTransmissionHandshake other = (DataTransmissionHandshake)o;
        if (!Objects.deepEquals(type, other.type)) return false;
        if (!Objects.deepEquals(size, other.size)) return false;
        if (!Objects.deepEquals(width, other.width)) return false;
        if (!Objects.deepEquals(height, other.height)) return false;
        if (!Objects.deepEquals(packets, other.packets)) return false;
        if (!Objects.deepEquals(payload, other.payload)) return false;
        if (!Objects.deepEquals(jpgQuality, other.jpgQuality)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(type);
        result = 31 * result + Objects.hashCode(size);
        result = 31 * result + Objects.hashCode(width);
        result = 31 * result + Objects.hashCode(height);
        result = 31 * result + Objects.hashCode(packets);
        result = 31 * result + Objects.hashCode(payload);
        result = 31 * result + Objects.hashCode(jpgQuality);
        return result;
    }

    public static final class Builder {
        private int type;

        private long size;

        private int width;

        private int height;

        private int packets;

        private int payload;

        private int jpgQuality;

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
         * payload size per packet (normally 253 byte, see DATA field size in message {@link io.dronefleet.mavlink.common.EncapsulatedData ENCAPSULATED_DATA}) 
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
            return new DataTransmissionHandshake(type, size, width, height, packets, payload, jpgQuality);
        }
    }
}
