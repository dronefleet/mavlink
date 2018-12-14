package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * Reports the current commanded vehicle position, velocity, and acceleration as specified by 
 * the autopilot. This should match the commands sent in {@link io.dronefleet.mavlink.common.SetPositionTargetLocalNed SET_POSITION_TARGET_LOCAL_NED} if the 
 * vehicle is being controlled this way. 
 */
@MavlinkMessageInfo(
        id = 85,
        crc = 140,
        description = "Reports the current commanded vehicle position, velocity, and acceleration as specified by the autopilot. This should match the commands sent in SET_POSITION_TARGET_LOCAL_NED if the vehicle is being controlled this way."
)
public final class PositionTargetLocalNed {
    private final long timeBootMs;

    private final EnumValue<MavFrame> coordinateFrame;

    private final EnumValue<PositionTargetTypemask> typeMask;

    private final float x;

    private final float y;

    private final float z;

    private final float vx;

    private final float vy;

    private final float vz;

    private final float afx;

    private final float afy;

    private final float afz;

    private final float yaw;

    private final float yawRate;

    private PositionTargetLocalNed(long timeBootMs, EnumValue<MavFrame> coordinateFrame,
            EnumValue<PositionTargetTypemask> typeMask, float x, float y, float z, float vx,
            float vy, float vz, float afx, float afy, float afz, float yaw, float yawRate) {
        this.timeBootMs = timeBootMs;
        this.coordinateFrame = coordinateFrame;
        this.typeMask = typeMask;
        this.x = x;
        this.y = y;
        this.z = z;
        this.vx = vx;
        this.vy = vy;
        this.vz = vz;
        this.afx = afx;
        this.afy = afy;
        this.afz = afz;
        this.yaw = yaw;
        this.yawRate = yawRate;
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
     * Valid options are: MAV_FRAME_LOCAL_NED = 1, MAV_FRAME_LOCAL_OFFSET_NED = 7, 
     * MAV_FRAME_BODY_NED = 8, MAV_FRAME_BODY_OFFSET_NED = 9 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = MavFrame.class,
            description = "Valid options are: MAV_FRAME_LOCAL_NED = 1, MAV_FRAME_LOCAL_OFFSET_NED = 7, MAV_FRAME_BODY_NED = 8, MAV_FRAME_BODY_OFFSET_NED = 9"
    )
    public final EnumValue<MavFrame> coordinateFrame() {
        return this.coordinateFrame;
    }

