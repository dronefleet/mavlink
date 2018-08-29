package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * Response from a {@link io.dronefleet.mavlink.ardupilotmega.GoproCommand GOPRO_COMMAND} get request 
 */
@MavlinkMessageInfo(
        id = 217,
        crc = 202
)
public final class GoproGetResponse {
    private final EnumValue<GoproCommand> cmdId;

    private final EnumValue<GoproRequestStatus> status;

    private final byte[] value;

    private GoproGetResponse(EnumValue<GoproCommand> cmdId, EnumValue<GoproRequestStatus> status,
            byte[] value) {
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
            unitSize = 1,
            enumType = GoproCommand.class
    )
    public final EnumValue<GoproCommand> cmdId() {
        return this.cmdId;
    }

    /**
     * Status 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = GoproRequestStatus.class
    )
    public final EnumValue<GoproRequestStatus> status() {
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

    @Override
    public String toString() {
        return "GoproGetResponse{cmdId=" + cmdId
                 + ", status=" + status
                 + ", value=" + value + "}";
    }

    public static final class Builder {
        private EnumValue<GoproCommand> cmdId;

        private EnumValue<GoproRequestStatus> status;

        private byte[] value;

        /**
         * Command ID 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                enumType = GoproCommand.class
        )
        public final Builder cmdId(EnumValue<GoproCommand> cmdId) {
            this.cmdId = cmdId;
            return this;
        }

        /**
         * Command ID 
         */
        public final Builder cmdId(GoproCommand entry) {
            return cmdId(EnumValue.of(entry));
        }

        /**
         * Command ID 
         */
        public final Builder cmdId(Enum... flags) {
            return cmdId(EnumValue.create(flags));
        }

        /**
         * Command ID 
         */
        public final Builder cmdId(Collection<Enum> flags) {
            return cmdId(EnumValue.create(flags));
        }

        /**
         * Status 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                enumType = GoproRequestStatus.class
        )
        public final Builder status(EnumValue<GoproRequestStatus> status) {
            this.status = status;
            return this;
        }

        /**
         * Status 
         */
        public final Builder status(GoproRequestStatus entry) {
            return status(EnumValue.of(entry));
        }

        /**
         * Status 
         */
        public final Builder status(Enum... flags) {
            return status(EnumValue.create(flags));
        }

        /**
         * Status 
         */
        public final Builder status(Collection<Enum> flags) {
            return status(EnumValue.create(flags));
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
