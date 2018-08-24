package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.util.List;
import java.util.Objects;

/**
 * Battery information 
 */
@MavlinkMessageInfo(
        id = 147,
        crc = 154
)
public final class BatteryStatus {
    private final int id;

    private final EnumValue<MavBatteryFunction> batteryFunction;

    private final EnumValue<MavBatteryType> type;

    private final int temperature;

    private final List<Integer> voltages;

    private final int currentBattery;

    private final int currentConsumed;

    private final int energyConsumed;

    private final int batteryRemaining;

    private final int timeRemaining;

    private final EnumValue<MavBatteryChargeState> chargeState;

    private BatteryStatus(int id, EnumValue<MavBatteryFunction> batteryFunction,
            EnumValue<MavBatteryType> type, int temperature, List<Integer> voltages,
            int currentBattery, int currentConsumed, int energyConsumed, int batteryRemaining,
            int timeRemaining, EnumValue<MavBatteryChargeState> chargeState) {
        this.id = id;
        this.batteryFunction = batteryFunction;
        this.type = type;
        this.temperature = temperature;
        this.voltages = voltages;
        this.currentBattery = currentBattery;
        this.currentConsumed = currentConsumed;
        this.energyConsumed = energyConsumed;
        this.batteryRemaining = batteryRemaining;
        this.timeRemaining = timeRemaining;
        this.chargeState = chargeState;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Battery ID 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int id() {
        return this.id;
    }

    /**
     * Function of the battery 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = MavBatteryFunction.class
    )
    public final EnumValue<MavBatteryFunction> batteryFunction() {
        return this.batteryFunction;
    }

    /**
     * Type (chemistry) of the battery 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            enumType = MavBatteryType.class
    )
    public final EnumValue<MavBatteryType> type() {
        return this.type;
    }

    /**
     * Temperature of the battery in centi-degrees celsius. INT16_MAX for unknown temperature. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            signed = true
    )
    public final int temperature() {
        return this.temperature;
    }

    /**
     * Battery voltage of cells, in millivolts (1 = 1 millivolt). Cells above the valid cell count for 
     * this battery should have the UINT16_MAX value. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            arraySize = 10
    )
    public final List<Integer> voltages() {
        return this.voltages;
    }

    /**
     * Battery current, in 10*milliamperes (1 = 10 milliampere), -1: autopilot does not measure the 
     * current 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            signed = true
    )
    public final int currentBattery() {
        return this.currentBattery;
    }

    /**
     * Consumed charge, in milliampere hours (1 = 1 mAh), -1: autopilot does not provide mAh 
     * consumption estimate 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            signed = true
    )
    public final int currentConsumed() {
        return this.currentConsumed;
    }

    /**
     * Consumed energy, in HectoJoules (intergrated U*I*dt) (1 = 100 Joule), -1: autopilot does not 
     * provide energy consumption estimate 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            signed = true
    )
    public final int energyConsumed() {
        return this.energyConsumed;
    }

    /**
     * Remaining battery energy: (0%: 0, 100%: 100), -1: autopilot does not estimate the remaining 
     * battery 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 1,
            signed = true
    )
    public final int batteryRemaining() {
        return this.batteryRemaining;
    }

    /**
     * Remaining battery time, in seconds (1 = 1s = 0% energy left), 0: autopilot does not provide 
     * remaining battery time estimate 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            signed = true,
            extension = true
    )
    public final int timeRemaining() {
        return this.timeRemaining;
    }

    /**
     * State for extent of discharge, provided by autopilot for warning or external reactions 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 1,
            enumType = MavBatteryChargeState.class,
            extension = true
    )
    public final EnumValue<MavBatteryChargeState> chargeState() {
        return this.chargeState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        BatteryStatus other = (BatteryStatus)o;
        if (!Objects.deepEquals(id, other.id)) return false;
        if (!Objects.deepEquals(batteryFunction, other.batteryFunction)) return false;
        if (!Objects.deepEquals(type, other.type)) return false;
        if (!Objects.deepEquals(temperature, other.temperature)) return false;
        if (!Objects.deepEquals(voltages, other.voltages)) return false;
        if (!Objects.deepEquals(currentBattery, other.currentBattery)) return false;
        if (!Objects.deepEquals(currentConsumed, other.currentConsumed)) return false;
        if (!Objects.deepEquals(energyConsumed, other.energyConsumed)) return false;
        if (!Objects.deepEquals(batteryRemaining, other.batteryRemaining)) return false;
        if (!Objects.deepEquals(timeRemaining, other.timeRemaining)) return false;
        if (!Objects.deepEquals(chargeState, other.chargeState)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(batteryFunction);
        result = 31 * result + Objects.hashCode(type);
        result = 31 * result + Objects.hashCode(temperature);
        result = 31 * result + Objects.hashCode(voltages);
        result = 31 * result + Objects.hashCode(currentBattery);
        result = 31 * result + Objects.hashCode(currentConsumed);
        result = 31 * result + Objects.hashCode(energyConsumed);
        result = 31 * result + Objects.hashCode(batteryRemaining);
        result = 31 * result + Objects.hashCode(timeRemaining);
        result = 31 * result + Objects.hashCode(chargeState);
        return result;
    }

    public static final class Builder {
        private int id;

        private EnumValue<MavBatteryFunction> batteryFunction;

        private EnumValue<MavBatteryType> type;

        private int temperature;

        private List<Integer> voltages;

        private int currentBattery;

        private int currentConsumed;

        private int energyConsumed;

        private int batteryRemaining;

        private int timeRemaining;

        private EnumValue<MavBatteryChargeState> chargeState;

        /**
         * Battery ID 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder id(int id) {
            this.id = id;
            return this;
        }

        /**
         * Function of the battery 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                enumType = MavBatteryFunction.class
        )
        public final Builder batteryFunction(EnumValue<MavBatteryFunction> batteryFunction) {
            this.batteryFunction = batteryFunction;
            return this;
        }

        /**
         * Function of the battery 
         */
        public final Builder batteryFunction(MavBatteryFunction entry) {
            this.batteryFunction = EnumValue.of(entry);
            return this;
        }

        /**
         * Function of the battery 
         */
        public final Builder batteryFunction(Enum... flags) {
            this.batteryFunction = EnumValue.create(flags);
            return this;
        }

        /**
         * Type (chemistry) of the battery 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                enumType = MavBatteryType.class
        )
        public final Builder type(EnumValue<MavBatteryType> type) {
            this.type = type;
            return this;
        }

        /**
         * Type (chemistry) of the battery 
         */
        public final Builder type(MavBatteryType entry) {
            this.type = EnumValue.of(entry);
            return this;
        }

        /**
         * Type (chemistry) of the battery 
         */
        public final Builder type(Enum... flags) {
            this.type = EnumValue.create(flags);
            return this;
        }

        /**
         * Temperature of the battery in centi-degrees celsius. INT16_MAX for unknown temperature. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                signed = true
        )
        public final Builder temperature(int temperature) {
            this.temperature = temperature;
            return this;
        }

        /**
         * Battery voltage of cells, in millivolts (1 = 1 millivolt). Cells above the valid cell count for 
         * this battery should have the UINT16_MAX value. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                arraySize = 10
        )
        public final Builder voltages(List<Integer> voltages) {
            this.voltages = voltages;
            return this;
        }

        /**
         * Battery current, in 10*milliamperes (1 = 10 milliampere), -1: autopilot does not measure the 
         * current 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                signed = true
        )
        public final Builder currentBattery(int currentBattery) {
            this.currentBattery = currentBattery;
            return this;
        }

        /**
         * Consumed charge, in milliampere hours (1 = 1 mAh), -1: autopilot does not provide mAh 
         * consumption estimate 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                signed = true
        )
        public final Builder currentConsumed(int currentConsumed) {
            this.currentConsumed = currentConsumed;
            return this;
        }

        /**
         * Consumed energy, in HectoJoules (intergrated U*I*dt) (1 = 100 Joule), -1: autopilot does not 
         * provide energy consumption estimate 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                signed = true
        )
        public final Builder energyConsumed(int energyConsumed) {
            this.energyConsumed = energyConsumed;
            return this;
        }

        /**
         * Remaining battery energy: (0%: 0, 100%: 100), -1: autopilot does not estimate the remaining 
         * battery 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 1,
                signed = true
        )
        public final Builder batteryRemaining(int batteryRemaining) {
            this.batteryRemaining = batteryRemaining;
            return this;
        }

        /**
         * Remaining battery time, in seconds (1 = 1s = 0% energy left), 0: autopilot does not provide 
         * remaining battery time estimate 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                signed = true,
                extension = true
        )
        public final Builder timeRemaining(int timeRemaining) {
            this.timeRemaining = timeRemaining;
            return this;
        }

        /**
         * State for extent of discharge, provided by autopilot for warning or external reactions 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 1,
                enumType = MavBatteryChargeState.class,
                extension = true
        )
        public final Builder chargeState(EnumValue<MavBatteryChargeState> chargeState) {
            this.chargeState = chargeState;
            return this;
        }

        /**
         * State for extent of discharge, provided by autopilot for warning or external reactions 
         */
        public final Builder chargeState(MavBatteryChargeState entry) {
            this.chargeState = EnumValue.of(entry);
            return this;
        }

        /**
         * State for extent of discharge, provided by autopilot for warning or external reactions 
         */
        public final Builder chargeState(Enum... flags) {
            this.chargeState = EnumValue.create(flags);
            return this;
        }

        public final BatteryStatus build() {
            return new BatteryStatus(id, batteryFunction, type, temperature, voltages, currentBattery, currentConsumed, energyConsumed, batteryRemaining, timeRemaining, chargeState);
        }
    }
}
