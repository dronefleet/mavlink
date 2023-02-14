package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * EFI status output 
 */
@MavlinkMessageInfo(
        id = 225,
        crc = 208,
        description = "EFI status output"
)
public final class EfiStatus {
    private final int health;

    private final float ecuIndex;

    private final float rpm;

    private final float fuelConsumed;

    private final float fuelFlow;

    private final float engineLoad;

    private final float throttlePosition;

    private final float sparkDwellTime;

    private final float barometricPressure;

    private final float intakeManifoldPressure;

    private final float intakeManifoldTemperature;

    private final float cylinderHeadTemperature;

    private final float ignitionTiming;

    private final float injectionTime;

    private final float exhaustGasTemperature;

    private final float throttleOut;

    private final float ptCompensation;

    private final float ignitionVoltage;

    private final float fuelPressure;

    private EfiStatus(int health, float ecuIndex, float rpm, float fuelConsumed, float fuelFlow,
            float engineLoad, float throttlePosition, float sparkDwellTime,
            float barometricPressure, float intakeManifoldPressure, float intakeManifoldTemperature,
            float cylinderHeadTemperature, float ignitionTiming, float injectionTime,
            float exhaustGasTemperature, float throttleOut, float ptCompensation,
            float ignitionVoltage, float fuelPressure) {
        this.health = health;
        this.ecuIndex = ecuIndex;
        this.rpm = rpm;
        this.fuelConsumed = fuelConsumed;
        this.fuelFlow = fuelFlow;
        this.engineLoad = engineLoad;
        this.throttlePosition = throttlePosition;
        this.sparkDwellTime = sparkDwellTime;
        this.barometricPressure = barometricPressure;
        this.intakeManifoldPressure = intakeManifoldPressure;
        this.intakeManifoldTemperature = intakeManifoldTemperature;
        this.cylinderHeadTemperature = cylinderHeadTemperature;
        this.ignitionTiming = ignitionTiming;
        this.injectionTime = injectionTime;
        this.exhaustGasTemperature = exhaustGasTemperature;
        this.throttleOut = throttleOut;
        this.ptCompensation = ptCompensation;
        this.ignitionVoltage = ignitionVoltage;
        this.fuelPressure = fuelPressure;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * EFI health status 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "EFI health status"
    )
    public final int health() {
        return this.health;
    }

    /**
     * ECU index 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "ECU index"
    )
    public final float ecuIndex() {
        return this.ecuIndex;
    }

    /**
     * RPM 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "RPM"
    )
    public final float rpm() {
        return this.rpm;
    }

    /**
     * Fuel consumed 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Fuel consumed"
    )
    public final float fuelConsumed() {
        return this.fuelConsumed;
    }

    /**
     * Fuel flow rate 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Fuel flow rate"
    )
    public final float fuelFlow() {
        return this.fuelFlow;
    }

    /**
     * Engine load 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Engine load"
    )
    public final float engineLoad() {
        return this.engineLoad;
    }

    /**
     * Throttle position 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Throttle position"
    )
    public final float throttlePosition() {
        return this.throttlePosition;
    }

    /**
     * Spark dwell time 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Spark dwell time"
    )
    public final float sparkDwellTime() {
        return this.sparkDwellTime;
    }

    /**
     * Barometric pressure 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Barometric pressure"
    )
    public final float barometricPressure() {
        return this.barometricPressure;
    }

    /**
     * Intake manifold pressure( 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "Intake manifold pressure("
    )
    public final float intakeManifoldPressure() {
        return this.intakeManifoldPressure;
    }

    /**
     * Intake manifold temperature 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            description = "Intake manifold temperature"
    )
    public final float intakeManifoldTemperature() {
        return this.intakeManifoldTemperature;
    }

    /**
     * Cylinder head temperature 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4,
            description = "Cylinder head temperature"
    )
    public final float cylinderHeadTemperature() {
        return this.cylinderHeadTemperature;
    }

    /**
     * Ignition timing (Crank angle degrees) 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 4,
            description = "Ignition timing (Crank angle degrees)"
    )
    public final float ignitionTiming() {
        return this.ignitionTiming;
    }

    /**
     * Injection time 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 4,
            description = "Injection time"
    )
    public final float injectionTime() {
        return this.injectionTime;
    }

    /**
     * Exhaust gas temperature 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 4,
            description = "Exhaust gas temperature"
    )
    public final float exhaustGasTemperature() {
        return this.exhaustGasTemperature;
    }

    /**
     * Output throttle 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 4,
            description = "Output throttle"
    )
    public final float throttleOut() {
        return this.throttleOut;
    }

    /**
     * Pressure/temperature compensation 
     */
    @MavlinkFieldInfo(
            position = 17,
            unitSize = 4,
            description = "Pressure/temperature compensation"
    )
    public final float ptCompensation() {
        return this.ptCompensation;
    }

