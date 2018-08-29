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
 * Write registers for a device 
 */
@MavlinkMessageInfo(
        id = 11002,
        crc = 234
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

    private DeviceOpWrite(int targetSystem, int targetComponent, long requestId,
            EnumValue<DeviceOpBustype> bustype, int bus, int address, String busname, int regstart,
            int count, byte[] data) {
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
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * System ID 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * request ID - copied to reply 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final long requestId() {
        return this.requestId;
    }

    /**
     * The bus type 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            enumType = DeviceOpBustype.class
    )
    public final EnumValue<DeviceOpBustype> bustype() {
        return this.bustype;
    }

    /**
     * Bus number 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final int bus() {
        return this.bus;
    }

    /**
     * Bus address 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1
    )
    public final int address() {
        return this.address;
    }

    /**
     * Name of device on bus (for SPI) 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1,
            arraySize = 40
    )
    public final String busname() {
        return this.busname;
    }

    /**
     * First register to write 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1
    )
    public final int regstart() {
        return this.regstart;
    }

    /**
     * count of registers to write 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 1
    )
    public final int count() {
        return this.count;
    }

    /**
     * write data 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1,
            arraySize = 128
    )
    public final byte[] data() {
        return this.data;
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
                 + ", data=" + data + "}";
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

        /**
         * System ID 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component ID 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * request ID - copied to reply 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder requestId(long requestId) {
            this.requestId = requestId;
            return this;
        }

        /**
         * The bus type 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                enumType = DeviceOpBustype.class
        )
        public final Builder bustype(EnumValue<DeviceOpBustype> bustype) {
            this.bustype = bustype;
            return this;
        }

        /**
         * The bus type 
         */
        public final Builder bustype(DeviceOpBustype entry) {
            return bustype(EnumValue.of(entry));
        }

        /**
         * The bus type 
         */
        public final Builder bustype(Enum... flags) {
            return bustype(EnumValue.create(flags));
        }

        /**
         * The bus type 
         */
        public final Builder bustype(Collection<Enum> flags) {
            return bustype(EnumValue.create(flags));
        }

        /**
         * Bus number 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1
        )
        public final Builder bus(int bus) {
            this.bus = bus;
            return this;
        }

        /**
         * Bus address 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1
        )
        public final Builder address(int address) {
            this.address = address;
            return this;
        }

        /**
         * Name of device on bus (for SPI) 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1,
                arraySize = 40
        )
        public final Builder busname(String busname) {
            this.busname = busname;
            return this;
        }

        /**
         * First register to write 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 1
        )
        public final Builder regstart(int regstart) {
            this.regstart = regstart;
            return this;
        }

        /**
         * count of registers to write 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 1
        )
        public final Builder count(int count) {
            this.count = count;
            return this;
        }

        /**
         * write data 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 1,
                arraySize = 128
        )
        public final Builder data(byte[] data) {
            this.data = data;
            return this;
        }

        public final DeviceOpWrite build() {
            return new DeviceOpWrite(targetSystem, targetComponent, requestId, bustype, bus, address, busname, regstart, count, data);
        }
    }
}
