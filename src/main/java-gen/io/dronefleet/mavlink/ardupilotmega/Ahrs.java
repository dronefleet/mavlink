package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Status of DCM attitude estimator 
 */
@MavlinkMessageInfo(
        id = 163,
        crc = 127
)
public final class Ahrs {
    private final float omegaix;

    private final float omegaiy;

    private final float omegaiz;

    private final float accelWeight;

    private final float renormVal;

    private final float errorRp;

    private final float errorYaw;

    private Ahrs(float omegaix, float omegaiy, float omegaiz, float accelWeight, float renormVal,
            float errorRp, float errorYaw) {
        this.omegaix = omegaix;
        this.omegaiy = omegaiy;
        this.omegaiz = omegaiz;
        this.accelWeight = accelWeight;
        this.renormVal = renormVal;
        this.errorRp = errorRp;
        this.errorYaw = errorYaw;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * X gyro drift estimate rad/s 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final float omegaix() {
        return this.omegaix;
    }

    /**
     * Y gyro drift estimate rad/s 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float omegaiy() {
        return this.omegaiy;
    }

    /**
     * Z gyro drift estimate rad/s 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float omegaiz() {
        return this.omegaiz;
    }

    /**
     * average accel_weight 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float accelWeight() {
        return this.accelWeight;
    }

    /**
     * average renormalisation value 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float renormVal() {
        return this.renormVal;
    }

    /**
     * average error_roll_pitch value 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float errorRp() {
        return this.errorRp;
    }

    /**
     * average error_yaw value 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float errorYaw() {
        return this.errorYaw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Ahrs other = (Ahrs)o;
        if (!Objects.deepEquals(omegaix, other.omegaix)) return false;
        if (!Objects.deepEquals(omegaiy, other.omegaiy)) return false;
        if (!Objects.deepEquals(omegaiz, other.omegaiz)) return false;
        if (!Objects.deepEquals(accelWeight, other.accelWeight)) return false;
        if (!Objects.deepEquals(renormVal, other.renormVal)) return false;
        if (!Objects.deepEquals(errorRp, other.errorRp)) return false;
        if (!Objects.deepEquals(errorYaw, other.errorYaw)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(omegaix);
        result = 31 * result + Objects.hashCode(omegaiy);
        result = 31 * result + Objects.hashCode(omegaiz);
        result = 31 * result + Objects.hashCode(accelWeight);
        result = 31 * result + Objects.hashCode(renormVal);
        result = 31 * result + Objects.hashCode(errorRp);
        result = 31 * result + Objects.hashCode(errorYaw);
        return result;
    }

    @Override
    public String toString() {
        return "Ahrs{omegaix=" + omegaix
                 + ", omegaiy=" + omegaiy
                 + ", omegaiz=" + omegaiz
                 + ", accelWeight=" + accelWeight
                 + ", renormVal=" + renormVal
                 + ", errorRp=" + errorRp
                 + ", errorYaw=" + errorYaw + "}";
    }

    public static final class Builder {
        private float omegaix;

        private float omegaiy;

        private float omegaiz;

        private float accelWeight;

        private float renormVal;

        private float errorRp;

        private float errorYaw;

        /**
         * X gyro drift estimate rad/s 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
        )
        public final Builder omegaix(float omegaix) {
            this.omegaix = omegaix;
            return this;
        }

        /**
         * Y gyro drift estimate rad/s 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder omegaiy(float omegaiy) {
            this.omegaiy = omegaiy;
            return this;
        }

        /**
         * Z gyro drift estimate rad/s 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder omegaiz(float omegaiz) {
            this.omegaiz = omegaiz;
            return this;
        }

        /**
         * average accel_weight 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder accelWeight(float accelWeight) {
            this.accelWeight = accelWeight;
            return this;
        }

        /**
         * average renormalisation value 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder renormVal(float renormVal) {
            this.renormVal = renormVal;
            return this;
        }

        /**
         * average error_roll_pitch value 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder errorRp(float errorRp) {
            this.errorRp = errorRp;
            return this;
        }

        /**
         * average error_yaw value 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4
        )
        public final Builder errorYaw(float errorYaw) {
            this.errorYaw = errorYaw;
            return this;
        }

        public final Ahrs build() {
            return new Ahrs(omegaix, omegaiy, omegaiz, accelWeight, renormVal, errorRp, errorYaw);
        }
    }
}
