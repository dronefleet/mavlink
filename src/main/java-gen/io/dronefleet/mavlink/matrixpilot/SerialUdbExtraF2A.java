package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Backwards compatible MAVLink version of SERIAL_UDB_EXTRA - F2: Format Part A 
 */
@MavlinkMessageInfo(
    id = 170,
    crc = 103
)
public final class SerialUdbExtraF2A {
  /**
   * Serial UDB Extra Time 
   */
  private final long sueTime;

  /**
   * Serial UDB Extra Latitude 
   */
  private final int sueLatitude;

  /**
   * Serial UDB Extra Longitude 
   */
  private final int sueLongitude;

  /**
   * Serial UDB Extra Altitude 
   */
  private final int sueAltitude;

  /**
   * Serial UDB Extra Waypoint Index 
   */
  private final int sueWaypointIndex;

  /**
   * Serial UDB Extra Rmat 0 
   */
  private final int sueRmat0;

  /**
   * Serial UDB Extra Rmat 1 
   */
  private final int sueRmat1;

  /**
   * Serial UDB Extra Rmat 2 
   */
  private final int sueRmat2;

  /**
   * Serial UDB Extra Rmat 3 
   */
  private final int sueRmat3;

  /**
   * Serial UDB Extra Rmat 4 
   */
  private final int sueRmat4;

  /**
   * Serial UDB Extra Rmat 5 
   */
  private final int sueRmat5;

  /**
   * Serial UDB Extra Rmat 6 
   */
  private final int sueRmat6;

  /**
   * Serial UDB Extra Rmat 7 
   */
  private final int sueRmat7;

  /**
   * Serial UDB Extra Rmat 8 
   */
  private final int sueRmat8;

  /**
   * Serial UDB Extra GPS Course Over Ground 
   */
  private final int sueCog;

  /**
   * Serial UDB Extra Speed Over Ground 
   */
  private final int sueSog;

  /**
   * Serial UDB Extra CPU Load 
   */
  private final int sueCpuLoad;

  /**
   * Serial UDB Extra 3D IMU Air Speed 
   */
  private final int sueAirSpeed3dimu;

  /**
   * Serial UDB Extra Estimated Wind 0 
   */
  private final int sueEstimatedWind0;

  /**
   * Serial UDB Extra Estimated Wind 1 
   */
  private final int sueEstimatedWind1;

  /**
   * Serial UDB Extra Estimated Wind 2 
   */
  private final int sueEstimatedWind2;

  /**
   * Serial UDB Extra Magnetic Field Earth 0 
   */
  private final int sueMagfieldearth0;

  /**
   * Serial UDB Extra Magnetic Field Earth 1 
   */
  private final int sueMagfieldearth1;

  /**
   * Serial UDB Extra Magnetic Field Earth 2 
   */
  private final int sueMagfieldearth2;

  /**
   * Serial UDB Extra Number of Sattelites in View 
   */
  private final int sueSvs;

  /**
   * Serial UDB Extra GPS Horizontal Dilution of Precision 
   */
  private final int sueHdop;

  /**
   * Serial UDB Extra Status 
   */
  private final int sueStatus;

  private SerialUdbExtraF2A(long sueTime, int sueLatitude, int sueLongitude, int sueAltitude,
      int sueWaypointIndex, int sueRmat0, int sueRmat1, int sueRmat2, int sueRmat3, int sueRmat4,
      int sueRmat5, int sueRmat6, int sueRmat7, int sueRmat8, int sueCog, int sueSog,
      int sueCpuLoad, int sueAirSpeed3dimu, int sueEstimatedWind0, int sueEstimatedWind1,
      int sueEstimatedWind2, int sueMagfieldearth0, int sueMagfieldearth1, int sueMagfieldearth2,
      int sueSvs, int sueHdop, int sueStatus) {
    this.sueTime = sueTime;
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
    this.sueStatus = sueStatus;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "SerialUdbExtraF2A{sueTime=" + sueTime
         + ", sueStatus=" + sueStatus
         + ", sueLatitude=" + sueLatitude
         + ", sueLongitude=" + sueLongitude
         + ", sueAltitude=" + sueAltitude
         + ", sueWaypointIndex=" + sueWaypointIndex
         + ", sueRmat0=" + sueRmat0
         + ", sueRmat1=" + sueRmat1
         + ", sueRmat2=" + sueRmat2
         + ", sueRmat3=" + sueRmat3
         + ", sueRmat4=" + sueRmat4
         + ", sueRmat5=" + sueRmat5
         + ", sueRmat6=" + sueRmat6
         + ", sueRmat7=" + sueRmat7
         + ", sueRmat8=" + sueRmat8
         + ", sueCog=" + sueCog
         + ", sueSog=" + sueSog
         + ", sueCpuLoad=" + sueCpuLoad
         + ", sueAirSpeed3dimu=" + sueAirSpeed3dimu
         + ", sueEstimatedWind0=" + sueEstimatedWind0
         + ", sueEstimatedWind1=" + sueEstimatedWind1
         + ", sueEstimatedWind2=" + sueEstimatedWind2
         + ", sueMagfieldearth0=" + sueMagfieldearth0
         + ", sueMagfieldearth1=" + sueMagfieldearth1
         + ", sueMagfieldearth2=" + sueMagfieldearth2
         + ", sueSvs=" + sueSvs
         + ", sueHdop=" + sueHdop + "}";
  }

