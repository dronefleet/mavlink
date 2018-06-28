package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Float;
import java.math.BigInteger;
import java.util.List;

/**
 *  
 */
@MavlinkMessageInfo(
        id = 104,
        crc = 176
)
public final class ViconPositionEstimate {
    private final BigInteger usec;

    private final float x;

    private final float y;

    private final float z;

    private final float roll;

    private final float pitch;

    private final float yaw;

    private final List<Float> covariance;

    private ViconPositionEstimate(BigInteger usec, float x, float y, float z, float roll,
            float pitch, float yaw, List<Float> covariance) {
        this.usec = usec;
        this.x = x;
        this.y = y;
        this.z = z;
        this.roll = roll;
        this.pitch = pitch;
        this.yaw = yaw;
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
     * Timestamp (microseconds, synced to UNIX time or since system boot) 
     */
    @MavlinkFieldInfo(
            position = 0,
            unitSize = 8
    )
    public final BigInteger usec() {
        return this.usec;
    }

    /**
     * Global X position 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final float x() {
        return this.x;
    }

    /**
     * Global Y position 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float y() {
        return this.y;
    }

    /**
     * Global Z position 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float z() {
        return this.z;
    }

    /**
     * Roll angle in rad 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float roll() {
        return this.roll;
    }

    /**
     * Pitch angle in rad 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float pitch() {
        return this.pitch;
    }

    /**
     * Yaw angle in rad 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float yaw() {
        return this.yaw;
    }

    /**
     * Pose covariance matrix upper right triangular (first six entries are the first ROW, next five 
     * entries are the second ROW, etc.) 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            arraySize = 21,
            extension = true
    )
    public final List<Float> covariance() {
        return this.covariance;
    }

    public static final class Builder {
        private BigInteger usec;

        private float x;

        private float y;

        private float z;

        private float roll;

        private float pitch;

        private float yaw;

        private List<Float> covariance;

        /**
         * Timestamp (microseconds, synced to UNIX time or since system boot) 
         */
        @MavlinkFieldInfo(
                position = 0,
                unitSize = 8
        )
        public final Builder usec(BigInteger usec) {
            this.usec = usec;
            return this;
        }

        /**
         * Global X position 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
        )
        public final Builder x(float x) {
            this.x = x;
            return this;
        }

        /**
         * Global Y position 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder y(float y) {
            this.y = y;
            return this;
        }

        /**
         * Global Z position 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder z(float z) {
            this.z = z;
            return this;
        }

        /**
         * Roll angle in rad 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder roll(float roll) {
            this.roll = roll;
            return this;
        }

        /**
         * Pitch angle in rad 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder pitch(float pitch) {
            this.pitch = pitch;
            return this;
        }

        /**
         * Yaw angle in rad 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder yaw(float yaw) {
            this.yaw = yaw;
            return this;
        }

        /**
         * Pose covariance matrix upper right triangular (first six entries are the first ROW, next five 
         * entries are the second ROW, etc.) 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                arraySize = 21,
                extension = true
        )
        public final Builder covariance(List<Float> covariance) {
            this.covariance = covariance;
            return this;
        }

        public final ViconPositionEstimate build() {
            return new ViconPositionEstimate(usec, x, y, z, roll, pitch, yaw, covariance);
        }
    }
}
