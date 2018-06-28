package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * The filtered local position (e.g. fused computer vision and accelerometers). Coordinate 
 * frame is right-handed, Z-axis down (aeronautical frame, NED / north-east-down convention) 
 */
@MavlinkMessageInfo(
        id = 32,
        crc = 185
)
public final class LocalPositionNed {
    private final long timeBootMs;

    private final float x;

    private final float y;

    private final float z;

    private final float vx;

    private final float vy;

    private final float vz;

    private LocalPositionNed(long timeBootMs, float x, float y, float z, float vx, float vy,
            float vz) {
        this.timeBootMs = timeBootMs;
        this.x = x;
        this.y = y;
        this.z = z;
        this.vx = vx;
        this.vy = vy;
        this.vz = vz;
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
     * X Speed 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float vx() {
        return this.vx;
    }

    /**
     * Y Speed 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float vy() {
        return this.vy;
    }

    /**
     * Z Speed 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float vz() {
        return this.vz;
    }

    public static final class Builder {
        private long timeBootMs;

        private float x;

        private float y;

        private float z;

        private float vx;

        private float vy;

        private float vz;

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
         * X Speed 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder vx(float vx) {
            this.vx = vx;
            return this;
        }

        /**
         * Y Speed 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder vy(float vy) {
            this.vy = vy;
            return this;
        }

        /**
         * Z Speed 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4
        )
        public final Builder vz(float vz) {
            this.vz = vz;
            return this;
        }

        public final LocalPositionNed build() {
            return new LocalPositionNed(timeBootMs, x, y, z, vx, vy, vz);
        }
    }
}
