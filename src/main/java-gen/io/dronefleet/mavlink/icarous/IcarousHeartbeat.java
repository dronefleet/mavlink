package io.dronefleet.mavlink.icarous;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * ICAROUS heartbeat 
 */
@MavlinkMessageInfo(
        id = 42000,
        crc = 227
)
public final class IcarousHeartbeat {
    /**
     * See the FMS_STATE enum. 
     */
    private final IcarousFmsState status;

    private IcarousHeartbeat(IcarousFmsState status) {
        this.status = status;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "IcarousHeartbeat{status=" + status + "}";
    }

    /**
     * See the FMS_STATE enum. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final IcarousFmsState status() {
        return status;
    }

    public static class Builder {
        private IcarousFmsState status;

        private Builder() {
        }

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
