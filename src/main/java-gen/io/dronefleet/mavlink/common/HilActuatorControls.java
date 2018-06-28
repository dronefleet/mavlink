package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Float;
import java.math.BigInteger;
import java.util.List;

/**
 * Sent from autopilot to simulation. Hardware in the loop control outputs (replacement for 
 * {@link io.dronefleet.mavlink.common.HilControls HIL_CONTROLS}) 
 */
@MavlinkMessageInfo(
        id = 93,
        crc = 47
)
public final class HilActuatorControls {
    private final BigInteger timeUsec;

    private final List<Float> controls;

    private final MavMode mode;

    private final BigInteger flags;

    private HilActuatorControls(BigInteger timeUsec, List<Float> controls, MavMode mode,
            BigInteger flags) {
        this.timeUsec = timeUsec;
        this.controls = controls;
        this.mode = mode;
        this.flags = flags;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * Control outputs -1 .. 1. Channel assignment depends on the simulated hardware. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            arraySize = 16
    )
    public final List<Float> controls() {
        return this.controls;
    }

    /**
     * System mode ({@link io.dronefleet.mavlink.common.MavMode MAV_MODE}), includes arming state. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final MavMode mode() {
        return this.mode;
    }

    /**
     * Flags as bitfield, reserved for future use. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 8
    )
    public final BigInteger flags() {
        return this.flags;
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private List<Float> controls;

        private MavMode mode;

        private BigInteger flags;

        /**
         * Timestamp (microseconds since UNIX epoch or microseconds since system boot) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * Control outputs -1 .. 1. Channel assignment depends on the simulated hardware. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                arraySize = 16
        )
        public final Builder controls(List<Float> controls) {
            this.controls = controls;
            return this;
        }

        /**
         * System mode ({@link io.dronefleet.mavlink.common.MavMode MAV_MODE}), includes arming state. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder mode(MavMode mode) {
            this.mode = mode;
            return this;
        }

        /**
         * Flags as bitfield, reserved for future use. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 8
        )
        public final Builder flags(BigInteger flags) {
            this.flags = flags;
            return this;
        }

        public final HilActuatorControls build() {
            return new HilActuatorControls(timeUsec, controls, mode, flags);
        }
    }
}
