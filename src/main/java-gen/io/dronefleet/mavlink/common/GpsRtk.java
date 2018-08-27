package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * RTK GPS data. Gives information on the relative baseline calculation the GPS is reporting 
 */
@MavlinkMessageInfo(
        id = 127,
        crc = 25
)
public final class GpsRtk {
    private final long timeLastBaselineMs;

    private final int rtkReceiverId;

    private final int wn;

    private final long tow;

    private final int rtkHealth;

    private final int rtkRate;

    private final int nsats;

    private final EnumValue<RtkBaselineCoordinateSystem> baselineCoordsType;

    private final int baselineAMm;

    private final int baselineBMm;

    private final int baselineCMm;

    private final long accuracy;

    private final int iarNumHypotheses;

    private GpsRtk(long timeLastBaselineMs, int rtkReceiverId, int wn, long tow, int rtkHealth,
            int rtkRate, int nsats, EnumValue<RtkBaselineCoordinateSystem> baselineCoordsType,
            int baselineAMm, int baselineBMm, int baselineCMm, long accuracy,
            int iarNumHypotheses) {
        this.timeLastBaselineMs = timeLastBaselineMs;
        this.rtkReceiverId = rtkReceiverId;
        this.wn = wn;
        this.tow = tow;
        this.rtkHealth = rtkHealth;
        this.rtkRate = rtkRate;
        this.nsats = nsats;
        this.baselineCoordsType = baselineCoordsType;
        this.baselineAMm = baselineAMm;
        this.baselineBMm = baselineBMm;
        this.baselineCMm = baselineCMm;
        this.accuracy = accuracy;
        this.iarNumHypotheses = iarNumHypotheses;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Time since boot of last baseline message received in ms. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final long timeLastBaselineMs() {
        return this.timeLastBaselineMs;
    }

    /**
     * Identification of connected RTK receiver. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int rtkReceiverId() {
        return this.rtkReceiverId;
    }

    /**
     * GPS Week Number of last baseline 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2
    )
    public final int wn() {
        return this.wn;
    }

    /**
     * GPS Time of Week of last baseline 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final long tow() {
        return this.tow;
    }

    /**
     * GPS-specific health report for RTK data. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final int rtkHealth() {
        return this.rtkHealth;
    }

    /**
     * Rate of baseline messages being received by GPS, in HZ 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1
    )
    public final int rtkRate() {
        return this.rtkRate;
    }

    /**
     * Current number of sats used for RTK calculation. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1
    )
    public final int nsats() {
        return this.nsats;
    }

    /**
     * Coordinate system of baseline 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1,
            enumType = RtkBaselineCoordinateSystem.class
    )
    public final EnumValue<RtkBaselineCoordinateSystem> baselineCoordsType() {
        return this.baselineCoordsType;
    }

    /**
     * Current baseline in ECEF x or NED north component in mm. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            signed = true
    )
    public final int baselineAMm() {
        return this.baselineAMm;
    }

    /**
     * Current baseline in ECEF y or NED east component in mm. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            signed = true
    )
    public final int baselineBMm() {
        return this.baselineBMm;
    }

    /**
     * Current baseline in ECEF z or NED down component in mm. 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            signed = true
    )
    public final int baselineCMm() {
        return this.baselineCMm;
    }

    /**
     * Current estimate of baseline accuracy. 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4
    )
    public final long accuracy() {
        return this.accuracy;
    }

    /**
     * Current number of integer ambiguity hypotheses. 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 4,
            signed = true
    )
    public final int iarNumHypotheses() {
        return this.iarNumHypotheses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        GpsRtk other = (GpsRtk)o;
        if (!Objects.deepEquals(timeLastBaselineMs, other.timeLastBaselineMs)) return false;
        if (!Objects.deepEquals(rtkReceiverId, other.rtkReceiverId)) return false;
        if (!Objects.deepEquals(wn, other.wn)) return false;
        if (!Objects.deepEquals(tow, other.tow)) return false;
        if (!Objects.deepEquals(rtkHealth, other.rtkHealth)) return false;
        if (!Objects.deepEquals(rtkRate, other.rtkRate)) return false;
        if (!Objects.deepEquals(nsats, other.nsats)) return false;
        if (!Objects.deepEquals(baselineCoordsType, other.baselineCoordsType)) return false;
        if (!Objects.deepEquals(baselineAMm, other.baselineAMm)) return false;
        if (!Objects.deepEquals(baselineBMm, other.baselineBMm)) return false;
        if (!Objects.deepEquals(baselineCMm, other.baselineCMm)) return false;
        if (!Objects.deepEquals(accuracy, other.accuracy)) return false;
        if (!Objects.deepEquals(iarNumHypotheses, other.iarNumHypotheses)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeLastBaselineMs);
        result = 31 * result + Objects.hashCode(rtkReceiverId);
        result = 31 * result + Objects.hashCode(wn);
        result = 31 * result + Objects.hashCode(tow);
        result = 31 * result + Objects.hashCode(rtkHealth);
        result = 31 * result + Objects.hashCode(rtkRate);
        result = 31 * result + Objects.hashCode(nsats);
        result = 31 * result + Objects.hashCode(baselineCoordsType);
        result = 31 * result + Objects.hashCode(baselineAMm);
        result = 31 * result + Objects.hashCode(baselineBMm);
        result = 31 * result + Objects.hashCode(baselineCMm);
        result = 31 * result + Objects.hashCode(accuracy);
        result = 31 * result + Objects.hashCode(iarNumHypotheses);
        return result;
    }

    @Override
    public String toString() {
        return "GpsRtk{timeLastBaselineMs=" + timeLastBaselineMs
                 + ", rtkReceiverId=" + rtkReceiverId
                 + ", wn=" + wn
                 + ", tow=" + tow
                 + ", rtkHealth=" + rtkHealth
                 + ", rtkRate=" + rtkRate
                 + ", nsats=" + nsats
                 + ", baselineCoordsType=" + baselineCoordsType
                 + ", baselineAMm=" + baselineAMm
                 + ", baselineBMm=" + baselineBMm
                 + ", baselineCMm=" + baselineCMm
                 + ", accuracy=" + accuracy
                 + ", iarNumHypotheses=" + iarNumHypotheses + "}";
    }

    public static final class Builder {
        private long timeLastBaselineMs;

        private int rtkReceiverId;

        private int wn;

        private long tow;

        private int rtkHealth;

        private int rtkRate;

        private int nsats;

        private EnumValue<RtkBaselineCoordinateSystem> baselineCoordsType;

        private int baselineAMm;

        private int baselineBMm;

        private int baselineCMm;

        private long accuracy;

        private int iarNumHypotheses;

        /**
         * Time since boot of last baseline message received in ms. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
        )
        public final Builder timeLastBaselineMs(long timeLastBaselineMs) {
            this.timeLastBaselineMs = timeLastBaselineMs;
            return this;
        }

        /**
         * Identification of connected RTK receiver. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder rtkReceiverId(int rtkReceiverId) {
            this.rtkReceiverId = rtkReceiverId;
            return this;
        }

        /**
         * GPS Week Number of last baseline 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2
        )
        public final Builder wn(int wn) {
            this.wn = wn;
            return this;
        }

        /**
         * GPS Time of Week of last baseline 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder tow(long tow) {
            this.tow = tow;
            return this;
        }

        /**
         * GPS-specific health report for RTK data. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1
        )
        public final Builder rtkHealth(int rtkHealth) {
            this.rtkHealth = rtkHealth;
            return this;
        }

        /**
         * Rate of baseline messages being received by GPS, in HZ 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1
        )
        public final Builder rtkRate(int rtkRate) {
            this.rtkRate = rtkRate;
            return this;
        }

        /**
         * Current number of sats used for RTK calculation. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1
        )
        public final Builder nsats(int nsats) {
            this.nsats = nsats;
            return this;
        }

        /**
         * Coordinate system of baseline 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 1,
                enumType = RtkBaselineCoordinateSystem.class
        )
        public final Builder baselineCoordsType(
                EnumValue<RtkBaselineCoordinateSystem> baselineCoordsType) {
            this.baselineCoordsType = baselineCoordsType;
            return this;
        }

        /**
         * Coordinate system of baseline 
         */
        public final Builder baselineCoordsType(RtkBaselineCoordinateSystem entry) {
            this.baselineCoordsType = EnumValue.of(entry);
            return this;
        }

        /**
         * Coordinate system of baseline 
         */
        public final Builder baselineCoordsType(Enum... flags) {
            this.baselineCoordsType = EnumValue.create(flags);
            return this;
        }

        /**
         * Current baseline in ECEF x or NED north component in mm. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                signed = true
        )
        public final Builder baselineAMm(int baselineAMm) {
            this.baselineAMm = baselineAMm;
            return this;
        }

        /**
         * Current baseline in ECEF y or NED east component in mm. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                signed = true
        )
        public final Builder baselineBMm(int baselineBMm) {
            this.baselineBMm = baselineBMm;
            return this;
        }

        /**
         * Current baseline in ECEF z or NED down component in mm. 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                signed = true
        )
        public final Builder baselineCMm(int baselineCMm) {
            this.baselineCMm = baselineCMm;
            return this;
        }

        /**
         * Current estimate of baseline accuracy. 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4
        )
        public final Builder accuracy(long accuracy) {
            this.accuracy = accuracy;
            return this;
        }

        /**
         * Current number of integer ambiguity hypotheses. 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 4,
                signed = true
        )
        public final Builder iarNumHypotheses(int iarNumHypotheses) {
            this.iarNumHypotheses = iarNumHypotheses;
            return this;
        }

        public final GpsRtk build() {
            return new GpsRtk(timeLastBaselineMs, rtkReceiverId, wn, tow, rtkHealth, rtkRate, nsats, baselineCoordsType, baselineAMm, baselineBMm, baselineCMm, accuracy, iarNumHypotheses);
        }
    }
}
