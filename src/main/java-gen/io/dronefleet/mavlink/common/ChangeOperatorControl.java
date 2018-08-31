package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

/**
 * Request to control this MAV 
 */
@MavlinkMessageInfo(
        id = 5,
        crc = 217,
        description = "Request to control this MAV"
)
public final class ChangeOperatorControl {
    private final int targetSystem;

    private final int controlRequest;

    private final int version;

    private final String passkey;

    private ChangeOperatorControl(int targetSystem, int controlRequest, int version,
            String passkey) {
        this.targetSystem = targetSystem;
        this.controlRequest = controlRequest;
        this.version = version;
        this.passkey = passkey;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * System the GCS requests control for 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            description = "System the GCS requests control for"
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * 0: request control of this MAV, 1: Release control of this MAV 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1,
            description = "0: request control of this MAV, 1: Release control of this MAV"
    )
    public final int controlRequest() {
        return this.controlRequest;
    }

    /**
     * 0: key as plaintext, 1-255: future, different hashing/encryption variants. The GCS should in 
     * general use the safest mode possible initially and then gradually move down the encryption 
     * level if it gets a NACK message indicating an encryption mismatch. 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            description = "0: key as plaintext, 1-255: future, different hashing/encryption variants. The GCS should in general use the safest mode possible initially and then gradually move down the encryption level if it gets a NACK message indicating an encryption mismatch."
    )
    public final int version() {
        return this.version;
    }

    /**
     * Password / Key, depending on version plaintext or encrypted. 25 or less characters, NULL 
     * terminated. The characters may involve A-Z, a-z, 0-9, and "!?,.-" 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            arraySize = 25,
            description = "Password / Key, depending on version plaintext or encrypted. 25 or less characters, NULL terminated. The characters may involve A-Z, a-z, 0-9, and \"!?,.-\""
    )
    public final String passkey() {
        return this.passkey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ChangeOperatorControl other = (ChangeOperatorControl)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(controlRequest, other.controlRequest)) return false;
        if (!Objects.deepEquals(version, other.version)) return false;
        if (!Objects.deepEquals(passkey, other.passkey)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(controlRequest);
        result = 31 * result + Objects.hashCode(version);
        result = 31 * result + Objects.hashCode(passkey);
        return result;
    }

    @Override
    public String toString() {
        return "ChangeOperatorControl{targetSystem=" + targetSystem
                 + ", controlRequest=" + controlRequest
                 + ", version=" + version
                 + ", passkey=" + passkey + "}";
    }

    public static final class Builder {
        private int targetSystem;

        private int controlRequest;

        private int version;

        private String passkey;

        /**
         * System the GCS requests control for 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                description = "System the GCS requests control for"
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * 0: request control of this MAV, 1: Release control of this MAV 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1,
                description = "0: request control of this MAV, 1: Release control of this MAV"
        )
        public final Builder controlRequest(int controlRequest) {
            this.controlRequest = controlRequest;
            return this;
        }

        /**
         * 0: key as plaintext, 1-255: future, different hashing/encryption variants. The GCS should in 
         * general use the safest mode possible initially and then gradually move down the encryption 
         * level if it gets a NACK message indicating an encryption mismatch. 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                description = "0: key as plaintext, 1-255: future, different hashing/encryption variants. The GCS should in general use the safest mode possible initially and then gradually move down the encryption level if it gets a NACK message indicating an encryption mismatch."
        )
        public final Builder version(int version) {
            this.version = version;
            return this;
        }

        /**
         * Password / Key, depending on version plaintext or encrypted. 25 or less characters, NULL 
         * terminated. The characters may involve A-Z, a-z, 0-9, and "!?,.-" 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                arraySize = 25,
                description = "Password / Key, depending on version plaintext or encrypted. 25 or less characters, NULL terminated. The characters may involve A-Z, a-z, 0-9, and \"!?,.-\""
        )
        public final Builder passkey(String passkey) {
            this.passkey = passkey;
            return this;
        }

        public final ChangeOperatorControl build() {
            return new ChangeOperatorControl(targetSystem, controlRequest, version, passkey);
        }
    }
}
