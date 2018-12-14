package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * The location and information of an ADSB vehicle 
 */
@MavlinkMessageInfo(
        id = 246,
        crc = 184,
        description = "The location and information of an ADSB vehicle"
)
public final class AdsbVehicle {
    private final long icaoAddress;

    private final int lat;

    private final int lon;

    private final EnumValue<AdsbAltitudeType> altitudeType;

    private final int altitude;

    private final int heading;

    private final int horVelocity;

    private final int verVelocity;

    private final String callsign;

    private final EnumValue<AdsbEmitterType> emitterType;

    private final int tslc;

    private final EnumValue<AdsbFlags> flags;

    private final int squawk;

    private AdsbVehicle(long icaoAddress, int lat, int lon,
            EnumValue<AdsbAltitudeType> altitudeType, int altitude, int heading, int horVelocity,
            int verVelocity, String callsign, EnumValue<AdsbEmitterType> emitterType, int tslc,
            EnumValue<AdsbFlags> flags, int squawk) {
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
            unitSize = 4,
            description = "ICAO address"
    )
    public final long icaoAddress() {
        return this.icaoAddress;
    }

    /**
     * Latitude 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            signed = true,
            description = "Latitude"
    )
    public final int lat() {
        return this.lat;
    }

    /**
     * Longitude 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            signed = true,
            description = "Longitude"
    )
    public final int lon() {
        return this.lon;
    }

    /**
     * ADSB altitude type. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            enumType = AdsbAltitudeType.class,
            description = "ADSB altitude type."
    )
    public final EnumValue<AdsbAltitudeType> altitudeType() {
        return this.altitudeType;
    }

    /**
     * Altitude(ASL) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            signed = true,
            description = "Altitude(ASL)"
    )
    public final int altitude() {
        return this.altitude;
    }

    /**
     * Course over ground 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            description = "Course over ground"
    )
    public final int heading() {
        return this.heading;
    }

    /**
     * The horizontal velocity 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            description = "The horizontal velocity"
    )
    public final int horVelocity() {
        return this.horVelocity;
    }

    /**
     * The vertical velocity. Positive is up 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2,
            signed = true,
            description = "The vertical velocity. Positive is up"
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
            arraySize = 9,
            description = "The callsign, 8+null"
    )
    public final String callsign() {
        return this.callsign;
    }

    /**
     * ADSB emitter type. 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1,
            enumType = AdsbEmitterType.class,
            description = "ADSB emitter type."
    )
    public final EnumValue<AdsbEmitterType> emitterType() {
        return this.emitterType;
    }

    /**
     * Time since last communication in seconds 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 1,
            description = "Time since last communication in seconds"
    )
    public final int tslc() {
        return this.tslc;
    }

    /**
     * Bitmap to indicate various statuses including valid data fields 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 2,
            enumType = AdsbFlags.class,
            description = "Bitmap to indicate various statuses including valid data fields"
    )
    public final EnumValue<AdsbFlags> flags() {
        return this.flags;
    }

    /**
     * Squawk code 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 2,
            description = "Squawk code"
    )
    public final int squawk() {
        return this.squawk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        AdsbVehicle other = (AdsbVehicle)o;
        if (!Objects.deepEquals(icaoAddress, other.icaoAddress)) return false;
        if (!Objects.deepEquals(lat, other.lat)) return false;
        if (!Objects.deepEquals(lon, other.lon)) return false;
        if (!Objects.deepEquals(altitudeType, other.altitudeType)) return false;
        if (!Objects.deepEquals(altitude, other.altitude)) return false;
        if (!Objects.deepEquals(heading, other.heading)) return false;
        if (!Objects.deepEquals(horVelocity, other.horVelocity)) return false;
        if (!Objects.deepEquals(verVelocity, other.verVelocity)) return false;
        if (!Objects.deepEquals(callsign, other.callsign)) return false;
        if (!Objects.deepEquals(emitterType, other.emitterType)) return false;
        if (!Objects.deepEquals(tslc, other.tslc)) return false;
        if (!Objects.deepEquals(flags, other.flags)) return false;
        if (!Objects.deepEquals(squawk, other.squawk)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(icaoAddress);
        result = 31 * result + Objects.hashCode(lat);
        result = 31 * result + Objects.hashCode(lon);
        result = 31 * result + Objects.hashCode(altitudeType);
        result = 31 * result + Objects.hashCode(altitude);
        result = 31 * result + Objects.hashCode(heading);
        result = 31 * result + Objects.hashCode(horVelocity);
        result = 31 * result + Objects.hashCode(verVelocity);
        result = 31 * result + Objects.hashCode(callsign);
        result = 31 * result + Objects.hashCode(emitterType);
        result = 31 * result + Objects.hashCode(tslc);
        result = 31 * result + Objects.hashCode(flags);
        result = 31 * result + Objects.hashCode(squawk);
        return result;
    }

    @Override
    public String toString() {
        return "AdsbVehicle{icaoAddress=" + icaoAddress
                 + ", lat=" + lat
                 + ", lon=" + lon
                 + ", altitudeType=" + altitudeType
                 + ", altitude=" + altitude
                 + ", heading=" + heading
                 + ", horVelocity=" + horVelocity
                 + ", verVelocity=" + verVelocity
                 + ", callsign=" + callsign
                 + ", emitterType=" + emitterType
                 + ", tslc=" + tslc
                 + ", flags=" + flags
                 + ", squawk=" + squawk + "}";
    }

    public static final class Builder {
        private long icaoAddress;

        private int lat;

        private int lon;

        private EnumValue<AdsbAltitudeType> altitudeType;

        private int altitude;

        private int heading;

        private int horVelocity;

        private int verVelocity;

        private String callsign;

        private EnumValue<AdsbEmitterType> emitterType;

        private int tslc;

        private EnumValue<AdsbFlags> flags;

        private int squawk;

        /**
         * ICAO address 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "ICAO address"
        )
        public final Builder icaoAddress(long icaoAddress) {
            this.icaoAddress = icaoAddress;
            return this;
        }

        /**
         * Latitude 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                signed = true,
                description = "Latitude"
        )
        public final Builder lat(int lat) {
            this.lat = lat;
            return this;
        }

        /**
         * Longitude 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                signed = true,
                description = "Longitude"
        )
        public final Builder lon(int lon) {
            this.lon = lon;
            return this;
        }

        /**
         * ADSB altitude type. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                enumType = AdsbAltitudeType.class,
                description = "ADSB altitude type."
        )
        public final Builder altitudeType(EnumValue<AdsbAltitudeType> altitudeType) {
            this.altitudeType = altitudeType;
            return this;
        }

        /**
         * ADSB altitude type. 
         */
        public final Builder altitudeType(AdsbAltitudeType entry) {
            return altitudeType(EnumValue.of(entry));
        }

