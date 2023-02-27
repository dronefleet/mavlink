package io.dronefleet.mavlink.storm32;

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
 * Radio link statistics. Should be emitted only by components with component id 
 * MAV_COMP_ID_TELEMETRY_RADIO. Per default, rssi values are in MAVLink units: 0 represents 
 * weakest signal, 254 represents maximum signal; can be changed to dBm with the flag 
 * RADIO_LINK_STATS_FLAGS_RSSI_DBM. 
 */
@MavlinkMessageInfo(
        id = 60046,
        crc = 238,
        description = "Radio link statistics. Should be emitted only by components with component id MAV_COMP_ID_TELEMETRY_RADIO. Per default, rssi values are in MAVLink units: 0 represents weakest signal, 254 represents maximum signal; can be changed to dBm with the flag RADIO_LINK_STATS_FLAGS_RSSI_DBM."
)
public final class RadioLinkStats {
    private final EnumValue<RadioLinkStatsFlags> flags;

    private final int rxLq;

    private final int rxRssi1;

    private final int rxSnr1;

    private final int rxRssi2;

    private final int rxSnr2;

    private final int rxReceiveAntenna;

    private final int rxTransmitAntenna;

    private final int txLq;

    private final int txRssi1;

    private final int txSnr1;

    private final int txRssi2;

    private final int txSnr2;

    private final int txReceiveAntenna;

    private final int txTransmitAntenna;

    private RadioLinkStats(EnumValue<RadioLinkStatsFlags> flags, int rxLq, int rxRssi1, int rxSnr1,
            int rxRssi2, int rxSnr2, int rxReceiveAntenna, int rxTransmitAntenna, int txLq,
            int txRssi1, int txSnr1, int txRssi2, int txSnr2, int txReceiveAntenna,
            int txTransmitAntenna) {
        this.flags = flags;
        this.rxLq = rxLq;
        this.rxRssi1 = rxRssi1;
        this.rxSnr1 = rxSnr1;
        this.rxRssi2 = rxRssi2;
        this.rxSnr2 = rxSnr2;
        this.rxReceiveAntenna = rxReceiveAntenna;
        this.rxTransmitAntenna = rxTransmitAntenna;
        this.txLq = txLq;
        this.txRssi1 = txRssi1;
        this.txSnr1 = txSnr1;
        this.txRssi2 = txRssi2;
        this.txSnr2 = txSnr2;
        this.txReceiveAntenna = txReceiveAntenna;
        this.txTransmitAntenna = txTransmitAntenna;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Radio link statistics flags. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            enumType = RadioLinkStatsFlags.class,
            description = "Radio link statistics flags."
    )
    public final EnumValue<RadioLinkStatsFlags> flags() {
        return this.flags;
    }