    /**
     * Supply voltage to EFI sparking system. Zero in this value means "unknown", so if the supply 
     * voltage really is zero volts use 0.0001 instead. 
     */
    @MavlinkFieldInfo(
            position = 19,
            unitSize = 4,
            extension = true,
            description = "Supply voltage to EFI sparking system.  Zero in this value means \"unknown\", so if the supply voltage really is zero volts use 0.0001 instead."
    )
    public final float ignitionVoltage() {
        return this.ignitionVoltage;
    }

    /**
     * Fuel pressure. Zero in this value means "unknown", so if the fuel pressure really is zero kPa use 
     * 0.0001 instead. 
     */
    @MavlinkFieldInfo(
            position = 20,
            unitSize = 4,
            extension = true,
            description = "Fuel pressure. Zero in this value means \"unknown\", so if the fuel pressure really is zero kPa use 0.0001 instead."
    )
    public final float fuelPressure() {
        return this.fuelPressure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        EfiStatus other = (EfiStatus)o;
        if (!Objects.deepEquals(health, other.health)) return false;
        if (!Objects.deepEquals(ecuIndex, other.ecuIndex)) return false;
        if (!Objects.deepEquals(rpm, other.rpm)) return false;
        if (!Objects.deepEquals(fuelConsumed, other.fuelConsumed)) return false;
        if (!Objects.deepEquals(fuelFlow, other.fuelFlow)) return false;
        if (!Objects.deepEquals(engineLoad, other.engineLoad)) return false;
        if (!Objects.deepEquals(throttlePosition, other.throttlePosition)) return false;
        if (!Objects.deepEquals(sparkDwellTime, other.sparkDwellTime)) return false;
        if (!Objects.deepEquals(barometricPressure, other.barometricPressure)) return false;
        if (!Objects.deepEquals(intakeManifoldPressure, other.intakeManifoldPressure)) return false;
        if (!Objects.deepEquals(intakeManifoldTemperature, other.intakeManifoldTemperature)) return false;
        if (!Objects.deepEquals(cylinderHeadTemperature, other.cylinderHeadTemperature)) return false;
        if (!Objects.deepEquals(ignitionTiming, other.ignitionTiming)) return false;
        if (!Objects.deepEquals(injectionTime, other.injectionTime)) return false;
        if (!Objects.deepEquals(exhaustGasTemperature, other.exhaustGasTemperature)) return false;
        if (!Objects.deepEquals(throttleOut, other.throttleOut)) return false;
        if (!Objects.deepEquals(ptCompensation, other.ptCompensation)) return false;
        if (!Objects.deepEquals(ignitionVoltage, other.ignitionVoltage)) return false;
        if (!Objects.deepEquals(fuelPressure, other.fuelPressure)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(health);
        result = 31 * result + Objects.hashCode(ecuIndex);
        result = 31 * result + Objects.hashCode(rpm);
        result = 31 * result + Objects.hashCode(fuelConsumed);
        result = 31 * result + Objects.hashCode(fuelFlow);
        result = 31 * result + Objects.hashCode(engineLoad);
        result = 31 * result + Objects.hashCode(throttlePosition);
        result = 31 * result + Objects.hashCode(sparkDwellTime);
        result = 31 * result + Objects.hashCode(barometricPressure);
        result = 31 * result + Objects.hashCode(intakeManifoldPressure);
        result = 31 * result + Objects.hashCode(intakeManifoldTemperature);
        result = 31 * result + Objects.hashCode(cylinderHeadTemperature);
        result = 31 * result + Objects.hashCode(ignitionTiming);
        result = 31 * result + Objects.hashCode(injectionTime);
        result = 31 * result + Objects.hashCode(exhaustGasTemperature);
        result = 31 * result + Objects.hashCode(throttleOut);
        result = 31 * result + Objects.hashCode(ptCompensation);
        result = 31 * result + Objects.hashCode(ignitionVoltage);
        result = 31 * result + Objects.hashCode(fuelPressure);
        return result;
    }

    @Override
    public String toString() {
        return "EfiStatus{health=" + health
                 + ", ecuIndex=" + ecuIndex
                 + ", rpm=" + rpm
                 + ", fuelConsumed=" + fuelConsumed
                 + ", fuelFlow=" + fuelFlow
                 + ", engineLoad=" + engineLoad
                 + ", throttlePosition=" + throttlePosition
                 + ", sparkDwellTime=" + sparkDwellTime
                 + ", barometricPressure=" + barometricPressure
                 + ", intakeManifoldPressure=" + intakeManifoldPressure
                 + ", intakeManifoldTemperature=" + intakeManifoldTemperature
                 + ", cylinderHeadTemperature=" + cylinderHeadTemperature
                 + ", ignitionTiming=" + ignitionTiming
                 + ", injectionTime=" + injectionTime
                 + ", exhaustGasTemperature=" + exhaustGasTemperature
                 + ", throttleOut=" + throttleOut
                 + ", ptCompensation=" + ptCompensation
                 + ", ignitionVoltage=" + ignitionVoltage
                 + ", fuelPressure=" + fuelPressure + "}";
    }

    public static final class Builder {
        private int health;

        private float ecuIndex;

        private float rpm;

        private float fuelConsumed;

        private float fuelFlow;

        private float engineLoad;

        private float throttlePosition;

        private float sparkDwellTime;

        private float barometricPressure;

        private float intakeManifoldPressure;

        private float intakeManifoldTemperature;

        private float cylinderHeadTemperature;

        private float ignitionTiming;

        private float injectionTime;

        private float exhaustGasTemperature;

        private float throttleOut;

        private float ptCompensation;

        private float ignitionVoltage;

        private float fuelPressure;

        /**
         * EFI health status 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "EFI health status"
        )
        public final Builder health(int health) {
            this.health = health;
            return this;
        }

        /**
         * ECU index 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "ECU index"
        )
        public final Builder ecuIndex(float ecuIndex) {
            this.ecuIndex = ecuIndex;
            return this;
        }

        /**
         * RPM 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "RPM"
        )
        public final Builder rpm(float rpm) {
            this.rpm = rpm;
            return this;
        }

        /**
         * Fuel consumed 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Fuel consumed"
        )
        public final Builder fuelConsumed(float fuelConsumed) {
            this.fuelConsumed = fuelConsumed;
            return this;
        }

        /**
         * Fuel flow rate 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Fuel flow rate"
        )
        public final Builder fuelFlow(float fuelFlow) {
            this.fuelFlow = fuelFlow;
            return this;
        }

        /**
         * Engine load 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Engine load"
        )
        public final Builder engineLoad(float engineLoad) {
            this.engineLoad = engineLoad;
            return this;
        }

        /**
         * Throttle position 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Throttle position"
        )
        public final Builder throttlePosition(float throttlePosition) {
            this.throttlePosition = throttlePosition;
            return this;
        }

        /**
         * Spark dwell time 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Spark dwell time"
        )
        public final Builder sparkDwellTime(float sparkDwellTime) {
            this.sparkDwellTime = sparkDwellTime;
            return this;
        }

        /**
         * Barometric pressure 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Barometric pressure"
        )
        public final Builder barometricPressure(float barometricPressure) {
            this.barometricPressure = barometricPressure;
            return this;
        }

        /**
         * Intake manifold pressure( 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "Intake manifold pressure("
        )
        public final Builder intakeManifoldPressure(float intakeManifoldPressure) {
            this.intakeManifoldPressure = intakeManifoldPressure;
            return this;
        }

        /**
         * Intake manifold temperature 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                description = "Intake manifold temperature"
        )
        public final Builder intakeManifoldTemperature(float intakeManifoldTemperature) {
            this.intakeManifoldTemperature = intakeManifoldTemperature;
            return this;
        }

        /**
         * Cylinder head temperature 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4,
                description = "Cylinder head temperature"
        )
        public final Builder cylinderHeadTemperature(float cylinderHeadTemperature) {
            this.cylinderHeadTemperature = cylinderHeadTemperature;
            return this;
        }

        /**
         * Ignition timing (Crank angle degrees) 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 4,
                description = "Ignition timing (Crank angle degrees)"
        )
        public final Builder ignitionTiming(float ignitionTiming) {
            this.ignitionTiming = ignitionTiming;
            return this;
        }

        /**
         * Injection time 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 4,
                description = "Injection time"
        )
        public final Builder injectionTime(float injectionTime) {
            this.injectionTime = injectionTime;
            return this;
        }

        /**
         * Exhaust gas temperature 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 4,
                description = "Exhaust gas temperature"
        )
        public final Builder exhaustGasTemperature(float exhaustGasTemperature) {
            this.exhaustGasTemperature = exhaustGasTemperature;
            return this;
        }

        /**
         * Output throttle 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 4,
                description = "Output throttle"
        )
        public final Builder throttleOut(float throttleOut) {
            this.throttleOut = throttleOut;
            return this;
        }

        /**
         * Pressure/temperature compensation 
         */
        @MavlinkFieldInfo(
                position = 17,
                unitSize = 4,
                description = "Pressure/temperature compensation"
        )
        public final Builder ptCompensation(float ptCompensation) {
            this.ptCompensation = ptCompensation;
            return this;
        }

        /**
         * Supply voltage to EFI sparking system. Zero in this value means "unknown", so if the supply 
         * voltage really is zero volts use 0.0001 instead. 
         */
        @MavlinkFieldInfo(
                position = 19,
                unitSize = 4,
                extension = true,
                description = "Supply voltage to EFI sparking system.  Zero in this value means \"unknown\", so if the supply voltage really is zero volts use 0.0001 instead."
        )
        public final Builder ignitionVoltage(float ignitionVoltage) {
            this.ignitionVoltage = ignitionVoltage;
            return this;
        }

        /**
         * Fuel pressure. Zero in this value means "unknown", so if the fuel pressure really is zero kPa use 
         * 0.0001 instead. 
         */
        @MavlinkFieldInfo(
                position = 20,
                unitSize = 4,
                extension = true,
                description = "Fuel pressure. Zero in this value means \"unknown\", so if the fuel pressure really is zero kPa use 0.0001 instead."
        )
        public final Builder fuelPressure(float fuelPressure) {
            this.fuelPressure = fuelPressure;
            return this;
        }

        public final EfiStatus build() {
            return new EfiStatus(health, ecuIndex, rpm, fuelConsumed, fuelFlow, engineLoad, throttlePosition, sparkDwellTime, barometricPressure, intakeManifoldPressure, intakeManifoldTemperature, cylinderHeadTemperature, ignitionTiming, injectionTime, exhaustGasTemperature, throttleOut, ptCompensation, ignitionVoltage, fuelPressure);
        }
    }
}
