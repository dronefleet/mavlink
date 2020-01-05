package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Deprecated;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Smart Battery information (static/infrequent update). Use for updates from: smart battery 
 * to flight stack, flight stack to GCS. Use instead of {@link io.dronefleet.mavlink.common.BatteryStatus BATTERY_STATUS} for smart batteries. 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 370,
        crc = 98,
        description = "Smart Battery information (static/infrequent update). Use for updates from: smart battery to flight stack, flight stack to GCS. Use instead of BATTERY_STATUS for smart batteries.",
        workInProgress = true
)
@Deprecated
public final class SmartBatteryInfo {
    private final int id;

    private final int capacityFullSpecification;

    private final int capacityFull;

    private final int cycleCount;

    private final int serialNumber;

    private final String deviceName;

    private final int weight;

    private final int dischargeMinimumVoltage;

    private final int chargingMinimumVoltage;

    private final int restingMinimumVoltage;

    private SmartBatteryInfo(int id, int capacityFullSpecification, int capacityFull,
            int cycleCount, int serialNumber, String deviceName, int weight,
            int dischargeMinimumVoltage, int chargingMinimumVoltage, int restingMinimumVoltage) {
        this.id = id;
        this.capacityFullSpecification = capacityFullSpecification;
        this.capacityFull = capacityFull;
        this.cycleCount = cycleCount;
        this.serialNumber = serialNumber;
        this.deviceName = deviceName;
        this.weight = weight;
        this.dischargeMinimumVoltage = dischargeMinimumVoltage;
        this.chargingMinimumVoltage = chargingMinimumVoltage;
        this.restingMinimumVoltage = restingMinimumVoltage;
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
            unitSize = 1,
            description = "Battery ID"
    )
    public final int id() {
        return this.id;
    }

    /**
     * Capacity when full according to manufacturer, -1: field not provided. 
     */
    @MavlinkFieldInfo(
            position = 3,
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
            position = 4,
            unitSize = 4,
            signed = true,
            description = "Capacity when full (accounting for battery degradation), -1: field not provided."
    )
    public final int capacityFull() {
        return this.capacityFull;
    }

    /**
     * Charge/discharge cycle count. -1: field not provided. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            description = "Charge/discharge cycle count. -1: field not provided."
    )
    public final int cycleCount() {
        return this.cycleCount;
    }

    /**
     * Serial number. -1: field not provided. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            signed = true,
            description = "Serial number. -1: field not provided."
    )
    public final int serialNumber() {
        return this.serialNumber;
    }

    /**
     * Static device name. Encode as manufacturer and product names separated using an underscore. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1,
            arraySize = 50,
            description = "Static device name. Encode as manufacturer and product names separated using an underscore."
    )
    public final String deviceName() {
        return this.deviceName;
    }

    /**
     * Battery weight. 0: field not provided. 
     */
    @MavlinkFieldInfo(
            position = 8,
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
            position = 9,
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
            position = 10,
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
            position = 11,
            unitSize = 2,
            description = "Minimum per-cell voltage when resting. If not supplied set to UINT16_MAX value."
    )
    public final int restingMinimumVoltage() {
        return this.restingMinimumVoltage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SmartBatteryInfo other = (SmartBatteryInfo)o;
        if (!Objects.deepEquals(id, other.id)) return false;
        if (!Objects.deepEquals(capacityFullSpecification, other.capacityFullSpecification)) return false;
        if (!Objects.deepEquals(capacityFull, other.capacityFull)) return false;
        if (!Objects.deepEquals(cycleCount, other.cycleCount)) return false;
        if (!Objects.deepEquals(serialNumber, other.serialNumber)) return false;
        if (!Objects.deepEquals(deviceName, other.deviceName)) return false;
        if (!Objects.deepEquals(weight, other.weight)) return false;
        if (!Objects.deepEquals(dischargeMinimumVoltage, other.dischargeMinimumVoltage)) return false;
        if (!Objects.deepEquals(chargingMinimumVoltage, other.chargingMinimumVoltage)) return false;
        if (!Objects.deepEquals(restingMinimumVoltage, other.restingMinimumVoltage)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(capacityFullSpecification);
        result = 31 * result + Objects.hashCode(capacityFull);
        result = 31 * result + Objects.hashCode(cycleCount);
        result = 31 * result + Objects.hashCode(serialNumber);
        result = 31 * result + Objects.hashCode(deviceName);
        result = 31 * result + Objects.hashCode(weight);
        result = 31 * result + Objects.hashCode(dischargeMinimumVoltage);
        result = 31 * result + Objects.hashCode(chargingMinimumVoltage);
        result = 31 * result + Objects.hashCode(restingMinimumVoltage);
        return result;
    }

    @Override
    public String toString() {
        return "SmartBatteryInfo{id=" + id
                 + ", capacityFullSpecification=" + capacityFullSpecification
                 + ", capacityFull=" + capacityFull
                 + ", cycleCount=" + cycleCount
                 + ", serialNumber=" + serialNumber
                 + ", deviceName=" + deviceName
                 + ", weight=" + weight
                 + ", dischargeMinimumVoltage=" + dischargeMinimumVoltage
                 + ", chargingMinimumVoltage=" + chargingMinimumVoltage
                 + ", restingMinimumVoltage=" + restingMinimumVoltage + "}";
    }

    public static final class Builder {
        private int id;

        private int capacityFullSpecification;

        private int capacityFull;

        private int cycleCount;

        private int serialNumber;

        private String deviceName;

        private int weight;

        private int dischargeMinimumVoltage;

        private int chargingMinimumVoltage;

        private int restingMinimumVoltage;

        /**
         * Battery ID 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Battery ID"
        )
        public final Builder id(int id) {
            this.id = id;
            return this;
        }

        /**
         * Capacity when full according to manufacturer, -1: field not provided. 
         */
        @MavlinkFieldInfo(
                position = 3,
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
                position = 4,
                unitSize = 4,
                signed = true,
                description = "Capacity when full (accounting for battery degradation), -1: field not provided."
        )
        public final Builder capacityFull(int capacityFull) {
            this.capacityFull = capacityFull;
            return this;
        }

        /**
         * Charge/discharge cycle count. -1: field not provided. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                description = "Charge/discharge cycle count. -1: field not provided."
        )
        public final Builder cycleCount(int cycleCount) {
            this.cycleCount = cycleCount;
            return this;
        }

        /**
         * Serial number. -1: field not provided. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                signed = true,
                description = "Serial number. -1: field not provided."
        )
        public final Builder serialNumber(int serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        /**
         * Static device name. Encode as manufacturer and product names separated using an underscore. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1,
                arraySize = 50,
                description = "Static device name. Encode as manufacturer and product names separated using an underscore."
        )
        public final Builder deviceName(String deviceName) {
            this.deviceName = deviceName;
            return this;
        }

        /**
         * Battery weight. 0: field not provided. 
         */
        @MavlinkFieldInfo(
                position = 8,
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
                position = 9,
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
                position = 10,
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
                position = 11,
                unitSize = 2,
                description = "Minimum per-cell voltage when resting. If not supplied set to UINT16_MAX value."
        )
        public final Builder restingMinimumVoltage(int restingMinimumVoltage) {
            this.restingMinimumVoltage = restingMinimumVoltage;
            return this;
        }

        public final SmartBatteryInfo build() {
            return new SmartBatteryInfo(id, capacityFullSpecification, capacityFull, cycleCount, serialNumber, deviceName, weight, dischargeMinimumVoltage, chargingMinimumVoltage, restingMinimumVoltage);
        }
    }
}
