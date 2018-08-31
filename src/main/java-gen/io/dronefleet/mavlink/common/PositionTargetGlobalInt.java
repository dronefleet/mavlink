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
 * the autopilot. This should match the commands sent in {@link io.dronefleet.mavlink.common.SetPositionTargetGlobalInt SET_POSITION_TARGET_GLOBAL_INT} if the 
 * vehicle is being controlled this way. 
 */
@MavlinkMessageInfo(
        id = 87,
        crc = 150,
        description = "Reports the current commanded vehicle position, velocity, and acceleration as specified by the autopilot. This should match the commands sent in SET_POSITION_TARGET_GLOBAL_INT if the vehicle is being controlled this way."
)
public final class PositionTargetGlobalInt {
    private final long timeBootMs;

    private final EnumValue<MavFrame> coordinateFrame;

    private final int typeMask;

    private final int latInt;

    private final int lonInt;

    private final float alt;

    private final float vx;

    private final float vy;

    private final float vz;

    private final float afx;

    private final float afy;

    private final float afz;

    private final float yaw;

    private final float yawRate;

    private PositionTargetGlobalInt(long timeBootMs, EnumValue<MavFrame> coordinateFrame,
            int typeMask, int latInt, int lonInt, float alt, float vx, float vy, float vz,
            float afx, float afy, float afz, float yaw, float yawRate) {
        this.timeBootMs = timeBootMs;
        this.coordinateFrame = coordinateFrame;
        this.typeMask = typeMask;
        this.latInt = latInt;
        this.lonInt = lonInt;
        this.alt = alt;
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
     * Timestamp in milliseconds since system boot. The rationale for the timestamp in the setpoint 
     * is to allow the system to compensate for the transport delay of the setpoint. This allows the 
     * system to compensate processing latency. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Timestamp in milliseconds since system boot. The rationale for the timestamp in the setpoint is to allow the system to compensate for the transport delay of the setpoint. This allows the system to compensate processing latency."
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * Valid options are: MAV_FRAME_GLOBAL_INT = 5, MAV_FRAME_GLOBAL_RELATIVE_ALT_INT = 6, 
     * MAV_FRAME_GLOBAL_TERRAIN_ALT_INT = 11 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = MavFrame.class,
            description = "Valid options are: MAV_FRAME_GLOBAL_INT = 5, MAV_FRAME_GLOBAL_RELATIVE_ALT_INT = 6, MAV_FRAME_GLOBAL_TERRAIN_ALT_INT = 11"
    )
    public final EnumValue<MavFrame> coordinateFrame() {
        return this.coordinateFrame;
    }

