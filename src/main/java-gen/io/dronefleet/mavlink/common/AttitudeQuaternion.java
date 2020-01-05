package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Float;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Objects;

/**
 * The attitude in the aeronautical frame (right-handed, Z-down, X-front, Y-right), expressed 
 * as quaternion. Quaternion order is w, x, y, z and a zero rotation would be expressed as (1 0 0 0). 
 */
@MavlinkMessageInfo(
        id = 31,
        crc = 246,
        description = "The attitude in the aeronautical frame (right-handed, Z-down, X-front, Y-right), expressed as quaternion. Quaternion order is w, x, y, z and a zero rotation would be expressed as (1 0 0 0)."
)
public final class AttitudeQuaternion {
    private final long timeBootMs;

    private final float q1;

    private final float q2;

    private final float q3;

    private final float q4;

    private final float rollspeed;

    private final float pitchspeed;

    private final float yawspeed;

    private final List<Float> reprOffsetQ;

    private AttitudeQuaternion(long timeBootMs, float q1, float q2, float q3, float q4,
            float rollspeed, float pitchspeed, float yawspeed, List<Float> reprOffsetQ) {
        this.timeBootMs = timeBootMs;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.rollspeed = rollspeed;
        this.pitchspeed = pitchspeed;
        this.yawspeed = yawspeed;
        this.reprOffsetQ = reprOffsetQ;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (time since system boot). 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Timestamp (time since system boot)."
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * Quaternion component 1, w (1 in null-rotation) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Quaternion component 1, w (1 in null-rotation)"
    )
    public final float q1() {
        return this.q1;
    }

    /**
     * Quaternion component 2, x (0 in null-rotation) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Quaternion component 2, x (0 in null-rotation)"
    )
    public final float q2() {
        return this.q2;
    }

    /**
     * Quaternion component 3, y (0 in null-rotation) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Quaternion component 3, y (0 in null-rotation)"
    )
    public final float q3() {
        return this.q3;
    }

    /**
     * Quaternion component 4, z (0 in null-rotation) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Quaternion component 4, z (0 in null-rotation)"
    )
    public final float q4() {
        return this.q4;
    }

    /**
     * Roll angular speed 
     */
    @MavlinkFieldInfo(
            position = 6,
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
            position = 7,
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
            position = 8,
            unitSize = 4,
            description = "Yaw angular speed"
    )
    public final float yawspeed() {
        return this.yawspeed;
    }

