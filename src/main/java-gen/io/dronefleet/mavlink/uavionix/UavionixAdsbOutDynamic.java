package io.dronefleet.mavlink.uavionix;

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
 * Dynamic data used to generate ADS-B out transponder data (send at 5Hz) 
 */
@MavlinkMessageInfo(
        id = 10002,
        crc = 186,
        description = "Dynamic data used to generate ADS-B out transponder data (send at 5Hz)"
)
public final class UavionixAdsbOutDynamic {
    private final long utctime;

    private final int gpslat;

    private final int gpslon;

    private final int gpsalt;

    private final EnumValue<UavionixAdsbOutDynamicGpsFix> gpsfix;

    private final int numsats;

    private final int baroaltmsl;

    private final long accuracyhor;

    private final int accuracyvert;

    private final int accuracyvel;

    private final int velvert;

    private final int velns;

    private final int velew;

    private final EnumValue<UavionixAdsbEmergencyStatus> emergencystatus;

    private final EnumValue<UavionixAdsbOutDynamicState> state;

    private final int squawk;

    private UavionixAdsbOutDynamic(long utctime, int gpslat, int gpslon, int gpsalt,
            EnumValue<UavionixAdsbOutDynamicGpsFix> gpsfix, int numsats, int baroaltmsl,
            long accuracyhor, int accuracyvert, int accuracyvel, int velvert, int velns, int velew,
            EnumValue<UavionixAdsbEmergencyStatus> emergencystatus,
            EnumValue<UavionixAdsbOutDynamicState> state, int squawk) {
        this.utctime = utctime;
        this.gpslat = gpslat;
        this.gpslon = gpslon;
        this.gpsalt = gpsalt;
        this.gpsfix = gpsfix;
        this.numsats = numsats;
        this.baroaltmsl = baroaltmsl;
        this.accuracyhor = accuracyhor;
        this.accuracyvert = accuracyvert;
        this.accuracyvel = accuracyvel;
        this.velvert = velvert;
        this.velns = velns;
        this.velew = velew;
        this.emergencystatus = emergencystatus;
        this.state = state;
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
     * UTC time in seconds since GPS epoch (Jan 6, 1980). If unknown set to UINT32_MAX 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "UTC time in seconds since GPS epoch (Jan 6, 1980). If unknown set to UINT32_MAX"
    )
    public final long utctime() {
        return this.utctime;
    }

    /**
     * Latitude WGS84 (deg * 1E7). If unknown set to INT32_MAX 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            signed = true,
            description = "Latitude WGS84 (deg * 1E7). If unknown set to INT32_MAX"
    )
    public final int gpslat() {
        return this.gpslat;
    }

    /**
     * Longitude WGS84 (deg * 1E7). If unknown set to INT32_MAX 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 4,
            signed = true,
            description = "Longitude WGS84 (deg * 1E7). If unknown set to INT32_MAX"
    )
    public final int gpslon() {
        return this.gpslon;
    }

    /**
     * Altitude in mm (m * 1E-3) UP +ve. WGS84 altitude. If unknown set to INT32_MAX 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            signed = true,
            description = "Altitude in mm (m * 1E-3) UP +ve. WGS84 altitude. If unknown set to INT32_MAX"
    )
    public final int gpsalt() {
        return this.gpsalt;
    }

    /**
     * 0-1: no fix, 2: 2D fix, 3: 3D fix, 4: DGPS, 5: RTK 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            enumType = UavionixAdsbOutDynamicGpsFix.class,
            description = "0-1: no fix, 2: 2D fix, 3: 3D fix, 4: DGPS, 5: RTK"
    )
    public final EnumValue<UavionixAdsbOutDynamicGpsFix> gpsfix() {
        return this.gpsfix;
    }

    /**
     * Number of satellites visible. If unknown set to UINT8_MAX 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            description = "Number of satellites visible. If unknown set to UINT8_MAX"
    )
    public final int numsats() {
        return this.numsats;
    }

    /**
     * Barometric pressure altitude relative to a standard atmosphere of 1013.2 mBar and NOT bar 
     * corrected altitude (m * 1E-3). (up +ve). If unknown set to INT32_MAX 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            signed = true,
            description = "Barometric pressure altitude relative to a standard atmosphere of 1013.2 mBar and NOT bar corrected altitude (m * 1E-3). (up +ve). If unknown set to INT32_MAX"
    )
    public final int baroaltmsl() {
        return this.baroaltmsl;
    }

    /**
     * Horizontal accuracy in mm (m * 1E-3). If unknown set to UINT32_MAX 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 4,
            description = "Horizontal accuracy in mm (m * 1E-3). If unknown set to UINT32_MAX"
    )
    public final long accuracyhor() {
        return this.accuracyhor;
    }

    /**
     * Vertical accuracy in cm. If unknown set to UINT16_MAX 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 2,
            description = "Vertical accuracy in cm. If unknown set to UINT16_MAX"
    )
    public final int accuracyvert() {
        return this.accuracyvert;
    }

    /**
     * Velocity accuracy in mm/s (m * 1E-3). If unknown set to UINT16_MAX 
     */
    @MavlinkFieldInfo(
            position = 10,
            unitSize = 2,
            description = "Velocity accuracy in mm/s (m * 1E-3). If unknown set to UINT16_MAX"
    )
    public final int accuracyvel() {
        return this.accuracyvel;
    }

