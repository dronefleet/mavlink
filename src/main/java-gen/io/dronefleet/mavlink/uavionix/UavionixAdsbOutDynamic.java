package io.dronefleet.mavlink.uavionix;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import io.dronefleet.mavlink.util.EnumFlagSet;
import java.lang.Override;
import java.lang.String;

/**
 * Dynamic data used to generate ADS-B out transponder data (send at 5Hz) 
 */
@MavlinkMessage(
    id = 10002,
    crc = 186
)
public final class UavionixAdsbOutDynamic {
  /**
   * UTC time in seconds since GPS epoch (Jan 6, 1980). If unknown set to UINT32_MAX 
   */
  private final long utctime;

  /**
   * Latitude WGS84 (deg * 1E7). If unknown set to INT32_MAX 
   */
  private final int gpslat;

  /**
   * Longitude WGS84 (deg * 1E7). If unknown set to INT32_MAX 
   */
  private final int gpslon;

  /**
   * Altitude in mm (m * 1E-3) UP +ve. WGS84 altitude. If unknown set to INT32_MAX 
   */
  private final int gpsalt;

  /**
   * Barometric pressure altitude relative to a standard atmosphere of 1013.2 mBar and NOT bar 
   * corrected altitude (m * 1E-3). (up +ve). If unknown set to INT32_MAX 
   */
  private final int baroaltmsl;

  /**
   * Horizontal accuracy in mm (m * 1E-3). If unknown set to UINT32_MAX 
   */
  private final long accuracyhor;

  /**
   * Vertical accuracy in cm. If unknown set to UINT16_MAX 
   */
  private final int accuracyvert;

  /**
   * Velocity accuracy in mm/s (m * 1E-3). If unknown set to UINT16_MAX 
   */
  private final int accuracyvel;

  /**
   * GPS vertical speed in cm/s. If unknown set to INT16_MAX 
   */
  private final int velvert;

  /**
   * North-South velocity over ground in cm/s North +ve. If unknown set to INT16_MAX 
   */
  private final int velns;

  /**
   * East-West velocity over ground in cm/s East +ve. If unknown set to INT16_MAX 
   */
  private final int velew;

  /**
   * ADS-B transponder dynamic input state flags 
   */
  private final EnumFlagSet<UavionixAdsbOutDynamicState> state;

  /**
   * Mode A code (typically 1200 [0x04B0] for VFR) 
   */
  private final int squawk;

  /**
   * 0-1: no fix, 2: 2D fix, 3: 3D fix, 4: DGPS, 5: RTK 
   */
  private final UavionixAdsbOutDynamicGpsFix gpsfix;

  /**
   * Number of satellites visible. If unknown set to UINT8_MAX 
   */
  private final int numsats;

  /**
   * Emergency status 
   */
  private final UavionixAdsbEmergencyStatus emergencystatus;

