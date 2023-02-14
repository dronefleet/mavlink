package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Float;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

/**
 * Current motion information from a designated system 
 */
@MavlinkMessageInfo(
        id = 144,
        crc = 127,
        description = "Current motion information from a designated system"
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
     * Timestamp (time since system boot). 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            description = "Timestamp (time since system boot)."
    )
    public final BigInteger timestamp() {
        return this.timestamp;
    }

    /**
     * bit positions for tracker reporting capabilities (POS = 0, VEL = 1, ACCEL = 2, ATT + RATES = 3) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "bit positions for tracker reporting capabilities (POS = 0, VEL = 1, ACCEL = 2, ATT + RATES = 3)"
    )
    public final int estCapabilities() {
        return this.estCapabilities;
    }

    /**
     * Latitude (WGS84) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            signed = true,
            description = "Latitude (WGS84)"
    )
    public final int lat() {
        return this.lat;
    }

    /**
     * Longitude (WGS84) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            signed = true,
            description = "Longitude (WGS84)"
    )
    public final int lon() {
        return this.lon;
    }

    /**
     * Altitude (MSL) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Altitude (MSL)"
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
            arraySize = 3,
            description = "target velocity (0,0,0) for unknown"
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
            arraySize = 3,
            description = "linear target acceleration (0,0,0) for unknown"
    )
    public final List<Float> acc() {
        return this.acc;
    }

    /**
     * (0 0 0 0 for unknown) 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            arraySize = 4,
            description = "(0 0 0 0 for unknown)"
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
            arraySize = 3,
            description = "(0 0 0 for unknown)"
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
            arraySize = 3,
            description = "eph epv"
    )
    public final List<Float> positionCov() {
        return this.positionCov;
    }

    /**
     * button states or switches of a tracker device 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 8,
            description = "button states or switches of a tracker device"
    )
    public final BigInteger customState() {
        return this.customState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        FollowTarget other = (FollowTarget)o;
        if (!Objects.deepEquals(timestamp, other.timestamp)) return false;
        if (!Objects.deepEquals(estCapabilities, other.estCapabilities)) return false;
        if (!Objects.deepEquals(lat, other.lat)) return false;
        if (!Objects.deepEquals(lon, other.lon)) return false;
        if (!Objects.deepEquals(alt, other.alt)) return false;
        if (!Objects.deepEquals(vel, other.vel)) return false;
        if (!Objects.deepEquals(acc, other.acc)) return false;
        if (!Objects.deepEquals(attitudeQ, other.attitudeQ)) return false;
        if (!Objects.deepEquals(rates, other.rates)) return false;
        if (!Objects.deepEquals(positionCov, other.positionCov)) return false;
        if (!Objects.deepEquals(customState, other.customState)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timestamp);
        result = 31 * result + Objects.hashCode(estCapabilities);
        result = 31 * result + Objects.hashCode(lat);
        result = 31 * result + Objects.hashCode(lon);
        result = 31 * result + Objects.hashCode(alt);
        result = 31 * result + Objects.hashCode(vel);
        result = 31 * result + Objects.hashCode(acc);
        result = 31 * result + Objects.hashCode(attitudeQ);
        result = 31 * result + Objects.hashCode(rates);
        result = 31 * result + Objects.hashCode(positionCov);
        result = 31 * result + Objects.hashCode(customState);
        return result;
    }

    @Override
    public String toString() {
        return "FollowTarget{timestamp=" + timestamp
                 + ", estCapabilities=" + estCapabilities
                 + ", lat=" + lat
                 + ", lon=" + lon
                 + ", alt=" + alt
                 + ", vel=" + vel
                 + ", acc=" + acc
                 + ", attitudeQ=" + attitudeQ
                 + ", rates=" + rates
                 + ", positionCov=" + positionCov
                 + ", customState=" + customState + "}";
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
         * Timestamp (time since system boot). 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                description = "Timestamp (time since system boot)."
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
                unitSize = 1,
                description = "bit positions for tracker reporting capabilities (POS = 0, VEL = 1, ACCEL = 2, ATT + RATES = 3)"
        )
        public final Builder estCapabilities(int estCapabilities) {
            this.estCapabilities = estCapabilities;
            return this;
        }

        /**
         * Latitude (WGS84) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                signed = true,
                description = "Latitude (WGS84)"
        )
        public final Builder lat(int lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Longitude (WGS84) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                signed = true,
                description = "Longitude (WGS84)"
        )
        public final Builder lon(int lon) {
            this.lon = lon;
            return this;
        }

        /**
         * Altitude (MSL) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Altitude (MSL)"
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
                arraySize = 3,
                description = "target velocity (0,0,0) for unknown"
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
                arraySize = 3,
                description = "linear target acceleration (0,0,0) for unknown"
        )
        public final Builder acc(List<Float> acc) {
            this.acc = acc;
            return this;
        }

        /**
         * (0 0 0 0 for unknown) 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                arraySize = 4,
                description = "(0 0 0 0 for unknown)"
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
                arraySize = 3,
                description = "(0 0 0 for unknown)"
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
                arraySize = 3,
                description = "eph epv"
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
                unitSize = 8,
                description = "button states or switches of a tracker device"
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
