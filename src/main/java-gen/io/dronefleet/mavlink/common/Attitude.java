package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * The attitude in the aeronautical frame (right-handed, Z-down, X-front, Y-right). 
 */
@MavlinkMessageInfo(
        id = 30,
        crc = 39,
        description = "The attitude in the aeronautical frame (right-handed, Z-down, X-front, Y-right)."
)
public final class Attitude {
    private final long timeBootMs;

    private final float roll;

    private final float pitch;

    private final float yaw;

    private final float rollspeed;

    private final float pitchspeed;

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

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (time since system boot). 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Timestamp (time since system boot)."
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * Roll angle (-pi..+pi) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Roll angle (-pi..+pi)"
    )
    public final float roll() {
        return this.roll;
    }

    /**
     * Pitch angle (-pi..+pi) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Pitch angle (-pi..+pi)"
    )
    public final float pitch() {
        return this.pitch;
    }

    /**
     * Yaw angle (-pi..+pi) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Yaw angle (-pi..+pi)"
    )
    public final float yaw() {
        return this.yaw;
    }

    /**
     * Roll angular speed 
     */
    @MavlinkFieldInfo(
            position = 5,
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
            position = 6,
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
            position = 7,
            unitSize = 4,
            description = "Yaw angular speed"
    )
    public final float yawspeed() {
        return this.yawspeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Attitude other = (Attitude)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(roll, other.roll)) return false;
        if (!Objects.deepEquals(pitch, other.pitch)) return false;
        if (!Objects.deepEquals(yaw, other.yaw)) return false;
        if (!Objects.deepEquals(rollspeed, other.rollspeed)) return false;
        if (!Objects.deepEquals(pitchspeed, other.pitchspeed)) return false;
        if (!Objects.deepEquals(yawspeed, other.yawspeed)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(roll);
        result = 31 * result + Objects.hashCode(pitch);
        result = 31 * result + Objects.hashCode(yaw);
        result = 31 * result + Objects.hashCode(rollspeed);
        result = 31 * result + Objects.hashCode(pitchspeed);
        result = 31 * result + Objects.hashCode(yawspeed);
        return result;
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

    public static final class Builder {
        private long timeBootMs;

        private float roll;

        private float pitch;

        private float yaw;

        private float rollspeed;

        private float pitchspeed;

        private float yawspeed;

        /**
         * Timestamp (time since system boot). 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Timestamp (time since system boot)."
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * Roll angle (-pi..+pi) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Roll angle (-pi..+pi)"
        )
        public final Builder roll(float roll) {
            this.roll = roll;
            return this;
        }

        /**
         * Pitch angle (-pi..+pi) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Pitch angle (-pi..+pi)"
        )
        public final Builder pitch(float pitch) {
            this.pitch = pitch;
            return this;
        }

        /**
         * Yaw angle (-pi..+pi) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Yaw angle (-pi..+pi)"
        )
        public final Builder yaw(float yaw) {
            this.yaw = yaw;
            return this;
        }

        /**
         * Roll angular speed 
         */
        @MavlinkFieldInfo(
                position = 5,
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
                position = 6,
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
                position = 7,
                unitSize = 4,
                description = "Yaw angular speed"
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
