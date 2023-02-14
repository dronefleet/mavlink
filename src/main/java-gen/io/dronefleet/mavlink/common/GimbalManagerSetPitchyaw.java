package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Deprecated;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * High level message to control a gimbal's pitch and yaw angles. This message is to be sent to the 
 * gimbal manager (e.g. from a ground station). Angles and rates can be set to NaN according to use 
 * case. 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 287,
        crc = 1,
        description = "High level message to control a gimbal's pitch and yaw angles. This message is to be sent to the gimbal manager (e.g. from a ground station). Angles and rates can be set to NaN according to use case.",
        workInProgress = true
)
@Deprecated
public final class GimbalManagerSetPitchyaw {
    private final int targetSystem;

    private final int targetComponent;

    private final EnumValue<GimbalManagerFlags> flags;

    private final int gimbalDeviceId;

    private final float pitch;

    private final float yaw;

    private final float pitchRate;

    private final float yawRate;

    private GimbalManagerSetPitchyaw(int targetSystem, int targetComponent,
            EnumValue<GimbalManagerFlags> flags, int gimbalDeviceId, float pitch, float yaw,
            float pitchRate, float yawRate) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.flags = flags;
        this.gimbalDeviceId = gimbalDeviceId;
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
     * Pitch angle (positive: up, negative: down, NaN to be ignored). 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Pitch angle (positive: up, negative: down, NaN to be ignored)."
    )
    public final float pitch() {
        return this.pitch;
    }

    /**
     * Yaw angle (positive: to the right, negative: to the left, NaN to be ignored). 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Yaw angle (positive: to the right, negative: to the left, NaN to be ignored)."
    )
    public final float yaw() {
        return this.yaw;
    }

    /**
     * Pitch angular rate (positive: up, negative: down, NaN to be ignored). 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Pitch angular rate (positive: up, negative: down, NaN to be ignored)."
    )
    public final float pitchRate() {
        return this.pitchRate;
    }

    /**
     * Yaw angular rate (positive: to the right, negative: to the left, NaN to be ignored). 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Yaw angular rate (positive: to the right, negative: to the left, NaN to be ignored)."
    )
    public final float yawRate() {
        return this.yawRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        GimbalManagerSetPitchyaw other = (GimbalManagerSetPitchyaw)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(flags, other.flags)) return false;
        if (!Objects.deepEquals(gimbalDeviceId, other.gimbalDeviceId)) return false;
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
        result = 31 * result + Objects.hashCode(flags);
        result = 31 * result + Objects.hashCode(gimbalDeviceId);
        result = 31 * result + Objects.hashCode(pitch);
        result = 31 * result + Objects.hashCode(yaw);
        result = 31 * result + Objects.hashCode(pitchRate);
        result = 31 * result + Objects.hashCode(yawRate);
        return result;
    }

    @Override
    public String toString() {
        return "GimbalManagerSetPitchyaw{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", flags=" + flags
                 + ", gimbalDeviceId=" + gimbalDeviceId
                 + ", pitch=" + pitch
                 + ", yaw=" + yaw
                 + ", pitchRate=" + pitchRate
                 + ", yawRate=" + yawRate + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private EnumValue<GimbalManagerFlags> flags;

        private int gimbalDeviceId;

        private float pitch;

        private float yaw;

        private float pitchRate;

        private float yawRate;

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
         * Pitch angle (positive: up, negative: down, NaN to be ignored). 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Pitch angle (positive: up, negative: down, NaN to be ignored)."
        )
        public final Builder pitch(float pitch) {
            this.pitch = pitch;
            return this;
        }

        /**
         * Yaw angle (positive: to the right, negative: to the left, NaN to be ignored). 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Yaw angle (positive: to the right, negative: to the left, NaN to be ignored)."
        )
        public final Builder yaw(float yaw) {
            this.yaw = yaw;
            return this;
        }

        /**
         * Pitch angular rate (positive: up, negative: down, NaN to be ignored). 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Pitch angular rate (positive: up, negative: down, NaN to be ignored)."
        )
        public final Builder pitchRate(float pitchRate) {
            this.pitchRate = pitchRate;
            return this;
        }

        /**
         * Yaw angular rate (positive: to the right, negative: to the left, NaN to be ignored). 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Yaw angular rate (positive: to the right, negative: to the left, NaN to be ignored)."
        )
        public final Builder yawRate(float yawRate) {
            this.yawRate = yawRate;
            return this;
        }

        public final GimbalManagerSetPitchyaw build() {
            return new GimbalManagerSetPitchyaw(targetSystem, targetComponent, flags, gimbalDeviceId, pitch, yaw, pitchRate, yawRate);
        }
    }
}
