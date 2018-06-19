package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Voltage and current sensor data 
 */
@MavlinkMessage(
    id = 201,
    crc = 218
)
public final class SensPower {
  /**
   * Power board voltage sensor reading 
   */
  private final float adc121VspbVolt;

  /**
   * Power board current sensor reading 
   */
  private final float adc121CspbAmp;

  /**
   * Board current sensor 1 reading 
   */
  private final float adc121Cs1Amp;

  /**
   * Board current sensor 2 reading 
   */
  private final float adc121Cs2Amp;

  private SensPower(float adc121VspbVolt, float adc121CspbAmp, float adc121Cs1Amp,
      float adc121Cs2Amp) {
    this.adc121VspbVolt = adc121VspbVolt;
    this.adc121CspbAmp = adc121CspbAmp;
    this.adc121Cs1Amp = adc121Cs1Amp;
    this.adc121Cs2Amp = adc121Cs2Amp;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "SensPower{adc121VspbVolt=" + adc121VspbVolt
         + ", adc121CspbAmp=" + adc121CspbAmp
         + ", adc121Cs1Amp=" + adc121Cs1Amp
         + ", adc121Cs2Amp=" + adc121Cs2Amp + "}";
  }

  /**
   * Power board voltage sensor reading 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 4
  )
  public final float adc121VspbVolt() {
    return adc121VspbVolt;
  }

  /**
   * Power board current sensor reading 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 4
  )
  public final float adc121CspbAmp() {
    return adc121CspbAmp;
  }

  /**
   * Board current sensor 1 reading 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 4
  )
  public final float adc121Cs1Amp() {
    return adc121Cs1Amp;
  }

  /**
   * Board current sensor 2 reading 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 4
  )
  public final float adc121Cs2Amp() {
    return adc121Cs2Amp;
  }

  public static class Builder {
    private float adc121VspbVolt;

    private float adc121CspbAmp;

    private float adc121Cs1Amp;

    private float adc121Cs2Amp;

    private Builder() {
    }

    /**
     * Power board voltage sensor reading 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 4
    )
    public final Builder adc121VspbVolt(float adc121VspbVolt) {
      this.adc121VspbVolt = adc121VspbVolt;
      return this;
    }

    /**
     * Power board current sensor reading 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 4
    )
    public final Builder adc121CspbAmp(float adc121CspbAmp) {
      this.adc121CspbAmp = adc121CspbAmp;
      return this;
    }

    /**
     * Board current sensor 1 reading 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 4
    )
    public final Builder adc121Cs1Amp(float adc121Cs1Amp) {
      this.adc121Cs1Amp = adc121Cs1Amp;
      return this;
    }

    /**
     * Board current sensor 2 reading 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 4
    )
    public final Builder adc121Cs2Amp(float adc121Cs2Amp) {
      this.adc121Cs2Amp = adc121Cs2Amp;
      return this;
    }

    public final SensPower build() {
      return new SensPower(adc121VspbVolt, adc121CspbAmp, adc121Cs1Amp, adc121Cs2Amp);
    }
  }
}
