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
 * Wind covariance estimate from vehicle. 
 */
@MavlinkMessageInfo(
        id = 231,
        crc = 105,
        description = "Wind covariance estimate from vehicle."
)
public final class WindCov {
    private final BigInteger timeUsec;

    private final float windX;

    private final float windY;

    private final float windZ;

    private final float varHoriz;

    private final float varVert;

    private final float windAlt;

    private final float horizAccuracy;

    private final float vertAccuracy;

    private WindCov(BigInteger timeUsec, float windX, float windY, float windZ, float varHoriz,
            float varVert, float windAlt, float horizAccuracy, float vertAccuracy) {
        this.timeUsec = timeUsec;
        this.windX = windX;
        this.windY = windY;
        this.windZ = windZ;
        this.varHoriz = varHoriz;
        this.varVert = varVert;
        this.windAlt = windAlt;
        this.horizAccuracy = horizAccuracy;
        this.vertAccuracy = vertAccuracy;
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
     * Wind in X (NED) direction 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Wind in X (NED) direction"
    )
    public final float windX() {
        return this.windX;
    }

    /**
     * Wind in Y (NED) direction 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Wind in Y (NED) direction"
    )
    public final float windY() {
        return this.windY;
    }

    /**
     * Wind in Z (NED) direction 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Wind in Z (NED) direction"
    )
    public final float windZ() {
        return this.windZ;
    }

    /**
     * Variability of the wind in XY. RMS of a 1 Hz lowpassed wind estimate. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Variability of the wind in XY. RMS of a 1 Hz lowpassed wind estimate."
    )
    public final float varHoriz() {
        return this.varHoriz;
    }

    /**
     * Variability of the wind in Z. RMS of a 1 Hz lowpassed wind estimate. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Variability of the wind in Z. RMS of a 1 Hz lowpassed wind estimate."
    )
    public final float varVert() {
        return this.varVert;
    }

    /**
     * Altitude (MSL) that this measurement was taken at 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Altitude (MSL) that this measurement was taken at"
    )
    public final float windAlt() {
        return this.windAlt;
    }

    /**
     * Horizontal speed 1-STD accuracy 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Horizontal speed 1-STD accuracy"
    )
    public final float horizAccuracy() {
        return this.horizAccuracy;
    }

    /**
     * Vertical speed 1-STD accuracy 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Vertical speed 1-STD accuracy"
    )
    public final float vertAccuracy() {
        return this.vertAccuracy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        WindCov other = (WindCov)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(windX, other.windX)) return false;
        if (!Objects.deepEquals(windY, other.windY)) return false;
        if (!Objects.deepEquals(windZ, other.windZ)) return false;
        if (!Objects.deepEquals(varHoriz, other.varHoriz)) return false;
        if (!Objects.deepEquals(varVert, other.varVert)) return false;
        if (!Objects.deepEquals(windAlt, other.windAlt)) return false;
        if (!Objects.deepEquals(horizAccuracy, other.horizAccuracy)) return false;
        if (!Objects.deepEquals(vertAccuracy, other.vertAccuracy)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(windX);
        result = 31 * result + Objects.hashCode(windY);
        result = 31 * result + Objects.hashCode(windZ);
        result = 31 * result + Objects.hashCode(varHoriz);
        result = 31 * result + Objects.hashCode(varVert);
        result = 31 * result + Objects.hashCode(windAlt);
        result = 31 * result + Objects.hashCode(horizAccuracy);
        result = 31 * result + Objects.hashCode(vertAccuracy);
        return result;
    }

    @Override
    public String toString() {
        return "WindCov{timeUsec=" + timeUsec
                 + ", windX=" + windX
                 + ", windY=" + windY
                 + ", windZ=" + windZ
                 + ", varHoriz=" + varHoriz
                 + ", varVert=" + varVert
                 + ", windAlt=" + windAlt
                 + ", horizAccuracy=" + horizAccuracy
                 + ", vertAccuracy=" + vertAccuracy + "}";
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private float windX;

        private float windY;

        private float windZ;

        private float varHoriz;

        private float varVert;

        private float windAlt;

        private float horizAccuracy;

        private float vertAccuracy;

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
         * Wind in X (NED) direction 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Wind in X (NED) direction"
        )
        public final Builder windX(float windX) {
            this.windX = windX;
            return this;
        }

        /**
         * Wind in Y (NED) direction 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Wind in Y (NED) direction"
        )
        public final Builder windY(float windY) {
            this.windY = windY;
            return this;
        }

        /**
         * Wind in Z (NED) direction 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Wind in Z (NED) direction"
        )
        public final Builder windZ(float windZ) {
            this.windZ = windZ;
            return this;
        }

        /**
         * Variability of the wind in XY. RMS of a 1 Hz lowpassed wind estimate. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Variability of the wind in XY. RMS of a 1 Hz lowpassed wind estimate."
        )
        public final Builder varHoriz(float varHoriz) {
            this.varHoriz = varHoriz;
            return this;
        }

        /**
         * Variability of the wind in Z. RMS of a 1 Hz lowpassed wind estimate. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Variability of the wind in Z. RMS of a 1 Hz lowpassed wind estimate."
        )
        public final Builder varVert(float varVert) {
            this.varVert = varVert;
            return this;
        }

        /**
         * Altitude (MSL) that this measurement was taken at 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Altitude (MSL) that this measurement was taken at"
        )
        public final Builder windAlt(float windAlt) {
            this.windAlt = windAlt;
            return this;
        }

        /**
         * Horizontal speed 1-STD accuracy 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Horizontal speed 1-STD accuracy"
        )
        public final Builder horizAccuracy(float horizAccuracy) {
            this.horizAccuracy = horizAccuracy;
            return this;
        }

        /**
         * Vertical speed 1-STD accuracy 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Vertical speed 1-STD accuracy"
        )
        public final Builder vertAccuracy(float vertAccuracy) {
            this.vertAccuracy = vertAccuracy;
            return this;
        }

        public final WindCov build() {
            return new WindCov(timeUsec, windX, windY, windZ, varHoriz, varVert, windAlt, horizAccuracy, vertAccuracy);
        }
    }
}
