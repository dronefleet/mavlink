package io.dronefleet.mavlink.python_array_test;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Objects;

/**
 * Array test #8. 
 */
@MavlinkMessageInfo(
        id = 158,
        crc = 106,
        description = "Array test #8."
)
public final class ArrayTest8 {
    private final long v3;

    private final List<Double> arD;

    private final List<Integer> arU16;

    private ArrayTest8(long v3, List<Double> arD, List<Integer> arU16) {
        this.v3 = v3;
        this.arD = arD;
        this.arU16 = arU16;
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
            position = 2,
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
            position = 3,
            unitSize = 2,
            arraySize = 2,
            description = "Value array"
    )
    public final List<Integer> arU16() {
        return this.arU16;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ArrayTest8 other = (ArrayTest8)o;
        if (!Objects.deepEquals(v3, other.v3)) return false;
        if (!Objects.deepEquals(arD, other.arD)) return false;
        if (!Objects.deepEquals(arU16, other.arU16)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(v3);
        result = 31 * result + Objects.hashCode(arD);
        result = 31 * result + Objects.hashCode(arU16);
        return result;
    }

    @Override
    public String toString() {
        return "ArrayTest8{v3=" + v3
                 + ", arD=" + arD
                 + ", arU16=" + arU16 + "}";
    }

    public static final class Builder {
        private long v3;

        private List<Double> arD;

        private List<Integer> arU16;

        /**
         * Stub field 
         */
        @MavlinkFieldInfo(
                position = 1,
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
                position = 2,
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
                position = 3,
                unitSize = 2,
                arraySize = 2,
                description = "Value array"
        )
        public final Builder arU16(List<Integer> arU16) {
            this.arU16 = arU16;
            return this;
        }

        public final ArrayTest8 build() {
            return new ArrayTest8(v3, arD, arU16);
        }
    }
}
