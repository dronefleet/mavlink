package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * WIP: Message that sets video stream settings 
 */
@MavlinkMessageInfo(
    id = 270,
    crc = 232
)
public final class SetVideoStreamSettings {
  /**
   * Frames per second (set to -1 for highest framerate possible) 
   */
  private final float framerate;

  /**
   * Bit rate in bits per second (set to -1 for auto) 
   */
  private final long bitrate;

  /**
   * Resolution horizontal in pixels (set to -1 for highest resolution possible) 
   */
  private final int resolutionH;

  /**
   * Resolution vertical in pixels (set to -1 for highest resolution possible) 
   */
  private final int resolutionV;

  /**
   * Video image rotation clockwise (0-359 degrees) 
   */
  private final int rotation;

  /**
   * system ID of the target 
   */
  private final int targetSystem;

  /**
   * component ID of the target 
   */
  private final int targetComponent;

  /**
   * Camera ID (1 for first, 2 for second, etc.) 
   */
  private final int cameraId;

  /**
   * Video stream URI 
   */
  private final String uri;

  private SetVideoStreamSettings(float framerate, long bitrate, int resolutionH, int resolutionV,
      int rotation, int targetSystem, int targetComponent, int cameraId, String uri) {
    this.framerate = framerate;
    this.bitrate = bitrate;
    this.resolutionH = resolutionH;
    this.resolutionV = resolutionV;
    this.rotation = rotation;
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.cameraId = cameraId;
    this.uri = uri;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "SetVideoStreamSettings{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", cameraId=" + cameraId
         + ", framerate=" + framerate
         + ", resolutionH=" + resolutionH
         + ", resolutionV=" + resolutionV
         + ", bitrate=" + bitrate
         + ", rotation=" + rotation
         + ", uri=" + uri + "}";
  }

  /**
   * Frames per second (set to -1 for highest framerate possible) 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 4
  )
  public final float framerate() {
    return framerate;
  }

  /**
   * Bit rate in bits per second (set to -1 for auto) 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 4
  )
  public final long bitrate() {
    return bitrate;
  }

  /**
   * Resolution horizontal in pixels (set to -1 for highest resolution possible) 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 2
  )
  public final int resolutionH() {
    return resolutionH;
  }

  /**
   * Resolution vertical in pixels (set to -1 for highest resolution possible) 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 2
  )
  public final int resolutionV() {
    return resolutionV;
  }

  /**
   * Video image rotation clockwise (0-359 degrees) 
   */
  @MavlinkFieldInfo(
      position = 8,
      unitSize = 2
  )
  public final int rotation() {
    return rotation;
  }

  /**
   * system ID of the target 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * component ID of the target 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 1
  )
  public final int targetComponent() {
    return targetComponent;
  }

  /**
   * Camera ID (1 for first, 2 for second, etc.) 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 1
  )
  public final int cameraId() {
    return cameraId;
  }

  /**
   * Video stream URI 
   */
  @MavlinkFieldInfo(
      position = 9,
      unitSize = 1,
      arraySize = 230
  )
  public final String uri() {
    return uri;
  }

  public static class Builder {
    private float framerate;

    private long bitrate;

    private int resolutionH;

    private int resolutionV;

    private int rotation;

    private int targetSystem;

    private int targetComponent;

    private int cameraId;

    private String uri;

    private Builder() {
    }

    /**
     * Frames per second (set to -1 for highest framerate possible) 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 4
    )
    public final Builder framerate(float framerate) {
      this.framerate = framerate;
      return this;
    }

    /**
     * Bit rate in bits per second (set to -1 for auto) 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 4
    )
    public final Builder bitrate(long bitrate) {
      this.bitrate = bitrate;
      return this;
    }

    /**
     * Resolution horizontal in pixels (set to -1 for highest resolution possible) 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 2
    )
    public final Builder resolutionH(int resolutionH) {
      this.resolutionH = resolutionH;
      return this;
    }

    /**
     * Resolution vertical in pixels (set to -1 for highest resolution possible) 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 2
    )
    public final Builder resolutionV(int resolutionV) {
      this.resolutionV = resolutionV;
      return this;
    }

    /**
     * Video image rotation clockwise (0-359 degrees) 
     */
    @MavlinkFieldInfo(
        position = 8,
        unitSize = 2
    )
    public final Builder rotation(int rotation) {
      this.rotation = rotation;
      return this;
    }

    /**
     * system ID of the target 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 1
    )
    public final Builder targetSystem(int targetSystem) {
      this.targetSystem = targetSystem;
      return this;
    }

    /**
     * component ID of the target 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 1
    )
    public final Builder targetComponent(int targetComponent) {
      this.targetComponent = targetComponent;
      return this;
    }

    /**
     * Camera ID (1 for first, 2 for second, etc.) 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 1
    )
    public final Builder cameraId(int cameraId) {
      this.cameraId = cameraId;
      return this;
    }

    /**
     * Video stream URI 
     */
    @MavlinkFieldInfo(
        position = 9,
        unitSize = 1,
        arraySize = 230
    )
    public final Builder uri(String uri) {
      this.uri = uri;
      return this;
    }

    public final SetVideoStreamSettings build() {
      return new SetVideoStreamSettings(framerate, bitrate, resolutionH, resolutionV, rotation, targetSystem, targetComponent, cameraId, uri);
    }
  }
}
