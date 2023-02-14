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
 * GPS sensor input message. This is a raw sensor value sent by the GPS. This is NOT the global 
 * position estimate of the system. 
 */
@MavlinkMessageInfo(
        id = 232,
        crc = 151,
        description = "GPS sensor input message.  This is a raw sensor value sent by the GPS. This is NOT the global position estimate of the system."
)
public final class GpsInput {
    private final BigInteger timeUsec;

    private final int gpsId;

    private final EnumValue<GpsInputIgnoreFlags> ignoreFlags;

    private final long timeWeekMs;

    private final int timeWeek;

    private final int fixType;

    private final int lat;

    private final int lon;

    private final float alt;

    private final float hdop;

    private final float vdop;

    private final float vn;

    private final float ve;

    private final float vd;

    private final float speedAccuracy;

    private final float horizAccuracy;

    private final float vertAccuracy;

    private final int satellitesVisible;

    private final int yaw;

    private GpsInput(BigInteger timeUsec, int gpsId, EnumValue<GpsInputIgnoreFlags> ignoreFlags,
            long timeWeekMs, int timeWeek, int fixType, int lat, int lon, float alt, float hdop,
            float vdop, float vn, float ve, float vd, float speedAccuracy, float horizAccuracy,
            float vertAccuracy, int satellitesVisible, int yaw) {
        this.timeUsec = timeUsec;
        this.gpsId = gpsId;
        this.ignoreFlags = ignoreFlags;
        this.timeWeekMs = timeWeekMs;
        this.timeWeek = timeWeek;
        this.fixType = fixType;
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
        this.hdop = hdop;
        this.vdop = vdop;
        this.vn = vn;
        this.ve = ve;
        this.vd = vd;
        this.speedAccuracy = speedAccuracy;
        this.horizAccuracy = horizAccuracy;
        this.vertAccuracy = vertAccuracy;
        this.satellitesVisible = satellitesVisible;
        this.yaw = yaw;
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
     * ID of the GPS for multiple GPS inputs 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "ID of the GPS for multiple GPS inputs"
    )
    public final int gpsId() {
        return this.gpsId;
    }

    /**
     * Bitmap indicating which GPS input flags fields to ignore. All other fields must be provided. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            enumType = GpsInputIgnoreFlags.class,
            description = "Bitmap indicating which GPS input flags fields to ignore.  All other fields must be provided."
    )
    public final EnumValue<GpsInputIgnoreFlags> ignoreFlags() {
        return this.ignoreFlags;
    }

    /**
     * GPS time (from start of GPS week) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "GPS time (from start of GPS week)"
    )
    public final long timeWeekMs() {
        return this.timeWeekMs;
    }

    /**
     * GPS week number 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            description = "GPS week number"
    )
    public final int timeWeek() {
        return this.timeWeek;
    }

    /**
     * 0-1: no fix, 2: 2D fix, 3: 3D fix. 4: 3D with DGPS. 5: 3D with RTK 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            description = "0-1: no fix, 2: 2D fix, 3: 3D fix. 4: 3D with DGPS. 5: 3D with RTK"
    )
    public final int fixType() {
        return this.fixType;
    }

    /**
     * Latitude (WGS84) 
     */
    @MavlinkFieldInfo(
            position = 7,
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
            position = 8,
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
            position = 9,
            unitSize = 4,
            description = "Altitude (MSL). Positive for up."
    )
    public final float alt() {
        return this.alt;
    }

    /**
     * GPS HDOP horizontal dilution of position (unitless). If unknown, set to: UINT16_MAX 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "GPS HDOP horizontal dilution of position (unitless). If unknown, set to: UINT16_MAX"
    )
    public final float hdop() {
        return this.hdop;
    }

    /**
     * GPS VDOP vertical dilution of position (unitless). If unknown, set to: UINT16_MAX 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            description = "GPS VDOP vertical dilution of position (unitless). If unknown, set to: UINT16_MAX"
    )
    public final float vdop() {
        return this.vdop;
    }

    /**
     * GPS velocity in north direction in earth-fixed NED frame 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4,
            description = "GPS velocity in north direction in earth-fixed NED frame"
    )
    public final float vn() {
        return this.vn;
    }

    /**
     * GPS velocity in east direction in earth-fixed NED frame 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 4,
            description = "GPS velocity in east direction in earth-fixed NED frame"
    )
    public final float ve() {
        return this.ve;
    }

    /**
     * GPS velocity in down direction in earth-fixed NED frame 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 4,
            description = "GPS velocity in down direction in earth-fixed NED frame"
    )
    public final float vd() {
        return this.vd;
    }

    /**
     * GPS speed accuracy 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 4,
            description = "GPS speed accuracy"
    )
    public final float speedAccuracy() {
        return this.speedAccuracy;
    }

    /**
     * GPS horizontal accuracy 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 4,
            description = "GPS horizontal accuracy"
    )
    public final float horizAccuracy() {
        return this.horizAccuracy;
    }

    /**
     * GPS vertical accuracy 
     */
    @MavlinkFieldInfo(
            position = 17,
            unitSize = 4,
            description = "GPS vertical accuracy"
    )
    public final float vertAccuracy() {
        return this.vertAccuracy;
    }

