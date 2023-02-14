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
 * High level message to control a gimbal's attitude. This message is to be sent to the gimbal 
 * manager (e.g. from a ground station). Angles and rates can be set to NaN according to use case. 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 282,
        crc = 123,
        description = "High level message to control a gimbal's attitude. This message is to be sent to the gimbal manager (e.g. from a ground station). Angles and rates can be set to NaN according to use case.",
        workInProgress = true
)
@Deprecated
public final class GimbalManagerSetAttitude {
    private final int targetSystem;

    private final int targetComponent;

    private final EnumValue<GimbalManagerFlags> flags;

    private final int gimbalDeviceId;

    private final List<Float> q;

    private final float angularVelocityX;

    private final float angularVelocityY;

    private final float angularVelocityZ;

    private GimbalManagerSetAttitude(int targetSystem, int targetComponent,
            EnumValue<GimbalManagerFlags> flags, int gimbalDeviceId, List<Float> q,
            float angularVelocityX, float angularVelocityY, float angularVelocityZ) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.flags = flags;
        this.gimbalDeviceId = gimbalDeviceId;
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
     * High level gimbal manager flags to use. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            enumType = GimbalManagerFlags.class,
            description = "High level gimbal manager flags to use."
    )
    public final EnumValue<GimbalManagerFlags> flags() {
        return this.flags;
    }

    /**
     * Component ID of gimbal device to address (or 1-6 for non-MAVLink gimbal), 0 for all gimbal 
     * device components. Send command multiple times for more than one gimbal (but not all gimbals). 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            description = "Component ID of gimbal device to address (or 1-6 for non-MAVLink gimbal), 0 for all gimbal device components. Send command multiple times for more than one gimbal (but not all gimbals)."
    )
    public final int gimbalDeviceId() {
        return this.gimbalDeviceId;
    }

    /**
     * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation, the frame is depends on whether 
     * the flag GIMBAL_MANAGER_FLAGS_YAW_LOCK is set) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            arraySize = 4,
            description = "Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation, the frame is depends on whether the flag GIMBAL_MANAGER_FLAGS_YAW_LOCK is set)"
    )
    public final List<Float> q() {
        return this.q;
    }

    /**
     * X component of angular velocity, positive is rolling to the right, NaN to be ignored. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "X component of angular velocity, positive is rolling to the right, NaN to be ignored."
    )
    public final float angularVelocityX() {
        return this.angularVelocityX;
    }

    /**
     * Y component of angular velocity, positive is pitching up, NaN to be ignored. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Y component of angular velocity, positive is pitching up, NaN to be ignored."
    )
    public final float angularVelocityY() {
        return this.angularVelocityY;
    }

    /**
     * Z component of angular velocity, positive is yawing to the right, NaN to be ignored. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Z component of angular velocity, positive is yawing to the right, NaN to be ignored."
    )
    public final float angularVelocityZ() {
        return this.angularVelocityZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        GimbalManagerSetAttitude other = (GimbalManagerSetAttitude)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(flags, other.flags)) return false;
        if (!Objects.deepEquals(gimbalDeviceId, other.gimbalDeviceId)) return false;
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
        result = 31 * result + Objects.hashCode(gimbalDeviceId);
        result = 31 * result + Objects.hashCode(q);
        result = 31 * result + Objects.hashCode(angularVelocityX);
        result = 31 * result + Objects.hashCode(angularVelocityY);
        result = 31 * result + Objects.hashCode(angularVelocityZ);
        return result;
    }

    @Override
    public String toString() {
        return "GimbalManagerSetAttitude{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", flags=" + flags
                 + ", gimbalDeviceId=" + gimbalDeviceId
                 + ", q=" + q
                 + ", angularVelocityX=" + angularVelocityX
                 + ", angularVelocityY=" + angularVelocityY
                 + ", angularVelocityZ=" + angularVelocityZ + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private EnumValue<GimbalManagerFlags> flags;

        private int gimbalDeviceId;

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
         * High level gimbal manager flags to use. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                enumType = GimbalManagerFlags.class,
                description = "High level gimbal manager flags to use."
        )
        public final Builder flags(EnumValue<GimbalManagerFlags> flags) {
            this.flags = flags;
            return this;
        }

        /**
         * High level gimbal manager flags to use. 
         */
        public final Builder flags(GimbalManagerFlags entry) {
            return flags(EnumValue.of(entry));
        }

        /**
         * High level gimbal manager flags to use. 
         */
        public final Builder flags(Enum... flags) {
            return flags(EnumValue.create(flags));
        }

        /**
         * High level gimbal manager flags to use. 
         */
        public final Builder flags(Collection<Enum> flags) {
            return flags(EnumValue.create(flags));
        }

        /**
         * Component ID of gimbal device to address (or 1-6 for non-MAVLink gimbal), 0 for all gimbal 
         * device components. Send command multiple times for more than one gimbal (but not all gimbals). 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                description = "Component ID of gimbal device to address (or 1-6 for non-MAVLink gimbal), 0 for all gimbal device components. Send command multiple times for more than one gimbal (but not all gimbals)."
        )
        public final Builder gimbalDeviceId(int gimbalDeviceId) {
            this.gimbalDeviceId = gimbalDeviceId;
            return this;
        }

        /**
         * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation, the frame is depends on whether 
         * the flag GIMBAL_MANAGER_FLAGS_YAW_LOCK is set) 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                arraySize = 4,
                description = "Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation, the frame is depends on whether the flag GIMBAL_MANAGER_FLAGS_YAW_LOCK is set)"
        )
        public final Builder q(List<Float> q) {
            this.q = q;
            return this;
        }

        /**
         * X component of angular velocity, positive is rolling to the right, NaN to be ignored. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "X component of angular velocity, positive is rolling to the right, NaN to be ignored."
        )
        public final Builder angularVelocityX(float angularVelocityX) {
            this.angularVelocityX = angularVelocityX;
            return this;
        }

        /**
         * Y component of angular velocity, positive is pitching up, NaN to be ignored. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Y component of angular velocity, positive is pitching up, NaN to be ignored."
        )
        public final Builder angularVelocityY(float angularVelocityY) {
            this.angularVelocityY = angularVelocityY;
            return this;
        }

        /**
         * Z component of angular velocity, positive is yawing to the right, NaN to be ignored. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Z component of angular velocity, positive is yawing to the right, NaN to be ignored."
        )
        public final Builder angularVelocityZ(float angularVelocityZ) {
            this.angularVelocityZ = angularVelocityZ;
            return this;
        }

        public final GimbalManagerSetAttitude build() {
            return new GimbalManagerSetAttitude(targetSystem, targetComponent, flags, gimbalDeviceId, q, angularVelocityX, angularVelocityY, angularVelocityZ);
        }
    }
}
