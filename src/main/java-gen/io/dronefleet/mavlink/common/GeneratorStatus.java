package io.dronefleet.mavlink.common;

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
 * Telemetry of power generation system. Alternator or mechanical generator. 
 */
@MavlinkMessageInfo(
        id = 373,
        crc = 117,
        description = "Telemetry of power generation system. Alternator or mechanical generator."
)
public final class GeneratorStatus {
    private final EnumValue<MavGeneratorStatusFlag> status;

    private final int generatorSpeed;

    private final float batteryCurrent;

    private final float loadCurrent;

    private final float powerGenerated;

    private final float busVoltage;

    private final int rectifierTemperature;

    private final float batCurrentSetpoint;

    private final int generatorTemperature;

    private final long runtime;

    private final int timeUntilMaintenance;

    private GeneratorStatus(EnumValue<MavGeneratorStatusFlag> status, int generatorSpeed,
            float batteryCurrent, float loadCurrent, float powerGenerated, float busVoltage,
            int rectifierTemperature, float batCurrentSetpoint, int generatorTemperature,
            long runtime, int timeUntilMaintenance) {
        this.status = status;
        this.generatorSpeed = generatorSpeed;
        this.batteryCurrent = batteryCurrent;
        this.loadCurrent = loadCurrent;
        this.powerGenerated = powerGenerated;
        this.busVoltage = busVoltage;
        this.rectifierTemperature = rectifierTemperature;
        this.batCurrentSetpoint = batCurrentSetpoint;
        this.generatorTemperature = generatorTemperature;
        this.runtime = runtime;
        this.timeUntilMaintenance = timeUntilMaintenance;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Status flags. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            enumType = MavGeneratorStatusFlag.class,
            description = "Status flags."
    )
    public final EnumValue<MavGeneratorStatusFlag> status() {
        return this.status;
    }

