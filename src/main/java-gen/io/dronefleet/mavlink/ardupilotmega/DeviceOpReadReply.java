package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Read registers reply. 
 */
@MavlinkMessageInfo(
        id = 11001,
        crc = 15,
        description = "Read registers reply."
)
public final class DeviceOpReadReply {
    private final long requestId;

    private final int result;

    private final int regstart;

    private final int count;

    private final byte[] data;

    private final int bank;

    private DeviceOpReadReply(long requestId, int result, int regstart, int count, byte[] data,
            int bank) {
        this.requestId = requestId;
        this.result = result;
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
     * Request ID - copied from request. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Request ID - copied from request."
    )
    public final long requestId() {
        return this.requestId;
    }

    /**
     * 0 for success, anything else is failure code. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "0 for success, anything else is failure code."
    )
    public final int result() {
        return this.result;
    }

    /**
     * Starting register. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "Starting register."
    )
    public final int regstart() {
        return this.regstart;
    }

    /**
     * Count of bytes read. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "Count of bytes read."
    )
    public final int count() {
        return this.count;
    }

    /**
     * Reply data. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            arraySize = 128,
            description = "Reply data."
    )
    public final byte[] data() {
        return this.data;
    }

    /**
     * Bank number. 
     */
    @MavlinkFieldInfo(
            position = 7,
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
        DeviceOpReadReply other = (DeviceOpReadReply)o;
        if (!Objects.deepEquals(requestId, other.requestId)) return false;
        if (!Objects.deepEquals(result, other.result)) return false;
        if (!Objects.deepEquals(regstart, other.regstart)) return false;
        if (!Objects.deepEquals(count, other.count)) return false;
        if (!Objects.deepEquals(data, other.data)) return false;
        if (!Objects.deepEquals(bank, other.bank)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(requestId);
        result = 31 * result + Objects.hashCode(result);
        result = 31 * result + Objects.hashCode(regstart);
        result = 31 * result + Objects.hashCode(count);
        result = 31 * result + Objects.hashCode(data);
        result = 31 * result + Objects.hashCode(bank);
        return result;
    }

    @Override
    public String toString() {
        return "DeviceOpReadReply{requestId=" + requestId
                 + ", result=" + result
                 + ", regstart=" + regstart
                 + ", count=" + count
                 + ", data=" + data
                 + ", bank=" + bank + "}";
    }

    public static final class Builder {
        private long requestId;

        private int result;

        private int regstart;

        private int count;

        private byte[] data;

        private int bank;

        /**
         * Request ID - copied from request. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Request ID - copied from request."
        )
        public final Builder requestId(long requestId) {
            this.requestId = requestId;
            return this;
        }

        /**
         * 0 for success, anything else is failure code. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "0 for success, anything else is failure code."
        )
        public final Builder result(int result) {
            this.result = result;
            return this;
        }

        /**
         * Starting register. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "Starting register."
        )
        public final Builder regstart(int regstart) {
            this.regstart = regstart;
            return this;
        }

        /**
         * Count of bytes read. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "Count of bytes read."
        )
        public final Builder count(int count) {
            this.count = count;
            return this;
        }

        /**
         * Reply data. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                arraySize = 128,
                description = "Reply data."
        )
        public final Builder data(byte[] data) {
            this.data = data;
            return this;
        }

        /**
         * Bank number. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1,
                extension = true,
                description = "Bank number."
        )
        public final Builder bank(int bank) {
            this.bank = bank;
            return this;
        }

        public final DeviceOpReadReply build() {
            return new DeviceOpReadReply(requestId, result, regstart, count, data, bank);
        }
    }
}
