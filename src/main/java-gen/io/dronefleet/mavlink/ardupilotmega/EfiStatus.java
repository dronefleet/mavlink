package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * EFI Status Output 
 */
@MavlinkMessageInfo(
        id = 225,
        crc = 142,
        description = "EFI Status Output"
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

    private EfiStatus(int health, float ecuIndex, float rpm, float fuelConsumed, float fuelFlow,
            float engineLoad, float throttlePosition, float sparkDwellTime,
            float barometricPressure, float intakeManifoldPressure, float intakeManifoldTemperature,
            float cylinderHeadTemperature, float ignitionTiming, float injectionTime) {
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
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * EFI Health status 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "EFI Health status"
    )
    public final int health() {
        return this.health;
    }

    /**
     * ECU Index 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "ECU Index"
    )
    public final float ecuIndex() {
        return this.ecuIndex;
    }

    /**
     * {@link io.dronefleet.mavlink.ardupilotmega.Rpm RPM} 
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
     * Fuel Consumed (grams) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Fuel Consumed (grams)"
    )
    public final float fuelConsumed() {
        return this.fuelConsumed;
    }

    /**
     * Fuel Flow Rate (g/min) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Fuel Flow Rate (g/min)"
    )
    public final float fuelFlow() {
        return this.fuelFlow;
    }

    /**
     * Engine Load (%) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Engine Load (%)"
    )
    public final float engineLoad() {
        return this.engineLoad;
    }

    /**
     * Throttle Position (%) 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Throttle Position (%)"
    )
    public final float throttlePosition() {
        return this.throttlePosition;
    }

    /**
     * Spark Dwell Time (ms) 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Spark Dwell Time (ms)"
    )
    public final float sparkDwellTime() {
        return this.sparkDwellTime;
    }

    /**
     * Barometric Pressure (kPa) 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Barometric Pressure (kPa)"
    )
    public final float barometricPressure() {
        return this.barometricPressure;
    }

    /**
     * Intake Manifold Pressure (kPa)( 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "Intake Manifold Pressure (kPa)("
    )
    public final float intakeManifoldPressure() {
        return this.intakeManifoldPressure;
    }

    /**
     * Intake Manifold Temperature (degC) 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            description = "Intake Manifold Temperature (degC)"
    )
    public final float intakeManifoldTemperature() {
        return this.intakeManifoldTemperature;
    }

    /**
     * cylinder_head_temperature (degC) 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4,
            description = "cylinder_head_temperature (degC)"
    )
    public final float cylinderHeadTemperature() {
        return this.cylinderHeadTemperature;
    }

    /**
     * Ignition timing for cylinder i (Crank Angle degrees) 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 4,
            description = "Ignition timing for cylinder i (Crank Angle degrees)"
    )
    public final float ignitionTiming() {
        return this.ignitionTiming;
    }

    /**
     * Injection time for injector i (ms) 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 4,
            description = "Injection time for injector i (ms)"
    )
    public final float injectionTime() {
        return this.injectionTime;
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
                 + ", injectionTime=" + injectionTime + "}";
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

        /**
         * EFI Health status 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "EFI Health status"
        )
        public final Builder health(int health) {
            this.health = health;
            return this;
        }

        /**
         * ECU Index 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "ECU Index"
        )
        public final Builder ecuIndex(float ecuIndex) {
            this.ecuIndex = ecuIndex;
            return this;
        }

        /**
         * {@link io.dronefleet.mavlink.ardupilotmega.Rpm RPM} 
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
         * Fuel Consumed (grams) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Fuel Consumed (grams)"
        )
        public final Builder fuelConsumed(float fuelConsumed) {
            this.fuelConsumed = fuelConsumed;
            return this;
        }

        /**
         * Fuel Flow Rate (g/min) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Fuel Flow Rate (g/min)"
        )
        public final Builder fuelFlow(float fuelFlow) {
            this.fuelFlow = fuelFlow;
            return this;
        }

        /**
         * Engine Load (%) 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Engine Load (%)"
        )
        public final Builder engineLoad(float engineLoad) {
            this.engineLoad = engineLoad;
            return this;
        }

        /**
         * Throttle Position (%) 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Throttle Position (%)"
        )
        public final Builder throttlePosition(float throttlePosition) {
            this.throttlePosition = throttlePosition;
            return this;
        }

        /**
         * Spark Dwell Time (ms) 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Spark Dwell Time (ms)"
        )
        public final Builder sparkDwellTime(float sparkDwellTime) {
            this.sparkDwellTime = sparkDwellTime;
            return this;
        }

        /**
         * Barometric Pressure (kPa) 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Barometric Pressure (kPa)"
        )
        public final Builder barometricPressure(float barometricPressure) {
            this.barometricPressure = barometricPressure;
            return this;
        }

        /**
         * Intake Manifold Pressure (kPa)( 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "Intake Manifold Pressure (kPa)("
        )
        public final Builder intakeManifoldPressure(float intakeManifoldPressure) {
            this.intakeManifoldPressure = intakeManifoldPressure;
            return this;
        }

        /**
         * Intake Manifold Temperature (degC) 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                description = "Intake Manifold Temperature (degC)"
        )
        public final Builder intakeManifoldTemperature(float intakeManifoldTemperature) {
            this.intakeManifoldTemperature = intakeManifoldTemperature;
            return this;
        }

        /**
         * cylinder_head_temperature (degC) 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4,
                description = "cylinder_head_temperature (degC)"
        )
        public final Builder cylinderHeadTemperature(float cylinderHeadTemperature) {
            this.cylinderHeadTemperature = cylinderHeadTemperature;
            return this;
        }

        /**
         * Ignition timing for cylinder i (Crank Angle degrees) 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 4,
                description = "Ignition timing for cylinder i (Crank Angle degrees)"
        )
        public final Builder ignitionTiming(float ignitionTiming) {
            this.ignitionTiming = ignitionTiming;
            return this;
        }

        /**
         * Injection time for injector i (ms) 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 4,
                description = "Injection time for injector i (ms)"
        )
        public final Builder injectionTime(float injectionTime) {
            this.injectionTime = injectionTime;
            return this;
        }

        public final EfiStatus build() {
            return new EfiStatus(health, ecuIndex, rpm, fuelConsumed, fuelFlow, engineLoad, throttlePosition, sparkDwellTime, barometricPressure, intakeManifoldPressure, intakeManifoldTemperature, cylinderHeadTemperature, ignitionTiming, injectionTime);
        }
    }
}
