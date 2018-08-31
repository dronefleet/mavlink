package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F20 format 
 */
@MavlinkMessageInfo(
        id = 186,
        crc = 144,
        description = "Backwards compatible version of SERIAL_UDB_EXTRA F20 format"
)
public final class SerialUdbExtraF20 {
    private final int sueNumberOfInputs;

    private final int sueTrimValueInput1;

    private final int sueTrimValueInput2;

    private final int sueTrimValueInput3;

    private final int sueTrimValueInput4;

    private final int sueTrimValueInput5;

    private final int sueTrimValueInput6;

    private final int sueTrimValueInput7;

    private final int sueTrimValueInput8;

    private final int sueTrimValueInput9;

    private final int sueTrimValueInput10;

    private final int sueTrimValueInput11;

    private final int sueTrimValueInput12;

    private SerialUdbExtraF20(int sueNumberOfInputs, int sueTrimValueInput1, int sueTrimValueInput2,
            int sueTrimValueInput3, int sueTrimValueInput4, int sueTrimValueInput5,
            int sueTrimValueInput6, int sueTrimValueInput7, int sueTrimValueInput8,
            int sueTrimValueInput9, int sueTrimValueInput10, int sueTrimValueInput11,
            int sueTrimValueInput12) {
        this.sueNumberOfInputs = sueNumberOfInputs;
        this.sueTrimValueInput1 = sueTrimValueInput1;
        this.sueTrimValueInput2 = sueTrimValueInput2;
        this.sueTrimValueInput3 = sueTrimValueInput3;
        this.sueTrimValueInput4 = sueTrimValueInput4;
        this.sueTrimValueInput5 = sueTrimValueInput5;
        this.sueTrimValueInput6 = sueTrimValueInput6;
        this.sueTrimValueInput7 = sueTrimValueInput7;
        this.sueTrimValueInput8 = sueTrimValueInput8;
        this.sueTrimValueInput9 = sueTrimValueInput9;
        this.sueTrimValueInput10 = sueTrimValueInput10;
        this.sueTrimValueInput11 = sueTrimValueInput11;
        this.sueTrimValueInput12 = sueTrimValueInput12;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * SUE Number of Input Channels 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "SUE Number of Input Channels"
    )
    public final int sueNumberOfInputs() {
        return this.sueNumberOfInputs;
    }

