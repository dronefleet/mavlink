package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.Objects;

/**
 * The system time is the time of the master clock, typically the computer clock of the main onboard 
 * computer. 
 */
@MavlinkMessageInfo(
        id = 2,
        crc = 137,
        description = "The system time is the time of the master clock, typically the computer clock of the main onboard computer."
)
public final class SystemTime {
    private final BigInteger timeUnixUsec;

    private final long timeBootMs;

    private SystemTime(BigInteger timeUnixUsec, long timeBootMs) {
        this.timeUnixUsec = timeUnixUsec;
        this.timeBootMs = timeBootMs;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp of the master clock in microseconds since UNIX epoch. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            description = "Timestamp of the master clock in microseconds since UNIX epoch."
    )
    public final BigInteger timeUnixUsec() {
        return this.timeUnixUsec;
    }

    /**
     * Timestamp of the component clock since boot time in milliseconds. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Timestamp of the component clock since boot time in milliseconds."
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SystemTime other = (SystemTime)o;
        if (!Objects.deepEquals(timeUnixUsec, other.timeUnixUsec)) return false;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUnixUsec);
        result = 31 * result + Objects.hashCode(timeBootMs);
        return result;
    }

    @Override
    public String toString() {
        return "SystemTime{timeUnixUsec=" + timeUnixUsec
                 + ", timeBootMs=" + timeBootMs + "}";
    }

    public static final class Builder {
        private BigInteger timeUnixUsec;

        private long timeBootMs;

        /**
         * Timestamp of the master clock in microseconds since UNIX epoch. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                description = "Timestamp of the master clock in microseconds since UNIX epoch."
        )
        public final Builder timeUnixUsec(BigInteger timeUnixUsec) {
            this.timeUnixUsec = timeUnixUsec;
            return this;
        }

        /**
         * Timestamp of the component clock since boot time in milliseconds. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Timestamp of the component clock since boot time in milliseconds."
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        public final SystemTime build() {
            return new SystemTime(timeUnixUsec, timeBootMs);
        }
    }
}
