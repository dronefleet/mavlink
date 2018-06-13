package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.String;
import java.math.BigInteger;

/**
 * null
 */
@MavlinkMessage(
    id = 250,
    crc = 49
)
public final class DebugVect {
  /**
   * Name 
   */
  private final String name;

  /**
   * Timestamp 
   */
  private final BigInteger timeUsec;

  /**
   * x 
   */
  private final float x;

  /**
   * y 
   */
  private final float y;

  /**
   * z 
   */
  private final float z;

  private DebugVect(String name, BigInteger timeUsec, float x, float y, float z) {
    this.name = name;
    this.timeUsec = timeUsec;
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Name 
   */
  @MavlinkMessageField(
      position = 0,
      length = 1,
      arraySize = 10
  )
  public final String name() {
    return name;
  }

  /**
   * Timestamp 
   */
  @MavlinkMessageField(
      position = 1,
      length = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * x 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final float x() {
    return x;
  }

  /**
   * y 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float y() {
    return y;
  }

  /**
   * z 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float z() {
    return z;
  }

  public static class Builder {
    private String name;

    private BigInteger timeUsec;

    private float x;

    private float y;

    private float z;

    private Builder() {
    }

    /**
     * Name 
     */
    @MavlinkMessageField(
        position = 0,
        length = 1,
        arraySize = 10
    )
    public final Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Timestamp 
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
     * x 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder x(float x) {
      this.x = x;
      return this;
    }

    /**
     * y 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder y(float y) {
      this.y = y;
      return this;
    }

    /**
     * z 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder z(float z) {
      this.z = z;
      return this;
    }

    public final DebugVect build() {
      return new DebugVect(name, timeUsec, x, y, z);
    }
  }
}
