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
 * The RAW IMU readings for a 9DOF sensor, which is identified by the id (default IMU1). This 
 * message should always contain the true raw values without any scaling to allow data capture and 
 * system debugging. 
 */
@MavlinkMessageInfo(
        id = 27,
        crc = 144,
        description = "The RAW IMU readings for a 9DOF sensor, which is identified by the id (default IMU1). This message should always contain the true raw values without any scaling to allow data capture and system debugging."
)
public final class RawImu {
    private final BigInteger timeUsec;

    private final int xacc;

    private final int yacc;

    private final int zacc;

    private final int xgyro;

    private final int ygyro;

    private final int zgyro;

    private final int xmag;

    private final int ymag;

    private final int zmag;

    private final int id;

    private final int temperature;

    private RawImu(BigInteger timeUsec, int xacc, int yacc, int zacc, int xgyro, int ygyro,
            int zgyro, int xmag, int ymag, int zmag, int id, int temperature) {
        this.timeUsec = timeUsec;
        this.xacc = xacc;
        this.yacc = yacc;
        this.zacc = zacc;
        this.xgyro = xgyro;
        this.ygyro = ygyro;
        this.zgyro = zgyro;
        this.xmag = xmag;
        this.ymag = ymag;
        this.zmag = zmag;
        this.id = id;
        this.temperature = temperature;
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
     * X acceleration (raw) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            signed = true,
            description = "X acceleration (raw)"
    )
    public final int xacc() {
        return this.xacc;
    }

