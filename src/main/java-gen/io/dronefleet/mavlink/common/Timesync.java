package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Time synchronization message. 
 */
@MavlinkMessageInfo(
        id = 111,
        crc = 34
)
public final class Timesync {
    private final long tc1;

    private final long ts1;

    private Timesync(long tc1, long ts1) {
        this.tc1 = tc1;
        this.ts1 = ts1;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Time sync timestamp 1 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            signed = true
    )
    public final long tc1() {
        return this.tc1;
    }

    /**
     * Time sync timestamp 2 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 8,
            signed = true
    )
    public final long ts1() {
        return this.ts1;
    }

    public static final class Builder {
        private long tc1;

        private long ts1;

        /**
         * Time sync timestamp 1 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                signed = true
        )
        public final Builder tc1(long tc1) {
            this.tc1 = tc1;
            return this;
        }

        /**
         * Time sync timestamp 2 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 8,
                signed = true
        )
        public final Builder ts1(long ts1) {
            this.ts1 = ts1;
            return this;
        }

        public final Timesync build() {
            return new Timesync(tc1, ts1);
        }
    }
}
