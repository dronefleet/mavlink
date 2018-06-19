package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Write registers for a device 
 */
@MavlinkMessage(
    id = 11002,
    crc = 234
)
public final class DeviceOpWrite {
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
   * First register to write 
   */
  private final int regstart;

  /**
   * count of registers to write 
   */
  private final int count;

  /**
   * write data 
   */
  private final List<Integer> data;

  private DeviceOpWrite(long requestId, int targetSystem, int targetComponent,
      DeviceOpBustype bustype, int bus, int address, String busname, int regstart, int count,
      List<Integer> data) {
    this.requestId = requestId;
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.bustype = bustype;
    this.bus = bus;
    this.address = address;
    this.busname = busname;
    this.regstart = regstart;
    this.count = count;
    this.data = data;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "DeviceOpWrite{targetSystem=" + targetSystem
         + ", targetComponent=" + targetComponent
         + ", requestId=" + requestId
         + ", bustype=" + bustype
         + ", bus=" + bus
         + ", address=" + address
         + ", busname=" + busname
         + ", regstart=" + regstart
         + ", count=" + count
         + ", data=" + data + "}";
  }

  /**
   * request ID - copied to reply 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 4
  )
  public final long requestId() {
    return requestId;
  }

  /**
   * System ID 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * Component ID 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 1
  )
  public final int targetComponent() {
    return targetComponent;
  }

  /**
   * The bus type 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 1
  )
  public final DeviceOpBustype bustype() {
    return bustype;
  }

  /**
   * Bus number 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 1
  )
  public final int bus() {
    return bus;
  }

  /**
   * Bus address 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 1
  )
  public final int address() {
    return address;
  }

  /**
   * Name of device on bus (for SPI) 
   */
  @MavlinkMessageField(
      position = 7,
      unitSize = 1,
      arraySize = 40
  )
  public final String busname() {
    return busname;
  }

  /**
   * First register to write 
   */
  @MavlinkMessageField(
      position = 8,
      unitSize = 1
  )
  public final int regstart() {
    return regstart;
  }

  /**
   * count of registers to write 
   */
  @MavlinkMessageField(
      position = 9,
      unitSize = 1
  )
  public final int count() {
    return count;
  }

  /**
   * write data 
   */
  @MavlinkMessageField(
      position = 10,
      unitSize = 1,
      arraySize = 128
  )
  public final List<Integer> data() {
    return data;
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

    private List<Integer> data;

    private Builder() {
    }

    /**
     * request ID - copied to reply 
     */
    @MavlinkMessageField(
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
    @MavlinkMessageField(
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
    @MavlinkMessageField(
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
    @MavlinkMessageField(
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
    @MavlinkMessageField(
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
    @MavlinkMessageField(
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
    @MavlinkMessageField(
        position = 7,
        unitSize = 1,
        arraySize = 40
    )
    public final Builder busname(String busname) {
      this.busname = busname;
      return this;
    }

    /**
     * First register to write 
     */
    @MavlinkMessageField(
        position = 8,
        unitSize = 1
    )
    public final Builder regstart(int regstart) {
      this.regstart = regstart;
      return this;
    }

    /**
     * count of registers to write 
     */
    @MavlinkMessageField(
        position = 9,
        unitSize = 1
    )
    public final Builder count(int count) {
      this.count = count;
      return this;
    }

    /**
     * write data 
     */
    @MavlinkMessageField(
        position = 10,
        unitSize = 1,
        arraySize = 128
    )
    public final Builder data(List<Integer> data) {
      this.data = data;
      return this;
    }

    public final DeviceOpWrite build() {
      return new DeviceOpWrite(requestId, targetSystem, targetComponent, bustype, bus, address, busname, regstart, count, data);
    }
  }
}