    /**
     * Rotation offset by which the attitude quaternion and angular speed vector should be rotated 
     * for user display (quaternion with [w, x, y, z] order, zero-rotation is [1, 0, 0, 0], send [0, 0, 0, 
     * 0] if field not supported). This field is intended for systems in which the reference attitude 
     * may change during flight. For example, tailsitters VTOLs rotate their reference attitude by 
     * 90 degrees between hover mode and fixed wing mode, thus repr_offset_q is equal to [1, 0, 0, 0] in 
     * hover mode and equal to [0.7071, 0, 0.7071, 0] in fixed wing mode. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            arraySize = 4,
            extension = true,
            description = "Rotation offset by which the attitude quaternion and angular speed vector should be rotated for user display (quaternion with [w, x, y, z] order, zero-rotation is [1, 0, 0, 0], send [0, 0, 0, 0] if field not supported). This field is intended for systems in which the reference attitude may change during flight. For example, tailsitters VTOLs rotate their reference attitude by 90 degrees between hover mode and fixed wing mode, thus repr_offset_q is equal to [1, 0, 0, 0] in hover mode and equal to [0.7071, 0, 0.7071, 0] in fixed wing mode."
    )
    public final List<Float> reprOffsetQ() {
        return this.reprOffsetQ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        AttitudeQuaternion other = (AttitudeQuaternion)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(q1, other.q1)) return false;
        if (!Objects.deepEquals(q2, other.q2)) return false;
        if (!Objects.deepEquals(q3, other.q3)) return false;
        if (!Objects.deepEquals(q4, other.q4)) return false;
        if (!Objects.deepEquals(rollspeed, other.rollspeed)) return false;
        if (!Objects.deepEquals(pitchspeed, other.pitchspeed)) return false;
        if (!Objects.deepEquals(yawspeed, other.yawspeed)) return false;
        if (!Objects.deepEquals(reprOffsetQ, other.reprOffsetQ)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(q1);
        result = 31 * result + Objects.hashCode(q2);
        result = 31 * result + Objects.hashCode(q3);
        result = 31 * result + Objects.hashCode(q4);
        result = 31 * result + Objects.hashCode(rollspeed);
        result = 31 * result + Objects.hashCode(pitchspeed);
        result = 31 * result + Objects.hashCode(yawspeed);
        result = 31 * result + Objects.hashCode(reprOffsetQ);
        return result;
    }

    @Override
    public String toString() {
        return "AttitudeQuaternion{timeBootMs=" + timeBootMs
                 + ", q1=" + q1
                 + ", q2=" + q2
                 + ", q3=" + q3
                 + ", q4=" + q4
                 + ", rollspeed=" + rollspeed
                 + ", pitchspeed=" + pitchspeed
                 + ", yawspeed=" + yawspeed
                 + ", reprOffsetQ=" + reprOffsetQ + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private float q1;

        private float q2;

        private float q3;

        private float q4;

        private float rollspeed;

        private float pitchspeed;

        private float yawspeed;

        private List<Float> reprOffsetQ;

        /**
         * Timestamp (time since system boot). 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Timestamp (time since system boot)."
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * Quaternion component 1, w (1 in null-rotation) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Quaternion component 1, w (1 in null-rotation)"
        )
        public final Builder q1(float q1) {
            this.q1 = q1;
            return this;
        }

        /**
         * Quaternion component 2, x (0 in null-rotation) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Quaternion component 2, x (0 in null-rotation)"
        )
        public final Builder q2(float q2) {
            this.q2 = q2;
            return this;
        }

        /**
         * Quaternion component 3, y (0 in null-rotation) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Quaternion component 3, y (0 in null-rotation)"
        )
        public final Builder q3(float q3) {
            this.q3 = q3;
            return this;
        }

        /**
         * Quaternion component 4, z (0 in null-rotation) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Quaternion component 4, z (0 in null-rotation)"
        )
        public final Builder q4(float q4) {
            this.q4 = q4;
            return this;
        }

        /**
         * Roll angular speed 
         */
        @MavlinkFieldInfo(
                position = 6,
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
                position = 7,
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
                position = 8,
                unitSize = 4,
                description = "Yaw angular speed"
        )
        public final Builder yawspeed(float yawspeed) {
            this.yawspeed = yawspeed;
            return this;
        }

        /**
         * Rotation offset by which the attitude quaternion and angular speed vector should be rotated 
         * for user display (quaternion with [w, x, y, z] order, zero-rotation is [1, 0, 0, 0], send [0, 0, 0, 
         * 0] if field not supported). This field is intended for systems in which the reference attitude 
         * may change during flight. For example, tailsitters VTOLs rotate their reference attitude by 
         * 90 degrees between hover mode and fixed wing mode, thus repr_offset_q is equal to [1, 0, 0, 0] in 
         * hover mode and equal to [0.7071, 0, 0.7071, 0] in fixed wing mode. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                arraySize = 4,
                extension = true,
                description = "Rotation offset by which the attitude quaternion and angular speed vector should be rotated for user display (quaternion with [w, x, y, z] order, zero-rotation is [1, 0, 0, 0], send [0, 0, 0, 0] if field not supported). This field is intended for systems in which the reference attitude may change during flight. For example, tailsitters VTOLs rotate their reference attitude by 90 degrees between hover mode and fixed wing mode, thus repr_offset_q is equal to [1, 0, 0, 0] in hover mode and equal to [0.7071, 0, 0.7071, 0] in fixed wing mode."
        )
        public final Builder reprOffsetQ(List<Float> reprOffsetQ) {
            this.reprOffsetQ = reprOffsetQ;
            return this;
        }

        public final AttitudeQuaternion build() {
            return new AttitudeQuaternion(timeBootMs, q1, q2, q3, q4, rollspeed, pitchspeed, yawspeed, reprOffsetQ);
        }
    }
}
