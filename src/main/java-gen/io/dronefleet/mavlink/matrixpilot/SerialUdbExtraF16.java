package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F16 format 
 */
@MavlinkMessageInfo(
        id = 180,
        crc = 222
)
public final class SerialUdbExtraF16 {
    private final byte[] sueIdLeadPilot;

    private final byte[] sueIdDiyDronesUrl;

    private SerialUdbExtraF16(byte[] sueIdLeadPilot, byte[] sueIdDiyDronesUrl) {
        this.sueIdLeadPilot = sueIdLeadPilot;
        this.sueIdDiyDronesUrl = sueIdDiyDronesUrl;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Serial UDB Extra Name of Expected Lead Pilot 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            arraySize = 40
    )
    public final byte[] sueIdLeadPilot() {
        return this.sueIdLeadPilot;
    }

    /**
     * Serial UDB Extra URL of Lead Pilot or Team 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            arraySize = 70
    )
    public final byte[] sueIdDiyDronesUrl() {
        return this.sueIdDiyDronesUrl;
    }

    public static final class Builder {
        private byte[] sueIdLeadPilot;

        private byte[] sueIdDiyDronesUrl;

        /**
         * Serial UDB Extra Name of Expected Lead Pilot 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                arraySize = 40
        )
        public final Builder sueIdLeadPilot(byte[] sueIdLeadPilot) {
            this.sueIdLeadPilot = sueIdLeadPilot;
            return this;
        }

        /**
         * Serial UDB Extra URL of Lead Pilot or Team 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                arraySize = 70
        )
        public final Builder sueIdDiyDronesUrl(byte[] sueIdDiyDronesUrl) {
            this.sueIdDiyDronesUrl = sueIdDiyDronesUrl;
            return this;
        }

        public final SerialUdbExtraF16 build() {
            return new SerialUdbExtraF16(sueIdLeadPilot, sueIdDiyDronesUrl);
        }
    }
}
