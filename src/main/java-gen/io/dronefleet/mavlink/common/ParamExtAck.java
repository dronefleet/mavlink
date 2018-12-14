package io.dronefleet.mavlink.common;

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
 * Response from a {@link io.dronefleet.mavlink.common.ParamExtSet PARAM_EXT_SET} message. 
 */
@MavlinkMessageInfo(
        id = 324,
        crc = 132,
        description = "Response from a PARAM_EXT_SET message."
)
public final class ParamExtAck {
    private final String paramId;

    private final String paramValue;

    private final EnumValue<MavParamExtType> paramType;

    private final EnumValue<ParamAck> paramResult;

    private ParamExtAck(String paramId, String paramValue, EnumValue<MavParamExtType> paramType,
            EnumValue<ParamAck> paramResult) {
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
            arraySize = 16,
            description = "Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1 bytes storage if the ID is stored as string"
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
            arraySize = 128,
            description = "Parameter value (new value if PARAM_ACK_ACCEPTED, current value otherwise)"
    )
    public final String paramValue() {
        return this.paramValue;
    }

    /**
     * Parameter type. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            enumType = MavParamExtType.class,
            description = "Parameter type."
    )
    public final EnumValue<MavParamExtType> paramType() {
        return this.paramType;
    }

    /**
     * Result code. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            enumType = ParamAck.class,
            description = "Result code."
    )
    public final EnumValue<ParamAck> paramResult() {
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

    @Override
    public String toString() {
        return "ParamExtAck{paramId=" + paramId
                 + ", paramValue=" + paramValue
                 + ", paramType=" + paramType
                 + ", paramResult=" + paramResult + "}";
    }

    public static final class Builder {
        private String paramId;

        private String paramValue;

        private EnumValue<MavParamExtType> paramType;

        private EnumValue<ParamAck> paramResult;

        /**
         * Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT 
         * null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 
         * 16+1 bytes storage if the ID is stored as string 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                arraySize = 16,
                description = "Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1 bytes storage if the ID is stored as string"
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
                arraySize = 128,
                description = "Parameter value (new value if PARAM_ACK_ACCEPTED, current value otherwise)"
        )
        public final Builder paramValue(String paramValue) {
            this.paramValue = paramValue;
            return this;
        }

        /**
         * Parameter type. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                enumType = MavParamExtType.class,
                description = "Parameter type."
        )
        public final Builder paramType(EnumValue<MavParamExtType> paramType) {
            this.paramType = paramType;
            return this;
        }

        /**
         * Parameter type. 
         */
        public final Builder paramType(MavParamExtType entry) {
            return paramType(EnumValue.of(entry));
        }

        /**
         * Parameter type. 
         */
        public final Builder paramType(Enum... flags) {
            return paramType(EnumValue.create(flags));
        }

        /**
         * Parameter type. 
         */
        public final Builder paramType(Collection<Enum> flags) {
            return paramType(EnumValue.create(flags));
        }

        /**
         * Result code. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                enumType = ParamAck.class,
                description = "Result code."
        )
        public final Builder paramResult(EnumValue<ParamAck> paramResult) {
            this.paramResult = paramResult;
            return this;
        }

        /**
         * Result code. 
         */
        public final Builder paramResult(ParamAck entry) {
            return paramResult(EnumValue.of(entry));
        }

        /**
         * Result code. 
         */
        public final Builder paramResult(Enum... flags) {
            return paramResult(EnumValue.create(flags));
        }

        /**
         * Result code. 
         */
        public final Builder paramResult(Collection<Enum> flags) {
            return paramResult(EnumValue.create(flags));
        }

        public final ParamExtAck build() {
            return new ParamExtAck(paramId, paramValue, paramType, paramResult);
        }
    }
}
