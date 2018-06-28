package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.String;

/**
 * Request to control this MAV 
 */
@MavlinkMessageInfo(
        id = 5,
        crc = 217
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
            unitSize = 1
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * 0: request control of this MAV, 1: Release control of this MAV 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
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
            unitSize = 1
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
            arraySize = 25
    )
    public final String passkey() {
        return this.passkey;
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
                unitSize = 1
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
                unitSize = 1
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
                unitSize = 1
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
                arraySize = 25
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
