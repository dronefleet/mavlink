package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;

/**
 * Estimator status message including flags, innovation test ratios and estimated accuracies. 
 * The flags message is an integer bitmask containing information on which EKF outputs are valid. 
 * See the {@link io.dronefleet.mavlink.common.EstimatorStatusFlags ESTIMATOR_STATUS_FLAGS} enum definition for further information. The innovation 
 * test ratios show the magnitude of the sensor innovation divided by the innovation check 
 * threshold. Under normal operation the innovation test ratios should be below 0.5 with 
 * occasional values up to 1.0. Values greater than 1.0 should be rare under normal operation and 
 * indicate that a measurement has been rejected by the filter. The user should be notified if an 
 * innovation test ratio greater than 1.0 is recorded. Notifications for values in the range 
 * between 0.5 and 1.0 should be optional and controllable by the user. 
 */
@MavlinkMessageInfo(
        id = 230,
        crc = 163,
        description = "Estimator status message including flags, innovation test ratios and estimated accuracies. The flags message is an integer bitmask containing information on which EKF outputs are valid. See the ESTIMATOR_STATUS_FLAGS enum definition for further information. The innovation test ratios show the magnitude of the sensor innovation divided by the innovation check threshold. Under normal operation the innovation test ratios should be below 0.5 with occasional values up to 1.0. Values greater than 1.0 should be rare under normal operation and indicate that a measurement has been rejected by the filter. The user should be notified if an innovation test ratio greater than 1.0 is recorded. Notifications for values in the range between 0.5 and 1.0 should be optional and controllable by the user."
)
public final class EstimatorStatus {
    private final BigInteger timeUsec;

    private final EnumValue<EstimatorStatusFlags> flags;

    private final float velRatio;

    private final float posHorizRatio;

    private final float posVertRatio;

    private final float magRatio;

    private final float haglRatio;

    private final float tasRatio;

    private final float posHorizAccuracy;

    private final float posVertAccuracy;

    private EstimatorStatus(BigInteger timeUsec, EnumValue<EstimatorStatusFlags> flags,
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
     * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
     * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * Bitmap indicating which EKF outputs are valid. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            enumType = EstimatorStatusFlags.class,
            description = "Bitmap indicating which EKF outputs are valid."
    )
    public final EnumValue<EstimatorStatusFlags> flags() {
        return this.flags;
    }

