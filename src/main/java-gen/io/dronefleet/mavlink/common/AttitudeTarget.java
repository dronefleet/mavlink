package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Float;
import java.util.List;

/**
 * Reports the current commanded attitude of the vehicle as specified by the autopilot. This 
 * should match the commands sent in a {@link io.dronefleet.mavlink.common.SetAttitudeTarget SET_ATTITUDE_TARGET} message if the vehicle is being 
 * controlled this way. 
 */
@MavlinkMessageInfo(
        id = 83,
        crc = 22
)
public final class AttitudeTarget {
    private final long timeBootMs;

    private final int typeMask;

    private final List<Float> q;

    private final float bodyRollRate;

    private final float bodyPitchRate;

    private final float bodyYawRate;

    private final float thrust;

    private AttitudeTarget(long timeBootMs, int typeMask, List<Float> q, float bodyRollRate,
            float bodyPitchRate, float bodyYawRate, float thrust) {
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
     * Timestamp in milliseconds since system boot 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * Mappings: If any of these bits are set, the corresponding input should be ignored: bit 1: body 
     * roll rate, bit 2: body pitch rate, bit 3: body yaw rate. bit 4-bit 7: reserved, bit 8: attitude 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int typeMask() {
        return this.typeMask;
    }

    /**
     * Attitude quaternion (w, x, y, z order, zero-rotation is 1, 0, 0, 0) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            arraySize = 4
    )
    public final List<Float> q() {
        return this.q;
    }

    /**
     * Body roll rate in radians per second 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float bodyRollRate() {
        return this.bodyRollRate;
    }

    /**
     * Body pitch rate in radians per second 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float bodyPitchRate() {
        return this.bodyPitchRate;
    }

    /**
     * Body yaw rate in radians per second 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float bodyYawRate() {
        return this.bodyYawRate;
    }

    /**
     * Collective thrust, normalized to 0 .. 1 (-1 .. 1 for vehicles capable of reverse trust) 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float thrust() {
        return this.thrust;
    }

    public static final class Builder {
        private long timeBootMs;

        private int typeMask;

        private List<Float> q;

        private float bodyRollRate;

        private float bodyPitchRate;

        private float bodyYawRate;

        private float thrust;

        /**
         * Timestamp in milliseconds since system boot 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * Mappings: If any of these bits are set, the corresponding input should be ignored: bit 1: body 
         * roll rate, bit 2: body pitch rate, bit 3: body yaw rate. bit 4-bit 7: reserved, bit 8: attitude 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder typeMask(int typeMask) {
            this.typeMask = typeMask;
            return this;
        }

        /**
         * Attitude quaternion (w, x, y, z order, zero-rotation is 1, 0, 0, 0) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                arraySize = 4
        )
        public final Builder q(List<Float> q) {
            this.q = q;
            return this;
        }

        /**
         * Body roll rate in radians per second 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder bodyRollRate(float bodyRollRate) {
            this.bodyRollRate = bodyRollRate;
            return this;
        }

        /**
         * Body pitch rate in radians per second 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder bodyPitchRate(float bodyPitchRate) {
            this.bodyPitchRate = bodyPitchRate;
            return this;
        }

        /**
         * Body yaw rate in radians per second 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
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
                unitSize = 4
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
