package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.String;

/**
 * WIP: Message that sets video stream settings 
 */
@MavlinkMessage(
    id = 270,
    crc = 232
)
public final class SetVideoStreamSettings {
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
   * Frames per second (set to -1 for highest framerate possible) 
   */
  private final float framerate;

  /**
   * Resolution horizontal in pixels (set to -1 for highest resolution possible) 
   */
  private final int resolutionH;

  /**
   * Resolution vertical in pixels (set to -1 for highest resolution possible) 
   */
  private final int resolutionV;

  /**
   * Bit rate in bits per second (set to -1 for auto) 
   */
  private final long bitrate;

  /**
   * Video image rotation clockwise (0-359 degrees) 
   */
  private final int rotation;

  /**
   * Video stream URI 
   */
  private final String uri;

  private SetVideoStreamSettings(int targetSystem, int targetComponent, int cameraId,
      float framerate, int resolutionH, int resolutionV, long bitrate, int rotation, String uri) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.cameraId = cameraId;
    this.framerate = framerate;
    this.resolutionH = resolutionH;
    this.resolutionV = resolutionV;
    this.bitrate = bitrate;
    this.rotation = rotation;
    this.uri = uri;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * system ID of the target 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * component ID of the target 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int targetComponent() {
    return targetComponent;
  }

  /**
   * Camera ID (1 for first, 2 for second, etc.) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final int cameraId() {
    return cameraId;
  }

  /**
   * Frames per second (set to -1 for highest framerate possible) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float framerate() {
    return framerate;
  }

  /**
   * Resolution horizontal in pixels (set to -1 for highest resolution possible) 
   */
  @MavlinkMessageField(
      position = 5,
      length = 2
  )
  public final int resolutionH() {
    return resolutionH;
  }

  /**
   * Resolution vertical in pixels (set to -1 for highest resolution possible) 
   */
  @MavlinkMessageField(
      position = 6,
      length = 2
  )
  public final int resolutionV() {
    return resolutionV;
  }

  /**
   * Bit rate in bits per second (set to -1 for auto) 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final long bitrate() {
    return bitrate;
  }

  /**
   * Video image rotation clockwise (0-359 degrees) 
   */
  @MavlinkMessageField(
      position = 8,
      length = 2
  )
  public final int rotation() {
    return rotation;
  }

  /**
   * Video stream URI 
   */
  @MavlinkMessageField(
      position = 9,
      length = 1,
      arraySize = 230
  )
  public final String uri() {
    return uri;
  }

  public static class Builder {
    private int targetSystem;

    private int targetComponent;

    private int cameraId;

    private float framerate;

    private int resolutionH;

    private int resolutionV;

    private long bitrate;

    private int rotation;

    private String uri;

    private Builder() {
    }

    /**
     * system ID of the target 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder targetSystem(int targetSystem) {
      this.targetSystem = targetSystem;
      return this;
    }

    /**
     * component ID of the target 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder targetComponent(int targetComponent) {
      this.targetComponent = targetComponent;
      return this;
    }

    /**
     * Camera ID (1 for first, 2 for second, etc.) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder cameraId(int cameraId) {
      this.cameraId = cameraId;
      return this;
    }

    /**
     * Frames per second (set to -1 for highest framerate possible) 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder framerate(float framerate) {
      this.framerate = framerate;
      return this;
    }

    /**
     * Resolution horizontal in pixels (set to -1 for highest resolution possible) 
     */
    @MavlinkMessageField(
        position = 5,
        length = 2
    )
    public final Builder resolutionH(int resolutionH) {
      this.resolutionH = resolutionH;
      return this;
    }

    /**
     * Resolution vertical in pixels (set to -1 for highest resolution possible) 
     */
    @MavlinkMessageField(
        position = 6,
        length = 2
    )
    public final Builder resolutionV(int resolutionV) {
      this.resolutionV = resolutionV;
      return this;
    }

    /**
     * Bit rate in bits per second (set to -1 for auto) 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder bitrate(long bitrate) {
      this.bitrate = bitrate;
      return this;
    }

    /**
     * Video image rotation clockwise (0-359 degrees) 
     */
    @MavlinkMessageField(
        position = 8,
        length = 2
    )
    public final Builder rotation(int rotation) {
      this.rotation = rotation;
      return this;
    }

    /**
     * Video stream URI 
     */
    @MavlinkMessageField(
        position = 9,
        length = 1,
        arraySize = 230
    )
    public final Builder uri(String uri) {
      this.uri = uri;
      return this;
    }

    public final SetVideoStreamSettings build() {
      return new SetVideoStreamSettings(targetSystem, targetComponent, cameraId, framerate, resolutionH, resolutionV, bitrate, rotation, uri);
    }
  }
}
