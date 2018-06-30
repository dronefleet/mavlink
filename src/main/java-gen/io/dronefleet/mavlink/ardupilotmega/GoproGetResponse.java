package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.util.Objects;

/**
 * Response from a {@link io.dronefleet.mavlink.ardupilotmega.GoproCommand GOPRO_COMMAND} get request 
 */
@MavlinkMessageInfo(
        id = 217,
        crc = 202
)
public final class GoproGetResponse {
    private final GoproCommand cmdId;

    private final GoproRequestStatus status;

    private final byte[] value;

    private GoproGetResponse(GoproCommand cmdId, GoproRequestStatus status, byte[] value) {
        this.cmdId = cmdId;
        this.status = status;
        this.value = value;
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

    /**
     * Value 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            arraySize = 4
    )
    public final byte[] value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        GoproGetResponse other = (GoproGetResponse)o;
        if (!Objects.deepEquals(cmdId, other.cmdId)) return false;
        if (!Objects.deepEquals(status, other.status)) return false;
        if (!Objects.deepEquals(value, other.value)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(cmdId);
        result = 31 * result + Objects.hashCode(status);
        result = 31 * result + Objects.hashCode(value);
        return result;
    }

    public static final class Builder {
        private GoproCommand cmdId;

        private GoproRequestStatus status;

        private byte[] value;

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

        /**
         * Value 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                arraySize = 4
        )
        public final Builder value(byte[] value) {
            this.value = value;
            return this;
        }

        public final GoproGetResponse build() {
            return new GoproGetResponse(cmdId, status, value);
        }
    }
}
