package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.util.List;
import java.util.Objects;

/**
 * Send raw controller memory. The use of this message is discouraged for normal packets, but a 
 * quite efficient way for testing new messages and getting experimental debug output. 
 */
@MavlinkMessageInfo(
        id = 249,
        crc = 204
)
public final class MemoryVect {
    private final int address;

    private final int ver;

    private final int type;

    private final List<Integer> value;

    private MemoryVect(int address, int ver, int type, List<Integer> value) {
        this.address = address;
        this.ver = ver;
        this.type = type;
        this.value = value;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Starting address of the debug variables 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 2
    )
    public final int address() {
        return this.address;
    }

    /**
     * Version code of the type variable. 0=unknown, type ignored and assumed int16_t. 1=as below 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int ver() {
        return this.ver;
    }

    /**
     * Type code of the memory variables. for ver = 1: 0=16 x int16_t, 1=16 x uint16_t, 2=16 x Q15, 3=16 x 
     * 1Q14 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final int type() {
        return this.type;
    }

    /**
     * Memory contents at specified address 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            arraySize = 32,
            signed = true
    )
    public final List<Integer> value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        MemoryVect other = (MemoryVect)o;
        if (!Objects.deepEquals(address, other.address)) return false;
        if (!Objects.deepEquals(ver, other.ver)) return false;
        if (!Objects.deepEquals(type, other.type)) return false;
        if (!Objects.deepEquals(value, other.value)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(address);
        result = 31 * result + Objects.hashCode(ver);
        result = 31 * result + Objects.hashCode(type);
        result = 31 * result + Objects.hashCode(value);
        return result;
    }

    public static final class Builder {
        private int address;

        private int ver;

        private int type;

        private List<Integer> value;

        /**
         * Starting address of the debug variables 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 2
        )
        public final Builder address(int address) {
            this.address = address;
            return this;
        }

        /**
         * Version code of the type variable. 0=unknown, type ignored and assumed int16_t. 1=as below 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder ver(int ver) {
            this.ver = ver;
            return this;
        }

        /**
         * Type code of the memory variables. for ver = 1: 0=16 x int16_t, 1=16 x uint16_t, 2=16 x Q15, 3=16 x 
         * 1Q14 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder type(int type) {
            this.type = type;
            return this;
        }

        /**
         * Memory contents at specified address 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                arraySize = 32,
                signed = true
        )
        public final Builder value(List<Integer> value) {
            this.value = value;
            return this;
        }

        public final MemoryVect build() {
            return new MemoryVect(address, ver, type, value);
        }
    }
}
