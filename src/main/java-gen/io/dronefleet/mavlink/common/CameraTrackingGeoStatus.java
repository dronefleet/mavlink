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
 * Camera tracking status, sent while in active tracking. Use MAV_CMD_SET_MESSAGE_INTERVAL to 
 * define message interval. 
 */
@MavlinkMessageInfo(
        id = 276,
        crc = 18,
        description = "Camera tracking status, sent while in active tracking. Use MAV_CMD_SET_MESSAGE_INTERVAL to define message interval."
)
public final class CameraTrackingGeoStatus {
    private final EnumValue<CameraTrackingStatusFlags> trackingStatus;

    private final int lat;

    private final int lon;

    private final float alt;

    private final float hAcc;

    private final float vAcc;

    private final float velN;

    private final float velE;

    private final float velD;

    private final float velAcc;

    private final float dist;

    private final float hdg;

    private final float hdgAcc;

    private CameraTrackingGeoStatus(EnumValue<CameraTrackingStatusFlags> trackingStatus, int lat,
            int lon, float alt, float hAcc, float vAcc, float velN, float velE, float velD,
            float velAcc, float dist, float hdg, float hdgAcc) {
        this.trackingStatus = trackingStatus;
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
        this.hAcc = hAcc;
        this.vAcc = vAcc;
        this.velN = velN;
        this.velE = velE;
        this.velD = velD;
        this.velAcc = velAcc;
        this.dist = dist;
        this.hdg = hdg;
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
     * Current tracking status 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            enumType = CameraTrackingStatusFlags.class,
            description = "Current tracking status"
    )
    public final EnumValue<CameraTrackingStatusFlags> trackingStatus() {
        return this.trackingStatus;
    }

    /**
     * Latitude of tracked object 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            signed = true,
            description = "Latitude of tracked object"
    )
    public final int lat() {
        return this.lat;
    }

    /**
     * Longitude of tracked object 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            signed = true,
            description = "Longitude of tracked object"
    )
    public final int lon() {
        return this.lon;
    }

    /**
     * Altitude of tracked object(AMSL, WGS84) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Altitude of tracked object(AMSL, WGS84)"
    )
    public final float alt() {
        return this.alt;
    }

    /**
     * Horizontal accuracy. NAN if unknown 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Horizontal accuracy. NAN if unknown"
    )
    public final float hAcc() {
        return this.hAcc;
    }

    /**
     * Vertical accuracy. NAN if unknown 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Vertical accuracy. NAN if unknown"
    )
    public final float vAcc() {
        return this.vAcc;
    }

    /**
     * North velocity of tracked object. NAN if unknown 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "North velocity of tracked object. NAN if unknown"
    )
    public final float velN() {
        return this.velN;
    }

    /**
     * East velocity of tracked object. NAN if unknown 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "East velocity of tracked object. NAN if unknown"
    )
    public final float velE() {
        return this.velE;
    }

    /**
     * Down velocity of tracked object. NAN if unknown 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Down velocity of tracked object. NAN if unknown"
    )
    public final float velD() {
        return this.velD;
    }

    /**
     * Velocity accuracy. NAN if unknown 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "Velocity accuracy. NAN if unknown"
    )
    public final float velAcc() {
        return this.velAcc;
    }

    /**
     * Distance between camera and tracked object. NAN if unknown 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            description = "Distance between camera and tracked object. NAN if unknown"
    )
    public final float dist() {
        return this.dist;
    }

    /**
     * Heading in radians, in NED. NAN if unknown 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4,
            description = "Heading in radians, in NED. NAN if unknown"
    )
    public final float hdg() {
        return this.hdg;
    }

    /**
     * Accuracy of heading, in NED. NAN if unknown 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 4,
            description = "Accuracy of heading, in NED. NAN if unknown"
    )
    public final float hdgAcc() {
        return this.hdgAcc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        CameraTrackingGeoStatus other = (CameraTrackingGeoStatus)o;
        if (!Objects.deepEquals(trackingStatus, other.trackingStatus)) return false;
        if (!Objects.deepEquals(lat, other.lat)) return false;
        if (!Objects.deepEquals(lon, other.lon)) return false;
        if (!Objects.deepEquals(alt, other.alt)) return false;
        if (!Objects.deepEquals(hAcc, other.hAcc)) return false;
        if (!Objects.deepEquals(vAcc, other.vAcc)) return false;
        if (!Objects.deepEquals(velN, other.velN)) return false;
        if (!Objects.deepEquals(velE, other.velE)) return false;
        if (!Objects.deepEquals(velD, other.velD)) return false;
        if (!Objects.deepEquals(velAcc, other.velAcc)) return false;
        if (!Objects.deepEquals(dist, other.dist)) return false;
        if (!Objects.deepEquals(hdg, other.hdg)) return false;
        if (!Objects.deepEquals(hdgAcc, other.hdgAcc)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(trackingStatus);
        result = 31 * result + Objects.hashCode(lat);
        result = 31 * result + Objects.hashCode(lon);
        result = 31 * result + Objects.hashCode(alt);
        result = 31 * result + Objects.hashCode(hAcc);
        result = 31 * result + Objects.hashCode(vAcc);
        result = 31 * result + Objects.hashCode(velN);
        result = 31 * result + Objects.hashCode(velE);
        result = 31 * result + Objects.hashCode(velD);
        result = 31 * result + Objects.hashCode(velAcc);
        result = 31 * result + Objects.hashCode(dist);
        result = 31 * result + Objects.hashCode(hdg);
        result = 31 * result + Objects.hashCode(hdgAcc);
        return result;
    }

    @Override
    public String toString() {
        return "CameraTrackingGeoStatus{trackingStatus=" + trackingStatus
                 + ", lat=" + lat
                 + ", lon=" + lon
                 + ", alt=" + alt
                 + ", hAcc=" + hAcc
                 + ", vAcc=" + vAcc
                 + ", velN=" + velN
                 + ", velE=" + velE
                 + ", velD=" + velD
                 + ", velAcc=" + velAcc
                 + ", dist=" + dist
                 + ", hdg=" + hdg
                 + ", hdgAcc=" + hdgAcc + "}";
    }

    public static final class Builder {
        private EnumValue<CameraTrackingStatusFlags> trackingStatus;

        private int lat;

        private int lon;

        private float alt;

        private float hAcc;

        private float vAcc;

        private float velN;

        private float velE;

        private float velD;

        private float velAcc;

        private float dist;

        private float hdg;

        private float hdgAcc;

        /**
         * Current tracking status 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                enumType = CameraTrackingStatusFlags.class,
                description = "Current tracking status"
        )
        public final Builder trackingStatus(EnumValue<CameraTrackingStatusFlags> trackingStatus) {
            this.trackingStatus = trackingStatus;
            return this;
        }

        /**
         * Current tracking status 
         */
        public final Builder trackingStatus(CameraTrackingStatusFlags entry) {
            return trackingStatus(EnumValue.of(entry));
        }

