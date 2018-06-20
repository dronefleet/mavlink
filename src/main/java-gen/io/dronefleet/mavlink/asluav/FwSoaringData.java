package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;

/**
 * Fixed-wing soaring (i.e. thermal seeking) data 
 */
@MavlinkMessageInfo(
    id = 210,
    crc = 20
)
public final class FwSoaringData {
  /**
   * Timestamp 
   */
  private final BigInteger timestamp;

  /**
   * Timestamp since last mode change 
   */
  private final BigInteger timestampmodechanged;

  /**
   * Thermal core updraft strength 
   */
  private final float xw;

  /**
   * Thermal radius 
   */
  private final float xr;

  /**
   * Thermal center latitude 
   */
  private final float xlat;

  /**
   * Thermal center longitude 
   */
  private final float xlon;

  /**
   * Variance W 
   */
  private final float varw;

  /**
   * Variance R 
   */
  private final float varr;

  /**
   * Variance Lat 
   */
  private final float varlat;

  /**
   * Variance Lon 
   */
  private final float varlon;

  /**
   * Suggested loiter radius 
   */
  private final float loiterradius;

  /**
   * Suggested loiter direction 
   */
  private final float loiterdirection;

  /**
   * Distance to soar point 
   */
  private final float disttosoarpoint;

  /**
   * Expected sink rate at current airspeed, roll and throttle 
   */
  private final float vsinkexp;

  /**
   * Measurement / updraft speed at current/local airplane position 
   */
  private final float z1Localupdraftspeed;

  /**
   * Measurement / roll angle tracking error 
   */
  private final float z2Deltaroll;

  /**
   * Expected measurement 1 
   */
  private final float z1Exp;

  /**
   * Expected measurement 2 
   */
  private final float z2Exp;

  /**
   * Thermal drift (from estimator prediction step only) 
   */
  private final float thermalgsnorth;

  /**
   * Thermal drift (from estimator prediction step only) 
   */
  private final float thermalgseast;

  /**
   * Total specific energy change (filtered) 
   */
  private final float tseDot;

  /**
   * Debug variable 1 
   */
  private final float debugvar1;

  /**
   * Debug variable 2 
   */
  private final float debugvar2;

  /**
   * Control Mode [-] 
   */
  private final int controlmode;

  /**
   * Data valid [-] 
   */
  private final int valid;

  private FwSoaringData(BigInteger timestamp, BigInteger timestampmodechanged, float xw, float xr,
      float xlat, float xlon, float varw, float varr, float varlat, float varlon,
      float loiterradius, float loiterdirection, float disttosoarpoint, float vsinkexp,
      float z1Localupdraftspeed, float z2Deltaroll, float z1Exp, float z2Exp, float thermalgsnorth,
      float thermalgseast, float tseDot, float debugvar1, float debugvar2, int controlmode,
      int valid) {
    this.timestamp = timestamp;
    this.timestampmodechanged = timestampmodechanged;
    this.xw = xw;
    this.xr = xr;
    this.xlat = xlat;
    this.xlon = xlon;
    this.varw = varw;
    this.varr = varr;
    this.varlat = varlat;
    this.varlon = varlon;
    this.loiterradius = loiterradius;
    this.loiterdirection = loiterdirection;
    this.disttosoarpoint = disttosoarpoint;
    this.vsinkexp = vsinkexp;
    this.z1Localupdraftspeed = z1Localupdraftspeed;
    this.z2Deltaroll = z2Deltaroll;
    this.z1Exp = z1Exp;
    this.z2Exp = z2Exp;
    this.thermalgsnorth = thermalgsnorth;
    this.thermalgseast = thermalgseast;
    this.tseDot = tseDot;
    this.debugvar1 = debugvar1;
    this.debugvar2 = debugvar2;
    this.controlmode = controlmode;
    this.valid = valid;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "FwSoaringData{timestamp=" + timestamp
         + ", timestampmodechanged=" + timestampmodechanged
         + ", xw=" + xw
         + ", xr=" + xr
         + ", xlat=" + xlat
         + ", xlon=" + xlon
         + ", varw=" + varw
         + ", varr=" + varr
         + ", varlat=" + varlat
         + ", varlon=" + varlon
         + ", loiterradius=" + loiterradius
         + ", loiterdirection=" + loiterdirection
         + ", disttosoarpoint=" + disttosoarpoint
         + ", vsinkexp=" + vsinkexp
         + ", z1Localupdraftspeed=" + z1Localupdraftspeed
         + ", z2Deltaroll=" + z2Deltaroll
         + ", z1Exp=" + z1Exp
         + ", z2Exp=" + z2Exp
         + ", thermalgsnorth=" + thermalgsnorth
         + ", thermalgseast=" + thermalgseast
         + ", tseDot=" + tseDot
         + ", debugvar1=" + debugvar1
         + ", debugvar2=" + debugvar2
         + ", controlmode=" + controlmode
         + ", valid=" + valid + "}";
  }

