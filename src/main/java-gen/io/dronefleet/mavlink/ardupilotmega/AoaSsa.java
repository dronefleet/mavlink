package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        AoaSsa other = (AoaSsa)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(aoa, other.aoa)) return false;
        if (!Objects.deepEquals(ssa, other.ssa)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(aoa);
        result = 31 * result + Objects.hashCode(ssa);
        return result;
    }

    @Override
    public String toString() {
        return "AoaSsa{timeUsec=" + timeUsec
                 + ", aoa=" + aoa
                 + ", ssa=" + ssa + "}";
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
