package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Control a serial port. This can be used for raw access to an onboard serial peripheral such as a 
 * GPS or telemetry radio. It is designed to make it possible to update the devices firmware via 
 * MAVLink messages or change the devices settings. A message with zero bytes can be used to change 
 * just the baudrate. 
 */
@MavlinkMessageInfo(
        id = 126,
        crc = 220
)
public final class SerialControl {
    private final EnumValue<SerialControlDev> device;

    private final EnumValue<SerialControlFlag> flags;

    private final int timeout;

    private final long baudrate;

    private final int count;

    private final byte[] data;

    private SerialControl(EnumValue<SerialControlDev> device, EnumValue<SerialControlFlag> flags,
            int timeout, long baudrate, int count, byte[] data) {
        this.device = device;
        this.flags = flags;
        this.timeout = timeout;
        this.baudrate = baudrate;
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
     * See {@link io.dronefleet.mavlink.common.SerialControlDev SERIAL_CONTROL_DEV} enum 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            enumType = SerialControlDev.class
    )
    public final EnumValue<SerialControlDev> device() {
        return this.device;
    }

    /**
     * See {@link io.dronefleet.mavlink.common.SerialControlFlag SERIAL_CONTROL_FLAG} enum 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = SerialControlFlag.class
    )
    public final EnumValue<SerialControlFlag> flags() {
        return this.flags;
    }

    /**
     * Timeout for reply data in milliseconds 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2
    )
    public final int timeout() {
        return this.timeout;
    }

    /**
     * Baudrate of transfer. Zero means no change. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final long baudrate() {
        return this.baudrate;
    }

    /**
     * how many bytes in this transfer 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final int count() {
        return this.count;
    }

    /**
     * serial data 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            arraySize = 70
    )
    public final byte[] data() {
        return this.data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SerialControl other = (SerialControl)o;
        if (!Objects.deepEquals(device, other.device)) return false;
        if (!Objects.deepEquals(flags, other.flags)) return false;
        if (!Objects.deepEquals(timeout, other.timeout)) return false;
        if (!Objects.deepEquals(baudrate, other.baudrate)) return false;
        if (!Objects.deepEquals(count, other.count)) return false;
        if (!Objects.deepEquals(data, other.data)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(device);
        result = 31 * result + Objects.hashCode(flags);
        result = 31 * result + Objects.hashCode(timeout);
        result = 31 * result + Objects.hashCode(baudrate);
        result = 31 * result + Objects.hashCode(count);
        result = 31 * result + Objects.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        return "SerialControl{device=" + device
                 + ", flags=" + flags
                 + ", timeout=" + timeout
                 + ", baudrate=" + baudrate
                 + ", count=" + count
                 + ", data=" + data + "}";
    }

    public static final class Builder {
        private EnumValue<SerialControlDev> device;

        private EnumValue<SerialControlFlag> flags;

        private int timeout;

        private long baudrate;

        private int count;

        private byte[] data;

        /**
         * See {@link io.dronefleet.mavlink.common.SerialControlDev SERIAL_CONTROL_DEV} enum 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                enumType = SerialControlDev.class
        )
        public final Builder device(EnumValue<SerialControlDev> device) {
            this.device = device;
            return this;
        }

        /**
         * See {@link io.dronefleet.mavlink.common.SerialControlDev SERIAL_CONTROL_DEV} enum 
         */
        public final Builder device(SerialControlDev entry) {
            this.device = EnumValue.of(entry);
            return this;
        }

        /**
         * See {@link io.dronefleet.mavlink.common.SerialControlDev SERIAL_CONTROL_DEV} enum 
         */
        public final Builder device(Enum... flags) {
            this.device = EnumValue.create(flags);
            return this;
        }

        /**
         * See {@link io.dronefleet.mavlink.common.SerialControlFlag SERIAL_CONTROL_FLAG} enum 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                enumType = SerialControlFlag.class
        )
        public final Builder flags(EnumValue<SerialControlFlag> flags) {
            this.flags = flags;
            return this;
        }

        /**
         * See {@link io.dronefleet.mavlink.common.SerialControlFlag SERIAL_CONTROL_FLAG} enum 
         */
        public final Builder flags(SerialControlFlag entry) {
            this.flags = EnumValue.of(entry);
            return this;
        }

        /**
         * See {@link io.dronefleet.mavlink.common.SerialControlFlag SERIAL_CONTROL_FLAG} enum 
         */
        public final Builder flags(Enum... flags) {
            this.flags = EnumValue.create(flags);
            return this;
        }

        /**
         * Timeout for reply data in milliseconds 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2
        )
        public final Builder timeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        /**
         * Baudrate of transfer. Zero means no change. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder baudrate(long baudrate) {
            this.baudrate = baudrate;
            return this;
        }

        /**
         * how many bytes in this transfer 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1
        )
        public final Builder count(int count) {
            this.count = count;
            return this;
        }

        /**
         * serial data 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                arraySize = 70
        )
        public final Builder data(byte[] data) {
            this.data = data;
            return this;
        }

        public final SerialControl build() {
            return new SerialControl(device, flags, timeout, baudrate, count, data);
        }
    }
}
