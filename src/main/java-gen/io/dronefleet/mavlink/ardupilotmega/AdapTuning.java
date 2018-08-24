package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.util.Objects;

/**
 * Adaptive Controller tuning information 
 */
@MavlinkMessageInfo(
        id = 11010,
        crc = 46
)
public final class AdapTuning {
    private final EnumValue<PidTuningAxis> axis;

    private final float desired;

    private final float achieved;

    private final float error;

    private final float theta;

    private final float omega;

    private final float sigma;

    private final float thetaDot;

    private final float omegaDot;

    private final float sigmaDot;

    private final float f;

    private final float fDot;

    private final float u;

    private AdapTuning(EnumValue<PidTuningAxis> axis, float desired, float achieved, float error,
            float theta, float omega, float sigma, float thetaDot, float omegaDot, float sigmaDot,
            float f, float fDot, float u) {
        this.axis = axis;
        this.desired = desired;
        this.achieved = achieved;
        this.error = error;
        this.theta = theta;
        this.omega = omega;
        this.sigma = sigma;
        this.thetaDot = thetaDot;
        this.omegaDot = omegaDot;
        this.sigmaDot = sigmaDot;
        this.f = f;
        this.fDot = fDot;
        this.u = u;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * axis 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            enumType = PidTuningAxis.class
    )
    public final EnumValue<PidTuningAxis> axis() {
        return this.axis;
    }

    /**
     * desired rate (degrees/s) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float desired() {
        return this.desired;
    }

    /**
     * achieved rate (degrees/s) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float achieved() {
        return this.achieved;
    }

    /**
     * error between model and vehicle 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float error() {
        return this.error;
    }

    /**
     * theta estimated state predictor 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float theta() {
        return this.theta;
    }

    /**
     * omega estimated state predictor 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float omega() {
        return this.omega;
    }

    /**
     * sigma estimated state predictor 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float sigma() {
        return this.sigma;
    }

    /**
     * theta derivative 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4
    )
    public final float thetaDot() {
        return this.thetaDot;
    }

    /**
     * omega derivative 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4
    )
    public final float omegaDot() {
        return this.omegaDot;
    }

    /**
     * sigma derivative 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4
    )
    public final float sigmaDot() {
        return this.sigmaDot;
    }

    /**
     * projection operator value 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4
    )
    public final float f() {
        return this.f;
    }

    /**
     * projection operator derivative 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4
    )
    public final float fDot() {
        return this.fDot;
    }

    /**
     * u adaptive controlled output command 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 4
    )
    public final float u() {
        return this.u;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        AdapTuning other = (AdapTuning)o;
        if (!Objects.deepEquals(axis, other.axis)) return false;
        if (!Objects.deepEquals(desired, other.desired)) return false;
        if (!Objects.deepEquals(achieved, other.achieved)) return false;
        if (!Objects.deepEquals(error, other.error)) return false;
        if (!Objects.deepEquals(theta, other.theta)) return false;
        if (!Objects.deepEquals(omega, other.omega)) return false;
        if (!Objects.deepEquals(sigma, other.sigma)) return false;
        if (!Objects.deepEquals(thetaDot, other.thetaDot)) return false;
        if (!Objects.deepEquals(omegaDot, other.omegaDot)) return false;
        if (!Objects.deepEquals(sigmaDot, other.sigmaDot)) return false;
        if (!Objects.deepEquals(f, other.f)) return false;
        if (!Objects.deepEquals(fDot, other.fDot)) return false;
        if (!Objects.deepEquals(u, other.u)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(axis);
        result = 31 * result + Objects.hashCode(desired);
        result = 31 * result + Objects.hashCode(achieved);
        result = 31 * result + Objects.hashCode(error);
        result = 31 * result + Objects.hashCode(theta);
        result = 31 * result + Objects.hashCode(omega);
        result = 31 * result + Objects.hashCode(sigma);
        result = 31 * result + Objects.hashCode(thetaDot);
        result = 31 * result + Objects.hashCode(omegaDot);
        result = 31 * result + Objects.hashCode(sigmaDot);
        result = 31 * result + Objects.hashCode(f);
        result = 31 * result + Objects.hashCode(fDot);
        result = 31 * result + Objects.hashCode(u);
        return result;
    }

    public static final class Builder {
        private EnumValue<PidTuningAxis> axis;

        private float desired;

        private float achieved;

        private float error;

        private float theta;

        private float omega;

        private float sigma;

        private float thetaDot;

        private float omegaDot;

        private float sigmaDot;

        private float f;

        private float fDot;

        private float u;

        /**
         * axis 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                enumType = PidTuningAxis.class
        )
        public final Builder axis(EnumValue<PidTuningAxis> axis) {
            this.axis = axis;
            return this;
        }

        /**
         * axis 
         */
        public final Builder axis(PidTuningAxis entry) {
            this.axis = EnumValue.of(entry);
            return this;
        }

        /**
         * axis 
         */
        public final Builder axis(Enum... flags) {
            this.axis = EnumValue.create(flags);
            return this;
        }

        /**
         * desired rate (degrees/s) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder desired(float desired) {
            this.desired = desired;
            return this;
        }

        /**
         * achieved rate (degrees/s) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder achieved(float achieved) {
            this.achieved = achieved;
            return this;
        }

        /**
         * error between model and vehicle 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder error(float error) {
            this.error = error;
            return this;
        }

        /**
         * theta estimated state predictor 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder theta(float theta) {
            this.theta = theta;
            return this;
        }

        /**
         * omega estimated state predictor 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder omega(float omega) {
            this.omega = omega;
            return this;
        }

        /**
         * sigma estimated state predictor 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4
        )
        public final Builder sigma(float sigma) {
            this.sigma = sigma;
            return this;
        }

        /**
         * theta derivative 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4
        )
        public final Builder thetaDot(float thetaDot) {
            this.thetaDot = thetaDot;
            return this;
        }

        /**
         * omega derivative 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4
        )
        public final Builder omegaDot(float omegaDot) {
            this.omegaDot = omegaDot;
            return this;
        }

        /**
         * sigma derivative 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4
        )
        public final Builder sigmaDot(float sigmaDot) {
            this.sigmaDot = sigmaDot;
            return this;
        }

        /**
         * projection operator value 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4
        )
        public final Builder f(float f) {
            this.f = f;
            return this;
        }

        /**
         * projection operator derivative 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4
        )
        public final Builder fDot(float fDot) {
            this.fDot = fDot;
            return this;
        }

        /**
         * u adaptive controlled output command 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 4
        )
        public final Builder u(float u) {
            this.u = u;
            return this;
        }

        public final AdapTuning build() {
            return new AdapTuning(axis, desired, achieved, error, theta, omega, sigma, thetaDot, omegaDot, sigmaDot, f, fDot, u);
        }
    }
}
