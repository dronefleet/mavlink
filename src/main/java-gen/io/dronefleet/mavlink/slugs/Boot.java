package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * The boot message indicates that a system is starting. The onboard software version allows to 
 * keep track of onboard soft/firmware revisions. This message allows the sensor and control 
 * MCUs to communicate version numbers on startup. 
 */
@MavlinkMessageInfo(
    id = 197,
    crc = 39
)
public final class Boot {
  /**
   * The onboard software version 
   */
  private final long version;

  private Boot(long version) {
    this.version = version;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "Boot{version=" + version + "}";
  }

  /**
   * The onboard software version 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 4
  )
  public final long version() {
    return version;
  }

  public static class Builder {
    private long version;

    private Builder() {
    }

    /**
     * The onboard software version 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 4
    )
    public final Builder version(long version) {
      this.version = version;
      return this;
    }

    public final Boot build() {
      return new Boot(version);
    }
  }
}
