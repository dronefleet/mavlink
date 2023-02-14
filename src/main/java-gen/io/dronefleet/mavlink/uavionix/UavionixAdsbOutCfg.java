package io.dronefleet.mavlink.uavionix;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.common.AdsbEmitterType;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * Static data to configure the ADS-B transponder (send within 10 sec of a POR and every 10 sec 
 * thereafter) 
 */
@MavlinkMessageInfo(
        id = 10001,
        crc = 209,
        description = "Static data to configure the ADS-B transponder (send within 10 sec of a POR and every 10 sec thereafter)"
)
public final class UavionixAdsbOutCfg {
    private final long icao;

    private final String callsign;

    private final EnumValue<AdsbEmitterType> emittertype;

    private final EnumValue<UavionixAdsbOutCfgAircraftSize> aircraftsize;

    private final EnumValue<UavionixAdsbOutCfgGpsOffsetLat> gpsoffsetlat;

    private final EnumValue<UavionixAdsbOutCfgGpsOffsetLon> gpsoffsetlon;

    private final int stallspeed;

    private final EnumValue<UavionixAdsbOutRfSelect> rfselect;

    private UavionixAdsbOutCfg(long icao, String callsign, EnumValue<AdsbEmitterType> emittertype,
            EnumValue<UavionixAdsbOutCfgAircraftSize> aircraftsize,
            EnumValue<UavionixAdsbOutCfgGpsOffsetLat> gpsoffsetlat,
            EnumValue<UavionixAdsbOutCfgGpsOffsetLon> gpsoffsetlon, int stallspeed,
            EnumValue<UavionixAdsbOutRfSelect> rfselect) {
        this.icao = icao;
        this.callsign = callsign;
        this.emittertype = emittertype;
        this.aircraftsize = aircraftsize;
        this.gpsoffsetlat = gpsoffsetlat;
        this.gpsoffsetlon = gpsoffsetlon;
        this.stallspeed = stallspeed;
        this.rfselect = rfselect;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Vehicle address (24 bit) 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 4,
            description = "Vehicle address (24 bit)"
    )
    public final long icao() {
        return this.icao;
    }

