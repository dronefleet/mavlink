package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F6: format 
 */
@MavlinkMessageInfo(
        id = 174,
        crc = 54,
        description = "Backwards compatible version of SERIAL_UDB_EXTRA F6: format"
)
public final class SerialUdbExtraF6 {
    private final float suePitchgain;

    private final float suePitchkd;

    private final float sueRudderElevMix;

    private final float sueRollElevMix;

    private final float sueElevatorBoost;

    private SerialUdbExtraF6(float suePitchgain, float suePitchkd, float sueRudderElevMix,
            float sueRollElevMix, float sueElevatorBoost) {
        this.suePitchgain = suePitchgain;
        this.suePitchkd = suePitchkd;
        this.sueRudderElevMix = sueRudderElevMix;
        this.sueRollElevMix = sueRollElevMix;
        this.sueElevatorBoost = sueElevatorBoost;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Serial UDB Extra PITCHGAIN Proportional Control 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Serial UDB Extra PITCHGAIN Proportional Control"
    )
    public final float suePitchgain() {
        return this.suePitchgain;
    }

    /**
     * Serial UDB Extra Pitch Rate Control 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Serial UDB Extra Pitch Rate Control"
    )
    public final float suePitchkd() {
        return this.suePitchkd;
    }

    /**
     * Serial UDB Extra Rudder to Elevator Mix 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Serial UDB Extra Rudder to Elevator Mix"
    )
    public final float sueRudderElevMix() {
        return this.sueRudderElevMix;
    }

    /**
     * Serial UDB Extra Roll to Elevator Mix 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Serial UDB Extra Roll to Elevator Mix"
    )
    public final float sueRollElevMix() {
        return this.sueRollElevMix;
    }

    /**
     * Gain For Boosting Manual Elevator control When Plane Stabilized 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Gain For Boosting Manual Elevator control When Plane Stabilized"
    )
    public final float sueElevatorBoost() {
        return this.sueElevatorBoost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SerialUdbExtraF6 other = (SerialUdbExtraF6)o;
        if (!Objects.deepEquals(suePitchgain, other.suePitchgain)) return false;
        if (!Objects.deepEquals(suePitchkd, other.suePitchkd)) return false;
        if (!Objects.deepEquals(sueRudderElevMix, other.sueRudderElevMix)) return false;
        if (!Objects.deepEquals(sueRollElevMix, other.sueRollElevMix)) return false;
        if (!Objects.deepEquals(sueElevatorBoost, other.sueElevatorBoost)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(suePitchgain);
        result = 31 * result + Objects.hashCode(suePitchkd);
        result = 31 * result + Objects.hashCode(sueRudderElevMix);
        result = 31 * result + Objects.hashCode(sueRollElevMix);
        result = 31 * result + Objects.hashCode(sueElevatorBoost);
        return result;
    }

    @Override
    public String toString() {
        return "SerialUdbExtraF6{suePitchgain=" + suePitchgain
                 + ", suePitchkd=" + suePitchkd
                 + ", sueRudderElevMix=" + sueRudderElevMix
                 + ", sueRollElevMix=" + sueRollElevMix
                 + ", sueElevatorBoost=" + sueElevatorBoost + "}";
    }

    public static final class Builder {
        private float suePitchgain;

        private float suePitchkd;

        private float sueRudderElevMix;

        private float sueRollElevMix;

        private float sueElevatorBoost;

        /**
         * Serial UDB Extra PITCHGAIN Proportional Control 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Serial UDB Extra PITCHGAIN Proportional Control"
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
                unitSize = 4,
                description = "Serial UDB Extra Pitch Rate Control"
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
                unitSize = 4,
                description = "Serial UDB Extra Rudder to Elevator Mix"
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
                unitSize = 4,
                description = "Serial UDB Extra Roll to Elevator Mix"
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
                unitSize = 4,
                description = "Gain For Boosting Manual Elevator control When Plane Stabilized"
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