    /**
     * Values: 0..100. UINT8_MAX: invalid/unknown. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Values: 0..100. UINT8_MAX: invalid/unknown."
    )
    public final int rxLq() {
        return this.rxLq;
    }

    /**
     * Rssi of antenna1. UINT8_MAX: invalid/unknown. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "Rssi of antenna1. UINT8_MAX: invalid/unknown."
    )
    public final int rxRssi1() {
        return this.rxRssi1;
    }

    /**
     * Noise on antenna1. Radio dependent. INT8_MAX: invalid/unknown. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            signed = true,
            description = "Noise on antenna1. Radio dependent. INT8_MAX: invalid/unknown."
    )
    public final int rxSnr1() {
        return this.rxSnr1;
    }

    /**
     * Rssi of antenna2. UINT8_MAX: ignore/unknown, use rx_rssi1. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            description = "Rssi of antenna2. UINT8_MAX: ignore/unknown, use rx_rssi1."
    )
    public final int rxRssi2() {
        return this.rxRssi2;
    }

    /**
     * Noise on antenna2. Radio dependent. INT8_MAX: ignore/unknown, use rx_snr1. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            signed = true,
            description = "Noise on antenna2. Radio dependent. INT8_MAX: ignore/unknown, use rx_snr1."
    )
    public final int rxSnr2() {
        return this.rxSnr2;
    }

    /**
     * 0: antenna1, 1: antenna2, UINT8_MAX: ignore, no Rx receive diversity, use rx_rssi1, rx_snr1. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1,
            description = "0: antenna1, 1: antenna2, UINT8_MAX: ignore, no Rx receive diversity, use rx_rssi1, rx_snr1."
    )
    public final int rxReceiveAntenna() {
        return this.rxReceiveAntenna;
    }

    /**
     * 0: antenna1, 1: antenna2, UINT8_MAX: ignore, no Rx transmit diversity. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1,
            description = "0: antenna1, 1: antenna2, UINT8_MAX: ignore, no Rx transmit diversity."
    )
    public final int rxTransmitAntenna() {
        return this.rxTransmitAntenna;
    }

    /**
     * Values: 0..100. UINT8_MAX: invalid/unknown. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 1,
            description = "Values: 0..100. UINT8_MAX: invalid/unknown."
    )
    public final int txLq() {
        return this.txLq;
    }

    /**
     * Rssi of antenna1. UINT8_MAX: invalid/unknown. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1,
            description = "Rssi of antenna1. UINT8_MAX: invalid/unknown."
    )
    public final int txRssi1() {
        return this.txRssi1;
    }

    /**
     * Noise on antenna1. Radio dependent. INT8_MAX: invalid/unknown. 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 1,
            signed = true,
            description = "Noise on antenna1. Radio dependent. INT8_MAX: invalid/unknown."
    )
    public final int txSnr1() {
        return this.txSnr1;
    }

    /**
     * Rssi of antenna2. UINT8_MAX: ignore/unknown, use tx_rssi1. 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 1,
            description = "Rssi of antenna2. UINT8_MAX: ignore/unknown, use tx_rssi1."
    )
    public final int txRssi2() {
        return this.txRssi2;
    }

    /**
     * Noise on antenna2. Radio dependent. INT8_MAX: ignore/unknown, use tx_snr1. 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 1,
            signed = true,
            description = "Noise on antenna2. Radio dependent. INT8_MAX: ignore/unknown, use tx_snr1."
    )
    public final int txSnr2() {
        return this.txSnr2;
    }

    /**
     * 0: antenna1, 1: antenna2, UINT8_MAX: ignore, no Tx receive diversity, use tx_rssi1, tx_snr1. 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 1,
            description = "0: antenna1, 1: antenna2, UINT8_MAX: ignore, no Tx receive diversity, use tx_rssi1, tx_snr1."
    )
    public final int txReceiveAntenna() {
        return this.txReceiveAntenna;
    }

    /**
     * 0: antenna1, 1: antenna2, UINT8_MAX: ignore, no Tx transmit diversity. 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 1,
            description = "0: antenna1, 1: antenna2, UINT8_MAX: ignore, no Tx transmit diversity."
    )
    public final int txTransmitAntenna() {
        return this.txTransmitAntenna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        RadioLinkStats other = (RadioLinkStats)o;
        if (!Objects.deepEquals(flags, other.flags)) return false;
        if (!Objects.deepEquals(rxLq, other.rxLq)) return false;
        if (!Objects.deepEquals(rxRssi1, other.rxRssi1)) return false;
        if (!Objects.deepEquals(rxSnr1, other.rxSnr1)) return false;
        if (!Objects.deepEquals(rxRssi2, other.rxRssi2)) return false;
        if (!Objects.deepEquals(rxSnr2, other.rxSnr2)) return false;
        if (!Objects.deepEquals(rxReceiveAntenna, other.rxReceiveAntenna)) return false;
        if (!Objects.deepEquals(rxTransmitAntenna, other.rxTransmitAntenna)) return false;
        if (!Objects.deepEquals(txLq, other.txLq)) return false;
        if (!Objects.deepEquals(txRssi1, other.txRssi1)) return false;
        if (!Objects.deepEquals(txSnr1, other.txSnr1)) return false;
        if (!Objects.deepEquals(txRssi2, other.txRssi2)) return false;
        if (!Objects.deepEquals(txSnr2, other.txSnr2)) return false;
        if (!Objects.deepEquals(txReceiveAntenna, other.txReceiveAntenna)) return false;
        if (!Objects.deepEquals(txTransmitAntenna, other.txTransmitAntenna)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(flags);
        result = 31 * result + Objects.hashCode(rxLq);
        result = 31 * result + Objects.hashCode(rxRssi1);
        result = 31 * result + Objects.hashCode(rxSnr1);
        result = 31 * result + Objects.hashCode(rxRssi2);
        result = 31 * result + Objects.hashCode(rxSnr2);
        result = 31 * result + Objects.hashCode(rxReceiveAntenna);
        result = 31 * result + Objects.hashCode(rxTransmitAntenna);
        result = 31 * result + Objects.hashCode(txLq);
        result = 31 * result + Objects.hashCode(txRssi1);
        result = 31 * result + Objects.hashCode(txSnr1);
        result = 31 * result + Objects.hashCode(txRssi2);
        result = 31 * result + Objects.hashCode(txSnr2);
        result = 31 * result + Objects.hashCode(txReceiveAntenna);
        result = 31 * result + Objects.hashCode(txTransmitAntenna);
        return result;
    }

    @Override
    public String toString() {
        return "RadioLinkStats{flags=" + flags
                 + ", rxLq=" + rxLq
                 + ", rxRssi1=" + rxRssi1
                 + ", rxSnr1=" + rxSnr1
                 + ", rxRssi2=" + rxRssi2
                 + ", rxSnr2=" + rxSnr2
                 + ", rxReceiveAntenna=" + rxReceiveAntenna
                 + ", rxTransmitAntenna=" + rxTransmitAntenna
                 + ", txLq=" + txLq
                 + ", txRssi1=" + txRssi1
                 + ", txSnr1=" + txSnr1
                 + ", txRssi2=" + txRssi2
                 + ", txSnr2=" + txSnr2
                 + ", txReceiveAntenna=" + txReceiveAntenna
                 + ", txTransmitAntenna=" + txTransmitAntenna + "}";
    }

    public static final class Builder {
        private EnumValue<RadioLinkStatsFlags> flags;

        private int rxLq;

        private int rxRssi1;

        private int rxSnr1;

        private int rxRssi2;

        private int rxSnr2;

        private int rxReceiveAntenna;

        private int rxTransmitAntenna;

        private int txLq;

        private int txRssi1;

        private int txSnr1;

        private int txRssi2;

        private int txSnr2;

        private int txReceiveAntenna;

        private int txTransmitAntenna;

        /**
         * Radio link statistics flags. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                enumType = RadioLinkStatsFlags.class,
                description = "Radio link statistics flags."
        )
        public final Builder flags(EnumValue<RadioLinkStatsFlags> flags) {
            this.flags = flags;
            return this;
        }

        /**
         * Radio link statistics flags. 
         */
        public final Builder flags(RadioLinkStatsFlags entry) {
            return flags(EnumValue.of(entry));
        }

