package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.util.Objects;

/**
 * Response from a {@link io.dronefleet.mavlink.ardupilotmega.GoproCommand GOPRO_COMMAND} set request 
 */
@MavlinkMessageInfo(
        id = 219,
        crc = 162
)
public final class GoproSetResponse {
    private final GoproCommand cmdId;

    private final GoproRequestStatus status;

    private GoproSetResponse(GoproCommand cmdId, GoproRequestStatus status) {
        this.cmdId = cmdId;
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
     * Command ID 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final GoproCommand cmdId() {
        return this.cmdId;
    }

    /**
     * Status 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final GoproRequestStatus status() {
        return this.status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        GoproSetResponse other = (GoproSetResponse)o;
        if (!Objects.deepEquals(cmdId, other.cmdId)) return false;
        if (!Objects.deepEquals(status, other.status)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(cmdId);
        result = 31 * result + Objects.hashCode(status);
        return result;
    }

    public static final class Builder {
        private GoproCommand cmdId;

        private GoproRequestStatus status;

        /**
         * Command ID 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder cmdId(GoproCommand cmdId) {
            this.cmdId = cmdId;
            return this;
        }

        /**
         * Status 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder status(GoproRequestStatus status) {
            this.status = status;
            return this;
        }

        public final GoproSetResponse build() {
            return new GoproSetResponse(cmdId, status);
        }
    }
}
