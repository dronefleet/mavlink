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
 * Data for filling the OpenDroneID Self ID message. The Self ID Message is an opportunity for the 
 * operator to (optionally) declare their identity and purpose of the flight. This message can 
 * provide additional information that could reduce the threat profile of a UA (Unmanned 
 * Aircraft) flying in a particular area or manner. This message can also be used to provide 
 * optional additional clarification in an emergency/remote ID system failure situation. 
 */
@MavlinkMessageInfo(
        id = 12903,
        crc = 249,
        description = "Data for filling the OpenDroneID Self ID message. The Self ID Message is an opportunity for the operator to (optionally) declare their identity and purpose of the flight. This message can provide additional information that could reduce the threat profile of a UA (Unmanned Aircraft) flying in a particular area or manner. This message can also be used to provide optional additional clarification in an emergency/remote ID system failure situation."
)
public final class OpenDroneIdSelfId {
    private final int targetSystem;

    private final int targetComponent;

    private final byte[] idOrMac;

    private final EnumValue<MavOdidDescType> descriptionType;

    private final String description;

    private OpenDroneIdSelfId(int targetSystem, int targetComponent, byte[] idOrMac,
            EnumValue<MavOdidDescType> descriptionType, String description) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.idOrMac = idOrMac;
        this.descriptionType = descriptionType;
        this.description = description;
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
     * Indicates the type of the description field. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            enumType = MavOdidDescType.class,
            description = "Indicates the type of the description field."
    )
    public final EnumValue<MavOdidDescType> descriptionType() {
        return this.descriptionType;
    }

    /**
     * Text description or numeric value expressed as ASCII characters. Shall be filled with nulls in 
     * the unused portion of the field. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            arraySize = 23,
            description = "Text description or numeric value expressed as ASCII characters. Shall be filled with nulls in the unused portion of the field."
    )
    public final String description() {
        return this.description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        OpenDroneIdSelfId other = (OpenDroneIdSelfId)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(idOrMac, other.idOrMac)) return false;
        if (!Objects.deepEquals(descriptionType, other.descriptionType)) return false;
        if (!Objects.deepEquals(description, other.description)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(idOrMac);
        result = 31 * result + Objects.hashCode(descriptionType);
        result = 31 * result + Objects.hashCode(description);
        return result;
    }

    @Override
    public String toString() {
        return "OpenDroneIdSelfId{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", idOrMac=" + idOrMac
                 + ", descriptionType=" + descriptionType
                 + ", description=" + description + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private byte[] idOrMac;

        private EnumValue<MavOdidDescType> descriptionType;

        private String description;

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
         * Indicates the type of the description field. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                enumType = MavOdidDescType.class,
                description = "Indicates the type of the description field."
        )
        public final Builder descriptionType(EnumValue<MavOdidDescType> descriptionType) {
            this.descriptionType = descriptionType;
            return this;
        }

        /**
         * Indicates the type of the description field. 
         */
        public final Builder descriptionType(MavOdidDescType entry) {
            return descriptionType(EnumValue.of(entry));
        }

        /**
         * Indicates the type of the description field. 
         */
        public final Builder descriptionType(Enum... flags) {
            return descriptionType(EnumValue.create(flags));
        }

        /**
         * Indicates the type of the description field. 
         */
        public final Builder descriptionType(Collection<Enum> flags) {
            return descriptionType(EnumValue.create(flags));
        }

        /**
         * Text description or numeric value expressed as ASCII characters. Shall be filled with nulls in 
         * the unused portion of the field. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                arraySize = 23,
                description = "Text description or numeric value expressed as ASCII characters. Shall be filled with nulls in the unused portion of the field."
        )
        public final Builder description(String description) {
            this.description = description;
            return this;
        }

        public final OpenDroneIdSelfId build() {
            return new OpenDroneIdSelfId(targetSystem, targetComponent, idOrMac, descriptionType, description);
        }
    }
}
