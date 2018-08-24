package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Float;
import java.lang.Object;
import java.lang.Override;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

/**
 * The location of a landing area captured from a downward facing camera 
 */
@MavlinkMessageInfo(
        id = 149,
        crc = 200
)
public final class LandingTarget {
    private final BigInteger timeUsec;

    private final int targetNum;

    private final EnumValue<MavFrame> frame;

    private final float angleX;

    private final float angleY;

    private final float distance;

    private final float sizeX;

    private final float sizeY;

    private final float x;

    private final float y;

    private final float z;

    private final List<Float> q;

    private final EnumValue<LandingTargetType> type;

    private final int positionValid;

    private LandingTarget(BigInteger timeUsec, int targetNum, EnumValue<MavFrame> frame,
            float angleX, float angleY, float distance, float sizeX, float sizeY, float x, float y,
            float z, List<Float> q, EnumValue<LandingTargetType> type, int positionValid) {
        this.timeUsec = timeUsec;
        this.targetNum = targetNum;
        this.frame = frame;
        this.angleX = angleX;
        this.angleY = angleY;
        this.distance = distance;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.x = x;
        this.y = y;
        this.z = z;
        this.q = q;
        this.type = type;
        this.positionValid = positionValid;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (micros since boot or Unix epoch) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * The ID of the target if multiple targets are present 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int targetNum() {
        return this.targetNum;
    }

    /**
     * {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} enum specifying the whether the following feilds are earth-frame, body-frame, 
     * etc. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            enumType = MavFrame.class
    )
    public final EnumValue<MavFrame> frame() {
        return this.frame;
    }

    /**
     * X-axis angular offset (in radians) of the target from the center of the image 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float angleX() {
        return this.angleX;
    }

    /**
     * Y-axis angular offset (in radians) of the target from the center of the image 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float angleY() {
        return this.angleY;
    }

    /**
     * Distance to the target from the vehicle in meters 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float distance() {
        return this.distance;
    }

    /**
     * Size in radians of target along x-axis 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float sizeX() {
        return this.sizeX;
    }

    /**
     * Size in radians of target along y-axis 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4
    )
    public final float sizeY() {
        return this.sizeY;
    }

    /**
     * X Position of the landing target on {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            extension = true
    )
    public final float x() {
        return this.x;
    }

    /**
     * Y Position of the landing target on {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            extension = true
    )
    public final float y() {
        return this.y;
    }

    /**
     * Z Position of the landing target on {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4,
            extension = true
    )
    public final float z() {
        return this.z;
    }

    /**
     * Quaternion of landing target orientation (w, x, y, z order, zero-rotation is 1, 0, 0, 0) 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 4,
            arraySize = 4,
            extension = true
    )
    public final List<Float> q() {
        return this.q;
    }

    /**
     * {@link io.dronefleet.mavlink.common.LandingTargetType LANDING_TARGET_TYPE} enum specifying the type of landing target 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 1,
            enumType = LandingTargetType.class,
            extension = true
    )
    public final EnumValue<LandingTargetType> type() {
        return this.type;
    }

    /**
     * Boolean indicating known position (1) or default unkown position (0), for validation of 
     * positioning of the landing target 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 1,
            extension = true
    )
    public final int positionValid() {
        return this.positionValid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        LandingTarget other = (LandingTarget)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(targetNum, other.targetNum)) return false;
        if (!Objects.deepEquals(frame, other.frame)) return false;
        if (!Objects.deepEquals(angleX, other.angleX)) return false;
        if (!Objects.deepEquals(angleY, other.angleY)) return false;
        if (!Objects.deepEquals(distance, other.distance)) return false;
        if (!Objects.deepEquals(sizeX, other.sizeX)) return false;
        if (!Objects.deepEquals(sizeY, other.sizeY)) return false;
        if (!Objects.deepEquals(x, other.x)) return false;
        if (!Objects.deepEquals(y, other.y)) return false;
        if (!Objects.deepEquals(z, other.z)) return false;
        if (!Objects.deepEquals(q, other.q)) return false;
        if (!Objects.deepEquals(type, other.type)) return false;
        if (!Objects.deepEquals(positionValid, other.positionValid)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(targetNum);
        result = 31 * result + Objects.hashCode(frame);
        result = 31 * result + Objects.hashCode(angleX);
        result = 31 * result + Objects.hashCode(angleY);
        result = 31 * result + Objects.hashCode(distance);
        result = 31 * result + Objects.hashCode(sizeX);
        result = 31 * result + Objects.hashCode(sizeY);
        result = 31 * result + Objects.hashCode(x);
        result = 31 * result + Objects.hashCode(y);
        result = 31 * result + Objects.hashCode(z);
        result = 31 * result + Objects.hashCode(q);
        result = 31 * result + Objects.hashCode(type);
        result = 31 * result + Objects.hashCode(positionValid);
        return result;
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private int targetNum;

        private EnumValue<MavFrame> frame;

        private float angleX;

        private float angleY;

        private float distance;

        private float sizeX;

        private float sizeY;

        private float x;

        private float y;

        private float z;

        private List<Float> q;

        private EnumValue<LandingTargetType> type;

        private int positionValid;

        /**
         * Timestamp (micros since boot or Unix epoch) 
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
         * The ID of the target if multiple targets are present 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder targetNum(int targetNum) {
            this.targetNum = targetNum;
            return this;
        }

        /**
         * {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} enum specifying the whether the following feilds are earth-frame, body-frame, 
         * etc. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                enumType = MavFrame.class
        )
        public final Builder frame(EnumValue<MavFrame> frame) {
            this.frame = frame;
            return this;
        }

        /**
         * {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} enum specifying the whether the following feilds are earth-frame, body-frame, 
         * etc. 
         */
        public final Builder frame(MavFrame entry) {
            this.frame = EnumValue.of(entry);
            return this;
        }

        /**
         * {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} enum specifying the whether the following feilds are earth-frame, body-frame, 
         * etc. 
         */
        public final Builder frame(Enum... flags) {
            this.frame = EnumValue.create(flags);
            return this;
        }

        /**
         * X-axis angular offset (in radians) of the target from the center of the image 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder angleX(float angleX) {
            this.angleX = angleX;
            return this;
        }

        /**
         * Y-axis angular offset (in radians) of the target from the center of the image 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder angleY(float angleY) {
            this.angleY = angleY;
            return this;
        }

        /**
         * Distance to the target from the vehicle in meters 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder distance(float distance) {
            this.distance = distance;
            return this;
        }

        /**
         * Size in radians of target along x-axis 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4
        )
        public final Builder sizeX(float sizeX) {
            this.sizeX = sizeX;
            return this;
        }

        /**
         * Size in radians of target along y-axis 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4
        )
        public final Builder sizeY(float sizeY) {
            this.sizeY = sizeY;
            return this;
        }

        /**
         * X Position of the landing target on {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                extension = true
        )
        public final Builder x(float x) {
            this.x = x;
            return this;
        }

        /**
         * Y Position of the landing target on {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                extension = true
        )
        public final Builder y(float y) {
            this.y = y;
            return this;
        }

        /**
         * Z Position of the landing target on {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4,
                extension = true
        )
        public final Builder z(float z) {
            this.z = z;
            return this;
        }

        /**
         * Quaternion of landing target orientation (w, x, y, z order, zero-rotation is 1, 0, 0, 0) 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 4,
                arraySize = 4,
                extension = true
        )
        public final Builder q(List<Float> q) {
            this.q = q;
            return this;
        }

        /**
         * {@link io.dronefleet.mavlink.common.LandingTargetType LANDING_TARGET_TYPE} enum specifying the type of landing target 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 1,
                enumType = LandingTargetType.class,
                extension = true
        )
        public final Builder type(EnumValue<LandingTargetType> type) {
            this.type = type;
            return this;
        }

        /**
         * {@link io.dronefleet.mavlink.common.LandingTargetType LANDING_TARGET_TYPE} enum specifying the type of landing target 
         */
        public final Builder type(LandingTargetType entry) {
            this.type = EnumValue.of(entry);
            return this;
        }

        /**
         * {@link io.dronefleet.mavlink.common.LandingTargetType LANDING_TARGET_TYPE} enum specifying the type of landing target 
         */
        public final Builder type(Enum... flags) {
            this.type = EnumValue.create(flags);
            return this;
        }

        /**
         * Boolean indicating known position (1) or default unkown position (0), for validation of 
         * positioning of the landing target 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 1,
                extension = true
        )
        public final Builder positionValid(int positionValid) {
            this.positionValid = positionValid;
            return this;
        }

        public final LandingTarget build() {
            return new LandingTarget(timeUsec, targetNum, frame, angleX, angleY, distance, sizeX, sizeY, x, y, z, q, type, positionValid);
        }
    }
}
