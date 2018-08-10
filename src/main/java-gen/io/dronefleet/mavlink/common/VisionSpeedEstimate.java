package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Float;
import java.lang.Object;
import java.lang.Override;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

/**
 *  
 */
@MavlinkMessageInfo(
        id = 103,
        crc = 208
)
public final class VisionSpeedEstimate {
    private final BigInteger usec;

    private final float x;

    private final float y;

    private final float z;

    private final List<Float> covariance;

    private VisionSpeedEstimate(BigInteger usec, float x, float y, float z,
            List<Float> covariance) {
        this.usec = usec;
        this.x = x;
        this.y = y;
        this.z = z;
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
     * Global X speed 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final float x() {
        return this.x;
    }

    /**
     * Global Y speed 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float y() {
        return this.y;
    }

    /**
     * Global Z speed 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float z() {
        return this.z;
    }

    /**
     * Linear velocity covariance matrix (1st three entries - 1st row, etc.) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            arraySize = 9,
            extension = true
    )
    public final List<Float> covariance() {
        return this.covariance;
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
        return result;
    }

    public static final class Builder {
        private BigInteger usec;

        private float x;

        private float y;

        private float z;

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
         * Global X speed 
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
         * Global Y speed 
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
         * Global Z speed 
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
         * Linear velocity covariance matrix (1st three entries - 1st row, etc.) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                arraySize = 9,
                extension = true
        )
        public final Builder covariance(List<Float> covariance) {
            this.covariance = covariance;
            return this;
        }

        public final VisionSpeedEstimate build() {
            return new VisionSpeedEstimate(usec, x, y, z, covariance);
        }
    }
}
