package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F20 format 
 */
@MavlinkMessageInfo(
    id = 186,
    crc = 144
)
public final class SerialUdbExtraF20 {
  /**
   * SUE UDB PWM Trim Value on Input 1 
   */
  private final int sueTrimValueInput1;

  /**
   * SUE UDB PWM Trim Value on Input 2 
   */
  private final int sueTrimValueInput2;

  /**
   * SUE UDB PWM Trim Value on Input 3 
   */
  private final int sueTrimValueInput3;

  /**
   * SUE UDB PWM Trim Value on Input 4 
   */
  private final int sueTrimValueInput4;

  /**
   * SUE UDB PWM Trim Value on Input 5 
   */
  private final int sueTrimValueInput5;

  /**
   * SUE UDB PWM Trim Value on Input 6 
   */
  private final int sueTrimValueInput6;

  /**
   * SUE UDB PWM Trim Value on Input 7 
   */
  private final int sueTrimValueInput7;

  /**
   * SUE UDB PWM Trim Value on Input 8 
   */
  private final int sueTrimValueInput8;

  /**
   * SUE UDB PWM Trim Value on Input 9 
   */
  private final int sueTrimValueInput9;

  /**
   * SUE UDB PWM Trim Value on Input 10 
   */
  private final int sueTrimValueInput10;

  /**
   * SUE UDB PWM Trim Value on Input 11 
   */
  private final int sueTrimValueInput11;

  /**
   * SUE UDB PWM Trim Value on Input 12 
   */
  private final int sueTrimValueInput12;

  /**
   * SUE Number of Input Channels 
   */
  private final int sueNumberOfInputs;

  private SerialUdbExtraF20(int sueTrimValueInput1, int sueTrimValueInput2, int sueTrimValueInput3,
      int sueTrimValueInput4, int sueTrimValueInput5, int sueTrimValueInput6,
      int sueTrimValueInput7, int sueTrimValueInput8, int sueTrimValueInput9,
      int sueTrimValueInput10, int sueTrimValueInput11, int sueTrimValueInput12,
      int sueNumberOfInputs) {
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
    this.sueNumberOfInputs = sueNumberOfInputs;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "SerialUdbExtraF20{sueNumberOfInputs=" + sueNumberOfInputs
         + ", sueTrimValueInput1=" + sueTrimValueInput1
         + ", sueTrimValueInput2=" + sueTrimValueInput2
         + ", sueTrimValueInput3=" + sueTrimValueInput3
         + ", sueTrimValueInput4=" + sueTrimValueInput4
         + ", sueTrimValueInput5=" + sueTrimValueInput5
         + ", sueTrimValueInput6=" + sueTrimValueInput6
         + ", sueTrimValueInput7=" + sueTrimValueInput7
         + ", sueTrimValueInput8=" + sueTrimValueInput8
         + ", sueTrimValueInput9=" + sueTrimValueInput9
         + ", sueTrimValueInput10=" + sueTrimValueInput10
         + ", sueTrimValueInput11=" + sueTrimValueInput11
         + ", sueTrimValueInput12=" + sueTrimValueInput12 + "}";
  }

  /**
   * SUE UDB PWM Trim Value on Input 1 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 2
  )
  public final int sueTrimValueInput1() {
    return sueTrimValueInput1;
  }

  /**
   * SUE UDB PWM Trim Value on Input 2 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 2
  )
  public final int sueTrimValueInput2() {
    return sueTrimValueInput2;
  }

  /**
   * SUE UDB PWM Trim Value on Input 3 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 2
  )
  public final int sueTrimValueInput3() {
    return sueTrimValueInput3;
  }

  /**
   * SUE UDB PWM Trim Value on Input 4 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 2
  )
  public final int sueTrimValueInput4() {
    return sueTrimValueInput4;
  }

  /**
   * SUE UDB PWM Trim Value on Input 5 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 2
  )
  public final int sueTrimValueInput5() {
    return sueTrimValueInput5;
  }

  /**
   * SUE UDB PWM Trim Value on Input 6 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 2
  )
  public final int sueTrimValueInput6() {
    return sueTrimValueInput6;
  }

  /**
   * SUE UDB PWM Trim Value on Input 7 
   */
  @MavlinkFieldInfo(
      position = 8,
      unitSize = 2
  )
  public final int sueTrimValueInput7() {
    return sueTrimValueInput7;
  }

  /**
   * SUE UDB PWM Trim Value on Input 8 
   */
  @MavlinkFieldInfo(
      position = 9,
      unitSize = 2
  )
  public final int sueTrimValueInput8() {
    return sueTrimValueInput8;
  }

  /**
   * SUE UDB PWM Trim Value on Input 9 
   */
  @MavlinkFieldInfo(
      position = 10,
      unitSize = 2
  )
  public final int sueTrimValueInput9() {
    return sueTrimValueInput9;
  }

  /**
   * SUE UDB PWM Trim Value on Input 10 
   */
  @MavlinkFieldInfo(
      position = 11,
      unitSize = 2
  )
  public final int sueTrimValueInput10() {
    return sueTrimValueInput10;
  }