        /**
         * ADSB altitude type. 
         */
        public final Builder altitudeType(Enum... flags) {
            return altitudeType(EnumValue.create(flags));
        }

        /**
         * ADSB altitude type. 
         */
        public final Builder altitudeType(Collection<Enum> flags) {
            return altitudeType(EnumValue.create(flags));
        }

        /**
         * Altitude(ASL) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                signed = true,
                description = "Altitude(ASL)"
        )
        public final Builder altitude(int altitude) {
            this.altitude = altitude;
            return this;
        }

        /**
         * Course over ground 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                description = "Course over ground"
        )
        public final Builder heading(int heading) {
            this.heading = heading;
            return this;
        }

        /**
         * The horizontal velocity 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                description = "The horizontal velocity"
        )
        public final Builder horVelocity(int horVelocity) {
            this.horVelocity = horVelocity;
            return this;
        }

        /**
         * The vertical velocity. Positive is up 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2,
                signed = true,
                description = "The vertical velocity. Positive is up"
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
                arraySize = 9,
                description = "The callsign, 8+null"
        )
        public final Builder callsign(String callsign) {
            this.callsign = callsign;
            return this;
        }

        /**
         * ADSB emitter type. 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 1,
                enumType = AdsbEmitterType.class,
                description = "ADSB emitter type."
        )
        public final Builder emitterType(EnumValue<AdsbEmitterType> emitterType) {
            this.emitterType = emitterType;
            return this;
        }

        /**
         * ADSB emitter type. 
         */
        public final Builder emitterType(AdsbEmitterType entry) {
            return emitterType(EnumValue.of(entry));
        }

        /**
         * ADSB emitter type. 
         */
        public final Builder emitterType(Enum... flags) {
            return emitterType(EnumValue.create(flags));
        }

        /**
         * ADSB emitter type. 
         */
        public final Builder emitterType(Collection<Enum> flags) {
            return emitterType(EnumValue.create(flags));
        }

        /**
         * Time since last communication in seconds 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 1,
                description = "Time since last communication in seconds"
        )
        public final Builder tslc(int tslc) {
            this.tslc = tslc;
            return this;
        }

        /**
         * Bitmap to indicate various statuses including valid data fields 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 2,
                enumType = AdsbFlags.class,
                description = "Bitmap to indicate various statuses including valid data fields"
        )
        public final Builder flags(EnumValue<AdsbFlags> flags) {
            this.flags = flags;
            return this;
        }

        /**
         * Bitmap to indicate various statuses including valid data fields 
         */
        public final Builder flags(AdsbFlags entry) {
            return flags(EnumValue.of(entry));
        }

        /**
         * Bitmap to indicate various statuses including valid data fields 
         */
        public final Builder flags(Enum... flags) {
            return flags(EnumValue.create(flags));
        }

        /**
         * Bitmap to indicate various statuses including valid data fields 
         */
        public final Builder flags(Collection<Enum> flags) {
            return flags(EnumValue.create(flags));
        }

        /**
         * Squawk code 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 2,
                description = "Squawk code"
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
