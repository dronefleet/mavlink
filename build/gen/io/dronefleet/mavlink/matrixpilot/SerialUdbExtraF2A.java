package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Backwards compatible MAVLink version of SERIAL_UDB_EXTRA - F2: Format Part A 
 */
@MavlinkMessage(
    id = 170,
    crc = 103
)
public final class SerialUdbExtraF2A {
  private final long sueTime;

  private final int sueStatus;

  private final int sueLatitude;

  private final int sueLongitude;

  private final int sueAltitude;

  private final int sueWaypointIndex;

  private final int sueRmat0;

  private final int sueRmat1;

  private final int sueRmat2;

  private final int sueRmat3;

  private final int sueRmat4;

  private final int sueRmat5;

  private final int sueRmat6;

  private final int sueRmat7;

  private final int sueRmat8;

  private final int sueCog;

  private final int sueSog;

  private final int sueCpuLoad;

  private final int sueAirSpeed3dimu;

  private final int sueEstimatedWind0;

  private final int sueEstimatedWind1;

  private final int sueEstimatedWind2;

  private final int sueMagfieldearth0;

  private final int sueMagfieldearth1;

  private final int sueMagfieldearth2;

  private final int sueSvs;

  private final int sueHdop;

  private SerialUdbExtraF2A(long sueTime, int sueStatus, int sueLatitude, int sueLongitude,
      int sueAltitude, int sueWaypointIndex, int sueRmat0, int sueRmat1, int sueRmat2, int sueRmat3,
      int sueRmat4, int sueRmat5, int sueRmat6, int sueRmat7, int sueRmat8, int sueCog, int sueSog,
      int sueCpuLoad, int sueAirSpeed3dimu, int sueEstimatedWind0, int sueEstimatedWind1,
      int sueEstimatedWind2, int sueMagfieldearth0, int sueMagfieldearth1, int sueMagfieldearth2,
      int sueSvs, int sueHdop) {
    this.sueTime = sueTime;
    this.sueStatus = sueStatus;
    this.sueLatitude = sueLatitude;
    this.sueLongitude = sueLongitude;
    this.sueAltitude = sueAltitude;
    this.sueWaypointIndex = sueWaypointIndex;
    this.sueRmat0 = sueRmat0;
    this.sueRmat1 = sueRmat1;
    this.sueRmat2 = sueRmat2;
    this.sueRmat3 = sueRmat3;
    this.sueRmat4 = sueRmat4;
    this.sueRmat5 = sueRmat5;
    this.sueRmat6 = sueRmat6;
    this.sueRmat7 = sueRmat7;
    this.sueRmat8 = sueRmat8;
    this.sueCog = sueCog;
    this.sueSog = sueSog;
    this.sueCpuLoad = sueCpuLoad;
    this.sueAirSpeed3dimu = sueAirSpeed3dimu;
    this.sueEstimatedWind0 = sueEstimatedWind0;
    this.sueEstimatedWind1 = sueEstimatedWind1;
    this.sueEstimatedWind2 = sueEstimatedWind2;
    this.sueMagfieldearth0 = sueMagfieldearth0;
    this.sueMagfieldearth1 = sueMagfieldearth1;
    this.sueMagfieldearth2 = sueMagfieldearth2;
    this.sueSvs = sueSvs;
    this.sueHdop = sueHdop;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Serial UDB Extra Time 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final long sueTime() {
    return sueTime;
  }

  /**
   * Serial UDB Extra Status 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int sueStatus() {
    return sueStatus;
  }

  /**
   * Serial UDB Extra Latitude 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final int sueLatitude() {
    return sueLatitude;
  }

  /**
   * Serial UDB Extra Longitude 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final int sueLongitude() {
    return sueLongitude;
  }

  /**
   * Serial UDB Extra Altitude 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final int sueAltitude() {
    return sueAltitude;
  }

  /**
   * Serial UDB Extra Waypoint Index 
   */
  @MavlinkMessageField(
      position = 6,
      length = 2
  )
  public final int sueWaypointIndex() {
    return sueWaypointIndex;
  }

  /**
   * Serial UDB Extra Rmat 0 
   */
  @MavlinkMessageField(
      position = 7,
      length = 2
  )
  public final int sueRmat0() {
    return sueRmat0;
  }

  /**
   * Serial UDB Extra Rmat 1 
   */
  @MavlinkMessageField(
      position = 8,
      length = 2
  )
  public final int sueRmat1() {
    return sueRmat1;
  }

  /**
   * Serial UDB Extra Rmat 2 
   */
  @MavlinkMessageField(
      position = 9,
      length = 2
  )
  public final int sueRmat2() {
    return sueRmat2;
  }

  /**
   * Serial UDB Extra Rmat 3 
   */
  @MavlinkMessageField(
      position = 10,
      length = 2
  )
  public final int sueRmat3() {
    return sueRmat3;
  }

  /**
   * Serial UDB Extra Rmat 4 
   */
  @MavlinkMessageField(
      position = 11,
      length = 2
  )
  public final int sueRmat4() {
    return sueRmat4;
  }

  /**
   * Serial UDB Extra Rmat 5 
   */
  @MavlinkMessageField(
      position = 12,
      length = 2
  )
  public final int sueRmat5() {
    return sueRmat5;
  }

  /**
   * Serial UDB Extra Rmat 6 
   */
  @MavlinkMessageField(
      position = 13,
      length = 2
  )
  public final int sueRmat6() {
    return sueRmat6;
  }

  /**
   * Serial UDB Extra Rmat 7 
   */
  @MavlinkMessageField(
      position = 14,
      length = 2
  )
  public final int sueRmat7() {
    return sueRmat7;
  }

  /**
   * Serial UDB Extra Rmat 8 
   */
  @MavlinkMessageField(
      position = 15,
      length = 2
  )
  public final int sueRmat8() {
    return sueRmat8;
  }

  /**
   * Serial UDB Extra GPS Course Over Ground 
   */
  @MavlinkMessageField(
      position = 16,
      length = 2
  )
  public final int sueCog() {
    return sueCog;
  }

  /**
   * Serial UDB Extra Speed Over Ground 
   */
  @MavlinkMessageField(
      position = 17,
      length = 2
  )
  public final int sueSog() {
    return sueSog;
  }

  /**
   * Serial UDB Extra CPU Load 
   */
  @MavlinkMessageField(
      position = 18,
      length = 2
  )
  public final int sueCpuLoad() {
    return sueCpuLoad;
  }

  /**
   * Serial UDB Extra 3D IMU Air Speed 
   */
  @MavlinkMessageField(
      position = 19,
      length = 2
  )
  public final int sueAirSpeed3dimu() {
    return sueAirSpeed3dimu;
  }

  /**
   * Serial UDB Extra Estimated Wind 0 
   */
  @MavlinkMessageField(
      position = 20,
      length = 2
  )
  public final int sueEstimatedWind0() {
    return sueEstimatedWind0;
  }

  /**
   * Serial UDB Extra Estimated Wind 1 
   */
  @MavlinkMessageField(
      position = 21,
      length = 2
  )
  public final int sueEstimatedWind1() {
    return sueEstimatedWind1;
  }

  /**
   * Serial UDB Extra Estimated Wind 2 
   */
  @MavlinkMessageField(
      position = 22,
      length = 2
  )
  public final int sueEstimatedWind2() {
    return sueEstimatedWind2;
  }

  /**
   * Serial UDB Extra Magnetic Field Earth 0 
   */
  @MavlinkMessageField(
      position = 23,
      length = 2
  )
  public final int sueMagfieldearth0() {
    return sueMagfieldearth0;
  }

  /**
   * Serial UDB Extra Magnetic Field Earth 1 
   */
  @MavlinkMessageField(
      position = 24,
      length = 2
  )
  public final int sueMagfieldearth1() {
    return sueMagfieldearth1;
  }

  /**
   * Serial UDB Extra Magnetic Field Earth 2 
   */
  @MavlinkMessageField(
      position = 25,
      length = 2
  )
  public final int sueMagfieldearth2() {
    return sueMagfieldearth2;
  }

  /**
   * Serial UDB Extra Number of Sattelites in View 
   */
  @MavlinkMessageField(
      position = 26,
      length = 2
  )
  public final int sueSvs() {
    return sueSvs;
  }

  /**
   * Serial UDB Extra GPS Horizontal Dilution of Precision 
   */
  @MavlinkMessageField(
      position = 27,
      length = 2
  )
  public final int sueHdop() {
    return sueHdop;
  }

  public class Builder {
    private long sueTime;

    private int sueStatus;

    private int sueLatitude;

    private int sueLongitude;

    private int sueAltitude;

    private int sueWaypointIndex;

    private int sueRmat0;

    private int sueRmat1;

    private int sueRmat2;

    private int sueRmat3;

    private int sueRmat4;

    private int sueRmat5;

    private int sueRmat6;

    private int sueRmat7;

    private int sueRmat8;

    private int sueCog;

    private int sueSog;

    private int sueCpuLoad;

    private int sueAirSpeed3dimu;

    private int sueEstimatedWind0;

    private int sueEstimatedWind1;

    private int sueEstimatedWind2;

    private int sueMagfieldearth0;

    private int sueMagfieldearth1;

    private int sueMagfieldearth2;

    private int sueSvs;

    private int sueHdop;

    private Builder() {
    }

    /**
     * Serial UDB Extra Time 
     */
    @MavlinkMessageField(
        position = 1,
        length = 4
    )
    public final Builder sueTime(long sueTime) {
      this.sueTime = sueTime;
      return this;
    }

    /**
     * Serial UDB Extra Status 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder sueStatus(int sueStatus) {
      this.sueStatus = sueStatus;
      return this;
    }

    /**
     * Serial UDB Extra Latitude 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder sueLatitude(int sueLatitude) {
      this.sueLatitude = sueLatitude;
      return this;
    }

    /**
     * Serial UDB Extra Longitude 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder sueLongitude(int sueLongitude) {
      this.sueLongitude = sueLongitude;
      return this;
    }

    /**
     * Serial UDB Extra Altitude 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder sueAltitude(int sueAltitude) {
      this.sueAltitude = sueAltitude;
      return this;
    }

    /**
     * Serial UDB Extra Waypoint Index 
     */
    @MavlinkMessageField(
        position = 6,
        length = 2
    )
    public final Builder sueWaypointIndex(int sueWaypointIndex) {
      this.sueWaypointIndex = sueWaypointIndex;
      return this;
    }

    /**
     * Serial UDB Extra Rmat 0 
     */
    @MavlinkMessageField(
        position = 7,
        length = 2
    )
    public final Builder sueRmat0(int sueRmat0) {
      this.sueRmat0 = sueRmat0;
      return this;
    }

    /**
     * Serial UDB Extra Rmat 1 
     */
    @MavlinkMessageField(
        position = 8,
        length = 2
    )
    public final Builder sueRmat1(int sueRmat1) {
      this.sueRmat1 = sueRmat1;
      return this;
    }

    /**
     * Serial UDB Extra Rmat 2 
     */
    @MavlinkMessageField(
        position = 9,
        length = 2
    )
    public final Builder sueRmat2(int sueRmat2) {
      this.sueRmat2 = sueRmat2;
      return this;
    }

    /**
     * Serial UDB Extra Rmat 3 
     */
    @MavlinkMessageField(
        position = 10,
        length = 2
    )
    public final Builder sueRmat3(int sueRmat3) {
      this.sueRmat3 = sueRmat3;
      return this;
    }

    /**
     * Serial UDB Extra Rmat 4 
     */
    @MavlinkMessageField(
        position = 11,
        length = 2
    )
    public final Builder sueRmat4(int sueRmat4) {
      this.sueRmat4 = sueRmat4;
      return this;
    }

    /**
     * Serial UDB Extra Rmat 5 
     */
    @MavlinkMessageField(
        position = 12,
        length = 2
    )
    public final Builder sueRmat5(int sueRmat5) {
      this.sueRmat5 = sueRmat5;
      return this;
    }

    /**
     * Serial UDB Extra Rmat 6 
     */
    @MavlinkMessageField(
        position = 13,
        length = 2
    )
    public final Builder sueRmat6(int sueRmat6) {
      this.sueRmat6 = sueRmat6;
      return this;
    }

    /**
     * Serial UDB Extra Rmat 7 
     */
    @MavlinkMessageField(
        position = 14,
        length = 2
    )
    public final Builder sueRmat7(int sueRmat7) {
      this.sueRmat7 = sueRmat7;
      return this;
    }

    /**
     * Serial UDB Extra Rmat 8 
     */
    @MavlinkMessageField(
        position = 15,
        length = 2
    )
    public final Builder sueRmat8(int sueRmat8) {
      this.sueRmat8 = sueRmat8;
      return this;
    }

    /**
     * Serial UDB Extra GPS Course Over Ground 
     */
    @MavlinkMessageField(
        position = 16,
        length = 2
    )
    public final Builder sueCog(int sueCog) {
      this.sueCog = sueCog;
      return this;
    }

    /**
     * Serial UDB Extra Speed Over Ground 
     */
    @MavlinkMessageField(
        position = 17,
        length = 2
    )
    public final Builder sueSog(int sueSog) {
      this.sueSog = sueSog;
      return this;
    }

    /**
     * Serial UDB Extra CPU Load 
     */
    @MavlinkMessageField(
        position = 18,
        length = 2
    )
    public final Builder sueCpuLoad(int sueCpuLoad) {
      this.sueCpuLoad = sueCpuLoad;
      return this;
    }

    /**
     * Serial UDB Extra 3D IMU Air Speed 
     */
    @MavlinkMessageField(
        position = 19,
        length = 2
    )
    public final Builder sueAirSpeed3dimu(int sueAirSpeed3dimu) {
      this.sueAirSpeed3dimu = sueAirSpeed3dimu;
      return this;
    }

    /**
     * Serial UDB Extra Estimated Wind 0 
     */
    @MavlinkMessageField(
        position = 20,
        length = 2
    )
    public final Builder sueEstimatedWind0(int sueEstimatedWind0) {
      this.sueEstimatedWind0 = sueEstimatedWind0;
      return this;
    }

    /**
     * Serial UDB Extra Estimated Wind 1 
     */
    @MavlinkMessageField(
        position = 21,
        length = 2
    )
    public final Builder sueEstimatedWind1(int sueEstimatedWind1) {
      this.sueEstimatedWind1 = sueEstimatedWind1;
      return this;
    }

    /**
     * Serial UDB Extra Estimated Wind 2 
     */
    @MavlinkMessageField(
        position = 22,
        length = 2
    )
    public final Builder sueEstimatedWind2(int sueEstimatedWind2) {
      this.sueEstimatedWind2 = sueEstimatedWind2;
      return this;
    }

    /**
     * Serial UDB Extra Magnetic Field Earth 0 
     */
    @MavlinkMessageField(
        position = 23,
        length = 2
    )
    public final Builder sueMagfieldearth0(int sueMagfieldearth0) {
      this.sueMagfieldearth0 = sueMagfieldearth0;
      return this;
    }

    /**
     * Serial UDB Extra Magnetic Field Earth 1 
     */
    @MavlinkMessageField(
        position = 24,
        length = 2
    )
    public final Builder sueMagfieldearth1(int sueMagfieldearth1) {
      this.sueMagfieldearth1 = sueMagfieldearth1;
      return this;
    }

    /**
     * Serial UDB Extra Magnetic Field Earth 2 
     */
    @MavlinkMessageField(
        position = 25,
        length = 2
    )
    public final Builder sueMagfieldearth2(int sueMagfieldearth2) {
      this.sueMagfieldearth2 = sueMagfieldearth2;
      return this;
    }

    /**
     * Serial UDB Extra Number of Sattelites in View 
     */
    @MavlinkMessageField(
        position = 26,
        length = 2
    )
    public final Builder sueSvs(int sueSvs) {
      this.sueSvs = sueSvs;
      return this;
    }

    /**
     * Serial UDB Extra GPS Horizontal Dilution of Precision 
     */
    @MavlinkMessageField(
        position = 27,
        length = 2
    )
    public final Builder sueHdop(int sueHdop) {
      this.sueHdop = sueHdop;
      return this;
    }

    public final SerialUdbExtraF2A build() {
      return new SerialUdbExtraF2A(sueTime, sueStatus, sueLatitude, sueLongitude, sueAltitude, sueWaypointIndex, sueRmat0, sueRmat1, sueRmat2, sueRmat3, sueRmat4, sueRmat5, sueRmat6, sueRmat7, sueRmat8, sueCog, sueSog, sueCpuLoad, sueAirSpeed3dimu, sueEstimatedWind0, sueEstimatedWind1, sueEstimatedWind2, sueMagfieldearth0, sueMagfieldearth1, sueMagfieldearth2, sueSvs, sueHdop);
    }
  }
}
