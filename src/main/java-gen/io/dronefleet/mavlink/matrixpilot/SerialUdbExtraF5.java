package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F5: format 
 */
@MavlinkMessageInfo(
        id = 173,
        crc = 54
)
public final class SerialUdbExtraF5 {
    private final float sueYawkpAileron;

    private final float sueYawkdAileron;

    private final float sueRollkp;

    private final float sueRollkd;

    private SerialUdbExtraF5(float sueYawkpAileron, float sueYawkdAileron, float sueRollkp,
            float sueRollkd) {
        this.sueYawkpAileron = sueYawkpAileron;
        this.sueYawkdAileron = sueYawkdAileron;
        this.sueRollkp = sueRollkp;
        this.sueRollkd = sueRollkd;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Serial UDB YAWKP_AILERON Gain for Proporional control of navigation 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final float sueYawkpAileron() {
        return this.sueYawkpAileron;
    }

    /**
     * Serial UDB YAWKD_AILERON Gain for Rate control of navigation 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float sueYawkdAileron() {
        return this.sueYawkdAileron;
    }

    /**
     * Serial UDB Extra ROLLKP Gain for Proportional control of roll stabilization 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float sueRollkp() {
        return this.sueRollkp;
    }

    /**
     * Serial UDB Extra ROLLKD Gain for Rate control of roll stabilization 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float sueRollkd() {
        return this.sueRollkd;
    }

    public static final class Builder {
        private float sueYawkpAileron;

        private float sueYawkdAileron;

        private float sueRollkp;

        private float sueRollkd;

        /**
         * Serial UDB YAWKP_AILERON Gain for Proporional control of navigation 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
        )
        public final Builder sueYawkpAileron(float sueYawkpAileron) {
            this.sueYawkpAileron = sueYawkpAileron;
            return this;
        }

        /**
         * Serial UDB YAWKD_AILERON Gain for Rate control of navigation 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder sueYawkdAileron(float sueYawkdAileron) {
            this.sueYawkdAileron = sueYawkdAileron;
            return this;
        }

        /**
         * Serial UDB Extra ROLLKP Gain for Proportional control of roll stabilization 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder sueRollkp(float sueRollkp) {
            this.sueRollkp = sueRollkp;
            return this;
        }

        /**
         * Serial UDB Extra ROLLKD Gain for Rate control of roll stabilization 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder sueRollkd(float sueRollkd) {
            this.sueRollkd = sueRollkd;
            return this;
        }

        public final SerialUdbExtraF5 build() {
            return new SerialUdbExtraF5(sueYawkpAileron, sueYawkdAileron, sueRollkp, sueRollkd);
        }
    }
}