    /**
     * Number of satellites visible. 
     */
    @MavlinkFieldInfo(
            position = 18,
            unitSize = 1,
            description = "Number of satellites visible."
    )
    public final int satellitesVisible() {
        return this.satellitesVisible;
    }

    /**
     * Yaw of vehicle relative to Earth's North, zero means not available, use 36000 for north 
     */
    @MavlinkFieldInfo(
            position = 20,
            unitSize = 2,
            extension = true,
            description = "Yaw of vehicle relative to Earth's North, zero means not available, use 36000 for north"
    )
    public final int yaw() {
        return this.yaw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        GpsInput other = (GpsInput)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(gpsId, other.gpsId)) return false;
        if (!Objects.deepEquals(ignoreFlags, other.ignoreFlags)) return false;
        if (!Objects.deepEquals(timeWeekMs, other.timeWeekMs)) return false;
        if (!Objects.deepEquals(timeWeek, other.timeWeek)) return false;
        if (!Objects.deepEquals(fixType, other.fixType)) return false;
        if (!Objects.deepEquals(lat, other.lat)) return false;
        if (!Objects.deepEquals(lon, other.lon)) return false;
        if (!Objects.deepEquals(alt, other.alt)) return false;
        if (!Objects.deepEquals(hdop, other.hdop)) return false;
        if (!Objects.deepEquals(vdop, other.vdop)) return false;
        if (!Objects.deepEquals(vn, other.vn)) return false;
        if (!Objects.deepEquals(ve, other.ve)) return false;
        if (!Objects.deepEquals(vd, other.vd)) return false;
        if (!Objects.deepEquals(speedAccuracy, other.speedAccuracy)) return false;
        if (!Objects.deepEquals(horizAccuracy, other.horizAccuracy)) return false;
        if (!Objects.deepEquals(vertAccuracy, other.vertAccuracy)) return false;
        if (!Objects.deepEquals(satellitesVisible, other.satellitesVisible)) return false;
        if (!Objects.deepEquals(yaw, other.yaw)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(gpsId);
        result = 31 * result + Objects.hashCode(ignoreFlags);
        result = 31 * result + Objects.hashCode(timeWeekMs);
        result = 31 * result + Objects.hashCode(timeWeek);
        result = 31 * result + Objects.hashCode(fixType);
        result = 31 * result + Objects.hashCode(lat);
        result = 31 * result + Objects.hashCode(lon);
        result = 31 * result + Objects.hashCode(alt);
        result = 31 * result + Objects.hashCode(hdop);
        result = 31 * result + Objects.hashCode(vdop);
        result = 31 * result + Objects.hashCode(vn);
        result = 31 * result + Objects.hashCode(ve);
        result = 31 * result + Objects.hashCode(vd);
        result = 31 * result + Objects.hashCode(speedAccuracy);
        result = 31 * result + Objects.hashCode(horizAccuracy);
        result = 31 * result + Objects.hashCode(vertAccuracy);
        result = 31 * result + Objects.hashCode(satellitesVisible);
        result = 31 * result + Objects.hashCode(yaw);
        return result;
    }

    @Override
    public String toString() {
        return "GpsInput{timeUsec=" + timeUsec
                 + ", gpsId=" + gpsId
                 + ", ignoreFlags=" + ignoreFlags
                 + ", timeWeekMs=" + timeWeekMs
                 + ", timeWeek=" + timeWeek
                 + ", fixType=" + fixType
                 + ", lat=" + lat
                 + ", lon=" + lon
                 + ", alt=" + alt
                 + ", hdop=" + hdop
                 + ", vdop=" + vdop
                 + ", vn=" + vn
                 + ", ve=" + ve
                 + ", vd=" + vd
                 + ", speedAccuracy=" + speedAccuracy
                 + ", horizAccuracy=" + horizAccuracy
                 + ", vertAccuracy=" + vertAccuracy
                 + ", satellitesVisible=" + satellitesVisible
                 + ", yaw=" + yaw + "}";
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private int gpsId;

        private EnumValue<GpsInputIgnoreFlags> ignoreFlags;

        private long timeWeekMs;

        private int timeWeek;

        private int fixType;

        private int lat;

        private int lon;

        private float alt;

        private float hdop;

        private float vdop;

        private float vn;

        private float ve;

        private float vd;

        private float speedAccuracy;

        private float horizAccuracy;

        private float vertAccuracy;

        private int satellitesVisible;

        private int yaw;

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
         * ID of the GPS for multiple GPS inputs 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "ID of the GPS for multiple GPS inputs"
        )
        public final Builder gpsId(int gpsId) {
            this.gpsId = gpsId;
            return this;
        }

