package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Obstacle distances in front of the sensor, starting from the left in increment degrees to the 
 * right 
 */
@MavlinkMessageInfo(
        id = 330,
        crc = 23,
        description = "Obstacle distances in front of the sensor, starting from the left in increment degrees to the right"
)
public final class ObstacleDistance {
    private final BigInteger timeUsec;

    private final EnumValue<MavDistanceSensor> sensorType;

    private final List<Integer> distances;

    private final int increment;

    private final int minDistance;

    private final int maxDistance;

    private final float incrementF;

    private final float angleOffset;

    private final EnumValue<MavFrame> frame;

    private ObstacleDistance(BigInteger timeUsec, EnumValue<MavDistanceSensor> sensorType,
            List<Integer> distances, int increment, int minDistance, int maxDistance,
            float incrementF, float angleOffset, EnumValue<MavFrame> frame) {
        this.timeUsec = timeUsec;
        this.sensorType = sensorType;
        this.distances = distances;
        this.increment = increment;
        this.minDistance = minDistance;
        this.maxDistance = maxDistance;
        this.incrementF = incrementF;
        this.angleOffset = angleOffset;
        this.frame = frame;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
     * format (since 1.1.1970 or since system boot) by checking for the magnitude the number. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude the number."
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * Class id of the distance sensor type. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = MavDistanceSensor.class,
            description = "Class id of the distance sensor type."
    )
    public final EnumValue<MavDistanceSensor> sensorType() {
        return this.sensorType;
    }

    /**
     * Distance of obstacles around the vehicle with index 0 corresponding to north + angle_offset, 
     * unless otherwise specified in the frame. A value of 0 is valid and means that the obstacle is 
     * practically touching the sensor. A value of max_distance +1 means no obstacle is present. A 
     * value of UINT16_MAX for unknown/not used. In a array element, one unit corresponds to 1cm. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            arraySize = 72,
            description = "Distance of obstacles around the vehicle with index 0 corresponding to north + angle_offset, unless otherwise specified in the frame. A value of 0 is valid and means that the obstacle is practically touching the sensor. A value of max_distance +1 means no obstacle is present. A value of UINT16_MAX for unknown/not used. In a array element, one unit corresponds to 1cm."
    )
    public final List<Integer> distances() {
        return this.distances;
    }

    /**
     * Angular width in degrees of each array element. Increment direction is clockwise. This field 
     * is ignored if increment_f is non-zero. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "Angular width in degrees of each array element. Increment direction is clockwise. This field is ignored if increment_f is non-zero."
    )
    public final int increment() {
        return this.increment;
    }

    /**
     * Minimum distance the sensor can measure. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            description = "Minimum distance the sensor can measure."
    )
    public final int minDistance() {
        return this.minDistance;
    }

    /**
     * Maximum distance the sensor can measure. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            description = "Maximum distance the sensor can measure."
    )
    public final int maxDistance() {
        return this.maxDistance;
    }

    /**
     * Angular width in degrees of each array element as a float. If non-zero then this value is used 
     * instead of the uint8_t increment field. Positive is clockwise direction, negative is 
     * counter-clockwise. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            extension = true,
            description = "Angular width in degrees of each array element as a float. If non-zero then this value is used instead of the uint8_t increment field. Positive is clockwise direction, negative is counter-clockwise."
    )
    public final float incrementF() {
        return this.incrementF;
    }

    /**
     * Relative angle offset of the 0-index element in the distances array. Value of 0 corresponds to 
     * forward. Positive is clockwise direction, negative is counter-clockwise. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            extension = true,
            description = "Relative angle offset of the 0-index element in the distances array. Value of 0 corresponds to forward. Positive is clockwise direction, negative is counter-clockwise."
    )
    public final float angleOffset() {
        return this.angleOffset;
    }

    /**
     * Coordinate frame of reference for the yaw rotation and offset of the sensor data. Defaults to 
     * MAV_FRAME_GLOBAL, which is north aligned. For body-mounted sensors use 
     * MAV_FRAME_BODY_FRD, which is vehicle front aligned. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1,
            enumType = MavFrame.class,
            extension = true,
            description = "Coordinate frame of reference for the yaw rotation and offset of the sensor data. Defaults to MAV_FRAME_GLOBAL, which is north aligned. For body-mounted sensors use MAV_FRAME_BODY_FRD, which is vehicle front aligned."
    )
    public final EnumValue<MavFrame> frame() {
        return this.frame;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ObstacleDistance other = (ObstacleDistance)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(sensorType, other.sensorType)) return false;
        if (!Objects.deepEquals(distances, other.distances)) return false;
        if (!Objects.deepEquals(increment, other.increment)) return false;
        if (!Objects.deepEquals(minDistance, other.minDistance)) return false;
        if (!Objects.deepEquals(maxDistance, other.maxDistance)) return false;
        if (!Objects.deepEquals(incrementF, other.incrementF)) return false;
        if (!Objects.deepEquals(angleOffset, other.angleOffset)) return false;
        if (!Objects.deepEquals(frame, other.frame)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(sensorType);
        result = 31 * result + Objects.hashCode(distances);
        result = 31 * result + Objects.hashCode(increment);
        result = 31 * result + Objects.hashCode(minDistance);
        result = 31 * result + Objects.hashCode(maxDistance);
        result = 31 * result + Objects.hashCode(incrementF);
        result = 31 * result + Objects.hashCode(angleOffset);
        result = 31 * result + Objects.hashCode(frame);
        return result;
    }

    @Override
    public String toString() {
        return "ObstacleDistance{timeUsec=" + timeUsec
                 + ", sensorType=" + sensorType
                 + ", distances=" + distances
                 + ", increment=" + increment
                 + ", minDistance=" + minDistance
                 + ", maxDistance=" + maxDistance
                 + ", incrementF=" + incrementF
                 + ", angleOffset=" + angleOffset
                 + ", frame=" + frame + "}";
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private EnumValue<MavDistanceSensor> sensorType;

        private List<Integer> distances;

        private int increment;

        private int minDistance;

        private int maxDistance;

        private float incrementF;

        private float angleOffset;

        private EnumValue<MavFrame> frame;

        /**
         * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
         * format (since 1.1.1970 or since system boot) by checking for the magnitude the number. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude the number."
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * Class id of the distance sensor type. 
         */
        @MavlinkFieldInfo(
                position = 2,
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
         * Distance of obstacles around the vehicle with index 0 corresponding to north + angle_offset, 
         * unless otherwise specified in the frame. A value of 0 is valid and means that the obstacle is 
         * practically touching the sensor. A value of max_distance +1 means no obstacle is present. A 
         * value of UINT16_MAX for unknown/not used. In a array element, one unit corresponds to 1cm. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                arraySize = 72,
                description = "Distance of obstacles around the vehicle with index 0 corresponding to north + angle_offset, unless otherwise specified in the frame. A value of 0 is valid and means that the obstacle is practically touching the sensor. A value of max_distance +1 means no obstacle is present. A value of UINT16_MAX for unknown/not used. In a array element, one unit corresponds to 1cm."
        )
        public final Builder distances(List<Integer> distances) {
            this.distances = distances;
            return this;
        }

