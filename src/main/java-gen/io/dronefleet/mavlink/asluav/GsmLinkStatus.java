package io.dronefleet.mavlink.asluav;

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
 * Status of GSM modem (connected to onboard computer) 
 */
@MavlinkMessageInfo(
        id = 213,
        crc = 200,
        description = "Status of GSM modem (connected to onboard computer)"
)
public final class GsmLinkStatus {
    private final BigInteger timestamp;

    private final EnumValue<GsmModemType> gsmModemType;

    private final EnumValue<GsmLinkType> gsmLinkType;

    private final int rssi;

    private final int rsrpRscp;

    private final int sinrEcio;

    private final int rsrq;

    private GsmLinkStatus(BigInteger timestamp, EnumValue<GsmModemType> gsmModemType,
            EnumValue<GsmLinkType> gsmLinkType, int rssi, int rsrpRscp, int sinrEcio, int rsrq) {
        this.timestamp = timestamp;
        this.gsmModemType = gsmModemType;
        this.gsmLinkType = gsmLinkType;
        this.rssi = rssi;
        this.rsrpRscp = rsrpRscp;
        this.sinrEcio = sinrEcio;
        this.rsrq = rsrq;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (of OBC) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            description = "Timestamp (of OBC)"
    )
    public final BigInteger timestamp() {
        return this.timestamp;
    }

    /**
     * GSM modem used 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = GsmModemType.class,
            description = "GSM modem used"
    )
    public final EnumValue<GsmModemType> gsmModemType() {
        return this.gsmModemType;
    }

    /**
     * GSM link type 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            enumType = GsmLinkType.class,
            description = "GSM link type"
    )
    public final EnumValue<GsmLinkType> gsmLinkType() {
        return this.gsmLinkType;
    }

    /**
     * RSSI as reported by modem (unconverted) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "RSSI as reported by modem (unconverted)"
    )
    public final int rssi() {
        return this.rssi;
    }

    /**
     * RSRP (LTE) or RSCP (WCDMA) as reported by modem (unconverted) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            description = "RSRP (LTE) or RSCP (WCDMA) as reported by modem (unconverted)"
    )
    public final int rsrpRscp() {
        return this.rsrpRscp;
    }

    /**
     * SINR (LTE) or ECIO (WCDMA) as reported by modem (unconverted) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            description = "SINR (LTE) or ECIO (WCDMA) as reported by modem (unconverted)"
    )
    public final int sinrEcio() {
        return this.sinrEcio;
    }

    /**
     * RSRQ (LTE only) as reported by modem (unconverted) 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1,
            description = "RSRQ (LTE only) as reported by modem (unconverted)"
    )
    public final int rsrq() {
        return this.rsrq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        GsmLinkStatus other = (GsmLinkStatus)o;
        if (!Objects.deepEquals(timestamp, other.timestamp)) return false;
        if (!Objects.deepEquals(gsmModemType, other.gsmModemType)) return false;
        if (!Objects.deepEquals(gsmLinkType, other.gsmLinkType)) return false;
        if (!Objects.deepEquals(rssi, other.rssi)) return false;
        if (!Objects.deepEquals(rsrpRscp, other.rsrpRscp)) return false;
        if (!Objects.deepEquals(sinrEcio, other.sinrEcio)) return false;
        if (!Objects.deepEquals(rsrq, other.rsrq)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timestamp);
        result = 31 * result + Objects.hashCode(gsmModemType);
        result = 31 * result + Objects.hashCode(gsmLinkType);
        result = 31 * result + Objects.hashCode(rssi);
        result = 31 * result + Objects.hashCode(rsrpRscp);
        result = 31 * result + Objects.hashCode(sinrEcio);
        result = 31 * result + Objects.hashCode(rsrq);
        return result;
    }

    @Override
    public String toString() {
        return "GsmLinkStatus{timestamp=" + timestamp
                 + ", gsmModemType=" + gsmModemType
                 + ", gsmLinkType=" + gsmLinkType
                 + ", rssi=" + rssi
                 + ", rsrpRscp=" + rsrpRscp
                 + ", sinrEcio=" + sinrEcio
                 + ", rsrq=" + rsrq + "}";
    }

    public static final class Builder {
        private BigInteger timestamp;

        private EnumValue<GsmModemType> gsmModemType;

        private EnumValue<GsmLinkType> gsmLinkType;

        private int rssi;

        private int rsrpRscp;

        private int sinrEcio;

        private int rsrq;

        /**
         * Timestamp (of OBC) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                description = "Timestamp (of OBC)"
        )
        public final Builder timestamp(BigInteger timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        /**
         * GSM modem used 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                enumType = GsmModemType.class,
                description = "GSM modem used"
        )
        public final Builder gsmModemType(EnumValue<GsmModemType> gsmModemType) {
            this.gsmModemType = gsmModemType;
            return this;
        }

        /**
         * GSM modem used 
         */
        public final Builder gsmModemType(GsmModemType entry) {
            return gsmModemType(EnumValue.of(entry));
        }

        /**
         * GSM modem used 
         */
        public final Builder gsmModemType(Enum... flags) {
            return gsmModemType(EnumValue.create(flags));
        }

        /**
         * GSM modem used 
         */
        public final Builder gsmModemType(Collection<Enum> flags) {
            return gsmModemType(EnumValue.create(flags));
        }

        /**
         * GSM link type 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                enumType = GsmLinkType.class,
                description = "GSM link type"
        )
        public final Builder gsmLinkType(EnumValue<GsmLinkType> gsmLinkType) {
            this.gsmLinkType = gsmLinkType;
            return this;
        }

        /**
         * GSM link type 
         */
        public final Builder gsmLinkType(GsmLinkType entry) {
            return gsmLinkType(EnumValue.of(entry));
        }

        /**
         * GSM link type 
         */
        public final Builder gsmLinkType(Enum... flags) {
            return gsmLinkType(EnumValue.create(flags));
        }

        /**
         * GSM link type 
         */
        public final Builder gsmLinkType(Collection<Enum> flags) {
            return gsmLinkType(EnumValue.create(flags));
        }

        /**
         * RSSI as reported by modem (unconverted) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "RSSI as reported by modem (unconverted)"
        )
        public final Builder rssi(int rssi) {
            this.rssi = rssi;
            return this;
        }

        /**
         * RSRP (LTE) or RSCP (WCDMA) as reported by modem (unconverted) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                description = "RSRP (LTE) or RSCP (WCDMA) as reported by modem (unconverted)"
        )
        public final Builder rsrpRscp(int rsrpRscp) {
            this.rsrpRscp = rsrpRscp;
            return this;
        }

        /**
         * SINR (LTE) or ECIO (WCDMA) as reported by modem (unconverted) 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                description = "SINR (LTE) or ECIO (WCDMA) as reported by modem (unconverted)"
        )
        public final Builder sinrEcio(int sinrEcio) {
            this.sinrEcio = sinrEcio;
            return this;
        }

        /**
         * RSRQ (LTE only) as reported by modem (unconverted) 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1,
                description = "RSRQ (LTE only) as reported by modem (unconverted)"
        )
        public final Builder rsrq(int rsrq) {
            this.rsrq = rsrq;
            return this;
        }

        public final GsmLinkStatus build() {
            return new GsmLinkStatus(timestamp, gsmModemType, gsmLinkType, rssi, rsrpRscp, sinrEcio, rsrq);
        }
    }
}