    /**
     * GPS vertical speed in cm/s. If unknown set to INT16_MAX 
     */
    @MavlinkFieldInfo(
            position = 11,
            unitSize = 2,
            signed = true,
            description = "GPS vertical speed in cm/s. If unknown set to INT16_MAX"
    )
    public final int velvert() {
        return this.velvert;
    }

    /**
     * North-South velocity over ground in cm/s North +ve. If unknown set to INT16_MAX 
     */
    @MavlinkFieldInfo(
            position = 12,
            unitSize = 2,
            signed = true,
            description = "North-South velocity over ground in cm/s North +ve. If unknown set to INT16_MAX"
    )
    public final int velns() {
        return this.velns;
    }

    /**
     * East-West velocity over ground in cm/s East +ve. If unknown set to INT16_MAX 
     */
    @MavlinkFieldInfo(
            position = 13,
            unitSize = 2,
            signed = true,
            description = "East-West velocity over ground in cm/s East +ve. If unknown set to INT16_MAX"
    )
    public final int velew() {
        return this.velew;
    }

    /**
     * Emergency status 
     */
    @MavlinkFieldInfo(
            position = 14,
            unitSize = 1,
            enumType = UavionixAdsbEmergencyStatus.class,
            description = "Emergency status"
    )
    public final EnumValue<UavionixAdsbEmergencyStatus> emergencystatus() {
        return this.emergencystatus;
    }

    /**
     * ADS-B transponder dynamic input state flags 
     */
    @MavlinkFieldInfo(
            position = 15,
            unitSize = 2,
            enumType = UavionixAdsbOutDynamicState.class,
            description = "ADS-B transponder dynamic input state flags"
    )
    public final EnumValue<UavionixAdsbOutDynamicState> state() {
        return this.state;
    }

