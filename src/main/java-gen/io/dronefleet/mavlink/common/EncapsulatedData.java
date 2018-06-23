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
        id = 131,
        crc = 223
)
public final class EncapsulatedData {
    /**
     * sequence number (starting with 0 on every transmission) 
     */
    private final int seqnr;

    /**
     * image data bytes 
     */
    private final byte[] data;

    private EncapsulatedData(int seqnr, byte[] data) {
        this.seqnr = seqnr;
        this.data = data;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "EncapsulatedData{seqnr=" + seqnr
                 + ", data=" + data + "}";
    }

    /**
     * sequence number (starting with 0 on every transmission) 
     */
    @MavlinkFieldInfo(
            position = 0,
            unitSize = 2
    )
    public final int seqnr() {
        return seqnr;
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
        return data;
    }

    public static class Builder {
        private int seqnr;

        private byte[] data;

        private Builder() {
        }

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
