package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.String;

/**
 * WIP: Information about video stream 
 */
@MavlinkMessage(
    id = 269,
    crc = 58
)
public final class VideoStreamInformation {
  /**
   * Camera ID (1 for first, 2 for second, etc.) 
   */
  private final int cameraId;

  /**
   * Current status of video streaming (0: not running, 1: in progress) 
   */
  private final int status;

  /**
   * Frames per second 
   */
  private final float framerate;

  /**
   * Resolution horizontal in pixels 
   */
  private final int resolutionH;

  /**
   * Resolution vertical in pixels 
   */
  private final int resolutionV;

  /**
   * Bit rate in bits per second 
   */
  private final long bitrate;

  /**
   * Video image rotation clockwise 
   */
  private final int rotation;

  /**
   * Video stream URI 
   */
  private final String uri;

  private VideoStreamInformation(int cameraId, int status, float framerate, int resolutionH,
      int resolutionV, long bitrate, int rotation, String uri) {
    this.cameraId = cameraId;
    this.status = status;
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
   * Camera ID (1 for first, 2 for second, etc.) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final int cameraId() {
    return cameraId;
  }

  /**
   * Current status of video streaming (0: not running, 1: in progress) 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int status() {
    return status;
  }

  /**
   * Frames per second 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final float framerate() {
    return framerate;
  }

  /**
   * Resolution horizontal in pixels 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int resolutionH() {
    return resolutionH;
  }

  /**
   * Resolution vertical in pixels 
   */
  @MavlinkMessageField(
      position = 5,
      length = 2
  )
  public final int resolutionV() {
    return resolutionV;
  }

  /**
   * Bit rate in bits per second 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final long bitrate() {
    return bitrate;
  }

  /**
   * Video image rotation clockwise 
   */
  @MavlinkMessageField(
      position = 7,
      length = 2
  )
  public final int rotation() {
    return rotation;
  }

  /**
   * Video stream URI 
   */
  @MavlinkMessageField(
      position = 8,
      length = 1,
      arraySize = 230
  )
  public final String uri() {
    return uri;
  }

  public static class Builder {
    private int cameraId;

    private int status;

    private float framerate;

    private int resolutionH;

    private int resolutionV;

    private long bitrate;

    private int rotation;

    private String uri;

    private Builder() {
    }

    /**
     * Camera ID (1 for first, 2 for second, etc.) 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder cameraId(int cameraId) {
      this.cameraId = cameraId;
      return this;
    }

    /**
     * Current status of video streaming (0: not running, 1: in progress) 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder status(int status) {
      this.status = status;
      return this;
    }

    /**
     * Frames per second 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder framerate(float framerate) {
      this.framerate = framerate;
      return this;
    }

    /**
     * Resolution horizontal in pixels 
     */
    @MavlinkMessageField(
        position = 4,
        length = 2
    )
    public final Builder resolutionH(int resolutionH) {
      this.resolutionH = resolutionH;
      return this;
    }

    /**
     * Resolution vertical in pixels 
     */
    @MavlinkMessageField(
        position = 5,
        length = 2
    )
    public final Builder resolutionV(int resolutionV) {
      this.resolutionV = resolutionV;
      return this;
    }

    /**
     * Bit rate in bits per second 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder bitrate(long bitrate) {
      this.bitrate = bitrate;
      return this;
    }

    /**
     * Video image rotation clockwise 
     */
    @MavlinkMessageField(
        position = 7,
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
        position = 8,
        length = 1,
        arraySize = 230
    )
    public final Builder uri(String uri) {
      this.uri = uri;
      return this;
    }

    public final VideoStreamInformation build() {
      return new VideoStreamInformation(cameraId, status, framerate, resolutionH, resolutionV, bitrate, rotation, uri);
    }
  }
}
