package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Deprecated;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Status generated in each node in the communication chain and injected into MAVLink stream. 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 8,
        crc = 117,
        description = "Status generated in each node in the communication chain and injected into MAVLink stream.",
        workInProgress = true
)
@Deprecated
public final class LinkNodeStatus {
    private final BigInteger timestamp;

    private final int txBuf;

    private final int rxBuf;

    private final long txRate;

    private final long rxRate;

    private final int rxParseErr;

    private final int txOverflows;

    private final int rxOverflows;

    private final long messagesSent;

    private final long messagesReceived;

    private final long messagesLost;

    private LinkNodeStatus(BigInteger timestamp, int txBuf, int rxBuf, long txRate, long rxRate,
            int rxParseErr, int txOverflows, int rxOverflows, long messagesSent,
            long messagesReceived, long messagesLost) {
        this.timestamp = timestamp;
        this.txBuf = txBuf;
        this.rxBuf = rxBuf;
        this.txRate = txRate;
        this.rxRate = rxRate;
        this.rxParseErr = rxParseErr;
        this.txOverflows = txOverflows;
        this.rxOverflows = rxOverflows;
        this.messagesSent = messagesSent;
        this.messagesReceived = messagesReceived;
        this.messagesLost = messagesLost;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (time since system boot). 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 8,
            description = "Timestamp (time since system boot)."
    )
    public final BigInteger timestamp() {
        return this.timestamp;
    }

