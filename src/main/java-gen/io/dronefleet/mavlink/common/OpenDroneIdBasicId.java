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
 * Data for filling the OpenDroneID Basic ID message. This and the below messages are primarily 
 * meant for feeding data to/from an OpenDroneID implementation. E.g. 
 * https://github.com/opendroneid/opendroneid-core-c. These messages are compatible with 
 * the ASTM F3411 Remote ID standard and the ASD-STAN prEN 4709-002 Direct Remote ID standard. 
 * Additional information and usage of these messages is documented at 
 * https://mavlink.io/en/services/opendroneid.html. 
 */
@MavlinkMessageInfo(
        id = 12900,
        crc = 114,
        description = "Data for filling the OpenDroneID Basic ID message. This and the below messages are primarily meant for feeding data to/from an OpenDroneID implementation. E.g. https://github.com/opendroneid/opendroneid-core-c. These messages are compatible with the ASTM F3411 Remote ID standard and the ASD-STAN prEN 4709-002 Direct Remote ID standard. Additional information and usage of these messages is documented at https://mavlink.io/en/services/opendroneid.html."
)
public final class OpenDroneIdBasicId {
    private final int targetSystem;

    private final int targetComponent;

    private final byte[] idOrMac;

    private final EnumValue<MavOdidIdType> idType;

    private final EnumValue<MavOdidUaType> uaType;

    private final byte[] uasId;

    private OpenDroneIdBasicId(int targetSystem, int targetComponent, byte[] idOrMac,
            EnumValue<MavOdidIdType> idType, EnumValue<MavOdidUaType> uaType, byte[] uasId) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.idOrMac = idOrMac;
        this.idType = idType;
        this.uaType = uaType;
        this.uasId = uasId;
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
     * Indicates the format for the uas_id field of this message. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            enumType = MavOdidIdType.class,
            description = "Indicates the format for the uas_id field of this message."
    )
    public final EnumValue<MavOdidIdType> idType() {
        return this.idType;
    }

    /**
     * Indicates the type of UA (Unmanned Aircraft). 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            enumType = MavOdidUaType.class,
            description = "Indicates the type of UA (Unmanned Aircraft)."
    )
    public final EnumValue<MavOdidUaType> uaType() {
        return this.uaType;
    }

    /**
     * UAS (Unmanned Aircraft System) ID following the format specified by id_type. Shall be filled 
     * with nulls in the unused portion of the field. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            arraySize = 20,
            description = "UAS (Unmanned Aircraft System) ID following the format specified by id_type. Shall be filled with nulls in the unused portion of the field."
    )
    public final byte[] uasId() {
        return this.uasId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        OpenDroneIdBasicId other = (OpenDroneIdBasicId)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(idOrMac, other.idOrMac)) return false;
        if (!Objects.deepEquals(idType, other.idType)) return false;
        if (!Objects.deepEquals(uaType, other.uaType)) return false;
        if (!Objects.deepEquals(uasId, other.uasId)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(idOrMac);
        result = 31 * result + Objects.hashCode(idType);
        result = 31 * result + Objects.hashCode(uaType);
        result = 31 * result + Objects.hashCode(uasId);
        return result;
    }

    @Override
    public String toString() {
        return "OpenDroneIdBasicId{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", idOrMac=" + idOrMac
                 + ", idType=" + idType
                 + ", uaType=" + uaType
                 + ", uasId=" + uasId + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private byte[] idOrMac;

        private EnumValue<MavOdidIdType> idType;

        private EnumValue<MavOdidUaType> uaType;

        private byte[] uasId;

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
         * Indicates the format for the uas_id field of this message. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                enumType = MavOdidIdType.class,
                description = "Indicates the format for the uas_id field of this message."
        )
        public final Builder idType(EnumValue<MavOdidIdType> idType) {
            this.idType = idType;
            return this;
        }

        /**
         * Indicates the format for the uas_id field of this message. 
         */
        public final Builder idType(MavOdidIdType entry) {
            return idType(EnumValue.of(entry));
        }

        /**
         * Indicates the format for the uas_id field of this message. 
         */
        public final Builder idType(Enum... flags) {
            return idType(EnumValue.create(flags));
        }

        /**
         * Indicates the format for the uas_id field of this message. 
         */
        public final Builder idType(Collection<Enum> flags) {
            return idType(EnumValue.create(flags));
        }

        /**
         * Indicates the type of UA (Unmanned Aircraft). 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                enumType = MavOdidUaType.class,
                description = "Indicates the type of UA (Unmanned Aircraft)."
        )
        public final Builder uaType(EnumValue<MavOdidUaType> uaType) {
            this.uaType = uaType;
            return this;
        }

        /**
         * Indicates the type of UA (Unmanned Aircraft). 
         */
        public final Builder uaType(MavOdidUaType entry) {
            return uaType(EnumValue.of(entry));
        }

        /**
         * Indicates the type of UA (Unmanned Aircraft). 
         */
        public final Builder uaType(Enum... flags) {
            return uaType(EnumValue.create(flags));
        }

        /**
         * Indicates the type of UA (Unmanned Aircraft). 
         */
        public final Builder uaType(Collection<Enum> flags) {
            return uaType(EnumValue.create(flags));
        }

        /**
         * UAS (Unmanned Aircraft System) ID following the format specified by id_type. Shall be filled 
         * with nulls in the unused portion of the field. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                arraySize = 20,
                description = "UAS (Unmanned Aircraft System) ID following the format specified by id_type. Shall be filled with nulls in the unused portion of the field."
        )
        public final Builder uasId(byte[] uasId) {
            this.uasId = uasId;
            return this;
        }

        public final OpenDroneIdBasicId build() {
            return new OpenDroneIdBasicId(targetSystem, targetComponent, idOrMac, idType, uaType, uasId);
        }
    }
}
