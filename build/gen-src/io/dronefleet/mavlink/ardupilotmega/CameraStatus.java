package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.math.BigInteger;

/**
 * Camera Event 
 */
@MavlinkMessage(
    id = 179,
    crc = 189
)
public final class CameraStatus {
  private final BigInteger timeUsec;

  private final int targetSystem;

  private final int camIdx;

  private final int imgIdx;

  private final CameraStatusTypes eventId;

  private final float p1;

  private final float p2;

  private final float p3;

  private final float p4;

  private CameraStatus(BigInteger timeUsec, int targetSystem, int camIdx, int imgIdx,
      CameraStatusTypes eventId, float p1, float p2, float p3, float p4) {
    this.timeUsec = timeUsec;
    this.targetSystem = targetSystem;
    this.camIdx = camIdx;
    this.imgIdx = imgIdx;
    this.eventId = eventId;
    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
    this.p4 = p4;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Image timestamp (microseconds since UNIX epoch, according to camera clock) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * System ID 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * Camera ID 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final int camIdx() {
    return camIdx;
  }

  /**
   * Image index 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int imgIdx() {
    return imgIdx;
  }

  /**
   * See CAMERA_STATUS_TYPES enum for definition of the bitmask 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1
  )
  public final CameraStatusTypes eventId() {
    return eventId;
  }

  /**
   * Parameter 1 (meaning depends on event, see CAMERA_STATUS_TYPES enum) 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float p1() {
    return p1;
  }

  /**
   * Parameter 2 (meaning depends on event, see CAMERA_STATUS_TYPES enum) 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float p2() {
    return p2;
  }

  /**
   * Parameter 3 (meaning depends on event, see CAMERA_STATUS_TYPES enum) 
   */
  @MavlinkMessageField(
      position = 8,
      length = 4
  )
  public final float p3() {
    return p3;
  }

  /**
   * Parameter 4 (meaning depends on event, see CAMERA_STATUS_TYPES enum) 
   */
  @MavlinkMessageField(
      position = 9,
      length = 4
  )
  public final float p4() {
    return p4;
  }

  public class Builder {
    private BigInteger timeUsec;

    private int targetSystem;

    private int camIdx;

    private int imgIdx;

    private CameraStatusTypes eventId;

    private float p1;

    private float p2;

    private float p3;

    private float p4;

    private Builder() {
    }

    /**
     * Image timestamp (microseconds since UNIX epoch, according to camera clock) 
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
     * System ID 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder targetSystem(int targetSystem) {
      this.targetSystem = targetSystem;
      return this;
    }

    /**
     * Camera ID 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder camIdx(int camIdx) {
      this.camIdx = camIdx;
      return this;
    }

    /**
     * Image index 
     */
    @MavlinkMessageField(
        position = 4,
        length = 2
    )
    public final Builder imgIdx(int imgIdx) {
      this.imgIdx = imgIdx;
      return this;
    }

    /**
     * See CAMERA_STATUS_TYPES enum for definition of the bitmask 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1
    )
    public final Builder eventId(CameraStatusTypes eventId) {
      this.eventId = eventId;
      return this;
    }

    /**
     * Parameter 1 (meaning depends on event, see CAMERA_STATUS_TYPES enum) 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder p1(float p1) {
      this.p1 = p1;
      return this;
    }

    /**
     * Parameter 2 (meaning depends on event, see CAMERA_STATUS_TYPES enum) 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder p2(float p2) {
      this.p2 = p2;
      return this;
    }

    /**
     * Parameter 3 (meaning depends on event, see CAMERA_STATUS_TYPES enum) 
     */
    @MavlinkMessageField(
        position = 8,
        length = 4
    )
    public final Builder p3(float p3) {
      this.p3 = p3;
      return this;
    }

    /**
     * Parameter 4 (meaning depends on event, see CAMERA_STATUS_TYPES enum) 
     */
    @MavlinkMessageField(
        position = 9,
        length = 4
    )
    public final Builder p4(float p4) {
      this.p4 = p4;
      return this;
    }

    public final CameraStatus build() {
      return new CameraStatus(timeUsec, targetSystem, camIdx, imgIdx, eventId, p1, p2, p3, p4);
    }
  }
}