    /**
     * Y acceleration (raw) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            signed = true,
            description = "Y acceleration (raw)"
    )
    public final int yacc() {
        return this.yacc;
    }

    /**
     * Z acceleration (raw) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            signed = true,
            description = "Z acceleration (raw)"
    )
    public final int zacc() {
        return this.zacc;
    }

    /**
     * Angular speed around X axis (raw) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            signed = true,
            description = "Angular speed around X axis (raw)"
    )
    public final int xgyro() {
        return this.xgyro;
    }

    /**
     * Angular speed around Y axis (raw) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            signed = true,
            description = "Angular speed around Y axis (raw)"
    )
    public final int ygyro() {
        return this.ygyro;
    }

    /**
     * Angular speed around Z axis (raw) 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            signed = true,
            description = "Angular speed around Z axis (raw)"
    )
    public final int zgyro() {
        return this.zgyro;
    }

    /**
     * X Magnetic field (raw) 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2,
            signed = true,
            description = "X Magnetic field (raw)"
    )
    public final int xmag() {
        return this.xmag;
    }

    /**
     * Y Magnetic field (raw) 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2,
            signed = true,
            description = "Y Magnetic field (raw)"
    )
    public final int ymag() {
        return this.ymag;
    }

    /**
     * Z Magnetic field (raw) 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 2,
            signed = true,
            description = "Z Magnetic field (raw)"
    )
    public final int zmag() {
        return this.zmag;
    }

    /**
     * Id. Ids are numbered from 0 and map to IMUs numbered from 1 (e.g. IMU1 will have a message with 
     * id=0) 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 1,
            extension = true,
            description = "Id. Ids are numbered from 0 and map to IMUs numbered from 1 (e.g. IMU1 will have a message with id=0)"
    )
    public final int id() {
        return this.id;
    }

    /**
     * Temperature, 0: IMU does not provide temperature values. If the IMU is at 0C it must send 1 
     * (0.01C). 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 2,
            signed = true,
            extension = true,
            description = "Temperature, 0: IMU does not provide temperature values. If the IMU is at 0C it must send 1 (0.01C)."
    )
    public final int temperature() {
        return this.temperature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        RawImu other = (RawImu)o;
        if (!Objects.deepEquals(timeUsec, other.timeUsec)) return false;
        if (!Objects.deepEquals(xacc, other.xacc)) return false;
        if (!Objects.deepEquals(yacc, other.yacc)) return false;
        if (!Objects.deepEquals(zacc, other.zacc)) return false;
        if (!Objects.deepEquals(xgyro, other.xgyro)) return false;
        if (!Objects.deepEquals(ygyro, other.ygyro)) return false;
        if (!Objects.deepEquals(zgyro, other.zgyro)) return false;
        if (!Objects.deepEquals(xmag, other.xmag)) return false;
        if (!Objects.deepEquals(ymag, other.ymag)) return false;
        if (!Objects.deepEquals(zmag, other.zmag)) return false;
        if (!Objects.deepEquals(id, other.id)) return false;
        if (!Objects.deepEquals(temperature, other.temperature)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeUsec);
        result = 31 * result + Objects.hashCode(xacc);
        result = 31 * result + Objects.hashCode(yacc);
        result = 31 * result + Objects.hashCode(zacc);
        result = 31 * result + Objects.hashCode(xgyro);
        result = 31 * result + Objects.hashCode(ygyro);
        result = 31 * result + Objects.hashCode(zgyro);
        result = 31 * result + Objects.hashCode(xmag);
        result = 31 * result + Objects.hashCode(ymag);
        result = 31 * result + Objects.hashCode(zmag);
        result = 31 * result + Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(temperature);
        return result;
    }

    @Override
    public String toString() {
        return "RawImu{timeUsec=" + timeUsec
                 + ", xacc=" + xacc
                 + ", yacc=" + yacc
                 + ", zacc=" + zacc
                 + ", xgyro=" + xgyro
                 + ", ygyro=" + ygyro
                 + ", zgyro=" + zgyro
                 + ", xmag=" + xmag
                 + ", ymag=" + ymag
                 + ", zmag=" + zmag
                 + ", id=" + id
                 + ", temperature=" + temperature + "}";
    }

    public static final class Builder {
        private BigInteger timeUsec;

        private int xacc;

        private int yacc;

        private int zacc;

        private int xgyro;

        private int ygyro;

        private int zgyro;

        private int xmag;

        private int ymag;

        private int zmag;

        private int id;

        private int temperature;

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
         * X acceleration (raw) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                signed = true,
                description = "X acceleration (raw)"
        )
        public final Builder xacc(int xacc) {
            this.xacc = xacc;
            return this;
        }

        /**
         * Y acceleration (raw) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                signed = true,
                description = "Y acceleration (raw)"
        )
        public final Builder yacc(int yacc) {
            this.yacc = yacc;
            return this;
        }

        /**
         * Z acceleration (raw) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                signed = true,
                description = "Z acceleration (raw)"
        )
        public final Builder zacc(int zacc) {
            this.zacc = zacc;
            return this;
        }

        /**
         * Angular speed around X axis (raw) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                signed = true,
                description = "Angular speed around X axis (raw)"
        )
        public final Builder xgyro(int xgyro) {
            this.xgyro = xgyro;
            return this;
        }

        /**
         * Angular speed around Y axis (raw) 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                signed = true,
                description = "Angular speed around Y axis (raw)"
        )
        public final Builder ygyro(int ygyro) {
            this.ygyro = ygyro;
            return this;
        }

        /**
         * Angular speed around Z axis (raw) 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                signed = true,
                description = "Angular speed around Z axis (raw)"
        )
        public final Builder zgyro(int zgyro) {
            this.zgyro = zgyro;
            return this;
        }

        /**
         * X Magnetic field (raw) 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2,
                signed = true,
                description = "X Magnetic field (raw)"
        )
        public final Builder xmag(int xmag) {
            this.xmag = xmag;
            return this;
        }

        /**
         * Y Magnetic field (raw) 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2,
                signed = true,
                description = "Y Magnetic field (raw)"
        )
        public final Builder ymag(int ymag) {
            this.ymag = ymag;
            return this;
        }

        /**
         * Z Magnetic field (raw) 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 2,
                signed = true,
                description = "Z Magnetic field (raw)"
        )
        public final Builder zmag(int zmag) {
            this.zmag = zmag;
            return this;
        }

        /**
         * Id. Ids are numbered from 0 and map to IMUs numbered from 1 (e.g. IMU1 will have a message with 
         * id=0) 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 1,
                extension = true,
                description = "Id. Ids are numbered from 0 and map to IMUs numbered from 1 (e.g. IMU1 will have a message with id=0)"
        )
        public final Builder id(int id) {
            this.id = id;
            return this;
        }

        /**
         * Temperature, 0: IMU does not provide temperature values. If the IMU is at 0C it must send 1 
         * (0.01C). 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 2,
                signed = true,
                extension = true,
                description = "Temperature, 0: IMU does not provide temperature values. If the IMU is at 0C it must send 1 (0.01C)."
        )
        public final Builder temperature(int temperature) {
            this.temperature = temperature;
            return this;
        }

        public final RawImu build() {
            return new RawImu(timeUsec, xacc, yacc, zacc, xgyro, ygyro, zgyro, xmag, ymag, zmag, id, temperature);
        }
    }
}
