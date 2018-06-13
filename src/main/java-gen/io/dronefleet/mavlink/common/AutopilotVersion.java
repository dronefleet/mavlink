package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import io.dronefleet.mavlink.util.EnumFlagSet;
import java.lang.Integer;
import java.math.BigInteger;
import java.util.List;

/**
 * Version and capability of autopilot software 
 */
@MavlinkMessage(
    id = 148,
    crc = 178
)
public final class AutopilotVersion {
  /**
   * bitmask of capabilities (see {@link io.dronefleet.mavlink.common.MavProtocolCapability MavProtocolCapability} enum) 
   */
  private final EnumFlagSet<MavProtocolCapability> capabilities;

  /**
   * Firmware version number 
   */
  private final long flightSwVersion;

  /**
   * Middleware version number 
   */
  private final long middlewareSwVersion;

  /**
   * Operating system version number 
   */
  private final long osSwVersion;

  /**
   * HW / board version (last 8 bytes should be silicon ID, if any) 
   */
  private final long boardVersion;

  /**
   * Custom version field, commonly the first 8 bytes of the git hash. This is not an unique 
   * identifier, but should allow to identify the commit using the main version number even for very 
   * large code bases. 
   */
  private final List<Integer> flightCustomVersion;

  /**
   * Custom version field, commonly the first 8 bytes of the git hash. This is not an unique 
   * identifier, but should allow to identify the commit using the main version number even for very 
   * large code bases. 
   */
  private final List<Integer> middlewareCustomVersion;

  /**
   * Custom version field, commonly the first 8 bytes of the git hash. This is not an unique 
   * identifier, but should allow to identify the commit using the main version number even for very 
   * large code bases. 
   */
  private final List<Integer> osCustomVersion;

  /**
   * ID of the board vendor 
   */
  private final int vendorId;

  /**
   * ID of the product 
   */
  private final int productId;

  /**
   * UID if provided by hardware (see uid2) 
   */
  private final BigInteger uid;

  /**
   * UID if provided by hardware (supersedes the uid field. If this is non-zero, use this field, 
   * otherwise use uid) 
   */
  private final List<Integer> uid2;

