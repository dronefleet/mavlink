package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F14: format 
 */
@MavlinkMessageInfo(
        id = 178,
        crc = 123
)
public final class SerialUdbExtraF14 {
    private final int sueWindEstimation;

    private final int sueGpsType;

    private final int sueDr;

    private final int sueBoardType;

    private final int sueAirframe;

    private final int sueRcon;

    private final int sueTrapFlags;

    private final long sueTrapSource;

    private final int sueOscFailCount;

    private final int sueClockConfig;

    private final int sueFlightPlanType;

    private SerialUdbExtraF14(int sueWindEstimation, int sueGpsType, int sueDr, int sueBoardType,
            int sueAirframe, int sueRcon, int sueTrapFlags, long sueTrapSource, int sueOscFailCount,
            int sueClockConfig, int sueFlightPlanType) {
        this.sueWindEstimation = sueWindEstimation;
        this.sueGpsType = sueGpsType;
        this.sueDr = sueDr;
        this.sueBoardType = sueBoardType;
        this.sueAirframe = sueAirframe;
        this.sueRcon = sueRcon;
        this.sueTrapFlags = sueTrapFlags;
        this.sueTrapSource = sueTrapSource;
        this.sueOscFailCount = sueOscFailCount;
        this.sueClockConfig = sueClockConfig;
        this.sueFlightPlanType = sueFlightPlanType;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Serial UDB Extra Wind Estimation Enabled 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int sueWindEstimation() {
        return this.sueWindEstimation;
    }

    /**
     * Serial UDB Extra Type of GPS Unit 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int sueGpsType() {
        return this.sueGpsType;
    }

    /**
     * Serial UDB Extra Dead Reckoning Enabled 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final int sueDr() {
        return this.sueDr;
    }

    /**
     * Serial UDB Extra Type of UDB Hardware 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final int sueBoardType() {
        return this.sueBoardType;
    }

    /**
     * Serial UDB Extra Type of Airframe 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final int sueAirframe() {
        return this.sueAirframe;
    }

    /**
     * Serial UDB Extra Reboot Register of DSPIC 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            signed = true
    )
    public final int sueRcon() {
        return this.sueRcon;
    }

    /**
     * Serial UDB Extra Last dspic Trap Flags 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            signed = true
    )
    public final int sueTrapFlags() {
        return this.sueTrapFlags;
    }

    /**
     * Serial UDB Extra Type Program Address of Last Trap 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4
    )
    public final long sueTrapSource() {
        return this.sueTrapSource;
    }

    /**
     * Serial UDB Extra Number of Ocillator Failures 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2,
            signed = true
    )
    public final int sueOscFailCount() {
        return this.sueOscFailCount;
    }

    /**
     * Serial UDB Extra UDB Internal Clock Configuration 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1
    )
    public final int sueClockConfig() {
        return this.sueClockConfig;
    }

    /**
     * Serial UDB Extra Type of Flight Plan 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 1
    )
    public final int sueFlightPlanType() {
        return this.sueFlightPlanType;
    }

    public static final class Builder {
        private int sueWindEstimation;

        private int sueGpsType;

        private int sueDr;

        private int sueBoardType;

        private int sueAirframe;

        private int sueRcon;

        private int sueTrapFlags;

        private long sueTrapSource;

        private int sueOscFailCount;

        private int sueClockConfig;

        private int sueFlightPlanType;

        /**
         * Serial UDB Extra Wind Estimation Enabled 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder sueWindEstimation(int sueWindEstimation) {
            this.sueWindEstimation = sueWindEstimation;
            return this;
        }

        /**
         * Serial UDB Extra Type of GPS Unit 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder sueGpsType(int sueGpsType) {
            this.sueGpsType = sueGpsType;
            return this;
        }

        /**
         * Serial UDB Extra Dead Reckoning Enabled 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder sueDr(int sueDr) {
            this.sueDr = sueDr;
            return this;
        }

        /**
         * Serial UDB Extra Type of UDB Hardware 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1
        )
        public final Builder sueBoardType(int sueBoardType) {
            this.sueBoardType = sueBoardType;
            return this;
        }

        /**
         * Serial UDB Extra Type of Airframe 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1
        )
        public final Builder sueAirframe(int sueAirframe) {
            this.sueAirframe = sueAirframe;
            return this;
        }

        /**
         * Serial UDB Extra Reboot Register of DSPIC 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                signed = true
        )
        public final Builder sueRcon(int sueRcon) {
            this.sueRcon = sueRcon;
            return this;
        }

        /**
         * Serial UDB Extra Last dspic Trap Flags 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                signed = true
        )
        public final Builder sueTrapFlags(int sueTrapFlags) {
            this.sueTrapFlags = sueTrapFlags;
            return this;
        }

        /**
         * Serial UDB Extra Type Program Address of Last Trap 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4
        )
        public final Builder sueTrapSource(long sueTrapSource) {
            this.sueTrapSource = sueTrapSource;
            return this;
        }

        /**
         * Serial UDB Extra Number of Ocillator Failures 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2,
                signed = true
        )
        public final Builder sueOscFailCount(int sueOscFailCount) {
            this.sueOscFailCount = sueOscFailCount;
            return this;
        }

        /**
         * Serial UDB Extra UDB Internal Clock Configuration 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 1
        )
        public final Builder sueClockConfig(int sueClockConfig) {
            this.sueClockConfig = sueClockConfig;
            return this;
        }

        /**
         * Serial UDB Extra Type of Flight Plan 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 1
        )
        public final Builder sueFlightPlanType(int sueFlightPlanType) {
            this.sueFlightPlanType = sueFlightPlanType;
            return this;
        }

        public final SerialUdbExtraF14 build() {
            return new SerialUdbExtraF14(sueWindEstimation, sueGpsType, sueDr, sueBoardType, sueAirframe, sueRcon, sueTrapFlags, sueTrapSource, sueOscFailCount, sueClockConfig, sueFlightPlanType);
        }
    }
}
