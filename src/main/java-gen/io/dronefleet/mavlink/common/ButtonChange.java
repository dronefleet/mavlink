package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Report button state change 
 */
@MavlinkMessageInfo(
        id = 257,
        crc = 131
)
public final class ButtonChange {
    private final long timeBootMs;

    private final long lastChangeMs;

    private final int state;

    private ButtonChange(long timeBootMs, long lastChangeMs, int state) {
        this.timeBootMs = timeBootMs;
        this.lastChangeMs = lastChangeMs;
        this.state = state;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (milliseconds since system boot) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * Time of last change of button state 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final long lastChangeMs() {
        return this.lastChangeMs;
    }

    /**
     * Bitmap state of buttons 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final int state() {
        return this.state;
    }

    public static final class Builder {
        private long timeBootMs;

        private long lastChangeMs;

        private int state;

        /**
         * Timestamp (milliseconds since system boot) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * Time of last change of button state 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder lastChangeMs(long lastChangeMs) {
            this.lastChangeMs = lastChangeMs;
            return this;
        }

        /**
         * Bitmap state of buttons 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder state(int state) {
            this.state = state;
            return this;
        }

        public final ButtonChange build() {
            return new ButtonChange(timeBootMs, lastChangeMs, state);
        }
    }
}
