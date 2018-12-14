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
 * Set a parameter value. In order to deal with message loss (and retransmission of 
 * {@link io.dronefleet.mavlink.common.ParamExtSet PARAM_EXT_SET}), when setting a parameter value and the new value is the same as the current 
 * value, you will immediately get a PARAM_ACK_ACCEPTED response. If the current state is 
 * PARAM_ACK_IN_PROGRESS, you will accordingly receive a PARAM_ACK_IN_PROGRESS in response. 
 */
@MavlinkMessageInfo(
        id = 323,
        crc = 78,
        description = "Set a parameter value. In order to deal with message loss (and retransmission of PARAM_EXT_SET), when setting a parameter value and the new value is the same as the current value, you will immediately get a PARAM_ACK_ACCEPTED response. If the current state is PARAM_ACK_IN_PROGRESS, you will accordingly receive a PARAM_ACK_IN_PROGRESS in response."
)
public final class ParamExtSet {
    private final int targetSystem;

    private final int targetComponent;

    private final String paramId;

    private final String paramValue;

    private final EnumValue<MavParamExtType> paramType;

    private ParamExtSet(int targetSystem, int targetComponent, String paramId, String paramValue,
            EnumValue<MavParamExtType> paramType) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.paramId = paramId;
        this.paramValue = paramValue;
        this.paramType = paramType;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * System ID 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "System ID"
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Component ID"
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT 
     * null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 
     * 16+1 bytes storage if the ID is stored as string 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            arraySize = 16,
            description = "Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1 bytes storage if the ID is stored as string"
    )
    public final String paramId() {
        return this.paramId;
    }

    /**
     * Parameter value 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            arraySize = 128,
            description = "Parameter value"
    )
    public final String paramValue() {
        return this.paramValue;
    }

    /**
     * Parameter type. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            enumType = MavParamExtType.class,
            description = "Parameter type."
    )
    public final EnumValue<MavParamExtType> paramType() {
        return this.paramType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ParamExtSet other = (ParamExtSet)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(paramId, other.paramId)) return false;
        if (!Objects.deepEquals(paramValue, other.paramValue)) return false;
        if (!Objects.deepEquals(paramType, other.paramType)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(paramId);
        result = 31 * result + Objects.hashCode(paramValue);
        result = 31 * result + Objects.hashCode(paramType);
        return result;
    }

    @Override
    public String toString() {
        return "ParamExtSet{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", paramId=" + paramId
                 + ", paramValue=" + paramValue
                 + ", paramType=" + paramType + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private String paramId;

        private String paramValue;

        private EnumValue<MavParamExtType> paramType;

        /**
         * System ID 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "System ID"
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component ID 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Component ID"
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT 
         * null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 
         * 16+1 bytes storage if the ID is stored as string 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                arraySize = 16,
                description = "Parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1 bytes storage if the ID is stored as string"
        )
        public final Builder paramId(String paramId) {
            this.paramId = paramId;
            return this;
        }

        /**
         * Parameter value 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                arraySize = 128,
                description = "Parameter value"
        )
        public final Builder paramValue(String paramValue) {
            this.paramValue = paramValue;
            return this;
        }

        /**
         * Parameter type. 
         */
        @MavlinkFieldInfo(
                position = 5,
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

        public final ParamExtSet build() {
            return new ParamExtSet(targetSystem, targetComponent, paramId, paramValue, paramType);
        }
    }
}
