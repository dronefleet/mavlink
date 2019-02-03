package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * The RAW values of the RC channels received. The standard PPM modulation is as follows: 1000 
 * microseconds: 0%, 2000 microseconds: 100%. A value of UINT16_MAX implies the channel is 
 * unused. Individual receivers/transmitters might violate this specification. 
 */
@MavlinkMessageInfo(
        id = 35,
        crc = 244,
        description = "The RAW values of the RC channels received. The standard PPM modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%. A value of UINT16_MAX implies the channel is unused. Individual receivers/transmitters might violate this specification."
)
public final class RcChannelsRaw {
    private final long timeBootMs;

    private final int port;

    private final int chan1Raw;

    private final int chan2Raw;

    private final int chan3Raw;

    private final int chan4Raw;

    private final int chan5Raw;

    private final int chan6Raw;

    private final int chan7Raw;

    private final int chan8Raw;

    private final int rssi;

    private RcChannelsRaw(long timeBootMs, int port, int chan1Raw, int chan2Raw, int chan3Raw,
            int chan4Raw, int chan5Raw, int chan6Raw, int chan7Raw, int chan8Raw, int rssi) {
        this.timeBootMs = timeBootMs;
        this.port = port;
        this.chan1Raw = chan1Raw;
        this.chan2Raw = chan2Raw;
        this.chan3Raw = chan3Raw;
        this.chan4Raw = chan4Raw;
        this.chan5Raw = chan5Raw;
        this.chan6Raw = chan6Raw;
        this.chan7Raw = chan7Raw;
        this.chan8Raw = chan8Raw;
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
     * Servo output port (set of 8 outputs = 1 port). Flight stacks running on Pixhawk should use: 0 = 
     * MAIN, 1 = AUX. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Servo output port (set of 8 outputs = 1 port). Flight stacks running on Pixhawk should use: 0 = MAIN, 1 = AUX."
    )
    public final int port() {
        return this.port;
    }

