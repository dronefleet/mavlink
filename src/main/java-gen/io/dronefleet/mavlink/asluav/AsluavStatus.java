package io.dronefleet.mavlink.asluav;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Extended state information for ASLUAVs 
 */
@MavlinkMessageInfo(
        id = 8006,
        crc = 97,
        description = "Extended state information for ASLUAVs"
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
            unitSize = 1,
            description = "Status of the position-indicator LEDs"
    )
    public final int ledStatus() {
        return this.ledStatus;
    }

    /**
     * Status of the IRIDIUM satellite communication system 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Status of the IRIDIUM satellite communication system"
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
            arraySize = 8,
            description = "Status vector for up to 8 servos"
    )
    public final byte[] servoStatus() {
        return this.servoStatus;
    }

    /**
     * Motor RPM 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4,
            description = "Motor RPM"
    )
    public final float motorRpm() {
        return this.motorRpm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        AsluavStatus other = (AsluavStatus)o;
        if (!Objects.deepEquals(ledStatus, other.ledStatus)) return false;
        if (!Objects.deepEquals(satcomStatus, other.satcomStatus)) return false;
        if (!Objects.deepEquals(servoStatus, other.servoStatus)) return false;
        if (!Objects.deepEquals(motorRpm, other.motorRpm)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(ledStatus);
        result = 31 * result + Objects.hashCode(satcomStatus);
        result = 31 * result + Objects.hashCode(servoStatus);
        result = 31 * result + Objects.hashCode(motorRpm);
        return result;
    }

    @Override
    public String toString() {
        return "AsluavStatus{ledStatus=" + ledStatus
                 + ", satcomStatus=" + satcomStatus
                 + ", servoStatus=" + servoStatus
                 + ", motorRpm=" + motorRpm + "}";
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
                unitSize = 1,
                description = "Status of the position-indicator LEDs"
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
                unitSize = 1,
                description = "Status of the IRIDIUM satellite communication system"
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
                arraySize = 8,
                description = "Status vector for up to 8 servos"
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
                unitSize = 4,
                description = "Motor RPM"
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
