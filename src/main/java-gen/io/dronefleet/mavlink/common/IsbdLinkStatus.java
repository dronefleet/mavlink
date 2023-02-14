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
 * Status of the Iridium SBD link. 
 */
@MavlinkMessageInfo(
        id = 335,
        crc = 225,
        description = "Status of the Iridium SBD link."
)
public final class IsbdLinkStatus {
    private final BigInteger timestamp;

    private final BigInteger lastHeartbeat;

    private final int failedSessions;

    private final int successfulSessions;

    private final int signalQuality;

    private final int ringPending;

    private final int txSessionPending;

    private final int rxSessionPending;

    private IsbdLinkStatus(BigInteger timestamp, BigInteger lastHeartbeat, int failedSessions,
            int successfulSessions, int signalQuality, int ringPending, int txSessionPending,
            int rxSessionPending) {
        this.timestamp = timestamp;
        this.lastHeartbeat = lastHeartbeat;
        this.failedSessions = failedSessions;
        this.successfulSessions = successfulSessions;
        this.signalQuality = signalQuality;
        this.ringPending = ringPending;
        this.txSessionPending = txSessionPending;
        this.rxSessionPending = rxSessionPending;
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
     * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
    )
    public final BigInteger timestamp() {
        return this.timestamp;
    }

    /**
     * Timestamp of the last successful sbd session. The receiving end can infer timestamp format 
     * (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 8,
            description = "Timestamp of the last successful sbd session. The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
    )
    public final BigInteger lastHeartbeat() {
        return this.lastHeartbeat;
    }

    /**
     * Number of failed SBD sessions. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            description = "Number of failed SBD sessions."
    )
    public final int failedSessions() {
        return this.failedSessions;
    }

    /**
     * Number of successful SBD sessions. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            description = "Number of successful SBD sessions."
    )
    public final int successfulSessions() {
        return this.successfulSessions;
    }

    /**
     * Signal quality equal to the number of bars displayed on the ISU signal strength indicator. 
     * Range is 0 to 5, where 0 indicates no signal and 5 indicates maximum signal strength. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            description = "Signal quality equal to the number of bars displayed on the ISU signal strength indicator. Range is 0 to 5, where 0 indicates no signal and 5 indicates maximum signal strength."
    )
    public final int signalQuality() {
        return this.signalQuality;
    }

    /**
     * 1: Ring call pending, 0: No call pending. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            description = "1: Ring call pending, 0: No call pending."
    )
    public final int ringPending() {
        return this.ringPending;
    }

    /**
     * 1: Transmission session pending, 0: No transmission session pending. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1,
            description = "1: Transmission session pending, 0: No transmission session pending."
    )
    public final int txSessionPending() {
        return this.txSessionPending;
    }

    /**
     * 1: Receiving session pending, 0: No receiving session pending. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1,
            description = "1: Receiving session pending, 0: No receiving session pending."
    )
    public final int rxSessionPending() {
        return this.rxSessionPending;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        IsbdLinkStatus other = (IsbdLinkStatus)o;
        if (!Objects.deepEquals(timestamp, other.timestamp)) return false;
        if (!Objects.deepEquals(lastHeartbeat, other.lastHeartbeat)) return false;
        if (!Objects.deepEquals(failedSessions, other.failedSessions)) return false;
        if (!Objects.deepEquals(successfulSessions, other.successfulSessions)) return false;
        if (!Objects.deepEquals(signalQuality, other.signalQuality)) return false;
        if (!Objects.deepEquals(ringPending, other.ringPending)) return false;
        if (!Objects.deepEquals(txSessionPending, other.txSessionPending)) return false;
        if (!Objects.deepEquals(rxSessionPending, other.rxSessionPending)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timestamp);
        result = 31 * result + Objects.hashCode(lastHeartbeat);
        result = 31 * result + Objects.hashCode(failedSessions);
        result = 31 * result + Objects.hashCode(successfulSessions);
        result = 31 * result + Objects.hashCode(signalQuality);
        result = 31 * result + Objects.hashCode(ringPending);
        result = 31 * result + Objects.hashCode(txSessionPending);
        result = 31 * result + Objects.hashCode(rxSessionPending);
        return result;
    }

    @Override
    public String toString() {
        return "IsbdLinkStatus{timestamp=" + timestamp
                 + ", lastHeartbeat=" + lastHeartbeat
                 + ", failedSessions=" + failedSessions
                 + ", successfulSessions=" + successfulSessions
                 + ", signalQuality=" + signalQuality
                 + ", ringPending=" + ringPending
                 + ", txSessionPending=" + txSessionPending
                 + ", rxSessionPending=" + rxSessionPending + "}";
    }

    public static final class Builder {
        private BigInteger timestamp;

        private BigInteger lastHeartbeat;

        private int failedSessions;

        private int successfulSessions;

        private int signalQuality;

        private int ringPending;

        private int txSessionPending;

        private int rxSessionPending;

        /**
         * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
         * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
        )
        public final Builder timestamp(BigInteger timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        /**
         * Timestamp of the last successful sbd session. The receiving end can infer timestamp format 
         * (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 8,
                description = "Timestamp of the last successful sbd session. The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
        )
        public final Builder lastHeartbeat(BigInteger lastHeartbeat) {
            this.lastHeartbeat = lastHeartbeat;
            return this;
        }

        /**
         * Number of failed SBD sessions. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                description = "Number of failed SBD sessions."
        )
        public final Builder failedSessions(int failedSessions) {
            this.failedSessions = failedSessions;
            return this;
        }

        /**
         * Number of successful SBD sessions. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                description = "Number of successful SBD sessions."
        )
        public final Builder successfulSessions(int successfulSessions) {
            this.successfulSessions = successfulSessions;
            return this;
        }

        /**
         * Signal quality equal to the number of bars displayed on the ISU signal strength indicator. 
         * Range is 0 to 5, where 0 indicates no signal and 5 indicates maximum signal strength. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                description = "Signal quality equal to the number of bars displayed on the ISU signal strength indicator. Range is 0 to 5, where 0 indicates no signal and 5 indicates maximum signal strength."
        )
        public final Builder signalQuality(int signalQuality) {
            this.signalQuality = signalQuality;
            return this;
        }

        /**
         * 1: Ring call pending, 0: No call pending. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                description = "1: Ring call pending, 0: No call pending."
        )
        public final Builder ringPending(int ringPending) {
            this.ringPending = ringPending;
            return this;
        }

        /**
         * 1: Transmission session pending, 0: No transmission session pending. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1,
                description = "1: Transmission session pending, 0: No transmission session pending."
        )
        public final Builder txSessionPending(int txSessionPending) {
            this.txSessionPending = txSessionPending;
            return this;
        }

        /**
         * 1: Receiving session pending, 0: No receiving session pending. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 1,
                description = "1: Receiving session pending, 0: No receiving session pending."
        )
        public final Builder rxSessionPending(int rxSessionPending) {
            this.rxSessionPending = rxSessionPending;
            return this;
        }

        public final IsbdLinkStatus build() {
            return new IsbdLinkStatus(timestamp, lastHeartbeat, failedSessions, successfulSessions, signalQuality, ringPending, txSessionPending, rxSessionPending);
        }
    }
}
