package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.String;

/**
 * Read registers for a device 
 */
@MavlinkMessageInfo(
        id = 11000,
        crc = 134
)
public final class DeviceOpRead {
    private final int targetSystem;

    private final int targetComponent;

    private final long requestId;

    private final DeviceOpBustype bustype;

    private final int bus;

    private final int address;

    private final String busname;

    private final int regstart;

    private final int count;

    private DeviceOpRead(int targetSystem, int targetComponent, long requestId,
            DeviceOpBustype bustype, int bus, int address, String busname, int regstart,
            int count) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.requestId = requestId;
        this.bustype = bustype;
        this.bus = bus;
        this.address = address;
        this.busname = busname;
        this.regstart = regstart;
        this.count = count;
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
            unitSize = 1
    )
    public final DeviceOpBustype bustype() {
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
     * First register to read 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1
    )
    public final int regstart() {
        return this.regstart;
    }

    /**
     * count of registers to read 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 1
    )
    public final int count() {
        return this.count;
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private long requestId;

        private DeviceOpBustype bustype;

        private int bus;

        private int address;

        private String busname;

        private int regstart;

        private int count;

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
                unitSize = 1
        )
        public final Builder bustype(DeviceOpBustype bustype) {
            this.bustype = bustype;
            return this;
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
         * First register to read 
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
         * count of registers to read 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 1
        )
        public final Builder count(int count) {
            this.count = count;
            return this;
        }

        public final DeviceOpRead build() {
            return new DeviceOpRead(targetSystem, targetComponent, requestId, bustype, bus, address, busname, regstart, count);
        }
    }
}
