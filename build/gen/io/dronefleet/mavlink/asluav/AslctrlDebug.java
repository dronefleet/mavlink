package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * ASL-fixed-wing controller debug data 
 */
@MavlinkMessage(
    id = 204,
    crc = 251
)
public final class AslctrlDebug {
  private final long i321;

  private final int i81;

  private final int i82;

  private final float f1;

  private final float f2;

  private final float f3;

  private final float f4;

  private final float f5;

  private final float f6;

  private final float f7;

  private final float f8;

  private AslctrlDebug(long i321, int i81, int i82, float f1, float f2, float f3, float f4,
      float f5, float f6, float f7, float f8) {
    this.i321 = i321;
    this.i81 = i81;
    this.i82 = i82;
    this.f1 = f1;
    this.f2 = f2;
    this.f3 = f3;
    this.f4 = f4;
    this.f5 = f5;
    this.f6 = f6;
    this.f7 = f7;
    this.f8 = f8;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Debug data 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final long i321() {
    return i321;
  }

  /**
   * Debug data 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int i81() {
    return i81;
  }

  /**
   * Debug data 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final int i82() {
    return i82;
  }

  /**
   * Debug data 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float f1() {
    return f1;
  }

  /**
   * Debug data 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float f2() {
    return f2;
  }

  /**
   * Debug data 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float f3() {
    return f3;
  }

  /**
   * Debug data 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float f4() {
    return f4;
  }

  /**
   * Debug data 
   */
  @MavlinkMessageField(
      position = 8,
      length = 4
  )
  public final float f5() {
    return f5;
  }

  /**
   * Debug data 
   */
  @MavlinkMessageField(
      position = 9,
      length = 4
  )
  public final float f6() {
    return f6;
  }

  /**
   * Debug data 
   */
  @MavlinkMessageField(
      position = 10,
      length = 4
  )
  public final float f7() {
    return f7;
  }

  /**
   * Debug data 
   */
  @MavlinkMessageField(
      position = 11,
      length = 4
  )
  public final float f8() {
    return f8;
  }

  public class Builder {
    private long i321;

    private int i81;

    private int i82;

    private float f1;

    private float f2;

    private float f3;

    private float f4;

    private float f5;

    private float f6;

    private float f7;

    private float f8;

    private Builder() {
    }

    /**
     * Debug data 
     */
    @MavlinkMessageField(
        position = 1,
        length = 4
    )
    public final Builder i321(long i321) {
      this.i321 = i321;
      return this;
    }

    /**
     * Debug data 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder i81(int i81) {
      this.i81 = i81;
      return this;
    }

    /**
     * Debug data 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder i82(int i82) {
      this.i82 = i82;
      return this;
    }

    /**
     * Debug data 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder f1(float f1) {
      this.f1 = f1;
      return this;
    }

    /**
     * Debug data 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder f2(float f2) {
      this.f2 = f2;
      return this;
    }

    /**
     * Debug data 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder f3(float f3) {
      this.f3 = f3;
      return this;
    }

    /**
     * Debug data 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder f4(float f4) {
      this.f4 = f4;
      return this;
    }

    /**
     * Debug data 
     */
    @MavlinkMessageField(
        position = 8,
        length = 4
    )
    public final Builder f5(float f5) {
      this.f5 = f5;
      return this;
    }

    /**
     * Debug data 
     */
    @MavlinkMessageField(
        position = 9,
        length = 4
    )
    public final Builder f6(float f6) {
      this.f6 = f6;
      return this;
    }

    /**
     * Debug data 
     */
    @MavlinkMessageField(
        position = 10,
        length = 4
    )
    public final Builder f7(float f7) {
      this.f7 = f7;
      return this;
    }

    /**
     * Debug data 
     */
    @MavlinkMessageField(
        position = 11,
        length = 4
    )
    public final Builder f8(float f8) {
      this.f8 = f8;
      return this;
    }

    public final AslctrlDebug build() {
      return new AslctrlDebug(i321, i81, i82, f1, f2, f3, f4, f5, f6, f7, f8);
    }
  }
}
