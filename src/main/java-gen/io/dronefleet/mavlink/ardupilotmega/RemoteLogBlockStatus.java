package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Send Status of each log block that autopilot board might have sent 
 */
@MavlinkMessage(
    id = 185,
    crc = 186
)
public final class RemoteLogBlockStatus {
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
  private final long seqno;

  /**
   * log data block status 
   */
  private final MavRemoteLogDataBlockStatuses status;

  private RemoteLogBlockStatus(int targetSystem, int targetComponent, long seqno,
      MavRemoteLogDataBlockStatuses status) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.seqno = seqno;
    this.status = status;
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
  public final long seqno() {
    return seqno;
  }

  /**
   * log data block status 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1
  )
  public final MavRemoteLogDataBlockStatuses status() {
    return status;
  }

  public static class Builder {
    private int targetSystem;

    private int targetComponent;

    private long seqno;

    private MavRemoteLogDataBlockStatuses status;

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
    public final Builder seqno(long seqno) {
      this.seqno = seqno;
      return this;
    }

    /**
     * log data block status 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1
    )
    public final Builder status(MavRemoteLogDataBlockStatuses status) {
      this.status = status;
      return this;
    }

    public final RemoteLogBlockStatus build() {
      return new RemoteLogBlockStatus(targetSystem, targetComponent, seqno, status);
    }
  }
}
