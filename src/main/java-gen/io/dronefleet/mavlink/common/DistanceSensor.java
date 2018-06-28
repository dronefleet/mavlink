package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 *  
 */
@MavlinkMessageInfo(
        id = 132,
        crc = 85
)
public final class DistanceSensor {
    private final long timeBootMs;

    private final int minDistance;

    private final int maxDistance;

    private final int currentDistance;

    private final MavDistanceSensor type;

    private final int id;

    private final MavSensorOrientation orientation;

    private final int covariance;

    private DistanceSensor(long timeBootMs, int minDistance, int maxDistance, int currentDistance,
            MavDistanceSensor type, int id, MavSensorOrientation orientation, int covariance) {
        this.timeBootMs = timeBootMs;
        this.minDistance = minDistance;
        this.maxDistance = maxDistance;
        this.currentDistance = currentDistance;
        this.type = type;
        this.id = id;
        this.orientation = orientation;
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
     * Time since system boot 
     */
    @MavlinkFieldInfo(
            position = 0,
            unitSize = 4
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * Minimum distance the sensor can measure in centimeters 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 2
    )
    public final int minDistance() {
        return this.minDistance;
    }

    /**
     * Maximum distance the sensor can measure in centimeters 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2
    )
    public final int maxDistance() {
        return this.maxDistance;
    }

    /**
     * Current distance reading 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2
    )
    public final int currentDistance() {
        return this.currentDistance;
    }

    /**
     * Type from {@link io.dronefleet.mavlink.common.MavDistanceSensor MAV_DISTANCE_SENSOR} enum. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final MavDistanceSensor type() {
        return this.type;
    }

    /**
     * Onboard ID of the sensor 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final int id() {
        return this.id;
    }

    /**
     * Direction the sensor faces from {@link io.dronefleet.mavlink.common.MavSensorOrientation MAV_SENSOR_ORIENTATION} enum. downward-facing: 
     * ROTATION_PITCH_270, upward-facing: ROTATION_PITCH_90, backward-facing: 
     * ROTATION_PITCH_180, forward-facing: ROTATION_NONE, left-facing: ROTATION_YAW_90, 
     * right-facing: ROTATION_YAW_270 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1
    )
    public final MavSensorOrientation orientation() {
        return this.orientation;
    }

    /**
     * Measurement covariance in centimeters, 0 for unknown / invalid readings 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1
    )
    public final int covariance() {
        return this.covariance;
    }

    public static final class Builder {
        private long timeBootMs;

        private int minDistance;

        private int maxDistance;

        private int currentDistance;

        private MavDistanceSensor type;

        private int id;

        private MavSensorOrientation orientation;

        private int covariance;

        /**
         * Time since system boot 
         */
        @MavlinkFieldInfo(
                position = 0,
                unitSize = 4
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * Minimum distance the sensor can measure in centimeters 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 2
        )
        public final Builder minDistance(int minDistance) {
            this.minDistance = minDistance;
            return this;
        }

        /**
         * Maximum distance the sensor can measure in centimeters 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2
        )
        public final Builder maxDistance(int maxDistance) {
            this.maxDistance = maxDistance;
            return this;
        }

        /**
         * Current distance reading 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2
        )
        public final Builder currentDistance(int currentDistance) {
            this.currentDistance = currentDistance;
            return this;
        }

        /**
         * Type from {@link io.dronefleet.mavlink.common.MavDistanceSensor MAV_DISTANCE_SENSOR} enum. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1
        )
        public final Builder type(MavDistanceSensor type) {
            this.type = type;
            return this;
        }

        /**
         * Onboard ID of the sensor 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1
        )
        public final Builder id(int id) {
            this.id = id;
            return this;
        }

        /**
         * Direction the sensor faces from {@link io.dronefleet.mavlink.common.MavSensorOrientation MAV_SENSOR_ORIENTATION} enum. downward-facing: 
         * ROTATION_PITCH_270, upward-facing: ROTATION_PITCH_90, backward-facing: 
         * ROTATION_PITCH_180, forward-facing: ROTATION_NONE, left-facing: ROTATION_YAW_90, 
         * right-facing: ROTATION_YAW_270 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1
        )
        public final Builder orientation(MavSensorOrientation orientation) {
            this.orientation = orientation;
            return this;
        }

        /**
         * Measurement covariance in centimeters, 0 for unknown / invalid readings 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1
        )
        public final Builder covariance(int covariance) {
            this.covariance = covariance;
            return this;
        }

        public final DistanceSensor build() {
            return new DistanceSensor(timeBootMs, minDistance, maxDistance, currentDistance, type, id, orientation, covariance);
        }
    }
}
