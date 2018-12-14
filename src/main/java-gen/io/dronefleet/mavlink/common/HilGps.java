package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.Objects;

/**
 * The global position, as returned by the Global Positioning System (GPS). This is NOT the global 
 * position estimate of the sytem, but rather a RAW sensor value. See message GLOBAL_POSITION for 
 * the global position estimate. 
 */
@MavlinkMessageInfo(
        id = 113,
        crc = 124,
        description = "The global position, as returned by the Global Positioning System (GPS). This is\n"
                        + "                 NOT the global position estimate of the sytem, but rather a RAW sensor value. See message GLOBAL_POSITION for the global position estimate."
)
public final class HilGps {
    private final BigInteger timeUsec;

    private final int fixType;

    private final int lat;

    private final int lon;

    private final int alt;

    private final int eph;

    private final int epv;

    private final int vel;

    private final int vn;

    private final int ve;

    private final int vd;

    private final int cog;

    private final int satellitesVisible;

    private HilGps(BigInteger timeUsec, int fixType, int lat, int lon, int alt, int eph, int epv,
            int vel, int vn, int ve, int vd, int cog, int satellitesVisible) {
        this.timeUsec = timeUsec;
        this.fixType = fixType;
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
        this.eph = eph;
        this.epv = epv;
        this.vel = vel;
        this.vn = vn;
        this.ve = ve;
        this.vd = vd;
        this.cog = cog;
        this.satellitesVisible = satellitesVisible;
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
     * format (since 1.1.1970 or since system boot) by checking for the magnitude the number. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude the number."
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * 0-1: no fix, 2: 2D fix, 3: 3D fix. Some applications will not use the value of this field unless it 
     * is at least two, so always correctly fill in the fix. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "0-1: no fix, 2: 2D fix, 3: 3D fix. Some applications will not use the value of this field unless it is at least two, so always correctly fill in the fix."
    )
    public final int fixType() {
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
     * GPS HDOP horizontal dilution of position. If unknown, set to: 65535 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            description = "GPS HDOP horizontal dilution of position. If unknown, set to: 65535"
    )
    public final int eph() {
        return this.eph;
    }

