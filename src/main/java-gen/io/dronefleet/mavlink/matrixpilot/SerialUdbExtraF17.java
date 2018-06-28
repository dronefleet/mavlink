package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F17 format 
 */
@MavlinkMessageInfo(
        id = 183,
        crc = 175
)
public final class SerialUdbExtraF17 {
    private final float sueFeedForward;

    private final float sueTurnRateNav;

    private final float sueTurnRateFbw;

    private SerialUdbExtraF17(float sueFeedForward, float sueTurnRateNav, float sueTurnRateFbw) {
        this.sueFeedForward = sueFeedForward;
        this.sueTurnRateNav = sueTurnRateNav;
        this.sueTurnRateFbw = sueTurnRateFbw;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * SUE Feed Forward Gain 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final float sueFeedForward() {
        return this.sueFeedForward;
    }

    /**
     * SUE Max Turn Rate when Navigating 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float sueTurnRateNav() {
        return this.sueTurnRateNav;
    }

    /**
     * SUE Max Turn Rate in Fly By Wire Mode 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float sueTurnRateFbw() {
        return this.sueTurnRateFbw;
    }

    public static final class Builder {
        private float sueFeedForward;

        private float sueTurnRateNav;

        private float sueTurnRateFbw;

        /**
         * SUE Feed Forward Gain 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
        )
        public final Builder sueFeedForward(float sueFeedForward) {
            this.sueFeedForward = sueFeedForward;
            return this;
        }

        /**
         * SUE Max Turn Rate when Navigating 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder sueTurnRateNav(float sueTurnRateNav) {
            this.sueTurnRateNav = sueTurnRateNav;
            return this;
        }

        /**
         * SUE Max Turn Rate in Fly By Wire Mode 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder sueTurnRateFbw(float sueTurnRateFbw) {
            this.sueTurnRateFbw = sueTurnRateFbw;
            return this;
        }

        public final SerialUdbExtraF17 build() {
            return new SerialUdbExtraF17(sueFeedForward, sueTurnRateNav, sueTurnRateFbw);
        }
    }
}
