package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * Handshake message to initiate, control and stop image streaming when using the Image 
 * Transmission Protocol: https://mavlink.io/en/services/image_transmission.html. 
 */
@MavlinkMessageInfo(
        id = 130,
        crc = 29,
        description = "Handshake message to initiate, control and stop image streaming when using the Image Transmission Protocol: https://mavlink.io/en/services/image_transmission.html."
)
public final class DataTransmissionHandshake {
    private final EnumValue<MavlinkDataStreamType> type;

    private final long size;

    private final int width;

    private final int height;

    private final int packets;

    private final int payload;

    private final int jpgQuality;

    private DataTransmissionHandshake(EnumValue<MavlinkDataStreamType> type, long size, int width,
            int height, int packets, int payload, int jpgQuality) {
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
     * Type of requested/acknowledged data. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            enumType = MavlinkDataStreamType.class,
            description = "Type of requested/acknowledged data."
    )
    public final EnumValue<MavlinkDataStreamType> type() {
        return this.type;
    }

    /**
     * total data size (set on ACK only). 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "total data size (set on ACK only)."
    )
    public final long size() {
        return this.size;
    }

    /**
     * Width of a matrix or image. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            description = "Width of a matrix or image."
    )
    public final int width() {
        return this.width;
    }

    /**
     * Height of a matrix or image. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            description = "Height of a matrix or image."
    )
    public final int height() {
        return this.height;
    }

    /**
     * Number of packets being sent (set on ACK only). 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            description = "Number of packets being sent (set on ACK only)."
    )
    public final int packets() {
        return this.packets;
    }

    /**
     * Payload size per packet (normally 253 byte, see DATA field size in message {@link io.dronefleet.mavlink.common.EncapsulatedData ENCAPSULATED_DATA}) 
     * (set on ACK only). 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            description = "Payload size per packet (normally 253 byte, see DATA field size in message ENCAPSULATED_DATA) (set on ACK only)."
    )
    public final int payload() {
        return this.payload;
    }

    /**
     * JPEG quality. Values: [1-100]. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1,
            description = "JPEG quality. Values: [1-100]."
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

    public static final class Builder {
        private EnumValue<MavlinkDataStreamType> type;

        private long size;

        private int width;

        private int height;

        private int packets;

        private int payload;

        private int jpgQuality;

        /**
         * Type of requested/acknowledged data. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                enumType = MavlinkDataStreamType.class,
                description = "Type of requested/acknowledged data."
        )
        public final Builder type(EnumValue<MavlinkDataStreamType> type) {
            this.type = type;
            return this;
        }

        /**
         * Type of requested/acknowledged data. 
         */
        public final Builder type(MavlinkDataStreamType entry) {
            return type(EnumValue.of(entry));
        }

        /**
         * Type of requested/acknowledged data. 
         */
        public final Builder type(Enum... flags) {
            return type(EnumValue.create(flags));
        }

        /**
         * Type of requested/acknowledged data. 
         */
        public final Builder type(Collection<Enum> flags) {
            return type(EnumValue.create(flags));
        }

        /**
         * total data size (set on ACK only). 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "total data size (set on ACK only)."
        )
        public final Builder size(long size) {
            this.size = size;
            return this;
        }

        /**
         * Width of a matrix or image. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                description = "Width of a matrix or image."
        )
        public final Builder width(int width) {
            this.width = width;
            return this;
        }

        /**
         * Height of a matrix or image. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                description = "Height of a matrix or image."
        )
        public final Builder height(int height) {
            this.height = height;
            return this;
        }

        /**
         * Number of packets being sent (set on ACK only). 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                description = "Number of packets being sent (set on ACK only)."
        )
        public final Builder packets(int packets) {
            this.packets = packets;
            return this;
        }

        /**
         * Payload size per packet (normally 253 byte, see DATA field size in message {@link io.dronefleet.mavlink.common.EncapsulatedData ENCAPSULATED_DATA}) 
         * (set on ACK only). 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                description = "Payload size per packet (normally 253 byte, see DATA field size in message ENCAPSULATED_DATA) (set on ACK only)."
        )
        public final Builder payload(int payload) {
            this.payload = payload;
            return this;
        }

        /**
         * JPEG quality. Values: [1-100]. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1,
                description = "JPEG quality. Values: [1-100]."
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
