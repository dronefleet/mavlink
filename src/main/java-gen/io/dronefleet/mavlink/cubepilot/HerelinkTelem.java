package io.dronefleet.mavlink.cubepilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Herelink Telemetry 
 */
@MavlinkMessageInfo(
        id = 50003,
        crc = 62,
        description = "Herelink Telemetry"
)
public final class HerelinkTelem {
    private final int rssi;

    private final int snr;

    private final long rfFreq;

    private final long linkBw;

    private final long linkRate;

    private final int cpuTemp;

    private final int boardTemp;

    private HerelinkTelem(int rssi, int snr, long rfFreq, long linkBw, long linkRate, int cpuTemp,
            int boardTemp) {
        this.rssi = rssi;
        this.snr = snr;
        this.rfFreq = rfFreq;
        this.linkBw = linkBw;
        this.linkRate = linkRate;
        this.cpuTemp = cpuTemp;
        this.boardTemp = boardTemp;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     *  
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int rssi() {
        return this.rssi;
    }

    /**
     *  
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            signed = true
    )
    public final int snr() {
        return this.snr;
    }

    /**
     *  
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final long rfFreq() {
        return this.rfFreq;
    }

    /**
     *  
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final long linkBw() {
        return this.linkBw;
    }

    /**
     *  
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final long linkRate() {
        return this.linkRate;
    }

    /**
     *  
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            signed = true
    )
    public final int cpuTemp() {
        return this.cpuTemp;
    }

    /**
     *  
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            signed = true
    )
    public final int boardTemp() {
        return this.boardTemp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        HerelinkTelem other = (HerelinkTelem)o;
        if (!Objects.deepEquals(rssi, other.rssi)) return false;
        if (!Objects.deepEquals(snr, other.snr)) return false;
        if (!Objects.deepEquals(rfFreq, other.rfFreq)) return false;
        if (!Objects.deepEquals(linkBw, other.linkBw)) return false;
        if (!Objects.deepEquals(linkRate, other.linkRate)) return false;
        if (!Objects.deepEquals(cpuTemp, other.cpuTemp)) return false;
        if (!Objects.deepEquals(boardTemp, other.boardTemp)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(rssi);
        result = 31 * result + Objects.hashCode(snr);
        result = 31 * result + Objects.hashCode(rfFreq);
        result = 31 * result + Objects.hashCode(linkBw);
        result = 31 * result + Objects.hashCode(linkRate);
        result = 31 * result + Objects.hashCode(cpuTemp);
        result = 31 * result + Objects.hashCode(boardTemp);
        return result;
    }

    @Override
    public String toString() {
        return "HerelinkTelem{rssi=" + rssi
                 + ", snr=" + snr
                 + ", rfFreq=" + rfFreq
                 + ", linkBw=" + linkBw
                 + ", linkRate=" + linkRate
                 + ", cpuTemp=" + cpuTemp
                 + ", boardTemp=" + boardTemp + "}";
    }

    public static final class Builder {
        private int rssi;

        private int snr;

        private long rfFreq;

        private long linkBw;

        private long linkRate;

        private int cpuTemp;

        private int boardTemp;

        /**
         *  
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder rssi(int rssi) {
            this.rssi = rssi;
            return this;
        }

        /**
         *  
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                signed = true
        )
        public final Builder snr(int snr) {
            this.snr = snr;
            return this;
        }

        /**
         *  
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder rfFreq(long rfFreq) {
            this.rfFreq = rfFreq;
            return this;
        }

        /**
         *  
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder linkBw(long linkBw) {
            this.linkBw = linkBw;
            return this;
        }

        /**
         *  
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder linkRate(long linkRate) {
            this.linkRate = linkRate;
            return this;
        }

        /**
         *  
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                signed = true
        )
        public final Builder cpuTemp(int cpuTemp) {
            this.cpuTemp = cpuTemp;
            return this;
        }

        /**
         *  
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                signed = true
        )
        public final Builder boardTemp(int boardTemp) {
            this.boardTemp = boardTemp;
            return this;
        }

        public final HerelinkTelem build() {
            return new HerelinkTelem(rssi, snr, rfFreq, linkBw, linkRate, cpuTemp, boardTemp);
        }
    }
}
