package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Transmits the actual Pan, Tilt and Zoom values of the camera unit 
 */
@MavlinkMessage(
    id = 192,
    crc = 187
)
public final class PtzStatus {
  /**
   * The actual Zoom Value 
   */
  private final int zoom;

  /**
   * The Pan value in 10ths of degree 
   */
  private final int pan;

  /**
   * The Tilt value in 10ths of degree 
   */
  private final int tilt;

  private PtzStatus(int zoom, int pan, int tilt) {
    this.zoom = zoom;
    this.pan = pan;
    this.tilt = tilt;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * The actual Zoom Value 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final int zoom() {
    return zoom;
  }

  /**
   * The Pan value in 10ths of degree 
   */
  @MavlinkMessageField(
      position = 2,
      length = 2
  )
  public final int pan() {
    return pan;
  }

  /**
   * The Tilt value in 10ths of degree 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int tilt() {
    return tilt;
  }

  public static class Builder {
    private int zoom;

    private int pan;

    private int tilt;

    private Builder() {
    }

    /**
     * The actual Zoom Value 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder zoom(int zoom) {
      this.zoom = zoom;
      return this;
    }

    /**
     * The Pan value in 10ths of degree 
     */
    @MavlinkMessageField(
        position = 2,
        length = 2
    )
    public final Builder pan(int pan) {
      this.pan = pan;
      return this;
    }

    /**
     * The Tilt value in 10ths of degree 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder tilt(int tilt) {
      this.tilt = tilt;
      return this;
    }

    public final PtzStatus build() {
      return new PtzStatus(zoom, pan, tilt);
    }
  }
}
