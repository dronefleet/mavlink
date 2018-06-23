package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * The attitude in the aeronautical frame (right-handed, Z-down, X-front, Y-right). 
 */
@MavlinkMessageInfo(
        id = 30,
        crc = 39
)
public final class Attitude {
    /**
     * Timestamp (milliseconds since system boot) 
     */
    private final long timeBootMs;

    /**
     * Roll angle (rad, -pi..+pi) 
     */
    private final float roll;

    /**
     * Pitch angle (rad, -pi..+pi) 
     */
    private final float pitch;

    /**
     * Yaw angle (rad, -pi..+pi) 
     */
    private final float yaw;

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

    private Attitude(long timeBootMs, float roll, float pitch, float yaw, float rollspeed,
            float pitchspeed, float yawspeed) {
        this.timeBootMs = timeBootMs;
        this.roll = roll;
        this.pitch = pitch;
        this.yaw = yaw;
        this.rollspeed = rollspeed;
        this.pitchspeed = pitchspeed;
        this.yawspeed = yawspeed;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Attitude{timeBootMs=" + timeBootMs
                 + ", roll=" + roll
                 + ", pitch=" + pitch
                 + ", yaw=" + yaw
                 + ", rollspeed=" + rollspeed
                 + ", pitchspeed=" + pitchspeed
                 + ", yawspeed=" + yawspeed + "}";
    }

    /**
     * Timestamp (milliseconds since system boot) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final long timeBootMs() {
        return timeBootMs;
    }

    /**
     * Roll angle (rad, -pi..+pi) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float roll() {
        return roll;
    }

    /**
     * Pitch angle (rad, -pi..+pi) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float pitch() {
        return pitch;
    }

    /**
     * Yaw angle (rad, -pi..+pi) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float yaw() {
        return yaw;
    }

    /**
     * Roll angular speed (rad/s) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float rollspeed() {
        return rollspeed;
    }

    /**
     * Pitch angular speed (rad/s) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float pitchspeed() {
        return pitchspeed;
    }

    /**
     * Yaw angular speed (rad/s) 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float yawspeed() {
        return yawspeed;
    }

    public static class Builder {
        private long timeBootMs;

        private float roll;

        private float pitch;

        private float yaw;

        private float rollspeed;

        private float pitchspeed;

        private float yawspeed;

        private Builder() {
        }

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
         * Roll angle (rad, -pi..+pi) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder roll(float roll) {
            this.roll = roll;
            return this;
        }

        /**
         * Pitch angle (rad, -pi..+pi) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder pitch(float pitch) {
            this.pitch = pitch;
            return this;
        }

        /**
         * Yaw angle (rad, -pi..+pi) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder yaw(float yaw) {
            this.yaw = yaw;
            return this;
        }

        /**
         * Roll angular speed (rad/s) 
         */
        @MavlinkFieldInfo(
                position = 5,
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
                position = 6,
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
                position = 7,
                unitSize = 4
        )
        public final Builder yawspeed(float yawspeed) {
            this.yawspeed = yawspeed;
            return this;
        }

        public final Attitude build() {
            return new Attitude(timeBootMs, roll, pitch, yaw, rollspeed, pitchspeed, yawspeed);
        }
    }
}
