package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Integer;
import java.util.List;

/**
 * Battery information 
 */
@MavlinkMessageInfo(
        id = 147,
        crc = 210
)
public final class BatteryStatus {
    private final int id;

    private final MavBatteryFunction batteryFunction;

    private final MavBatteryType type;

    private final int temperature;

    private final List<Integer> voltages;

    private final int currentBattery;

    private final int currentConsumed;

    private final int energyConsumed;

    private final int batteryRemaining;

    private final int timeRemaining;

    private final MavBatteryChargeState chargeState;

    private BatteryStatus(int id, MavBatteryFunction batteryFunction, MavBatteryType type,
            int temperature, List<Integer> voltages, int currentBattery, int currentConsumed,
            int energyConsumed, int batteryRemaining, int timeRemaining,
            MavBatteryChargeState chargeState) {
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
            unitSize = 1
    )
    public final MavBatteryFunction batteryFunction() {
        return this.batteryFunction;
    }

    /**
     * Type (chemistry) of the battery 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final MavBatteryType type() {
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
            extension = true
    )
    public final MavBatteryChargeState chargeState() {
        return this.chargeState;
    }

    public static final class Builder {
        private int id;

        private MavBatteryFunction batteryFunction;

        private MavBatteryType type;

        private int temperature;

        private List<Integer> voltages;

        private int currentBattery;

        private int currentConsumed;

        private int energyConsumed;

        private int batteryRemaining;

        private int timeRemaining;

        private MavBatteryChargeState chargeState;

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
                unitSize = 1
        )
        public final Builder batteryFunction(MavBatteryFunction batteryFunction) {
            this.batteryFunction = batteryFunction;
            return this;
        }

        /**
         * Type (chemistry) of the battery 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder type(MavBatteryType type) {
            this.type = type;
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
                extension = true
        )
        public final Builder chargeState(MavBatteryChargeState chargeState) {
            this.chargeState = chargeState;
            return this;
        }

        public final BatteryStatus build() {
            return new BatteryStatus(id, batteryFunction, type, temperature, voltages, currentBattery, currentConsumed, energyConsumed, batteryRemaining, timeRemaining, chargeState);
        }
    }
}
