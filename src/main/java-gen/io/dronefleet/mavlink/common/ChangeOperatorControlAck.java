package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Accept / deny control of this MAV 
 */
@MavlinkMessage(
    id = 6,
    crc = 104
)
public final class ChangeOperatorControlAck {
  /**
   * ID of the GCS this message 
   */
  private final int gcsSystemId;

  /**
   * 0: request control of this MAV, 1: Release control of this MAV 
   */
  private final int controlRequest;

  /**
   * 0: ACK, 1: NACK: Wrong passkey, 2: NACK: Unsupported passkey encryption method, 3: NACK: 
   * Already under control 
   */
  private final int ack;

  private ChangeOperatorControlAck(int gcsSystemId, int controlRequest, int ack) {
    this.gcsSystemId = gcsSystemId;
    this.controlRequest = controlRequest;
    this.ack = ack;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * ID of the GCS this message 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final int gcsSystemId() {
    return gcsSystemId;
  }

  /**
   * 0: request control of this MAV, 1: Release control of this MAV 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int controlRequest() {
    return controlRequest;
  }

  /**
   * 0: ACK, 1: NACK: Wrong passkey, 2: NACK: Unsupported passkey encryption method, 3: NACK: 
   * Already under control 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final int ack() {
    return ack;
  }

  public static class Builder {
    private int gcsSystemId;

    private int controlRequest;

    private int ack;

    private Builder() {
    }

    /**
     * ID of the GCS this message 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder gcsSystemId(int gcsSystemId) {
      this.gcsSystemId = gcsSystemId;
      return this;
    }

    /**
     * 0: request control of this MAV, 1: Release control of this MAV 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder controlRequest(int controlRequest) {
      this.controlRequest = controlRequest;
      return this;
    }

    /**
     * 0: ACK, 1: NACK: Wrong passkey, 2: NACK: Unsupported passkey encryption method, 3: NACK: 
     * Already under control 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder ack(int ack) {
      this.ack = ack;
      return this;
    }

    public final ChangeOperatorControlAck build() {
      return new ChangeOperatorControlAck(gcsSystemId, controlRequest, ack);
    }
  }
}
