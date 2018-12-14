package io.dronefleet.mavlink.test;

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
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

/**
 * Test all field types 
 */
@MavlinkMessageInfo(
        id = 0,
        crc = 103,
        description = "Test all field types"
)
public final class TestTypes {
    private final int c;

    private final String s;

    private final int u8;

    private final int u16;

    private final long u32;

    private final BigInteger u64;

    private final int s8;

    private final int s16;

    private final int s32;

    private final long s64;

    private final float f;

    private final double d;

    private final byte[] u8Array;

    private final List<Integer> u16Array;

    private final List<Long> u32Array;

    private final List<BigInteger> u64Array;

    private final List<Integer> s8Array;

    private final List<Integer> s16Array;

    private final List<Integer> s32Array;

    private final List<Long> s64Array;

    private final List<Float> fArray;

    private final List<Double> dArray;

    private TestTypes(int c, String s, int u8, int u16, long u32, BigInteger u64, int s8, int s16,
            int s32, long s64, float f, double d, byte[] u8Array, List<Integer> u16Array,
            List<Long> u32Array, List<BigInteger> u64Array, List<Integer> s8Array,
            List<Integer> s16Array, List<Integer> s32Array, List<Long> s64Array, List<Float> fArray,
            List<Double> dArray) {
        this.c = c;
        this.s = s;
        this.u8 = u8;
        this.u16 = u16;
        this.u32 = u32;
        this.u64 = u64;
        this.s8 = s8;
        this.s16 = s16;
        this.s32 = s32;
        this.s64 = s64;
        this.f = f;
        this.d = d;
        this.u8Array = u8Array;
        this.u16Array = u16Array;
        this.u32Array = u32Array;
        this.u64Array = u64Array;
        this.s8Array = s8Array;
        this.s16Array = s16Array;
        this.s32Array = s32Array;
        this.s64Array = s64Array;
        this.fArray = fArray;
        this.dArray = dArray;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * char 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "char"
    )
    public final int c() {
        return this.c;
    }

    /**
     * string 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            arraySize = 10,
            description = "string"
    )
    public final String s() {
        return this.s;
    }

    /**
     * uint8_t 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "uint8_t"
    )
    public final int u8() {
        return this.u8;
    }

    /**
     * uint16_t 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            description = "uint16_t"
    )
    public final int u16() {
        return this.u16;
    }

    /**
     * uint32_t 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "uint32_t"
    )
    public final long u32() {
        return this.u32;
    }

    /**
     * uint64_t 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 8,
            description = "uint64_t"
    )
    public final BigInteger u64() {
        return this.u64;
    }

    /**
     * int8_t 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1,
            signed = true,
            description = "int8_t"
    )
    public final int s8() {
        return this.s8;
    }

    /**
     * int16_t 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2,
            signed = true,
            description = "int16_t"
    )
    public final int s16() {
        return this.s16;
    }

    /**
     * int32_t 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            signed = true,
            description = "int32_t"
    )
    public final int s32() {
        return this.s32;
    }

    /**
     * int64_t 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 8,
            signed = true,
            description = "int64_t"
    )
    public final long s64() {
        return this.s64;
    }

    /**
     * float 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            description = "float"
    )
    public final float f() {
        return this.f;
    }

    /**
     * double 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 8,
            description = "double"
    )
    public final double d() {
        return this.d;
    }

    /**
     * uint8_t_array 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 1,
            arraySize = 3,
            description = "uint8_t_array"
    )
    public final byte[] u8Array() {
        return this.u8Array;
    }

    /**
     * uint16_t_array 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 2,
            arraySize = 3,
            description = "uint16_t_array"
    )
    public final List<Integer> u16Array() {
        return this.u16Array;
    }

    /**
     * uint32_t_array 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 4,
            arraySize = 3,
            description = "uint32_t_array"
    )
    public final List<Long> u32Array() {
        return this.u32Array;
    }

    /**
     * uint64_t_array 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 8,
            arraySize = 3,
            description = "uint64_t_array"
    )
    public final List<BigInteger> u64Array() {
        return this.u64Array;
    }

    /**
     * int8_t_array 
     */
    @MavlinkFieldInfo(
            position = 17,
            unitSize = 1,
            arraySize = 3,
            signed = true,
            description = "int8_t_array"
    )
    public final List<Integer> s8Array() {
        return this.s8Array;
    }

    /**
     * int16_t_array 
     */
    @MavlinkFieldInfo(
            position = 18,
            unitSize = 2,
            arraySize = 3,
            signed = true,
            description = "int16_t_array"
    )
    public final List<Integer> s16Array() {
        return this.s16Array;
    }

    /**
     * int32_t_array 
     */
    @MavlinkFieldInfo(
            position = 19,
            unitSize = 4,
            arraySize = 3,
            signed = true,
            description = "int32_t_array"
    )
    public final List<Integer> s32Array() {
        return this.s32Array;
    }

