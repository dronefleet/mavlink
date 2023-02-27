package io.dronefleet.mavlink.storm32;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.common.GimbalDeviceCapFlags;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * Information about a gimbal manager. This message should be requested by a ground station using 
 * MAV_CMD_REQUEST_MESSAGE. It mirrors some fields of the GIMBAL_DEVICE_INFORMATION 
 * message, but not all. If the additional information is desired, also 
 * GIMBAL_DEVICE_INFORMATION should be requested. 
 */
@MavlinkMessageInfo(
        id = 60010,
        crc = 208,
        description = "Information about a gimbal manager. This message should be requested by a ground station using MAV_CMD_REQUEST_MESSAGE. It mirrors some fields of the GIMBAL_DEVICE_INFORMATION message, but not all. If the additional information is desired, also GIMBAL_DEVICE_INFORMATION should be requested."
)
public final class Storm32GimbalManagerInformation {
    private final int gimbalId;

    private final EnumValue<GimbalDeviceCapFlags> deviceCapFlags;

    private final EnumValue<MavStorm32GimbalManagerCapFlags> managerCapFlags;

    private final float rollMin;

    private final float rollMax;

    private final float pitchMin;

    private final float pitchMax;

    private final float yawMin;

    private final float yawMax;

    private Storm32GimbalManagerInformation(int gimbalId,
            EnumValue<GimbalDeviceCapFlags> deviceCapFlags,
            EnumValue<MavStorm32GimbalManagerCapFlags> managerCapFlags, float rollMin,
            float rollMax, float pitchMin, float pitchMax, float yawMin, float yawMax) {
        this.gimbalId = gimbalId;
        this.deviceCapFlags = deviceCapFlags;
        this.managerCapFlags = managerCapFlags;
        this.rollMin = rollMin;
        this.rollMax = rollMax;
        this.pitchMin = pitchMin;
        this.pitchMax = pitchMax;
        this.yawMin = yawMin;
        this.yawMax = yawMax;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Gimbal ID (component ID or 1-6 for non-MAVLink gimbal) that this gimbal manager is responsible 
     * for. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "Gimbal ID (component ID or 1-6 for non-MAVLink gimbal) that this gimbal manager is responsible for."
    )
    public final int gimbalId() {
        return this.gimbalId;
    }