    /**
     * GPS VDOP vertical dilution of position. If unknown, set to: 65535 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            description = "GPS VDOP vertical dilution of position. If unknown, set to: 65535"
    )
    public final int epv() {
        return this.epv;
    }

    /**
     * GPS ground speed. If unknown, set to: 65535 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2,
            description = "GPS ground speed. If unknown, set to: 65535"
    )
    public final int vel() {
        return this.vel;
    }

    /**
     * GPS velocity in NORTH direction in earth-fixed NED frame 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2,
            signed = true,
            description = "GPS velocity in NORTH direction in earth-fixed NED frame"
    )
    public final int vn() {
        return this.vn;
    }

    /**
     * GPS velocity in EAST direction in earth-fixed NED frame 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 2,
            signed = true,
            description = "GPS velocity in EAST direction in earth-fixed NED frame"
    )
    public final int ve() {
        return this.ve;
    }

    /**
     * GPS velocity in DOWN direction in earth-fixed NED frame 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 2,
            signed = true,
            description = "GPS velocity in DOWN direction in earth-fixed NED frame"
    )
    public final int vd() {
        return this.vd;
    }

    /**
     * Course over ground (NOT heading, but direction of movement), 0.0..359.99 degrees. If 
     * unknown, set to: 65535 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 2,
            description = "Course over ground (NOT heading, but direction of movement), 0.0..359.99 degrees. If unknown, set to: 65535"
    )
    public final int cog() {
        return this.cog;
    }

    /**
     * Number of satellites visible. If unknown, set to 255 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 1,
            description = "Number of satellites visible. If unknown, set to 255"
    )
    public final int satellitesVisible() {
        return this.satellitesVisible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        HilGps other = (HilGps)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(fixType, other.fixType)) return false;
        if (!Objects.deepEquals(lat, other.lat)) return false;
        if (!Objects.deepEquals(lon, other.lon)) return false;
        if (!Objects.deepEquals(alt, other.alt)) return false;
        if (!Objects.deepEquals(eph, other.eph)) return false;
        if (!Objects.deepEquals(epv, other.epv)) return false;
        if (!Objects.deepEquals(vel, other.vel)) return false;
        if (!Objects.deepEquals(vn, other.vn)) return false;
        if (!Objects.deepEquals(ve, other.ve)) return false;
        if (!Objects.deepEquals(vd, other.vd)) return false;
        if (!Objects.deepEquals(cog, other.cog)) return false;
        if (!Objects.deepEquals(satellitesVisible, other.satellitesVisible)) return false;
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
        result = 31 * result + Objects.hashCode(vn);
        result = 31 * result + Objects.hashCode(ve);
        result = 31 * result + Objects.hashCode(vd);
        result = 31 * result + Objects.hashCode(cog);
        result = 31 * result + Objects.hashCode(satellitesVisible);
        return result;
    }

    @Override
    public String toString() {
        return "HilGps{timeUsec=" + timeUsec
                 + ", fixType=" + fixType
                 + ", lat=" + lat
                 + ", lon=" + lon
                 + ", alt=" + alt
                 + ", eph=" + eph
                 + ", epv=" + epv
                 + ", vel=" + vel
                 + ", vn=" + vn
                 + ", ve=" + ve
                 + ", vd=" + vd
                 + ", cog=" + cog
                 + ", satellitesVisible=" + satellitesVisible + "}";
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private int fixType;

        private int lat;

        private int lon;

        private int alt;

        private int eph;

        private int epv;

        private int vel;

        private int vn;

        private int ve;

        private int vd;

        private int cog;

        private int satellitesVisible;

        /**
         * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
         * format (since 1.1.1970 or since system boot) by checking for the magnitude the number. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude the number."
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * 0-1: no fix, 2: 2D fix, 3: 3D fix. Some applications will not use the value of this field unless it 
         * is at least two, so always correctly fill in the fix. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "0-1: no fix, 2: 2D fix, 3: 3D fix. Some applications will not use the value of this field unless it is at least two, so always correctly fill in the fix."
        )
        public final Builder fixType(int fixType) {
            this.fixType = fixType;
            return this;
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
         * GPS HDOP horizontal dilution of position. If unknown, set to: 65535 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                description = "GPS HDOP horizontal dilution of position. If unknown, set to: 65535"
        )
        public final Builder eph(int eph) {
            this.eph = eph;
            return this;
        }

        /**
         * GPS VDOP vertical dilution of position. If unknown, set to: 65535 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                description = "GPS VDOP vertical dilution of position. If unknown, set to: 65535"
        )
        public final Builder epv(int epv) {
            this.epv = epv;
            return this;
        }

        /**
         * GPS ground speed. If unknown, set to: 65535 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2,
                description = "GPS ground speed. If unknown, set to: 65535"
        )
        public final Builder vel(int vel) {
            this.vel = vel;
            return this;
        }

        /**
         * GPS velocity in NORTH direction in earth-fixed NED frame 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2,
                signed = true,
                description = "GPS velocity in NORTH direction in earth-fixed NED frame"
        )
        public final Builder vn(int vn) {
            this.vn = vn;
            return this;
        }

        /**
         * GPS velocity in EAST direction in earth-fixed NED frame 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 2,
                signed = true,
                description = "GPS velocity in EAST direction in earth-fixed NED frame"
        )
        public final Builder ve(int ve) {
            this.ve = ve;
            return this;
        }

        /**
         * GPS velocity in DOWN direction in earth-fixed NED frame 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 2,
                signed = true,
                description = "GPS velocity in DOWN direction in earth-fixed NED frame"
        )
        public final Builder vd(int vd) {
            this.vd = vd;
            return this;
        }

        /**
         * Course over ground (NOT heading, but direction of movement), 0.0..359.99 degrees. If 
         * unknown, set to: 65535 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 2,
                description = "Course over ground (NOT heading, but direction of movement), 0.0..359.99 degrees. If unknown, set to: 65535"
        )
        public final Builder cog(int cog) {
            this.cog = cog;
            return this;
        }

        /**
         * Number of satellites visible. If unknown, set to 255 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 1,
                description = "Number of satellites visible. If unknown, set to 255"
        )
        public final Builder satellitesVisible(int satellitesVisible) {
            this.satellitesVisible = satellitesVisible;
            return this;
        }

        public final HilGps build() {
            return new HilGps(timeUsec, fixType, lat, lon, alt, eph, epv, vel, vn, ve, vd, cog, satellitesVisible);
        }
    }
}
