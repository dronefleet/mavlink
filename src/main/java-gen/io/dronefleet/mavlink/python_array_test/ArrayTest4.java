package io.dronefleet.mavlink.python_array_test;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Objects;

/**
 * Array test #4. 
 */
@MavlinkMessageInfo(
        id = 154,
        crc = 89,
        description = "Array test #4."
)
public final class ArrayTest4 {
    private final List<Long> arU32;

    private final int v;

    private ArrayTest4(List<Long> arU32, int v) {
        this.arU32 = arU32;
        this.v = v;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Value array 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            arraySize = 4,
            description = "Value array"
    )
    public final List<Long> arU32() {
        return this.arU32;
    }

    /**
     * Stub field 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Stub field"
    )
    public final int v() {
        return this.v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ArrayTest4 other = (ArrayTest4)o;
        if (!Objects.deepEquals(arU32, other.arU32)) return false;
        if (!Objects.deepEquals(v, other.v)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(arU32);
        result = 31 * result + Objects.hashCode(v);
        return result;
    }

    @Override
    public String toString() {
        return "ArrayTest4{arU32=" + arU32
                 + ", v=" + v + "}";
    }

    public static final class Builder {
        private List<Long> arU32;

        private int v;

        /**
         * Value array 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                arraySize = 4,
                description = "Value array"
        )
        public final Builder arU32(List<Long> arU32) {
            this.arU32 = arU32;
            return this;
        }

        /**
         * Stub field 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Stub field"
        )
        public final Builder v(int v) {
            this.v = v;
            return this;
        }

        public final ArrayTest4 build() {
            return new ArrayTest4(arU32, v);
        }
    }
}
