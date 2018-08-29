package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * EKF Status message including flags and variances 
 */
@MavlinkMessageInfo(
        id = 193,
        crc = 71
)
public final class EkfStatusReport {
    private final EnumValue<EkfStatusFlags> flags;

    private final float velocityVariance;

    private final float posHorizVariance;

    private final float posVertVariance;

    private final float compassVariance;

    private final float terrainAltVariance;

    private final float airspeedVariance;

    private EkfStatusReport(EnumValue<EkfStatusFlags> flags, float velocityVariance,
            float posHorizVariance, float posVertVariance, float compassVariance,
            float terrainAltVariance, float airspeedVariance) {
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
            unitSize = 2,
            enumType = EkfStatusFlags.class
    )
    public final EnumValue<EkfStatusFlags> flags() {
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

    @Override
    public String toString() {
        return "EkfStatusReport{flags=" + flags
                 + ", velocityVariance=" + velocityVariance
                 + ", posHorizVariance=" + posHorizVariance
                 + ", posVertVariance=" + posVertVariance
                 + ", compassVariance=" + compassVariance
                 + ", terrainAltVariance=" + terrainAltVariance
                 + ", airspeedVariance=" + airspeedVariance + "}";
    }

    public static final class Builder {
        private EnumValue<EkfStatusFlags> flags;

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
                unitSize = 2,
                enumType = EkfStatusFlags.class
        )
        public final Builder flags(EnumValue<EkfStatusFlags> flags) {
            this.flags = flags;
            return this;
        }

        /**
         * Flags 
         */
        public final Builder flags(EkfStatusFlags entry) {
            return flags(EnumValue.of(entry));
        }

        /**
         * Flags 
         */
        public final Builder flags(Enum... flags) {
            return flags(EnumValue.create(flags));
        }

        /**
         * Flags 
         */
        public final Builder flags(Collection<Enum> flags) {
            return flags(EnumValue.create(flags));
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
