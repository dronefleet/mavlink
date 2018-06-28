package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

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
