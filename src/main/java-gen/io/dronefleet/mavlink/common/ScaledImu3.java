package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * The RAW IMU readings for 3rd 9DOF sensor setup. This message should contain the scaled values to 
 * the described units 
 */
@MavlinkMessageInfo(
        id = 129,
        crc = 46
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
     * Timestamp (milliseconds since system boot) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * X acceleration (mg) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2,
            signed = true
    )
    public final int xacc() {
        return this.xacc;
    }

    /**
     * Y acceleration (mg) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 2,
            signed = true
    )
    public final int yacc() {
        return this.yacc;
    }

    /**
     * Z acceleration (mg) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 2,
            signed = true
    )
    public final int zacc() {
        return this.zacc;
    }

    /**
     * Angular speed around X axis (millirad /sec) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            signed = true
    )
    public final int xgyro() {
        return this.xgyro;
    }

    /**
     * Angular speed around Y axis (millirad /sec) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            signed = true
    )
    public final int ygyro() {
        return this.ygyro;
    }

    /**
     * Angular speed around Z axis (millirad /sec) 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            signed = true
    )
    public final int zgyro() {
        return this.zgyro;
    }

    /**
     * X Magnetic field (milli tesla) 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2,
            signed = true
    )
    public final int xmag() {
        return this.xmag;
    }

    /**
     * Y Magnetic field (milli tesla) 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2,
            signed = true
    )
    public final int ymag() {
        return this.ymag;
    }

    /**
     * Z Magnetic field (milli tesla) 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 2,
            signed = true
    )
    public final int zmag() {
        return this.zmag;
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
         * Timestamp (milliseconds since system boot) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * X acceleration (mg) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2,
                signed = true
        )
        public final Builder xacc(int xacc) {
            this.xacc = xacc;
            return this;
        }

        /**
         * Y acceleration (mg) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 2,
                signed = true
        )
        public final Builder yacc(int yacc) {
            this.yacc = yacc;
            return this;
        }

        /**
         * Z acceleration (mg) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 2,
                signed = true
        )
        public final Builder zacc(int zacc) {
            this.zacc = zacc;
            return this;
        }

        /**
         * Angular speed around X axis (millirad /sec) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                signed = true
        )
        public final Builder xgyro(int xgyro) {
            this.xgyro = xgyro;
            return this;
        }

        /**
         * Angular speed around Y axis (millirad /sec) 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                signed = true
        )
        public final Builder ygyro(int ygyro) {
            this.ygyro = ygyro;
            return this;
        }

        /**
         * Angular speed around Z axis (millirad /sec) 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                signed = true
        )
        public final Builder zgyro(int zgyro) {
            this.zgyro = zgyro;
            return this;
        }

        /**
         * X Magnetic field (milli tesla) 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2,
                signed = true
        )
        public final Builder xmag(int xmag) {
            this.xmag = xmag;
            return this;
        }

        /**
         * Y Magnetic field (milli tesla) 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2,
                signed = true
        )
        public final Builder ymag(int ymag) {
            this.ymag = ymag;
            return this;
        }

        /**
         * Z Magnetic field (milli tesla) 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 2,
                signed = true
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
