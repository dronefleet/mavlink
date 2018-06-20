package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;

/**
 * Camera Event 
 */
@MavlinkMessageInfo(
    id = 179,
    crc = 189
)
public final class CameraStatus {
  /**
   * Image timestamp (microseconds since UNIX epoch, according to camera clock) 
   */
  private final BigInteger timeUsec;

  /**
   * Parameter 1 (meaning depends on event, see {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CameraStatusTypes} enum) 
   */
  private final float p1;

  /**
   * Parameter 2 (meaning depends on event, see {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CameraStatusTypes} enum) 
   */
  private final float p2;

  /**
   * Parameter 3 (meaning depends on event, see {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CameraStatusTypes} enum) 
   */
  private final float p3;

  /**
   * Parameter 4 (meaning depends on event, see {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CameraStatusTypes} enum) 
   */
  private final float p4;

  /**
   * Image index 
   */
  private final int imgIdx;

  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Camera ID 
   */
  private final int camIdx;

  /**
   * See {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CameraStatusTypes} enum for definition of the bitmask 
   */
  private final CameraStatusTypes eventId;

  private CameraStatus(BigInteger timeUsec, float p1, float p2, float p3, float p4, int imgIdx,
      int targetSystem, int camIdx, CameraStatusTypes eventId) {
    this.timeUsec = timeUsec;
    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
    this.p4 = p4;
    this.imgIdx = imgIdx;
    this.targetSystem = targetSystem;
    this.camIdx = camIdx;
    this.eventId = eventId;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "CameraStatus{timeUsec=" + timeUsec
         + ", targetSystem=" + targetSystem
         + ", camIdx=" + camIdx
         + ", imgIdx=" + imgIdx
         + ", eventId=" + eventId
         + ", p1=" + p1
         + ", p2=" + p2
         + ", p3=" + p3
         + ", p4=" + p4 + "}";
  }

  /**
   * Image timestamp (microseconds since UNIX epoch, according to camera clock) 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 8
  )
  public final BigInteger timeUsec() {
    return timeUsec;
  }

  /**
   * Parameter 1 (meaning depends on event, see {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CameraStatusTypes} enum) 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 4
  )
  public final float p1() {
    return p1;
  }

  /**
   * Parameter 2 (meaning depends on event, see {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CameraStatusTypes} enum) 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 4
  )
  public final float p2() {
    return p2;
  }

  /**
   * Parameter 3 (meaning depends on event, see {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CameraStatusTypes} enum) 
   */
  @MavlinkFieldInfo(
      position = 8,
      unitSize = 4
  )
  public final float p3() {
    return p3;
  }

  /**
   * Parameter 4 (meaning depends on event, see {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CameraStatusTypes} enum) 
   */
  @MavlinkFieldInfo(
      position = 9,
      unitSize = 4
  )
  public final float p4() {
    return p4;
  }

  /**
   * Image index 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 2
  )
  public final int imgIdx() {
    return imgIdx;
  }

  /**
   * System ID 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * Camera ID 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 1
  )
  public final int camIdx() {
    return camIdx;
  }

  /**
   * See {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CameraStatusTypes} enum for definition of the bitmask 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 1
  )
  public final CameraStatusTypes eventId() {
    return eventId;
  }

  public static class Builder {
    private BigInteger timeUsec;

    private float p1;

    private float p2;

    private float p3;

    private float p4;

    private int imgIdx;

    private int targetSystem;

    private int camIdx;

    private CameraStatusTypes eventId;

    private Builder() {
    }

    /**
     * Image timestamp (microseconds since UNIX epoch, according to camera clock) 
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
     * Parameter 1 (meaning depends on event, see {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CameraStatusTypes} enum) 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 4
    )
    public final Builder p1(float p1) {
      this.p1 = p1;
      return this;
    }

    /**
     * Parameter 2 (meaning depends on event, see {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CameraStatusTypes} enum) 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 4
    )
    public final Builder p2(float p2) {
      this.p2 = p2;
      return this;
    }

    /**
     * Parameter 3 (meaning depends on event, see {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CameraStatusTypes} enum) 
     */
    @MavlinkFieldInfo(
        position = 8,
        unitSize = 4
    )
    public final Builder p3(float p3) {
      this.p3 = p3;
      return this;
    }

    /**
     * Parameter 4 (meaning depends on event, see {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CameraStatusTypes} enum) 
     */
    @MavlinkFieldInfo(
        position = 9,
        unitSize = 4
    )
    public final Builder p4(float p4) {
      this.p4 = p4;
      return this;
    }

    /**
     * Image index 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 2
    )
    public final Builder imgIdx(int imgIdx) {
      this.imgIdx = imgIdx;
      return this;
    }

    /**
     * System ID 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 1
    )
    public final Builder targetSystem(int targetSystem) {
      this.targetSystem = targetSystem;
      return this;
    }

    /**
     * Camera ID 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 1
    )
    public final Builder camIdx(int camIdx) {
      this.camIdx = camIdx;
      return this;
    }

    /**
     * See {@link io.dronefleet.mavlink.ardupilotmega.CameraStatusTypes CameraStatusTypes} enum for definition of the bitmask 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 1
    )
    public final Builder eventId(CameraStatusTypes eventId) {
      this.eventId = eventId;
      return this;
    }

    public final CameraStatus build() {
      return new CameraStatus(timeUsec, p1, p2, p3, p4, imgIdx, targetSystem, camIdx, eventId);
    }
  }
}
