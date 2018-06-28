package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.common.MavMountMode;

/**
 * Message to configure a camera mount, directional antenna, etc. 
 */
@MavlinkMessageInfo(
        id = 156,
        crc = 19
)
public final class MountConfigure {
    private final int targetSystem;

    private final int targetComponent;

    private final MavMountMode mountMode;

    private final int stabRoll;

    private final int stabPitch;

    private final int stabYaw;

    private MountConfigure(int targetSystem, int targetComponent, MavMountMode mountMode,
            int stabRoll, int stabPitch, int stabYaw) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.mountMode = mountMode;
        this.stabRoll = stabRoll;
        this.stabPitch = stabPitch;
        this.stabYaw = stabYaw;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * System ID 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * mount operating mode (see {@link io.dronefleet.mavlink.common.MavMountMode MAV_MOUNT_MODE} enum) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final MavMountMode mountMode() {
        return this.mountMode;
    }

    /**
     * (1 = yes, 0 = no) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final int stabRoll() {
        return this.stabRoll;
    }

    /**
     * (1 = yes, 0 = no) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final int stabPitch() {
        return this.stabPitch;
    }

    /**
     * (1 = yes, 0 = no) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1
    )
    public final int stabYaw() {
        return this.stabYaw;
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private MavMountMode mountMode;

        private int stabRoll;

        private int stabPitch;

        private int stabYaw;

        /**
         * System ID 
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
         * Component ID 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * mount operating mode (see {@link io.dronefleet.mavlink.common.MavMountMode MAV_MOUNT_MODE} enum) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder mountMode(MavMountMode mountMode) {
            this.mountMode = mountMode;
            return this;
        }

        /**
         * (1 = yes, 0 = no) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1
        )
        public final Builder stabRoll(int stabRoll) {
            this.stabRoll = stabRoll;
            return this;
        }

        /**
         * (1 = yes, 0 = no) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1
        )
        public final Builder stabPitch(int stabPitch) {
            this.stabPitch = stabPitch;
            return this;
        }

        /**
         * (1 = yes, 0 = no) 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1
        )
        public final Builder stabYaw(int stabYaw) {
            this.stabYaw = stabYaw;
            return this;
        }

        public final MountConfigure build() {
            return new MountConfigure(targetSystem, targetComponent, mountMode, stabRoll, stabPitch, stabYaw);
        }
    }
}
