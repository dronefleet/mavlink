package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.math.BigInteger;

/**
 * Vibration levels and accelerometer clipping 
 */
@MavlinkMessage(
    id = 241,
    crc = 90
)
public final class Vibration {
  /**
   * Timestamp (micros since boot or Unix epoch) 
   */
  private final BigInteger timeUsec;

  /**
   * Vibration levels on X-axis 
   */
  private final float vibrationX;

  /**
   * Vibration levels on Y-axis 
   */
  private final float vibrationY;

  /**
   * Vibration levels on Z-axis 
   */
  private final float vibrationZ;

  /**
   * first accelerometer clipping count 
   */
  private final long clipping0;

  /**
   * second accelerometer clipping count 
   */
  private final long clipping1;

  /**
   * third accelerometer clipping count 
   */
  private final long clipping2;

  private Vibration(BigInteger timeUsec, float vibrationX, float vibrationY, float vibrationZ,
      long clipping0, long clipping1, long clipping2) {
    this.timeUsec = timeUsec;
    this.vibrationX = vibrationX;
    this.vibrationY = vibrationY;
    this.vibrationZ = vibrationZ;
    this.clipping0 = clipping0;
    this.clipping1 = clipping1;
    this.clipping2 = clipping2;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp (micros since boot or Unix epoch) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * Vibration levels on X-axis 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float vibrationX() {
    return vibrationX;
  }

  /**
   * Vibration levels on Y-axis 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float vibrationY() {
    return vibrationY;
  }

  /**
   * Vibration levels on Z-axis 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float vibrationZ() {
    return vibrationZ;
  }

  /**
   * first accelerometer clipping count 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final long clipping0() {
    return clipping0;
  }

  /**
   * second accelerometer clipping count 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final long clipping1() {
    return clipping1;
  }

  /**
   * third accelerometer clipping count 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final long clipping2() {
    return clipping2;
  }

  public static class Builder {
    private BigInteger timeUsec;

    private float vibrationX;

    private float vibrationY;

    private float vibrationZ;

    private long clipping0;

    private long clipping1;

    private long clipping2;

    private Builder() {
    }

    /**
     * Timestamp (micros since boot or Unix epoch) 
     */
    @MavlinkMessageField(
        position = 1,
        length = 8
    )
    public final Builder timeUsec(BigInteger timeUsec) {
      this.timeUsec = timeUsec;
      return this;
    }

    /**
     * Vibration levels on X-axis 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder vibrationX(float vibrationX) {
      this.vibrationX = vibrationX;
      return this;
    }

    /**
     * Vibration levels on Y-axis 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder vibrationY(float vibrationY) {
      this.vibrationY = vibrationY;
      return this;
    }

    /**
     * Vibration levels on Z-axis 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder vibrationZ(float vibrationZ) {
      this.vibrationZ = vibrationZ;
      return this;
    }

    /**
     * first accelerometer clipping count 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder clipping0(long clipping0) {
      this.clipping0 = clipping0;
      return this;
    }

    /**
     * second accelerometer clipping count 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder clipping1(long clipping1) {
      this.clipping1 = clipping1;
      return this;
    }

    /**
     * third accelerometer clipping count 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder clipping2(long clipping2) {
      this.clipping2 = clipping2;
      return this;
    }

    public final Vibration build() {
      return new Vibration(timeUsec, vibrationX, vibrationY, vibrationZ, clipping0, clipping1, clipping2);
    }
  }
}
