package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;

/**
 * Second GPS data. 
 */
@MavlinkMessageInfo(
        id = 124,
        crc = 87,
        description = "Second GPS data."
)
public final class Gps2Raw {
    private final BigInteger timeUsec;

    private final EnumValue<GpsFixType> fixType;

    private final int lat;

    private final int lon;

    private final int alt;

    private final int eph;

    private final int epv;

    private final int vel;

    private final int cog;

    private final int satellitesVisible;

    private final int dgpsNumch;

    private final long dgpsAge;

    private final int yaw;

    private final int altEllipsoid;

    private final long hAcc;

    private final long vAcc;

    private final long velAcc;

    private final long hdgAcc;

    private Gps2Raw(BigInteger timeUsec, EnumValue<GpsFixType> fixType, int lat, int lon, int alt,
            int eph, int epv, int vel, int cog, int satellitesVisible, int dgpsNumch, long dgpsAge,
            int yaw, int altEllipsoid, long hAcc, long vAcc, long velAcc, long hdgAcc) {
        this.timeUsec = timeUsec;
        this.fixType = fixType;
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
        this.eph = eph;
        this.epv = epv;
        this.vel = vel;
        this.cog = cog;
        this.satellitesVisible = satellitesVisible;
        this.dgpsNumch = dgpsNumch;
        this.dgpsAge = dgpsAge;
        this.yaw = yaw;
        this.altEllipsoid = altEllipsoid;
        this.hAcc = hAcc;
        this.vAcc = vAcc;
        this.velAcc = velAcc;
        this.hdgAcc = hdgAcc;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
     * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * GPS fix type. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = GpsFixType.class,
            description = "GPS fix type."
    )
    public final EnumValue<GpsFixType> fixType() {
        return this.fixType;
    }

    /**
     * Latitude (WGS84) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            signed = true,
            description = "Latitude (WGS84)"
    )
    public final int lat() {
        return this.lat;
    }

    /**
     * Longitude (WGS84) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            signed = true,
            description = "Longitude (WGS84)"
    )
    public final int lon() {
        return this.lon;
    }

    /**
     * Altitude (MSL). Positive for up. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true,
            description = "Altitude (MSL). Positive for up."
    )
    public final int alt() {
        return this.alt;
    }

    /**
     * GPS HDOP horizontal dilution of position (unitless * 100). If unknown, set to: UINT16_MAX 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            description = "GPS HDOP horizontal dilution of position (unitless * 100). If unknown, set to: UINT16_MAX"
    )
    public final int eph() {
        return this.eph;
    }

    /**
     * GPS VDOP vertical dilution of position (unitless * 100). If unknown, set to: UINT16_MAX 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            description = "GPS VDOP vertical dilution of position (unitless * 100). If unknown, set to: UINT16_MAX"
    )
    public final int epv() {
        return this.epv;
    }

    /**
     * GPS ground speed. If unknown, set to: UINT16_MAX 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2,
            description = "GPS ground speed. If unknown, set to: UINT16_MAX"
    )
    public final int vel() {
        return this.vel;
    }

    /**
     * Course over ground (NOT heading, but direction of movement): 0.0..359.99 degrees. If 
     * unknown, set to: UINT16_MAX 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2,
            description = "Course over ground (NOT heading, but direction of movement): 0.0..359.99 degrees. If unknown, set to: UINT16_MAX"
    )
    public final int cog() {
        return this.cog;
    }

    /**
     * Number of satellites visible. If unknown, set to UINT8_MAX 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1,
            description = "Number of satellites visible. If unknown, set to UINT8_MAX"
    )
    public final int satellitesVisible() {
        return this.satellitesVisible;
    }

    /**
     * Number of DGPS satellites 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 1,
            description = "Number of DGPS satellites"
    )
    public final int dgpsNumch() {
        return this.dgpsNumch;
    }

    /**
     * Age of DGPS info 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4,
            description = "Age of DGPS info"
    )
    public final long dgpsAge() {
        return this.dgpsAge;
    }

    /**
     * Yaw in earth frame from north. Use 0 if this GPS does not provide yaw. Use UINT16_MAX if this GPS is 
     * configured to provide yaw and is currently unable to provide it. Use 36000 for north. 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 2,
            extension = true,
            description = "Yaw in earth frame from north. Use 0 if this GPS does not provide yaw. Use UINT16_MAX if this GPS is configured to provide yaw and is currently unable to provide it. Use 36000 for north."
    )
    public final int yaw() {
        return this.yaw;
    }

    /**
     * Altitude (above WGS84, EGM96 ellipsoid). Positive for up. 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 4,
            signed = true,
            extension = true,
            description = "Altitude (above WGS84, EGM96 ellipsoid). Positive for up."
    )
    public final int altEllipsoid() {
        return this.altEllipsoid;
    }

    /**
     * Position uncertainty. 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 4,
            extension = true,
            description = "Position uncertainty."
    )
    public final long hAcc() {
        return this.hAcc;
    }

    /**
     * Altitude uncertainty. 
     */
    @MavlinkFieldInfo(
            position = 17,
            unitSize = 4,
            extension = true,
            description = "Altitude uncertainty."
    )
    public final long vAcc() {
        return this.vAcc;
    }

