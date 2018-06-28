package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumFlagSet;
import java.math.BigInteger;

/**
 * Estimator status message including flags, innovation test ratios and estimated accuracies. 
 * The flags message is an integer bitmask containing information on which EKF outputs are valid. 
 * See the {@link io.dronefleet.mavlink.common.EstimatorStatusFlags ESTIMATOR_STATUS_FLAGS} enum definition for further information. The innovaton test 
 * ratios show the magnitude of the sensor innovation divided by the innovation check threshold. 
 * Under normal operation the innovaton test ratios should be below 0.5 with occasional values up 
 * to 1.0. Values greater than 1.0 should be rare under normal operation and indicate that a 
 * measurement has been rejected by the filter. The user should be notified if an innovation test 
 * ratio greater than 1.0 is recorded. Notifications for values in the range between 0.5 and 1.0 
 * should be optional and controllable by the user. 
 */
@MavlinkMessageInfo(
        id = 230,
        crc = 163
)
public final class EstimatorStatus {
    private final BigInteger timeUsec;

    private final EnumFlagSet<EstimatorStatusFlags> flags;

    private final float velRatio;

    private final float posHorizRatio;

    private final float posVertRatio;

    private final float magRatio;

    private final float haglRatio;

    private final float tasRatio;

    private final float posHorizAccuracy;

    private final float posVertAccuracy;

    private EstimatorStatus(BigInteger timeUsec, EnumFlagSet<EstimatorStatusFlags> flags,
            float velRatio, float posHorizRatio, float posVertRatio, float magRatio,
            float haglRatio, float tasRatio, float posHorizAccuracy, float posVertAccuracy) {
        this.timeUsec = timeUsec;
        this.flags = flags;
        this.velRatio = velRatio;
        this.posHorizRatio = posHorizRatio;
        this.posVertRatio = posVertRatio;
        this.magRatio = magRatio;
        this.haglRatio = haglRatio;
        this.tasRatio = tasRatio;
        this.posHorizAccuracy = posHorizAccuracy;
        this.posVertAccuracy = posVertAccuracy;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (micros since boot or Unix epoch) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * Integer bitmask indicating which EKF outputs are valid. See definition for 
     * {@link io.dronefleet.mavlink.common.EstimatorStatusFlags ESTIMATOR_STATUS_FLAGS}. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2
    )
    public final EnumFlagSet<EstimatorStatusFlags> flags() {
        return this.flags;
    }

    /**
     * Velocity innovation test ratio 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float velRatio() {
        return this.velRatio;
    }

    /**
     * Horizontal position innovation test ratio 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float posHorizRatio() {
        return this.posHorizRatio;
    }

    /**
     * Vertical position innovation test ratio 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float posVertRatio() {
        return this.posVertRatio;
    }

    /**
     * Magnetometer innovation test ratio 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float magRatio() {
        return this.magRatio;
    }

    /**
     * Height above terrain innovation test ratio 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float haglRatio() {
        return this.haglRatio;
    }

    /**
     * True airspeed innovation test ratio 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4
    )
    public final float tasRatio() {
        return this.tasRatio;
    }

    /**
     * Horizontal position 1-STD accuracy relative to the EKF local origin (m) 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4
    )
    public final float posHorizAccuracy() {
        return this.posHorizAccuracy;
    }

    /**
     * Vertical position 1-STD accuracy relative to the EKF local origin (m) 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4
    )
    public final float posVertAccuracy() {
        return this.posVertAccuracy;
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private EnumFlagSet<EstimatorStatusFlags> flags;

        private float velRatio;

        private float posHorizRatio;

        private float posVertRatio;

        private float magRatio;

        private float haglRatio;

        private float tasRatio;

        private float posHorizAccuracy;

        private float posVertAccuracy;

        /**
         * Timestamp (micros since boot or Unix epoch) 
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
         * Integer bitmask indicating which EKF outputs are valid. See definition for 
         * {@link io.dronefleet.mavlink.common.EstimatorStatusFlags ESTIMATOR_STATUS_FLAGS}. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2
        )
        public final Builder flags(EnumFlagSet<EstimatorStatusFlags> flags) {
            this.flags = flags;
            return this;
        }

        /**
         * Velocity innovation test ratio 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder velRatio(float velRatio) {
            this.velRatio = velRatio;
            return this;
        }

        /**
         * Horizontal position innovation test ratio 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder posHorizRatio(float posHorizRatio) {
            this.posHorizRatio = posHorizRatio;
            return this;
        }

        /**
         * Vertical position innovation test ratio 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder posVertRatio(float posVertRatio) {
            this.posVertRatio = posVertRatio;
            return this;
        }

        /**
         * Magnetometer innovation test ratio 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder magRatio(float magRatio) {
            this.magRatio = magRatio;
            return this;
        }

        /**
         * Height above terrain innovation test ratio 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4
        )
        public final Builder haglRatio(float haglRatio) {
            this.haglRatio = haglRatio;
            return this;
        }

        /**
         * True airspeed innovation test ratio 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4
        )
        public final Builder tasRatio(float tasRatio) {
            this.tasRatio = tasRatio;
            return this;
        }

        /**
         * Horizontal position 1-STD accuracy relative to the EKF local origin (m) 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4
        )
        public final Builder posHorizAccuracy(float posHorizAccuracy) {
            this.posHorizAccuracy = posHorizAccuracy;
            return this;
        }

        /**
         * Vertical position 1-STD accuracy relative to the EKF local origin (m) 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4
        )
        public final Builder posVertAccuracy(float posVertAccuracy) {
            this.posVertAccuracy = posVertAccuracy;
            return this;
        }

        public final EstimatorStatus build() {
            return new EstimatorStatus(timeUsec, flags, velRatio, posHorizRatio, posVertRatio, magRatio, haglRatio, tasRatio, posHorizAccuracy, posVertAccuracy);
        }
    }
}
