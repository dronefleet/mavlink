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
 * Smart Battery information (static/infrequent update). Use for updates from: smart battery 
 * to flight stack, flight stack to GCS. Use {@link io.dronefleet.mavlink.common.BatteryStatus BATTERY_STATUS} for smart battery frequent updates. 
 */
@MavlinkMessageInfo(
        id = 370,
        crc = 75,
        description = "Smart Battery information (static/infrequent update). Use for updates from: smart battery to flight stack, flight stack to GCS. Use BATTERY_STATUS for smart battery frequent updates."
)
public final class SmartBatteryInfo {
    private final int id;

    private final EnumValue<MavBatteryFunction> batteryFunction;

    private final EnumValue<MavBatteryType> type;

    private final int capacityFullSpecification;

    private final int capacityFull;

    private final int cycleCount;

    private final String serialNumber;

    private final String deviceName;

    private final int weight;

    private final int dischargeMinimumVoltage;

    private final int chargingMinimumVoltage;

    private final int restingMinimumVoltage;

    private final int chargingMaximumVoltage;

    private final int cellsInSeries;

    private final long dischargeMaximumCurrent;

    private final long dischargeMaximumBurstCurrent;

    private final String manufactureDate;

    private SmartBatteryInfo(int id, EnumValue<MavBatteryFunction> batteryFunction,
            EnumValue<MavBatteryType> type, int capacityFullSpecification, int capacityFull,
            int cycleCount, String serialNumber, String deviceName, int weight,
            int dischargeMinimumVoltage, int chargingMinimumVoltage, int restingMinimumVoltage,
            int chargingMaximumVoltage, int cellsInSeries, long dischargeMaximumCurrent,
            long dischargeMaximumBurstCurrent, String manufactureDate) {
        this.id = id;
        this.batteryFunction = batteryFunction;
        this.type = type;
        this.capacityFullSpecification = capacityFullSpecification;
        this.capacityFull = capacityFull;
        this.cycleCount = cycleCount;
        this.serialNumber = serialNumber;
        this.deviceName = deviceName;
        this.weight = weight;
        this.dischargeMinimumVoltage = dischargeMinimumVoltage;
        this.chargingMinimumVoltage = chargingMinimumVoltage;
        this.restingMinimumVoltage = restingMinimumVoltage;
        this.chargingMaximumVoltage = chargingMaximumVoltage;
        this.cellsInSeries = cellsInSeries;
        this.dischargeMaximumCurrent = dischargeMaximumCurrent;
        this.dischargeMaximumBurstCurrent = dischargeMaximumBurstCurrent;
        this.manufactureDate = manufactureDate;
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
     * Capacity when full according to manufacturer, -1: field not provided. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            signed = true,
            description = "Capacity when full according to manufacturer, -1: field not provided."
    )
    public final int capacityFullSpecification() {
        return this.capacityFullSpecification;
    }