  private AutopilotVersion(EnumFlagSet<MavProtocolCapability> capabilities, long flightSwVersion,
      long middlewareSwVersion, long osSwVersion, long boardVersion,
      List<Integer> flightCustomVersion, List<Integer> middlewareCustomVersion,
      List<Integer> osCustomVersion, int vendorId, int productId, BigInteger uid,
      List<Integer> uid2) {
    this.capabilities = capabilities;
    this.flightSwVersion = flightSwVersion;
    this.middlewareSwVersion = middlewareSwVersion;
    this.osSwVersion = osSwVersion;
    this.boardVersion = boardVersion;
    this.flightCustomVersion = flightCustomVersion;
    this.middlewareCustomVersion = middlewareCustomVersion;
    this.osCustomVersion = osCustomVersion;
    this.vendorId = vendorId;
    this.productId = productId;
    this.uid = uid;
    this.uid2 = uid2;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * bitmask of capabilities (see {@link io.dronefleet.mavlink.common.MavProtocolCapability MavProtocolCapability} enum) 
   */
  @MavlinkMessageField(
      position = 1,
      length = 8
  )
  public final EnumFlagSet<MavProtocolCapability> capabilities() {
    return capabilities;
  }

  /**
   * Firmware version number 
   */
  @MavlinkMessageField(
      position = 2,
      length = 4
  )
  public final long flightSwVersion() {
    return flightSwVersion;
  }

  /**
   * Middleware version number 
   */
  @MavlinkMessageField(
      position = 3,
      length = 4
  )
  public final long middlewareSwVersion() {
    return middlewareSwVersion;
  }

  /**
   * Operating system version number 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final long osSwVersion() {
    return osSwVersion;
  }

  /**
   * HW / board version (last 8 bytes should be silicon ID, if any) 
   */
  @MavlinkMessageField(
      position = 5,
      length = 4
  )
  public final long boardVersion() {
    return boardVersion;
  }

  /**
   * Custom version field, commonly the first 8 bytes of the git hash. This is not an unique 
   * identifier, but should allow to identify the commit using the main version number even for very 
   * large code bases. 
   */
  @MavlinkMessageField(
      position = 6,
      length = 1,
      arraySize = 8
  )
  public final List<Integer> flightCustomVersion() {
    return flightCustomVersion;
  }

  /**
   * Custom version field, commonly the first 8 bytes of the git hash. This is not an unique 
   * identifier, but should allow to identify the commit using the main version number even for very 
   * large code bases. 
   */
  @MavlinkMessageField(
      position = 7,
      length = 1,
      arraySize = 8
  )
  public final List<Integer> middlewareCustomVersion() {
    return middlewareCustomVersion;
  }

  /**
   * Custom version field, commonly the first 8 bytes of the git hash. This is not an unique 
   * identifier, but should allow to identify the commit using the main version number even for very 
   * large code bases. 
   */
  @MavlinkMessageField(
      position = 8,
      length = 1,
      arraySize = 8
  )
  public final List<Integer> osCustomVersion() {
    return osCustomVersion;
  }

  /**
   * ID of the board vendor 
   */
  @MavlinkMessageField(
      position = 9,
      length = 2
  )
  public final int vendorId() {
    return vendorId;
  }

  /**
   * ID of the product 
   */
  @MavlinkMessageField(
      position = 10,
      length = 2
  )
  public final int productId() {
    return productId;
  }

  /**
   * UID if provided by hardware (see uid2) 
   */
  @MavlinkMessageField(
      position = 11,
      length = 8
  )
  public final BigInteger uid() {
    return uid;
  }

  /**
   * UID if provided by hardware (supersedes the uid field. If this is non-zero, use this field, 
   * otherwise use uid) 
   */
  @MavlinkMessageField(
      position = 13,
      length = 1,
      arraySize = 18,
      extension = true
  )
  public final List<Integer> uid2() {
    return uid2;
  }

  public static class Builder {
    private EnumFlagSet<MavProtocolCapability> capabilities;

    private long flightSwVersion;

    private long middlewareSwVersion;

    private long osSwVersion;

    private long boardVersion;

    private List<Integer> flightCustomVersion;

    private List<Integer> middlewareCustomVersion;

    private List<Integer> osCustomVersion;

    private int vendorId;

    private int productId;

    private BigInteger uid;

    private List<Integer> uid2;

    private Builder() {
    }

    /**
     * bitmask of capabilities (see {@link io.dronefleet.mavlink.common.MavProtocolCapability MavProtocolCapability} enum) 
     */
    @MavlinkMessageField(
        position = 1,
        length = 8
    )
    public final Builder capabilities(EnumFlagSet<MavProtocolCapability> capabilities) {
      this.capabilities = capabilities;
      return this;
    }

    /**
     * Firmware version number 
     */
    @MavlinkMessageField(
        position = 2,
        length = 4
    )
    public final Builder flightSwVersion(long flightSwVersion) {
      this.flightSwVersion = flightSwVersion;
      return this;
    }

    /**
     * Middleware version number 
     */
    @MavlinkMessageField(
        position = 3,
        length = 4
    )
    public final Builder middlewareSwVersion(long middlewareSwVersion) {
      this.middlewareSwVersion = middlewareSwVersion;
      return this;
    }

    /**
     * Operating system version number 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder osSwVersion(long osSwVersion) {
      this.osSwVersion = osSwVersion;
      return this;
    }

    /**
     * HW / board version (last 8 bytes should be silicon ID, if any) 
     */
    @MavlinkMessageField(
        position = 5,
        length = 4
    )
    public final Builder boardVersion(long boardVersion) {
      this.boardVersion = boardVersion;
      return this;
    }

    /**
     * Custom version field, commonly the first 8 bytes of the git hash. This is not an unique 
     * identifier, but should allow to identify the commit using the main version number even for very 
     * large code bases. 
     */
    @MavlinkMessageField(
        position = 6,
        length = 1,
        arraySize = 8
    )
    public final Builder flightCustomVersion(List<Integer> flightCustomVersion) {
      this.flightCustomVersion = flightCustomVersion;
      return this;
    }

    /**
     * Custom version field, commonly the first 8 bytes of the git hash. This is not an unique 
     * identifier, but should allow to identify the commit using the main version number even for very 
     * large code bases. 
     */
    @MavlinkMessageField(
        position = 7,
        length = 1,
        arraySize = 8
    )
    public final Builder middlewareCustomVersion(List<Integer> middlewareCustomVersion) {
      this.middlewareCustomVersion = middlewareCustomVersion;
      return this;
    }

    /**
     * Custom version field, commonly the first 8 bytes of the git hash. This is not an unique 
     * identifier, but should allow to identify the commit using the main version number even for very 
     * large code bases. 
     */
    @MavlinkMessageField(
        position = 8,
        length = 1,
        arraySize = 8
    )
    public final Builder osCustomVersion(List<Integer> osCustomVersion) {
      this.osCustomVersion = osCustomVersion;
      return this;
    }

    /**
     * ID of the board vendor 
     */
    @MavlinkMessageField(
        position = 9,
        length = 2
    )
    public final Builder vendorId(int vendorId) {
      this.vendorId = vendorId;
      return this;
    }

    /**
     * ID of the product 
     */
    @MavlinkMessageField(
        position = 10,
        length = 2
    )
    public final Builder productId(int productId) {
      this.productId = productId;
      return this;
    }

    /**
     * UID if provided by hardware (see uid2) 
     */
    @MavlinkMessageField(
        position = 11,
        length = 8
    )
    public final Builder uid(BigInteger uid) {
      this.uid = uid;
      return this;
    }

    /**
     * UID if provided by hardware (supersedes the uid field. If this is non-zero, use this field, 
     * otherwise use uid) 
     */
    @MavlinkMessageField(
        position = 13,
        length = 1,
        arraySize = 18,
        extension = true
    )
    public final Builder uid2(List<Integer> uid2) {
      this.uid2 = uid2;
      return this;
    }

    public final AutopilotVersion build() {
      return new AutopilotVersion(capabilities, flightSwVersion, middlewareSwVersion, osSwVersion, boardVersion, flightCustomVersion, middlewareCustomVersion, osCustomVersion, vendorId, productId, uid, uid2);
    }
  }
}
