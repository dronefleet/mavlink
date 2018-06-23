package io.dronefleet.mavlink.paparazzi;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * This message informs about the currently active SCRIPT. 
 */
@MavlinkMessageInfo(
        id = 184,
        crc = 40
)
public final class ScriptCurrent {
    /**
     * Active Sequence 
     */
    private final int seq;

    private ScriptCurrent(int seq) {
        this.seq = seq;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "ScriptCurrent{seq=" + seq + "}";
    }

    /**
     * Active Sequence 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 2
    )
    public final int seq() {
        return seq;
    }

    public static class Builder {
        private int seq;

        private Builder() {
        }

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
