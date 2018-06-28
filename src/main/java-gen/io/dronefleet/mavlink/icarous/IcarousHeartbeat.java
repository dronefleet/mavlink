package io.dronefleet.mavlink.icarous;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * ICAROUS heartbeat 
 */
@MavlinkMessageInfo(
        id = 42000,
        crc = 227
)
public final class IcarousHeartbeat {
    private final IcarousFmsState status;

    private IcarousHeartbeat(IcarousFmsState status) {
        this.status = status;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * See the FMS_STATE enum. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final IcarousFmsState status() {
        return this.status;
    }

    public static final class Builder {
        private IcarousFmsState status;

        /**
         * See the FMS_STATE enum. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder status(IcarousFmsState status) {
            this.status = status;
            return this;
        }

        public final IcarousHeartbeat build() {
            return new IcarousHeartbeat(status);
        }
    }
}
