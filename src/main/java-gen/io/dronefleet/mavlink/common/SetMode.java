package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * THIS INTERFACE IS DEPRECATED. USE {@link io.dronefleet.mavlink.common.CommandLong COMMAND_LONG} with MAV_CMD_DO_SET_MODE INSTEAD. Set the 
 * system mode, as defined by enum {@link io.dronefleet.mavlink.common.MavMode MAV_MODE}. There is no target component id as the mode is by 
 * definition for the overall aircraft, not only for one component. 
 */
@MavlinkMessageInfo(
        id = 11,
        crc = 89
)
public final class SetMode {
    private final int targetSystem;

    private final MavMode baseMode;

    private final long customMode;

    private SetMode(int targetSystem, MavMode baseMode, long customMode) {
        this.targetSystem = targetSystem;
        this.baseMode = baseMode;
        this.customMode = customMode;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * The system setting the mode 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * The new base mode 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final MavMode baseMode() {
        return this.baseMode;
    }

    /**
     * The new autopilot-specific mode. This field can be ignored by an autopilot. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final long customMode() {
        return this.customMode;
    }

    public static final class Builder {
        private int targetSystem;

        private MavMode baseMode;

        private long customMode;

        /**
         * The system setting the mode 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * The new base mode 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder baseMode(MavMode baseMode) {
            this.baseMode = baseMode;
            return this;
        }

        /**
         * The new autopilot-specific mode. This field can be ignored by an autopilot. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder customMode(long customMode) {
            this.customMode = customMode;
            return this;
        }

        public final SetMode build() {
            return new SetMode(targetSystem, baseMode, customMode);
        }
    }
}
