package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Deprecated;
import java.lang.Enum;
import java.lang.Float;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Low level message to control a gimbal device's attitude. This message is to be sent from the 
 * gimbal manager to the gimbal device component. The quaternion and angular velocities can be 
 * set to NaN according to use case. For the angles encoded in the quaternion and the angular 
 * velocities holds: If the flag GIMBAL_DEVICE_FLAGS_YAW_IN_VEHICLE_FRAME is set, then they 
 * are relative to the vehicle heading (vehicle frame). If the flag 
 * GIMBAL_DEVICE_FLAGS_YAW_IN_EARTH_FRAME is set, then they are relative to absolute North 
 * (earth frame). If neither of these flags are set, then (for backwards compatibility) it holds: 
 * If the flag GIMBAL_DEVICE_FLAGS_YAW_LOCK is set, then they are relative to absolute North 
 * (earth frame), else they are relative to the vehicle heading (vehicle frame). Setting both 
 * GIMBAL_DEVICE_FLAGS_YAW_IN_VEHICLE_FRAME and 
 * GIMBAL_DEVICE_FLAGS_YAW_IN_EARTH_FRAME is not allowed. These rules are to ensure 
 * backwards compatibility. New implementations should always set either 
 * GIMBAL_DEVICE_FLAGS_YAW_IN_VEHICLE_FRAME or 
 * GIMBAL_DEVICE_FLAGS_YAW_IN_EARTH_FRAME. 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 284,
        crc = 99,
        description = "Low level message to control a gimbal device's attitude. \n"
                        + "\t  This message is to be sent from the gimbal manager to the gimbal device component. \n"
                        + "\t  The quaternion and angular velocities can be set to NaN according to use case. \n"
                        + "\t  For the angles encoded in the quaternion and the angular velocities holds: \n"
                        + "\t  If the flag GIMBAL_DEVICE_FLAGS_YAW_IN_VEHICLE_FRAME is set, then they are relative to the vehicle heading (vehicle frame). \n"
                        + "\t  If the flag GIMBAL_DEVICE_FLAGS_YAW_IN_EARTH_FRAME is set, then they are relative to absolute North (earth frame). \n"
                        + "\t  If neither of these flags are set, then (for backwards compatibility) it holds: \n"
                        + "\t  If the flag GIMBAL_DEVICE_FLAGS_YAW_LOCK is set, then they are relative to absolute North (earth frame), \n"
                        + "\t  else they are relative to the vehicle heading (vehicle frame). \n"
                        + "\t  Setting both GIMBAL_DEVICE_FLAGS_YAW_IN_VEHICLE_FRAME and GIMBAL_DEVICE_FLAGS_YAW_IN_EARTH_FRAME is not allowed. \n"
                        + "\t  These rules are to ensure backwards compatibility. \n"
                        + "\t  New implementations should always set either GIMBAL_DEVICE_FLAGS_YAW_IN_VEHICLE_FRAME or GIMBAL_DEVICE_FLAGS_YAW_IN_EARTH_FRAME.",
        workInProgress = true
)
@Deprecated
public final class GimbalDeviceSetAttitude {
    private final int targetSystem;

    private final int targetComponent;

    private final EnumValue<GimbalDeviceFlags> flags;

    private final List<Float> q;

    private final float angularVelocityX;

    private final float angularVelocityY;

    private final float angularVelocityZ;

