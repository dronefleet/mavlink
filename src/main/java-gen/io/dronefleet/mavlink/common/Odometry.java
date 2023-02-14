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
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Odometry message to communicate odometry information with an external interface. Fits ROS 
 * REP 147 standard for aerial vehicles (http://www.ros.org/reps/rep-0147.html). 
 */
@MavlinkMessageInfo(
        id = 331,
        crc = 91,
        description = "Odometry message to communicate odometry information with an external interface. Fits ROS REP 147 standard for aerial vehicles (http://www.ros.org/reps/rep-0147.html)."
)
public final class Odometry {
    private final BigInteger timeUsec;

    private final EnumValue<MavFrame> frameId;

    private final EnumValue<MavFrame> childFrameId;

    private final float x;

    private final float y;

    private final float z;

    private final List<Float> q;

    private final float vx;

    private final float vy;

    private final float vz;

    private final float rollspeed;

    private final float pitchspeed;

    private final float yawspeed;

    private final List<Float> poseCovariance;

    private final List<Float> velocityCovariance;

    private final int resetCounter;

    private final EnumValue<MavEstimatorType> estimatorType;

    private final int quality;

    private Odometry(BigInteger timeUsec, EnumValue<MavFrame> frameId,
            EnumValue<MavFrame> childFrameId, float x, float y, float z, List<Float> q, float vx,
            float vy, float vz, float rollspeed, float pitchspeed, float yawspeed,
            List<Float> poseCovariance, List<Float> velocityCovariance, int resetCounter,
            EnumValue<MavEstimatorType> estimatorType, int quality) {
        this.timeUsec = timeUsec;
        this.frameId = frameId;
        this.childFrameId = childFrameId;
        this.x = x;
        this.y = y;
        this.z = z;
        this.q = q;
        this.vx = vx;
        this.vy = vy;
        this.vz = vz;
        this.rollspeed = rollspeed;
        this.pitchspeed = pitchspeed;
        this.yawspeed = yawspeed;
        this.poseCovariance = poseCovariance;
        this.velocityCovariance = velocityCovariance;
        this.resetCounter = resetCounter;
        this.estimatorType = estimatorType;
        this.quality = quality;
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
     * Coordinate frame of reference for the pose data. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = MavFrame.class,
            description = "Coordinate frame of reference for the pose data."
    )
    public final EnumValue<MavFrame> frameId() {
        return this.frameId;
    }

    /**
     * Coordinate frame of reference for the velocity in free space (twist) data. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            enumType = MavFrame.class,
            description = "Coordinate frame of reference for the velocity in free space (twist) data."
    )
    public final EnumValue<MavFrame> childFrameId() {
        return this.childFrameId;
    }

    /**
     * X Position 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "X Position"
    )
    public final float x() {
        return this.x;
    }

    /**
     * Y Position 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Y Position"
    )
    public final float y() {
        return this.y;
    }

    /**
     * Z Position 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Z Position"
    )
    public final float z() {
        return this.z;
    }

    /**
     * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation) 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            arraySize = 4,
            description = "Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation)"
    )
    public final List<Float> q() {
        return this.q;
    }

    /**
     * X linear speed 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "X linear speed"
    )
    public final float vx() {
        return this.vx;
    }

    /**
     * Y linear speed 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Y linear speed"
    )
    public final float vy() {
        return this.vy;
    }

    /**
     * Z linear speed 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "Z linear speed"
    )
    public final float vz() {
        return this.vz;
    }

    /**
     * Roll angular speed 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            description = "Roll angular speed"
    )
    public final float rollspeed() {
        return this.rollspeed;
    }

    /**
     * Pitch angular speed 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4,
            description = "Pitch angular speed"
    )
    public final float pitchspeed() {
        return this.pitchspeed;
    }

    /**
     * Yaw angular speed 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 4,
            description = "Yaw angular speed"
    )
    public final float yawspeed() {
        return this.yawspeed;
    }

    /**
     * Row-major representation of a 6x6 pose cross-covariance matrix upper right triangle 
     * (states: x, y, z, roll, pitch, yaw; first six entries are the first ROW, next five entries are the 
     * second ROW, etc.). If unknown, assign NaN value to first element in the array. 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 4,
            arraySize = 21,
            description = "Row-major representation of a 6x6 pose cross-covariance matrix upper right triangle (states: x, y, z, roll, pitch, yaw; first six entries are the first ROW, next five entries are the second ROW, etc.). If unknown, assign NaN value to first element in the array."
    )
    public final List<Float> poseCovariance() {
        return this.poseCovariance;
    }

    /**
     * Row-major representation of a 6x6 velocity cross-covariance matrix upper right triangle 
     * (states: vx, vy, vz, rollspeed, pitchspeed, yawspeed; first six entries are the first ROW, 
     * next five entries are the second ROW, etc.). If unknown, assign NaN value to first element in the 
     * array. 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 4,
            arraySize = 21,
            description = "Row-major representation of a 6x6 velocity cross-covariance matrix upper right triangle (states: vx, vy, vz, rollspeed, pitchspeed, yawspeed; first six entries are the first ROW, next five entries are the second ROW, etc.). If unknown, assign NaN value to first element in the array."
    )
    public final List<Float> velocityCovariance() {
        return this.velocityCovariance;
    }

    /**
     * Estimate reset counter. This should be incremented when the estimate resets in any of the 
     * dimensions (position, velocity, attitude, angular speed). This is designed to be used when 
     * e.g an external SLAM system detects a loop-closure and the estimate jumps. 
     */
    @MavlinkFieldInfo(
            position = 17,
            unitSize = 1,
            extension = true,
            description = "Estimate reset counter. This should be incremented when the estimate resets in any of the dimensions (position, velocity, attitude, angular speed). This is designed to be used when e.g an external SLAM system detects a loop-closure and the estimate jumps."
    )
    public final int resetCounter() {
        return this.resetCounter;
    }

    /**
     * Type of estimator that is providing the odometry. 
     */
    @MavlinkFieldInfo(
            position = 18,
            unitSize = 1,
            enumType = MavEstimatorType.class,
            extension = true,
            description = "Type of estimator that is providing the odometry."
    )
    public final EnumValue<MavEstimatorType> estimatorType() {
        return this.estimatorType;
    }

    /**
     * Optional odometry quality metric as a percentage. -1 = odometry has failed, 0 = unknown/unset 
     * quality, 1 = worst quality, 100 = best quality 
     */
    @MavlinkFieldInfo(
            position = 19,
            unitSize = 1,
            signed = true,
            extension = true,
            description = "Optional odometry quality metric as a percentage. -1 = odometry has failed, 0 = unknown/unset quality, 1 = worst quality, 100 = best quality"
    )
    public final int quality() {
        return this.quality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Odometry other = (Odometry)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(frameId, other.frameId)) return false;
        if (!Objects.deepEquals(childFrameId, other.childFrameId)) return false;
        if (!Objects.deepEquals(x, other.x)) return false;
        if (!Objects.deepEquals(y, other.y)) return false;
        if (!Objects.deepEquals(z, other.z)) return false;
        if (!Objects.deepEquals(q, other.q)) return false;
        if (!Objects.deepEquals(vx, other.vx)) return false;
        if (!Objects.deepEquals(vy, other.vy)) return false;
        if (!Objects.deepEquals(vz, other.vz)) return false;
        if (!Objects.deepEquals(rollspeed, other.rollspeed)) return false;
        if (!Objects.deepEquals(pitchspeed, other.pitchspeed)) return false;
        if (!Objects.deepEquals(yawspeed, other.yawspeed)) return false;
        if (!Objects.deepEquals(poseCovariance, other.poseCovariance)) return false;
        if (!Objects.deepEquals(velocityCovariance, other.velocityCovariance)) return false;
        if (!Objects.deepEquals(resetCounter, other.resetCounter)) return false;
        if (!Objects.deepEquals(estimatorType, other.estimatorType)) return false;
        if (!Objects.deepEquals(quality, other.quality)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(frameId);
        result = 31 * result + Objects.hashCode(childFrameId);
        result = 31 * result + Objects.hashCode(x);
        result = 31 * result + Objects.hashCode(y);
        result = 31 * result + Objects.hashCode(z);
        result = 31 * result + Objects.hashCode(q);
        result = 31 * result + Objects.hashCode(vx);
        result = 31 * result + Objects.hashCode(vy);
        result = 31 * result + Objects.hashCode(vz);
        result = 31 * result + Objects.hashCode(rollspeed);
        result = 31 * result + Objects.hashCode(pitchspeed);
        result = 31 * result + Objects.hashCode(yawspeed);
        result = 31 * result + Objects.hashCode(poseCovariance);
        result = 31 * result + Objects.hashCode(velocityCovariance);
        result = 31 * result + Objects.hashCode(resetCounter);
        result = 31 * result + Objects.hashCode(estimatorType);
        result = 31 * result + Objects.hashCode(quality);
        return result;
    }

    @Override
    public String toString() {
        return "Odometry{timeUsec=" + timeUsec
                 + ", frameId=" + frameId
                 + ", childFrameId=" + childFrameId
                 + ", x=" + x
                 + ", y=" + y
                 + ", z=" + z
                 + ", q=" + q
                 + ", vx=" + vx
                 + ", vy=" + vy
                 + ", vz=" + vz
                 + ", rollspeed=" + rollspeed
                 + ", pitchspeed=" + pitchspeed
                 + ", yawspeed=" + yawspeed
                 + ", poseCovariance=" + poseCovariance
                 + ", velocityCovariance=" + velocityCovariance
                 + ", resetCounter=" + resetCounter
                 + ", estimatorType=" + estimatorType
                 + ", quality=" + quality + "}";
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private EnumValue<MavFrame> frameId;

        private EnumValue<MavFrame> childFrameId;

        private float x;

        private float y;

        private float z;

        private List<Float> q;

        private float vx;

        private float vy;

        private float vz;

        private float rollspeed;

        private float pitchspeed;

        private float yawspeed;

        private List<Float> poseCovariance;

        private List<Float> velocityCovariance;

        private int resetCounter;

        private EnumValue<MavEstimatorType> estimatorType;

        private int quality;

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
         * Coordinate frame of reference for the pose data. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                enumType = MavFrame.class,
                description = "Coordinate frame of reference for the pose data."
        )
        public final Builder frameId(EnumValue<MavFrame> frameId) {
            this.frameId = frameId;
            return this;
        }

        /**
         * Coordinate frame of reference for the pose data. 
         */
        public final Builder frameId(MavFrame entry) {
            return frameId(EnumValue.of(entry));
        }

        /**
         * Coordinate frame of reference for the pose data. 
         */
        public final Builder frameId(Enum... flags) {
            return frameId(EnumValue.create(flags));
        }

        /**
         * Coordinate frame of reference for the pose data. 
         */
        public final Builder frameId(Collection<Enum> flags) {
            return frameId(EnumValue.create(flags));
        }

        /**
         * Coordinate frame of reference for the velocity in free space (twist) data. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                enumType = MavFrame.class,
                description = "Coordinate frame of reference for the velocity in free space (twist) data."
        )
        public final Builder childFrameId(EnumValue<MavFrame> childFrameId) {
            this.childFrameId = childFrameId;
            return this;
        }

        /**
         * Coordinate frame of reference for the velocity in free space (twist) data. 
         */
        public final Builder childFrameId(MavFrame entry) {
            return childFrameId(EnumValue.of(entry));
        }

        /**
         * Coordinate frame of reference for the velocity in free space (twist) data. 
         */
        public final Builder childFrameId(Enum... flags) {
            return childFrameId(EnumValue.create(flags));
        }

        /**
         * Coordinate frame of reference for the velocity in free space (twist) data. 
         */
        public final Builder childFrameId(Collection<Enum> flags) {
            return childFrameId(EnumValue.create(flags));
        }

        /**
         * X Position 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "X Position"
        )
        public final Builder x(float x) {
            this.x = x;
            return this;
        }

        /**
         * Y Position 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Y Position"
        )
        public final Builder y(float y) {
            this.y = y;
            return this;
        }

        /**
         * Z Position 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Z Position"
        )
        public final Builder z(float z) {
            this.z = z;
            return this;
        }

        /**
         * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation) 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                arraySize = 4,
                description = "Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation)"
        )
        public final Builder q(List<Float> q) {
            this.q = q;
            return this;
        }

        /**
         * X linear speed 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "X linear speed"
        )
        public final Builder vx(float vx) {
            this.vx = vx;
            return this;
        }

        /**
         * Y linear speed 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Y linear speed"
        )
        public final Builder vy(float vy) {
            this.vy = vy;
            return this;
        }

        /**
         * Z linear speed 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "Z linear speed"
        )
        public final Builder vz(float vz) {
            this.vz = vz;
            return this;
        }

        /**
         * Roll angular speed 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                description = "Roll angular speed"
        )
        public final Builder rollspeed(float rollspeed) {
            this.rollspeed = rollspeed;
            return this;
        }

        /**
         * Pitch angular speed 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4,
                description = "Pitch angular speed"
        )
        public final Builder pitchspeed(float pitchspeed) {
            this.pitchspeed = pitchspeed;
            return this;
        }

        /**
         * Yaw angular speed 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 4,
                description = "Yaw angular speed"
        )
        public final Builder yawspeed(float yawspeed) {
            this.yawspeed = yawspeed;
            return this;
        }

        /**
         * Row-major representation of a 6x6 pose cross-covariance matrix upper right triangle 
         * (states: x, y, z, roll, pitch, yaw; first six entries are the first ROW, next five entries are the 
         * second ROW, etc.). If unknown, assign NaN value to first element in the array. 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 4,
                arraySize = 21,
                description = "Row-major representation of a 6x6 pose cross-covariance matrix upper right triangle (states: x, y, z, roll, pitch, yaw; first six entries are the first ROW, next five entries are the second ROW, etc.). If unknown, assign NaN value to first element in the array."
        )
        public final Builder poseCovariance(List<Float> poseCovariance) {
            this.poseCovariance = poseCovariance;
            return this;
        }

        /**
         * Row-major representation of a 6x6 velocity cross-covariance matrix upper right triangle 
         * (states: vx, vy, vz, rollspeed, pitchspeed, yawspeed; first six entries are the first ROW, 
         * next five entries are the second ROW, etc.). If unknown, assign NaN value to first element in the 
         * array. 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 4,
                arraySize = 21,
                description = "Row-major representation of a 6x6 velocity cross-covariance matrix upper right triangle (states: vx, vy, vz, rollspeed, pitchspeed, yawspeed; first six entries are the first ROW, next five entries are the second ROW, etc.). If unknown, assign NaN value to first element in the array."
        )
        public final Builder velocityCovariance(List<Float> velocityCovariance) {
            this.velocityCovariance = velocityCovariance;
            return this;
        }

        /**
         * Estimate reset counter. This should be incremented when the estimate resets in any of the 
         * dimensions (position, velocity, attitude, angular speed). This is designed to be used when 
         * e.g an external SLAM system detects a loop-closure and the estimate jumps. 
         */
        @MavlinkFieldInfo(
                position = 17,
                unitSize = 1,
                extension = true,
                description = "Estimate reset counter. This should be incremented when the estimate resets in any of the dimensions (position, velocity, attitude, angular speed). This is designed to be used when e.g an external SLAM system detects a loop-closure and the estimate jumps."
        )
        public final Builder resetCounter(int resetCounter) {
            this.resetCounter = resetCounter;
            return this;
        }

        /**
         * Type of estimator that is providing the odometry. 
         */
        @MavlinkFieldInfo(
                position = 18,
                unitSize = 1,
                enumType = MavEstimatorType.class,
                extension = true,
                description = "Type of estimator that is providing the odometry."
        )
        public final Builder estimatorType(EnumValue<MavEstimatorType> estimatorType) {
            this.estimatorType = estimatorType;
            return this;
        }

        /**
         * Type of estimator that is providing the odometry. 
         */
        public final Builder estimatorType(MavEstimatorType entry) {
            return estimatorType(EnumValue.of(entry));
        }

        /**
         * Type of estimator that is providing the odometry. 
         */
        public final Builder estimatorType(Enum... flags) {
            return estimatorType(EnumValue.create(flags));
        }

        /**
         * Type of estimator that is providing the odometry. 
         */
        public final Builder estimatorType(Collection<Enum> flags) {
            return estimatorType(EnumValue.create(flags));
        }

        /**
         * Optional odometry quality metric as a percentage. -1 = odometry has failed, 0 = unknown/unset 
         * quality, 1 = worst quality, 100 = best quality 
         */
        @MavlinkFieldInfo(
                position = 19,
                unitSize = 1,
                signed = true,
                extension = true,
                description = "Optional odometry quality metric as a percentage. -1 = odometry has failed, 0 = unknown/unset quality, 1 = worst quality, 100 = best quality"
        )
        public final Builder quality(int quality) {
            this.quality = quality;
            return this;
        }

        public final Odometry build() {
            return new Odometry(timeUsec, frameId, childFrameId, x, y, z, q, vx, vy, vz, rollspeed, pitchspeed, yawspeed, poseCovariance, velocityCovariance, resetCounter, estimatorType, quality);
        }
    }
}
