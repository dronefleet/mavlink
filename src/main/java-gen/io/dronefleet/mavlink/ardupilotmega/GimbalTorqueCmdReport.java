package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * 100 Hz gimbal torque command telemetry 
 */
@MavlinkMessageInfo(
        id = 214,
        crc = 69
)
public final class GimbalTorqueCmdReport {
    /**
     * Roll Torque Command 
     */
    private final int rlTorqueCmd;

    /**
     * Elevation Torque Command 
     */
    private final int elTorqueCmd;

    /**
     * Azimuth Torque Command 
     */
    private final int azTorqueCmd;

    /**
     * System ID 
     */
    private final int targetSystem;

    /**
     * Component ID 
     */
    private final int targetComponent;

    private GimbalTorqueCmdReport(int rlTorqueCmd, int elTorqueCmd, int azTorqueCmd,
            int targetSystem, int targetComponent) {
        this.rlTorqueCmd = rlTorqueCmd;
        this.elTorqueCmd = elTorqueCmd;
        this.azTorqueCmd = azTorqueCmd;
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "GimbalTorqueCmdReport{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", rlTorqueCmd=" + rlTorqueCmd
                 + ", elTorqueCmd=" + elTorqueCmd
                 + ", azTorqueCmd=" + azTorqueCmd + "}";
    }

    /**
     * Roll Torque Command 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            signed = true
    )
    public final int rlTorqueCmd() {
        return rlTorqueCmd;
    }

    /**
     * Elevation Torque Command 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            signed = true
    )
    public final int elTorqueCmd() {
        return elTorqueCmd;
    }

    /**
     * Azimuth Torque Command 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            signed = true
    )
    public final int azTorqueCmd() {
        return azTorqueCmd;
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
        private int rlTorqueCmd;

        private int elTorqueCmd;

        private int azTorqueCmd;

        private int targetSystem;

        private int targetComponent;

        private Builder() {
        }

        /**
         * Roll Torque Command 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                signed = true
        )
        public final Builder rlTorqueCmd(int rlTorqueCmd) {
            this.rlTorqueCmd = rlTorqueCmd;
            return this;
        }

        /**
         * Elevation Torque Command 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                signed = true
        )
        public final Builder elTorqueCmd(int elTorqueCmd) {
            this.elTorqueCmd = elTorqueCmd;
            return this;
        }

        /**
         * Azimuth Torque Command 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                signed = true
        )
        public final Builder azTorqueCmd(int azTorqueCmd) {
            this.azTorqueCmd = azTorqueCmd;
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

        public final GimbalTorqueCmdReport build() {
            return new GimbalTorqueCmdReport(rlTorqueCmd, elTorqueCmd, azTorqueCmd, targetSystem, targetComponent);
        }
    }
}
