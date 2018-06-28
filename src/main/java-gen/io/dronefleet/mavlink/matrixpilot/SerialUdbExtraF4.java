package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F4: format 
 */
@MavlinkMessageInfo(
        id = 172,
        crc = 191
)
public final class SerialUdbExtraF4 {
    private final int sueRollStabilizationAilerons;

    private final int sueRollStabilizationRudder;

    private final int suePitchStabilization;

    private final int sueYawStabilizationRudder;

    private final int sueYawStabilizationAileron;

    private final int sueAileronNavigation;

    private final int sueRudderNavigation;

    private final int sueAltitudeholdStabilized;

    private final int sueAltitudeholdWaypoint;

    private final int sueRacingMode;

    private SerialUdbExtraF4(int sueRollStabilizationAilerons, int sueRollStabilizationRudder,
            int suePitchStabilization, int sueYawStabilizationRudder,
            int sueYawStabilizationAileron, int sueAileronNavigation, int sueRudderNavigation,
            int sueAltitudeholdStabilized, int sueAltitudeholdWaypoint, int sueRacingMode) {
        this.sueRollStabilizationAilerons = sueRollStabilizationAilerons;
        this.sueRollStabilizationRudder = sueRollStabilizationRudder;
        this.suePitchStabilization = suePitchStabilization;
        this.sueYawStabilizationRudder = sueYawStabilizationRudder;
        this.sueYawStabilizationAileron = sueYawStabilizationAileron;
        this.sueAileronNavigation = sueAileronNavigation;
        this.sueRudderNavigation = sueRudderNavigation;
        this.sueAltitudeholdStabilized = sueAltitudeholdStabilized;
        this.sueAltitudeholdWaypoint = sueAltitudeholdWaypoint;
        this.sueRacingMode = sueRacingMode;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Serial UDB Extra Roll Stabilization with Ailerons Enabled 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int sueRollStabilizationAilerons() {
        return this.sueRollStabilizationAilerons;
    }

    /**
     * Serial UDB Extra Roll Stabilization with Rudder Enabled 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int sueRollStabilizationRudder() {
        return this.sueRollStabilizationRudder;
    }

    /**
     * Serial UDB Extra Pitch Stabilization Enabled 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final int suePitchStabilization() {
        return this.suePitchStabilization;
    }

    /**
     * Serial UDB Extra Yaw Stabilization using Rudder Enabled 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final int sueYawStabilizationRudder() {
        return this.sueYawStabilizationRudder;
    }

    /**
     * Serial UDB Extra Yaw Stabilization using Ailerons Enabled 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final int sueYawStabilizationAileron() {
        return this.sueYawStabilizationAileron;
    }

    /**
     * Serial UDB Extra Navigation with Ailerons Enabled 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1
    )
    public final int sueAileronNavigation() {
        return this.sueAileronNavigation;
    }

    /**
     * Serial UDB Extra Navigation with Rudder Enabled 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1
    )
    public final int sueRudderNavigation() {
        return this.sueRudderNavigation;
    }

    /**
     * Serial UDB Extra Type of Alitude Hold when in Stabilized Mode 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1
    )
    public final int sueAltitudeholdStabilized() {
        return this.sueAltitudeholdStabilized;
    }

    /**
     * Serial UDB Extra Type of Alitude Hold when in Waypoint Mode 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 1
    )
    public final int sueAltitudeholdWaypoint() {
        return this.sueAltitudeholdWaypoint;
    }

    /**
     * Serial UDB Extra Firmware racing mode enabled 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1
    )
    public final int sueRacingMode() {
        return this.sueRacingMode;
    }

    public static final class Builder {
        private int sueRollStabilizationAilerons;

        private int sueRollStabilizationRudder;

        private int suePitchStabilization;

        private int sueYawStabilizationRudder;

        private int sueYawStabilizationAileron;

        private int sueAileronNavigation;

        private int sueRudderNavigation;

        private int sueAltitudeholdStabilized;

        private int sueAltitudeholdWaypoint;

        private int sueRacingMode;

        /**
         * Serial UDB Extra Roll Stabilization with Ailerons Enabled 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder sueRollStabilizationAilerons(int sueRollStabilizationAilerons) {
            this.sueRollStabilizationAilerons = sueRollStabilizationAilerons;
            return this;
        }

        /**
         * Serial UDB Extra Roll Stabilization with Rudder Enabled 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder sueRollStabilizationRudder(int sueRollStabilizationRudder) {
            this.sueRollStabilizationRudder = sueRollStabilizationRudder;
            return this;
        }

        /**
         * Serial UDB Extra Pitch Stabilization Enabled 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder suePitchStabilization(int suePitchStabilization) {
            this.suePitchStabilization = suePitchStabilization;
            return this;
        }

        /**
         * Serial UDB Extra Yaw Stabilization using Rudder Enabled 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1
        )
        public final Builder sueYawStabilizationRudder(int sueYawStabilizationRudder) {
            this.sueYawStabilizationRudder = sueYawStabilizationRudder;
            return this;
        }

        /**
         * Serial UDB Extra Yaw Stabilization using Ailerons Enabled 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1
        )
        public final Builder sueYawStabilizationAileron(int sueYawStabilizationAileron) {
            this.sueYawStabilizationAileron = sueYawStabilizationAileron;
            return this;
        }

        /**
         * Serial UDB Extra Navigation with Ailerons Enabled 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1
        )
        public final Builder sueAileronNavigation(int sueAileronNavigation) {
            this.sueAileronNavigation = sueAileronNavigation;
            return this;
        }

        /**
         * Serial UDB Extra Navigation with Rudder Enabled 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1
        )
        public final Builder sueRudderNavigation(int sueRudderNavigation) {
            this.sueRudderNavigation = sueRudderNavigation;
            return this;
        }

        /**
         * Serial UDB Extra Type of Alitude Hold when in Stabilized Mode 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 1
        )
        public final Builder sueAltitudeholdStabilized(int sueAltitudeholdStabilized) {
            this.sueAltitudeholdStabilized = sueAltitudeholdStabilized;
            return this;
        }

        /**
         * Serial UDB Extra Type of Alitude Hold when in Waypoint Mode 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 1
        )
        public final Builder sueAltitudeholdWaypoint(int sueAltitudeholdWaypoint) {
            this.sueAltitudeholdWaypoint = sueAltitudeholdWaypoint;
            return this;
        }

        /**
         * Serial UDB Extra Firmware racing mode enabled 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 1
        )
        public final Builder sueRacingMode(int sueRacingMode) {
            this.sueRacingMode = sueRacingMode;
            return this;
        }

        public final SerialUdbExtraF4 build() {
            return new SerialUdbExtraF4(sueRollStabilizationAilerons, sueRollStabilizationRudder, suePitchStabilization, sueYawStabilizationRudder, sueYawStabilizationAileron, sueAileronNavigation, sueRudderNavigation, sueAltitudeholdStabilized, sueAltitudeholdWaypoint, sueRacingMode);
        }
    }
}
