package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Emit the value of a onboard parameter. The inclusion of param_count and param_index in the 
 * message allows the recipient to keep track of received parameters and allows him to re-request 
 * missing parameters after a loss or timeout. 
 */
@MavlinkMessageInfo(
        id = 22,
        crc = 220
)
public final class ParamValue {
    private final String paramId;

    private final float paramValue;

    private final EnumValue<MavParamType> paramType;

    private final int paramCount;

    private final int paramIndex;

    private ParamValue(String paramId, float paramValue, EnumValue<MavParamType> paramType,
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
     * Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and 
     * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to 
     * provide 16+1 bytes storage if the ID is stored as string 
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
     * Onboard parameter value 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float paramValue() {
        return this.paramValue;
    }

    /**
     * Onboard parameter type: see the {@link io.dronefleet.mavlink.common.MavParamType MAV_PARAM_TYPE} enum for supported data types. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            enumType = MavParamType.class
    )
    public final EnumValue<MavParamType> paramType() {
        return this.paramType;
    }

    /**
     * Total number of onboard parameters 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2
    )
    public final int paramCount() {
        return this.paramCount;
    }

    /**
     * Index of this onboard parameter 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2
    )
    public final int paramIndex() {
        return this.paramIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ParamValue other = (ParamValue)o;
        if (!Objects.deepEquals(paramId, other.paramId)) return false;
        if (!Objects.deepEquals(paramValue, other.paramValue)) return false;
        if (!Objects.deepEquals(paramType, other.paramType)) return false;
        if (!Objects.deepEquals(paramCount, other.paramCount)) return false;
        if (!Objects.deepEquals(paramIndex, other.paramIndex)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(paramId);
        result = 31 * result + Objects.hashCode(paramValue);
        result = 31 * result + Objects.hashCode(paramType);
        result = 31 * result + Objects.hashCode(paramCount);
        result = 31 * result + Objects.hashCode(paramIndex);
        return result;
    }

    @Override
    public String toString() {
        return "ParamValue{paramId=" + paramId
                 + ", paramValue=" + paramValue
                 + ", paramType=" + paramType
                 + ", paramCount=" + paramCount
                 + ", paramIndex=" + paramIndex + "}";
    }

    public static final class Builder {
        private String paramId;

        private float paramValue;

        private EnumValue<MavParamType> paramType;

        private int paramCount;

        private int paramIndex;

        /**
         * Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and 
         * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to 
         * provide 16+1 bytes storage if the ID is stored as string 
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
         * Onboard parameter value 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder paramValue(float paramValue) {
            this.paramValue = paramValue;
            return this;
        }

        /**
         * Onboard parameter type: see the {@link io.dronefleet.mavlink.common.MavParamType MAV_PARAM_TYPE} enum for supported data types. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                enumType = MavParamType.class
        )
        public final Builder paramType(EnumValue<MavParamType> paramType) {
            this.paramType = paramType;
            return this;
        }

        /**
         * Onboard parameter type: see the {@link io.dronefleet.mavlink.common.MavParamType MAV_PARAM_TYPE} enum for supported data types. 
         */
        public final Builder paramType(MavParamType entry) {
            this.paramType = EnumValue.of(entry);
            return this;
        }

        /**
         * Onboard parameter type: see the {@link io.dronefleet.mavlink.common.MavParamType MAV_PARAM_TYPE} enum for supported data types. 
         */
        public final Builder paramType(Enum... flags) {
            this.paramType = EnumValue.create(flags);
            return this;
        }

        /**
         * Total number of onboard parameters 
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
         * Index of this onboard parameter 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2
        )
        public final Builder paramIndex(int paramIndex) {
            this.paramIndex = paramIndex;
            return this;
        }

        public final ParamValue build() {
            return new ParamValue(paramId, paramValue, paramType, paramCount, paramIndex);
        }
    }
}
