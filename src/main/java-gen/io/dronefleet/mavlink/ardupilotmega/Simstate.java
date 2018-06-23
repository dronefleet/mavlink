package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Status of simulation environment, if used 
 */
@MavlinkMessageInfo(
        id = 164,
        crc = 154
)
public final class Simstate {
    /**
     * Roll angle (rad) 
     */
    private final float roll;

    /**
     * Pitch angle (rad) 
     */
    private final float pitch;

    /**
     * Yaw angle (rad) 
     */
    private final float yaw;

    /**
     * X acceleration m/s/s 
     */
    private final float xacc;

    /**
     * Y acceleration m/s/s 
     */
    private final float yacc;

    /**
     * Z acceleration m/s/s 
     */
    private final float zacc;

    /**
     * Angular speed around X axis rad/s 
     */
    private final float xgyro;

    /**
     * Angular speed around Y axis rad/s 
     */
    private final float ygyro;

    /**
     * Angular speed around Z axis rad/s 
     */
    private final float zgyro;

    /**
     * Latitude in degrees * 1E7 
     */
    private final int lat;

    /**
     * Longitude in degrees * 1E7 
     */
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

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
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

    /**
     * Roll angle (rad) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final float roll() {
        return roll;
    }

    /**
     * Pitch angle (rad) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4
    )
    public final float pitch() {
        return pitch;
    }

    /**
     * Yaw angle (rad) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4
    )
    public final float yaw() {
        return yaw;
    }

    /**
     * X acceleration m/s/s 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float xacc() {
        return xacc;
    }

    /**
     * Y acceleration m/s/s 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4
    )
    public final float yacc() {
        return yacc;
    }

    /**
     * Z acceleration m/s/s 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4
    )
    public final float zacc() {
        return zacc;
    }

    /**
     * Angular speed around X axis rad/s 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4
    )
    public final float xgyro() {
        return xgyro;
    }

    /**
     * Angular speed around Y axis rad/s 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4
    )
    public final float ygyro() {
        return ygyro;
    }

    /**
     * Angular speed around Z axis rad/s 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 4
    )
    public final float zgyro() {
        return zgyro;
    }

    /**
     * Latitude in degrees * 1E7 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 4,
            signed = true
    )
    public final int lat() {
        return lat;
    }

    /**
     * Longitude in degrees * 1E7 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 4,
            signed = true
    )
    public final int lng() {
        return lng;
    }

    public static class Builder {
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

        private Builder() {
        }

        /**
         * Roll angle (rad) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
        )
        public final Builder roll(float roll) {
            this.roll = roll;
            return this;
        }

        /**
         * Pitch angle (rad) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4
        )
        public final Builder pitch(float pitch) {
            this.pitch = pitch;
            return this;
        }

        /**
         * Yaw angle (rad) 
         */
        @MavlinkFieldInfo(
                position = 3,
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
                position = 4,
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
                position = 5,
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
                position = 6,
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
                position = 7,
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
                position = 8,
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
                position = 9,
                unitSize = 4
        )
        public final Builder zgyro(float zgyro) {
            this.zgyro = zgyro;
            return this;
        }

        /**
         * Latitude in degrees * 1E7 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 4,
                signed = true
        )
        public final Builder lat(int lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Longitude in degrees * 1E7 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 4,
                signed = true
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
