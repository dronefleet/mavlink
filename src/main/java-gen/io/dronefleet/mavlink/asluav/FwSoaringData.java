package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Fixed-wing soaring (i.e. thermal seeking) data 
 */
@MavlinkMessageInfo(
        id = 8011,
        crc = 20,
        description = "Fixed-wing soaring (i.e. thermal seeking) data"
)
public final class FwSoaringData {
    private final BigInteger timestamp;

    private final BigInteger timestampmodechanged;

    private final float xw;

    private final float xr;

    private final float xlat;

    private final float xlon;

    private final float varw;

    private final float varr;

    private final float varlat;

    private final float varlon;

    private final float loiterradius;

    private final float loiterdirection;

    private final float disttosoarpoint;

    private final float vsinkexp;

    private final float z1Localupdraftspeed;

    private final float z2Deltaroll;

    private final float z1Exp;

    private final float z2Exp;

    private final float thermalgsnorth;

    private final float thermalgseast;

    private final float tseDot;

    private final float debugvar1;

    private final float debugvar2;

    private final int controlmode;

    private final int valid;

    private FwSoaringData(BigInteger timestamp, BigInteger timestampmodechanged, float xw, float xr,
            float xlat, float xlon, float varw, float varr, float varlat, float varlon,
            float loiterradius, float loiterdirection, float disttosoarpoint, float vsinkexp,
            float z1Localupdraftspeed, float z2Deltaroll, float z1Exp, float z2Exp,
            float thermalgsnorth, float thermalgseast, float tseDot, float debugvar1,
            float debugvar2, int controlmode, int valid) {
        this.timestamp = timestamp;
        this.timestampmodechanged = timestampmodechanged;
        this.xw = xw;
        this.xr = xr;
        this.xlat = xlat;
        this.xlon = xlon;
        this.varw = varw;
        this.varr = varr;
        this.varlat = varlat;
        this.varlon = varlon;
        this.loiterradius = loiterradius;
        this.loiterdirection = loiterdirection;
        this.disttosoarpoint = disttosoarpoint;
        this.vsinkexp = vsinkexp;
        this.z1Localupdraftspeed = z1Localupdraftspeed;
        this.z2Deltaroll = z2Deltaroll;
        this.z1Exp = z1Exp;
        this.z2Exp = z2Exp;
        this.thermalgsnorth = thermalgsnorth;
        this.thermalgseast = thermalgseast;
        this.tseDot = tseDot;
        this.debugvar1 = debugvar1;
        this.debugvar2 = debugvar2;
        this.controlmode = controlmode;
        this.valid = valid;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            description = "Timestamp"
    )
    public final BigInteger timestamp() {
        return this.timestamp;
    }

    /**
     * Timestamp since last mode change 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 8,
            description = "Timestamp since last mode change"
    )
    public final BigInteger timestampmodechanged() {
        return this.timestampmodechanged;
    }

    /**
     * Thermal core updraft strength 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Thermal core updraft strength"
    )
    public final float xw() {
        return this.xw;
    }

    /**
     * Thermal radius 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Thermal radius"
    )
    public final float xr() {
        return this.xr;
    }

    /**
     * Thermal center latitude 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Thermal center latitude"
    )
    public final float xlat() {
        return this.xlat;
    }

    /**
     * Thermal center longitude 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Thermal center longitude"
    )
    public final float xlon() {
        return this.xlon;
    }

    /**
     * Variance W 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Variance W"
    )
    public final float varw() {
        return this.varw;
    }

    /**
     * Variance R 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Variance R"
    )
    public final float varr() {
        return this.varr;
    }

    /**
     * Variance Lat 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Variance Lat"
    )
    public final float varlat() {
        return this.varlat;
    }

    /**
     * Variance Lon 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "Variance Lon"
    )
    public final float varlon() {
        return this.varlon;
    }

    /**
     * Suggested loiter radius 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            description = "Suggested loiter radius"
    )
    public final float loiterradius() {
        return this.loiterradius;
    }

    /**
     * Suggested loiter direction 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4,
            description = "Suggested loiter direction"
    )
    public final float loiterdirection() {
        return this.loiterdirection;
    }

    /**
     * Distance to soar point 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 4,
            description = "Distance to soar point"
    )
    public final float disttosoarpoint() {
        return this.disttosoarpoint;
    }

    /**
     * Expected sink rate at current airspeed, roll and throttle 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 4,
            description = "Expected sink rate at current airspeed, roll and throttle"
    )
    public final float vsinkexp() {
        return this.vsinkexp;
    }

    /**
     * Measurement / updraft speed at current/local airplane position 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 4,
            description = "Measurement / updraft speed at current/local airplane position"
    )
    public final float z1Localupdraftspeed() {
        return this.z1Localupdraftspeed;
    }

    /**
     * Measurement / roll angle tracking error 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 4,
            description = "Measurement / roll angle tracking error"
    )
    public final float z2Deltaroll() {
        return this.z2Deltaroll;
    }

    /**
     * Expected measurement 1 
     */
    @MavlinkFieldInfo(
            position = 17,
            unitSize = 4,
            description = "Expected measurement 1"
    )
    public final float z1Exp() {
        return this.z1Exp;
    }

