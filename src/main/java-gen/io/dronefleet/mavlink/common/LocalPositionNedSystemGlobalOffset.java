package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * The offset in X, Y, Z and yaw between the {@link io.dronefleet.mavlink.common.LocalPositionNed LOCAL_POSITION_NED} messages of MAV X and the global 
 * coordinate frame in NED coordinates. Coordinate frame is right-handed, Z-axis down 
 * (aeronautical frame, NED / north-east-down convention) 
 */
@MavlinkMessageInfo(
        id = 89,
        crc = 231,
        description = "The offset in X, Y, Z and yaw between the LOCAL_POSITION_NED messages of MAV X and the global coordinate frame in NED coordinates. Coordinate frame is right-handed, Z-axis down (aeronautical frame, NED / north-east-down convention)"
)
public final class LocalPositionNedSystemGlobalOffset {
    private final long timeBootMs;

    private final float x;

    private final float y;

    private final float z;

    private final float roll;

    private final float pitch;

    private final float yaw;

    private LocalPositionNedSystemGlobalOffset(long timeBootMs, float x, float y, float z,
            float roll, float pitch, float yaw) {
        this.timeBootMs = timeBootMs;
        this.x = x;
        this.y = y;
        this.z = z;
        this.roll = roll;
        this.pitch = pitch;
        this.yaw = yaw;
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
     * X Position 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "X Position"
    )
    public final float x() {
        return this.x;
    }

    /**
     * Y Position 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Y Position"
    )
    public final float y() {
        return this.y;
    }

    /**
     * Z Position 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Z Position"
    )
    public final float z() {
        return this.z;
    }

    /**
     * Roll 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Roll"
    )
    public final float roll() {
        return this.roll;
    }

    /**
     * Pitch 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Pitch"
    )
    public final float pitch() {
        return this.pitch;
    }

    /**
     * Yaw 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Yaw"
    )
    public final float yaw() {
        return this.yaw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        LocalPositionNedSystemGlobalOffset other = (LocalPositionNedSystemGlobalOffset)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(x, other.x)) return false;
        if (!Objects.deepEquals(y, other.y)) return false;
        if (!Objects.deepEquals(z, other.z)) return false;
        if (!Objects.deepEquals(roll, other.roll)) return false;
        if (!Objects.deepEquals(pitch, other.pitch)) return false;
        if (!Objects.deepEquals(yaw, other.yaw)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(x);
        result = 31 * result + Objects.hashCode(y);
        result = 31 * result + Objects.hashCode(z);
        result = 31 * result + Objects.hashCode(roll);
        result = 31 * result + Objects.hashCode(pitch);
        result = 31 * result + Objects.hashCode(yaw);
        return result;
    }

    @Override
    public String toString() {
        return "LocalPositionNedSystemGlobalOffset{timeBootMs=" + timeBootMs
                 + ", x=" + x
                 + ", y=" + y
                 + ", z=" + z
                 + ", roll=" + roll
                 + ", pitch=" + pitch
                 + ", yaw=" + yaw + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private float x;

        private float y;

        private float z;

        private float roll;

        private float pitch;

        private float yaw;

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
         * X Position 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "X Position"
        )
        public final Builder x(float x) {
            this.x = x;
            return this;
        }

        /**
         * Y Position 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Y Position"
        )
        public final Builder y(float y) {
            this.y = y;
            return this;
        }

        /**
         * Z Position 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Z Position"
        )
        public final Builder z(float z) {
            this.z = z;
            return this;
        }

        /**
         * Roll 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Roll"
        )
        public final Builder roll(float roll) {
            this.roll = roll;
            return this;
        }

        /**
         * Pitch 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Pitch"
        )
        public final Builder pitch(float pitch) {
            this.pitch = pitch;
            return this;
        }

        /**
         * Yaw 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Yaw"
        )
        public final Builder yaw(float yaw) {
            this.yaw = yaw;
            return this;
        }

        public final LocalPositionNedSystemGlobalOffset build() {
            return new LocalPositionNedSystemGlobalOffset(timeBootMs, x, y, z, roll, pitch, yaw);
        }
    }
}
