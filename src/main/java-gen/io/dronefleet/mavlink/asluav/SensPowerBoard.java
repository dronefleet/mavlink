package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;

/**
 * Monitoring of power board status 
 */
@MavlinkMessage(
    id = 212,
    crc = 222
)
public final class SensPowerBoard {
  /**
   * Timestamp 
   */
  private final BigInteger timestamp;

  /**
   * Power board system voltage 
   */
  private final float pwrBrdSystemVolt;

  /**
   * Power board servo voltage 
   */
  private final float pwrBrdServoVolt;

  /**
   * Power board digital voltage 
   */
  private final float pwrBrdDigitalVolt;

  /**
   * Power board left motor current sensor 
   */
  private final float pwrBrdMotLAmp;

  /**
   * Power board right motor current sensor 
   */
  private final float pwrBrdMotRAmp;

  /**
   * Power board analog current sensor 
   */
  private final float pwrBrdAnalogAmp;

  /**
   * Power board digital current sensor 
   */
  private final float pwrBrdDigitalAmp;

  /**
   * Power board extension current sensor 
   */
  private final float pwrBrdExtAmp;

  /**
   * Power board aux current sensor 
   */
  private final float pwrBrdAuxAmp;

  /**
   * Power board status register 
   */
  private final int pwrBrdStatus;

  /**
   * Power board leds status 
   */
  private final int pwrBrdLedStatus;

  private SensPowerBoard(BigInteger timestamp, float pwrBrdSystemVolt, float pwrBrdServoVolt,
      float pwrBrdDigitalVolt, float pwrBrdMotLAmp, float pwrBrdMotRAmp, float pwrBrdAnalogAmp,
      float pwrBrdDigitalAmp, float pwrBrdExtAmp, float pwrBrdAuxAmp, int pwrBrdStatus,
      int pwrBrdLedStatus) {
    this.timestamp = timestamp;
    this.pwrBrdSystemVolt = pwrBrdSystemVolt;
    this.pwrBrdServoVolt = pwrBrdServoVolt;
    this.pwrBrdDigitalVolt = pwrBrdDigitalVolt;
    this.pwrBrdMotLAmp = pwrBrdMotLAmp;
    this.pwrBrdMotRAmp = pwrBrdMotRAmp;
    this.pwrBrdAnalogAmp = pwrBrdAnalogAmp;
    this.pwrBrdDigitalAmp = pwrBrdDigitalAmp;
    this.pwrBrdExtAmp = pwrBrdExtAmp;
    this.pwrBrdAuxAmp = pwrBrdAuxAmp;
    this.pwrBrdStatus = pwrBrdStatus;
    this.pwrBrdLedStatus = pwrBrdLedStatus;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "SensPowerBoard{timestamp=" + timestamp
         + ", pwrBrdStatus=" + pwrBrdStatus
         + ", pwrBrdLedStatus=" + pwrBrdLedStatus
         + ", pwrBrdSystemVolt=" + pwrBrdSystemVolt
         + ", pwrBrdServoVolt=" + pwrBrdServoVolt
         + ", pwrBrdDigitalVolt=" + pwrBrdDigitalVolt
         + ", pwrBrdMotLAmp=" + pwrBrdMotLAmp
         + ", pwrBrdMotRAmp=" + pwrBrdMotRAmp
         + ", pwrBrdAnalogAmp=" + pwrBrdAnalogAmp
         + ", pwrBrdDigitalAmp=" + pwrBrdDigitalAmp
         + ", pwrBrdExtAmp=" + pwrBrdExtAmp
         + ", pwrBrdAuxAmp=" + pwrBrdAuxAmp + "}";
  }

  /**
   * Timestamp 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 8
  )
  public final BigInteger timestamp() {
    return timestamp;
  }

  /**
   * Power board system voltage 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 4
  )
  public final float pwrBrdSystemVolt() {
    return pwrBrdSystemVolt;
  }

  /**
   * Power board servo voltage 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 4
  )
  public final float pwrBrdServoVolt() {
    return pwrBrdServoVolt;
  }

  /**
   * Power board digital voltage 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 4
  )
  public final float pwrBrdDigitalVolt() {
    return pwrBrdDigitalVolt;
  }

  /**
   * Power board left motor current sensor 
   */
  @MavlinkMessageField(
      position = 7,
      unitSize = 4
  )
  public final float pwrBrdMotLAmp() {
    return pwrBrdMotLAmp;
  }

  /**
   * Power board right motor current sensor 
   */
  @MavlinkMessageField(
      position = 8,
      unitSize = 4
  )
  public final float pwrBrdMotRAmp() {
    return pwrBrdMotRAmp;
  }

  /**
   * Power board analog current sensor 
   */
  @MavlinkMessageField(
      position = 9,
      unitSize = 4
  )
  public final float pwrBrdAnalogAmp() {
    return pwrBrdAnalogAmp;
  }

  /**
   * Power board digital current sensor 
   */
  @MavlinkMessageField(
      position = 10,
      unitSize = 4
  )
  public final float pwrBrdDigitalAmp() {
    return pwrBrdDigitalAmp;
  }