    /**
     * Gimbal device capability flags. Same flags as reported by GIMBAL_DEVICE_INFORMATION. The 
     * flag is only 16 bit wide, but stored in 32 bit, for backwards compatibility (high word is zero). 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            enumType = GimbalDeviceCapFlags.class,
            description = "Gimbal device capability flags. Same flags as reported by GIMBAL_DEVICE_INFORMATION. The flag is only 16 bit wide, but stored in 32 bit, for backwards compatibility (high word is zero)."
    )
    public final EnumValue<GimbalDeviceCapFlags> deviceCapFlags() {
        return this.deviceCapFlags;
    }

    /**
     * Gimbal manager capability flags. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            enumType = MavStorm32GimbalManagerCapFlags.class,
            description = "Gimbal manager capability flags."
    )
    public final EnumValue<MavStorm32GimbalManagerCapFlags> managerCapFlags() {
        return this.managerCapFlags;
    }

    /**
     * Hardware minimum roll angle (positive: roll to the right). NaN if unknown. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Hardware minimum roll angle (positive: roll to the right). NaN if unknown."
    )
    public final float rollMin() {
        return this.rollMin;
    }

    /**
     * Hardware maximum roll angle (positive: roll to the right). NaN if unknown. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Hardware maximum roll angle (positive: roll to the right). NaN if unknown."
    )
    public final float rollMax() {
        return this.rollMax;
    }

    /**
     * Hardware minimum pitch/tilt angle (positive: tilt up). NaN if unknown. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Hardware minimum pitch/tilt angle (positive: tilt up). NaN if unknown."
    )
    public final float pitchMin() {
        return this.pitchMin;
    }

    /**
     * Hardware maximum pitch/tilt angle (positive: tilt up). NaN if unknown. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Hardware maximum pitch/tilt angle (positive: tilt up). NaN if unknown."
    )
    public final float pitchMax() {
        return this.pitchMax;
    }

    /**
     * Hardware minimum yaw/pan angle (positive: pan to the right, relative to the vehicle/gimbal 
     * base). NaN if unknown. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Hardware minimum yaw/pan angle (positive: pan to the right, relative to the vehicle/gimbal base). NaN if unknown."
    )
    public final float yawMin() {
        return this.yawMin;
    }

    /**
     * Hardware maximum yaw/pan angle (positive: pan to the right, relative to the vehicle/gimbal 
     * base). NaN if unknown. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Hardware maximum yaw/pan angle (positive: pan to the right, relative to the vehicle/gimbal base). NaN if unknown."
    )
    public final float yawMax() {
        return this.yawMax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Storm32GimbalManagerInformation other = (Storm32GimbalManagerInformation)o;
        if (!Objects.deepEquals(gimbalId, other.gimbalId)) return false;
        if (!Objects.deepEquals(deviceCapFlags, other.deviceCapFlags)) return false;
        if (!Objects.deepEquals(managerCapFlags, other.managerCapFlags)) return false;
        if (!Objects.deepEquals(rollMin, other.rollMin)) return false;
        if (!Objects.deepEquals(rollMax, other.rollMax)) return false;
        if (!Objects.deepEquals(pitchMin, other.pitchMin)) return false;
        if (!Objects.deepEquals(pitchMax, other.pitchMax)) return false;
        if (!Objects.deepEquals(yawMin, other.yawMin)) return false;
        if (!Objects.deepEquals(yawMax, other.yawMax)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(gimbalId);
        result = 31 * result + Objects.hashCode(deviceCapFlags);
        result = 31 * result + Objects.hashCode(managerCapFlags);
        result = 31 * result + Objects.hashCode(rollMin);
        result = 31 * result + Objects.hashCode(rollMax);
        result = 31 * result + Objects.hashCode(pitchMin);
        result = 31 * result + Objects.hashCode(pitchMax);
        result = 31 * result + Objects.hashCode(yawMin);
        result = 31 * result + Objects.hashCode(yawMax);
        return result;
    }

    @Override
    public String toString() {
        return "Storm32GimbalManagerInformation{gimbalId=" + gimbalId
                 + ", deviceCapFlags=" + deviceCapFlags
                 + ", managerCapFlags=" + managerCapFlags
                 + ", rollMin=" + rollMin
                 + ", rollMax=" + rollMax
                 + ", pitchMin=" + pitchMin
                 + ", pitchMax=" + pitchMax
                 + ", yawMin=" + yawMin
                 + ", yawMax=" + yawMax + "}";
    }

    public static final class Builder {
        private int gimbalId;

        private EnumValue<GimbalDeviceCapFlags> deviceCapFlags;

        private EnumValue<MavStorm32GimbalManagerCapFlags> managerCapFlags;

        private float rollMin;

        private float rollMax;

        private float pitchMin;

        private float pitchMax;

        private float yawMin;

        private float yawMax;

        /**
         * Gimbal ID (component ID or 1-6 for non-MAVLink gimbal) that this gimbal manager is responsible 
         * for. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "Gimbal ID (component ID or 1-6 for non-MAVLink gimbal) that this gimbal manager is responsible for."
        )
        public final Builder gimbalId(int gimbalId) {
            this.gimbalId = gimbalId;
            return this;
        }

        /**
         * Gimbal device capability flags. Same flags as reported by GIMBAL_DEVICE_INFORMATION. The 
         * flag is only 16 bit wide, but stored in 32 bit, for backwards compatibility (high word is zero). 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                enumType = GimbalDeviceCapFlags.class,
                description = "Gimbal device capability flags. Same flags as reported by GIMBAL_DEVICE_INFORMATION. The flag is only 16 bit wide, but stored in 32 bit, for backwards compatibility (high word is zero)."
        )
        public final Builder deviceCapFlags(EnumValue<GimbalDeviceCapFlags> deviceCapFlags) {
            this.deviceCapFlags = deviceCapFlags;
            return this;
        }

        /**
         * Gimbal device capability flags. Same flags as reported by GIMBAL_DEVICE_INFORMATION. The 
         * flag is only 16 bit wide, but stored in 32 bit, for backwards compatibility (high word is zero). 
         */
        public final Builder deviceCapFlags(GimbalDeviceCapFlags entry) {
            return deviceCapFlags(EnumValue.of(entry));
        }

