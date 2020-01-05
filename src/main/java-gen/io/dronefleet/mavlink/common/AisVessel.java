package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Deprecated;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * The location and information of an AIS vessel 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 301,
        crc = 243,
        description = "The location and information of an AIS vessel",
        workInProgress = true
)
@Deprecated
public final class AisVessel {
    private final long mmsi;

    private final int lat;

    private final int lon;

    private final int cog;

    private final int heading;

    private final int velocity;

    private final int turnRate;

    private final EnumValue<AisNavStatus> navigationalStatus;

    private final EnumValue<AisType> type;

    private final int dimensionBow;

    private final int dimensionStern;

    private final int dimensionPort;

    private final int dimensionStarboard;

    private final String callsign;

    private final String name;

    private final int tslc;

    private final EnumValue<AisFlags> flags;

    private AisVessel(long mmsi, int lat, int lon, int cog, int heading, int velocity, int turnRate,
            EnumValue<AisNavStatus> navigationalStatus, EnumValue<AisType> type, int dimensionBow,
            int dimensionStern, int dimensionPort, int dimensionStarboard, String callsign,
            String name, int tslc, EnumValue<AisFlags> flags) {
        this.mmsi = mmsi;
        this.lat = lat;
        this.lon = lon;
        this.cog = cog;
        this.heading = heading;
        this.velocity = velocity;
        this.turnRate = turnRate;
        this.navigationalStatus = navigationalStatus;
        this.type = type;
        this.dimensionBow = dimensionBow;
        this.dimensionStern = dimensionStern;
        this.dimensionPort = dimensionPort;
        this.dimensionStarboard = dimensionStarboard;
        this.callsign = callsign;
        this.name = name;
        this.tslc = tslc;
        this.flags = flags;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Mobile Marine Service Identifier, 9 decimal digits 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Mobile Marine Service Identifier, 9 decimal digits"
    )
    public final long mmsi() {
        return this.mmsi;
    }

    /**
     * Latitude 
     */
    @MavlinkFieldInfo(
            position = 3,
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
            position = 4,
            unitSize = 4,
            signed = true,
            description = "Longitude"
    )
    public final int lon() {
        return this.lon;
    }

    /**
     * Course over ground 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 2,
            description = "Course over ground"
    )
    public final int cog() {
        return this.cog;
    }

    /**
     * True heading 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2,
            description = "True heading"
    )
    public final int heading() {
        return this.heading;
    }

    /**
     * Speed over ground 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            description = "Speed over ground"
    )
    public final int velocity() {
        return this.velocity;
    }

    /**
     * Turn rate 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1,
            signed = true,
            description = "Turn rate"
    )
    public final int turnRate() {
        return this.turnRate;
    }

    /**
     * Navigational status 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 1,
            enumType = AisNavStatus.class,
            description = "Navigational status"
    )
    public final EnumValue<AisNavStatus> navigationalStatus() {
        return this.navigationalStatus;
    }

    /**
     * Type of vessels 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 1,
            enumType = AisType.class,
            description = "Type of vessels"
    )
    public final EnumValue<AisType> type() {
        return this.type;
    }

    /**
     * Distance from lat/lon location to bow 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 2,
            description = "Distance from lat/lon location to bow"
    )
    public final int dimensionBow() {
        return this.dimensionBow;
    }

    /**
     * Distance from lat/lon location to stern 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 2,
            description = "Distance from lat/lon location to stern"
    )
    public final int dimensionStern() {
        return this.dimensionStern;
    }

    /**
     * Distance from lat/lon location to port side 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 1,
            description = "Distance from lat/lon location to port side"
    )
    public final int dimensionPort() {
        return this.dimensionPort;
    }

    /**
     * Distance from lat/lon location to starboard side 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 1,
            description = "Distance from lat/lon location to starboard side"
    )
    public final int dimensionStarboard() {
        return this.dimensionStarboard;
    }

    /**
     * The vessel callsign 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 1,
            arraySize = 7,
            description = "The vessel callsign"
    )
    public final String callsign() {
        return this.callsign;
    }

    /**
     * The vessel name 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 1,
            arraySize = 20,
            description = "The vessel name"
    )
    public final String name() {
        return this.name;
    }

    /**
     * Time since last communication in seconds 
     */
    @MavlinkFieldInfo(
            position = 17,
            unitSize = 2,
            description = "Time since last communication in seconds"
    )
    public final int tslc() {
        return this.tslc;
    }

