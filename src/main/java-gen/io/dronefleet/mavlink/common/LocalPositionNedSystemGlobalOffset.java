package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * The offset in X, Y, Z and yaw between the {@link io.dronefleet.mavlink.common.LocalPositionNed LOCAL_POSITION_NED} messages of MAV X and the global 
 * coordinate frame in NED coordinates. Coordinate frame is right-handed, Z-axis down 
 * (aeronautical frame, NED / north-east-down convention) 
 */
@MavlinkMessageInfo(
        id = 89,
        crc = 231
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
     * X Position 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float x() {
        return this.x;
    }

    /**
     * Y Position 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float y() {
        return this.y;
    }

    /**
     * Z Position 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float z() {
        return this.z;
    }

    /**
     * Roll 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float roll() {
        return this.roll;
    }

    /**
     * Pitch 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float pitch() {
        return this.pitch;
    }

    /**
     * Yaw 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float yaw() {
        return this.yaw;
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
         * X Position 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
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
                unitSize = 4
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
                unitSize = 4
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
                unitSize = 4
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
                unitSize = 4
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
                unitSize = 4
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
