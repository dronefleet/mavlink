package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * Configure cellular modems. This message is re-emitted as an acknowledgement by the modem. The 
 * message may also be explicitly requested using MAV_CMD_REQUEST_MESSAGE. 
 */
@MavlinkMessageInfo(
        id = 336,
        crc = 245,
        description = "Configure cellular modems.\n"
                        + "        This message is re-emitted as an acknowledgement by the modem.\n"
                        + "        The message may also be explicitly requested using MAV_CMD_REQUEST_MESSAGE."
)
public final class CellularConfig {
    private final int enableLte;

    private final int enablePin;

    private final String pin;

    private final String newPin;

    private final String apn;

    private final String puk;

    private final int roaming;

    private final EnumValue<CellularConfigResponse> response;

    private CellularConfig(int enableLte, int enablePin, String pin, String newPin, String apn,
            String puk, int roaming, EnumValue<CellularConfigResponse> response) {
        this.enableLte = enableLte;
        this.enablePin = enablePin;
        this.pin = pin;
        this.newPin = newPin;
        this.apn = apn;
        this.puk = puk;
        this.roaming = roaming;
        this.response = response;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Enable/disable LTE. 0: setting unchanged, 1: disabled, 2: enabled. Current setting when sent 
     * back as a response. 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "Enable/disable LTE. 0: setting unchanged, 1: disabled, 2: enabled. Current setting when sent back as a response."
    )
    public final int enableLte() {
        return this.enableLte;
    }

