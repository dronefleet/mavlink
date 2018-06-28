package io.dronefleet.mavlink.paparazzi;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * This message informs about the currently active SCRIPT. 
 */
@MavlinkMessageInfo(
        id = 184,
        crc = 40
)
public final class ScriptCurrent {
    private final int seq;

    private ScriptCurrent(int seq) {
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
     * Active Sequence 
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
         * Active Sequence 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 2
        )
        public final Builder seq(int seq) {
            this.seq = seq;
            return this;
        }

        public final ScriptCurrent build() {
            return new ScriptCurrent(seq);
        }
    }
}