  /**
   * Timestamp 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 8
  )
  public final BigInteger timestamp() {
    return timestamp;
  }

  /**
   * Timestamp since last mode change 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 8
  )
  public final BigInteger timestampmodechanged() {
    return timestampmodechanged;
  }

  /**
   * Thermal core updraft strength 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 4
  )
  public final float xw() {
    return xw;
  }

  /**
   * Thermal radius 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 4
  )
  public final float xr() {
    return xr;
  }

  /**
   * Thermal center latitude 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 4
  )
  public final float xlat() {
    return xlat;
  }

  /**
   * Thermal center longitude 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 4
  )
  public final float xlon() {
    return xlon;
  }

  /**
   * Variance W 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 4
  )
  public final float varw() {
    return varw;
  }

  /**
   * Variance R 
   */
  @MavlinkFieldInfo(
      position = 8,
      unitSize = 4
  )
  public final float varr() {
    return varr;
  }

  /**
   * Variance Lat 
   */
  @MavlinkFieldInfo(
      position = 9,
      unitSize = 4
  )
  public final float varlat() {
    return varlat;
  }

  /**
   * Variance Lon 
   */
  @MavlinkFieldInfo(
      position = 10,
      unitSize = 4
  )
  public final float varlon() {
    return varlon;
  }

  /**
   * Suggested loiter radius 
   */
  @MavlinkFieldInfo(
      position = 11,
      unitSize = 4
  )
  public final float loiterradius() {
    return loiterradius;
  }

  /**
   * Suggested loiter direction 
   */
  @MavlinkFieldInfo(
      position = 12,
      unitSize = 4
  )
  public final float loiterdirection() {
    return loiterdirection;
  }

  /**
   * Distance to soar point 
   */
  @MavlinkFieldInfo(
      position = 13,
      unitSize = 4
  )
  public final float disttosoarpoint() {
    return disttosoarpoint;
  }

  /**
   * Expected sink rate at current airspeed, roll and throttle 
   */
  @MavlinkFieldInfo(
      position = 14,
      unitSize = 4
  )
  public final float vsinkexp() {
    return vsinkexp;
  }

  /**
   * Measurement / updraft speed at current/local airplane position 
   */
  @MavlinkFieldInfo(
      position = 15,
      unitSize = 4
  )
  public final float z1Localupdraftspeed() {
    return z1Localupdraftspeed;
  }

  /**
   * Measurement / roll angle tracking error 
   */
  @MavlinkFieldInfo(
      position = 16,
      unitSize = 4
  )
  public final float z2Deltaroll() {
    return z2Deltaroll;
  }

  /**
   * Expected measurement 1 
   */
  @MavlinkFieldInfo(
      position = 17,
      unitSize = 4
  )
  public final float z1Exp() {
    return z1Exp;
  }

  /**
   * Expected measurement 2 
   */
  @MavlinkFieldInfo(
      position = 18,
      unitSize = 4
  )
  public final float z2Exp() {
    return z2Exp;
  }

