package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.util.List;

/**
 * Send raw controller memory. The use of this message is discouraged for normal packets, but a 
 * quite efficient way for testing new messages and getting experimental debug output. 
 */
@MavlinkMessage(
    id = 249,
    crc = 204
)
public final class MemoryVect {
  /**
   * Starting address of the debug variables 
   */
  private final int address;

  /**
   * Version code of the type variable. 0=unknown, type ignored and assumed int16_t. 1=as below 
   */
  private final int ver;

  /**
   * Type code of the memory variables. for ver = 1: 0=16 x int16_t, 1=16 x uint16_t, 2=16 x Q15, 3=16 x 
   * 1Q14 
   */
  private final int type;

  /**
   * Memory contents at specified address 
   */
  private final List<Integer> value;

  private MemoryVect(int address, int ver, int type, List<Integer> value) {
    this.address = address;
    this.ver = ver;
    this.type = type;
    this.value = value;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Starting address of the debug variables 
   */
  @MavlinkMessageField(
      position = 1,
      length = 2
  )
  public final int address() {
    return address;
  }

  /**
   * Version code of the type variable. 0=unknown, type ignored and assumed int16_t. 1=as below 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int ver() {
    return ver;
  }

  /**
   * Type code of the memory variables. for ver = 1: 0=16 x int16_t, 1=16 x uint16_t, 2=16 x Q15, 3=16 x 
   * 1Q14 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1
  )
  public final int type() {
    return type;
  }

  /**
   * Memory contents at specified address 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1,
      arraySize = 32
  )
  public final List<Integer> value() {
    return value;
  }

  public static class Builder {
    private int address;

    private int ver;

    private int type;

    private List<Integer> value;

    private Builder() {
    }

    /**
     * Starting address of the debug variables 
     */
    @MavlinkMessageField(
        position = 1,
        length = 2
    )
    public final Builder address(int address) {
      this.address = address;
      return this;
    }

    /**
     * Version code of the type variable. 0=unknown, type ignored and assumed int16_t. 1=as below 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder ver(int ver) {
      this.ver = ver;
      return this;
    }

    /**
     * Type code of the memory variables. for ver = 1: 0=16 x int16_t, 1=16 x uint16_t, 2=16 x Q15, 3=16 x 
     * 1Q14 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1
    )
    public final Builder type(int type) {
      this.type = type;
      return this;
    }

    /**
     * Memory contents at specified address 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1,
        arraySize = 32
    )
    public final Builder value(List<Integer> value) {
      this.value = value;
      return this;
    }

    public final MemoryVect build() {
      return new MemoryVect(address, ver, type, value);
    }
  }
}
