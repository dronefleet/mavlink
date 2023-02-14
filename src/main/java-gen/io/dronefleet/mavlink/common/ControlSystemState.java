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
 * The smoothed, monotonic system state used to feed the control loops of the system. 
 */
@MavlinkMessageInfo(
        id = 146,
        crc = 103,
        description = "The smoothed, monotonic system state used to feed the control loops of the system."
)
public final class ControlSystemState {
    private final BigInteger timeUsec;

    private final float xAcc;

    private final float yAcc;

    private final float zAcc;

    private final float xVel;

    private final float yVel;

    private final float zVel;

    private final float xPos;

    private final float yPos;

    private final float zPos;

    private final float airspeed;

    private final List<Float> velVariance;

    private final List<Float> posVariance;

    private final List<Float> q;

    private final float rollRate;

    private final float pitchRate;

    private final float yawRate;

    private ControlSystemState(BigInteger timeUsec, float xAcc, float yAcc, float zAcc, float xVel,
            float yVel, float zVel, float xPos, float yPos, float zPos, float airspeed,
            List<Float> velVariance, List<Float> posVariance, List<Float> q, float rollRate,
            float pitchRate, float yawRate) {
        this.timeUsec = timeUsec;
        this.xAcc = xAcc;
        this.yAcc = yAcc;
        this.zAcc = zAcc;
        this.xVel = xVel;
        this.yVel = yVel;
        this.zVel = zVel;
        this.xPos = xPos;
        this.yPos = yPos;
        this.zPos = zPos;
        this.airspeed = airspeed;
        this.velVariance = velVariance;
        this.posVariance = posVariance;
        this.q = q;
        this.rollRate = rollRate;
        this.pitchRate = pitchRate;
        this.yawRate = yawRate;
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
     * X acceleration in body frame 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "X acceleration in body frame"
    )
    public final float xAcc() {
        return this.xAcc;
    }

    /**
     * Y acceleration in body frame 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Y acceleration in body frame"
    )
    public final float yAcc() {
        return this.yAcc;
    }

    /**
     * Z acceleration in body frame 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Z acceleration in body frame"
    )
    public final float zAcc() {
        return this.zAcc;
    }

    /**
     * X velocity in body frame 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "X velocity in body frame"
    )
    public final float xVel() {
        return this.xVel;
    }

    /**
     * Y velocity in body frame 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Y velocity in body frame"
    )
    public final float yVel() {
        return this.yVel;
    }

    /**
     * Z velocity in body frame 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Z velocity in body frame"
    )
    public final float zVel() {
        return this.zVel;
    }

    /**
     * X position in local frame 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "X position in local frame"
    )
    public final float xPos() {
        return this.xPos;
    }

    /**
     * Y position in local frame 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Y position in local frame"
    )
    public final float yPos() {
        return this.yPos;
    }

    /**
     * Z position in local frame 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "Z position in local frame"
    )
    public final float zPos() {
        return this.zPos;
    }

    /**
     * Airspeed, set to -1 if unknown 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            description = "Airspeed, set to -1 if unknown"
    )
    public final float airspeed() {
        return this.airspeed;
    }

    /**
     * Variance of body velocity estimate 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4,
            arraySize = 3,
            description = "Variance of body velocity estimate"
    )
    public final List<Float> velVariance() {
        return this.velVariance;
    }

    /**
     * Variance in local position 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 4,
            arraySize = 3,
            description = "Variance in local position"
    )
    public final List<Float> posVariance() {
        return this.posVariance;
    }

    /**
     * The attitude, represented as Quaternion 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 4,
            arraySize = 4,
            description = "The attitude, represented as Quaternion"
    )
    public final List<Float> q() {
        return this.q;
    }

    /**
     * Angular rate in roll axis 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 4,
            description = "Angular rate in roll axis"
    )
    public final float rollRate() {
        return this.rollRate;
    }

    /**
     * Angular rate in pitch axis 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 4,
            description = "Angular rate in pitch axis"
    )
    public final float pitchRate() {
        return this.pitchRate;
    }

    /**
     * Angular rate in yaw axis 
     */
    @MavlinkFieldInfo(
            position = 17,
            unitSize = 4,
            description = "Angular rate in yaw axis"
    )
    public final float yawRate() {
        return this.yawRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ControlSystemState other = (ControlSystemState)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(xAcc, other.xAcc)) return false;
        if (!Objects.deepEquals(yAcc, other.yAcc)) return false;
        if (!Objects.deepEquals(zAcc, other.zAcc)) return false;
        if (!Objects.deepEquals(xVel, other.xVel)) return false;
        if (!Objects.deepEquals(yVel, other.yVel)) return false;
        if (!Objects.deepEquals(zVel, other.zVel)) return false;
        if (!Objects.deepEquals(xPos, other.xPos)) return false;
        if (!Objects.deepEquals(yPos, other.yPos)) return false;
        if (!Objects.deepEquals(zPos, other.zPos)) return false;
        if (!Objects.deepEquals(airspeed, other.airspeed)) return false;
        if (!Objects.deepEquals(velVariance, other.velVariance)) return false;
        if (!Objects.deepEquals(posVariance, other.posVariance)) return false;
        if (!Objects.deepEquals(q, other.q)) return false;
        if (!Objects.deepEquals(rollRate, other.rollRate)) return false;
        if (!Objects.deepEquals(pitchRate, other.pitchRate)) return false;
        if (!Objects.deepEquals(yawRate, other.yawRate)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(xAcc);
        result = 31 * result + Objects.hashCode(yAcc);
        result = 31 * result + Objects.hashCode(zAcc);
        result = 31 * result + Objects.hashCode(xVel);
        result = 31 * result + Objects.hashCode(yVel);
        result = 31 * result + Objects.hashCode(zVel);
        result = 31 * result + Objects.hashCode(xPos);
        result = 31 * result + Objects.hashCode(yPos);
        result = 31 * result + Objects.hashCode(zPos);
        result = 31 * result + Objects.hashCode(airspeed);
        result = 31 * result + Objects.hashCode(velVariance);
        result = 31 * result + Objects.hashCode(posVariance);
        result = 31 * result + Objects.hashCode(q);
        result = 31 * result + Objects.hashCode(rollRate);
        result = 31 * result + Objects.hashCode(pitchRate);
        result = 31 * result + Objects.hashCode(yawRate);
        return result;
    }

