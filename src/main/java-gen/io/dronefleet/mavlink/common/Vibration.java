package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.math.BigInteger;

/**
 * Vibration levels and accelerometer clipping 
 */
@MavlinkMessageInfo(
        id = 241,
        crc = 90
)
public final class Vibration {
    private final BigInteger timeUsec;

    private final float vibrationX;

    private final float vibrationY;

    private final float vibrationZ;

    private final long clipping0;

    private final long clipping1;

    private final long clipping2;

    private Vibration(BigInteger timeUsec, float vibrationX, float vibrationY, float vibrationZ,
            long clipping0, long clipping1, long clipping2) {
        this.timeUsec = timeUsec;
        this.vibrationX = vibrationX;
        this.vibrationY = vibrationY;
        this.vibrationZ = vibrationZ;
        this.clipping0 = clipping0;
        this.clipping1 = clipping1;
        this.clipping2 = clipping2;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (micros since boot or Unix epoch) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * Vibration levels on X-axis 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float vibrationX() {
        return this.vibrationX;
    }

    /**
     * Vibration levels on Y-axis 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float vibrationY() {
        return this.vibrationY;
    }

    /**
     * Vibration levels on Z-axis 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float vibrationZ() {
        return this.vibrationZ;
    }

    /**
     * first accelerometer clipping count 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final long clipping0() {
        return this.clipping0;
    }

    /**
     * second accelerometer clipping count 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final long clipping1() {
        return this.clipping1;
    }

    /**
     * third accelerometer clipping count 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final long clipping2() {
        return this.clipping2;
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private float vibrationX;

        private float vibrationY;

        private float vibrationZ;

        private long clipping0;

        private long clipping1;

        private long clipping2;

        /**
         * Timestamp (micros since boot or Unix epoch) 
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
         * Vibration levels on X-axis 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder vibrationX(float vibrationX) {
            this.vibrationX = vibrationX;
            return this;
        }

        /**
         * Vibration levels on Y-axis 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder vibrationY(float vibrationY) {
            this.vibrationY = vibrationY;
            return this;
        }

        /**
         * Vibration levels on Z-axis 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder vibrationZ(float vibrationZ) {
            this.vibrationZ = vibrationZ;
            return this;
        }

        /**
         * first accelerometer clipping count 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder clipping0(long clipping0) {
            this.clipping0 = clipping0;
            return this;
        }

        /**
         * second accelerometer clipping count 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder clipping1(long clipping1) {
            this.clipping1 = clipping1;
            return this;
        }

        /**
         * third accelerometer clipping count 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4
        )
        public final Builder clipping2(long clipping2) {
            this.clipping2 = clipping2;
            return this;
        }

        public final Vibration build() {
            return new Vibration(timeUsec, vibrationX, vibrationY, vibrationZ, clipping0, clipping1, clipping2);
        }
    }
}
