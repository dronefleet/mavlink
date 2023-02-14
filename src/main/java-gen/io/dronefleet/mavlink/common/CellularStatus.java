package io.dronefleet.mavlink.common;

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
 * Report current used cellular network status 
 */
@MavlinkMessageInfo(
        id = 334,
        crc = 72,
        description = "Report current used cellular network status"
)
public final class CellularStatus {
    private final EnumValue<CellularStatusFlag> status;

    private final EnumValue<CellularNetworkFailedReason> failureReason;

    private final EnumValue<CellularNetworkRadioType> type;

    private final int quality;

    private final int mcc;

    private final int mnc;

    private final int lac;

    private CellularStatus(EnumValue<CellularStatusFlag> status,
            EnumValue<CellularNetworkFailedReason> failureReason,
            EnumValue<CellularNetworkRadioType> type, int quality, int mcc, int mnc, int lac) {
        this.status = status;
        this.failureReason = failureReason;
        this.type = type;
        this.quality = quality;
        this.mcc = mcc;
        this.mnc = mnc;
        this.lac = lac;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Cellular modem status 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            enumType = CellularStatusFlag.class,
            description = "Cellular modem status"
    )
    public final EnumValue<CellularStatusFlag> status() {
        return this.status;
    }

    /**
     * Failure reason when status in in CELLULAR_STATUS_FLAG_FAILED 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = CellularNetworkFailedReason.class,
            description = "Failure reason when status in in CELLULAR_STATUS_FLAG_FAILED"
    )
    public final EnumValue<CellularNetworkFailedReason> failureReason() {
        return this.failureReason;
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
     * Signal quality in percent. If unknown, set to UINT8_MAX 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "Signal quality in percent. If unknown, set to UINT8_MAX"
    )
    public final int quality() {
        return this.quality;
    }

    /**
     * Mobile country code. If unknown, set to UINT16_MAX 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            description = "Mobile country code. If unknown, set to UINT16_MAX"
    )
    public final int mcc() {
        return this.mcc;
    }

    /**
     * Mobile network code. If unknown, set to UINT16_MAX 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            description = "Mobile network code. If unknown, set to UINT16_MAX"
    )
    public final int mnc() {
        return this.mnc;
    }

    /**
     * Location area code. If unknown, set to 0 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            description = "Location area code. If unknown, set to 0"
    )
    public final int lac() {
        return this.lac;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        CellularStatus other = (CellularStatus)o;
        if (!Objects.deepEquals(status, other.status)) return false;
        if (!Objects.deepEquals(failureReason, other.failureReason)) return false;
        if (!Objects.deepEquals(type, other.type)) return false;
        if (!Objects.deepEquals(quality, other.quality)) return false;
        if (!Objects.deepEquals(mcc, other.mcc)) return false;
        if (!Objects.deepEquals(mnc, other.mnc)) return false;
        if (!Objects.deepEquals(lac, other.lac)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(status);
        result = 31 * result + Objects.hashCode(failureReason);
        result = 31 * result + Objects.hashCode(type);
        result = 31 * result + Objects.hashCode(quality);
        result = 31 * result + Objects.hashCode(mcc);
        result = 31 * result + Objects.hashCode(mnc);
        result = 31 * result + Objects.hashCode(lac);
        return result;
    }

    @Override
    public String toString() {
        return "CellularStatus{status=" + status
                 + ", failureReason=" + failureReason
                 + ", type=" + type
                 + ", quality=" + quality
                 + ", mcc=" + mcc
                 + ", mnc=" + mnc
                 + ", lac=" + lac + "}";
    }

    public static final class Builder {
        private EnumValue<CellularStatusFlag> status;

        private EnumValue<CellularNetworkFailedReason> failureReason;

        private EnumValue<CellularNetworkRadioType> type;

        private int quality;

        private int mcc;

        private int mnc;

        private int lac;

        /**
         * Cellular modem status 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                enumType = CellularStatusFlag.class,
                description = "Cellular modem status"
        )
        public final Builder status(EnumValue<CellularStatusFlag> status) {
            this.status = status;
            return this;
        }

        /**
         * Cellular modem status 
         */
        public final Builder status(CellularStatusFlag entry) {
            return status(EnumValue.of(entry));
        }

        /**
         * Cellular modem status 
         */
        public final Builder status(Enum... flags) {
            return status(EnumValue.create(flags));
        }

        /**
         * Cellular modem status 
         */
        public final Builder status(Collection<Enum> flags) {
            return status(EnumValue.create(flags));
        }

        /**
         * Failure reason when status in in CELLULAR_STATUS_FLAG_FAILED 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                enumType = CellularNetworkFailedReason.class,
                description = "Failure reason when status in in CELLULAR_STATUS_FLAG_FAILED"
        )
        public final Builder failureReason(EnumValue<CellularNetworkFailedReason> failureReason) {
            this.failureReason = failureReason;
            return this;
        }

        /**
         * Failure reason when status in in CELLULAR_STATUS_FLAG_FAILED 
         */
        public final Builder failureReason(CellularNetworkFailedReason entry) {
            return failureReason(EnumValue.of(entry));
        }

        /**
         * Failure reason when status in in CELLULAR_STATUS_FLAG_FAILED 
         */
        public final Builder failureReason(Enum... flags) {
            return failureReason(EnumValue.create(flags));
        }

        /**
         * Failure reason when status in in CELLULAR_STATUS_FLAG_FAILED 
         */
        public final Builder failureReason(Collection<Enum> flags) {
            return failureReason(EnumValue.create(flags));
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
         * Signal quality in percent. If unknown, set to UINT8_MAX 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "Signal quality in percent. If unknown, set to UINT8_MAX"
        )
        public final Builder quality(int quality) {
            this.quality = quality;
            return this;
        }

        /**
         * Mobile country code. If unknown, set to UINT16_MAX 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                description = "Mobile country code. If unknown, set to UINT16_MAX"
        )
        public final Builder mcc(int mcc) {
            this.mcc = mcc;
            return this;
        }

        /**
         * Mobile network code. If unknown, set to UINT16_MAX 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                description = "Mobile network code. If unknown, set to UINT16_MAX"
        )
        public final Builder mnc(int mnc) {
            this.mnc = mnc;
            return this;
        }

        /**
         * Location area code. If unknown, set to 0 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                description = "Location area code. If unknown, set to 0"
        )
        public final Builder lac(int lac) {
            this.lac = lac;
            return this;
        }

        public final CellularStatus build() {
            return new CellularStatus(status, failureReason, type, quality, mcc, mnc, lac);
        }
    }
}
