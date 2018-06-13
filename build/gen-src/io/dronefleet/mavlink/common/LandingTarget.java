package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Float;
import java.math.BigInteger;
import java.util.List;

/**
 * The location of a landing area captured from a downward facing camera 
 */
@MavlinkMessage(
    id = 149,
    crc = 200
)
public final class LandingTarget {
  private final BigInteger timeUsec;

  private final int targetNum;

  private final MavFrame frame;

  private final float angleX;

  private final float angleY;

  private final float distance;

  private final float sizeX;

  private final float sizeY;

  private final float x;

  private final float y;

  private final float z;

  private final List<Float> q;

  private final LandingTargetType type;

  private final int positionValid;

  private LandingTarget(BigInteger timeUsec, int targetNum, MavFrame frame, float angleX,
      float angleY, float distance, float sizeX, float sizeY, float x, float y, float z,
      List<Float> q, LandingTargetType type, int positionValid) {
    this.timeUsec = timeUsec;
    this.targetNum = targetNum;
    this.frame = frame;
    this.angleX = angleX;
    this.angleY = angleY;
    this.distance = distance;
    this.sizeX = sizeX;
    this.sizeY = sizeY;
    this.x = x;
    this.y = y;
    this.z = z;
    this.q = q;
    this.type = type;
    this.positionValid = positionValid;
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
   * The ID of the target if multiple targets are present 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int targetNum() {
    return targetNum;
  }

  /**
   * MAV_FRAME enum specifying the whether the following feilds are earth-frame, body-frame, 
   * etc. 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final MavFrame frame() {
    return frame;
  }

  /**
   * X-axis angular offset (in radians) of the target from the center of the image 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float angleX() {
    return angleX;
  }

  /**
   * Y-axis angular offset (in radians) of the target from the center of the image 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float angleY() {
    return angleY;
  }

  /**
   * Distance to the target from the vehicle in meters 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float distance() {
    return distance;
  }

  /**
   * Size in radians of target along x-axis 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float sizeX() {
    return sizeX;
  }

  /**
   * Size in radians of target along y-axis 
   */
  @MavlinkMessageField(
      position = 8,
      length = 4
  )
  public final float sizeY() {
    return sizeY;
  }

  /**
   * X Position of the landing target on MAV_FRAME 
   */
  @MavlinkMessageField(
      position = 10,
      length = 4,
      extension = true
  )
  public final float x() {
    return x;
  }

  /**
   * Y Position of the landing target on MAV_FRAME 
   */
  @MavlinkMessageField(
      position = 11,
      length = 4,
      extension = true
  )
  public final float y() {
    return y;
  }

  /**
   * Z Position of the landing target on MAV_FRAME 
   */
  @MavlinkMessageField(
      position = 12,
      length = 4,
      extension = true
  )
  public final float z() {
    return z;
  }

  /**
   * Quaternion of landing target orientation (w, x, y, z order, zero-rotation is 1, 0, 0, 0) 
   */
  @MavlinkMessageField(
      position = 13,
      length = 4,
      arraySize = 4,
      extension = true
  )
  public final List<Float> q() {
    return q;
  }

  /**
   * LANDING_TARGET_TYPE enum specifying the type of landing target 
   */
  @MavlinkMessageField(
      position = 14,
      length = 1,
      extension = true
  )
  public final LandingTargetType type() {
    return type;
  }

  /**
   * Boolean indicating known position (1) or default unkown position (0), for validation of 
   * positioning of the landing target 
   */
  @MavlinkMessageField(
      position = 15,
      length = 1,
      extension = true
  )
  public final int positionValid() {
    return positionValid;
  }

  public class Builder {
    private BigInteger timeUsec;

    private int targetNum;

    private MavFrame frame;

    private float angleX;

    private float angleY;

    private float distance;

    private float sizeX;

    private float sizeY;

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
    @MavlinkMessageField(
        position = 1,
        length = 8
    )
    public final Builder timeUsec(BigInteger timeUsec) {
      this.timeUsec = timeUsec;
      return this;
    }

    /**
     * The ID of the target if multiple targets are present 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder targetNum(int targetNum) {
      this.targetNum = targetNum;
      return this;
    }

    /**
     * MAV_FRAME enum specifying the whether the following feilds are earth-frame, body-frame, 
     * etc. 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder frame(MavFrame frame) {
      this.frame = frame;
      return this;
    }

    /**
     * X-axis angular offset (in radians) of the target from the center of the image 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder angleX(float angleX) {
      this.angleX = angleX;
      return this;
    }

    /**
     * Y-axis angular offset (in radians) of the target from the center of the image 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder angleY(float angleY) {
      this.angleY = angleY;
      return this;
    }

    /**
     * Distance to the target from the vehicle in meters 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder distance(float distance) {
      this.distance = distance;
      return this;
    }

    /**
     * Size in radians of target along x-axis 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder sizeX(float sizeX) {
      this.sizeX = sizeX;
      return this;
    }

    /**
     * Size in radians of target along y-axis 
     */
    @MavlinkMessageField(
        position = 8,
        length = 4
    )
    public final Builder sizeY(float sizeY) {
      this.sizeY = sizeY;
      return this;
    }

    /**
     * X Position of the landing target on MAV_FRAME 
     */
    @MavlinkMessageField(
        position = 10,
        length = 4,
        extension = true
    )
    public final Builder x(float x) {
      this.x = x;
      return this;
    }

    /**
     * Y Position of the landing target on MAV_FRAME 
     */
    @MavlinkMessageField(
        position = 11,
        length = 4,
        extension = true
    )
    public final Builder y(float y) {
      this.y = y;
      return this;
    }

    /**
     * Z Position of the landing target on MAV_FRAME 
     */
    @MavlinkMessageField(
        position = 12,
        length = 4,
        extension = true
    )
    public final Builder z(float z) {
      this.z = z;
      return this;
    }

    /**
     * Quaternion of landing target orientation (w, x, y, z order, zero-rotation is 1, 0, 0, 0) 
     */
    @MavlinkMessageField(
        position = 13,
        length = 4,
        arraySize = 4,
        extension = true
    )
    public final Builder q(List<Float> q) {
      this.q = q;
      return this;
    }

    /**
     * LANDING_TARGET_TYPE enum specifying the type of landing target 
     */
    @MavlinkMessageField(
        position = 14,
        length = 1,
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
    @MavlinkMessageField(
        position = 15,
        length = 1,
        extension = true
    )
    public final Builder positionValid(int positionValid) {
      this.positionValid = positionValid;
      return this;
    }

    public final LandingTarget build() {
      return new LandingTarget(timeUsec, targetNum, frame, angleX, angleY, distance, sizeX, sizeY, x, y, z, q, type, positionValid);
    }
  }
}
