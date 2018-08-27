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
 * A ping message either requesting or responding to a ping. This allows to measure the system 
 * latencies, including serial port, radio modem and UDP connections. 
 */
@MavlinkMessageInfo(
        id = 4,
        crc = 237
)
public final class Ping {
    private final BigInteger timeUsec;

    private final long seq;

    private final int targetSystem;

    private final int targetComponent;

    private Ping(BigInteger timeUsec, long seq, int targetSystem, int targetComponent) {
        this.timeUsec = timeUsec;
        this.seq = seq;
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Unix timestamp in microseconds or since system boot if smaller than MAVLink epoch (1.1.2009) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * {@link io.dronefleet.mavlink.common.Ping PING} sequence 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final long seq() {
        return this.seq;
    }

    /**
     * 0: request ping from all receiving systems, if greater than 0: message is a ping response and 
     * number is the system id of the requesting system 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * 0: request ping from all receiving components, if greater than 0: message is a ping response and 
     * number is the system id of the requesting system 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Ping other = (Ping)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(seq, other.seq)) return false;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(seq);
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        return result;
    }

    @Override
    public String toString() {
        return "Ping{timeUsec=" + timeUsec
                 + ", seq=" + seq
                 + ", targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent + "}";
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private long seq;

        private int targetSystem;

        private int targetComponent;

        /**
         * Unix timestamp in microseconds or since system boot if smaller than MAVLink epoch (1.1.2009) 
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
         * {@link io.dronefleet.mavlink.common.Ping PING} sequence 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder seq(long seq) {
            this.seq = seq;
            return this;
        }

        /**
         * 0: request ping from all receiving systems, if greater than 0: message is a ping response and 
         * number is the system id of the requesting system 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * 0: request ping from all receiving components, if greater than 0: message is a ping response and 
         * number is the system id of the requesting system 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        public final Ping build() {
            return new Ping(timeUsec, seq, targetSystem, targetComponent);
        }
    }
}
