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
 * Data for filling the OpenDroneID Operator ID message, which contains the CAA (Civil Aviation 
 * Authority) issued operator ID. 
 */
@MavlinkMessageInfo(
        id = 12905,
        crc = 49,
        description = "Data for filling the OpenDroneID Operator ID message, which contains the CAA (Civil Aviation Authority) issued operator ID."
)
public final class OpenDroneIdOperatorId {
    private final int targetSystem;

    private final int targetComponent;

    private final byte[] idOrMac;

    private final EnumValue<MavOdidOperatorIdType> operatorIdType;

    private final String operatorId;

    private OpenDroneIdOperatorId(int targetSystem, int targetComponent, byte[] idOrMac,
            EnumValue<MavOdidOperatorIdType> operatorIdType, String operatorId) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.idOrMac = idOrMac;
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
     * System ID (0 for broadcast). 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "System ID (0 for broadcast)."
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID (0 for broadcast). 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Component ID (0 for broadcast)."
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Only used for drone ID data received from other UAs. See detailed description at 
     * https://mavlink.io/en/services/opendroneid.html. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            arraySize = 20,
            description = "Only used for drone ID data received from other UAs. See detailed description at https://mavlink.io/en/services/opendroneid.html."
    )
    public final byte[] idOrMac() {
        return this.idOrMac;
    }

    /**
     * Indicates the type of the operator_id field. 
     */
    @MavlinkFieldInfo(
            position = 4,
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
            position = 5,
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
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(idOrMac, other.idOrMac)) return false;
        if (!Objects.deepEquals(operatorIdType, other.operatorIdType)) return false;
        if (!Objects.deepEquals(operatorId, other.operatorId)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(idOrMac);
        result = 31 * result + Objects.hashCode(operatorIdType);
        result = 31 * result + Objects.hashCode(operatorId);
        return result;
    }

    @Override
    public String toString() {
        return "OpenDroneIdOperatorId{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", idOrMac=" + idOrMac
                 + ", operatorIdType=" + operatorIdType
                 + ", operatorId=" + operatorId + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private byte[] idOrMac;

        private EnumValue<MavOdidOperatorIdType> operatorIdType;

        private String operatorId;

        /**
         * System ID (0 for broadcast). 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "System ID (0 for broadcast)."
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component ID (0 for broadcast). 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Component ID (0 for broadcast)."
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Only used for drone ID data received from other UAs. See detailed description at 
         * https://mavlink.io/en/services/opendroneid.html. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                arraySize = 20,
                description = "Only used for drone ID data received from other UAs. See detailed description at https://mavlink.io/en/services/opendroneid.html."
        )
        public final Builder idOrMac(byte[] idOrMac) {
            this.idOrMac = idOrMac;
            return this;
        }

        /**
         * Indicates the type of the operator_id field. 
         */
        @MavlinkFieldInfo(
                position = 4,
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
                position = 5,
                unitSize = 1,
                arraySize = 20,
                description = "Text description or numeric value expressed as ASCII characters. Shall be filled with nulls in the unused portion of the field."
        )
        public final Builder operatorId(String operatorId) {
            this.operatorId = operatorId;
            return this;
        }

        public final OpenDroneIdOperatorId build() {
            return new OpenDroneIdOperatorId(targetSystem, targetComponent, idOrMac, operatorIdType, operatorId);
        }
    }
}
