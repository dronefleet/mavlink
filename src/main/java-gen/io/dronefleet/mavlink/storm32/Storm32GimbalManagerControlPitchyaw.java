package io.dronefleet.mavlink.storm32;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.common.GimbalDeviceFlags;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * Message to a gimbal manager to control the gimbal tilt and pan angles. Angles and rates can be set 
 * to NaN according to use case. A gimbal device is never to react to this message. 
 */
@MavlinkMessageInfo(
        id = 60013,
        crc = 129,
        description = "Message to a gimbal manager to control the gimbal tilt and pan angles. Angles and rates can be set to NaN according to use case. A gimbal device is never to react to this message."
)
public final class Storm32GimbalManagerControlPitchyaw {
    private final int targetSystem;

    private final int targetComponent;

    private final int gimbalId;

    private final EnumValue<MavStorm32GimbalManagerClient> client;

    private final EnumValue<GimbalDeviceFlags> deviceFlags;

    private final EnumValue<MavStorm32GimbalManagerFlags> managerFlags;

    private final float pitch;

    private final float yaw;

    private final float pitchRate;

    private final float yawRate;

    private Storm32GimbalManagerControlPitchyaw(int targetSystem, int targetComponent, int gimbalId,
            EnumValue<MavStorm32GimbalManagerClient> client,
            EnumValue<GimbalDeviceFlags> deviceFlags,
            EnumValue<MavStorm32GimbalManagerFlags> managerFlags, float pitch, float yaw,
            float pitchRate, float yawRate) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.gimbalId = gimbalId;
        this.client = client;
        this.deviceFlags = deviceFlags;
        this.managerFlags = managerFlags;
        this.pitch = pitch;
        this.yaw = yaw;
        this.pitchRate = pitchRate;
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
     * System ID 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "System ID"
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Component ID"
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Gimbal ID of the gimbal manager to address (component ID or 1-6 for non-MAVLink gimbal, 0 for all 
     * gimbals). Send command multiple times for more than one but not all gimbals. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "Gimbal ID of the gimbal manager to address (component ID or 1-6 for non-MAVLink gimbal, 0 for all gimbals). Send command multiple times for more than one but not all gimbals."
    )
    public final int gimbalId() {
        return this.gimbalId;
    }

    /**
     * Client which is contacting the gimbal manager (must be set). 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            enumType = MavStorm32GimbalManagerClient.class,
            description = "Client which is contacting the gimbal manager (must be set)."
    )
    public final EnumValue<MavStorm32GimbalManagerClient> client() {
        return this.client;
    }

    /**
     * Gimbal device flags to be applied (UINT16_MAX to be ignored). Same flags as used in 
     * GIMBAL_DEVICE_SET_ATTITUDE. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            enumType = GimbalDeviceFlags.class,
            description = "Gimbal device flags to be applied (UINT16_MAX to be ignored). Same flags as used in GIMBAL_DEVICE_SET_ATTITUDE."
    )
    public final EnumValue<GimbalDeviceFlags> deviceFlags() {
        return this.deviceFlags;
    }

    /**
     * Gimbal manager flags to be applied (0 to be ignored). 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            enumType = MavStorm32GimbalManagerFlags.class,
            description = "Gimbal manager flags to be applied (0 to be ignored)."
    )
    public final EnumValue<MavStorm32GimbalManagerFlags> managerFlags() {
        return this.managerFlags;
    }

    /**
     * Pitch/tilt angle (positive: tilt up). NaN to be ignored. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Pitch/tilt angle (positive: tilt up). NaN to be ignored."
    )
    public final float pitch() {
        return this.pitch;
    }

    /**
     * Yaw/pan angle (positive: pan the right). NaN to be ignored. The frame is determined by the 
     * GIMBAL_DEVICE_FLAGS_YAW_IN_xxx_FRAME flags. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Yaw/pan angle (positive: pan the right). NaN to be ignored. The frame is determined by the GIMBAL_DEVICE_FLAGS_YAW_IN_xxx_FRAME flags."
    )
    public final float yaw() {
        return this.yaw;
    }

    /**
     * Pitch/tilt angular rate (positive: tilt up). NaN to be ignored. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Pitch/tilt angular rate (positive: tilt up). NaN to be ignored."
    )
    public final float pitchRate() {
        return this.pitchRate;
    }

    /**
     * Yaw/pan angular rate (positive: pan to the right). NaN to be ignored. The frame is determined by 
     * the GIMBAL_DEVICE_FLAGS_YAW_IN_xxx_FRAME flags. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "Yaw/pan angular rate (positive: pan to the right). NaN to be ignored. The frame is determined by the GIMBAL_DEVICE_FLAGS_YAW_IN_xxx_FRAME flags."
    )
    public final float yawRate() {
        return this.yawRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Storm32GimbalManagerControlPitchyaw other = (Storm32GimbalManagerControlPitchyaw)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(gimbalId, other.gimbalId)) return false;
        if (!Objects.deepEquals(client, other.client)) return false;
        if (!Objects.deepEquals(deviceFlags, other.deviceFlags)) return false;
        if (!Objects.deepEquals(managerFlags, other.managerFlags)) return false;
        if (!Objects.deepEquals(pitch, other.pitch)) return false;
        if (!Objects.deepEquals(yaw, other.yaw)) return false;
        if (!Objects.deepEquals(pitchRate, other.pitchRate)) return false;
        if (!Objects.deepEquals(yawRate, other.yawRate)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(gimbalId);
        result = 31 * result + Objects.hashCode(client);
        result = 31 * result + Objects.hashCode(deviceFlags);
        result = 31 * result + Objects.hashCode(managerFlags);
        result = 31 * result + Objects.hashCode(pitch);
        result = 31 * result + Objects.hashCode(yaw);
        result = 31 * result + Objects.hashCode(pitchRate);
        result = 31 * result + Objects.hashCode(yawRate);
        return result;
    }

    @Override
    public String toString() {
        return "Storm32GimbalManagerControlPitchyaw{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", gimbalId=" + gimbalId
                 + ", client=" + client
                 + ", deviceFlags=" + deviceFlags
                 + ", managerFlags=" + managerFlags
                 + ", pitch=" + pitch
                 + ", yaw=" + yaw
                 + ", pitchRate=" + pitchRate
                 + ", yawRate=" + yawRate + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int gimbalId;

        private EnumValue<MavStorm32GimbalManagerClient> client;

        private EnumValue<GimbalDeviceFlags> deviceFlags;

        private EnumValue<MavStorm32GimbalManagerFlags> managerFlags;

        private float pitch;

        private float yaw;

        private float pitchRate;

        private float yawRate;

        /**
         * System ID 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "System ID"
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component ID 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Component ID"
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Gimbal ID of the gimbal manager to address (component ID or 1-6 for non-MAVLink gimbal, 0 for all 
         * gimbals). Send command multiple times for more than one but not all gimbals. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "Gimbal ID of the gimbal manager to address (component ID or 1-6 for non-MAVLink gimbal, 0 for all gimbals). Send command multiple times for more than one but not all gimbals."
        )
        public final Builder gimbalId(int gimbalId) {
            this.gimbalId = gimbalId;
            return this;
        }

        /**
         * Client which is contacting the gimbal manager (must be set). 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                enumType = MavStorm32GimbalManagerClient.class,
                description = "Client which is contacting the gimbal manager (must be set)."
        )
        public final Builder client(EnumValue<MavStorm32GimbalManagerClient> client) {
            this.client = client;
            return this;
        }

        /**
         * Client which is contacting the gimbal manager (must be set). 
         */
        public final Builder client(MavStorm32GimbalManagerClient entry) {
            return client(EnumValue.of(entry));
        }

        /**
         * Client which is contacting the gimbal manager (must be set). 
         */
        public final Builder client(Enum... flags) {
            return client(EnumValue.create(flags));
        }

        /**
         * Client which is contacting the gimbal manager (must be set). 
         */
        public final Builder client(Collection<Enum> flags) {
            return client(EnumValue.create(flags));
        }

        /**
         * Gimbal device flags to be applied (UINT16_MAX to be ignored). Same flags as used in 
         * GIMBAL_DEVICE_SET_ATTITUDE. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                enumType = GimbalDeviceFlags.class,
                description = "Gimbal device flags to be applied (UINT16_MAX to be ignored). Same flags as used in GIMBAL_DEVICE_SET_ATTITUDE."
        )
        public final Builder deviceFlags(EnumValue<GimbalDeviceFlags> deviceFlags) {
            this.deviceFlags = deviceFlags;
            return this;
        }

        /**
         * Gimbal device flags to be applied (UINT16_MAX to be ignored). Same flags as used in 
         * GIMBAL_DEVICE_SET_ATTITUDE. 
         */
        public final Builder deviceFlags(GimbalDeviceFlags entry) {
            return deviceFlags(EnumValue.of(entry));
        }

        /**
         * Gimbal device flags to be applied (UINT16_MAX to be ignored). Same flags as used in 
         * GIMBAL_DEVICE_SET_ATTITUDE. 
         */
        public final Builder deviceFlags(Enum... flags) {
            return deviceFlags(EnumValue.create(flags));
        }

        /**
         * Gimbal device flags to be applied (UINT16_MAX to be ignored). Same flags as used in 
         * GIMBAL_DEVICE_SET_ATTITUDE. 
         */
        public final Builder deviceFlags(Collection<Enum> flags) {
            return deviceFlags(EnumValue.create(flags));
        }

        /**
         * Gimbal manager flags to be applied (0 to be ignored). 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                enumType = MavStorm32GimbalManagerFlags.class,
                description = "Gimbal manager flags to be applied (0 to be ignored)."
        )
        public final Builder managerFlags(EnumValue<MavStorm32GimbalManagerFlags> managerFlags) {
            this.managerFlags = managerFlags;
            return this;
        }

        /**
         * Gimbal manager flags to be applied (0 to be ignored). 
         */
        public final Builder managerFlags(MavStorm32GimbalManagerFlags entry) {
            return managerFlags(EnumValue.of(entry));
        }

        /**
         * Gimbal manager flags to be applied (0 to be ignored). 
         */
        public final Builder managerFlags(Enum... flags) {
            return managerFlags(EnumValue.create(flags));
        }

        /**
         * Gimbal manager flags to be applied (0 to be ignored). 
         */
        public final Builder managerFlags(Collection<Enum> flags) {
            return managerFlags(EnumValue.create(flags));
        }

        /**
         * Pitch/tilt angle (positive: tilt up). NaN to be ignored. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Pitch/tilt angle (positive: tilt up). NaN to be ignored."
        )
        public final Builder pitch(float pitch) {
            this.pitch = pitch;
            return this;
        }

        /**
         * Yaw/pan angle (positive: pan the right). NaN to be ignored. The frame is determined by the 
         * GIMBAL_DEVICE_FLAGS_YAW_IN_xxx_FRAME flags. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Yaw/pan angle (positive: pan the right). NaN to be ignored. The frame is determined by the GIMBAL_DEVICE_FLAGS_YAW_IN_xxx_FRAME flags."
        )
        public final Builder yaw(float yaw) {
            this.yaw = yaw;
            return this;
        }

        /**
         * Pitch/tilt angular rate (positive: tilt up). NaN to be ignored. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Pitch/tilt angular rate (positive: tilt up). NaN to be ignored."
        )
        public final Builder pitchRate(float pitchRate) {
            this.pitchRate = pitchRate;
            return this;
        }

        /**
         * Yaw/pan angular rate (positive: pan to the right). NaN to be ignored. The frame is determined by 
         * the GIMBAL_DEVICE_FLAGS_YAW_IN_xxx_FRAME flags. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "Yaw/pan angular rate (positive: pan to the right). NaN to be ignored. The frame is determined by the GIMBAL_DEVICE_FLAGS_YAW_IN_xxx_FRAME flags."
        )
        public final Builder yawRate(float yawRate) {
            this.yawRate = yawRate;
            return this;
        }

        public final Storm32GimbalManagerControlPitchyaw build() {
            return new Storm32GimbalManagerControlPitchyaw(targetSystem, targetComponent, gimbalId, client, deviceFlags, managerFlags, pitch, yaw, pitchRate, yawRate);
        }
    }
}
