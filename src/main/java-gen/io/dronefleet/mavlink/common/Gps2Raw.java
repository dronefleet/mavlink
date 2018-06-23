package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;

/**
 * Second GPS data. 
 */
@MavlinkMessageInfo(
        id = 124,
        crc = 87
)
public final class Gps2Raw {
    /**
     * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     */
    private final BigInteger timeUsec;

    /**
     * Latitude (WGS84), in degrees * 1E7 
     */
    private final int lat;

    /**
     * Longitude (WGS84), in degrees * 1E7 
     */
    private final int lon;

    /**
     * Altitude (AMSL, not WGS84), in meters * 1000 (positive for up) 
     */
    private final int alt;

    /**
     * Age of DGPS info 
     */
    private final long dgpsAge;

    /**
     * GPS HDOP horizontal dilution of position in cm (m*100). If unknown, set to: UINT16_MAX 
     */
    private final int eph;

    /**
     * GPS VDOP vertical dilution of position in cm (m*100). If unknown, set to: UINT16_MAX 
     */
    private final int epv;

    /**
     * GPS ground speed (m/s * 100). If unknown, set to: UINT16_MAX 
     */
    private final int vel;

    /**
     * Course over ground (NOT heading, but direction of movement) in degrees * 100, 0.0..359.99 
     * degrees. If unknown, set to: UINT16_MAX 
     */
    private final int cog;

    /**
     * See the {@link io.dronefleet.mavlink.common.GpsFixType GpsFixType} enum. 
     */
    private final GpsFixType fixType;

    /**
     * Number of satellites visible. If unknown, set to 255 
     */
    private final int satellitesVisible;

    /**
     * Number of DGPS satellites 
     */
    private final int dgpsNumch;

    private Gps2Raw(BigInteger timeUsec, int lat, int lon, int alt, long dgpsAge, int eph, int epv,
            int vel, int cog, GpsFixType fixType, int satellitesVisible, int dgpsNumch) {
        this.timeUsec = timeUsec;
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
        this.dgpsAge = dgpsAge;
        this.eph = eph;
        this.epv = epv;
        this.vel = vel;
        this.cog = cog;
        this.fixType = fixType;
        this.satellitesVisible = satellitesVisible;
        this.dgpsNumch = dgpsNumch;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
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
                 + ", dgpsAge=" + dgpsAge + "}";
    }

    /**
     * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
    )
    public final BigInteger timeUsec() {
        return timeUsec;
    }

    /**
     * Latitude (WGS84), in degrees * 1E7 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            signed = true
    )
    public final int lat() {
        return lat;
    }

    /**
     * Longitude (WGS84), in degrees * 1E7 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            signed = true
    )
    public final int lon() {
        return lon;
    }

    /**
     * Altitude (AMSL, not WGS84), in meters * 1000 (positive for up) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true
    )
    public final int alt() {
        return alt;
    }

    /**
     * Age of DGPS info 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4
    )
    public final long dgpsAge() {
        return dgpsAge;
    }

    /**
     * GPS HDOP horizontal dilution of position in cm (m*100). If unknown, set to: UINT16_MAX 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2
    )
    public final int eph() {
        return eph;
    }

    /**
     * GPS VDOP vertical dilution of position in cm (m*100). If unknown, set to: UINT16_MAX 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2
    )
    public final int epv() {
        return epv;
    }

    /**
     * GPS ground speed (m/s * 100). If unknown, set to: UINT16_MAX 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2
    )
    public final int vel() {
        return vel;
    }

    /**
     * Course over ground (NOT heading, but direction of movement) in degrees * 100, 0.0..359.99 
     * degrees. If unknown, set to: UINT16_MAX 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2
    )
    public final int cog() {
        return cog;
    }

    /**
     * See the {@link io.dronefleet.mavlink.common.GpsFixType GpsFixType} enum. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final GpsFixType fixType() {
        return fixType;
    }

    /**
     * Number of satellites visible. If unknown, set to 255 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1
    )
    public final int satellitesVisible() {
        return satellitesVisible;
    }

    /**
     * Number of DGPS satellites 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 1
    )
    public final int dgpsNumch() {
        return dgpsNumch;
    }

    public static class Builder {
        private BigInteger timeUsec;

        private int lat;

        private int lon;

        private int alt;

        private long dgpsAge;

        private int eph;

        private int epv;

        private int vel;

        private int cog;

        private GpsFixType fixType;

        private int satellitesVisible;

        private int dgpsNumch;

        private Builder() {
        }

        /**
         * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * Latitude (WGS84), in degrees * 1E7 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                signed = true
        )
        public final Builder lat(int lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Longitude (WGS84), in degrees * 1E7 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                signed = true
        )
        public final Builder lon(int lon) {
            this.lon = lon;
            return this;
        }

        /**
         * Altitude (AMSL, not WGS84), in meters * 1000 (positive for up) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true
        )
        public final Builder alt(int alt) {
            this.alt = alt;
            return this;
        }

        /**
         * Age of DGPS info 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4
        )
        public final Builder dgpsAge(long dgpsAge) {
            this.dgpsAge = dgpsAge;
            return this;
        }

        /**
         * GPS HDOP horizontal dilution of position in cm (m*100). If unknown, set to: UINT16_MAX 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2
        )
        public final Builder eph(int eph) {
            this.eph = eph;
            return this;
        }

        /**
         * GPS VDOP vertical dilution of position in cm (m*100). If unknown, set to: UINT16_MAX 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2
        )
        public final Builder epv(int epv) {
            this.epv = epv;
            return this;
        }

        /**
         * GPS ground speed (m/s * 100). If unknown, set to: UINT16_MAX 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2
        )
        public final Builder vel(int vel) {
            this.vel = vel;
            return this;
        }

        /**
         * Course over ground (NOT heading, but direction of movement) in degrees * 100, 0.0..359.99 
         * degrees. If unknown, set to: UINT16_MAX 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2
        )
        public final Builder cog(int cog) {
            this.cog = cog;
            return this;
        }

        /**
         * See the {@link io.dronefleet.mavlink.common.GpsFixType GpsFixType} enum. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder fixType(GpsFixType fixType) {
            this.fixType = fixType;
            return this;
        }

        /**
         * Number of satellites visible. If unknown, set to 255 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 1
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
                unitSize = 1
        )
        public final Builder dgpsNumch(int dgpsNumch) {
            this.dgpsNumch = dgpsNumch;
            return this;
        }

        public final Gps2Raw build() {
            return new Gps2Raw(timeUsec, lat, lon, alt, dgpsAge, eph, epv, vel, cog, fixType, satellitesVisible, dgpsNumch);
        }
    }
}
