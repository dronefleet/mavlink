package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Float;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Distance sensor information for an onboard rangefinder. 
 */
@MavlinkMessageInfo(
        id = 132,
        crc = 85,
        description = "Distance sensor information for an onboard rangefinder."
)
public final class DistanceSensor {
    private final long timeBootMs;

    private final int minDistance;

    private final int maxDistance;

    private final int currentDistance;

    private final EnumValue<MavDistanceSensor> type;

    private final int id;

    private final EnumValue<MavSensorOrientation> orientation;

    private final int covariance;

    private final float horizontalFov;

    private final float verticalFov;

    private final List<Float> quaternion;

    private final int signalQuality;

    private DistanceSensor(long timeBootMs, int minDistance, int maxDistance, int currentDistance,
            EnumValue<MavDistanceSensor> type, int id, EnumValue<MavSensorOrientation> orientation,
            int covariance, float horizontalFov, float verticalFov, List<Float> quaternion,
            int signalQuality) {
        this.timeBootMs = timeBootMs;
        this.minDistance = minDistance;
        this.maxDistance = maxDistance;
        this.currentDistance = currentDistance;
        this.type = type;
        this.id = id;
        this.orientation = orientation;
        this.covariance = covariance;
        this.horizontalFov = horizontalFov;
        this.verticalFov = verticalFov;
        this.quaternion = quaternion;
        this.signalQuality = signalQuality;
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
     * Minimum distance the sensor can measure 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            description = "Minimum distance the sensor can measure"
    )
    public final int minDistance() {
        return this.minDistance;
    }

