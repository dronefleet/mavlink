package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Maximum Power Point Tracker (MPPT) sensor data for solar module power performance tracking 
 */
@MavlinkMessageInfo(
        id = 202,
        crc = 231,
        description = "Maximum Power Point Tracker (MPPT) sensor data for solar module power performance tracking"
)
public final class SensMppt {
    private final BigInteger mpptTimestamp;

    private final float mppt1Volt;

    private final float mppt1Amp;

    private final int mppt1Pwm;

    private final int mppt1Status;

    private final float mppt2Volt;

    private final float mppt2Amp;

    private final int mppt2Pwm;

    private final int mppt2Status;

    private final float mppt3Volt;

    private final float mppt3Amp;

    private final int mppt3Pwm;

    private final int mppt3Status;

    private SensMppt(BigInteger mpptTimestamp, float mppt1Volt, float mppt1Amp, int mppt1Pwm,
            int mppt1Status, float mppt2Volt, float mppt2Amp, int mppt2Pwm, int mppt2Status,
            float mppt3Volt, float mppt3Amp, int mppt3Pwm, int mppt3Status) {
        this.mpptTimestamp = mpptTimestamp;
        this.mppt1Volt = mppt1Volt;
        this.mppt1Amp = mppt1Amp;
        this.mppt1Pwm = mppt1Pwm;
        this.mppt1Status = mppt1Status;
        this.mppt2Volt = mppt2Volt;
        this.mppt2Amp = mppt2Amp;
        this.mppt2Pwm = mppt2Pwm;
        this.mppt2Status = mppt2Status;
        this.mppt3Volt = mppt3Volt;
        this.mppt3Amp = mppt3Amp;
        this.mppt3Pwm = mppt3Pwm;
        this.mppt3Status = mppt3Status;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * MPPT last timestamp 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            description = "MPPT last timestamp"
    )
    public final BigInteger mpptTimestamp() {
        return this.mpptTimestamp;
    }

