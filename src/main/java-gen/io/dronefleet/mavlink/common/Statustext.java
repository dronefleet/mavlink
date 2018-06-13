package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.String;

/**
 * Status text message. These messages are printed in yellow in the COMM console of 
 * QGroundControl. WARNING: They consume quite some bandwidth, so use only for important status 
 * and error messages. If implemented wisely, these messages are buffered on the MCU and sent only 
 * at a limited rate (e.g. 10 Hz). 
 */
@MavlinkMessage(
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

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Severity of status. Relies on the definitions within RFC-5424. See enum {@link io.dronefleet.mavlink.common.MavSeverity MavSeverity}. 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final MavSeverity severity() {
    return severity;
  }

  /**
   * Status text message, without null termination character 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1,
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
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder severity(MavSeverity severity) {
      this.severity = severity;
      return this;
    }

    /**
     * Status text message, without null termination character 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1,
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
