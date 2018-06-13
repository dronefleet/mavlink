package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.util.List;

/**
 * Configure AP SSID and Password. 
 */
@MavlinkMessage(
    id = 299,
    crc = 19
)
public final class WifiConfigAp {
  private final List<Integer> ssid;

  private final List<Integer> password;

  private WifiConfigAp(List<Integer> ssid, List<Integer> password) {
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
  public final List<Integer> ssid() {
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
  public final List<Integer> password() {
    return password;
  }

  public class Builder {
    private List<Integer> ssid;

    private List<Integer> password;

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
    public final Builder ssid(List<Integer> ssid) {
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
    public final Builder password(List<Integer> password) {
      this.password = password;
      return this;
    }

    public final WifiConfigAp build() {
      return new WifiConfigAp(ssid, password);
    }
  }
}
