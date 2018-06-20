package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Configure on-board Camera Control System. 
 */
@MavlinkMessageInfo(
    id = 154,
    crc = 84
)
public final class DigicamConfigure {
  /**
   * Correspondent value to given extra_param 
   */
  private final float extraValue;

  /**
   * Divisor number //e.g. 1000 means 1/1000 (0 means ignore) 
   */
  private final int shutterSpeed;

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

  private DigicamConfigure(float extraValue, int shutterSpeed, int targetSystem,
      int targetComponent, int mode, int aperture, int iso, int exposureType, int commandId,
      int engineCutOff, int extraParam) {
    this.extraValue = extraValue;
    this.shutterSpeed = shutterSpeed;
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.mode = mode;
    this.aperture = aperture;
    this.iso = iso;
    this.exposureType = exposureType;
    this.commandId = commandId;
    this.engineCutOff = engineCutOff;
    this.extraParam = extraParam;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "DigicamConfigure{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", mode=" + mode
         + ", shutterSpeed=" + shutterSpeed
         + ", aperture=" + aperture
         + ", iso=" + iso
         + ", exposureType=" + exposureType
         + ", commandId=" + commandId
         + ", engineCutOff=" + engineCutOff
         + ", extraParam=" + extraParam
         + ", extraValue=" + extraValue + "}";
  }

  /**
   * Correspondent value to given extra_param 
   */
  @MavlinkFieldInfo(
      position = 11,
      unitSize = 4
  )
  public final float extraValue() {
    return extraValue;
  }

  /**
   * Divisor number //e.g. 1000 means 1/1000 (0 means ignore) 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 2
  )
  public final int shutterSpeed() {
    return shutterSpeed;
  }

  /**
   * System ID 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * Component ID 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 1
  )
  public final int targetComponent() {
    return targetComponent;
  }

  /**
   * Mode enumeration from 1 to N //P, TV, AV, M, Etc (0 means ignore) 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 1
  )
  public final int mode() {
    return mode;
  }

  /**
   * F stop number x 10 //e.g. 28 means 2.8 (0 means ignore) 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 1
  )
  public final int aperture() {
    return aperture;
  }

  /**
   * ISO enumeration from 1 to N //e.g. 80, 100, 200, Etc (0 means ignore) 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 1
  )
  public final int iso() {
    return iso;
  }

  /**
   * Exposure type enumeration from 1 to N (0 means ignore) 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 1
  )
  public final int exposureType() {
    return exposureType;
  }

  /**
   * Command Identity (incremental loop: 0 to 255)//A command sent multiple times will be executed 
   * or pooled just once 
   */
  @MavlinkFieldInfo(
      position = 8,
      unitSize = 1
  )
  public final int commandId() {
    return commandId;
  }

  /**
   * Main engine cut-off time before camera trigger in seconds/10 (0 means no cut-off) 
   */
  @MavlinkFieldInfo(
      position = 9,
      unitSize = 1
  )
  public final int engineCutOff() {
    return engineCutOff;
  }

  /**
   * Extra parameters enumeration (0 means ignore) 
   */
  @MavlinkFieldInfo(
      position = 10,
      unitSize = 1
  )
  public final int extraParam() {
    return extraParam;
  }

  public static class Builder {
    private float extraValue;

    private int shutterSpeed;

    private int targetSystem;

    private int targetComponent;

    private int mode;

    private int aperture;

    private int iso;

    private int exposureType;

    private int commandId;

    private int engineCutOff;

    private int extraParam;

    private Builder() {
    }

    /**
     * Correspondent value to given extra_param 
     */
    @MavlinkFieldInfo(
        position = 11,
        unitSize = 4
    )
    public final Builder extraValue(float extraValue) {
      this.extraValue = extraValue;
      return this;
    }

    /**
     * Divisor number //e.g. 1000 means 1/1000 (0 means ignore) 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 2
    )
    public final Builder shutterSpeed(int shutterSpeed) {
      this.shutterSpeed = shutterSpeed;
      return this;
    }

    /**
     * System ID 
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
     * Component ID 
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
     * Mode enumeration from 1 to N //P, TV, AV, M, Etc (0 means ignore) 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 1
    )
    public final Builder mode(int mode) {
      this.mode = mode;
      return this;
    }

    /**
     * F stop number x 10 //e.g. 28 means 2.8 (0 means ignore) 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 1
    )
    public final Builder aperture(int aperture) {
      this.aperture = aperture;
      return this;
    }

    /**
     * ISO enumeration from 1 to N //e.g. 80, 100, 200, Etc (0 means ignore) 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 1
    )
    public final Builder iso(int iso) {
      this.iso = iso;
      return this;
    }

    /**
     * Exposure type enumeration from 1 to N (0 means ignore) 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 1
    )
    public final Builder exposureType(int exposureType) {
      this.exposureType = exposureType;
      return this;
    }

    /**
     * Command Identity (incremental loop: 0 to 255)//A command sent multiple times will be executed 
     * or pooled just once 
     */
    @MavlinkFieldInfo(
        position = 8,
        unitSize = 1
    )
    public final Builder commandId(int commandId) {
      this.commandId = commandId;
      return this;
    }

    /**
     * Main engine cut-off time before camera trigger in seconds/10 (0 means no cut-off) 
     */
    @MavlinkFieldInfo(
        position = 9,
        unitSize = 1
    )
    public final Builder engineCutOff(int engineCutOff) {
      this.engineCutOff = engineCutOff;
      return this;
    }

    /**
     * Extra parameters enumeration (0 means ignore) 
     */
    @MavlinkFieldInfo(
        position = 10,
        unitSize = 1
    )
    public final Builder extraParam(int extraParam) {
      this.extraParam = extraParam;
      return this;
    }

    public final DigicamConfigure build() {
      return new DigicamConfigure(extraValue, shutterSpeed, targetSystem, targetComponent, mode, aperture, iso, exposureType, commandId, engineCutOff, extraParam);
    }
  }
}
