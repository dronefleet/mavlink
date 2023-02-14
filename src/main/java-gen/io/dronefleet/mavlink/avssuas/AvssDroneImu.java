package io.dronefleet.mavlink.avssuas;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Drone IMU data. Quaternion order is w, x, y, z and a zero rotation would be expressed as (1 0 0 0). 
 */
@MavlinkMessageInfo(
        id = 60052,
        crc = 101,
        description = "Drone IMU data. Quaternion order is w, x, y, z and a zero rotation would be expressed as (1 0 0 0)."
)
public final class AvssDroneImu {
    private final long timeBootMs;

    private final float q1;

    private final float q2;

    private final float q3;

    private final float q4;

    private final float xacc;

    private final float yacc;

    private final float zacc;

    private final float xgyro;

    private final float ygyro;

    private final float zgyro;

    private AvssDroneImu(long timeBootMs, float q1, float q2, float q3, float q4, float xacc,
            float yacc, float zacc, float xgyro, float ygyro, float zgyro) {
        this.timeBootMs = timeBootMs;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.xacc = xacc;
        this.yacc = yacc;
        this.zacc = zacc;
        this.xgyro = xgyro;
        this.ygyro = ygyro;
        this.zgyro = zgyro;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (time since FC boot). 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Timestamp (time since FC boot)."
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * Quaternion component 1, w (1 in null-rotation) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Quaternion component 1, w (1 in null-rotation)"
    )
    public final float q1() {
        return this.q1;
    }

    /**
     * Quaternion component 2, x (0 in null-rotation) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Quaternion component 2, x (0 in null-rotation)"
    )
    public final float q2() {
        return this.q2;
    }

    /**
     * Quaternion component 3, y (0 in null-rotation) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Quaternion component 3, y (0 in null-rotation)"
    )
    public final float q3() {
        return this.q3;
    }

    /**
     * Quaternion component 4, z (0 in null-rotation) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Quaternion component 4, z (0 in null-rotation)"
    )
    public final float q4() {
        return this.q4;
    }

    /**
     * X acceleration 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "X acceleration"
    )
    public final float xacc() {
        return this.xacc;
    }

    /**
     * Y acceleration 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Y acceleration"
    )
    public final float yacc() {
        return this.yacc;
    }

    /**
     * Z acceleration 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Z acceleration"
    )
    public final float zacc() {
        return this.zacc;
    }

    /**
     * Angular speed around X axis 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Angular speed around X axis"
    )
    public final float xgyro() {
        return this.xgyro;
    }

    /**
     * Angular speed around Y axis 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            description = "Angular speed around Y axis"
    )
    public final float ygyro() {
        return this.ygyro;
    }

    /**
     * Angular speed around Z axis 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            description = "Angular speed around Z axis"
    )
    public final float zgyro() {
        return this.zgyro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        AvssDroneImu other = (AvssDroneImu)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(q1, other.q1)) return false;
        if (!Objects.deepEquals(q2, other.q2)) return false;
        if (!Objects.deepEquals(q3, other.q3)) return false;
        if (!Objects.deepEquals(q4, other.q4)) return false;
        if (!Objects.deepEquals(xacc, other.xacc)) return false;
        if (!Objects.deepEquals(yacc, other.yacc)) return false;
        if (!Objects.deepEquals(zacc, other.zacc)) return false;
        if (!Objects.deepEquals(xgyro, other.xgyro)) return false;
        if (!Objects.deepEquals(ygyro, other.ygyro)) return false;
        if (!Objects.deepEquals(zgyro, other.zgyro)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(q1);
        result = 31 * result + Objects.hashCode(q2);
        result = 31 * result + Objects.hashCode(q3);
        result = 31 * result + Objects.hashCode(q4);
        result = 31 * result + Objects.hashCode(xacc);
        result = 31 * result + Objects.hashCode(yacc);
        result = 31 * result + Objects.hashCode(zacc);
        result = 31 * result + Objects.hashCode(xgyro);
        result = 31 * result + Objects.hashCode(ygyro);
        result = 31 * result + Objects.hashCode(zgyro);
        return result;
    }

    @Override
    public String toString() {
        return "AvssDroneImu{timeBootMs=" + timeBootMs
                 + ", q1=" + q1
                 + ", q2=" + q2
                 + ", q3=" + q3
                 + ", q4=" + q4
                 + ", xacc=" + xacc
                 + ", yacc=" + yacc
                 + ", zacc=" + zacc
                 + ", xgyro=" + xgyro
                 + ", ygyro=" + ygyro
                 + ", zgyro=" + zgyro + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private float q1;

        private float q2;

        private float q3;

        private float q4;

        private float xacc;

        private float yacc;

        private float zacc;

        private float xgyro;

        private float ygyro;

        private float zgyro;

        /**
         * Timestamp (time since FC boot). 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Timestamp (time since FC boot)."
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * Quaternion component 1, w (1 in null-rotation) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Quaternion component 1, w (1 in null-rotation)"
        )
        public final Builder q1(float q1) {
            this.q1 = q1;
            return this;
        }

        /**
         * Quaternion component 2, x (0 in null-rotation) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Quaternion component 2, x (0 in null-rotation)"
        )
        public final Builder q2(float q2) {
            this.q2 = q2;
            return this;
        }

        /**
         * Quaternion component 3, y (0 in null-rotation) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "Quaternion component 3, y (0 in null-rotation)"
        )
        public final Builder q3(float q3) {
            this.q3 = q3;
            return this;
        }

        /**
         * Quaternion component 4, z (0 in null-rotation) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Quaternion component 4, z (0 in null-rotation)"
        )
        public final Builder q4(float q4) {
            this.q4 = q4;
            return this;
        }

        /**
         * X acceleration 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "X acceleration"
        )
        public final Builder xacc(float xacc) {
            this.xacc = xacc;
            return this;
        }

        /**
         * Y acceleration 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Y acceleration"
        )
        public final Builder yacc(float yacc) {
            this.yacc = yacc;
            return this;
        }

        /**
         * Z acceleration 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Z acceleration"
        )
        public final Builder zacc(float zacc) {
            this.zacc = zacc;
            return this;
        }

        /**
         * Angular speed around X axis 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Angular speed around X axis"
        )
        public final Builder xgyro(float xgyro) {
            this.xgyro = xgyro;
            return this;
        }

        /**
         * Angular speed around Y axis 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                description = "Angular speed around Y axis"
        )
        public final Builder ygyro(float ygyro) {
            this.ygyro = ygyro;
            return this;
        }

        /**
         * Angular speed around Z axis 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                description = "Angular speed around Z axis"
        )
        public final Builder zgyro(float zgyro) {
            this.zgyro = zgyro;
            return this;
        }

        public final AvssDroneImu build() {
            return new AvssDroneImu(timeBootMs, q1, q2, q3, q4, xacc, yacc, zacc, xgyro, ygyro, zgyro);
        }
    }
}