        /**
         * Current tracking status 
         */
        public final Builder trackingStatus(Enum... flags) {
            return trackingStatus(EnumValue.create(flags));
        }

        /**
         * Current tracking status 
         */
        public final Builder trackingStatus(Collection<Enum> flags) {
            return trackingStatus(EnumValue.create(flags));
        }

        /**
         * Latitude of tracked object 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                signed = true,
                description = "Latitude of tracked object"
        )
        public final Builder lat(int lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Longitude of tracked object 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                signed = true,
                description = "Longitude of tracked object"
        )
        public final Builder lon(int lon) {
            this.lon = lon;
            return this;
        }

        /**
         * Altitude of tracked object(AMSL, WGS84) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Altitude of tracked object(AMSL, WGS84)"
        )
        public final Builder alt(float alt) {
            this.alt = alt;
            return this;
        }

        /**
         * Horizontal accuracy. NAN if unknown 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Horizontal accuracy. NAN if unknown"
        )
        public final Builder hAcc(float hAcc) {
            this.hAcc = hAcc;
            return this;
        }

        /**
         * Vertical accuracy. NAN if unknown 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Vertical accuracy. NAN if unknown"
        )
        public final Builder vAcc(float vAcc) {
            this.vAcc = vAcc;
            return this;
        }

        /**
         * North velocity of tracked object. NAN if unknown 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "North velocity of tracked object. NAN if unknown"
        )
        public final Builder velN(float velN) {
            this.velN = velN;
            return this;
        }

        /**
         * East velocity of tracked object. NAN if unknown 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "East velocity of tracked object. NAN if unknown"
        )
        public final Builder velE(float velE) {
            this.velE = velE;
            return this;
        }

        /**
         * Down velocity of tracked object. NAN if unknown 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Down velocity of tracked object. NAN if unknown"
        )
        public final Builder velD(float velD) {
            this.velD = velD;
            return this;
        }

        /**
         * Velocity accuracy. NAN if unknown 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "Velocity accuracy. NAN if unknown"
        )
        public final Builder velAcc(float velAcc) {
            this.velAcc = velAcc;
            return this;
        }

        /**
         * Distance between camera and tracked object. NAN if unknown 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                description = "Distance between camera and tracked object. NAN if unknown"
        )
        public final Builder dist(float dist) {
            this.dist = dist;
            return this;
        }

        /**
         * Heading in radians, in NED. NAN if unknown 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4,
                description = "Heading in radians, in NED. NAN if unknown"
        )
        public final Builder hdg(float hdg) {
            this.hdg = hdg;
            return this;
        }

        /**
         * Accuracy of heading, in NED. NAN if unknown 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 4,
                description = "Accuracy of heading, in NED. NAN if unknown"
        )
        public final Builder hdgAcc(float hdgAcc) {
            this.hdgAcc = hdgAcc;
            return this;
        }

        public final CameraTrackingGeoStatus build() {
            return new CameraTrackingGeoStatus(trackingStatus, lat, lon, alt, hAcc, vAcc, velN, velE, velD, velAcc, dist, hdg, hdgAcc);
        }
    }
}
