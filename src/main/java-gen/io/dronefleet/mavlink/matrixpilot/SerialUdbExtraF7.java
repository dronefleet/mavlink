package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F7: format 
 */
@MavlinkMessageInfo(
        id = 175,
        crc = 171
)
public final class SerialUdbExtraF7 {
    private final float sueYawkpRudder;

    private final float sueYawkdRudder;

    private final float sueRollkpRudder;

    private final float sueRollkdRudder;

    private final float sueRudderBoost;

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

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Serial UDB YAWKP_RUDDER Gain for Proporional control of navigation 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final float sueYawkpRudder() {
        return this.sueYawkpRudder;
    }

    /**
     * Serial UDB YAWKD_RUDDER Gain for Rate control of navigation 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float sueYawkdRudder() {
        return this.sueYawkdRudder;
    }

    /**
     * Serial UDB Extra ROLLKP_RUDDER Gain for Proportional control of roll stabilization 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float sueRollkpRudder() {
        return this.sueRollkpRudder;
    }

    /**
     * Serial UDB Extra ROLLKD_RUDDER Gain for Rate control of roll stabilization 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float sueRollkdRudder() {
        return this.sueRollkdRudder;
    }

    /**
     * SERIAL UDB EXTRA Rudder Boost Gain to Manual Control when stabilized 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float sueRudderBoost() {
        return this.sueRudderBoost;
    }

    /**
     * Serial UDB Extra Return To Landing - Angle to Pitch Plane Down 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float sueRtlPitchDown() {
        return this.sueRtlPitchDown;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SerialUdbExtraF7 other = (SerialUdbExtraF7)o;
        if (!Objects.deepEquals(sueYawkpRudder, other.sueYawkpRudder)) return false;
        if (!Objects.deepEquals(sueYawkdRudder, other.sueYawkdRudder)) return false;
        if (!Objects.deepEquals(sueRollkpRudder, other.sueRollkpRudder)) return false;
        if (!Objects.deepEquals(sueRollkdRudder, other.sueRollkdRudder)) return false;
        if (!Objects.deepEquals(sueRudderBoost, other.sueRudderBoost)) return false;
        if (!Objects.deepEquals(sueRtlPitchDown, other.sueRtlPitchDown)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(sueYawkpRudder);
        result = 31 * result + Objects.hashCode(sueYawkdRudder);
        result = 31 * result + Objects.hashCode(sueRollkpRudder);
        result = 31 * result + Objects.hashCode(sueRollkdRudder);
        result = 31 * result + Objects.hashCode(sueRudderBoost);
        result = 31 * result + Objects.hashCode(sueRtlPitchDown);
        return result;
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

    public static final class Builder {
        private float sueYawkpRudder;

        private float sueYawkdRudder;

        private float sueRollkpRudder;

        private float sueRollkdRudder;

        private float sueRudderBoost;

        private float sueRtlPitchDown;

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