    /**
     * Maximum distance the sensor can measure 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            description = "Maximum distance the sensor can measure"
    )
    public final int maxDistance() {
        return this.maxDistance;
    }

    /**
     * Current distance reading 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            description = "Current distance reading"
    )
    public final int currentDistance() {
        return this.currentDistance;
    }

    /**
     * Type of distance sensor. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            enumType = MavDistanceSensor.class,
            description = "Type of distance sensor."
    )
    public final EnumValue<MavDistanceSensor> type() {
        return this.type;
    }

    /**
     * Onboard ID of the sensor 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            description = "Onboard ID of the sensor"
    )
    public final int id() {
        return this.id;
    }

    /**
     * Direction the sensor faces. downward-facing: ROTATION_PITCH_270, upward-facing: 
     * ROTATION_PITCH_90, backward-facing: ROTATION_PITCH_180, forward-facing: 
     * ROTATION_NONE, left-facing: ROTATION_YAW_90, right-facing: ROTATION_YAW_270 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1,
            enumType = MavSensorOrientation.class,
            description = "Direction the sensor faces. downward-facing: ROTATION_PITCH_270, upward-facing: ROTATION_PITCH_90, backward-facing: ROTATION_PITCH_180, forward-facing: ROTATION_NONE, left-facing: ROTATION_YAW_90, right-facing: ROTATION_YAW_270"
    )
    public final EnumValue<MavSensorOrientation> orientation() {
        return this.orientation;
    }

    /**
     * Measurement variance. Max standard deviation is 6cm. UINT8_MAX if unknown. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1,
            description = "Measurement variance. Max standard deviation is 6cm. UINT8_MAX if unknown."
    )
    public final int covariance() {
        return this.covariance;
    }

    /**
     * Horizontal Field of View (angle) where the distance measurement is valid and the field of view 
     * is known. Otherwise this is set to 0. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            extension = true,
            description = "Horizontal Field of View (angle) where the distance measurement is valid and the field of view is known. Otherwise this is set to 0."
    )
    public final float horizontalFov() {
        return this.horizontalFov;
    }

    /**
     * Vertical Field of View (angle) where the distance measurement is valid and the field of view is 
     * known. Otherwise this is set to 0. 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            extension = true,
            description = "Vertical Field of View (angle) where the distance measurement is valid and the field of view is known. Otherwise this is set to 0."
    )
    public final float verticalFov() {
        return this.verticalFov;
    }

    /**
     * Quaternion of the sensor orientation in vehicle body frame (w, x, y, z order, zero-rotation is 
     * 1, 0, 0, 0). Zero-rotation is along the vehicle body x-axis. This field is required if the 
     * orientation is set to MAV_SENSOR_ROTATION_CUSTOM. Set it to 0 if invalid." 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4,
            arraySize = 4,
            extension = true,
            description = "Quaternion of the sensor orientation in vehicle body frame (w, x, y, z order, zero-rotation is 1, 0, 0, 0). Zero-rotation is along the vehicle body x-axis. This field is required if the orientation is set to MAV_SENSOR_ROTATION_CUSTOM. Set it to 0 if invalid.\""
    )
    public final List<Float> quaternion() {
        return this.quaternion;
    }

    /**
     * Signal quality of the sensor. Specific to each sensor type, representing the relation of the 
     * signal strength with the target reflectivity, distance, size or aspect, but normalised as a 
     * percentage. 0 = unknown/unset signal quality, 1 = invalid signal, 100 = perfect signal. 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 1,
            extension = true,
            description = "Signal quality of the sensor. Specific to each sensor type, representing the relation of the signal strength with the target reflectivity, distance, size or aspect, but normalised as a percentage. 0 = unknown/unset signal quality, 1 = invalid signal, 100 = perfect signal."
    )
    public final int signalQuality() {
        return this.signalQuality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        DistanceSensor other = (DistanceSensor)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(minDistance, other.minDistance)) return false;
        if (!Objects.deepEquals(maxDistance, other.maxDistance)) return false;
        if (!Objects.deepEquals(currentDistance, other.currentDistance)) return false;
        if (!Objects.deepEquals(type, other.type)) return false;
        if (!Objects.deepEquals(id, other.id)) return false;
        if (!Objects.deepEquals(orientation, other.orientation)) return false;
        if (!Objects.deepEquals(covariance, other.covariance)) return false;
        if (!Objects.deepEquals(horizontalFov, other.horizontalFov)) return false;
        if (!Objects.deepEquals(verticalFov, other.verticalFov)) return false;
        if (!Objects.deepEquals(quaternion, other.quaternion)) return false;
        if (!Objects.deepEquals(signalQuality, other.signalQuality)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(minDistance);
        result = 31 * result + Objects.hashCode(maxDistance);
        result = 31 * result + Objects.hashCode(currentDistance);
        result = 31 * result + Objects.hashCode(type);
        result = 31 * result + Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(orientation);
        result = 31 * result + Objects.hashCode(covariance);
        result = 31 * result + Objects.hashCode(horizontalFov);
        result = 31 * result + Objects.hashCode(verticalFov);
        result = 31 * result + Objects.hashCode(quaternion);
        result = 31 * result + Objects.hashCode(signalQuality);
        return result;
    }

    @Override
    public String toString() {
        return "DistanceSensor{timeBootMs=" + timeBootMs
                 + ", minDistance=" + minDistance
                 + ", maxDistance=" + maxDistance
                 + ", currentDistance=" + currentDistance
                 + ", type=" + type
                 + ", id=" + id
                 + ", orientation=" + orientation
                 + ", covariance=" + covariance
                 + ", horizontalFov=" + horizontalFov
                 + ", verticalFov=" + verticalFov
                 + ", quaternion=" + quaternion
                 + ", signalQuality=" + signalQuality + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private int minDistance;

        private int maxDistance;

        private int currentDistance;

        private EnumValue<MavDistanceSensor> type;

        private int id;

        private EnumValue<MavSensorOrientation> orientation;

        private int covariance;

        private float horizontalFov;

        private float verticalFov;

        private List<Float> quaternion;

        private int signalQuality;

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
         * Minimum distance the sensor can measure 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                description = "Minimum distance the sensor can measure"
        )
        public final Builder minDistance(int minDistance) {
            this.minDistance = minDistance;
            return this;
        }

        /**
         * Maximum distance the sensor can measure 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                description = "Maximum distance the sensor can measure"
        )
        public final Builder maxDistance(int maxDistance) {
            this.maxDistance = maxDistance;
            return this;
        }

        /**
         * Current distance reading 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                description = "Current distance reading"
        )
        public final Builder currentDistance(int currentDistance) {
            this.currentDistance = currentDistance;
            return this;
        }

        /**
         * Type of distance sensor. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                enumType = MavDistanceSensor.class,
                description = "Type of distance sensor."
        )
        public final Builder type(EnumValue<MavDistanceSensor> type) {
            this.type = type;
            return this;
        }

        /**
         * Type of distance sensor. 
         */
        public final Builder type(MavDistanceSensor entry) {
            return type(EnumValue.of(entry));
        }

        /**
         * Type of distance sensor. 
         */
        public final Builder type(Enum... flags) {
            return type(EnumValue.create(flags));
        }

        /**
         * Type of distance sensor. 
         */
        public final Builder type(Collection<Enum> flags) {
            return type(EnumValue.create(flags));
        }

