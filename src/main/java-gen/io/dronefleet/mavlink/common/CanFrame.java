package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * A forwarded CAN frame as requested by MAV_CMD_CAN_FORWARD. 
 */
@MavlinkMessageInfo(
        id = 386,
        crc = 132,
        description = "A forwarded CAN frame as requested by MAV_CMD_CAN_FORWARD."
)
public final class CanFrame {
    private final int targetSystem;

    private final int targetComponent;

    private final int bus;

    private final int len;

    private final long id;

    private final byte[] data;

    private CanFrame(int targetSystem, int targetComponent, int bus, int len, long id,
            byte[] data) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.bus = bus;
        this.len = len;
        this.id = id;
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
     * Bus number 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "Bus number"
    )
    public final int bus() {
        return this.bus;
    }

    /**
     * Frame length 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "Frame length"
    )
    public final int len() {
        return this.len;
    }

    /**
     * Frame ID 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Frame ID"
    )
    public final long id() {
        return this.id;
    }

    /**
     * Frame data 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            arraySize = 8,
            description = "Frame data"
    )
    public final byte[] data() {
        return this.data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        CanFrame other = (CanFrame)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(bus, other.bus)) return false;
        if (!Objects.deepEquals(len, other.len)) return false;
        if (!Objects.deepEquals(id, other.id)) return false;
        if (!Objects.deepEquals(data, other.data)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(bus);
        result = 31 * result + Objects.hashCode(len);
        result = 31 * result + Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        return "CanFrame{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", bus=" + bus
                 + ", len=" + len
                 + ", id=" + id
                 + ", data=" + data + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int bus;

        private int len;

        private long id;

        private byte[] data;

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
         * Bus number 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "Bus number"
        )
        public final Builder bus(int bus) {
            this.bus = bus;
            return this;
        }

        /**
         * Frame length 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "Frame length"
        )
        public final Builder len(int len) {
            this.len = len;
            return this;
        }

        /**
         * Frame ID 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Frame ID"
        )
        public final Builder id(long id) {
            this.id = id;
            return this;
        }

        /**
         * Frame data 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                arraySize = 8,
                description = "Frame data"
        )
        public final Builder data(byte[] data) {
            this.data = data;
            return this;
        }

        public final CanFrame build() {
            return new CanFrame(targetSystem, targetComponent, bus, len, id, data);
        }
    }
}