    /**
     * Bitmask to indicate various statuses including valid data fields 
     */
    @MavlinkFieldInfo(
            position = 18,
            unitSize = 2,
            enumType = AisFlags.class,
            description = "Bitmask to indicate various statuses including valid data fields"
    )
    public final EnumValue<AisFlags> flags() {
        return this.flags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        AisVessel other = (AisVessel)o;
        if (!Objects.deepEquals(mmsi, other.mmsi)) return false;
        if (!Objects.deepEquals(lat, other.lat)) return false;
        if (!Objects.deepEquals(lon, other.lon)) return false;
        if (!Objects.deepEquals(cog, other.cog)) return false;
        if (!Objects.deepEquals(heading, other.heading)) return false;
        if (!Objects.deepEquals(velocity, other.velocity)) return false;
        if (!Objects.deepEquals(turnRate, other.turnRate)) return false;
        if (!Objects.deepEquals(navigationalStatus, other.navigationalStatus)) return false;
        if (!Objects.deepEquals(type, other.type)) return false;
        if (!Objects.deepEquals(dimensionBow, other.dimensionBow)) return false;
        if (!Objects.deepEquals(dimensionStern, other.dimensionStern)) return false;
        if (!Objects.deepEquals(dimensionPort, other.dimensionPort)) return false;
        if (!Objects.deepEquals(dimensionStarboard, other.dimensionStarboard)) return false;
        if (!Objects.deepEquals(callsign, other.callsign)) return false;
        if (!Objects.deepEquals(name, other.name)) return false;
        if (!Objects.deepEquals(tslc, other.tslc)) return false;
        if (!Objects.deepEquals(flags, other.flags)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(mmsi);
        result = 31 * result + Objects.hashCode(lat);
        result = 31 * result + Objects.hashCode(lon);
        result = 31 * result + Objects.hashCode(cog);
        result = 31 * result + Objects.hashCode(heading);
        result = 31 * result + Objects.hashCode(velocity);
        result = 31 * result + Objects.hashCode(turnRate);
        result = 31 * result + Objects.hashCode(navigationalStatus);
        result = 31 * result + Objects.hashCode(type);
        result = 31 * result + Objects.hashCode(dimensionBow);
        result = 31 * result + Objects.hashCode(dimensionStern);
        result = 31 * result + Objects.hashCode(dimensionPort);
        result = 31 * result + Objects.hashCode(dimensionStarboard);
        result = 31 * result + Objects.hashCode(callsign);
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(tslc);
        result = 31 * result + Objects.hashCode(flags);
        return result;
    }

    @Override
    public String toString() {
        return "AisVessel{mmsi=" + mmsi
                 + ", lat=" + lat
                 + ", lon=" + lon
                 + ", cog=" + cog
                 + ", heading=" + heading
                 + ", velocity=" + velocity
                 + ", turnRate=" + turnRate
                 + ", navigationalStatus=" + navigationalStatus
                 + ", type=" + type
                 + ", dimensionBow=" + dimensionBow
                 + ", dimensionStern=" + dimensionStern
                 + ", dimensionPort=" + dimensionPort
                 + ", dimensionStarboard=" + dimensionStarboard
                 + ", callsign=" + callsign
                 + ", name=" + name
                 + ", tslc=" + tslc
                 + ", flags=" + flags + "}";
    }

    public static final class Builder {
        private long mmsi;

        private int lat;

        private int lon;

        private int cog;

        private int heading;

        private int velocity;

        private int turnRate;

        private EnumValue<AisNavStatus> navigationalStatus;

        private EnumValue<AisType> type;

        private int dimensionBow;

        private int dimensionStern;

        private int dimensionPort;

        private int dimensionStarboard;

        private String callsign;

        private String name;

        private int tslc;

        private EnumValue<AisFlags> flags;

        /**
         * Mobile Marine Service Identifier, 9 decimal digits 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Mobile Marine Service Identifier, 9 decimal digits"
        )
        public final Builder mmsi(long mmsi) {
            this.mmsi = mmsi;
            return this;
        }

        /**
         * Latitude 
         */
        @MavlinkFieldInfo(
                position = 3,
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
                position = 4,
                unitSize = 4,
                signed = true,
                description = "Longitude"
        )
        public final Builder lon(int lon) {
            this.lon = lon;
            return this;
        }

        /**
         * Course over ground 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 2,
                description = "Course over ground"
        )
        public final Builder cog(int cog) {
            this.cog = cog;
            return this;
        }

        /**
         * True heading 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2,
                description = "True heading"
        )
        public final Builder heading(int heading) {
            this.heading = heading;
            return this;
        }

        /**
         * Speed over ground 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                description = "Speed over ground"
        )
        public final Builder velocity(int velocity) {
            this.velocity = velocity;
            return this;
        }

        /**
         * Turn rate 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 1,
                signed = true,
                description = "Turn rate"
        )
        public final Builder turnRate(int turnRate) {
            this.turnRate = turnRate;
            return this;
        }

        /**
         * Navigational status 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 1,
                enumType = AisNavStatus.class,
                description = "Navigational status"
        )
        public final Builder navigationalStatus(EnumValue<AisNavStatus> navigationalStatus) {
            this.navigationalStatus = navigationalStatus;
            return this;
        }

        /**
         * Navigational status 
         */
        public final Builder navigationalStatus(AisNavStatus entry) {
            return navigationalStatus(EnumValue.of(entry));
        }

        /**
         * Navigational status 
         */
        public final Builder navigationalStatus(Enum... flags) {
            return navigationalStatus(EnumValue.create(flags));
        }

        /**
         * Navigational status 
         */
        public final Builder navigationalStatus(Collection<Enum> flags) {
            return navigationalStatus(EnumValue.create(flags));
        }

        /**
         * Type of vessels 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 1,
                enumType = AisType.class,
                description = "Type of vessels"
        )
        public final Builder type(EnumValue<AisType> type) {
            this.type = type;
            return this;
        }

        /**
         * Type of vessels 
         */
        public final Builder type(AisType entry) {
            return type(EnumValue.of(entry));
        }

        /**
         * Type of vessels 
         */
        public final Builder type(Enum... flags) {
            return type(EnumValue.create(flags));
        }

        /**
         * Type of vessels 
         */
        public final Builder type(Collection<Enum> flags) {
            return type(EnumValue.create(flags));
        }

        /**
         * Distance from lat/lon location to bow 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 2,
                description = "Distance from lat/lon location to bow"
        )
        public final Builder dimensionBow(int dimensionBow) {
            this.dimensionBow = dimensionBow;
            return this;
        }

        /**
         * Distance from lat/lon location to stern 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 2,
                description = "Distance from lat/lon location to stern"
        )
        public final Builder dimensionStern(int dimensionStern) {
            this.dimensionStern = dimensionStern;
            return this;
        }

        /**
         * Distance from lat/lon location to port side 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 1,
                description = "Distance from lat/lon location to port side"
        )
        public final Builder dimensionPort(int dimensionPort) {
            this.dimensionPort = dimensionPort;
            return this;
        }

        /**
         * Distance from lat/lon location to starboard side 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 1,
                description = "Distance from lat/lon location to starboard side"
        )
        public final Builder dimensionStarboard(int dimensionStarboard) {
            this.dimensionStarboard = dimensionStarboard;
            return this;
        }

        /**
         * The vessel callsign 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 1,
                arraySize = 7,
                description = "The vessel callsign"
        )
        public final Builder callsign(String callsign) {
            this.callsign = callsign;
            return this;
        }

        /**
         * The vessel name 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 1,
                arraySize = 20,
                description = "The vessel name"
        )
        public final Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Time since last communication in seconds 
         */
        @MavlinkFieldInfo(
                position = 17,
                unitSize = 2,
                description = "Time since last communication in seconds"
        )
        public final Builder tslc(int tslc) {
            this.tslc = tslc;
            return this;
        }

        /**
         * Bitmask to indicate various statuses including valid data fields 
         */
        @MavlinkFieldInfo(
                position = 18,
                unitSize = 2,
                enumType = AisFlags.class,
                description = "Bitmask to indicate various statuses including valid data fields"
        )
        public final Builder flags(EnumValue<AisFlags> flags) {
            this.flags = flags;
            return this;
        }

        /**
         * Bitmask to indicate various statuses including valid data fields 
         */
        public final Builder flags(AisFlags entry) {
            return flags(EnumValue.of(entry));
        }

        /**
         * Bitmask to indicate various statuses including valid data fields 
         */
        public final Builder flags(Enum... flags) {
            return flags(EnumValue.create(flags));
        }

        /**
         * Bitmask to indicate various statuses including valid data fields 
         */
        public final Builder flags(Collection<Enum> flags) {
            return flags(EnumValue.create(flags));
        }

        public final AisVessel build() {
            return new AisVessel(mmsi, lat, lon, cog, heading, velocity, turnRate, navigationalStatus, type, dimensionBow, dimensionStern, dimensionPort, dimensionStarboard, callsign, name, tslc, flags);
        }
    }
}
