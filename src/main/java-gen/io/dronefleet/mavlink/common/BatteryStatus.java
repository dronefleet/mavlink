package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Battery information. Updates GCS with flight controller battery status. Smart batteries 
 * also use this message, but may additionally send {@link io.dronefleet.mavlink.common.SmartBatteryInfo SMART_BATTERY_INFO}. 
 */
@MavlinkMessageInfo(
        id = 147,
        crc = 154,
        description = "Battery information. Updates GCS with flight controller battery status. Smart batteries also use this message, but may additionally send SMART_BATTERY_INFO."
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

    private final List<Integer> voltagesExt;

    private final EnumValue<MavBatteryMode> mode;

    private final EnumValue<MavBatteryFault> faultBitmask;

    private BatteryStatus(int id, EnumValue<MavBatteryFunction> batteryFunction,
            EnumValue<MavBatteryType> type, int temperature, List<Integer> voltages,
            int currentBattery, int currentConsumed, int energyConsumed, int batteryRemaining,
            int timeRemaining, EnumValue<MavBatteryChargeState> chargeState,
            List<Integer> voltagesExt, EnumValue<MavBatteryMode> mode,
            EnumValue<MavBatteryFault> faultBitmask) {
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
        this.voltagesExt = voltagesExt;
        this.mode = mode;
        this.faultBitmask = faultBitmask;
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
            unitSize = 1,
            description = "Battery ID"
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
            enumType = MavBatteryFunction.class,
            description = "Function of the battery"
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
            enumType = MavBatteryType.class,
            description = "Type (chemistry) of the battery"
    )
    public final EnumValue<MavBatteryType> type() {
        return this.type;
    }

    /**
     * Temperature of the battery. INT16_MAX for unknown temperature. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            signed = true,
            description = "Temperature of the battery. INT16_MAX for unknown temperature."
    )
    public final int temperature() {
        return this.temperature;
    }

    /**
     * Battery voltage of cells 1 to 10 (see voltages_ext for cells 11-14). Cells in this field above 
     * the valid cell count for this battery should have the UINT16_MAX value. If individual cell 
     * voltages are unknown or not measured for this battery, then the overall battery voltage should 
     * be filled in cell 0, with all others set to UINT16_MAX. If the voltage of the battery is greater 
     * than (UINT16_MAX - 1), then cell 0 should be set to (UINT16_MAX - 1), and cell 1 to the remaining 
     * voltage. This can be extended to multiple cells if the total voltage is greater than 2 * 
     * (UINT16_MAX - 1). 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            arraySize = 10,
            description = "Battery voltage of cells 1 to 10 (see voltages_ext for cells 11-14). Cells in this field above the valid cell count for this battery should have the UINT16_MAX value. If individual cell voltages are unknown or not measured for this battery, then the overall battery voltage should be filled in cell 0, with all others set to UINT16_MAX. If the voltage of the battery is greater than (UINT16_MAX - 1), then cell 0 should be set to (UINT16_MAX - 1), and cell 1 to the remaining voltage. This can be extended to multiple cells if the total voltage is greater than 2 * (UINT16_MAX - 1)."
    )
    public final List<Integer> voltages() {
        return this.voltages;
    }

    /**
     * Battery current, -1: autopilot does not measure the current 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            signed = true,
            description = "Battery current, -1: autopilot does not measure the current"
    )
    public final int currentBattery() {
        return this.currentBattery;
    }

    /**
     * Consumed charge, -1: autopilot does not provide consumption estimate 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            signed = true,
            description = "Consumed charge, -1: autopilot does not provide consumption estimate"
    )
    public final int currentConsumed() {
        return this.currentConsumed;
    }

    /**
     * Consumed energy, -1: autopilot does not provide energy consumption estimate 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            signed = true,
            description = "Consumed energy, -1: autopilot does not provide energy consumption estimate"
    )
    public final int energyConsumed() {
        return this.energyConsumed;
    }

    /**
     * Remaining battery energy. Values: [0-100], -1: autopilot does not estimate the remaining 
     * battery. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 1,
            signed = true,
            description = "Remaining battery energy. Values: [0-100], -1: autopilot does not estimate the remaining battery."
    )
    public final int batteryRemaining() {
        return this.batteryRemaining;
    }

    /**
     * Remaining battery time, 0: autopilot does not provide remaining battery time estimate 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            signed = true,
            extension = true,
            description = "Remaining battery time, 0: autopilot does not provide remaining battery time estimate"
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
            extension = true,
            description = "State for extent of discharge, provided by autopilot for warning or external reactions"
    )
    public final EnumValue<MavBatteryChargeState> chargeState() {
        return this.chargeState;
    }

    /**
     * Battery voltages for cells 11 to 14. Cells above the valid cell count for this battery should 
     * have a value of 0, where zero indicates not supported (note, this is different than for the 
     * voltages field and allows empty byte truncation). If the measured value is 0 then 1 should be 
     * sent instead. 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 2,
            arraySize = 4,
            extension = true,
            description = "Battery voltages for cells 11 to 14. Cells above the valid cell count for this battery should have a value of 0, where zero indicates not supported (note, this is different than for the voltages field and allows empty byte truncation). If the measured value is 0 then 1 should be sent instead."
    )
    public final List<Integer> voltagesExt() {
        return this.voltagesExt;
    }

    /**
     * Battery mode. Default (0) is that battery mode reporting is not supported or battery is in 
     * normal-use mode. 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 1,
            enumType = MavBatteryMode.class,
            extension = true,
            description = "Battery mode. Default (0) is that battery mode reporting is not supported or battery is in normal-use mode."
    )
    public final EnumValue<MavBatteryMode> mode() {
        return this.mode;
    }

    /**
     * Fault/health indications. These should be set when charge_state is 
     * MAV_BATTERY_CHARGE_STATE_FAILED or MAV_BATTERY_CHARGE_STATE_UNHEALTHY (if not, fault 
     * reporting is not supported). 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 4,
            enumType = MavBatteryFault.class,
            extension = true,
            description = "Fault/health indications. These should be set when charge_state is MAV_BATTERY_CHARGE_STATE_FAILED or MAV_BATTERY_CHARGE_STATE_UNHEALTHY (if not, fault reporting is not supported)."
    )
    public final EnumValue<MavBatteryFault> faultBitmask() {
        return this.faultBitmask;
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
        if (!Objects.deepEquals(voltagesExt, other.voltagesExt)) return false;
        if (!Objects.deepEquals(mode, other.mode)) return false;
        if (!Objects.deepEquals(faultBitmask, other.faultBitmask)) return false;
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
        result = 31 * result + Objects.hashCode(voltagesExt);
        result = 31 * result + Objects.hashCode(mode);
        result = 31 * result + Objects.hashCode(faultBitmask);
        return result;
    }

    @Override
    public String toString() {
        return "BatteryStatus{id=" + id
                 + ", batteryFunction=" + batteryFunction
                 + ", type=" + type
                 + ", temperature=" + temperature
                 + ", voltages=" + voltages
                 + ", currentBattery=" + currentBattery
                 + ", currentConsumed=" + currentConsumed
                 + ", energyConsumed=" + energyConsumed
                 + ", batteryRemaining=" + batteryRemaining
                 + ", timeRemaining=" + timeRemaining
                 + ", chargeState=" + chargeState
                 + ", voltagesExt=" + voltagesExt
                 + ", mode=" + mode
                 + ", faultBitmask=" + faultBitmask + "}";
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

        private List<Integer> voltagesExt;

        private EnumValue<MavBatteryMode> mode;

        private EnumValue<MavBatteryFault> faultBitmask;

        /**
         * Battery ID 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "Battery ID"
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
                enumType = MavBatteryFunction.class,
                description = "Function of the battery"
        )
        public final Builder batteryFunction(EnumValue<MavBatteryFunction> batteryFunction) {
            this.batteryFunction = batteryFunction;
            return this;
        }

        /**
         * Function of the battery 
         */
        public final Builder batteryFunction(MavBatteryFunction entry) {
            return batteryFunction(EnumValue.of(entry));
        }

        /**
         * Function of the battery 
         */
        public final Builder batteryFunction(Enum... flags) {
            return batteryFunction(EnumValue.create(flags));
        }

        /**
         * Function of the battery 
         */
        public final Builder batteryFunction(Collection<Enum> flags) {
            return batteryFunction(EnumValue.create(flags));
        }

        /**
         * Type (chemistry) of the battery 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                enumType = MavBatteryType.class,
                description = "Type (chemistry) of the battery"
        )
        public final Builder type(EnumValue<MavBatteryType> type) {
            this.type = type;
            return this;
        }

        /**
         * Type (chemistry) of the battery 
         */
        public final Builder type(MavBatteryType entry) {
            return type(EnumValue.of(entry));
        }

        /**
         * Type (chemistry) of the battery 
         */
        public final Builder type(Enum... flags) {
            return type(EnumValue.create(flags));
        }

        /**
         * Type (chemistry) of the battery 
         */
        public final Builder type(Collection<Enum> flags) {
            return type(EnumValue.create(flags));
        }

        /**
         * Temperature of the battery. INT16_MAX for unknown temperature. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                signed = true,
                description = "Temperature of the battery. INT16_MAX for unknown temperature."
        )
        public final Builder temperature(int temperature) {
            this.temperature = temperature;
            return this;
        }

        /**
         * Battery voltage of cells 1 to 10 (see voltages_ext for cells 11-14). Cells in this field above 
         * the valid cell count for this battery should have the UINT16_MAX value. If individual cell 
         * voltages are unknown or not measured for this battery, then the overall battery voltage should 
         * be filled in cell 0, with all others set to UINT16_MAX. If the voltage of the battery is greater 
         * than (UINT16_MAX - 1), then cell 0 should be set to (UINT16_MAX - 1), and cell 1 to the remaining 
         * voltage. This can be extended to multiple cells if the total voltage is greater than 2 * 
         * (UINT16_MAX - 1). 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                arraySize = 10,
                description = "Battery voltage of cells 1 to 10 (see voltages_ext for cells 11-14). Cells in this field above the valid cell count for this battery should have the UINT16_MAX value. If individual cell voltages are unknown or not measured for this battery, then the overall battery voltage should be filled in cell 0, with all others set to UINT16_MAX. If the voltage of the battery is greater than (UINT16_MAX - 1), then cell 0 should be set to (UINT16_MAX - 1), and cell 1 to the remaining voltage. This can be extended to multiple cells if the total voltage is greater than 2 * (UINT16_MAX - 1)."
        )
        public final Builder voltages(List<Integer> voltages) {
            this.voltages = voltages;
            return this;
        }

        /**
         * Battery current, -1: autopilot does not measure the current 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                signed = true,
                description = "Battery current, -1: autopilot does not measure the current"
        )
        public final Builder currentBattery(int currentBattery) {
            this.currentBattery = currentBattery;
            return this;
        }

        /**
         * Consumed charge, -1: autopilot does not provide consumption estimate 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                signed = true,
                description = "Consumed charge, -1: autopilot does not provide consumption estimate"
        )
        public final Builder currentConsumed(int currentConsumed) {
            this.currentConsumed = currentConsumed;
            return this;
        }

        /**
         * Consumed energy, -1: autopilot does not provide energy consumption estimate 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                signed = true,
                description = "Consumed energy, -1: autopilot does not provide energy consumption estimate"
        )
        public final Builder energyConsumed(int energyConsumed) {
            this.energyConsumed = energyConsumed;
            return this;
        }

        /**
         * Remaining battery energy. Values: [0-100], -1: autopilot does not estimate the remaining 
         * battery. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 1,
                signed = true,
                description = "Remaining battery energy. Values: [0-100], -1: autopilot does not estimate the remaining battery."
        )
        public final Builder batteryRemaining(int batteryRemaining) {
            this.batteryRemaining = batteryRemaining;
            return this;
        }

        /**
         * Remaining battery time, 0: autopilot does not provide remaining battery time estimate 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                signed = true,
                extension = true,
                description = "Remaining battery time, 0: autopilot does not provide remaining battery time estimate"
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
                extension = true,
                description = "State for extent of discharge, provided by autopilot for warning or external reactions"
        )
        public final Builder chargeState(EnumValue<MavBatteryChargeState> chargeState) {
            this.chargeState = chargeState;
            return this;
        }

        /**
         * State for extent of discharge, provided by autopilot for warning or external reactions 
         */
        public final Builder chargeState(MavBatteryChargeState entry) {
            return chargeState(EnumValue.of(entry));
        }

        /**
         * State for extent of discharge, provided by autopilot for warning or external reactions 
         */
        public final Builder chargeState(Enum... flags) {
            return chargeState(EnumValue.create(flags));
        }

        /**
         * State for extent of discharge, provided by autopilot for warning or external reactions 
         */
        public final Builder chargeState(Collection<Enum> flags) {
            return chargeState(EnumValue.create(flags));
        }

        /**
         * Battery voltages for cells 11 to 14. Cells above the valid cell count for this battery should 
         * have a value of 0, where zero indicates not supported (note, this is different than for the 
         * voltages field and allows empty byte truncation). If the measured value is 0 then 1 should be 
         * sent instead. 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 2,
                arraySize = 4,
                extension = true,
                description = "Battery voltages for cells 11 to 14. Cells above the valid cell count for this battery should have a value of 0, where zero indicates not supported (note, this is different than for the voltages field and allows empty byte truncation). If the measured value is 0 then 1 should be sent instead."
        )
        public final Builder voltagesExt(List<Integer> voltagesExt) {
            this.voltagesExt = voltagesExt;
            return this;
        }

        /**
         * Battery mode. Default (0) is that battery mode reporting is not supported or battery is in 
         * normal-use mode. 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 1,
                enumType = MavBatteryMode.class,
                extension = true,
                description = "Battery mode. Default (0) is that battery mode reporting is not supported or battery is in normal-use mode."
        )
        public final Builder mode(EnumValue<MavBatteryMode> mode) {
            this.mode = mode;
            return this;
        }

        /**
         * Battery mode. Default (0) is that battery mode reporting is not supported or battery is in 
         * normal-use mode. 
         */
        public final Builder mode(MavBatteryMode entry) {
            return mode(EnumValue.of(entry));
        }

        /**
         * Battery mode. Default (0) is that battery mode reporting is not supported or battery is in 
         * normal-use mode. 
         */
        public final Builder mode(Enum... flags) {
            return mode(EnumValue.create(flags));
        }

        /**
         * Battery mode. Default (0) is that battery mode reporting is not supported or battery is in 
         * normal-use mode. 
         */
        public final Builder mode(Collection<Enum> flags) {
            return mode(EnumValue.create(flags));
        }

        /**
         * Fault/health indications. These should be set when charge_state is 
         * MAV_BATTERY_CHARGE_STATE_FAILED or MAV_BATTERY_CHARGE_STATE_UNHEALTHY (if not, fault 
         * reporting is not supported). 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 4,
                enumType = MavBatteryFault.class,
                extension = true,
                description = "Fault/health indications. These should be set when charge_state is MAV_BATTERY_CHARGE_STATE_FAILED or MAV_BATTERY_CHARGE_STATE_UNHEALTHY (if not, fault reporting is not supported)."
        )
        public final Builder faultBitmask(EnumValue<MavBatteryFault> faultBitmask) {
            this.faultBitmask = faultBitmask;
            return this;
        }

        /**
         * Fault/health indications. These should be set when charge_state is 
         * MAV_BATTERY_CHARGE_STATE_FAILED or MAV_BATTERY_CHARGE_STATE_UNHEALTHY (if not, fault 
         * reporting is not supported). 
         */
        public final Builder faultBitmask(MavBatteryFault entry) {
            return faultBitmask(EnumValue.of(entry));
        }

        /**
         * Fault/health indications. These should be set when charge_state is 
         * MAV_BATTERY_CHARGE_STATE_FAILED or MAV_BATTERY_CHARGE_STATE_UNHEALTHY (if not, fault 
         * reporting is not supported). 
         */
        public final Builder faultBitmask(Enum... flags) {
            return faultBitmask(EnumValue.create(flags));
        }

        /**
         * Fault/health indications. These should be set when charge_state is 
         * MAV_BATTERY_CHARGE_STATE_FAILED or MAV_BATTERY_CHARGE_STATE_UNHEALTHY (if not, fault 
         * reporting is not supported). 
         */
        public final Builder faultBitmask(Collection<Enum> flags) {
            return faultBitmask(EnumValue.create(flags));
        }

        public final BatteryStatus build() {
            return new BatteryStatus(id, batteryFunction, type, temperature, voltages, currentBattery, currentConsumed, energyConsumed, batteryRemaining, timeRemaining, chargeState, voltagesExt, mode, faultBitmask);
        }
    }
}