    /**
     * Capacity when full (accounting for battery degradation), -1: field not provided. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true,
            description = "Capacity when full (accounting for battery degradation), -1: field not provided."
    )
    public final int capacityFull() {
        return this.capacityFull;
    }

    /**
     * Charge/discharge cycle count. UINT16_MAX: field not provided. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            description = "Charge/discharge cycle count. UINT16_MAX: field not provided."
    )
    public final int cycleCount() {
        return this.cycleCount;
    }

    /**
     * Serial number in ASCII characters, 0 terminated. All 0: field not provided. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1,
            arraySize = 16,
            description = "Serial number in ASCII characters, 0 terminated. All 0: field not provided."
    )
    public final String serialNumber() {
        return this.serialNumber;
    }

    /**
     * Static device name in ASCII characters, 0 terminated. All 0: field not provided. Encode as 
     * manufacturer name then product name separated using an underscore. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1,
            arraySize = 50,
            description = "Static device name in ASCII characters, 0 terminated. All 0: field not provided. Encode as manufacturer name then product name separated using an underscore."
    )
    public final String deviceName() {
        return this.deviceName;
    }

    /**
     * Battery weight. 0: field not provided. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2,
            description = "Battery weight. 0: field not provided."
    )
    public final int weight() {
        return this.weight;
    }

    /**
     * Minimum per-cell voltage when discharging. If not supplied set to UINT16_MAX value. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 2,
            description = "Minimum per-cell voltage when discharging. If not supplied set to UINT16_MAX value."
    )
    public final int dischargeMinimumVoltage() {
        return this.dischargeMinimumVoltage;
    }

    /**
     * Minimum per-cell voltage when charging. If not supplied set to UINT16_MAX value. 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 2,
            description = "Minimum per-cell voltage when charging. If not supplied set to UINT16_MAX value."
    )
    public final int chargingMinimumVoltage() {
        return this.chargingMinimumVoltage;
    }

    /**
     * Minimum per-cell voltage when resting. If not supplied set to UINT16_MAX value. 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 2,
            description = "Minimum per-cell voltage when resting. If not supplied set to UINT16_MAX value."
    )
    public final int restingMinimumVoltage() {
        return this.restingMinimumVoltage;
    }

    /**
     * Maximum per-cell voltage when charged. 0: field not provided. 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 2,
            extension = true,
            description = "Maximum per-cell voltage when charged. 0: field not provided."
    )
    public final int chargingMaximumVoltage() {
        return this.chargingMaximumVoltage;
    }

    /**
     * Number of battery cells in series. 0: field not provided. 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 1,
            extension = true,
            description = "Number of battery cells in series. 0: field not provided."
    )
    public final int cellsInSeries() {
        return this.cellsInSeries;
    }

    /**
     * Maximum pack discharge current. 0: field not provided. 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 4,
            extension = true,
            description = "Maximum pack discharge current. 0: field not provided."
    )
    public final long dischargeMaximumCurrent() {
        return this.dischargeMaximumCurrent;
    }

    /**
     * Maximum pack discharge burst current. 0: field not provided. 
     */
    @MavlinkFieldInfo(
            position = 17,
            unitSize = 4,
            extension = true,
            description = "Maximum pack discharge burst current. 0: field not provided."
    )
    public final long dischargeMaximumBurstCurrent() {
        return this.dischargeMaximumBurstCurrent;
    }