    /**
     * Enable/disable PIN on the SIM card. 0: setting unchanged, 1: disabled, 2: enabled. Current 
     * setting when sent back as a response. 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "Enable/disable PIN on the SIM card. 0: setting unchanged, 1: disabled, 2: enabled. Current setting when sent back as a response."
    )
    public final int enablePin() {
        return this.enablePin;
    }

    /**
     * PIN sent to the SIM card. Blank when PIN is disabled. Empty when message is sent back as a 
     * response. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            arraySize = 16,
            description = "PIN sent to the SIM card. Blank when PIN is disabled. Empty when message is sent back as a response."
    )
    public final String pin() {
        return this.pin;
    }

    /**
     * New PIN when changing the PIN. Blank to leave it unchanged. Empty when message is sent back as a 
     * response. 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            arraySize = 16,
            description = "New PIN when changing the PIN. Blank to leave it unchanged. Empty when message is sent back as a response."
    )
    public final String newPin() {
        return this.newPin;
    }

    /**
     * Name of the cellular APN. Blank to leave it unchanged. Current APN when sent back as a response. 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1,
            arraySize = 32,
            description = "Name of the cellular APN. Blank to leave it unchanged. Current APN when sent back as a response."
    )
    public final String apn() {
        return this.apn;
    }

    /**
     * Required PUK code in case the user failed to authenticate 3 times with the PIN. Empty when 
     * message is sent back as a response. 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            arraySize = 16,
            description = "Required PUK code in case the user failed to authenticate 3 times with the PIN. Empty when message is sent back as a response."
    )
    public final String puk() {
        return this.puk;
    }

    /**
     * Enable/disable roaming. 0: setting unchanged, 1: disabled, 2: enabled. Current setting when 
     * sent back as a response. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 1,
            description = "Enable/disable roaming. 0: setting unchanged, 1: disabled, 2: enabled. Current setting when sent back as a response."
    )
    public final int roaming() {
        return this.roaming;
    }

    /**
     * Message acceptance response (sent back to GS). 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 1,
            enumType = CellularConfigResponse.class,
            description = "Message acceptance response (sent back to GS)."
    )
    public final EnumValue<CellularConfigResponse> response() {
        return this.response;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        CellularConfig other = (CellularConfig)o;
        if (!Objects.deepEquals(enableLte, other.enableLte)) return false;
        if (!Objects.deepEquals(enablePin, other.enablePin)) return false;
        if (!Objects.deepEquals(pin, other.pin)) return false;
        if (!Objects.deepEquals(newPin, other.newPin)) return false;
        if (!Objects.deepEquals(apn, other.apn)) return false;
        if (!Objects.deepEquals(puk, other.puk)) return false;
        if (!Objects.deepEquals(roaming, other.roaming)) return false;
        if (!Objects.deepEquals(response, other.response)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(enableLte);
        result = 31 * result + Objects.hashCode(enablePin);
        result = 31 * result + Objects.hashCode(pin);
        result = 31 * result + Objects.hashCode(newPin);
        result = 31 * result + Objects.hashCode(apn);
        result = 31 * result + Objects.hashCode(puk);
        result = 31 * result + Objects.hashCode(roaming);
        result = 31 * result + Objects.hashCode(response);
        return result;
    }

    @Override
    public String toString() {
        return "CellularConfig{enableLte=" + enableLte
                 + ", enablePin=" + enablePin
                 + ", pin=" + pin
                 + ", newPin=" + newPin
                 + ", apn=" + apn
                 + ", puk=" + puk
                 + ", roaming=" + roaming
                 + ", response=" + response + "}";
    }

    public static final class Builder {
        private int enableLte;

        private int enablePin;

        private String pin;

        private String newPin;

        private String apn;

        private String puk;

        private int roaming;

        private EnumValue<CellularConfigResponse> response;

        /**
         * Enable/disable LTE. 0: setting unchanged, 1: disabled, 2: enabled. Current setting when sent 
         * back as a response. 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "Enable/disable LTE. 0: setting unchanged, 1: disabled, 2: enabled. Current setting when sent back as a response."
        )
        public final Builder enableLte(int enableLte) {
            this.enableLte = enableLte;
            return this;
        }

        /**
         * Enable/disable PIN on the SIM card. 0: setting unchanged, 1: disabled, 2: enabled. Current 
         * setting when sent back as a response. 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "Enable/disable PIN on the SIM card. 0: setting unchanged, 1: disabled, 2: enabled. Current setting when sent back as a response."
        )
        public final Builder enablePin(int enablePin) {
            this.enablePin = enablePin;
            return this;
        }

        /**
         * PIN sent to the SIM card. Blank when PIN is disabled. Empty when message is sent back as a 
         * response. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                arraySize = 16,
                description = "PIN sent to the SIM card. Blank when PIN is disabled. Empty when message is sent back as a response."
        )
        public final Builder pin(String pin) {
            this.pin = pin;
            return this;
        }

        /**
         * New PIN when changing the PIN. Blank to leave it unchanged. Empty when message is sent back as a 
         * response. 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                arraySize = 16,
                description = "New PIN when changing the PIN. Blank to leave it unchanged. Empty when message is sent back as a response."
        )
        public final Builder newPin(String newPin) {
            this.newPin = newPin;
            return this;
        }

        /**
         * Name of the cellular APN. Blank to leave it unchanged. Current APN when sent back as a response. 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1,
                arraySize = 32,
                description = "Name of the cellular APN. Blank to leave it unchanged. Current APN when sent back as a response."
        )
        public final Builder apn(String apn) {
            this.apn = apn;
            return this;
        }

        /**
         * Required PUK code in case the user failed to authenticate 3 times with the PIN. Empty when 
         * message is sent back as a response. 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                arraySize = 16,
                description = "Required PUK code in case the user failed to authenticate 3 times with the PIN. Empty when message is sent back as a response."
        )
        public final Builder puk(String puk) {
            this.puk = puk;
            return this;
        }

        /**
         * Enable/disable roaming. 0: setting unchanged, 1: disabled, 2: enabled. Current setting when 
         * sent back as a response. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 1,
                description = "Enable/disable roaming. 0: setting unchanged, 1: disabled, 2: enabled. Current setting when sent back as a response."
        )
        public final Builder roaming(int roaming) {
            this.roaming = roaming;
            return this;
        }

        /**
         * Message acceptance response (sent back to GS). 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 1,
                enumType = CellularConfigResponse.class,
                description = "Message acceptance response (sent back to GS)."
        )
        public final Builder response(EnumValue<CellularConfigResponse> response) {
            this.response = response;
            return this;
        }

        /**
         * Message acceptance response (sent back to GS). 
         */
        public final Builder response(CellularConfigResponse entry) {
            return response(EnumValue.of(entry));
        }

        /**
         * Message acceptance response (sent back to GS). 
         */
        public final Builder response(Enum... flags) {
            return response(EnumValue.create(flags));
        }

        /**
         * Message acceptance response (sent back to GS). 
         */
        public final Builder response(Collection<Enum> flags) {
            return response(EnumValue.create(flags));
        }

        public final CellularConfig build() {
            return new CellularConfig(enableLte, enablePin, pin, newPin, apn, puk, roaming, response);
        }
    }
}
