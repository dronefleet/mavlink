package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Float;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

/**
 * Speed estimate from a vision source. 
 */
@MavlinkMessageInfo(
        id = 103,
        crc = 208,
        description = "Speed estimate from a vision source."
)
public final class VisionSpeedEstimate {
    private final BigInteger usec;

    private final float x;

    private final float y;

    private final float z;

    private final List<Float> covariance;

    private final int resetCounter;

    private VisionSpeedEstimate(BigInteger usec, float x, float y, float z, List<Float> covariance,
            int resetCounter) {
        this.usec = usec;
        this.x = x;
        this.y = y;
        this.z = z;
        this.covariance = covariance;
        this.resetCounter = resetCounter;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (UNIX time or time since system boot) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            description = "Timestamp (UNIX time or time since system boot)"
    )
    public final BigInteger usec() {
        return this.usec;
    }

    /**
     * Global X speed 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Global X speed"
    )
    public final float x() {
        return this.x;
    }

    /**
     * Global Y speed 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Global Y speed"
    )
    public final float y() {
        return this.y;
    }

    /**
     * Global Z speed 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Global Z speed"
    )
    public final float z() {
        return this.z;
    }

    /**
     * Row-major representation of 3x3 linear velocity covariance matrix (states: vx, vy, vz; 1st 
     * three entries - 1st row, etc.). If unknown, assign NaN value to first element in the array. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            arraySize = 9,
            extension = true,
            description = "Row-major representation of 3x3 linear velocity covariance matrix (states: vx, vy, vz; 1st three entries - 1st row, etc.). If unknown, assign NaN value to first element in the array."
    )
    public final List<Float> covariance() {
        return this.covariance;
    }

    /**
     * Estimate reset counter. This should be incremented when the estimate resets in any of the 
     * dimensions (position, velocity, attitude, angular speed). This is designed to be used when 
     * e.g an external SLAM system detects a loop-closure and the estimate jumps. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1,
            extension = true,
            description = "Estimate reset counter. This should be incremented when the estimate resets in any of the dimensions (position, velocity, attitude, angular speed). This is designed to be used when e.g an external SLAM system detects a loop-closure and the estimate jumps."
    )
    public final int resetCounter() {
        return this.resetCounter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        VisionSpeedEstimate other = (VisionSpeedEstimate)o;
        if (!Objects.deepEquals(usec, other.usec)) return false;
        if (!Objects.deepEquals(x, other.x)) return false;
        if (!Objects.deepEquals(y, other.y)) return false;
        if (!Objects.deepEquals(z, other.z)) return false;
        if (!Objects.deepEquals(covariance, other.covariance)) return false;
        if (!Objects.deepEquals(resetCounter, other.resetCounter)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(usec);
        result = 31 * result + Objects.hashCode(x);
        result = 31 * result + Objects.hashCode(y);
        result = 31 * result + Objects.hashCode(z);
        result = 31 * result + Objects.hashCode(covariance);
        result = 31 * result + Objects.hashCode(resetCounter);
        return result;
    }

    @Override
    public String toString() {
        return "VisionSpeedEstimate{usec=" + usec
                 + ", x=" + x
                 + ", y=" + y
                 + ", z=" + z
                 + ", covariance=" + covariance
                 + ", resetCounter=" + resetCounter + "}";
    }

    public static final class Builder {
        private BigInteger usec;

        private float x;

        private float y;

        private float z;

        private List<Float> covariance;

        private int resetCounter;

        /**
         * Timestamp (UNIX time or time since system boot) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                description = "Timestamp (UNIX time or time since system boot)"
        )
        public final Builder usec(BigInteger usec) {
            this.usec = usec;
            return this;
        }

        /**
         * Global X speed 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Global X speed"
        )
        public final Builder x(float x) {
            this.x = x;
            return this;
        }

        /**
         * Global Y speed 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Global Y speed"
        )
        public final Builder y(float y) {
            this.y = y;
            return this;
        }

        /**
         * Global Z speed 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Global Z speed"
        )
        public final Builder z(float z) {
            this.z = z;
            return this;
        }

        /**
         * Row-major representation of 3x3 linear velocity covariance matrix (states: vx, vy, vz; 1st 
         * three entries - 1st row, etc.). If unknown, assign NaN value to first element in the array. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                arraySize = 9,
                extension = true,
                description = "Row-major representation of 3x3 linear velocity covariance matrix (states: vx, vy, vz; 1st three entries - 1st row, etc.). If unknown, assign NaN value to first element in the array."
        )
        public final Builder covariance(List<Float> covariance) {
            this.covariance = covariance;
            return this;
        }

        /**
         * Estimate reset counter. This should be incremented when the estimate resets in any of the 
         * dimensions (position, velocity, attitude, angular speed). This is designed to be used when 
         * e.g an external SLAM system detects a loop-closure and the estimate jumps. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1,
                extension = true,
                description = "Estimate reset counter. This should be incremented when the estimate resets in any of the dimensions (position, velocity, attitude, angular speed). This is designed to be used when e.g an external SLAM system detects a loop-closure and the estimate jumps."
        )
        public final Builder resetCounter(int resetCounter) {
            this.resetCounter = resetCounter;
            return this;
        }

        public final VisionSpeedEstimate build() {
            return new VisionSpeedEstimate(usec, x, y, z, covariance, resetCounter);
        }
    }
}