    /**
     * Speed uncertainty. 
     */
    @MavlinkFieldInfo(
            position = 18,
            unitSize = 4,
            extension = true,
            description = "Speed uncertainty."
    )
    public final long velAcc() {
        return this.velAcc;
    }

    /**
     * Heading / track uncertainty 
     */
    @MavlinkFieldInfo(
            position = 19,
            unitSize = 4,
            extension = true,
            description = "Heading / track uncertainty"
    )
    public final long hdgAcc() {
        return this.hdgAcc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Gps2Raw other = (Gps2Raw)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(fixType, other.fixType)) return false;
        if (!Objects.deepEquals(lat, other.lat)) return false;
        if (!Objects.deepEquals(lon, other.lon)) return false;
        if (!Objects.deepEquals(alt, other.alt)) return false;
        if (!Objects.deepEquals(eph, other.eph)) return false;
        if (!Objects.deepEquals(epv, other.epv)) return false;
        if (!Objects.deepEquals(vel, other.vel)) return false;
        if (!Objects.deepEquals(cog, other.cog)) return false;
        if (!Objects.deepEquals(satellitesVisible, other.satellitesVisible)) return false;
        if (!Objects.deepEquals(dgpsNumch, other.dgpsNumch)) return false;
        if (!Objects.deepEquals(dgpsAge, other.dgpsAge)) return false;
        if (!Objects.deepEquals(yaw, other.yaw)) return false;
        if (!Objects.deepEquals(altEllipsoid, other.altEllipsoid)) return false;
        if (!Objects.deepEquals(hAcc, other.hAcc)) return false;
        if (!Objects.deepEquals(vAcc, other.vAcc)) return false;
        if (!Objects.deepEquals(velAcc, other.velAcc)) return false;
        if (!Objects.deepEquals(hdgAcc, other.hdgAcc)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(fixType);
        result = 31 * result + Objects.hashCode(lat);
        result = 31 * result + Objects.hashCode(lon);
        result = 31 * result + Objects.hashCode(alt);
        result = 31 * result + Objects.hashCode(eph);
        result = 31 * result + Objects.hashCode(epv);
        result = 31 * result + Objects.hashCode(vel);
        result = 31 * result + Objects.hashCode(cog);
        result = 31 * result + Objects.hashCode(satellitesVisible);
        result = 31 * result + Objects.hashCode(dgpsNumch);
        result = 31 * result + Objects.hashCode(dgpsAge);
        result = 31 * result + Objects.hashCode(yaw);
        result = 31 * result + Objects.hashCode(altEllipsoid);
        result = 31 * result + Objects.hashCode(hAcc);
        result = 31 * result + Objects.hashCode(vAcc);
        result = 31 * result + Objects.hashCode(velAcc);
        result = 31 * result + Objects.hashCode(hdgAcc);
        return result;
    }