        /**
         * Onboard ID of the sensor 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                description = "Onboard ID of the sensor"
        )
        public final Builder id(int id) {
            this.id = id;
            return this;
        }

        /**
         * Direction the sensor faces. downward-facing: ROTATION_PITCH_270, upward-facing: 
         * ROTATION_PITCH_90, backward-facing: ROTATION_PITCH_180, forward-facing: 
         * ROTATION_NONE, left-facing: ROTATION_YAW_90, right-facing: ROTATION_YAW_270 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1,
                enumType = MavSensorOrientation.class,
                description = "Direction the sensor faces. downward-facing: ROTATION_PITCH_270, upward-facing: ROTATION_PITCH_90, backward-facing: ROTATION_PITCH_180, forward-facing: ROTATION_NONE, left-facing: ROTATION_YAW_90, right-facing: ROTATION_YAW_270"
        )
        public final Builder orientation(EnumValue<MavSensorOrientation> orientation) {
            this.orientation = orientation;
            return this;
        }

        /**
         * Direction the sensor faces. downward-facing: ROTATION_PITCH_270, upward-facing: 
         * ROTATION_PITCH_90, backward-facing: ROTATION_PITCH_180, forward-facing: 
         * ROTATION_NONE, left-facing: ROTATION_YAW_90, right-facing: ROTATION_YAW_270 
         */
        public final Builder orientation(MavSensorOrientation entry) {
            return orientation(EnumValue.of(entry));
        }

        /**
         * Direction the sensor faces. downward-facing: ROTATION_PITCH_270, upward-facing: 
         * ROTATION_PITCH_90, backward-facing: ROTATION_PITCH_180, forward-facing: 
         * ROTATION_NONE, left-facing: ROTATION_YAW_90, right-facing: ROTATION_YAW_270 
         */
        public final Builder orientation(Enum... flags) {
            return orientation(EnumValue.create(flags));
        }

        /**
         * Direction the sensor faces. downward-facing: ROTATION_PITCH_270, upward-facing: 
         * ROTATION_PITCH_90, backward-facing: ROTATION_PITCH_180, forward-facing: 
         * ROTATION_NONE, left-facing: ROTATION_YAW_90, right-facing: ROTATION_YAW_270 
         */
        public final Builder orientation(Collection<Enum> flags) {
            return orientation(EnumValue.create(flags));
        }

        /**
         * Measurement variance. Max standard deviation is 6cm. UINT8_MAX if unknown. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 1,
                description = "Measurement variance. Max standard deviation is 6cm. UINT8_MAX if unknown."
        )
        public final Builder covariance(int covariance) {
            this.covariance = covariance;
            return this;
        }

        /**
         * Horizontal Field of View (angle) where the distance measurement is valid and the field of view 
         * is known. Otherwise this is set to 0. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                extension = true,
                description = "Horizontal Field of View (angle) where the distance measurement is valid and the field of view is known. Otherwise this is set to 0."
        )
        public final Builder horizontalFov(float horizontalFov) {
            this.horizontalFov = horizontalFov;
            return this;
        }

        /**
         * Vertical Field of View (angle) where the distance measurement is valid and the field of view is 
         * known. Otherwise this is set to 0. 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                extension = true,
                description = "Vertical Field of View (angle) where the distance measurement is valid and the field of view is known. Otherwise this is set to 0."
        )
        public final Builder verticalFov(float verticalFov) {
            this.verticalFov = verticalFov;
            return this;
        }

        /**
         * Quaternion of the sensor orientation in vehicle body frame (w, x, y, z order, zero-rotation is 
         * 1, 0, 0, 0). Zero-rotation is along the vehicle body x-axis. This field is required if the 
         * orientation is set to MAV_SENSOR_ROTATION_CUSTOM. Set it to 0 if invalid." 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4,
                arraySize = 4,
                extension = true,
                description = "Quaternion of the sensor orientation in vehicle body frame (w, x, y, z order, zero-rotation is 1, 0, 0, 0). Zero-rotation is along the vehicle body x-axis. This field is required if the orientation is set to MAV_SENSOR_ROTATION_CUSTOM. Set it to 0 if invalid.\""
        )
        public final Builder quaternion(List<Float> quaternion) {
            this.quaternion = quaternion;
            return this;
        }

        /**
         * Signal quality of the sensor. Specific to each sensor type, representing the relation of the 
         * signal strength with the target reflectivity, distance, size or aspect, but normalised as a 
         * percentage. 0 = unknown/unset signal quality, 1 = invalid signal, 100 = perfect signal. 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 1,
                extension = true,
                description = "Signal quality of the sensor. Specific to each sensor type, representing the relation of the signal strength with the target reflectivity, distance, size or aspect, but normalised as a percentage. 0 = unknown/unset signal quality, 1 = invalid signal, 100 = perfect signal."
        )
        public final Builder signalQuality(int signalQuality) {
            this.signalQuality = signalQuality;
            return this;
        }

        public final DistanceSensor build() {
            return new DistanceSensor(timeBootMs, minDistance, maxDistance, currentDistance, type, id, orientation, covariance, horizontalFov, verticalFov, quaternion, signalQuality);
        }
    }
}