  private UavionixAdsbOutDynamic(long utctime, int gpslat, int gpslon, int gpsalt, int baroaltmsl,
      long accuracyhor, int accuracyvert, int accuracyvel, int velvert, int velns, int velew,
      EnumFlagSet<UavionixAdsbOutDynamicState> state, int squawk,
      UavionixAdsbOutDynamicGpsFix gpsfix, int numsats,
      UavionixAdsbEmergencyStatus emergencystatus) {
    this.utctime = utctime;
    this.gpslat = gpslat;
    this.gpslon = gpslon;
    this.gpsalt = gpsalt;
    this.baroaltmsl = baroaltmsl;
    this.accuracyhor = accuracyhor;
    this.accuracyvert = accuracyvert;
    this.accuracyvel = accuracyvel;
    this.velvert = velvert;
    this.velns = velns;
    this.velew = velew;
    this.state = state;
    this.squawk = squawk;
    this.gpsfix = gpsfix;
    this.numsats = numsats;
    this.emergencystatus = emergencystatus;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
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

  /**
   * UTC time in seconds since GPS epoch (Jan 6, 1980). If unknown set to UINT32_MAX 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 4
  )
  public final long utctime() {
    return utctime;
  }

  /**
   * Latitude WGS84 (deg * 1E7). If unknown set to INT32_MAX 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 4
  )
  public final int gpslat() {
    return gpslat;
  }

  /**
   * Longitude WGS84 (deg * 1E7). If unknown set to INT32_MAX 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 4
  )
  public final int gpslon() {
    return gpslon;
  }

  /**
   * Altitude in mm (m * 1E-3) UP +ve. WGS84 altitude. If unknown set to INT32_MAX 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 4
  )
  public final int gpsalt() {
    return gpsalt;
  }

  /**
   * Barometric pressure altitude relative to a standard atmosphere of 1013.2 mBar and NOT bar 
   * corrected altitude (m * 1E-3). (up +ve). If unknown set to INT32_MAX 
   */
  @MavlinkMessageField(
      position = 7,
      unitSize = 4
  )
  public final int baroaltmsl() {
    return baroaltmsl;
  }

  /**
   * Horizontal accuracy in mm (m * 1E-3). If unknown set to UINT32_MAX 
   */
  @MavlinkMessageField(
      position = 8,
      unitSize = 4
  )
  public final long accuracyhor() {
    return accuracyhor;
  }

  /**
   * Vertical accuracy in cm. If unknown set to UINT16_MAX 
   */
  @MavlinkMessageField(
      position = 9,
      unitSize = 2
  )
  public final int accuracyvert() {
    return accuracyvert;
  }

  /**
   * Velocity accuracy in mm/s (m * 1E-3). If unknown set to UINT16_MAX 
   */
  @MavlinkMessageField(
      position = 10,
      unitSize = 2
  )
  public final int accuracyvel() {
    return accuracyvel;
  }

  /**
   * GPS vertical speed in cm/s. If unknown set to INT16_MAX 
   */
  @MavlinkMessageField(
      position = 11,
      unitSize = 2
  )
  public final int velvert() {
    return velvert;
  }

  /**
   * North-South velocity over ground in cm/s North +ve. If unknown set to INT16_MAX 
   */
  @MavlinkMessageField(
      position = 12,
      unitSize = 2
  )
  public final int velns() {
    return velns;
  }

  /**
   * East-West velocity over ground in cm/s East +ve. If unknown set to INT16_MAX 
   */
  @MavlinkMessageField(
      position = 13,
      unitSize = 2
  )
  public final int velew() {
    return velew;
  }

  /**
   * ADS-B transponder dynamic input state flags 
   */
  @MavlinkMessageField(
      position = 15,
      unitSize = 2
  )
  public final EnumFlagSet<UavionixAdsbOutDynamicState> state() {
    return state;
  }

  /**
   * Mode A code (typically 1200 [0x04B0] for VFR) 
   */
  @MavlinkMessageField(
      position = 16,
      unitSize = 2
  )
  public final int squawk() {
    return squawk;
  }

  /**
   * 0-1: no fix, 2: 2D fix, 3: 3D fix, 4: DGPS, 5: RTK 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 1
  )
  public final UavionixAdsbOutDynamicGpsFix gpsfix() {
    return gpsfix;
  }

  /**
   * Number of satellites visible. If unknown set to UINT8_MAX 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 1
  )
  public final int numsats() {
    return numsats;
  }

  /**
   * Emergency status 
   */
  @MavlinkMessageField(
      position = 14,
      unitSize = 1
  )
  public final UavionixAdsbEmergencyStatus emergencystatus() {
    return emergencystatus;
  }

  public static class Builder {
    private long utctime;

    private int gpslat;

    private int gpslon;

    private int gpsalt;

    private int baroaltmsl;

    private long accuracyhor;

    private int accuracyvert;

    private int accuracyvel;

    private int velvert;

    private int velns;

    private int velew;

    private EnumFlagSet<UavionixAdsbOutDynamicState> state;

    private int squawk;

    private UavionixAdsbOutDynamicGpsFix gpsfix;

    private int numsats;

    private UavionixAdsbEmergencyStatus emergencystatus;

    private Builder() {
    }

    /**
     * UTC time in seconds since GPS epoch (Jan 6, 1980). If unknown set to UINT32_MAX 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 4
    )
    public final Builder utctime(long utctime) {
      this.utctime = utctime;
      return this;
    }

    /**
     * Latitude WGS84 (deg * 1E7). If unknown set to INT32_MAX 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 4
    )
    public final Builder gpslat(int gpslat) {
      this.gpslat = gpslat;
      return this;
    }

    /**
     * Longitude WGS84 (deg * 1E7). If unknown set to INT32_MAX 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 4
    )
    public final Builder gpslon(int gpslon) {
      this.gpslon = gpslon;
      return this;
    }

    /**
     * Altitude in mm (m * 1E-3) UP +ve. WGS84 altitude. If unknown set to INT32_MAX 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 4
    )
    public final Builder gpsalt(int gpsalt) {
      this.gpsalt = gpsalt;
      return this;
    }

    /**
     * Barometric pressure altitude relative to a standard atmosphere of 1013.2 mBar and NOT bar 
     * corrected altitude (m * 1E-3). (up +ve). If unknown set to INT32_MAX 
     */
    @MavlinkMessageField(
        position = 7,
        unitSize = 4
    )
    public final Builder baroaltmsl(int baroaltmsl) {
      this.baroaltmsl = baroaltmsl;
      return this;
    }

    /**
     * Horizontal accuracy in mm (m * 1E-3). If unknown set to UINT32_MAX 
     */
    @MavlinkMessageField(
        position = 8,
        unitSize = 4
    )
    public final Builder accuracyhor(long accuracyhor) {
      this.accuracyhor = accuracyhor;
      return this;
    }

    /**
     * Vertical accuracy in cm. If unknown set to UINT16_MAX 
     */
    @MavlinkMessageField(
        position = 9,
        unitSize = 2
    )
    public final Builder accuracyvert(int accuracyvert) {
      this.accuracyvert = accuracyvert;
      return this;
    }

    /**
     * Velocity accuracy in mm/s (m * 1E-3). If unknown set to UINT16_MAX 
     */
    @MavlinkMessageField(
        position = 10,
        unitSize = 2
    )
    public final Builder accuracyvel(int accuracyvel) {
      this.accuracyvel = accuracyvel;
      return this;
    }

    /**
     * GPS vertical speed in cm/s. If unknown set to INT16_MAX 
     */
    @MavlinkMessageField(
        position = 11,
        unitSize = 2
    )
    public final Builder velvert(int velvert) {
      this.velvert = velvert;
      return this;
    }

    /**
     * North-South velocity over ground in cm/s North +ve. If unknown set to INT16_MAX 
     */
    @MavlinkMessageField(
        position = 12,
        unitSize = 2
    )
    public final Builder velns(int velns) {
      this.velns = velns;
      return this;
    }

    /**
     * East-West velocity over ground in cm/s East +ve. If unknown set to INT16_MAX 
     */
    @MavlinkMessageField(
        position = 13,
        unitSize = 2
    )
    public final Builder velew(int velew) {
      this.velew = velew;
      return this;
    }

    /**
     * ADS-B transponder dynamic input state flags 
     */
    @MavlinkMessageField(
        position = 15,
        unitSize = 2
    )
    public final Builder state(EnumFlagSet<UavionixAdsbOutDynamicState> state) {
      this.state = state;
      return this;
    }

    /**
     * Mode A code (typically 1200 [0x04B0] for VFR) 
     */
    @MavlinkMessageField(
        position = 16,
        unitSize = 2
    )
    public final Builder squawk(int squawk) {
      this.squawk = squawk;
      return this;
    }

    /**
     * 0-1: no fix, 2: 2D fix, 3: 3D fix, 4: DGPS, 5: RTK 
     */
    @MavlinkMessageField(
        position = 5,
        unitSize = 1
    )
    public final Builder gpsfix(UavionixAdsbOutDynamicGpsFix gpsfix) {
      this.gpsfix = gpsfix;
      return this;
    }

    /**
     * Number of satellites visible. If unknown set to UINT8_MAX 
     */
    @MavlinkMessageField(
        position = 6,
        unitSize = 1
    )
    public final Builder numsats(int numsats) {
      this.numsats = numsats;
      return this;
    }

    /**
     * Emergency status 
     */
    @MavlinkMessageField(
        position = 14,
        unitSize = 1
    )
    public final Builder emergencystatus(UavionixAdsbEmergencyStatus emergencystatus) {
      this.emergencystatus = emergencystatus;
      return this;
    }

    public final UavionixAdsbOutDynamic build() {
      return new UavionixAdsbOutDynamic(utctime, gpslat, gpslon, gpsalt, baroaltmsl, accuracyhor, accuracyvert, accuracyvel, velvert, velns, velew, state, squawk, gpsfix, numsats, emergencystatus);
    }
  }
}