  /**
   * Serial UDB Extra Time 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 4
  )
  public final long sueTime() {
    return sueTime;
  }

  /**
   * Serial UDB Extra Latitude 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 4
  )
  public final int sueLatitude() {
    return sueLatitude;
  }

  /**
   * Serial UDB Extra Longitude 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 4
  )
  public final int sueLongitude() {
    return sueLongitude;
  }

  /**
   * Serial UDB Extra Altitude 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 4
  )
  public final int sueAltitude() {
    return sueAltitude;
  }

  /**
   * Serial UDB Extra Waypoint Index 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 2
  )
  public final int sueWaypointIndex() {
    return sueWaypointIndex;
  }

  /**
   * Serial UDB Extra Rmat 0 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 2
  )
  public final int sueRmat0() {
    return sueRmat0;
  }

  /**
   * Serial UDB Extra Rmat 1 
   */
  @MavlinkFieldInfo(
      position = 8,
      unitSize = 2
  )
  public final int sueRmat1() {
    return sueRmat1;
  }

  /**
   * Serial UDB Extra Rmat 2 
   */
  @MavlinkFieldInfo(
      position = 9,
      unitSize = 2
  )
  public final int sueRmat2() {
    return sueRmat2;
  }

  /**
   * Serial UDB Extra Rmat 3 
   */
  @MavlinkFieldInfo(
      position = 10,
      unitSize = 2
  )
  public final int sueRmat3() {
    return sueRmat3;
  }

  /**
   * Serial UDB Extra Rmat 4 
   */
  @MavlinkFieldInfo(
      position = 11,
      unitSize = 2
  )
  public final int sueRmat4() {
    return sueRmat4;
  }

  /**
   * Serial UDB Extra Rmat 5 
   */
  @MavlinkFieldInfo(
      position = 12,
      unitSize = 2
  )
  public final int sueRmat5() {
    return sueRmat5;
  }

  /**
   * Serial UDB Extra Rmat 6 
   */
  @MavlinkFieldInfo(
      position = 13,
      unitSize = 2
  )
  public final int sueRmat6() {
    return sueRmat6;
  }

  /**
   * Serial UDB Extra Rmat 7 
   */
  @MavlinkFieldInfo(
      position = 14,
      unitSize = 2
  )
  public final int sueRmat7() {
    return sueRmat7;
  }

  /**
   * Serial UDB Extra Rmat 8 
   */
  @MavlinkFieldInfo(
      position = 15,
      unitSize = 2
  )
  public final int sueRmat8() {
    return sueRmat8;
  }

  /**
   * Serial UDB Extra GPS Course Over Ground 
   */
  @MavlinkFieldInfo(
      position = 16,
      unitSize = 2
  )
  public final int sueCog() {
    return sueCog;
  }

  /**
   * Serial UDB Extra Speed Over Ground 
   */
  @MavlinkFieldInfo(
      position = 17,
      unitSize = 2
  )
  public final int sueSog() {
    return sueSog;
  }

  /**
   * Serial UDB Extra CPU Load 
   */
  @MavlinkFieldInfo(
      position = 18,
      unitSize = 2
  )
  public final int sueCpuLoad() {
    return sueCpuLoad;
  }

  /**
   * Serial UDB Extra 3D IMU Air Speed 
   */
  @MavlinkFieldInfo(
      position = 19,
      unitSize = 2
  )
  public final int sueAirSpeed3dimu() {
    return sueAirSpeed3dimu;
  }

  /**
   * Serial UDB Extra Estimated Wind 0 
   */
  @MavlinkFieldInfo(
      position = 20,
      unitSize = 2
  )
  public final int sueEstimatedWind0() {
    return sueEstimatedWind0;
  }

  /**
   * Serial UDB Extra Estimated Wind 1 
   */
  @MavlinkFieldInfo(
      position = 21,
      unitSize = 2
  )
  public final int sueEstimatedWind1() {
    return sueEstimatedWind1;
  }

