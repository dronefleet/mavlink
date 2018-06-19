package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Send a command with up to seven parameters to the MAV 
 */
@MavlinkMessage(
    id = 76,
    crc = 152
)
public final class CommandLong {
  /**
   * Parameter 1, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
   */
  private final float param1;

  /**
   * Parameter 2, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
   */
  private final float param2;

  /**
   * Parameter 3, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
   */
  private final float param3;

  /**
   * Parameter 4, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
   */
  private final float param4;

  /**
   * Parameter 5, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
   */
  private final float param5;

  /**
   * Parameter 6, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
   */
  private final float param6;

  /**
   * Parameter 7, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
   */
  private final float param7;

  /**
   * Command ID, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
   */
  private final MavCmd command;

  /**
   * System which should execute the command 
   */
  private final int targetSystem;

  /**
   * Component which should execute the command, 0 for all components 
   */
  private final int targetComponent;

  /**
   * 0: First transmission of this command. 1-255: Confirmation transmissions (e.g. for kill 
   * command) 
   */
  private final int confirmation;

  private CommandLong(float param1, float param2, float param3, float param4, float param5,
      float param6, float param7, MavCmd command, int targetSystem, int targetComponent,
      int confirmation) {
    this.param1 = param1;
    this.param2 = param2;
    this.param3 = param3;
    this.param4 = param4;
    this.param5 = param5;
    this.param6 = param6;
    this.param7 = param7;
    this.command = command;
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.confirmation = confirmation;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "CommandLong{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", command=" + command
         + ", confirmation=" + confirmation
         + ", param1=" + param1
         + ", param2=" + param2
         + ", param3=" + param3
         + ", param4=" + param4
         + ", param5=" + param5
         + ", param6=" + param6
         + ", param7=" + param7 + "}";
  }

  /**
   * Parameter 1, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 4
  )
  public final float param1() {
    return param1;
  }

  /**
   * Parameter 2, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 4
  )
  public final float param2() {
    return param2;
  }

  /**
   * Parameter 3, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
   */
  @MavlinkMessageField(
      position = 7,
      unitSize = 4
  )
  public final float param3() {
    return param3;
  }

  /**
   * Parameter 4, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
   */
  @MavlinkMessageField(
      position = 8,
      unitSize = 4
  )
  public final float param4() {
    return param4;
  }

  /**
   * Parameter 5, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
   */
  @MavlinkMessageField(
      position = 9,
      unitSize = 4
  )
  public final float param5() {
    return param5;
  }

  /**
   * Parameter 6, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
   */
  @MavlinkMessageField(
      position = 10,
      unitSize = 4
  )
  public final float param6() {
    return param6;
  }

  /**
   * Parameter 7, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
   */
  @MavlinkMessageField(
      position = 11,
      unitSize = 4
  )
  public final float param7() {
    return param7;
  }

  /**
   * Command ID, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 2
  )
  public final MavCmd command() {
    return command;
  }

  /**
   * System which should execute the command 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * Component which should execute the command, 0 for all components 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 1
  )
  public final int targetComponent() {
    return targetComponent;
  }

  /**
   * 0: First transmission of this command. 1-255: Confirmation transmissions (e.g. for kill 
   * command) 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 1
  )
  public final int confirmation() {
    return confirmation;
  }

  public static class Builder {
    private float param1;

    private float param2;

    private float param3;

    private float param4;

    private float param5;

    private float param6;

    private float param7;

    private MavCmd command;

    private int targetSystem;

    private int targetComponent;

    private int confirmation;

    private Builder() {
    }

    /**
     * Parameter 1, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
     */
    @MavlinkMessageField(
        position = 5,
        unitSize = 4
    )
    public final Builder param1(float param1) {
      this.param1 = param1;
      return this;
    }

    /**
     * Parameter 2, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
     */
    @MavlinkMessageField(
        position = 6,
        unitSize = 4
    )
    public final Builder param2(float param2) {
      this.param2 = param2;
      return this;
    }

    /**
     * Parameter 3, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
     */
    @MavlinkMessageField(
        position = 7,
        unitSize = 4
    )
    public final Builder param3(float param3) {
      this.param3 = param3;
      return this;
    }

    /**
     * Parameter 4, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
     */
    @MavlinkMessageField(
        position = 8,
        unitSize = 4
    )
    public final Builder param4(float param4) {
      this.param4 = param4;
      return this;
    }

    /**
     * Parameter 5, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
     */
    @MavlinkMessageField(
        position = 9,
        unitSize = 4
    )
    public final Builder param5(float param5) {
      this.param5 = param5;
      return this;
    }

    /**
     * Parameter 6, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
     */
    @MavlinkMessageField(
        position = 10,
        unitSize = 4
    )
    public final Builder param6(float param6) {
      this.param6 = param6;
      return this;
    }

    /**
     * Parameter 7, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
     */
    @MavlinkMessageField(
        position = 11,
        unitSize = 4
    )
    public final Builder param7(float param7) {
      this.param7 = param7;
      return this;
    }

    /**
     * Command ID, as defined by {@link io.dronefleet.mavlink.common.MavCmd MavCmd} enum. 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 2
    )
    public final Builder command(MavCmd command) {
      this.command = command;
      return this;
    }

    /**
     * System which should execute the command 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 1
    )
    public final Builder targetSystem(int targetSystem) {
      this.targetSystem = targetSystem;
      return this;
    }

    /**
     * Component which should execute the command, 0 for all components 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 1
    )
    public final Builder targetComponent(int targetComponent) {
      this.targetComponent = targetComponent;
      return this;
    }

    /**
     * 0: First transmission of this command. 1-255: Confirmation transmissions (e.g. for kill 
     * command) 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 1
    )
    public final Builder confirmation(int confirmation) {
      this.confirmation = confirmation;
      return this;
    }

    public final CommandLong build() {
      return new CommandLong(param1, param2, param3, param4, param5, param6, param7, command, targetSystem, targetComponent, confirmation);
    }
  }
}
