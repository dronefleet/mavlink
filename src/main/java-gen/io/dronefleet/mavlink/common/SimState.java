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
        crc = 32,
        description = "Status of simulation environment, if used"
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
            unitSize = 4,
            description = "True attitude quaternion component 1, w (1 in null-rotation)"
    )
    public final float q1() {
        return this.q1;
    }

    /**
     * True attitude quaternion component 2, x (0 in null-rotation) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "True attitude quaternion component 2, x (0 in null-rotation)"
    )
    public final float q2() {
        return this.q2;
    }

    /**
     * True attitude quaternion component 3, y (0 in null-rotation) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "True attitude quaternion component 3, y (0 in null-rotation)"
    )
    public final float q3() {
        return this.q3;
    }

    /**
     * True attitude quaternion component 4, z (0 in null-rotation) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "True attitude quaternion component 4, z (0 in null-rotation)"
    )
    public final float q4() {
        return this.q4;
    }

    /**
     * Attitude roll expressed as Euler angles, not recommended except for human-readable outputs 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Attitude roll expressed as Euler angles, not recommended except for human-readable outputs"
    )
    public final float roll() {
        return this.roll;
    }

    /**
     * Attitude pitch expressed as Euler angles, not recommended except for human-readable outputs 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Attitude pitch expressed as Euler angles, not recommended except for human-readable outputs"
    )
    public final float pitch() {
        return this.pitch;
    }

    /**
     * Attitude yaw expressed as Euler angles, not recommended except for human-readable outputs 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Attitude yaw expressed as Euler angles, not recommended except for human-readable outputs"
    )
    public final float yaw() {
        return this.yaw;
    }

    /**
     * X acceleration 
     */
    @MavlinkFieldInfo(
            position = 8,
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
            position = 9,
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
            position = 10,
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
            position = 11,
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
            position = 12,
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
            position = 13,
            unitSize = 4,
            description = "Angular speed around Z axis"
    )
    public final float zgyro() {
        return this.zgyro;
    }

    /**
     * Latitude 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 4,
            description = "Latitude"
    )
    public final float lat() {
        return this.lat;
    }

    /**
     * Longitude 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 4,
            description = "Longitude"
    )
    public final float lon() {
        return this.lon;
    }

    /**
     * Altitude 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 4,
            description = "Altitude"
    )
    public final float alt() {
        return this.alt;
    }

    /**
     * Horizontal position standard deviation 
     */
    @MavlinkFieldInfo(
            position = 17,
            unitSize = 4,
            description = "Horizontal position standard deviation"
    )
    public final float stdDevHorz() {
        return this.stdDevHorz;
    }

    /**
     * Vertical position standard deviation 
     */
    @MavlinkFieldInfo(
            position = 18,
            unitSize = 4,
            description = "Vertical position standard deviation"
    )
    public final float stdDevVert() {
        return this.stdDevVert;
    }

    /**
     * True velocity in NORTH direction in earth-fixed NED frame 
     */
    @MavlinkFieldInfo(
            position = 19,
            unitSize = 4,
            description = "True velocity in NORTH direction in earth-fixed NED frame"
    )
    public final float vn() {
        return this.vn;
    }

    /**
     * True velocity in EAST direction in earth-fixed NED frame 
     */
    @MavlinkFieldInfo(
            position = 20,
            unitSize = 4,
            description = "True velocity in EAST direction in earth-fixed NED frame"
    )
    public final float ve() {
        return this.ve;
    }

    /**
     * True velocity in DOWN direction in earth-fixed NED frame 
     */
    @MavlinkFieldInfo(
            position = 21,
            unitSize = 4,
            description = "True velocity in DOWN direction in earth-fixed NED frame"
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
                unitSize = 4,
                description = "True attitude quaternion component 1, w (1 in null-rotation)"
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
                unitSize = 4,
                description = "True attitude quaternion component 2, x (0 in null-rotation)"
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
                unitSize = 4,
                description = "True attitude quaternion component 3, y (0 in null-rotation)"
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
                unitSize = 4,
                description = "True attitude quaternion component 4, z (0 in null-rotation)"
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
                unitSize = 4,
                description = "Attitude roll expressed as Euler angles, not recommended except for human-readable outputs"
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
                unitSize = 4,
                description = "Attitude pitch expressed as Euler angles, not recommended except for human-readable outputs"
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
                unitSize = 4,
                description = "Attitude yaw expressed as Euler angles, not recommended except for human-readable outputs"
        )
        public final Builder yaw(float yaw) {
            this.yaw = yaw;
            return this;
        }

        /**
         * X acceleration 
         */
        @MavlinkFieldInfo(
                position = 8,
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
                position = 9,
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
                position = 10,
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
                position = 11,
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
                position = 12,
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
                position = 13,
                unitSize = 4,
                description = "Angular speed around Z axis"
        )
        public final Builder zgyro(float zgyro) {
            this.zgyro = zgyro;
            return this;
        }

        /**
         * Latitude 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 4,
                description = "Latitude"
        )
        public final Builder lat(float lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Longitude 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 4,
                description = "Longitude"
        )
        public final Builder lon(float lon) {
            this.lon = lon;
            return this;
        }

        /**
         * Altitude 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 4,
                description = "Altitude"
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
                unitSize = 4,
                description = "Horizontal position standard deviation"
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
                unitSize = 4,
                description = "Vertical position standard deviation"
        )
        public final Builder stdDevVert(float stdDevVert) {
            this.stdDevVert = stdDevVert;
            return this;
        }

        /**
         * True velocity in NORTH direction in earth-fixed NED frame 
         */
        @MavlinkFieldInfo(
                position = 19,
                unitSize = 4,
                description = "True velocity in NORTH direction in earth-fixed NED frame"
        )
        public final Builder vn(float vn) {
            this.vn = vn;
            return this;
        }

        /**
         * True velocity in EAST direction in earth-fixed NED frame 
         */
        @MavlinkFieldInfo(
                position = 20,
                unitSize = 4,
                description = "True velocity in EAST direction in earth-fixed NED frame"
        )
        public final Builder ve(float ve) {
            this.ve = ve;
            return this;
        }

        /**
         * True velocity in DOWN direction in earth-fixed NED frame 
         */
        @MavlinkFieldInfo(
                position = 21,
                unitSize = 4,
                description = "True velocity in DOWN direction in earth-fixed NED frame"
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
