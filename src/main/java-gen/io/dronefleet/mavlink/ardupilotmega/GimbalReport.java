package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * 3 axis gimbal mesuraments 
 */
@MavlinkMessageInfo(
        id = 200,
        crc = 134,
        description = "3 axis gimbal mesuraments"
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
            unitSize = 1,
            description = "System ID"
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Component ID"
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Time since last update (seconds) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Time since last update (seconds)"
    )
    public final float deltaTime() {
        return this.deltaTime;
    }

    /**
     * Delta angle X (radians) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Delta angle X (radians)"
    )
    public final float deltaAngleX() {
        return this.deltaAngleX;
    }

    /**
     * Delta angle Y (radians) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Delta angle Y (radians)"
    )
    public final float deltaAngleY() {
        return this.deltaAngleY;
    }

    /**
     * Delta angle X (radians) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Delta angle X (radians)"
    )
    public final float deltaAngleZ() {
        return this.deltaAngleZ;
    }

    /**
     * Delta velocity X (m/s) 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Delta velocity X (m/s)"
    )
    public final float deltaVelocityX() {
        return this.deltaVelocityX;
    }

    /**
     * Delta velocity Y (m/s) 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Delta velocity Y (m/s)"
    )
    public final float deltaVelocityY() {
        return this.deltaVelocityY;
    }

    /**
     * Delta velocity Z (m/s) 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Delta velocity Z (m/s)"
    )
    public final float deltaVelocityZ() {
        return this.deltaVelocityZ;
    }

    /**
     * Joint ROLL (radians) 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "Joint ROLL (radians)"
    )
    public final float jointRoll() {
        return this.jointRoll;
    }

    /**
     * Joint EL (radians) 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            description = "Joint EL (radians)"
    )
    public final float jointEl() {
        return this.jointEl;
    }

    /**
     * Joint AZ (radians) 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4,
            description = "Joint AZ (radians)"
    )
    public final float jointAz() {
        return this.jointAz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        GimbalReport other = (GimbalReport)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(deltaTime, other.deltaTime)) return false;
        if (!Objects.deepEquals(deltaAngleX, other.deltaAngleX)) return false;
        if (!Objects.deepEquals(deltaAngleY, other.deltaAngleY)) return false;
        if (!Objects.deepEquals(deltaAngleZ, other.deltaAngleZ)) return false;
        if (!Objects.deepEquals(deltaVelocityX, other.deltaVelocityX)) return false;
        if (!Objects.deepEquals(deltaVelocityY, other.deltaVelocityY)) return false;
        if (!Objects.deepEquals(deltaVelocityZ, other.deltaVelocityZ)) return false;
        if (!Objects.deepEquals(jointRoll, other.jointRoll)) return false;
        if (!Objects.deepEquals(jointEl, other.jointEl)) return false;
        if (!Objects.deepEquals(jointAz, other.jointAz)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(deltaTime);
        result = 31 * result + Objects.hashCode(deltaAngleX);
        result = 31 * result + Objects.hashCode(deltaAngleY);
        result = 31 * result + Objects.hashCode(deltaAngleZ);
        result = 31 * result + Objects.hashCode(deltaVelocityX);
        result = 31 * result + Objects.hashCode(deltaVelocityY);
        result = 31 * result + Objects.hashCode(deltaVelocityZ);
        result = 31 * result + Objects.hashCode(jointRoll);
        result = 31 * result + Objects.hashCode(jointEl);
        result = 31 * result + Objects.hashCode(jointAz);
        return result;
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
                unitSize = 1,
                description = "System ID"
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
                unitSize = 1,
                description = "Component ID"
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
                unitSize = 4,
                description = "Time since last update (seconds)"
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
                unitSize = 4,
                description = "Delta angle X (radians)"
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
                unitSize = 4,
                description = "Delta angle Y (radians)"
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
                unitSize = 4,
                description = "Delta angle X (radians)"
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
                unitSize = 4,
                description = "Delta velocity X (m/s)"
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
                unitSize = 4,
                description = "Delta velocity Y (m/s)"
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
                unitSize = 4,
                description = "Delta velocity Z (m/s)"
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
                unitSize = 4,
                description = "Joint ROLL (radians)"
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
                unitSize = 4,
                description = "Joint EL (radians)"
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
                unitSize = 4,
                description = "Joint AZ (radians)"
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
