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
 * Data for filling the OpenDroneID Self ID message. The Self ID Message is an opportunity for the 
 * operator to (optionally) declare their identity and purpose of the flight. This message can 
 * provide additional information that could reduce the threat profile of a UA (Unmanned 
 * Aircraft) flying in a particular area or manner. 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 12903,
        crc = 149,
        description = "Data for filling the OpenDroneID Self ID message. The Self ID Message is an opportunity for the operator to (optionally) declare their identity and purpose of the flight. This message can provide additional information that could reduce the threat profile of a UA (Unmanned Aircraft) flying in a particular area or manner.",
        workInProgress = true
)
@Deprecated
public final class OpenDroneIdSelfId {
    private final EnumValue<MavOdidDescType> descriptionType;

    private final String description;

    private OpenDroneIdSelfId(EnumValue<MavOdidDescType> descriptionType, String description) {
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
     * Indicates the type of the description field. 
     */
    @MavlinkFieldInfo(
            position = 2,
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
            position = 3,
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
        if (!Objects.deepEquals(descriptionType, other.descriptionType)) return false;
        if (!Objects.deepEquals(description, other.description)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(descriptionType);
        result = 31 * result + Objects.hashCode(description);
        return result;
    }

    @Override
    public String toString() {
        return "OpenDroneIdSelfId{descriptionType=" + descriptionType
                 + ", description=" + description + "}";
    }

    public static final class Builder {
        private EnumValue<MavOdidDescType> descriptionType;

        private String description;

        /**
         * Indicates the type of the description field. 
         */
        @MavlinkFieldInfo(
                position = 2,
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
                position = 3,
                unitSize = 1,
                arraySize = 23,
                description = "Text description or numeric value expressed as ASCII characters. Shall be filled with nulls in the unused portion of the field."
        )
        public final Builder description(String description) {
            this.description = description;
            return this;
        }

        public final OpenDroneIdSelfId build() {
            return new OpenDroneIdSelfId(descriptionType, description);
        }
    }
}
