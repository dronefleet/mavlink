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
 * Data for filling the OpenDroneID Authentication message. The Authentication Message 
 * defines a field that can provide a means of authenticity for the identity of the UAS (Unmanned 
 * Aircraft System). The Authentication message can have two different formats. For data page 0, 
 * the fields PageCount, Length and TimeStamp are present and AuthData is only 17 bytes. For data 
 * page 1 through 15, PageCount, Length and TimeStamp are not present and the size of AuthData is 23 
 * bytes. 
 */
@MavlinkMessageInfo(
        id = 12902,
        crc = 140,
        description = "Data for filling the OpenDroneID Authentication message. The Authentication Message defines a field that can provide a means of authenticity for the identity of the UAS (Unmanned Aircraft System). The Authentication message can have two different formats. For data page 0, the fields PageCount, Length and TimeStamp are present and AuthData is only 17 bytes. For data page 1 through 15, PageCount, Length and TimeStamp are not present and the size of AuthData is 23 bytes."
)
public final class OpenDroneIdAuthentication {
    private final int targetSystem;

    private final int targetComponent;

    private final byte[] idOrMac;

    private final EnumValue<MavOdidAuthType> authenticationType;

    private final int dataPage;

    private final int lastPageIndex;

    private final int length;

    private final long timestamp;

    private final byte[] authenticationData;

