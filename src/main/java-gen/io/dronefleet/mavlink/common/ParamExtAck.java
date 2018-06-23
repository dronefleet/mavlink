package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Response from a {@link io.dronefleet.mavlink.common.ParamExtSet ParamExtSet} message. 
 */
@MavlinkMessageInfo(
        id = 324,
        crc = 132
)
public final class ParamExtAck {
    /**
     * Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT 
     * null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 
     * 16+1 bytes storage if the ID is stored as string 
     */
    private final String paramId;

    /**
     * Parameter value (new value if PARAM_ACK_ACCEPTED, current value otherwise) 
     */
    private final String paramValue;

    /**
     * Parameter type: see the {@link io.dronefleet.mavlink.common.MavParamExtType MavParamExtType} enum for supported data types. 
     */
    private final MavParamExtType paramType;

    /**
     * Result code: see the {@link io.dronefleet.mavlink.common.ParamAck ParamAck} enum for possible codes. 
     */
    private final ParamAck paramResult;

    private ParamExtAck(String paramId, String paramValue, MavParamExtType paramType,
            ParamAck paramResult) {
        this.paramId = paramId;
        this.paramValue = paramValue;
        this.paramType = paramType;
        this.paramResult = paramResult;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "ParamExtAck{paramId=" + paramId
                 + ", paramValue=" + paramValue
                 + ", paramType=" + paramType
                 + ", paramResult=" + paramResult + "}";
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
        return paramId;
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
        return paramValue;
    }

    /**
     * Parameter type: see the {@link io.dronefleet.mavlink.common.MavParamExtType MavParamExtType} enum for supported data types. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final MavParamExtType paramType() {
        return paramType;
    }

    /**
     * Result code: see the {@link io.dronefleet.mavlink.common.ParamAck ParamAck} enum for possible codes. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final ParamAck paramResult() {
        return paramResult;
    }

    public static class Builder {
        private String paramId;

        private String paramValue;

        private MavParamExtType paramType;

        private ParamAck paramResult;

        private Builder() {
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
         * Parameter type: see the {@link io.dronefleet.mavlink.common.MavParamExtType MavParamExtType} enum for supported data types. 
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
         * Result code: see the {@link io.dronefleet.mavlink.common.ParamAck ParamAck} enum for possible codes. 
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
