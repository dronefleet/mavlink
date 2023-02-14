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
 * The location of a landing target. See: 
 * https://mavlink.io/en/services/landing_target.html 
 */
@MavlinkMessageInfo(
        id = 149,
        crc = 200,
        description = "The location of a landing target. See: https://mavlink.io/en/services/landing_target.html"
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
     * The ID of the target if multiple targets are present 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "The ID of the target if multiple targets are present"
    )
    public final int targetNum() {
        return this.targetNum;
    }

    /**
     * Coordinate frame used for following fields. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            enumType = MavFrame.class,
            description = "Coordinate frame used for following fields."
    )
    public final EnumValue<MavFrame> frame() {
        return this.frame;
    }

    /**
     * X-axis angular offset of the target from the center of the image 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "X-axis angular offset of the target from the center of the image"
    )
    public final float angleX() {
        return this.angleX;
    }

    /**
     * Y-axis angular offset of the target from the center of the image 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Y-axis angular offset of the target from the center of the image"
    )
    public final float angleY() {
        return this.angleY;
    }

    /**
     * Distance to the target from the vehicle 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Distance to the target from the vehicle"
    )
    public final float distance() {
        return this.distance;
    }

    /**
     * Size of target along x-axis 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Size of target along x-axis"
    )
    public final float sizeX() {
        return this.sizeX;
    }

    /**
     * Size of target along y-axis 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Size of target along y-axis"
    )
    public final float sizeY() {
        return this.sizeY;
    }

    /**
     * X Position of the landing target in {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            extension = true,
            description = "X Position of the landing target in MAV_FRAME"
    )
    public final float x() {
        return this.x;
    }

    /**
     * Y Position of the landing target in {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            extension = true,
            description = "Y Position of the landing target in MAV_FRAME"
    )
    public final float y() {
        return this.y;
    }

    /**
     * Z Position of the landing target in {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4,
            extension = true,
            description = "Z Position of the landing target in MAV_FRAME"
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
            extension = true,
            description = "Quaternion of landing target orientation (w, x, y, z order, zero-rotation is 1, 0, 0, 0)"
    )
    public final List<Float> q() {
        return this.q;
    }

    /**
     * Type of landing target 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 1,
            enumType = LandingTargetType.class,
            extension = true,
            description = "Type of landing target"
    )
    public final EnumValue<LandingTargetType> type() {
        return this.type;
    }

    /**
     * Boolean indicating whether the position fields (x, y, z, q, type) contain valid target 
     * position information (valid: 1, invalid: 0). Default is 0 (invalid). 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 1,
            extension = true,
            description = "Boolean indicating whether the position fields (x, y, z, q, type) contain valid target position information (valid: 1, invalid: 0). Default is 0 (invalid)."
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

    @Override
    public String toString() {
        return "LandingTarget{timeUsec=" + timeUsec
                 + ", targetNum=" + targetNum
                 + ", frame=" + frame
                 + ", angleX=" + angleX
                 + ", angleY=" + angleY
                 + ", distance=" + distance
                 + ", sizeX=" + sizeX
                 + ", sizeY=" + sizeY
                 + ", x=" + x
                 + ", y=" + y
                 + ", z=" + z
                 + ", q=" + q
                 + ", type=" + type
                 + ", positionValid=" + positionValid + "}";
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
         * The ID of the target if multiple targets are present 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "The ID of the target if multiple targets are present"
        )
        public final Builder targetNum(int targetNum) {
            this.targetNum = targetNum;
            return this;
        }

        /**
         * Coordinate frame used for following fields. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                enumType = MavFrame.class,
                description = "Coordinate frame used for following fields."
        )
        public final Builder frame(EnumValue<MavFrame> frame) {
            this.frame = frame;
            return this;
        }

        /**
         * Coordinate frame used for following fields. 
         */
        public final Builder frame(MavFrame entry) {
            return frame(EnumValue.of(entry));
        }

        /**
         * Coordinate frame used for following fields. 
         */
        public final Builder frame(Enum... flags) {
            return frame(EnumValue.create(flags));
        }

        /**
         * Coordinate frame used for following fields. 
         */
        public final Builder frame(Collection<Enum> flags) {
            return frame(EnumValue.create(flags));
        }

        /**
         * X-axis angular offset of the target from the center of the image 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "X-axis angular offset of the target from the center of the image"
        )
        public final Builder angleX(float angleX) {
            this.angleX = angleX;
            return this;
        }

        /**
         * Y-axis angular offset of the target from the center of the image 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Y-axis angular offset of the target from the center of the image"
        )
        public final Builder angleY(float angleY) {
            this.angleY = angleY;
            return this;
        }

        /**
         * Distance to the target from the vehicle 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Distance to the target from the vehicle"
        )
        public final Builder distance(float distance) {
            this.distance = distance;
            return this;
        }

        /**
         * Size of target along x-axis 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Size of target along x-axis"
        )
        public final Builder sizeX(float sizeX) {
            this.sizeX = sizeX;
            return this;
        }

        /**
         * Size of target along y-axis 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Size of target along y-axis"
        )
        public final Builder sizeY(float sizeY) {
            this.sizeY = sizeY;
            return this;
        }

        /**
         * X Position of the landing target in {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                extension = true,
                description = "X Position of the landing target in MAV_FRAME"
        )
        public final Builder x(float x) {
            this.x = x;
            return this;
        }

        /**
         * Y Position of the landing target in {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                extension = true,
                description = "Y Position of the landing target in MAV_FRAME"
        )
        public final Builder y(float y) {
            this.y = y;
            return this;
        }

        /**
         * Z Position of the landing target in {@link io.dronefleet.mavlink.common.MavFrame MAV_FRAME} 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4,
                extension = true,
                description = "Z Position of the landing target in MAV_FRAME"
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
                extension = true,
                description = "Quaternion of landing target orientation (w, x, y, z order, zero-rotation is 1, 0, 0, 0)"
        )
        public final Builder q(List<Float> q) {
            this.q = q;
            return this;
        }

        /**
         * Type of landing target 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 1,
                enumType = LandingTargetType.class,
                extension = true,
                description = "Type of landing target"
        )
        public final Builder type(EnumValue<LandingTargetType> type) {
            this.type = type;
            return this;
        }

        /**
         * Type of landing target 
         */
        public final Builder type(LandingTargetType entry) {
            return type(EnumValue.of(entry));
        }

        /**
         * Type of landing target 
         */
        public final Builder type(Enum... flags) {
            return type(EnumValue.create(flags));
        }

        /**
         * Type of landing target 
         */
        public final Builder type(Collection<Enum> flags) {
            return type(EnumValue.create(flags));
        }

        /**
         * Boolean indicating whether the position fields (x, y, z, q, type) contain valid target 
         * position information (valid: 1, invalid: 0). Default is 0 (invalid). 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 1,
                extension = true,
                description = "Boolean indicating whether the position fields (x, y, z, q, type) contain valid target position information (valid: 1, invalid: 0). Default is 0 (invalid)."
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
