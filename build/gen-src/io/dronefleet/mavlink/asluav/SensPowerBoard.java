package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.math.BigInteger;

/**
 * Monitoring of power board status 
 */
@MavlinkMessage(
    id = 212,
    crc = 222
)
public final class SensPowerBoard {
  private final BigInteger timestamp;

  private final int pwrBrdStatus;

  private final int pwrBrdLedStatus;

  private final float pwrBrdSystemVolt;

  private final float pwrBrdServoVolt;

  private final float pwrBrdDigitalVolt;

  private final float pwrBrdMotLAmp;

  private final float pwrBrdMotRAmp;

  private final float pwrBrdAnalogAmp;

  private final float pwrBrdDigitalAmp;

  private final float pwrBrdExtAmp;

  private final float pwrBrdAuxAmp;

  private SensPowerBoard(BigInteger timestamp, int pwrBrdStatus, int pwrBrdLedStatus,
      float pwrBrdSystemVolt, float pwrBrdServoVolt, float pwrBrdDigitalVolt, float pwrBrdMotLAmp,
      float pwrBrdMotRAmp, float pwrBrdAnalogAmp, float pwrBrdDigitalAmp, float pwrBrdExtAmp,
      float pwrBrdAuxAmp) {
    this.timestamp = timestamp;
    this.pwrBrdStatus = pwrBrdStatus;
    this.pwrBrdLedStatus = pwrBrdLedStatus;
    this.pwrBrdSystemVolt = pwrBrdSystemVolt;
    this.pwrBrdServoVolt = pwrBrdServoVolt;
    this.pwrBrdDigitalVolt = pwrBrdDigitalVolt;
    this.pwrBrdMotLAmp = pwrBrdMotLAmp;
    this.pwrBrdMotRAmp = pwrBrdMotRAmp;
    this.pwrBrdAnalogAmp = pwrBrdAnalogAmp;
    this.pwrBrdDigitalAmp = pwrBrdDigitalAmp;
    this.pwrBrdExtAmp = pwrBrdExtAmp;
    this.pwrBrdAuxAmp = pwrBrdAuxAmp;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp 
   */
  @MavlinkMessageField(
      position = 1,
      length = 8
  )
  public final BigInteger timestamp() {
    return timestamp;
  }

  /**
   * Power board status register 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int pwrBrdStatus() {
    return pwrBrdStatus;
  }

  /**
   * Power board leds status 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final int pwrBrdLedStatus() {
    return pwrBrdLedStatus;
  }

  /**
   * Power board system voltage 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float pwrBrdSystemVolt() {
    return pwrBrdSystemVolt;
  }

  /**
   * Power board servo voltage 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float pwrBrdServoVolt() {
    return pwrBrdServoVolt;
  }

  /**
   * Power board digital voltage 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float pwrBrdDigitalVolt() {
    return pwrBrdDigitalVolt;
  }

  /**
   * Power board left motor current sensor 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float pwrBrdMotLAmp() {
    return pwrBrdMotLAmp;
  }

  /**
   * Power board right motor current sensor 
   */
  @MavlinkMessageField(
      position = 8,
      length = 4
  )
  public final float pwrBrdMotRAmp() {
    return pwrBrdMotRAmp;
  }

  /**
   * Power board analog current sensor 
   */
  @MavlinkMessageField(
      position = 9,
      length = 4
  )
  public final float pwrBrdAnalogAmp() {
    return pwrBrdAnalogAmp;
  }

  /**
   * Power board digital current sensor 
   */
  @MavlinkMessageField(
      position = 10,
      length = 4
  )
  public final float pwrBrdDigitalAmp() {
    return pwrBrdDigitalAmp;
  }

  /**
   * Power board extension current sensor 
   */
  @MavlinkMessageField(
      position = 11,
      length = 4
  )
  public final float pwrBrdExtAmp() {
    return pwrBrdExtAmp;
  }

  /**
   * Power board aux current sensor 
   */
  @MavlinkMessageField(
      position = 12,
      length = 4
  )
  public final float pwrBrdAuxAmp() {
    return pwrBrdAuxAmp;
  }

  public class Builder {
    private BigInteger timestamp;

    private int pwrBrdStatus;

    private int pwrBrdLedStatus;

    private float pwrBrdSystemVolt;

    private float pwrBrdServoVolt;

    private float pwrBrdDigitalVolt;

    private float pwrBrdMotLAmp;

    private float pwrBrdMotRAmp;

    private float pwrBrdAnalogAmp;

    private float pwrBrdDigitalAmp;

    private float pwrBrdExtAmp;

    private float pwrBrdAuxAmp;

    private Builder() {
    }

    /**
     * Timestamp 
     */
    @MavlinkMessageField(
        position = 1,
        length = 8
    )
    public final Builder timestamp(BigInteger timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    /**
     * Power board status register 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
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
        length = 1
    )
    public final Builder pwrBrdLedStatus(int pwrBrdLedStatus) {
      this.pwrBrdLedStatus = pwrBrdLedStatus;
      return this;
    }

    /**
     * Power board system voltage 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
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
        length = 4
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
        length = 4
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
        length = 4
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
        length = 4
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
        length = 4
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
        length = 4
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
        length = 4
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
        length = 4
    )
    public final Builder pwrBrdAuxAmp(float pwrBrdAuxAmp) {
      this.pwrBrdAuxAmp = pwrBrdAuxAmp;
      return this;
    }

    public final SensPowerBoard build() {
      return new SensPowerBoard(timestamp, pwrBrdStatus, pwrBrdLedStatus, pwrBrdSystemVolt, pwrBrdServoVolt, pwrBrdDigitalVolt, pwrBrdMotLAmp, pwrBrdMotRAmp, pwrBrdAnalogAmp, pwrBrdDigitalAmp, pwrBrdExtAmp, pwrBrdAuxAmp);
    }
  }
}
