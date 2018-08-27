package io.dronefleet.mavlink.autoquad;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Sends up to 20 raw float values. 
 */
@MavlinkMessageInfo(
        id = 150,
        crc = 241
)
public final class AqTelemetryF {
    private final int index;

    private final float value1;

    private final float value2;

    private final float value3;

    private final float value4;

    private final float value5;

    private final float value6;

    private final float value7;

    private final float value8;

    private final float value9;

    private final float value10;

    private final float value11;

    private final float value12;

    private final float value13;

    private final float value14;

    private final float value15;

    private final float value16;

    private final float value17;

    private final float value18;

    private final float value19;

    private final float value20;

    private AqTelemetryF(int index, float value1, float value2, float value3, float value4,
            float value5, float value6, float value7, float value8, float value9, float value10,
            float value11, float value12, float value13, float value14, float value15,
            float value16, float value17, float value18, float value19, float value20) {
        this.index = index;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.value4 = value4;
        this.value5 = value5;
        this.value6 = value6;
        this.value7 = value7;
        this.value8 = value8;
        this.value9 = value9;
        this.value10 = value10;
        this.value11 = value11;
        this.value12 = value12;
        this.value13 = value13;
        this.value14 = value14;
        this.value15 = value15;
        this.value16 = value16;
        this.value17 = value17;
        this.value18 = value18;
        this.value19 = value19;
        this.value20 = value20;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Index of message 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 2
    )
    public final int index() {
        return this.index;
    }

    /**
     * value1 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float value1() {
        return this.value1;
    }

    /**
     * value2 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float value2() {
        return this.value2;
    }

    /**
     * value3 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float value3() {
        return this.value3;
    }

    /**
     * value4 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float value4() {
        return this.value4;
    }

    /**
     * value5 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float value5() {
        return this.value5;
    }

    /**
     * value6 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float value6() {
        return this.value6;
    }

    /**
     * value7 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4
    )
    public final float value7() {
        return this.value7;
    }

    /**
     * value8 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4
    )
    public final float value8() {
        return this.value8;
    }

    /**
     * value9 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4
    )
    public final float value9() {
        return this.value9;
    }

    /**
     * value10 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4
    )
    public final float value10() {
        return this.value10;
    }

    /**
     * value11 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4
    )
    public final float value11() {
        return this.value11;
    }

    /**
     * value12 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 4
    )
    public final float value12() {
        return this.value12;
    }

    /**
     * value13 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 4
    )
    public final float value13() {
        return this.value13;
    }

    /**
     * value14 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 4
    )
    public final float value14() {
        return this.value14;
    }

    /**
     * value15 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 4
    )
    public final float value15() {
        return this.value15;
    }

    /**
     * value16 
     */
    @MavlinkFieldInfo(
            position = 17,
            unitSize = 4
    )
    public final float value16() {
        return this.value16;
    }

    /**
     * value17 
     */
    @MavlinkFieldInfo(
            position = 18,
            unitSize = 4
    )
    public final float value17() {
        return this.value17;
    }

    /**
     * value18 
     */
    @MavlinkFieldInfo(
            position = 19,
            unitSize = 4
    )
    public final float value18() {
        return this.value18;
    }

    /**
     * value19 
     */
    @MavlinkFieldInfo(
            position = 20,
            unitSize = 4
    )
    public final float value19() {
        return this.value19;
    }

