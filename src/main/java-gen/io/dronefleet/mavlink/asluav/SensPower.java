package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Voltage and current sensor data 
 */
@MavlinkMessageInfo(
        id = 201,
        crc = 218
)
public final class SensPower {
    private final float adc121VspbVolt;

    private final float adc121CspbAmp;

    private final float adc121Cs1Amp;

    private final float adc121Cs2Amp;

    private SensPower(float adc121VspbVolt, float adc121CspbAmp, float adc121Cs1Amp,
            float adc121Cs2Amp) {
        this.adc121VspbVolt = adc121VspbVolt;
        this.adc121CspbAmp = adc121CspbAmp;
        this.adc121Cs1Amp = adc121Cs1Amp;
        this.adc121Cs2Amp = adc121Cs2Amp;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Power board voltage sensor reading 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final float adc121VspbVolt() {
        return this.adc121VspbVolt;
    }

    /**
     * Power board current sensor reading 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float adc121CspbAmp() {
        return this.adc121CspbAmp;
    }

    /**
     * Board current sensor 1 reading 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float adc121Cs1Amp() {
        return this.adc121Cs1Amp;
    }

    /**
     * Board current sensor 2 reading 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float adc121Cs2Amp() {
        return this.adc121Cs2Amp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SensPower other = (SensPower)o;
        if (!Objects.deepEquals(adc121VspbVolt, other.adc121VspbVolt)) return false;
        if (!Objects.deepEquals(adc121CspbAmp, other.adc121CspbAmp)) return false;
        if (!Objects.deepEquals(adc121Cs1Amp, other.adc121Cs1Amp)) return false;
        if (!Objects.deepEquals(adc121Cs2Amp, other.adc121Cs2Amp)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(adc121VspbVolt);
        result = 31 * result + Objects.hashCode(adc121CspbAmp);
        result = 31 * result + Objects.hashCode(adc121Cs1Amp);
        result = 31 * result + Objects.hashCode(adc121Cs2Amp);
        return result;
    }

    @Override
    public String toString() {
        return "SensPower{adc121VspbVolt=" + adc121VspbVolt
                 + ", adc121CspbAmp=" + adc121CspbAmp
                 + ", adc121Cs1Amp=" + adc121Cs1Amp
                 + ", adc121Cs2Amp=" + adc121Cs2Amp + "}";
    }

    public static final class Builder {
        private float adc121VspbVolt;

        private float adc121CspbAmp;

        private float adc121Cs1Amp;

        private float adc121Cs2Amp;

        /**
         * Power board voltage sensor reading 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
        )
        public final Builder adc121VspbVolt(float adc121VspbVolt) {
            this.adc121VspbVolt = adc121VspbVolt;
            return this;
        }

        /**
         * Power board current sensor reading 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder adc121CspbAmp(float adc121CspbAmp) {
            this.adc121CspbAmp = adc121CspbAmp;
            return this;
        }

        /**
         * Board current sensor 1 reading 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder adc121Cs1Amp(float adc121Cs1Amp) {
            this.adc121Cs1Amp = adc121Cs1Amp;
            return this;
        }

        /**
         * Board current sensor 2 reading 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder adc121Cs2Amp(float adc121Cs2Amp) {
            this.adc121Cs2Amp = adc121Cs2Amp;
            return this;
        }

        public final SensPower build() {
            return new SensPower(adc121VspbVolt, adc121CspbAmp, adc121Cs1Amp, adc121Cs2Amp);
        }
    }
}