    /**
     * Bitmap to indicate which dimensions should be ignored by the vehicle. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            enumType = PositionTargetTypemask.class,
            description = "Bitmap to indicate which dimensions should be ignored by the vehicle."
    )
    public final EnumValue<PositionTargetTypemask> typeMask() {
        return this.typeMask;
    }

    /**
     * X Position in NED frame 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "X Position in NED frame"
    )
    public final float x() {
        return this.x;
    }

    /**
     * Y Position in NED frame 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Y Position in NED frame"
    )
    public final float y() {
        return this.y;
    }

    /**
     * Z Position in NED frame (note, altitude is negative in NED) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Z Position in NED frame (note, altitude is negative in NED)"
    )
    public final float z() {
        return this.z;
    }

    /**
     * X velocity in NED frame 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "X velocity in NED frame"
    )
    public final float vx() {
        return this.vx;
    }

    /**
     * Y velocity in NED frame 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Y velocity in NED frame"
    )
    public final float vy() {
        return this.vy;
    }

    /**
     * Z velocity in NED frame 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Z velocity in NED frame"
    )
    public final float vz() {
        return this.vz;
    }

    /**
     * X acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "X acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N"
    )
    public final float afx() {
        return this.afx;
    }

    /**
     * Y acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            description = "Y acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N"
    )
    public final float afy() {
        return this.afy;
    }

    /**
     * Z acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4,
            description = "Z acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N"
    )
    public final float afz() {
        return this.afz;
    }

    /**
     * yaw setpoint 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 4,
            description = "yaw setpoint"
    )
    public final float yaw() {
        return this.yaw;
    }

    /**
     * yaw rate setpoint 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 4,
            description = "yaw rate setpoint"
    )
    public final float yawRate() {
        return this.yawRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        PositionTargetLocalNed other = (PositionTargetLocalNed)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(coordinateFrame, other.coordinateFrame)) return false;
        if (!Objects.deepEquals(typeMask, other.typeMask)) return false;
        if (!Objects.deepEquals(x, other.x)) return false;
        if (!Objects.deepEquals(y, other.y)) return false;
        if (!Objects.deepEquals(z, other.z)) return false;
        if (!Objects.deepEquals(vx, other.vx)) return false;
        if (!Objects.deepEquals(vy, other.vy)) return false;
        if (!Objects.deepEquals(vz, other.vz)) return false;
        if (!Objects.deepEquals(afx, other.afx)) return false;
        if (!Objects.deepEquals(afy, other.afy)) return false;
        if (!Objects.deepEquals(afz, other.afz)) return false;
        if (!Objects.deepEquals(yaw, other.yaw)) return false;
        if (!Objects.deepEquals(yawRate, other.yawRate)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(coordinateFrame);
        result = 31 * result + Objects.hashCode(typeMask);
        result = 31 * result + Objects.hashCode(x);
        result = 31 * result + Objects.hashCode(y);
        result = 31 * result + Objects.hashCode(z);
        result = 31 * result + Objects.hashCode(vx);
        result = 31 * result + Objects.hashCode(vy);
        result = 31 * result + Objects.hashCode(vz);
        result = 31 * result + Objects.hashCode(afx);
        result = 31 * result + Objects.hashCode(afy);
        result = 31 * result + Objects.hashCode(afz);
        result = 31 * result + Objects.hashCode(yaw);
        result = 31 * result + Objects.hashCode(yawRate);
        return result;
    }

    @Override
    public String toString() {
        return "PositionTargetLocalNed{timeBootMs=" + timeBootMs
                 + ", coordinateFrame=" + coordinateFrame
                 + ", typeMask=" + typeMask
                 + ", x=" + x
                 + ", y=" + y
                 + ", z=" + z
                 + ", vx=" + vx
                 + ", vy=" + vy
                 + ", vz=" + vz
                 + ", afx=" + afx
                 + ", afy=" + afy
                 + ", afz=" + afz
                 + ", yaw=" + yaw
                 + ", yawRate=" + yawRate + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private EnumValue<MavFrame> coordinateFrame;

        private EnumValue<PositionTargetTypemask> typeMask;

        private float x;

        private float y;

        private float z;

        private float vx;

        private float vy;

        private float vz;

        private float afx;

        private float afy;

        private float afz;

        private float yaw;

        private float yawRate;

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
         * Valid options are: MAV_FRAME_LOCAL_NED = 1, MAV_FRAME_LOCAL_OFFSET_NED = 7, 
         * MAV_FRAME_BODY_NED = 8, MAV_FRAME_BODY_OFFSET_NED = 9 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                enumType = MavFrame.class,
                description = "Valid options are: MAV_FRAME_LOCAL_NED = 1, MAV_FRAME_LOCAL_OFFSET_NED = 7, MAV_FRAME_BODY_NED = 8, MAV_FRAME_BODY_OFFSET_NED = 9"
        )
        public final Builder coordinateFrame(EnumValue<MavFrame> coordinateFrame) {
            this.coordinateFrame = coordinateFrame;
            return this;
        }

        /**
         * Valid options are: MAV_FRAME_LOCAL_NED = 1, MAV_FRAME_LOCAL_OFFSET_NED = 7, 
         * MAV_FRAME_BODY_NED = 8, MAV_FRAME_BODY_OFFSET_NED = 9 
         */
        public final Builder coordinateFrame(MavFrame entry) {
            return coordinateFrame(EnumValue.of(entry));
        }

