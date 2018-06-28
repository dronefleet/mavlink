package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Extended state information for ASLUAVs 
 */
@MavlinkMessageInfo(
        id = 205,
        crc = 97
)
public final class AsluavStatus {
    private final int ledStatus;

    private final int satcomStatus;

    private final byte[] servoStatus;

    private final float motorRpm;

    private AsluavStatus(int ledStatus, int satcomStatus, byte[] servoStatus, float motorRpm) {
        this.ledStatus = ledStatus;
        this.satcomStatus = satcomStatus;
        this.servoStatus = servoStatus;
        this.motorRpm = motorRpm;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Status of the position-indicator LEDs 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int ledStatus() {
        return this.ledStatus;
    }

    /**
     * Status of the IRIDIUM satellite communication system 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int satcomStatus() {
        return this.satcomStatus;
    }

    /**
     * Status vector for up to 8 servos 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            arraySize = 8
    )
    public final byte[] servoStatus() {
        return this.servoStatus;
    }

    /**
     * Motor RPM 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final float motorRpm() {
        return this.motorRpm;
    }

    public static final class Builder {
        private int ledStatus;

        private int satcomStatus;

        private byte[] servoStatus;

        private float motorRpm;

        /**
         * Status of the position-indicator LEDs 
         */
        @MavlinkFieldInfo(
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
        @MavlinkFieldInfo(
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
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                arraySize = 8
        )
        public final Builder servoStatus(byte[] servoStatus) {
            this.servoStatus = servoStatus;
            return this;
        }

        /**
         * Motor RPM 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
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
