package io.dronefleet.mavlink.avssuas;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * AVSS PRS system status. 
 */
@MavlinkMessageInfo(
        id = 60050,
        crc = 220,
        description = "AVSS PRS system status."
)
public final class AvssPrsSysStatus {
    private final long timeBootMs;

    private final long errorStatus;

    private final long batteryStatus;

    private final int armStatus;

    private final int chargeStatus;

    private AvssPrsSysStatus(long timeBootMs, long errorStatus, long batteryStatus, int armStatus,
            int chargeStatus) {
        this.timeBootMs = timeBootMs;
        this.errorStatus = errorStatus;
        this.batteryStatus = batteryStatus;
        this.armStatus = armStatus;
        this.chargeStatus = chargeStatus;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (time since PRS boot). 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Timestamp (time since PRS boot)."
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * PRS error statuses 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "PRS error statuses"
    )
    public final long errorStatus() {
        return this.errorStatus;
    }

    /**
     * Estimated battery run-time without a remote connection and PRS battery voltage 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Estimated battery run-time without a remote connection and PRS battery voltage"
    )
    public final long batteryStatus() {
        return this.batteryStatus;
    }

    /**
     * PRS arm statuses 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "PRS arm statuses"
    )
    public final int armStatus() {
        return this.armStatus;
    }

    /**
     * PRS battery charge statuses 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            description = "PRS battery charge statuses"
    )
    public final int chargeStatus() {
        return this.chargeStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        AvssPrsSysStatus other = (AvssPrsSysStatus)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(errorStatus, other.errorStatus)) return false;
        if (!Objects.deepEquals(batteryStatus, other.batteryStatus)) return false;
        if (!Objects.deepEquals(armStatus, other.armStatus)) return false;
        if (!Objects.deepEquals(chargeStatus, other.chargeStatus)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(errorStatus);
        result = 31 * result + Objects.hashCode(batteryStatus);
        result = 31 * result + Objects.hashCode(armStatus);
        result = 31 * result + Objects.hashCode(chargeStatus);
        return result;
    }

    @Override
    public String toString() {
        return "AvssPrsSysStatus{timeBootMs=" + timeBootMs
                 + ", errorStatus=" + errorStatus
                 + ", batteryStatus=" + batteryStatus
                 + ", armStatus=" + armStatus
                 + ", chargeStatus=" + chargeStatus + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private long errorStatus;

        private long batteryStatus;

        private int armStatus;

        private int chargeStatus;

        /**
         * Timestamp (time since PRS boot). 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Timestamp (time since PRS boot)."
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * PRS error statuses 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "PRS error statuses"
        )
        public final Builder errorStatus(long errorStatus) {
            this.errorStatus = errorStatus;
            return this;
        }

        /**
         * Estimated battery run-time without a remote connection and PRS battery voltage 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Estimated battery run-time without a remote connection and PRS battery voltage"
        )
        public final Builder batteryStatus(long batteryStatus) {
            this.batteryStatus = batteryStatus;
            return this;
        }

        /**
         * PRS arm statuses 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "PRS arm statuses"
        )
        public final Builder armStatus(int armStatus) {
            this.armStatus = armStatus;
            return this;
        }

        /**
         * PRS battery charge statuses 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                description = "PRS battery charge statuses"
        )
        public final Builder chargeStatus(int chargeStatus) {
            this.chargeStatus = chargeStatus;
            return this;
        }

        public final AvssPrsSysStatus build() {
            return new AvssPrsSysStatus(timeBootMs, errorStatus, batteryStatus, armStatus, chargeStatus);
        }
    }
}
