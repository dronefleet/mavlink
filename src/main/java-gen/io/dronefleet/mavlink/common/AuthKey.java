package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.String;

/**
 * Emit an encrypted signature / key identifying this system. PLEASE NOTE: This protocol has been 
 * kept simple, so transmitting the key requires an encrypted channel for true safety. 
 */
@MavlinkMessageInfo(
        id = 7,
        crc = 119
)
public final class AuthKey {
    private final String key;

    private AuthKey(String key) {
        this.key = key;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * key 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            arraySize = 32
    )
    public final String key() {
        return this.key;
    }

    public static final class Builder {
        private String key;

        /**
         * key 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                arraySize = 32
        )
        public final Builder key(String key) {
            this.key = key;
            return this;
        }

        public final AuthKey build() {
            return new AuthKey(key);
        }
    }
}
