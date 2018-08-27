package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Status of simulation environment, if used 
 */
@MavlinkMessageInfo(
        id = 108,
        crc = 32
)
public final class SimState {
    private final float q1;

    private final float q2;

    private final float q3;

    private final float q4;

    private final float roll;

    private final float pitch;

    private final float yaw;

    private final float xacc;

    private final float yacc;

    private final float zacc;

    private final float xgyro;

    private final float ygyro;

    private final float zgyro;

    private final float lat;

    private final float lon;

    private final float alt;

    private final float stdDevHorz;

    private final float stdDevVert;

    private final float vn;

    private final float ve;

    private final float vd;

    private SimState(float q1, float q2, float q3, float q4, float roll, float pitch, float yaw,
            float xacc, float yacc, float zacc, float xgyro, float ygyro, float zgyro, float lat,
            float lon, float alt, float stdDevHorz, float stdDevVert, float vn, float ve,
            float vd) {
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.roll = roll;
        this.pitch = pitch;
        this.yaw = yaw;
        this.xacc = xacc;
        this.yacc = yacc;
        this.zacc = zacc;
        this.xgyro = xgyro;
        this.ygyro = ygyro;
        this.zgyro = zgyro;
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
        this.stdDevHorz = stdDevHorz;
        this.stdDevVert = stdDevVert;
        this.vn = vn;
        this.ve = ve;
        this.vd = vd;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * True attitude quaternion component 1, w (1 in null-rotation) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final float q1() {
        return this.q1;
    }

    /**
     * True attitude quaternion component 2, x (0 in null-rotation) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float q2() {
        return this.q2;
    }

    /**
     * True attitude quaternion component 3, y (0 in null-rotation) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float q3() {
        return this.q3;
    }

    /**
     * True attitude quaternion component 4, z (0 in null-rotation) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float q4() {
        return this.q4;
    }

    /**
     * Attitude roll expressed as Euler angles, not recommended except for human-readable outputs 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float roll() {
        return this.roll;
    }

    /**
     * Attitude pitch expressed as Euler angles, not recommended except for human-readable outputs 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float pitch() {
        return this.pitch;
    }

    /**
     * Attitude yaw expressed as Euler angles, not recommended except for human-readable outputs 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float yaw() {
        return this.yaw;
    }

    /**
     * X acceleration m/s/s 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4
    )
    public final float xacc() {
        return this.xacc;
    }

    /**
     * Y acceleration m/s/s 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4
    )
    public final float yacc() {
        return this.yacc;
    }

    /**
     * Z acceleration m/s/s 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4
    )
    public final float zacc() {
        return this.zacc;
    }

    /**
     * Angular speed around X axis rad/s 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4
    )
    public final float xgyro() {
        return this.xgyro;
    }

    /**
     * Angular speed around Y axis rad/s 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 4
    )
    public final float ygyro() {
        return this.ygyro;
    }

    /**
     * Angular speed around Z axis rad/s 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 4
    )
    public final float zgyro() {
        return this.zgyro;
    }

    /**
     * Latitude in degrees 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 4
    )
    public final float lat() {
        return this.lat;
    }

    /**
     * Longitude in degrees 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 4
    )
    public final float lon() {
        return this.lon;
    }

    /**
     * Altitude in meters 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 4
    )
    public final float alt() {
        return this.alt;
    }

    /**
     * Horizontal position standard deviation 
     */
    @MavlinkFieldInfo(
            position = 17,
            unitSize = 4
    )
    public final float stdDevHorz() {
        return this.stdDevHorz;
    }

    /**
     * Vertical position standard deviation 
     */
    @MavlinkFieldInfo(
            position = 18,
            unitSize = 4
    )
    public final float stdDevVert() {
        return this.stdDevVert;
    }

    /**
     * True velocity in m/s in NORTH direction in earth-fixed NED frame 
     */
    @MavlinkFieldInfo(
            position = 19,
            unitSize = 4
    )
    public final float vn() {
        return this.vn;
    }

    /**
     * True velocity in m/s in EAST direction in earth-fixed NED frame 
     */
    @MavlinkFieldInfo(
            position = 20,
            unitSize = 4
    )
    public final float ve() {
        return this.ve;
    }

    /**
     * True velocity in m/s in DOWN direction in earth-fixed NED frame 
     */
    @MavlinkFieldInfo(
            position = 21,
            unitSize = 4
    )
    public final float vd() {
        return this.vd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SimState other = (SimState)o;
        if (!Objects.deepEquals(q1, other.q1)) return false;
        if (!Objects.deepEquals(q2, other.q2)) return false;
        if (!Objects.deepEquals(q3, other.q3)) return false;
        if (!Objects.deepEquals(q4, other.q4)) return false;
        if (!Objects.deepEquals(roll, other.roll)) return false;
        if (!Objects.deepEquals(pitch, other.pitch)) return false;
        if (!Objects.deepEquals(yaw, other.yaw)) return false;
        if (!Objects.deepEquals(xacc, other.xacc)) return false;
        if (!Objects.deepEquals(yacc, other.yacc)) return false;
        if (!Objects.deepEquals(zacc, other.zacc)) return false;
        if (!Objects.deepEquals(xgyro, other.xgyro)) return false;
        if (!Objects.deepEquals(ygyro, other.ygyro)) return false;
        if (!Objects.deepEquals(zgyro, other.zgyro)) return false;
        if (!Objects.deepEquals(lat, other.lat)) return false;
        if (!Objects.deepEquals(lon, other.lon)) return false;
        if (!Objects.deepEquals(alt, other.alt)) return false;
        if (!Objects.deepEquals(stdDevHorz, other.stdDevHorz)) return false;
        if (!Objects.deepEquals(stdDevVert, other.stdDevVert)) return false;
        if (!Objects.deepEquals(vn, other.vn)) return false;
        if (!Objects.deepEquals(ve, other.ve)) return false;
        if (!Objects.deepEquals(vd, other.vd)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(q1);
        result = 31 * result + Objects.hashCode(q2);
        result = 31 * result + Objects.hashCode(q3);
        result = 31 * result + Objects.hashCode(q4);
        result = 31 * result + Objects.hashCode(roll);
        result = 31 * result + Objects.hashCode(pitch);
        result = 31 * result + Objects.hashCode(yaw);
        result = 31 * result + Objects.hashCode(xacc);
        result = 31 * result + Objects.hashCode(yacc);
        result = 31 * result + Objects.hashCode(zacc);
        result = 31 * result + Objects.hashCode(xgyro);
        result = 31 * result + Objects.hashCode(ygyro);
        result = 31 * result + Objects.hashCode(zgyro);
        result = 31 * result + Objects.hashCode(lat);
        result = 31 * result + Objects.hashCode(lon);
        result = 31 * result + Objects.hashCode(alt);
        result = 31 * result + Objects.hashCode(stdDevHorz);
        result = 31 * result + Objects.hashCode(stdDevVert);
        result = 31 * result + Objects.hashCode(vn);
        result = 31 * result + Objects.hashCode(ve);
        result = 31 * result + Objects.hashCode(vd);
        return result;
    }

    @Override
    public String toString() {
        return "SimState{q1=" + q1
                 + ", q2=" + q2
                 + ", q3=" + q3
                 + ", q4=" + q4
                 + ", roll=" + roll
                 + ", pitch=" + pitch
                 + ", yaw=" + yaw
                 + ", xacc=" + xacc
                 + ", yacc=" + yacc
                 + ", zacc=" + zacc
                 + ", xgyro=" + xgyro
                 + ", ygyro=" + ygyro
                 + ", zgyro=" + zgyro
                 + ", lat=" + lat
                 + ", lon=" + lon
                 + ", alt=" + alt
                 + ", stdDevHorz=" + stdDevHorz
                 + ", stdDevVert=" + stdDevVert
                 + ", vn=" + vn
                 + ", ve=" + ve
                 + ", vd=" + vd + "}";
    }

    public static final class Builder {
        private float q1;

        private float q2;

        private float q3;

        private float q4;

        private float roll;

        private float pitch;

        private float yaw;

        private float xacc;

        private float yacc;

        private float zacc;

        private float xgyro;

        private float ygyro;

        private float zgyro;

        private float lat;

        private float lon;

        private float alt;

        private float stdDevHorz;

        private float stdDevVert;

        private float vn;

        private float ve;

        private float vd;

        /**
         * True attitude quaternion component 1, w (1 in null-rotation) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
        )
        public final Builder q1(float q1) {
            this.q1 = q1;
            return this;
        }

        /**
         * True attitude quaternion component 2, x (0 in null-rotation) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder q2(float q2) {
            this.q2 = q2;
            return this;
        }

        /**
         * True attitude quaternion component 3, y (0 in null-rotation) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4
        )
        public final Builder q3(float q3) {
            this.q3 = q3;
            return this;
        }

        /**
         * True attitude quaternion component 4, z (0 in null-rotation) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder q4(float q4) {
            this.q4 = q4;
            return this;
        }

        /**
         * Attitude roll expressed as Euler angles, not recommended except for human-readable outputs 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4
        )
        public final Builder roll(float roll) {
            this.roll = roll;
            return this;
        }

        /**
         * Attitude pitch expressed as Euler angles, not recommended except for human-readable outputs 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4
        )
        public final Builder pitch(float pitch) {
            this.pitch = pitch;
            return this;
        }

        /**
         * Attitude yaw expressed as Euler angles, not recommended except for human-readable outputs 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4
        )
        public final Builder yaw(float yaw) {
            this.yaw = yaw;
            return this;
        }

        /**
         * X acceleration m/s/s 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4
        )
        public final Builder xacc(float xacc) {
            this.xacc = xacc;
            return this;
        }

        /**
         * Y acceleration m/s/s 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4
        )
        public final Builder yacc(float yacc) {
            this.yacc = yacc;
            return this;
        }

        /**
         * Z acceleration m/s/s 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4
        )
        public final Builder zacc(float zacc) {
            this.zacc = zacc;
            return this;
        }

        /**
         * Angular speed around X axis rad/s 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4
        )
        public final Builder xgyro(float xgyro) {
            this.xgyro = xgyro;
            return this;
        }

        /**
         * Angular speed around Y axis rad/s 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 4
        )
        public final Builder ygyro(float ygyro) {
            this.ygyro = ygyro;
            return this;
        }

        /**
         * Angular speed around Z axis rad/s 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 4
        )
        public final Builder zgyro(float zgyro) {
            this.zgyro = zgyro;
            return this;
        }

        /**
         * Latitude in degrees 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 4
        )
        public final Builder lat(float lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Longitude in degrees 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 4
        )
        public final Builder lon(float lon) {
            this.lon = lon;
            return this;
        }

        /**
         * Altitude in meters 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 4
        )
        public final Builder alt(float alt) {
            this.alt = alt;
            return this;
        }

        /**
         * Horizontal position standard deviation 
         */
        @MavlinkFieldInfo(
                position = 17,
                unitSize = 4
        )
        public final Builder stdDevHorz(float stdDevHorz) {
            this.stdDevHorz = stdDevHorz;
            return this;
        }

        /**
         * Vertical position standard deviation 
         */
        @MavlinkFieldInfo(
                position = 18,
                unitSize = 4
        )
        public final Builder stdDevVert(float stdDevVert) {
            this.stdDevVert = stdDevVert;
            return this;
        }

        /**
         * True velocity in m/s in NORTH direction in earth-fixed NED frame 
         */
        @MavlinkFieldInfo(
                position = 19,
                unitSize = 4
        )
        public final Builder vn(float vn) {
            this.vn = vn;
            return this;
        }

        /**
         * True velocity in m/s in EAST direction in earth-fixed NED frame 
         */
        @MavlinkFieldInfo(
                position = 20,
                unitSize = 4
        )
        public final Builder ve(float ve) {
            this.ve = ve;
            return this;
        }

        /**
         * True velocity in m/s in DOWN direction in earth-fixed NED frame 
         */
        @MavlinkFieldInfo(
                position = 21,
                unitSize = 4
        )
        public final Builder vd(float vd) {
            this.vd = vd;
            return this;
        }

        public final SimState build() {
            return new SimState(q1, q2, q3, q4, roll, pitch, yaw, xacc, yacc, zacc, xgyro, ygyro, zgyro, lat, lon, alt, stdDevHorz, stdDevVert, vn, ve, vd);
        }
    }
}
