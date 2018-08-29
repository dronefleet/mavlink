package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * Provides state for additional features 
 */
@MavlinkMessageInfo(
        id = 245,
        crc = 130
)
public final class ExtendedSysState {
    private final EnumValue<MavVtolState> vtolState;

    private final EnumValue<MavLandedState> landedState;

    private ExtendedSysState(EnumValue<MavVtolState> vtolState,
            EnumValue<MavLandedState> landedState) {
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
            unitSize = 1,
            enumType = MavVtolState.class
    )
    public final EnumValue<MavVtolState> vtolState() {
        return this.vtolState;
    }

    /**
     * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            enumType = MavLandedState.class
    )
    public final EnumValue<MavLandedState> landedState() {
        return this.landedState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ExtendedSysState other = (ExtendedSysState)o;
        if (!Objects.deepEquals(vtolState, other.vtolState)) return false;
        if (!Objects.deepEquals(landedState, other.landedState)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(vtolState);
        result = 31 * result + Objects.hashCode(landedState);
        return result;
    }

    @Override
    public String toString() {
        return "ExtendedSysState{vtolState=" + vtolState
                 + ", landedState=" + landedState + "}";
    }

    public static final class Builder {
        private EnumValue<MavVtolState> vtolState;

        private EnumValue<MavLandedState> landedState;

        /**
         * The VTOL state if applicable. Is set to MAV_VTOL_STATE_UNDEFINED if UAV is not in VTOL 
         * configuration. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                enumType = MavVtolState.class
        )
        public final Builder vtolState(EnumValue<MavVtolState> vtolState) {
            this.vtolState = vtolState;
            return this;
        }

        /**
         * The VTOL state if applicable. Is set to MAV_VTOL_STATE_UNDEFINED if UAV is not in VTOL 
         * configuration. 
         */
        public final Builder vtolState(MavVtolState entry) {
            return vtolState(EnumValue.of(entry));
        }

        /**
         * The VTOL state if applicable. Is set to MAV_VTOL_STATE_UNDEFINED if UAV is not in VTOL 
         * configuration. 
         */
        public final Builder vtolState(Enum... flags) {
            return vtolState(EnumValue.create(flags));
        }

        /**
         * The VTOL state if applicable. Is set to MAV_VTOL_STATE_UNDEFINED if UAV is not in VTOL 
         * configuration. 
         */
        public final Builder vtolState(Collection<Enum> flags) {
            return vtolState(EnumValue.create(flags));
        }

        /**
         * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                enumType = MavLandedState.class
        )
        public final Builder landedState(EnumValue<MavLandedState> landedState) {
            this.landedState = landedState;
            return this;
        }

        /**
         * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown. 
         */
        public final Builder landedState(MavLandedState entry) {
            return landedState(EnumValue.of(entry));
        }

        /**
         * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown. 
         */
        public final Builder landedState(Enum... flags) {
            return landedState(EnumValue.create(flags));
        }

        /**
         * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown. 
         */
        public final Builder landedState(Collection<Enum> flags) {
            return landedState(EnumValue.create(flags));
        }

        public final ExtendedSysState build() {
            return new ExtendedSysState(vtolState, landedState);
        }
    }
}