        /**
         * Radio link statistics flags. 
         */
        public final Builder flags(Enum... flags) {
            return flags(EnumValue.create(flags));
        }

        /**
         * Radio link statistics flags. 
         */
        public final Builder flags(Collection<Enum> flags) {
            return flags(EnumValue.create(flags));
        }

        /**
         * Values: 0..100. UINT8_MAX: invalid/unknown. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Values: 0..100. UINT8_MAX: invalid/unknown."
        )
        public final Builder rxLq(int rxLq) {
            this.rxLq = rxLq;
            return this;
        }

        /**
         * Rssi of antenna1. UINT8_MAX: invalid/unknown. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "Rssi of antenna1. UINT8_MAX: invalid/unknown."
        )
        public final Builder rxRssi1(int rxRssi1) {
            this.rxRssi1 = rxRssi1;
            return this;
        }

        /**
         * Noise on antenna1. Radio dependent. INT8_MAX: invalid/unknown. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                signed = true,
                description = "Noise on antenna1. Radio dependent. INT8_MAX: invalid/unknown."
        )
        public final Builder rxSnr1(int rxSnr1) {
            this.rxSnr1 = rxSnr1;
            return this;
        }

        /**
         * Rssi of antenna2. UINT8_MAX: ignore/unknown, use rx_rssi1. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                description = "Rssi of antenna2. UINT8_MAX: ignore/unknown, use rx_rssi1."
        )
        public final Builder rxRssi2(int rxRssi2) {
            this.rxRssi2 = rxRssi2;
            return this;
        }

        /**
         * Noise on antenna2. Radio dependent. INT8_MAX: ignore/unknown, use rx_snr1. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                signed = true,
                description = "Noise on antenna2. Radio dependent. INT8_MAX: ignore/unknown, use rx_snr1."
        )
        public final Builder rxSnr2(int rxSnr2) {
            this.rxSnr2 = rxSnr2;
            return this;
        }

        /**
         * 0: antenna1, 1: antenna2, UINT8_MAX: ignore, no Rx receive diversity, use rx_rssi1, rx_snr1. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1,
                description = "0: antenna1, 1: antenna2, UINT8_MAX: ignore, no Rx receive diversity, use rx_rssi1, rx_snr1."
        )
        public final Builder rxReceiveAntenna(int rxReceiveAntenna) {
            this.rxReceiveAntenna = rxReceiveAntenna;
            return this;
        }

        /**
         * 0: antenna1, 1: antenna2, UINT8_MAX: ignore, no Rx transmit diversity. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 1,
                description = "0: antenna1, 1: antenna2, UINT8_MAX: ignore, no Rx transmit diversity."
        )
        public final Builder rxTransmitAntenna(int rxTransmitAntenna) {
            this.rxTransmitAntenna = rxTransmitAntenna;
            return this;
        }

        /**
         * Values: 0..100. UINT8_MAX: invalid/unknown. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 1,
                description = "Values: 0..100. UINT8_MAX: invalid/unknown."
        )
        public final Builder txLq(int txLq) {
            this.txLq = txLq;
            return this;
        }

        /**
         * Rssi of antenna1. UINT8_MAX: invalid/unknown. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 1,
                description = "Rssi of antenna1. UINT8_MAX: invalid/unknown."
        )
        public final Builder txRssi1(int txRssi1) {
            this.txRssi1 = txRssi1;
            return this;
        }

        /**
         * Noise on antenna1. Radio dependent. INT8_MAX: invalid/unknown. 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 1,
                signed = true,
                description = "Noise on antenna1. Radio dependent. INT8_MAX: invalid/unknown."
        )
        public final Builder txSnr1(int txSnr1) {
            this.txSnr1 = txSnr1;
            return this;
        }

        /**
         * Rssi of antenna2. UINT8_MAX: ignore/unknown, use tx_rssi1. 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 1,
                description = "Rssi of antenna2. UINT8_MAX: ignore/unknown, use tx_rssi1."
        )
        public final Builder txRssi2(int txRssi2) {
            this.txRssi2 = txRssi2;
            return this;
        }

        /**
         * Noise on antenna2. Radio dependent. INT8_MAX: ignore/unknown, use tx_snr1. 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 1,
                signed = true,
                description = "Noise on antenna2. Radio dependent. INT8_MAX: ignore/unknown, use tx_snr1."
        )
        public final Builder txSnr2(int txSnr2) {
            this.txSnr2 = txSnr2;
            return this;
        }

        /**
         * 0: antenna1, 1: antenna2, UINT8_MAX: ignore, no Tx receive diversity, use tx_rssi1, tx_snr1. 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 1,
                description = "0: antenna1, 1: antenna2, UINT8_MAX: ignore, no Tx receive diversity, use tx_rssi1, tx_snr1."
        )
        public final Builder txReceiveAntenna(int txReceiveAntenna) {
            this.txReceiveAntenna = txReceiveAntenna;
            return this;
        }

        /**
         * 0: antenna1, 1: antenna2, UINT8_MAX: ignore, no Tx transmit diversity. 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 1,
                description = "0: antenna1, 1: antenna2, UINT8_MAX: ignore, no Tx transmit diversity."
        )
        public final Builder txTransmitAntenna(int txTransmitAntenna) {
            this.txTransmitAntenna = txTransmitAntenna;
            return this;
        }

        public final RadioLinkStats build() {
            return new RadioLinkStats(flags, rxLq, rxRssi1, rxSnr1, rxRssi2, rxSnr2, rxReceiveAntenna, rxTransmitAntenna, txLq, txRssi1, txSnr1, txRssi2, txSnr2, txReceiveAntenna, txTransmitAntenna);
        }
    }
}
