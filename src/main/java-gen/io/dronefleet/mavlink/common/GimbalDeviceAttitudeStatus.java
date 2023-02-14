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
 * Message reporting the status of a gimbal device. This message should be broadcast by a gimbal 
 * device component at a low regular rate (e.g. 5 Hz). For the angles encoded in the quaternion and 
 * the angular velocities holds: If the flag GIMBAL_DEVICE_FLAGS_YAW_IN_VEHICLE_FRAME is 
 * set, then they are relative to the vehicle heading (vehicle frame). If the flag 
 * GIMBAL_DEVICE_FLAGS_YAW_IN_EARTH_FRAME is set, then they are relative to absolute North 
 * (earth frame). If neither of these flags are set, then (for backwards compatibility) it holds: 
 * If the flag GIMBAL_DEVICE_FLAGS_YAW_LOCK is set, then they are relative to absolute North 
 * (earth frame), else they are relative to the vehicle heading (vehicle frame). Other 
 * conditions of the flags are not allowed. The quaternion and angular velocities in the other 
 * frame can be calculated from delta_yaw and delta_yaw_velocity as q_earth = q_delta_yaw * 
 * q_vehicle and w_earth = w_delta_yaw_velocity + w_vehicle (if not NaN). If neither the 
 * GIMBAL_DEVICE_FLAGS_YAW_IN_VEHICLE_FRAME nor the 
 * GIMBAL_DEVICE_FLAGS_YAW_IN_EARTH_FRAME flag is set, then (for backwards compatibility) 
 * the data in the delta_yaw and delta_yaw_velocity fields are to be ignored. New 
 * implementations should always set either GIMBAL_DEVICE_FLAGS_YAW_IN_VEHICLE_FRAME or 
 * GIMBAL_DEVICE_FLAGS_YAW_IN_EARTH_FRAME, and always should set delta_yaw and 
 * delta_yaw_velocity either to the proper value or NaN. 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 285,
        crc = 137,
        description = "Message reporting the status of a gimbal device. \n"
                        + "\t  This message should be broadcast by a gimbal device component at a low regular rate (e.g. 5 Hz). \n"
                        + "\t  For the angles encoded in the quaternion and the angular velocities holds: \n"
                        + "\t  If the flag GIMBAL_DEVICE_FLAGS_YAW_IN_VEHICLE_FRAME is set, then they are relative to the vehicle heading (vehicle frame). \n"
                        + "\t  If the flag GIMBAL_DEVICE_FLAGS_YAW_IN_EARTH_FRAME is set, then they are relative to absolute North (earth frame). \n"
                        + "\t  If neither of these flags are set, then (for backwards compatibility) it holds: \n"
                        + "\t  If the flag GIMBAL_DEVICE_FLAGS_YAW_LOCK is set, then they are relative to absolute North (earth frame), \n"
                        + "\t  else they are relative to the vehicle heading (vehicle frame). \n"
                        + "\t  Other conditions of the flags are not allowed. \n"
                        + "\t  The quaternion and angular velocities in the other frame can be calculated from delta_yaw and delta_yaw_velocity as \n"
                        + "\t  q_earth = q_delta_yaw * q_vehicle and w_earth = w_delta_yaw_velocity + w_vehicle (if not NaN).\n"
                        + "\t  If neither the GIMBAL_DEVICE_FLAGS_YAW_IN_VEHICLE_FRAME nor the GIMBAL_DEVICE_FLAGS_YAW_IN_EARTH_FRAME flag is set, \n"
                        + "\t  then (for backwards compatibility) the data in the delta_yaw and delta_yaw_velocity fields are to be ignored.\n"
                        + "\t  New implementations should always set either GIMBAL_DEVICE_FLAGS_YAW_IN_VEHICLE_FRAME or GIMBAL_DEVICE_FLAGS_YAW_IN_EARTH_FRAME, \n"
                        + "\t  and always should set delta_yaw and delta_yaw_velocity either to the proper value or NaN.",
        workInProgress = true
)
@Deprecated
public final class GimbalDeviceAttitudeStatus {
    private final int targetSystem;

    private final int targetComponent;

    private final long timeBootMs;

    private final EnumValue<GimbalDeviceFlags> flags;

    private final List<Float> q;

    private final float angularVelocityX;

    private final float angularVelocityY;

    private final float angularVelocityZ;

    private final EnumValue<GimbalDeviceErrorFlags> failureFlags;

    private final float deltaYaw;

    private final float deltaYawVelocity;

