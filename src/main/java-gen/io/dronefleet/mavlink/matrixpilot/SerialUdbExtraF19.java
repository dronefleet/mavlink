package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.util.Objects;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F19 format 
 */
@MavlinkMessageInfo(
        id = 185,
        crc = 87
)
public final class SerialUdbExtraF19 {
    private final int sueAileronOutputChannel;

    private final int sueAileronReversed;

    private final int sueElevatorOutputChannel;

    private final int sueElevatorReversed;

    private final int sueThrottleOutputChannel;

    private final int sueThrottleReversed;

    private final int sueRudderOutputChannel;

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

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * SUE aileron output channel 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int sueAileronOutputChannel() {
        return this.sueAileronOutputChannel;
    }

    /**
     * SUE aileron reversed 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int sueAileronReversed() {
        return this.sueAileronReversed;
    }

    /**
     * SUE elevator output channel 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final int sueElevatorOutputChannel() {
        return this.sueElevatorOutputChannel;
    }

    /**
     * SUE elevator reversed 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final int sueElevatorReversed() {
        return this.sueElevatorReversed;
    }

    /**
     * SUE throttle output channel 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final int sueThrottleOutputChannel() {
        return this.sueThrottleOutputChannel;
    }

    /**
     * SUE throttle reversed 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1
    )
    public final int sueThrottleReversed() {
        return this.sueThrottleReversed;
    }

    /**
     * SUE rudder output channel 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1
    )
    public final int sueRudderOutputChannel() {
        return this.sueRudderOutputChannel;
    }

    /**
     * SUE rudder reversed 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1
    )
    public final int sueRudderReversed() {
        return this.sueRudderReversed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SerialUdbExtraF19 other = (SerialUdbExtraF19)o;
        if (!Objects.deepEquals(sueAileronOutputChannel, other.sueAileronOutputChannel)) return false;
        if (!Objects.deepEquals(sueAileronReversed, other.sueAileronReversed)) return false;
        if (!Objects.deepEquals(sueElevatorOutputChannel, other.sueElevatorOutputChannel)) return false;
        if (!Objects.deepEquals(sueElevatorReversed, other.sueElevatorReversed)) return false;
        if (!Objects.deepEquals(sueThrottleOutputChannel, other.sueThrottleOutputChannel)) return false;
        if (!Objects.deepEquals(sueThrottleReversed, other.sueThrottleReversed)) return false;
        if (!Objects.deepEquals(sueRudderOutputChannel, other.sueRudderOutputChannel)) return false;
        if (!Objects.deepEquals(sueRudderReversed, other.sueRudderReversed)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(sueAileronOutputChannel);
        result = 31 * result + Objects.hashCode(sueAileronReversed);
        result = 31 * result + Objects.hashCode(sueElevatorOutputChannel);
        result = 31 * result + Objects.hashCode(sueElevatorReversed);
        result = 31 * result + Objects.hashCode(sueThrottleOutputChannel);
        result = 31 * result + Objects.hashCode(sueThrottleReversed);
        result = 31 * result + Objects.hashCode(sueRudderOutputChannel);
        result = 31 * result + Objects.hashCode(sueRudderReversed);
        return result;
    }

    public static final class Builder {
        private int sueAileronOutputChannel;

        private int sueAileronReversed;

        private int sueElevatorOutputChannel;

        private int sueElevatorReversed;

        private int sueThrottleOutputChannel;

        private int sueThrottleReversed;

        private int sueRudderOutputChannel;

        private int sueRudderReversed;

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
