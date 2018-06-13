package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * RTK GPS data. Gives information on the relative baseline calculation the GPS is reporting 
 */
@MavlinkMessage(
    id = 128,
    crc = 226
)
public final class Gps2Rtk {
  private final long timeLastBaselineMs;

  private final int rtkReceiverId;

  private final int wn;

  private final long tow;

  private final int rtkHealth;

  private final int rtkRate;

  private final int nsats;

  private final RtkBaselineCoordinateSystem baselineCoordsType;

  private final int baselineAMm;

  private final int baselineBMm;

  private final int baselineCMm;

  private final long accuracy;

  private final int iarNumHypotheses;

  private Gps2Rtk(long timeLastBaselineMs, int rtkReceiverId, int wn, long tow, int rtkHealth,
      int rtkRate, int nsats, RtkBaselineCoordinateSystem baselineCoordsType, int baselineAMm,
      int baselineBMm, int baselineCMm, long accuracy, int iarNumHypotheses) {
    this.timeLastBaselineMs = timeLastBaselineMs;
    this.rtkReceiverId = rtkReceiverId;
    this.wn = wn;
    this.tow = tow;
    this.rtkHealth = rtkHealth;
    this.rtkRate = rtkRate;
    this.nsats = nsats;
    this.baselineCoordsType = baselineCoordsType;
    this.baselineAMm = baselineAMm;
    this.baselineBMm = baselineBMm;
    this.baselineCMm = baselineCMm;
    this.accuracy = accuracy;
    this.iarNumHypotheses = iarNumHypotheses;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Time since boot of last baseline message received in ms. 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final long timeLastBaselineMs() {
    return timeLastBaselineMs;
  }

  /**
   * Identification of connected RTK receiver. 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int rtkReceiverId() {
    return rtkReceiverId;
  }

  /**
   * GPS Week Number of last baseline 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int wn() {
    return wn;
  }

  /**
   * GPS Time of Week of last baseline 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final long tow() {
    return tow;
  }

  /**
   * GPS-specific health report for RTK data. 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1
  )
  public final int rtkHealth() {
    return rtkHealth;
  }

  /**
   * Rate of baseline messages being received by GPS, in HZ 
   */
  @MavlinkMessageField(
      position = 6,
      length = 1
  )
  public final int rtkRate() {
    return rtkRate;
  }

  /**
   * Current number of sats used for RTK calculation. 
   */
  @MavlinkMessageField(
      position = 7,
      length = 1
  )
  public final int nsats() {
    return nsats;
  }

  /**
   * Coordinate system of baseline 
   */
  @MavlinkMessageField(
      position = 8,
      length = 1
  )
  public final RtkBaselineCoordinateSystem baselineCoordsType() {
    return baselineCoordsType;
  }

  /**
   * Current baseline in ECEF x or NED north component in mm. 
   */
  @MavlinkMessageField(
      position = 9,
      length = 4
  )
  public final int baselineAMm() {
    return baselineAMm;
  }

  /**
   * Current baseline in ECEF y or NED east component in mm. 
   */
  @MavlinkMessageField(
      position = 10,
      length = 4
  )
  public final int baselineBMm() {
    return baselineBMm;
  }

  /**
   * Current baseline in ECEF z or NED down component in mm. 
   */
  @MavlinkMessageField(
      position = 11,
      length = 4
  )
  public final int baselineCMm() {
    return baselineCMm;
  }

  /**
   * Current estimate of baseline accuracy. 
   */
  @MavlinkMessageField(
      position = 12,
      length = 4
  )
  public final long accuracy() {
    return accuracy;
  }

  /**
   * Current number of integer ambiguity hypotheses. 
   */
  @MavlinkMessageField(
      position = 13,
      length = 4
  )
  public final int iarNumHypotheses() {
    return iarNumHypotheses;
  }

  public class Builder {
    private long timeLastBaselineMs;

    private int rtkReceiverId;

    private int wn;

    private long tow;

    private int rtkHealth;

    private int rtkRate;

    private int nsats;

    private RtkBaselineCoordinateSystem baselineCoordsType;

    private int baselineAMm;

    private int baselineBMm;

    private int baselineCMm;

    private long accuracy;

    private int iarNumHypotheses;

    private Builder() {
    }

    /**
     * Time since boot of last baseline message received in ms. 
     */
    @MavlinkMessageField(
        position = 1,
        length = 4
    )
    public final Builder timeLastBaselineMs(long timeLastBaselineMs) {
      this.timeLastBaselineMs = timeLastBaselineMs;
      return this;
    }

    /**
     * Identification of connected RTK receiver. 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder rtkReceiverId(int rtkReceiverId) {
      this.rtkReceiverId = rtkReceiverId;
      return this;
    }

    /**
     * GPS Week Number of last baseline 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder wn(int wn) {
      this.wn = wn;
      return this;
    }

    /**
     * GPS Time of Week of last baseline 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder tow(long tow) {
      this.tow = tow;
      return this;
    }

    /**
     * GPS-specific health report for RTK data. 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1
    )
    public final Builder rtkHealth(int rtkHealth) {
      this.rtkHealth = rtkHealth;
      return this;
    }

    /**
     * Rate of baseline messages being received by GPS, in HZ 
     */
    @MavlinkMessageField(
        position = 6,
        length = 1
    )
    public final Builder rtkRate(int rtkRate) {
      this.rtkRate = rtkRate;
      return this;
    }

    /**
     * Current number of sats used for RTK calculation. 
     */
    @MavlinkMessageField(
        position = 7,
        length = 1
    )
    public final Builder nsats(int nsats) {
      this.nsats = nsats;
      return this;
    }

    /**
     * Coordinate system of baseline 
     */
    @MavlinkMessageField(
        position = 8,
        length = 1
    )
    public final Builder baselineCoordsType(RtkBaselineCoordinateSystem baselineCoordsType) {
      this.baselineCoordsType = baselineCoordsType;
      return this;
    }

    /**
     * Current baseline in ECEF x or NED north component in mm. 
     */
    @MavlinkMessageField(
        position = 9,
        length = 4
    )
    public final Builder baselineAMm(int baselineAMm) {
      this.baselineAMm = baselineAMm;
      return this;
    }

    /**
     * Current baseline in ECEF y or NED east component in mm. 
     */
    @MavlinkMessageField(
        position = 10,
        length = 4
    )
    public final Builder baselineBMm(int baselineBMm) {
      this.baselineBMm = baselineBMm;
      return this;
    }

    /**
     * Current baseline in ECEF z or NED down component in mm. 
     */
    @MavlinkMessageField(
        position = 11,
        length = 4
    )
    public final Builder baselineCMm(int baselineCMm) {
      this.baselineCMm = baselineCMm;
      return this;
    }

    /**
     * Current estimate of baseline accuracy. 
     */
    @MavlinkMessageField(
        position = 12,
        length = 4
    )
    public final Builder accuracy(long accuracy) {
      this.accuracy = accuracy;
      return this;
    }

    /**
     * Current number of integer ambiguity hypotheses. 
     */
    @MavlinkMessageField(
        position = 13,
        length = 4
    )
    public final Builder iarNumHypotheses(int iarNumHypotheses) {
      this.iarNumHypotheses = iarNumHypotheses;
      return this;
    }

    public final Gps2Rtk build() {
      return new Gps2Rtk(timeLastBaselineMs, rtkReceiverId, wn, tow, rtkHealth, rtkRate, nsats, baselineCoordsType, baselineAMm, baselineBMm, baselineCMm, accuracy, iarNumHypotheses);
    }
  }
}
