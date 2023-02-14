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
 * The global position resulting from GPS and sensor fusion. 
 */
@MavlinkMessageInfo(
        id = 340,
        crc = 99,
        description = "The global position resulting from GPS and sensor fusion."
)
public final class UtmGlobalPosition {
    private final BigInteger time;

    private final byte[] uasId;

    private final int lat;

    private final int lon;

    private final int alt;

    private final int relativeAlt;

    private final int vx;

    private final int vy;

    private final int vz;

    private final int hAcc;

    private final int vAcc;

    private final int velAcc;

    private final int nextLat;

    private final int nextLon;

    private final int nextAlt;

    private final int updateRate;

    private final EnumValue<UtmFlightState> flightState;

    private final EnumValue<UtmDataAvailFlags> flags;

    private UtmGlobalPosition(BigInteger time, byte[] uasId, int lat, int lon, int alt,
            int relativeAlt, int vx, int vy, int vz, int hAcc, int vAcc, int velAcc, int nextLat,
            int nextLon, int nextAlt, int updateRate, EnumValue<UtmFlightState> flightState,
            EnumValue<UtmDataAvailFlags> flags) {
        this.time = time;
        this.uasId = uasId;
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
        this.relativeAlt = relativeAlt;
        this.vx = vx;
        this.vy = vy;
        this.vz = vz;
        this.hAcc = hAcc;
        this.vAcc = vAcc;
        this.velAcc = velAcc;
        this.nextLat = nextLat;
        this.nextLon = nextLon;
        this.nextAlt = nextAlt;
        this.updateRate = updateRate;
        this.flightState = flightState;
        this.flags = flags;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Time of applicability of position (microseconds since UNIX epoch). 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            description = "Time of applicability of position (microseconds since UNIX epoch)."
    )
    public final BigInteger time() {
        return this.time;
    }

    /**
     * Unique UAS ID. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            arraySize = 18,
            description = "Unique UAS ID."
    )
    public final byte[] uasId() {
        return this.uasId;
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
     * Altitude (WGS84) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true,
            description = "Altitude (WGS84)"
    )
    public final int alt() {
        return this.alt;
    }

    /**
     * Altitude above ground 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            signed = true,
            description = "Altitude above ground"
    )
    public final int relativeAlt() {
        return this.relativeAlt;
    }

    /**
     * Ground X speed (latitude, positive north) 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            signed = true,
            description = "Ground X speed (latitude, positive north)"
    )
    public final int vx() {
        return this.vx;
    }

    /**
     * Ground Y speed (longitude, positive east) 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2,
            signed = true,
            description = "Ground Y speed (longitude, positive east)"
    )
    public final int vy() {
        return this.vy;
    }

    /**
     * Ground Z speed (altitude, positive down) 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2,
            signed = true,
            description = "Ground Z speed (altitude, positive down)"
    )
    public final int vz() {
        return this.vz;
    }

    /**
     * Horizontal position uncertainty (standard deviation) 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 2,
            description = "Horizontal position uncertainty (standard deviation)"
    )
    public final int hAcc() {
        return this.hAcc;
    }

    /**
     * Altitude uncertainty (standard deviation) 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 2,
            description = "Altitude uncertainty (standard deviation)"
    )
    public final int vAcc() {
        return this.vAcc;
    }

    /**
     * Speed uncertainty (standard deviation) 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 2,
            description = "Speed uncertainty (standard deviation)"
    )
    public final int velAcc() {
        return this.velAcc;
    }

    /**
     * Next waypoint, latitude (WGS84) 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 4,
            signed = true,
            description = "Next waypoint, latitude (WGS84)"
    )
    public final int nextLat() {
        return this.nextLat;
    }

    /**
     * Next waypoint, longitude (WGS84) 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 4,
            signed = true,
            description = "Next waypoint, longitude (WGS84)"
    )
    public final int nextLon() {
        return this.nextLon;
    }

    /**
     * Next waypoint, altitude (WGS84) 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 4,
            signed = true,
            description = "Next waypoint, altitude (WGS84)"
    )
    public final int nextAlt() {
        return this.nextAlt;
    }

    /**
     * Time until next update. Set to 0 if unknown or in data driven mode. 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 2,
            description = "Time until next update. Set to 0 if unknown or in data driven mode."
    )
    public final int updateRate() {
        return this.updateRate;
    }

    /**
     * Flight state 
     */
    @MavlinkFieldInfo(
            position = 17,
            unitSize = 1,
            enumType = UtmFlightState.class,
            description = "Flight state"
    )
    public final EnumValue<UtmFlightState> flightState() {
        return this.flightState;
    }

