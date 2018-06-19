package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Send a block of log data to remote location 
 */
@MavlinkMessage(
    id = 184,
    crc = 159
)
public final class RemoteLogDataBlock {
  /**
   * log data block sequence number 
   */
  private final MavRemoteLogDataBlockCommands seqno;

  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  /**
   * log data block 
   */
  private final List<Integer> data;

  private RemoteLogDataBlock(MavRemoteLogDataBlockCommands seqno, int targetSystem,
      int targetComponent, List<Integer> data) {
    this.seqno = seqno;
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.data = data;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "RemoteLogDataBlock{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", seqno=" + seqno
         + ", data=" + data + "}";
  }

  /**
   * log data block sequence number 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 4
  )
  public final MavRemoteLogDataBlockCommands seqno() {
    return seqno;
  }

  /**
   * System ID 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * Component ID 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 1
  )
  public final int targetComponent() {
    return targetComponent;
  }

  /**
   * log data block 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 1,
      arraySize = 200
  )
  public final List<Integer> data() {
    return data;
  }

  public static class Builder {
    private MavRemoteLogDataBlockCommands seqno;

    private int targetSystem;

    private int targetComponent;

    private List<Integer> data;

    private Builder() {
    }

    /**
     * log data block sequence number 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 4
    )
    public final Builder seqno(MavRemoteLogDataBlockCommands seqno) {
      this.seqno = seqno;
      return this;
    }

    /**
     * System ID 
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
     * Component ID 
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
     * log data block 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 1,
        arraySize = 200
    )
    public final Builder data(List<Integer> data) {
      this.data = data;
      return this;
    }

    public final RemoteLogDataBlock build() {
      return new RemoteLogDataBlock(seqno, targetSystem, targetComponent, data);
    }
  }
}
