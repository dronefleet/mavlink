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
 * The attitude in the aeronautical frame (right-handed, Z-down, X-front, Y-right), expressed 
 * as quaternion. Quaternion order is w, x, y, z and a zero rotation would be expressed as (1 0 0 0). 
 */
@MavlinkMessageInfo(
        id = 61,
        crc = 167,
        description = "The attitude in the aeronautical frame (right-handed, Z-down, X-front, Y-right), expressed as quaternion. Quaternion order is w, x, y, z and a zero rotation would be expressed as (1 0 0 0)."
)
public final class AttitudeQuaternionCov {
    private final BigInteger timeUsec;

    private final List<Float> q;

    private final float rollspeed;

    private final float pitchspeed;

    private final float yawspeed;

    private final List<Float> covariance;

    private AttitudeQuaternionCov(BigInteger timeUsec, List<Float> q, float rollspeed,
            float pitchspeed, float yawspeed, List<Float> covariance) {
        this.timeUsec = timeUsec;
        this.q = q;
        this.rollspeed = rollspeed;
        this.pitchspeed = pitchspeed;
        this.yawspeed = yawspeed;
        this.covariance = covariance;
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
     * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            arraySize = 4,
            description = "Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation)"
    )
    public final List<Float> q() {
        return this.q;
    }

    /**
     * Roll angular speed 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Roll angular speed"
    )
    public final float rollspeed() {
        return this.rollspeed;
    }

    /**
     * Pitch angular speed 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Pitch angular speed"
    )
    public final float pitchspeed() {
        return this.pitchspeed;
    }

    /**
     * Yaw angular speed 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Yaw angular speed"
    )
    public final float yawspeed() {
        return this.yawspeed;
    }

    /**
     * Row-major representation of a 3x3 attitude covariance matrix (states: roll, pitch, yaw; 
     * first three entries are the first ROW, next three entries are the second row, etc.). If unknown, 
     * assign NaN value to first element in the array. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            arraySize = 9,
            description = "Row-major representation of a 3x3 attitude covariance matrix (states: roll, pitch, yaw; first three entries are the first ROW, next three entries are the second row, etc.). If unknown, assign NaN value to first element in the array."
    )
    public final List<Float> covariance() {
        return this.covariance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        AttitudeQuaternionCov other = (AttitudeQuaternionCov)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(q, other.q)) return false;
        if (!Objects.deepEquals(rollspeed, other.rollspeed)) return false;
        if (!Objects.deepEquals(pitchspeed, other.pitchspeed)) return false;
        if (!Objects.deepEquals(yawspeed, other.yawspeed)) return false;
        if (!Objects.deepEquals(covariance, other.covariance)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(q);
        result = 31 * result + Objects.hashCode(rollspeed);
        result = 31 * result + Objects.hashCode(pitchspeed);
        result = 31 * result + Objects.hashCode(yawspeed);
        result = 31 * result + Objects.hashCode(covariance);
        return result;
    }

    @Override
    public String toString() {
        return "AttitudeQuaternionCov{timeUsec=" + timeUsec
                 + ", q=" + q
                 + ", rollspeed=" + rollspeed
                 + ", pitchspeed=" + pitchspeed
                 + ", yawspeed=" + yawspeed
                 + ", covariance=" + covariance + "}";
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private List<Float> q;

        private float rollspeed;

        private float pitchspeed;

        private float yawspeed;

        private List<Float> covariance;

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
         * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                arraySize = 4,
                description = "Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation)"
        )
        public final Builder q(List<Float> q) {
            this.q = q;
            return this;
        }

        /**
         * Roll angular speed 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Roll angular speed"
        )
        public final Builder rollspeed(float rollspeed) {
            this.rollspeed = rollspeed;
            return this;
        }

        /**
         * Pitch angular speed 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Pitch angular speed"
        )
        public final Builder pitchspeed(float pitchspeed) {
            this.pitchspeed = pitchspeed;
            return this;
        }

        /**
         * Yaw angular speed 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Yaw angular speed"
        )
        public final Builder yawspeed(float yawspeed) {
            this.yawspeed = yawspeed;
            return this;
        }

        /**
         * Row-major representation of a 3x3 attitude covariance matrix (states: roll, pitch, yaw; 
         * first three entries are the first ROW, next three entries are the second row, etc.). If unknown, 
         * assign NaN value to first element in the array. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                arraySize = 9,
                description = "Row-major representation of a 3x3 attitude covariance matrix (states: roll, pitch, yaw; first three entries are the first ROW, next three entries are the second row, etc.). If unknown, assign NaN value to first element in the array."
        )
        public final Builder covariance(List<Float> covariance) {
            this.covariance = covariance;
            return this;
        }

        public final AttitudeQuaternionCov build() {
            return new AttitudeQuaternionCov(timeUsec, q, rollspeed, pitchspeed, yawspeed, covariance);
        }
    }
}