    /**
     * Bitwise OR combination of the data available flags. 
     */
    @MavlinkFieldInfo(
            position = 18,
            unitSize = 1,
            enumType = UtmDataAvailFlags.class,
            description = "Bitwise OR combination of the data available flags."
    )
    public final EnumValue<UtmDataAvailFlags> flags() {
        return this.flags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        UtmGlobalPosition other = (UtmGlobalPosition)o;
        if (!Objects.deepEquals(time, other.time)) return false;
        if (!Objects.deepEquals(uasId, other.uasId)) return false;
        if (!Objects.deepEquals(lat, other.lat)) return false;
        if (!Objects.deepEquals(lon, other.lon)) return false;
        if (!Objects.deepEquals(alt, other.alt)) return false;
        if (!Objects.deepEquals(relativeAlt, other.relativeAlt)) return false;
        if (!Objects.deepEquals(vx, other.vx)) return false;
        if (!Objects.deepEquals(vy, other.vy)) return false;
        if (!Objects.deepEquals(vz, other.vz)) return false;
        if (!Objects.deepEquals(hAcc, other.hAcc)) return false;
        if (!Objects.deepEquals(vAcc, other.vAcc)) return false;
        if (!Objects.deepEquals(velAcc, other.velAcc)) return false;
        if (!Objects.deepEquals(nextLat, other.nextLat)) return false;
        if (!Objects.deepEquals(nextLon, other.nextLon)) return false;
        if (!Objects.deepEquals(nextAlt, other.nextAlt)) return false;
        if (!Objects.deepEquals(updateRate, other.updateRate)) return false;
        if (!Objects.deepEquals(flightState, other.flightState)) return false;
        if (!Objects.deepEquals(flags, other.flags)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(time);
        result = 31 * result + Objects.hashCode(uasId);
        result = 31 * result + Objects.hashCode(lat);
        result = 31 * result + Objects.hashCode(lon);
        result = 31 * result + Objects.hashCode(alt);
        result = 31 * result + Objects.hashCode(relativeAlt);
        result = 31 * result + Objects.hashCode(vx);
        result = 31 * result + Objects.hashCode(vy);
        result = 31 * result + Objects.hashCode(vz);
        result = 31 * result + Objects.hashCode(hAcc);
        result = 31 * result + Objects.hashCode(vAcc);
        result = 31 * result + Objects.hashCode(velAcc);
        result = 31 * result + Objects.hashCode(nextLat);
        result = 31 * result + Objects.hashCode(nextLon);
        result = 31 * result + Objects.hashCode(nextAlt);
        result = 31 * result + Objects.hashCode(updateRate);
        result = 31 * result + Objects.hashCode(flightState);
        result = 31 * result + Objects.hashCode(flags);
        return result;
    }

    @Override
    public String toString() {
        return "UtmGlobalPosition{time=" + time
                 + ", uasId=" + uasId
                 + ", lat=" + lat
                 + ", lon=" + lon
                 + ", alt=" + alt
                 + ", relativeAlt=" + relativeAlt
                 + ", vx=" + vx
                 + ", vy=" + vy
                 + ", vz=" + vz
                 + ", hAcc=" + hAcc
                 + ", vAcc=" + vAcc
                 + ", velAcc=" + velAcc
                 + ", nextLat=" + nextLat
                 + ", nextLon=" + nextLon
                 + ", nextAlt=" + nextAlt
                 + ", updateRate=" + updateRate
                 + ", flightState=" + flightState
                 + ", flags=" + flags + "}";
    }

    public static final class Builder {
        private BigInteger time;

        private byte[] uasId;

        private int lat;

        private int lon;

        private int alt;

        private int relativeAlt;

        private int vx;

        private int vy;

        private int vz;

        private int hAcc;

        private int vAcc;

        private int velAcc;

        private int nextLat;

        private int nextLon;

        private int nextAlt;

        private int updateRate;

        private EnumValue<UtmFlightState> flightState;

        private EnumValue<UtmDataAvailFlags> flags;

        /**
         * Time of applicability of position (microseconds since UNIX epoch). 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                description = "Time of applicability of position (microseconds since UNIX epoch)."
        )
        public final Builder time(BigInteger time) {
            this.time = time;
            return this;
        }

        /**
         * Unique UAS ID. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                arraySize = 18,
                description = "Unique UAS ID."
        )
        public final Builder uasId(byte[] uasId) {
            this.uasId = uasId;
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
         * Altitude (WGS84) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true,
                description = "Altitude (WGS84)"
        )
        public final Builder alt(int alt) {
            this.alt = alt;
            return this;
        }

        /**
         * Altitude above ground 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                signed = true,
                description = "Altitude above ground"
        )
        public final Builder relativeAlt(int relativeAlt) {
            this.relativeAlt = relativeAlt;
            return this;
        }

        /**
         * Ground X speed (latitude, positive north) 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                signed = true,
                description = "Ground X speed (latitude, positive north)"
        )
        public final Builder vx(int vx) {
            this.vx = vx;
            return this;
        }

        /**
         * Ground Y speed (longitude, positive east) 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2,
                signed = true,
                description = "Ground Y speed (longitude, positive east)"
        )
        public final Builder vy(int vy) {
            this.vy = vy;
            return this;
        }

        /**
         * Ground Z speed (altitude, positive down) 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2,
                signed = true,
                description = "Ground Z speed (altitude, positive down)"
        )
        public final Builder vz(int vz) {
            this.vz = vz;
            return this;
        }

        /**
         * Horizontal position uncertainty (standard deviation) 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 2,
                description = "Horizontal position uncertainty (standard deviation)"
        )
        public final Builder hAcc(int hAcc) {
            this.hAcc = hAcc;
            return this;
        }

        /**
         * Altitude uncertainty (standard deviation) 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 2,
                description = "Altitude uncertainty (standard deviation)"
        )
        public final Builder vAcc(int vAcc) {
            this.vAcc = vAcc;
            return this;
        }

        /**
         * Speed uncertainty (standard deviation) 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 2,
                description = "Speed uncertainty (standard deviation)"
        )
        public final Builder velAcc(int velAcc) {
            this.velAcc = velAcc;
            return this;
        }

        /**
         * Next waypoint, latitude (WGS84) 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 4,
                signed = true,
                description = "Next waypoint, latitude (WGS84)"
        )
        public final Builder nextLat(int nextLat) {
            this.nextLat = nextLat;
            return this;
        }

        /**
         * Next waypoint, longitude (WGS84) 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 4,
                signed = true,
                description = "Next waypoint, longitude (WGS84)"
        )
        public final Builder nextLon(int nextLon) {
            this.nextLon = nextLon;
            return this;
        }

        /**
         * Next waypoint, altitude (WGS84) 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 4,
                signed = true,
                description = "Next waypoint, altitude (WGS84)"
        )
        public final Builder nextAlt(int nextAlt) {
            this.nextAlt = nextAlt;
            return this;
        }

        /**
         * Time until next update. Set to 0 if unknown or in data driven mode. 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 2,
                description = "Time until next update. Set to 0 if unknown or in data driven mode."
        )
        public final Builder updateRate(int updateRate) {
            this.updateRate = updateRate;
            return this;
        }

        /**
         * Flight state 
         */
        @MavlinkFieldInfo(
                position = 17,
                unitSize = 1,
                enumType = UtmFlightState.class,
                description = "Flight state"
        )
        public final Builder flightState(EnumValue<UtmFlightState> flightState) {
            this.flightState = flightState;
            return this;
        }

        /**
         * Flight state 
         */
        public final Builder flightState(UtmFlightState entry) {
            return flightState(EnumValue.of(entry));
        }

        /**
         * Flight state 
         */
        public final Builder flightState(Enum... flags) {
            return flightState(EnumValue.create(flags));
        }

        /**
         * Flight state 
         */
        public final Builder flightState(Collection<Enum> flags) {
            return flightState(EnumValue.create(flags));
        }

        /**
         * Bitwise OR combination of the data available flags. 
         */
        @MavlinkFieldInfo(
                position = 18,
                unitSize = 1,
                enumType = UtmDataAvailFlags.class,
                description = "Bitwise OR combination of the data available flags."
        )
        public final Builder flags(EnumValue<UtmDataAvailFlags> flags) {
            this.flags = flags;
            return this;
        }

        /**
         * Bitwise OR combination of the data available flags. 
         */
        public final Builder flags(UtmDataAvailFlags entry) {
            return flags(EnumValue.of(entry));
        }

        /**
         * Bitwise OR combination of the data available flags. 
         */
        public final Builder flags(Enum... flags) {
            return flags(EnumValue.create(flags));
        }

        /**
         * Bitwise OR combination of the data available flags. 
         */
        public final Builder flags(Collection<Enum> flags) {
            return flags(EnumValue.create(flags));
        }

        public final UtmGlobalPosition build() {
            return new UtmGlobalPosition(time, uasId, lat, lon, alt, relativeAlt, vx, vy, vz, hAcc, vAcc, velAcc, nextLat, nextLon, nextAlt, updateRate, flightState, flags);
        }
    }
}