    /**
     * Manufacture date (DD/MM/YYYY) in ASCII characters, 0 terminated. All 0: field not provided. 
     */
    @MavlinkFieldInfo(
            position = 18,
            unitSize = 1,
            arraySize = 11,
            extension = true,
            description = "Manufacture date (DD/MM/YYYY) in ASCII characters, 0 terminated. All 0: field not provided."
    )
    public final String manufactureDate() {
        return this.manufactureDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SmartBatteryInfo other = (SmartBatteryInfo)o;
        if (!Objects.deepEquals(id, other.id)) return false;
        if (!Objects.deepEquals(batteryFunction, other.batteryFunction)) return false;
        if (!Objects.deepEquals(type, other.type)) return false;
        if (!Objects.deepEquals(capacityFullSpecification, other.capacityFullSpecification)) return false;
        if (!Objects.deepEquals(capacityFull, other.capacityFull)) return false;
        if (!Objects.deepEquals(cycleCount, other.cycleCount)) return false;
        if (!Objects.deepEquals(serialNumber, other.serialNumber)) return false;
        if (!Objects.deepEquals(deviceName, other.deviceName)) return false;
        if (!Objects.deepEquals(weight, other.weight)) return false;
        if (!Objects.deepEquals(dischargeMinimumVoltage, other.dischargeMinimumVoltage)) return false;
        if (!Objects.deepEquals(chargingMinimumVoltage, other.chargingMinimumVoltage)) return false;
        if (!Objects.deepEquals(restingMinimumVoltage, other.restingMinimumVoltage)) return false;
        if (!Objects.deepEquals(chargingMaximumVoltage, other.chargingMaximumVoltage)) return false;
        if (!Objects.deepEquals(cellsInSeries, other.cellsInSeries)) return false;
        if (!Objects.deepEquals(dischargeMaximumCurrent, other.dischargeMaximumCurrent)) return false;
        if (!Objects.deepEquals(dischargeMaximumBurstCurrent, other.dischargeMaximumBurstCurrent)) return false;
        if (!Objects.deepEquals(manufactureDate, other.manufactureDate)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(batteryFunction);
        result = 31 * result + Objects.hashCode(type);
        result = 31 * result + Objects.hashCode(capacityFullSpecification);
        result = 31 * result + Objects.hashCode(capacityFull);
        result = 31 * result + Objects.hashCode(cycleCount);
        result = 31 * result + Objects.hashCode(serialNumber);
        result = 31 * result + Objects.hashCode(deviceName);
        result = 31 * result + Objects.hashCode(weight);
        result = 31 * result + Objects.hashCode(dischargeMinimumVoltage);
        result = 31 * result + Objects.hashCode(chargingMinimumVoltage);
        result = 31 * result + Objects.hashCode(restingMinimumVoltage);
        result = 31 * result + Objects.hashCode(chargingMaximumVoltage);
        result = 31 * result + Objects.hashCode(cellsInSeries);
        result = 31 * result + Objects.hashCode(dischargeMaximumCurrent);
        result = 31 * result + Objects.hashCode(dischargeMaximumBurstCurrent);
        result = 31 * result + Objects.hashCode(manufactureDate);
        return result;
    }

    @Override
    public String toString() {
        return "SmartBatteryInfo{id=" + id
                 + ", batteryFunction=" + batteryFunction
                 + ", type=" + type
                 + ", capacityFullSpecification=" + capacityFullSpecification
                 + ", capacityFull=" + capacityFull
                 + ", cycleCount=" + cycleCount
                 + ", serialNumber=" + serialNumber
                 + ", deviceName=" + deviceName
                 + ", weight=" + weight
                 + ", dischargeMinimumVoltage=" + dischargeMinimumVoltage
                 + ", chargingMinimumVoltage=" + chargingMinimumVoltage
                 + ", restingMinimumVoltage=" + restingMinimumVoltage
                 + ", chargingMaximumVoltage=" + chargingMaximumVoltage
                 + ", cellsInSeries=" + cellsInSeries
                 + ", dischargeMaximumCurrent=" + dischargeMaximumCurrent
                 + ", dischargeMaximumBurstCurrent=" + dischargeMaximumBurstCurrent
                 + ", manufactureDate=" + manufactureDate + "}";
    }

    public static final class Builder {
        private int id;

        private EnumValue<MavBatteryFunction> batteryFunction;

        private EnumValue<MavBatteryType> type;

        private int capacityFullSpecification;

        private int capacityFull;

        private int cycleCount;

        private String serialNumber;

        private String deviceName;

        private int weight;

        private int dischargeMinimumVoltage;

        private int chargingMinimumVoltage;

        private int restingMinimumVoltage;

        private int chargingMaximumVoltage;

        private int cellsInSeries;

        private long dischargeMaximumCurrent;

        private long dischargeMaximumBurstCurrent;

        private String manufactureDate;

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
         * Capacity when full according to manufacturer, -1: field not provided. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                signed = true,
                description = "Capacity when full according to manufacturer, -1: field not provided."
        )
        public final Builder capacityFullSpecification(int capacityFullSpecification) {
            this.capacityFullSpecification = capacityFullSpecification;
            return this;
        }

        /**
         * Capacity when full (accounting for battery degradation), -1: field not provided. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true,
                description = "Capacity when full (accounting for battery degradation), -1: field not provided."
        )
        public final Builder capacityFull(int capacityFull) {
            this.capacityFull = capacityFull;
            return this;
        }

        /**
         * Charge/discharge cycle count. UINT16_MAX: field not provided. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                description = "Charge/discharge cycle count. UINT16_MAX: field not provided."
        )
        public final Builder cycleCount(int cycleCount) {
            this.cycleCount = cycleCount;
            return this;
        }

        /**
         * Serial number in ASCII characters, 0 terminated. All 0: field not provided. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1,
                arraySize = 16,
                description = "Serial number in ASCII characters, 0 terminated. All 0: field not provided."
        )
        public final Builder serialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        /**
         * Static device name in ASCII characters, 0 terminated. All 0: field not provided. Encode as 
         * manufacturer name then product name separated using an underscore. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 1,
                arraySize = 50,
                description = "Static device name in ASCII characters, 0 terminated. All 0: field not provided. Encode as manufacturer name then product name separated using an underscore."
        )
        public final Builder deviceName(String deviceName) {
            this.deviceName = deviceName;
            return this;
        }

        /**
         * Battery weight. 0: field not provided. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2,
                description = "Battery weight. 0: field not provided."
        )
        public final Builder weight(int weight) {
            this.weight = weight;
            return this;
        }

        /**
         * Minimum per-cell voltage when discharging. If not supplied set to UINT16_MAX value. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 2,
                description = "Minimum per-cell voltage when discharging. If not supplied set to UINT16_MAX value."
        )
        public final Builder dischargeMinimumVoltage(int dischargeMinimumVoltage) {
            this.dischargeMinimumVoltage = dischargeMinimumVoltage;
            return this;
        }

        /**
         * Minimum per-cell voltage when charging. If not supplied set to UINT16_MAX value. 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 2,
                description = "Minimum per-cell voltage when charging. If not supplied set to UINT16_MAX value."
        )
        public final Builder chargingMinimumVoltage(int chargingMinimumVoltage) {
            this.chargingMinimumVoltage = chargingMinimumVoltage;
            return this;
        }

        /**
         * Minimum per-cell voltage when resting. If not supplied set to UINT16_MAX value. 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 2,
                description = "Minimum per-cell voltage when resting. If not supplied set to UINT16_MAX value."
        )
        public final Builder restingMinimumVoltage(int restingMinimumVoltage) {
            this.restingMinimumVoltage = restingMinimumVoltage;
            return this;
        }

        /**
         * Maximum per-cell voltage when charged. 0: field not provided. 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 2,
                extension = true,
                description = "Maximum per-cell voltage when charged. 0: field not provided."
        )
        public final Builder chargingMaximumVoltage(int chargingMaximumVoltage) {
            this.chargingMaximumVoltage = chargingMaximumVoltage;
            return this;
        }

        /**
         * Number of battery cells in series. 0: field not provided. 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 1,
                extension = true,
                description = "Number of battery cells in series. 0: field not provided."
        )
        public final Builder cellsInSeries(int cellsInSeries) {
            this.cellsInSeries = cellsInSeries;
            return this;
        }

        /**
         * Maximum pack discharge current. 0: field not provided. 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 4,
                extension = true,
                description = "Maximum pack discharge current. 0: field not provided."
        )
        public final Builder dischargeMaximumCurrent(long dischargeMaximumCurrent) {
            this.dischargeMaximumCurrent = dischargeMaximumCurrent;
            return this;
        }

        /**
         * Maximum pack discharge burst current. 0: field not provided. 
         */
        @MavlinkFieldInfo(
                position = 17,
                unitSize = 4,
                extension = true,
                description = "Maximum pack discharge burst current. 0: field not provided."
        )
        public final Builder dischargeMaximumBurstCurrent(long dischargeMaximumBurstCurrent) {
            this.dischargeMaximumBurstCurrent = dischargeMaximumBurstCurrent;
            return this;
        }

        /**
         * Manufacture date (DD/MM/YYYY) in ASCII characters, 0 terminated. All 0: field not provided. 
         */
        @MavlinkFieldInfo(
                position = 18,
                unitSize = 1,
                arraySize = 11,
                extension = true,
                description = "Manufacture date (DD/MM/YYYY) in ASCII characters, 0 terminated. All 0: field not provided."
        )
        public final Builder manufactureDate(String manufactureDate) {
            this.manufactureDate = manufactureDate;
            return this;
        }

        public final SmartBatteryInfo build() {
            return new SmartBatteryInfo(id, batteryFunction, type, capacityFullSpecification, capacityFull, cycleCount, serialNumber, deviceName, weight, dischargeMinimumVoltage, chargingMinimumVoltage, restingMinimumVoltage, chargingMaximumVoltage, cellsInSeries, dischargeMaximumCurrent, dischargeMaximumBurstCurrent, manufactureDate);
        }
    }
}
