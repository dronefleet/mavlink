package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.math.BigInteger;

/**
 * Angle of Attack and Side Slip Angle 
 */
@MavlinkMessageInfo(
        id = 11020,
        crc = 205
)
public final class AoaSsa {
    private final BigInteger timeUsec;

    private final float aoa;

    private final float ssa;

    private AoaSsa(BigInteger timeUsec, float aoa, float ssa) {
        this.timeUsec = timeUsec;
        this.aoa = aoa;
        this.ssa = ssa;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (micros since boot or Unix epoch) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * Angle of Attack (degrees) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float aoa() {
        return this.aoa;
    }

    /**
     * Side Slip Angle (degrees) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float ssa() {
        return this.ssa;
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private float aoa;

        private float ssa;

        /**
         * Timestamp (micros since boot or Unix epoch) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * Angle of Attack (degrees) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder aoa(float aoa) {
            this.aoa = aoa;
            return this;
        }

        /**
         * Side Slip Angle (degrees) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder ssa(float ssa) {
            this.ssa = ssa;
            return this;
        }

        public final AoaSsa build() {
            return new AoaSsa(timeUsec, aoa, ssa);
        }
    }
}
