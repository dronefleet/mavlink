package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.util.List;

/**
 * Information about a camera 
 */
@MavlinkMessage(
    id = 259,
    crc = 92
)
public final class CameraInformation {
  private final long timeBootMs;

  private final List<Integer> vendorName;

  private final List<Integer> modelName;

  private final long firmwareVersion;

  private final float focalLength;

  private final float sensorSizeH;

  private final float sensorSizeV;

  private final int resolutionH;

  private final int resolutionV;

  private final int lensId;

  private final CameraCapFlags flags;

  private final int camDefinitionVersion;

  private final List<Integer> camDefinitionUri;

  private CameraInformation(long timeBootMs, List<Integer> vendorName, List<Integer> modelName,
      long firmwareVersion, float focalLength, float sensorSizeH, float sensorSizeV,
      int resolutionH, int resolutionV, int lensId, CameraCapFlags flags, int camDefinitionVersion,
      List<Integer> camDefinitionUri) {
    this.timeBootMs = timeBootMs;
    this.vendorName = vendorName;
    this.modelName = modelName;
    this.firmwareVersion = firmwareVersion;
    this.focalLength = focalLength;
    this.sensorSizeH = sensorSizeH;
    this.sensorSizeV = sensorSizeV;
    this.resolutionH = resolutionH;
    this.resolutionV = resolutionV;
    this.lensId = lensId;
    this.flags = flags;
    this.camDefinitionVersion = camDefinitionVersion;
    this.camDefinitionUri = camDefinitionUri;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Timestamp (milliseconds since system boot) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final long timeBootMs() {
    return timeBootMs;
  }

  /**
   * Name of the camera vendor 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1,
      arraySize = 32
  )
  public final List<Integer> vendorName() {
    return vendorName;
  }

  /**
   * Name of the camera model 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1,
      arraySize = 32
  )
  public final List<Integer> modelName() {
    return modelName;
  }

  /**
   * Version of the camera firmware (v << 24 & 0xff = Dev, v << 16 & 0xff = Patch, v << 8 & 0xff = Minor, v & 
   * 0xff = Major) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final long firmwareVersion() {
    return firmwareVersion;
  }

  /**
   * Focal length in mm 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final float focalLength() {
    return focalLength;
  }

  /**
   * Image sensor size horizontal in mm 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final float sensorSizeH() {
    return sensorSizeH;
  }

  /**
   * Image sensor size vertical in mm 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final float sensorSizeV() {
    return sensorSizeV;
  }

  /**
   * Image resolution in pixels horizontal 
   */
  @MavlinkMessageField(
      position = 8,
      length = 2
  )
  public final int resolutionH() {
    return resolutionH;
  }

  /**
   * Image resolution in pixels vertical 
   */
  @MavlinkMessageField(
      position = 9,
      length = 2
  )
  public final int resolutionV() {
    return resolutionV;
  }

  /**
   * Reserved for a lens ID 
   */
  @MavlinkMessageField(
      position = 10,
      length = 1
  )
  public final int lensId() {
    return lensId;
  }

  /**
   * CAMERA_CAP_FLAGS enum flags (bitmap) describing camera capabilities. 
   */
  @MavlinkMessageField(
      position = 11,
      length = 4
  )
  public final CameraCapFlags flags() {
    return flags;
  }

  /**
   * Camera definition version (iteration) 
   */
  @MavlinkMessageField(
      position = 12,
      length = 2
  )
  public final int camDefinitionVersion() {
    return camDefinitionVersion;
  }

  /**
   * Camera definition URI (if any, otherwise only basic functions will be available). 
   */
  @MavlinkMessageField(
      position = 13,
      length = 1,
      arraySize = 140
  )
  public final List<Integer> camDefinitionUri() {
    return camDefinitionUri;
  }

  public class Builder {
    private long timeBootMs;

    private List<Integer> vendorName;

    private List<Integer> modelName;

    private long firmwareVersion;

    private float focalLength;

    private float sensorSizeH;

    private float sensorSizeV;

    private int resolutionH;

    private int resolutionV;

    private int lensId;

    private CameraCapFlags flags;

    private int camDefinitionVersion;

    private List<Integer> camDefinitionUri;

    private Builder() {
    }

    /**
     * Timestamp (milliseconds since system boot) 
     */
    @MavlinkMessageField(
        position = 1,
        length = 4
    )
    public final Builder timeBootMs(long timeBootMs) {
      this.timeBootMs = timeBootMs;
      return this;
    }

    /**
     * Name of the camera vendor 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1,
        arraySize = 32
    )
    public final Builder vendorName(List<Integer> vendorName) {
      this.vendorName = vendorName;
      return this;
    }

    /**
     * Name of the camera model 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1,
        arraySize = 32
    )
    public final Builder modelName(List<Integer> modelName) {
      this.modelName = modelName;
      return this;
    }

    /**
     * Version of the camera firmware (v << 24 & 0xff = Dev, v << 16 & 0xff = Patch, v << 8 & 0xff = Minor, v & 
     * 0xff = Major) 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder firmwareVersion(long firmwareVersion) {
      this.firmwareVersion = firmwareVersion;
      return this;
    }

    /**
     * Focal length in mm 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder focalLength(float focalLength) {
      this.focalLength = focalLength;
      return this;
    }

    /**
     * Image sensor size horizontal in mm 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder sensorSizeH(float sensorSizeH) {
      this.sensorSizeH = sensorSizeH;
      return this;
    }

    /**
     * Image sensor size vertical in mm 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder sensorSizeV(float sensorSizeV) {
      this.sensorSizeV = sensorSizeV;
      return this;
    }

    /**
     * Image resolution in pixels horizontal 
     */
    @MavlinkMessageField(
        position = 8,
        length = 2
    )
    public final Builder resolutionH(int resolutionH) {
      this.resolutionH = resolutionH;
      return this;
    }

    /**
     * Image resolution in pixels vertical 
     */
    @MavlinkMessageField(
        position = 9,
        length = 2
    )
    public final Builder resolutionV(int resolutionV) {
      this.resolutionV = resolutionV;
      return this;
    }

    /**
     * Reserved for a lens ID 
     */
    @MavlinkMessageField(
        position = 10,
        length = 1
    )
    public final Builder lensId(int lensId) {
      this.lensId = lensId;
      return this;
    }

    /**
     * CAMERA_CAP_FLAGS enum flags (bitmap) describing camera capabilities. 
     */
    @MavlinkMessageField(
        position = 11,
        length = 4
    )
    public final Builder flags(CameraCapFlags flags) {
      this.flags = flags;
      return this;
    }

    /**
     * Camera definition version (iteration) 
     */
    @MavlinkMessageField(
        position = 12,
        length = 2
    )
    public final Builder camDefinitionVersion(int camDefinitionVersion) {
      this.camDefinitionVersion = camDefinitionVersion;
      return this;
    }

    /**
     * Camera definition URI (if any, otherwise only basic functions will be available). 
     */
    @MavlinkMessageField(
        position = 13,
        length = 1,
        arraySize = 140
    )
    public final Builder camDefinitionUri(List<Integer> camDefinitionUri) {
      this.camDefinitionUri = camDefinitionUri;
      return this;
    }

    public final CameraInformation build() {
      return new CameraInformation(timeBootMs, vendorName, modelName, firmwareVersion, focalLength, sensorSizeH, sensorSizeV, resolutionH, resolutionV, lensId, flags, camDefinitionVersion, camDefinitionUri);
    }
  }
}
