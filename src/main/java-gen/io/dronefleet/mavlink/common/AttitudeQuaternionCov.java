package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Float;
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
     * Timestamp (microseconds since system boot or since UNIX epoch) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
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
            arraySize = 4
    )
    public final List<Float> q() {
        return this.q;
    }

    /**
     * Roll angular speed (rad/s) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float rollspeed() {
        return this.rollspeed;
    }

    /**
     * Pitch angular speed (rad/s) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float pitchspeed() {
        return this.pitchspeed;
    }

    /**
     * Yaw angular speed (rad/s) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float yawspeed() {
        return this.yawspeed;
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
        return this.covariance;
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private List<Float> q;

        private float rollspeed;

        private float pitchspeed;

        private float yawspeed;

        private List<Float> covariance;

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
