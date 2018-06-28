package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Float;
import java.math.BigInteger;
import java.util.List;

/**
 * The filtered local position (e.g. fused computer vision and accelerometers). Coordinate 
 * frame is right-handed, Z-axis down (aeronautical frame, NED / north-east-down convention) 
 */
@MavlinkMessageInfo(
        id = 64,
        crc = 191
)
public final class LocalPositionNedCov {
    private final BigInteger timeUsec;

    private final MavEstimatorType estimatorType;

    private final float x;

    private final float y;

    private final float z;

    private final float vx;

    private final float vy;

    private final float vz;

    private final float ax;

    private final float ay;

    private final float az;

    private final List<Float> covariance;

    private LocalPositionNedCov(BigInteger timeUsec, MavEstimatorType estimatorType, float x,
            float y, float z, float vx, float vy, float vz, float ax, float ay, float az,
            List<Float> covariance) {
        this.timeUsec = timeUsec;
        this.estimatorType = estimatorType;
        this.x = x;
        this.y = y;
        this.z = z;
        this.vx = vx;
        this.vy = vy;
        this.vz = vz;
        this.ax = ax;
        this.ay = ay;
        this.az = az;
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
     * Timestamp (microseconds since system boot or since UNIX epoch) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * Class id of the estimator this estimate originated from. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final MavEstimatorType estimatorType() {
        return this.estimatorType;
    }

    /**
     * X Position 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float x() {
        return this.x;
    }

    /**
     * Y Position 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float y() {
        return this.y;
    }

    /**
     * Z Position 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float z() {
        return this.z;
    }

    /**
     * X Speed (m/s) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float vx() {
        return this.vx;
    }

    /**
     * Y Speed (m/s) 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float vy() {
        return this.vy;
    }

    /**
     * Z Speed (m/s) 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4
    )
    public final float vz() {
        return this.vz;
    }

    /**
     * X Acceleration (m/s^2) 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4
    )
    public final float ax() {
        return this.ax;
    }

    /**
     * Y Acceleration (m/s^2) 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4
    )
    public final float ay() {
        return this.ay;
    }

    /**
     * Z Acceleration (m/s^2) 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4
    )
    public final float az() {
        return this.az;
    }

    /**
     * Covariance matrix upper right triangular (first nine entries are the first ROW, next eight 
     * entries are the second row, etc.) 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4,
            arraySize = 45
    )
    public final List<Float> covariance() {
        return this.covariance;
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private MavEstimatorType estimatorType;

        private float x;

        private float y;

        private float z;

        private float vx;

        private float vy;

        private float vz;

        private float ax;

        private float ay;

        private float az;

        private List<Float> covariance;

        /**
         * Timestamp (microseconds since system boot or since UNIX epoch) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * Class id of the estimator this estimate originated from. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder estimatorType(MavEstimatorType estimatorType) {
            this.estimatorType = estimatorType;
            return this;
        }

        /**
         * X Position 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder x(float x) {
            this.x = x;
            return this;
        }

        /**
         * Y Position 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder y(float y) {
            this.y = y;
            return this;
        }

        /**
         * Z Position 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder z(float z) {
            this.z = z;
            return this;
        }

        /**
         * X Speed (m/s) 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder vx(float vx) {
            this.vx = vx;
            return this;
        }

        /**
         * Y Speed (m/s) 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4
        )
        public final Builder vy(float vy) {
            this.vy = vy;
            return this;
        }

        /**
         * Z Speed (m/s) 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4
        )
        public final Builder vz(float vz) {
            this.vz = vz;
            return this;
        }

        /**
         * X Acceleration (m/s^2) 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4
        )
        public final Builder ax(float ax) {
            this.ax = ax;
            return this;
        }

        /**
         * Y Acceleration (m/s^2) 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4
        )
        public final Builder ay(float ay) {
            this.ay = ay;
            return this;
        }

        /**
         * Z Acceleration (m/s^2) 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4
        )
        public final Builder az(float az) {
            this.az = az;
            return this;
        }

        /**
         * Covariance matrix upper right triangular (first nine entries are the first ROW, next eight 
         * entries are the second row, etc.) 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4,
                arraySize = 45
        )
        public final Builder covariance(List<Float> covariance) {
            this.covariance = covariance;
            return this;
        }

        public final LocalPositionNedCov build() {
            return new LocalPositionNedCov(timeUsec, estimatorType, x, y, z, vx, vy, vz, ax, ay, az, covariance);
        }
    }
}
