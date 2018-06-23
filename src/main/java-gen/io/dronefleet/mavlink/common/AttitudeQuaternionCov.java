package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Float;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.List;

/**
 * The attitude in the aeronautical frame (right-handed, Z-down, X-front, Y-right), expressed 
 * as quaternion. Quaternion order is w, x, y, z and a zero rotation would be expressed as (1 0 0 0). 
 */
@MavlinkMessageInfo(
        id = 61,
        crc = 167
)
public final class AttitudeQuaternionCov {
    /**
     * Timestamp (microseconds since system boot or since UNIX epoch) 
     */
    private final BigInteger timeUsec;

    /**
     * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation) 
     */
    private final List<Float> q;

    /**
     * Roll angular speed (rad/s) 
     */
    private final float rollspeed;

    /**
     * Pitch angular speed (rad/s) 
     */
    private final float pitchspeed;

    /**
     * Yaw angular speed (rad/s) 
     */
    private final float yawspeed;

    /**
     * Attitude covariance 
     */
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

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
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

    /**
     * Timestamp (microseconds since system boot or since UNIX epoch) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
    )
    public final BigInteger timeUsec() {
        return timeUsec;
    }

    /**
     * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            arraySize = 4
    )
    public final List<Float> q() {
        return q;
    }

    /**
     * Roll angular speed (rad/s) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float rollspeed() {
        return rollspeed;
    }

    /**
     * Pitch angular speed (rad/s) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float pitchspeed() {
        return pitchspeed;
    }

    /**
     * Yaw angular speed (rad/s) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float yawspeed() {
        return yawspeed;
    }

    /**
     * Attitude covariance 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            arraySize = 9
    )
    public final List<Float> covariance() {
        return covariance;
    }

    public static class Builder {
        private BigInteger timeUsec;

        private List<Float> q;

        private float rollspeed;

        private float pitchspeed;

        private float yawspeed;

        private List<Float> covariance;

        private Builder() {
        }

        /**
         * Timestamp (microseconds since system boot or since UNIX epoch) 
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
         * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                arraySize = 4
        )
        public final Builder q(List<Float> q) {
            this.q = q;
            return this;
        }

        /**
         * Roll angular speed (rad/s) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder rollspeed(float rollspeed) {
            this.rollspeed = rollspeed;
            return this;
        }

        /**
         * Pitch angular speed (rad/s) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder pitchspeed(float pitchspeed) {
            this.pitchspeed = pitchspeed;
            return this;
        }

        /**
         * Yaw angular speed (rad/s) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder yawspeed(float yawspeed) {
            this.yawspeed = yawspeed;
            return this;
        }

        /**
         * Attitude covariance 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                arraySize = 9
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
