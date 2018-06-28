package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * 3 axis gimbal mesuraments 
 */
@MavlinkMessageInfo(
        id = 200,
        crc = 134
)
public final class GimbalReport {
    private final int targetSystem;

    private final int targetComponent;

    private final float deltaTime;

    private final float deltaAngleX;

    private final float deltaAngleY;

    private final float deltaAngleZ;

    private final float deltaVelocityX;

    private final float deltaVelocityY;

    private final float deltaVelocityZ;

    private final float jointRoll;

    private final float jointEl;

    private final float jointAz;

    private GimbalReport(int targetSystem, int targetComponent, float deltaTime, float deltaAngleX,
            float deltaAngleY, float deltaAngleZ, float deltaVelocityX, float deltaVelocityY,
            float deltaVelocityZ, float jointRoll, float jointEl, float jointAz) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.deltaTime = deltaTime;
        this.deltaAngleX = deltaAngleX;
        this.deltaAngleY = deltaAngleY;
        this.deltaAngleZ = deltaAngleZ;
        this.deltaVelocityX = deltaVelocityX;
        this.deltaVelocityY = deltaVelocityY;
        this.deltaVelocityZ = deltaVelocityZ;
        this.jointRoll = jointRoll;
        this.jointEl = jointEl;
        this.jointAz = jointAz;
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
     * Time since last update (seconds) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float deltaTime() {
        return this.deltaTime;
    }

    /**
     * Delta angle X (radians) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float deltaAngleX() {
        return this.deltaAngleX;
    }

    /**
     * Delta angle Y (radians) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float deltaAngleY() {
        return this.deltaAngleY;
    }

    /**
     * Delta angle X (radians) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float deltaAngleZ() {
        return this.deltaAngleZ;
    }

    /**
     * Delta velocity X (m/s) 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float deltaVelocityX() {
        return this.deltaVelocityX;
    }

    /**
     * Delta velocity Y (m/s) 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4
    )
    public final float deltaVelocityY() {
        return this.deltaVelocityY;
    }

    /**
     * Delta velocity Z (m/s) 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4
    )
    public final float deltaVelocityZ() {
        return this.deltaVelocityZ;
    }

    /**
     * Joint ROLL (radians) 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4
    )
    public final float jointRoll() {
        return this.jointRoll;
    }

    /**
     * Joint EL (radians) 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4
    )
    public final float jointEl() {
        return this.jointEl;
    }

    /**
     * Joint AZ (radians) 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4
    )
    public final float jointAz() {
        return this.jointAz;
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private float deltaTime;

        private float deltaAngleX;

        private float deltaAngleY;

        private float deltaAngleZ;

        private float deltaVelocityX;

        private float deltaVelocityY;

        private float deltaVelocityZ;

        private float jointRoll;

        private float jointEl;

        private float jointAz;

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
         * Time since last update (seconds) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder deltaTime(float deltaTime) {
            this.deltaTime = deltaTime;
            return this;
        }

        /**
         * Delta angle X (radians) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder deltaAngleX(float deltaAngleX) {
            this.deltaAngleX = deltaAngleX;
            return this;
        }

        /**
         * Delta angle Y (radians) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder deltaAngleY(float deltaAngleY) {
            this.deltaAngleY = deltaAngleY;
            return this;
        }

        /**
         * Delta angle X (radians) 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder deltaAngleZ(float deltaAngleZ) {
            this.deltaAngleZ = deltaAngleZ;
            return this;
        }

        /**
         * Delta velocity X (m/s) 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4
        )
        public final Builder deltaVelocityX(float deltaVelocityX) {
            this.deltaVelocityX = deltaVelocityX;
            return this;
        }

        /**
         * Delta velocity Y (m/s) 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4
        )
        public final Builder deltaVelocityY(float deltaVelocityY) {
            this.deltaVelocityY = deltaVelocityY;
            return this;
        }

        /**
         * Delta velocity Z (m/s) 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4
        )
        public final Builder deltaVelocityZ(float deltaVelocityZ) {
            this.deltaVelocityZ = deltaVelocityZ;
            return this;
        }

        /**
         * Joint ROLL (radians) 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4
        )
        public final Builder jointRoll(float jointRoll) {
            this.jointRoll = jointRoll;
            return this;
        }

        /**
         * Joint EL (radians) 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4
        )
        public final Builder jointEl(float jointEl) {
            this.jointEl = jointEl;
            return this;
        }

        /**
         * Joint AZ (radians) 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4
        )
        public final Builder jointAz(float jointAz) {
            this.jointAz = jointAz;
            return this;
        }

        public final GimbalReport build() {
            return new GimbalReport(targetSystem, targetComponent, deltaTime, deltaAngleX, deltaAngleY, deltaAngleZ, deltaVelocityX, deltaVelocityY, deltaVelocityZ, jointRoll, jointEl, jointAz);
        }
    }
}
