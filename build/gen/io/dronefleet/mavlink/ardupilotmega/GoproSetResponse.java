package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Response from a GOPRO_COMMAND set request 
 */
@MavlinkMessage(
    id = 219,
    crc = 162
)
public final class GoproSetResponse {
  private final GoproCommand cmdId;

  private final GoproRequestStatus status;

  private GoproSetResponse(GoproCommand cmdId, GoproRequestStatus status) {
    this.cmdId = cmdId;
    this.status = status;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Command ID 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final GoproCommand cmdId() {
    return cmdId;
  }

  /**
   * Status 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final GoproRequestStatus status() {
    return status;
  }

  public class Builder {
    private GoproCommand cmdId;

    private GoproRequestStatus status;

    private Builder() {
    }

    /**
     * Command ID 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder cmdId(GoproCommand cmdId) {
      this.cmdId = cmdId;
      return this;
    }

    /**
     * Status 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder status(GoproRequestStatus status) {
      this.status = status;
      return this;
    }

    public final GoproSetResponse build() {
      return new GoproSetResponse(cmdId, status);
    }
  }
}
