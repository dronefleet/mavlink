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
 * Configure OSD parameter reply. 
 */
@MavlinkMessageInfo(
        id = 11034,
        crc = 79,
        description = "Configure OSD parameter reply."
)
public final class OsdParamConfigReply {
    private final long requestId;

    private final EnumValue<OsdParamConfigError> result;

    private OsdParamConfigReply(long requestId, EnumValue<OsdParamConfigError> result) {
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
     * Config error type. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = OsdParamConfigError.class,
            description = "Config error type."
    )
    public final EnumValue<OsdParamConfigError> result() {
        return this.result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        OsdParamConfigReply other = (OsdParamConfigReply)o;
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
        return "OsdParamConfigReply{requestId=" + requestId
                 + ", result=" + result + "}";
    }

    public static final class Builder {
        private long requestId;

        private EnumValue<OsdParamConfigError> result;

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
         * Config error type. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                enumType = OsdParamConfigError.class,
                description = "Config error type."
        )
        public final Builder result(EnumValue<OsdParamConfigError> result) {
            this.result = result;
            return this;
        }

        /**
         * Config error type. 
         */
        public final Builder result(OsdParamConfigError entry) {
            return result(EnumValue.of(entry));
        }

        /**
         * Config error type. 
         */
        public final Builder result(Enum... flags) {
            return result(EnumValue.create(flags));
        }

        /**
         * Config error type. 
         */
        public final Builder result(Collection<Enum> flags) {
            return result(EnumValue.create(flags));
        }

        public final OsdParamConfigReply build() {
            return new OsdParamConfigReply(requestId, result);
        }
    }
}
