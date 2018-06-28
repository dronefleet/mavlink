package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Control for surface; pending and order to origin. 
 */
@MavlinkMessageInfo(
        id = 185,
        crc = 113
)
public final class ControlSurface {
    private final int target;

    private final int idsurface;

    private final float mcontrol;

    private final float bcontrol;

    private ControlSurface(int target, int idsurface, float mcontrol, float bcontrol) {
        this.target = target;
        this.idsurface = idsurface;
        this.mcontrol = mcontrol;
        this.bcontrol = bcontrol;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * The system setting the commands 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int target() {
        return this.target;
    }

    /**
     * ID control surface send 0: throttle 1: aileron 2: elevator 3: rudder 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int idsurface() {
        return this.idsurface;
    }

    /**
     * Pending 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float mcontrol() {
        return this.mcontrol;
    }

    /**
     * Order to origin 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float bcontrol() {
        return this.bcontrol;
    }

    public static final class Builder {
        private int target;

        private int idsurface;

        private float mcontrol;

        private float bcontrol;

        /**
         * The system setting the commands 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder target(int target) {
            this.target = target;
            return this;
        }

        /**
         * ID control surface send 0: throttle 1: aileron 2: elevator 3: rudder 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder idsurface(int idsurface) {
            this.idsurface = idsurface;
            return this;
        }

        /**
         * Pending 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder mcontrol(float mcontrol) {
            this.mcontrol = mcontrol;
            return this;
        }

        /**
         * Order to origin 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder bcontrol(float bcontrol) {
            this.bcontrol = bcontrol;
            return this;
        }

        public final ControlSurface build() {
            return new ControlSurface(target, idsurface, mcontrol, bcontrol);
        }
    }
}
