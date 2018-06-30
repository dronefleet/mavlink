package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Float;
import java.lang.Object;
import java.lang.Override;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

/**
 * The filtered global position (e.g. fused GPS and accelerometers). The position is in 
 * GPS-frame (right-handed, Z-up). It is designed as scaled integer message since the 
 * resolution of float is not sufficient. NOTE: This message is intended for onboard networks / 
 * companion computers and higher-bandwidth links and optimized for accuracy and 
 * completeness. Please use the {@link io.dronefleet.mavlink.common.GlobalPositionInt GLOBAL_POSITION_INT} message for a minimal subset. 
 */
@MavlinkMessageInfo(
        id = 63,
        crc = 119
)
public final class GlobalPositionIntCov {
    private final BigInteger timeUsec;

    private final MavEstimatorType estimatorType;

    private final int lat;

    private final int lon;

    private final int alt;

    private final int relativeAlt;

    private final float vx;

    private final float vy;

    private final float vz;

    private final List<Float> covariance;

    private GlobalPositionIntCov(BigInteger timeUsec, MavEstimatorType estimatorType, int lat,
            int lon, int alt, int relativeAlt, float vx, float vy, float vz,
            List<Float> covariance) {
        this.timeUsec = timeUsec;
        this.estimatorType = estimatorType;
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
        this.relativeAlt = relativeAlt;
        this.vx = vx;
        this.vy = vy;
        this.vz = vz;
        this.covariance = covariance;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (microseconds since system boot or since UNIX epoch) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * Class id of the estimator this estimate originated from. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final MavEstimatorType estimatorType() {
        return this.estimatorType;
    }

    /**
     * Latitude, expressed as degrees * 1E7 
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
     * Longitude, expressed as degrees * 1E7 
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
     * Altitude in meters, expressed as * 1000 (millimeters), above MSL 
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
     * Altitude above ground in meters, expressed as * 1000 (millimeters) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            signed = true
    )
    public final int relativeAlt() {
        return this.relativeAlt;
    }

    /**
     * Ground X Speed (Latitude), expressed as m/s 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float vx() {
        return this.vx;
    }

    /**
     * Ground Y Speed (Longitude), expressed as m/s 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4
    )
    public final float vy() {
        return this.vy;
    }

    /**
     * Ground Z Speed (Altitude), expressed as m/s 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4
    )
    public final float vz() {
        return this.vz;
    }

    /**
     * Covariance matrix (first six entries are the first ROW, next six entries are the second row, 
     * etc.) 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            arraySize = 36
    )
    public final List<Float> covariance() {
        return this.covariance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        GlobalPositionIntCov other = (GlobalPositionIntCov)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(estimatorType, other.estimatorType)) return false;
        if (!Objects.deepEquals(lat, other.lat)) return false;
        if (!Objects.deepEquals(lon, other.lon)) return false;
        if (!Objects.deepEquals(alt, other.alt)) return false;
        if (!Objects.deepEquals(relativeAlt, other.relativeAlt)) return false;
        if (!Objects.deepEquals(vx, other.vx)) return false;
        if (!Objects.deepEquals(vy, other.vy)) return false;
        if (!Objects.deepEquals(vz, other.vz)) return false;
        if (!Objects.deepEquals(covariance, other.covariance)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(estimatorType);
        result = 31 * result + Objects.hashCode(lat);
        result = 31 * result + Objects.hashCode(lon);
        result = 31 * result + Objects.hashCode(alt);
        result = 31 * result + Objects.hashCode(relativeAlt);
        result = 31 * result + Objects.hashCode(vx);
        result = 31 * result + Objects.hashCode(vy);
        result = 31 * result + Objects.hashCode(vz);
        result = 31 * result + Objects.hashCode(covariance);
        return result;
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private MavEstimatorType estimatorType;

        private int lat;

        private int lon;

        private int alt;

        private int relativeAlt;

        private float vx;

        private float vy;

        private float vz;

        private List<Float> covariance;

        /**
         * Timestamp (microseconds since system boot or since UNIX epoch) 
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
         * Class id of the estimator this estimate originated from. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder estimatorType(MavEstimatorType estimatorType) {
            this.estimatorType = estimatorType;
            return this;
        }

        /**
         * Latitude, expressed as degrees * 1E7 
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
         * Longitude, expressed as degrees * 1E7 
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
         * Altitude in meters, expressed as * 1000 (millimeters), above MSL 
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
         * Altitude above ground in meters, expressed as * 1000 (millimeters) 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                signed = true
        )
        public final Builder relativeAlt(int relativeAlt) {
            this.relativeAlt = relativeAlt;
            return this;
        }

        /**
         * Ground X Speed (Latitude), expressed as m/s 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4
        )
        public final Builder vx(float vx) {
            this.vx = vx;
            return this;
        }

        /**
         * Ground Y Speed (Longitude), expressed as m/s 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4
        )
        public final Builder vy(float vy) {
            this.vy = vy;
            return this;
        }

        /**
         * Ground Z Speed (Altitude), expressed as m/s 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4
        )
        public final Builder vz(float vz) {
            this.vz = vz;
            return this;
        }

        /**
         * Covariance matrix (first six entries are the first ROW, next six entries are the second row, 
         * etc.) 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                arraySize = 36
        )
        public final Builder covariance(List<Float> covariance) {
            this.covariance = covariance;
            return this;
        }

        public final GlobalPositionIntCov build() {
            return new GlobalPositionIntCov(timeUsec, estimatorType, lat, lon, alt, relativeAlt, vx, vy, vz, covariance);
        }
    }
}
