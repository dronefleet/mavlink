package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Status of simulation environment, if used. 
 */
@MavlinkMessageInfo(
        id = 164,
        crc = 154,
        description = "Status of simulation environment, if used."
)
public final class Simstate {
    private final float roll;

    private final float pitch;

    private final float yaw;

    private final float xacc;

    private final float yacc;

    private final float zacc;

    private final float xgyro;

    private final float ygyro;

    private final float zgyro;

    private final int lat;

    private final int lng;

    private Simstate(float roll, float pitch, float yaw, float xacc, float yacc, float zacc,
            float xgyro, float ygyro, float zgyro, int lat, int lng) {
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
        this.lng = lng;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Roll angle. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Roll angle."
    )
    public final float roll() {
        return this.roll;
    }

    /**
     * Pitch angle. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Pitch angle."
    )
    public final float pitch() {
        return this.pitch;
    }

    /**
     * Yaw angle. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            description = "Yaw angle."
    )
    public final float yaw() {
        return this.yaw;
    }

    /**
     * X acceleration. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "X acceleration."
    )
    public final float xacc() {
        return this.xacc;
    }

    /**
     * Y acceleration. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Y acceleration."
    )
    public final float yacc() {
        return this.yacc;
    }

    /**
     * Z acceleration. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Z acceleration."
    )
    public final float zacc() {
        return this.zacc;
    }

    /**
     * Angular speed around X axis. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            description = "Angular speed around X axis."
    )
    public final float xgyro() {
        return this.xgyro;
    }

    /**
     * Angular speed around Y axis. 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Angular speed around Y axis."
    )
    public final float ygyro() {
        return this.ygyro;
    }

    /**
     * Angular speed around Z axis. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4,
            description = "Angular speed around Z axis."
    )
    public final float zgyro() {
        return this.zgyro;
    }

    /**
     * Latitude. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            signed = true,
            description = "Latitude."
    )
    public final int lat() {
        return this.lat;
    }

    /**
     * Longitude. 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            signed = true,
            description = "Longitude."
    )
    public final int lng() {
        return this.lng;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        Simstate other = (Simstate)o;
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
        if (!Objects.deepEquals(lng, other.lng)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
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
        result = 31 * result + Objects.hashCode(lng);
        return result;
    }

    @Override
    public String toString() {
        return "Simstate{roll=" + roll
                 + ", pitch=" + pitch
                 + ", yaw=" + yaw
                 + ", xacc=" + xacc
                 + ", yacc=" + yacc
                 + ", zacc=" + zacc
                 + ", xgyro=" + xgyro
                 + ", ygyro=" + ygyro
                 + ", zgyro=" + zgyro
                 + ", lat=" + lat
                 + ", lng=" + lng + "}";
    }

    public static final class Builder {
        private float roll;

        private float pitch;

        private float yaw;

        private float xacc;

        private float yacc;

        private float zacc;

        private float xgyro;

        private float ygyro;

        private float zgyro;

        private int lat;

        private int lng;

        /**
         * Roll angle. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Roll angle."
        )
        public final Builder roll(float roll) {
            this.roll = roll;
            return this;
        }

        /**
         * Pitch angle. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Pitch angle."
        )
        public final Builder pitch(float pitch) {
            this.pitch = pitch;
            return this;
        }

        /**
         * Yaw angle. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                description = "Yaw angle."
        )
        public final Builder yaw(float yaw) {
            this.yaw = yaw;
            return this;
        }

        /**
         * X acceleration. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                description = "X acceleration."
        )
        public final Builder xacc(float xacc) {
            this.xacc = xacc;
            return this;
        }

        /**
         * Y acceleration. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Y acceleration."
        )
        public final Builder yacc(float yacc) {
            this.yacc = yacc;
            return this;
        }

        /**
         * Z acceleration. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Z acceleration."
        )
        public final Builder zacc(float zacc) {
            this.zacc = zacc;
            return this;
        }

        /**
         * Angular speed around X axis. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                description = "Angular speed around X axis."
        )
        public final Builder xgyro(float xgyro) {
            this.xgyro = xgyro;
            return this;
        }

        /**
         * Angular speed around Y axis. 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Angular speed around Y axis."
        )
        public final Builder ygyro(float ygyro) {
            this.ygyro = ygyro;
            return this;
        }

        /**
         * Angular speed around Z axis. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 4,
                description = "Angular speed around Z axis."
        )
        public final Builder zgyro(float zgyro) {
            this.zgyro = zgyro;
            return this;
        }

        /**
         * Latitude. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                signed = true,
                description = "Latitude."
        )
        public final Builder lat(int lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Longitude. 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                signed = true,
                description = "Longitude."
        )
        public final Builder lng(int lng) {
            this.lng = lng;
            return this;
        }

        public final Simstate build() {
            return new Simstate(roll, pitch, yaw, xacc, yacc, zacc, xgyro, ygyro, zgyro, lat, lng);
        }
    }
}
