package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Extended state information for ASLUAVs 
 */
@MavlinkMessage(
    id = 205,
    crc = 97
)
public final class AsluavStatus {
  /**
   * Motor RPM 
   */
  private final float motorRpm;

  /**
   * Status of the position-indicator LEDs 
   */
  private final int ledStatus;

  /**
   * Status of the IRIDIUM satellite communication system 
   */
  private final int satcomStatus;

  /**
   * Status vector for up to 8 servos 
   */
  private final List<Integer> servoStatus;

  private AsluavStatus(float motorRpm, int ledStatus, int satcomStatus, List<Integer> servoStatus) {
    this.motorRpm = motorRpm;
    this.ledStatus = ledStatus;
    this.satcomStatus = satcomStatus;
    this.servoStatus = servoStatus;
  }

  @MavlinkMessageBuilder
  public static Builder builder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return "AsluavStatus{ledStatus=" + ledStatus
         + ", satcomStatus=" + satcomStatus
         + ", servoStatus=" + servoStatus
         + ", motorRpm=" + motorRpm + "}";
  }

  /**
   * Motor RPM 
   */
  @MavlinkMessageField(
      position = 4,
      unitSize = 4
  )
  public final float motorRpm() {
    return motorRpm;
  }

  /**
   * Status of the position-indicator LEDs 
   */
  @MavlinkMessageField(
      position = 1,
      unitSize = 1
  )
  public final int ledStatus() {
    return ledStatus;
  }

  /**
   * Status of the IRIDIUM satellite communication system 
   */
  @MavlinkMessageField(
      position = 2,
      unitSize = 1
  )
  public final int satcomStatus() {
    return satcomStatus;
  }

  /**
   * Status vector for up to 8 servos 
   */
  @MavlinkMessageField(
      position = 3,
      unitSize = 1,
      arraySize = 8
  )
  public final List<Integer> servoStatus() {
    return servoStatus;
  }

  public static class Builder {
    private float motorRpm;

    private int ledStatus;

    private int satcomStatus;

    private List<Integer> servoStatus;

    private Builder() {
    }

    /**
     * Motor RPM 
     */
    @MavlinkMessageField(
        position = 4,
        unitSize = 4
    )
    public final Builder motorRpm(float motorRpm) {
      this.motorRpm = motorRpm;
      return this;
    }

    /**
     * Status of the position-indicator LEDs 
     */
    @MavlinkMessageField(
        position = 1,
        unitSize = 1
    )
    public final Builder ledStatus(int ledStatus) {
      this.ledStatus = ledStatus;
      return this;
    }

    /**
     * Status of the IRIDIUM satellite communication system 
     */
    @MavlinkMessageField(
        position = 2,
        unitSize = 1
    )
    public final Builder satcomStatus(int satcomStatus) {
      this.satcomStatus = satcomStatus;
      return this;
    }

    /**
     * Status vector for up to 8 servos 
     */
    @MavlinkMessageField(
        position = 3,
        unitSize = 1,
        arraySize = 8
    )
    public final Builder servoStatus(List<Integer> servoStatus) {
      this.servoStatus = servoStatus;
      return this;
    }

    public final AsluavStatus build() {
      return new AsluavStatus(motorRpm, ledStatus, satcomStatus, servoStatus);
    }
  }
}
