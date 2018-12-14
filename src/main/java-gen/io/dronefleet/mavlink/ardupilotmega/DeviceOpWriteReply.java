package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Write registers reply. 
 */
@MavlinkMessageInfo(
        id = 11003,
        crc = 64,
        description = "Write registers reply."
)
public final class DeviceOpWriteReply {
    private final long requestId;

    private final int result;

    private DeviceOpWriteReply(long requestId, int result) {
        this.requestId = requestId;
        this.result = result;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        DeviceOpWriteReply other = (DeviceOpWriteReply)o;
        if (!Objects.deepEquals(requestId, other.requestId)) return false;
        if (!Objects.deepEquals(result, other.result)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(requestId);
        result = 31 * result + Objects.hashCode(result);
        return result;
    }

    @Override
    public String toString() {
        return "DeviceOpWriteReply{requestId=" + requestId
                 + ", result=" + result + "}";
    }

    public static final class Builder {
        private long requestId;

        private int result;

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

        public final DeviceOpWriteReply build() {
            return new DeviceOpWriteReply(requestId, result);
        }
    }
}