    @Override
    public String toString() {
        return "Gps2Raw{timeUsec=" + timeUsec
                 + ", fixType=" + fixType
                 + ", lat=" + lat
                 + ", lon=" + lon
                 + ", alt=" + alt
                 + ", eph=" + eph
                 + ", epv=" + epv
                 + ", vel=" + vel
                 + ", cog=" + cog
                 + ", satellitesVisible=" + satellitesVisible
                 + ", dgpsNumch=" + dgpsNumch
                 + ", dgpsAge=" + dgpsAge
                 + ", yaw=" + yaw
                 + ", altEllipsoid=" + altEllipsoid
                 + ", hAcc=" + hAcc
                 + ", vAcc=" + vAcc
                 + ", velAcc=" + velAcc
                 + ", hdgAcc=" + hdgAcc + "}";
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private EnumValue<GpsFixType> fixType;

        private int lat;

        private int lon;

        private int alt;

        private int eph;

        private int epv;

        private int vel;

        private int cog;

        private int satellitesVisible;

        private int dgpsNumch;

        private long dgpsAge;

        private int yaw;

        private int altEllipsoid;

        private long hAcc;

        private long vAcc;

        private long velAcc;

        private long hdgAcc;

        /**
         * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
         * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * GPS fix type. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                enumType = GpsFixType.class,
                description = "GPS fix type."
        )
        public final Builder fixType(EnumValue<GpsFixType> fixType) {
            this.fixType = fixType;
            return this;
        }

        /**
         * GPS fix type. 
         */
        public final Builder fixType(GpsFixType entry) {
            return fixType(EnumValue.of(entry));
        }

        /**
         * GPS fix type. 
         */
        public final Builder fixType(Enum... flags) {
            return fixType(EnumValue.create(flags));
        }

        /**
         * GPS fix type. 
         */
        public final Builder fixType(Collection<Enum> flags) {
            return fixType(EnumValue.create(flags));
        }

        /**
         * Latitude (WGS84) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                signed = true,
                description = "Latitude (WGS84)"
        )
        public final Builder lat(int lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Longitude (WGS84) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                signed = true,
                description = "Longitude (WGS84)"
        )
        public final Builder lon(int lon) {
            this.lon = lon;
            return this;
        }

        /**
         * Altitude (MSL). Positive for up. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true,
                description = "Altitude (MSL). Positive for up."
        )
        public final Builder alt(int alt) {
            this.alt = alt;
            return this;
        }

        /**
         * GPS HDOP horizontal dilution of position (unitless * 100). If unknown, set to: UINT16_MAX 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                description = "GPS HDOP horizontal dilution of position (unitless * 100). If unknown, set to: UINT16_MAX"
        )
        public final Builder eph(int eph) {
            this.eph = eph;
            return this;
        }

        /**
         * GPS VDOP vertical dilution of position (unitless * 100). If unknown, set to: UINT16_MAX 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                description = "GPS VDOP vertical dilution of position (unitless * 100). If unknown, set to: UINT16_MAX"
        )
        public final Builder epv(int epv) {
            this.epv = epv;
            return this;
        }

        /**
         * GPS ground speed. If unknown, set to: UINT16_MAX 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2,
                description = "GPS ground speed. If unknown, set to: UINT16_MAX"
        )
        public final Builder vel(int vel) {
            this.vel = vel;
            return this;
        }

        /**
         * Course over ground (NOT heading, but direction of movement): 0.0..359.99 degrees. If 
         * unknown, set to: UINT16_MAX 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2,
                description = "Course over ground (NOT heading, but direction of movement): 0.0..359.99 degrees. If unknown, set to: UINT16_MAX"
        )
        public final Builder cog(int cog) {
            this.cog = cog;
            return this;
        }

        /**
         * Number of satellites visible. If unknown, set to UINT8_MAX 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 1,
                description = "Number of satellites visible. If unknown, set to UINT8_MAX"
        )
        public final Builder satellitesVisible(int satellitesVisible) {
            this.satellitesVisible = satellitesVisible;
            return this;
        }

        /**
         * Number of DGPS satellites 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 1,
                description = "Number of DGPS satellites"
        )
        public final Builder dgpsNumch(int dgpsNumch) {
            this.dgpsNumch = dgpsNumch;
            return this;
        }

        /**
         * Age of DGPS info 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4,
                description = "Age of DGPS info"
        )
        public final Builder dgpsAge(long dgpsAge) {
            this.dgpsAge = dgpsAge;
            return this;
        }

        /**
         * Yaw in earth frame from north. Use 0 if this GPS does not provide yaw. Use UINT16_MAX if this GPS is 
         * configured to provide yaw and is currently unable to provide it. Use 36000 for north. 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 2,
                extension = true,
                description = "Yaw in earth frame from north. Use 0 if this GPS does not provide yaw. Use UINT16_MAX if this GPS is configured to provide yaw and is currently unable to provide it. Use 36000 for north."
        )
        public final Builder yaw(int yaw) {
            this.yaw = yaw;
            return this;
        }

        /**
         * Altitude (above WGS84, EGM96 ellipsoid). Positive for up. 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 4,
                signed = true,
                extension = true,
                description = "Altitude (above WGS84, EGM96 ellipsoid). Positive for up."
        )
        public final Builder altEllipsoid(int altEllipsoid) {
            this.altEllipsoid = altEllipsoid;
            return this;
        }

        /**
         * Position uncertainty. 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 4,
                extension = true,
                description = "Position uncertainty."
        )
        public final Builder hAcc(long hAcc) {
            this.hAcc = hAcc;
            return this;
        }

        /**
         * Altitude uncertainty. 
         */
        @MavlinkFieldInfo(
                position = 17,
                unitSize = 4,
                extension = true,
                description = "Altitude uncertainty."
        )
        public final Builder vAcc(long vAcc) {
            this.vAcc = vAcc;
            return this;
        }

        /**
         * Speed uncertainty. 
         */
        @MavlinkFieldInfo(
                position = 18,
                unitSize = 4,
                extension = true,
                description = "Speed uncertainty."
        )
        public final Builder velAcc(long velAcc) {
            this.velAcc = velAcc;
            return this;
        }

        /**
         * Heading / track uncertainty 
         */
        @MavlinkFieldInfo(
                position = 19,
                unitSize = 4,
                extension = true,
                description = "Heading / track uncertainty"
        )
        public final Builder hdgAcc(long hdgAcc) {
            this.hdgAcc = hdgAcc;
            return this;
        }

        public final Gps2Raw build() {
            return new Gps2Raw(timeUsec, fixType, lat, lon, alt, eph, epv, vel, cog, satellitesVisible, dgpsNumch, dgpsAge, yaw, altEllipsoid, hAcc, vAcc, velAcc, hdgAcc);
        }
    }
}
