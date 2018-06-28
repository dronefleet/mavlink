package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * A certain mission item has been reached. The system will either hold this position (or circle on 
 * the orbit) or (if the autocontinue on the WP was set) continue to the next waypoint. 
 */
@MavlinkMessageInfo(
        id = 46,
        crc = 11
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
            unitSize = 2
    )
    public final int seq() {
        return this.seq;
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

        public final MissionItemReached build() {
            return new MissionItemReached(seq);
        }
    }
}
