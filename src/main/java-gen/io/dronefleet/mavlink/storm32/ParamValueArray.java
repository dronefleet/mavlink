package io.dronefleet.mavlink.storm32;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Parameter multi param value container. 
 */
@MavlinkMessageInfo(
        id = 60041,
        crc = 191,
        description = "Parameter multi param value container."
)
public final class ParamValueArray {
    private final int paramCount;

    private final int paramIndexFirst;

    private final int paramArrayLen;

    private final int flags;

    private final byte[] packetBuf;

    private ParamValueArray(int paramCount, int paramIndexFirst, int paramArrayLen, int flags,
            byte[] packetBuf) {
        this.paramCount = paramCount;
        this.paramIndexFirst = paramIndexFirst;
        this.paramArrayLen = paramArrayLen;
        this.flags = flags;
        this.packetBuf = packetBuf;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Total number of onboard parameters. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 2,
            description = "Total number of onboard parameters."
    )
    public final int paramCount() {
        return this.paramCount;
    }

    /**
     * Index of the first onboard parameter in this array. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            description = "Index of the first onboard parameter in this array."
    )
    public final int paramIndexFirst() {
        return this.paramIndexFirst;
    }

    /**
     * Number of onboard parameters in this array. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "Number of onboard parameters in this array."
    )
    public final int paramArrayLen() {
        return this.paramArrayLen;
    }

    /**
     * Flags. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            description = "Flags."
    )
    public final int flags() {
        return this.flags;
    }

    /**
     * Parameters buffer. Contains a series of variable length parameter blocks, one per parameter, 
     * with format as specifed elsewhere. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            arraySize = 248,
            description = "Parameters buffer. Contains a series of variable length parameter blocks, one per parameter, with format as specifed elsewhere."
    )
    public final byte[] packetBuf() {
        return this.packetBuf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ParamValueArray other = (ParamValueArray)o;
        if (!Objects.deepEquals(paramCount, other.paramCount)) return false;
        if (!Objects.deepEquals(paramIndexFirst, other.paramIndexFirst)) return false;
        if (!Objects.deepEquals(paramArrayLen, other.paramArrayLen)) return false;
        if (!Objects.deepEquals(flags, other.flags)) return false;
        if (!Objects.deepEquals(packetBuf, other.packetBuf)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(paramCount);
        result = 31 * result + Objects.hashCode(paramIndexFirst);
        result = 31 * result + Objects.hashCode(paramArrayLen);
        result = 31 * result + Objects.hashCode(flags);
        result = 31 * result + Objects.hashCode(packetBuf);
        return result;
    }

    @Override
    public String toString() {
        return "ParamValueArray{paramCount=" + paramCount
                 + ", paramIndexFirst=" + paramIndexFirst
                 + ", paramArrayLen=" + paramArrayLen
                 + ", flags=" + flags
                 + ", packetBuf=" + packetBuf + "}";
    }

    public static final class Builder {
        private int paramCount;

        private int paramIndexFirst;

        private int paramArrayLen;

        private int flags;

        private byte[] packetBuf;

        /**
         * Total number of onboard parameters. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 2,
                description = "Total number of onboard parameters."
        )
        public final Builder paramCount(int paramCount) {
            this.paramCount = paramCount;
            return this;
        }

        /**
         * Index of the first onboard parameter in this array. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                description = "Index of the first onboard parameter in this array."
        )
        public final Builder paramIndexFirst(int paramIndexFirst) {
            this.paramIndexFirst = paramIndexFirst;
            return this;
        }

        /**
         * Number of onboard parameters in this array. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "Number of onboard parameters in this array."
        )
        public final Builder paramArrayLen(int paramArrayLen) {
            this.paramArrayLen = paramArrayLen;
            return this;
        }

        /**
         * Flags. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                description = "Flags."
        )
        public final Builder flags(int flags) {
            this.flags = flags;
            return this;
        }

        /**
         * Parameters buffer. Contains a series of variable length parameter blocks, one per parameter, 
         * with format as specifed elsewhere. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                arraySize = 248,
                description = "Parameters buffer. Contains a series of variable length parameter blocks, one per parameter, with format as specifed elsewhere."
        )
        public final Builder packetBuf(byte[] packetBuf) {
            this.packetBuf = packetBuf;
            return this;
        }

        public final ParamValueArray build() {
            return new ParamValueArray(paramCount, paramIndexFirst, paramArrayLen, flags, packetBuf);
        }
    }
}
