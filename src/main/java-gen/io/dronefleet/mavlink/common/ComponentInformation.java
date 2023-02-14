package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Deprecated;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Component information message, which may be requested using MAV_CMD_REQUEST_MESSAGE. 
 * @deprecated Since 2022-04, replaced by {@link io.dronefleet.mavlink.common.ComponentMetadata COMPONENT_METADATA}. 
 */
@MavlinkMessageInfo(
        id = 395,
        crc = 0,
        description = "Component information message, which may be requested using MAV_CMD_REQUEST_MESSAGE."
)
@Deprecated
public final class ComponentInformation {
    private final long timeBootMs;

    private final long generalMetadataFileCrc;

    private final String generalMetadataUri;

    private final long peripheralsMetadataFileCrc;

    private final String peripheralsMetadataUri;

    private ComponentInformation(long timeBootMs, long generalMetadataFileCrc,
            String generalMetadataUri, long peripheralsMetadataFileCrc,
            String peripheralsMetadataUri) {
        this.timeBootMs = timeBootMs;
        this.generalMetadataFileCrc = generalMetadataFileCrc;
        this.generalMetadataUri = generalMetadataUri;
        this.peripheralsMetadataFileCrc = peripheralsMetadataFileCrc;
        this.peripheralsMetadataUri = peripheralsMetadataUri;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (time since system boot). 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Timestamp (time since system boot)."
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * CRC32 of the general metadata file (general_metadata_uri). 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "CRC32 of the general metadata file (general_metadata_uri)."
    )
    public final long generalMetadataFileCrc() {
        return this.generalMetadataFileCrc;
    }

    /**
     * MAVLink FTP URI for the general metadata file (COMP_METADATA_TYPE_GENERAL), which may be 
     * compressed with xz. The file contains general component metadata, and may contain URI links 
     * for additional metadata (see {@link io.dronefleet.mavlink.common.CompMetadataType COMP_METADATA_TYPE}). The information is static from boot, and 
     * may be generated at compile time. The string needs to be zero terminated. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            arraySize = 100,
            description = "MAVLink FTP URI for the general metadata file (COMP_METADATA_TYPE_GENERAL), which may be compressed with xz. The file contains general component metadata, and may contain URI links for additional metadata (see COMP_METADATA_TYPE). The information is static from boot, and may be generated at compile time. The string needs to be zero terminated."
    )
    public final String generalMetadataUri() {
        return this.generalMetadataUri;
    }

    /**
     * CRC32 of peripherals metadata file (peripherals_metadata_uri). 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "CRC32 of peripherals metadata file (peripherals_metadata_uri)."
    )
    public final long peripheralsMetadataFileCrc() {
        return this.peripheralsMetadataFileCrc;
    }

    /**
     * (Optional) MAVLink FTP URI for the peripherals metadata file 
     * (COMP_METADATA_TYPE_PERIPHERALS), which may be compressed with xz. This contains data 
     * about "attached components" such as UAVCAN nodes. The peripherals are in a separate file 
     * because the information must be generated dynamically at runtime. The string needs to be zero 
     * terminated. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            arraySize = 100,
            description = "(Optional) MAVLink FTP URI for the peripherals metadata file (COMP_METADATA_TYPE_PERIPHERALS), which may be compressed with xz. This contains data about \"attached components\" such as UAVCAN nodes. The peripherals are in a separate file because the information must be generated dynamically at runtime. The string needs to be zero terminated."
    )
    public final String peripheralsMetadataUri() {
        return this.peripheralsMetadataUri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ComponentInformation other = (ComponentInformation)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(generalMetadataFileCrc, other.generalMetadataFileCrc)) return false;
        if (!Objects.deepEquals(generalMetadataUri, other.generalMetadataUri)) return false;
        if (!Objects.deepEquals(peripheralsMetadataFileCrc, other.peripheralsMetadataFileCrc)) return false;
        if (!Objects.deepEquals(peripheralsMetadataUri, other.peripheralsMetadataUri)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(generalMetadataFileCrc);
        result = 31 * result + Objects.hashCode(generalMetadataUri);
        result = 31 * result + Objects.hashCode(peripheralsMetadataFileCrc);
        result = 31 * result + Objects.hashCode(peripheralsMetadataUri);
        return result;
    }

    @Override
    public String toString() {
        return "ComponentInformation{timeBootMs=" + timeBootMs
                 + ", generalMetadataFileCrc=" + generalMetadataFileCrc
                 + ", generalMetadataUri=" + generalMetadataUri
                 + ", peripheralsMetadataFileCrc=" + peripheralsMetadataFileCrc
                 + ", peripheralsMetadataUri=" + peripheralsMetadataUri + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private long generalMetadataFileCrc;

        private String generalMetadataUri;

        private long peripheralsMetadataFileCrc;

        private String peripheralsMetadataUri;

        /**
         * Timestamp (time since system boot). 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Timestamp (time since system boot)."
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * CRC32 of the general metadata file (general_metadata_uri). 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "CRC32 of the general metadata file (general_metadata_uri)."
        )
        public final Builder generalMetadataFileCrc(long generalMetadataFileCrc) {
            this.generalMetadataFileCrc = generalMetadataFileCrc;
            return this;
        }

        /**
         * MAVLink FTP URI for the general metadata file (COMP_METADATA_TYPE_GENERAL), which may be 
         * compressed with xz. The file contains general component metadata, and may contain URI links 
         * for additional metadata (see {@link io.dronefleet.mavlink.common.CompMetadataType COMP_METADATA_TYPE}). The information is static from boot, and 
         * may be generated at compile time. The string needs to be zero terminated. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                arraySize = 100,
                description = "MAVLink FTP URI for the general metadata file (COMP_METADATA_TYPE_GENERAL), which may be compressed with xz. The file contains general component metadata, and may contain URI links for additional metadata (see COMP_METADATA_TYPE). The information is static from boot, and may be generated at compile time. The string needs to be zero terminated."
        )
        public final Builder generalMetadataUri(String generalMetadataUri) {
            this.generalMetadataUri = generalMetadataUri;
            return this;
        }

        /**
         * CRC32 of peripherals metadata file (peripherals_metadata_uri). 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "CRC32 of peripherals metadata file (peripherals_metadata_uri)."
        )
        public final Builder peripheralsMetadataFileCrc(long peripheralsMetadataFileCrc) {
            this.peripheralsMetadataFileCrc = peripheralsMetadataFileCrc;
            return this;
        }

        /**
         * (Optional) MAVLink FTP URI for the peripherals metadata file 
         * (COMP_METADATA_TYPE_PERIPHERALS), which may be compressed with xz. This contains data 
         * about "attached components" such as UAVCAN nodes. The peripherals are in a separate file 
         * because the information must be generated dynamically at runtime. The string needs to be zero 
         * terminated. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                arraySize = 100,
                description = "(Optional) MAVLink FTP URI for the peripherals metadata file (COMP_METADATA_TYPE_PERIPHERALS), which may be compressed with xz. This contains data about \"attached components\" such as UAVCAN nodes. The peripherals are in a separate file because the information must be generated dynamically at runtime. The string needs to be zero terminated."
        )
        public final Builder peripheralsMetadataUri(String peripheralsMetadataUri) {
            this.peripheralsMetadataUri = peripheralsMetadataUri;
            return this;
        }

        public final ComponentInformation build() {
            return new ComponentInformation(timeBootMs, generalMetadataFileCrc, generalMetadataUri, peripheralsMetadataFileCrc, peripheralsMetadataUri);
        }
    }
}