  /**
   * Serial UDB Extra Estimated Wind 2 
   */
  @MavlinkFieldInfo(
      position = 22,
      unitSize = 2
  )
  public final int sueEstimatedWind2() {
    return sueEstimatedWind2;
  }

  /**
   * Serial UDB Extra Magnetic Field Earth 0 
   */
  @MavlinkFieldInfo(
      position = 23,
      unitSize = 2
  )
  public final int sueMagfieldearth0() {
    return sueMagfieldearth0;
  }

  /**
   * Serial UDB Extra Magnetic Field Earth 1 
   */
  @MavlinkFieldInfo(
      position = 24,
      unitSize = 2
  )
  public final int sueMagfieldearth1() {
    return sueMagfieldearth1;
  }

  /**
   * Serial UDB Extra Magnetic Field Earth 2 
   */
  @MavlinkFieldInfo(
      position = 25,
      unitSize = 2
  )
  public final int sueMagfieldearth2() {
    return sueMagfieldearth2;
  }

  /**
   * Serial UDB Extra Number of Sattelites in View 
   */
  @MavlinkFieldInfo(
      position = 26,
      unitSize = 2
  )
  public final int sueSvs() {
    return sueSvs;
  }

  /**
   * Serial UDB Extra GPS Horizontal Dilution of Precision 
   */
  @MavlinkFieldInfo(
      position = 27,
      unitSize = 2
  )
  public final int sueHdop() {
    return sueHdop;
  }

  /**
   * Serial UDB Extra Status 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 1
  )
  public final int sueStatus() {
    return sueStatus;
  }

  public static class Builder {
    private long sueTime;

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

    private int sueStatus;

    private Builder() {
    }

    /**
     * Serial UDB Extra Time 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 4
    )
    public final Builder sueTime(long sueTime) {
      this.sueTime = sueTime;
      return this;
    }

    /**
     * Serial UDB Extra Latitude 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 4
    )
    public final Builder sueLatitude(int sueLatitude) {
      this.sueLatitude = sueLatitude;
      return this;
    }

    /**
     * Serial UDB Extra Longitude 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 4
    )
    public final Builder sueLongitude(int sueLongitude) {
      this.sueLongitude = sueLongitude;
      return this;
    }

    /**
     * Serial UDB Extra Altitude 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 4
    )
    public final Builder sueAltitude(int sueAltitude) {
      this.sueAltitude = sueAltitude;
      return this;
    }

    /**
     * Serial UDB Extra Waypoint Index 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 2
    )
    public final Builder sueWaypointIndex(int sueWaypointIndex) {
      this.sueWaypointIndex = sueWaypointIndex;
      return this;
    }

    /**
     * Serial UDB Extra Rmat 0 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 2
    )
    public final Builder sueRmat0(int sueRmat0) {
      this.sueRmat0 = sueRmat0;
      return this;
    }

    /**
     * Serial UDB Extra Rmat 1 
     */
    @MavlinkFieldInfo(
        position = 8,
        unitSize = 2
    )
    public final Builder sueRmat1(int sueRmat1) {
      this.sueRmat1 = sueRmat1;
      return this;
    }

    /**
     * Serial UDB Extra Rmat 2 
     */
    @MavlinkFieldInfo(
        position = 9,
        unitSize = 2
    )
    public final Builder sueRmat2(int sueRmat2) {
      this.sueRmat2 = sueRmat2;
      return this;
    }

    /**
     * Serial UDB Extra Rmat 3 
     */
    @MavlinkFieldInfo(
        position = 10,
        unitSize = 2
    )
    public final Builder sueRmat3(int sueRmat3) {
      this.sueRmat3 = sueRmat3;
      return this;
    }

    /**
     * Serial UDB Extra Rmat 4 
     */
    @MavlinkFieldInfo(
        position = 11,
        unitSize = 2
    )
    public final Builder sueRmat4(int sueRmat4) {
      this.sueRmat4 = sueRmat4;
      return this;
    }

    /**
     * Serial UDB Extra Rmat 5 
     */
    @MavlinkFieldInfo(
        position = 12,
        unitSize = 2
    )
    public final Builder sueRmat5(int sueRmat5) {
      this.sueRmat5 = sueRmat5;
      return this;
    }

    /**
     * Serial UDB Extra Rmat 6 
     */
    @MavlinkFieldInfo(
        position = 13,
        unitSize = 2
    )
    public final Builder sueRmat6(int sueRmat6) {
      this.sueRmat6 = sueRmat6;
      return this;
    }

    /**
     * Serial UDB Extra Rmat 7 
     */
    @MavlinkFieldInfo(
        position = 14,
        unitSize = 2
    )
    public final Builder sueRmat7(int sueRmat7) {
      this.sueRmat7 = sueRmat7;
      return this;
    }

