package io.dronefleet.mavlink.ardupilotmega;

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
 * Write registers for a device. 
 */
@MavlinkMessageInfo(
        id = 11002,
        crc = 234,
        description = "Write registers for a device."
)
public final class DeviceOpWrite {
    private final int targetSystem;

    private final int targetComponent;

    private final long requestId;

    private final EnumValue<DeviceOpBustype> bustype;

    private final int bus;

    private final int address;

    private final String busname;

    private final int regstart;

    private final int count;

    private final byte[] data;

    private final int bank;

    private DeviceOpWrite(int targetSystem, int targetComponent, long requestId,
            EnumValue<DeviceOpBustype> bustype, int bus, int address, String busname, int regstart,
            int count, byte[] data, int bank) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.requestId = requestId;
        this.bustype = bustype;
        this.bus = bus;
        this.address = address;
        this.busname = busname;
        this.regstart = regstart;
        this.count = count;
        this.data = data;
        this.bank = bank;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * System ID. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "System ID."
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Component ID."
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Request ID - copied to reply. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Request ID - copied to reply."
    )
    public final long requestId() {
        return this.requestId;
    }

    /**
     * The bus type. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            enumType = DeviceOpBustype.class,
            description = "The bus type."
    )
    public final EnumValue<DeviceOpBustype> bustype() {
        return this.bustype;
    }

    /**
     * Bus number. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            description = "Bus number."
    )
    public final int bus() {
        return this.bus;
    }

    /**
     * Bus address. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            description = "Bus address."
    )
    public final int address() {
        return this.address;
    }

    /**
     * Name of device on bus (for SPI). 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1,
            arraySize = 40,
            description = "Name of device on bus (for SPI)."
    )
    public final String busname() {
        return this.busname;
    }

    /**
     * First register to write. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1,
            description = "First register to write."
    )
    public final int regstart() {
        return this.regstart;
    }

    /**
     * Count of registers to write. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 1,
            description = "Count of registers to write."
    )
    public final int count() {
        return this.count;
    }

    /**
     * Write data. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1,
            arraySize = 128,
            description = "Write data."
    )
    public final byte[] data() {
        return this.data;
    }

    /**
     * Bank number. 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 1,
            extension = true,
            description = "Bank number."
    )
    public final int bank() {
        return this.bank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        DeviceOpWrite other = (DeviceOpWrite)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(requestId, other.requestId)) return false;
        if (!Objects.deepEquals(bustype, other.bustype)) return false;
        if (!Objects.deepEquals(bus, other.bus)) return false;
        if (!Objects.deepEquals(address, other.address)) return false;
        if (!Objects.deepEquals(busname, other.busname)) return false;
        if (!Objects.deepEquals(regstart, other.regstart)) return false;
        if (!Objects.deepEquals(count, other.count)) return false;
        if (!Objects.deepEquals(data, other.data)) return false;
        if (!Objects.deepEquals(bank, other.bank)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(requestId);
        result = 31 * result + Objects.hashCode(bustype);
        result = 31 * result + Objects.hashCode(bus);
        result = 31 * result + Objects.hashCode(address);
        result = 31 * result + Objects.hashCode(busname);
        result = 31 * result + Objects.hashCode(regstart);
        result = 31 * result + Objects.hashCode(count);
        result = 31 * result + Objects.hashCode(data);
        result = 31 * result + Objects.hashCode(bank);
        return result;
    }

    @Override
    public String toString() {
        return "DeviceOpWrite{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", requestId=" + requestId
                 + ", bustype=" + bustype
                 + ", bus=" + bus
                 + ", address=" + address
                 + ", busname=" + busname
                 + ", regstart=" + regstart
                 + ", count=" + count
                 + ", data=" + data
                 + ", bank=" + bank + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private long requestId;

        private EnumValue<DeviceOpBustype> bustype;

        private int bus;

        private int address;

        private String busname;

        private int regstart;

        private int count;

        private byte[] data;

        private int bank;

        /**
         * System ID. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "System ID."
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component ID. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Component ID."
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Request ID - copied to reply. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Request ID - copied to reply."
        )
        public final Builder requestId(long requestId) {
            this.requestId = requestId;
            return this;
        }

        /**
         * The bus type. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                enumType = DeviceOpBustype.class,
                description = "The bus type."
        )
        public final Builder bustype(EnumValue<DeviceOpBustype> bustype) {
            this.bustype = bustype;
            return this;
        }

        /**
         * The bus type. 
         */
        public final Builder bustype(DeviceOpBustype entry) {
            return bustype(EnumValue.of(entry));
        }

        /**
         * The bus type. 
         */
        public final Builder bustype(Enum... flags) {
            return bustype(EnumValue.create(flags));
        }

        /**
         * The bus type. 
         */
        public final Builder bustype(Collection<Enum> flags) {
            return bustype(EnumValue.create(flags));
        }

        /**
         * Bus number. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                description = "Bus number."
        )
        public final Builder bus(int bus) {
            this.bus = bus;
            return this;
        }

        /**
         * Bus address. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                description = "Bus address."
        )
        public final Builder address(int address) {
            this.address = address;
            return this;
        }

        /**
         * Name of device on bus (for SPI). 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1,
                arraySize = 40,
                description = "Name of device on bus (for SPI)."
        )
        public final Builder busname(String busname) {
            this.busname = busname;
            return this;
        }

        /**
         * First register to write. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 1,
                description = "First register to write."
        )
        public final Builder regstart(int regstart) {
            this.regstart = regstart;
            return this;
        }

        /**
         * Count of registers to write. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 1,
                description = "Count of registers to write."
        )
        public final Builder count(int count) {
            this.count = count;
            return this;
        }

        /**
         * Write data. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 1,
                arraySize = 128,
                description = "Write data."
        )
        public final Builder data(byte[] data) {
            this.data = data;
            return this;
        }

        /**
         * Bank number. 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 1,
                extension = true,
                description = "Bank number."
        )
        public final Builder bank(int bank) {
            this.bank = bank;
            return this;
        }

        public final DeviceOpWrite build() {
            return new DeviceOpWrite(targetSystem, targetComponent, requestId, bustype, bus, address, busname, regstart, count, data, bank);
        }
    }
}
