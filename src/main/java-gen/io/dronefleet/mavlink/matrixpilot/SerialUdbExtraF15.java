package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Backwards compatible version of SERIAL_UDB_EXTRA F15 format 
 */
@MavlinkMessageInfo(
        id = 179,
        crc = 7,
        description = "Backwards compatible version of SERIAL_UDB_EXTRA F15 format"
)
public final class SerialUdbExtraF15 {
    private final byte[] sueIdVehicleModelName;

    private final byte[] sueIdVehicleRegistration;

    private SerialUdbExtraF15(byte[] sueIdVehicleModelName, byte[] sueIdVehicleRegistration) {
        this.sueIdVehicleModelName = sueIdVehicleModelName;
        this.sueIdVehicleRegistration = sueIdVehicleRegistration;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Serial UDB Extra Model Name Of Vehicle 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            arraySize = 40,
            description = "Serial UDB Extra Model Name Of Vehicle"
    )
    public final byte[] sueIdVehicleModelName() {
        return this.sueIdVehicleModelName;
    }

    /**
     * Serial UDB Extra Registraton Number of Vehicle 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            arraySize = 20,
            description = "Serial UDB Extra Registraton Number of Vehicle"
    )
    public final byte[] sueIdVehicleRegistration() {
        return this.sueIdVehicleRegistration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        SerialUdbExtraF15 other = (SerialUdbExtraF15)o;
        if (!Objects.deepEquals(sueIdVehicleModelName, other.sueIdVehicleModelName)) return false;
        if (!Objects.deepEquals(sueIdVehicleRegistration, other.sueIdVehicleRegistration)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(sueIdVehicleModelName);
        result = 31 * result + Objects.hashCode(sueIdVehicleRegistration);
        return result;
    }

    @Override
    public String toString() {
        return "SerialUdbExtraF15{sueIdVehicleModelName=" + sueIdVehicleModelName
                 + ", sueIdVehicleRegistration=" + sueIdVehicleRegistration + "}";
    }

    public static final class Builder {
        private byte[] sueIdVehicleModelName;

        private byte[] sueIdVehicleRegistration;

        /**
         * Serial UDB Extra Model Name Of Vehicle 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                arraySize = 40,
                description = "Serial UDB Extra Model Name Of Vehicle"
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
                arraySize = 20,
                description = "Serial UDB Extra Registraton Number of Vehicle"
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
