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
 * Motion capture attitude and position 
 */
@MavlinkMessageInfo(
        id = 138,
        crc = 109,
        description = "Motion capture attitude and position"
)
public final class AttPosMocap {
    private final BigInteger timeUsec;

    private final List<Float> q;

    private final float x;

    private final float y;

    private final float z;

    private final List<Float> covariance;

    private AttPosMocap(BigInteger timeUsec, List<Float> q, float x, float y, float z,
            List<Float> covariance) {
        this.timeUsec = timeUsec;
        this.q = q;
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
     * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
     * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * Attitude quaternion (w, x, y, z order, zero-rotation is 1, 0, 0, 0) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            arraySize = 4,
            description = "Attitude quaternion (w, x, y, z order, zero-rotation is 1, 0, 0, 0)"
    )
    public final List<Float> q() {
        return this.q;
    }

    /**
     * X position (NED) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "X position (NED)"
    )
    public final float x() {
        return this.x;
    }

    /**
     * Y position (NED) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Y position (NED)"
    )
    public final float y() {
        return this.y;
    }

    /**
     * Z position (NED) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Z position (NED)"
    )
    public final float z() {
        return this.z;
    }

    /**
     * Row-major representation of a pose 6x6 cross-covariance matrix upper right triangle 
     * (states: x, y, z, roll, pitch, yaw; first six entries are the first ROW, next five entries are the 
     * second ROW, etc.). If unknown, assign NaN value to first element in the array. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            arraySize = 21,
            extension = true,
            description = "Row-major representation of a pose 6x6 cross-covariance matrix upper right triangle (states: x, y, z, roll, pitch, yaw; first six entries are the first ROW, next five entries are the second ROW, etc.). If unknown, assign NaN value to first element in the array."
    )
    public final List<Float> covariance() {
        return this.covariance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        AttPosMocap other = (AttPosMocap)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(q, other.q)) return false;
        if (!Objects.deepEquals(x, other.x)) return false;
        if (!Objects.deepEquals(y, other.y)) return false;
        if (!Objects.deepEquals(z, other.z)) return false;
        if (!Objects.deepEquals(covariance, other.covariance)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(q);
        result = 31 * result + Objects.hashCode(x);
        result = 31 * result + Objects.hashCode(y);
        result = 31 * result + Objects.hashCode(z);
        result = 31 * result + Objects.hashCode(covariance);
        return result;
    }

    @Override
    public String toString() {
        return "AttPosMocap{timeUsec=" + timeUsec
                 + ", q=" + q
                 + ", x=" + x
                 + ", y=" + y
                 + ", z=" + z
                 + ", covariance=" + covariance + "}";
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private List<Float> q;

        private float x;

        private float y;

        private float z;

        private List<Float> covariance;

        /**
         * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
         * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * Attitude quaternion (w, x, y, z order, zero-rotation is 1, 0, 0, 0) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                arraySize = 4,
                description = "Attitude quaternion (w, x, y, z order, zero-rotation is 1, 0, 0, 0)"
        )
        public final Builder q(List<Float> q) {
            this.q = q;
            return this;
        }

        /**
         * X position (NED) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "X position (NED)"
        )
        public final Builder x(float x) {
            this.x = x;
            return this;
        }

        /**
         * Y position (NED) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Y position (NED)"
        )
        public final Builder y(float y) {
            this.y = y;
            return this;
        }

        /**
         * Z position (NED) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Z position (NED)"
        )
        public final Builder z(float z) {
            this.z = z;
            return this;
        }

        /**
         * Row-major representation of a pose 6x6 cross-covariance matrix upper right triangle 
         * (states: x, y, z, roll, pitch, yaw; first six entries are the first ROW, next five entries are the 
         * second ROW, etc.). If unknown, assign NaN value to first element in the array. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                arraySize = 21,
                extension = true,
                description = "Row-major representation of a pose 6x6 cross-covariance matrix upper right triangle (states: x, y, z, roll, pitch, yaw; first six entries are the first ROW, next five entries are the second ROW, etc.). If unknown, assign NaN value to first element in the array."
        )
        public final Builder covariance(List<Float> covariance) {
            this.covariance = covariance;
            return this;
        }

        public final AttPosMocap build() {
            return new AttPosMocap(timeUsec, q, x, y, z, covariance);
        }
    }
}
