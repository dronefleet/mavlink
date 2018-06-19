package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Transmits the actual Pan, Tilt and Zoom values of the camera unit 
 */
@MavlinkMessage(
    id = 192,
    crc = 187
)
public final class PtzStatus {
  /**
   * The Pan value in 10ths of degree 
   */
  private final int pan;

  /**
   * The Tilt value in 10ths of degree 
   */
  private final int tilt;

  /**
   * The actual Zoom Value 
   */
  private final int zoom;

  private PtzStatus(int pan, int tilt, int zoom) {
    this.pan = pan;
    this.tilt = tilt;
    this.zoom = zoom;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "PtzStatus{zoom=" + zoom
         + ", pan=" + pan
         + ", tilt=" + tilt + "}";
  }

  /**
   * The Pan value in 10ths of degree 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 2
  )
  public final int pan() {
    return pan;
  }

  /**
   * The Tilt value in 10ths of degree 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 2
  )
  public final int tilt() {
    return tilt;
  }

  /**
   * The actual Zoom Value 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 1
  )
  public final int zoom() {
    return zoom;
  }

  public static class Builder {
    private int pan;

    private int tilt;

    private int zoom;

    private Builder() {
    }

    /**
     * The Pan value in 10ths of degree 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 2
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
        unitSize = 2
    )
    public final Builder tilt(int tilt) {
      this.tilt = tilt;
      return this;
    }

    /**
     * The actual Zoom Value 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 1
    )
    public final Builder zoom(int zoom) {
      this.zoom = zoom;
      return this;
    }

    public final PtzStatus build() {
      return new PtzStatus(pan, tilt, zoom);
    }
  }
}
