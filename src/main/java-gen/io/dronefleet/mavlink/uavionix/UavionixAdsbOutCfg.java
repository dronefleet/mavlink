package io.dronefleet.mavlink.uavionix;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.common.AdsbEmitterType;
import io.dronefleet.mavlink.util.EnumFlagSet;
import java.lang.String;

/**
 * Static data to configure the ADS-B transponder (send within 10 sec of a POR and every 10 sec 
 * thereafter) 
 */
@MavlinkMessageInfo(
        id = 10001,
        crc = 209
)
public final class UavionixAdsbOutCfg {
    private final long icao;

    private final String callsign;

    private final AdsbEmitterType emittertype;

    private final UavionixAdsbOutCfgAircraftSize aircraftsize;

    private final UavionixAdsbOutCfgGpsOffsetLat gpsoffsetlat;

    private final UavionixAdsbOutCfgGpsOffsetLon gpsoffsetlon;

    private final int stallspeed;

    private final EnumFlagSet<UavionixAdsbOutRfSelect> rfselect;

    private UavionixAdsbOutCfg(long icao, String callsign, AdsbEmitterType emittertype,
            UavionixAdsbOutCfgAircraftSize aircraftsize,
            UavionixAdsbOutCfgGpsOffsetLat gpsoffsetlat,
            UavionixAdsbOutCfgGpsOffsetLon gpsoffsetlon, int stallspeed,
            EnumFlagSet<UavionixAdsbOutRfSelect> rfselect) {
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
            unitSize = 4
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
            arraySize = 9
    )
    public final String callsign() {
        return this.callsign;
    }

    /**
     * Transmitting vehicle type. See {@link io.dronefleet.mavlink.common.AdsbEmitterType ADSB_EMITTER_TYPE} enum 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final AdsbEmitterType emittertype() {
        return this.emittertype;
    }

    /**
     * Aircraft length and width encoding (table 2-35 of DO-282B) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final UavionixAdsbOutCfgAircraftSize aircraftsize() {
        return this.aircraftsize;
    }

    /**
     * GPS antenna lateral offset (table 2-36 of DO-282B) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final UavionixAdsbOutCfgGpsOffsetLat gpsoffsetlat() {
        return this.gpsoffsetlat;
    }

    /**
     * GPS antenna longitudinal offset from nose [if non-zero, take position (in meters) divide by 2 
     * and add one] (table 2-37 DO-282B) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1
    )
    public final UavionixAdsbOutCfgGpsOffsetLon gpsoffsetlon() {
        return this.gpsoffsetlon;
    }

    /**
     * Aircraft stall speed in cm/s 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 2
    )
    public final int stallspeed() {
        return this.stallspeed;
    }

    /**
     * ADS-B transponder reciever and transmit enable flags 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1
    )
    public final EnumFlagSet<UavionixAdsbOutRfSelect> rfselect() {
        return this.rfselect;
    }

    public static final class Builder {
        private long icao;

        private String callsign;

        private AdsbEmitterType emittertype;

        private UavionixAdsbOutCfgAircraftSize aircraftsize;

        private UavionixAdsbOutCfgGpsOffsetLat gpsoffsetlat;

        private UavionixAdsbOutCfgGpsOffsetLon gpsoffsetlon;

        private int stallspeed;

        private EnumFlagSet<UavionixAdsbOutRfSelect> rfselect;

        /**
         * Vehicle address (24 bit) 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 4
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
                arraySize = 9
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
                unitSize = 1
        )
        public final Builder emittertype(AdsbEmitterType emittertype) {
            this.emittertype = emittertype;
            return this;
        }

        /**
         * Aircraft length and width encoding (table 2-35 of DO-282B) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1
        )
        public final Builder aircraftsize(UavionixAdsbOutCfgAircraftSize aircraftsize) {
            this.aircraftsize = aircraftsize;
            return this;
        }

        /**
         * GPS antenna lateral offset (table 2-36 of DO-282B) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1
        )
        public final Builder gpsoffsetlat(UavionixAdsbOutCfgGpsOffsetLat gpsoffsetlat) {
            this.gpsoffsetlat = gpsoffsetlat;
            return this;
        }

        /**
         * GPS antenna longitudinal offset from nose [if non-zero, take position (in meters) divide by 2 
         * and add one] (table 2-37 DO-282B) 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1
        )
        public final Builder gpsoffsetlon(UavionixAdsbOutCfgGpsOffsetLon gpsoffsetlon) {
            this.gpsoffsetlon = gpsoffsetlon;
            return this;
        }

        /**
         * Aircraft stall speed in cm/s 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 2
        )
        public final Builder stallspeed(int stallspeed) {
            this.stallspeed = stallspeed;
            return this;
        }

        /**
         * ADS-B transponder reciever and transmit enable flags 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 1
        )
        public final Builder rfselect(EnumFlagSet<UavionixAdsbOutRfSelect> rfselect) {
            this.rfselect = rfselect;
            return this;
        }

        public final UavionixAdsbOutCfg build() {
            return new UavionixAdsbOutCfg(icao, callsign, emittertype, aircraftsize, gpsoffsetlat, gpsoffsetlon, stallspeed, rfselect);
        }
    }
}