        /**
         * Valid options are: MAV_FRAME_LOCAL_NED = 1, MAV_FRAME_LOCAL_OFFSET_NED = 7, 
         * MAV_FRAME_BODY_NED = 8, MAV_FRAME_BODY_OFFSET_NED = 9 
         */
        public final Builder coordinateFrame(Enum... flags) {
            return coordinateFrame(EnumValue.create(flags));
        }

        /**
         * Valid options are: MAV_FRAME_LOCAL_NED = 1, MAV_FRAME_LOCAL_OFFSET_NED = 7, 
         * MAV_FRAME_BODY_NED = 8, MAV_FRAME_BODY_OFFSET_NED = 9 
         */
        public final Builder coordinateFrame(Collection<Enum> flags) {
            return coordinateFrame(EnumValue.create(flags));
        }

        /**
         * Bitmap to indicate which dimensions should be ignored by the vehicle. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                enumType = PositionTargetTypemask.class,
                description = "Bitmap to indicate which dimensions should be ignored by the vehicle."
        )
        public final Builder typeMask(EnumValue<PositionTargetTypemask> typeMask) {
            this.typeMask = typeMask;
            return this;
        }

        /**
         * Bitmap to indicate which dimensions should be ignored by the vehicle. 
         */
        public final Builder typeMask(PositionTargetTypemask entry) {
            return typeMask(EnumValue.of(entry));
        }

        /**
         * Bitmap to indicate which dimensions should be ignored by the vehicle. 
         */
        public final Builder typeMask(Enum... flags) {
            return typeMask(EnumValue.create(flags));
        }

        /**
         * Bitmap to indicate which dimensions should be ignored by the vehicle. 
         */
        public final Builder typeMask(Collection<Enum> flags) {
            return typeMask(EnumValue.create(flags));
        }

        /**
         * X Position in NED frame 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "X Position in NED frame"
        )
        public final Builder x(float x) {
            this.x = x;
            return this;
        }

        /**
         * Y Position in NED frame 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Y Position in NED frame"
        )
        public final Builder y(float y) {
            this.y = y;
            return this;
        }

        /**
         * Z Position in NED frame (note, altitude is negative in NED) 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Z Position in NED frame (note, altitude is negative in NED)"
        )
        public final Builder z(float z) {
            this.z = z;
            return this;
        }

        /**
         * X velocity in NED frame 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "X velocity in NED frame"
        )
        public final Builder vx(float vx) {
            this.vx = vx;
            return this;
        }

        /**
         * Y velocity in NED frame 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Y velocity in NED frame"
        )
        public final Builder vy(float vy) {
            this.vy = vy;
            return this;
        }

        /**
         * Z velocity in NED frame 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Z velocity in NED frame"
        )
        public final Builder vz(float vz) {
            this.vz = vz;
            return this;
        }

        /**
         * X acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "X acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N"
        )
        public final Builder afx(float afx) {
            this.afx = afx;
            return this;
        }

        /**
         * Y acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                description = "Y acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N"
        )
        public final Builder afy(float afy) {
            this.afy = afy;
            return this;
        }

        /**
         * Z acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4,
                description = "Z acceleration or force (if bit 10 of type_mask is set) in NED frame in meter / s^2 or N"
        )
        public final Builder afz(float afz) {
            this.afz = afz;
            return this;
        }

        /**
         * yaw setpoint 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 4,
                description = "yaw setpoint"
        )
        public final Builder yaw(float yaw) {
            this.yaw = yaw;
            return this;
        }

        /**
         * yaw rate setpoint 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 4,
                description = "yaw rate setpoint"
        )
        public final Builder yawRate(float yawRate) {
            this.yawRate = yawRate;
            return this;
        }

        public final PositionTargetLocalNed build() {
            return new PositionTargetLocalNed(timeBootMs, coordinateFrame, typeMask, x, y, z, vx, vy, vz, afx, afy, afz, yaw, yawRate);
        }
    }
}
