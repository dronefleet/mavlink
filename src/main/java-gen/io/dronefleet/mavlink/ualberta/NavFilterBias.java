package io.dronefleet.mavlink.ualberta;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Accelerometer and Gyro biases from the navigation filter 
 */
@MavlinkMessageInfo(
        id = 220,
        crc = 34,
        description = "Accelerometer and Gyro biases from the navigation filter"
)
public final class NavFilterBias {
    private final BigInteger usec;

    private final float accel0;

    private final float accel1;

    private final float accel2;

    private final float gyro0;

    private final float gyro1;

    private final float gyro2;

    private NavFilterBias(BigInteger usec, float accel0, float accel1, float accel2, float gyro0,
            float gyro1, float gyro2) {
        this.usec = usec;
        this.accel0 = accel0;
        this.accel1 = accel1;
        this.accel2 = accel2;
        this.gyro0 = gyro0;
        this.gyro1 = gyro1;
        this.gyro2 = gyro2;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (microseconds) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 8,
            description = "Timestamp (microseconds)"
    )
    public final BigInteger usec() {
        return this.usec;
    }

    /**
     * b_f[0] 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "b_f[0]"
    )
    public final float accel0() {
        return this.accel0;
    }

    /**
     * b_f[1] 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "b_f[1]"
    )
    public final float accel1() {
        return this.accel1;
    }

    /**
     * b_f[2] 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "b_f[2]"
    )
    public final float accel2() {
        return this.accel2;
    }

    /**
     * b_f[0] 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "b_f[0]"
    )
    public final float gyro0() {
        return this.gyro0;
    }

    /**
     * b_f[1] 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "b_f[1]"
    )
    public final float gyro1() {
        return this.gyro1;
    }

    /**
     * b_f[2] 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "b_f[2]"
    )
    public final float gyro2() {
        return this.gyro2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        NavFilterBias other = (NavFilterBias)o;
        if (!Objects.deepEquals(usec, other.usec)) return false;
        if (!Objects.deepEquals(accel0, other.accel0)) return false;
        if (!Objects.deepEquals(accel1, other.accel1)) return false;
        if (!Objects.deepEquals(accel2, other.accel2)) return false;
        if (!Objects.deepEquals(gyro0, other.gyro0)) return false;
        if (!Objects.deepEquals(gyro1, other.gyro1)) return false;
        if (!Objects.deepEquals(gyro2, other.gyro2)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(usec);
        result = 31 * result + Objects.hashCode(accel0);
        result = 31 * result + Objects.hashCode(accel1);
        result = 31 * result + Objects.hashCode(accel2);
        result = 31 * result + Objects.hashCode(gyro0);
        result = 31 * result + Objects.hashCode(gyro1);
        result = 31 * result + Objects.hashCode(gyro2);
        return result;
    }

    @Override
    public String toString() {
        return "NavFilterBias{usec=" + usec
                 + ", accel0=" + accel0
                 + ", accel1=" + accel1
                 + ", accel2=" + accel2
                 + ", gyro0=" + gyro0
                 + ", gyro1=" + gyro1
                 + ", gyro2=" + gyro2 + "}";
    }

    public static final class Builder {
        private BigInteger usec;

        private float accel0;

        private float accel1;

        private float accel2;

        private float gyro0;

        private float gyro1;

        private float gyro2;

        /**
         * Timestamp (microseconds) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 8,
                description = "Timestamp (microseconds)"
        )
        public final Builder usec(BigInteger usec) {
            this.usec = usec;
            return this;
        }

        /**
         * b_f[0] 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "b_f[0]"
        )
        public final Builder accel0(float accel0) {
            this.accel0 = accel0;
            return this;
        }

        /**
         * b_f[1] 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "b_f[1]"
        )
        public final Builder accel1(float accel1) {
            this.accel1 = accel1;
            return this;
        }

        /**
         * b_f[2] 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "b_f[2]"
        )
        public final Builder accel2(float accel2) {
            this.accel2 = accel2;
            return this;
        }

        /**
         * b_f[0] 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "b_f[0]"
        )
        public final Builder gyro0(float gyro0) {
            this.gyro0 = gyro0;
            return this;
        }

        /**
         * b_f[1] 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "b_f[1]"
        )
        public final Builder gyro1(float gyro1) {
            this.gyro1 = gyro1;
            return this;
        }

        /**
         * b_f[2] 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "b_f[2]"
        )
        public final Builder gyro2(float gyro2) {
            this.gyro2 = gyro2;
            return this;
        }

        public final NavFilterBias build() {
            return new NavFilterBias(usec, accel0, accel1, accel2, gyro0, gyro1, gyro2);
        }
    }
}