        /**
         * Gimbal device capability flags. Same flags as reported by GIMBAL_DEVICE_INFORMATION. The 
         * flag is only 16 bit wide, but stored in 32 bit, for backwards compatibility (high word is zero). 
         */
        public final Builder deviceCapFlags(Enum... flags) {
            return deviceCapFlags(EnumValue.create(flags));
        }

        /**
         * Gimbal device capability flags. Same flags as reported by GIMBAL_DEVICE_INFORMATION. The 
         * flag is only 16 bit wide, but stored in 32 bit, for backwards compatibility (high word is zero). 
         */
        public final Builder deviceCapFlags(Collection<Enum> flags) {
            return deviceCapFlags(EnumValue.create(flags));
        }

        /**
         * Gimbal manager capability flags. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                enumType = MavStorm32GimbalManagerCapFlags.class,
                description = "Gimbal manager capability flags."
        )
        public final Builder managerCapFlags(
                EnumValue<MavStorm32GimbalManagerCapFlags> managerCapFlags) {
            this.managerCapFlags = managerCapFlags;
            return this;
        }

        /**
         * Gimbal manager capability flags. 
         */
        public final Builder managerCapFlags(MavStorm32GimbalManagerCapFlags entry) {
            return managerCapFlags(EnumValue.of(entry));
        }

        /**
         * Gimbal manager capability flags. 
         */
        public final Builder managerCapFlags(Enum... flags) {
            return managerCapFlags(EnumValue.create(flags));
        }

        /**
         * Gimbal manager capability flags. 
         */
        public final Builder managerCapFlags(Collection<Enum> flags) {
            return managerCapFlags(EnumValue.create(flags));
        }

        /**
         * Hardware minimum roll angle (positive: roll to the right). NaN if unknown. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Hardware minimum roll angle (positive: roll to the right). NaN if unknown."
        )
        public final Builder rollMin(float rollMin) {
            this.rollMin = rollMin;
            return this;
        }

        /**
         * Hardware maximum roll angle (positive: roll to the right). NaN if unknown. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Hardware maximum roll angle (positive: roll to the right). NaN if unknown."
        )
        public final Builder rollMax(float rollMax) {
            this.rollMax = rollMax;
            return this;
        }

        /**
         * Hardware minimum pitch/tilt angle (positive: tilt up). NaN if unknown. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Hardware minimum pitch/tilt angle (positive: tilt up). NaN if unknown."
        )
        public final Builder pitchMin(float pitchMin) {
            this.pitchMin = pitchMin;
            return this;
        }

        /**
         * Hardware maximum pitch/tilt angle (positive: tilt up). NaN if unknown. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Hardware maximum pitch/tilt angle (positive: tilt up). NaN if unknown."
        )
        public final Builder pitchMax(float pitchMax) {
            this.pitchMax = pitchMax;
            return this;
        }

        /**
         * Hardware minimum yaw/pan angle (positive: pan to the right, relative to the vehicle/gimbal 
         * base). NaN if unknown. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Hardware minimum yaw/pan angle (positive: pan to the right, relative to the vehicle/gimbal base). NaN if unknown."
        )
        public final Builder yawMin(float yawMin) {
            this.yawMin = yawMin;
            return this;
        }

        /**
         * Hardware maximum yaw/pan angle (positive: pan to the right, relative to the vehicle/gimbal 
         * base). NaN if unknown. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Hardware maximum yaw/pan angle (positive: pan to the right, relative to the vehicle/gimbal base). NaN if unknown."
        )
        public final Builder yawMax(float yawMax) {
            this.yawMax = yawMax;
            return this;
        }

        public final Storm32GimbalManagerInformation build() {
            return new Storm32GimbalManagerInformation(gimbalId, deviceCapFlags, managerCapFlags, rollMin, rollMax, pitchMin, pitchMax, yawMin, yawMax);
        }
    }
}
