package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.String;

/**
 * Read registers for a device 
 */
@MavlinkMessage(
    id = 11000,
    crc = 134
)
public final class DeviceOpRead {
  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

  /**
   * request ID - copied to reply 
   */
  private final long requestId;

  /**
   * The bus type 
   */
  private final DeviceOpBustype bustype;

  /**
   * Bus number 
   */
  private final int bus;

  /**
   * Bus address 
   */
  private final int address;

  /**
   * Name of device on bus (for SPI) 
   */
  private final String busname;

  /**
   * First register to read 
   */
  private final int regstart;

  /**
   * count of registers to read 
   */
  private final int count;

  private DeviceOpRead(int targetSystem, int targetComponent, long requestId,
      DeviceOpBustype bustype, int bus, int address, String busname, int regstart, int count) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.requestId = requestId;
    this.bustype = bustype;
    this.bus = bus;
    this.address = address;
    this.busname = busname;
    this.regstart = regstart;
    this.count = count;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * System ID 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * Component ID 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int targetComponent() {
    return targetComponent;
  }

  /**
   * request ID - copied to reply 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final long requestId() {
    return requestId;
  }

  /**
   * The bus type 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1
  )
  public final DeviceOpBustype bustype() {
    return bustype;
  }

  /**
   * Bus number 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1
  )
  public final int bus() {
    return bus;
  }

  /**
   * Bus address 
   */
  @MavlinkMessageField(
      position = 6,
      length = 1
  )
  public final int address() {
    return address;
  }

  /**
   * Name of device on bus (for SPI) 
   */
  @MavlinkMessageField(
      position = 7,
      length = 1,
      arraySize = 40
  )
  public final String busname() {
    return busname;
  }

  /**
   * First register to read 
   */
  @MavlinkMessageField(
      position = 8,
      length = 1
  )
  public final int regstart() {
    return regstart;
  }

  /**
   * count of registers to read 
   */
  @MavlinkMessageField(
      position = 9,
      length = 1
  )
  public final int count() {
    return count;
  }

  public static class Builder {
    private int targetSystem;

    private int targetComponent;

    private long requestId;

    private DeviceOpBustype bustype;

    private int bus;

    private int address;

    private String busname;

    private int regstart;

    private int count;

    private Builder() {
    }

    /**
     * System ID 
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
     * Component ID 
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
     * request ID - copied to reply 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder requestId(long requestId) {
      this.requestId = requestId;
      return this;
    }

    /**
     * The bus type 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1
    )
    public final Builder bustype(DeviceOpBustype bustype) {
      this.bustype = bustype;
      return this;
    }

    /**
     * Bus number 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1
    )
    public final Builder bus(int bus) {
      this.bus = bus;
      return this;
    }

    /**
     * Bus address 
     */
    @MavlinkMessageField(
        position = 6,
        length = 1
    )
    public final Builder address(int address) {
      this.address = address;
      return this;
    }

    /**
     * Name of device on bus (for SPI) 
     */
    @MavlinkMessageField(
        position = 7,
        length = 1,
        arraySize = 40
    )
    public final Builder busname(String busname) {
      this.busname = busname;
      return this;
    }

    /**
     * First register to read 
     */
    @MavlinkMessageField(
        position = 8,
        length = 1
    )
    public final Builder regstart(int regstart) {
      this.regstart = regstart;
      return this;
    }

    /**
     * count of registers to read 
     */
    @MavlinkMessageField(
        position = 9,
        length = 1
    )
    public final Builder count(int count) {
      this.count = count;
      return this;
    }

    public final DeviceOpRead build() {
      return new DeviceOpRead(targetSystem, targetComponent, requestId, bustype, bus, address, busname, regstart, count);
    }
  }
}
