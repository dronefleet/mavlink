package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * PID tuning information. 
 */
@MavlinkMessageInfo(
        id = 194,
        crc = 98,
        description = "PID tuning information."
)
public final class PidTuning {
    private final EnumValue<PidTuningAxis> axis;

    private final float desired;

    private final float achieved;

    private final float ff;

    private final float p;

    private final float i;

    private final float d;

    private PidTuning(EnumValue<PidTuningAxis> axis, float desired, float achieved, float ff,
            float p, float i, float d) {
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
     * Axis. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            enumType = PidTuningAxis.class,
            description = "Axis."
    )
    public final EnumValue<PidTuningAxis> axis() {
        return this.axis;
    }

    /**
     * Desired rate. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Desired rate."
    )
    public final float desired() {
        return this.desired;
    }

    /**
     * Achieved rate. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Achieved rate."
    )
    public final float achieved() {
        return this.achieved;
    }

    /**
     * FF component. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "FF component."
    )
    public final float ff() {
        return this.ff;
    }

    /**
     * P component. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "P component."
    )
    public final float p() {
        return this.p;
    }

    /**
     * I component. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "I component."
    )
    public final float i() {
        return this.i;
    }

    /**
     * D component. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "D component."
    )
    public final float d() {
        return this.d;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        PidTuning other = (PidTuning)o;
        if (!Objects.deepEquals(axis, other.axis)) return false;
        if (!Objects.deepEquals(desired, other.desired)) return false;
        if (!Objects.deepEquals(achieved, other.achieved)) return false;
        if (!Objects.deepEquals(ff, other.ff)) return false;
        if (!Objects.deepEquals(p, other.p)) return false;
        if (!Objects.deepEquals(i, other.i)) return false;
        if (!Objects.deepEquals(d, other.d)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(axis);
        result = 31 * result + Objects.hashCode(desired);
        result = 31 * result + Objects.hashCode(achieved);
        result = 31 * result + Objects.hashCode(ff);
        result = 31 * result + Objects.hashCode(p);
        result = 31 * result + Objects.hashCode(i);
        result = 31 * result + Objects.hashCode(d);
        return result;
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

    public static final class Builder {
        private EnumValue<PidTuningAxis> axis;

        private float desired;

        private float achieved;

        private float ff;

        private float p;

        private float i;

        private float d;

        /**
         * Axis. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                enumType = PidTuningAxis.class,
                description = "Axis."
        )
        public final Builder axis(EnumValue<PidTuningAxis> axis) {
            this.axis = axis;
            return this;
        }

        /**
         * Axis. 
         */
        public final Builder axis(PidTuningAxis entry) {
            return axis(EnumValue.of(entry));
        }

        /**
         * Axis. 
         */
        public final Builder axis(Enum... flags) {
            return axis(EnumValue.create(flags));
        }

        /**
         * Axis. 
         */
        public final Builder axis(Collection<Enum> flags) {
            return axis(EnumValue.create(flags));
        }

        /**
         * Desired rate. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Desired rate."
        )
        public final Builder desired(float desired) {
            this.desired = desired;
            return this;
        }

        /**
         * Achieved rate. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Achieved rate."
        )
        public final Builder achieved(float achieved) {
            this.achieved = achieved;
            return this;
        }

        /**
         * FF component. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "FF component."
        )
        public final Builder ff(float ff) {
            this.ff = ff;
            return this;
        }

        /**
         * P component. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "P component."
        )
        public final Builder p(float p) {
            this.p = p;
            return this;
        }

        /**
         * I component. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "I component."
        )
        public final Builder i(float i) {
            this.i = i;
            return this;
        }

        /**
         * D component. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "D component."
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
