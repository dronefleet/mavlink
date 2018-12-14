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
 * Array test #3. 
 */
@MavlinkMessageInfo(
        id = 153,
        crc = 19,
        description = "Array test #3."
)
public final class ArrayTest3 {
    private final int v;

    private final List<Long> arU32;

    private ArrayTest3(int v, List<Long> arU32) {
        this.v = v;
        this.arU32 = arU32;
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
    public final int v() {
        return this.v;
    }

    /**
     * Value array 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            arraySize = 4,
            description = "Value array"
    )
    public final List<Long> arU32() {
        return this.arU32;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ArrayTest3 other = (ArrayTest3)o;
        if (!Objects.deepEquals(v, other.v)) return false;
        if (!Objects.deepEquals(arU32, other.arU32)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(v);
        result = 31 * result + Objects.hashCode(arU32);
        return result;
    }

    @Override
    public String toString() {
        return "ArrayTest3{v=" + v
                 + ", arU32=" + arU32 + "}";
    }

    public static final class Builder {
        private int v;

        private List<Long> arU32;

        /**
         * Stub field 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "Stub field"
        )
        public final Builder v(int v) {
            this.v = v;
            return this;
        }

        /**
         * Value array 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                arraySize = 4,
                description = "Value array"
        )
        public final Builder arU32(List<Long> arU32) {
            this.arU32 = arU32;
            return this;
        }

        public final ArrayTest3 build() {
            return new ArrayTest3(v, arU32);
        }
    }
}
