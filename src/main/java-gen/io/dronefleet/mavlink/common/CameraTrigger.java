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
 * Camera-IMU triggering and synchronisation message. 
 */
@MavlinkMessageInfo(
        id = 112,
        crc = 174
)
public final class CameraTrigger {
    private final BigInteger timeUsec;

    private final long seq;

    private CameraTrigger(BigInteger timeUsec, long seq) {
        this.timeUsec = timeUsec;
        this.seq = seq;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp for the image frame in microseconds 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * Image frame sequence 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final long seq() {
        return this.seq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        CameraTrigger other = (CameraTrigger)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(seq, other.seq)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(seq);
        return result;
    }

    @Override
    public String toString() {
        return "CameraTrigger{timeUsec=" + timeUsec
                 + ", seq=" + seq + "}";
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private long seq;

        /**
         * Timestamp for the image frame in microseconds 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * Image frame sequence 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder seq(long seq) {
            this.seq = seq;
            return this;
        }

        public final CameraTrigger build() {
            return new CameraTrigger(timeUsec, seq);
        }
    }
}
