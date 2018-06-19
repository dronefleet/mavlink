package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Send Status of each log block that autopilot board might have sent 
 */
@MavlinkMessage(
    id = 185,
    crc = 186
)
public final class RemoteLogBlockStatus {
  /**
   * log data block sequence number 
   */
  private final long seqno;

  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  /**
   * log data block status 
   */
  private final MavRemoteLogDataBlockStatuses status;

  private RemoteLogBlockStatus(long seqno, int targetSystem, int targetComponent,
      MavRemoteLogDataBlockStatuses status) {
    this.seqno = seqno;
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.status = status;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "RemoteLogBlockStatus{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", seqno=" + seqno
         + ", status=" + status + "}";
  }

  /**
   * log data block sequence number 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 4
  )
  public final long seqno() {
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
   * log data block status 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 1
  )
  public final MavRemoteLogDataBlockStatuses status() {
    return status;
  }

  public static class Builder {
    private long seqno;

    private int targetSystem;

    private int targetComponent;

    private MavRemoteLogDataBlockStatuses status;

    private Builder() {
    }

    /**
     * log data block sequence number 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 4
    )
    public final Builder seqno(long seqno) {
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
     * log data block status 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 1
    )
    public final Builder status(MavRemoteLogDataBlockStatuses status) {
      this.status = status;
      return this;
    }

    public final RemoteLogBlockStatus build() {
      return new RemoteLogBlockStatus(seqno, targetSystem, targetComponent, status);
    }
  }
}