    /**
     * Mode A code (typically 1200 [0x04B0] for VFR) 
     */
    @MavlinkFieldInfo(
            position = 16,
            unitSize = 2,
            description = "Mode A code (typically 1200 [0x04B0] for VFR)"
    )
    public final int squawk() {
        return this.squawk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        UavionixAdsbOutDynamic other = (UavionixAdsbOutDynamic)o;
        if (!Objects.deepEquals(utctime, other.utctime)) return false;
        if (!Objects.deepEquals(gpslat, other.gpslat)) return false;
        if (!Objects.deepEquals(gpslon, other.gpslon)) return false;
        if (!Objects.deepEquals(gpsalt, other.gpsalt)) return false;
        if (!Objects.deepEquals(gpsfix, other.gpsfix)) return false;
        if (!Objects.deepEquals(numsats, other.numsats)) return false;
        if (!Objects.deepEquals(baroaltmsl, other.baroaltmsl)) return false;
        if (!Objects.deepEquals(accuracyhor, other.accuracyhor)) return false;
        if (!Objects.deepEquals(accuracyvert, other.accuracyvert)) return false;
        if (!Objects.deepEquals(accuracyvel, other.accuracyvel)) return false;
        if (!Objects.deepEquals(velvert, other.velvert)) return false;
        if (!Objects.deepEquals(velns, other.velns)) return false;
        if (!Objects.deepEquals(velew, other.velew)) return false;
        if (!Objects.deepEquals(emergencystatus, other.emergencystatus)) return false;
        if (!Objects.deepEquals(state, other.state)) return false;
        if (!Objects.deepEquals(squawk, other.squawk)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(utctime);
        result = 31 * result + Objects.hashCode(gpslat);
        result = 31 * result + Objects.hashCode(gpslon);
        result = 31 * result + Objects.hashCode(gpsalt);
        result = 31 * result + Objects.hashCode(gpsfix);
        result = 31 * result + Objects.hashCode(numsats);
        result = 31 * result + Objects.hashCode(baroaltmsl);
        result = 31 * result + Objects.hashCode(accuracyhor);
        result = 31 * result + Objects.hashCode(accuracyvert);
        result = 31 * result + Objects.hashCode(accuracyvel);
        result = 31 * result + Objects.hashCode(velvert);
        result = 31 * result + Objects.hashCode(velns);
        result = 31 * result + Objects.hashCode(velew);
        result = 31 * result + Objects.hashCode(emergencystatus);
        result = 31 * result + Objects.hashCode(state);
        result = 31 * result + Objects.hashCode(squawk);
        return result;
    }

    @Override
    public String toString() {
        return "UavionixAdsbOutDynamic{utctime=" + utctime
                 + ", gpslat=" + gpslat
                 + ", gpslon=" + gpslon
                 + ", gpsalt=" + gpsalt
                 + ", gpsfix=" + gpsfix
                 + ", numsats=" + numsats
                 + ", baroaltmsl=" + baroaltmsl
                 + ", accuracyhor=" + accuracyhor
                 + ", accuracyvert=" + accuracyvert
                 + ", accuracyvel=" + accuracyvel
                 + ", velvert=" + velvert
                 + ", velns=" + velns
                 + ", velew=" + velew
                 + ", emergencystatus=" + emergencystatus
                 + ", state=" + state
                 + ", squawk=" + squawk + "}";
    }

    public static final class Builder {
        private long utctime;

        private int gpslat;

        private int gpslon;

        private int gpsalt;

        private EnumValue<UavionixAdsbOutDynamicGpsFix> gpsfix;

        private int numsats;

        private int baroaltmsl;

        private long accuracyhor;

        private int accuracyvert;

        private int accuracyvel;

        private int velvert;

        private int velns;

        private int velew;

        private EnumValue<UavionixAdsbEmergencyStatus> emergencystatus;

        private EnumValue<UavionixAdsbOutDynamicState> state;

        private int squawk;

        /**
         * UTC time in seconds since GPS epoch (Jan 6, 1980). If unknown set to UINT32_MAX 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "UTC time in seconds since GPS epoch (Jan 6, 1980). If unknown set to UINT32_MAX"
        )
        public final Builder utctime(long utctime) {
            this.utctime = utctime;
            return this;
        }

        /**
         * Latitude WGS84 (deg * 1E7). If unknown set to INT32_MAX 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                signed = true,
                description = "Latitude WGS84 (deg * 1E7). If unknown set to INT32_MAX"
        )
        public final Builder gpslat(int gpslat) {
            this.gpslat = gpslat;
            return this;
        }

        /**
         * Longitude WGS84 (deg * 1E7). If unknown set to INT32_MAX 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 4,
                signed = true,
                description = "Longitude WGS84 (deg * 1E7). If unknown set to INT32_MAX"
        )
        public final Builder gpslon(int gpslon) {
            this.gpslon = gpslon;
            return this;
        }

        /**
         * Altitude in mm (m * 1E-3) UP +ve. WGS84 altitude. If unknown set to INT32_MAX 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4,
                signed = true,
                description = "Altitude in mm (m * 1E-3) UP +ve. WGS84 altitude. If unknown set to INT32_MAX"
        )
        public final Builder gpsalt(int gpsalt) {
            this.gpsalt = gpsalt;
            return this;
        }

        /**
         * 0-1: no fix, 2: 2D fix, 3: 3D fix, 4: DGPS, 5: RTK 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                enumType = UavionixAdsbOutDynamicGpsFix.class,
                description = "0-1: no fix, 2: 2D fix, 3: 3D fix, 4: DGPS, 5: RTK"
        )
        public final Builder gpsfix(EnumValue<UavionixAdsbOutDynamicGpsFix> gpsfix) {
            this.gpsfix = gpsfix;
            return this;
        }

        /**
         * 0-1: no fix, 2: 2D fix, 3: 3D fix, 4: DGPS, 5: RTK 
         */
        public final Builder gpsfix(UavionixAdsbOutDynamicGpsFix entry) {
            return gpsfix(EnumValue.of(entry));
        }

        /**
         * 0-1: no fix, 2: 2D fix, 3: 3D fix, 4: DGPS, 5: RTK 
         */
        public final Builder gpsfix(Enum... flags) {
            return gpsfix(EnumValue.create(flags));
        }

        /**
         * 0-1: no fix, 2: 2D fix, 3: 3D fix, 4: DGPS, 5: RTK 
         */
        public final Builder gpsfix(Collection<Enum> flags) {
            return gpsfix(EnumValue.create(flags));
        }

        /**
         * Number of satellites visible. If unknown set to UINT8_MAX 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                description = "Number of satellites visible. If unknown set to UINT8_MAX"
        )
        public final Builder numsats(int numsats) {
            this.numsats = numsats;
            return this;
        }

        /**
         * Barometric pressure altitude relative to a standard atmosphere of 1013.2 mBar and NOT bar 
         * corrected altitude (m * 1E-3). (up +ve). If unknown set to INT32_MAX 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                signed = true,
                description = "Barometric pressure altitude relative to a standard atmosphere of 1013.2 mBar and NOT bar corrected altitude (m * 1E-3). (up +ve). If unknown set to INT32_MAX"
        )
        public final Builder baroaltmsl(int baroaltmsl) {
            this.baroaltmsl = baroaltmsl;
            return this;
        }

        /**
         * Horizontal accuracy in mm (m * 1E-3). If unknown set to UINT32_MAX 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 4,
                description = "Horizontal accuracy in mm (m * 1E-3). If unknown set to UINT32_MAX"
        )
        public final Builder accuracyhor(long accuracyhor) {
            this.accuracyhor = accuracyhor;
            return this;
        }

        /**
         * Vertical accuracy in cm. If unknown set to UINT16_MAX 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 2,
                description = "Vertical accuracy in cm. If unknown set to UINT16_MAX"
        )
        public final Builder accuracyvert(int accuracyvert) {
            this.accuracyvert = accuracyvert;
            return this;
        }

        /**
         * Velocity accuracy in mm/s (m * 1E-3). If unknown set to UINT16_MAX 
         */
        @MavlinkFieldInfo(
                position = 10,
                unitSize = 2,
                description = "Velocity accuracy in mm/s (m * 1E-3). If unknown set to UINT16_MAX"
        )
        public final Builder accuracyvel(int accuracyvel) {
            this.accuracyvel = accuracyvel;
            return this;
        }

        /**
         * GPS vertical speed in cm/s. If unknown set to INT16_MAX 
         */
        @MavlinkFieldInfo(
                position = 11,
                unitSize = 2,
                signed = true,
                description = "GPS vertical speed in cm/s. If unknown set to INT16_MAX"
        )
        public final Builder velvert(int velvert) {
            this.velvert = velvert;
            return this;
        }

        /**
         * North-South velocity over ground in cm/s North +ve. If unknown set to INT16_MAX 
         */
        @MavlinkFieldInfo(
                position = 12,
                unitSize = 2,
                signed = true,
                description = "North-South velocity over ground in cm/s North +ve. If unknown set to INT16_MAX"
        )
        public final Builder velns(int velns) {
            this.velns = velns;
            return this;
        }

        /**
         * East-West velocity over ground in cm/s East +ve. If unknown set to INT16_MAX 
         */
        @MavlinkFieldInfo(
                position = 13,
                unitSize = 2,
                signed = true,
                description = "East-West velocity over ground in cm/s East +ve. If unknown set to INT16_MAX"
        )
        public final Builder velew(int velew) {
            this.velew = velew;
            return this;
        }

        /**
         * Emergency status 
         */
        @MavlinkFieldInfo(
                position = 14,
                unitSize = 1,
                enumType = UavionixAdsbEmergencyStatus.class,
                description = "Emergency status"
        )
        public final Builder emergencystatus(
                EnumValue<UavionixAdsbEmergencyStatus> emergencystatus) {
            this.emergencystatus = emergencystatus;
            return this;
        }

        /**
         * Emergency status 
         */
        public final Builder emergencystatus(UavionixAdsbEmergencyStatus entry) {
            return emergencystatus(EnumValue.of(entry));
        }

        /**
         * Emergency status 
         */
        public final Builder emergencystatus(Enum... flags) {
            return emergencystatus(EnumValue.create(flags));
        }

        /**
         * Emergency status 
         */
        public final Builder emergencystatus(Collection<Enum> flags) {
            return emergencystatus(EnumValue.create(flags));
        }

        /**
         * ADS-B transponder dynamic input state flags 
         */
        @MavlinkFieldInfo(
                position = 15,
                unitSize = 2,
                enumType = UavionixAdsbOutDynamicState.class,
                description = "ADS-B transponder dynamic input state flags"
        )
        public final Builder state(EnumValue<UavionixAdsbOutDynamicState> state) {
            this.state = state;
            return this;
        }

        /**
         * ADS-B transponder dynamic input state flags 
         */
        public final Builder state(UavionixAdsbOutDynamicState entry) {
            return state(EnumValue.of(entry));
        }

        /**
         * ADS-B transponder dynamic input state flags 
         */
        public final Builder state(Enum... flags) {
            return state(EnumValue.create(flags));
        }

        /**
         * ADS-B transponder dynamic input state flags 
         */
        public final Builder state(Collection<Enum> flags) {
            return state(EnumValue.create(flags));
        }

        /**
         * Mode A code (typically 1200 [0x04B0] for VFR) 
         */
        @MavlinkFieldInfo(
                position = 16,
                unitSize = 2,
                description = "Mode A code (typically 1200 [0x04B0] for VFR)"
        )
        public final Builder squawk(int squawk) {
            this.squawk = squawk;
            return this;
        }

        public final UavionixAdsbOutDynamic build() {
            return new UavionixAdsbOutDynamic(utctime, gpslat, gpslon, gpsalt, gpsfix, numsats, baroaltmsl, accuracyhor, accuracyvert, accuracyvel, velvert, velns, velew, emergencystatus, state, squawk);
        }
    }
}
