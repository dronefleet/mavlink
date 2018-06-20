package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Status text message. These messages are printed in yellow in the COMM console of 
 * QGroundControl. WARNING: They consume quite some bandwidth, so use only for important status 
 * and error messages. If implemented wisely, these messages are buffered on the MCU and sent only 
 * at a limited rate (e.g. 10 Hz). 
 */
@MavlinkMessageInfo(
    id = 253,
    crc = 83
)
public final class Statustext {
  /**
   * Severity of status. Relies on the definitions within RFC-5424. See enum {@link io.dronefleet.mavlink.common.MavSeverity MavSeverity}. 
   */
  private final MavSeverity severity;

  /**
   * Status text message, without null termination character 
   */
  private final String text;

  private Statustext(MavSeverity severity, String text) {
    this.severity = severity;
    this.text = text;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "Statustext{severity=" + severity
         + ", text=" + text + "}";
  }

  /**
   * Severity of status. Relies on the definitions within RFC-5424. See enum {@link io.dronefleet.mavlink.common.MavSeverity MavSeverity}. 
   */
  @MavlinkFieldInfo(
      position = 1,
      unitSize = 1
  )
  public final MavSeverity severity() {
    return severity;
  }

  /**
   * Status text message, without null termination character 
   */
  @MavlinkFieldInfo(
      position = 2,
      unitSize = 1,
      arraySize = 50
  )
  public final String text() {
    return text;
  }

  public static class Builder {
    private MavSeverity severity;

    private String text;

    private Builder() {
    }

    /**
     * Severity of status. Relies on the definitions within RFC-5424. See enum {@link io.dronefleet.mavlink.common.MavSeverity MavSeverity}. 
     */
    @MavlinkFieldInfo(
        position = 1,
        unitSize = 1
    )
    public final Builder severity(MavSeverity severity) {
      this.severity = severity;
      return this;
    }

    /**
     * Status text message, without null termination character 
     */
    @MavlinkFieldInfo(
        position = 2,
        unitSize = 1,
        arraySize = 50
    )
    public final Builder text(String text) {
      this.text = text;
      return this;
    }

    public final Statustext build() {
      return new Statustext(severity, text);
    }
  }
}
