package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * null
 */
@MavlinkMessage(
    id = 130,
    crc = 29
)
public final class DataTransmissionHandshake {
  private final int type;

  private final long size;

  private final int width;

  private final int height;

  private final int packets;

  private final int payload;

  private final int jpgQuality;

  private DataTransmissionHandshake(int type, long size, int width, int height, int packets,
      int payload, int jpgQuality) {
    this.type = type;
    this.size = size;
    this.width = width;
    this.height = height;
    this.packets = packets;
    this.payload = payload;
    this.jpgQuality = jpgQuality;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * type of requested/acknowledged data (as defined in ENUM DATA_TYPES in 
   * mavlink/include/mavlink_types.h) 
   */
  @MavlinkMessageField(
      position = 0,
      length = 1
  )
  public final int type() {
    return type;
  }

  /**
   * total data size in bytes (set on ACK only) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 4
  )
  public final long size() {
    return size;
  }

  /**
   * Width of a matrix or image 
   */
  @MavlinkMessageField(
      position = 2,
      length = 2
  )
  public final int width() {
    return width;
  }

  /**
   * Height of a matrix or image 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int height() {
    return height;
  }

  /**
   * number of packets beeing sent (set on ACK only) 
   */
  @MavlinkMessageField(
      position = 4,
      length = 2
  )
  public final int packets() {
    return packets;
  }

  /**
   * payload size per packet (normally 253 byte, see DATA field size in message ENCAPSULATED_DATA) 
   * (set on ACK only) 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1
  )
  public final int payload() {
    return payload;
  }

  /**
   * JPEG quality out of [1,100] 
   */
  @MavlinkMessageField(
      position = 6,
      length = 1
  )
  public final int jpgQuality() {
    return jpgQuality;
  }

  public class Builder {
    private int type;

    private long size;

    private int width;

    private int height;

    private int packets;

    private int payload;

    private int jpgQuality;

    private Builder() {
    }

    /**
     * type of requested/acknowledged data (as defined in ENUM DATA_TYPES in 
     * mavlink/include/mavlink_types.h) 
     */
    @MavlinkMessageField(
        position = 0,
        length = 1
    )
    public final Builder type(int type) {
      this.type = type;
      return this;
    }

    /**
     * total data size in bytes (set on ACK only) 
     */
    @MavlinkMessageField(
        position = 1,
        length = 4
    )
    public final Builder size(long size) {
      this.size = size;
      return this;
    }

    /**
     * Width of a matrix or image 
     */
    @MavlinkMessageField(
        position = 2,
        length = 2
    )
    public final Builder width(int width) {
      this.width = width;
      return this;
    }

    /**
     * Height of a matrix or image 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder height(int height) {
      this.height = height;
      return this;
    }

    /**
     * number of packets beeing sent (set on ACK only) 
     */
    @MavlinkMessageField(
        position = 4,
        length = 2
    )
    public final Builder packets(int packets) {
      this.packets = packets;
      return this;
    }

    /**
     * payload size per packet (normally 253 byte, see DATA field size in message ENCAPSULATED_DATA) 
     * (set on ACK only) 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1
    )
    public final Builder payload(int payload) {
      this.payload = payload;
      return this;
    }

    /**
     * JPEG quality out of [1,100] 
     */
    @MavlinkMessageField(
        position = 6,
        length = 1
    )
    public final Builder jpgQuality(int jpgQuality) {
      this.jpgQuality = jpgQuality;
      return this;
    }

    public final DataTransmissionHandshake build() {
      return new DataTransmissionHandshake(type, size, width, height, packets, payload, jpgQuality);
    }
  }
}
