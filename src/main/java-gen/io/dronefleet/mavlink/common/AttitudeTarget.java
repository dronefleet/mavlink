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
 * Reports the current commanded attitude of the vehicle as specified by the autopilot. This 
 * should match the commands sent in a {@link io.dronefleet.mavlink.common.SetAttitudeTarget SET_ATTITUDE_TARGET} message if the vehicle is being 
 * controlled this way. 
 */
@MavlinkMessageInfo(
        id = 83,
        crc = 22,
        description = "Reports the current commanded attitude of the vehicle as specified by the autopilot. This should match the commands sent in a SET_ATTITUDE_TARGET message if the vehicle is being controlled this way."
)
public final class AttitudeTarget {
    private final long timeBootMs;

    private final EnumValue<AttitudeTargetTypemask> typeMask;

    private final List<Float> q;

    private final float bodyRollRate;

    private final float bodyPitchRate;

    private final float bodyYawRate;

    private final float thrust;

    private AttitudeTarget(long timeBootMs, EnumValue<AttitudeTargetTypemask> typeMask,
            List<Float> q, float bodyRollRate, float bodyPitchRate, float bodyYawRate,
            float thrust) {
        this.timeBootMs = timeBootMs;
        this.typeMask = typeMask;
        this.q = q;
        this.bodyRollRate = bodyRollRate;
        this.bodyPitchRate = bodyPitchRate;
        this.bodyYawRate = bodyYawRate;
        this.thrust = thrust;
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
     * Bitmap to indicate which dimensions should be ignored by the vehicle. 
     */
    @MavlinkFieldInfo(
            position = 2,
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
            position = 3,
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
            position = 4,
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
            position = 5,
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
            position = 6,
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
            position = 7,
            unitSize = 4,
            description = "Collective thrust, normalized to 0 .. 1 (-1 .. 1 for vehicles capable of reverse trust)"
    )
    public final float thrust() {
        return this.thrust;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        AttitudeTarget other = (AttitudeTarget)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(typeMask, other.typeMask)) return false;
        if (!Objects.deepEquals(q, other.q)) return false;
        if (!Objects.deepEquals(bodyRollRate, other.bodyRollRate)) return false;
        if (!Objects.deepEquals(bodyPitchRate, other.bodyPitchRate)) return false;
        if (!Objects.deepEquals(bodyYawRate, other.bodyYawRate)) return false;
        if (!Objects.deepEquals(thrust, other.thrust)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(typeMask);
        result = 31 * result + Objects.hashCode(q);
        result = 31 * result + Objects.hashCode(bodyRollRate);
        result = 31 * result + Objects.hashCode(bodyPitchRate);
        result = 31 * result + Objects.hashCode(bodyYawRate);
        result = 31 * result + Objects.hashCode(thrust);
        return result;
    }

    @Override
    public String toString() {
        return "AttitudeTarget{timeBootMs=" + timeBootMs
                 + ", typeMask=" + typeMask
                 + ", q=" + q
                 + ", bodyRollRate=" + bodyRollRate
                 + ", bodyPitchRate=" + bodyPitchRate
                 + ", bodyYawRate=" + bodyYawRate
                 + ", thrust=" + thrust + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private EnumValue<AttitudeTargetTypemask> typeMask;

        private List<Float> q;

        private float bodyRollRate;

        private float bodyPitchRate;

        private float bodyYawRate;

        private float thrust;

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
         * Bitmap to indicate which dimensions should be ignored by the vehicle. 
         */
        @MavlinkFieldInfo(
                position = 2,
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
                position = 3,
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
                position = 4,
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
                position = 5,
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
                position = 6,
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
                position = 7,
                unitSize = 4,
                description = "Collective thrust, normalized to 0 .. 1 (-1 .. 1 for vehicles capable of reverse trust)"
        )
        public final Builder thrust(float thrust) {
            this.thrust = thrust;
            return this;
        }

        public final AttitudeTarget build() {
            return new AttitudeTarget(timeBootMs, typeMask, q, bodyRollRate, bodyPitchRate, bodyYawRate, thrust);
        }
    }
}
