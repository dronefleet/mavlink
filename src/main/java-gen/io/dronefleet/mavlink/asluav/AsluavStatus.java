package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
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

  /**
   * Motor RPM 
   */
  private final float motorRpm;

  private AsluavStatus(int ledStatus, int satcomStatus, List<Integer> servoStatus, float motorRpm) {
    this.ledStatus = ledStatus;
    this.satcomStatus = satcomStatus;
    this.servoStatus = servoStatus;
    this.motorRpm = motorRpm;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Status of the position-indicator LEDs 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final int ledStatus() {
    return ledStatus;
  }

  /**
   * Status of the IRIDIUM satellite communication system 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int satcomStatus() {
    return satcomStatus;
  }

  /**
   * Status vector for up to 8 servos 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1,
      arraySize = 8
  )
  public final List<Integer> servoStatus() {
    return servoStatus;
  }

  /**
   * Motor RPM 
   */
  @MavlinkMessageField(
      position = 4,
      length = 4
  )
  public final float motorRpm() {
    return motorRpm;
  }

  public static class Builder {
    private int ledStatus;

    private int satcomStatus;

    private List<Integer> servoStatus;

    private float motorRpm;

    private Builder() {
    }

    /**
     * Status of the position-indicator LEDs 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
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
        length = 1
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
        length = 1,
        arraySize = 8
    )
    public final Builder servoStatus(List<Integer> servoStatus) {
      this.servoStatus = servoStatus;
      return this;
    }

    /**
     * Motor RPM 
     */
    @MavlinkMessageField(
        position = 4,
        length = 4
    )
    public final Builder motorRpm(float motorRpm) {
      this.motorRpm = motorRpm;
      return this;
    }

    public final AsluavStatus build() {
      return new AsluavStatus(ledStatus, satcomStatus, servoStatus, motorRpm);
    }
  }
}
