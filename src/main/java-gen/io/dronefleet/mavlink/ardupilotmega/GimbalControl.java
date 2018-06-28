package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Control message for rate gimbal 
 */
@MavlinkMessageInfo(
        id = 201,
        crc = 205
)
public final class GimbalControl {
    private final int targetSystem;

    private final int targetComponent;

    private final float demandedRateX;

    private final float demandedRateY;

    private final float demandedRateZ;

    private GimbalControl(int targetSystem, int targetComponent, float demandedRateX,
            float demandedRateY, float demandedRateZ) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.demandedRateX = demandedRateX;
        this.demandedRateY = demandedRateY;
        this.demandedRateZ = demandedRateZ;
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
     * Demanded angular rate X (rad/s) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float demandedRateX() {
        return this.demandedRateX;
    }

    /**
     * Demanded angular rate Y (rad/s) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float demandedRateY() {
        return this.demandedRateY;
    }

    /**
     * Demanded angular rate Z (rad/s) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float demandedRateZ() {
        return this.demandedRateZ;
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private float demandedRateX;

        private float demandedRateY;

        private float demandedRateZ;

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
         * Demanded angular rate X (rad/s) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder demandedRateX(float demandedRateX) {
            this.demandedRateX = demandedRateX;
            return this;
        }

        /**
         * Demanded angular rate Y (rad/s) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder demandedRateY(float demandedRateY) {
            this.demandedRateY = demandedRateY;
            return this;
        }

        /**
         * Demanded angular rate Z (rad/s) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder demandedRateZ(float demandedRateZ) {
            this.demandedRateZ = demandedRateZ;
            return this;
        }

        public final GimbalControl build() {
            return new GimbalControl(targetSystem, targetComponent, demandedRateX, demandedRateY, demandedRateZ);
        }
    }
}