    private OpenDroneIdAuthentication(int targetSystem, int targetComponent, byte[] idOrMac,
            EnumValue<MavOdidAuthType> authenticationType, int dataPage, int lastPageIndex,
            int length, long timestamp, byte[] authenticationData) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.idOrMac = idOrMac;
        this.authenticationType = authenticationType;
        this.dataPage = dataPage;
        this.lastPageIndex = lastPageIndex;
        this.length = length;
        this.timestamp = timestamp;
        this.authenticationData = authenticationData;
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
     * Indicates the type of authentication. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            enumType = MavOdidAuthType.class,
            description = "Indicates the type of authentication."
    )
    public final EnumValue<MavOdidAuthType> authenticationType() {
        return this.authenticationType;
    }

    /**
     * Allowed range is 0 - 15. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            description = "Allowed range is 0 - 15."
    )
    public final int dataPage() {
        return this.dataPage;
    }

    /**
     * This field is only present for page 0. Allowed range is 0 - 15. See the description of struct 
     * ODID_Auth_data at 
     * https://github.com/opendroneid/opendroneid-core-c/blob/master/libopendroneid/opendroneid.h. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            description = "This field is only present for page 0. Allowed range is 0 - 15. See the description of struct ODID_Auth_data at https://github.com/opendroneid/opendroneid-core-c/blob/master/libopendroneid/opendroneid.h."
    )
    public final int lastPageIndex() {
        return this.lastPageIndex;
    }

    /**
     * This field is only present for page 0. Total bytes of authentication_data from all data pages. 
     * See the description of struct ODID_Auth_data at 
     * https://github.com/opendroneid/opendroneid-core-c/blob/master/libopendroneid/opendroneid.h. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1,
            description = "This field is only present for page 0. Total bytes of authentication_data from all data pages. See the description of struct ODID_Auth_data at https://github.com/opendroneid/opendroneid-core-c/blob/master/libopendroneid/opendroneid.h."
    )
    public final int length() {
        return this.length;
    }

    /**
     * This field is only present for page 0. 32 bit Unix Timestamp in seconds since 00:00:00 
     * 01/01/2019. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "This field is only present for page 0. 32 bit Unix Timestamp in seconds since 00:00:00 01/01/2019."
    )
    public final long timestamp() {
        return this.timestamp;
    }

    /**
     * Opaque authentication data. For page 0, the size is only 17 bytes. For other pages, the size is 23 
     * bytes. Shall be filled with nulls in the unused portion of the field. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 1,
            arraySize = 23,
            description = "Opaque authentication data. For page 0, the size is only 17 bytes. For other pages, the size is 23 bytes. Shall be filled with nulls in the unused portion of the field."
    )
    public final byte[] authenticationData() {
        return this.authenticationData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        OpenDroneIdAuthentication other = (OpenDroneIdAuthentication)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(idOrMac, other.idOrMac)) return false;
        if (!Objects.deepEquals(authenticationType, other.authenticationType)) return false;
        if (!Objects.deepEquals(dataPage, other.dataPage)) return false;
        if (!Objects.deepEquals(lastPageIndex, other.lastPageIndex)) return false;
        if (!Objects.deepEquals(length, other.length)) return false;
        if (!Objects.deepEquals(timestamp, other.timestamp)) return false;
        if (!Objects.deepEquals(authenticationData, other.authenticationData)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(idOrMac);
        result = 31 * result + Objects.hashCode(authenticationType);
        result = 31 * result + Objects.hashCode(dataPage);
        result = 31 * result + Objects.hashCode(lastPageIndex);
        result = 31 * result + Objects.hashCode(length);
        result = 31 * result + Objects.hashCode(timestamp);
        result = 31 * result + Objects.hashCode(authenticationData);
        return result;
    }

    @Override
    public String toString() {
        return "OpenDroneIdAuthentication{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", idOrMac=" + idOrMac
                 + ", authenticationType=" + authenticationType
                 + ", dataPage=" + dataPage
                 + ", lastPageIndex=" + lastPageIndex
                 + ", length=" + length
                 + ", timestamp=" + timestamp
                 + ", authenticationData=" + authenticationData + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private byte[] idOrMac;

        private EnumValue<MavOdidAuthType> authenticationType;

        private int dataPage;

        private int lastPageIndex;

        private int length;

        private long timestamp;

        private byte[] authenticationData;

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
         * Indicates the type of authentication. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                enumType = MavOdidAuthType.class,
                description = "Indicates the type of authentication."
        )
        public final Builder authenticationType(EnumValue<MavOdidAuthType> authenticationType) {
            this.authenticationType = authenticationType;
            return this;
        }

        /**
         * Indicates the type of authentication. 
         */
        public final Builder authenticationType(MavOdidAuthType entry) {
            return authenticationType(EnumValue.of(entry));
        }

        /**
         * Indicates the type of authentication. 
         */
        public final Builder authenticationType(Enum... flags) {
            return authenticationType(EnumValue.create(flags));
        }

        /**
         * Indicates the type of authentication. 
         */
        public final Builder authenticationType(Collection<Enum> flags) {
            return authenticationType(EnumValue.create(flags));
        }

        /**
         * Allowed range is 0 - 15. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                description = "Allowed range is 0 - 15."
        )
        public final Builder dataPage(int dataPage) {
            this.dataPage = dataPage;
            return this;
        }

        /**
         * This field is only present for page 0. Allowed range is 0 - 15. See the description of struct 
         * ODID_Auth_data at 
         * https://github.com/opendroneid/opendroneid-core-c/blob/master/libopendroneid/opendroneid.h. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                description = "This field is only present for page 0. Allowed range is 0 - 15. See the description of struct ODID_Auth_data at https://github.com/opendroneid/opendroneid-core-c/blob/master/libopendroneid/opendroneid.h."
        )
        public final Builder lastPageIndex(int lastPageIndex) {
            this.lastPageIndex = lastPageIndex;
            return this;
        }

        /**
         * This field is only present for page 0. Total bytes of authentication_data from all data pages. 
         * See the description of struct ODID_Auth_data at 
         * https://github.com/opendroneid/opendroneid-core-c/blob/master/libopendroneid/opendroneid.h. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1,
                description = "This field is only present for page 0. Total bytes of authentication_data from all data pages. See the description of struct ODID_Auth_data at https://github.com/opendroneid/opendroneid-core-c/blob/master/libopendroneid/opendroneid.h."
        )
        public final Builder length(int length) {
            this.length = length;
            return this;
        }

        /**
         * This field is only present for page 0. 32 bit Unix Timestamp in seconds since 00:00:00 
         * 01/01/2019. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "This field is only present for page 0. 32 bit Unix Timestamp in seconds since 00:00:00 01/01/2019."
        )
        public final Builder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        /**
         * Opaque authentication data. For page 0, the size is only 17 bytes. For other pages, the size is 23 
         * bytes. Shall be filled with nulls in the unused portion of the field. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 1,
                arraySize = 23,
                description = "Opaque authentication data. For page 0, the size is only 17 bytes. For other pages, the size is 23 bytes. Shall be filled with nulls in the unused portion of the field."
        )
        public final Builder authenticationData(byte[] authenticationData) {
            this.authenticationData = authenticationData;
            return this;
        }

        public final OpenDroneIdAuthentication build() {
            return new OpenDroneIdAuthentication(targetSystem, targetComponent, idOrMac, authenticationType, dataPage, lastPageIndex, length, timestamp, authenticationData);
        }
    }
}
