package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F7: format 
 */
@MavlinkMessageInfo(
        id = 175,
        crc = 171
)
public final class SerialUdbExtraF7 {
    /**
     * Serial UDB YAWKP_RUDDER Gain for Proporional control of navigation 
     */
    private final float sueYawkpRudder;

    /**
     * Serial UDB YAWKD_RUDDER Gain for Rate control of navigation 
     */
    private final float sueYawkdRudder;

    /**
     * Serial UDB Extra ROLLKP_RUDDER Gain for Proportional control of roll stabilization 
     */
    private final float sueRollkpRudder;

    /**
     * Serial UDB Extra ROLLKD_RUDDER Gain for Rate control of roll stabilization 
     */
    private final float sueRollkdRudder;

    /**
     * SERIAL UDB EXTRA Rudder Boost Gain to Manual Control when stabilized 
     */
    private final float sueRudderBoost;

    /**
     * Serial UDB Extra Return To Landing - Angle to Pitch Plane Down 
     */
    private final float sueRtlPitchDown;

    private SerialUdbExtraF7(float sueYawkpRudder, float sueYawkdRudder, float sueRollkpRudder,
            float sueRollkdRudder, float sueRudderBoost, float sueRtlPitchDown) {
        this.sueYawkpRudder = sueYawkpRudder;
        this.sueYawkdRudder = sueYawkdRudder;
        this.sueRollkpRudder = sueRollkpRudder;
        this.sueRollkdRudder = sueRollkdRudder;
        this.sueRudderBoost = sueRudderBoost;
        this.sueRtlPitchDown = sueRtlPitchDown;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "SerialUdbExtraF7{sueYawkpRudder=" + sueYawkpRudder
                 + ", sueYawkdRudder=" + sueYawkdRudder
                 + ", sueRollkpRudder=" + sueRollkpRudder
                 + ", sueRollkdRudder=" + sueRollkdRudder
                 + ", sueRudderBoost=" + sueRudderBoost
                 + ", sueRtlPitchDown=" + sueRtlPitchDown + "}";
    }

    /**
     * Serial UDB YAWKP_RUDDER Gain for Proporional control of navigation 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final float sueYawkpRudder() {
        return sueYawkpRudder;
    }

    /**
     * Serial UDB YAWKD_RUDDER Gain for Rate control of navigation 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float sueYawkdRudder() {
        return sueYawkdRudder;
    }

    /**
     * Serial UDB Extra ROLLKP_RUDDER Gain for Proportional control of roll stabilization 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float sueRollkpRudder() {
        return sueRollkpRudder;
    }

    /**
     * Serial UDB Extra ROLLKD_RUDDER Gain for Rate control of roll stabilization 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float sueRollkdRudder() {
        return sueRollkdRudder;
    }

    /**
     * SERIAL UDB EXTRA Rudder Boost Gain to Manual Control when stabilized 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float sueRudderBoost() {
        return sueRudderBoost;
    }

    /**
     * Serial UDB Extra Return To Landing - Angle to Pitch Plane Down 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float sueRtlPitchDown() {
        return sueRtlPitchDown;
    }

    public static class Builder {
        private float sueYawkpRudder;

        private float sueYawkdRudder;

        private float sueRollkpRudder;

        private float sueRollkdRudder;

        private float sueRudderBoost;

        private float sueRtlPitchDown;

        private Builder() {
        }

        /**
         * Serial UDB YAWKP_RUDDER Gain for Proporional control of navigation 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
        )
        public final Builder sueYawkpRudder(float sueYawkpRudder) {
            this.sueYawkpRudder = sueYawkpRudder;
            return this;
        }

        /**
         * Serial UDB YAWKD_RUDDER Gain for Rate control of navigation 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder sueYawkdRudder(float sueYawkdRudder) {
            this.sueYawkdRudder = sueYawkdRudder;
            return this;
        }

        /**
         * Serial UDB Extra ROLLKP_RUDDER Gain for Proportional control of roll stabilization 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder sueRollkpRudder(float sueRollkpRudder) {
            this.sueRollkpRudder = sueRollkpRudder;
            return this;
        }

        /**
         * Serial UDB Extra ROLLKD_RUDDER Gain for Rate control of roll stabilization 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder sueRollkdRudder(float sueRollkdRudder) {
            this.sueRollkdRudder = sueRollkdRudder;
            return this;
        }

        /**
         * SERIAL UDB EXTRA Rudder Boost Gain to Manual Control when stabilized 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder sueRudderBoost(float sueRudderBoost) {
            this.sueRudderBoost = sueRudderBoost;
            return this;
        }

        /**
         * Serial UDB Extra Return To Landing - Angle to Pitch Plane Down 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder sueRtlPitchDown(float sueRtlPitchDown) {
            this.sueRtlPitchDown = sueRtlPitchDown;
            return this;
        }

        public final SerialUdbExtraF7 build() {
            return new SerialUdbExtraF7(sueYawkpRudder, sueYawkdRudder, sueRollkpRudder, sueRollkdRudder, sueRudderBoost, sueRtlPitchDown);
        }
    }
}
