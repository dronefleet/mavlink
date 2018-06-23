package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * RTK GPS data. Gives information on the relative baseline calculation the GPS is reporting 
 */
@MavlinkMessageInfo(
        id = 127,
        crc = 25
)
public final class GpsRtk {
    /**
     * Time since boot of last baseline message received in ms. 
     */
    private final long timeLastBaselineMs;

    /**
     * GPS Time of Week of last baseline 
     */
    private final long tow;

    /**
     * Current baseline in ECEF x or NED north component in mm. 
     */
    private final int baselineAMm;

    /**
     * Current baseline in ECEF y or NED east component in mm. 
     */
    private final int baselineBMm;

    /**
     * Current baseline in ECEF z or NED down component in mm. 
     */
    private final int baselineCMm;

    /**
     * Current estimate of baseline accuracy. 
     */
    private final long accuracy;

    /**
     * Current number of integer ambiguity hypotheses. 
     */
    private final int iarNumHypotheses;

    /**
     * GPS Week Number of last baseline 
     */
    private final int wn;

    /**
     * Identification of connected RTK receiver. 
     */
    private final int rtkReceiverId;

    /**
     * GPS-specific health report for RTK data. 
     */
    private final int rtkHealth;

    /**
     * Rate of baseline messages being received by GPS, in HZ 
     */
    private final int rtkRate;

    /**
     * Current number of sats used for RTK calculation. 
     */
    private final int nsats;

    /**
     * Coordinate system of baseline 
     */
    private final RtkBaselineCoordinateSystem baselineCoordsType;

    private GpsRtk(long timeLastBaselineMs, long tow, int baselineAMm, int baselineBMm,
            int baselineCMm, long accuracy, int iarNumHypotheses, int wn, int rtkReceiverId,
            int rtkHealth, int rtkRate, int nsats, RtkBaselineCoordinateSystem baselineCoordsType) {
        this.timeLastBaselineMs = timeLastBaselineMs;
        this.tow = tow;
        this.baselineAMm = baselineAMm;
        this.baselineBMm = baselineBMm;
        this.baselineCMm = baselineCMm;
        this.accuracy = accuracy;
        this.iarNumHypotheses = iarNumHypotheses;
        this.wn = wn;
        this.rtkReceiverId = rtkReceiverId;
        this.rtkHealth = rtkHealth;
        this.rtkRate = rtkRate;
        this.nsats = nsats;
        this.baselineCoordsType = baselineCoordsType;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
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

    /**
     * Time since boot of last baseline message received in ms. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final long timeLastBaselineMs() {
        return timeLastBaselineMs;
    }

    /**
     * GPS Time of Week of last baseline 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final long tow() {
        return tow;
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
        return baselineAMm;
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
        return baselineBMm;
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
        return baselineCMm;
    }

    /**
     * Current estimate of baseline accuracy. 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4
    )
    public final long accuracy() {
        return accuracy;
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
        return iarNumHypotheses;
    }

    /**
     * GPS Week Number of last baseline 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2
    )
    public final int wn() {
        return wn;
    }

    /**
     * Identification of connected RTK receiver. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int rtkReceiverId() {
        return rtkReceiverId;
    }

    /**
     * GPS-specific health report for RTK data. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final int rtkHealth() {
        return rtkHealth;
    }

    /**
     * Rate of baseline messages being received by GPS, in HZ 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1
    )
    public final int rtkRate() {
        return rtkRate;
    }

    /**
     * Current number of sats used for RTK calculation. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1
    )
    public final int nsats() {
        return nsats;
    }

    /**
     * Coordinate system of baseline 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1
    )
    public final RtkBaselineCoordinateSystem baselineCoordsType() {
        return baselineCoordsType;
    }

    public static class Builder {
        private long timeLastBaselineMs;

        private long tow;

        private int baselineAMm;

        private int baselineBMm;

        private int baselineCMm;

        private long accuracy;

        private int iarNumHypotheses;

        private int wn;

        private int rtkReceiverId;

        private int rtkHealth;

        private int rtkRate;

        private int nsats;

        private RtkBaselineCoordinateSystem baselineCoordsType;

        private Builder() {
        }

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
                unitSize = 1
        )
        public final Builder baselineCoordsType(RtkBaselineCoordinateSystem baselineCoordsType) {
            this.baselineCoordsType = baselineCoordsType;
            return this;
        }

        public final GpsRtk build() {
            return new GpsRtk(timeLastBaselineMs, tow, baselineAMm, baselineBMm, baselineCMm, accuracy, iarNumHypotheses, wn, rtkReceiverId, rtkHealth, rtkRate, nsats, baselineCoordsType);
        }
    }
}
