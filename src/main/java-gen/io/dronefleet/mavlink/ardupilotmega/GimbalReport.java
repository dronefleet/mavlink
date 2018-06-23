package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * 3 axis gimbal mesuraments 
 */
@MavlinkMessageInfo(
        id = 200,
        crc = 134
)
public final class GimbalReport {
    /**
     * Time since last update (seconds) 
     */
    private final float deltaTime;

    /**
     * Delta angle X (radians) 
     */
    private final float deltaAngleX;

    /**
     * Delta angle Y (radians) 
     */
    private final float deltaAngleY;

    /**
     * Delta angle X (radians) 
     */
    private final float deltaAngleZ;

    /**
     * Delta velocity X (m/s) 
     */
    private final float deltaVelocityX;

    /**
     * Delta velocity Y (m/s) 
     */
    private final float deltaVelocityY;

    /**
     * Delta velocity Z (m/s) 
     */
    private final float deltaVelocityZ;

    /**
     * Joint ROLL (radians) 
     */
    private final float jointRoll;

    /**
     * Joint EL (radians) 
     */
    private final float jointEl;

    /**
     * Joint AZ (radians) 
     */
    private final float jointAz;

    /**
     * System ID 
     */
    private final int targetSystem;

    /**
     * Component ID 
     */
    private final int targetComponent;

    private GimbalReport(float deltaTime, float deltaAngleX, float deltaAngleY, float deltaAngleZ,
            float deltaVelocityX, float deltaVelocityY, float deltaVelocityZ, float jointRoll,
            float jointEl, float jointAz, int targetSystem, int targetComponent) {
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
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "GimbalReport{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", deltaTime=" + deltaTime
                 + ", deltaAngleX=" + deltaAngleX
                 + ", deltaAngleY=" + deltaAngleY
                 + ", deltaAngleZ=" + deltaAngleZ
                 + ", deltaVelocityX=" + deltaVelocityX
                 + ", deltaVelocityY=" + deltaVelocityY
                 + ", deltaVelocityZ=" + deltaVelocityZ
                 + ", jointRoll=" + jointRoll
                 + ", jointEl=" + jointEl
                 + ", jointAz=" + jointAz + "}";
    }

    /**
     * Time since last update (seconds) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float deltaTime() {
        return deltaTime;
    }

    /**
     * Delta angle X (radians) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float deltaAngleX() {
        return deltaAngleX;
    }

    /**
     * Delta angle Y (radians) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float deltaAngleY() {
        return deltaAngleY;
    }

    /**
     * Delta angle X (radians) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float deltaAngleZ() {
        return deltaAngleZ;
    }

    /**
     * Delta velocity X (m/s) 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float deltaVelocityX() {
        return deltaVelocityX;
    }

    /**
     * Delta velocity Y (m/s) 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4
    )
    public final float deltaVelocityY() {
        return deltaVelocityY;
    }

    /**
     * Delta velocity Z (m/s) 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4
    )
    public final float deltaVelocityZ() {
        return deltaVelocityZ;
    }

    /**
     * Joint ROLL (radians) 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4
    )
    public final float jointRoll() {
        return jointRoll;
    }

    /**
     * Joint EL (radians) 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4
    )
    public final float jointEl() {
        return jointEl;
    }

    /**
     * Joint AZ (radians) 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4
    )
    public final float jointAz() {
        return jointAz;
    }

    /**
     * System ID 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int targetSystem() {
        return targetSystem;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int targetComponent() {
        return targetComponent;
    }

    public static class Builder {
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

        private int targetSystem;

        private int targetComponent;

        private Builder() {
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

        public final GimbalReport build() {
            return new GimbalReport(deltaTime, deltaAngleX, deltaAngleY, deltaAngleZ, deltaVelocityX, deltaVelocityY, deltaVelocityZ, jointRoll, jointEl, jointAz, targetSystem, targetComponent);
        }
    }
}
