package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F16 format 
 */
@MavlinkMessageInfo(
        id = 180,
        crc = 222
)
public final class SerialUdbExtraF16 {
    /**
     * Serial UDB Extra Name of Expected Lead Pilot 
     */
    private final byte[] sueIdLeadPilot;

    /**
     * Serial UDB Extra URL of Lead Pilot or Team 
     */
    private final byte[] sueIdDiyDronesUrl;

    private SerialUdbExtraF16(byte[] sueIdLeadPilot, byte[] sueIdDiyDronesUrl) {
        this.sueIdLeadPilot = sueIdLeadPilot;
        this.sueIdDiyDronesUrl = sueIdDiyDronesUrl;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "SerialUdbExtraF16{sueIdLeadPilot=" + sueIdLeadPilot
                 + ", sueIdDiyDronesUrl=" + sueIdDiyDronesUrl + "}";
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
        return sueIdLeadPilot;
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
        return sueIdDiyDronesUrl;
    }

    public static class Builder {
        private byte[] sueIdLeadPilot;

        private byte[] sueIdDiyDronesUrl;

        private Builder() {
        }

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
