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
 * Component metadata message, which may be requested using MAV_CMD_REQUEST_MESSAGE. This 
 * contains the MAVLink FTP URI and CRC for the component's general metadata file. The file must be 
 * hosted on the component, and may be xz compressed. The file CRC can be used for file caching. The 
 * general metadata file can be read to get the locations of other metadata files 
 * ({@link io.dronefleet.mavlink.common.CompMetadataType COMP_METADATA_TYPE}) and translations, which may be hosted either on the vehicle or the 
 * internet. For more information see: 
 * https://mavlink.io/en/services/component_information.html. Note: Camera components 
 * should use {@link io.dronefleet.mavlink.common.CameraInformation CAMERA_INFORMATION} instead, and autopilots may use both this message and 
 * {@link io.dronefleet.mavlink.common.AutopilotVersion AUTOPILOT_VERSION}. 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 397,
        crc = 182,
        description = "Component metadata message, which may be requested using MAV_CMD_REQUEST_MESSAGE.\n"
                        + "\n"
                        + "        This contains the MAVLink FTP URI and CRC for the component's general metadata file.\n"
                        + "        The file must be hosted on the component, and may be xz compressed.\n"
                        + "        The file CRC can be used for file caching.\n"
                        + "\n"
                        + "        The general metadata file can be read to get the locations of other metadata files (COMP_METADATA_TYPE) and translations, which may be hosted either on the vehicle or the internet.\n"
                        + "        For more information see: https://mavlink.io/en/services/component_information.html.\n"
                        + "\n"
                        + "        Note: Camera components should use CAMERA_INFORMATION instead, and autopilots may use both this message and AUTOPILOT_VERSION.",
        workInProgress = true
)
@Deprecated
public final class ComponentMetadata {
    private final long timeBootMs;

    private final long fileCrc;

    private final String uri;

    private ComponentMetadata(long timeBootMs, long fileCrc, String uri) {
        this.timeBootMs = timeBootMs;
        this.fileCrc = fileCrc;
        this.uri = uri;
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
     * CRC32 of the general metadata file. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "CRC32 of the general metadata file."
    )
    public final long fileCrc() {
        return this.fileCrc;
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
    public final String uri() {
        return this.uri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ComponentMetadata other = (ComponentMetadata)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(fileCrc, other.fileCrc)) return false;
        if (!Objects.deepEquals(uri, other.uri)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(fileCrc);
        result = 31 * result + Objects.hashCode(uri);
        return result;
    }

    @Override
    public String toString() {
        return "ComponentMetadata{timeBootMs=" + timeBootMs
                 + ", fileCrc=" + fileCrc
                 + ", uri=" + uri + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private long fileCrc;

        private String uri;

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
         * CRC32 of the general metadata file. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "CRC32 of the general metadata file."
        )
        public final Builder fileCrc(long fileCrc) {
            this.fileCrc = fileCrc;
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
        public final Builder uri(String uri) {
            this.uri = uri;
            return this;
        }

        public final ComponentMetadata build() {
            return new ComponentMetadata(timeBootMs, fileCrc, uri);
        }
    }
}
