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

    private ObstacleDistance(BigInteger timeUsec, EnumValue<MavDistanceSensor> sensorType,
            List<Integer> distances, int increment, int minDistance, int maxDistance) {
        this.timeUsec = timeUsec;
        this.sensorType = sensorType;
        this.distances = distances;
        this.increment = increment;
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
     * Timestamp (microseconds since system boot or since UNIX epoch). 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            description = "Timestamp (microseconds since system boot or since UNIX epoch)."
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
     * Distance of obstacles around the UAV with index 0 corresponding to local North. A value of 0 
     * means that the obstacle is right in front of the sensor. A value of max_distance +1 means no 
     * obstacle is present. A value of UINT16_MAX for unknown/not used. In a array element, one unit 
     * corresponds to 1cm. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            arraySize = 72,
            description = "Distance of obstacles around the UAV with index 0 corresponding to local North. A value of 0 means that the obstacle is right in front of the sensor. A value of max_distance +1 means no obstacle is present. A value of UINT16_MAX for unknown/not used. In a array element, one unit corresponds to 1cm."
    )
    public final List<Integer> distances() {
        return this.distances;
    }

    /**
     * Angular width in degrees of each array element. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "Angular width in degrees of each array element."
    )
    public final int increment() {
        return this.increment;
    }

    /**
     * Minimum distance the sensor can measure in centimeters. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            description = "Minimum distance the sensor can measure in centimeters."
    )
    public final int minDistance() {
        return this.minDistance;
    }

    /**
     * Maximum distance the sensor can measure in centimeters. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            description = "Maximum distance the sensor can measure in centimeters."
    )
    public final int maxDistance() {
        return this.maxDistance;
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
        return result;
    }

    @Override
    public String toString() {
        return "ObstacleDistance{timeUsec=" + timeUsec
                 + ", sensorType=" + sensorType
                 + ", distances=" + distances
                 + ", increment=" + increment
                 + ", minDistance=" + minDistance
                 + ", maxDistance=" + maxDistance + "}";
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private EnumValue<MavDistanceSensor> sensorType;

        private List<Integer> distances;

        private int increment;

        private int minDistance;

        private int maxDistance;

        /**
         * Timestamp (microseconds since system boot or since UNIX epoch). 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                description = "Timestamp (microseconds since system boot or since UNIX epoch)."
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
         * Distance of obstacles around the UAV with index 0 corresponding to local North. A value of 0 
         * means that the obstacle is right in front of the sensor. A value of max_distance +1 means no 
         * obstacle is present. A value of UINT16_MAX for unknown/not used. In a array element, one unit 
         * corresponds to 1cm. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                arraySize = 72,
                description = "Distance of obstacles around the UAV with index 0 corresponding to local North. A value of 0 means that the obstacle is right in front of the sensor. A value of max_distance +1 means no obstacle is present. A value of UINT16_MAX for unknown/not used. In a array element, one unit corresponds to 1cm."
        )
        public final Builder distances(List<Integer> distances) {
            this.distances = distances;
            return this;
        }

        /**
         * Angular width in degrees of each array element. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "Angular width in degrees of each array element."
        )
        public final Builder increment(int increment) {
            this.increment = increment;
            return this;
        }

        /**
         * Minimum distance the sensor can measure in centimeters. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                description = "Minimum distance the sensor can measure in centimeters."
        )
        public final Builder minDistance(int minDistance) {
            this.minDistance = minDistance;
            return this;
        }

        /**
         * Maximum distance the sensor can measure in centimeters. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                description = "Maximum distance the sensor can measure in centimeters."
        )
        public final Builder maxDistance(int maxDistance) {
            this.maxDistance = maxDistance;
            return this;
        }

        public final ObstacleDistance build() {
            return new ObstacleDistance(timeUsec, sensorType, distances, increment, minDistance, maxDistance);
        }
    }
}
