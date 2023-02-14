package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
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
 * Sets a desired vehicle attitude. Used by an external controller to command the vehicle (manual 
 * controller or other system). 
 */
@MavlinkMessageInfo(
        id = 82,
        crc = 49,
        description = "Sets a desired vehicle attitude. Used by an external controller to command the vehicle (manual controller or other system)."
)
public final class SetAttitudeTarget {
    private final long timeBootMs;

    private final int targetSystem;

    private final int targetComponent;

    private final EnumValue<AttitudeTargetTypemask> typeMask;

    private final List<Float> q;

    private final float bodyRollRate;

    private final float bodyPitchRate;

    private final float bodyYawRate;

    private final float thrust;

    private final List<Float> thrustBody;

    private SetAttitudeTarget(long timeBootMs, int targetSystem, int targetComponent,
            EnumValue<AttitudeTargetTypemask> typeMask, List<Float> q, float bodyRollRate,
            float bodyPitchRate, float bodyYawRate, float thrust, List<Float> thrustBody) {
        this.timeBootMs = timeBootMs;
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.typeMask = typeMask;
        this.q = q;
        this.bodyRollRate = bodyRollRate;
        this.bodyPitchRate = bodyPitchRate;
        this.bodyYawRate = bodyYawRate;
        this.thrust = thrust;
        this.thrustBody = thrustBody;
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
     * Bitmap to indicate which dimensions should be ignored by the vehicle. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            enumType = AttitudeTargetTypemask.class,
            description = "Bitmap to indicate which dimensions should be ignored by the vehicle."
    )
    public final EnumValue<AttitudeTargetTypemask> typeMask() {
        return this.typeMask;
    }

    /**
     * Attitude quaternion (w, x, y, z order, zero-rotation is 1, 0, 0, 0) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            arraySize = 4,
            description = "Attitude quaternion (w, x, y, z order, zero-rotation is 1, 0, 0, 0)"
    )
    public final List<Float> q() {
        return this.q;
    }

    /**
     * Body roll rate 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Body roll rate"
    )
    public final float bodyRollRate() {
        return this.bodyRollRate;
    }

    /**
     * Body pitch rate 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Body pitch rate"
    )
    public final float bodyPitchRate() {
        return this.bodyPitchRate;
    }

    /**
     * Body yaw rate 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Body yaw rate"
    )
    public final float bodyYawRate() {
        return this.bodyYawRate;
    }

    /**
     * Collective thrust, normalized to 0 .. 1 (-1 .. 1 for vehicles capable of reverse trust) 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Collective thrust, normalized to 0 .. 1 (-1 .. 1 for vehicles capable of reverse trust)"
    )
    public final float thrust() {
        return this.thrust;
    }

    /**
     * 3D thrust setpoint in the body NED frame, normalized to -1 .. 1 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            arraySize = 3,
            extension = true,
            description = "3D thrust setpoint in the body NED frame, normalized to -1 .. 1"
    )
    public final List<Float> thrustBody() {
        return this.thrustBody;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SetAttitudeTarget other = (SetAttitudeTarget)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(typeMask, other.typeMask)) return false;
        if (!Objects.deepEquals(q, other.q)) return false;
        if (!Objects.deepEquals(bodyRollRate, other.bodyRollRate)) return false;
        if (!Objects.deepEquals(bodyPitchRate, other.bodyPitchRate)) return false;
        if (!Objects.deepEquals(bodyYawRate, other.bodyYawRate)) return false;
        if (!Objects.deepEquals(thrust, other.thrust)) return false;
        if (!Objects.deepEquals(thrustBody, other.thrustBody)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(typeMask);
        result = 31 * result + Objects.hashCode(q);
        result = 31 * result + Objects.hashCode(bodyRollRate);
        result = 31 * result + Objects.hashCode(bodyPitchRate);
        result = 31 * result + Objects.hashCode(bodyYawRate);
        result = 31 * result + Objects.hashCode(thrust);
        result = 31 * result + Objects.hashCode(thrustBody);
        return result;
    }

    @Override
    public String toString() {
        return "SetAttitudeTarget{timeBootMs=" + timeBootMs
                 + ", targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", typeMask=" + typeMask
                 + ", q=" + q
                 + ", bodyRollRate=" + bodyRollRate
                 + ", bodyPitchRate=" + bodyPitchRate
                 + ", bodyYawRate=" + bodyYawRate
                 + ", thrust=" + thrust
                 + ", thrustBody=" + thrustBody + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private int targetSystem;

        private int targetComponent;

        private EnumValue<AttitudeTargetTypemask> typeMask;

        private List<Float> q;

        private float bodyRollRate;

        private float bodyPitchRate;

        private float bodyYawRate;

        private float thrust;

        private List<Float> thrustBody;

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
         * Bitmap to indicate which dimensions should be ignored by the vehicle. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                enumType = AttitudeTargetTypemask.class,
                description = "Bitmap to indicate which dimensions should be ignored by the vehicle."
        )
        public final Builder typeMask(EnumValue<AttitudeTargetTypemask> typeMask) {
            this.typeMask = typeMask;
            return this;
        }

        /**
         * Bitmap to indicate which dimensions should be ignored by the vehicle. 
         */
        public final Builder typeMask(AttitudeTargetTypemask entry) {
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
         * Attitude quaternion (w, x, y, z order, zero-rotation is 1, 0, 0, 0) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                arraySize = 4,
                description = "Attitude quaternion (w, x, y, z order, zero-rotation is 1, 0, 0, 0)"
        )
        public final Builder q(List<Float> q) {
            this.q = q;
            return this;
        }

        /**
         * Body roll rate 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Body roll rate"
        )
        public final Builder bodyRollRate(float bodyRollRate) {
            this.bodyRollRate = bodyRollRate;
            return this;
        }

        /**
         * Body pitch rate 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Body pitch rate"
        )
        public final Builder bodyPitchRate(float bodyPitchRate) {
            this.bodyPitchRate = bodyPitchRate;
            return this;
        }

        /**
         * Body yaw rate 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Body yaw rate"
        )
        public final Builder bodyYawRate(float bodyYawRate) {
            this.bodyYawRate = bodyYawRate;
            return this;
        }

        /**
         * Collective thrust, normalized to 0 .. 1 (-1 .. 1 for vehicles capable of reverse trust) 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Collective thrust, normalized to 0 .. 1 (-1 .. 1 for vehicles capable of reverse trust)"
        )
        public final Builder thrust(float thrust) {
            this.thrust = thrust;
            return this;
        }

        /**
         * 3D thrust setpoint in the body NED frame, normalized to -1 .. 1 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                arraySize = 3,
                extension = true,
                description = "3D thrust setpoint in the body NED frame, normalized to -1 .. 1"
        )
        public final Builder thrustBody(List<Float> thrustBody) {
            this.thrustBody = thrustBody;
            return this;
        }

        public final SetAttitudeTarget build() {
            return new SetAttitudeTarget(timeBootMs, targetSystem, targetComponent, typeMask, q, bodyRollRate, bodyPitchRate, bodyYawRate, thrust, thrustBody);
        }
    }
}
