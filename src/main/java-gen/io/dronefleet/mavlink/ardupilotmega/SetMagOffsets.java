package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Deprecated. Use MAV_CMD_PREFLIGHT_SET_SENSOR_OFFSETS instead. Set the magnetometer 
 * offsets 
 */
@MavlinkMessageInfo(
        id = 151,
        crc = 219
)
public final class SetMagOffsets {
    /**
     * magnetometer X offset 
     */
    private final int magOfsX;

    /**
     * magnetometer Y offset 
     */
    private final int magOfsY;

    /**
     * magnetometer Z offset 
     */
    private final int magOfsZ;

    /**
     * System ID 
     */
    private final int targetSystem;

    /**
     * Component ID 
     */
    private final int targetComponent;

    private SetMagOffsets(int magOfsX, int magOfsY, int magOfsZ, int targetSystem,
            int targetComponent) {
        this.magOfsX = magOfsX;
        this.magOfsY = magOfsY;
        this.magOfsZ = magOfsZ;
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "SetMagOffsets{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", magOfsX=" + magOfsX
                 + ", magOfsY=" + magOfsY
                 + ", magOfsZ=" + magOfsZ + "}";
    }

    /**
     * magnetometer X offset 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            signed = true
    )
    public final int magOfsX() {
        return magOfsX;
    }

    /**
     * magnetometer Y offset 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            signed = true
    )
    public final int magOfsY() {
        return magOfsY;
    }

    /**
     * magnetometer Z offset 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            signed = true
    )
    public final int magOfsZ() {
        return magOfsZ;
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
        private int magOfsX;

        private int magOfsY;

        private int magOfsZ;

        private int targetSystem;

        private int targetComponent;

        private Builder() {
        }

        /**
         * magnetometer X offset 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                signed = true
        )
        public final Builder magOfsX(int magOfsX) {
            this.magOfsX = magOfsX;
            return this;
        }

        /**
         * magnetometer Y offset 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                signed = true
        )
        public final Builder magOfsY(int magOfsY) {
            this.magOfsY = magOfsY;
            return this;
        }

        /**
         * magnetometer Z offset 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                signed = true
        )
        public final Builder magOfsZ(int magOfsZ) {
            this.magOfsZ = magOfsZ;
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

        public final SetMagOffsets build() {
            return new SetMagOffsets(magOfsX, magOfsY, magOfsZ, targetSystem, targetComponent);
        }
    }
}
