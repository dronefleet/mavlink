package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Deprecated;
import java.lang.Enum;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Smart Battery information (dynamic). Use for updates from: smart battery to flight stack, 
 * flight stack to GCS. Use instead of {@link io.dronefleet.mavlink.common.BatteryStatus BATTERY_STATUS} for smart batteries. 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 371,
        crc = 161,
        description = "Smart Battery information (dynamic). Use for updates from: smart battery to flight stack, flight stack to GCS. Use instead of BATTERY_STATUS for smart batteries.",
        workInProgress = true
)
@Deprecated
public final class SmartBatteryStatus {
    private final int id;

    private final int capacityRemaining;

    private final int current;

    private final int temperature;

    private final EnumValue<MavSmartBatteryFault> faultBitmask;

    private final int timeRemaining;

    private final int cellOffset;

    private final List<Integer> voltages;

    private SmartBatteryStatus(int id, int capacityRemaining, int current, int temperature,
            EnumValue<MavSmartBatteryFault> faultBitmask, int timeRemaining, int cellOffset,
            List<Integer> voltages) {
        this.id = id;
        this.capacityRemaining = capacityRemaining;
        this.current = current;
        this.temperature = temperature;
        this.faultBitmask = faultBitmask;
        this.timeRemaining = timeRemaining;
        this.cellOffset = cellOffset;
        this.voltages = voltages;
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
            position = 2,
            unitSize = 2,
            description = "Battery ID"
    )
    public final int id() {
        return this.id;
    }

    /**
     * Remaining battery energy. Values: [0-100], -1: field not provided. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            signed = true,
            description = "Remaining battery energy. Values: [0-100], -1: field not provided."
    )
    public final int capacityRemaining() {
        return this.capacityRemaining;
    }

    /**
     * Battery current (through all cells/loads). Positive if discharging, negative if charging. 
     * UINT16_MAX: field not provided. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            signed = true,
            description = "Battery current (through all cells/loads). Positive if discharging, negative if charging. UINT16_MAX: field not provided."
    )
    public final int current() {
        return this.current;
    }

    /**
     * Battery temperature. -1: field not provided. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            signed = true,
            description = "Battery temperature. -1: field not provided."
    )
    public final int temperature() {
        return this.temperature;
    }

    /**
     * Fault/health indications. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            enumType = MavSmartBatteryFault.class,
            signed = true,
            description = "Fault/health indications."
    )
    public final EnumValue<MavSmartBatteryFault> faultBitmask() {
        return this.faultBitmask;
    }

    /**
     * Estimated remaining battery time. -1: field not provided. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            signed = true,
            description = "Estimated remaining battery time. -1: field not provided."
    )
    public final int timeRemaining() {
        return this.timeRemaining;
    }

    /**
     * The cell number of the first index in the 'voltages' array field. Using this field allows you to 
     * specify cell voltages for batteries with more than 16 cells. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2,
            description = "The cell number of the first index in the 'voltages' array field. Using this field allows you to specify cell voltages for batteries with more than 16 cells."
    )
    public final int cellOffset() {
        return this.cellOffset;
    }

    /**
     * Individual cell voltages. Batteries with more 16 cells can use the cell_offset field to 
     * specify the cell offset for the array specified in the current message . Index values above the 
     * valid cell count for this battery should have the UINT16_MAX value. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2,
            arraySize = 16,
            description = "Individual cell voltages. Batteries with more 16 cells can use the cell_offset field to specify the cell offset for the array specified in the current message . Index values above the valid cell count for this battery should have the UINT16_MAX value."
    )
    public final List<Integer> voltages() {
        return this.voltages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SmartBatteryStatus other = (SmartBatteryStatus)o;
        if (!Objects.deepEquals(id, other.id)) return false;
        if (!Objects.deepEquals(capacityRemaining, other.capacityRemaining)) return false;
        if (!Objects.deepEquals(current, other.current)) return false;
        if (!Objects.deepEquals(temperature, other.temperature)) return false;
        if (!Objects.deepEquals(faultBitmask, other.faultBitmask)) return false;
        if (!Objects.deepEquals(timeRemaining, other.timeRemaining)) return false;
        if (!Objects.deepEquals(cellOffset, other.cellOffset)) return false;
        if (!Objects.deepEquals(voltages, other.voltages)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(capacityRemaining);
        result = 31 * result + Objects.hashCode(current);
        result = 31 * result + Objects.hashCode(temperature);
        result = 31 * result + Objects.hashCode(faultBitmask);
        result = 31 * result + Objects.hashCode(timeRemaining);
        result = 31 * result + Objects.hashCode(cellOffset);
        result = 31 * result + Objects.hashCode(voltages);
        return result;
    }

    @Override
    public String toString() {
        return "SmartBatteryStatus{id=" + id
                 + ", capacityRemaining=" + capacityRemaining
                 + ", current=" + current
                 + ", temperature=" + temperature
                 + ", faultBitmask=" + faultBitmask
                 + ", timeRemaining=" + timeRemaining
                 + ", cellOffset=" + cellOffset
                 + ", voltages=" + voltages + "}";
    }

    public static final class Builder {
        private int id;

        private int capacityRemaining;

        private int current;

        private int temperature;

        private EnumValue<MavSmartBatteryFault> faultBitmask;

        private int timeRemaining;

        private int cellOffset;

        private List<Integer> voltages;

        /**
         * Battery ID 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                description = "Battery ID"
        )
        public final Builder id(int id) {
            this.id = id;
            return this;
        }

        /**
         * Remaining battery energy. Values: [0-100], -1: field not provided. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                signed = true,
                description = "Remaining battery energy. Values: [0-100], -1: field not provided."
        )
        public final Builder capacityRemaining(int capacityRemaining) {
            this.capacityRemaining = capacityRemaining;
            return this;
        }

        /**
         * Battery current (through all cells/loads). Positive if discharging, negative if charging. 
         * UINT16_MAX: field not provided. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                signed = true,
                description = "Battery current (through all cells/loads). Positive if discharging, negative if charging. UINT16_MAX: field not provided."
        )
        public final Builder current(int current) {
            this.current = current;
            return this;
        }

        /**
         * Battery temperature. -1: field not provided. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                signed = true,
                description = "Battery temperature. -1: field not provided."
        )
        public final Builder temperature(int temperature) {
            this.temperature = temperature;
            return this;
        }

        /**
         * Fault/health indications. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                enumType = MavSmartBatteryFault.class,
                signed = true,
                description = "Fault/health indications."
        )
        public final Builder faultBitmask(EnumValue<MavSmartBatteryFault> faultBitmask) {
            this.faultBitmask = faultBitmask;
            return this;
        }

        /**
         * Fault/health indications. 
         */
        public final Builder faultBitmask(MavSmartBatteryFault entry) {
            return faultBitmask(EnumValue.of(entry));
        }