  /**
   * Power board extension current sensor 
   */
  @MavlinkMessageField(
      position = 11,
      unitSize = 4
  )
  public final float pwrBrdExtAmp() {
    return pwrBrdExtAmp;
  }

  /**
   * Power board aux current sensor 
   */
  @MavlinkMessageField(
      position = 12,
      unitSize = 4
  )
  public final float pwrBrdAuxAmp() {
    return pwrBrdAuxAmp;
  }

  /**
   * Power board status register 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 1
  )
  public final int pwrBrdStatus() {
    return pwrBrdStatus;
  }

  /**
   * Power board leds status 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 1
  )
  public final int pwrBrdLedStatus() {
    return pwrBrdLedStatus;
  }

  public static class Builder {
    private BigInteger timestamp;

    private float pwrBrdSystemVolt;

    private float pwrBrdServoVolt;

    private float pwrBrdDigitalVolt;

    private float pwrBrdMotLAmp;

    private float pwrBrdMotRAmp;

    private float pwrBrdAnalogAmp;

    private float pwrBrdDigitalAmp;

    private float pwrBrdExtAmp;

    private float pwrBrdAuxAmp;

    private int pwrBrdStatus;

    private int pwrBrdLedStatus;

    private Builder() {
    }

    /**
     * Timestamp 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 8
    )
    public final Builder timestamp(BigInteger timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    /**
     * Power board system voltage 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 4
    )
    public final Builder pwrBrdSystemVolt(float pwrBrdSystemVolt) {
      this.pwrBrdSystemVolt = pwrBrdSystemVolt;
      return this;
    }

    /**
     * Power board servo voltage 
     */
    @MavlinkMessageField(
        position = 5,
        unitSize = 4
    )
    public final Builder pwrBrdServoVolt(float pwrBrdServoVolt) {
      this.pwrBrdServoVolt = pwrBrdServoVolt;
      return this;
    }

    /**
     * Power board digital voltage 
     */
    @MavlinkMessageField(
        position = 6,
        unitSize = 4
    )
    public final Builder pwrBrdDigitalVolt(float pwrBrdDigitalVolt) {
      this.pwrBrdDigitalVolt = pwrBrdDigitalVolt;
      return this;
    }

    /**
     * Power board left motor current sensor 
     */
    @MavlinkMessageField(
        position = 7,
        unitSize = 4
    )
    public final Builder pwrBrdMotLAmp(float pwrBrdMotLAmp) {
      this.pwrBrdMotLAmp = pwrBrdMotLAmp;
      return this;
    }

    /**
     * Power board right motor current sensor 
     */
    @MavlinkMessageField(
        position = 8,
        unitSize = 4
    )
    public final Builder pwrBrdMotRAmp(float pwrBrdMotRAmp) {
      this.pwrBrdMotRAmp = pwrBrdMotRAmp;
      return this;
    }

    /**
     * Power board analog current sensor 
     */
    @MavlinkMessageField(
        position = 9,
        unitSize = 4
    )
    public final Builder pwrBrdAnalogAmp(float pwrBrdAnalogAmp) {
      this.pwrBrdAnalogAmp = pwrBrdAnalogAmp;
      return this;
    }

    /**
     * Power board digital current sensor 
     */
    @MavlinkMessageField(
        position = 10,
        unitSize = 4
    )
    public final Builder pwrBrdDigitalAmp(float pwrBrdDigitalAmp) {
      this.pwrBrdDigitalAmp = pwrBrdDigitalAmp;
      return this;
    }

    /**
     * Power board extension current sensor 
     */
    @MavlinkMessageField(
        position = 11,
        unitSize = 4
    )
    public final Builder pwrBrdExtAmp(float pwrBrdExtAmp) {
      this.pwrBrdExtAmp = pwrBrdExtAmp;
      return this;
    }

    /**
     * Power board aux current sensor 
     */
    @MavlinkMessageField(
        position = 12,
        unitSize = 4
    )
    public final Builder pwrBrdAuxAmp(float pwrBrdAuxAmp) {
      this.pwrBrdAuxAmp = pwrBrdAuxAmp;
      return this;
    }

    /**
     * Power board status register 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 1
    )
    public final Builder pwrBrdStatus(int pwrBrdStatus) {
      this.pwrBrdStatus = pwrBrdStatus;
      return this;
    }

    /**
     * Power board leds status 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 1
    )
    public final Builder pwrBrdLedStatus(int pwrBrdLedStatus) {
      this.pwrBrdLedStatus = pwrBrdLedStatus;
      return this;
    }

    public final SensPowerBoard build() {
      return new SensPowerBoard(timestamp, pwrBrdSystemVolt, pwrBrdServoVolt, pwrBrdDigitalVolt, pwrBrdMotLAmp, pwrBrdMotRAmp, pwrBrdAnalogAmp, pwrBrdDigitalAmp, pwrBrdExtAmp, pwrBrdAuxAmp, pwrBrdStatus, pwrBrdLedStatus);
    }
  }
}
