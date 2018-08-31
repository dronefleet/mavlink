package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F4: format 
 */
@MavlinkMessageInfo(
        id = 172,
        crc = 191,
        description = "Backwards compatible version of SERIAL_UDB_EXTRA F4: format"
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
            unitSize = 1,
            description = "Serial UDB Extra Roll Stabilization with Ailerons Enabled"
    )
    public final int sueRollStabilizationAilerons() {
        return this.sueRollStabilizationAilerons;
    }

    /**
     * Serial UDB Extra Roll Stabilization with Rudder Enabled 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Serial UDB Extra Roll Stabilization with Rudder Enabled"
    )
    public final int sueRollStabilizationRudder() {
        return this.sueRollStabilizationRudder;
    }

    /**
     * Serial UDB Extra Pitch Stabilization Enabled 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "Serial UDB Extra Pitch Stabilization Enabled"
    )
    public final int suePitchStabilization() {
        return this.suePitchStabilization;
    }

    /**
     * Serial UDB Extra Yaw Stabilization using Rudder Enabled 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            description = "Serial UDB Extra Yaw Stabilization using Rudder Enabled"
    )
    public final int sueYawStabilizationRudder() {
        return this.sueYawStabilizationRudder;
    }

    /**
     * Serial UDB Extra Yaw Stabilization using Ailerons Enabled 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            description = "Serial UDB Extra Yaw Stabilization using Ailerons Enabled"
    )
    public final int sueYawStabilizationAileron() {
        return this.sueYawStabilizationAileron;
    }

    /**
     * Serial UDB Extra Navigation with Ailerons Enabled 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            description = "Serial UDB Extra Navigation with Ailerons Enabled"
    )
    public final int sueAileronNavigation() {
        return this.sueAileronNavigation;
    }

    /**
     * Serial UDB Extra Navigation with Rudder Enabled 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1,
            description = "Serial UDB Extra Navigation with Rudder Enabled"
    )
    public final int sueRudderNavigation() {
        return this.sueRudderNavigation;
    }

    /**
     * Serial UDB Extra Type of Alitude Hold when in Stabilized Mode 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1,
            description = "Serial UDB Extra Type of Alitude Hold when in Stabilized Mode"
    )
    public final int sueAltitudeholdStabilized() {
        return this.sueAltitudeholdStabilized;
    }

    /**
     * Serial UDB Extra Type of Alitude Hold when in Waypoint Mode 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 1,
            description = "Serial UDB Extra Type of Alitude Hold when in Waypoint Mode"
    )
    public final int sueAltitudeholdWaypoint() {
        return this.sueAltitudeholdWaypoint;
    }

    /**
     * Serial UDB Extra Firmware racing mode enabled 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1,
            description = "Serial UDB Extra Firmware racing mode enabled"
    )
    public final int sueRacingMode() {
        return this.sueRacingMode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SerialUdbExtraF4 other = (SerialUdbExtraF4)o;
        if (!Objects.deepEquals(sueRollStabilizationAilerons, other.sueRollStabilizationAilerons)) return false;
        if (!Objects.deepEquals(sueRollStabilizationRudder, other.sueRollStabilizationRudder)) return false;
        if (!Objects.deepEquals(suePitchStabilization, other.suePitchStabilization)) return false;
        if (!Objects.deepEquals(sueYawStabilizationRudder, other.sueYawStabilizationRudder)) return false;
        if (!Objects.deepEquals(sueYawStabilizationAileron, other.sueYawStabilizationAileron)) return false;
        if (!Objects.deepEquals(sueAileronNavigation, other.sueAileronNavigation)) return false;
        if (!Objects.deepEquals(sueRudderNavigation, other.sueRudderNavigation)) return false;
        if (!Objects.deepEquals(sueAltitudeholdStabilized, other.sueAltitudeholdStabilized)) return false;
        if (!Objects.deepEquals(sueAltitudeholdWaypoint, other.sueAltitudeholdWaypoint)) return false;
        if (!Objects.deepEquals(sueRacingMode, other.sueRacingMode)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(sueRollStabilizationAilerons);
        result = 31 * result + Objects.hashCode(sueRollStabilizationRudder);
        result = 31 * result + Objects.hashCode(suePitchStabilization);
        result = 31 * result + Objects.hashCode(sueYawStabilizationRudder);
        result = 31 * result + Objects.hashCode(sueYawStabilizationAileron);
        result = 31 * result + Objects.hashCode(sueAileronNavigation);
        result = 31 * result + Objects.hashCode(sueRudderNavigation);
        result = 31 * result + Objects.hashCode(sueAltitudeholdStabilized);
        result = 31 * result + Objects.hashCode(sueAltitudeholdWaypoint);
        result = 31 * result + Objects.hashCode(sueRacingMode);
        return result;
    }

    @Override
    public String toString() {
        return "SerialUdbExtraF4{sueRollStabilizationAilerons=" + sueRollStabilizationAilerons
                 + ", sueRollStabilizationRudder=" + sueRollStabilizationRudder
                 + ", suePitchStabilization=" + suePitchStabilization
                 + ", sueYawStabilizationRudder=" + sueYawStabilizationRudder
                 + ", sueYawStabilizationAileron=" + sueYawStabilizationAileron
                 + ", sueAileronNavigation=" + sueAileronNavigation
                 + ", sueRudderNavigation=" + sueRudderNavigation
                 + ", sueAltitudeholdStabilized=" + sueAltitudeholdStabilized
                 + ", sueAltitudeholdWaypoint=" + sueAltitudeholdWaypoint
                 + ", sueRacingMode=" + sueRacingMode + "}";
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
                unitSize = 1,
                description = "Serial UDB Extra Roll Stabilization with Ailerons Enabled"
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
                unitSize = 1,
                description = "Serial UDB Extra Roll Stabilization with Rudder Enabled"
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
                unitSize = 1,
                description = "Serial UDB Extra Pitch Stabilization Enabled"
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
                unitSize = 1,
                description = "Serial UDB Extra Yaw Stabilization using Rudder Enabled"
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
                unitSize = 1,
                description = "Serial UDB Extra Yaw Stabilization using Ailerons Enabled"
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
                unitSize = 1,
                description = "Serial UDB Extra Navigation with Ailerons Enabled"
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
                unitSize = 1,
                description = "Serial UDB Extra Navigation with Rudder Enabled"
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
                unitSize = 1,
                description = "Serial UDB Extra Type of Alitude Hold when in Stabilized Mode"
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
                unitSize = 1,
                description = "Serial UDB Extra Type of Alitude Hold when in Waypoint Mode"
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
                unitSize = 1,
                description = "Serial UDB Extra Firmware racing mode enabled"
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
