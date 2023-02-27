package io.dronefleet.mavlink.storm32;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Frsky SPort passthrough multi packet container. 
 */
@MavlinkMessageInfo(
        id = 60040,
        crc = 156,
        description = "Frsky SPort passthrough multi packet container."
)
public final class FrskyPassthroughArray {
    private final long timeBootMs;

    private final int count;

    private final byte[] packetBuf;

    private FrskyPassthroughArray(long timeBootMs, int count, byte[] packetBuf) {
        this.timeBootMs = timeBootMs;
        this.count = count;
        this.packetBuf = packetBuf;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (time since system boot). 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Timestamp (time since system boot)."
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * Number of passthrough packets in this message. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Number of passthrough packets in this message."
    )
    public final int count() {
        return this.count;
    }

    /**
     * Passthrough packet buffer. A packet has 6 bytes: uint16_t id + uint32_t data. The array has 
     * space for 40 packets. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            arraySize = 240,
            description = "Passthrough packet buffer. A packet has 6 bytes: uint16_t id + uint32_t data. The array has space for 40 packets."
    )
    public final byte[] packetBuf() {
        return this.packetBuf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        FrskyPassthroughArray other = (FrskyPassthroughArray)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(count, other.count)) return false;
        if (!Objects.deepEquals(packetBuf, other.packetBuf)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(count);
        result = 31 * result + Objects.hashCode(packetBuf);
        return result;
    }

    @Override
    public String toString() {
        return "FrskyPassthroughArray{timeBootMs=" + timeBootMs
                 + ", count=" + count
                 + ", packetBuf=" + packetBuf + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private int count;

        private byte[] packetBuf;

        /**
         * Timestamp (time since system boot). 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Timestamp (time since system boot)."
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * Number of passthrough packets in this message. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Number of passthrough packets in this message."
        )
        public final Builder count(int count) {
            this.count = count;
            return this;
        }

        /**
         * Passthrough packet buffer. A packet has 6 bytes: uint16_t id + uint32_t data. The array has 
         * space for 40 packets. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                arraySize = 240,
                description = "Passthrough packet buffer. A packet has 6 bytes: uint16_t id + uint32_t data. The array has space for 40 packets."
        )
        public final Builder packetBuf(byte[] packetBuf) {
            this.packetBuf = packetBuf;
            return this;
        }

        public final FrskyPassthroughArray build() {
            return new FrskyPassthroughArray(timeBootMs, count, packetBuf);
        }
    }
}
