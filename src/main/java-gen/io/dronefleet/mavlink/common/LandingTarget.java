package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Float;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;
import java.util.List;

/**
 * The location of a landing area captured from a downward facing camera 
 */
@MavlinkMessageInfo(
    id = 149,
    crc = 200
)
public final class LandingTarget {
  /**
   * Timestamp (micros since boot or Unix epoch) 
   */
  private final BigInteger timeUsec;

  /**
   * X-axis angular offset (in radians) of the target from the center of the image 
   */
  private final float angleX;

  /**
   * Y-axis angular offset (in radians) of the target from the center of the image 
   */
  private final float angleY;

  /**
   * Distance to the target from the vehicle in meters 
   */
  private final float distance;

  /**
   * Size in radians of target along x-axis 
   */
  private final float sizeX;

  /**
   * Size in radians of target along y-axis 
   */
  private final float sizeY;

  /**
   * The ID of the target if multiple targets are present 
   */
  private final int targetNum;

  /**
   * {@link io.dronefleet.mavlink.common.MavFrame MavFrame} enum specifying the whether the following feilds are earth-frame, body-frame, 
   * etc. 
   */
  private final MavFrame frame;

  /**
   * X Position of the landing target on {@link io.dronefleet.mavlink.common.MavFrame MavFrame} 
   */
  private final float x;

  /**
   * Y Position of the landing target on {@link io.dronefleet.mavlink.common.MavFrame MavFrame} 
   */
  private final float y;

  /**
   * Z Position of the landing target on {@link io.dronefleet.mavlink.common.MavFrame MavFrame} 
   */
  private final float z;

  /**
   * Quaternion of landing target orientation (w, x, y, z order, zero-rotation is 1, 0, 0, 0) 
   */
  private final List<Float> q;

  /**
   * {@link io.dronefleet.mavlink.common.LandingTargetType LandingTargetType} enum specifying the type of landing target 
   */
  private final LandingTargetType type;

  /**
   * Boolean indicating known position (1) or default unkown position (0), for validation of 
   * positioning of the landing target 
   */
  private final int positionValid;

  private LandingTarget(BigInteger timeUsec, float angleX, float angleY, float distance,
      float sizeX, float sizeY, int targetNum, MavFrame frame, float x, float y, float z,
      List<Float> q, LandingTargetType type, int positionValid) {
    this.timeUsec = timeUsec;
    this.angleX = angleX;
    this.angleY = angleY;
    this.distance = distance;
    this.sizeX = sizeX;
    this.sizeY = sizeY;
    this.targetNum = targetNum;
    this.frame = frame;
    this.x = x;
    this.y = y;
    this.z = z;
    this.q = q;
    this.type = type;
    this.positionValid = positionValid;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "LandingTarget{timeUsec=" + timeUsec
         + ", targetNum=" + targetNum
         + ", frame=" + frame
         + ", angleX=" + angleX
         + ", angleY=" + angleY
         + ", distance=" + distance
         + ", sizeX=" + sizeX
         + ", sizeY=" + sizeY
         + ", x=" + x
         + ", y=" + y
         + ", z=" + z
         + ", q=" + q
         + ", type=" + type
         + ", positionValid=" + positionValid + "}";
  }

  /**
   * Timestamp (micros since boot or Unix epoch) 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * X-axis angular offset (in radians) of the target from the center of the image 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 4
  )
  public final float angleX() {
    return angleX;
  }

  /**
   * Y-axis angular offset (in radians) of the target from the center of the image 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 4
  )
  public final float angleY() {
    return angleY;
  }

  /**
   * Distance to the target from the vehicle in meters 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 4
  )
  public final float distance() {
    return distance;
  }

  /**
   * Size in radians of target along x-axis 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 4
  )
  public final float sizeX() {
    return sizeX;
  }

  /**
   * Size in radians of target along y-axis 
   */
  @MavlinkFieldInfo(
      position = 8,
      unitSize = 4
  )
  public final float sizeY() {
    return sizeY;
  }

  /**
   * The ID of the target if multiple targets are present 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 1
  )
  public final int targetNum() {
    return targetNum;
  }

  /**
   * {@link io.dronefleet.mavlink.common.MavFrame MavFrame} enum specifying the whether the following feilds are earth-frame, body-frame, 
   * etc. 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 1
  )
  public final MavFrame frame() {
    return frame;
  }

  /**
   * X Position of the landing target on {@link io.dronefleet.mavlink.common.MavFrame MavFrame} 
   */
  @MavlinkFieldInfo(
      position = 10,
      unitSize = 4,
      extension = true
  )
  public final float x() {
    return x;
  }

  /**
   * Y Position of the landing target on {@link io.dronefleet.mavlink.common.MavFrame MavFrame} 
   */
  @MavlinkFieldInfo(
      position = 11,
      unitSize = 4,
      extension = true
  )
  public final float y() {
    return y;
  }

  /**
   * Z Position of the landing target on {@link io.dronefleet.mavlink.common.MavFrame MavFrame} 
   */
  @MavlinkFieldInfo(
      position = 12,
      unitSize = 4,
      extension = true
  )
  public final float z() {
    return z;
  }

