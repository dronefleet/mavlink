package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Data packet, size 64. 
 */
@MavlinkMessageInfo(
        id = 171,
        crc = 181,
        description = "Data packet, size 64."
)
public final class Data64 {
    private final int type;

    private final int len;

    private final byte[] data;

    private Data64(int type, int len, byte[] data) {
        this.type = type;
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
     * Data type. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "Data type."
    )
    public final int type() {
        return this.type;
    }

    /**
     * Data length. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Data length."
    )
    public final int len() {
        return this.len;
    }

    /**
     * Raw data. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            arraySize = 64,
            description = "Raw data."
    )
    public final byte[] data() {
        return this.data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Data64 other = (Data64)o;
        if (!Objects.deepEquals(type, other.type)) return false;
        if (!Objects.deepEquals(len, other.len)) return false;
        if (!Objects.deepEquals(data, other.data)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(type);
        result = 31 * result + Objects.hashCode(len);
        result = 31 * result + Objects.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        return "Data64{type=" + type
                 + ", len=" + len
                 + ", data=" + data + "}";
    }

    public static final class Builder {
        private int type;

        private int len;

        private byte[] data;

        /**
         * Data type. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "Data type."
        )
        public final Builder type(int type) {
            this.type = type;
            return this;
        }

        /**
         * Data length. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Data length."
        )
        public final Builder len(int len) {
            this.len = len;
            return this;
        }

        /**
         * Raw data. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                arraySize = 64,
                description = "Raw data."
        )
        public final Builder data(byte[] data) {
            this.data = data;
            return this;
        }

        public final Data64 build() {
            return new Data64(type, len, data);
        }
    }
}
