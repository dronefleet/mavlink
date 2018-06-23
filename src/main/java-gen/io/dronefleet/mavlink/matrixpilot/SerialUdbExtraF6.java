package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F6: format 
 */
@MavlinkMessageInfo(
        id = 174,
        crc = 54
)
public final class SerialUdbExtraF6 {
    /**
     * Serial UDB Extra PITCHGAIN Proportional Control 
     */
    private final float suePitchgain;

    /**
     * Serial UDB Extra Pitch Rate Control 
     */
    private final float suePitchkd;

    /**
     * Serial UDB Extra Rudder to Elevator Mix 
     */
    private final float sueRudderElevMix;

    /**
     * Serial UDB Extra Roll to Elevator Mix 
     */
    private final float sueRollElevMix;

    /**
     * Gain For Boosting Manual Elevator control When Plane Stabilized 
     */
    private final float sueElevatorBoost;

    private SerialUdbExtraF6(float suePitchgain, float suePitchkd, float sueRudderElevMix,
            float sueRollElevMix, float sueElevatorBoost) {
        this.suePitchgain = suePitchgain;
        this.suePitchkd = suePitchkd;
        this.sueRudderElevMix = sueRudderElevMix;
        this.sueRollElevMix = sueRollElevMix;
        this.sueElevatorBoost = sueElevatorBoost;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "SerialUdbExtraF6{suePitchgain=" + suePitchgain
                 + ", suePitchkd=" + suePitchkd
                 + ", sueRudderElevMix=" + sueRudderElevMix
                 + ", sueRollElevMix=" + sueRollElevMix
                 + ", sueElevatorBoost=" + sueElevatorBoost + "}";
    }

    /**
     * Serial UDB Extra PITCHGAIN Proportional Control 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final float suePitchgain() {
        return suePitchgain;
    }

    /**
     * Serial UDB Extra Pitch Rate Control 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float suePitchkd() {
        return suePitchkd;
    }

    /**
     * Serial UDB Extra Rudder to Elevator Mix 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float sueRudderElevMix() {
        return sueRudderElevMix;
    }

    /**
     * Serial UDB Extra Roll to Elevator Mix 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float sueRollElevMix() {
        return sueRollElevMix;
    }

    /**
     * Gain For Boosting Manual Elevator control When Plane Stabilized 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float sueElevatorBoost() {
        return sueElevatorBoost;
    }

    public static class Builder {
        private float suePitchgain;

        private float suePitchkd;

        private float sueRudderElevMix;

        private float sueRollElevMix;

        private float sueElevatorBoost;

        private Builder() {
        }

        /**
         * Serial UDB Extra PITCHGAIN Proportional Control 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
        )
        public final Builder suePitchgain(float suePitchgain) {
            this.suePitchgain = suePitchgain;
            return this;
        }

        /**
         * Serial UDB Extra Pitch Rate Control 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder suePitchkd(float suePitchkd) {
            this.suePitchkd = suePitchkd;
            return this;
        }

        /**
         * Serial UDB Extra Rudder to Elevator Mix 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder sueRudderElevMix(float sueRudderElevMix) {
            this.sueRudderElevMix = sueRudderElevMix;
            return this;
        }

        /**
         * Serial UDB Extra Roll to Elevator Mix 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder sueRollElevMix(float sueRollElevMix) {
            this.sueRollElevMix = sueRollElevMix;
            return this;
        }

        /**
         * Gain For Boosting Manual Elevator control When Plane Stabilized 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder sueElevatorBoost(float sueElevatorBoost) {
            this.sueElevatorBoost = sueElevatorBoost;
            return this;
        }

        public final SerialUdbExtraF6 build() {
            return new SerialUdbExtraF6(suePitchgain, suePitchkd, sueRudderElevMix, sueRollElevMix, sueElevatorBoost);
        }
    }
}
