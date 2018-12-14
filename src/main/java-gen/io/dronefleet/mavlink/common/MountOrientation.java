package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Orientation of a mount 
 */
@MavlinkMessageInfo(
        id = 265,
        crc = 26,
        description = "Orientation of a mount"
)
public final class MountOrientation {
    private final long timeBootMs;

    private final float roll;

    private final float pitch;

    private final float yaw;

    private final float yawAbsolute;

    private MountOrientation(long timeBootMs, float roll, float pitch, float yaw,
            float yawAbsolute) {
        this.timeBootMs = timeBootMs;
        this.roll = roll;
        this.pitch = pitch;
        this.yaw = yaw;
        this.yawAbsolute = yawAbsolute;
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
     * Roll in global frame (set to NaN for invalid). 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Roll in global frame (set to NaN for invalid)."
    )
    public final float roll() {
        return this.roll;
    }

    /**
     * Pitch in global frame (set to NaN for invalid). 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Pitch in global frame (set to NaN for invalid)."
    )
    public final float pitch() {
        return this.pitch;
    }

    /**
     * Yaw relative to vehicle(set to NaN for invalid). 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Yaw relative to vehicle(set to NaN for invalid)."
    )
    public final float yaw() {
        return this.yaw;
    }

    /**
     * Yaw in absolute frame, North is 0 (set to NaN for invalid). 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            extension = true,
            description = "Yaw in absolute frame, North is 0 (set to NaN for invalid)."
    )
    public final float yawAbsolute() {
        return this.yawAbsolute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        MountOrientation other = (MountOrientation)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(roll, other.roll)) return false;
        if (!Objects.deepEquals(pitch, other.pitch)) return false;
        if (!Objects.deepEquals(yaw, other.yaw)) return false;
        if (!Objects.deepEquals(yawAbsolute, other.yawAbsolute)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(roll);
        result = 31 * result + Objects.hashCode(pitch);
        result = 31 * result + Objects.hashCode(yaw);
        result = 31 * result + Objects.hashCode(yawAbsolute);
        return result;
    }

    @Override
    public String toString() {
        return "MountOrientation{timeBootMs=" + timeBootMs
                 + ", roll=" + roll
                 + ", pitch=" + pitch
                 + ", yaw=" + yaw
                 + ", yawAbsolute=" + yawAbsolute + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private float roll;

        private float pitch;

        private float yaw;

        private float yawAbsolute;

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
         * Roll in global frame (set to NaN for invalid). 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Roll in global frame (set to NaN for invalid)."
        )
        public final Builder roll(float roll) {
            this.roll = roll;
            return this;
        }

        /**
         * Pitch in global frame (set to NaN for invalid). 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Pitch in global frame (set to NaN for invalid)."
        )
        public final Builder pitch(float pitch) {
            this.pitch = pitch;
            return this;
        }

        /**
         * Yaw relative to vehicle(set to NaN for invalid). 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Yaw relative to vehicle(set to NaN for invalid)."
        )
        public final Builder yaw(float yaw) {
            this.yaw = yaw;
            return this;
        }

        /**
         * Yaw in absolute frame, North is 0 (set to NaN for invalid). 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                extension = true,
                description = "Yaw in absolute frame, North is 0 (set to NaN for invalid)."
        )
        public final Builder yawAbsolute(float yawAbsolute) {
            this.yawAbsolute = yawAbsolute;
            return this;
        }

        public final MountOrientation build() {
            return new MountOrientation(timeBootMs, roll, pitch, yaw, yawAbsolute);
        }
    }
}
