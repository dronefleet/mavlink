package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.String;

/**
 * Emit an encrypted signature / key identifying this system. PLEASE NOTE: This protocol has been 
 * kept simple, so transmitting the key requires an encrypted channel for true safety. 
 */
@MavlinkMessage(
    id = 7,
    crc = 119
)
public final class AuthKey {
  /**
   * key 
   */
  private final String key;

  private AuthKey(String key) {
    this.key = key;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * key 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1,
      arraySize = 32
  )
  public final String key() {
    return key;
  }

  public static class Builder {
    private String key;

    private Builder() {
    }

    /**
     * key 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1,
        arraySize = 32
    )
    public final Builder key(String key) {
      this.key = key;
      return this;
    }

    public final AuthKey build() {
      return new AuthKey(key);
    }
  }
}
