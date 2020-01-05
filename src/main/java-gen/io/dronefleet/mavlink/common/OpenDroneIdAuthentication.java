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
 * Data for filling the OpenDroneID Authentication message. The Authentication Message 
 * defines a field that can provide a means of authenticity for the identity of the UAS (Unmanned 
 * Aircraft System). The Authentication message can have two different formats. Five data pages 
 * are supported. For data page 0, the fields PageCount, Length and TimeStamp are present and 
 * AuthData is only 17 bytes. For data page 1 through 4, PageCount,Length and TimeStamp are not 
 * present and the size of AuthData is 23 bytes. 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 12902,
        crc = 181,
        description = "Data for filling the OpenDroneID Authentication message. The Authentication Message defines a field that can provide a means of authenticity for the identity of the UAS (Unmanned Aircraft System). The Authentication message can have two different formats. Five data pages are supported. For data page 0, the fields PageCount, Length and TimeStamp are present and AuthData is only 17 bytes. For data page 1 through 4, PageCount,Length and TimeStamp are not present and the size of AuthData is 23 bytes.",
        workInProgress = true
)
@Deprecated
public final class OpenDroneIdAuthentication {
    private final EnumValue<MavOdidAuthType> authenticationType;

    private final int dataPage;

    private final int pageCount;

    private final int length;

    private final long timestamp;

    private final byte[] authenticationData;

    private OpenDroneIdAuthentication(EnumValue<MavOdidAuthType> authenticationType, int dataPage,
            int pageCount, int length, long timestamp, byte[] authenticationData) {
        this.authenticationType = authenticationType;
        this.dataPage = dataPage;
        this.pageCount = pageCount;
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
     * Indicates the type of authentication. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = MavOdidAuthType.class,
            description = "Indicates the type of authentication."
    )
    public final EnumValue<MavOdidAuthType> authenticationType() {
        return this.authenticationType;
    }

    /**
     * Allowed range is 0 - 4. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "Allowed range is 0 - 4."
    )
    public final int dataPage() {
        return this.dataPage;
    }

    /**
     * This field is only present for page 0. Allowed range is 0 - 5. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "This field is only present for page 0. Allowed range is 0 - 5."
    )
    public final int pageCount() {
        return this.pageCount;
    }

    /**
     * This field is only present for page 0. Total bytes of authentication_data from all data pages. 
     * Allowed range is 0 - 109 (17 + 23*4). 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            description = "This field is only present for page 0. Total bytes of authentication_data from all data pages. Allowed range is 0 - 109 (17 + 23*4)."
    )
    public final int length() {
        return this.length;
    }

    /**
     * This field is only present for page 0. 32 bit Unix Timestamp in seconds since 00:00:00 
     * 01/01/2019. 
     */
    @MavlinkFieldInfo(
            position = 6,
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
            position = 7,
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
        if (!Objects.deepEquals(authenticationType, other.authenticationType)) return false;
        if (!Objects.deepEquals(dataPage, other.dataPage)) return false;
        if (!Objects.deepEquals(pageCount, other.pageCount)) return false;
        if (!Objects.deepEquals(length, other.length)) return false;
        if (!Objects.deepEquals(timestamp, other.timestamp)) return false;
        if (!Objects.deepEquals(authenticationData, other.authenticationData)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(authenticationType);
        result = 31 * result + Objects.hashCode(dataPage);
        result = 31 * result + Objects.hashCode(pageCount);
        result = 31 * result + Objects.hashCode(length);
        result = 31 * result + Objects.hashCode(timestamp);
        result = 31 * result + Objects.hashCode(authenticationData);
        return result;
    }

    @Override
    public String toString() {
        return "OpenDroneIdAuthentication{authenticationType=" + authenticationType
                 + ", dataPage=" + dataPage
                 + ", pageCount=" + pageCount
                 + ", length=" + length
                 + ", timestamp=" + timestamp
                 + ", authenticationData=" + authenticationData + "}";
    }

    public static final class Builder {
        private EnumValue<MavOdidAuthType> authenticationType;

        private int dataPage;

        private int pageCount;

        private int length;

        private long timestamp;

        private byte[] authenticationData;

        /**
         * Indicates the type of authentication. 
         */
        @MavlinkFieldInfo(
                position = 2,
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
         * Allowed range is 0 - 4. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "Allowed range is 0 - 4."
        )
        public final Builder dataPage(int dataPage) {
            this.dataPage = dataPage;
            return this;
        }

        /**
         * This field is only present for page 0. Allowed range is 0 - 5. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "This field is only present for page 0. Allowed range is 0 - 5."
        )
        public final Builder pageCount(int pageCount) {
            this.pageCount = pageCount;
            return this;
        }

        /**
         * This field is only present for page 0. Total bytes of authentication_data from all data pages. 
         * Allowed range is 0 - 109 (17 + 23*4). 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                description = "This field is only present for page 0. Total bytes of authentication_data from all data pages. Allowed range is 0 - 109 (17 + 23*4)."
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
                position = 6,
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
                position = 7,
                unitSize = 1,
                arraySize = 23,
                description = "Opaque authentication data. For page 0, the size is only 17 bytes. For other pages, the size is 23 bytes. Shall be filled with nulls in the unused portion of the field."
        )
        public final Builder authenticationData(byte[] authenticationData) {
            this.authenticationData = authenticationData;
            return this;
        }

        public final OpenDroneIdAuthentication build() {
            return new OpenDroneIdAuthentication(authenticationType, dataPage, pageCount, length, timestamp, authenticationData);
        }
    }
}
