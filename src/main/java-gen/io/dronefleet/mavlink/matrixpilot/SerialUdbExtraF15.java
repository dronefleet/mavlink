package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.util.List;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F15 format 
 */
@MavlinkMessage(
    id = 179,
    crc = 7
)
public final class SerialUdbExtraF15 {
  /**
   * Serial UDB Extra Model Name Of Vehicle 
   */
  private final List<Integer> sueIdVehicleModelName;

  /**
   * Serial UDB Extra Registraton Number of Vehicle 
   */
  private final List<Integer> sueIdVehicleRegistration;

  private SerialUdbExtraF15(List<Integer> sueIdVehicleModelName,
      List<Integer> sueIdVehicleRegistration) {
    this.sueIdVehicleModelName = sueIdVehicleModelName;
    this.sueIdVehicleRegistration = sueIdVehicleRegistration;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Serial UDB Extra Model Name Of Vehicle 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1,
      arraySize = 40
  )
  public final List<Integer> sueIdVehicleModelName() {
    return sueIdVehicleModelName;
  }

  /**
   * Serial UDB Extra Registraton Number of Vehicle 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1,
      arraySize = 20
  )
  public final List<Integer> sueIdVehicleRegistration() {
    return sueIdVehicleRegistration;
  }

  public static class Builder {
    private List<Integer> sueIdVehicleModelName;

    private List<Integer> sueIdVehicleRegistration;

    private Builder() {
    }

    /**
     * Serial UDB Extra Model Name Of Vehicle 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1,
        arraySize = 40
    )
    public final Builder sueIdVehicleModelName(List<Integer> sueIdVehicleModelName) {
      this.sueIdVehicleModelName = sueIdVehicleModelName;
      return this;
    }

    /**
     * Serial UDB Extra Registraton Number of Vehicle 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1,
        arraySize = 20
    )
    public final Builder sueIdVehicleRegistration(List<Integer> sueIdVehicleRegistration) {
      this.sueIdVehicleRegistration = sueIdVehicleRegistration;
      return this;
    }

    public final SerialUdbExtraF15 build() {
      return new SerialUdbExtraF15(sueIdVehicleModelName, sueIdVehicleRegistration);
    }
  }
}
