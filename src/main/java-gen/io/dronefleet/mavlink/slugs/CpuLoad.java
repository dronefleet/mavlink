package io.dronefleet.mavlink.slugs;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Override;
import java.lang.String;

/**
 * Sensor and DSC control loads. 
 */
@MavlinkMessage(
    id = 170,
    crc = 75
)
public final class CpuLoad {
  /**
   * Battery Voltage 
   */
  private final int batvolt;

  /**
   * Sensor DSC Load 
   */
  private final int sensload;

  /**
   * Control DSC Load 
   */
  private final int ctrlload;

  private CpuLoad(int batvolt, int sensload, int ctrlload) {
    this.batvolt = batvolt;
    this.sensload = sensload;
    this.ctrlload = ctrlload;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "CpuLoad{sensload=" + sensload
         + ", ctrlload=" + ctrlload
         + ", batvolt=" + batvolt + "}";
  }

  /**
   * Battery Voltage 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 2
  )
  public final int batvolt() {
    return batvolt;
  }

  /**
   * Sensor DSC Load 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 1
  )
  public final int sensload() {
    return sensload;
  }

  /**
   * Control DSC Load 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 1
  )
  public final int ctrlload() {
    return ctrlload;
  }

  public static class Builder {
    private int batvolt;

    private int sensload;

    private int ctrlload;

    private Builder() {
    }

    /**
     * Battery Voltage 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 2
    )
    public final Builder batvolt(int batvolt) {
      this.batvolt = batvolt;
      return this;
    }

    /**
     * Sensor DSC Load 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 1
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
        unitSize = 1
    )
    public final Builder ctrlload(int ctrlload) {
      this.ctrlload = ctrlload;
      return this;
    }

    public final CpuLoad build() {
      return new CpuLoad(batvolt, sensload, ctrlload);
    }
  }
}
