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
 * Vibration levels and accelerometer clipping 
 */
@MavlinkMessageInfo(
        id = 241,
        crc = 90,
        description = "Vibration levels and accelerometer clipping"
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
     * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
     * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
    )
    public final BigInteger timeUsec() {
        return this.timeUsec;
    }

    /**
     * Vibration levels on X-axis 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Vibration levels on X-axis"
    )
    public final float vibrationX() {
        return this.vibrationX;
    }

    /**
     * Vibration levels on Y-axis 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Vibration levels on Y-axis"
    )
    public final float vibrationY() {
        return this.vibrationY;
    }

    /**
     * Vibration levels on Z-axis 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Vibration levels on Z-axis"
    )
    public final float vibrationZ() {
        return this.vibrationZ;
    }

    /**
     * first accelerometer clipping count 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "first accelerometer clipping count"
    )
    public final long clipping0() {
        return this.clipping0;
    }

    /**
     * second accelerometer clipping count 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "second accelerometer clipping count"
    )
    public final long clipping1() {
        return this.clipping1;
    }

    /**
     * third accelerometer clipping count 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "third accelerometer clipping count"
    )
    public final long clipping2() {
        return this.clipping2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Vibration other = (Vibration)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(vibrationX, other.vibrationX)) return false;
        if (!Objects.deepEquals(vibrationY, other.vibrationY)) return false;
        if (!Objects.deepEquals(vibrationZ, other.vibrationZ)) return false;
        if (!Objects.deepEquals(clipping0, other.clipping0)) return false;
        if (!Objects.deepEquals(clipping1, other.clipping1)) return false;
        if (!Objects.deepEquals(clipping2, other.clipping2)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(vibrationX);
        result = 31 * result + Objects.hashCode(vibrationY);
        result = 31 * result + Objects.hashCode(vibrationZ);
        result = 31 * result + Objects.hashCode(clipping0);
        result = 31 * result + Objects.hashCode(clipping1);
        result = 31 * result + Objects.hashCode(clipping2);
        return result;
    }

    @Override
    public String toString() {
        return "Vibration{timeUsec=" + timeUsec
                 + ", vibrationX=" + vibrationX
                 + ", vibrationY=" + vibrationY
                 + ", vibrationZ=" + vibrationZ
                 + ", clipping0=" + clipping0
                 + ", clipping1=" + clipping1
                 + ", clipping2=" + clipping2 + "}";
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
         * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp 
         * format (since 1.1.1970 or since system boot) by checking for the magnitude of the number. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                description = "Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude of the number."
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
                unitSize = 4,
                description = "Vibration levels on X-axis"
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
                unitSize = 4,
                description = "Vibration levels on Y-axis"
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
                unitSize = 4,
                description = "Vibration levels on Z-axis"
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
                unitSize = 4,
                description = "first accelerometer clipping count"
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
                unitSize = 4,
                description = "second accelerometer clipping count"
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
                unitSize = 4,
                description = "third accelerometer clipping count"
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