    /**
     * Remaining free transmit buffer space 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "Remaining free transmit buffer space"
    )
    public final int txBuf() {
        return this.txBuf;
    }

    /**
     * Remaining free receive buffer space 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "Remaining free receive buffer space"
    )
    public final int rxBuf() {
        return this.rxBuf;
    }

    /**
     * Transmit rate 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Transmit rate"
    )
    public final long txRate() {
        return this.txRate;
    }

    /**
     * Receive rate 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Receive rate"
    )
    public final long rxRate() {
        return this.rxRate;
    }

    /**
     * Number of bytes that could not be parsed correctly. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            description = "Number of bytes that could not be parsed correctly."
    )
    public final int rxParseErr() {
        return this.rxParseErr;
    }

    /**
     * Transmit buffer overflows. This number wraps around as it reaches UINT16_MAX 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2,
            description = "Transmit buffer overflows. This number wraps around as it reaches UINT16_MAX"
    )
    public final int txOverflows() {
        return this.txOverflows;
    }

    /**
     * Receive buffer overflows. This number wraps around as it reaches UINT16_MAX 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2,
            description = "Receive buffer overflows. This number wraps around as it reaches UINT16_MAX"
    )
    public final int rxOverflows() {
        return this.rxOverflows;
    }

    /**
     * Messages sent 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "Messages sent"
    )
    public final long messagesSent() {
        return this.messagesSent;
    }

    /**
     * Messages received (estimated from counting seq) 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            description = "Messages received (estimated from counting seq)"
    )
    public final long messagesReceived() {
        return this.messagesReceived;
    }

    /**
     * Messages lost (estimated from counting seq) 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4,
            description = "Messages lost (estimated from counting seq)"
    )
    public final long messagesLost() {
        return this.messagesLost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        LinkNodeStatus other = (LinkNodeStatus)o;
        if (!Objects.deepEquals(timestamp, other.timestamp)) return false;
        if (!Objects.deepEquals(txBuf, other.txBuf)) return false;
        if (!Objects.deepEquals(rxBuf, other.rxBuf)) return false;
        if (!Objects.deepEquals(txRate, other.txRate)) return false;
        if (!Objects.deepEquals(rxRate, other.rxRate)) return false;
        if (!Objects.deepEquals(rxParseErr, other.rxParseErr)) return false;
        if (!Objects.deepEquals(txOverflows, other.txOverflows)) return false;
        if (!Objects.deepEquals(rxOverflows, other.rxOverflows)) return false;
        if (!Objects.deepEquals(messagesSent, other.messagesSent)) return false;
        if (!Objects.deepEquals(messagesReceived, other.messagesReceived)) return false;
        if (!Objects.deepEquals(messagesLost, other.messagesLost)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timestamp);
        result = 31 * result + Objects.hashCode(txBuf);
        result = 31 * result + Objects.hashCode(rxBuf);
        result = 31 * result + Objects.hashCode(txRate);
        result = 31 * result + Objects.hashCode(rxRate);
        result = 31 * result + Objects.hashCode(rxParseErr);
        result = 31 * result + Objects.hashCode(txOverflows);
        result = 31 * result + Objects.hashCode(rxOverflows);
        result = 31 * result + Objects.hashCode(messagesSent);
        result = 31 * result + Objects.hashCode(messagesReceived);
        result = 31 * result + Objects.hashCode(messagesLost);
        return result;
    }

    @Override
    public String toString() {
        return "LinkNodeStatus{timestamp=" + timestamp
                 + ", txBuf=" + txBuf
                 + ", rxBuf=" + rxBuf
                 + ", txRate=" + txRate
                 + ", rxRate=" + rxRate
                 + ", rxParseErr=" + rxParseErr
                 + ", txOverflows=" + txOverflows
                 + ", rxOverflows=" + rxOverflows
                 + ", messagesSent=" + messagesSent
                 + ", messagesReceived=" + messagesReceived
                 + ", messagesLost=" + messagesLost + "}";
    }

    public static final class Builder {
        private BigInteger timestamp;

        private int txBuf;

        private int rxBuf;

        private long txRate;

        private long rxRate;

        private int rxParseErr;

        private int txOverflows;

        private int rxOverflows;

        private long messagesSent;

        private long messagesReceived;

        private long messagesLost;

        /**
         * Timestamp (time since system boot). 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 8,
                description = "Timestamp (time since system boot)."
        )
        public final Builder timestamp(BigInteger timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        /**
         * Remaining free transmit buffer space 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "Remaining free transmit buffer space"
        )
        public final Builder txBuf(int txBuf) {
            this.txBuf = txBuf;
            return this;
        }

        /**
         * Remaining free receive buffer space 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                description = "Remaining free receive buffer space"
        )
        public final Builder rxBuf(int rxBuf) {
            this.rxBuf = rxBuf;
            return this;
        }

        /**
         * Transmit rate 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Transmit rate"
        )
        public final Builder txRate(long txRate) {
            this.txRate = txRate;
            return this;
        }

        /**
         * Receive rate 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Receive rate"
        )
        public final Builder rxRate(long rxRate) {
            this.rxRate = rxRate;
            return this;
        }

        /**
         * Number of bytes that could not be parsed correctly. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                description = "Number of bytes that could not be parsed correctly."
        )
        public final Builder rxParseErr(int rxParseErr) {
            this.rxParseErr = rxParseErr;
            return this;
        }

        /**
         * Transmit buffer overflows. This number wraps around as it reaches UINT16_MAX 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2,
                description = "Transmit buffer overflows. This number wraps around as it reaches UINT16_MAX"
        )
        public final Builder txOverflows(int txOverflows) {
            this.txOverflows = txOverflows;
            return this;
        }

        /**
         * Receive buffer overflows. This number wraps around as it reaches UINT16_MAX 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2,
                description = "Receive buffer overflows. This number wraps around as it reaches UINT16_MAX"
        )
        public final Builder rxOverflows(int rxOverflows) {
            this.rxOverflows = rxOverflows;
            return this;
        }

        /**
         * Messages sent 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "Messages sent"
        )
        public final Builder messagesSent(long messagesSent) {
            this.messagesSent = messagesSent;
            return this;
        }

        /**
         * Messages received (estimated from counting seq) 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                description = "Messages received (estimated from counting seq)"
        )
        public final Builder messagesReceived(long messagesReceived) {
            this.messagesReceived = messagesReceived;
            return this;
        }

        /**
         * Messages lost (estimated from counting seq) 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4,
                description = "Messages lost (estimated from counting seq)"
        )
        public final Builder messagesLost(long messagesLost) {
            this.messagesLost = messagesLost;
            return this;
        }

        public final LinkNodeStatus build() {
            return new LinkNodeStatus(timestamp, txBuf, rxBuf, txRate, rxRate, rxParseErr, txOverflows, rxOverflows, messagesSent, messagesReceived, messagesLost);
        }
    }
}
