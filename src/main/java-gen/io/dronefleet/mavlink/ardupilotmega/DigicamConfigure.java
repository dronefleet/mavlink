package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Configure on-board Camera Control System. 
 */
@MavlinkMessage(
    id = 154,
    crc = 84
)
public final class DigicamConfigure {
  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  /**
   * Mode enumeration from 1 to N //P, TV, AV, M, Etc (0 means ignore) 
   */
  private final int mode;

  /**
   * Divisor number //e.g. 1000 means 1/1000 (0 means ignore) 
   */
  private final int shutterSpeed;

  /**
   * F stop number x 10 //e.g. 28 means 2.8 (0 means ignore) 
   */
  private final int aperture;

  /**
   * ISO enumeration from 1 to N //e.g. 80, 100, 200, Etc (0 means ignore) 
   */
  private final int iso;

  /**
   * Exposure type enumeration from 1 to N (0 means ignore) 
   */
  private final int exposureType;

  /**
   * Command Identity (incremental loop: 0 to 255)//A command sent multiple times will be executed 
   * or pooled just once 
   */
  private final int commandId;

  /**
   * Main engine cut-off time before camera trigger in seconds/10 (0 means no cut-off) 
   */
  private final int engineCutOff;

  /**
   * Extra parameters enumeration (0 means ignore) 
   */
  private final int extraParam;

  /**
   * Correspondent value to given extra_param 
   */
  private final float extraValue;

  private DigicamConfigure(int targetSystem, int targetComponent, int mode, int shutterSpeed,
      int aperture, int iso, int exposureType, int commandId, int engineCutOff, int extraParam,
      float extraValue) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.mode = mode;
    this.shutterSpeed = shutterSpeed;
    this.aperture = aperture;
    this.iso = iso;
    this.exposureType = exposureType;
    this.commandId = commandId;
    this.engineCutOff = engineCutOff;
    this.extraParam = extraParam;
    this.extraValue = extraValue;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * System ID 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * Component ID 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int targetComponent() {
    return targetComponent;
  }

  /**
   * Mode enumeration from 1 to N //P, TV, AV, M, Etc (0 means ignore) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final int mode() {
    return mode;
  }

  /**
   * Divisor number //e.g. 1000 means 1/1000 (0 means ignore) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int shutterSpeed() {
    return shutterSpeed;
  }

  /**
   * F stop number x 10 //e.g. 28 means 2.8 (0 means ignore) 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1
  )
  public final int aperture() {
    return aperture;
  }

  /**
   * ISO enumeration from 1 to N //e.g. 80, 100, 200, Etc (0 means ignore) 
   */
  @MavlinkMessageField(
      position = 6,
      length = 1
  )
  public final int iso() {
    return iso;
  }

  /**
   * Exposure type enumeration from 1 to N (0 means ignore) 
   */
  @MavlinkMessageField(
      position = 7,
      length = 1
  )
  public final int exposureType() {
    return exposureType;
  }

  /**
   * Command Identity (incremental loop: 0 to 255)//A command sent multiple times will be executed 
   * or pooled just once 
   */
  @MavlinkMessageField(
      position = 8,
      length = 1
  )
  public final int commandId() {
    return commandId;
  }

  /**
   * Main engine cut-off time before camera trigger in seconds/10 (0 means no cut-off) 
   */
  @MavlinkMessageField(
      position = 9,
      length = 1
  )
  public final int engineCutOff() {
    return engineCutOff;
  }

  /**
   * Extra parameters enumeration (0 means ignore) 
   */
  @MavlinkMessageField(
      position = 10,
      length = 1
  )
  public final int extraParam() {
    return extraParam;
  }

  /**
   * Correspondent value to given extra_param 
   */
  @MavlinkMessageField(
      position = 11,
      length = 4
  )
  public final float extraValue() {
    return extraValue;
  }

  public static class Builder {
    private int targetSystem;

    private int targetComponent;

    private int mode;

    private int shutterSpeed;

    private int aperture;

    private int iso;

    private int exposureType;

    private int commandId;

    private int engineCutOff;

    private int extraParam;

    private float extraValue;

    private Builder() {
    }

    /**
     * System ID 
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
     * Component ID 
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
     * Mode enumeration from 1 to N //P, TV, AV, M, Etc (0 means ignore) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder mode(int mode) {
      this.mode = mode;
      return this;
    }

    /**
     * Divisor number //e.g. 1000 means 1/1000 (0 means ignore) 
     */
    @MavlinkMessageField(
        position = 4,
        length = 2
    )
    public final Builder shutterSpeed(int shutterSpeed) {
      this.shutterSpeed = shutterSpeed;
      return this;
    }

    /**
     * F stop number x 10 //e.g. 28 means 2.8 (0 means ignore) 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1
    )
    public final Builder aperture(int aperture) {
      this.aperture = aperture;
      return this;
    }

    /**
     * ISO enumeration from 1 to N //e.g. 80, 100, 200, Etc (0 means ignore) 
     */
    @MavlinkMessageField(
        position = 6,
        length = 1
    )
    public final Builder iso(int iso) {
      this.iso = iso;
      return this;
    }

    /**
     * Exposure type enumeration from 1 to N (0 means ignore) 
     */
    @MavlinkMessageField(
        position = 7,
        length = 1
    )
    public final Builder exposureType(int exposureType) {
      this.exposureType = exposureType;
      return this;
    }

    /**
     * Command Identity (incremental loop: 0 to 255)//A command sent multiple times will be executed 
     * or pooled just once 
     */
    @MavlinkMessageField(
        position = 8,
        length = 1
    )
    public final Builder commandId(int commandId) {
      this.commandId = commandId;
      return this;
    }

    /**
     * Main engine cut-off time before camera trigger in seconds/10 (0 means no cut-off) 
     */
    @MavlinkMessageField(
        position = 9,
        length = 1
    )
    public final Builder engineCutOff(int engineCutOff) {
      this.engineCutOff = engineCutOff;
      return this;
    }

    /**
     * Extra parameters enumeration (0 means ignore) 
     */
    @MavlinkMessageField(
        position = 10,
        length = 1
    )
    public final Builder extraParam(int extraParam) {
      this.extraParam = extraParam;
      return this;
    }

    /**
     * Correspondent value to given extra_param 
     */
    @MavlinkMessageField(
        position = 11,
        length = 4
    )
    public final Builder extraValue(float extraValue) {
      this.extraValue = extraValue;
      return this;
    }

    public final DigicamConfigure build() {
      return new DigicamConfigure(targetSystem, targetComponent, mode, shutterSpeed, aperture, iso, exposureType, commandId, engineCutOff, extraParam, extraValue);
    }
  }
}
