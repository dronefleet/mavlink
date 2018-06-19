package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import io.dronefleet.mavlink.util.EnumFlagSet;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
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
   * UID if provided by hardware (see uid2) 
   */
  private final BigInteger uid;

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
   * ID of the board vendor 
   */
  private final int vendorId;

  /**
   * ID of the product 
   */
  private final int productId;

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
   * UID if provided by hardware (supersedes the uid field. If this is non-zero, use this field, 
   * otherwise use uid) 
   */
  private final List<Integer> uid2;

  private AutopilotVersion(EnumFlagSet<MavProtocolCapability> capabilities, BigInteger uid,
      long flightSwVersion, long middlewareSwVersion, long osSwVersion, long boardVersion,
      int vendorId, int productId, List<Integer> flightCustomVersion,
      List<Integer> middlewareCustomVersion, List<Integer> osCustomVersion, List<Integer> uid2) {
    this.capabilities = capabilities;
    this.uid = uid;
    this.flightSwVersion = flightSwVersion;
    this.middlewareSwVersion = middlewareSwVersion;
    this.osSwVersion = osSwVersion;
    this.boardVersion = boardVersion;
    this.vendorId = vendorId;
    this.productId = productId;
    this.flightCustomVersion = flightCustomVersion;
    this.middlewareCustomVersion = middlewareCustomVersion;
    this.osCustomVersion = osCustomVersion;
    this.uid2 = uid2;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "AutopilotVersion{capabilities=" + capabilities
         + ", flightSwVersion=" + flightSwVersion
         + ", middlewareSwVersion=" + middlewareSwVersion
         + ", osSwVersion=" + osSwVersion
         + ", boardVersion=" + boardVersion
         + ", flightCustomVersion=" + flightCustomVersion
         + ", middlewareCustomVersion=" + middlewareCustomVersion
         + ", osCustomVersion=" + osCustomVersion
         + ", vendorId=" + vendorId
         + ", productId=" + productId
         + ", uid=" + uid
         + ", uid2=" + uid2 + "}";
  }

  /**
   * bitmask of capabilities (see {@link io.dronefleet.mavlink.common.MavProtocolCapability MavProtocolCapability} enum) 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 8
  )
  public final EnumFlagSet<MavProtocolCapability> capabilities() {
    return capabilities;
  }

  /**
   * UID if provided by hardware (see uid2) 
   */
  @MavlinkMessageField(
      position = 11,
      unitSize = 8
  )
  public final BigInteger uid() {
    return uid;
  }

  /**
   * Firmware version number 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 4
  )
  public final long flightSwVersion() {
    return flightSwVersion;
  }

  /**
   * Middleware version number 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 4
  )
  public final long middlewareSwVersion() {
    return middlewareSwVersion;
  }

  /**
   * Operating system version number 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 4
  )
  public final long osSwVersion() {
    return osSwVersion;
  }

  /**
   * HW / board version (last 8 bytes should be silicon ID, if any) 
   */
  @MavlinkMessageField(
      position = 5,
      unitSize = 4
  )
  public final long boardVersion() {
    return boardVersion;
  }

  /**
   * ID of the board vendor 
   */
  @MavlinkMessageField(
      position = 9,
      unitSize = 2
  )
  public final int vendorId() {
    return vendorId;
  }

  /**
   * ID of the product 
   */
  @MavlinkMessageField(
      position = 10,
      unitSize = 2
  )
  public final int productId() {
    return productId;
  }

  /**
   * Custom version field, commonly the first 8 bytes of the git hash. This is not an unique 
   * identifier, but should allow to identify the commit using the main version number even for very 
   * large code bases. 
   */
  @MavlinkMessageField(
      position = 6,
      unitSize = 1,
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
      unitSize = 1,
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
      unitSize = 1,
      arraySize = 8
  )
  public final List<Integer> osCustomVersion() {
    return osCustomVersion;
  }

  /**
   * UID if provided by hardware (supersedes the uid field. If this is non-zero, use this field, 
   * otherwise use uid) 
   */
  @MavlinkMessageField(
      position = 13,
      unitSize = 1,
      arraySize = 18,
      extension = true
  )
  public final List<Integer> uid2() {
    return uid2;
  }

  public static class Builder {
    private EnumFlagSet<MavProtocolCapability> capabilities;

    private BigInteger uid;

    private long flightSwVersion;

    private long middlewareSwVersion;

    private long osSwVersion;

    private long boardVersion;

    private int vendorId;

    private int productId;

    private List<Integer> flightCustomVersion;

    private List<Integer> middlewareCustomVersion;

    private List<Integer> osCustomVersion;

    private List<Integer> uid2;

    private Builder() {
    }

    /**
     * bitmask of capabilities (see {@link io.dronefleet.mavlink.common.MavProtocolCapability MavProtocolCapability} enum) 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 8
    )
    public final Builder capabilities(EnumFlagSet<MavProtocolCapability> capabilities) {
      this.capabilities = capabilities;
      return this;
    }

    /**
     * UID if provided by hardware (see uid2) 
     */
    @MavlinkMessageField(
        position = 11,
        unitSize = 8
    )
    public final Builder uid(BigInteger uid) {
      this.uid = uid;
      return this;
    }

    /**
     * Firmware version number 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 4
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
        unitSize = 4
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
        unitSize = 4
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
        unitSize = 4
    )
    public final Builder boardVersion(long boardVersion) {
      this.boardVersion = boardVersion;
      return this;
    }

    /**
     * ID of the board vendor 
     */
    @MavlinkMessageField(
        position = 9,
        unitSize = 2
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
        unitSize = 2
    )
    public final Builder productId(int productId) {
      this.productId = productId;
      return this;
    }

    /**
     * Custom version field, commonly the first 8 bytes of the git hash. This is not an unique 
     * identifier, but should allow to identify the commit using the main version number even for very 
     * large code bases. 
     */
    @MavlinkMessageField(
        position = 6,
        unitSize = 1,
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
        unitSize = 1,
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
        unitSize = 1,
        arraySize = 8
    )
    public final Builder osCustomVersion(List<Integer> osCustomVersion) {
      this.osCustomVersion = osCustomVersion;
      return this;
    }

    /**
     * UID if provided by hardware (supersedes the uid field. If this is non-zero, use this field, 
     * otherwise use uid) 
     */
    @MavlinkMessageField(
        position = 13,
        unitSize = 1,
        arraySize = 18,
        extension = true
    )
    public final Builder uid2(List<Integer> uid2) {
      this.uid2 = uid2;
      return this;
    }

    public final AutopilotVersion build() {
      return new AutopilotVersion(capabilities, uid, flightSwVersion, middlewareSwVersion, osSwVersion, boardVersion, vendorId, productId, flightCustomVersion, middlewareCustomVersion, osCustomVersion, uid2);
    }
  }
}
