package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Time synchronization message. 
 */
@MavlinkMessageInfo(
        id = 111,
        crc = 34
)
public final class Timesync {
    /**
     * Time sync timestamp 1 
     */
    private final long tc1;

    /**
     * Time sync timestamp 2 
     */
    private final long ts1;

    private Timesync(long tc1, long ts1) {
        this.tc1 = tc1;
        this.ts1 = ts1;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Timesync{tc1=" + tc1
                 + ", ts1=" + ts1 + "}";
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
        return tc1;
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
        return ts1;
    }

    public static class Builder {
        private long tc1;

        private long ts1;

        private Builder() {
        }

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
