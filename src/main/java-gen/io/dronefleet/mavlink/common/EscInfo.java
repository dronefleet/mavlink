package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Deprecated;
import java.lang.Enum;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * ESC information for lower rate streaming. Recommended streaming rate 1Hz. See {@link io.dronefleet.mavlink.common.EscStatus ESC_STATUS} for 
 * higher-rate ESC data. 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 290,
        crc = 251,
        description = "ESC information for lower rate streaming. Recommended streaming rate 1Hz. See ESC_STATUS for higher-rate ESC data.",
        workInProgress = true
)
@Deprecated
public final class EscInfo {
    private final int index;

    private final BigInteger timeUsec;

    private final int counter;

    private final int count;

    private final EnumValue<EscConnectionType> connectionType;

    private final int info;

    private final EnumValue<EscFailureFlags> failureFlags;

    private final List<Long> errorCount;

    private final List<Integer> temperature;

    private EscInfo(int index, BigInteger timeUsec, int counter, int count,
            EnumValue<EscConnectionType> connectionType, int info,
            EnumValue<EscFailureFlags> failureFlags, List<Long> errorCount,
            List<Integer> temperature) {
        this.index = index;
        this.timeUsec = timeUsec;
        this.counter = counter;
        this.count = count;
        this.connectionType = connectionType;
        this.info = info;
        this.failureFlags = failureFlags;
        this.errorCount = errorCount;
        this.temperature = temperature;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Index of the first ESC in this message. minValue = 0, maxValue = 60, increment = 4. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Index of the first ESC in this message. minValue = 0, maxValue = 60, increment = 4."
    )
    public final int index() {
        return this.index;
    }

    /**
     * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
     * format (since 1.1.1970 or since system boot) by checking for the magnitude the number. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 8,
            description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude the number."
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * Counter of data packets received. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            description = "Counter of data packets received."
    )
    public final int counter() {
        return this.counter;
    }

    /**
     * Total number of ESCs in all messages of this type. Message fields with an index higher than this 
     * should be ignored because they contain invalid data. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            description = "Total number of ESCs in all messages of this type. Message fields with an index higher than this should be ignored because they contain invalid data."
    )
    public final int count() {
        return this.count;
    }

    /**
     * Connection type protocol for all ESC. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            enumType = EscConnectionType.class,
            description = "Connection type protocol for all ESC."
    )
    public final EnumValue<EscConnectionType> connectionType() {
        return this.connectionType;
    }

    /**
     * Information regarding online/offline status of each ESC. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1,
            description = "Information regarding online/offline status of each ESC."
    )
    public final int info() {
        return this.info;
    }

    /**
     * Bitmap of ESC failure flags. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2,
            arraySize = 4,
            enumType = EscFailureFlags.class,
            description = "Bitmap of ESC failure flags."
    )
    public final EnumValue<EscFailureFlags> failureFlags() {
        return this.failureFlags;
    }

    /**
     * Number of reported errors by each ESC since boot. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            arraySize = 4,
            description = "Number of reported errors by each ESC since boot."
    )
    public final List<Long> errorCount() {
        return this.errorCount;
    }

    /**
     * Temperature of each ESC. INT16_MAX: if data not supplied by ESC. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 2,
            arraySize = 4,
            signed = true,
            description = "Temperature of each ESC. INT16_MAX: if data not supplied by ESC."
    )
    public final List<Integer> temperature() {
        return this.temperature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        EscInfo other = (EscInfo)o;
        if (!Objects.deepEquals(index, other.index)) return false;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(counter, other.counter)) return false;
        if (!Objects.deepEquals(count, other.count)) return false;
        if (!Objects.deepEquals(connectionType, other.connectionType)) return false;
        if (!Objects.deepEquals(info, other.info)) return false;
        if (!Objects.deepEquals(failureFlags, other.failureFlags)) return false;
        if (!Objects.deepEquals(errorCount, other.errorCount)) return false;
        if (!Objects.deepEquals(temperature, other.temperature)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(index);
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(counter);
        result = 31 * result + Objects.hashCode(count);
        result = 31 * result + Objects.hashCode(connectionType);
        result = 31 * result + Objects.hashCode(info);
        result = 31 * result + Objects.hashCode(failureFlags);
        result = 31 * result + Objects.hashCode(errorCount);
        result = 31 * result + Objects.hashCode(temperature);
        return result;
    }

    @Override
    public String toString() {
        return "EscInfo{index=" + index
                 + ", timeUsec=" + timeUsec
                 + ", counter=" + counter
                 + ", count=" + count
                 + ", connectionType=" + connectionType
                 + ", info=" + info
                 + ", failureFlags=" + failureFlags
                 + ", errorCount=" + errorCount
                 + ", temperature=" + temperature + "}";
    }

    public static final class Builder {
        private int index;

        private BigInteger timeUsec;

        private int counter;

        private int count;

        private EnumValue<EscConnectionType> connectionType;

        private int info;

        private EnumValue<EscFailureFlags> failureFlags;

        private List<Long> errorCount;

        private List<Integer> temperature;

        /**
         * Index of the first ESC in this message. minValue = 0, maxValue = 60, increment = 4. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Index of the first ESC in this message. minValue = 0, maxValue = 60, increment = 4."
        )
        public final Builder index(int index) {
            this.index = index;
            return this;
        }

        /**
         * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
         * format (since 1.1.1970 or since system boot) by checking for the magnitude the number. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 8,
                description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude the number."
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * Counter of data packets received. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                description = "Counter of data packets received."
        )
        public final Builder counter(int counter) {
            this.counter = counter;
            return this;
        }

        /**
         * Total number of ESCs in all messages of this type. Message fields with an index higher than this 
         * should be ignored because they contain invalid data. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                description = "Total number of ESCs in all messages of this type. Message fields with an index higher than this should be ignored because they contain invalid data."
        )
        public final Builder count(int count) {
            this.count = count;
            return this;
        }

        /**
         * Connection type protocol for all ESC. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                enumType = EscConnectionType.class,
                description = "Connection type protocol for all ESC."
        )
        public final Builder connectionType(EnumValue<EscConnectionType> connectionType) {
            this.connectionType = connectionType;
            return this;
        }

        /**
         * Connection type protocol for all ESC. 
         */
        public final Builder connectionType(EscConnectionType entry) {
            return connectionType(EnumValue.of(entry));
        }

