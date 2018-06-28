package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.math.BigInteger;

/**
 * Second GPS data. 
 */
@MavlinkMessageInfo(
        id = 124,
        crc = 87
)
public final class Gps2Raw {
    private final BigInteger timeUsec;

    private final GpsFixType fixType;

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

    private Gps2Raw(BigInteger timeUsec, GpsFixType fixType, int lat, int lon, int alt, int eph,
            int epv, int vel, int cog, int satellitesVisible, int dgpsNumch, long dgpsAge) {
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
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * See the {@link io.dronefleet.mavlink.common.GpsFixType GPS_FIX_TYPE} enum. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final GpsFixType fixType() {
        return this.fixType;
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
        return this.lat;
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
        return this.lon;
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
        return this.alt;
    }

    /**
     * GPS HDOP horizontal dilution of position in cm (m*100). If unknown, set to: UINT16_MAX 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2
    )
    public final int eph() {
        return this.eph;
    }

    /**
     * GPS VDOP vertical dilution of position in cm (m*100). If unknown, set to: UINT16_MAX 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2
    )
    public final int epv() {
        return this.epv;
    }

    /**
     * GPS ground speed (m/s * 100). If unknown, set to: UINT16_MAX 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2
    )
    public final int vel() {
        return this.vel;
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
        return this.cog;
    }

    /**
     * Number of satellites visible. If unknown, set to 255 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1
    )
    public final int satellitesVisible() {
        return this.satellitesVisible;
    }

    /**
     * Number of DGPS satellites 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 1
    )
    public final int dgpsNumch() {
        return this.dgpsNumch;
    }

    /**
     * Age of DGPS info 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4
    )
    public final long dgpsAge() {
        return this.dgpsAge;
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private GpsFixType fixType;

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
         * See the {@link io.dronefleet.mavlink.common.GpsFixType GPS_FIX_TYPE} enum. 
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

        public final Gps2Raw build() {
            return new Gps2Raw(timeUsec, fixType, lat, lon, alt, eph, epv, vel, cog, satellitesVisible, dgpsNumch, dgpsAge);
        }
    }
}
