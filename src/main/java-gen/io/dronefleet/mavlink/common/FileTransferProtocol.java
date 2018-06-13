package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.util.List;

/**
 * File transfer message 
 */
@MavlinkMessage(
    id = 110,
    crc = 84
)
public final class FileTransferProtocol {
  /**
   * Network ID (0 for broadcast) 
   */
  private final int targetNetwork;

  /**
   * System ID (0 for broadcast) 
   */
  private final int targetSystem;

  /**
   * Component ID (0 for broadcast) 
   */
  private final int targetComponent;

  /**
   * Variable length payload. The length is defined by the remaining message length when 
   * subtracting the header and other fields. The entire content of this block is opaque unless you 
   * understand any the encoding message_type. The particular encoding used can be extension 
   * specific and might not always be documented as part of the mavlink specification. 
   */
  private final List<Integer> payload;

  private FileTransferProtocol(int targetNetwork, int targetSystem, int targetComponent,
      List<Integer> payload) {
    this.targetNetwork = targetNetwork;
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.payload = payload;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Network ID (0 for broadcast) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final int targetNetwork() {
    return targetNetwork;
  }

  /**
   * System ID (0 for broadcast) 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * Component ID (0 for broadcast) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final int targetComponent() {
    return targetComponent;
  }

  /**
   * Variable length payload. The length is defined by the remaining message length when 
   * subtracting the header and other fields. The entire content of this block is opaque unless you 
   * understand any the encoding message_type. The particular encoding used can be extension 
   * specific and might not always be documented as part of the mavlink specification. 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1,
      arraySize = 251
  )
  public final List<Integer> payload() {
    return payload;
  }

  public static class Builder {
    private int targetNetwork;

    private int targetSystem;

    private int targetComponent;

    private List<Integer> payload;

    private Builder() {
    }

    /**
     * Network ID (0 for broadcast) 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder targetNetwork(int targetNetwork) {
      this.targetNetwork = targetNetwork;
      return this;
    }

    /**
     * System ID (0 for broadcast) 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder targetSystem(int targetSystem) {
      this.targetSystem = targetSystem;
      return this;
    }

    /**
     * Component ID (0 for broadcast) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder targetComponent(int targetComponent) {
      this.targetComponent = targetComponent;
      return this;
    }

    /**
     * Variable length payload. The length is defined by the remaining message length when 
     * subtracting the header and other fields. The entire content of this block is opaque unless you 
     * understand any the encoding message_type. The particular encoding used can be extension 
     * specific and might not always be documented as part of the mavlink specification. 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1,
        arraySize = 251
    )
    public final Builder payload(List<Integer> payload) {
      this.payload = payload;
      return this;
    }

    public final FileTransferProtocol build() {
      return new FileTransferProtocol(targetNetwork, targetSystem, targetComponent, payload);
    }
  }
}
