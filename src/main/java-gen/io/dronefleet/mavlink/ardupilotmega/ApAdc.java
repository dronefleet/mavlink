package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Raw ADC output. 
 */
@MavlinkMessageInfo(
        id = 153,
        crc = 188,
        description = "Raw ADC output."
)
public final class ApAdc {
    private final int adc1;

    private final int adc2;

    private final int adc3;

    private final int adc4;

    private final int adc5;

    private final int adc6;

    private ApAdc(int adc1, int adc2, int adc3, int adc4, int adc5, int adc6) {
        this.adc1 = adc1;
        this.adc2 = adc2;
        this.adc3 = adc3;
        this.adc4 = adc4;
        this.adc5 = adc5;
        this.adc6 = adc6;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * ADC output 1. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 2,
            description = "ADC output 1."
    )
    public final int adc1() {
        return this.adc1;
    }

    /**
     * ADC output 2. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            description = "ADC output 2."
    )
    public final int adc2() {
        return this.adc2;
    }

    /**
     * ADC output 3. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            description = "ADC output 3."
    )
    public final int adc3() {
        return this.adc3;
    }

    /**
     * ADC output 4. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            description = "ADC output 4."
    )
    public final int adc4() {
        return this.adc4;
    }

    /**
     * ADC output 5. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            description = "ADC output 5."
    )
    public final int adc5() {
        return this.adc5;
    }

    /**
     * ADC output 6. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            description = "ADC output 6."
    )
    public final int adc6() {
        return this.adc6;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ApAdc other = (ApAdc)o;
        if (!Objects.deepEquals(adc1, other.adc1)) return false;
        if (!Objects.deepEquals(adc2, other.adc2)) return false;
        if (!Objects.deepEquals(adc3, other.adc3)) return false;
        if (!Objects.deepEquals(adc4, other.adc4)) return false;
        if (!Objects.deepEquals(adc5, other.adc5)) return false;
        if (!Objects.deepEquals(adc6, other.adc6)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(adc1);
        result = 31 * result + Objects.hashCode(adc2);
        result = 31 * result + Objects.hashCode(adc3);
        result = 31 * result + Objects.hashCode(adc4);
        result = 31 * result + Objects.hashCode(adc5);
        result = 31 * result + Objects.hashCode(adc6);
        return result;
    }

    @Override
    public String toString() {
        return "ApAdc{adc1=" + adc1
                 + ", adc2=" + adc2
                 + ", adc3=" + adc3
                 + ", adc4=" + adc4
                 + ", adc5=" + adc5
                 + ", adc6=" + adc6 + "}";
    }

    public static final class Builder {
        private int adc1;

        private int adc2;

        private int adc3;

        private int adc4;

        private int adc5;

        private int adc6;

        /**
         * ADC output 1. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 2,
                description = "ADC output 1."
        )
        public final Builder adc1(int adc1) {
            this.adc1 = adc1;
            return this;
        }

        /**
         * ADC output 2. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                description = "ADC output 2."
        )
        public final Builder adc2(int adc2) {
            this.adc2 = adc2;
            return this;
        }

        /**
         * ADC output 3. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                description = "ADC output 3."
        )
        public final Builder adc3(int adc3) {
            this.adc3 = adc3;
            return this;
        }

        /**
         * ADC output 4. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                description = "ADC output 4."
        )
        public final Builder adc4(int adc4) {
            this.adc4 = adc4;
            return this;
        }

        /**
         * ADC output 5. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                description = "ADC output 5."
        )
        public final Builder adc5(int adc5) {
            this.adc5 = adc5;
            return this;
        }

        /**
         * ADC output 6. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                description = "ADC output 6."
        )
        public final Builder adc6(int adc6) {
            this.adc6 = adc6;
            return this;
        }

        public final ApAdc build() {
            return new ApAdc(adc1, adc2, adc3, adc4, adc5, adc6);
        }
    }
}