    /**
     * Expected measurement 2 
     */
    @MavlinkFieldInfo(
            position = 18,
            unitSize = 4,
            description = "Expected measurement 2"
    )
    public final float z2Exp() {
        return this.z2Exp;
    }

    /**
     * Thermal drift (from estimator prediction step only) 
     */
    @MavlinkFieldInfo(
            position = 19,
            unitSize = 4,
            description = "Thermal drift (from estimator prediction step only)"
    )
    public final float thermalgsnorth() {
        return this.thermalgsnorth;
    }

    /**
     * Thermal drift (from estimator prediction step only) 
     */
    @MavlinkFieldInfo(
            position = 20,
            unitSize = 4,
            description = "Thermal drift (from estimator prediction step only)"
    )
    public final float thermalgseast() {
        return this.thermalgseast;
    }

    /**
     * Total specific energy change (filtered) 
     */
    @MavlinkFieldInfo(
            position = 21,
            unitSize = 4,
            description = "Total specific energy change (filtered)"
    )
    public final float tseDot() {
        return this.tseDot;
    }

    /**
     * Debug variable 1 
     */
    @MavlinkFieldInfo(
            position = 22,
            unitSize = 4,
            description = "Debug variable 1"
    )
    public final float debugvar1() {
        return this.debugvar1;
    }

    /**
     * Debug variable 2 
     */
    @MavlinkFieldInfo(
            position = 23,
            unitSize = 4,
            description = "Debug variable 2"
    )
    public final float debugvar2() {
        return this.debugvar2;
    }

    /**
     * Control Mode [-] 
     */
    @MavlinkFieldInfo(
            position = 24,
            unitSize = 1,
            description = "Control Mode [-]"
    )
    public final int controlmode() {
        return this.controlmode;
    }

    /**
     * Data valid [-] 
     */
    @MavlinkFieldInfo(
            position = 25,
            unitSize = 1,
            description = "Data valid [-]"
    )
    public final int valid() {
        return this.valid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        FwSoaringData other = (FwSoaringData)o;
        if (!Objects.deepEquals(timestamp, other.timestamp)) return false;
        if (!Objects.deepEquals(timestampmodechanged, other.timestampmodechanged)) return false;
        if (!Objects.deepEquals(xw, other.xw)) return false;
        if (!Objects.deepEquals(xr, other.xr)) return false;
        if (!Objects.deepEquals(xlat, other.xlat)) return false;
        if (!Objects.deepEquals(xlon, other.xlon)) return false;
        if (!Objects.deepEquals(varw, other.varw)) return false;
        if (!Objects.deepEquals(varr, other.varr)) return false;
        if (!Objects.deepEquals(varlat, other.varlat)) return false;
        if (!Objects.deepEquals(varlon, other.varlon)) return false;
        if (!Objects.deepEquals(loiterradius, other.loiterradius)) return false;
        if (!Objects.deepEquals(loiterdirection, other.loiterdirection)) return false;
        if (!Objects.deepEquals(disttosoarpoint, other.disttosoarpoint)) return false;
        if (!Objects.deepEquals(vsinkexp, other.vsinkexp)) return false;
        if (!Objects.deepEquals(z1Localupdraftspeed, other.z1Localupdraftspeed)) return false;
        if (!Objects.deepEquals(z2Deltaroll, other.z2Deltaroll)) return false;
        if (!Objects.deepEquals(z1Exp, other.z1Exp)) return false;
        if (!Objects.deepEquals(z2Exp, other.z2Exp)) return false;
        if (!Objects.deepEquals(thermalgsnorth, other.thermalgsnorth)) return false;
        if (!Objects.deepEquals(thermalgseast, other.thermalgseast)) return false;
        if (!Objects.deepEquals(tseDot, other.tseDot)) return false;
        if (!Objects.deepEquals(debugvar1, other.debugvar1)) return false;
        if (!Objects.deepEquals(debugvar2, other.debugvar2)) return false;
        if (!Objects.deepEquals(controlmode, other.controlmode)) return false;
        if (!Objects.deepEquals(valid, other.valid)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timestamp);
        result = 31 * result + Objects.hashCode(timestampmodechanged);
        result = 31 * result + Objects.hashCode(xw);
        result = 31 * result + Objects.hashCode(xr);
        result = 31 * result + Objects.hashCode(xlat);
        result = 31 * result + Objects.hashCode(xlon);
        result = 31 * result + Objects.hashCode(varw);
        result = 31 * result + Objects.hashCode(varr);
        result = 31 * result + Objects.hashCode(varlat);
        result = 31 * result + Objects.hashCode(varlon);
        result = 31 * result + Objects.hashCode(loiterradius);
        result = 31 * result + Objects.hashCode(loiterdirection);
        result = 31 * result + Objects.hashCode(disttosoarpoint);
        result = 31 * result + Objects.hashCode(vsinkexp);
        result = 31 * result + Objects.hashCode(z1Localupdraftspeed);
        result = 31 * result + Objects.hashCode(z2Deltaroll);
        result = 31 * result + Objects.hashCode(z1Exp);
        result = 31 * result + Objects.hashCode(z2Exp);
        result = 31 * result + Objects.hashCode(thermalgsnorth);
        result = 31 * result + Objects.hashCode(thermalgseast);
        result = 31 * result + Objects.hashCode(tseDot);
        result = 31 * result + Objects.hashCode(debugvar1);
        result = 31 * result + Objects.hashCode(debugvar2);
        result = 31 * result + Objects.hashCode(controlmode);
        result = 31 * result + Objects.hashCode(valid);
        return result;
    }