    /**
     * Serial UDB Extra Rmat 8 
     */
    @MavlinkFieldInfo(
        position = 15,
        unitSize = 2
    )
    public final Builder sueRmat8(int sueRmat8) {
      this.sueRmat8 = sueRmat8;
      return this;
    }

    /**
     * Serial UDB Extra GPS Course Over Ground 
     */
    @MavlinkFieldInfo(
        position = 16,
        unitSize = 2
    )
    public final Builder sueCog(int sueCog) {
      this.sueCog = sueCog;
      return this;
    }

    /**
     * Serial UDB Extra Speed Over Ground 
     */
    @MavlinkFieldInfo(
        position = 17,
        unitSize = 2
    )
    public final Builder sueSog(int sueSog) {
      this.sueSog = sueSog;
      return this;
    }

    /**
     * Serial UDB Extra CPU Load 
     */
    @MavlinkFieldInfo(
        position = 18,
        unitSize = 2
    )
    public final Builder sueCpuLoad(int sueCpuLoad) {
      this.sueCpuLoad = sueCpuLoad;
      return this;
    }

    /**
     * Serial UDB Extra 3D IMU Air Speed 
     */
    @MavlinkFieldInfo(
        position = 19,
        unitSize = 2
    )
    public final Builder sueAirSpeed3dimu(int sueAirSpeed3dimu) {
      this.sueAirSpeed3dimu = sueAirSpeed3dimu;
      return this;
    }

    /**
     * Serial UDB Extra Estimated Wind 0 
     */
    @MavlinkFieldInfo(
        position = 20,
        unitSize = 2
    )
    public final Builder sueEstimatedWind0(int sueEstimatedWind0) {
      this.sueEstimatedWind0 = sueEstimatedWind0;
      return this;
    }

    /**
     * Serial UDB Extra Estimated Wind 1 
     */
    @MavlinkFieldInfo(
        position = 21,
        unitSize = 2
    )
    public final Builder sueEstimatedWind1(int sueEstimatedWind1) {
      this.sueEstimatedWind1 = sueEstimatedWind1;
      return this;
    }

    /**
     * Serial UDB Extra Estimated Wind 2 
     */
    @MavlinkFieldInfo(
        position = 22,
        unitSize = 2
    )
    public final Builder sueEstimatedWind2(int sueEstimatedWind2) {
      this.sueEstimatedWind2 = sueEstimatedWind2;
      return this;
    }

    /**
     * Serial UDB Extra Magnetic Field Earth 0 
     */
    @MavlinkFieldInfo(
        position = 23,
        unitSize = 2
    )
    public final Builder sueMagfieldearth0(int sueMagfieldearth0) {
      this.sueMagfieldearth0 = sueMagfieldearth0;
      return this;
    }

    /**
     * Serial UDB Extra Magnetic Field Earth 1 
     */
    @MavlinkFieldInfo(
        position = 24,
        unitSize = 2
    )
    public final Builder sueMagfieldearth1(int sueMagfieldearth1) {
      this.sueMagfieldearth1 = sueMagfieldearth1;
      return this;
    }

    /**
     * Serial UDB Extra Magnetic Field Earth 2 
     */
    @MavlinkFieldInfo(
        position = 25,
        unitSize = 2
    )
    public final Builder sueMagfieldearth2(int sueMagfieldearth2) {
      this.sueMagfieldearth2 = sueMagfieldearth2;
      return this;
    }

    /**
     * Serial UDB Extra Number of Sattelites in View 
     */
    @MavlinkFieldInfo(
        position = 26,
        unitSize = 2
    )
    public final Builder sueSvs(int sueSvs) {
      this.sueSvs = sueSvs;
      return this;
    }

    /**
     * Serial UDB Extra GPS Horizontal Dilution of Precision 
     */
    @MavlinkFieldInfo(
        position = 27,
        unitSize = 2
    )
    public final Builder sueHdop(int sueHdop) {
      this.sueHdop = sueHdop;
      return this;
    }

    /**
     * Serial UDB Extra Status 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 1
    )
    public final Builder sueStatus(int sueStatus) {
      this.sueStatus = sueStatus;
      return this;
    }

    public final SerialUdbExtraF2A build() {
      return new SerialUdbExtraF2A(sueTime, sueLatitude, sueLongitude, sueAltitude, sueWaypointIndex, sueRmat0, sueRmat1, sueRmat2, sueRmat3, sueRmat4, sueRmat5, sueRmat6, sueRmat7, sueRmat8, sueCog, sueSog, sueCpuLoad, sueAirSpeed3dimu, sueEstimatedWind0, sueEstimatedWind1, sueEstimatedWind2, sueMagfieldearth0, sueMagfieldearth1, sueMagfieldearth2, sueSvs, sueHdop, sueStatus);
    }
  }
}
