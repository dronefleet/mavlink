package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.math.BigInteger;
import java.util.List;

/**
 * null
 */
@MavlinkMessage(
    id = 250,
    crc = 49
)
public final class DebugVect {
  private final List<Integer> name;

  private final BigInteger timeUsec;

  private final float x;

  private final float y;

  private final float z;

  private DebugVect(List<Integer> name, BigInteger timeUsec, float x, float y, float z) {
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
  public final List<Integer> name() {
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

  public class Builder {
    private List<Integer> name;

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
    public final Builder name(List<Integer> name) {
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