    @Override
    public String toString() {
        return "FwSoaringData{timestamp=" + timestamp
                 + ", timestampmodechanged=" + timestampmodechanged
                 + ", xw=" + xw
                 + ", xr=" + xr
                 + ", xlat=" + xlat
                 + ", xlon=" + xlon
                 + ", varw=" + varw
                 + ", varr=" + varr
                 + ", varlat=" + varlat
                 + ", varlon=" + varlon
                 + ", loiterradius=" + loiterradius
                 + ", loiterdirection=" + loiterdirection
                 + ", disttosoarpoint=" + disttosoarpoint
                 + ", vsinkexp=" + vsinkexp
                 + ", z1Localupdraftspeed=" + z1Localupdraftspeed
                 + ", z2Deltaroll=" + z2Deltaroll
                 + ", z1Exp=" + z1Exp
                 + ", z2Exp=" + z2Exp
                 + ", thermalgsnorth=" + thermalgsnorth
                 + ", thermalgseast=" + thermalgseast
                 + ", tseDot=" + tseDot
                 + ", debugvar1=" + debugvar1
                 + ", debugvar2=" + debugvar2
                 + ", controlmode=" + controlmode
                 + ", valid=" + valid + "}";
    }

    public static final class Builder {
        private BigInteger timestamp;

        private BigInteger timestampmodechanged;

        private float xw;

        private float xr;

        private float xlat;

        private float xlon;

        private float varw;

        private float varr;

        private float varlat;

        private float varlon;

        private float loiterradius;

        private float loiterdirection;

        private float disttosoarpoint;

        private float vsinkexp;

        private float z1Localupdraftspeed;

        private float z2Deltaroll;

        private float z1Exp;

        private float z2Exp;

        private float thermalgsnorth;

        private float thermalgseast;

        private float tseDot;

        private float debugvar1;

        private float debugvar2;

        private int controlmode;

        private int valid;

