package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * PID tuning information 
 */
@MavlinkMessageInfo(
        id = 194,
        crc = 98
)
public final class PidTuning {
    private final PidTuningAxis axis;

    private final float desired;

    private final float achieved;

    private final float ff;

    private final float p;

    private final float i;

    private final float d;

    private PidTuning(PidTuningAxis axis, float desired, float achieved, float ff, float p, float i,
            float d) {
        this.axis = axis;
        this.desired = desired;
        this.achieved = achieved;
        this.ff = ff;
        this.p = p;
        this.i = i;
        this.d = d;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * axis 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final PidTuningAxis axis() {
        return this.axis;
    }

    /**
     * desired rate (degrees/s) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float desired() {
        return this.desired;
    }

    /**
     * achieved rate (degrees/s) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float achieved() {
        return this.achieved;
    }

    /**
     * FF component 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float ff() {
        return this.ff;
    }

    /**
     * P component 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float p() {
        return this.p;
    }

    /**
     * I component 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float i() {
        return this.i;
    }

    /**
     * D component 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float d() {
        return this.d;
    }

    public static final class Builder {
        private PidTuningAxis axis;

        private float desired;

        private float achieved;

        private float ff;

        private float p;

        private float i;

        private float d;

        /**
         * axis 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder axis(PidTuningAxis axis) {
            this.axis = axis;
            return this;
        }

        /**
         * desired rate (degrees/s) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder desired(float desired) {
            this.desired = desired;
            return this;
        }

        /**
         * achieved rate (degrees/s) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder achieved(float achieved) {
            this.achieved = achieved;
            return this;
        }

        /**
         * FF component 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder ff(float ff) {
            this.ff = ff;
            return this;
        }

        /**
         * P component 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder p(float p) {
            this.p = p;
            return this;
        }

        /**
         * I component 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder i(float i) {
            this.i = i;
            return this;
        }

        /**
         * D component 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4
        )
        public final Builder d(float d) {
            this.d = d;
            return this;
        }

        public final PidTuning build() {
            return new PidTuning(axis, desired, achieved, ff, p, i, d);
        }
    }
}
