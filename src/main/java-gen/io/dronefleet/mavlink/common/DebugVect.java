package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.String;
import java.math.BigInteger;

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
