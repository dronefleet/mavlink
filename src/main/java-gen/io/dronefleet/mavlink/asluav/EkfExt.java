package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.math.BigInteger;

/**
 * Extended EKF state estimates for ASLUAVs 
 */
@MavlinkMessageInfo(
        id = 206,
        crc = 64
)
public final class EkfExt {
    private final BigInteger timestamp;

    private final float windspeed;

    private final float winddir;

    private final float windz;

    private final float airspeed;

    private final float beta;

    private final float alpha;

    private EkfExt(BigInteger timestamp, float windspeed, float winddir, float windz,
            float airspeed, float beta, float alpha) {
        this.timestamp = timestamp;
        this.windspeed = windspeed;
        this.winddir = winddir;
        this.windz = windz;
        this.airspeed = airspeed;
        this.beta = beta;
        this.alpha = alpha;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Time since system start 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
    )
    public final BigInteger timestamp() {
        return this.timestamp;
    }

    /**
     * Magnitude of wind velocity (in lateral inertial plane) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float windspeed() {
        return this.windspeed;
    }

    /**
     * Wind heading angle from North 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float winddir() {
        return this.winddir;
    }

    /**
     * Z (Down) component of inertial wind velocity 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float windz() {
        return this.windz;
    }

    /**
     * Magnitude of air velocity 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float airspeed() {
        return this.airspeed;
    }

    /**
     * Sideslip angle 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float beta() {
        return this.beta;
    }

    /**
     * Angle of attack 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float alpha() {
        return this.alpha;
    }

    public static final class Builder {
        private BigInteger timestamp;

        private float windspeed;

        private float winddir;

        private float windz;

        private float airspeed;

        private float beta;

        private float alpha;

        /**
         * Time since system start 
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
         * Magnitude of wind velocity (in lateral inertial plane) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder windspeed(float windspeed) {
            this.windspeed = windspeed;
            return this;
        }

        /**
         * Wind heading angle from North 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder winddir(float winddir) {
            this.winddir = winddir;
            return this;
        }

        /**
         * Z (Down) component of inertial wind velocity 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder windz(float windz) {
            this.windz = windz;
            return this;
        }

        /**
         * Magnitude of air velocity 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder airspeed(float airspeed) {
            this.airspeed = airspeed;
            return this;
        }

        /**
         * Sideslip angle 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder beta(float beta) {
            this.beta = beta;
            return this;
        }

        /**
         * Angle of attack 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4
        )
        public final Builder alpha(float alpha) {
            this.alpha = alpha;
            return this;
        }

        public final EkfExt build() {
            return new EkfExt(timestamp, windspeed, winddir, windz, airspeed, beta, alpha);
        }
    }
}
