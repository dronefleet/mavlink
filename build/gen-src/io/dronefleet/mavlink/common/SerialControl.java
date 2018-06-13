package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import io.dronefleet.mavlink.util.EnumFlagSet;
import java.lang.Integer;
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
  private final SerialControlDev device;

  private final EnumFlagSet<SerialControlFlag> flags;

  private final int timeout;

  private final long baudrate;

  private final int count;

  private final List<Integer> data;

  private SerialControl(SerialControlDev device, EnumFlagSet<SerialControlFlag> flags, int timeout,
      long baudrate, int count, List<Integer> data) {
    this.device = device;
    this.flags = flags;
    this.timeout = timeout;
    this.baudrate = baudrate;
    this.count = count;
    this.data = data;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * See SERIAL_CONTROL_DEV enum 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final SerialControlDev device() {
    return device;
  }

  /**
   * See SERIAL_CONTROL_FLAG enum 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final EnumFlagSet<SerialControlFlag> flags() {
    return flags;
  }

  /**
   * Timeout for reply data in milliseconds 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int timeout() {
    return timeout;
  }

  /**
   * Baudrate of transfer. Zero means no change. 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final long baudrate() {
    return baudrate;
  }

  /**
   * how many bytes in this transfer 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1
  )
  public final int count() {
    return count;
  }

  /**
   * serial data 
   */
  @MavlinkMessageField(
      position = 6,
      length = 1,
      arraySize = 70
  )
  public final List<Integer> data() {
    return data;
  }

  public class Builder {
    private SerialControlDev device;

    private EnumFlagSet<SerialControlFlag> flags;

    private int timeout;

    private long baudrate;

    private int count;

    private List<Integer> data;

    private Builder() {
    }

    /**
     * See SERIAL_CONTROL_DEV enum 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder device(SerialControlDev device) {
      this.device = device;
      return this;
    }

    /**
     * See SERIAL_CONTROL_FLAG enum 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder flags(EnumFlagSet<SerialControlFlag> flags) {
      this.flags = flags;
      return this;
    }

    /**
     * Timeout for reply data in milliseconds 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder timeout(int timeout) {
      this.timeout = timeout;
      return this;
    }

    /**
     * Baudrate of transfer. Zero means no change. 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder baudrate(long baudrate) {
      this.baudrate = baudrate;
      return this;
    }

    /**
     * how many bytes in this transfer 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1
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
        length = 1,
        arraySize = 70
    )
    public final Builder data(List<Integer> data) {
      this.data = data;
      return this;
    }

    public final SerialControl build() {
      return new SerialControl(device, flags, timeout, baudrate, count, data);
    }
  }
}
