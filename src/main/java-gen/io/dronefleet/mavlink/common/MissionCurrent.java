package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.util.Objects;

/**
 * Message that announces the sequence number of the current active mission item. The MAV will fly 
 * towards this mission item. 
 */
@MavlinkMessageInfo(
        id = 42,
        crc = 28
)
public final class MissionCurrent {
    private final int seq;

    private MissionCurrent(int seq) {
        this.seq = seq;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Sequence 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 2
    )
    public final int seq() {
        return this.seq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        MissionCurrent other = (MissionCurrent)o;
        if (!Objects.deepEquals(seq, other.seq)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(seq);
        return result;
    }

    public static final class Builder {
        private int seq;

        /**
         * Sequence 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 2
        )
        public final Builder seq(int seq) {
            this.seq = seq;
            return this;
        }

        public final MissionCurrent build() {
            return new MissionCurrent(seq);
        }
    }
}
