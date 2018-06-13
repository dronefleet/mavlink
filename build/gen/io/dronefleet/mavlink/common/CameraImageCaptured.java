package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Float;
import java.lang.Integer;
import java.math.BigInteger;
import java.util.List;

/**
 * Information about a captured image 
 */
@MavlinkMessage(
    id = 263,
    crc = 133
)
public final class CameraImageCaptured {
  private final long timeBootMs;

  private final BigInteger timeUtc;

  private final int cameraId;

  private final int lat;

  private final int lon;

  private final int alt;

  private final int relativeAlt;

  private final List<Float> q;

  private final int imageIndex;

  private final int captureResult;

  private final List<Integer> fileUrl;

  private CameraImageCaptured(long timeBootMs, BigInteger timeUtc, int cameraId, int lat, int lon,
      int alt, int relativeAlt, List<Float> q, int imageIndex, int captureResult,
      List<Integer> fileUrl) {
    this.timeBootMs = timeBootMs;
    this.timeUtc = timeUtc;
    this.cameraId = cameraId;
    this.lat = lat;
    this.lon = lon;
    this.alt = alt;
    this.relativeAlt = relativeAlt;
    this.q = q;
    this.imageIndex = imageIndex;
    this.captureResult = captureResult;
    this.fileUrl = fileUrl;
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
   * Timestamp (microseconds since UNIX epoch) in UTC. 0 for unknown. 
   */
  @MavlinkMessageField(
      position = 2,
      length = 8
  )
  public final BigInteger timeUtc() {
    return timeUtc;
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
   * Latitude, expressed as degrees * 1E7 where image was taken 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final int lat() {
    return lat;
  }

  /**
   * Longitude, expressed as degrees * 1E7 where capture was taken 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final int lon() {
    return lon;
  }

  /**
   * Altitude in meters, expressed as * 1E3 (AMSL, not WGS84) where image was taken 
   */
  @MavlinkMessageField(
      position = 6,
      length = 4
  )
  public final int alt() {
    return alt;
  }

  /**
   * Altitude above ground in meters, expressed as * 1E3 where image was taken 
   */
  @MavlinkMessageField(
      position = 7,
      length = 4
  )
  public final int relativeAlt() {
    return relativeAlt;
  }

  /**
   * Quaternion of camera orientation (w, x, y, z order, zero-rotation is 0, 0, 0, 0) 
   */
  @MavlinkMessageField(
      position = 8,
      length = 4,
      arraySize = 4
  )
  public final List<Float> q() {
    return q;
  }

  /**
   * Zero based index of this image (image count since armed -1) 
   */
  @MavlinkMessageField(
      position = 9,
      length = 4
  )
  public final int imageIndex() {
    return imageIndex;
  }

  /**
   * Boolean indicating success (1) or failure (0) while capturing this image. 
   */
  @MavlinkMessageField(
      position = 10,
      length = 1
  )
  public final int captureResult() {
    return captureResult;
  }

  /**
   * URL of image taken. Either local storage or http://foo.jpg if camera provides an HTTP 
   * interface. 
   */
  @MavlinkMessageField(
      position = 11,
      length = 1,
      arraySize = 205
  )
  public final List<Integer> fileUrl() {
    return fileUrl;
  }

  public class Builder {
    private long timeBootMs;

    private BigInteger timeUtc;

    private int cameraId;

    private int lat;

    private int lon;

    private int alt;

    private int relativeAlt;

    private List<Float> q;

    private int imageIndex;

    private int captureResult;

    private List<Integer> fileUrl;

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
     * Timestamp (microseconds since UNIX epoch) in UTC. 0 for unknown. 
     */
    @MavlinkMessageField(
        position = 2,
        length = 8
    )
    public final Builder timeUtc(BigInteger timeUtc) {
      this.timeUtc = timeUtc;
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
     * Latitude, expressed as degrees * 1E7 where image was taken 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder lat(int lat) {
      this.lat = lat;
      return this;
    }

    /**
     * Longitude, expressed as degrees * 1E7 where capture was taken 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder lon(int lon) {
      this.lon = lon;
      return this;
    }

    /**
     * Altitude in meters, expressed as * 1E3 (AMSL, not WGS84) where image was taken 
     */
    @MavlinkMessageField(
        position = 6,
        length = 4
    )
    public final Builder alt(int alt) {
      this.alt = alt;
      return this;
    }

    /**
     * Altitude above ground in meters, expressed as * 1E3 where image was taken 
     */
    @MavlinkMessageField(
        position = 7,
        length = 4
    )
    public final Builder relativeAlt(int relativeAlt) {
      this.relativeAlt = relativeAlt;
      return this;
    }

    /**
     * Quaternion of camera orientation (w, x, y, z order, zero-rotation is 0, 0, 0, 0) 
     */
    @MavlinkMessageField(
        position = 8,
        length = 4,
        arraySize = 4
    )
    public final Builder q(List<Float> q) {
      this.q = q;
      return this;
    }

    /**
     * Zero based index of this image (image count since armed -1) 
     */
    @MavlinkMessageField(
        position = 9,
        length = 4
    )
    public final Builder imageIndex(int imageIndex) {
      this.imageIndex = imageIndex;
      return this;
    }

    /**
     * Boolean indicating success (1) or failure (0) while capturing this image. 
     */
    @MavlinkMessageField(
        position = 10,
        length = 1
    )
    public final Builder captureResult(int captureResult) {
      this.captureResult = captureResult;
      return this;
    }

    /**
     * URL of image taken. Either local storage or http://foo.jpg if camera provides an HTTP 
     * interface. 
     */
    @MavlinkMessageField(
        position = 11,
        length = 1,
        arraySize = 205
    )
    public final Builder fileUrl(List<Integer> fileUrl) {
      this.fileUrl = fileUrl;
      return this;
    }

    public final CameraImageCaptured build() {
      return new CameraImageCaptured(timeBootMs, timeUtc, cameraId, lat, lon, alt, relativeAlt, q, imageIndex, captureResult, fileUrl);
    }
  }
}
