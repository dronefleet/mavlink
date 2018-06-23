package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Emit the value of a parameter. The inclusion of param_count and param_index in the message 
 * allows the recipient to keep track of received parameters and allows them to re-request 
 * missing parameters after a loss or timeout. 
 */
@MavlinkMessageInfo(
        id = 322,
        crc = 243
)
public final class ParamExtValue {
    /**
     * Total number of parameters 
     */
    private final int paramCount;

    /**
     * Index of this parameter 
     */
    private final int paramIndex;

    /**
     * Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT 
     * null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 
     * 16+1 bytes storage if the ID is stored as string 
     */
    private final String paramId;

    /**
     * Parameter value 
     */
    private final String paramValue;

    /**
     * Parameter type: see the {@link io.dronefleet.mavlink.common.MavParamExtType MavParamExtType} enum for supported data types. 
     */
    private final MavParamExtType paramType;

    private ParamExtValue(int paramCount, int paramIndex, String paramId, String paramValue,
            MavParamExtType paramType) {
        this.paramCount = paramCount;
        this.paramIndex = paramIndex;
        this.paramId = paramId;
        this.paramValue = paramValue;
        this.paramType = paramType;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "ParamExtValue{paramId=" + paramId
                 + ", paramValue=" + paramValue
                 + ", paramType=" + paramType
                 + ", paramCount=" + paramCount
                 + ", paramIndex=" + paramIndex + "}";
    }

    /**
     * Total number of parameters 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2
    )
    public final int paramCount() {
        return paramCount;
    }

    /**
     * Index of this parameter 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2
    )
    public final int paramIndex() {
        return paramIndex;
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
     * Parameter value 
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

    public static class Builder {
        private int paramCount;

        private int paramIndex;

        private String paramId;

        private String paramValue;

        private MavParamExtType paramType;

        private Builder() {
        }

        /**
         * Total number of parameters 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2
        )
        public final Builder paramCount(int paramCount) {
            this.paramCount = paramCount;
            return this;
        }

        /**
         * Index of this parameter 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2
        )
        public final Builder paramIndex(int paramIndex) {
            this.paramIndex = paramIndex;
            return this;
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
         * Parameter value 
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

        public final ParamExtValue build() {
            return new ParamExtValue(paramCount, paramIndex, paramId, paramValue, paramType);
        }
    }
}
