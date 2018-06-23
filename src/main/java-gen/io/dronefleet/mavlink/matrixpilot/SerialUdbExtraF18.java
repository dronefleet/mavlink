package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F18 format 
 */
@MavlinkMessageInfo(
        id = 184,
        crc = 41
)
public final class SerialUdbExtraF18 {
    /**
     * SUE Angle of Attack Normal 
     */
    private final float angleOfAttackNormal;

    /**
     * SUE Angle of Attack Inverted 
     */
    private final float angleOfAttackInverted;

    /**
     * SUE Elevator Trim Normal 
     */
    private final float elevatorTrimNormal;

    /**
     * SUE Elevator Trim Inverted 
     */
    private final float elevatorTrimInverted;

    /**
     * SUE reference_speed 
     */
    private final float referenceSpeed;

    private SerialUdbExtraF18(float angleOfAttackNormal, float angleOfAttackInverted,
            float elevatorTrimNormal, float elevatorTrimInverted, float referenceSpeed) {
        this.angleOfAttackNormal = angleOfAttackNormal;
        this.angleOfAttackInverted = angleOfAttackInverted;
        this.elevatorTrimNormal = elevatorTrimNormal;
        this.elevatorTrimInverted = elevatorTrimInverted;
        this.referenceSpeed = referenceSpeed;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "SerialUdbExtraF18{angleOfAttackNormal=" + angleOfAttackNormal
                 + ", angleOfAttackInverted=" + angleOfAttackInverted
                 + ", elevatorTrimNormal=" + elevatorTrimNormal
                 + ", elevatorTrimInverted=" + elevatorTrimInverted
                 + ", referenceSpeed=" + referenceSpeed + "}";
    }

    /**
     * SUE Angle of Attack Normal 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final float angleOfAttackNormal() {
        return angleOfAttackNormal;
    }

    /**
     * SUE Angle of Attack Inverted 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float angleOfAttackInverted() {
        return angleOfAttackInverted;
    }

    /**
     * SUE Elevator Trim Normal 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float elevatorTrimNormal() {
        return elevatorTrimNormal;
    }

    /**
     * SUE Elevator Trim Inverted 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float elevatorTrimInverted() {
        return elevatorTrimInverted;
    }

    /**
     * SUE reference_speed 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float referenceSpeed() {
        return referenceSpeed;
    }

    public static class Builder {
        private float angleOfAttackNormal;

        private float angleOfAttackInverted;

        private float elevatorTrimNormal;

        private float elevatorTrimInverted;

        private float referenceSpeed;

        private Builder() {
        }

        /**
         * SUE Angle of Attack Normal 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
        )
        public final Builder angleOfAttackNormal(float angleOfAttackNormal) {
            this.angleOfAttackNormal = angleOfAttackNormal;
            return this;
        }

        /**
         * SUE Angle of Attack Inverted 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder angleOfAttackInverted(float angleOfAttackInverted) {
            this.angleOfAttackInverted = angleOfAttackInverted;
            return this;
        }

        /**
         * SUE Elevator Trim Normal 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder elevatorTrimNormal(float elevatorTrimNormal) {
            this.elevatorTrimNormal = elevatorTrimNormal;
            return this;
        }

        /**
         * SUE Elevator Trim Inverted 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder elevatorTrimInverted(float elevatorTrimInverted) {
            this.elevatorTrimInverted = elevatorTrimInverted;
            return this;
        }

        /**
         * SUE reference_speed 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder referenceSpeed(float referenceSpeed) {
            this.referenceSpeed = referenceSpeed;
            return this;
        }

        public final SerialUdbExtraF18 build() {
            return new SerialUdbExtraF18(angleOfAttackNormal, angleOfAttackInverted, elevatorTrimNormal, elevatorTrimInverted, referenceSpeed);
        }
    }
}
