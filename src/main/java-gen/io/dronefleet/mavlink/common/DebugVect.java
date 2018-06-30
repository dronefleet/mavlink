package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.Objects;

/**
 *  
 */
@MavlinkMessageInfo(
        id = 250,
        crc = 49
)
public final class DebugVect {
    private final String name;

    private final BigInteger timeUsec;

    private final float x;

    private final float y;

    private final float z;

    private DebugVect(String name, BigInteger timeUsec, float x, float y, float z) {
        this.name = name;
        this.timeUsec = timeUsec;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Name 
     */
    @MavlinkFieldInfo(
            position = 0,
            unitSize = 1,
            arraySize = 10
    )
    public final String name() {
        return this.name;
    }

    /**
     * Timestamp 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * x 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float x() {
        return this.x;
    }

    /**
     * y 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float y() {
        return this.y;
    }

    /**
     * z 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float z() {
        return this.z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        DebugVect other = (DebugVect)o;
        if (!Objects.deepEquals(name, other.name)) return false;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(x, other.x)) return false;
        if (!Objects.deepEquals(y, other.y)) return false;
        if (!Objects.deepEquals(z, other.z)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(x);
        result = 31 * result + Objects.hashCode(y);
        result = 31 * result + Objects.hashCode(z);
        return result;
    }

    public static final class Builder {
        private String name;

        private BigInteger timeUsec;

        private float x;

        private float y;

        private float z;

        /**
         * Name 
         */
        @MavlinkFieldInfo(
                position = 0,
                unitSize = 1,
                arraySize = 10
        )
        public final Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Timestamp 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8
        )
        public final Builder timeUsec(BigInteger timeUsec) {
            this.timeUsec = timeUsec;
            return this;
        }

        /**
         * x 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder x(float x) {
            this.x = x;
            return this;
        }

        /**
         * y 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder y(float y) {
            this.y = y;
            return this;
        }

        /**
         * z 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder z(float z) {
            this.z = z;
            return this;
        }

        public final DebugVect build() {
            return new DebugVect(name, timeUsec, x, y, z);
        }
    }
}