  /**
   * Quaternion of landing target orientation (w, x, y, z order, zero-rotation is 1, 0, 0, 0) 
   */
  @MavlinkFieldInfo(
      position = 13,
      unitSize = 4,
      arraySize = 4,
      extension = true
  )
  public final List<Float> q() {
    return q;
  }

  /**
   * {@link io.dronefleet.mavlink.common.LandingTargetType LandingTargetType} enum specifying the type of landing target 
   */
  @MavlinkFieldInfo(
      position = 14,
      unitSize = 1,
      extension = true
  )
  public final LandingTargetType type() {
    return type;
  }

  /**
   * Boolean indicating known position (1) or default unkown position (0), for validation of 
   * positioning of the landing target 
   */
  @MavlinkFieldInfo(
      position = 15,
      unitSize = 1,
      extension = true
  )
  public final int positionValid() {
    return positionValid;
  }

  public static class Builder {
    private BigInteger timeUsec;

    private float angleX;

    private float angleY;

    private float distance;

    private float sizeX;

    private float sizeY;

    private int targetNum;

    private MavFrame frame;

    private float x;

    private float y;

    private float z;

    private List<Float> q;

    private LandingTargetType type;

    private int positionValid;

    private Builder() {
    }

    /**
     * Timestamp (micros since boot or Unix epoch) 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 8
    )
    public final Builder timeUsec(BigInteger timeUsec) {
      this.timeUsec = timeUsec;
      return this;
    }

    /**
     * X-axis angular offset (in radians) of the target from the center of the image 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 4
    )
    public final Builder angleX(float angleX) {
      this.angleX = angleX;
      return this;
    }

    /**
     * Y-axis angular offset (in radians) of the target from the center of the image 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 4
    )
    public final Builder angleY(float angleY) {
      this.angleY = angleY;
      return this;
    }

    /**
     * Distance to the target from the vehicle in meters 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 4
    )
    public final Builder distance(float distance) {
      this.distance = distance;
      return this;
    }

    /**
     * Size in radians of target along x-axis 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 4
    )
    public final Builder sizeX(float sizeX) {
      this.sizeX = sizeX;
      return this;
    }

    /**
     * Size in radians of target along y-axis 
     */
    @MavlinkFieldInfo(
        position = 8,
        unitSize = 4
    )
    public final Builder sizeY(float sizeY) {
      this.sizeY = sizeY;
      return this;
    }

    /**
     * The ID of the target if multiple targets are present 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 1
    )
    public final Builder targetNum(int targetNum) {
      this.targetNum = targetNum;
      return this;
    }

    /**
     * {@link io.dronefleet.mavlink.common.MavFrame MavFrame} enum specifying the whether the following feilds are earth-frame, body-frame, 
     * etc. 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 1
    )
    public final Builder frame(MavFrame frame) {
      this.frame = frame;
      return this;
    }

    /**
     * X Position of the landing target on {@link io.dronefleet.mavlink.common.MavFrame MavFrame} 
     */
    @MavlinkFieldInfo(
        position = 10,
        unitSize = 4,
        extension = true
    )
    public final Builder x(float x) {
      this.x = x;
      return this;
    }

    /**
     * Y Position of the landing target on {@link io.dronefleet.mavlink.common.MavFrame MavFrame} 
     */
    @MavlinkFieldInfo(
        position = 11,
        unitSize = 4,
        extension = true
    )
    public final Builder y(float y) {
      this.y = y;
      return this;
    }

    /**
     * Z Position of the landing target on {@link io.dronefleet.mavlink.common.MavFrame MavFrame} 
     */
    @MavlinkFieldInfo(
        position = 12,
        unitSize = 4,
        extension = true
    )
    public final Builder z(float z) {
      this.z = z;
      return this;
    }

    /**
     * Quaternion of landing target orientation (w, x, y, z order, zero-rotation is 1, 0, 0, 0) 
     */
    @MavlinkFieldInfo(
        position = 13,
        unitSize = 4,
        arraySize = 4,
        extension = true
    )
    public final Builder q(List<Float> q) {
      this.q = q;
      return this;
    }

    /**
     * {@link io.dronefleet.mavlink.common.LandingTargetType LandingTargetType} enum specifying the type of landing target 
     */
    @MavlinkFieldInfo(
        position = 14,
        unitSize = 1,
        extension = true
    )
    public final Builder type(LandingTargetType type) {
      this.type = type;
      return this;
    }

    /**
     * Boolean indicating known position (1) or default unkown position (0), for validation of 
     * positioning of the landing target 
     */
    @MavlinkFieldInfo(
        position = 15,
        unitSize = 1,
        extension = true
    )
    public final Builder positionValid(int positionValid) {
      this.positionValid = positionValid;
      return this;
    }

    public final LandingTarget build() {
      return new LandingTarget(timeUsec, angleX, angleY, distance, sizeX, sizeY, targetNum, frame, x, y, z, q, type, positionValid);
    }
  }
}
