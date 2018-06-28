package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
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
    private final String paramId;

    private final String paramValue;

    private final MavParamExtType paramType;

    private final int paramCount;

    private final int paramIndex;

    private ParamExtValue(String paramId, String paramValue, MavParamExtType paramType,
            int paramCount, int paramIndex) {
        this.paramId = paramId;
        this.paramValue = paramValue;
        this.paramType = paramType;
        this.paramCount = paramCount;
        this.paramIndex = paramIndex;
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
     * Parameter value 
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
     * Total number of parameters 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2
    )
    public final int paramCount() {
        return this.paramCount;
    }

    /**
     * Index of this parameter 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2
    )
    public final int paramIndex() {
        return this.paramIndex;
    }

    public static final class Builder {
        private String paramId;

        private String paramValue;

        private MavParamExtType paramType;

        private int paramCount;

        private int paramIndex;

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

        public final ParamExtValue build() {
            return new ParamExtValue(paramId, paramValue, paramType, paramCount, paramIndex);
        }
    }
}
