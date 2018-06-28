package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Float;
import java.math.BigInteger;
import java.util.List;

/**
 * current motion information from a designated system 
 */
@MavlinkMessageInfo(
        id = 144,
        crc = 127
)
public final class FollowTarget {
    private final BigInteger timestamp;

    private final int estCapabilities;

    private final int lat;

    private final int lon;

    private final float alt;

    private final List<Float> vel;

    private final List<Float> acc;

    private final List<Float> attitudeQ;

    private final List<Float> rates;

    private final List<Float> positionCov;

    private final BigInteger customState;

    private FollowTarget(BigInteger timestamp, int estCapabilities, int lat, int lon, float alt,
            List<Float> vel, List<Float> acc, List<Float> attitudeQ, List<Float> rates,
            List<Float> positionCov, BigInteger customState) {
        this.timestamp = timestamp;
        this.estCapabilities = estCapabilities;
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
        this.vel = vel;
        this.acc = acc;
        this.attitudeQ = attitudeQ;
        this.rates = rates;
        this.positionCov = positionCov;
        this.customState = customState;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp in milliseconds since system boot 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
    )
    public final BigInteger timestamp() {
        return this.timestamp;
    }

    /**
     * bit positions for tracker reporting capabilities (POS = 0, VEL = 1, ACCEL = 2, ATT + RATES = 3) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int estCapabilities() {
        return this.estCapabilities;
    }

    /**
     * Latitude (WGS84), in degrees * 1E7 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            signed = true
    )
    public final int lat() {
        return this.lat;
    }

    /**
     * Longitude (WGS84), in degrees * 1E7 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            signed = true
    )
    public final int lon() {
        return this.lon;
    }

    /**
     * AMSL, in meters 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float alt() {
        return this.alt;
    }

    /**
     * target velocity (0,0,0) for unknown 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            arraySize = 3
    )
    public final List<Float> vel() {
        return this.vel;
    }

    /**
     * linear target acceleration (0,0,0) for unknown 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            arraySize = 3
    )
    public final List<Float> acc() {
        return this.acc;
    }

    /**
     * (1 0 0 0 for unknown) 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            arraySize = 4
    )
    public final List<Float> attitudeQ() {
        return this.attitudeQ;
    }

    /**
     * (0 0 0 for unknown) 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            arraySize = 3
    )
    public final List<Float> rates() {
        return this.rates;
    }

    /**
     * eph epv 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            arraySize = 3
    )
    public final List<Float> positionCov() {
        return this.positionCov;
    }

    /**
     * button states or switches of a tracker device 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 8
    )
    public final BigInteger customState() {
        return this.customState;
    }

    public static final class Builder {
        private BigInteger timestamp;

        private int estCapabilities;

        private int lat;

        private int lon;

        private float alt;

        private List<Float> vel;

        private List<Float> acc;

        private List<Float> attitudeQ;

        private List<Float> rates;

        private List<Float> positionCov;

        private BigInteger customState;

        /**
         * Timestamp in milliseconds since system boot 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8
        )
        public final Builder timestamp(BigInteger timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        /**
         * bit positions for tracker reporting capabilities (POS = 0, VEL = 1, ACCEL = 2, ATT + RATES = 3) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder estCapabilities(int estCapabilities) {
            this.estCapabilities = estCapabilities;
            return this;
        }

        /**
         * Latitude (WGS84), in degrees * 1E7 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                signed = true
        )
        public final Builder lat(int lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Longitude (WGS84), in degrees * 1E7 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                signed = true
        )
        public final Builder lon(int lon) {
            this.lon = lon;
            return this;
        }

        /**
         * AMSL, in meters 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder alt(float alt) {
            this.alt = alt;
            return this;
        }

        /**
         * target velocity (0,0,0) for unknown 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                arraySize = 3
        )
        public final Builder vel(List<Float> vel) {
            this.vel = vel;
            return this;
        }

        /**
         * linear target acceleration (0,0,0) for unknown 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                arraySize = 3
        )
        public final Builder acc(List<Float> acc) {
            this.acc = acc;
            return this;
        }

        /**
         * (1 0 0 0 for unknown) 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                arraySize = 4
        )
        public final Builder attitudeQ(List<Float> attitudeQ) {
            this.attitudeQ = attitudeQ;
            return this;
        }

        /**
         * (0 0 0 for unknown) 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                arraySize = 3
        )
        public final Builder rates(List<Float> rates) {
            this.rates = rates;
            return this;
        }

        /**
         * eph epv 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                arraySize = 3
        )
        public final Builder positionCov(List<Float> positionCov) {
            this.positionCov = positionCov;
            return this;
        }

        /**
         * button states or switches of a tracker device 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 8
        )
        public final Builder customState(BigInteger customState) {
            this.customState = customState;
            return this;
        }

        public final FollowTarget build() {
            return new FollowTarget(timestamp, estCapabilities, lat, lon, alt, vel, acc, attitudeQ, rates, positionCov, customState);
        }
    }
}
