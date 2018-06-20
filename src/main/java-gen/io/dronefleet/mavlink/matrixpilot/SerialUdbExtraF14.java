package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F14: format 
 */
@MavlinkMessageInfo(
    id = 178,
    crc = 123
)
public final class SerialUdbExtraF14 {
  /**
   * Serial UDB Extra Type Program Address of Last Trap 
   */
  private final long sueTrapSource;

  /**
   * Serial UDB Extra Reboot Register of DSPIC 
   */
  private final int sueRcon;

  /**
   * Serial UDB Extra Last dspic Trap Flags 
   */
  private final int sueTrapFlags;

  /**
   * Serial UDB Extra Number of Ocillator Failures 
   */
  private final int sueOscFailCount;

  /**
   * Serial UDB Extra Wind Estimation Enabled 
   */
  private final int sueWindEstimation;

  /**
   * Serial UDB Extra Type of GPS Unit 
   */
  private final int sueGpsType;

  /**
   * Serial UDB Extra Dead Reckoning Enabled 
   */
  private final int sueDr;

  /**
   * Serial UDB Extra Type of UDB Hardware 
   */
  private final int sueBoardType;

  /**
   * Serial UDB Extra Type of Airframe 
   */
  private final int sueAirframe;

  /**
   * Serial UDB Extra UDB Internal Clock Configuration 
   */
  private final int sueClockConfig;

  /**
   * Serial UDB Extra Type of Flight Plan 
   */
  private final int sueFlightPlanType;

  private SerialUdbExtraF14(long sueTrapSource, int sueRcon, int sueTrapFlags, int sueOscFailCount,
      int sueWindEstimation, int sueGpsType, int sueDr, int sueBoardType, int sueAirframe,
      int sueClockConfig, int sueFlightPlanType) {
    this.sueTrapSource = sueTrapSource;
    this.sueRcon = sueRcon;
    this.sueTrapFlags = sueTrapFlags;
    this.sueOscFailCount = sueOscFailCount;
    this.sueWindEstimation = sueWindEstimation;
    this.sueGpsType = sueGpsType;
    this.sueDr = sueDr;
    this.sueBoardType = sueBoardType;
    this.sueAirframe = sueAirframe;
    this.sueClockConfig = sueClockConfig;
    this.sueFlightPlanType = sueFlightPlanType;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "SerialUdbExtraF14{sueWindEstimation=" + sueWindEstimation
         + ", sueGpsType=" + sueGpsType
         + ", sueDr=" + sueDr
         + ", sueBoardType=" + sueBoardType
         + ", sueAirframe=" + sueAirframe
         + ", sueRcon=" + sueRcon
         + ", sueTrapFlags=" + sueTrapFlags
         + ", sueTrapSource=" + sueTrapSource
         + ", sueOscFailCount=" + sueOscFailCount
         + ", sueClockConfig=" + sueClockConfig
         + ", sueFlightPlanType=" + sueFlightPlanType + "}";
  }

  /**
   * Serial UDB Extra Type Program Address of Last Trap 
   */
  @MavlinkFieldInfo(
      position = 8,
      unitSize = 4
  )
  public final long sueTrapSource() {
    return sueTrapSource;
  }

  /**
   * Serial UDB Extra Reboot Register of DSPIC 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 2
  )
  public final int sueRcon() {
    return sueRcon;
  }

  /**
   * Serial UDB Extra Last dspic Trap Flags 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 2
  )
  public final int sueTrapFlags() {
    return sueTrapFlags;
  }

  /**
   * Serial UDB Extra Number of Ocillator Failures 
   */
  @MavlinkFieldInfo(
      position = 9,
      unitSize = 2
  )
  public final int sueOscFailCount() {
    return sueOscFailCount;
  }