  /**
   * Thermal drift (from estimator prediction step only) 
   */
  @MavlinkFieldInfo(
      position = 19,
      unitSize = 4
  )
  public final float thermalgsnorth() {
    return thermalgsnorth;
  }

  /**
   * Thermal drift (from estimator prediction step only) 
   */
  @MavlinkFieldInfo(
      position = 20,
      unitSize = 4
  )
  public final float thermalgseast() {
    return thermalgseast;
  }

  /**
   * Total specific energy change (filtered) 
   */
  @MavlinkFieldInfo(
      position = 21,
      unitSize = 4
  )
  public final float tseDot() {
    return tseDot;
  }

  /**
   * Debug variable 1 
   */
  @MavlinkFieldInfo(
      position = 22,
      unitSize = 4
  )
  public final float debugvar1() {
    return debugvar1;
  }

  /**
   * Debug variable 2 
   */
  @MavlinkFieldInfo(
      position = 23,
      unitSize = 4
  )
  public final float debugvar2() {
    return debugvar2;
  }

  /**
   * Control Mode [-] 
   */
  @MavlinkFieldInfo(
      position = 24,
      unitSize = 1
  )
  public final int controlmode() {
    return controlmode;
  }

  /**
   * Data valid [-] 
   */
  @MavlinkFieldInfo(
      position = 25,
      unitSize = 1
  )
  public final int valid() {
    return valid;
  }

  public static class Builder {
    private BigInteger timestamp;

    private BigInteger timestampmodechanged;

    private float xw;

    private float xr;

    private float xlat;

    private float xlon;

    private float varw;

    private float varr;

    private float varlat;

    private float varlon;

    private float loiterradius;

    private float loiterdirection;

    private float disttosoarpoint;

    private float vsinkexp;

    private float z1Localupdraftspeed;

    private float z2Deltaroll;

    private float z1Exp;

    private float z2Exp;

    private float thermalgsnorth;

    private float thermalgseast;

    private float tseDot;

    private float debugvar1;

    private float debugvar2;

    private int controlmode;

    private int valid;

    private Builder() {
    }

    /**
     * Timestamp 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 8
    )
    public final Builder timestamp(BigInteger timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    /**
     * Timestamp since last mode change 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 8
    )
    public final Builder timestampmodechanged(BigInteger timestampmodechanged) {
      this.timestampmodechanged = timestampmodechanged;
      return this;
    }

    /**
     * Thermal core updraft strength 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 4
    )
    public final Builder xw(float xw) {
      this.xw = xw;
      return this;
    }

    /**
     * Thermal radius 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 4
    )
    public final Builder xr(float xr) {
      this.xr = xr;
      return this;
    }

    /**
     * Thermal center latitude 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 4
    )
    public final Builder xlat(float xlat) {
      this.xlat = xlat;
      return this;
    }

    /**
     * Thermal center longitude 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 4
    )
    public final Builder xlon(float xlon) {
      this.xlon = xlon;
      return this;
    }

    /**
     * Variance W 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 4
    )
    public final Builder varw(float varw) {
      this.varw = varw;
      return this;
    }

    /**
     * Variance R 
     */
    @MavlinkFieldInfo(
        position = 8,
        unitSize = 4
    )
    public final Builder varr(float varr) {
      this.varr = varr;
      return this;
    }

    /**
     * Variance Lat 
     */
    @MavlinkFieldInfo(
        position = 9,
        unitSize = 4
    )
    public final Builder varlat(float varlat) {
      this.varlat = varlat;
      return this;
    }

    /**
     * Variance Lon 
     */
    @MavlinkFieldInfo(
        position = 10,
        unitSize = 4
    )
    public final Builder varlon(float varlon) {
      this.varlon = varlon;
      return this;
    }

    /**
     * Suggested loiter radius 
     */
    @MavlinkFieldInfo(
        position = 11,
        unitSize = 4
    )
    public final Builder loiterradius(float loiterradius) {
      this.loiterradius = loiterradius;
      return this;
    }

    /**
     * Suggested loiter direction 
     */
    @MavlinkFieldInfo(
        position = 12,
        unitSize = 4
    )
    public final Builder loiterdirection(float loiterdirection) {
      this.loiterdirection = loiterdirection;
      return this;
    }

