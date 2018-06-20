package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * THIS INTERFACE IS DEPRECATED. USE SET_MESSAGE_INTERVAL INSTEAD. 
 */
@MavlinkMessageInfo(
    id = 66,
    crc = 148
)
public final class RequestDataStream {
  /**
   * The requested message rate 
   */
  private final int reqMessageRate;

  /**
   * The target requested to send the message stream. 
   */
  private final int targetSystem;

  /**
   * The target requested to send the message stream. 
   */
  private final int targetComponent;

  /**
   * The ID of the requested data stream 
   */
  private final int reqStreamId;

  /**
   * 1 to start sending, 0 to stop sending. 
   */
  private final int startStop;

  private RequestDataStream(int reqMessageRate, int targetSystem, int targetComponent,
      int reqStreamId, int startStop) {
    this.reqMessageRate = reqMessageRate;
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.reqStreamId = reqStreamId;
    this.startStop = startStop;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "RequestDataStream{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", reqStreamId=" + reqStreamId
         + ", reqMessageRate=" + reqMessageRate
         + ", startStop=" + startStop + "}";
  }

  /**
   * The requested message rate 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 2
  )
  public final int reqMessageRate() {
    return reqMessageRate;
  }

  /**
   * The target requested to send the message stream. 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * The target requested to send the message stream. 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 1
  )
  public final int targetComponent() {
    return targetComponent;
  }

  /**
   * The ID of the requested data stream 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 1
  )
  public final int reqStreamId() {
    return reqStreamId;
  }

  /**
   * 1 to start sending, 0 to stop sending. 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 1
  )
  public final int startStop() {
    return startStop;
  }

  public static class Builder {
    private int reqMessageRate;

    private int targetSystem;

    private int targetComponent;

    private int reqStreamId;

    private int startStop;

    private Builder() {
    }

    /**
     * The requested message rate 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 2
    )
    public final Builder reqMessageRate(int reqMessageRate) {
      this.reqMessageRate = reqMessageRate;
      return this;
    }

    /**
     * The target requested to send the message stream. 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 1
    )
    public final Builder targetSystem(int targetSystem) {
      this.targetSystem = targetSystem;
      return this;
    }

    /**
     * The target requested to send the message stream. 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 1
    )
    public final Builder targetComponent(int targetComponent) {
      this.targetComponent = targetComponent;
      return this;
    }

    /**
     * The ID of the requested data stream 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 1
    )
    public final Builder reqStreamId(int reqStreamId) {
      this.reqStreamId = reqStreamId;
      return this;
    }

    /**
     * 1 to start sending, 0 to stop sending. 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 1
    )
    public final Builder startStop(int startStop) {
      this.startStop = startStop;
      return this;
    }

    public final RequestDataStream build() {
      return new RequestDataStream(reqMessageRate, targetSystem, targetComponent, reqStreamId, startStop);
    }
  }
}
