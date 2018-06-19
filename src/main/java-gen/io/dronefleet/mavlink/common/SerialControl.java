package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import io.dronefleet.mavlink.util.EnumFlagSet;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Control a serial port. This can be used for raw access to an onboard serial peripheral such as a 
 * GPS or telemetry radio. It is designed to make it possible to update the devices firmware via 
 * MAVLink messages or change the devices settings. A message with zero bytes can be used to change 
 * just the baudrate. 
 */
@MavlinkMessage(
    id = 126,
    crc = 220
)
public final class SerialControl {
  /**
   * Baudrate of transfer. Zero means no change. 
   */
  private final long baudrate;

  /**
   * Timeout for reply data in milliseconds 
   */
  private final int timeout;

  /**
   * See {@link io.dronefleet.mavlink.common.SerialControlDev SerialControlDev} enum 
   */
  private final SerialControlDev device;

  /**
   * See {@link io.dronefleet.mavlink.common.SerialControlFlag SerialControlFlag} enum 
   */
  private final EnumFlagSet<SerialControlFlag> flags;

  /**
   * how many bytes in this transfer 
   */
  private final int count;

  /**
   * serial data 
   */
  private final List<Integer> data;

  private SerialControl(long baudrate, int timeout, SerialControlDev device,
      EnumFlagSet<SerialControlFlag> flags, int count, List<Integer> data) {
    this.baudrate = baudrate;
    this.timeout = timeout;
    this.device = device;
    this.flags = flags;
    this.count = count;
    this.data = data;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "SerialControl{device=" + device
         + ", flags=" + flags
         + ", timeout=" + timeout
         + ", baudrate=" + baudrate
         + ", count=" + count
         + ", data=" + data + "}";
  }

  /**
   * Baudrate of transfer. Zero means no change. 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 4
  )
  public final long baudrate() {
    return baudrate;
  }

  /**
   * Timeout for reply data in milliseconds 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 2
  )
  public final int timeout() {
    return timeout;
  }

  /**
   * See {@link io.dronefleet.mavlink.common.SerialControlDev SerialControlDev} enum 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 1
  )
  public final SerialControlDev device() {
    return device;
  }

  /**
   * See {@link io.dronefleet.mavlink.common.SerialControlFlag SerialControlFlag} enum 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 1
  )
  public final EnumFlagSet<SerialControlFlag> flags() {
    return flags;
  }

  /**
   * how many bytes in this transfer 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 1
  )
  public final int count() {
    return count;
  }

  /**
   * serial data 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 1,
      arraySize = 70
  )
  public final List<Integer> data() {
    return data;
  }

  public static class Builder {
    private long baudrate;

    private int timeout;

    private SerialControlDev device;

    private EnumFlagSet<SerialControlFlag> flags;

    private int count;

    private List<Integer> data;

    private Builder() {
    }

    /**
     * Baudrate of transfer. Zero means no change. 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 4
    )
    public final Builder baudrate(long baudrate) {
      this.baudrate = baudrate;
      return this;
    }

    /**
     * Timeout for reply data in milliseconds 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 2
    )
    public final Builder timeout(int timeout) {
      this.timeout = timeout;
      return this;
    }

    /**
     * See {@link io.dronefleet.mavlink.common.SerialControlDev SerialControlDev} enum 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 1
    )
    public final Builder device(SerialControlDev device) {
      this.device = device;
      return this;
    }

    /**
     * See {@link io.dronefleet.mavlink.common.SerialControlFlag SerialControlFlag} enum 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 1
    )
    public final Builder flags(EnumFlagSet<SerialControlFlag> flags) {
      this.flags = flags;
      return this;
    }

    /**
     * how many bytes in this transfer 
     */
    @MavlinkMessageField(
        position = 5,
        unitSize = 1
    )
    public final Builder count(int count) {
      this.count = count;
      return this;
    }

    /**
     * serial data 
     */
    @MavlinkMessageField(
        position = 6,
        unitSize = 1,
        arraySize = 70
    )
    public final Builder data(List<Integer> data) {
      this.data = data;
      return this;
    }

    public final SerialControl build() {
      return new SerialControl(baudrate, timeout, device, flags, count, data);
    }
  }
}
