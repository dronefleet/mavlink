package io.dronefleet.mavlink.ualberta;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * System status specific to ualberta uav 
 */
@MavlinkMessageInfo(
        id = 222,
        crc = 15,
        description = "System status specific to ualberta uav"
)
public final class UalbertaSysStatus {
    private final int mode;

    private final int navMode;

    private final int pilot;

    private UalbertaSysStatus(int mode, int navMode, int pilot) {
        this.mode = mode;
        this.navMode = navMode;
        this.pilot = pilot;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * System mode, see {@link io.dronefleet.mavlink.ualberta.UalbertaAutopilotMode UALBERTA_AUTOPILOT_MODE} ENUM 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "System mode, see UALBERTA_AUTOPILOT_MODE ENUM"
    )
    public final int mode() {
        return this.mode;
    }

    /**
     * Navigation mode, see {@link io.dronefleet.mavlink.ualberta.UalbertaNavMode UALBERTA_NAV_MODE} ENUM 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Navigation mode, see UALBERTA_NAV_MODE ENUM"
    )
    public final int navMode() {
        return this.navMode;
    }

    /**
     * Pilot mode, see {@link io.dronefleet.mavlink.ualberta.UalbertaPilotMode UALBERTA_PILOT_MODE} 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "Pilot mode, see UALBERTA_PILOT_MODE"
    )
    public final int pilot() {
        return this.pilot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        UalbertaSysStatus other = (UalbertaSysStatus)o;
        if (!Objects.deepEquals(mode, other.mode)) return false;
        if (!Objects.deepEquals(navMode, other.navMode)) return false;
        if (!Objects.deepEquals(pilot, other.pilot)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(mode);
        result = 31 * result + Objects.hashCode(navMode);
        result = 31 * result + Objects.hashCode(pilot);
        return result;
    }

    @Override
    public String toString() {
        return "UalbertaSysStatus{mode=" + mode
                 + ", navMode=" + navMode
                 + ", pilot=" + pilot + "}";
    }

    public static final class Builder {
        private int mode;

        private int navMode;

        private int pilot;

        /**
         * System mode, see {@link io.dronefleet.mavlink.ualberta.UalbertaAutopilotMode UALBERTA_AUTOPILOT_MODE} ENUM 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "System mode, see UALBERTA_AUTOPILOT_MODE ENUM"
        )
        public final Builder mode(int mode) {
            this.mode = mode;
            return this;
        }

        /**
         * Navigation mode, see {@link io.dronefleet.mavlink.ualberta.UalbertaNavMode UALBERTA_NAV_MODE} ENUM 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Navigation mode, see UALBERTA_NAV_MODE ENUM"
        )
        public final Builder navMode(int navMode) {
            this.navMode = navMode;
            return this;
        }

        /**
         * Pilot mode, see {@link io.dronefleet.mavlink.ualberta.UalbertaPilotMode UALBERTA_PILOT_MODE} 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "Pilot mode, see UALBERTA_PILOT_MODE"
        )
        public final Builder pilot(int pilot) {
            this.pilot = pilot;
            return this;
        }

        public final UalbertaSysStatus build() {
            return new UalbertaSysStatus(mode, navMode, pilot);
        }
    }
}
