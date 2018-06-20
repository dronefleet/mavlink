package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Read registers for a device 
 */
@MavlinkMessageInfo(
    id = 11000,
    crc = 134
)
public final class DeviceOpRead {
  /**
   * request ID - copied to reply 
   */
  private final long requestId;

  /**
   * System ID 
   */
  private final int targetSystem;

  /**
   * Component ID 
   */
  private final int targetComponent;

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

  private DeviceOpRead(long requestId, int targetSystem, int targetComponent,
      DeviceOpBustype bustype, int bus, int address, String busname, int regstart, int count) {
    this.requestId = requestId;
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.bustype = bustype;
    this.bus = bus;
    this.address = address;
    this.busname = busname;
    this.regstart = regstart;
    this.count = count;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "DeviceOpRead{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", requestId=" + requestId
         + ", bustype=" + bustype
         + ", bus=" + bus
         + ", address=" + address
         + ", busname=" + busname
         + ", regstart=" + regstart
         + ", count=" + count + "}";
  }

  /**
   * request ID - copied to reply 
   */
  @MavlinkFieldInfo(
      position = 3,
      unitSize = 4
  )
  public final long requestId() {
    return requestId;
  }

  /**
   * System ID 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * Component ID 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 1
  )
  public final int targetComponent() {
    return targetComponent;
  }

  /**
   * The bus type 
   */
  @MavlinkFieldInfo(
      position = 4,
      unitSize = 1
  )
  public final DeviceOpBustype bustype() {
    return bustype;
  }

  /**
   * Bus number 
   */
  @MavlinkFieldInfo(
      position = 5,
      unitSize = 1
  )
  public final int bus() {
    return bus;
  }

  /**
   * Bus address 
   */
  @MavlinkFieldInfo(
      position = 6,
      unitSize = 1
  )
  public final int address() {
    return address;
  }

  /**
   * Name of device on bus (for SPI) 
   */
  @MavlinkFieldInfo(
      position = 7,
      unitSize = 1,
      arraySize = 40
  )
  public final String busname() {
    return busname;
  }

  /**
   * First register to read 
   */
  @MavlinkFieldInfo(
      position = 8,
      unitSize = 1
  )
  public final int regstart() {
    return regstart;
  }

  /**
   * count of registers to read 
   */
  @MavlinkFieldInfo(
      position = 9,
      unitSize = 1
  )
  public final int count() {
    return count;
  }

  public static class Builder {
    private long requestId;

    private int targetSystem;

    private int targetComponent;

    private DeviceOpBustype bustype;

    private int bus;

    private int address;

    private String busname;

    private int regstart;

    private int count;

    private Builder() {
    }

    /**
     * request ID - copied to reply 
     */
    @MavlinkFieldInfo(
        position = 3,
        unitSize = 4
    )
    public final Builder requestId(long requestId) {
      this.requestId = requestId;
      return this;
    }

    /**
     * System ID 
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
     * Component ID 
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
     * The bus type 
     */
    @MavlinkFieldInfo(
        position = 4,
        unitSize = 1
    )
    public final Builder bustype(DeviceOpBustype bustype) {
      this.bustype = bustype;
      return this;
    }

    /**
     * Bus number 
     */
    @MavlinkFieldInfo(
        position = 5,
        unitSize = 1
    )
    public final Builder bus(int bus) {
      this.bus = bus;
      return this;
    }

    /**
     * Bus address 
     */
    @MavlinkFieldInfo(
        position = 6,
        unitSize = 1
    )
    public final Builder address(int address) {
      this.address = address;
      return this;
    }

    /**
     * Name of device on bus (for SPI) 
     */
    @MavlinkFieldInfo(
        position = 7,
        unitSize = 1,
        arraySize = 40
    )
    public final Builder busname(String busname) {
      this.busname = busname;
      return this;
    }

    /**
     * First register to read 
     */
    @MavlinkFieldInfo(
        position = 8,
        unitSize = 1
    )
    public final Builder regstart(int regstart) {
      this.regstart = regstart;
      return this;
    }

    /**
     * count of registers to read 
     */
    @MavlinkFieldInfo(
        position = 9,
        unitSize = 1
    )
    public final Builder count(int count) {
      this.count = count;
      return this;
    }

    public final DeviceOpRead build() {
      return new DeviceOpRead(requestId, targetSystem, targetComponent, bustype, bus, address, busname, regstart, count);
    }
  }
}
