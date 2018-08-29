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
        crc = 58
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

    private final List<Float> twistCovariance;

    private Odometry(BigInteger timeUsec, EnumValue<MavFrame> frameId,
            EnumValue<MavFrame> childFrameId, float x, float y, float z, List<Float> q, float vx,
            float vy, float vz, float rollspeed, float pitchspeed, float yawspeed,
            List<Float> poseCovariance, List<Float> twistCovariance) {
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
        this.twistCovariance = twistCovariance;
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
            unitSize = 8
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * Coordinate frame of reference for the pose data, as defined by {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} enum. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = MavFrame.class
    )
    public final EnumValue<MavFrame> frameId() {
        return this.frameId;
    }

    /**
     * Coordinate frame of reference for the velocity in free space (twist) data, as defined by 
     * {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} enum. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            enumType = MavFrame.class
    )
    public final EnumValue<MavFrame> childFrameId() {
        return this.childFrameId;
    }

    /**
     * X Position 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float x() {
        return this.x;
    }

    /**
     * Y Position 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float y() {
        return this.y;
    }

    /**
     * Z Position 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
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
            arraySize = 4
    )
    public final List<Float> q() {
        return this.q;
    }

    /**
     * X linear speed 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4
    )
    public final float vx() {
        return this.vx;
    }

    /**
     * Y linear speed 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4
    )
    public final float vy() {
        return this.vy;
    }

    /**
     * Z linear speed 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4
    )
    public final float vz() {
        return this.vz;
    }

    /**
     * Roll angular speed 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4
    )
    public final float rollspeed() {
        return this.rollspeed;
    }

    /**
     * Pitch angular speed 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4
    )
    public final float pitchspeed() {
        return this.pitchspeed;
    }

    /**
     * Yaw angular speed 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 4
    )
    public final float yawspeed() {
        return this.yawspeed;
    }

    /**
     * Pose (states: x, y, z, roll, pitch, yaw) covariance matrix upper right triangle (first six 
     * entries are the first ROW, next five entries are the second ROW, etc.) 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 4,
            arraySize = 21
    )
    public final List<Float> poseCovariance() {
        return this.poseCovariance;
    }

    /**
     * Twist (states: vx, vy, vz, rollspeed, pitchspeed, yawspeed) covariance matrix upper right 
     * triangle (first six entries are the first ROW, next five entries are the second ROW, etc.) 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 4,
            arraySize = 21
    )
    public final List<Float> twistCovariance() {
        return this.twistCovariance;
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
        if (!Objects.deepEquals(twistCovariance, other.twistCovariance)) return false;
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
        result = 31 * result + Objects.hashCode(twistCovariance);
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
                 + ", twistCovariance=" + twistCovariance + "}";
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

        private List<Float> twistCovariance;

        /**
         * Timestamp (microseconds since system boot or since UNIX epoch). 
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
         * Coordinate frame of reference for the pose data, as defined by {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} enum. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                enumType = MavFrame.class
        )
        public final Builder frameId(EnumValue<MavFrame> frameId) {
            this.frameId = frameId;
            return this;
        }

        /**
         * Coordinate frame of reference for the pose data, as defined by {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} enum. 
         */
        public final Builder frameId(MavFrame entry) {
            return frameId(EnumValue.of(entry));
        }

        /**
         * Coordinate frame of reference for the pose data, as defined by {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} enum. 
         */
        public final Builder frameId(Enum... flags) {
            return frameId(EnumValue.create(flags));
        }

        /**
         * Coordinate frame of reference for the pose data, as defined by {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} enum. 
         */
        public final Builder frameId(Collection<Enum> flags) {
            return frameId(EnumValue.create(flags));
        }

        /**
         * Coordinate frame of reference for the velocity in free space (twist) data, as defined by 
         * {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} enum. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                enumType = MavFrame.class
        )
        public final Builder childFrameId(EnumValue<MavFrame> childFrameId) {
            this.childFrameId = childFrameId;
            return this;
        }

        /**
         * Coordinate frame of reference for the velocity in free space (twist) data, as defined by 
         * {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} enum. 
         */
        public final Builder childFrameId(MavFrame entry) {
            return childFrameId(EnumValue.of(entry));
        }

        /**
         * Coordinate frame of reference for the velocity in free space (twist) data, as defined by 
         * {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} enum. 
         */
        public final Builder childFrameId(Enum... flags) {
            return childFrameId(EnumValue.create(flags));
        }

        /**
         * Coordinate frame of reference for the velocity in free space (twist) data, as defined by 
         * {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} enum. 
         */
        public final Builder childFrameId(Collection<Enum> flags) {
            return childFrameId(EnumValue.create(flags));
        }

        /**
         * X Position 
         */
        @MavlinkFieldInfo(
                position = 4,
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
                position = 5,
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
                position = 6,
                unitSize = 4
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
                arraySize = 4
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
                unitSize = 4
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
                unitSize = 4
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
                unitSize = 4
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
                unitSize = 4
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
                unitSize = 4
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
                unitSize = 4
        )
        public final Builder yawspeed(float yawspeed) {
            this.yawspeed = yawspeed;
            return this;
        }

        /**
         * Pose (states: x, y, z, roll, pitch, yaw) covariance matrix upper right triangle (first six 
         * entries are the first ROW, next five entries are the second ROW, etc.) 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 4,
                arraySize = 21
        )
        public final Builder poseCovariance(List<Float> poseCovariance) {
            this.poseCovariance = poseCovariance;
            return this;
        }

        /**
         * Twist (states: vx, vy, vz, rollspeed, pitchspeed, yawspeed) covariance matrix upper right 
         * triangle (first six entries are the first ROW, next five entries are the second ROW, etc.) 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 4,
                arraySize = 21
        )
        public final Builder twistCovariance(List<Float> twistCovariance) {
            this.twistCovariance = twistCovariance;
            return this;
        }

        public final Odometry build() {
            return new Odometry(timeUsec, frameId, childFrameId, x, y, z, q, vx, vy, vz, rollspeed, pitchspeed, yawspeed, poseCovariance, twistCovariance);
        }
    }
}
