package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

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
