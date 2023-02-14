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
 * Regular broadcast for the current latest event sequence number for a component. This is used to 
 * check for dropped events. 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 411,
        crc = 106,
        description = "Regular broadcast for the current latest event sequence number for a component. This is used to check for dropped events.",
        workInProgress = true
)
@Deprecated
public final class CurrentEventSequence {
    private final int sequence;

    private final EnumValue<MavEventCurrentSequenceFlags> flags;

    private CurrentEventSequence(int sequence, EnumValue<MavEventCurrentSequenceFlags> flags) {
        this.sequence = sequence;
        this.flags = flags;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Sequence number. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            description = "Sequence number."
    )
    public final int sequence() {
        return this.sequence;
    }

    /**
     * Flag bitset. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            enumType = MavEventCurrentSequenceFlags.class,
            description = "Flag bitset."
    )
    public final EnumValue<MavEventCurrentSequenceFlags> flags() {
        return this.flags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        CurrentEventSequence other = (CurrentEventSequence)o;
        if (!Objects.deepEquals(sequence, other.sequence)) return false;
        if (!Objects.deepEquals(flags, other.flags)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(sequence);
        result = 31 * result + Objects.hashCode(flags);
        return result;
    }

    @Override
    public String toString() {
        return "CurrentEventSequence{sequence=" + sequence
                 + ", flags=" + flags + "}";
    }

    public static final class Builder {
        private int sequence;

        private EnumValue<MavEventCurrentSequenceFlags> flags;

        /**
         * Sequence number. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                description = "Sequence number."
        )
        public final Builder sequence(int sequence) {
            this.sequence = sequence;
            return this;
        }

        /**
         * Flag bitset. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                enumType = MavEventCurrentSequenceFlags.class,
                description = "Flag bitset."
        )
        public final Builder flags(EnumValue<MavEventCurrentSequenceFlags> flags) {
            this.flags = flags;
            return this;
        }

        /**
         * Flag bitset. 
         */
        public final Builder flags(MavEventCurrentSequenceFlags entry) {
            return flags(EnumValue.of(entry));
        }

        /**
         * Flag bitset. 
         */
        public final Builder flags(Enum... flags) {
            return flags(EnumValue.create(flags));
        }

        /**
         * Flag bitset. 
         */
        public final Builder flags(Collection<Enum> flags) {
            return flags(EnumValue.create(flags));
        }

        public final CurrentEventSequence build() {
            return new CurrentEventSequence(sequence, flags);
        }
    }
}
