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
        id = 131,
        crc = 223
)
public final class EncapsulatedData {
    private final int seqnr;

    private final byte[] data;

    private EncapsulatedData(int seqnr, byte[] data) {
        this.seqnr = seqnr;
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
     * sequence number (starting with 0 on every transmission) 
     */
    @MavlinkFieldInfo(
            position = 0,
            unitSize = 2
    )
    public final int seqnr() {
        return this.seqnr;
    }

    /**
     * image data bytes 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            arraySize = 253
    )
    public final byte[] data() {
        return this.data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        EncapsulatedData other = (EncapsulatedData)o;
        if (!Objects.deepEquals(seqnr, other.seqnr)) return false;
        if (!Objects.deepEquals(data, other.data)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(seqnr);
        result = 31 * result + Objects.hashCode(data);
        return result;
    }

    public static final class Builder {
        private int seqnr;

        private byte[] data;

        /**
         * sequence number (starting with 0 on every transmission) 
         */
        @MavlinkFieldInfo(
                position = 0,
                unitSize = 2
        )
        public final Builder seqnr(int seqnr) {
            this.seqnr = seqnr;
            return this;
        }

        /**
         * image data bytes 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                arraySize = 253
        )
        public final Builder data(byte[] data) {
            this.data = data;
            return this;
        }

        public final EncapsulatedData build() {
            return new EncapsulatedData(seqnr, data);
        }
    }
}
