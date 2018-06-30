package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Sent from simulation to autopilot. The RAW values of the RC channels received. The standard PPM 
 * modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%. Individual 
 * receivers/transmitters might violate this specification. 
 */
@MavlinkMessageInfo(
        id = 92,
        crc = 54
)
public final class HilRcInputsRaw {
    private final BigInteger timeUsec;

    private final int chan1Raw;

    private final int chan2Raw;

    private final int chan3Raw;

    private final int chan4Raw;

    private final int chan5Raw;

    private final int chan6Raw;

    private final int chan7Raw;

    private final int chan8Raw;

    private final int chan9Raw;

    private final int chan10Raw;

    private final int chan11Raw;

    private final int chan12Raw;

    private final int rssi;

    private HilRcInputsRaw(BigInteger timeUsec, int chan1Raw, int chan2Raw, int chan3Raw,
            int chan4Raw, int chan5Raw, int chan6Raw, int chan7Raw, int chan8Raw, int chan9Raw,
            int chan10Raw, int chan11Raw, int chan12Raw, int rssi) {
        this.timeUsec = timeUsec;
        this.chan1Raw = chan1Raw;
        this.chan2Raw = chan2Raw;
        this.chan3Raw = chan3Raw;
        this.chan4Raw = chan4Raw;
        this.chan5Raw = chan5Raw;
        this.chan6Raw = chan6Raw;
        this.chan7Raw = chan7Raw;
        this.chan8Raw = chan8Raw;
        this.chan9Raw = chan9Raw;
        this.chan10Raw = chan10Raw;
        this.chan11Raw = chan11Raw;
        this.chan12Raw = chan12Raw;
        this.rssi = rssi;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * RC channel 1 value, in microseconds 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2
    )
    public final int chan1Raw() {
        return this.chan1Raw;
    }

