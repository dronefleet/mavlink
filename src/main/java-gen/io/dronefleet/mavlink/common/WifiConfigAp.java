package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.String;

/**
 * Configure AP SSID and Password. 
 */
@MavlinkMessage(
    id = 299,
    crc = 19
)
public final class WifiConfigAp {
  /**
   * Name of Wi-Fi network (SSID). Leave it blank to leave it unchanged. 
   */
  private final String ssid;

  /**
   * Password. Leave it blank for an open AP. 
   */
  private final String password;

  private WifiConfigAp(String ssid, String password) {
    this.ssid = ssid;
    this.password = password;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Name of Wi-Fi network (SSID). Leave it blank to leave it unchanged. 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1,
      arraySize = 32
  )
  public final String ssid() {
    return ssid;
  }

  /**
   * Password. Leave it blank for an open AP. 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1,
      arraySize = 64
  )
  public final String password() {
    return password;
  }

  public static class Builder {
    private String ssid;

    private String password;

    private Builder() {
    }

    /**
     * Name of Wi-Fi network (SSID). Leave it blank to leave it unchanged. 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1,
        arraySize = 32
    )
    public final Builder ssid(String ssid) {
      this.ssid = ssid;
      return this;
    }

    /**
     * Password. Leave it blank for an open AP. 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1,
        arraySize = 64
    )
    public final Builder password(String password) {
      this.password = password;
      return this;
    }

    public final WifiConfigAp build() {
      return new WifiConfigAp(ssid, password);
    }
  }
}
