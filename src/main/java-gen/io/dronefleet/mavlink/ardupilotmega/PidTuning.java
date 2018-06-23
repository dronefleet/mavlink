package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * PID tuning information 
 */
@MavlinkMessageInfo(
        id = 194,
        crc = 98
)
public final class PidTuning {
    /**
     * desired rate (degrees/s) 
     */
    private final float desired;

    /**
     * achieved rate (degrees/s) 
     */
    private final float achieved;

    /**
     * FF component 
     */
    private final float ff;

    /**
     * P component 
     */
    private final float p;

    /**
     * I component 
     */
    private final float i;

    /**
     * D component 
     */
    private final float d;

    /**
     * axis 
     */
    private final PidTuningAxis axis;

    private PidTuning(float desired, float achieved, float ff, float p, float i, float d,
            PidTuningAxis axis) {
        this.desired = desired;
        this.achieved = achieved;
        this.ff = ff;
        this.p = p;
        this.i = i;
        this.d = d;
        this.axis = axis;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "PidTuning{axis=" + axis
                 + ", desired=" + desired
                 + ", achieved=" + achieved
                 + ", ff=" + ff
                 + ", p=" + p
                 + ", i=" + i
                 + ", d=" + d + "}";
    }

    /**
     * desired rate (degrees/s) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float desired() {
        return desired;
    }

    /**
     * achieved rate (degrees/s) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float achieved() {
        return achieved;
    }

    /**
     * FF component 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float ff() {
        return ff;
    }

    /**
     * P component 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float p() {
        return p;
    }

    /**
     * I component 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float i() {
        return i;
    }

    /**
     * D component 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float d() {
        return d;
    }

    /**
     * axis 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final PidTuningAxis axis() {
        return axis;
    }

    public static class Builder {
        private float desired;

        private float achieved;

        private float ff;

        private float p;

        private float i;

        private float d;

        private PidTuningAxis axis;

        private Builder() {
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

        public final PidTuning build() {
            return new PidTuning(desired, achieved, ff, p, i, d, axis);
        }
    }
}
