package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Orders generated to the SLUGS camera mount. 
 */
@MavlinkMessage(
    id = 184,
    crc = 45
)
public final class SlugsCameraOrder {
  private final int target;

  private final int pan;

  private final int tilt;

  private final int zoom;

  private final int movehome;

  private SlugsCameraOrder(int target, int pan, int tilt, int zoom, int movehome) {
    this.target = target;
    this.pan = pan;
    this.tilt = tilt;
    this.zoom = zoom;
    this.movehome = movehome;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * The system reporting the action 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final int target() {
    return target;
  }

  /**
   * Order the mount to pan: -1 left, 0 No pan motion, +1 right 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int pan() {
    return pan;
  }

  /**
   * Order the mount to tilt: -1 down, 0 No tilt motion, +1 up 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final int tilt() {
    return tilt;
  }

  /**
   * Order the zoom values 0 to 10 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1
  )
  public final int zoom() {
    return zoom;
  }

  /**
   * Orders the camera mount to move home. The other fields are ignored when this field is set. 1: move 
   * home, 0 ignored 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1
  )
  public final int movehome() {
    return movehome;
  }

  public class Builder {
    private int target;

    private int pan;

    private int tilt;

    private int zoom;

    private int movehome;

    private Builder() {
    }

    /**
     * The system reporting the action 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder target(int target) {
      this.target = target;
      return this;
    }

    /**
     * Order the mount to pan: -1 left, 0 No pan motion, +1 right 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder pan(int pan) {
      this.pan = pan;
      return this;
    }

    /**
     * Order the mount to tilt: -1 down, 0 No tilt motion, +1 up 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder tilt(int tilt) {
      this.tilt = tilt;
      return this;
    }

    /**
     * Order the zoom values 0 to 10 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1
    )
    public final Builder zoom(int zoom) {
      this.zoom = zoom;
      return this;
    }

    /**
     * Orders the camera mount to move home. The other fields are ignored when this field is set. 1: move 
     * home, 0 ignored 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1
    )
    public final Builder movehome(int movehome) {
      this.movehome = movehome;
      return this;
    }

    public final SlugsCameraOrder build() {
      return new SlugsCameraOrder(target, pan, tilt, zoom, movehome);
    }
  }
}
