package io.dronefleet.mavlink.python_array_test;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Array test #5. 
 */
@MavlinkMessageInfo(
        id = 155,
        crc = 27,
        description = "Array test #5."
)
public final class ArrayTest5 {
    private final String c1;

    private final String c2;

    private ArrayTest5(String c1, String c2) {
        this.c1 = c1;
        this.c2 = c2;
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
            unitSize = 1,
            arraySize = 5,
            description = "Value array"
    )
    public final String c1() {
        return this.c1;
    }

    /**
     * Value array 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            arraySize = 5,
            description = "Value array"
    )
    public final String c2() {
        return this.c2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ArrayTest5 other = (ArrayTest5)o;
        if (!Objects.deepEquals(c1, other.c1)) return false;
        if (!Objects.deepEquals(c2, other.c2)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(c1);
        result = 31 * result + Objects.hashCode(c2);
        return result;
    }

    @Override
    public String toString() {
        return "ArrayTest5{c1=" + c1
                 + ", c2=" + c2 + "}";
    }

    public static final class Builder {
        private String c1;

        private String c2;

        /**
         * Value array 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                arraySize = 5,
                description = "Value array"
        )
        public final Builder c1(String c1) {
            this.c1 = c1;
            return this;
        }

        /**
         * Value array 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                arraySize = 5,
                description = "Value array"
        )
        public final Builder c2(String c2) {
            this.c2 = c2;
            return this;
        }

        public final ArrayTest5 build() {
            return new ArrayTest5(c1, c2);
        }
    }
}
