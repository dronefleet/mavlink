package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * THIS INTERFACE IS DEPRECATED. USE SET_MESSAGE_INTERVAL INSTEAD. 
 */
@MavlinkMessage(
    id = 66,
    crc = 148
)
public final class RequestDataStream {
  private final int targetSystem;

  private final int targetComponent;

  private final int reqStreamId;

  private final int reqMessageRate;

  private final int startStop;

  private RequestDataStream(int targetSystem, int targetComponent, int reqStreamId,
      int reqMessageRate, int startStop) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.reqStreamId = reqStreamId;
    this.reqMessageRate = reqMessageRate;
    this.startStop = startStop;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * The target requested to send the message stream. 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * The target requested to send the message stream. 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int targetComponent() {
    return targetComponent;
  }

  /**
   * The ID of the requested data stream 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final int reqStreamId() {
    return reqStreamId;
  }

  /**
   * The requested message rate 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int reqMessageRate() {
    return reqMessageRate;
  }

  /**
   * 1 to start sending, 0 to stop sending. 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1
  )
  public final int startStop() {
    return startStop;
  }

  public class Builder {
    private int targetSystem;

    private int targetComponent;

    private int reqStreamId;

    private int reqMessageRate;

    private int startStop;

    private Builder() {
    }

    /**
     * The target requested to send the message stream. 
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
     * The target requested to send the message stream. 
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
     * The ID of the requested data stream 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder reqStreamId(int reqStreamId) {
      this.reqStreamId = reqStreamId;
      return this;
    }

    /**
     * The requested message rate 
     */
    @MavlinkMessageField(
        position = 4,
        length = 2
    )
    public final Builder reqMessageRate(int reqMessageRate) {
      this.reqMessageRate = reqMessageRate;
      return this;
    }

    /**
     * 1 to start sending, 0 to stop sending. 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1
    )
    public final Builder startStop(int startStop) {
      this.startStop = startStop;
      return this;
    }

    public final RequestDataStream build() {
      return new RequestDataStream(targetSystem, targetComponent, reqStreamId, reqMessageRate, startStop);
    }
  }
}
