package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * The attitude in the aeronautical frame (right-handed, Z-down, X-front, Y-right), expressed 
 * as quaternion. Quaternion order is w, x, y, z and a zero rotation would be expressed as (1 0 0 0). 
 */
@MavlinkMessageInfo(
        id = 31,
        crc = 246
)
public final class AttitudeQuaternion {
    private final long timeBootMs;

    private final float q1;

    private final float q2;

    private final float q3;

    private final float q4;

    private final float rollspeed;

    private final float pitchspeed;

    private final float yawspeed;

    private AttitudeQuaternion(long timeBootMs, float q1, float q2, float q3, float q4,
            float rollspeed, float pitchspeed, float yawspeed) {
        this.timeBootMs = timeBootMs;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.rollspeed = rollspeed;
        this.pitchspeed = pitchspeed;
        this.yawspeed = yawspeed;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (milliseconds since system boot) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * Quaternion component 1, w (1 in null-rotation) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float q1() {
        return this.q1;
    }

    /**
     * Quaternion component 2, x (0 in null-rotation) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float q2() {
        return this.q2;
    }

    /**
     * Quaternion component 3, y (0 in null-rotation) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float q3() {
        return this.q3;
    }

    /**
     * Quaternion component 4, z (0 in null-rotation) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float q4() {
        return this.q4;
    }

    /**
     * Roll angular speed (rad/s) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float rollspeed() {
        return this.rollspeed;
    }

    /**
     * Pitch angular speed (rad/s) 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float pitchspeed() {
        return this.pitchspeed;
    }

    /**
     * Yaw angular speed (rad/s) 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4
    )
    public final float yawspeed() {
        return this.yawspeed;
    }

    public static final class Builder {
        private long timeBootMs;

        private float q1;

        private float q2;

        private float q3;

        private float q4;

        private float rollspeed;

        private float pitchspeed;

        private float yawspeed;

        /**
         * Timestamp (milliseconds since system boot) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * Quaternion component 1, w (1 in null-rotation) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder q1(float q1) {
            this.q1 = q1;
            return this;
        }

        /**
         * Quaternion component 2, x (0 in null-rotation) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder q2(float q2) {
            this.q2 = q2;
            return this;
        }

        /**
         * Quaternion component 3, y (0 in null-rotation) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder q3(float q3) {
            this.q3 = q3;
            return this;
        }

        /**
         * Quaternion component 4, z (0 in null-rotation) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder q4(float q4) {
            this.q4 = q4;
            return this;
        }

        /**
         * Roll angular speed (rad/s) 
         */
        @MavlinkFieldInfo(
                position = 6,
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
                position = 7,
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
                position = 8,
                unitSize = 4
        )
        public final Builder yawspeed(float yawspeed) {
            this.yawspeed = yawspeed;
            return this;
        }

        public final AttitudeQuaternion build() {
            return new AttitudeQuaternion(timeBootMs, q1, q2, q3, q4, rollspeed, pitchspeed, yawspeed);
        }
    }
}
