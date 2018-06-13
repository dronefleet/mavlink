package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Acknowldge sucess or failure of a flexifunction command 
 */
@MavlinkMessage(
    id = 158,
    crc = 208
)
public final class FlexifunctionCommandAck {
  /**
   * Command acknowledged 
   */
  private final int commandType;

  /**
   * result of acknowledge 
   */
  private final int result;

  private FlexifunctionCommandAck(int commandType, int result) {
    this.commandType = commandType;
    this.result = result;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Command acknowledged 
   */
  @MavlinkMessageField(
      position = 1,
      length = 2
  )
  public final int commandType() {
    return commandType;
  }

  /**
   * result of acknowledge 
   */
  @MavlinkMessageField(
      position = 2,
      length = 2
  )
  public final int result() {
    return result;
  }

  public static class Builder {
    private int commandType;

    private int result;

    private Builder() {
    }

    /**
     * Command acknowledged 
     */
    @MavlinkMessageField(
        position = 1,
        length = 2
    )
    public final Builder commandType(int commandType) {
      this.commandType = commandType;
      return this;
    }

    /**
     * result of acknowledge 
     */
    @MavlinkMessageField(
        position = 2,
        length = 2
    )
    public final Builder result(int result) {
      this.result = result;
      return this;
    }

    public final FlexifunctionCommandAck build() {
      return new FlexifunctionCommandAck(commandType, result);
    }
  }
}