    private GimbalDeviceSetAttitude(int targetSystem, int targetComponent,
            EnumValue<GimbalDeviceFlags> flags, List<Float> q, float angularVelocityX,
            float angularVelocityY, float angularVelocityZ) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.flags = flags;
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
            position = 2,
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
            position = 3,
            unitSize = 1,
            description = "Component ID"
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Low level gimbal flags. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            enumType = GimbalDeviceFlags.class,
            description = "Low level gimbal flags."
    )
    public final EnumValue<GimbalDeviceFlags> flags() {
        return this.flags;
    }

    /**
     * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation). The frame is described in the 
     * message description. Set fields to NaN to be ignored. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            arraySize = 4,
            description = "Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation). The frame is described in the message description. Set fields to NaN to be ignored."
    )
    public final List<Float> q() {
        return this.q;
    }

    /**
     * X component of angular velocity (positive: rolling to the right). The frame is described in the 
     * message description. NaN to be ignored. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "X component of angular velocity (positive: rolling to the right). The frame is described in the message description. NaN to be ignored."
    )
    public final float angularVelocityX() {
        return this.angularVelocityX;
    }

    /**
     * Y component of angular velocity (positive: pitching up). The frame is described in the message 
     * description. NaN to be ignored. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Y component of angular velocity (positive: pitching up). The frame is described in the message description. NaN to be ignored."
    )
    public final float angularVelocityY() {
        return this.angularVelocityY;
    }

    /**
     * Z component of angular velocity (positive: yawing to the right). The frame is described in the 
     * message description. NaN to be ignored. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Z component of angular velocity (positive: yawing to the right). The frame is described in the message description. NaN to be ignored."
    )
    public final float angularVelocityZ() {
        return this.angularVelocityZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        GimbalDeviceSetAttitude other = (GimbalDeviceSetAttitude)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(flags, other.flags)) return false;
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
        result = 31 * result + Objects.hashCode(flags);
        result = 31 * result + Objects.hashCode(q);
        result = 31 * result + Objects.hashCode(angularVelocityX);
        result = 31 * result + Objects.hashCode(angularVelocityY);
        result = 31 * result + Objects.hashCode(angularVelocityZ);
        return result;
    }

    @Override
    public String toString() {
        return "GimbalDeviceSetAttitude{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", flags=" + flags
                 + ", q=" + q
                 + ", angularVelocityX=" + angularVelocityX
                 + ", angularVelocityY=" + angularVelocityY
                 + ", angularVelocityZ=" + angularVelocityZ + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private EnumValue<GimbalDeviceFlags> flags;

        private List<Float> q;

        private float angularVelocityX;

        private float angularVelocityY;

        private float angularVelocityZ;

        /**
         * System ID 
         */
        @MavlinkFieldInfo(
                position = 2,
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
                position = 3,
                unitSize = 1,
                description = "Component ID"
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Low level gimbal flags. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                enumType = GimbalDeviceFlags.class,
                description = "Low level gimbal flags."
        )
        public final Builder flags(EnumValue<GimbalDeviceFlags> flags) {
            this.flags = flags;
            return this;
        }

        /**
         * Low level gimbal flags. 
         */
        public final Builder flags(GimbalDeviceFlags entry) {
            return flags(EnumValue.of(entry));
        }

        /**
         * Low level gimbal flags. 
         */
        public final Builder flags(Enum... flags) {
            return flags(EnumValue.create(flags));
        }

        /**
         * Low level gimbal flags. 
         */
        public final Builder flags(Collection<Enum> flags) {
            return flags(EnumValue.create(flags));
        }

        /**
         * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation). The frame is described in the 
         * message description. Set fields to NaN to be ignored. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                arraySize = 4,
                description = "Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation). The frame is described in the message description. Set fields to NaN to be ignored."
        )
        public final Builder q(List<Float> q) {
            this.q = q;
            return this;
        }

        /**
         * X component of angular velocity (positive: rolling to the right). The frame is described in the 
         * message description. NaN to be ignored. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "X component of angular velocity (positive: rolling to the right). The frame is described in the message description. NaN to be ignored."
        )
        public final Builder angularVelocityX(float angularVelocityX) {
            this.angularVelocityX = angularVelocityX;
            return this;
        }

        /**
         * Y component of angular velocity (positive: pitching up). The frame is described in the message 
         * description. NaN to be ignored. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Y component of angular velocity (positive: pitching up). The frame is described in the message description. NaN to be ignored."
        )
        public final Builder angularVelocityY(float angularVelocityY) {
            this.angularVelocityY = angularVelocityY;
            return this;
        }

        /**
         * Z component of angular velocity (positive: yawing to the right). The frame is described in the 
         * message description. NaN to be ignored. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Z component of angular velocity (positive: yawing to the right). The frame is described in the message description. NaN to be ignored."
        )
        public final Builder angularVelocityZ(float angularVelocityZ) {
            this.angularVelocityZ = angularVelocityZ;
            return this;
        }

        public final GimbalDeviceSetAttitude build() {
            return new GimbalDeviceSetAttitude(targetSystem, targetComponent, flags, q, angularVelocityX, angularVelocityY, angularVelocityZ);
        }
    }
}
