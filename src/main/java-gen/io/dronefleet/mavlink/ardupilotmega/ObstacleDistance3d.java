package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.common.MavDistanceSensor;
import io.dronefleet.mavlink.common.MavFrame;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Deprecated;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * Obstacle located as a 3D vector. 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 11037,
        crc = 130,
        description = "Obstacle located as a 3D vector.",
        workInProgress = true
)
@Deprecated
public final class ObstacleDistance3d {
    private final long timeBootMs;

    private final EnumValue<MavDistanceSensor> sensorType;

    private final EnumValue<MavFrame> frame;

    private final int obstacleId;

    private final float x;

    private final float y;

    private final float z;

    private final float minDistance;

    private final float maxDistance;

    private ObstacleDistance3d(long timeBootMs, EnumValue<MavDistanceSensor> sensorType,
            EnumValue<MavFrame> frame, int obstacleId, float x, float y, float z, float minDistance,
            float maxDistance) {
        this.timeBootMs = timeBootMs;
        this.sensorType = sensorType;
        this.frame = frame;
        this.obstacleId = obstacleId;
        this.x = x;
        this.y = y;
        this.z = z;
        this.minDistance = minDistance;
        this.maxDistance = maxDistance;
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
            position = 2,
            unitSize = 4,
            description = "Timestamp (time since system boot)."
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * Class id of the distance sensor type. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            enumType = MavDistanceSensor.class,
            description = "Class id of the distance sensor type."
    )
    public final EnumValue<MavDistanceSensor> sensorType() {
        return this.sensorType;
    }

    /**
     * Coordinate frame of reference. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            enumType = MavFrame.class,
            description = "Coordinate frame of reference."
    )
    public final EnumValue<MavFrame> frame() {
        return this.frame;
    }

    /**
     * Unique ID given to each obstacle so that its movement can be tracked. Use UINT16_MAX if object ID 
     * is unknown or cannot be determined. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            description = "Unique ID given to each obstacle so that its movement can be tracked. Use UINT16_MAX if object ID is unknown or cannot be determined."
    )
    public final int obstacleId() {
        return this.obstacleId;
    }

    /**
     * X position of the obstacle. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "X position of the obstacle."
    )
    public final float x() {
        return this.x;
    }

    /**
     * Y position of the obstacle. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Y position of the obstacle."
    )
    public final float y() {
        return this.y;
    }

    /**
     * Z position of the obstacle. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Z position of the obstacle."
    )
    public final float z() {
        return this.z;
    }

    /**
     * Minimum distance the sensor can measure. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Minimum distance the sensor can measure."
    )
    public final float minDistance() {
        return this.minDistance;
    }

    /**
     * Maximum distance the sensor can measure. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "Maximum distance the sensor can measure."
    )
    public final float maxDistance() {
        return this.maxDistance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ObstacleDistance3d other = (ObstacleDistance3d)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(sensorType, other.sensorType)) return false;
        if (!Objects.deepEquals(frame, other.frame)) return false;
        if (!Objects.deepEquals(obstacleId, other.obstacleId)) return false;
        if (!Objects.deepEquals(x, other.x)) return false;
        if (!Objects.deepEquals(y, other.y)) return false;
        if (!Objects.deepEquals(z, other.z)) return false;
        if (!Objects.deepEquals(minDistance, other.minDistance)) return false;
        if (!Objects.deepEquals(maxDistance, other.maxDistance)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(sensorType);
        result = 31 * result + Objects.hashCode(frame);
        result = 31 * result + Objects.hashCode(obstacleId);
        result = 31 * result + Objects.hashCode(x);
        result = 31 * result + Objects.hashCode(y);
        result = 31 * result + Objects.hashCode(z);
        result = 31 * result + Objects.hashCode(minDistance);
        result = 31 * result + Objects.hashCode(maxDistance);
        return result;
    }

    @Override
    public String toString() {
        return "ObstacleDistance3d{timeBootMs=" + timeBootMs
                 + ", sensorType=" + sensorType
                 + ", frame=" + frame
                 + ", obstacleId=" + obstacleId
                 + ", x=" + x
                 + ", y=" + y
                 + ", z=" + z
                 + ", minDistance=" + minDistance
                 + ", maxDistance=" + maxDistance + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private EnumValue<MavDistanceSensor> sensorType;

        private EnumValue<MavFrame> frame;

        private int obstacleId;

        private float x;

        private float y;

        private float z;

        private float minDistance;

        private float maxDistance;

        /**
         * Timestamp (time since system boot). 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Timestamp (time since system boot)."
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * Class id of the distance sensor type. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                enumType = MavDistanceSensor.class,
                description = "Class id of the distance sensor type."
        )
        public final Builder sensorType(EnumValue<MavDistanceSensor> sensorType) {
            this.sensorType = sensorType;
            return this;
        }

        /**
         * Class id of the distance sensor type. 
         */
        public final Builder sensorType(MavDistanceSensor entry) {
            return sensorType(EnumValue.of(entry));
        }

        /**
         * Class id of the distance sensor type. 
         */
        public final Builder sensorType(Enum... flags) {
            return sensorType(EnumValue.create(flags));
        }

        /**
         * Class id of the distance sensor type. 
         */
        public final Builder sensorType(Collection<Enum> flags) {
            return sensorType(EnumValue.create(flags));
        }

        /**
         * Coordinate frame of reference. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                enumType = MavFrame.class,
                description = "Coordinate frame of reference."
        )
        public final Builder frame(EnumValue<MavFrame> frame) {
            this.frame = frame;
            return this;
        }

        /**
         * Coordinate frame of reference. 
         */
        public final Builder frame(MavFrame entry) {
            return frame(EnumValue.of(entry));
        }

        /**
         * Coordinate frame of reference. 
         */
        public final Builder frame(Enum... flags) {
            return frame(EnumValue.create(flags));
        }

        /**
         * Coordinate frame of reference. 
         */
        public final Builder frame(Collection<Enum> flags) {
            return frame(EnumValue.create(flags));
        }

        /**
         * Unique ID given to each obstacle so that its movement can be tracked. Use UINT16_MAX if object ID 
         * is unknown or cannot be determined. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                description = "Unique ID given to each obstacle so that its movement can be tracked. Use UINT16_MAX if object ID is unknown or cannot be determined."
        )
        public final Builder obstacleId(int obstacleId) {
            this.obstacleId = obstacleId;
            return this;
        }

        /**
         * X position of the obstacle. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "X position of the obstacle."
        )
        public final Builder x(float x) {
            this.x = x;
            return this;
        }

        /**
         * Y position of the obstacle. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Y position of the obstacle."
        )
        public final Builder y(float y) {
            this.y = y;
            return this;
        }

        /**
         * Z position of the obstacle. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Z position of the obstacle."
        )
        public final Builder z(float z) {
            this.z = z;
            return this;
        }

        /**
         * Minimum distance the sensor can measure. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Minimum distance the sensor can measure."
        )
        public final Builder minDistance(float minDistance) {
            this.minDistance = minDistance;
            return this;
        }

        /**
         * Maximum distance the sensor can measure. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "Maximum distance the sensor can measure."
        )
        public final Builder maxDistance(float maxDistance) {
            this.maxDistance = maxDistance;
            return this;
        }

        public final ObstacleDistance3d build() {
            return new ObstacleDistance3d(timeBootMs, sensorType, frame, obstacleId, x, y, z, minDistance, maxDistance);
        }
    }
}
