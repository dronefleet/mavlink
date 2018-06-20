package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Response from a {@link io.dronefleet.mavlink.ardupilotmega.GoproCommand GoproCommand} get request 
 */
@MavlinkMessageInfo(
    id = 217,
    crc = 202
)
public final class GoproGetResponse {
  /**
   * Command ID 
   */
  private final GoproCommand cmdId;

  /**
   * Status 
   */
  private final GoproRequestStatus status;

  /**
   * Value 
   */
  private final List<Integer> value;

  private GoproGetResponse(GoproCommand cmdId, GoproRequestStatus status, List<Integer> value) {
    this.cmdId = cmdId;
    this.status = status;
    this.value = value;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "GoproGetResponse{cmdId=" + cmdId
         + ", status=" + status
         + ", value=" + value + "}";
  }

  /**
   * Command ID 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 1
  )
  public final GoproCommand cmdId() {
    return cmdId;
  }

  /**
   * Status 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 1
  )
  public final GoproRequestStatus status() {
    return status;
  }

  /**
   * Value 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 1,
      arraySize = 4
  )
  public final List<Integer> value() {
    return value;
  }

  public static class Builder {
    private GoproCommand cmdId;

    private GoproRequestStatus status;

    private List<Integer> value;

    private Builder() {
    }

    /**
     * Command ID 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 1
    )
    public final Builder cmdId(GoproCommand cmdId) {
      this.cmdId = cmdId;
      return this;
    }

    /**
     * Status 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 1
    )
    public final Builder status(GoproRequestStatus status) {
      this.status = status;
      return this;
    }

    /**
     * Value 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 1,
        arraySize = 4
    )
    public final Builder value(List<Integer> value) {
      this.value = value;
      return this;
    }

    public final GoproGetResponse build() {
      return new GoproGetResponse(cmdId, status, value);
    }
  }
}