        /**
         * Angular width in degrees of each array element. Increment direction is clockwise. This field 
         * is ignored if increment_f is non-zero. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "Angular width in degrees of each array element. Increment direction is clockwise. This field is ignored if increment_f is non-zero."
        )
        public final Builder increment(int increment) {
            this.increment = increment;
            return this;
        }

        /**
         * Minimum distance the sensor can measure. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                description = "Minimum distance the sensor can measure."
        )
        public final Builder minDistance(int minDistance) {
            this.minDistance = minDistance;
            return this;
        }

        /**
         * Maximum distance the sensor can measure. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                description = "Maximum distance the sensor can measure."
        )
        public final Builder maxDistance(int maxDistance) {
            this.maxDistance = maxDistance;
            return this;
        }

        /**
         * Angular width in degrees of each array element as a float. If non-zero then this value is used 
         * instead of the uint8_t increment field. Positive is clockwise direction, negative is 
         * counter-clockwise. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                extension = true,
                description = "Angular width in degrees of each array element as a float. If non-zero then this value is used instead of the uint8_t increment field. Positive is clockwise direction, negative is counter-clockwise."
        )
        public final Builder incrementF(float incrementF) {
            this.incrementF = incrementF;
            return this;
        }

        /**
         * Relative angle offset of the 0-index element in the distances array. Value of 0 corresponds to 
         * forward. Positive is clockwise direction, negative is counter-clockwise. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                extension = true,
                description = "Relative angle offset of the 0-index element in the distances array. Value of 0 corresponds to forward. Positive is clockwise direction, negative is counter-clockwise."
        )
        public final Builder angleOffset(float angleOffset) {
            this.angleOffset = angleOffset;
            return this;
        }

        /**
         * Coordinate frame of reference for the yaw rotation and offset of the sensor data. Defaults to 
         * MAV_FRAME_GLOBAL, which is north aligned. For body-mounted sensors use 
         * MAV_FRAME_BODY_FRD, which is vehicle front aligned. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 1,
                enumType = MavFrame.class,
                extension = true,
                description = "Coordinate frame of reference for the yaw rotation and offset of the sensor data. Defaults to MAV_FRAME_GLOBAL, which is north aligned. For body-mounted sensors use MAV_FRAME_BODY_FRD, which is vehicle front aligned."
        )
        public final Builder frame(EnumValue<MavFrame> frame) {
            this.frame = frame;
            return this;
        }

        /**
         * Coordinate frame of reference for the yaw rotation and offset of the sensor data. Defaults to 
         * MAV_FRAME_GLOBAL, which is north aligned. For body-mounted sensors use 
         * MAV_FRAME_BODY_FRD, which is vehicle front aligned. 
         */
        public final Builder frame(MavFrame entry) {
            return frame(EnumValue.of(entry));
        }

        /**
         * Coordinate frame of reference for the yaw rotation and offset of the sensor data. Defaults to 
         * MAV_FRAME_GLOBAL, which is north aligned. For body-mounted sensors use 
         * MAV_FRAME_BODY_FRD, which is vehicle front aligned. 
         */
        public final Builder frame(Enum... flags) {
            return frame(EnumValue.create(flags));
        }

        /**
         * Coordinate frame of reference for the yaw rotation and offset of the sensor data. Defaults to 
         * MAV_FRAME_GLOBAL, which is north aligned. For body-mounted sensors use 
         * MAV_FRAME_BODY_FRD, which is vehicle front aligned. 
         */
        public final Builder frame(Collection<Enum> flags) {
            return frame(EnumValue.create(flags));
        }

        public final ObstacleDistance build() {
            return new ObstacleDistance(timeUsec, sensorType, distances, increment, minDistance, maxDistance, incrementF, angleOffset, frame);
        }
    }
}
