package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Control for surface; pending and order to origin. 
 */
@MavlinkMessageInfo(
        id = 185,
        crc = 113
)
public final class ControlSurface {
    /**
     * Pending 
     */
    private final float mcontrol;

    /**
     * Order to origin 
     */
    private final float bcontrol;

    /**
     * The system setting the commands 
     */
    private final int target;

    /**
     * ID control surface send 0: throttle 1: aileron 2: elevator 3: rudder 
     */
    private final int idsurface;

    private ControlSurface(float mcontrol, float bcontrol, int target, int idsurface) {
        this.mcontrol = mcontrol;
        this.bcontrol = bcontrol;
        this.target = target;
        this.idsurface = idsurface;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "ControlSurface{target=" + target
                 + ", idsurface=" + idsurface
                 + ", mcontrol=" + mcontrol
                 + ", bcontrol=" + bcontrol + "}";
    }

    /**
     * Pending 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float mcontrol() {
        return mcontrol;
    }

    /**
     * Order to origin 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float bcontrol() {
        return bcontrol;
    }

    /**
     * The system setting the commands 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int target() {
        return target;
    }

    /**
     * ID control surface send 0: throttle 1: aileron 2: elevator 3: rudder 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int idsurface() {
        return idsurface;
    }

    public static class Builder {
        private float mcontrol;

        private float bcontrol;

        private int target;

        private int idsurface;

        private Builder() {
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

        public final ControlSurface build() {
            return new ControlSurface(mcontrol, bcontrol, target, idsurface);
        }
    }
}
