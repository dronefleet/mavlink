package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.util.List;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F16 format 
 */
@MavlinkMessage(
    id = 180,
    crc = 222
)
public final class SerialUdbExtraF16 {
  private final List<Integer> sueIdLeadPilot;

  private final List<Integer> sueIdDiyDronesUrl;

  private SerialUdbExtraF16(List<Integer> sueIdLeadPilot, List<Integer> sueIdDiyDronesUrl) {
    this.sueIdLeadPilot = sueIdLeadPilot;
    this.sueIdDiyDronesUrl = sueIdDiyDronesUrl;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Serial UDB Extra Name of Expected Lead Pilot 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1,
      arraySize = 40
  )
  public final List<Integer> sueIdLeadPilot() {
    return sueIdLeadPilot;
  }

  /**
   * Serial UDB Extra URL of Lead Pilot or Team 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1,
      arraySize = 70
  )
  public final List<Integer> sueIdDiyDronesUrl() {
    return sueIdDiyDronesUrl;
  }

  public class Builder {
    private List<Integer> sueIdLeadPilot;

    private List<Integer> sueIdDiyDronesUrl;

    private Builder() {
    }

    /**
     * Serial UDB Extra Name of Expected Lead Pilot 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1,
        arraySize = 40
    )
    public final Builder sueIdLeadPilot(List<Integer> sueIdLeadPilot) {
      this.sueIdLeadPilot = sueIdLeadPilot;
      return this;
    }

    /**
     * Serial UDB Extra URL of Lead Pilot or Team 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1,
        arraySize = 70
    )
    public final Builder sueIdDiyDronesUrl(List<Integer> sueIdDiyDronesUrl) {
      this.sueIdDiyDronesUrl = sueIdDiyDronesUrl;
      return this;
    }

    public final SerialUdbExtraF16 build() {
      return new SerialUdbExtraF16(sueIdLeadPilot, sueIdDiyDronesUrl);
    }
  }
}
