package io.dronefleet.mavlink.python_array_test;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Double;
import java.lang.Float;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Objects;

/**
 * Array test #6. 
 */
@MavlinkMessageInfo(
        id = 156,
        crc = 14,
        description = "Array test #6."
)
public final class ArrayTest6 {
    private final int v1;

    private final int v2;

    private final long v3;

    private final List<Long> arU32;

    private final List<Integer> arI32;

    private final List<Integer> arU16;

    private final List<Integer> arI16;

    private final byte[] arU8;

    private final List<Integer> arI8;

    private final String arC;

    private final List<Double> arD;

    private final List<Float> arF;

    private ArrayTest6(int v1, int v2, long v3, List<Long> arU32, List<Integer> arI32,
            List<Integer> arU16, List<Integer> arI16, byte[] arU8, List<Integer> arI8, String arC,
            List<Double> arD, List<Float> arF) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.arU32 = arU32;
        this.arI32 = arI32;
        this.arU16 = arU16;
        this.arI16 = arI16;
        this.arU8 = arU8;
        this.arI8 = arI8;
        this.arC = arC;
        this.arD = arD;
        this.arF = arF;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Stub field 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "Stub field"
    )
    public final int v1() {
        return this.v1;
    }

    /**
     * Stub field 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            description = "Stub field"
    )
    public final int v2() {
        return this.v2;
    }

    /**
     * Stub field 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Stub field"
    )
    public final long v3() {
        return this.v3;
    }

    /**
     * Value array 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            arraySize = 2,
            description = "Value array"
    )
    public final List<Long> arU32() {
        return this.arU32;
    }

    /**
     * Value array 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            arraySize = 2,
            signed = true,
            description = "Value array"
    )
    public final List<Integer> arI32() {
        return this.arI32;
    }

    /**
     * Value array 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            arraySize = 2,
            description = "Value array"
    )
    public final List<Integer> arU16() {
        return this.arU16;
    }

    /**
     * Value array 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            arraySize = 2,
            signed = true,
            description = "Value array"
    )
    public final List<Integer> arI16() {
        return this.arI16;
    }

    /**
     * Value array 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1,
            arraySize = 2,
            description = "Value array"
    )
    public final byte[] arU8() {
        return this.arU8;
    }

    /**
     * Value array 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 1,
            arraySize = 2,
            signed = true,
            description = "Value array"
    )
    public final List<Integer> arI8() {
        return this.arI8;
    }

    /**
     * Value array 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1,
            arraySize = 32,
            description = "Value array"
    )
    public final String arC() {
        return this.arC;
    }

    /**
     * Value array 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 8,
            arraySize = 2,
            description = "Value array"
    )
    public final List<Double> arD() {
        return this.arD;
    }

    /**
     * Value array 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4,
            arraySize = 2,
            description = "Value array"
    )
    public final List<Float> arF() {
        return this.arF;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ArrayTest6 other = (ArrayTest6)o;
        if (!Objects.deepEquals(v1, other.v1)) return false;
        if (!Objects.deepEquals(v2, other.v2)) return false;
        if (!Objects.deepEquals(v3, other.v3)) return false;
        if (!Objects.deepEquals(arU32, other.arU32)) return false;
        if (!Objects.deepEquals(arI32, other.arI32)) return false;
        if (!Objects.deepEquals(arU16, other.arU16)) return false;
        if (!Objects.deepEquals(arI16, other.arI16)) return false;
        if (!Objects.deepEquals(arU8, other.arU8)) return false;
        if (!Objects.deepEquals(arI8, other.arI8)) return false;
        if (!Objects.deepEquals(arC, other.arC)) return false;
        if (!Objects.deepEquals(arD, other.arD)) return false;
        if (!Objects.deepEquals(arF, other.arF)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(v1);
        result = 31 * result + Objects.hashCode(v2);
        result = 31 * result + Objects.hashCode(v3);
        result = 31 * result + Objects.hashCode(arU32);
        result = 31 * result + Objects.hashCode(arI32);
        result = 31 * result + Objects.hashCode(arU16);
        result = 31 * result + Objects.hashCode(arI16);
        result = 31 * result + Objects.hashCode(arU8);
        result = 31 * result + Objects.hashCode(arI8);
        result = 31 * result + Objects.hashCode(arC);
        result = 31 * result + Objects.hashCode(arD);
        result = 31 * result + Objects.hashCode(arF);
        return result;
    }

    @Override
    public String toString() {
        return "ArrayTest6{v1=" + v1
                 + ", v2=" + v2
                 + ", v3=" + v3
                 + ", arU32=" + arU32
                 + ", arI32=" + arI32
                 + ", arU16=" + arU16
                 + ", arI16=" + arI16
                 + ", arU8=" + arU8
                 + ", arI8=" + arI8
                 + ", arC=" + arC
                 + ", arD=" + arD
                 + ", arF=" + arF + "}";
    }

    public static final class Builder {
        private int v1;

        private int v2;

        private long v3;

        private List<Long> arU32;

        private List<Integer> arI32;

        private List<Integer> arU16;

        private List<Integer> arI16;

        private byte[] arU8;

        private List<Integer> arI8;

        private String arC;

        private List<Double> arD;

        private List<Float> arF;

        /**
         * Stub field 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "Stub field"
        )
        public final Builder v1(int v1) {
            this.v1 = v1;
            return this;
        }

        /**
         * Stub field 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                description = "Stub field"
        )
        public final Builder v2(int v2) {
            this.v2 = v2;
            return this;
        }

        /**
         * Stub field 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Stub field"
        )
        public final Builder v3(long v3) {
            this.v3 = v3;
            return this;
        }

        /**
         * Value array 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                arraySize = 2,
                description = "Value array"
        )
        public final Builder arU32(List<Long> arU32) {
            this.arU32 = arU32;
            return this;
        }

        /**
         * Value array 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                arraySize = 2,
                signed = true,
                description = "Value array"
        )
        public final Builder arI32(List<Integer> arI32) {
            this.arI32 = arI32;
            return this;
        }

        /**
         * Value array 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                arraySize = 2,
                description = "Value array"
        )
        public final Builder arU16(List<Integer> arU16) {
            this.arU16 = arU16;
            return this;
        }

        /**
         * Value array 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                arraySize = 2,
                signed = true,
                description = "Value array"
        )
        public final Builder arI16(List<Integer> arI16) {
            this.arI16 = arI16;
            return this;
        }

        /**
         * Value array 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 1,
                arraySize = 2,
                description = "Value array"
        )
        public final Builder arU8(byte[] arU8) {
            this.arU8 = arU8;
            return this;
        }

        /**
         * Value array 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 1,
                arraySize = 2,
                signed = true,
                description = "Value array"
        )
        public final Builder arI8(List<Integer> arI8) {
            this.arI8 = arI8;
            return this;
        }

        /**
         * Value array 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 1,
                arraySize = 32,
                description = "Value array"
        )
        public final Builder arC(String arC) {
            this.arC = arC;
            return this;
        }

        /**
         * Value array 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 8,
                arraySize = 2,
                description = "Value array"
        )
        public final Builder arD(List<Double> arD) {
            this.arD = arD;
            return this;
        }

        /**
         * Value array 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4,
                arraySize = 2,
                description = "Value array"
        )
        public final Builder arF(List<Float> arF) {
            this.arF = arF;
            return this;
        }

        public final ArrayTest6 build() {
            return new ArrayTest6(v1, v2, v3, arU32, arI32, arU16, arI16, arU8, arI8, arC, arD, arF);
        }
    }
}