    /**
     * Distance to soar point 
     */
    @MavlinkFieldInfo(
        position = 13,
        unitSize = 4
    )
    public final Builder disttosoarpoint(float disttosoarpoint) {
      this.disttosoarpoint = disttosoarpoint;
      return this;
    }

    /**
     * Expected sink rate at current airspeed, roll and throttle 
     */
    @MavlinkFieldInfo(
        position = 14,
        unitSize = 4
    )
    public final Builder vsinkexp(float vsinkexp) {
      this.vsinkexp = vsinkexp;
      return this;
    }

    /**
     * Measurement / updraft speed at current/local airplane position 
     */
    @MavlinkFieldInfo(
        position = 15,
        unitSize = 4
    )
    public final Builder z1Localupdraftspeed(float z1Localupdraftspeed) {
      this.z1Localupdraftspeed = z1Localupdraftspeed;
      return this;
    }

    /**
     * Measurement / roll angle tracking error 
     */
    @MavlinkFieldInfo(
        position = 16,
        unitSize = 4
    )
    public final Builder z2Deltaroll(float z2Deltaroll) {
      this.z2Deltaroll = z2Deltaroll;
      return this;
    }

    /**
     * Expected measurement 1 
     */
    @MavlinkFieldInfo(
        position = 17,
        unitSize = 4
    )
    public final Builder z1Exp(float z1Exp) {
      this.z1Exp = z1Exp;
      return this;
    }

    /**
     * Expected measurement 2 
     */
    @MavlinkFieldInfo(
        position = 18,
        unitSize = 4
    )
    public final Builder z2Exp(float z2Exp) {
      this.z2Exp = z2Exp;
      return this;
    }

    /**
     * Thermal drift (from estimator prediction step only) 
     */
    @MavlinkFieldInfo(
        position = 19,
        unitSize = 4
    )
    public final Builder thermalgsnorth(float thermalgsnorth) {
      this.thermalgsnorth = thermalgsnorth;
      return this;
    }

    /**
     * Thermal drift (from estimator prediction step only) 
     */
    @MavlinkFieldInfo(
        position = 20,
        unitSize = 4
    )
    public final Builder thermalgseast(float thermalgseast) {
      this.thermalgseast = thermalgseast;
      return this;
    }

    /**
     * Total specific energy change (filtered) 
     */
    @MavlinkFieldInfo(
        position = 21,
        unitSize = 4
    )
    public final Builder tseDot(float tseDot) {
      this.tseDot = tseDot;
      return this;
    }

    /**
     * Debug variable 1 
     */
    @MavlinkFieldInfo(
        position = 22,
        unitSize = 4
    )
    public final Builder debugvar1(float debugvar1) {
      this.debugvar1 = debugvar1;
      return this;
    }

    /**
     * Debug variable 2 
     */
    @MavlinkFieldInfo(
        position = 23,
        unitSize = 4
    )
    public final Builder debugvar2(float debugvar2) {
      this.debugvar2 = debugvar2;
      return this;
    }

    /**
     * Control Mode [-] 
     */
    @MavlinkFieldInfo(
        position = 24,
        unitSize = 1
    )
    public final Builder controlmode(int controlmode) {
      this.controlmode = controlmode;
      return this;
    }

    /**
     * Data valid [-] 
     */
    @MavlinkFieldInfo(
        position = 25,
        unitSize = 1
    )
    public final Builder valid(int valid) {
      this.valid = valid;
      return this;
    }

    public final FwSoaringData build() {
      return new FwSoaringData(timestamp, timestampmodechanged, xw, xr, xlat, xlon, varw, varr, varlat, varlon, loiterradius, loiterdirection, disttosoarpoint, vsinkexp, z1Localupdraftspeed, z2Deltaroll, z1Exp, z2Exp, thermalgsnorth, thermalgseast, tseDot, debugvar1, debugvar2, controlmode, valid);
    }
  }
}
