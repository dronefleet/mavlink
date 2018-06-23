package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;
import java.math.BigInteger;

/**
 * Setup a MAVLink2 signing key. If called with secret_key of all zero and zero initial_timestamp 
 * will disable signing 
 */
@MavlinkMessageInfo(
        id = 256,
        crc = 71
)
public final class SetupSigning {
    /**
     * initial timestamp 
     */
    private final BigInteger initialTimestamp;

    /**
     * system id of the target 
     */
    private final int targetSystem;

    /**
     * component ID of the target 
     */
    private final int targetComponent;

    /**
     * signing key 
     */
    private final byte[] secretKey;

    private SetupSigning(BigInteger initialTimestamp, int targetSystem, int targetComponent,
            byte[] secretKey) {
        this.initialTimestamp = initialTimestamp;
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.secretKey = secretKey;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "SetupSigning{targetSystem=" + targetSystem
                 + ", targetComponent=" + targetComponent
                 + ", secretKey=" + secretKey
                 + ", initialTimestamp=" + initialTimestamp + "}";
    }

    /**
     * initial timestamp 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 8
    )
    public final BigInteger initialTimestamp() {
        return initialTimestamp;
    }

    /**
     * system id of the target 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int targetSystem() {
        return targetSystem;
    }

    /**
     * component ID of the target 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int targetComponent() {
        return targetComponent;
    }

    /**
     * signing key 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            arraySize = 32
    )
    public final byte[] secretKey() {
        return secretKey;
    }

    public static class Builder {
        private BigInteger initialTimestamp;

        private int targetSystem;

        private int targetComponent;

        private byte[] secretKey;

        private Builder() {
        }

        /**
         * initial timestamp 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 8
        )
        public final Builder initialTimestamp(BigInteger initialTimestamp) {
            this.initialTimestamp = initialTimestamp;
            return this;
        }

        /**
         * system id of the target 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * component ID of the target 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * signing key 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                arraySize = 32
        )
        public final Builder secretKey(byte[] secretKey) {
            this.secretKey = secretKey;
            return this;
        }

        public final SetupSigning build() {
            return new SetupSigning(initialTimestamp, targetSystem, targetComponent, secretKey);
        }
    }
}