        /**
         * Connection type protocol for all ESC. 
         */
        public final Builder connectionType(Enum... flags) {
            return connectionType(EnumValue.create(flags));
        }

        /**
         * Connection type protocol for all ESC. 
         */
        public final Builder connectionType(Collection<Enum> flags) {
            return connectionType(EnumValue.create(flags));
        }

        /**
         * Information regarding online/offline status of each ESC. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1,
                description = "Information regarding online/offline status of each ESC."
        )
        public final Builder info(int info) {
            this.info = info;
            return this;
        }

        /**
         * Bitmap of ESC failure flags. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2,
                arraySize = 4,
                enumType = EscFailureFlags.class,
                description = "Bitmap of ESC failure flags."
        )
        public final Builder failureFlags(EnumValue<EscFailureFlags> failureFlags) {
            this.failureFlags = failureFlags;
            return this;
        }

        /**
         * Bitmap of ESC failure flags. 
         */
        public final Builder failureFlags(EscFailureFlags entry) {
            return failureFlags(EnumValue.of(entry));
        }

        /**
         * Bitmap of ESC failure flags. 
         */
        public final Builder failureFlags(Enum... flags) {
            return failureFlags(EnumValue.create(flags));
        }

        /**
         * Bitmap of ESC failure flags. 
         */
        public final Builder failureFlags(Collection<Enum> flags) {
            return failureFlags(EnumValue.create(flags));
        }

        /**
         * Number of reported errors by each ESC since boot. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                arraySize = 4,
                description = "Number of reported errors by each ESC since boot."
        )
        public final Builder errorCount(List<Long> errorCount) {
            this.errorCount = errorCount;
            return this;
        }

        /**
         * Temperature of each ESC. INT16_MAX: if data not supplied by ESC. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 2,
                arraySize = 4,
                signed = true,
                description = "Temperature of each ESC. INT16_MAX: if data not supplied by ESC."
        )
        public final Builder temperature(List<Integer> temperature) {
            this.temperature = temperature;
            return this;
        }

        public final EscInfo build() {
            return new EscInfo(index, timeUsec, counter, count, connectionType, info, failureFlags, errorCount, temperature);
        }
    }
}
