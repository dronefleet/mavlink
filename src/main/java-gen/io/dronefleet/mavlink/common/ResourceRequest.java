package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.util.List;

/**
 * The autopilot is requesting a resource (file, binary, other type of data) 
 */
@MavlinkMessage(
    id = 142,
    crc = 72
)
public final class ResourceRequest {
  /**
   * Request ID. This ID should be re-used when sending back URI contents 
   */
  private final int requestId;

  /**
   * The type of requested URI. 0 = a file via URL. 1 = a UAVCAN binary 
   */
  private final int uriType;

  /**
   * The requested unique resource identifier (URI). It is not necessarily a straight domain name 
   * (depends on the URI type enum) 
   */
  private final List<Integer> uri;

  /**
   * The way the autopilot wants to receive the URI. 0 = MAVLink FTP. 1 = binary stream. 
   */
  private final int transferType;

  /**
   * The storage path the autopilot wants the URI to be stored in. Will only be valid if the 
   * transfer_type has a storage associated (e.g. MAVLink FTP). 
   */
  private final List<Integer> storage;

  private ResourceRequest(int requestId, int uriType, List<Integer> uri, int transferType,
      List<Integer> storage) {
    this.requestId = requestId;
    this.uriType = uriType;
    this.uri = uri;
    this.transferType = transferType;
    this.storage = storage;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Request ID. This ID should be re-used when sending back URI contents 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final int requestId() {
    return requestId;
  }

  /**
   * The type of requested URI. 0 = a file via URL. 1 = a UAVCAN binary 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int uriType() {
    return uriType;
  }

  /**
   * The requested unique resource identifier (URI). It is not necessarily a straight domain name 
   * (depends on the URI type enum) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1,
      arraySize = 120
  )
  public final List<Integer> uri() {
    return uri;
  }

  /**
   * The way the autopilot wants to receive the URI. 0 = MAVLink FTP. 1 = binary stream. 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1
  )
  public final int transferType() {
    return transferType;
  }

  /**
   * The storage path the autopilot wants the URI to be stored in. Will only be valid if the 
   * transfer_type has a storage associated (e.g. MAVLink FTP). 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1,
      arraySize = 120
  )
  public final List<Integer> storage() {
    return storage;
  }

  public static class Builder {
    private int requestId;

    private int uriType;

    private List<Integer> uri;

    private int transferType;

    private List<Integer> storage;

    private Builder() {
    }

    /**
     * Request ID. This ID should be re-used when sending back URI contents 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder requestId(int requestId) {
      this.requestId = requestId;
      return this;
    }

    /**
     * The type of requested URI. 0 = a file via URL. 1 = a UAVCAN binary 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder uriType(int uriType) {
      this.uriType = uriType;
      return this;
    }

    /**
     * The requested unique resource identifier (URI). It is not necessarily a straight domain name 
     * (depends on the URI type enum) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1,
        arraySize = 120
    )
    public final Builder uri(List<Integer> uri) {
      this.uri = uri;
      return this;
    }

    /**
     * The way the autopilot wants to receive the URI. 0 = MAVLink FTP. 1 = binary stream. 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1
    )
    public final Builder transferType(int transferType) {
      this.transferType = transferType;
      return this;
    }

    /**
     * The storage path the autopilot wants the URI to be stored in. Will only be valid if the 
     * transfer_type has a storage associated (e.g. MAVLink FTP). 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1,
        arraySize = 120
    )
    public final Builder storage(List<Integer> storage) {
      this.storage = storage;
      return this;
    }

    public final ResourceRequest build() {
      return new ResourceRequest(requestId, uriType, uri, transferType, storage);
    }
  }
}