    /**
     * Vehicle identifier (8 characters, null terminated, valid characters are A-Z, 0-9, " " only) 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            arraySize = 9,
            description = "Vehicle identifier (8 characters, null terminated, valid characters are A-Z, 0-9, \" \" only)"
    )
    public final String callsign() {
        return this.callsign;
    }

    /**
     * Transmitting vehicle type. See {@link io.dronefleet.mavlink.common.AdsbEmitterType ADSB_EMITTER_TYPE} enum 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            enumType = AdsbEmitterType.class,
            description = "Transmitting vehicle type. See ADSB_EMITTER_TYPE enum"
    )
    public final EnumValue<AdsbEmitterType> emittertype() {
        return this.emittertype;
    }

    /**
     * Aircraft length and width encoding (table 2-35 of DO-282B) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            enumType = UavionixAdsbOutCfgAircraftSize.class,
            description = "Aircraft length and width encoding (table 2-35 of DO-282B)"
    )
    public final EnumValue<UavionixAdsbOutCfgAircraftSize> aircraftsize() {
        return this.aircraftsize;
    }

    /**
     * GPS antenna lateral offset (table 2-36 of DO-282B) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            enumType = UavionixAdsbOutCfgGpsOffsetLat.class,
            description = "GPS antenna lateral offset (table 2-36 of DO-282B)"
    )
    public final EnumValue<UavionixAdsbOutCfgGpsOffsetLat> gpsoffsetlat() {
        return this.gpsoffsetlat;
    }

    /**
     * GPS antenna longitudinal offset from nose [if non-zero, take position (in meters) divide by 2 
     * and add one] (table 2-37 DO-282B) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            enumType = UavionixAdsbOutCfgGpsOffsetLon.class,
            description = "GPS antenna longitudinal offset from nose [if non-zero, take position (in meters) divide by 2 and add one] (table 2-37 DO-282B)"
    )
    public final EnumValue<UavionixAdsbOutCfgGpsOffsetLon> gpsoffsetlon() {
        return this.gpsoffsetlon;
    }

    /**
     * Aircraft stall speed in cm/s 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2,
            description = "Aircraft stall speed in cm/s"
    )
    public final int stallspeed() {
        return this.stallspeed;
    }

    /**
     * ADS-B transponder receiver and transmit enable flags 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1,
            enumType = UavionixAdsbOutRfSelect.class,
            description = "ADS-B transponder receiver and transmit enable flags"
    )
    public final EnumValue<UavionixAdsbOutRfSelect> rfselect() {
        return this.rfselect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        UavionixAdsbOutCfg other = (UavionixAdsbOutCfg)o;
        if (!Objects.deepEquals(icao, other.icao)) return false;
        if (!Objects.deepEquals(callsign, other.callsign)) return false;
        if (!Objects.deepEquals(emittertype, other.emittertype)) return false;
        if (!Objects.deepEquals(aircraftsize, other.aircraftsize)) return false;
        if (!Objects.deepEquals(gpsoffsetlat, other.gpsoffsetlat)) return false;
        if (!Objects.deepEquals(gpsoffsetlon, other.gpsoffsetlon)) return false;
        if (!Objects.deepEquals(stallspeed, other.stallspeed)) return false;
        if (!Objects.deepEquals(rfselect, other.rfselect)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(icao);
        result = 31 * result + Objects.hashCode(callsign);
        result = 31 * result + Objects.hashCode(emittertype);
        result = 31 * result + Objects.hashCode(aircraftsize);
        result = 31 * result + Objects.hashCode(gpsoffsetlat);
        result = 31 * result + Objects.hashCode(gpsoffsetlon);
        result = 31 * result + Objects.hashCode(stallspeed);
        result = 31 * result + Objects.hashCode(rfselect);
        return result;
    }

    @Override
    public String toString() {
        return "UavionixAdsbOutCfg{icao=" + icao
                 + ", callsign=" + callsign
                 + ", emittertype=" + emittertype
                 + ", aircraftsize=" + aircraftsize
                 + ", gpsoffsetlat=" + gpsoffsetlat
                 + ", gpsoffsetlon=" + gpsoffsetlon
                 + ", stallspeed=" + stallspeed
                 + ", rfselect=" + rfselect + "}";
    }

    public static final class Builder {
        private long icao;

        private String callsign;

        private EnumValue<AdsbEmitterType> emittertype;

        private EnumValue<UavionixAdsbOutCfgAircraftSize> aircraftsize;

        private EnumValue<UavionixAdsbOutCfgGpsOffsetLat> gpsoffsetlat;

        private EnumValue<UavionixAdsbOutCfgGpsOffsetLon> gpsoffsetlon;

        private int stallspeed;

        private EnumValue<UavionixAdsbOutRfSelect> rfselect;

        /**
         * Vehicle address (24 bit) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4,
                description = "Vehicle address (24 bit)"
        )
        public final Builder icao(long icao) {
            this.icao = icao;
            return this;
        }

        /**
         * Vehicle identifier (8 characters, null terminated, valid characters are A-Z, 0-9, " " only) 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                arraySize = 9,
                description = "Vehicle identifier (8 characters, null terminated, valid characters are A-Z, 0-9, \" \" only)"
        )
        public final Builder callsign(String callsign) {
            this.callsign = callsign;
            return this;
        }

        /**
         * Transmitting vehicle type. See {@link io.dronefleet.mavlink.common.AdsbEmitterType ADSB_EMITTER_TYPE} enum 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                enumType = AdsbEmitterType.class,
                description = "Transmitting vehicle type. See ADSB_EMITTER_TYPE enum"
        )
        public final Builder emittertype(EnumValue<AdsbEmitterType> emittertype) {
            this.emittertype = emittertype;
            return this;
        }

        /**
         * Transmitting vehicle type. See {@link io.dronefleet.mavlink.common.AdsbEmitterType ADSB_EMITTER_TYPE} enum 
         */
        public final Builder emittertype(AdsbEmitterType entry) {
            return emittertype(EnumValue.of(entry));
        }

        /**
         * Transmitting vehicle type. See {@link io.dronefleet.mavlink.common.AdsbEmitterType ADSB_EMITTER_TYPE} enum 
         */
        public final Builder emittertype(Enum... flags) {
            return emittertype(EnumValue.create(flags));
        }

        /**
         * Transmitting vehicle type. See {@link io.dronefleet.mavlink.common.AdsbEmitterType ADSB_EMITTER_TYPE} enum 
         */
        public final Builder emittertype(Collection<Enum> flags) {
            return emittertype(EnumValue.create(flags));
        }

        /**
         * Aircraft length and width encoding (table 2-35 of DO-282B) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                enumType = UavionixAdsbOutCfgAircraftSize.class,
                description = "Aircraft length and width encoding (table 2-35 of DO-282B)"
        )
        public final Builder aircraftsize(EnumValue<UavionixAdsbOutCfgAircraftSize> aircraftsize) {
            this.aircraftsize = aircraftsize;
            return this;
        }

        /**
         * Aircraft length and width encoding (table 2-35 of DO-282B) 
         */
        public final Builder aircraftsize(UavionixAdsbOutCfgAircraftSize entry) {
            return aircraftsize(EnumValue.of(entry));
        }

