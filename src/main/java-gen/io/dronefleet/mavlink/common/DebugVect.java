package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;

/**
 * null
 */
@MavlinkMessageInfo(
        id = 250,
        crc = 49
)
public final class DebugVect {
    /**
     * Timestamp 
     */
    private final BigInteger timeUsec;

    /**
     * x 
     */
    private final float x;

    /**
     * y 
     */
    private final float y;

    /**
     * z 
     */
    private final float z;

    /**
     * Name 
     */
    private final String name;

    private DebugVect(BigInteger timeUsec, float x, float y, float z, String name) {
        this.timeUsec = timeUsec;
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "DebugVect{name=" + name
                 + ", timeUsec=" + timeUsec
                 + ", x=" + x
                 + ", y=" + y
                 + ", z=" + z + "}";
    }

    /**
     * Timestamp 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
    )
    public final BigInteger timeUsec() {
        return timeUsec;
    }

    /**
     * x 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float x() {
        return x;
    }

    /**
     * y 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float y() {
        return y;
    }

    /**
     * z 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float z() {
        return z;
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
        return name;
    }

    public static class Builder {
        private BigInteger timeUsec;

        private float x;

        private float y;

        private float z;

        private String name;

        private Builder() {
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

        public final DebugVect build() {
            return new DebugVect(timeUsec, x, y, z, name);
        }
    }
}
