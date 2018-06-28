package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumFlagSet;
import java.lang.String;

/**
 * The location and information of an ADSB vehicle 
 */
@MavlinkMessageInfo(
        id = 246,
        crc = 184
)
public final class AdsbVehicle {
    private final long icaoAddress;

    private final int lat;

    private final int lon;

    private final AdsbAltitudeType altitudeType;

    private final int altitude;

    private final int heading;

    private final int horVelocity;

    private final int verVelocity;

    private final String callsign;

    private final AdsbEmitterType emitterType;

    private final int tslc;

    private final EnumFlagSet<AdsbFlags> flags;

    private final int squawk;

    private AdsbVehicle(long icaoAddress, int lat, int lon, AdsbAltitudeType altitudeType,
            int altitude, int heading, int horVelocity, int verVelocity, String callsign,
            AdsbEmitterType emitterType, int tslc, EnumFlagSet<AdsbFlags> flags, int squawk) {
        this.icaoAddress = icaoAddress;
        this.lat = lat;
        this.lon = lon;
        this.altitudeType = altitudeType;
        this.altitude = altitude;
        this.heading = heading;
        this.horVelocity = horVelocity;
        this.verVelocity = verVelocity;
        this.callsign = callsign;
        this.emitterType = emitterType;
        this.tslc = tslc;
        this.flags = flags;
        this.squawk = squawk;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * ICAO address 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4
    )
    public final long icaoAddress() {
        return this.icaoAddress;
    }

    /**
     * Latitude, expressed as degrees * 1E7 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            signed = true
    )
    public final int lat() {
        return this.lat;
    }

    /**
     * Longitude, expressed as degrees * 1E7 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            signed = true
    )
    public final int lon() {
        return this.lon;
    }

    /**
     * Type from {@link io.dronefleet.mavlink.common.AdsbAltitudeType ADSB_ALTITUDE_TYPE} enum 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final AdsbAltitudeType altitudeType() {
        return this.altitudeType;
    }

    /**
     * Altitude(ASL) in millimeters 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true
    )
    public final int altitude() {
        return this.altitude;
    }

    /**
     * Course over ground in centidegrees 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2
    )
    public final int heading() {
        return this.heading;
    }

    /**
     * The horizontal velocity in centimeters/second 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2
    )
    public final int horVelocity() {
        return this.horVelocity;
    }

    /**
     * The vertical velocity in centimeters/second, positive is up 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2,
            signed = true
    )
    public final int verVelocity() {
        return this.verVelocity;
    }

    /**
     * The callsign, 8+null 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 1,
            arraySize = 9
    )
    public final String callsign() {
        return this.callsign;
    }

    /**
     * Type from {@link io.dronefleet.mavlink.common.AdsbEmitterType ADSB_EMITTER_TYPE} enum 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1
    )
    public final AdsbEmitterType emitterType() {
        return this.emitterType;
    }

    /**
     * Time since last communication in seconds 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 1
    )
    public final int tslc() {
        return this.tslc;
    }

    /**
     * Flags to indicate various statuses including valid data fields 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 2
    )
    public final EnumFlagSet<AdsbFlags> flags() {
        return this.flags;
    }

    /**
     * Squawk code 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 2
    )
    public final int squawk() {
        return this.squawk;
    }

    public static final class Builder {
        private long icaoAddress;

        private int lat;

        private int lon;

        private AdsbAltitudeType altitudeType;

        private int altitude;

        private int heading;

        private int horVelocity;

        private int verVelocity;

        private String callsign;

        private AdsbEmitterType emitterType;

        private int tslc;

        private EnumFlagSet<AdsbFlags> flags;

        private int squawk;

        /**
         * ICAO address 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
        )
        public final Builder icaoAddress(long icaoAddress) {
            this.icaoAddress = icaoAddress;
            return this;
        }

        /**
         * Latitude, expressed as degrees * 1E7 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                signed = true
        )
        public final Builder lat(int lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Longitude, expressed as degrees * 1E7 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                signed = true
        )
        public final Builder lon(int lon) {
            this.lon = lon;
            return this;
        }

        /**
         * Type from {@link io.dronefleet.mavlink.common.AdsbAltitudeType ADSB_ALTITUDE_TYPE} enum 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1
        )
        public final Builder altitudeType(AdsbAltitudeType altitudeType) {
            this.altitudeType = altitudeType;
            return this;
        }

        /**
         * Altitude(ASL) in millimeters 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true
        )
        public final Builder altitude(int altitude) {
            this.altitude = altitude;
            return this;
        }

        /**
         * Course over ground in centidegrees 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2
        )
        public final Builder heading(int heading) {
            this.heading = heading;
            return this;
        }

        /**
         * The horizontal velocity in centimeters/second 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2
        )
        public final Builder horVelocity(int horVelocity) {
            this.horVelocity = horVelocity;
            return this;
        }

        /**
         * The vertical velocity in centimeters/second, positive is up 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2,
                signed = true
        )
        public final Builder verVelocity(int verVelocity) {
            this.verVelocity = verVelocity;
            return this;
        }

        /**
         * The callsign, 8+null 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 1,
                arraySize = 9
        )
        public final Builder callsign(String callsign) {
            this.callsign = callsign;
            return this;
        }

        /**
         * Type from {@link io.dronefleet.mavlink.common.AdsbEmitterType ADSB_EMITTER_TYPE} enum 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 1
        )
        public final Builder emitterType(AdsbEmitterType emitterType) {
            this.emitterType = emitterType;
            return this;
        }

        /**
         * Time since last communication in seconds 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 1
        )
        public final Builder tslc(int tslc) {
            this.tslc = tslc;
            return this;
        }

        /**
         * Flags to indicate various statuses including valid data fields 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 2
        )
        public final Builder flags(EnumFlagSet<AdsbFlags> flags) {
            this.flags = flags;
            return this;
        }

        /**
         * Squawk code 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 2
        )
        public final Builder squawk(int squawk) {
            this.squawk = squawk;
            return this;
        }

        public final AdsbVehicle build() {
            return new AdsbVehicle(icaoAddress, lat, lon, altitudeType, altitude, heading, horVelocity, verVelocity, callsign, emitterType, tslc, flags, squawk);
        }
    }
}
