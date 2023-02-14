package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Calibrated airflow angle measurements 
 */
@MavlinkMessageInfo(
        id = 8016,
        crc = 149,
        description = "Calibrated airflow angle measurements"
)
public final class SensorAirflowAngles {
    private final BigInteger timestamp;

    private final float angleofattack;

    private final int angleofattackValid;

    private final float sideslip;

    private final int sideslipValid;

    private SensorAirflowAngles(BigInteger timestamp, float angleofattack, int angleofattackValid,
            float sideslip, int sideslipValid) {
        this.timestamp = timestamp;
        this.angleofattack = angleofattack;
        this.angleofattackValid = angleofattackValid;
        this.sideslip = sideslip;
        this.sideslipValid = sideslipValid;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            description = "Timestamp"
    )
    public final BigInteger timestamp() {
        return this.timestamp;
    }

    /**
     * Angle of attack 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Angle of attack"
    )
    public final float angleofattack() {
        return this.angleofattack;
    }

    /**
     * Angle of attack measurement valid 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "Angle of attack measurement valid"
    )
    public final int angleofattackValid() {
        return this.angleofattackValid;
    }

    /**
     * Sideslip angle 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Sideslip angle"
    )
    public final float sideslip() {
        return this.sideslip;
    }

    /**
     * Sideslip angle measurement valid 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            description = "Sideslip angle measurement valid"
    )
    public final int sideslipValid() {
        return this.sideslipValid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SensorAirflowAngles other = (SensorAirflowAngles)o;
        if (!Objects.deepEquals(timestamp, other.timestamp)) return false;
        if (!Objects.deepEquals(angleofattack, other.angleofattack)) return false;
        if (!Objects.deepEquals(angleofattackValid, other.angleofattackValid)) return false;
        if (!Objects.deepEquals(sideslip, other.sideslip)) return false;
        if (!Objects.deepEquals(sideslipValid, other.sideslipValid)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timestamp);
        result = 31 * result + Objects.hashCode(angleofattack);
        result = 31 * result + Objects.hashCode(angleofattackValid);
        result = 31 * result + Objects.hashCode(sideslip);
        result = 31 * result + Objects.hashCode(sideslipValid);
        return result;
    }

    @Override
    public String toString() {
        return "SensorAirflowAngles{timestamp=" + timestamp
                 + ", angleofattack=" + angleofattack
                 + ", angleofattackValid=" + angleofattackValid
                 + ", sideslip=" + sideslip
                 + ", sideslipValid=" + sideslipValid + "}";
    }

    public static final class Builder {
        private BigInteger timestamp;

        private float angleofattack;

        private int angleofattackValid;

        private float sideslip;

        private int sideslipValid;

        /**
         * Timestamp 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                description = "Timestamp"
        )
        public final Builder timestamp(BigInteger timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        /**
         * Angle of attack 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Angle of attack"
        )
        public final Builder angleofattack(float angleofattack) {
            this.angleofattack = angleofattack;
            return this;
        }

        /**
         * Angle of attack measurement valid 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "Angle of attack measurement valid"
        )
        public final Builder angleofattackValid(int angleofattackValid) {
            this.angleofattackValid = angleofattackValid;
            return this;
        }

        /**
         * Sideslip angle 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Sideslip angle"
        )
        public final Builder sideslip(float sideslip) {
            this.sideslip = sideslip;
            return this;
        }

        /**
         * Sideslip angle measurement valid 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                description = "Sideslip angle measurement valid"
        )
        public final Builder sideslipValid(int sideslipValid) {
            this.sideslipValid = sideslipValid;
            return this;
        }

        public final SensorAirflowAngles build() {
            return new SensorAirflowAngles(timestamp, angleofattack, angleofattackValid, sideslip, sideslipValid);
        }
    }
}
