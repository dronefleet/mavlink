package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Deprecated;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * Report current used cellular network status 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 334,
        crc = 135,
        description = "Report current used cellular network status",
        workInProgress = true
)
@Deprecated
public final class CellularStatus {
    private final EnumValue<CellularNetworkStatusFlag> status;

    private final EnumValue<CellularNetworkRadioType> type;

    private final int quality;

    private final int mcc;

    private final int mnc;

    private final int lac;

    private final long cid;

    private CellularStatus(EnumValue<CellularNetworkStatusFlag> status,
            EnumValue<CellularNetworkRadioType> type, int quality, int mcc, int mnc, int lac,
            long cid) {
        this.status = status;
        this.type = type;
        this.quality = quality;
        this.mcc = mcc;
        this.mnc = mnc;
        this.lac = lac;
        this.cid = cid;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Status bitmap 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            enumType = CellularNetworkStatusFlag.class,
            description = "Status bitmap"
    )
    public final EnumValue<CellularNetworkStatusFlag> status() {
        return this.status;
    }

    /**
     * Cellular network radio type: gsm, cdma, lte... 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            enumType = CellularNetworkRadioType.class,
            description = "Cellular network radio type: gsm, cdma, lte..."
    )
    public final EnumValue<CellularNetworkRadioType> type() {
        return this.type;
    }

    /**
     * Cellular network RSSI/RSRP in dBm, absolute value 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "Cellular network RSSI/RSRP in dBm, absolute value"
    )
    public final int quality() {
        return this.quality;
    }

    /**
     * Mobile country code. If unknown, set to: UINT16_MAX 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            description = "Mobile country code. If unknown, set to: UINT16_MAX"
    )
    public final int mcc() {
        return this.mcc;
    }

    /**
     * Mobile network code. If unknown, set to: UINT16_MAX 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            description = "Mobile network code. If unknown, set to: UINT16_MAX"
    )
    public final int mnc() {
        return this.mnc;
    }

    /**
     * Location area code. If unknown, set to: 0 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            description = "Location area code. If unknown, set to: 0"
    )
    public final int lac() {
        return this.lac;
    }

    /**
     * Cell ID. If unknown, set to: UINT32_MAX 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Cell ID. If unknown, set to: UINT32_MAX"
    )
    public final long cid() {
        return this.cid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        CellularStatus other = (CellularStatus)o;
        if (!Objects.deepEquals(status, other.status)) return false;
        if (!Objects.deepEquals(type, other.type)) return false;
        if (!Objects.deepEquals(quality, other.quality)) return false;
        if (!Objects.deepEquals(mcc, other.mcc)) return false;
        if (!Objects.deepEquals(mnc, other.mnc)) return false;
        if (!Objects.deepEquals(lac, other.lac)) return false;
        if (!Objects.deepEquals(cid, other.cid)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(status);
        result = 31 * result + Objects.hashCode(type);
        result = 31 * result + Objects.hashCode(quality);
        result = 31 * result + Objects.hashCode(mcc);
        result = 31 * result + Objects.hashCode(mnc);
        result = 31 * result + Objects.hashCode(lac);
        result = 31 * result + Objects.hashCode(cid);
        return result;
    }

    @Override
    public String toString() {
        return "CellularStatus{status=" + status
                 + ", type=" + type
                 + ", quality=" + quality
                 + ", mcc=" + mcc
                 + ", mnc=" + mnc
                 + ", lac=" + lac
                 + ", cid=" + cid + "}";
    }

    public static final class Builder {
        private EnumValue<CellularNetworkStatusFlag> status;

        private EnumValue<CellularNetworkRadioType> type;

        private int quality;

        private int mcc;

        private int mnc;

        private int lac;

        private long cid;

        /**
         * Status bitmap 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                enumType = CellularNetworkStatusFlag.class,
                description = "Status bitmap"
        )
        public final Builder status(EnumValue<CellularNetworkStatusFlag> status) {
            this.status = status;
            return this;
        }

        /**
         * Status bitmap 
         */
        public final Builder status(CellularNetworkStatusFlag entry) {
            return status(EnumValue.of(entry));
        }

        /**
         * Status bitmap 
         */
        public final Builder status(Enum... flags) {
            return status(EnumValue.create(flags));
        }

        /**
         * Status bitmap 
         */
        public final Builder status(Collection<Enum> flags) {
            return status(EnumValue.create(flags));
        }

        /**
         * Cellular network radio type: gsm, cdma, lte... 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                enumType = CellularNetworkRadioType.class,
                description = "Cellular network radio type: gsm, cdma, lte..."
        )
        public final Builder type(EnumValue<CellularNetworkRadioType> type) {
            this.type = type;
            return this;
        }

        /**
         * Cellular network radio type: gsm, cdma, lte... 
         */
        public final Builder type(CellularNetworkRadioType entry) {
            return type(EnumValue.of(entry));
        }

        /**
         * Cellular network radio type: gsm, cdma, lte... 
         */
        public final Builder type(Enum... flags) {
            return type(EnumValue.create(flags));
        }

        /**
         * Cellular network radio type: gsm, cdma, lte... 
         */
        public final Builder type(Collection<Enum> flags) {
            return type(EnumValue.create(flags));
        }

        /**
         * Cellular network RSSI/RSRP in dBm, absolute value 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "Cellular network RSSI/RSRP in dBm, absolute value"
        )
        public final Builder quality(int quality) {
            this.quality = quality;
            return this;
        }

        /**
         * Mobile country code. If unknown, set to: UINT16_MAX 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                description = "Mobile country code. If unknown, set to: UINT16_MAX"
        )
        public final Builder mcc(int mcc) {
            this.mcc = mcc;
            return this;
        }

        /**
         * Mobile network code. If unknown, set to: UINT16_MAX 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                description = "Mobile network code. If unknown, set to: UINT16_MAX"
        )
        public final Builder mnc(int mnc) {
            this.mnc = mnc;
            return this;
        }

        /**
         * Location area code. If unknown, set to: 0 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                description = "Location area code. If unknown, set to: 0"
        )
        public final Builder lac(int lac) {
            this.lac = lac;
            return this;
        }

        /**
         * Cell ID. If unknown, set to: UINT32_MAX 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Cell ID. If unknown, set to: UINT32_MAX"
        )
        public final Builder cid(long cid) {
            this.cid = cid;
            return this;
        }

        public final CellularStatus build() {
            return new CellularStatus(status, type, quality, mcc, mnc, lac, cid);
        }
    }
}
