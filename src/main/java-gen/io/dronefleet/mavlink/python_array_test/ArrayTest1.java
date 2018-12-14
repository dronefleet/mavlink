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
 * Array test #1. 
 */
@MavlinkMessageInfo(
        id = 151,
        crc = 72,
        description = "Array test #1."
)
public final class ArrayTest1 {
    private final List<Long> arU32;

    private ArrayTest1(List<Long> arU32) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ArrayTest1 other = (ArrayTest1)o;
        if (!Objects.deepEquals(arU32, other.arU32)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(arU32);
        return result;
    }

    @Override
    public String toString() {
        return "ArrayTest1{arU32=" + arU32 + "}";
    }

    public static final class Builder {
        private List<Long> arU32;

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

        public final ArrayTest1 build() {
            return new ArrayTest1(arU32);
        }
    }
}
