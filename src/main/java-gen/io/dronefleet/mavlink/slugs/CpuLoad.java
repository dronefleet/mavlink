package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;

/**
 * Sensor and DSC control loads. 
 */
@MavlinkMessage(
    id = 170,
    crc = 75
)
public final class CpuLoad {
  /**
   * Sensor DSC Load 
   */
  private final int sensload;

  /**
   * Control DSC Load 
   */
  private final int ctrlload;

  /**
   * Battery Voltage 
   */
  private final int batvolt;

  private CpuLoad(int sensload, int ctrlload, int batvolt) {
    this.sensload = sensload;
    this.ctrlload = ctrlload;
    this.batvolt = batvolt;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Sensor DSC Load 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final int sensload() {
    return sensload;
  }

  /**
   * Control DSC Load 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int ctrlload() {
    return ctrlload;
  }

  /**
   * Battery Voltage 
   */
  @MavlinkMessageField(
      position = 3,
      length = 2
  )
  public final int batvolt() {
    return batvolt;
  }

  public static class Builder {
    private int sensload;

    private int ctrlload;

    private int batvolt;

    private Builder() {
    }

    /**
     * Sensor DSC Load 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder sensload(int sensload) {
      this.sensload = sensload;
      return this;
    }

    /**
     * Control DSC Load 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder ctrlload(int ctrlload) {
      this.ctrlload = ctrlload;
      return this;
    }

    /**
     * Battery Voltage 
     */
    @MavlinkMessageField(
        position = 3,
        length = 2
    )
    public final Builder batvolt(int batvolt) {
      this.batvolt = batvolt;
      return this;
    }

    public final CpuLoad build() {
      return new CpuLoad(sensload, ctrlload, batvolt);
    }
  }
}
