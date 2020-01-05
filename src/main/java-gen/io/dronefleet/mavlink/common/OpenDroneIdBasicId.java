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
 * Data for filling the OpenDroneID Basic ID message. This and the below messages are primarily 
 * meant for feeding data to/from an OpenDroneID implementation. E.g. 
 * https://github.com/opendroneid/opendroneid-core-c 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 12900,
        crc = 197,
        description = "Data for filling the OpenDroneID Basic ID message. This and the below messages are primarily meant for feeding data to/from an OpenDroneID implementation. E.g. https://github.com/opendroneid/opendroneid-core-c",
        workInProgress = true
)
@Deprecated
public final class OpenDroneIdBasicId {
    private final EnumValue<MavOdidIdType> idType;

    private final EnumValue<MavOdidUaType> uaType;

    private final byte[] uasId;

    private OpenDroneIdBasicId(EnumValue<MavOdidIdType> idType, EnumValue<MavOdidUaType> uaType,
            byte[] uasId) {
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
     * Indicates the format for the uas_id field of this message. 
     */
    @MavlinkFieldInfo(
            position = 2,
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
            position = 3,
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
            position = 4,
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
        if (!Objects.deepEquals(idType, other.idType)) return false;
        if (!Objects.deepEquals(uaType, other.uaType)) return false;
        if (!Objects.deepEquals(uasId, other.uasId)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(idType);
        result = 31 * result + Objects.hashCode(uaType);
        result = 31 * result + Objects.hashCode(uasId);
        return result;
    }

    @Override
    public String toString() {
        return "OpenDroneIdBasicId{idType=" + idType
                 + ", uaType=" + uaType
                 + ", uasId=" + uasId + "}";
    }

    public static final class Builder {
        private EnumValue<MavOdidIdType> idType;

        private EnumValue<MavOdidUaType> uaType;

        private byte[] uasId;

        /**
         * Indicates the format for the uas_id field of this message. 
         */
        @MavlinkFieldInfo(
                position = 2,
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
                position = 3,
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
                position = 4,
                unitSize = 1,
                arraySize = 20,
                description = "UAS (Unmanned Aircraft System) ID following the format specified by id_type. Shall be filled with nulls in the unused portion of the field."
        )
        public final Builder uasId(byte[] uasId) {
            this.uasId = uasId;
            return this;
        }

        public final OpenDroneIdBasicId build() {
            return new OpenDroneIdBasicId(idType, uaType, uasId);
        }
    }
}