        /**
         * Bitmap indicating which GPS input flags fields to ignore. All other fields must be provided. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                enumType = GpsInputIgnoreFlags.class,
                description = "Bitmap indicating which GPS input flags fields to ignore.  All other fields must be provided."
        )
        public final Builder ignoreFlags(EnumValue<GpsInputIgnoreFlags> ignoreFlags) {
            this.ignoreFlags = ignoreFlags;
            return this;
        }

        /**
         * Bitmap indicating which GPS input flags fields to ignore. All other fields must be provided. 
         */
        public final Builder ignoreFlags(GpsInputIgnoreFlags entry) {
            return ignoreFlags(EnumValue.of(entry));
        }

        /**
         * Bitmap indicating which GPS input flags fields to ignore. All other fields must be provided. 
         */
        public final Builder ignoreFlags(Enum... flags) {
            return ignoreFlags(EnumValue.create(flags));
        }

        /**
         * Bitmap indicating which GPS input flags fields to ignore. All other fields must be provided. 
         */
        public final Builder ignoreFlags(Collection<Enum> flags) {
            return ignoreFlags(EnumValue.create(flags));
        }

        /**
         * GPS time (from start of GPS week) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "GPS time (from start of GPS week)"
        )
        public final Builder timeWeekMs(long timeWeekMs) {
            this.timeWeekMs = timeWeekMs;
            return this;
        }

        /**
         * GPS week number 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                description = "GPS week number"
        )
        public final Builder timeWeek(int timeWeek) {
            this.timeWeek = timeWeek;
            return this;
        }

        /**
         * 0-1: no fix, 2: 2D fix, 3: 3D fix. 4: 3D with DGPS. 5: 3D with RTK 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                description = "0-1: no fix, 2: 2D fix, 3: 3D fix. 4: 3D with DGPS. 5: 3D with RTK"
        )
        public final Builder fixType(int fixType) {
            this.fixType = fixType;
            return this;
        }

        /**
         * Latitude (WGS84) 
         */
        @MavlinkFieldInfo(
                position = 7,
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
                position = 8,
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
                position = 9,
                unitSize = 4,
                description = "Altitude (MSL). Positive for up."
        )
        public final Builder alt(float alt) {
            this.alt = alt;
            return this;
        }

        /**
         * GPS HDOP horizontal dilution of position (unitless). If unknown, set to: UINT16_MAX 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "GPS HDOP horizontal dilution of position (unitless). If unknown, set to: UINT16_MAX"
        )
        public final Builder hdop(float hdop) {
            this.hdop = hdop;
            return this;
        }

        /**
         * GPS VDOP vertical dilution of position (unitless). If unknown, set to: UINT16_MAX 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                description = "GPS VDOP vertical dilution of position (unitless). If unknown, set to: UINT16_MAX"
        )
        public final Builder vdop(float vdop) {
            this.vdop = vdop;
            return this;
        }

        /**
         * GPS velocity in north direction in earth-fixed NED frame 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4,
                description = "GPS velocity in north direction in earth-fixed NED frame"
        )
        public final Builder vn(float vn) {
            this.vn = vn;
            return this;
        }

        /**
         * GPS velocity in east direction in earth-fixed NED frame 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 4,
                description = "GPS velocity in east direction in earth-fixed NED frame"
        )
        public final Builder ve(float ve) {
            this.ve = ve;
            return this;
        }

        /**
         * GPS velocity in down direction in earth-fixed NED frame 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 4,
                description = "GPS velocity in down direction in earth-fixed NED frame"
        )
        public final Builder vd(float vd) {
            this.vd = vd;
            return this;
        }

        /**
         * GPS speed accuracy 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 4,
                description = "GPS speed accuracy"
        )
        public final Builder speedAccuracy(float speedAccuracy) {
            this.speedAccuracy = speedAccuracy;
            return this;
        }

        /**
         * GPS horizontal accuracy 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 4,
                description = "GPS horizontal accuracy"
        )
        public final Builder horizAccuracy(float horizAccuracy) {
            this.horizAccuracy = horizAccuracy;
            return this;
        }

        /**
         * GPS vertical accuracy 
         */
        @MavlinkFieldInfo(
                position = 17,
                unitSize = 4,
                description = "GPS vertical accuracy"
        )
        public final Builder vertAccuracy(float vertAccuracy) {
            this.vertAccuracy = vertAccuracy;
            return this;
        }

        /**
         * Number of satellites visible. 
         */
        @MavlinkFieldInfo(
                position = 18,
                unitSize = 1,
                description = "Number of satellites visible."
        )
        public final Builder satellitesVisible(int satellitesVisible) {
            this.satellitesVisible = satellitesVisible;
            return this;
        }

        /**
         * Yaw of vehicle relative to Earth's North, zero means not available, use 36000 for north 
         */
        @MavlinkFieldInfo(
                position = 20,
                unitSize = 2,
                extension = true,
                description = "Yaw of vehicle relative to Earth's North, zero means not available, use 36000 for north"
        )
        public final Builder yaw(int yaw) {
            this.yaw = yaw;
            return this;
        }

        public final GpsInput build() {
            return new GpsInput(timeUsec, gpsId, ignoreFlags, timeWeekMs, timeWeek, fixType, lat, lon, alt, hdop, vdop, vn, ve, vd, speedAccuracy, horizAccuracy, vertAccuracy, satellitesVisible, yaw);
        }
    }
}