    /**
     * int64_t_array 
     */
    @MavlinkFieldInfo(
            position = 20,
            unitSize = 8,
            arraySize = 3,
            signed = true,
            description = "int64_t_array"
    )
    public final List<Long> s64Array() {
        return this.s64Array;
    }

    /**
     * float_array 
     */
    @MavlinkFieldInfo(
            position = 21,
            unitSize = 4,
            arraySize = 3,
            description = "float_array"
    )
    public final List<Float> fArray() {
        return this.fArray;
    }

    /**
     * double_array 
     */
    @MavlinkFieldInfo(
            position = 22,
            unitSize = 8,
            arraySize = 3,
            description = "double_array"
    )
    public final List<Double> dArray() {
        return this.dArray;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        TestTypes other = (TestTypes)o;
        if (!Objects.deepEquals(c, other.c)) return false;
        if (!Objects.deepEquals(s, other.s)) return false;
        if (!Objects.deepEquals(u8, other.u8)) return false;
        if (!Objects.deepEquals(u16, other.u16)) return false;
        if (!Objects.deepEquals(u32, other.u32)) return false;
        if (!Objects.deepEquals(u64, other.u64)) return false;
        if (!Objects.deepEquals(s8, other.s8)) return false;
        if (!Objects.deepEquals(s16, other.s16)) return false;
        if (!Objects.deepEquals(s32, other.s32)) return false;
        if (!Objects.deepEquals(s64, other.s64)) return false;
        if (!Objects.deepEquals(f, other.f)) return false;
        if (!Objects.deepEquals(d, other.d)) return false;
        if (!Objects.deepEquals(u8Array, other.u8Array)) return false;
        if (!Objects.deepEquals(u16Array, other.u16Array)) return false;
        if (!Objects.deepEquals(u32Array, other.u32Array)) return false;
        if (!Objects.deepEquals(u64Array, other.u64Array)) return false;
        if (!Objects.deepEquals(s8Array, other.s8Array)) return false;
        if (!Objects.deepEquals(s16Array, other.s16Array)) return false;
        if (!Objects.deepEquals(s32Array, other.s32Array)) return false;
        if (!Objects.deepEquals(s64Array, other.s64Array)) return false;
        if (!Objects.deepEquals(fArray, other.fArray)) return false;
        if (!Objects.deepEquals(dArray, other.dArray)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(c);
        result = 31 * result + Objects.hashCode(s);
        result = 31 * result + Objects.hashCode(u8);
        result = 31 * result + Objects.hashCode(u16);
        result = 31 * result + Objects.hashCode(u32);
        result = 31 * result + Objects.hashCode(u64);
        result = 31 * result + Objects.hashCode(s8);
        result = 31 * result + Objects.hashCode(s16);
        result = 31 * result + Objects.hashCode(s32);
        result = 31 * result + Objects.hashCode(s64);
        result = 31 * result + Objects.hashCode(f);
        result = 31 * result + Objects.hashCode(d);
        result = 31 * result + Objects.hashCode(u8Array);
        result = 31 * result + Objects.hashCode(u16Array);
        result = 31 * result + Objects.hashCode(u32Array);
        result = 31 * result + Objects.hashCode(u64Array);
        result = 31 * result + Objects.hashCode(s8Array);
        result = 31 * result + Objects.hashCode(s16Array);
        result = 31 * result + Objects.hashCode(s32Array);
        result = 31 * result + Objects.hashCode(s64Array);
        result = 31 * result + Objects.hashCode(fArray);
        result = 31 * result + Objects.hashCode(dArray);
        return result;
    }

    @Override
    public String toString() {
        return "TestTypes{c=" + c
                 + ", s=" + s
                 + ", u8=" + u8
                 + ", u16=" + u16
                 + ", u32=" + u32
                 + ", u64=" + u64
                 + ", s8=" + s8
                 + ", s16=" + s16
                 + ", s32=" + s32
                 + ", s64=" + s64
                 + ", f=" + f
                 + ", d=" + d
                 + ", u8Array=" + u8Array
                 + ", u16Array=" + u16Array
                 + ", u32Array=" + u32Array
                 + ", u64Array=" + u64Array
                 + ", s8Array=" + s8Array
                 + ", s16Array=" + s16Array
                 + ", s32Array=" + s32Array
                 + ", s64Array=" + s64Array
                 + ", fArray=" + fArray
                 + ", dArray=" + dArray + "}";
    }

    public static final class Builder {
        private int c;

        private String s;

        private int u8;

        private int u16;

        private long u32;

        private BigInteger u64;

        private int s8;

        private int s16;

        private int s32;

        private long s64;

        private float f;

        private double d;

        private byte[] u8Array;

        private List<Integer> u16Array;

        private List<Long> u32Array;

        private List<BigInteger> u64Array;

        private List<Integer> s8Array;

        private List<Integer> s16Array;

        private List<Integer> s32Array;

        private List<Long> s64Array;

        private List<Float> fArray;

        private List<Double> dArray;

        /**
         * char 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "char"
        )
        public final Builder c(int c) {
            this.c = c;
            return this;
        }

        /**
         * string 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                arraySize = 10,
                description = "string"
        )
        public final Builder s(String s) {
            this.s = s;
            return this;
        }

        /**
         * uint8_t 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "uint8_t"
        )
        public final Builder u8(int u8) {
            this.u8 = u8;
            return this;
        }

        /**
         * uint16_t 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                description = "uint16_t"
        )
        public final Builder u16(int u16) {
            this.u16 = u16;
            return this;
        }

        /**
         * uint32_t 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "uint32_t"
        )
        public final Builder u32(long u32) {
            this.u32 = u32;
            return this;
        }

        /**
         * uint64_t 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 8,
                description = "uint64_t"
        )
        public final Builder u64(BigInteger u64) {
            this.u64 = u64;
            return this;
        }

        /**
         * int8_t 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1,
                signed = true,
                description = "int8_t"
        )
        public final Builder s8(int s8) {
            this.s8 = s8;
            return this;
        }

        /**
         * int16_t 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2,
                signed = true,
                description = "int16_t"
        )
        public final Builder s16(int s16) {
            this.s16 = s16;
            return this;
        }

        /**
         * int32_t 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                signed = true,
                description = "int32_t"
        )
        public final Builder s32(int s32) {
            this.s32 = s32;
            return this;
        }

        /**
         * int64_t 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 8,
                signed = true,
                description = "int64_t"
        )
        public final Builder s64(long s64) {
            this.s64 = s64;
            return this;
        }

        /**
         * float 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                description = "float"
        )
        public final Builder f(float f) {
            this.f = f;
            return this;
        }

        /**
         * double 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 8,
                description = "double"
        )
        public final Builder d(double d) {
            this.d = d;
            return this;
        }

        /**
         * uint8_t_array 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 1,
                arraySize = 3,
                description = "uint8_t_array"
        )
        public final Builder u8Array(byte[] u8Array) {
            this.u8Array = u8Array;
            return this;
        }

        /**
         * uint16_t_array 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 2,
                arraySize = 3,
                description = "uint16_t_array"
        )
        public final Builder u16Array(List<Integer> u16Array) {
            this.u16Array = u16Array;
            return this;
        }

        /**
         * uint32_t_array 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 4,
                arraySize = 3,
                description = "uint32_t_array"
        )
        public final Builder u32Array(List<Long> u32Array) {
            this.u32Array = u32Array;
            return this;
        }

        /**
         * uint64_t_array 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 8,
                arraySize = 3,
                description = "uint64_t_array"
        )
        public final Builder u64Array(List<BigInteger> u64Array) {
            this.u64Array = u64Array;
            return this;
        }

        /**
         * int8_t_array 
         */
        @MavlinkFieldInfo(
                position = 17,
                unitSize = 1,
                arraySize = 3,
                signed = true,
                description = "int8_t_array"
        )
        public final Builder s8Array(List<Integer> s8Array) {
            this.s8Array = s8Array;
            return this;
        }

        /**
         * int16_t_array 
         */
        @MavlinkFieldInfo(
                position = 18,
                unitSize = 2,
                arraySize = 3,
                signed = true,
                description = "int16_t_array"
        )
        public final Builder s16Array(List<Integer> s16Array) {
            this.s16Array = s16Array;
            return this;
        }

        /**
         * int32_t_array 
         */
        @MavlinkFieldInfo(
                position = 19,
                unitSize = 4,
                arraySize = 3,
                signed = true,
                description = "int32_t_array"
        )
        public final Builder s32Array(List<Integer> s32Array) {
            this.s32Array = s32Array;
            return this;
        }

        /**
         * int64_t_array 
         */
        @MavlinkFieldInfo(
                position = 20,
                unitSize = 8,
                arraySize = 3,
                signed = true,
                description = "int64_t_array"
        )
        public final Builder s64Array(List<Long> s64Array) {
            this.s64Array = s64Array;
            return this;
        }

        /**
         * float_array 
         */
        @MavlinkFieldInfo(
                position = 21,
                unitSize = 4,
                arraySize = 3,
                description = "float_array"
        )
        public final Builder fArray(List<Float> fArray) {
            this.fArray = fArray;
            return this;
        }

        /**
         * double_array 
         */
        @MavlinkFieldInfo(
                position = 22,
                unitSize = 8,
                arraySize = 3,
                description = "double_array"
        )
        public final Builder dArray(List<Double> dArray) {
            this.dArray = dArray;
            return this;
        }

        public final TestTypes build() {
            return new TestTypes(c, s, u8, u16, u32, u64, s8, s16, s32, s64, f, d, u8Array, u16Array, u32Array, u64Array, s8Array, s16Array, s32Array, s64Array, fArray, dArray);
        }
    }
}