    /**
     * SUE UDB PWM Trim Value on Input 1 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            signed = true,
            description = "SUE UDB PWM Trim Value on Input 1"
    )
    public final int sueTrimValueInput1() {
        return this.sueTrimValueInput1;
    }

    /**
     * SUE UDB PWM Trim Value on Input 2 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            signed = true,
            description = "SUE UDB PWM Trim Value on Input 2"
    )
    public final int sueTrimValueInput2() {
        return this.sueTrimValueInput2;
    }

    /**
     * SUE UDB PWM Trim Value on Input 3 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            signed = true,
            description = "SUE UDB PWM Trim Value on Input 3"
    )
    public final int sueTrimValueInput3() {
        return this.sueTrimValueInput3;
    }

    /**
     * SUE UDB PWM Trim Value on Input 4 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            signed = true,
            description = "SUE UDB PWM Trim Value on Input 4"
    )
    public final int sueTrimValueInput4() {
        return this.sueTrimValueInput4;
    }

    /**
     * SUE UDB PWM Trim Value on Input 5 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            signed = true,
            description = "SUE UDB PWM Trim Value on Input 5"
    )
    public final int sueTrimValueInput5() {
        return this.sueTrimValueInput5;
    }

    /**
     * SUE UDB PWM Trim Value on Input 6 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            signed = true,
            description = "SUE UDB PWM Trim Value on Input 6"
    )
    public final int sueTrimValueInput6() {
        return this.sueTrimValueInput6;
    }

    /**
     * SUE UDB PWM Trim Value on Input 7 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2,
            signed = true,
            description = "SUE UDB PWM Trim Value on Input 7"
    )
    public final int sueTrimValueInput7() {
        return this.sueTrimValueInput7;
    }

    /**
     * SUE UDB PWM Trim Value on Input 8 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2,
            signed = true,
            description = "SUE UDB PWM Trim Value on Input 8"
    )
    public final int sueTrimValueInput8() {
        return this.sueTrimValueInput8;
    }

    /**
     * SUE UDB PWM Trim Value on Input 9 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 2,
            signed = true,
            description = "SUE UDB PWM Trim Value on Input 9"
    )
    public final int sueTrimValueInput9() {
        return this.sueTrimValueInput9;
    }

    /**
     * SUE UDB PWM Trim Value on Input 10 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 2,
            signed = true,
            description = "SUE UDB PWM Trim Value on Input 10"
    )
    public final int sueTrimValueInput10() {
        return this.sueTrimValueInput10;
    }

    /**
     * SUE UDB PWM Trim Value on Input 11 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 2,
            signed = true,
            description = "SUE UDB PWM Trim Value on Input 11"
    )
    public final int sueTrimValueInput11() {
        return this.sueTrimValueInput11;
    }

    /**
     * SUE UDB PWM Trim Value on Input 12 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 2,
            signed = true,
            description = "SUE UDB PWM Trim Value on Input 12"
    )
    public final int sueTrimValueInput12() {
        return this.sueTrimValueInput12;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SerialUdbExtraF20 other = (SerialUdbExtraF20)o;
        if (!Objects.deepEquals(sueNumberOfInputs, other.sueNumberOfInputs)) return false;
        if (!Objects.deepEquals(sueTrimValueInput1, other.sueTrimValueInput1)) return false;
        if (!Objects.deepEquals(sueTrimValueInput2, other.sueTrimValueInput2)) return false;
        if (!Objects.deepEquals(sueTrimValueInput3, other.sueTrimValueInput3)) return false;
        if (!Objects.deepEquals(sueTrimValueInput4, other.sueTrimValueInput4)) return false;
        if (!Objects.deepEquals(sueTrimValueInput5, other.sueTrimValueInput5)) return false;
        if (!Objects.deepEquals(sueTrimValueInput6, other.sueTrimValueInput6)) return false;
        if (!Objects.deepEquals(sueTrimValueInput7, other.sueTrimValueInput7)) return false;
        if (!Objects.deepEquals(sueTrimValueInput8, other.sueTrimValueInput8)) return false;
        if (!Objects.deepEquals(sueTrimValueInput9, other.sueTrimValueInput9)) return false;
        if (!Objects.deepEquals(sueTrimValueInput10, other.sueTrimValueInput10)) return false;
        if (!Objects.deepEquals(sueTrimValueInput11, other.sueTrimValueInput11)) return false;
        if (!Objects.deepEquals(sueTrimValueInput12, other.sueTrimValueInput12)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(sueNumberOfInputs);
        result = 31 * result + Objects.hashCode(sueTrimValueInput1);
        result = 31 * result + Objects.hashCode(sueTrimValueInput2);
        result = 31 * result + Objects.hashCode(sueTrimValueInput3);
        result = 31 * result + Objects.hashCode(sueTrimValueInput4);
        result = 31 * result + Objects.hashCode(sueTrimValueInput5);
        result = 31 * result + Objects.hashCode(sueTrimValueInput6);
        result = 31 * result + Objects.hashCode(sueTrimValueInput7);
        result = 31 * result + Objects.hashCode(sueTrimValueInput8);
        result = 31 * result + Objects.hashCode(sueTrimValueInput9);
        result = 31 * result + Objects.hashCode(sueTrimValueInput10);
        result = 31 * result + Objects.hashCode(sueTrimValueInput11);
        result = 31 * result + Objects.hashCode(sueTrimValueInput12);
        return result;
    }

    @Override
    public String toString() {
        return "SerialUdbExtraF20{sueNumberOfInputs=" + sueNumberOfInputs
                 + ", sueTrimValueInput1=" + sueTrimValueInput1
                 + ", sueTrimValueInput2=" + sueTrimValueInput2
                 + ", sueTrimValueInput3=" + sueTrimValueInput3
                 + ", sueTrimValueInput4=" + sueTrimValueInput4
                 + ", sueTrimValueInput5=" + sueTrimValueInput5
                 + ", sueTrimValueInput6=" + sueTrimValueInput6
                 + ", sueTrimValueInput7=" + sueTrimValueInput7
                 + ", sueTrimValueInput8=" + sueTrimValueInput8
                 + ", sueTrimValueInput9=" + sueTrimValueInput9
                 + ", sueTrimValueInput10=" + sueTrimValueInput10
                 + ", sueTrimValueInput11=" + sueTrimValueInput11
                 + ", sueTrimValueInput12=" + sueTrimValueInput12 + "}";
    }

    public static final class Builder {
        private int sueNumberOfInputs;

        private int sueTrimValueInput1;

        private int sueTrimValueInput2;

        private int sueTrimValueInput3;

        private int sueTrimValueInput4;

        private int sueTrimValueInput5;

        private int sueTrimValueInput6;

        private int sueTrimValueInput7;

        private int sueTrimValueInput8;

        private int sueTrimValueInput9;

        private int sueTrimValueInput10;

        private int sueTrimValueInput11;

        private int sueTrimValueInput12;

        /**
         * SUE Number of Input Channels 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "SUE Number of Input Channels"
        )
        public final Builder sueNumberOfInputs(int sueNumberOfInputs) {
            this.sueNumberOfInputs = sueNumberOfInputs;
            return this;
        }

        /**
         * SUE UDB PWM Trim Value on Input 1 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                signed = true,
                description = "SUE UDB PWM Trim Value on Input 1"
        )
        public final Builder sueTrimValueInput1(int sueTrimValueInput1) {
            this.sueTrimValueInput1 = sueTrimValueInput1;
            return this;
        }

        /**
         * SUE UDB PWM Trim Value on Input 2 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                signed = true,
                description = "SUE UDB PWM Trim Value on Input 2"
        )
        public final Builder sueTrimValueInput2(int sueTrimValueInput2) {
            this.sueTrimValueInput2 = sueTrimValueInput2;
            return this;
        }

        /**
         * SUE UDB PWM Trim Value on Input 3 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                signed = true,
                description = "SUE UDB PWM Trim Value on Input 3"
        )
        public final Builder sueTrimValueInput3(int sueTrimValueInput3) {
            this.sueTrimValueInput3 = sueTrimValueInput3;
            return this;
        }

        /**
         * SUE UDB PWM Trim Value on Input 4 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                signed = true,
                description = "SUE UDB PWM Trim Value on Input 4"
        )
        public final Builder sueTrimValueInput4(int sueTrimValueInput4) {
            this.sueTrimValueInput4 = sueTrimValueInput4;
            return this;
        }

        /**
         * SUE UDB PWM Trim Value on Input 5 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                signed = true,
                description = "SUE UDB PWM Trim Value on Input 5"
        )
        public final Builder sueTrimValueInput5(int sueTrimValueInput5) {
            this.sueTrimValueInput5 = sueTrimValueInput5;
            return this;
        }

        /**
         * SUE UDB PWM Trim Value on Input 6 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                signed = true,
                description = "SUE UDB PWM Trim Value on Input 6"
        )
        public final Builder sueTrimValueInput6(int sueTrimValueInput6) {
            this.sueTrimValueInput6 = sueTrimValueInput6;
            return this;
        }

        /**
         * SUE UDB PWM Trim Value on Input 7 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2,
                signed = true,
                description = "SUE UDB PWM Trim Value on Input 7"
        )
        public final Builder sueTrimValueInput7(int sueTrimValueInput7) {
            this.sueTrimValueInput7 = sueTrimValueInput7;
            return this;
        }

        /**
         * SUE UDB PWM Trim Value on Input 8 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2,
                signed = true,
                description = "SUE UDB PWM Trim Value on Input 8"
        )
        public final Builder sueTrimValueInput8(int sueTrimValueInput8) {
            this.sueTrimValueInput8 = sueTrimValueInput8;
            return this;
        }

        /**
         * SUE UDB PWM Trim Value on Input 9 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 2,
                signed = true,
                description = "SUE UDB PWM Trim Value on Input 9"
        )
        public final Builder sueTrimValueInput9(int sueTrimValueInput9) {
            this.sueTrimValueInput9 = sueTrimValueInput9;
            return this;
        }

        /**
         * SUE UDB PWM Trim Value on Input 10 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 2,
                signed = true,
                description = "SUE UDB PWM Trim Value on Input 10"
        )
        public final Builder sueTrimValueInput10(int sueTrimValueInput10) {
            this.sueTrimValueInput10 = sueTrimValueInput10;
            return this;
        }

        /**
         * SUE UDB PWM Trim Value on Input 11 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 2,
                signed = true,
                description = "SUE UDB PWM Trim Value on Input 11"
        )
        public final Builder sueTrimValueInput11(int sueTrimValueInput11) {
            this.sueTrimValueInput11 = sueTrimValueInput11;
            return this;
        }

        /**
         * SUE UDB PWM Trim Value on Input 12 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 2,
                signed = true,
                description = "SUE UDB PWM Trim Value on Input 12"
        )
        public final Builder sueTrimValueInput12(int sueTrimValueInput12) {
            this.sueTrimValueInput12 = sueTrimValueInput12;
            return this;
        }

        public final SerialUdbExtraF20 build() {
            return new SerialUdbExtraF20(sueNumberOfInputs, sueTrimValueInput1, sueTrimValueInput2, sueTrimValueInput3, sueTrimValueInput4, sueTrimValueInput5, sueTrimValueInput6, sueTrimValueInput7, sueTrimValueInput8, sueTrimValueInput9, sueTrimValueInput10, sueTrimValueInput11, sueTrimValueInput12);
        }
    }
}
