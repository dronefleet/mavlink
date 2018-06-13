package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.util.List;

/**
 * WIP: Version and capability of protocol version. This message is the response to 
 * REQUEST_PROTOCOL_VERSION and is used as part of the handshaking to establish which MAVLink 
 * version should be used on the network. Every node should respond to REQUEST_PROTOCOL_VERSION 
 * to enable the handshaking. Library implementers should consider adding this into the default 
 * decoding state machine to allow the protocol core to respond directly. 
 */
@MavlinkMessage(
    id = 300,
    crc = 217
)
public final class ProtocolVersion {
  private final int version;

  private final int minVersion;

  private final int maxVersion;

  private final List<Integer> specVersionHash;

  private final List<Integer> libraryVersionHash;

  private ProtocolVersion(int version, int minVersion, int maxVersion,
      List<Integer> specVersionHash, List<Integer> libraryVersionHash) {
    this.version = version;
    this.minVersion = minVersion;
    this.maxVersion = maxVersion;
    this.specVersionHash = specVersionHash;
    this.libraryVersionHash = libraryVersionHash;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Currently active MAVLink version number * 100: v1.0 is 100, v2.0 is 200, etc. 
   */
  @MavlinkMessageField(
      position = 1,
      length = 2
  )
  public final int version() {
    return version;
  }

  /**
   * Minimum MAVLink version supported 
   */
  @MavlinkMessageField(
      position = 2,
      length = 2
  )
  public final int minVersion() {
    return minVersion;
  }

  /**
   * Maximum MAVLink version supported (set to the same value as version by default) 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int maxVersion() {
    return maxVersion;
  }

  /**
   * The first 8 bytes (not characters printed in hex!) of the git hash. 
   */
  @MavlinkMessageField(
      position = 4,
      length = 1,
      arraySize = 8
  )
  public final List<Integer> specVersionHash() {
    return specVersionHash;
  }

  /**
   * The first 8 bytes (not characters printed in hex!) of the git hash. 
   */
  @MavlinkMessageField(
      position = 5,
      length = 1,
      arraySize = 8
  )
  public final List<Integer> libraryVersionHash() {
    return libraryVersionHash;
  }

  public class Builder {
    private int version;

    private int minVersion;

    private int maxVersion;

    private List<Integer> specVersionHash;

    private List<Integer> libraryVersionHash;

    private Builder() {
    }

    /**
     * Currently active MAVLink version number * 100: v1.0 is 100, v2.0 is 200, etc. 
     */
    @MavlinkMessageField(
        position = 1,
        length = 2
    )
    public final Builder version(int version) {
      this.version = version;
      return this;
    }

    /**
     * Minimum MAVLink version supported 
     */
    @MavlinkMessageField(
        position = 2,
        length = 2
    )
    public final Builder minVersion(int minVersion) {
      this.minVersion = minVersion;
      return this;
    }

    /**
     * Maximum MAVLink version supported (set to the same value as version by default) 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder maxVersion(int maxVersion) {
      this.maxVersion = maxVersion;
      return this;
    }

    /**
     * The first 8 bytes (not characters printed in hex!) of the git hash. 
     */
    @MavlinkMessageField(
        position = 4,
        length = 1,
        arraySize = 8
    )
    public final Builder specVersionHash(List<Integer> specVersionHash) {
      this.specVersionHash = specVersionHash;
      return this;
    }

    /**
     * The first 8 bytes (not characters printed in hex!) of the git hash. 
     */
    @MavlinkMessageField(
        position = 5,
        length = 1,
        arraySize = 8
    )
    public final Builder libraryVersionHash(List<Integer> libraryVersionHash) {
      this.libraryVersionHash = libraryVersionHash;
      return this;
    }

    public final ProtocolVersion build() {
      return new ProtocolVersion(version, minVersion, maxVersion, specVersionHash, libraryVersionHash);
    }
  }
}
