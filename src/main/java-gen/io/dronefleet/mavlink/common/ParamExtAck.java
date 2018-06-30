package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Response from a {@link io.dronefleet.mavlink.common.ParamExtSet PARAM_EXT_SET} message. 
 */
@MavlinkMessageInfo(
        id = 324,
        crc = 132
)
public final class ParamExtAck {
    private final String paramId;

    private final String paramValue;

    private final MavParamExtType paramType;

    private final ParamAck paramResult;

    private ParamExtAck(String paramId, String paramValue, MavParamExtType paramType,
            ParamAck paramResult) {
        this.paramId = paramId;
        this.paramValue = paramValue;
        this.paramType = paramType;
        this.paramResult = paramResult;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT 
     * null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 
     * 16+1 bytes storage if the ID is stored as string 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            arraySize = 16
    )
    public final String paramId() {
        return this.paramId;
    }

    /**
     * Parameter value (new value if PARAM_ACK_ACCEPTED, current value otherwise) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            arraySize = 128
    )
    public final String paramValue() {
        return this.paramValue;
    }

    /**
     * Parameter type: see the {@link io.dronefleet.mavlink.common.MavParamExtType MAV_PARAM_EXT_TYPE} enum for supported data types. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final MavParamExtType paramType() {
        return this.paramType;
    }

    /**
     * Result code: see the {@link io.dronefleet.mavlink.common.ParamAck PARAM_ACK} enum for possible codes. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final ParamAck paramResult() {
        return this.paramResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ParamExtAck other = (ParamExtAck)o;
        if (!Objects.deepEquals(paramId, other.paramId)) return false;
        if (!Objects.deepEquals(paramValue, other.paramValue)) return false;
        if (!Objects.deepEquals(paramType, other.paramType)) return false;
        if (!Objects.deepEquals(paramResult, other.paramResult)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(paramId);
        result = 31 * result + Objects.hashCode(paramValue);
        result = 31 * result + Objects.hashCode(paramType);
        result = 31 * result + Objects.hashCode(paramResult);
        return result;
    }

    public static final class Builder {
        private String paramId;

        private String paramValue;

        private MavParamExtType paramType;

        private ParamAck paramResult;

        /**
         * Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT 
         * null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 
         * 16+1 bytes storage if the ID is stored as string 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                arraySize = 16
        )
        public final Builder paramId(String paramId) {
            this.paramId = paramId;
            return this;
        }

        /**
         * Parameter value (new value if PARAM_ACK_ACCEPTED, current value otherwise) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                arraySize = 128
        )
        public final Builder paramValue(String paramValue) {
            this.paramValue = paramValue;
            return this;
        }

        /**
         * Parameter type: see the {@link io.dronefleet.mavlink.common.MavParamExtType MAV_PARAM_EXT_TYPE} enum for supported data types. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder paramType(MavParamExtType paramType) {
            this.paramType = paramType;
            return this;
        }

        /**
         * Result code: see the {@link io.dronefleet.mavlink.common.ParamAck PARAM_ACK} enum for possible codes. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1
        )
        public final Builder paramResult(ParamAck paramResult) {
            this.paramResult = paramResult;
            return this;
        }

        public final ParamExtAck build() {
            return new ParamExtAck(paramId, paramValue, paramType, paramResult);
        }
    }
}
