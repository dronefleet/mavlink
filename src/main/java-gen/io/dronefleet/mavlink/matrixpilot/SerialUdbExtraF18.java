package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.util.Objects;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F18 format 
 */
@MavlinkMessageInfo(
        id = 184,
        crc = 41
)
public final class SerialUdbExtraF18 {
    private final float angleOfAttackNormal;

    private final float angleOfAttackInverted;

    private final float elevatorTrimNormal;

    private final float elevatorTrimInverted;

    private final float referenceSpeed;

    private SerialUdbExtraF18(float angleOfAttackNormal, float angleOfAttackInverted,
            float elevatorTrimNormal, float elevatorTrimInverted, float referenceSpeed) {
        this.angleOfAttackNormal = angleOfAttackNormal;
        this.angleOfAttackInverted = angleOfAttackInverted;
        this.elevatorTrimNormal = elevatorTrimNormal;
        this.elevatorTrimInverted = elevatorTrimInverted;
        this.referenceSpeed = referenceSpeed;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * SUE Angle of Attack Normal 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final float angleOfAttackNormal() {
        return this.angleOfAttackNormal;
    }

    /**
     * SUE Angle of Attack Inverted 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float angleOfAttackInverted() {
        return this.angleOfAttackInverted;
    }

    /**
     * SUE Elevator Trim Normal 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float elevatorTrimNormal() {
        return this.elevatorTrimNormal;
    }

    /**
     * SUE Elevator Trim Inverted 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float elevatorTrimInverted() {
        return this.elevatorTrimInverted;
    }

    /**
     * SUE reference_speed 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float referenceSpeed() {
        return this.referenceSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SerialUdbExtraF18 other = (SerialUdbExtraF18)o;
        if (!Objects.deepEquals(angleOfAttackNormal, other.angleOfAttackNormal)) return false;
        if (!Objects.deepEquals(angleOfAttackInverted, other.angleOfAttackInverted)) return false;
        if (!Objects.deepEquals(elevatorTrimNormal, other.elevatorTrimNormal)) return false;
        if (!Objects.deepEquals(elevatorTrimInverted, other.elevatorTrimInverted)) return false;
        if (!Objects.deepEquals(referenceSpeed, other.referenceSpeed)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(angleOfAttackNormal);
        result = 31 * result + Objects.hashCode(angleOfAttackInverted);
        result = 31 * result + Objects.hashCode(elevatorTrimNormal);
        result = 31 * result + Objects.hashCode(elevatorTrimInverted);
        result = 31 * result + Objects.hashCode(referenceSpeed);
        return result;
    }

    public static final class Builder {
        private float angleOfAttackNormal;

        private float angleOfAttackInverted;

        private float elevatorTrimNormal;

        private float elevatorTrimInverted;

        private float referenceSpeed;

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