    private GimbalDeviceAttitudeStatus(int targetSystem, int targetComponent, long timeBootMs,
            EnumValue<GimbalDeviceFlags> flags, List<Float> q, float angularVelocityX,
            float angularVelocityY, float angularVelocityZ,
            EnumValue<GimbalDeviceErrorFlags> failureFlags, float deltaYaw,
            float deltaYawVelocity) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.timeBootMs = timeBootMs;
        this.flags = flags;
        this.q = q;
        this.angularVelocityX = angularVelocityX;
        this.angularVelocityY = angularVelocityY;
        this.angularVelocityZ = angularVelocityZ;
        this.failureFlags = failureFlags;
        this.deltaYaw = deltaYaw;
        this.deltaYawVelocity = deltaYawVelocity;
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
     * Timestamp (time since system boot). 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Timestamp (time since system boot)."
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * Current gimbal flags set. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            enumType = GimbalDeviceFlags.class,
            description = "Current gimbal flags set."
    )
    public final EnumValue<GimbalDeviceFlags> flags() {
        return this.flags;
    }

    /**
     * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation). The frame is described in the 
     * message description. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            arraySize = 4,
            description = "Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation). The frame is described in the message description."
    )
    public final List<Float> q() {
        return this.q;
    }

    /**
     * X component of angular velocity (positive: rolling to the right). The frame is described in the 
     * message description. NaN if unknown. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "X component of angular velocity (positive: rolling to the right). The frame is described in the message description. NaN if unknown."
    )
    public final float angularVelocityX() {
        return this.angularVelocityX;
    }

    /**
     * Y component of angular velocity (positive: pitching up). The frame is described in the message 
     * description. NaN if unknown. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Y component of angular velocity (positive: pitching up). The frame is described in the message description. NaN if unknown."
    )
    public final float angularVelocityY() {
        return this.angularVelocityY;
    }

    /**
     * Z component of angular velocity (positive: yawing to the right). The frame is described in the 
     * message description. NaN if unknown. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Z component of angular velocity (positive: yawing to the right). The frame is described in the message description. NaN if unknown."
    )
    public final float angularVelocityZ() {
        return this.angularVelocityZ;
    }

    /**
     * Failure flags (0 for no failure) 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            enumType = GimbalDeviceErrorFlags.class,
            description = "Failure flags (0 for no failure)"
    )
    public final EnumValue<GimbalDeviceErrorFlags> failureFlags() {
        return this.failureFlags;
    }

    /**
     * Yaw angle relating the quaternions in earth and body frames (see message description). NaN if 
     * unknown. 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4,
            extension = true,
            description = "Yaw angle relating the quaternions in earth and body frames (see message description). NaN if unknown."
    )
    public final float deltaYaw() {
        return this.deltaYaw;
    }

    /**
     * Yaw angular velocity relating the angular velocities in earth and body frames (see message 
     * description). NaN if unknown. 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 4,
            extension = true,
            description = "Yaw angular velocity relating the angular velocities in earth and body frames (see message description). NaN if unknown."
    )
    public final float deltaYawVelocity() {
        return this.deltaYawVelocity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        GimbalDeviceAttitudeStatus other = (GimbalDeviceAttitudeStatus)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(flags, other.flags)) return false;
        if (!Objects.deepEquals(q, other.q)) return false;
        if (!Objects.deepEquals(angularVelocityX, other.angularVelocityX)) return false;
        if (!Objects.deepEquals(angularVelocityY, other.angularVelocityY)) return false;
        if (!Objects.deepEquals(angularVelocityZ, other.angularVelocityZ)) return false;
        if (!Objects.deepEquals(failureFlags, other.failureFlags)) return false;
        if (!Objects.deepEquals(deltaYaw, other.deltaYaw)) return false;
        if (!Objects.deepEquals(deltaYawVelocity, other.deltaYawVelocity)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(flags);
        result = 31 * result + Objects.hashCode(q);
        result = 31 * result + Objects.hashCode(angularVelocityX);
        result = 31 * result + Objects.hashCode(angularVelocityY);
        result = 31 * result + Objects.hashCode(angularVelocityZ);
        result = 31 * result + Objects.hashCode(failureFlags);
        result = 31 * result + Objects.hashCode(deltaYaw);
        result = 31 * result + Objects.hashCode(deltaYawVelocity);
        return result;
    }

    @Override
    public String toString() {
        return "GimbalDeviceAttitudeStatus{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", timeBootMs=" + timeBootMs
                 + ", flags=" + flags
                 + ", q=" + q
                 + ", angularVelocityX=" + angularVelocityX
                 + ", angularVelocityY=" + angularVelocityY
                 + ", angularVelocityZ=" + angularVelocityZ
                 + ", failureFlags=" + failureFlags
                 + ", deltaYaw=" + deltaYaw
                 + ", deltaYawVelocity=" + deltaYawVelocity + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private long timeBootMs;

        private EnumValue<GimbalDeviceFlags> flags;

        private List<Float> q;

        private float angularVelocityX;

        private float angularVelocityY;

        private float angularVelocityZ;

        private EnumValue<GimbalDeviceErrorFlags> failureFlags;

        private float deltaYaw;

        private float deltaYawVelocity;

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
         * Timestamp (time since system boot). 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Timestamp (time since system boot)."
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * Current gimbal flags set. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                enumType = GimbalDeviceFlags.class,
                description = "Current gimbal flags set."
        )
        public final Builder flags(EnumValue<GimbalDeviceFlags> flags) {
            this.flags = flags;
            return this;
        }

        /**
         * Current gimbal flags set. 
         */
        public final Builder flags(GimbalDeviceFlags entry) {
            return flags(EnumValue.of(entry));
        }

        /**
         * Current gimbal flags set. 
         */
        public final Builder flags(Enum... flags) {
            return flags(EnumValue.create(flags));
        }

        /**
         * Current gimbal flags set. 
         */
        public final Builder flags(Collection<Enum> flags) {
            return flags(EnumValue.create(flags));
        }

        /**
         * Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation). The frame is described in the 
         * message description. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                arraySize = 4,
                description = "Quaternion components, w, x, y, z (1 0 0 0 is the null-rotation). The frame is described in the message description."
        )
        public final Builder q(List<Float> q) {
            this.q = q;
            return this;
        }

        /**
         * X component of angular velocity (positive: rolling to the right). The frame is described in the 
         * message description. NaN if unknown. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "X component of angular velocity (positive: rolling to the right). The frame is described in the message description. NaN if unknown."
        )
        public final Builder angularVelocityX(float angularVelocityX) {
            this.angularVelocityX = angularVelocityX;
            return this;
        }

        /**
         * Y component of angular velocity (positive: pitching up). The frame is described in the message 
         * description. NaN if unknown. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Y component of angular velocity (positive: pitching up). The frame is described in the message description. NaN if unknown."
        )
        public final Builder angularVelocityY(float angularVelocityY) {
            this.angularVelocityY = angularVelocityY;
            return this;
        }

        /**
         * Z component of angular velocity (positive: yawing to the right). The frame is described in the 
         * message description. NaN if unknown. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Z component of angular velocity (positive: yawing to the right). The frame is described in the message description. NaN if unknown."
        )
        public final Builder angularVelocityZ(float angularVelocityZ) {
            this.angularVelocityZ = angularVelocityZ;
            return this;
        }

        /**
         * Failure flags (0 for no failure) 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                enumType = GimbalDeviceErrorFlags.class,
                description = "Failure flags (0 for no failure)"
        )
        public final Builder failureFlags(EnumValue<GimbalDeviceErrorFlags> failureFlags) {
            this.failureFlags = failureFlags;
            return this;
        }

        /**
         * Failure flags (0 for no failure) 
         */
        public final Builder failureFlags(GimbalDeviceErrorFlags entry) {
            return failureFlags(EnumValue.of(entry));
        }

        /**
         * Failure flags (0 for no failure) 
         */
        public final Builder failureFlags(Enum... flags) {
            return failureFlags(EnumValue.create(flags));
        }

        /**
         * Failure flags (0 for no failure) 
         */
        public final Builder failureFlags(Collection<Enum> flags) {
            return failureFlags(EnumValue.create(flags));
        }

        /**
         * Yaw angle relating the quaternions in earth and body frames (see message description). NaN if 
         * unknown. 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4,
                extension = true,
                description = "Yaw angle relating the quaternions in earth and body frames (see message description). NaN if unknown."
        )
        public final Builder deltaYaw(float deltaYaw) {
            this.deltaYaw = deltaYaw;
            return this;
        }

        /**
         * Yaw angular velocity relating the angular velocities in earth and body frames (see message 
         * description). NaN if unknown. 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 4,
                extension = true,
                description = "Yaw angular velocity relating the angular velocities in earth and body frames (see message description). NaN if unknown."
        )
        public final Builder deltaYawVelocity(float deltaYawVelocity) {
            this.deltaYawVelocity = deltaYawVelocity;
            return this;
        }

        public final GimbalDeviceAttitudeStatus build() {
            return new GimbalDeviceAttitudeStatus(targetSystem, targetComponent, timeBootMs, flags, q, angularVelocityX, angularVelocityY, angularVelocityZ, failureFlags, deltaYaw, deltaYawVelocity);
        }
    }
}