    @Override
    public String toString() {
        return "ControlSystemState{timeUsec=" + timeUsec
                 + ", xAcc=" + xAcc
                 + ", yAcc=" + yAcc
                 + ", zAcc=" + zAcc
                 + ", xVel=" + xVel
                 + ", yVel=" + yVel
                 + ", zVel=" + zVel
                 + ", xPos=" + xPos
                 + ", yPos=" + yPos
                 + ", zPos=" + zPos
                 + ", airspeed=" + airspeed
                 + ", velVariance=" + velVariance
                 + ", posVariance=" + posVariance
                 + ", q=" + q
                 + ", rollRate=" + rollRate
                 + ", pitchRate=" + pitchRate
                 + ", yawRate=" + yawRate + "}";
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private float xAcc;

        private float yAcc;

        private float zAcc;

        private float xVel;

        private float yVel;

        private float zVel;

        private float xPos;

        private float yPos;

        private float zPos;

        private float airspeed;

        private List<Float> velVariance;

        private List<Float> posVariance;

        private List<Float> q;

        private float rollRate;

        private float pitchRate;

        private float yawRate;

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
         * X acceleration in body frame 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "X acceleration in body frame"
        )
        public final Builder xAcc(float xAcc) {
            this.xAcc = xAcc;
            return this;
        }

        /**
         * Y acceleration in body frame 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Y acceleration in body frame"
        )
        public final Builder yAcc(float yAcc) {
            this.yAcc = yAcc;
            return this;
        }

        /**
         * Z acceleration in body frame 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Z acceleration in body frame"
        )
        public final Builder zAcc(float zAcc) {
            this.zAcc = zAcc;
            return this;
        }

        /**
         * X velocity in body frame 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "X velocity in body frame"
        )
        public final Builder xVel(float xVel) {
            this.xVel = xVel;
            return this;
        }

        /**
         * Y velocity in body frame 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Y velocity in body frame"
        )
        public final Builder yVel(float yVel) {
            this.yVel = yVel;
            return this;
        }

        /**
         * Z velocity in body frame 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Z velocity in body frame"
        )
        public final Builder zVel(float zVel) {
            this.zVel = zVel;
            return this;
        }

        /**
         * X position in local frame 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "X position in local frame"
        )
        public final Builder xPos(float xPos) {
            this.xPos = xPos;
            return this;
        }

        /**
         * Y position in local frame 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Y position in local frame"
        )
        public final Builder yPos(float yPos) {
            this.yPos = yPos;
            return this;
        }

        /**
         * Z position in local frame 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "Z position in local frame"
        )
        public final Builder zPos(float zPos) {
            this.zPos = zPos;
            return this;
        }

        /**
         * Airspeed, set to -1 if unknown 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                description = "Airspeed, set to -1 if unknown"
        )
        public final Builder airspeed(float airspeed) {
            this.airspeed = airspeed;
            return this;
        }

        /**
         * Variance of body velocity estimate 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4,
                arraySize = 3,
                description = "Variance of body velocity estimate"
        )
        public final Builder velVariance(List<Float> velVariance) {
            this.velVariance = velVariance;
            return this;
        }

        /**
         * Variance in local position 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 4,
                arraySize = 3,
                description = "Variance in local position"
        )
        public final Builder posVariance(List<Float> posVariance) {
            this.posVariance = posVariance;
            return this;
        }

        /**
         * The attitude, represented as Quaternion 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 4,
                arraySize = 4,
                description = "The attitude, represented as Quaternion"
        )
        public final Builder q(List<Float> q) {
            this.q = q;
            return this;
        }

        /**
         * Angular rate in roll axis 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 4,
                description = "Angular rate in roll axis"
        )
        public final Builder rollRate(float rollRate) {
            this.rollRate = rollRate;
            return this;
        }

        /**
         * Angular rate in pitch axis 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 4,
                description = "Angular rate in pitch axis"
        )
        public final Builder pitchRate(float pitchRate) {
            this.pitchRate = pitchRate;
            return this;
        }

        /**
         * Angular rate in yaw axis 
         */
        @MavlinkFieldInfo(
                position = 17,
                unitSize = 4,
                description = "Angular rate in yaw axis"
        )
        public final Builder yawRate(float yawRate) {
            this.yawRate = yawRate;
            return this;
        }

        public final ControlSystemState build() {
            return new ControlSystemState(timeUsec, xAcc, yAcc, zAcc, xVel, yVel, zVel, xPos, yPos, zPos, airspeed, velVariance, posVariance, q, rollRate, pitchRate, yawRate);
        }
    }
}
