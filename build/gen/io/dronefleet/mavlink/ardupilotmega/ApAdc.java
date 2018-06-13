package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * raw ADC output 
 */
@MavlinkMessage(
    id = 153,
    crc = 188
)
public final class ApAdc {
  private final int adc1;

  private final int adc2;

  private final int adc3;

  private final int adc4;

  private final int adc5;

  private final int adc6;

  private ApAdc(int adc1, int adc2, int adc3, int adc4, int adc5, int adc6) {
    this.adc1 = adc1;
    this.adc2 = adc2;
    this.adc3 = adc3;
    this.adc4 = adc4;
    this.adc5 = adc5;
    this.adc6 = adc6;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * ADC output 1 
   */
  @MavlinkMessageField(
      position = 1,
      length = 2
  )
  public final int adc1() {
    return adc1;
  }

  /**
   * ADC output 2 
   */
  @MavlinkMessageField(
      position = 2,
      length = 2
  )
  public final int adc2() {
    return adc2;
  }

  /**
   * ADC output 3 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int adc3() {
    return adc3;
  }

  /**
   * ADC output 4 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int adc4() {
    return adc4;
  }

  /**
   * ADC output 5 
   */
  @MavlinkMessageField(
      position = 5,
      length = 2
  )
  public final int adc5() {
    return adc5;
  }

  /**
   * ADC output 6 
   */
  @MavlinkMessageField(
      position = 6,
      length = 2
  )
  public final int adc6() {
    return adc6;
  }

  public class Builder {
    private int adc1;

    private int adc2;

    private int adc3;

    private int adc4;

    private int adc5;

    private int adc6;

    private Builder() {
    }

    /**
     * ADC output 1 
     */
    @MavlinkMessageField(
        position = 1,
        length = 2
    )
    public final Builder adc1(int adc1) {
      this.adc1 = adc1;
      return this;
    }

    /**
     * ADC output 2 
     */
    @MavlinkMessageField(
        position = 2,
        length = 2
    )
    public final Builder adc2(int adc2) {
      this.adc2 = adc2;
      return this;
    }

    /**
     * ADC output 3 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder adc3(int adc3) {
      this.adc3 = adc3;
      return this;
    }

    /**
     * ADC output 4 
     */
    @MavlinkMessageField(
        position = 4,
        length = 2
    )
    public final Builder adc4(int adc4) {
      this.adc4 = adc4;
      return this;
    }

    /**
     * ADC output 5 
     */
    @MavlinkMessageField(
        position = 5,
        length = 2
    )
    public final Builder adc5(int adc5) {
      this.adc5 = adc5;
      return this;
    }

    /**
     * ADC output 6 
     */
    @MavlinkMessageField(
        position = 6,
        length = 2
    )
    public final Builder adc6(int adc6) {
      this.adc6 = adc6;
      return this;
    }

    public final ApAdc build() {
      return new ApAdc(adc1, adc2, adc3, adc4, adc5, adc6);
    }
  }
}