    /**
     * RC channel 2 value, in microseconds 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2
    )
    public final int chan2Raw() {
        return this.chan2Raw;
    }

    /**
     * RC channel 3 value, in microseconds 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2
    )
    public final int chan3Raw() {
        return this.chan3Raw;
    }

    /**
     * RC channel 4 value, in microseconds 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2
    )
    public final int chan4Raw() {
        return this.chan4Raw;
    }

    /**
     * RC channel 5 value, in microseconds 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2
    )
    public final int chan5Raw() {
        return this.chan5Raw;
    }

    /**
     * RC channel 6 value, in microseconds 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2
    )
    public final int chan6Raw() {
        return this.chan6Raw;
    }

    /**
     * RC channel 7 value, in microseconds 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2
    )
    public final int chan7Raw() {
        return this.chan7Raw;
    }

    /**
     * RC channel 8 value, in microseconds 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2
    )
    public final int chan8Raw() {
        return this.chan8Raw;
    }

    /**
     * RC channel 9 value, in microseconds 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 2
    )
    public final int chan9Raw() {
        return this.chan9Raw;
    }

    /**
     * RC channel 10 value, in microseconds 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 2
    )
    public final int chan10Raw() {
        return this.chan10Raw;
    }

    /**
     * RC channel 11 value, in microseconds 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 2
    )
    public final int chan11Raw() {
        return this.chan11Raw;
    }

    /**
     * RC channel 12 value, in microseconds 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 2
    )
    public final int chan12Raw() {
        return this.chan12Raw;
    }

    /**
     * Receive signal strength indicator, 0: 0%, 255: 100% 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 1
    )
    public final int rssi() {
        return this.rssi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        HilRcInputsRaw other = (HilRcInputsRaw)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(chan1Raw, other.chan1Raw)) return false;
        if (!Objects.deepEquals(chan2Raw, other.chan2Raw)) return false;
        if (!Objects.deepEquals(chan3Raw, other.chan3Raw)) return false;
        if (!Objects.deepEquals(chan4Raw, other.chan4Raw)) return false;
        if (!Objects.deepEquals(chan5Raw, other.chan5Raw)) return false;
        if (!Objects.deepEquals(chan6Raw, other.chan6Raw)) return false;
        if (!Objects.deepEquals(chan7Raw, other.chan7Raw)) return false;
        if (!Objects.deepEquals(chan8Raw, other.chan8Raw)) return false;
        if (!Objects.deepEquals(chan9Raw, other.chan9Raw)) return false;
        if (!Objects.deepEquals(chan10Raw, other.chan10Raw)) return false;
        if (!Objects.deepEquals(chan11Raw, other.chan11Raw)) return false;
        if (!Objects.deepEquals(chan12Raw, other.chan12Raw)) return false;
        if (!Objects.deepEquals(rssi, other.rssi)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(chan1Raw);
        result = 31 * result + Objects.hashCode(chan2Raw);
        result = 31 * result + Objects.hashCode(chan3Raw);
        result = 31 * result + Objects.hashCode(chan4Raw);
        result = 31 * result + Objects.hashCode(chan5Raw);
        result = 31 * result + Objects.hashCode(chan6Raw);
        result = 31 * result + Objects.hashCode(chan7Raw);
        result = 31 * result + Objects.hashCode(chan8Raw);
        result = 31 * result + Objects.hashCode(chan9Raw);
        result = 31 * result + Objects.hashCode(chan10Raw);
        result = 31 * result + Objects.hashCode(chan11Raw);
        result = 31 * result + Objects.hashCode(chan12Raw);
        result = 31 * result + Objects.hashCode(rssi);
        return result;
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private int chan1Raw;

        private int chan2Raw;

        private int chan3Raw;

        private int chan4Raw;

        private int chan5Raw;

        private int chan6Raw;

        private int chan7Raw;

        private int chan8Raw;

        private int chan9Raw;

        private int chan10Raw;

        private int chan11Raw;

        private int chan12Raw;

        private int rssi;

        /**
         * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
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
         * RC channel 1 value, in microseconds 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2
        )
        public final Builder chan1Raw(int chan1Raw) {
            this.chan1Raw = chan1Raw;
            return this;
        }

        /**
         * RC channel 2 value, in microseconds 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2
        )
        public final Builder chan2Raw(int chan2Raw) {
            this.chan2Raw = chan2Raw;
            return this;
        }

        /**
         * RC channel 3 value, in microseconds 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2
        )
        public final Builder chan3Raw(int chan3Raw) {
            this.chan3Raw = chan3Raw;
            return this;
        }

        /**
         * RC channel 4 value, in microseconds 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2
        )
        public final Builder chan4Raw(int chan4Raw) {
            this.chan4Raw = chan4Raw;
            return this;
        }

        /**
         * RC channel 5 value, in microseconds 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2
        )
        public final Builder chan5Raw(int chan5Raw) {
            this.chan5Raw = chan5Raw;
            return this;
        }

        /**
         * RC channel 6 value, in microseconds 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2
        )
        public final Builder chan6Raw(int chan6Raw) {
            this.chan6Raw = chan6Raw;
            return this;
        }

        /**
         * RC channel 7 value, in microseconds 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2
        )
        public final Builder chan7Raw(int chan7Raw) {
            this.chan7Raw = chan7Raw;
            return this;
        }

        /**
         * RC channel 8 value, in microseconds 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2
        )
        public final Builder chan8Raw(int chan8Raw) {
            this.chan8Raw = chan8Raw;
            return this;
        }

        /**
         * RC channel 9 value, in microseconds 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 2
        )
        public final Builder chan9Raw(int chan9Raw) {
            this.chan9Raw = chan9Raw;
            return this;
        }

        /**
         * RC channel 10 value, in microseconds 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 2
        )
        public final Builder chan10Raw(int chan10Raw) {
            this.chan10Raw = chan10Raw;
            return this;
        }

        /**
         * RC channel 11 value, in microseconds 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 2
        )
        public final Builder chan11Raw(int chan11Raw) {
            this.chan11Raw = chan11Raw;
            return this;
        }

        /**
         * RC channel 12 value, in microseconds 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 2
        )
        public final Builder chan12Raw(int chan12Raw) {
            this.chan12Raw = chan12Raw;
            return this;
        }

        /**
         * Receive signal strength indicator, 0: 0%, 255: 100% 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 1
        )
        public final Builder rssi(int rssi) {
            this.rssi = rssi;
            return this;
        }

        public final HilRcInputsRaw build() {
            return new HilRcInputsRaw(timeUsec, chan1Raw, chan2Raw, chan3Raw, chan4Raw, chan5Raw, chan6Raw, chan7Raw, chan8Raw, chan9Raw, chan10Raw, chan11Raw, chan12Raw, rssi);
        }
    }
}