        /**
         * Timestamp 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                description = "Timestamp"
        )
        public final Builder timestamp(BigInteger timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        /**
         * Timestamp since last mode change 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 8,
                description = "Timestamp since last mode change"
        )
        public final Builder timestampmodechanged(BigInteger timestampmodechanged) {
            this.timestampmodechanged = timestampmodechanged;
            return this;
        }

        /**
         * Thermal core updraft strength 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Thermal core updraft strength"
        )
        public final Builder xw(float xw) {
            this.xw = xw;
            return this;
        }

        /**
         * Thermal radius 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Thermal radius"
        )
        public final Builder xr(float xr) {
            this.xr = xr;
            return this;
        }

        /**
         * Thermal center latitude 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Thermal center latitude"
        )
        public final Builder xlat(float xlat) {
            this.xlat = xlat;
            return this;
        }

        /**
         * Thermal center longitude 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Thermal center longitude"
        )
        public final Builder xlon(float xlon) {
            this.xlon = xlon;
            return this;
        }

        /**
         * Variance W 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Variance W"
        )
        public final Builder varw(float varw) {
            this.varw = varw;
            return this;
        }

        /**
         * Variance R 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Variance R"
        )
        public final Builder varr(float varr) {
            this.varr = varr;
            return this;
        }

        /**
         * Variance Lat 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Variance Lat"
        )
        public final Builder varlat(float varlat) {
            this.varlat = varlat;
            return this;
        }

        /**
         * Variance Lon 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "Variance Lon"
        )
        public final Builder varlon(float varlon) {
            this.varlon = varlon;
            return this;
        }

        /**
         * Suggested loiter radius 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                description = "Suggested loiter radius"
        )
        public final Builder loiterradius(float loiterradius) {
            this.loiterradius = loiterradius;
            return this;
        }

        /**
         * Suggested loiter direction 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4,
                description = "Suggested loiter direction"
        )
        public final Builder loiterdirection(float loiterdirection) {
            this.loiterdirection = loiterdirection;
            return this;
        }

        /**
         * Distance to soar point 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 4,
                description = "Distance to soar point"
        )
        public final Builder disttosoarpoint(float disttosoarpoint) {
            this.disttosoarpoint = disttosoarpoint;
            return this;
        }

        /**
         * Expected sink rate at current airspeed, roll and throttle 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 4,
                description = "Expected sink rate at current airspeed, roll and throttle"
        )
        public final Builder vsinkexp(float vsinkexp) {
            this.vsinkexp = vsinkexp;
            return this;
        }

        /**
         * Measurement / updraft speed at current/local airplane position 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 4,
                description = "Measurement / updraft speed at current/local airplane position"
        )
        public final Builder z1Localupdraftspeed(float z1Localupdraftspeed) {
            this.z1Localupdraftspeed = z1Localupdraftspeed;
            return this;
        }

        /**
         * Measurement / roll angle tracking error 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 4,
                description = "Measurement / roll angle tracking error"
        )
        public final Builder z2Deltaroll(float z2Deltaroll) {
            this.z2Deltaroll = z2Deltaroll;
            return this;
        }

        /**
         * Expected measurement 1 
         */
        @MavlinkFieldInfo(
                position = 17,
                unitSize = 4,
                description = "Expected measurement 1"
        )
        public final Builder z1Exp(float z1Exp) {
            this.z1Exp = z1Exp;
            return this;
        }

        /**
         * Expected measurement 2 
         */
        @MavlinkFieldInfo(
                position = 18,
                unitSize = 4,
                description = "Expected measurement 2"
        )
        public final Builder z2Exp(float z2Exp) {
            this.z2Exp = z2Exp;
            return this;
        }

        /**
         * Thermal drift (from estimator prediction step only) 
         */
        @MavlinkFieldInfo(
                position = 19,
                unitSize = 4,
                description = "Thermal drift (from estimator prediction step only)"
        )
        public final Builder thermalgsnorth(float thermalgsnorth) {
            this.thermalgsnorth = thermalgsnorth;
            return this;
        }

        /**
         * Thermal drift (from estimator prediction step only) 
         */
        @MavlinkFieldInfo(
                position = 20,
                unitSize = 4,
                description = "Thermal drift (from estimator prediction step only)"
        )
        public final Builder thermalgseast(float thermalgseast) {
            this.thermalgseast = thermalgseast;
            return this;
        }

        /**
         * Total specific energy change (filtered) 
         */
        @MavlinkFieldInfo(
                position = 21,
                unitSize = 4,
                description = "Total specific energy change (filtered)"
        )
        public final Builder tseDot(float tseDot) {
            this.tseDot = tseDot;
            return this;
        }

        /**
         * Debug variable 1 
         */
        @MavlinkFieldInfo(
                position = 22,
                unitSize = 4,
                description = "Debug variable 1"
        )
        public final Builder debugvar1(float debugvar1) {
            this.debugvar1 = debugvar1;
            return this;
        }

        /**
         * Debug variable 2 
         */
        @MavlinkFieldInfo(
                position = 23,
                unitSize = 4,
                description = "Debug variable 2"
        )
        public final Builder debugvar2(float debugvar2) {
            this.debugvar2 = debugvar2;
            return this;
        }

        /**
         * Control Mode [-] 
         */
        @MavlinkFieldInfo(
                position = 24,
                unitSize = 1,
                description = "Control Mode [-]"
        )
        public final Builder controlmode(int controlmode) {
            this.controlmode = controlmode;
            return this;
        }

        /**
         * Data valid [-] 
         */
        @MavlinkFieldInfo(
                position = 25,
                unitSize = 1,
                description = "Data valid [-]"
        )
        public final Builder valid(int valid) {
            this.valid = valid;
            return this;
        }

        public final FwSoaringData build() {
            return new FwSoaringData(timestamp, timestampmodechanged, xw, xr, xlat, xlon, varw, varr, varlat, varlon, loiterradius, loiterdirection, disttosoarpoint, vsinkexp, z1Localupdraftspeed, z2Deltaroll, z1Exp, z2Exp, thermalgsnorth, thermalgseast, tseDot, debugvar1, debugvar2, controlmode, valid);
        }
    }
}
