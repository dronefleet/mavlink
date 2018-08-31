package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * A certain mission item has been reached. The system will either hold this position (or circle on 
 * the orbit) or (if the autocontinue on the WP was set) continue to the next waypoint. 
 */
@MavlinkMessageInfo(
        id = 46,
        crc = 11,
        description = "A certain mission item has been reached. The system will either hold this position (or circle on the orbit) or (if the autocontinue on the WP was set) continue to the next waypoint."
)
public final class MissionItemReached {
    private final int seq;

    private MissionItemReached(int seq) {
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
            unitSize = 2,
            description = "Sequence"
    )
    public final int seq() {
        return this.seq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        MissionItemReached other = (MissionItemReached)o;
        if (!Objects.deepEquals(seq, other.seq)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(seq);
        return result;
    }

    @Override
    public String toString() {
        return "MissionItemReached{seq=" + seq + "}";
    }

    public static final class Builder {
        private int seq;

        /**
         * Sequence 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 2,
                description = "Sequence"
        )
        public final Builder seq(int seq) {
            this.seq = seq;
            return this;
        }

        public final MissionItemReached build() {
            return new MissionItemReached(seq);
        }
    }
}
