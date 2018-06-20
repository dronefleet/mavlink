package io.dronefleet.mavlink.uavionix;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.common.AdsbEmitterType;
import io.dronefleet.mavlink.util.EnumFlagSet;
import java.lang.Override;
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
  /**
   * Vehicle address (24 bit) 
   */
  private final long icao;

  /**
   * Aircraft stall speed in cm/s 
   */
  private final int stallspeed;

  /**
   * Vehicle identifier (8 characters, null terminated, valid characters are A-Z, 0-9, " " only) 
   */
  private final String callsign;

  /**
   * Transmitting vehicle type. See {@link io.dronefleet.mavlink.common.AdsbEmitterType AdsbEmitterType} enum 
   */
  private final AdsbEmitterType emittertype;

  /**
   * Aircraft length and width encoding (table 2-35 of DO-282B) 
   */
  private final UavionixAdsbOutCfgAircraftSize aircraftsize;

  /**
   * GPS antenna lateral offset (table 2-36 of DO-282B) 
   */
  private final UavionixAdsbOutCfgGpsOffsetLat gpsoffsetlat;

  /**
   * GPS antenna longitudinal offset from nose [if non-zero, take position (in meters) divide by 2 
   * and add one] (table 2-37 DO-282B) 
   */
  private final UavionixAdsbOutCfgGpsOffsetLon gpsoffsetlon;

  /**
   * ADS-B transponder reciever and transmit enable flags 
   */
  private final EnumFlagSet<UavionixAdsbOutRfSelect> rfselect;

  private UavionixAdsbOutCfg(long icao, int stallspeed, String callsign,
      AdsbEmitterType emittertype, UavionixAdsbOutCfgAircraftSize aircraftsize,
      UavionixAdsbOutCfgGpsOffsetLat gpsoffsetlat, UavionixAdsbOutCfgGpsOffsetLon gpsoffsetlon,
      EnumFlagSet<UavionixAdsbOutRfSelect> rfselect) {
    this.icao = icao;
    this.stallspeed = stallspeed;
    this.callsign = callsign;
    this.emittertype = emittertype;
    this.aircraftsize = aircraftsize;
    this.gpsoffsetlat = gpsoffsetlat;
    this.gpsoffsetlon = gpsoffsetlon;
    this.rfselect = rfselect;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
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

  /**
   * Vehicle address (24 bit) 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 4
  )
  public final long icao() {
    return icao;
  }

  /**
   * Aircraft stall speed in cm/s 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 2
  )
  public final int stallspeed() {
    return stallspeed;
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
    return callsign;
  }

  /**
   * Transmitting vehicle type. See {@link io.dronefleet.mavlink.common.AdsbEmitterType AdsbEmitterType} enum 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 1
  )
  public final AdsbEmitterType emittertype() {
    return emittertype;
  }

  /**
   * Aircraft length and width encoding (table 2-35 of DO-282B) 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 1
  )
  public final UavionixAdsbOutCfgAircraftSize aircraftsize() {
    return aircraftsize;
  }

  /**
   * GPS antenna lateral offset (table 2-36 of DO-282B) 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 1
  )
  public final UavionixAdsbOutCfgGpsOffsetLat gpsoffsetlat() {
    return gpsoffsetlat;
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
    return gpsoffsetlon;
  }

  /**
   * ADS-B transponder reciever and transmit enable flags 
   */
  @MavlinkFieldInfo(
      position = 8,
      unitSize = 1
  )
  public final EnumFlagSet<UavionixAdsbOutRfSelect> rfselect() {
    return rfselect;
  }

  public static class Builder {
    private long icao;

    private int stallspeed;

    private String callsign;

    private AdsbEmitterType emittertype;

    private UavionixAdsbOutCfgAircraftSize aircraftsize;

    private UavionixAdsbOutCfgGpsOffsetLat gpsoffsetlat;

    private UavionixAdsbOutCfgGpsOffsetLon gpsoffsetlon;

    private EnumFlagSet<UavionixAdsbOutRfSelect> rfselect;

    private Builder() {
    }

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
     * Transmitting vehicle type. See {@link io.dronefleet.mavlink.common.AdsbEmitterType AdsbEmitterType} enum 
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
      return new UavionixAdsbOutCfg(icao, stallspeed, callsign, emittertype, aircraftsize, gpsoffsetlat, gpsoffsetlon, rfselect);
    }
  }
}