        /**
         * Fault/health indications. 
         */
        public final Builder faultBitmask(Enum... flags) {
            return faultBitmask(EnumValue.create(flags));
        }

        /**
         * Fault/health indications. 
         */
        public final Builder faultBitmask(Collection<Enum> flags) {
            return faultBitmask(EnumValue.create(flags));
        }

        /**
         * Estimated remaining battery time. -1: field not provided. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                signed = true,
                description = "Estimated remaining battery time. -1: field not provided."
        )
        public final Builder timeRemaining(int timeRemaining) {
            this.timeRemaining = timeRemaining;
            return this;
        }

        /**
         * The cell number of the first index in the 'voltages' array field. Using this field allows you to 
         * specify cell voltages for batteries with more than 16 cells. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2,
                description = "The cell number of the first index in the 'voltages' array field. Using this field allows you to specify cell voltages for batteries with more than 16 cells."
        )
        public final Builder cellOffset(int cellOffset) {
            this.cellOffset = cellOffset;
            return this;
        }

        /**
         * Individual cell voltages. Batteries with more 16 cells can use the cell_offset field to 
         * specify the cell offset for the array specified in the current message . Index values above the 
         * valid cell count for this battery should have the UINT16_MAX value. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2,
                arraySize = 16,
                description = "Individual cell voltages. Batteries with more 16 cells can use the cell_offset field to specify the cell offset for the array specified in the current message . Index values above the valid cell count for this battery should have the UINT16_MAX value."
        )
        public final Builder voltages(List<Integer> voltages) {
            this.voltages = voltages;
            return this;
        }

        public final SmartBatteryStatus build() {
            return new SmartBatteryStatus(id, capacityRemaining, current, temperature, faultBitmask, timeRemaining, cellOffset, voltages);
        }
    }
}
