package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Override;
import java.lang.String;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F15 format 
 */
@MavlinkMessageInfo(
        id = 179,
        crc = 7
)
public final class SerialUdbExtraF15 {
    /**
     * Serial UDB Extra Model Name Of Vehicle 
     */
    private final byte[] sueIdVehicleModelName;

    /**
     * Serial UDB Extra Registraton Number of Vehicle 
     */
    private final byte[] sueIdVehicleRegistration;

    private SerialUdbExtraF15(byte[] sueIdVehicleModelName, byte[] sueIdVehicleRegistration) {
        this.sueIdVehicleModelName = sueIdVehicleModelName;
        this.sueIdVehicleRegistration = sueIdVehicleRegistration;
    }

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "SerialUdbExtraF15{sueIdVehicleModelName=" + sueIdVehicleModelName
                 + ", sueIdVehicleRegistration=" + sueIdVehicleRegistration + "}";
    }

    /**
     * Serial UDB Extra Model Name Of Vehicle 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            arraySize = 40
    )
    public final byte[] sueIdVehicleModelName() {
        return sueIdVehicleModelName;
    }

    /**
     * Serial UDB Extra Registraton Number of Vehicle 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            arraySize = 20
    )
    public final byte[] sueIdVehicleRegistration() {
        return sueIdVehicleRegistration;
    }

    public static class Builder {
        private byte[] sueIdVehicleModelName;

        private byte[] sueIdVehicleRegistration;

        private Builder() {
        }

        /**
         * Serial UDB Extra Model Name Of Vehicle 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                arraySize = 40
        )
        public final Builder sueIdVehicleModelName(byte[] sueIdVehicleModelName) {
            this.sueIdVehicleModelName = sueIdVehicleModelName;
            return this;
        }

        /**
         * Serial UDB Extra Registraton Number of Vehicle 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                arraySize = 20
        )
        public final Builder sueIdVehicleRegistration(byte[] sueIdVehicleRegistration) {
            this.sueIdVehicleRegistration = sueIdVehicleRegistration;
            return this;
        }

        public final SerialUdbExtraF15 build() {
            return new SerialUdbExtraF15(sueIdVehicleModelName, sueIdVehicleRegistration);
        }
    }
}