  /**
   * SUE UDB PWM Trim Value on Input 11 
   */
  @MavlinkFieldInfo(
      position = 12,
      unitSize = 2
  )
  public final int sueTrimValueInput11() {
    return sueTrimValueInput11;
  }

  /**
   * SUE UDB PWM Trim Value on Input 12 
   */
  @MavlinkFieldInfo(
      position = 13,
      unitSize = 2
  )
  public final int sueTrimValueInput12() {
    return sueTrimValueInput12;
  }

  /**
   * SUE Number of Input Channels 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 1
  )
  public final int sueNumberOfInputs() {
    return sueNumberOfInputs;
  }

  public static class Builder {
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

    private int sueNumberOfInputs;

    private Builder() {
    }

    /**
     * SUE UDB PWM Trim Value on Input 1 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 2
    )
    public final Builder sueTrimValueInput1(int sueTrimValueInput1) {
      this.sueTrimValueInput1 = sueTrimValueInput1;
      return this;
    }

    /**
     * SUE UDB PWM Trim Value on Input 2 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 2
    )
    public final Builder sueTrimValueInput2(int sueTrimValueInput2) {
      this.sueTrimValueInput2 = sueTrimValueInput2;
      return this;
    }

    /**
     * SUE UDB PWM Trim Value on Input 3 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 2
    )
    public final Builder sueTrimValueInput3(int sueTrimValueInput3) {
      this.sueTrimValueInput3 = sueTrimValueInput3;
      return this;
    }

    /**
     * SUE UDB PWM Trim Value on Input 4 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 2
    )
    public final Builder sueTrimValueInput4(int sueTrimValueInput4) {
      this.sueTrimValueInput4 = sueTrimValueInput4;
      return this;
    }

    /**
     * SUE UDB PWM Trim Value on Input 5 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 2
    )
    public final Builder sueTrimValueInput5(int sueTrimValueInput5) {
      this.sueTrimValueInput5 = sueTrimValueInput5;
      return this;
    }

    /**
     * SUE UDB PWM Trim Value on Input 6 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 2
    )
    public final Builder sueTrimValueInput6(int sueTrimValueInput6) {
      this.sueTrimValueInput6 = sueTrimValueInput6;
      return this;
    }

    /**
     * SUE UDB PWM Trim Value on Input 7 
     */
    @MavlinkFieldInfo(
        position = 8,
        unitSize = 2
    )
    public final Builder sueTrimValueInput7(int sueTrimValueInput7) {
      this.sueTrimValueInput7 = sueTrimValueInput7;
      return this;
    }

    /**
     * SUE UDB PWM Trim Value on Input 8 
     */
    @MavlinkFieldInfo(
        position = 9,
        unitSize = 2
    )
    public final Builder sueTrimValueInput8(int sueTrimValueInput8) {
      this.sueTrimValueInput8 = sueTrimValueInput8;
      return this;
    }

    /**
     * SUE UDB PWM Trim Value on Input 9 
     */
    @MavlinkFieldInfo(
        position = 10,
        unitSize = 2
    )
    public final Builder sueTrimValueInput9(int sueTrimValueInput9) {
      this.sueTrimValueInput9 = sueTrimValueInput9;
      return this;
    }

    /**
     * SUE UDB PWM Trim Value on Input 10 
     */
    @MavlinkFieldInfo(
        position = 11,
        unitSize = 2
    )
    public final Builder sueTrimValueInput10(int sueTrimValueInput10) {
      this.sueTrimValueInput10 = sueTrimValueInput10;
      return this;
    }

    /**
     * SUE UDB PWM Trim Value on Input 11 
     */
    @MavlinkFieldInfo(
        position = 12,
        unitSize = 2
    )
    public final Builder sueTrimValueInput11(int sueTrimValueInput11) {
      this.sueTrimValueInput11 = sueTrimValueInput11;
      return this;
    }

    /**
     * SUE UDB PWM Trim Value on Input 12 
     */
    @MavlinkFieldInfo(
        position = 13,
        unitSize = 2
    )
    public final Builder sueTrimValueInput12(int sueTrimValueInput12) {
      this.sueTrimValueInput12 = sueTrimValueInput12;
      return this;
    }

    /**
     * SUE Number of Input Channels 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 1
    )
    public final Builder sueNumberOfInputs(int sueNumberOfInputs) {
      this.sueNumberOfInputs = sueNumberOfInputs;
      return this;
    }

    public final SerialUdbExtraF20 build() {
      return new SerialUdbExtraF20(sueTrimValueInput1, sueTrimValueInput2, sueTrimValueInput3, sueTrimValueInput4, sueTrimValueInput5, sueTrimValueInput6, sueTrimValueInput7, sueTrimValueInput8, sueTrimValueInput9, sueTrimValueInput10, sueTrimValueInput11, sueTrimValueInput12, sueNumberOfInputs);
    }
  }
}
