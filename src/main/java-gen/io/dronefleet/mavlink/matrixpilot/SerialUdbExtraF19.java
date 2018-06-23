package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F19 format 
 */
@MavlinkMessageInfo(
        id = 185,
        crc = 87
)
public final class SerialUdbExtraF19 {
    /**
     * SUE aileron output channel 
     */
    private final int sueAileronOutputChannel;

    /**
     * SUE aileron reversed 
     */
    private final int sueAileronReversed;

    /**
     * SUE elevator output channel 
     */
    private final int sueElevatorOutputChannel;

    /**
     * SUE elevator reversed 
     */
    private final int sueElevatorReversed;

    /**
     * SUE throttle output channel 
     */
    private final int sueThrottleOutputChannel;

    /**
     * SUE throttle reversed 
     */
    private final int sueThrottleReversed;

    /**
     * SUE rudder output channel 
     */
    private final int sueRudderOutputChannel;

    /**
     * SUE rudder reversed 
     */
    private final int sueRudderReversed;

    private SerialUdbExtraF19(int sueAileronOutputChannel, int sueAileronReversed,
            int sueElevatorOutputChannel, int sueElevatorReversed, int sueThrottleOutputChannel,
            int sueThrottleReversed, int sueRudderOutputChannel, int sueRudderReversed) {
        this.sueAileronOutputChannel = sueAileronOutputChannel;
        this.sueAileronReversed = sueAileronReversed;
        this.sueElevatorOutputChannel = sueElevatorOutputChannel;
        this.sueElevatorReversed = sueElevatorReversed;
        this.sueThrottleOutputChannel = sueThrottleOutputChannel;
        this.sueThrottleReversed = sueThrottleReversed;
        this.sueRudderOutputChannel = sueRudderOutputChannel;
        this.sueRudderReversed = sueRudderReversed;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "SerialUdbExtraF19{sueAileronOutputChannel=" + sueAileronOutputChannel
                 + ", sueAileronReversed=" + sueAileronReversed
                 + ", sueElevatorOutputChannel=" + sueElevatorOutputChannel
                 + ", sueElevatorReversed=" + sueElevatorReversed
                 + ", sueThrottleOutputChannel=" + sueThrottleOutputChannel
                 + ", sueThrottleReversed=" + sueThrottleReversed
                 + ", sueRudderOutputChannel=" + sueRudderOutputChannel
                 + ", sueRudderReversed=" + sueRudderReversed + "}";
    }

    /**
     * SUE aileron output channel 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int sueAileronOutputChannel() {
        return sueAileronOutputChannel;
    }

    /**
     * SUE aileron reversed 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int sueAileronReversed() {
        return sueAileronReversed;
    }

    /**
     * SUE elevator output channel 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final int sueElevatorOutputChannel() {
        return sueElevatorOutputChannel;
    }

    /**
     * SUE elevator reversed 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final int sueElevatorReversed() {
        return sueElevatorReversed;
    }

    /**
     * SUE throttle output channel 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final int sueThrottleOutputChannel() {
        return sueThrottleOutputChannel;
    }

    /**
     * SUE throttle reversed 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1
    )
    public final int sueThrottleReversed() {
        return sueThrottleReversed;
    }

    /**
     * SUE rudder output channel 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1
    )
    public final int sueRudderOutputChannel() {
        return sueRudderOutputChannel;
    }

    /**
     * SUE rudder reversed 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1
    )
    public final int sueRudderReversed() {
        return sueRudderReversed;
    }

    public static class Builder {
        private int sueAileronOutputChannel;

        private int sueAileronReversed;

        private int sueElevatorOutputChannel;

        private int sueElevatorReversed;

        private int sueThrottleOutputChannel;

        private int sueThrottleReversed;

        private int sueRudderOutputChannel;

        private int sueRudderReversed;

        private Builder() {
        }

        /**
         * SUE aileron output channel 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder sueAileronOutputChannel(int sueAileronOutputChannel) {
            this.sueAileronOutputChannel = sueAileronOutputChannel;
            return this;
        }

        /**
         * SUE aileron reversed 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder sueAileronReversed(int sueAileronReversed) {
            this.sueAileronReversed = sueAileronReversed;
            return this;
        }

        /**
         * SUE elevator output channel 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder sueElevatorOutputChannel(int sueElevatorOutputChannel) {
            this.sueElevatorOutputChannel = sueElevatorOutputChannel;
            return this;
        }

        /**
         * SUE elevator reversed 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1
        )
        public final Builder sueElevatorReversed(int sueElevatorReversed) {
            this.sueElevatorReversed = sueElevatorReversed;
            return this;
        }

        /**
         * SUE throttle output channel 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1
        )
        public final Builder sueThrottleOutputChannel(int sueThrottleOutputChannel) {
            this.sueThrottleOutputChannel = sueThrottleOutputChannel;
            return this;
        }

        /**
         * SUE throttle reversed 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1
        )
        public final Builder sueThrottleReversed(int sueThrottleReversed) {
            this.sueThrottleReversed = sueThrottleReversed;
            return this;
        }

        /**
         * SUE rudder output channel 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1
        )
        public final Builder sueRudderOutputChannel(int sueRudderOutputChannel) {
            this.sueRudderOutputChannel = sueRudderOutputChannel;
            return this;
        }

        /**
         * SUE rudder reversed 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 1
        )
        public final Builder sueRudderReversed(int sueRudderReversed) {
            this.sueRudderReversed = sueRudderReversed;
            return this;
        }

        public final SerialUdbExtraF19 build() {
            return new SerialUdbExtraF19(sueAileronOutputChannel, sueAileronReversed, sueElevatorOutputChannel, sueElevatorReversed, sueThrottleOutputChannel, sueThrottleReversed, sueRudderOutputChannel, sueRudderReversed);
        }
    }
}