    /**
     * MPPT1 voltage 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "MPPT1 voltage"
    )
    public final float mppt1Volt() {
        return this.mppt1Volt;
    }

    /**
     * MPPT1 current 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "MPPT1 current"
    )
    public final float mppt1Amp() {
        return this.mppt1Amp;
    }

    /**
     * MPPT1 pwm 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            description = "MPPT1 pwm"
    )
    public final int mppt1Pwm() {
        return this.mppt1Pwm;
    }

    /**
     * MPPT1 status 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            description = "MPPT1 status"
    )
    public final int mppt1Status() {
        return this.mppt1Status;
    }

    /**
     * MPPT2 voltage 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "MPPT2 voltage"
    )
    public final float mppt2Volt() {
        return this.mppt2Volt;
    }

    /**
     * MPPT2 current 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "MPPT2 current"
    )
    public final float mppt2Amp() {
        return this.mppt2Amp;
    }

    /**
     * MPPT2 pwm 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2,
            description = "MPPT2 pwm"
    )
    public final int mppt2Pwm() {
        return this.mppt2Pwm;
    }

    /**
     * MPPT2 status 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 1,
            description = "MPPT2 status"
    )
    public final int mppt2Status() {
        return this.mppt2Status;
    }

    /**
     * MPPT3 voltage 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "MPPT3 voltage"
    )
    public final float mppt3Volt() {
        return this.mppt3Volt;
    }

    /**
     * MPPT3 current 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            description = "MPPT3 current"
    )
    public final float mppt3Amp() {
        return this.mppt3Amp;
    }

    /**
     * MPPT3 pwm 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 2,
            description = "MPPT3 pwm"
    )
    public final int mppt3Pwm() {
        return this.mppt3Pwm;
    }

    /**
     * MPPT3 status 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 1,
            description = "MPPT3 status"
    )
    public final int mppt3Status() {
        return this.mppt3Status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SensMppt other = (SensMppt)o;
        if (!Objects.deepEquals(mpptTimestamp, other.mpptTimestamp)) return false;
        if (!Objects.deepEquals(mppt1Volt, other.mppt1Volt)) return false;
        if (!Objects.deepEquals(mppt1Amp, other.mppt1Amp)) return false;
        if (!Objects.deepEquals(mppt1Pwm, other.mppt1Pwm)) return false;
        if (!Objects.deepEquals(mppt1Status, other.mppt1Status)) return false;
        if (!Objects.deepEquals(mppt2Volt, other.mppt2Volt)) return false;
        if (!Objects.deepEquals(mppt2Amp, other.mppt2Amp)) return false;
        if (!Objects.deepEquals(mppt2Pwm, other.mppt2Pwm)) return false;
        if (!Objects.deepEquals(mppt2Status, other.mppt2Status)) return false;
        if (!Objects.deepEquals(mppt3Volt, other.mppt3Volt)) return false;
        if (!Objects.deepEquals(mppt3Amp, other.mppt3Amp)) return false;
        if (!Objects.deepEquals(mppt3Pwm, other.mppt3Pwm)) return false;
        if (!Objects.deepEquals(mppt3Status, other.mppt3Status)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(mpptTimestamp);
        result = 31 * result + Objects.hashCode(mppt1Volt);
        result = 31 * result + Objects.hashCode(mppt1Amp);
        result = 31 * result + Objects.hashCode(mppt1Pwm);
        result = 31 * result + Objects.hashCode(mppt1Status);
        result = 31 * result + Objects.hashCode(mppt2Volt);
        result = 31 * result + Objects.hashCode(mppt2Amp);
        result = 31 * result + Objects.hashCode(mppt2Pwm);
        result = 31 * result + Objects.hashCode(mppt2Status);
        result = 31 * result + Objects.hashCode(mppt3Volt);
        result = 31 * result + Objects.hashCode(mppt3Amp);
        result = 31 * result + Objects.hashCode(mppt3Pwm);
        result = 31 * result + Objects.hashCode(mppt3Status);
        return result;
    }

    @Override
    public String toString() {
        return "SensMppt{mpptTimestamp=" + mpptTimestamp
                 + ", mppt1Volt=" + mppt1Volt
                 + ", mppt1Amp=" + mppt1Amp
                 + ", mppt1Pwm=" + mppt1Pwm
                 + ", mppt1Status=" + mppt1Status
                 + ", mppt2Volt=" + mppt2Volt
                 + ", mppt2Amp=" + mppt2Amp
                 + ", mppt2Pwm=" + mppt2Pwm
                 + ", mppt2Status=" + mppt2Status
                 + ", mppt3Volt=" + mppt3Volt
                 + ", mppt3Amp=" + mppt3Amp
                 + ", mppt3Pwm=" + mppt3Pwm
                 + ", mppt3Status=" + mppt3Status + "}";
    }

    public static final class Builder {
        private BigInteger mpptTimestamp;

        private float mppt1Volt;

        private float mppt1Amp;

        private int mppt1Pwm;

        private int mppt1Status;

        private float mppt2Volt;

        private float mppt2Amp;

        private int mppt2Pwm;

        private int mppt2Status;

        private float mppt3Volt;

        private float mppt3Amp;

        private int mppt3Pwm;

        private int mppt3Status;

        /**
         * MPPT last timestamp 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                description = "MPPT last timestamp"
        )
        public final Builder mpptTimestamp(BigInteger mpptTimestamp) {
            this.mpptTimestamp = mpptTimestamp;
            return this;
        }

        /**
         * MPPT1 voltage 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "MPPT1 voltage"
        )
        public final Builder mppt1Volt(float mppt1Volt) {
            this.mppt1Volt = mppt1Volt;
            return this;
        }

        /**
         * MPPT1 current 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "MPPT1 current"
        )
        public final Builder mppt1Amp(float mppt1Amp) {
            this.mppt1Amp = mppt1Amp;
            return this;
        }

        /**
         * MPPT1 pwm 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                description = "MPPT1 pwm"
        )
        public final Builder mppt1Pwm(int mppt1Pwm) {
            this.mppt1Pwm = mppt1Pwm;
            return this;
        }

        /**
         * MPPT1 status 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                description = "MPPT1 status"
        )
        public final Builder mppt1Status(int mppt1Status) {
            this.mppt1Status = mppt1Status;
            return this;
        }

        /**
         * MPPT2 voltage 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "MPPT2 voltage"
        )
        public final Builder mppt2Volt(float mppt2Volt) {
            this.mppt2Volt = mppt2Volt;
            return this;
        }

        /**
         * MPPT2 current 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "MPPT2 current"
        )
        public final Builder mppt2Amp(float mppt2Amp) {
            this.mppt2Amp = mppt2Amp;
            return this;
        }

        /**
         * MPPT2 pwm 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2,
                description = "MPPT2 pwm"
        )
        public final Builder mppt2Pwm(int mppt2Pwm) {
            this.mppt2Pwm = mppt2Pwm;
            return this;
        }

        /**
         * MPPT2 status 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 1,
                description = "MPPT2 status"
        )
        public final Builder mppt2Status(int mppt2Status) {
            this.mppt2Status = mppt2Status;
            return this;
        }

        /**
         * MPPT3 voltage 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "MPPT3 voltage"
        )
        public final Builder mppt3Volt(float mppt3Volt) {
            this.mppt3Volt = mppt3Volt;
            return this;
        }

        /**
         * MPPT3 current 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                description = "MPPT3 current"
        )
        public final Builder mppt3Amp(float mppt3Amp) {
            this.mppt3Amp = mppt3Amp;
            return this;
        }

        /**
         * MPPT3 pwm 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 2,
                description = "MPPT3 pwm"
        )
        public final Builder mppt3Pwm(int mppt3Pwm) {
            this.mppt3Pwm = mppt3Pwm;
            return this;
        }

        /**
         * MPPT3 status 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 1,
                description = "MPPT3 status"
        )
        public final Builder mppt3Status(int mppt3Status) {
            this.mppt3Status = mppt3Status;
            return this;
        }

        public final SensMppt build() {
            return new SensMppt(mpptTimestamp, mppt1Volt, mppt1Amp, mppt1Pwm, mppt1Status, mppt2Volt, mppt2Amp, mppt2Pwm, mppt2Status, mppt3Volt, mppt3Amp, mppt3Pwm, mppt3Status);
        }
    }
}
