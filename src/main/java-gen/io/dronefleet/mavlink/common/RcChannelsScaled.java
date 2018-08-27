package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * The scaled values of the RC channels received. (-100%) -10000, (0%) 0, (100%) 10000. Channels 
 * that are inactive should be set to UINT16_MAX. 
 */
@MavlinkMessageInfo(
        id = 34,
        crc = 237
)
public final class RcChannelsScaled {
    private final long timeBootMs;

    private final int port;

    private final int chan1Scaled;

    private final int chan2Scaled;

    private final int chan3Scaled;

    private final int chan4Scaled;

    private final int chan5Scaled;

    private final int chan6Scaled;

    private final int chan7Scaled;

    private final int chan8Scaled;

    private final int rssi;

    private RcChannelsScaled(long timeBootMs, int port, int chan1Scaled, int chan2Scaled,
            int chan3Scaled, int chan4Scaled, int chan5Scaled, int chan6Scaled, int chan7Scaled,
            int chan8Scaled, int rssi) {
        this.timeBootMs = timeBootMs;
        this.port = port;
        this.chan1Scaled = chan1Scaled;
        this.chan2Scaled = chan2Scaled;
        this.chan3Scaled = chan3Scaled;
        this.chan4Scaled = chan4Scaled;
        this.chan5Scaled = chan5Scaled;
        this.chan6Scaled = chan6Scaled;
        this.chan7Scaled = chan7Scaled;
        this.chan8Scaled = chan8Scaled;
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
     * Timestamp (milliseconds since system boot) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * Servo output port (set of 8 outputs = 1 port). Most MAVs will just use one, but this allows for more 
     * than 8 servos. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int port() {
        return this.port;
    }

    /**
     * RC channel 1 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            signed = true
    )
    public final int chan1Scaled() {
        return this.chan1Scaled;
    }

    /**
     * RC channel 2 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            signed = true
    )
    public final int chan2Scaled() {
        return this.chan2Scaled;
    }

    /**
     * RC channel 3 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            signed = true
    )
    public final int chan3Scaled() {
        return this.chan3Scaled;
    }

    /**
     * RC channel 4 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            signed = true
    )
    public final int chan4Scaled() {
        return this.chan4Scaled;
    }

    /**
     * RC channel 5 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            signed = true
    )
    public final int chan5Scaled() {
        return this.chan5Scaled;
    }

    /**
     * RC channel 6 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2,
            signed = true
    )
    public final int chan6Scaled() {
        return this.chan6Scaled;
    }

    /**
     * RC channel 7 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2,
            signed = true
    )
    public final int chan7Scaled() {
        return this.chan7Scaled;
    }

    /**
     * RC channel 8 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 2,
            signed = true
    )
    public final int chan8Scaled() {
        return this.chan8Scaled;
    }

    /**
     * Receive signal strength indicator, 0: 0%, 100: 100%, 255: invalid/unknown. 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 1
    )
    public final int rssi() {
        return this.rssi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        RcChannelsScaled other = (RcChannelsScaled)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(port, other.port)) return false;
        if (!Objects.deepEquals(chan1Scaled, other.chan1Scaled)) return false;
        if (!Objects.deepEquals(chan2Scaled, other.chan2Scaled)) return false;
        if (!Objects.deepEquals(chan3Scaled, other.chan3Scaled)) return false;
        if (!Objects.deepEquals(chan4Scaled, other.chan4Scaled)) return false;
        if (!Objects.deepEquals(chan5Scaled, other.chan5Scaled)) return false;
        if (!Objects.deepEquals(chan6Scaled, other.chan6Scaled)) return false;
        if (!Objects.deepEquals(chan7Scaled, other.chan7Scaled)) return false;
        if (!Objects.deepEquals(chan8Scaled, other.chan8Scaled)) return false;
        if (!Objects.deepEquals(rssi, other.rssi)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(port);
        result = 31 * result + Objects.hashCode(chan1Scaled);
        result = 31 * result + Objects.hashCode(chan2Scaled);
        result = 31 * result + Objects.hashCode(chan3Scaled);
        result = 31 * result + Objects.hashCode(chan4Scaled);
        result = 31 * result + Objects.hashCode(chan5Scaled);
        result = 31 * result + Objects.hashCode(chan6Scaled);
        result = 31 * result + Objects.hashCode(chan7Scaled);
        result = 31 * result + Objects.hashCode(chan8Scaled);
        result = 31 * result + Objects.hashCode(rssi);
        return result;
    }

    @Override
    public String toString() {
        return "RcChannelsScaled{timeBootMs=" + timeBootMs
                 + ", port=" + port
                 + ", chan1Scaled=" + chan1Scaled
                 + ", chan2Scaled=" + chan2Scaled
                 + ", chan3Scaled=" + chan3Scaled
                 + ", chan4Scaled=" + chan4Scaled
                 + ", chan5Scaled=" + chan5Scaled
                 + ", chan6Scaled=" + chan6Scaled
                 + ", chan7Scaled=" + chan7Scaled
                 + ", chan8Scaled=" + chan8Scaled
                 + ", rssi=" + rssi + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private int port;

        private int chan1Scaled;

        private int chan2Scaled;

        private int chan3Scaled;

        private int chan4Scaled;

        private int chan5Scaled;

        private int chan6Scaled;

        private int chan7Scaled;

        private int chan8Scaled;

        private int rssi;

        /**
         * Timestamp (milliseconds since system boot) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * Servo output port (set of 8 outputs = 1 port). Most MAVs will just use one, but this allows for more 
         * than 8 servos. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder port(int port) {
            this.port = port;
            return this;
        }

        /**
         * RC channel 1 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                signed = true
        )
        public final Builder chan1Scaled(int chan1Scaled) {
            this.chan1Scaled = chan1Scaled;
            return this;
        }

        /**
         * RC channel 2 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                signed = true
        )
        public final Builder chan2Scaled(int chan2Scaled) {
            this.chan2Scaled = chan2Scaled;
            return this;
        }

        /**
         * RC channel 3 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                signed = true
        )
        public final Builder chan3Scaled(int chan3Scaled) {
            this.chan3Scaled = chan3Scaled;
            return this;
        }

        /**
         * RC channel 4 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                signed = true
        )
        public final Builder chan4Scaled(int chan4Scaled) {
            this.chan4Scaled = chan4Scaled;
            return this;
        }

        /**
         * RC channel 5 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                signed = true
        )
        public final Builder chan5Scaled(int chan5Scaled) {
            this.chan5Scaled = chan5Scaled;
            return this;
        }

        /**
         * RC channel 6 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2,
                signed = true
        )
        public final Builder chan6Scaled(int chan6Scaled) {
            this.chan6Scaled = chan6Scaled;
            return this;
        }

        /**
         * RC channel 7 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2,
                signed = true
        )
        public final Builder chan7Scaled(int chan7Scaled) {
            this.chan7Scaled = chan7Scaled;
            return this;
        }

        /**
         * RC channel 8 value scaled, (-100%) -10000, (0%) 0, (100%) 10000, (invalid) INT16_MAX. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 2,
                signed = true
        )
        public final Builder chan8Scaled(int chan8Scaled) {
            this.chan8Scaled = chan8Scaled;
            return this;
        }

        /**
         * Receive signal strength indicator, 0: 0%, 100: 100%, 255: invalid/unknown. 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 1
        )
        public final Builder rssi(int rssi) {
            this.rssi = rssi;
            return this;
        }

        public final RcChannelsScaled build() {
            return new RcChannelsScaled(timeBootMs, port, chan1Scaled, chan2Scaled, chan3Scaled, chan4Scaled, chan5Scaled, chan6Scaled, chan7Scaled, chan8Scaled, rssi);
        }
    }
}
