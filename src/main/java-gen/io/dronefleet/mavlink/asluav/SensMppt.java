package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;

/**
 * Maximum Power Point Tracker (MPPT) sensor data for solar module power performance tracking 
 */
@MavlinkMessageInfo(
        id = 202,
        crc = 231
)
public final class SensMppt {
    /**
     * MPPT last timestamp 
     */
    private final BigInteger mpptTimestamp;

    /**
     * MPPT1 voltage 
     */
    private final float mppt1Volt;

    /**
     * MPPT1 current 
     */
    private final float mppt1Amp;

    /**
     * MPPT2 voltage 
     */
    private final float mppt2Volt;

    /**
     * MPPT2 current 
     */
    private final float mppt2Amp;

    /**
     * MPPT3 voltage 
     */
    private final float mppt3Volt;

    /**
     * MPPT3 current 
     */
    private final float mppt3Amp;

    /**
     * MPPT1 pwm 
     */
    private final int mppt1Pwm;

    /**
     * MPPT2 pwm 
     */
    private final int mppt2Pwm;

    /**
     * MPPT3 pwm 
     */
    private final int mppt3Pwm;

    /**
     * MPPT1 status 
     */
    private final int mppt1Status;

    /**
     * MPPT2 status 
     */
    private final int mppt2Status;

    /**
     * MPPT3 status 
     */
    private final int mppt3Status;

    private SensMppt(BigInteger mpptTimestamp, float mppt1Volt, float mppt1Amp, float mppt2Volt,
            float mppt2Amp, float mppt3Volt, float mppt3Amp, int mppt1Pwm, int mppt2Pwm,
            int mppt3Pwm, int mppt1Status, int mppt2Status, int mppt3Status) {
        this.mpptTimestamp = mpptTimestamp;
        this.mppt1Volt = mppt1Volt;
        this.mppt1Amp = mppt1Amp;
        this.mppt2Volt = mppt2Volt;
        this.mppt2Amp = mppt2Amp;
        this.mppt3Volt = mppt3Volt;
        this.mppt3Amp = mppt3Amp;
        this.mppt1Pwm = mppt1Pwm;
        this.mppt2Pwm = mppt2Pwm;
        this.mppt3Pwm = mppt3Pwm;
        this.mppt1Status = mppt1Status;
        this.mppt2Status = mppt2Status;
        this.mppt3Status = mppt3Status;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
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

    /**
     * MPPT last timestamp 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
    )
    public final BigInteger mpptTimestamp() {
        return mpptTimestamp;
    }

    /**
     * MPPT1 voltage 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float mppt1Volt() {
        return mppt1Volt;
    }

    /**
     * MPPT1 current 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float mppt1Amp() {
        return mppt1Amp;
    }

    /**
     * MPPT2 voltage 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float mppt2Volt() {
        return mppt2Volt;
    }

    /**
     * MPPT2 current 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float mppt2Amp() {
        return mppt2Amp;
    }

    /**
     * MPPT3 voltage 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4
    )
    public final float mppt3Volt() {
        return mppt3Volt;
    }

    /**
     * MPPT3 current 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4
    )
    public final float mppt3Amp() {
        return mppt3Amp;
    }

    /**
     * MPPT1 pwm 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2
    )
    public final int mppt1Pwm() {
        return mppt1Pwm;
    }

    /**
     * MPPT2 pwm 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2
    )
    public final int mppt2Pwm() {
        return mppt2Pwm;
    }

    /**
     * MPPT3 pwm 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 2
    )
    public final int mppt3Pwm() {
        return mppt3Pwm;
    }

    /**
     * MPPT1 status 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final int mppt1Status() {
        return mppt1Status;
    }

    /**
     * MPPT2 status 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 1
    )
    public final int mppt2Status() {
        return mppt2Status;
    }

    /**
     * MPPT3 status 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 1
    )
    public final int mppt3Status() {
        return mppt3Status;
    }

    public static class Builder {
        private BigInteger mpptTimestamp;

        private float mppt1Volt;

        private float mppt1Amp;

        private float mppt2Volt;

        private float mppt2Amp;

        private float mppt3Volt;

        private float mppt3Amp;

        private int mppt1Pwm;

        private int mppt2Pwm;

        private int mppt3Pwm;

        private int mppt1Status;

        private int mppt2Status;

        private int mppt3Status;

        private Builder() {
        }

        /**
         * MPPT last timestamp 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8
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
                unitSize = 4
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
                unitSize = 4
        )
        public final Builder mppt1Amp(float mppt1Amp) {
            this.mppt1Amp = mppt1Amp;
            return this;
        }

        /**
         * MPPT2 voltage 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
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
                unitSize = 4
        )
        public final Builder mppt2Amp(float mppt2Amp) {
            this.mppt2Amp = mppt2Amp;
            return this;
        }

        /**
         * MPPT3 voltage 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4
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
                unitSize = 4
        )
        public final Builder mppt3Amp(float mppt3Amp) {
            this.mppt3Amp = mppt3Amp;
            return this;
        }

        /**
         * MPPT1 pwm 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2
        )
        public final Builder mppt1Pwm(int mppt1Pwm) {
            this.mppt1Pwm = mppt1Pwm;
            return this;
        }

        /**
         * MPPT2 pwm 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2
        )
        public final Builder mppt2Pwm(int mppt2Pwm) {
            this.mppt2Pwm = mppt2Pwm;
            return this;
        }

        /**
         * MPPT3 pwm 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 2
        )
        public final Builder mppt3Pwm(int mppt3Pwm) {
            this.mppt3Pwm = mppt3Pwm;
            return this;
        }

        /**
         * MPPT1 status 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1
        )
        public final Builder mppt1Status(int mppt1Status) {
            this.mppt1Status = mppt1Status;
            return this;
        }

        /**
         * MPPT2 status 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 1
        )
        public final Builder mppt2Status(int mppt2Status) {
            this.mppt2Status = mppt2Status;
            return this;
        }

        /**
         * MPPT3 status 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 1
        )
        public final Builder mppt3Status(int mppt3Status) {
            this.mppt3Status = mppt3Status;
            return this;
        }

        public final SensMppt build() {
            return new SensMppt(mpptTimestamp, mppt1Volt, mppt1Amp, mppt2Volt, mppt2Amp, mppt3Volt, mppt3Amp, mppt1Pwm, mppt2Pwm, mppt3Pwm, mppt1Status, mppt2Status, mppt3Status);
        }
    }
}
