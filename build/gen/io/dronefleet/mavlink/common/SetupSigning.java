package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkMessage;
import io.dronefleet.mavlink.annotations.MavlinkMessageField;
import java.lang.Integer;
import java.math.BigInteger;
import java.util.List;

/**
 * Setup a MAVLink2 signing key. If called with secret_key of all zero and zero initial_timestamp 
 * will disable signing 
 */
@MavlinkMessage(
    id = 256,
    crc = 71
)
public final class SetupSigning {
  private final int targetSystem;

  private final int targetComponent;

  private final List<Integer> secretKey;

  private final BigInteger initialTimestamp;

  private SetupSigning(int targetSystem, int targetComponent, List<Integer> secretKey,
      BigInteger initialTimestamp) {
    this.targetSystem = targetSystem;
    this.targetComponent = targetComponent;
    this.secretKey = secretKey;
    this.initialTimestamp = initialTimestamp;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * system id of the target 
   */
  @MavlinkMessageField(
      position = 1,
      length = 1
  )
  public final int targetSystem() {
    return targetSystem;
  }

  /**
   * component ID of the target 
   */
  @MavlinkMessageField(
      position = 2,
      length = 1
  )
  public final int targetComponent() {
    return targetComponent;
  }

  /**
   * signing key 
   */
  @MavlinkMessageField(
      position = 3,
      length = 1,
      arraySize = 32
  )
  public final List<Integer> secretKey() {
    return secretKey;
  }

  /**
   * initial timestamp 
   */
  @MavlinkMessageField(
      position = 4,
      length = 8
  )
  public final BigInteger initialTimestamp() {
    return initialTimestamp;
  }

  public class Builder {
    private int targetSystem;

    private int targetComponent;

    private List<Integer> secretKey;

    private BigInteger initialTimestamp;

    private Builder() {
    }

    /**
     * system id of the target 
     */
    @MavlinkMessageField(
        position = 1,
        length = 1
    )
    public final Builder targetSystem(int targetSystem) {
      this.targetSystem = targetSystem;
      return this;
    }

    /**
     * component ID of the target 
     */
    @MavlinkMessageField(
        position = 2,
        length = 1
    )
    public final Builder targetComponent(int targetComponent) {
      this.targetComponent = targetComponent;
      return this;
    }

    /**
     * signing key 
     */
    @MavlinkMessageField(
        position = 3,
        length = 1,
        arraySize = 32
    )
    public final Builder secretKey(List<Integer> secretKey) {
      this.secretKey = secretKey;
      return this;
    }

    /**
     * initial timestamp 
     */
    @MavlinkMessageField(
        position = 4,
        length = 8
    )
    public final Builder initialTimestamp(BigInteger initialTimestamp) {
      this.initialTimestamp = initialTimestamp;
      return this;
    }

    public final SetupSigning build() {
      return new SetupSigning(targetSystem, targetComponent, secretKey, initialTimestamp);
    }
  }
}