    /**
     * Speed of electrical generator or alternator. UINT16_MAX: field not provided. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            description = "Speed of electrical generator or alternator. UINT16_MAX: field not provided."
    )
    public final int generatorSpeed() {
        return this.generatorSpeed;
    }

    /**
     * Current into/out of battery. Positive for out. Negative for in. NaN: field not provided. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Current into/out of battery. Positive for out. Negative for in. NaN: field not provided."
    )
    public final float batteryCurrent() {
        return this.batteryCurrent;
    }

    /**
     * Current going to the UAV. If battery current not available this is the DC current from the 
     * generator. Positive for out. Negative for in. NaN: field not provided 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Current going to the UAV. If battery current not available this is the DC current from the generator. Positive for out. Negative for in. NaN: field not provided"
    )
    public final float loadCurrent() {
        return this.loadCurrent;
    }

    /**
     * The power being generated. NaN: field not provided 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "The power being generated. NaN: field not provided"
    )
    public final float powerGenerated() {
        return this.powerGenerated;
    }

    /**
     * Voltage of the bus seen at the generator, or battery bus if battery bus is controlled by 
     * generator and at a different voltage to main bus. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Voltage of the bus seen at the generator, or battery bus if battery bus is controlled by generator and at a different voltage to main bus."
    )
    public final float busVoltage() {
        return this.busVoltage;
    }

    /**
     * The temperature of the rectifier or power converter. INT16_MAX: field not provided. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            signed = true,
            description = "The temperature of the rectifier or power converter. INT16_MAX: field not provided."
    )
    public final int rectifierTemperature() {
        return this.rectifierTemperature;
    }

    /**
     * The target battery current. Positive for out. Negative for in. NaN: field not provided 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "The target battery current. Positive for out. Negative for in. NaN: field not provided"
    )
    public final float batCurrentSetpoint() {
        return this.batCurrentSetpoint;
    }

    /**
     * The temperature of the mechanical motor, fuel cell core or generator. INT16_MAX: field not 
     * provided. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2,
            signed = true,
            description = "The temperature of the mechanical motor, fuel cell core or generator. INT16_MAX: field not provided."
    )
    public final int generatorTemperature() {
        return this.generatorTemperature;
    }

    /**
     * Seconds this generator has run since it was rebooted. UINT32_MAX: field not provided. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "Seconds this generator has run since it was rebooted. UINT32_MAX: field not provided."
    )
    public final long runtime() {
        return this.runtime;
    }

    /**
     * Seconds until this generator requires maintenance. A negative value indicates maintenance 
     * is past-due. INT32_MAX: field not provided. 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            signed = true,
            description = "Seconds until this generator requires maintenance.  A negative value indicates maintenance is past-due. INT32_MAX: field not provided."
    )
    public final int timeUntilMaintenance() {
        return this.timeUntilMaintenance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        GeneratorStatus other = (GeneratorStatus)o;
        if (!Objects.deepEquals(status, other.status)) return false;
        if (!Objects.deepEquals(generatorSpeed, other.generatorSpeed)) return false;
        if (!Objects.deepEquals(batteryCurrent, other.batteryCurrent)) return false;
        if (!Objects.deepEquals(loadCurrent, other.loadCurrent)) return false;
        if (!Objects.deepEquals(powerGenerated, other.powerGenerated)) return false;
        if (!Objects.deepEquals(busVoltage, other.busVoltage)) return false;
        if (!Objects.deepEquals(rectifierTemperature, other.rectifierTemperature)) return false;
        if (!Objects.deepEquals(batCurrentSetpoint, other.batCurrentSetpoint)) return false;
        if (!Objects.deepEquals(generatorTemperature, other.generatorTemperature)) return false;
        if (!Objects.deepEquals(runtime, other.runtime)) return false;
        if (!Objects.deepEquals(timeUntilMaintenance, other.timeUntilMaintenance)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(status);
        result = 31 * result + Objects.hashCode(generatorSpeed);
        result = 31 * result + Objects.hashCode(batteryCurrent);
        result = 31 * result + Objects.hashCode(loadCurrent);
        result = 31 * result + Objects.hashCode(powerGenerated);
        result = 31 * result + Objects.hashCode(busVoltage);
        result = 31 * result + Objects.hashCode(rectifierTemperature);
        result = 31 * result + Objects.hashCode(batCurrentSetpoint);
        result = 31 * result + Objects.hashCode(generatorTemperature);
        result = 31 * result + Objects.hashCode(runtime);
        result = 31 * result + Objects.hashCode(timeUntilMaintenance);
        return result;
    }

    @Override
    public String toString() {
        return "GeneratorStatus{status=" + status
                 + ", generatorSpeed=" + generatorSpeed
                 + ", batteryCurrent=" + batteryCurrent
                 + ", loadCurrent=" + loadCurrent
                 + ", powerGenerated=" + powerGenerated
                 + ", busVoltage=" + busVoltage
                 + ", rectifierTemperature=" + rectifierTemperature
                 + ", batCurrentSetpoint=" + batCurrentSetpoint
                 + ", generatorTemperature=" + generatorTemperature
                 + ", runtime=" + runtime
                 + ", timeUntilMaintenance=" + timeUntilMaintenance + "}";
    }

    public static final class Builder {
        private EnumValue<MavGeneratorStatusFlag> status;

        private int generatorSpeed;

        private float batteryCurrent;

        private float loadCurrent;

        private float powerGenerated;

        private float busVoltage;

        private int rectifierTemperature;

        private float batCurrentSetpoint;

        private int generatorTemperature;

        private long runtime;

        private int timeUntilMaintenance;

        /**
         * Status flags. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                enumType = MavGeneratorStatusFlag.class,
                description = "Status flags."
        )
        public final Builder status(EnumValue<MavGeneratorStatusFlag> status) {
            this.status = status;
            return this;
        }

        /**
         * Status flags. 
         */
        public final Builder status(MavGeneratorStatusFlag entry) {
            return status(EnumValue.of(entry));
        }

