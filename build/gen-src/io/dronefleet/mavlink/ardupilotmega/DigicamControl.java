package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Control on-board Camera Control System to take shots. 
 */
@MavlinkMessage(
    id = 155,
    crc = 22
)
public final class DigicamControl {
  private final int targetSystem;

  private final int targetComponent;

  private final int session;

  private final int zoomPos;

  private final int zoomStep;

  private final int focusLock;

  private final int shot;

  private final int commandId;

  private final int extraParam;

  private final float extraValue;

  private DigicamControl(int targetSystem, int targetComponent, int session, int zoomPos,
      int zoomStep, int focusLock, int shot, int commandId, int extraParam, float extraValue) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.session = session;
    this.zoomPos = zoomPos;
    this.zoomStep = zoomStep;
    this.focusLock = focusLock;
    this.shot = shot;
    this.commandId = commandId;
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
   * 0: stop, 1: start or keep it up //Session control e.g. show/hide lens 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final int session() {
    return session;
  }

  /**
   * 1 to N //Zoom's absolute position (0 means ignore) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1
  )
  public final int zoomPos() {
    return zoomPos;
  }

  /**
   * -100 to 100 //Zooming step value to offset zoom from the current position 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1
  )
  public final int zoomStep() {
    return zoomStep;
  }

  /**
   * 0: unlock focus or keep unlocked, 1: lock focus or keep locked, 3: re-lock focus 
   */
  @MavlinkMessageField(
      position = 6,
      length = 1
  )
  public final int focusLock() {
    return focusLock;
  }

  /**
   * 0: ignore, 1: shot or start filming 
   */
  @MavlinkMessageField(
      position = 7,
      length = 1
  )
  public final int shot() {
    return shot;
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
   * Extra parameters enumeration (0 means ignore) 
   */
  @MavlinkMessageField(
      position = 9,
      length = 1
  )
  public final int extraParam() {
    return extraParam;
  }

  /**
   * Correspondent value to given extra_param 
   */
  @MavlinkMessageField(
      position = 10,
      length = 4
  )
  public final float extraValue() {
    return extraValue;
  }

  public class Builder {
    private int targetSystem;

    private int targetComponent;

    private int session;

    private int zoomPos;

    private int zoomStep;

    private int focusLock;

    private int shot;

    private int commandId;

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
     * 0: stop, 1: start or keep it up //Session control e.g. show/hide lens 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder session(int session) {
      this.session = session;
      return this;
    }

    /**
     * 1 to N //Zoom's absolute position (0 means ignore) 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1
    )
    public final Builder zoomPos(int zoomPos) {
      this.zoomPos = zoomPos;
      return this;
    }

    /**
     * -100 to 100 //Zooming step value to offset zoom from the current position 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1
    )
    public final Builder zoomStep(int zoomStep) {
      this.zoomStep = zoomStep;
      return this;
    }

    /**
     * 0: unlock focus or keep unlocked, 1: lock focus or keep locked, 3: re-lock focus 
     */
    @MavlinkMessageField(
        position = 6,
        length = 1
    )
    public final Builder focusLock(int focusLock) {
      this.focusLock = focusLock;
      return this;
    }

    /**
     * 0: ignore, 1: shot or start filming 
     */
    @MavlinkMessageField(
        position = 7,
        length = 1
    )
    public final Builder shot(int shot) {
      this.shot = shot;
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
     * Extra parameters enumeration (0 means ignore) 
     */
    @MavlinkMessageField(
        position = 9,
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
        position = 10,
        length = 4
    )
    public final Builder extraValue(float extraValue) {
      this.extraValue = extraValue;
      return this;
    }

    public final DigicamControl build() {
      return new DigicamControl(targetSystem, targetComponent, session, zoomPos, zoomStep, focusLock, shot, commandId, extraParam, extraValue);
    }
  }
}
