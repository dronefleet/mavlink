package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Orders generated to the SLUGS camera mount. 
 */
@MavlinkMessageInfo(
    id = 184,
    crc = 45
)
public final class SlugsCameraOrder {
  /**
   * The system reporting the action 
   */
  private final int target;

  /**
   * Order the mount to pan: -1 left, 0 No pan motion, +1 right 
   */
  private final int pan;

  /**
   * Order the mount to tilt: -1 down, 0 No tilt motion, +1 up 
   */
  private final int tilt;

  /**
   * Order the zoom values 0 to 10 
   */
  private final int zoom;

  /**
   * Orders the camera mount to move home. The other fields are ignored when this field is set. 1: move 
   * home, 0 ignored 
   */
  private final int movehome;

  private SlugsCameraOrder(int target, int pan, int tilt, int zoom, int movehome) {
    this.target = target;
    this.pan = pan;
    this.tilt = tilt;
    this.zoom = zoom;
    this.movehome = movehome;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "SlugsCameraOrder{target=" + target
         + ", pan=" + pan
         + ", tilt=" + tilt
         + ", zoom=" + zoom
         + ", movehome=" + movehome + "}";
  }

  /**
   * The system reporting the action 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 1
  )
  public final int target() {
    return target;
  }

  /**
   * Order the mount to pan: -1 left, 0 No pan motion, +1 right 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 1
  )
  public final int pan() {
    return pan;
  }

  /**
   * Order the mount to tilt: -1 down, 0 No tilt motion, +1 up 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 1
  )
  public final int tilt() {
    return tilt;
  }

  /**
   * Order the zoom values 0 to 10 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 1
  )
  public final int zoom() {
    return zoom;
  }

  /**
   * Orders the camera mount to move home. The other fields are ignored when this field is set. 1: move 
   * home, 0 ignored 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 1
  )
  public final int movehome() {
    return movehome;
  }

  public static class Builder {
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
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 1
    )
    public final Builder target(int target) {
      this.target = target;
      return this;
    }

    /**
     * Order the mount to pan: -1 left, 0 No pan motion, +1 right 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 1
    )
    public final Builder pan(int pan) {
      this.pan = pan;
      return this;
    }

    /**
     * Order the mount to tilt: -1 down, 0 No tilt motion, +1 up 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 1
    )
    public final Builder tilt(int tilt) {
      this.tilt = tilt;
      return this;
    }

    /**
     * Order the zoom values 0 to 10 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 1
    )
    public final Builder zoom(int zoom) {
      this.zoom = zoom;
      return this;
    }

    /**
     * Orders the camera mount to move home. The other fields are ignored when this field is set. 1: move 
     * home, 0 ignored 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 1
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
