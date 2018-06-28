package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Write registers reply 
 */
@MavlinkMessageInfo(
        id = 11003,
        crc = 64
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
     * request ID - copied from request 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final long requestId() {
        return this.requestId;
    }

    /**
     * 0 for success, anything else is failure code 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int result() {
        return this.result;
    }

    public static final class Builder {
        private long requestId;

        private int result;

        /**
         * request ID - copied from request 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
        )
        public final Builder requestId(long requestId) {
            this.requestId = requestId;
            return this;
        }

        /**
         * 0 for success, anything else is failure code 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
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