    /**
     * Velocity innovation test ratio 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Velocity innovation test ratio"
    )
    public final float velRatio() {
        return this.velRatio;
    }

    /**
     * Horizontal position innovation test ratio 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Horizontal position innovation test ratio"
    )
    public final float posHorizRatio() {
        return this.posHorizRatio;
    }

    /**
     * Vertical position innovation test ratio 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Vertical position innovation test ratio"
    )
    public final float posVertRatio() {
        return this.posVertRatio;
    }

    /**
     * Magnetometer innovation test ratio 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Magnetometer innovation test ratio"
    )
    public final float magRatio() {
        return this.magRatio;
    }

    /**
     * Height above terrain innovation test ratio 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Height above terrain innovation test ratio"
    )
    public final float haglRatio() {
        return this.haglRatio;
    }

    /**
     * True airspeed innovation test ratio 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "True airspeed innovation test ratio"
    )
    public final float tasRatio() {
        return this.tasRatio;
    }

    /**
     * Horizontal position 1-STD accuracy relative to the EKF local origin 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Horizontal position 1-STD accuracy relative to the EKF local origin"
    )
    public final float posHorizAccuracy() {
        return this.posHorizAccuracy;
    }

    /**
     * Vertical position 1-STD accuracy relative to the EKF local origin 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "Vertical position 1-STD accuracy relative to the EKF local origin"
    )
    public final float posVertAccuracy() {
        return this.posVertAccuracy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        EstimatorStatus other = (EstimatorStatus)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(flags, other.flags)) return false;
        if (!Objects.deepEquals(velRatio, other.velRatio)) return false;
        if (!Objects.deepEquals(posHorizRatio, other.posHorizRatio)) return false;
        if (!Objects.deepEquals(posVertRatio, other.posVertRatio)) return false;
        if (!Objects.deepEquals(magRatio, other.magRatio)) return false;
        if (!Objects.deepEquals(haglRatio, other.haglRatio)) return false;
        if (!Objects.deepEquals(tasRatio, other.tasRatio)) return false;
        if (!Objects.deepEquals(posHorizAccuracy, other.posHorizAccuracy)) return false;
        if (!Objects.deepEquals(posVertAccuracy, other.posVertAccuracy)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(flags);
        result = 31 * result + Objects.hashCode(velRatio);
        result = 31 * result + Objects.hashCode(posHorizRatio);
        result = 31 * result + Objects.hashCode(posVertRatio);
        result = 31 * result + Objects.hashCode(magRatio);
        result = 31 * result + Objects.hashCode(haglRatio);
        result = 31 * result + Objects.hashCode(tasRatio);
        result = 31 * result + Objects.hashCode(posHorizAccuracy);
        result = 31 * result + Objects.hashCode(posVertAccuracy);
        return result;
    }

    @Override
    public String toString() {
        return "EstimatorStatus{timeUsec=" + timeUsec
                 + ", flags=" + flags
                 + ", velRatio=" + velRatio
                 + ", posHorizRatio=" + posHorizRatio
                 + ", posVertRatio=" + posVertRatio
                 + ", magRatio=" + magRatio
                 + ", haglRatio=" + haglRatio
                 + ", tasRatio=" + tasRatio
                 + ", posHorizAccuracy=" + posHorizAccuracy
                 + ", posVertAccuracy=" + posVertAccuracy + "}";
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private EnumValue<EstimatorStatusFlags> flags;

        private float velRatio;

        private float posHorizRatio;

        private float posVertRatio;

        private float magRatio;

        private float haglRatio;

        private float tasRatio;

        private float posHorizAccuracy;

        private float posVertAccuracy;

        /**
         * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
         * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * Bitmap indicating which EKF outputs are valid. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                enumType = EstimatorStatusFlags.class,
                description = "Bitmap indicating which EKF outputs are valid."
        )
        public final Builder flags(EnumValue<EstimatorStatusFlags> flags) {
            this.flags = flags;
            return this;
        }

        /**
         * Bitmap indicating which EKF outputs are valid. 
         */
        public final Builder flags(EstimatorStatusFlags entry) {
            return flags(EnumValue.of(entry));
        }

        /**
         * Bitmap indicating which EKF outputs are valid. 
         */
        public final Builder flags(Enum... flags) {
            return flags(EnumValue.create(flags));
        }

        /**
         * Bitmap indicating which EKF outputs are valid. 
         */
        public final Builder flags(Collection<Enum> flags) {
            return flags(EnumValue.create(flags));
        }

        /**
         * Velocity innovation test ratio 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Velocity innovation test ratio"
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
                unitSize = 4,
                description = "Horizontal position innovation test ratio"
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
                unitSize = 4,
                description = "Vertical position innovation test ratio"
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
                unitSize = 4,
                description = "Magnetometer innovation test ratio"
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
                unitSize = 4,
                description = "Height above terrain innovation test ratio"
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
                unitSize = 4,
                description = "True airspeed innovation test ratio"
        )
        public final Builder tasRatio(float tasRatio) {
            this.tasRatio = tasRatio;
            return this;
        }

        /**
         * Horizontal position 1-STD accuracy relative to the EKF local origin 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Horizontal position 1-STD accuracy relative to the EKF local origin"
        )
        public final Builder posHorizAccuracy(float posHorizAccuracy) {
            this.posHorizAccuracy = posHorizAccuracy;
            return this;
        }

        /**
         * Vertical position 1-STD accuracy relative to the EKF local origin 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "Vertical position 1-STD accuracy relative to the EKF local origin"
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
