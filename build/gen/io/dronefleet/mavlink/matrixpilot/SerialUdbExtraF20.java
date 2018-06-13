package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F20 format 
 */
@MavlinkMessage(
    id = 186,
    crc = 144
)
public final class SerialUdbExtraF20 {
  private final int sueNumberOfInputs;

  private final int sueTrimValueInput1;

  private final int sueTrimValueInput2;

  private final int sueTrimValueInput3;

  private final int sueTrimValueInput4;

  private final int sueTrimValueInput5;

  private final int sueTrimValueInput6;

  private final int sueTrimValueInput7;

  private final int sueTrimValueInput8;

  private final int sueTrimValueInput9;

  private final int sueTrimValueInput10;

  private final int sueTrimValueInput11;

  private final int sueTrimValueInput12;

  private SerialUdbExtraF20(int sueNumberOfInputs, int sueTrimValueInput1, int sueTrimValueInput2,
      int sueTrimValueInput3, int sueTrimValueInput4, int sueTrimValueInput5,
      int sueTrimValueInput6, int sueTrimValueInput7, int sueTrimValueInput8,
      int sueTrimValueInput9, int sueTrimValueInput10, int sueTrimValueInput11,
      int sueTrimValueInput12) {
    this.sueNumberOfInputs = sueNumberOfInputs;
    this.sueTrimValueInput1 = sueTrimValueInput1;
    this.sueTrimValueInput2 = sueTrimValueInput2;
    this.sueTrimValueInput3 = sueTrimValueInput3;
    this.sueTrimValueInput4 = sueTrimValueInput4;
    this.sueTrimValueInput5 = sueTrimValueInput5;
    this.sueTrimValueInput6 = sueTrimValueInput6;
    this.sueTrimValueInput7 = sueTrimValueInput7;
    this.sueTrimValueInput8 = sueTrimValueInput8;
    this.sueTrimValueInput9 = sueTrimValueInput9;
    this.sueTrimValueInput10 = sueTrimValueInput10;
    this.sueTrimValueInput11 = sueTrimValueInput11;
    this.sueTrimValueInput12 = sueTrimValueInput12;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * SUE Number of Input Channels 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final int sueNumberOfInputs() {
    return sueNumberOfInputs;
  }

  /**
   * SUE UDB PWM Trim Value on Input 1 
   */
  @MavlinkMessageField(
      position = 2,
      length = 2
  )
  public final int sueTrimValueInput1() {
    return sueTrimValueInput1;
  }

  /**
   * SUE UDB PWM Trim Value on Input 2 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int sueTrimValueInput2() {
    return sueTrimValueInput2;
  }

  /**
   * SUE UDB PWM Trim Value on Input 3 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int sueTrimValueInput3() {
    return sueTrimValueInput3;
  }

  /**
   * SUE UDB PWM Trim Value on Input 4 
   */
  @MavlinkMessageField(
      position = 5,
      length = 2
  )
  public final int sueTrimValueInput4() {
    return sueTrimValueInput4;
  }

  /**
   * SUE UDB PWM Trim Value on Input 5 
   */
  @MavlinkMessageField(
      position = 6,
      length = 2
  )
  public final int sueTrimValueInput5() {
    return sueTrimValueInput5;
  }

  /**
   * SUE UDB PWM Trim Value on Input 6 
   */
  @MavlinkMessageField(
      position = 7,
      length = 2
  )
  public final int sueTrimValueInput6() {
    return sueTrimValueInput6;
  }

  /**
   * SUE UDB PWM Trim Value on Input 7 
   */
  @MavlinkMessageField(
      position = 8,
      length = 2
  )
  public final int sueTrimValueInput7() {
    return sueTrimValueInput7;
  }

  /**
   * SUE UDB PWM Trim Value on Input 8 
   */
  @MavlinkMessageField(
      position = 9,
      length = 2
  )
  public final int sueTrimValueInput8() {
    return sueTrimValueInput8;
  }

  /**
   * SUE UDB PWM Trim Value on Input 9 
   */
  @MavlinkMessageField(
      position = 10,
      length = 2
  )
  public final int sueTrimValueInput9() {
    return sueTrimValueInput9;
  }

  /**
   * SUE UDB PWM Trim Value on Input 10 
   */
  @MavlinkMessageField(
      position = 11,
      length = 2
  )
  public final int sueTrimValueInput10() {
    return sueTrimValueInput10;
  }

  /**
   * SUE UDB PWM Trim Value on Input 11 
   */
  @MavlinkMessageField(
      position = 12,
      length = 2
  )
  public final int sueTrimValueInput11() {
    return sueTrimValueInput11;
  }

  /**
   * SUE UDB PWM Trim Value on Input 12 
   */
  @MavlinkMessageField(
      position = 13,
      length = 2
  )
  public final int sueTrimValueInput12() {
    return sueTrimValueInput12;
  }

  public class Builder {
    private int sueNumberOfInputs;

    private int sueTrimValueInput1;

    private int sueTrimValueInput2;

    private int sueTrimValueInput3;

    private int sueTrimValueInput4;

    private int sueTrimValueInput5;

    private int sueTrimValueInput6;

    private int sueTrimValueInput7;

    private int sueTrimValueInput8;

    private int sueTrimValueInput9;

    private int sueTrimValueInput10;

    private int sueTrimValueInput11;

    private int sueTrimValueInput12;

    private Builder() {
    }

    /**
     * SUE Number of Input Channels 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder sueNumberOfInputs(int sueNumberOfInputs) {
      this.sueNumberOfInputs = sueNumberOfInputs;
      return this;
    }

    /**
     * SUE UDB PWM Trim Value on Input 1 
     */
    @MavlinkMessageField(
        position = 2,
        length = 2
    )
    public final Builder sueTrimValueInput1(int sueTrimValueInput1) {
      this.sueTrimValueInput1 = sueTrimValueInput1;
      return this;
    }

    /**
     * SUE UDB PWM Trim Value on Input 2 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder sueTrimValueInput2(int sueTrimValueInput2) {
      this.sueTrimValueInput2 = sueTrimValueInput2;
      return this;
    }

    /**
     * SUE UDB PWM Trim Value on Input 3 
     */
    @MavlinkMessageField(
        position = 4,
        length = 2
    )
    public final Builder sueTrimValueInput3(int sueTrimValueInput3) {
      this.sueTrimValueInput3 = sueTrimValueInput3;
      return this;
    }

    /**
     * SUE UDB PWM Trim Value on Input 4 
     */
    @MavlinkMessageField(
        position = 5,
        length = 2
    )
    public final Builder sueTrimValueInput4(int sueTrimValueInput4) {
      this.sueTrimValueInput4 = sueTrimValueInput4;
      return this;
    }

    /**
     * SUE UDB PWM Trim Value on Input 5 
     */
    @MavlinkMessageField(
        position = 6,
        length = 2
    )
    public final Builder sueTrimValueInput5(int sueTrimValueInput5) {
      this.sueTrimValueInput5 = sueTrimValueInput5;
      return this;
    }

    /**
     * SUE UDB PWM Trim Value on Input 6 
     */
    @MavlinkMessageField(
        position = 7,
        length = 2
    )
    public final Builder sueTrimValueInput6(int sueTrimValueInput6) {
      this.sueTrimValueInput6 = sueTrimValueInput6;
      return this;
    }

    /**
     * SUE UDB PWM Trim Value on Input 7 
     */
    @MavlinkMessageField(
        position = 8,
        length = 2
    )
    public final Builder sueTrimValueInput7(int sueTrimValueInput7) {
      this.sueTrimValueInput7 = sueTrimValueInput7;
      return this;
    }

    /**
     * SUE UDB PWM Trim Value on Input 8 
     */
    @MavlinkMessageField(
        position = 9,
        length = 2
    )
    public final Builder sueTrimValueInput8(int sueTrimValueInput8) {
      this.sueTrimValueInput8 = sueTrimValueInput8;
      return this;
    }

    /**
     * SUE UDB PWM Trim Value on Input 9 
     */
    @MavlinkMessageField(
        position = 10,
        length = 2
    )
    public final Builder sueTrimValueInput9(int sueTrimValueInput9) {
      this.sueTrimValueInput9 = sueTrimValueInput9;
      return this;
    }

    /**
     * SUE UDB PWM Trim Value on Input 10 
     */
    @MavlinkMessageField(
        position = 11,
        length = 2
    )
    public final Builder sueTrimValueInput10(int sueTrimValueInput10) {
      this.sueTrimValueInput10 = sueTrimValueInput10;
      return this;
    }

    /**
     * SUE UDB PWM Trim Value on Input 11 
     */
    @MavlinkMessageField(
        position = 12,
        length = 2
    )
    public final Builder sueTrimValueInput11(int sueTrimValueInput11) {
      this.sueTrimValueInput11 = sueTrimValueInput11;
      return this;
    }

    /**
     * SUE UDB PWM Trim Value on Input 12 
     */
    @MavlinkMessageField(
        position = 13,
        length = 2
    )
    public final Builder sueTrimValueInput12(int sueTrimValueInput12) {
      this.sueTrimValueInput12 = sueTrimValueInput12;
      return this;
    }

    public final SerialUdbExtraF20 build() {
      return new SerialUdbExtraF20(sueNumberOfInputs, sueTrimValueInput1, sueTrimValueInput2, sueTrimValueInput3, sueTrimValueInput4, sueTrimValueInput5, sueTrimValueInput6, sueTrimValueInput7, sueTrimValueInput8, sueTrimValueInput9, sueTrimValueInput10, sueTrimValueInput11, sueTrimValueInput12);
    }
  }
}