    /**
     * RC channel 1 value. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            description = "RC channel 1 value."
    )
    public final int chan1Raw() {
        return this.chan1Raw;
    }

    /**
     * RC channel 2 value. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            description = "RC channel 2 value."
    )
    public final int chan2Raw() {
        return this.chan2Raw;
    }

    /**
     * RC channel 3 value. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            description = "RC channel 3 value."
    )
    public final int chan3Raw() {
        return this.chan3Raw;
    }

    /**
     * RC channel 4 value. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            description = "RC channel 4 value."
    )
    public final int chan4Raw() {
        return this.chan4Raw;
    }

    /**
     * RC channel 5 value. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            description = "RC channel 5 value."
    )
    public final int chan5Raw() {
        return this.chan5Raw;
    }

    /**
     * RC channel 6 value. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2,
            description = "RC channel 6 value."
    )
    public final int chan6Raw() {
        return this.chan6Raw;
    }

    /**
     * RC channel 7 value. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2,
            description = "RC channel 7 value."
    )
    public final int chan7Raw() {
        return this.chan7Raw;
    }

    /**
     * RC channel 8 value. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 2,
            description = "RC channel 8 value."
    )
    public final int chan8Raw() {
        return this.chan8Raw;
    }

    /**
     * Receive signal strength indicator. Values: [0-100], 255: invalid/unknown. 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 1,
            description = "Receive signal strength indicator. Values: [0-100], 255: invalid/unknown."
    )
    public final int rssi() {
        return this.rssi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        RcChannelsRaw other = (RcChannelsRaw)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(port, other.port)) return false;
        if (!Objects.deepEquals(chan1Raw, other.chan1Raw)) return false;
        if (!Objects.deepEquals(chan2Raw, other.chan2Raw)) return false;
        if (!Objects.deepEquals(chan3Raw, other.chan3Raw)) return false;
        if (!Objects.deepEquals(chan4Raw, other.chan4Raw)) return false;
        if (!Objects.deepEquals(chan5Raw, other.chan5Raw)) return false;
        if (!Objects.deepEquals(chan6Raw, other.chan6Raw)) return false;
        if (!Objects.deepEquals(chan7Raw, other.chan7Raw)) return false;
        if (!Objects.deepEquals(chan8Raw, other.chan8Raw)) return false;
        if (!Objects.deepEquals(rssi, other.rssi)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(port);
        result = 31 * result + Objects.hashCode(chan1Raw);
        result = 31 * result + Objects.hashCode(chan2Raw);
        result = 31 * result + Objects.hashCode(chan3Raw);
        result = 31 * result + Objects.hashCode(chan4Raw);
        result = 31 * result + Objects.hashCode(chan5Raw);
        result = 31 * result + Objects.hashCode(chan6Raw);
        result = 31 * result + Objects.hashCode(chan7Raw);
        result = 31 * result + Objects.hashCode(chan8Raw);
        result = 31 * result + Objects.hashCode(rssi);
        return result;
    }

    @Override
    public String toString() {
        return "RcChannelsRaw{timeBootMs=" + timeBootMs
                 + ", port=" + port
                 + ", chan1Raw=" + chan1Raw
                 + ", chan2Raw=" + chan2Raw
                 + ", chan3Raw=" + chan3Raw
                 + ", chan4Raw=" + chan4Raw
                 + ", chan5Raw=" + chan5Raw
                 + ", chan6Raw=" + chan6Raw
                 + ", chan7Raw=" + chan7Raw
                 + ", chan8Raw=" + chan8Raw
                 + ", rssi=" + rssi + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private int port;

        private int chan1Raw;

        private int chan2Raw;

        private int chan3Raw;

        private int chan4Raw;

        private int chan5Raw;

        private int chan6Raw;

        private int chan7Raw;

        private int chan8Raw;

        private int rssi;

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
         * Servo output port (set of 8 outputs = 1 port). Flight stacks running on Pixhawk should use: 0 = 
         * MAIN, 1 = AUX. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Servo output port (set of 8 outputs = 1 port). Flight stacks running on Pixhawk should use: 0 = MAIN, 1 = AUX."
        )
        public final Builder port(int port) {
            this.port = port;
            return this;
        }

        /**
         * RC channel 1 value. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                description = "RC channel 1 value."
        )
        public final Builder chan1Raw(int chan1Raw) {
            this.chan1Raw = chan1Raw;
            return this;
        }

        /**
         * RC channel 2 value. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                description = "RC channel 2 value."
        )
        public final Builder chan2Raw(int chan2Raw) {
            this.chan2Raw = chan2Raw;
            return this;
        }

        /**
         * RC channel 3 value. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                description = "RC channel 3 value."
        )
        public final Builder chan3Raw(int chan3Raw) {
            this.chan3Raw = chan3Raw;
            return this;
        }

        /**
         * RC channel 4 value. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                description = "RC channel 4 value."
        )
        public final Builder chan4Raw(int chan4Raw) {
            this.chan4Raw = chan4Raw;
            return this;
        }

        /**
         * RC channel 5 value. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                description = "RC channel 5 value."
        )
        public final Builder chan5Raw(int chan5Raw) {
            this.chan5Raw = chan5Raw;
            return this;
        }

        /**
         * RC channel 6 value. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2,
                description = "RC channel 6 value."
        )
        public final Builder chan6Raw(int chan6Raw) {
            this.chan6Raw = chan6Raw;
            return this;
        }

        /**
         * RC channel 7 value. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2,
                description = "RC channel 7 value."
        )
        public final Builder chan7Raw(int chan7Raw) {
            this.chan7Raw = chan7Raw;
            return this;
        }

        /**
         * RC channel 8 value. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 2,
                description = "RC channel 8 value."
        )
        public final Builder chan8Raw(int chan8Raw) {
            this.chan8Raw = chan8Raw;
            return this;
        }

        /**
         * Receive signal strength indicator. Values: [0-100], 255: invalid/unknown. 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 1,
                description = "Receive signal strength indicator. Values: [0-100], 255: invalid/unknown."
        )
        public final Builder rssi(int rssi) {
            this.rssi = rssi;
            return this;
        }

        public final RcChannelsRaw build() {
            return new RcChannelsRaw(timeBootMs, port, chan1Raw, chan2Raw, chan3Raw, chan4Raw, chan5Raw, chan6Raw, chan7Raw, chan8Raw, rssi);
        }
    }
}