    /**
     * value20 
     */
    @MavlinkFieldInfo(
            position = 21,
            unitSize = 4
    )
    public final float value20() {
        return this.value20;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        AqTelemetryF other = (AqTelemetryF)o;
        if (!Objects.deepEquals(index, other.index)) return false;
        if (!Objects.deepEquals(value1, other.value1)) return false;
        if (!Objects.deepEquals(value2, other.value2)) return false;
        if (!Objects.deepEquals(value3, other.value3)) return false;
        if (!Objects.deepEquals(value4, other.value4)) return false;
        if (!Objects.deepEquals(value5, other.value5)) return false;
        if (!Objects.deepEquals(value6, other.value6)) return false;
        if (!Objects.deepEquals(value7, other.value7)) return false;
        if (!Objects.deepEquals(value8, other.value8)) return false;
        if (!Objects.deepEquals(value9, other.value9)) return false;
        if (!Objects.deepEquals(value10, other.value10)) return false;
        if (!Objects.deepEquals(value11, other.value11)) return false;
        if (!Objects.deepEquals(value12, other.value12)) return false;
        if (!Objects.deepEquals(value13, other.value13)) return false;
        if (!Objects.deepEquals(value14, other.value14)) return false;
        if (!Objects.deepEquals(value15, other.value15)) return false;
        if (!Objects.deepEquals(value16, other.value16)) return false;
        if (!Objects.deepEquals(value17, other.value17)) return false;
        if (!Objects.deepEquals(value18, other.value18)) return false;
        if (!Objects.deepEquals(value19, other.value19)) return false;
        if (!Objects.deepEquals(value20, other.value20)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(index);
        result = 31 * result + Objects.hashCode(value1);
        result = 31 * result + Objects.hashCode(value2);
        result = 31 * result + Objects.hashCode(value3);
        result = 31 * result + Objects.hashCode(value4);
        result = 31 * result + Objects.hashCode(value5);
        result = 31 * result + Objects.hashCode(value6);
        result = 31 * result + Objects.hashCode(value7);
        result = 31 * result + Objects.hashCode(value8);
        result = 31 * result + Objects.hashCode(value9);
        result = 31 * result + Objects.hashCode(value10);
        result = 31 * result + Objects.hashCode(value11);
        result = 31 * result + Objects.hashCode(value12);
        result = 31 * result + Objects.hashCode(value13);
        result = 31 * result + Objects.hashCode(value14);
        result = 31 * result + Objects.hashCode(value15);
        result = 31 * result + Objects.hashCode(value16);
        result = 31 * result + Objects.hashCode(value17);
        result = 31 * result + Objects.hashCode(value18);
        result = 31 * result + Objects.hashCode(value19);
        result = 31 * result + Objects.hashCode(value20);
        return result;
    }

    @Override
    public String toString() {
        return "AqTelemetryF{index=" + index
                 + ", value1=" + value1
                 + ", value2=" + value2
                 + ", value3=" + value3
                 + ", value4=" + value4
                 + ", value5=" + value5
                 + ", value6=" + value6
                 + ", value7=" + value7
                 + ", value8=" + value8
                 + ", value9=" + value9
                 + ", value10=" + value10
                 + ", value11=" + value11
                 + ", value12=" + value12
                 + ", value13=" + value13
                 + ", value14=" + value14
                 + ", value15=" + value15
                 + ", value16=" + value16
                 + ", value17=" + value17
                 + ", value18=" + value18
                 + ", value19=" + value19
                 + ", value20=" + value20 + "}";
    }

    public static final class Builder {
        private int index;

        private float value1;

        private float value2;

        private float value3;

        private float value4;

        private float value5;

        private float value6;

        private float value7;

        private float value8;

        private float value9;

        private float value10;

        private float value11;

        private float value12;

        private float value13;

        private float value14;

        private float value15;

        private float value16;

        private float value17;

        private float value18;

        private float value19;

        private float value20;

        /**
         * Index of message 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 2
        )
        public final Builder index(int index) {
            this.index = index;
            return this;
        }

        /**
         * value1 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder value1(float value1) {
            this.value1 = value1;
            return this;
        }

        /**
         * value2 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder value2(float value2) {
            this.value2 = value2;
            return this;
        }

        /**
         * value3 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder value3(float value3) {
            this.value3 = value3;
            return this;
        }

        /**
         * value4 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder value4(float value4) {
            this.value4 = value4;
            return this;
        }

        /**
         * value5 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder value5(float value5) {
            this.value5 = value5;
            return this;
        }

        /**
         * value6 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4
        )
        public final Builder value6(float value6) {
            this.value6 = value6;
            return this;
        }

        /**
         * value7 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4
        )
        public final Builder value7(float value7) {
            this.value7 = value7;
            return this;
        }

        /**
         * value8 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4
        )
        public final Builder value8(float value8) {
            this.value8 = value8;
            return this;
        }

        /**
         * value9 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4
        )
        public final Builder value9(float value9) {
            this.value9 = value9;
            return this;
        }

        /**
         * value10 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4
        )
        public final Builder value10(float value10) {
            this.value10 = value10;
            return this;
        }

        /**
         * value11 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4
        )
        public final Builder value11(float value11) {
            this.value11 = value11;
            return this;
        }

        /**
         * value12 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 4
        )
        public final Builder value12(float value12) {
            this.value12 = value12;
            return this;
        }

        /**
         * value13 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 4
        )
        public final Builder value13(float value13) {
            this.value13 = value13;
            return this;
        }

        /**
         * value14 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 4
        )
        public final Builder value14(float value14) {
            this.value14 = value14;
            return this;
        }

        /**
         * value15 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 4
        )
        public final Builder value15(float value15) {
            this.value15 = value15;
            return this;
        }

        /**
         * value16 
         */
        @MavlinkFieldInfo(
                position = 17,
                unitSize = 4
        )
        public final Builder value16(float value16) {
            this.value16 = value16;
            return this;
        }

        /**
         * value17 
         */
        @MavlinkFieldInfo(
                position = 18,
                unitSize = 4
        )
        public final Builder value17(float value17) {
            this.value17 = value17;
            return this;
        }

        /**
         * value18 
         */
        @MavlinkFieldInfo(
                position = 19,
                unitSize = 4
        )
        public final Builder value18(float value18) {
            this.value18 = value18;
            return this;
        }

        /**
         * value19 
         */
        @MavlinkFieldInfo(
                position = 20,
                unitSize = 4
        )
        public final Builder value19(float value19) {
            this.value19 = value19;
            return this;
        }

        /**
         * value20 
         */
        @MavlinkFieldInfo(
                position = 21,
                unitSize = 4
        )
        public final Builder value20(float value20) {
            this.value20 = value20;
            return this;
        }

        public final AqTelemetryF build() {
            return new AqTelemetryF(index, value1, value2, value3, value4, value5, value6, value7, value8, value9, value10, value11, value12, value13, value14, value15, value16, value17, value18, value19, value20);
        }
    }
}
