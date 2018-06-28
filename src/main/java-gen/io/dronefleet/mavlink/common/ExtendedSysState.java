package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Provides state for additional features 
 */
@MavlinkMessageInfo(
        id = 245,
        crc = 130
)
public final class ExtendedSysState {
    private final MavVtolState vtolState;

    private final MavLandedState landedState;

    private ExtendedSysState(MavVtolState vtolState, MavLandedState landedState) {
        this.vtolState = vtolState;
        this.landedState = landedState;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * The VTOL state if applicable. Is set to MAV_VTOL_STATE_UNDEFINED if UAV is not in VTOL 
     * configuration. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final MavVtolState vtolState() {
        return this.vtolState;
    }

    /**
     * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final MavLandedState landedState() {
        return this.landedState;
    }

    public static final class Builder {
        private MavVtolState vtolState;

        private MavLandedState landedState;

        /**
         * The VTOL state if applicable. Is set to MAV_VTOL_STATE_UNDEFINED if UAV is not in VTOL 
         * configuration. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder vtolState(MavVtolState vtolState) {
            this.vtolState = vtolState;
            return this;
        }

        /**
         * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder landedState(MavLandedState landedState) {
            this.landedState = landedState;
            return this;
        }

        public final ExtendedSysState build() {
            return new ExtendedSysState(vtolState, landedState);
        }
    }
}
