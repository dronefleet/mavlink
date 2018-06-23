package io.dronefleet.mavlink.uavionix;

import com.benbarkay.events.EventEmitter;
import com.benbarkay.events.EventSource;
import io.dronefleet.mavlink.common.AdsbEmitterType;
import io.dronefleet.mavlink.common.CommonVehicle;
import io.dronefleet.mavlink.util.EnumFlagSet;
import io.dronefleet.mavlink.vehicle.AbstractMavlinkVehicle;
import java.lang.Object;
import java.lang.String;

public interface UavionixVehicle extends CommonVehicle {
    /**
     * Transceiver heartbeat with health report (updated every 10s) 
     * @param rfhealth ADS-B transponder messages 
     */
    default void sendUavionixAdsbTransceiverHealthReport(
            EnumFlagSet<UavionixAdsbRfHealth> rfhealth) {
        outgoing().emit(UavionixAdsbTransceiverHealthReport.builder()
                .rfhealth(rfhealth)
                .build());
    }

    /**
     * Dynamic data used to generate ADS-B out transponder data (send at 5Hz) 
     * @param utctime UTC time in seconds since GPS epoch (Jan 6, 1980). If unknown set to UINT32_MAX 
     * @param gpslat Latitude WGS84 (deg * 1E7). If unknown set to INT32_MAX 
     * @param gpslon Longitude WGS84 (deg * 1E7). If unknown set to INT32_MAX 
     * @param gpsalt Altitude in mm (m * 1E-3) UP +ve. WGS84 altitude. If unknown set to INT32_MAX 
     * @param baroaltmsl Barometric pressure altitude relative to a standard atmosphere of 1013.2 mBar and NOT bar 
     * corrected altitude (m * 1E-3). (up +ve). If unknown set to INT32_MAX 
     * @param accuracyhor Horizontal accuracy in mm (m * 1E-3). If unknown set to UINT32_MAX 
     * @param accuracyvert Vertical accuracy in cm. If unknown set to UINT16_MAX 
     * @param accuracyvel Velocity accuracy in mm/s (m * 1E-3). If unknown set to UINT16_MAX 
     * @param velvert GPS vertical speed in cm/s. If unknown set to INT16_MAX 
     * @param velns North-South velocity over ground in cm/s North +ve. If unknown set to INT16_MAX 
     * @param velew East-West velocity over ground in cm/s East +ve. If unknown set to INT16_MAX 
     * @param state ADS-B transponder dynamic input state flags 
     * @param squawk Mode A code (typically 1200 [0x04B0] for VFR) 
     * @param gpsfix 0-1: no fix, 2: 2D fix, 3: 3D fix, 4: DGPS, 5: RTK 
     * @param numsats Number of satellites visible. If unknown set to UINT8_MAX 
     * @param emergencystatus Emergency status 
     */
    default void sendUavionixAdsbOutDynamic(long utctime, int gpslat, int gpslon, int gpsalt,
            int baroaltmsl, long accuracyhor, int accuracyvert, int accuracyvel, int velvert,
            int velns, int velew, EnumFlagSet<UavionixAdsbOutDynamicState> state, int squawk,
            UavionixAdsbOutDynamicGpsFix gpsfix, int numsats,
            UavionixAdsbEmergencyStatus emergencystatus) {
        outgoing().emit(UavionixAdsbOutDynamic.builder()
                .utctime(utctime)
                .gpslat(gpslat)
                .gpslon(gpslon)
                .gpsalt(gpsalt)
                .baroaltmsl(baroaltmsl)
                .accuracyhor(accuracyhor)
                .accuracyvert(accuracyvert)
                .accuracyvel(accuracyvel)
                .velvert(velvert)
                .velns(velns)
                .velew(velew)
                .state(state)
                .squawk(squawk)
                .gpsfix(gpsfix)
                .numsats(numsats)
                .emergencystatus(emergencystatus)
                .build());
    }

    /**
     * Static data to configure the ADS-B transponder (send within 10 sec of a POR and every 10 sec 
     * thereafter) 
     * @param icao Vehicle address (24 bit) 
     * @param stallspeed Aircraft stall speed in cm/s 
     * @param callsign Vehicle identifier (8 characters, null terminated, valid characters are A-Z, 0-9, " " only) 
     * @param emittertype Transmitting vehicle type. See {@link io.dronefleet.mavlink.common.AdsbEmitterType AdsbEmitterType} enum 
     * @param aircraftsize Aircraft length and width encoding (table 2-35 of DO-282B) 
     * @param gpsoffsetlat GPS antenna lateral offset (table 2-36 of DO-282B) 
     * @param gpsoffsetlon GPS antenna longitudinal offset from nose [if non-zero, take position (in meters) divide by 2 
     * and add one] (table 2-37 DO-282B) 
     * @param rfselect ADS-B transponder reciever and transmit enable flags 
     */
    default void sendUavionixAdsbOutCfg(long icao, int stallspeed, String callsign,
            AdsbEmitterType emittertype, UavionixAdsbOutCfgAircraftSize aircraftsize,
            UavionixAdsbOutCfgGpsOffsetLat gpsoffsetlat,
            UavionixAdsbOutCfgGpsOffsetLon gpsoffsetlon,
            EnumFlagSet<UavionixAdsbOutRfSelect> rfselect) {
        outgoing().emit(UavionixAdsbOutCfg.builder()
                .icao(icao)
                .stallspeed(stallspeed)
                .callsign(callsign)
                .emittertype(emittertype)
                .aircraftsize(aircraftsize)
                .gpsoffsetlat(gpsoffsetlat)
                .gpsoffsetlon(gpsoffsetlon)
                .rfselect(rfselect)
                .build());
    }

    final class Impl extends AbstractMavlinkVehicle implements UavionixVehicle {
        Impl(int systemId, EventSource<Object> incoming, EventEmitter<Object> outgoing) {
            super(systemId, incoming, outgoing);
        }
    }
}