    /**
     * Bitmask to indicate which dimensions should be ignored by the vehicle: a value of 
     * 0b0000000000000000 or 0b0000001000000000 indicates that none of the setpoint dimensions 
     * should be ignored. If bit 10 is set the floats afx afy afz should be interpreted as force instead 
     * of acceleration. Mapping: bit 1: x, bit 2: y, bit 3: z, bit 4: vx, bit 5: vy, bit 6: vz, bit 7: ax, bit 
     * 8: ay, bit 9: az, bit 10: is force setpoint, bit 11: yaw, bit 12: yaw rate 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            description = "Bitmask to indicate which dimensions should be ignored by the vehicle: a value of 0b0000000000000000 or 0b0000001000000000 indicates that none of the setpoint dimensions should be ignored. If bit 10 is set the floats afx afy afz should be interpreted as force instead of acceleration. Mapping: bit 1: x, bit 2: y, bit 3: z, bit 4: vx, bit 5: vy, bit 6: vz, bit 7: ax, bit 8: ay, bit 9: az, bit 10: is force setpoint, bit 11: yaw, bit 12: yaw rate"
    )
    public final int typeMask() {
        return this.typeMask;
    }

    /**
     * X Position in WGS84 frame in 1e7 * degrees 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            signed = true,
            description = "X Position in WGS84 frame in 1e7 * degrees"
    )
    public final int latInt() {
        return this.latInt;
    }

    /**
     * Y Position in WGS84 frame in 1e7 * degrees 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true,
            description = "Y Position in WGS84 frame in 1e7 * degrees"
    )
    public final int lonInt() {
        return this.lonInt;
    }

    /**
     * Altitude in meters in AMSL altitude, not WGS84 if absolute or relative, above terrain if 
     * GLOBAL_TERRAIN_ALT_INT 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Altitude in meters in AMSL altitude, not WGS84 if absolute or relative, above terrain if GLOBAL_TERRAIN_ALT_INT"
    )
    public final float alt() {
        return this.alt;
    }

    /**
     * X velocity in NED frame in meter / s 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "X velocity in NED frame in meter / s"
    )
    public final float vx() {
        return this.vx;
    }

    /**
     * Y velocity in NED frame in meter / s 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Y velocity in NED frame in meter / s"
    )
    public final float vy() {
        return this.vy;
    }

    /**
     * Z velocity in NED frame in meter / s 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Z velocity in NED frame in meter / s"
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
     * yaw setpoint in rad 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 4,
            description = "yaw setpoint in rad"
    )
    public final float yaw() {
        return this.yaw;
    }

    /**
     * yaw rate setpoint in rad/s 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 4,
            description = "yaw rate setpoint in rad/s"
    )
    public final float yawRate() {
        return this.yawRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        PositionTargetGlobalInt other = (PositionTargetGlobalInt)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(coordinateFrame, other.coordinateFrame)) return false;
        if (!Objects.deepEquals(typeMask, other.typeMask)) return false;
        if (!Objects.deepEquals(latInt, other.latInt)) return false;
        if (!Objects.deepEquals(lonInt, other.lonInt)) return false;
        if (!Objects.deepEquals(alt, other.alt)) return false;
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
        result = 31 * result + Objects.hashCode(latInt);
        result = 31 * result + Objects.hashCode(lonInt);
        result = 31 * result + Objects.hashCode(alt);
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
        return "PositionTargetGlobalInt{timeBootMs=" + timeBootMs
                 + ", coordinateFrame=" + coordinateFrame
                 + ", typeMask=" + typeMask
                 + ", latInt=" + latInt
                 + ", lonInt=" + lonInt
                 + ", alt=" + alt
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

        private int typeMask;

        private int latInt;

        private int lonInt;

        private float alt;

        private float vx;

        private float vy;

        private float vz;

        private float afx;

        private float afy;

        private float afz;

        private float yaw;

        private float yawRate;

        /**
         * Timestamp in milliseconds since system boot. The rationale for the timestamp in the setpoint 
         * is to allow the system to compensate for the transport delay of the setpoint. This allows the 
         * system to compensate processing latency. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Timestamp in milliseconds since system boot. The rationale for the timestamp in the setpoint is to allow the system to compensate for the transport delay of the setpoint. This allows the system to compensate processing latency."
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * Valid options are: MAV_FRAME_GLOBAL_INT = 5, MAV_FRAME_GLOBAL_RELATIVE_ALT_INT = 6, 
         * MAV_FRAME_GLOBAL_TERRAIN_ALT_INT = 11 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                enumType = MavFrame.class,
                description = "Valid options are: MAV_FRAME_GLOBAL_INT = 5, MAV_FRAME_GLOBAL_RELATIVE_ALT_INT = 6, MAV_FRAME_GLOBAL_TERRAIN_ALT_INT = 11"
        )
        public final Builder coordinateFrame(EnumValue<MavFrame> coordinateFrame) {
            this.coordinateFrame = coordinateFrame;
            return this;
        }

        /**
         * Valid options are: MAV_FRAME_GLOBAL_INT = 5, MAV_FRAME_GLOBAL_RELATIVE_ALT_INT = 6, 
         * MAV_FRAME_GLOBAL_TERRAIN_ALT_INT = 11 
         */
        public final Builder coordinateFrame(MavFrame entry) {
            return coordinateFrame(EnumValue.of(entry));
        }

