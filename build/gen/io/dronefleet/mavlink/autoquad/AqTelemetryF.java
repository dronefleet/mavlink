package io.dronefleet.mavlink.autoquad;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Sends up to 20 raw float values. 
 */
@MavlinkMessage(
    id = 150,
    crc = 241
)
public final class AqTelemetryF {
  private final int index;

  private final float value1;

  private final float value2;

  private final float value3;

  private final float value4;

  private final float value5;

  private final float value6;

  private final float value7;

  private final float value8;

  private final float value9;

  private final float value10;

  private final float value11;

  private final float value12;

  private final float value13;

  private final float value14;

  private final float value15;

  private final float value16;

  private final float value17;

  private final float value18;

  private final float value19;

  private final float value20;

  private AqTelemetryF(int index, float value1, float value2, float value3, float value4,
      float value5, float value6, float value7, float value8, float value9, float value10,
      float value11, float value12, float value13, float value14, float value15, float value16,
      float value17, float value18, float value19, float value20) {
    this.index = index;
    this.value1 = value1;
    this.value2 = value2;
    this.value3 = value3;
    this.value4 = value4;
    this.value5 = value5;
    this.value6 = value6;
    this.value7 = value7;
    this.value8 = value8;
    this.value9 = value9;
    this.value10 = value10;
    this.value11 = value11;
    this.value12 = value12;
    this.value13 = value13;
    this.value14 = value14;
    this.value15 = value15;
    this.value16 = value16;
    this.value17 = value17;
    this.value18 = value18;
    this.value19 = value19;
    this.value20 = value20;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Index of message 
   */
  @MavlinkMessageField(
      position = 1,
      length = 2
  )
  public final int index() {
    return index;
  }

  /**
   * value1 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float value1() {
    return value1;
  }

  /**
   * value2 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float value2() {
    return value2;
  }

  /**
   * value3 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float value3() {
    return value3;
  }

  /**
   * value4 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float value4() {
    return value4;
  }

  /**
   * value5 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float value5() {
    return value5;
  }

  /**
   * value6 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float value6() {
    return value6;
  }

  /**
   * value7 
   */
  @MavlinkMessageField(
      position = 8,
      length = 4
  )
  public final float value7() {
    return value7;
  }

  /**
   * value8 
   */
  @MavlinkMessageField(
      position = 9,
      length = 4
  )
  public final float value8() {
    return value8;
  }

  /**
   * value9 
   */
  @MavlinkMessageField(
      position = 10,
      length = 4
  )
  public final float value9() {
    return value9;
  }

  /**
   * value10 
   */
  @MavlinkMessageField(
      position = 11,
      length = 4
  )
  public final float value10() {
    return value10;
  }

  /**
   * value11 
   */
  @MavlinkMessageField(
      position = 12,
      length = 4
  )
  public final float value11() {
    return value11;
  }

  /**
   * value12 
   */
  @MavlinkMessageField(
      position = 13,
      length = 4
  )
  public final float value12() {
    return value12;
  }

  /**
   * value13 
   */
  @MavlinkMessageField(
      position = 14,
      length = 4
  )
  public final float value13() {
    return value13;
  }

  /**
   * value14 
   */
  @MavlinkMessageField(
      position = 15,
      length = 4
  )
  public final float value14() {
    return value14;
  }

  /**
   * value15 
   */
  @MavlinkMessageField(
      position = 16,
      length = 4
  )
  public final float value15() {
    return value15;
  }

  /**
   * value16 
   */
  @MavlinkMessageField(
      position = 17,
      length = 4
  )
  public final float value16() {
    return value16;
  }

  /**
   * value17 
   */
  @MavlinkMessageField(
      position = 18,
      length = 4
  )
  public final float value17() {
    return value17;
  }

  /**
   * value18 
   */
  @MavlinkMessageField(
      position = 19,
      length = 4
  )
  public final float value18() {
    return value18;
  }

  /**
   * value19 
   */
  @MavlinkMessageField(
      position = 20,
      length = 4
  )
  public final float value19() {
    return value19;
  }

  /**
   * value20 
   */
  @MavlinkMessageField(
      position = 21,
      length = 4
  )
  public final float value20() {
    return value20;
  }

  public class Builder {
    private int index;

    private float value1;

    private float value2;

    private float value3;

    private float value4;

    private float value5;

    private float value6;

    private float value7;

    private float value8;

    private float value9;

    private float value10;

    private float value11;

    private float value12;

    private float value13;

    private float value14;

    private float value15;

    private float value16;

    private float value17;

    private float value18;

    private float value19;

    private float value20;

    private Builder() {
    }

    /**
     * Index of message 
     */
    @MavlinkMessageField(
        position = 1,
        length = 2
    )
    public final Builder index(int index) {
      this.index = index;
      return this;
    }

    /**
     * value1 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder value1(float value1) {
      this.value1 = value1;
      return this;
    }

    /**
     * value2 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder value2(float value2) {
      this.value2 = value2;
      return this;
    }

    /**
     * value3 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder value3(float value3) {
      this.value3 = value3;
      return this;
    }

    /**
     * value4 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder value4(float value4) {
      this.value4 = value4;
      return this;
    }

    /**
     * value5 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder value5(float value5) {
      this.value5 = value5;
      return this;
    }

    /**
     * value6 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder value6(float value6) {
      this.value6 = value6;
      return this;
    }

    /**
     * value7 
     */
    @MavlinkMessageField(
        position = 8,
        length = 4
    )
    public final Builder value7(float value7) {
      this.value7 = value7;
      return this;
    }

    /**
     * value8 
     */
    @MavlinkMessageField(
        position = 9,
        length = 4
    )
    public final Builder value8(float value8) {
      this.value8 = value8;
      return this;
    }

    /**
     * value9 
     */
    @MavlinkMessageField(
        position = 10,
        length = 4
    )
    public final Builder value9(float value9) {
      this.value9 = value9;
      return this;
    }

    /**
     * value10 
     */
    @MavlinkMessageField(
        position = 11,
        length = 4
    )
    public final Builder value10(float value10) {
      this.value10 = value10;
      return this;
    }

    /**
     * value11 
     */
    @MavlinkMessageField(
        position = 12,
        length = 4
    )
    public final Builder value11(float value11) {
      this.value11 = value11;
      return this;
    }

    /**
     * value12 
     */
    @MavlinkMessageField(
        position = 13,
        length = 4
    )
    public final Builder value12(float value12) {
      this.value12 = value12;
      return this;
    }

    /**
     * value13 
     */
    @MavlinkMessageField(
        position = 14,
        length = 4
    )
    public final Builder value13(float value13) {
      this.value13 = value13;
      return this;
    }

    /**
     * value14 
     */
    @MavlinkMessageField(
        position = 15,
        length = 4
    )
    public final Builder value14(float value14) {
      this.value14 = value14;
      return this;
    }

    /**
     * value15 
     */
    @MavlinkMessageField(
        position = 16,
        length = 4
    )
    public final Builder value15(float value15) {
      this.value15 = value15;
      return this;
    }

    /**
     * value16 
     */
    @MavlinkMessageField(
        position = 17,
        length = 4
    )
    public final Builder value16(float value16) {
      this.value16 = value16;
      return this;
    }

    /**
     * value17 
     */
    @MavlinkMessageField(
        position = 18,
        length = 4
    )
    public final Builder value17(float value17) {
      this.value17 = value17;
      return this;
    }

    /**
     * value18 
     */
    @MavlinkMessageField(
        position = 19,
        length = 4
    )
    public final Builder value18(float value18) {
      this.value18 = value18;
      return this;
    }

    /**
     * value19 
     */
    @MavlinkMessageField(
        position = 20,
        length = 4
    )
    public final Builder value19(float value19) {
      this.value19 = value19;
      return this;
    }

    /**
     * value20 
     */
    @MavlinkMessageField(
        position = 21,
        length = 4
    )
    public final Builder value20(float value20) {
      this.value20 = value20;
      return this;
    }

    public final AqTelemetryF build() {
      return new AqTelemetryF(index, value1, value2, value3, value4, value5, value6, value7, value8, value9, value10, value11, value12, value13, value14, value15, value16, value17, value18, value19, value20);
    }
  }
}
