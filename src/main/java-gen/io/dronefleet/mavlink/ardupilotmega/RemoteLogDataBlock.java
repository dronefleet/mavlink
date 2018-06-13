package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
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
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  /**
   * log data block sequence number 
   */
  private final MavRemoteLogDataBlockCommands seqno;

  /**
   * log data block 
   */
  private final List<Integer> data;

  private RemoteLogDataBlock(int targetSystem, int targetComponent,
      MavRemoteLogDataBlockCommands seqno, List<Integer> data) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.seqno = seqno;
    this.data = data;
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
   * log data block sequence number 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final MavRemoteLogDataBlockCommands seqno() {
    return seqno;
  }

  /**
   * log data block 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1,
      arraySize = 200
  )
  public final List<Integer> data() {
    return data;
  }

  public static class Builder {
    private int targetSystem;

    private int targetComponent;

    private MavRemoteLogDataBlockCommands seqno;

    private List<Integer> data;

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
     * log data block sequence number 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder seqno(MavRemoteLogDataBlockCommands seqno) {
      this.seqno = seqno;
      return this;
    }

    /**
     * log data block 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1,
        arraySize = 200
    )
    public final Builder data(List<Integer> data) {
      this.data = data;
      return this;
    }

    public final RemoteLogDataBlock build() {
      return new RemoteLogDataBlock(targetSystem, targetComponent, seqno, data);
    }
  }
}
