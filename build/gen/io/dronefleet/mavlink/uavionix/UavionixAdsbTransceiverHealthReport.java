package io.dronefleet.mavlink.uavionix;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import io.dronefleet.mavlink.util.EnumFlagSet;

/**
 * Transceiver heartbeat with health report (updated every 10s) 
 */
@MavlinkMessage(
    id = 10003,
    crc = 4
)
public final class UavionixAdsbTransceiverHealthReport {
  private final EnumFlagSet<UavionixAdsbRfHealth> rfhealth;

  private UavionixAdsbTransceiverHealthReport(EnumFlagSet<UavionixAdsbRfHealth> rfhealth) {
    this.rfhealth = rfhealth;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * ADS-B transponder messages 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final EnumFlagSet<UavionixAdsbRfHealth> rfhealth() {
    return rfhealth;
  }

  public class Builder {
    private EnumFlagSet<UavionixAdsbRfHealth> rfhealth;

    private Builder() {
    }

    /**
     * ADS-B transponder messages 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder rfhealth(EnumFlagSet<UavionixAdsbRfHealth> rfhealth) {
      this.rfhealth = rfhealth;
      return this;
    }

    public final UavionixAdsbTransceiverHealthReport build() {
      return new UavionixAdsbTransceiverHealthReport(rfhealth);
    }
  }
}