        /**
         * Aircraft length and width encoding (table 2-35 of DO-282B) 
         */
        public final Builder aircraftsize(Enum... flags) {
            return aircraftsize(EnumValue.create(flags));
        }

        /**
         * Aircraft length and width encoding (table 2-35 of DO-282B) 
         */
        public final Builder aircraftsize(Collection<Enum> flags) {
            return aircraftsize(EnumValue.create(flags));
        }

        /**
         * GPS antenna lateral offset (table 2-36 of DO-282B) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                enumType = UavionixAdsbOutCfgGpsOffsetLat.class,
                description = "GPS antenna lateral offset (table 2-36 of DO-282B)"
        )
        public final Builder gpsoffsetlat(EnumValue<UavionixAdsbOutCfgGpsOffsetLat> gpsoffsetlat) {
            this.gpsoffsetlat = gpsoffsetlat;
            return this;
        }

        /**
         * GPS antenna lateral offset (table 2-36 of DO-282B) 
         */
        public final Builder gpsoffsetlat(UavionixAdsbOutCfgGpsOffsetLat entry) {
            return gpsoffsetlat(EnumValue.of(entry));
        }

        /**
         * GPS antenna lateral offset (table 2-36 of DO-282B) 
         */
        public final Builder gpsoffsetlat(Enum... flags) {
            return gpsoffsetlat(EnumValue.create(flags));
        }

        /**
         * GPS antenna lateral offset (table 2-36 of DO-282B) 
         */
        public final Builder gpsoffsetlat(Collection<Enum> flags) {
            return gpsoffsetlat(EnumValue.create(flags));
        }

        /**
         * GPS antenna longitudinal offset from nose [if non-zero, take position (in meters) divide by 2 
         * and add one] (table 2-37 DO-282B) 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                enumType = UavionixAdsbOutCfgGpsOffsetLon.class,
                description = "GPS antenna longitudinal offset from nose [if non-zero, take position (in meters) divide by 2 and add one] (table 2-37 DO-282B)"
        )
        public final Builder gpsoffsetlon(EnumValue<UavionixAdsbOutCfgGpsOffsetLon> gpsoffsetlon) {
            this.gpsoffsetlon = gpsoffsetlon;
            return this;
        }

        /**
         * GPS antenna longitudinal offset from nose [if non-zero, take position (in meters) divide by 2 
         * and add one] (table 2-37 DO-282B) 
         */
        public final Builder gpsoffsetlon(UavionixAdsbOutCfgGpsOffsetLon entry) {
            return gpsoffsetlon(EnumValue.of(entry));
        }

        /**
         * GPS antenna longitudinal offset from nose [if non-zero, take position (in meters) divide by 2 
         * and add one] (table 2-37 DO-282B) 
         */
        public final Builder gpsoffsetlon(Enum... flags) {
            return gpsoffsetlon(EnumValue.create(flags));
        }

        /**
         * GPS antenna longitudinal offset from nose [if non-zero, take position (in meters) divide by 2 
         * and add one] (table 2-37 DO-282B) 
         */
        public final Builder gpsoffsetlon(Collection<Enum> flags) {
            return gpsoffsetlon(EnumValue.create(flags));
        }

        /**
         * Aircraft stall speed in cm/s 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2,
                description = "Aircraft stall speed in cm/s"
        )
        public final Builder stallspeed(int stallspeed) {
            this.stallspeed = stallspeed;
            return this;
        }

        /**
         * ADS-B transponder receiver and transmit enable flags 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 1,
                enumType = UavionixAdsbOutRfSelect.class,
                description = "ADS-B transponder receiver and transmit enable flags"
        )
        public final Builder rfselect(EnumValue<UavionixAdsbOutRfSelect> rfselect) {
            this.rfselect = rfselect;
            return this;
        }

        /**
         * ADS-B transponder receiver and transmit enable flags 
         */
        public final Builder rfselect(UavionixAdsbOutRfSelect entry) {
            return rfselect(EnumValue.of(entry));
        }

        /**
         * ADS-B transponder receiver and transmit enable flags 
         */
        public final Builder rfselect(Enum... flags) {
            return rfselect(EnumValue.create(flags));
        }

        /**
         * ADS-B transponder receiver and transmit enable flags 
         */
        public final Builder rfselect(Collection<Enum> flags) {
            return rfselect(EnumValue.create(flags));
        }

        public final UavionixAdsbOutCfg build() {
            return new UavionixAdsbOutCfg(icao, callsign, emittertype, aircraftsize, gpsoffsetlat, gpsoffsetlon, stallspeed, rfselect);
        }
    }
}
