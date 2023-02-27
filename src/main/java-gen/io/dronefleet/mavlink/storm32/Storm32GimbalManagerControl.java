package io.dronefleet.mavlink.storm32;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.common.GimbalDeviceFlags;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Float;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Message to a gimbal manager to control the gimbal attitude. Angles and rates can be set to NaN 
 * according to use case. A gimbal device is never to react to this message. 
 */
@MavlinkMessageInfo(
        id = 60012,
        crc = 99,
        description = "Message to a gimbal manager to control the gimbal attitude. Angles and rates can be set to NaN according to use case. A gimbal device is never to react to this message."
)
public final class Storm32GimbalManagerControl {
    private final int targetSystem;

    private final int targetComponent;

    private final int gimbalId;

    private final EnumValue<MavStorm32GimbalManagerClient> client;

    private final EnumValue<GimbalDeviceFlags> deviceFlags;

    private final EnumValue<MavStorm32GimbalManagerFlags> managerFlags;

    private final List<Float> q;

    private final float angularVelocityX;

    private final float angularVelocityY;

    private final float angularVelocityZ;

    private Storm32GimbalManagerControl(int targetSystem, int targetComponent, int gimbalId,
            EnumValue<MavStorm32GimbalManagerClient> client,
            EnumValue<GimbalDeviceFlags> deviceFlags,
            EnumValue<MavStorm32GimbalManagerFlags> managerFlags, List<Float> q,
            float angularVelocityX, float angularVelocityY, float angularVelocityZ) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.gimbalId = gimbalId;
        this.client = client;
        this.deviceFlags = deviceFlags;
        this.managerFlags = managerFlags;
        this.q = q;
        this.angularVelocityX = angularVelocityX;
        this.angularVelocityY = angularVelocityY;
        this.angularVelocityZ = angularVelocityZ;
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
     * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation). Set first element to NaN to be 
     * ignored. The frame is determined by the GIMBAL_DEVICE_FLAGS_YAW_IN_xxx_FRAME flags. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            arraySize = 4,
            description = "Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation). Set first element to NaN to be ignored. The frame is determined by the GIMBAL_DEVICE_FLAGS_YAW_IN_xxx_FRAME flags."
    )
    public final List<Float> q() {
        return this.q;
    }

    /**
     * X component of angular velocity (positive: roll to the right). NaN to be ignored. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "X component of angular velocity (positive: roll to the right). NaN to be ignored."
    )
    public final float angularVelocityX() {
        return this.angularVelocityX;
    }

    /**
     * Y component of angular velocity (positive: tilt up). NaN to be ignored. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Y component of angular velocity (positive: tilt up). NaN to be ignored."
    )
    public final float angularVelocityY() {
        return this.angularVelocityY;
    }

    /**
     * Z component of angular velocity (positive: pan to the right). NaN to be ignored. The frame is 
     * determined by the GIMBAL_DEVICE_FLAGS_YAW_IN_xxx_FRAME flags. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "Z component of angular velocity (positive: pan to the right). NaN to be ignored. The frame is determined by the GIMBAL_DEVICE_FLAGS_YAW_IN_xxx_FRAME flags."
    )
    public final float angularVelocityZ() {
        return this.angularVelocityZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Storm32GimbalManagerControl other = (Storm32GimbalManagerControl)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(gimbalId, other.gimbalId)) return false;
        if (!Objects.deepEquals(client, other.client)) return false;
        if (!Objects.deepEquals(deviceFlags, other.deviceFlags)) return false;
        if (!Objects.deepEquals(managerFlags, other.managerFlags)) return false;
        if (!Objects.deepEquals(q, other.q)) return false;
        if (!Objects.deepEquals(angularVelocityX, other.angularVelocityX)) return false;
        if (!Objects.deepEquals(angularVelocityY, other.angularVelocityY)) return false;
        if (!Objects.deepEquals(angularVelocityZ, other.angularVelocityZ)) return false;
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
        result = 31 * result + Objects.hashCode(q);
        result = 31 * result + Objects.hashCode(angularVelocityX);
        result = 31 * result + Objects.hashCode(angularVelocityY);
        result = 31 * result + Objects.hashCode(angularVelocityZ);
        return result;
    }

    @Override
    public String toString() {
        return "Storm32GimbalManagerControl{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", gimbalId=" + gimbalId
                 + ", client=" + client
                 + ", deviceFlags=" + deviceFlags
                 + ", managerFlags=" + managerFlags
                 + ", q=" + q
                 + ", angularVelocityX=" + angularVelocityX
                 + ", angularVelocityY=" + angularVelocityY
                 + ", angularVelocityZ=" + angularVelocityZ + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int gimbalId;

        private EnumValue<MavStorm32GimbalManagerClient> client;

        private EnumValue<GimbalDeviceFlags> deviceFlags;

        private EnumValue<MavStorm32GimbalManagerFlags> managerFlags;

        private List<Float> q;

        private float angularVelocityX;

        private float angularVelocityY;

        private float angularVelocityZ;

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
         * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation). Set first element to NaN to be 
         * ignored. The frame is determined by the GIMBAL_DEVICE_FLAGS_YAW_IN_xxx_FRAME flags. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                arraySize = 4,
                description = "Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation). Set first element to NaN to be ignored. The frame is determined by the GIMBAL_DEVICE_FLAGS_YAW_IN_xxx_FRAME flags."
        )
        public final Builder q(List<Float> q) {
            this.q = q;
            return this;
        }

        /**
         * X component of angular velocity (positive: roll to the right). NaN to be ignored. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "X component of angular velocity (positive: roll to the right). NaN to be ignored."
        )
        public final Builder angularVelocityX(float angularVelocityX) {
            this.angularVelocityX = angularVelocityX;
            return this;
        }

        /**
         * Y component of angular velocity (positive: tilt up). NaN to be ignored. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Y component of angular velocity (positive: tilt up). NaN to be ignored."
        )
        public final Builder angularVelocityY(float angularVelocityY) {
            this.angularVelocityY = angularVelocityY;
            return this;
        }

        /**
         * Z component of angular velocity (positive: pan to the right). NaN to be ignored. The frame is 
         * determined by the GIMBAL_DEVICE_FLAGS_YAW_IN_xxx_FRAME flags. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "Z component of angular velocity (positive: pan to the right). NaN to be ignored. The frame is determined by the GIMBAL_DEVICE_FLAGS_YAW_IN_xxx_FRAME flags."
        )
        public final Builder angularVelocityZ(float angularVelocityZ) {
            this.angularVelocityZ = angularVelocityZ;
            return this;
        }

        public final Storm32GimbalManagerControl build() {
            return new Storm32GimbalManagerControl(targetSystem, targetComponent, gimbalId, client, deviceFlags, managerFlags, q, angularVelocityX, angularVelocityY, angularVelocityZ);
        }
    }
}
