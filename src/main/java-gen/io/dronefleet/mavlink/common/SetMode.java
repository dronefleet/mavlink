package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * THIS INTERFACE IS DEPRECATED. USE COMMAND_LONG with MAV_CMD_DO_SET_MODE INSTEAD. Set the 
 * system mode, as defined by enum {@link io.dronefleet.mavlink.common.MavMode MavMode}. There is no target component id as the mode is by 
 * definition for the overall aircraft, not only for one component. 
 */
@MavlinkMessageInfo(
        id = 11,
        crc = 89
)
public final class SetMode {
    /**
     * The new autopilot-specific mode. This field can be ignored by an autopilot. 
     */
    private final long customMode;

    /**
     * The system setting the mode 
     */
    private final int targetSystem;

    /**
     * The new base mode 
     */
    private final MavMode baseMode;

    private SetMode(long customMode, int targetSystem, MavMode baseMode) {
        this.customMode = customMode;
        this.targetSystem = targetSystem;
        this.baseMode = baseMode;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "SetMode{targetSystem=" + targetSystem
                 + ", baseMode=" + baseMode
                 + ", customMode=" + customMode + "}";
    }

    /**
     * The new autopilot-specific mode. This field can be ignored by an autopilot. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final long customMode() {
        return customMode;
    }

    /**
     * The system setting the mode 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int targetSystem() {
        return targetSystem;
    }

    /**
     * The new base mode 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final MavMode baseMode() {
        return baseMode;
    }

    public static class Builder {
        private long customMode;

        private int targetSystem;

        private MavMode baseMode;

        private Builder() {
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

        public final SetMode build() {
            return new SetMode(customMode, targetSystem, baseMode);
        }
    }
}
