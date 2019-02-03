package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Double;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

/**
 * Cumulative distance traveled for each reported wheel. 
 */
@MavlinkMessageInfo(
        id = 9000,
        crc = 113,
        description = "Cumulative distance traveled for each reported wheel."
)
public final class WheelDistance {
    private final BigInteger timeUsec;

    private final int count;

    private final List<Double> distance;

    private WheelDistance(BigInteger timeUsec, int count, List<Double> distance) {
        this.timeUsec = timeUsec;
        this.count = count;
        this.distance = distance;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (synced to UNIX time or since system boot). 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            description = "Timestamp (synced to UNIX time or since system boot)."
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * Number of wheels reported. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Number of wheels reported."
    )
    public final int count() {
        return this.count;
    }

    /**
     * Distance reported by individual wheel encoders. Forward rotations increase values, reverse 
     * rotations decrease them. Not all wheels will necessarily have wheel encoders; the mapping of 
     * encoders to wheel positions must be agreed/understood by the endpoints. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 8,
            arraySize = 16,
            description = "Distance reported by individual wheel encoders. Forward rotations increase values, reverse rotations decrease them. Not all wheels will necessarily have wheel encoders; the mapping of encoders to wheel positions must be agreed/understood by the endpoints."
    )
    public final List<Double> distance() {
        return this.distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        WheelDistance other = (WheelDistance)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(count, other.count)) return false;
        if (!Objects.deepEquals(distance, other.distance)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(count);
        result = 31 * result + Objects.hashCode(distance);
        return result;
    }

    @Override
    public String toString() {
        return "WheelDistance{timeUsec=" + timeUsec
                 + ", count=" + count
                 + ", distance=" + distance + "}";
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private int count;

        private List<Double> distance;

        /**
         * Timestamp (synced to UNIX time or since system boot). 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                description = "Timestamp (synced to UNIX time or since system boot)."
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * Number of wheels reported. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Number of wheels reported."
        )
        public final Builder count(int count) {
            this.count = count;
            return this;
        }

        /**
         * Distance reported by individual wheel encoders. Forward rotations increase values, reverse 
         * rotations decrease them. Not all wheels will necessarily have wheel encoders; the mapping of 
         * encoders to wheel positions must be agreed/understood by the endpoints. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 8,
                arraySize = 16,
                description = "Distance reported by individual wheel encoders. Forward rotations increase values, reverse rotations decrease them. Not all wheels will necessarily have wheel encoders; the mapping of encoders to wheel positions must be agreed/understood by the endpoints."
        )
        public final Builder distance(List<Double> distance) {
            this.distance = distance;
            return this;
        }

        public final WheelDistance build() {
            return new WheelDistance(timeUsec, count, distance);
        }
    }
}
