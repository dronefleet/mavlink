package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * The RAW IMU readings for 3rd 9DOF sensor setup. This message should contain the scaled values to 
 * the described units 
 */
@MavlinkMessageInfo(
        id = 129,
        crc = 46,
        description = "The RAW IMU readings for 3rd 9DOF sensor setup. This message should contain the scaled values to the described units"
)
public final class ScaledImu3 {
    private final long timeBootMs;

    private final int xacc;

    private final int yacc;

    private final int zacc;

    private final int xgyro;

    private final int ygyro;

    private final int zgyro;

    private final int xmag;

    private final int ymag;

    private final int zmag;

    private ScaledImu3(long timeBootMs, int xacc, int yacc, int zacc, int xgyro, int ygyro,
            int zgyro, int xmag, int ymag, int zmag) {
        this.timeBootMs = timeBootMs;
        this.xacc = xacc;
        this.yacc = yacc;
        this.zacc = zacc;
        this.xgyro = xgyro;
        this.ygyro = ygyro;
        this.zgyro = zgyro;
        this.xmag = xmag;
        this.ymag = ymag;
        this.zmag = zmag;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (time since system boot). 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Timestamp (time since system boot)."
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * X acceleration 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            signed = true,
            description = "X acceleration"
    )
    public final int xacc() {
        return this.xacc;
    }

    /**
     * Y acceleration 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            signed = true,
            description = "Y acceleration"
    )
    public final int yacc() {
        return this.yacc;
    }

    /**
     * Z acceleration 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            signed = true,
            description = "Z acceleration"
    )
    public final int zacc() {
        return this.zacc;
    }

    /**
     * Angular speed around X axis 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            signed = true,
            description = "Angular speed around X axis"
    )
    public final int xgyro() {
        return this.xgyro;
    }

    /**
     * Angular speed around Y axis 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            signed = true,
            description = "Angular speed around Y axis"
    )
    public final int ygyro() {
        return this.ygyro;
    }

    /**
     * Angular speed around Z axis 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            signed = true,
            description = "Angular speed around Z axis"
    )
    public final int zgyro() {
        return this.zgyro;
    }

    /**
     * X Magnetic field 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2,
            signed = true,
            description = "X Magnetic field"
    )
    public final int xmag() {
        return this.xmag;
    }

    /**
     * Y Magnetic field 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2,
            signed = true,
            description = "Y Magnetic field"
    )
    public final int ymag() {
        return this.ymag;
    }

    /**
     * Z Magnetic field 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 2,
            signed = true,
            description = "Z Magnetic field"
    )
    public final int zmag() {
        return this.zmag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ScaledImu3 other = (ScaledImu3)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(xacc, other.xacc)) return false;
        if (!Objects.deepEquals(yacc, other.yacc)) return false;
        if (!Objects.deepEquals(zacc, other.zacc)) return false;
        if (!Objects.deepEquals(xgyro, other.xgyro)) return false;
        if (!Objects.deepEquals(ygyro, other.ygyro)) return false;
        if (!Objects.deepEquals(zgyro, other.zgyro)) return false;
        if (!Objects.deepEquals(xmag, other.xmag)) return false;
        if (!Objects.deepEquals(ymag, other.ymag)) return false;
        if (!Objects.deepEquals(zmag, other.zmag)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(xacc);
        result = 31 * result + Objects.hashCode(yacc);
        result = 31 * result + Objects.hashCode(zacc);
        result = 31 * result + Objects.hashCode(xgyro);
        result = 31 * result + Objects.hashCode(ygyro);
        result = 31 * result + Objects.hashCode(zgyro);
        result = 31 * result + Objects.hashCode(xmag);
        result = 31 * result + Objects.hashCode(ymag);
        result = 31 * result + Objects.hashCode(zmag);
        return result;
    }

    @Override
    public String toString() {
        return "ScaledImu3{timeBootMs=" + timeBootMs
                 + ", xacc=" + xacc
                 + ", yacc=" + yacc
                 + ", zacc=" + zacc
                 + ", xgyro=" + xgyro
                 + ", ygyro=" + ygyro
                 + ", zgyro=" + zgyro
                 + ", xmag=" + xmag
                 + ", ymag=" + ymag
                 + ", zmag=" + zmag + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private int xacc;

        private int yacc;

        private int zacc;

        private int xgyro;

        private int ygyro;

        private int zgyro;

        private int xmag;

        private int ymag;

        private int zmag;

        /**
         * Timestamp (time since system boot). 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Timestamp (time since system boot)."
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * X acceleration 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                signed = true,
                description = "X acceleration"
        )
        public final Builder xacc(int xacc) {
            this.xacc = xacc;
            return this;
        }

        /**
         * Y acceleration 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                signed = true,
                description = "Y acceleration"
        )
        public final Builder yacc(int yacc) {
            this.yacc = yacc;
            return this;
        }

        /**
         * Z acceleration 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                signed = true,
                description = "Z acceleration"
        )
        public final Builder zacc(int zacc) {
            this.zacc = zacc;
            return this;
        }

        /**
         * Angular speed around X axis 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                signed = true,
                description = "Angular speed around X axis"
        )
        public final Builder xgyro(int xgyro) {
            this.xgyro = xgyro;
            return this;
        }

        /**
         * Angular speed around Y axis 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                signed = true,
                description = "Angular speed around Y axis"
        )
        public final Builder ygyro(int ygyro) {
            this.ygyro = ygyro;
            return this;
        }

        /**
         * Angular speed around Z axis 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                signed = true,
                description = "Angular speed around Z axis"
        )
        public final Builder zgyro(int zgyro) {
            this.zgyro = zgyro;
            return this;
        }

        /**
         * X Magnetic field 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2,
                signed = true,
                description = "X Magnetic field"
        )
        public final Builder xmag(int xmag) {
            this.xmag = xmag;
            return this;
        }

        /**
         * Y Magnetic field 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2,
                signed = true,
                description = "Y Magnetic field"
        )
        public final Builder ymag(int ymag) {
            this.ymag = ymag;
            return this;
        }

        /**
         * Z Magnetic field 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 2,
                signed = true,
                description = "Z Magnetic field"
        )
        public final Builder zmag(int zmag) {
            this.zmag = zmag;
            return this;
        }

        public final ScaledImu3 build() {
            return new ScaledImu3(timeBootMs, xacc, yacc, zacc, xgyro, ygyro, zgyro, xmag, ymag, zmag);
        }
    }
}
