package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Float;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.Collection;
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
        crc = 119,
        description = "The filtered global position (e.g. fused GPS and accelerometers). The position is in GPS-frame (right-handed, Z-up). It  is designed as scaled integer message since the resolution of float is not sufficient. NOTE: This message is intended for onboard networks / companion computers and higher-bandwidth links and optimized for accuracy and completeness. Please use the GLOBAL_POSITION_INT message for a minimal subset."
)
public final class GlobalPositionIntCov {
    private final BigInteger timeUsec;

    private final EnumValue<MavEstimatorType> estimatorType;

    private final int lat;

    private final int lon;

    private final int alt;

    private final int relativeAlt;

    private final float vx;

    private final float vy;

    private final float vz;

    private final List<Float> covariance;

    private GlobalPositionIntCov(BigInteger timeUsec, EnumValue<MavEstimatorType> estimatorType,
            int lat, int lon, int alt, int relativeAlt, float vx, float vy, float vz,
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
     * Class id of the estimator this estimate originated from. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = MavEstimatorType.class,
            description = "Class id of the estimator this estimate originated from."
    )
    public final EnumValue<MavEstimatorType> estimatorType() {
        return this.estimatorType;
    }

    /**
     * Latitude 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            signed = true,
            description = "Latitude"
    )
    public final int lat() {
        return this.lat;
    }

    /**
     * Longitude 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            signed = true,
            description = "Longitude"
    )
    public final int lon() {
        return this.lon;
    }

    /**
     * Altitude in meters above MSL 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true,
            description = "Altitude in meters above MSL"
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
     * Ground X Speed (Latitude) 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Ground X Speed (Latitude)"
    )
    public final float vx() {
        return this.vx;
    }

    /**
     * Ground Y Speed (Longitude) 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Ground Y Speed (Longitude)"
    )
    public final float vy() {
        return this.vy;
    }

    /**
     * Ground Z Speed (Altitude) 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Ground Z Speed (Altitude)"
    )
    public final float vz() {
        return this.vz;
    }

    /**
     * Row-major representation of a 6x6 position and velocity 6x6 cross-covariance matrix 
     * (states: lat, lon, alt, vx, vy, vz; first six entries are the first ROW, next six entries are the 
     * second row, etc.). If unknown, assign NaN value to first element in the array. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            arraySize = 36,
            description = "Row-major representation of a 6x6 position and velocity 6x6 cross-covariance matrix (states: lat, lon, alt, vx, vy, vz; first six entries are the first ROW, next six entries are the second row, etc.). If unknown, assign NaN value to first element in the array."
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

    @Override
    public String toString() {
        return "GlobalPositionIntCov{timeUsec=" + timeUsec
                 + ", estimatorType=" + estimatorType
                 + ", lat=" + lat
                 + ", lon=" + lon
                 + ", alt=" + alt
                 + ", relativeAlt=" + relativeAlt
                 + ", vx=" + vx
                 + ", vy=" + vy
                 + ", vz=" + vz
                 + ", covariance=" + covariance + "}";
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private EnumValue<MavEstimatorType> estimatorType;

        private int lat;

        private int lon;

        private int alt;

        private int relativeAlt;

        private float vx;

        private float vy;

        private float vz;

        private List<Float> covariance;

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
         * Class id of the estimator this estimate originated from. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                enumType = MavEstimatorType.class,
                description = "Class id of the estimator this estimate originated from."
        )
        public final Builder estimatorType(EnumValue<MavEstimatorType> estimatorType) {
            this.estimatorType = estimatorType;
            return this;
        }

        /**
         * Class id of the estimator this estimate originated from. 
         */
        public final Builder estimatorType(MavEstimatorType entry) {
            return estimatorType(EnumValue.of(entry));
        }

        /**
         * Class id of the estimator this estimate originated from. 
         */
        public final Builder estimatorType(Enum... flags) {
            return estimatorType(EnumValue.create(flags));
        }

        /**
         * Class id of the estimator this estimate originated from. 
         */
        public final Builder estimatorType(Collection<Enum> flags) {
            return estimatorType(EnumValue.create(flags));
        }

        /**
         * Latitude 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                signed = true,
                description = "Latitude"
        )
        public final Builder lat(int lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Longitude 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                signed = true,
                description = "Longitude"
        )
        public final Builder lon(int lon) {
            this.lon = lon;
            return this;
        }

        /**
         * Altitude in meters above MSL 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true,
                description = "Altitude in meters above MSL"
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
         * Ground X Speed (Latitude) 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Ground X Speed (Latitude)"
        )
        public final Builder vx(float vx) {
            this.vx = vx;
            return this;
        }

        /**
         * Ground Y Speed (Longitude) 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Ground Y Speed (Longitude)"
        )
        public final Builder vy(float vy) {
            this.vy = vy;
            return this;
        }

        /**
         * Ground Z Speed (Altitude) 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Ground Z Speed (Altitude)"
        )
        public final Builder vz(float vz) {
            this.vz = vz;
            return this;
        }

        /**
         * Row-major representation of a 6x6 position and velocity 6x6 cross-covariance matrix 
         * (states: lat, lon, alt, vx, vy, vz; first six entries are the first ROW, next six entries are the 
         * second row, etc.). If unknown, assign NaN value to first element in the array. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                arraySize = 36,
                description = "Row-major representation of a 6x6 position and velocity 6x6 cross-covariance matrix (states: lat, lon, alt, vx, vy, vz; first six entries are the first ROW, next six entries are the second row, etc.). If unknown, assign NaN value to first element in the array."
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
