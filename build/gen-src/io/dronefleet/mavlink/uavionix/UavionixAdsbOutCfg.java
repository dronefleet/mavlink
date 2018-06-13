package io.dronefleet.mavlink.uavionix;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import io.dronefleet.mavlink.common.AdsbEmitterType;
import io.dronefleet.mavlink.util.EnumFlagSet;
import java.lang.Integer;
import java.util.List;

/**
 * Static data to configure the ADS-B transponder (send within 10 sec of a POR and every 10 sec 
 * thereafter) 
 */
@MavlinkMessage(
    id = 10001,
    crc = 209
)
public final class UavionixAdsbOutCfg {
  private final long icao;

  private final List<Integer> callsign;

  private final AdsbEmitterType emittertype;

  private final UavionixAdsbOutCfgAircraftSize aircraftsize;

  private final UavionixAdsbOutCfgGpsOffsetLat gpsoffsetlat;

  private final UavionixAdsbOutCfgGpsOffsetLon gpsoffsetlon;

  private final int stallspeed;

  private final EnumFlagSet<UavionixAdsbOutRfSelect> rfselect;

  private UavionixAdsbOutCfg(long icao, List<Integer> callsign, AdsbEmitterType emittertype,
      UavionixAdsbOutCfgAircraftSize aircraftsize, UavionixAdsbOutCfgGpsOffsetLat gpsoffsetlat,
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

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Vehicle address (24 bit) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final long icao() {
    return icao;
  }

  /**
   * Vehicle identifier (8 characters, null terminated, valid characters are A-Z, 0-9, " " only) 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1,
      arraySize = 9
  )
  public final List<Integer> callsign() {
    return callsign;
  }

  /**
   * Transmitting vehicle type. See ADSB_EMITTER_TYPE enum 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final AdsbEmitterType emittertype() {
    return emittertype;
  }

  /**
   * Aircraft length and width encoding (table 2-35 of DO-282B) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1
  )
  public final UavionixAdsbOutCfgAircraftSize aircraftsize() {
    return aircraftsize;
  }

  /**
   * GPS antenna lateral offset (table 2-36 of DO-282B) 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1
  )
  public final UavionixAdsbOutCfgGpsOffsetLat gpsoffsetlat() {
    return gpsoffsetlat;
  }

  /**
   * GPS antenna longitudinal offset from nose [if non-zero, take position (in meters) divide by 2 
   * and add one] (table 2-37 DO-282B) 
   */
  @MavlinkMessageField(
      position = 6,
      length = 1
  )
  public final UavionixAdsbOutCfgGpsOffsetLon gpsoffsetlon() {
    return gpsoffsetlon;
  }

  /**
   * Aircraft stall speed in cm/s 
   */
  @MavlinkMessageField(
      position = 7,
      length = 2
  )
  public final int stallspeed() {
    return stallspeed;
  }

  /**
   * ADS-B transponder reciever and transmit enable flags 
   */
  @MavlinkMessageField(
      position = 8,
      length = 1
  )
  public final EnumFlagSet<UavionixAdsbOutRfSelect> rfselect() {
    return rfselect;
  }

  public class Builder {
    private long icao;

    private List<Integer> callsign;

    private AdsbEmitterType emittertype;

    private UavionixAdsbOutCfgAircraftSize aircraftsize;

    private UavionixAdsbOutCfgGpsOffsetLat gpsoffsetlat;

    private UavionixAdsbOutCfgGpsOffsetLon gpsoffsetlon;

    private int stallspeed;

    private EnumFlagSet<UavionixAdsbOutRfSelect> rfselect;

    private Builder() {
    }

    /**
     * Vehicle address (24 bit) 
     */
    @MavlinkMessageField(
        position = 1,
        length = 4
    )
    public final Builder icao(long icao) {
      this.icao = icao;
      return this;
    }

    /**
     * Vehicle identifier (8 characters, null terminated, valid characters are A-Z, 0-9, " " only) 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1,
        arraySize = 9
    )
    public final Builder callsign(List<Integer> callsign) {
      this.callsign = callsign;
      return this;
    }

    /**
     * Transmitting vehicle type. See ADSB_EMITTER_TYPE enum 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder emittertype(AdsbEmitterType emittertype) {
      this.emittertype = emittertype;
      return this;
    }

    /**
     * Aircraft length and width encoding (table 2-35 of DO-282B) 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1
    )
    public final Builder aircraftsize(UavionixAdsbOutCfgAircraftSize aircraftsize) {
      this.aircraftsize = aircraftsize;
      return this;
    }

    /**
     * GPS antenna lateral offset (table 2-36 of DO-282B) 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1
    )
    public final Builder gpsoffsetlat(UavionixAdsbOutCfgGpsOffsetLat gpsoffsetlat) {
      this.gpsoffsetlat = gpsoffsetlat;
      return this;
    }

    /**
     * GPS antenna longitudinal offset from nose [if non-zero, take position (in meters) divide by 2 
     * and add one] (table 2-37 DO-282B) 
     */
    @MavlinkMessageField(
        position = 6,
        length = 1
    )
    public final Builder gpsoffsetlon(UavionixAdsbOutCfgGpsOffsetLon gpsoffsetlon) {
      this.gpsoffsetlon = gpsoffsetlon;
      return this;
    }

    /**
     * Aircraft stall speed in cm/s 
     */
    @MavlinkMessageField(
        position = 7,
        length = 2
    )
    public final Builder stallspeed(int stallspeed) {
      this.stallspeed = stallspeed;
      return this;
    }

    /**
     * ADS-B transponder reciever and transmit enable flags 
     */
    @MavlinkMessageField(
        position = 8,
        length = 1
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