        /**
         * Status flags. 
         */
        public final Builder status(Enum... flags) {
            return status(EnumValue.create(flags));
        }

        /**
         * Status flags. 
         */
        public final Builder status(Collection<Enum> flags) {
            return status(EnumValue.create(flags));
        }

        /**
         * Speed of electrical generator or alternator. UINT16_MAX: field not provided. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                description = "Speed of electrical generator or alternator. UINT16_MAX: field not provided."
        )
        public final Builder generatorSpeed(int generatorSpeed) {
            this.generatorSpeed = generatorSpeed;
            return this;
        }

        /**
         * Current into/out of battery. Positive for out. Negative for in. NaN: field not provided. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Current into/out of battery. Positive for out. Negative for in. NaN: field not provided."
        )
        public final Builder batteryCurrent(float batteryCurrent) {
            this.batteryCurrent = batteryCurrent;
            return this;
        }

        /**
         * Current going to the UAV. If battery current not available this is the DC current from the 
         * generator. Positive for out. Negative for in. NaN: field not provided 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Current going to the UAV. If battery current not available this is the DC current from the generator. Positive for out. Negative for in. NaN: field not provided"
        )
        public final Builder loadCurrent(float loadCurrent) {
            this.loadCurrent = loadCurrent;
            return this;
        }

        /**
         * The power being generated. NaN: field not provided 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "The power being generated. NaN: field not provided"
        )
        public final Builder powerGenerated(float powerGenerated) {
            this.powerGenerated = powerGenerated;
            return this;
        }

        /**
         * Voltage of the bus seen at the generator, or battery bus if battery bus is controlled by 
         * generator and at a different voltage to main bus. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Voltage of the bus seen at the generator, or battery bus if battery bus is controlled by generator and at a different voltage to main bus."
        )
        public final Builder busVoltage(float busVoltage) {
            this.busVoltage = busVoltage;
            return this;
        }

        /**
         * The temperature of the rectifier or power converter. INT16_MAX: field not provided. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                signed = true,
                description = "The temperature of the rectifier or power converter. INT16_MAX: field not provided."
        )
        public final Builder rectifierTemperature(int rectifierTemperature) {
            this.rectifierTemperature = rectifierTemperature;
            return this;
        }

        /**
         * The target battery current. Positive for out. Negative for in. NaN: field not provided 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "The target battery current. Positive for out. Negative for in. NaN: field not provided"
        )
        public final Builder batCurrentSetpoint(float batCurrentSetpoint) {
            this.batCurrentSetpoint = batCurrentSetpoint;
            return this;
        }

        /**
         * The temperature of the mechanical motor, fuel cell core or generator. INT16_MAX: field not 
         * provided. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2,
                signed = true,
                description = "The temperature of the mechanical motor, fuel cell core or generator. INT16_MAX: field not provided."
        )
        public final Builder generatorTemperature(int generatorTemperature) {
            this.generatorTemperature = generatorTemperature;
            return this;
        }

        /**
         * Seconds this generator has run since it was rebooted. UINT32_MAX: field not provided. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "Seconds this generator has run since it was rebooted. UINT32_MAX: field not provided."
        )
        public final Builder runtime(long runtime) {
            this.runtime = runtime;
            return this;
        }

        /**
         * Seconds until this generator requires maintenance. A negative value indicates maintenance 
         * is past-due. INT32_MAX: field not provided. 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                signed = true,
                description = "Seconds until this generator requires maintenance.  A negative value indicates maintenance is past-due. INT32_MAX: field not provided."
        )
        public final Builder timeUntilMaintenance(int timeUntilMaintenance) {
            this.timeUntilMaintenance = timeUntilMaintenance;
            return this;
        }

        public final GeneratorStatus build() {
            return new GeneratorStatus(status, generatorSpeed, batteryCurrent, loadCurrent, powerGenerated, busVoltage, rectifierTemperature, batCurrentSetpoint, generatorTemperature, runtime, timeUntilMaintenance);
        }
    }
}