  /**
   * Serial UDB Extra Wind Estimation Enabled 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 1
  )
  public final int sueWindEstimation() {
    return sueWindEstimation;
  }

  /**
   * Serial UDB Extra Type of GPS Unit 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 1
  )
  public final int sueGpsType() {
    return sueGpsType;
  }

  /**
   * Serial UDB Extra Dead Reckoning Enabled 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 1
  )
  public final int sueDr() {
    return sueDr;
  }

  /**
   * Serial UDB Extra Type of UDB Hardware 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 1
  )
  public final int sueBoardType() {
    return sueBoardType;
  }

  /**
   * Serial UDB Extra Type of Airframe 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 1
  )
  public final int sueAirframe() {
    return sueAirframe;
  }

  /**
   * Serial UDB Extra UDB Internal Clock Configuration 
   */
  @MavlinkFieldInfo(
      position = 10,
      unitSize = 1
  )
  public final int sueClockConfig() {
    return sueClockConfig;
  }

  /**
   * Serial UDB Extra Type of Flight Plan 
   */
  @MavlinkFieldInfo(
      position = 11,
      unitSize = 1
  )
  public final int sueFlightPlanType() {
    return sueFlightPlanType;
  }

  public static class Builder {
    private long sueTrapSource;

    private int sueRcon;

    private int sueTrapFlags;

    private int sueOscFailCount;

    private int sueWindEstimation;

    private int sueGpsType;

    private int sueDr;

    private int sueBoardType;

    private int sueAirframe;

    private int sueClockConfig;

    private int sueFlightPlanType;

    private Builder() {
    }

    /**
     * Serial UDB Extra Type Program Address of Last Trap 
     */
    @MavlinkFieldInfo(
        position = 8,
        unitSize = 4
    )
    public final Builder sueTrapSource(long sueTrapSource) {
      this.sueTrapSource = sueTrapSource;
      return this;
    }

    /**
     * Serial UDB Extra Reboot Register of DSPIC 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 2
    )
    public final Builder sueRcon(int sueRcon) {
      this.sueRcon = sueRcon;
      return this;
    }

    /**
     * Serial UDB Extra Last dspic Trap Flags 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 2
    )
    public final Builder sueTrapFlags(int sueTrapFlags) {
      this.sueTrapFlags = sueTrapFlags;
      return this;
    }

    /**
     * Serial UDB Extra Number of Ocillator Failures 
     */
    @MavlinkFieldInfo(
        position = 9,
        unitSize = 2
    )
    public final Builder sueOscFailCount(int sueOscFailCount) {
      this.sueOscFailCount = sueOscFailCount;
      return this;
    }

    /**
     * Serial UDB Extra Wind Estimation Enabled 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 1
    )
    public final Builder sueWindEstimation(int sueWindEstimation) {
      this.sueWindEstimation = sueWindEstimation;
      return this;
    }

    /**
     * Serial UDB Extra Type of GPS Unit 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 1
    )
    public final Builder sueGpsType(int sueGpsType) {
      this.sueGpsType = sueGpsType;
      return this;
    }

    /**
     * Serial UDB Extra Dead Reckoning Enabled 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 1
    )
    public final Builder sueDr(int sueDr) {
      this.sueDr = sueDr;
      return this;
    }

    /**
     * Serial UDB Extra Type of UDB Hardware 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 1
    )
    public final Builder sueBoardType(int sueBoardType) {
      this.sueBoardType = sueBoardType;
      return this;
    }

    /**
     * Serial UDB Extra Type of Airframe 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 1
    )
    public final Builder sueAirframe(int sueAirframe) {
      this.sueAirframe = sueAirframe;
      return this;
    }

    /**
     * Serial UDB Extra UDB Internal Clock Configuration 
     */
    @MavlinkFieldInfo(
        position = 10,
        unitSize = 1
    )
    public final Builder sueClockConfig(int sueClockConfig) {
      this.sueClockConfig = sueClockConfig;
      return this;
    }

    /**
     * Serial UDB Extra Type of Flight Plan 
     */
    @MavlinkFieldInfo(
        position = 11,
        unitSize = 1
    )
    public final Builder sueFlightPlanType(int sueFlightPlanType) {
      this.sueFlightPlanType = sueFlightPlanType;
      return this;
    }

    public final SerialUdbExtraF14 build() {
      return new SerialUdbExtraF14(sueTrapSource, sueRcon, sueTrapFlags, sueOscFailCount, sueWindEstimation, sueGpsType, sueDr, sueBoardType, sueAirframe, sueClockConfig, sueFlightPlanType);
    }
  }
}