        /**
         * Valid options are: MAV_FRAME_GLOBAL_INT = 5, MAV_FRAME_GLOBAL_RELATIVE_ALT_INT = 6, 
         * MAV_FRAME_GLOBAL_TERRAIN_ALT_INT = 11 
         */
        public final Builder coordinateFrame(Enum... flags) {
            return coordinateFrame(EnumValue.create(flags));
        }

        /**
         * Valid options are: MAV_FRAME_GLOBAL_INT = 5, MAV_FRAME_GLOBAL_RELATIVE_ALT_INT = 6, 
         * MAV_FRAME_GLOBAL_TERRAIN_ALT_INT = 11 
         */
        public final Builder coordinateFrame(Collection<Enum> flags) {
            return coordinateFrame(EnumValue.create(flags));
        }

        /**
         * Bitmask to indicate which dimensions should be ignored by the vehicle: a value of 
         * 0b0000000000000000 or 0b0000001000000000 indicates that none of the setpoint dimensions 
         * should be ignored. If bit 10 is set the floats afx afy afz should be interpreted as force instead 
         * of acceleration. Mapping: bit 1: x, bit 2: y, bit 3: z, bit 4: vx, bit 5: vy, bit 6: vz, bit 7: ax, bit 
         * 8: ay, bit 9: az, bit 10: is force setpoint, bit 11: yaw, bit 12: yaw rate 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                description = "Bitmask to indicate which dimensions should be ignored by the vehicle: a value of 0b0000000000000000 or 0b0000001000000000 indicates that none of the setpoint dimensions should be ignored. If bit 10 is set the floats afx afy afz should be interpreted as force instead of acceleration. Mapping: bit 1: x, bit 2: y, bit 3: z, bit 4: vx, bit 5: vy, bit 6: vz, bit 7: ax, bit 8: ay, bit 9: az, bit 10: is force setpoint, bit 11: yaw, bit 12: yaw rate"
        )
        public final Builder typeMask(int typeMask) {
            this.typeMask = typeMask;
            return this;
        }

        /**
         * X Position in WGS84 frame in 1e7 * degrees 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                signed = true,
                description = "X Position in WGS84 frame in 1e7 * degrees"
        )
        public final Builder latInt(int latInt) {
            this.latInt = latInt;
            return this;
        }

        /**
         * Y Position in WGS84 frame in 1e7 * degrees 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true,
                description = "Y Position in WGS84 frame in 1e7 * degrees"
        )
        public final Builder lonInt(int lonInt) {
            this.lonInt = lonInt;
            return this;
        }

        /**
         * Altitude in meters in AMSL altitude, not WGS84 if absolute or relative, above terrain if 
         * GLOBAL_TERRAIN_ALT_INT 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Altitude in meters in AMSL altitude, not WGS84 if absolute or relative, above terrain if GLOBAL_TERRAIN_ALT_INT"
        )
        public final Builder alt(float alt) {
            this.alt = alt;
            return this;
        }

        /**
         * X velocity in NED frame in meter / s 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "X velocity in NED frame in meter / s"
        )
        public final Builder vx(float vx) {
            this.vx = vx;
            return this;
        }

        /**
         * Y velocity in NED frame in meter / s 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Y velocity in NED frame in meter / s"
        )
        public final Builder vy(float vy) {
            this.vy = vy;
            return this;
        }

        /**
         * Z velocity in NED frame in meter / s 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Z velocity in NED frame in meter / s"
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
         * yaw setpoint in rad 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 4,
                description = "yaw setpoint in rad"
        )
        public final Builder yaw(float yaw) {
            this.yaw = yaw;
            return this;
        }

        /**
         * yaw rate setpoint in rad/s 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 4,
                description = "yaw rate setpoint in rad/s"
        )
        public final Builder yawRate(float yawRate) {
            this.yawRate = yawRate;
            return this;
        }

        public final PositionTargetGlobalInt build() {
            return new PositionTargetGlobalInt(timeBootMs, coordinateFrame, typeMask, latInt, lonInt, alt, vx, vy, vz, afx, afy, afz, yaw, yawRate);
        }
    }
}
