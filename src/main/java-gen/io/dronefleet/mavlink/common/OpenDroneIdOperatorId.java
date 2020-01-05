package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Deprecated;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * Data for filling the OpenDroneID Operator ID message, which contains the CAA (Civil Aviation 
 * Authority) issued operator ID. 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 12905,
        crc = 56,
        description = "Data for filling the OpenDroneID Operator ID message, which contains the CAA (Civil Aviation Authority) issued operator ID.",
        workInProgress = true
)
@Deprecated
public final class OpenDroneIdOperatorId {
    private final EnumValue<MavOdidOperatorIdType> operatorIdType;

    private final String operatorId;

    private OpenDroneIdOperatorId(EnumValue<MavOdidOperatorIdType> operatorIdType,
            String operatorId) {
        this.operatorIdType = operatorIdType;
        this.operatorId = operatorId;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Indicates the type of the operator_id field. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = MavOdidOperatorIdType.class,
            description = "Indicates the type of the operator_id field."
    )
    public final EnumValue<MavOdidOperatorIdType> operatorIdType() {
        return this.operatorIdType;
    }

    /**
     * Text description or numeric value expressed as ASCII characters. Shall be filled with nulls in 
     * the unused portion of the field. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            arraySize = 20,
            description = "Text description or numeric value expressed as ASCII characters. Shall be filled with nulls in the unused portion of the field."
    )
    public final String operatorId() {
        return this.operatorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        OpenDroneIdOperatorId other = (OpenDroneIdOperatorId)o;
        if (!Objects.deepEquals(operatorIdType, other.operatorIdType)) return false;
        if (!Objects.deepEquals(operatorId, other.operatorId)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(operatorIdType);
        result = 31 * result + Objects.hashCode(operatorId);
        return result;
    }

    @Override
    public String toString() {
        return "OpenDroneIdOperatorId{operatorIdType=" + operatorIdType
                 + ", operatorId=" + operatorId + "}";
    }

    public static final class Builder {
        private EnumValue<MavOdidOperatorIdType> operatorIdType;

        private String operatorId;

        /**
         * Indicates the type of the operator_id field. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                enumType = MavOdidOperatorIdType.class,
                description = "Indicates the type of the operator_id field."
        )
        public final Builder operatorIdType(EnumValue<MavOdidOperatorIdType> operatorIdType) {
            this.operatorIdType = operatorIdType;
            return this;
        }

        /**
         * Indicates the type of the operator_id field. 
         */
        public final Builder operatorIdType(MavOdidOperatorIdType entry) {
            return operatorIdType(EnumValue.of(entry));
        }

        /**
         * Indicates the type of the operator_id field. 
         */
        public final Builder operatorIdType(Enum... flags) {
            return operatorIdType(EnumValue.create(flags));
        }

        /**
         * Indicates the type of the operator_id field. 
         */
        public final Builder operatorIdType(Collection<Enum> flags) {
            return operatorIdType(EnumValue.create(flags));
        }

        /**
         * Text description or numeric value expressed as ASCII characters. Shall be filled with nulls in 
         * the unused portion of the field. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                arraySize = 20,
                description = "Text description or numeric value expressed as ASCII characters. Shall be filled with nulls in the unused portion of the field."
        )
        public final Builder operatorId(String operatorId) {
            this.operatorId = operatorId;
            return this;
        }

        public final OpenDroneIdOperatorId build() {
            return new OpenDroneIdOperatorId(operatorIdType, operatorId);
        }
    }
}
