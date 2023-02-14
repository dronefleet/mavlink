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
 * Set a parameter value (write new value to permanent storage). The receiving component should 
 * acknowledge the new parameter value by broadcasting a {@link io.dronefleet.mavlink.common.ParamValue PARAM_VALUE} message (broadcasting 
 * ensures that multiple GCS all have an up-to-date list of all parameters). If the sending GCS did 
 * not receive a {@link io.dronefleet.mavlink.common.ParamValue PARAM_VALUE} within its timeout time, it should re-send the {@link io.dronefleet.mavlink.common.ParamSet PARAM_SET} message. 
 * The parameter microservice is documented at 
 * https://mavlink.io/en/services/parameter.html. {@link io.dronefleet.mavlink.common.ParamSet PARAM_SET} may also be called within the 
 * context of a transaction (started with MAV_CMD_PARAM_TRANSACTION). Within a transaction 
 * the receiving component should respond with PARAM_ACK_TRANSACTION to the setter component 
 * (instead of broadcasting {@link io.dronefleet.mavlink.common.ParamValue PARAM_VALUE}), and {@link io.dronefleet.mavlink.common.ParamSet PARAM_SET} should be re-sent if this is ACK not 
 * received. 
 */
@MavlinkMessageInfo(
        id = 23,
        crc = 168,
        description = "Set a parameter value (write new value to permanent storage).\n"
                        + "        The receiving component should acknowledge the new parameter value by broadcasting a PARAM_VALUE message (broadcasting ensures that multiple GCS all have an up-to-date list of all parameters). If the sending GCS did not receive a PARAM_VALUE within its timeout time, it should re-send the PARAM_SET message. The parameter microservice is documented at https://mavlink.io/en/services/parameter.html.\n"
                        + "        PARAM_SET may also be called within the context of a transaction (started with MAV_CMD_PARAM_TRANSACTION). Within a transaction the receiving component should respond with PARAM_ACK_TRANSACTION to the setter component (instead of broadcasting PARAM_VALUE), and PARAM_SET should be re-sent if this is ACK not received."
)
public final class ParamSet {
    private final int targetSystem;

    private final int targetComponent;

    private final String paramId;

    private final float paramValue;

    private final EnumValue<MavParamType> paramType;

    private ParamSet(int targetSystem, int targetComponent, String paramId, float paramValue,
            EnumValue<MavParamType> paramType) {
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
     * Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and 
     * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to 
     * provide 16+1 bytes storage if the ID is stored as string 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            arraySize = 16,
            description = "Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1 bytes storage if the ID is stored as string"
    )
    public final String paramId() {
        return this.paramId;
    }

    /**
     * Onboard parameter value 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Onboard parameter value"
    )
    public final float paramValue() {
        return this.paramValue;
    }

    /**
     * Onboard parameter type. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            enumType = MavParamType.class,
            description = "Onboard parameter type."
    )
    public final EnumValue<MavParamType> paramType() {
        return this.paramType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ParamSet other = (ParamSet)o;
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
        return "ParamSet{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", paramId=" + paramId
                 + ", paramValue=" + paramValue
                 + ", paramType=" + paramType + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private String paramId;

        private float paramValue;

        private EnumValue<MavParamType> paramType;

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
         * Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and 
         * WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to 
         * provide 16+1 bytes storage if the ID is stored as string 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                arraySize = 16,
                description = "Onboard parameter id, terminated by NULL if the length is less than 16 human-readable chars and WITHOUT null termination (NULL) byte if the length is exactly 16 chars - applications have to provide 16+1 bytes storage if the ID is stored as string"
        )
        public final Builder paramId(String paramId) {
            this.paramId = paramId;
            return this;
        }

        /**
         * Onboard parameter value 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Onboard parameter value"
        )
        public final Builder paramValue(float paramValue) {
            this.paramValue = paramValue;
            return this;
        }

        /**
         * Onboard parameter type. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                enumType = MavParamType.class,
                description = "Onboard parameter type."
        )
        public final Builder paramType(EnumValue<MavParamType> paramType) {
            this.paramType = paramType;
            return this;
        }

        /**
         * Onboard parameter type. 
         */
        public final Builder paramType(MavParamType entry) {
            return paramType(EnumValue.of(entry));
        }

        /**
         * Onboard parameter type. 
         */
        public final Builder paramType(Enum... flags) {
            return paramType(EnumValue.create(flags));
        }

        /**
         * Onboard parameter type. 
         */
        public final Builder paramType(Collection<Enum> flags) {
            return paramType(EnumValue.create(flags));
        }

        public final ParamSet build() {
            return new ParamSet(targetSystem, targetComponent, paramId, paramValue, paramType);
        }
    }
}
