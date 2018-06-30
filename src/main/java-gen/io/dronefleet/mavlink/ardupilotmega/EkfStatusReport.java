package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.util.Objects;

/**
 * EKF Status message including flags and variances 
 */
@MavlinkMessageInfo(
        id = 193,
        crc = 88
)
public final class EkfStatusReport {
    private final EkfStatusFlags flags;

    private final float velocityVariance;

    private final float posHorizVariance;

    private final float posVertVariance;

    private final float compassVariance;

    private final float terrainAltVariance;

    private final float airspeedVariance;

    private EkfStatusReport(EkfStatusFlags flags, float velocityVariance, float posHorizVariance,
            float posVertVariance, float compassVariance, float terrainAltVariance,
            float airspeedVariance) {
        this.flags = flags;
        this.velocityVariance = velocityVariance;
        this.posHorizVariance = posHorizVariance;
        this.posVertVariance = posVertVariance;
        this.compassVariance = compassVariance;
        this.terrainAltVariance = terrainAltVariance;
        this.airspeedVariance = airspeedVariance;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Flags 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 2
    )
    public final EkfStatusFlags flags() {
        return this.flags;
    }

    /**
     * Velocity variance 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float velocityVariance() {
        return this.velocityVariance;
    }

    /**
     * Horizontal Position variance 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float posHorizVariance() {
        return this.posHorizVariance;
    }

    /**
     * Vertical Position variance 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float posVertVariance() {
        return this.posVertVariance;
    }

    /**
     * Compass variance 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float compassVariance() {
        return this.compassVariance;
    }

    /**
     * Terrain Altitude variance 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float terrainAltVariance() {
        return this.terrainAltVariance;
    }

    /**
     * Airspeed variance 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            extension = true
    )
    public final float airspeedVariance() {
        return this.airspeedVariance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        EkfStatusReport other = (EkfStatusReport)o;
        if (!Objects.deepEquals(flags, other.flags)) return false;
        if (!Objects.deepEquals(velocityVariance, other.velocityVariance)) return false;
        if (!Objects.deepEquals(posHorizVariance, other.posHorizVariance)) return false;
        if (!Objects.deepEquals(posVertVariance, other.posVertVariance)) return false;
        if (!Objects.deepEquals(compassVariance, other.compassVariance)) return false;
        if (!Objects.deepEquals(terrainAltVariance, other.terrainAltVariance)) return false;
        if (!Objects.deepEquals(airspeedVariance, other.airspeedVariance)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(flags);
        result = 31 * result + Objects.hashCode(velocityVariance);
        result = 31 * result + Objects.hashCode(posHorizVariance);
        result = 31 * result + Objects.hashCode(posVertVariance);
        result = 31 * result + Objects.hashCode(compassVariance);
        result = 31 * result + Objects.hashCode(terrainAltVariance);
        result = 31 * result + Objects.hashCode(airspeedVariance);
        return result;
    }

    public static final class Builder {
        private EkfStatusFlags flags;

        private float velocityVariance;

        private float posHorizVariance;

        private float posVertVariance;

        private float compassVariance;

        private float terrainAltVariance;

        private float airspeedVariance;

        /**
         * Flags 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 2
        )
        public final Builder flags(EkfStatusFlags flags) {
            this.flags = flags;
            return this;
        }

        /**
         * Velocity variance 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder velocityVariance(float velocityVariance) {
            this.velocityVariance = velocityVariance;
            return this;
        }

        /**
         * Horizontal Position variance 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder posHorizVariance(float posHorizVariance) {
            this.posHorizVariance = posHorizVariance;
            return this;
        }

        /**
         * Vertical Position variance 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder posVertVariance(float posVertVariance) {
            this.posVertVariance = posVertVariance;
            return this;
        }

        /**
         * Compass variance 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder compassVariance(float compassVariance) {
            this.compassVariance = compassVariance;
            return this;
        }

        /**
         * Terrain Altitude variance 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder terrainAltVariance(float terrainAltVariance) {
            this.terrainAltVariance = terrainAltVariance;
            return this;
        }

        /**
         * Airspeed variance 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                extension = true
        )
        public final Builder airspeedVariance(float airspeedVariance) {
            this.airspeedVariance = airspeedVariance;
            return this;
        }

        public final EkfStatusReport build() {
            return new EkfStatusReport(flags, velocityVariance, posHorizVariance, posVertVariance, compassVariance, terrainAltVariance, airspeedVariance);
        }
    }
}
